package com.example.vsreenathreddy1.login;

public class Event {
    String name;
    String description;
    String location;
    String date_time;
    String availability;
    String id;

    public Event(String name, String description, String location, String date_time, String availability, String id) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date_time = date_time;
        this.availability = availability;
        this.id = id;
    }
}
