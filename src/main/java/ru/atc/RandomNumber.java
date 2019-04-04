package ru.atc;

import java.util.Random;

public class RandomNumber {

    public static int RandomNun() {
        int min = 1;
        int max = 1000000000;

        Random random = new Random(System.currentTimeMillis());
        int number = min + random.nextInt(max - min + 1);
        return number;
    }

}
