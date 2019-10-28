package com.entersekt.entersekt_app_library.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Shops implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    protected Shops(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<Shops> CREATOR = new Creator<Shops>() {
        @Override
        public Shops createFromParcel(Parcel in) {
            return new Shops(in);
        }

        @Override
        public Shops[] newArray(int size) {
            return new Shops[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);

    }
}
