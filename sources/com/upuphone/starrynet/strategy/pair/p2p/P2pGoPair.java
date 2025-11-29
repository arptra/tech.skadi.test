package com.upuphone.starrynet.strategy.pair.p2p;

import android.os.Bundle;
import android.os.Message;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairStatusCallback;

public class P2pGoPair extends P2pChannelPair {
    public P2pGoPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback) {
        super(iPairChannel, iPairStatusCallback);
    }

    public void onEvent(String str, byte[] bArr) {
        Message obtainMessage = this.mP2pPairMsgHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putByteArray("pairData", bArr);
        obtainMessage.setData(bundle);
        obtainMessage.obj = str;
        obtainMessage.what = 2;
        this.mP2pPairMsgHandler.sendMessage(obtainMessage);
    }
}
