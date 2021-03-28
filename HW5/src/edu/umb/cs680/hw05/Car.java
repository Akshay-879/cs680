package edu.umb.cs680.hw05;

public class Car {
    private String Make;
    private String Model;
    private int Mileage;
    private int Year;
    private float Price;

    public Car(String Make, String Model , int Mileage, int Year, float Price) {
        this.Mileage=Mileage;
        this.Price=Price;
        this.Make=Make;
        this.Model=Model;
        this.Year=Year;
    }

    public String getMake() {
        return this.Make;
    }
    public String getModel() {
        return  this.Model;
    }
    public int getMileage() {
        return this.Mileage;
    }
    public int getYear() {
        return this.Year;
    }
    public float getPrice() {
        return this.Price;
    }
    public static void main(String[] args) {
        Car c = new Car("Lykn", "Hypersport", 2, 2018, 350000 );
    }

}
