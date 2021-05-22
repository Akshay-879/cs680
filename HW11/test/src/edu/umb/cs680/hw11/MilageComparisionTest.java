package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MilageComparisionTest {

    static LinkedList<Car> carList = new LinkedList<Car>();

    @BeforeAll
    public static void initialize() {
        Car c1 = new Car("Lykn", "Hypersport", 2019, 3, 10000000, 1);
        carList.add(c1);
        Car c2 = new Car("Venom", "GT", 2018, 4, 20000000, 3);
        carList.add(c2);
        Car c3 = new Car("Buggati", "Vyron", 2020, 2, 15000000, 2);
        carList.add(c3);
        Car c4 = new Car("Mercedes", "AMG", 2016, 12, 1000000, 4);
        carList.add(c4);
    }


    @Test
    void verificationforcar3() {
        assertEquals(2, carList.get(2).getMileage());
    }

    @Test
    void verificationforcar4() {
        assertEquals(12, carList.get(3).getMileage());

    }
}
