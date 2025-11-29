package com.upuphone.starrynet.core.spp.task;

import android.bluetooth.BluetoothSocket;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SPPReadTask implements Runnable {
    private static final String TAG = "SPPReadTask";
    private byte[] SPP_HEADER_ID_CODE_ARRAY = {-22, RingSecurityPair.OPCODE_RING_ENCRYPTED_DATA, -109, 83};
    private final String mDeviceAddress;
    private IConnectionEventListener mIConnectionEventListener;
    private InputStream mInputStream;
    private boolean mIsInputStreamInit;

    public SPPReadTask(@NonNull BluetoothSocket bluetoothSocket, @NonNull IConnectionEventListener iConnectionEventListener) {
        this.mIConnectionEventListener = iConnectionEventListener;
        this.mDeviceAddress = bluetoothSocket.getRemoteDevice().getAddress();
        try {
            this.mInputStream = bluetoothSocket.getInputStream();
            this.mIsInputStreamInit = true;
        } catch (IOException unused) {
            StLog.d(TAG, "SPPReadTask: getInputStream error");
            this.mIsInputStreamInit = false;
            this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 100);
        }
    }

    private boolean checkHeaderID() throws IOException {
        byte[] bArr = new byte[4];
        int i = 0;
        while (i < 4) {
            int read = this.mInputStream.read(bArr, i, 4 - i);
            if (read < 0) {
                return false;
            }
            i += read;
        }
        return Arrays.equals(bArr, this.SPP_HEADER_ID_CODE_ARRAY);
    }

    private int readHeader() throws IOException {
        byte[] bArr = new byte[4];
        int i = 0;
        while (i < 4) {
            int read = this.mInputStream.read(bArr, i, 4 - i);
            if (read < 0) {
                return read;
            }
            i += read;
        }
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    @Nullable
    private byte[] readPayload(int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = this.mInputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                return null;
            }
            i2 += read;
        }
        return bArr;
    }

    public void run() {
        while (true) {
            if (!this.mIsInputStreamInit) {
                break;
            }
            try {
                if (!checkHeaderID()) {
                    StLog.e(TAG, "Spp check header error, continue next!");
                } else {
                    int readHeader = readHeader();
                    if (readHeader < 0) {
                        StLog.e(TAG, "SPPReadTask read header error");
                        break;
                    }
                    String str = TAG;
                    StLog.d(str, "SPPReadTask, payloadLen:" + readHeader);
                    byte[] readPayload = readPayload(readHeader);
                    if (readPayload == null) {
                        StLog.e(str, "SPPReadTask payloadArray is null");
                        break;
                    }
                    this.mIConnectionEventListener.onMessageReceived(this.mDeviceAddress, readPayload);
                }
            } catch (IOException e) {
                String str2 = TAG;
                StLog.d(str2, "SPPReadTask, read exception:" + e);
            }
        }
        this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 100);
    }
}
