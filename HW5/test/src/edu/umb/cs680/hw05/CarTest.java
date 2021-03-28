package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test

    private String[] carToStringArray(Car car) {
        String[] carInfo =  {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear()
    {
        String[] expected = {"Venom","GT","2018"};
        Car actual= new Car("Venom","GT",4,2018,10000);
        assertArrayEquals(expected,carToStringArray(actual));
    }
}