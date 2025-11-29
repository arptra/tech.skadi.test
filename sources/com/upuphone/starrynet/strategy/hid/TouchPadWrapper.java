package com.upuphone.starrynet.strategy.hid;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.hid.ITouchPadWrapper;
import com.upuphone.starrynet.common.StLog;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressLint({"MissingPermission"})
public class TouchPadWrapper implements ITouchPadWrapper {
    private static final int MSG_DO_REQUEST = 2;
    private static final String TAG = "TouchPadWrapper";
    /* access modifiers changed from: private */
    public Queue<TouchReport> inputReportQueue = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public volatile boolean isSending = false;
    private byte[] mBuffer = new byte[6];
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    private BluetoothHidDevice mHidDevice;
    private BluetoothDevice mHost;
    private int mTouchAreaHeight = -1;
    private int mTouchAreaWidth = -1;
    private TouchEventHandler mTouchHandler;

    public TouchPadWrapper(BluetoothHidDevice bluetoothHidDevice, BluetoothDevice bluetoothDevice) {
        this.mHidDevice = bluetoothHidDevice;
        this.mHost = bluetoothDevice;
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper()) {
            public void handleMessage(@NonNull Message message) {
                if (message.what == 2) {
                    TouchPadWrapper.this.sendInputReport((TouchReport) message.obj);
                    TouchReport touchReport = (TouchReport) TouchPadWrapper.this.inputReportQueue.poll();
                    if (!TouchPadWrapper.this.inputReportQueue.isEmpty()) {
                        StLog.d(TouchPadWrapper.TAG, "poll next,remain queue size =" + TouchPadWrapper.this.inputReportQueue.size());
                    }
                    if (touchReport != null) {
                        boolean unused = TouchPadWrapper.this.isSending = true;
                        TouchPadWrapper.this.mHandler.sendMessageDelayed(TouchPadWrapper.this.mHandler.obtainMessage(2, touchReport), 5);
                        return;
                    }
                    boolean unused2 = TouchPadWrapper.this.isSending = false;
                }
            }
        };
        this.mTouchHandler = new TouchEventHandler(this);
    }

    private void readySend(TouchReport touchReport) {
        if (this.isSending) {
            this.inputReportQueue.offer(touchReport);
            return;
        }
        this.isSending = true;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, touchReport));
    }

    /* access modifiers changed from: private */
    public void sendInputReport(TouchReport touchReport) {
        BluetoothHidDevice bluetoothHidDevice = this.mHidDevice;
        if (bluetoothHidDevice == null || this.mHost == null) {
            String str = "not";
            String str2 = bluetoothHidDevice == null ? "" : str;
            if (this.mHost == null) {
                str = "";
            }
            StLog.i(TAG, "sendInputReport, hidDevice is %s null ,host device is %s null", str2, str);
        } else if (touchReport.buffer == null || touchReport.buffer.length <= 0) {
            if (touchReport.mIsReset) {
                this.mBuffer[0] = 0;
            } else {
                this.mBuffer[0] = 1;
            }
            this.mBuffer[1] = touchReport.mTouchID;
            this.mBuffer[2] = touchReport.mXLow;
            this.mBuffer[3] = touchReport.mXHigh;
            this.mBuffer[4] = touchReport.mYLow;
            this.mBuffer[5] = touchReport.mYHigh;
            boolean sendReport = this.mHidDevice.sendReport(this.mHost, 1, this.mBuffer);
            StLog.d(TAG, "sendReport ret =" + sendReport);
        } else {
            boolean sendReport2 = this.mHidDevice.sendReport(this.mHost, 1, touchReport.buffer);
            StLog.d(TAG, "sendReport ret =" + sendReport2);
        }
    }

    public boolean onTouch(MotionEvent motionEvent) {
        return this.mTouchHandler.onTouch(motionEvent);
    }

    public void sendBytes(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            BluetoothHidDevice bluetoothHidDevice = this.mHidDevice;
            if (bluetoothHidDevice == null || this.mHost == null) {
                String str = "not";
                String str2 = bluetoothHidDevice == null ? "" : str;
                if (this.mHost == null) {
                    str = "";
                }
                StLog.d(TAG, "sendBytes, hidDevice is %s null ,host device is %s null", str2, str);
                return;
            }
            readySend(new TouchReport(bArr));
        }
    }

    public void setTouchAreaSize(int i, int i2) {
        this.mTouchAreaWidth = i;
        this.mTouchAreaHeight = i2;
    }

    public void touchMove(int i, int i2, int i3) {
        if (this.mTouchAreaHeight < 0 || this.mTouchAreaWidth < 0) {
            StLog.e(TAG, "you must to execute method : ITouchPadWrapper class setTouchAreaSize(int width, int height), then touch, this touch event will ignore! ");
            return;
        }
        StLog.d(TAG, String.format("current threadName =%s, touchMove ,touchID =%d, x=%d, y=%d", new Object[]{Thread.currentThread().getName(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
        readySend(new TouchReport(i, (int) Math.round((((double) i2) * 3840.0d) / ((double) this.mTouchAreaWidth)), (int) Math.round((((double) i3) * 3840.0d) / ((double) this.mTouchAreaHeight))));
    }

    public void touchReset(int i) {
        readySend(new TouchReport(i));
    }

    public void updateHidDevice(BluetoothHidDevice bluetoothHidDevice) {
        this.mHidDevice = bluetoothHidDevice;
    }

    public void updateHost(BluetoothDevice bluetoothDevice) {
        this.mHost = bluetoothDevice;
    }

    public final class TouchReport {
        /* access modifiers changed from: private */
        public byte[] buffer;
        /* access modifiers changed from: private */
        public boolean mIsReset;
        /* access modifiers changed from: private */
        public byte mTouchID;
        /* access modifiers changed from: private */
        public byte mXHigh;
        /* access modifiers changed from: private */
        public byte mXLow;
        /* access modifiers changed from: private */
        public byte mYHigh;
        /* access modifiers changed from: private */
        public byte mYLow;

        private TouchReport(int i) {
            this.buffer = null;
            this.mIsReset = true;
            this.mTouchID = (byte) i;
            this.mXHigh = 0;
            this.mXLow = 0;
            this.mYHigh = 0;
            this.mYLow = 0;
        }

        private TouchReport(int i, int i2, int i3) {
            this.buffer = null;
            this.mIsReset = false;
            this.mTouchID = (byte) i;
            this.mXHigh = (byte) ((i2 >>> 8) & 255);
            this.mXLow = (byte) (i2 & 255);
            this.mYHigh = (byte) (i3 >>> 8);
            this.mYLow = (byte) (i3 & 255);
        }

        private TouchReport(byte[] bArr) {
            this.mIsReset = false;
            this.buffer = bArr;
        }
    }
}
