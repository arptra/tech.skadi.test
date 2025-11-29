package com.upuphone.starrynet.payload.hid;

public interface IHidOutputListener {
    void openHidCallBack(int i, String str);

    void output(int i, byte[] bArr);
}
