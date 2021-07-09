package com.synth.audio;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.AL10.*;

public class WaveGenerator {
    private final String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
    private final long device = alcOpenDevice(defaultDeviceName);
    private final int[] attributes = {0};
    private long context;
    ALCCapabilities alcCapabilities = ALC.createCapabilities(device);
    ALCapabilities alCapabilities = AL.createCapabilities(alcCapabilities);

    public WaveGenerator() {
        String fileName = "sound.ogg";
    }

    private void beginOpenAL() {
        alcCreateContext(device, attributes);
        alcMakeContextCurrent(context);
    }

    private void endOpenAL() {
        alcDestroyContext(context);
        alcCloseDevice(device);
    }

}
