package com.entersekt.entersekt_app_library.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Malls implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("shops")
    private List<Shops> shops;

    public Malls(String id, String name,List<Shops> shops) {
        this.id = id;
        this.name = name;
        this.shops = shops;
    }

    protected Malls(Parcel in) {
        id = in.readString();
        name = in.readString();
        shops = in.readArrayList(Malls.class.getClassLoader());
    }

    public static final Creator<Malls> CREATOR = new Creator<Malls>() {
        @Override
        public Malls createFromParcel(Parcel in) {
            return new Malls(in);
        }

        @Override
        public Malls[] newArray(int size) {
            return new Malls[size];
        }
    };

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Shops> getShops() {
        return shops;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeList(shops);
    }
}
