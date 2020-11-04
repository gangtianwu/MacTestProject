package com.ding.pokedex.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Parce implements Parcelable {
    private String name;
    private int age;

    protected Parce(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<Parce> CREATOR = new Creator<Parce>() {
        @Override
        public Parce createFromParcel(Parcel in) {
            return new Parce(in);
        }

        @Override
        public Parce[] newArray(int size) {
            return new Parce[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
