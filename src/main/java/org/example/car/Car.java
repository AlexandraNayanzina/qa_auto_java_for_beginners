package org.example.car;

import org.example.car.Drivable;

public class Car implements Drivable {
    private String brand;
    private String model;
    private int year;

    public Car(){};

    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void start(){
        System.out.println("Start moving");
    }

    public void stop(){
        System.out.println("Stop moving");
    }

    public void drive(int distance){
        System.out.println("Drive " + distance + "km");
    }

    public void printCar(){
        System.out.println("The car is " + this.toString());
    }

    @Override
    public String toString() {
        return "Car {" +
                "brand=" + brand +
                ", model=" + model +
                ", year=" + year +
                '}';
    }


}
