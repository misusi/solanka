package com.synth.audio;

import com.synth.Oscillator;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.AL10.*;

public class WaveGenerator {
//    private final String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
//    private final long device = alcOpenDevice(defaultDeviceName);
//    private final int[] attributes = {0};
//    private long context;
//    ALCCapabilities alcCapabilities = ALC.createCapabilities(device);
//    ALCapabilities alCapabilities = AL.createCapabilities(alcCapabilities);

    private boolean shouldGenerate = false;

    private final AudioThread audioThread = new AudioThread(() -> {
        if (!shouldGenerate) {
            return null;
        }
        short[] s = new short[AudioThread.BUFFER_SIZE];
        for (int i = 0; i < AudioThread.BUFFER_SIZE; ++i) {
            //s[i] = (short) (Short.MAX_VALUE * Math.sin(2*Math.PI*440) / AudioInfo.SAMPLE_RATE * wavePos++);
//            s[i] = (short) (10000 * (Short.MAX_VALUE + Math.sin((2 * Math.PI * 440) / AudioInfo.SAMPLE_RATE * wavePos++)));
            double d = 0;
//            for (Oscillator o : oscillators) {
//                d += o.getNextSample() / oscillators.length;
//                // ^^ Say we have 2 oscillators
//                // One returns 1, the other 0.5.
//                // If we have more oscillators, they can overflow the short.
//                // So we do (1 + 0.5) / 2 = 0.75
//            }
            s[i] = (short) (Short.MAX_VALUE * d);
        }
        return s;
    });


    public WaveGenerator() {
//        String fileName = "sound.ogg";
    }













    private void beginOpenAL() {
//        alcCreateContext(device, attributes);
//        alcMakeContextCurrent(context);
    }

    private void endOpenAL() {
//        alcDestroyContext(context);
//        alcCloseDevice(device);
    }

}
