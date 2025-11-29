package com.upuphone.starrynet.payload.hid;

import android.view.MotionEvent;
import com.upuphone.starrynet.payload.Plog;

public class TouchPadProxy {
    private static final String TAG = "TouchPadProxy";
    private IHidOutputListener mOutputListener;
    private int mTouchAreaHeight;
    private int mTouchAreaWidth;
    private TouchEventHandler mTouchEventHandler;

    public interface TouchEventListener {
        void touchMove(int i, int i2, int i3);

        void touchReset(int i);
    }

    public TouchPadProxy(int i, int i2) {
        this.mTouchAreaWidth = i;
        this.mTouchAreaHeight = i2;
        if (this.mTouchEventHandler == null) {
            this.mTouchEventHandler = new TouchEventHandler(new TouchEventListener() {
                public void touchMove(int i, int i2, int i3) {
                    TouchPadProxy.this.output(TouchPadProxy.this.touchMove(i, i2, i3));
                }

                public void touchReset(int i) {
                    TouchPadProxy.this.output(TouchPadProxy.this.touchReset(i));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void output(byte[] bArr) {
        if (bArr == null) {
            Plog.w(TAG, "output data cannot be null!", new Object[0]);
            return;
        }
        IHidOutputListener iHidOutputListener = this.mOutputListener;
        if (iHidOutputListener != null) {
            iHidOutputListener.output(2, bArr);
        }
    }

    /* access modifiers changed from: private */
    public byte[] touchMove(int i, int i2, int i3) {
        if (this.mTouchAreaHeight < 0 || this.mTouchAreaWidth < 0) {
            Plog.e(TAG, "you must to execute method : ITouchPadWrapper class setTouchAreaSize(int width, int height), then touch, this touch event will ignore! ", new Object[0]);
            return null;
        }
        Plog.v(TAG, String.format("current threadName =%s, touchMove ,touchID =%d, x=%d, y=%d", new Object[]{Thread.currentThread().getName(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}), new Object[0]);
        int round = (int) Math.round((((double) i2) * 3840.0d) / ((double) this.mTouchAreaWidth));
        int round2 = (int) Math.round((((double) i3) * 3840.0d) / ((double) this.mTouchAreaHeight));
        byte[] bArr = new byte[6];
        bArr[0] = 1;
        bArr[1] = (byte) i;
        bArr[3] = (byte) ((round >>> 8) & 255);
        bArr[2] = (byte) (round & 255);
        bArr[5] = (byte) (round2 >>> 8);
        bArr[4] = (byte) (round2 & 255);
        return bArr;
    }

    /* access modifiers changed from: private */
    public byte[] touchReset(int i) {
        return new byte[]{0, (byte) i, 0, 0, 0, 0};
    }

    public void setIPayloadMessageOutputListener(IHidOutputListener iHidOutputListener) {
        this.mOutputListener = iHidOutputListener;
    }

    public void touchEvent(MotionEvent motionEvent) {
        TouchEventHandler touchEventHandler = this.mTouchEventHandler;
        if (touchEventHandler != null) {
            touchEventHandler.onTouch(motionEvent);
        }
    }

    public void updateSize(int i, int i2) {
        this.mTouchAreaWidth = i;
        this.mTouchAreaHeight = i2;
    }
}
