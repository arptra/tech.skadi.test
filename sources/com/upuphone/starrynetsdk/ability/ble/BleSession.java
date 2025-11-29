package com.upuphone.starrynetsdk.ability.ble;

import com.upuphone.runasone.ble.BleRawSession;
import com.upuphone.runasone.ble.SessionConfig;

public class BleSession extends BleRawSession {
    private final BleAbility bleAbility;

    public BleSession(String str, String str2, BleAbility bleAbility2) {
        super(str, str2);
        this.bleAbility = bleAbility2;
    }

    public static BleSession warp(BleRawSession bleRawSession) {
        BleAbility bleAbility2 = new BleAbility();
        BleSession bleSession = new BleSession(bleRawSession.getDeviceId(), bleRawSession.getSessionId(), bleAbility2);
        bleAbility2.setDeviceId(bleRawSession.getDeviceId());
        return bleSession;
    }

    public int init(SessionConfig sessionConfig, BleInitSessionListener bleInitSessionListener) {
        return this.bleAbility.initSession(sessionConfig, bleInitSessionListener);
    }

    public int openNotify(String str, BleOpenNotifyListener bleOpenNotifyListener) {
        return this.bleAbility.openNotify(str, bleOpenNotifyListener);
    }

    public int read(String str, BleReadListener bleReadListener) {
        return this.bleAbility.read(str, bleReadListener);
    }

    public void registerSessionListener(BleSessionListener bleSessionListener) {
        this.bleAbility.registerSessionListener(bleSessionListener);
    }

    public int setMtu(int i, BleMtuListener bleMtuListener) {
        return this.bleAbility.setMtu(i, bleMtuListener);
    }

    public void unregisterSessionListener() {
        this.bleAbility.unregisterSessionListener();
    }

    public BleRawSession unwrap() {
        return new BleRawSession(getDeviceId(), getSessionId());
    }

    public int write(String str, byte[] bArr, BleWriteListener bleWriteListener) {
        return this.bleAbility.write(str, bArr, bleWriteListener);
    }
}
