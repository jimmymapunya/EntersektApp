package com.entersekt.entersekt_app_library.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Cities  implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("malls")
    private List<Malls> malls;

    public Cities(String id, String name, List<Malls> malls) {
        super();
        this.id = id;
        this.name = name;
        this.malls = malls;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Malls> getMalls() {
        return malls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeList(this.malls);
    }

    public static final Parcelable.Creator<Cities> CREATOR
            = new Parcelable.Creator<Cities>() {
        public Cities createFromParcel(Parcel in) {
            return new Cities(in);
        }

        @Override
        public Cities[] newArray(int size) {
            return new Cities[0];
        }
    };

    private Cities(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.malls = in.readArrayList(Cities.class.getClassLoader());

    }
}
