package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
    @Test
    public void testingMileageComparison(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        cars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        cars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        cars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        cars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        Collections.sort(cars, Comparator.comparing(car -> car.getMileage()));
        Car[] actual = new Car[5];
        int i = 0;
        for(Car car : cars){
            actual[i++] = car;
        }
        ArrayList<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        expectedCars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        expectedCars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        expectedCars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        expectedCars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        Car[] expected = new Car[5];
        i = 0;
        for(Car car : expectedCars){
            expected[i++] = car;
        }
        for(int j = 0; j < cars.size(); j++) {
            Assertions.assertEquals(expected[j].getMileage(), actual[j].getMileage());
        }
    }

    @Test
    public void testingYearComparator(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        cars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        cars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        cars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        cars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        Collections.sort(cars, Comparator.comparing(car -> car.getYear()));
        Car[] actual = new Car[5];
        int i = 0;
        for(Car car : cars){
            actual[i++] = car;
        }
        ArrayList<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        expectedCars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        expectedCars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        expectedCars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        expectedCars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));

        Car[] expected = new Car[5];
        i = 0;
        for(Car car : expectedCars){
            expected[i++] = car;
        }
        for(int j = 0; j < cars.size(); j++) {
            Assertions.assertEquals(expected[j].getYear(), actual[j].getYear());
        }
    }

    @Test
    public void testingPriceComparator(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        cars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        cars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        cars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        cars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        Collections.sort(cars, Comparator.comparing(car -> car.getPrice()));
        Car[] actual = new Car[5];
        int i = 0;
        for(Car car : cars){
            actual[i++] = car;
        }
        ArrayList<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        expectedCars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        expectedCars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        expectedCars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        expectedCars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));

        Car[] expected = new Car[5];
        i = 0;
        for(Car car : expectedCars){
            expected[i++] = car;
        }
        for(int j = 0; j < cars.size(); j++) {
            Assertions.assertEquals(expected[j].getPrice(), actual[j].getPrice());
        }
    }

    @Test
    public void testingParetoComparator(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));
        cars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        cars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        cars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        cars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        int y = 9;
        for(Car car : cars){
            car.setDominationCount(y--);
        }
        Collections.sort(cars, Comparator.comparing(car -> car.getDominationCount()));
        Car[] actual = new Car[5];
        int i = 0;
        for(Car car : cars){
            actual[i++] = car;
        }
        ArrayList<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("Veneno", "Lamborghini", 100, 2010, 3000000.0F));
        expectedCars.add(new Car("Nano", "Tata", 10, 2008, 3000.0F));
        expectedCars.add(new Car("SLS AMG", "Mercedes", 40, 2012, 100000.0F));
        expectedCars.add(new Car("Phantom", "Rolls Royce", 30, 2020, 300000.0F));
        expectedCars.add(new Car("Civic", "Honda", 20, 2002, 30000.0F));

        Car[] expected = new Car[5];
        i = 0;
        for(Car car : expectedCars){
            expected[i++] = car;
        }
        for(int j = 0; j < cars.size(); j++) {
            Assertions.assertEquals(expected[j].getPrice(), actual[j].getPrice());
        }
    }
}
