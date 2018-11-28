package com.example.vsreenathreddy1.login;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

public class Event implements Parcelable {
    String name;
    String description;
    String location;
    String date_time;
    String availability;
    String id;

    public Event() {
    }

    public Event(String name, String description, String location, String date_time, String availability, String id) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date_time = date_time;
        this.availability = availability;
        this.id = id;
    }

    protected Event(Parcel in) {
        name = in.readString();
        description = in.readString();
        location = in.readString();
        date_time = in.readString();
        availability = in.readString();
        id = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(location);
        dest.writeString(date_time);
        dest.writeString(availability);
        dest.writeString(id);
    }
}
