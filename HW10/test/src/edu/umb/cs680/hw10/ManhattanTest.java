package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class ManhattanTest {
    @Test
    public void testingManhattanDistance(){
        ArrayList<Double> p1 = new ArrayList<>();
        ArrayList<Double> p2 = new ArrayList<>();
        p1.add(2.0);
        p1.add(5.0);
        p1.add(3.0);
        p1.add(7.0);
        p1.add(8.0);
        p2.add(3.0);
        p2.add(4.0);
        p2.add(5.0);
        p2.add(6.0);
        p2.add(10.0);
        double actual = Distance.get(p1, p2, new Manhattan());
        double expected = 7;
        Assertions.assertEquals(expected, actual);
    }
}
