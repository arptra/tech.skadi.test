package com.upuphone.starrynet.strategy.discovery.mdns;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.core.dns.NsdLog;
import com.upuphone.starrynet.strategy.StarryNetData;

public class MdnsStarryNetDiscovery {
    private static final String TAG = "MdnsStarryNetDiscovery";
    private final Context mContext;
    private MdnsStateMachine mdnsStateMachine;

    public MdnsStarryNetDiscovery() {
        Context applicationContext = StarryNetData.getInstance().getApplicationContext();
        this.mContext = applicationContext;
        HandlerThread handlerThread = new HandlerThread("MDNS.HandlerThread.MDNSStateMachine");
        handlerThread.start();
        this.mdnsStateMachine = MdnsStateMachine.make(applicationContext, handlerThread.getLooper());
    }

    public int startCast() {
        Message obtainMessage = this.mdnsStateMachine.obtainMessage();
        obtainMessage.what = 1;
        this.mdnsStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter) {
        NsdLog.LOG.debug(TAG, "MdnsStarryNetDiscovery start");
        Message obtainMessage = this.mdnsStateMachine.obtainMessage();
        obtainMessage.what = 2;
        this.mdnsStateMachine.sendMessage(obtainMessage);
        return 0;
    }
}
