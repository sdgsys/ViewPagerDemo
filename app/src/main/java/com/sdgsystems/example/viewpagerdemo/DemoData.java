package com.sdgsystems.example.viewpagerdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jay on 8/4/16.
 */
public class DemoData implements Parcelable  {
    public final String name;
    public final String desc;
    public final double weight;

    public DemoData(String name, String desc, double weight) {
        this.name = name;
        this.desc = desc;
        this.weight = weight;
    }

    protected DemoData(Parcel in) {
        name = in.readString();
        desc = in.readString();
        weight = in.readDouble();
    }

    public static final Creator<DemoData> CREATOR = new Creator<DemoData>() {
        @Override
        public DemoData createFromParcel(Parcel in) {
            return new DemoData(in);
        }

        @Override
        public DemoData[] newArray(int size) {
            return new DemoData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeDouble(weight);
    }
}
