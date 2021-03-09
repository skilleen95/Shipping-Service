package com.skilleen.secondmicroservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum City {
    Toronto,
    Boston,
    Ottawa,
    Calgary,
    Montreal;

    private static final List<City> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static City randomCity()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
    }
