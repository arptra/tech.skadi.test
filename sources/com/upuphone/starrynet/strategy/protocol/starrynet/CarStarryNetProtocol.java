package com.upuphone.starrynet.strategy.protocol.starrynet;

import android.os.Handler;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.config.CarConfigs;

public class CarStarryNetProtocol extends StarryNetProtocol {
    private static final String TAG = "CarStarryNetProtocol";

    public CarStarryNetProtocol() {
        StLog.d(TAG, TAG);
    }

    public int getProtocolConnectVersion() {
        return CarConfigs.SUPPORT_CONNECTION_PROTOCOL_V3_CARS_LIST.contains(StarryNetData.getInstance().getOwnDevice().getModelName()) ? 3 : 2;
    }

    public boolean onHandleMessage(Message message) {
        if (message.what != 4) {
            return super.onHandleMessage(message);
        }
        StDevice stDevice = (StDevice) message.obj;
        if (stDevice == null) {
            return true;
        }
        if (StarryNetController.getConnectManager().getDeviceConnectable(stDevice) == 102000) {
            this.mCreateBondWaitRetry = 20;
            createBond(stDevice);
            return true;
        }
        int i = this.mCreateBondWaitRetry - 1;
        this.mCreateBondWaitRetry = i;
        if (i >= 0) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(Message.obtain(handler, 4, stDevice), 200);
        } else {
            this.mCreateBondWaitRetry = 20;
            cancelAuth(stDevice);
        }
        return true;
    }
}
