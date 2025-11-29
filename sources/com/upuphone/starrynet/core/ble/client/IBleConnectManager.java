package com.upuphone.starrynet.core.ble.client;

import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteResponse;
import java.util.List;
import java.util.UUID;

public interface IBleConnectManager {
    void cancelConnecting(String str);

    void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse);

    void connect(String str, BleConnectResponse bleConnectResponse);

    void disconnect(String str);

    void disconnectAllDevices();

    void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse);

    void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse);

    void write(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteNoRespResponse bleWriteNoRespResponse);

    void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse);

    void writeNoRspAtOnce(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse);
}
