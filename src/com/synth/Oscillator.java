package com.synth;

import com.synth.Synthesizer;
import com.synth.audio.Wavetable;
import com.synth.ui.OscillatorUI;
import com.synth.utils.Math ;
import com.synth.utils.RefWrapper;
import org.lwjgl.system.CallbackI;


public class Oscillator {
    protected static final int TONE_OFFSET_LIMIT = 2000;
    //    public static final double FREQUENCY = 440;
    protected double keyFrequency;
    protected int wavetableStepSize;
    protected int wavetableIndex;
    protected RefWrapper<Integer> toneOffset = new RefWrapper<>(0);
    protected RefWrapper<Integer> volume = new RefWrapper<>(100);
    protected int freqMultiplier = 10000;
    protected Wavetable wavetable = Wavetable.Sine;
    protected String name;

    private OscillatorUI ui;

    public Oscillator(String name) {
        ui = new OscillatorUI(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNextSample() {
        double sample = wavetable.getSamples()[wavetableIndex] * getVolumeMultiplier();
        wavetableIndex = (wavetableIndex + wavetableStepSize) % Wavetable.SIZE;
        return sample;
    }

    public void setKeyFrequency(double frequency) {
        keyFrequency = frequency;
        applyToneOffset();
    }

    public double[] getSampleWaveform(int numSamples) {
        double[] samples = new double[numSamples];
        double frequency = 1.0 / (numSamples / (double) Synthesizer.AudioInfo.SAMPLE_RATE) * 3.0; // 3.0 shows move waveform
        int index = 0;
        int stepSize = (int) (Wavetable.SIZE * Math.offsetTone(frequency, getToneOffset()) / Synthesizer.AudioInfo.SAMPLE_RATE);
        for (int i = 0; i < numSamples; ++i) {
            samples[i] = wavetable.getSamples()[index] * getVolumeMultiplier();
            index = (index + stepSize) % Wavetable.SIZE;
        }
        return samples;
    }

    protected double getToneOffset()
    {
        return toneOffset.val / 1000.0;
    }

    protected double getVolumeMultiplier() {
        return volume.val / 100.0;
    }

    protected void applyToneOffset() {
        wavetableStepSize = (int) (Wavetable.SIZE * Math.offsetTone(keyFrequency, getToneOffset()) / Synthesizer.AudioInfo.SAMPLE_RATE);
    }
}