package com.synth.utils;

import static java.lang.Math.*;

public class Math {
    public static double frequencyToAngularFrequency(double freq){
        return 2 * PI * freq;
    }

    //  https://en.wikipedia.org/wiki/Piano_key_frequencies
    public static double getKeyFrequency(int keyNum) {
        return pow(root(2, 12), keyNum - 49) * 440;
    }

    public static double root(double num, double root) {
        return pow(E, log(num) / root);
    }

    public static double offsetTone(double baseFrequency, double frequencyMultiplier) {
        return baseFrequency * pow(2.0, frequencyMultiplier);
    }
}