package com.entersekt.entersekt_app_library.Interface;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface INetworkResponseListener {
    void onResponse(JSONObject response);
    void onError(VolleyError error);
}