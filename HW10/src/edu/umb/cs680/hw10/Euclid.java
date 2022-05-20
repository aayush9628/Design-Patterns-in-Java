package edu.umb.cs680.hw10;

import java.util.List;

public class Euclid implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double ans = 0;
        for(int i = 0; i < p1.size(); i++){
            ans += (p1.get(i) - p2.get(i))*(p1.get(i) - p2.get(i));
        }
        return Math.sqrt(ans);
    }
}
