package com.danlu.dmall.service.util;

import java.util.Comparator;

public class DoubleCompartor implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
    }

}
