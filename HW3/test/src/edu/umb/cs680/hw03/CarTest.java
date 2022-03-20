package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static String[] carToStringArray(Car instance) {
        String[] carString = new String[3];
        carString[0] = instance.getMake();
        carString[1] = instance.getModel();
        carString[2] = String.valueOf(instance.getYear());
        return carString;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 2018, 23, 20000);
        Assertions.assertArrayEquals(expected, carToStringArray(actual));
    }
}
