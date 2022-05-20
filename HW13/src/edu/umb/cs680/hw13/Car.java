package edu.umb.cs680.hw13;

public class Car {
    private String model, make;
    private int mileage, year;
    private float price;
    private int dominationCount;

    public Car(String model, String make, int mileage, int year, float price){
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDominationCount(int dominationCount){
        this.dominationCount = dominationCount;
    }

    public int getDominationCount(){
        return this.dominationCount;
    }
}
