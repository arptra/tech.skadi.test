package com.xjmz.ai.opus;

public class OpusCodecOptions {
    private final int bitrate;
    private final int channels;
    private final int frameSize;
    private final int maxFrameSize;
    private final int maxPacketSize;
    private final int sampleRate;

    private OpusCodecOptions(int i, int i2, int i3, int i4, int i5, int i6) {
        this.frameSize = i;
        this.sampleRate = i2;
        this.channels = i3;
        this.bitrate = i4;
        this.maxFrameSize = i5;
        this.maxPacketSize = i6;
    }

    public static OpusCodecOptions of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new OpusCodecOptions(i, i2, i3, i4, i5, i6);
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChannels() {
        return this.channels;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public int getMaxPacketSize() {
        return this.maxPacketSize;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }
}
