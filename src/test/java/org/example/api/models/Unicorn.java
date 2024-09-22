package org.example.api.models;

public class Unicorn {
    private String name;
    private String color;

    public Unicorn(String name, String color) {
        this.name = name;
        this.color = color;
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

    public String toJson() {
        return "{\n" +
                "  \"name\": \"Unic\",\n" +
                "  \"color\": \"yellow\"\n" +
                "}";
    }
}
