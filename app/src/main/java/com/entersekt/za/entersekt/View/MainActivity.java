package com.entersekt.za.entersekt.View;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.entersekt.entersekt_app_library.Controller.NetworkEngine;
import com.entersekt.entersekt_app_library.Interface.INetworkResponseListener;
import com.entersekt.entersekt_app_library.Model.Cities;
import com.entersekt.entersekt_app_library.Model.CityData;
import com.entersekt.entersekt_app_library.Utils;
import com.entersekt.za.R;
import com.entersekt.za.entersekt.Controller.CitiesAdapter;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ListView lvCities;
    private List<Cities> cities;
    private CityData cityData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        lvCities = findViewById(R.id.lvCities);

        NetworkEngine.EntersektAppAPICall(context, new INetworkResponseListener() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                final ArrayList<Cities> dataModels= new ArrayList<>();

                cityData = gson.fromJson(response.toString(),CityData.class);
                cities = cityData.getCities();

                for (Cities currentCity: cities) {

                    dataModels.add(new Cities(currentCity.getId(), currentCity.getName(),currentCity.getMalls()));
                }
                CitiesAdapter adapter = new CitiesAdapter(context, dataModels);
                lvCities.setAdapter(adapter);
                adapter.notifyDataSetChanged();
       }

            @Override
            public void onError(VolleyError error) {

                String message = null;
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }

                Utils.showToast(context, message);
            }
        });


        lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cities city = cityData.getCities().get(position);

                Intent intent = new Intent(context ,MallsActivity.class);
                intent.putParcelableArrayListExtra("malls", (ArrayList<? extends Parcelable>) city.getMalls());

                context.startActivity(intent);

            }
        });



    }
}
