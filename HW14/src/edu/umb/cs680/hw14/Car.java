package edu.umb.cs680.hw14;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, float price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if (make.equals(car.getMake()) && model.equals(car.getModel())
                && year == car.getYear() && mileage == car.getMileage()
                && price == car.getPrice() && dominationCount == car.getDominationCount())
            return true;
        return false;
    }
}


