package com.xjmz.ai.opus;

import android.util.Log;
import com.honey.account.l9.a;
import com.meizu.common.app.SlideNotice;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpusCodec {
    /* access modifiers changed from: private */
    public static String LOG_TAG = "opus_code";
    private List<byte[]> bufferList;
    private boolean decoderInitialized;
    private long decoderState;
    private boolean encoderInitialized;
    private long encoderState;
    private int frameSize;
    private final OpusCodecOptions opusOptions;

    public static class Builder {
        private int bitrate;
        private int channels;
        private int frameSize;
        private int maxFrameSize;
        private int maxPacketSize;
        private int sampleRate;

        public OpusCodec build() {
            Log.i(OpusCodec.LOG_TAG, "opus build");
            return new OpusCodec(OpusCodecOptions.of(this.frameSize, this.sampleRate, this.channels, this.bitrate, this.maxFrameSize, this.maxPacketSize));
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

        public Builder withBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder withChannels(int i) {
            this.channels = i;
            return this;
        }

        public Builder withFrameSize(int i) {
            this.frameSize = i;
            return this;
        }

        public Builder withMaxFrameSize(int i) {
            this.maxFrameSize = i;
            return this;
        }

        public Builder withMaxPacketSize(int i) {
            this.maxPacketSize = i;
            return this;
        }

        public Builder withSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        private Builder() {
            this.frameSize = SlideNotice.SHOW_ANIMATION_DURATION;
            this.sampleRate = 16000;
            this.channels = 2;
            this.bitrate = 64000;
            this.maxFrameSize = 640;
            this.maxPacketSize = 40;
        }
    }

    static {
        System.loadLibrary("opus-jni");
    }

    private byte[] byteList2ByteArr(List<byte[]> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        list.forEach(new a(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }

    public static OpusCodec createByOptions(OpusCodecOptions opusCodecOptions) {
        return new OpusCodec(opusCodecOptions);
    }

    private native long createDecoder(OpusCodecOptions opusCodecOptions);

    public static OpusCodec createDefault() {
        return newBuilder().build();
    }

    private native long createEncoder(OpusCodecOptions opusCodecOptions);

    private native byte[] decodeFrame(long j, byte[] bArr);

    private native void destroyDecoder(long j);

    private native void destroyEncoder(long j);

    private native byte[] encodeFrame(long j, byte[] bArr, int i, int i2);

    private void ensureDecoderExistence() {
        if (!this.decoderInitialized) {
            this.decoderState = createDecoder(this.opusOptions);
            this.decoderInitialized = true;
        }
    }

    private void ensureEncoderExistence() {
        if (!this.encoderInitialized) {
            this.encoderState = createEncoder(this.opusOptions);
            this.encoderInitialized = true;
        }
    }

    private static boolean hasResource(String str) {
        return OpusCodec.class.getResource(str) != null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$byteList2ByteArr$0(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        try {
            byte[] bArr2 = {(byte) (bArr.length >> 8), (byte) (bArr.length & 255)};
            byte[] bArr3 = new byte[(bArr.length + 2)];
            System.arraycopy(bArr2, 0, bArr3, 0, 2);
            System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
            byteArrayOutputStream.write(bArr3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] decodeFrame(byte[] bArr) {
        ensureDecoderExistence();
        return decodeFrame(this.decoderState, bArr);
    }

    public void destroy() {
        Log.i(LOG_TAG, "opus destroy");
        if (this.encoderInitialized) {
            destroyEncoder(this.encoderState);
        }
        if (this.decoderInitialized) {
            destroyDecoder(this.decoderState);
        }
        this.encoderInitialized = false;
        this.decoderInitialized = false;
    }

    public byte[] encodeFrame(byte[] bArr) {
        return encodeFrame(bArr, 0, bArr.length);
    }

    public int getBitrate() {
        return this.opusOptions.getBitrate();
    }

    public int getChannels() {
        return this.opusOptions.getChannels();
    }

    public int getFrameSize() {
        return this.opusOptions.getFrameSize();
    }

    public int getMaxFrameSize() {
        return this.opusOptions.getMaxFrameSize();
    }

    public int getMaxPacketSize() {
        return this.opusOptions.getMaxPacketSize();
    }

    public int getSampleRate() {
        return this.opusOptions.getSampleRate();
    }

    public byte[] packFrame(byte[] bArr) {
        RoundQueue instance = RoundQueue.getInstance();
        instance.putVoiceData(bArr);
        byte[] bArr2 = new byte[640];
        while (instance.getVoiceData(bArr2) && this.bufferList.size() != this.frameSize) {
            this.bufferList.add(encodeFrame(bArr2));
        }
        if (this.bufferList.size() != this.frameSize) {
            return null;
        }
        byte[] byteList2ByteArr = byteList2ByteArr(this.bufferList);
        this.bufferList.clear();
        return byteList2ByteArr;
    }

    private OpusCodec(OpusCodecOptions opusCodecOptions) {
        this.encoderInitialized = false;
        this.decoderInitialized = false;
        this.bufferList = new LinkedList();
        this.frameSize = 5;
        Log.i(LOG_TAG, "opus OpusCodec");
        this.opusOptions = opusCodecOptions;
    }

    public byte[] encodeFrame(byte[] bArr, int i, int i2) {
        String str = LOG_TAG;
        Log.i(str, "opus encodeFrame offset " + i + " length " + i2);
        if (i2 == getChannels() * getFrameSize() * 2) {
            ensureEncoderExistence();
            return encodeFrame(this.encoderState, bArr, i, i2);
        }
        throw new IllegalArgumentException(String.format("data length must be == CHANNELS * FRAMESIZE * 2 (%d bytes) but is %d bytes", new Object[]{Integer.valueOf(getChannels() * getFrameSize() * 2), Integer.valueOf(bArr.length)}));
    }
}
