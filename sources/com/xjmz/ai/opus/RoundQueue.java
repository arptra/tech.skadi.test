package com.xjmz.ai.opus;

import android.util.Log;
import com.meizu.common.app.SlideNotice;

public class RoundQueue {
    private static final int MAX_SIZE = 32000;
    private static final String TAG = "RoundQueue";
    private final int GET;
    private final int PUT;
    private int readIndex;
    private int size;
    private byte[] voiceData;
    private int writeIndex;

    public static final class Hold {
        /* access modifiers changed from: private */
        public static final RoundQueue instance = new RoundQueue();

        private Hold() {
        }
    }

    public static RoundQueue getInstance() {
        return Hold.instance;
    }

    private boolean isEmpty() {
        return this.size < 640;
    }

    private boolean isFull() {
        return 32000 - this.size < 320;
    }

    public synchronized void clear() {
        this.writeIndex = 0;
        this.readIndex = 0;
        this.size = 0;
    }

    public synchronized boolean getVoiceData(byte[] bArr) {
        if (!isEmpty()) {
            System.arraycopy(this.voiceData, this.readIndex, bArr, 0, bArr.length);
            this.readIndex = (this.readIndex + 640) % 32000;
            this.size -= 640;
            return true;
        }
        Log.e(TAG, "Buffer is empty readIndex = " + this.readIndex + ",writeIndex = " + this.writeIndex);
        return false;
    }

    public synchronized boolean putVoiceData(byte[] bArr) {
        if (!isFull()) {
            System.arraycopy(bArr, 0, this.voiceData, this.writeIndex, bArr.length);
            this.writeIndex = (this.writeIndex + SlideNotice.SHOW_ANIMATION_DURATION) % 32000;
            this.size += SlideNotice.SHOW_ANIMATION_DURATION;
            return true;
        }
        Log.e(TAG, "Buffer is not enough readIndex = " + this.readIndex + ",writeIndex = " + this.writeIndex);
        return false;
    }

    private RoundQueue() {
        this.PUT = SlideNotice.SHOW_ANIMATION_DURATION;
        this.GET = 640;
        this.readIndex = 0;
        this.writeIndex = 0;
        this.voiceData = new byte[32000];
        this.size = 0;
    }
}
