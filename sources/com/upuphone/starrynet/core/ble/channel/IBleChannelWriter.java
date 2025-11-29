package com.upuphone.starrynet.core.ble.channel;

import android.os.Bundle;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;

public interface IBleChannelWriter {
    void write(byte[] bArr, int i, BleResponse<Bundle> bleResponse);

    void writeWithOpCode(int i, byte[] bArr, int i2, BleResponse<Bundle> bleResponse);
}
