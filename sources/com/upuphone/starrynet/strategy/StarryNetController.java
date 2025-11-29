package com.upuphone.starrynet.strategy;

import android.content.Context;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.strategy.bean.IDetailInfo;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.IStarryDeviceCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.operater.StarryNetOperator;
import java.util.ArrayList;
import java.util.List;

public class StarryNetController {
    private static final String TAG = "StarryNetController";

    public interface IStarryNetInitCallback {
        void onInit();
    }

    private StarryNetController() {
    }

    public static List<StDevice> getBondDevices() {
        ArrayList arrayList = new ArrayList();
        for (StConnectDevice next : StarryDeviceManager.getInstance().getBondedInfo()) {
            if (next != null) {
                arrayList.add(next.getDevice());
            }
        }
        ReLog.v(TAG, "getBondDevices list size = " + arrayList.size());
        return arrayList;
    }

    public static IDetailInfo getConnectDeviceDetailInfo(byte[] bArr) {
        return StarryDeviceManager.getInstance().getConnectDevice(bArr);
    }

    public static IStarryNetConnector getConnectManager() {
        return StarryNetData.getInstance().getConnectManager();
    }

    public static List<StDevice> getConnectedDevices(int i) {
        List<StConnectDevice> connectedDevices = StarryDeviceManager.getInstance().getConnectedDevices();
        ArrayList arrayList = new ArrayList();
        for (StConnectDevice next : connectedDevices) {
            if (i == -1) {
                arrayList.add(next.getDevice());
            } else if (i == 512) {
                if (next.getDevice().isBrEdrConnected()) {
                    arrayList.add(next.getDevice());
                }
            } else if (i == 1 && next.getDevice().isBleConnected()) {
                arrayList.add(next.getDevice());
            }
        }
        StLog.d(TAG, "getConnectedDevices list size = " + arrayList.size());
        return arrayList;
    }

    public static IDetailInfo getDisDeviceDetail(byte[] bArr) {
        return StarryDeviceManager.getInstance().getDiscoveryDevice(bArr);
    }

    public static IStarryNetDiscoverer getDiscoveryManager() {
        return StarryNetData.getInstance().getDiscoveryManager();
    }

    public static StarryNetOperator getOperateManager() {
        return StarryNetData.getInstance().getOperateManager();
    }

    public static StDevice getOwnerDevice() {
        return StarryNetData.getInstance().getOwnDevice();
    }

    public static StDevice getStDevice(byte[] bArr) {
        return StarryDeviceManager.getInstance().getDevice(bArr);
    }

    public static void init(Context context, final IStarryNetInitCallback iStarryNetInitCallback) {
        StarryNetData.getInstance().init(context);
        BluetoothContextManager.setContext(context, false);
        SysActionManager.getInstance().init(context);
        initStTracker(context);
        StarryDeviceManager.getInstance().init(new IStarryDeviceCallback() {
            public void onLoadFinish() {
                StLog.d(StarryNetController.TAG, "Bond data load finish");
                IStarryNetInitCallback iStarryNetInitCallback = IStarryNetInitCallback.this;
                if (iStarryNetInitCallback != null) {
                    iStarryNetInitCallback.onInit();
                }
            }
        });
    }

    private static void initStTracker(Context context) {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        TrackerManager.getInstance().init(context, ownDevice.getTerminalType(), ownDevice.getIdentifier2String());
    }

    public static void init(Context context, byte b, final IStarryNetInitCallback iStarryNetInitCallback) {
        StarryNetData.getInstance().init(context, b);
        SysActionManager.getInstance().init(context.getApplicationContext());
        BluetoothContextManager.setContext(context, false);
        initStTracker(context);
        StarryDeviceManager.getInstance().init(new IStarryDeviceCallback() {
            public void onLoadFinish() {
                StLog.d(StarryNetController.TAG, "Bond data load finish");
                IStarryNetInitCallback iStarryNetInitCallback = IStarryNetInitCallback.this;
                if (iStarryNetInitCallback != null) {
                    iStarryNetInitCallback.onInit();
                }
            }
        });
    }
}
