package com.entersekt.entersekt_app_library.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityData implements Parcelable {
    @SerializedName("cities")
    private List<Cities> cities;

    protected CityData(Parcel in) {
        cities = in.createTypedArrayList(Cities.CREATOR);
    }

    public static final Creator<CityData> CREATOR = new Creator<CityData>() {
        @Override
        public CityData createFromParcel(Parcel in) {
            return new CityData(in);
        }

        @Override
        public CityData[] newArray(int size) {
            return new CityData[size];
        }
    };

    public List<Cities> getCities() {
        return cities;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cities);
    }
}


