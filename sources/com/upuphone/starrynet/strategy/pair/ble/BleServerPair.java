package com.upuphone.starrynet.strategy.pair.ble;

import android.os.Bundle;
import android.os.Message;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairStatusCallback;

public class BleServerPair extends BleChannelPair {
    public BleServerPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback) {
        super(iPairChannel, iPairStatusCallback);
    }

    public void createBond(StDevice stDevice, byte[] bArr) {
        serverCreateBond(stDevice, bArr);
    }

    public void onEvent(String str, byte[] bArr) {
        Message obtainMessage = this.mPairMsgHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putByteArray("pairData", bArr);
        bundle.putString("pairMac", str);
        obtainMessage.what = 0;
        obtainMessage.setData(bundle);
        this.mPairMsgHandler.sendMessage(obtainMessage);
    }

    public IPublisher.IHandler registerPublisher(IPublisher iPublisher) {
        return null;
    }

    public void removeBond(StConnectDevice stConnectDevice, byte[] bArr) {
        super.removeBond(stConnectDevice, bArr);
        serverRemoveBond(stConnectDevice);
    }
}
