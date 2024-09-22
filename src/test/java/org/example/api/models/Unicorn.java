package org.example.api.models;

import com.google.gson.annotations.SerializedName;

public class Unicorn {
    private String name;
    private String color;
    @SerializedName("_id")
    private String id;

    public Unicorn(String name, String color) {
        this.name = name;
        this.color = color;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }
}
