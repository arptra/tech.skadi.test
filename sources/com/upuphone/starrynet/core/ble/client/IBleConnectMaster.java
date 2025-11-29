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

public interface IBleConnectMaster {
    void cancelConnecting();

    void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse);

    void destroy();

    void disconnect();

    void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse);

    void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse);

    void write(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeBatchNoRsp(UUID uuid, UUID uuid2, List<byte[]> list, BleWriteNoRespResponse bleWriteNoRespResponse);

    void writeNoRsp(UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse);

    void writeNoRspAtOnce(UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse);
}
