package com.entersekt.entersekt_app_library.Controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.entersekt.entersekt_app_library.Interface.INetworkResponseListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NetworkEngine {

    //Api URL
    private static final String WeatherURL = "http://www.mocky.io/v2/5b7e8bc03000005c0084c210";

    public static void EntersektAppAPICall (Context context, final INetworkResponseListener iNetworkResponseListener){


        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, WeatherURL,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        iNetworkResponseListener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iNetworkResponseListener.onError(error);
                    }
                }){

            @Override
            public Map<String, String> getHeaders() {

                HashMap<String,String> headers = new HashMap<>();

                return headers;
            }
        };

        NetworkSingleton.getInstance(context).addRequestQueue(request);
    }
}
