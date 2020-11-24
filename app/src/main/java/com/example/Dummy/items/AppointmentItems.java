package com.example.Dummy.items;

public class AppointmentItems {
    private String Name;
    private String Cost;
    private String Duration;
    private String Time;

    public AppointmentItems(){

    }
    public AppointmentItems(String name, String cost, String duration, String time) {
        Name = name;
        Cost = cost;
        Duration = duration;
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        this.Cost = cost;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        this.Duration = duration;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

}