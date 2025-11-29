package com.upuphone.starrynet.core.ble.client.request;

import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import java.util.UUID;

public class BleWriteAtOneRequest extends BleWriteNoRspRequest {
    public BleWriteAtOneRequest(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        super(uuid, uuid2, bArr, bleResponser);
    }
}
