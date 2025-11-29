package com.upuphone.starrynet.strategy.pair.ble;

import android.os.Bundle;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairStatusCallback;

public class BleClientPair extends BleChannelPair {
    public BleClientPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback) {
        super(iPairChannel, iPairStatusCallback);
    }

    public void createBond(StDevice stDevice, byte[] bArr) {
        clientCreateBond(stDevice, bArr);
    }

    public void onEvent(String str, byte[] bArr) {
        Message obtainMessage = this.mPairMsgHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putByteArray("pairData", bArr);
        obtainMessage.setData(bundle);
        obtainMessage.obj = str;
        obtainMessage.what = 1;
        this.mPairMsgHandler.sendMessage(obtainMessage);
    }

    public void removeBond(StConnectDevice stConnectDevice, byte[] bArr) {
        clientRemoveBond(stConnectDevice);
    }
}
