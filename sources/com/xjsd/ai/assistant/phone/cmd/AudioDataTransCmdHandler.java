package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.protocol.Cmd;

public class AudioDataTransCmdHandler implements CmdHandler {
    public static final AudioDataTransCmdHandler b = new AudioDataTransCmdHandler();

    /* renamed from: a  reason: collision with root package name */
    public OnDataListener f8543a;

    public interface OnDataListener {
        void b(byte[] bArr);
    }

    public static AudioDataTransCmdHandler a() {
        return b;
    }

    public void b(OnDataListener onDataListener) {
        this.f8543a = onDataListener;
    }

    public int getHandleCode() {
        return 109;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        byte[] data = starryNetMessage.getData();
        int length = data.length;
        int i = 0;
        while (i < length) {
            byte[] bArr = new byte[2];
            System.arraycopy(data, i, bArr, 0, 2);
            byte b2 = (bArr[0] << 8) | (bArr[1] & 255);
            int i2 = b2 + 2;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(data, i, bArr2, 0, i2);
            OnDataListener onDataListener = this.f8543a;
            if (onDataListener != null) {
                onDataListener.b(bArr2);
            }
            i = i + b2 + 2;
        }
    }
}
