package com.synth.audio;


import com.synth.Synthesizer;
import com.synth.utils.Math;
import javafx.collections.ObservableList;

import static java.lang.Math.*;

public enum Wavetable {
    Sine, Square, Saw, Triangle;

    public static final int SIZE = 8192;

    private final float[] samples = new float[SIZE];

    static
    {
        final double FUND_FREQ = 1d / (SIZE / (double) Synthesizer.AudioInfo.SAMPLE_RATE);
        for (int i = 0; i < SIZE; ++i) {
            double t = i / (double) Synthesizer.AudioInfo.SAMPLE_RATE;
            double tDivP = t / (1d / FUND_FREQ);
            Sine.samples[i] = (float) sin(Math.frequencyToAngularFrequency(FUND_FREQ) * t);
            Square.samples[i] = signum(Sine.samples[i]);
            Saw.samples[i] = (float) (2d * (tDivP - floor(0.5 + tDivP)));
            Triangle.samples[i] = (float) (2d * abs(Saw.samples[i]) - 1d);
            System.out.println(Saw.samples[i]);
        }
    }

    public float[] getSamples() {
        return samples;
    }
}
