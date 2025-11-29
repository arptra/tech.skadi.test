package com.xjsd.iot.starrynetstack.jni;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.IOException;
import java.net.InetSocketAddress;

@Keep
public class StarrySocketProxy {
    private final boolean mIsServer;
    private long mNativeContext;
    private int mProtocol;

    static {
        StarrySocketLibLoader.a();
    }

    public StarrySocketProxy(boolean z, int i, int i2) {
        this.mIsServer = z;
        nativeSetup(i, i2);
    }

    private native int nativeBind(String str, int i);

    private native int nativeClose();

    private native int nativeConnect(String str, int i);

    private native int nativeGetLocalPort();

    private native InetSocketAddress nativeGetRemoteSockAddr(int i);

    private native int nativeOpen(int i, int i2, int i3, int i4);

    private native void nativeRelease();

    private native int nativeSend(byte[] bArr, int i, int i2);

    private native int nativeSendDirect(byte[] bArr, int i, int i2, String str, int i3);

    private native int nativeSendTo(int i, byte[] bArr, int i2, int i3);

    private native void nativeSetListener(IStarrySocketListener iStarrySocketListener);

    private native int nativeSetReceiveBufferSize(int i);

    private native int nativeSetSendBufferSize(int i);

    private native int nativeSetSockOption(int i, int i2, String str, int i3);

    private native void nativeSetup(int i, int i2);

    public int bind(String str, int i) {
        if (i >= 0 && i <= 65535) {
            return nativeBind(str, i);
        }
        throw new IllegalArgumentException("Port value out of range: " + i);
    }

    public int close() {
        return nativeClose();
    }

    public int connect(String str, int i) {
        if (this.mIsServer) {
            return -1;
        }
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Port value out of range: " + i);
        } else if (!TextUtils.isEmpty(str)) {
            return nativeConnect(str, i);
        } else {
            throw new NullPointerException("host is null or empty");
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public int getLocalPort() {
        return nativeGetLocalPort();
    }

    public InetSocketAddress getReomoteSockAddr(int i) {
        return nativeGetRemoteSockAddr(i);
    }

    public int open(int i, int i2, int i3, int i4) {
        this.mProtocol = i3;
        return nativeOpen(i, i2, i3, i4);
    }

    public void release() {
        nativeRelease();
    }

    public int send(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.mIsServer && this.mProtocol != 3) {
            return -1;
        }
        bArr.getClass();
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i4 < i2) {
            int nativeSend = nativeSend(bArr, i + i4, i2 - i4);
            if (nativeSend >= 0) {
                i4 += nativeSend;
            } else {
                throw new IOException("it is over");
            }
        }
        return i2;
    }

    public int sendDirect(byte[] bArr, int i, int i2, String str, int i3) throws IOException {
        int i4;
        bArr.getClass();
        if (i < 0 || i > bArr.length || i2 < 0 || (i4 = i + i2) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i5 < i2) {
            int nativeSendDirect = nativeSendDirect(bArr, i + i5, i2 - i5, str, i3);
            if (nativeSendDirect >= 0) {
                i5 += nativeSendDirect;
            } else {
                throw new IOException("it is over");
            }
        }
        return i2;
    }

    public int sendTo(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (!this.mIsServer) {
            return -1;
        }
        bArr.getClass();
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i5 < i3) {
            int nativeSendTo = nativeSendTo(i, bArr, i2 + i5, i3 - i5);
            if (nativeSendTo >= 0) {
                i5 += nativeSendTo;
            } else {
                throw new IOException("it is over");
            }
        }
        return i3;
    }

    public void setListener(IStarrySocketListener iStarrySocketListener) {
        nativeSetListener(iStarrySocketListener);
    }

    public void setReceiveBufferSize(int i) {
        nativeSetReceiveBufferSize(i);
    }

    public void setSendBufferSize(int i) {
        nativeSetSendBufferSize(i);
    }

    public int setSockOption(int i, int i2, String str, int i3) {
        return nativeSetSockOption(i, i2, str, i3);
    }

    public StarrySocketProxy(boolean z, int i) {
        this.mIsServer = z;
        nativeSetup(i, 5);
    }

    public StarrySocketProxy(int i, int i2) {
        this.mIsServer = false;
        nativeSetup(i, i2);
    }

    public StarrySocketProxy(int i) {
        this.mIsServer = false;
        nativeSetup(i, 5);
    }
}
