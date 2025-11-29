package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import com.upuphone.hub.Hub;
import com.upuphone.hub.annotation.Callback;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.runasone.uupcast.api.IHandleReceiverCarMessageListener;
import com.upuphone.runasone.uupcast.api.IIccoaCastProxy;
import com.upuphone.runasone.uupcast.api.IccoaConnectListener;
import com.upuphone.starryiccoaproto.UCarMessage;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.SNSLog;

public class IccoaAbility extends Ability {
    private static final String TAG = "IccoaAbility";
    private boolean isRunAsOneRebooted = false;
    protected String sessionTag = "";
    protected final IIccoaCastProxy starryCast = new IIccoaCastProxy();

    public IccoaAbility() {
        Camp.getInstance().addSentry(this);
    }

    public void buildVirtualAfterBleConnected() {
        this.starryCast.buildVirtualAfterBleConnected();
    }

    public void createIccoaSession(SinkDisplayConfig sinkDisplayConfig) {
        this.starryCast.initSession(sinkDisplayConfig);
    }

    public void destroyVirtualDisplayWhenConnectFail() {
        this.starryCast.destroyVirtualDisplayWhenConnectFail();
    }

    public void initPhoneState() {
        this.starryCast.initPhoneState();
    }

    public boolean isCarInCache(byte[] bArr) {
        return this.starryCast.isCarInCache(bArr);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.starryCast.setHub(hub);
        if (this.isRunAsOneRebooted) {
            String str = this.sessionTag;
            if (str == null || str.isEmpty()) {
                SNSLog.e(TAG, "sessionTag is empty");
            } else {
                SNSLog.d(TAG, "re initCastSession ok!");
            }
        }
        this.isRunAsOneRebooted = false;
    }

    public void onUninstalled() {
        super.onUninstalled();
        this.isRunAsOneRebooted = true;
    }

    public void reAuth(boolean z) {
        this.starryCast.reAuth(z);
    }

    public void removeCarCache() {
        this.starryCast.removeCarCache();
    }

    public void sendCarMessage(UCarMessage uCarMessage) {
        this.starryCast.sendCarMessage(uCarMessage);
    }

    public void sendMessage(int i) {
        this.starryCast.sendMessage(i);
    }

    public void setIHandleReceiverCarMessageListener(@Callback IHandleReceiverCarMessageListener iHandleReceiverCarMessageListener) {
        this.starryCast.setIHandleReceiverCarMessageListener(iHandleReceiverCarMessageListener);
    }

    public void setIccoaConnectListener(@Callback IccoaConnectListener iccoaConnectListener) {
        this.starryCast.setIccoaConnectListener(iccoaConnectListener);
    }

    public void setUibcDisplayId(int i) {
        this.starryCast.setUibcDisplayId(i);
    }

    public void startCast(int i, Bundle bundle) {
        this.starryCast.startCast(i, bundle);
    }

    public void stopPlay() {
        this.starryCast.stopPlay();
    }

    public void updatePinCode(String str) {
        this.starryCast.updatePincode(str);
    }

    public void removeCarCache(byte[] bArr) {
        this.starryCast.removeCarCache(bArr);
    }

    public void sendMessage(int i, Bundle bundle) {
        this.starryCast.sendCastMessage(i, bundle);
    }
}
