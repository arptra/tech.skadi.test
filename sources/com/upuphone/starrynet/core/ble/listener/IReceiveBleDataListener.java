package com.upuphone.starrynet.core.ble.listener;

import com.upuphone.starrynet.api.bean.StMessage;

public interface IReceiveBleDataListener {
    void receiveData(byte[] bArr);

    void receiveStMessage(StMessage stMessage);

    void receiveTlvData(boolean z, byte[] bArr);

    void receiveV2Data(boolean z, byte[] bArr);
}
