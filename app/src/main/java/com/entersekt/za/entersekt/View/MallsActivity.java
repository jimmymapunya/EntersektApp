package com.entersekt.za.entersekt.View;

import android.content.Context;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.entersekt.entersekt_app_library.Model.Malls;
import com.entersekt.entersekt_app_library.Utils;
import com.entersekt.za.R;
import com.entersekt.za.entersekt.Controller.MallsAdapter;
import java.util.ArrayList;


public class MallsActivity extends AppCompatActivity {

    private Context context;
    private ListView lvMalls;
    private ArrayList<Malls> items;
    private String malls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);
        context = this;

        lvMalls = findViewById(R.id.lvMalls);


        items = getIntent().getParcelableArrayListExtra("malls");
        final ArrayList<Malls> dataModels= new ArrayList<>();

        for (int x=0; x<items.size(); x++)
        {
            malls = items.get(x).getName();
            dataModels.add(new Malls(items.get(x).getId(), malls, items.get(x).getShops()));

        }

        MallsAdapter adapter = new MallsAdapter(context, dataModels);
        lvMalls.setAdapter(adapter);

        lvMalls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Malls mall = items.get(position);
                Utils.alertDialogShow(context, mall.getName(), mall.getShops().get(position).getName());

            }
        });











    }
}