package com.upuphone.xr.interconnect.api;

import android.app.usage.StorageStatsManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.cast.CastConst;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.XrSdkDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StarryNetDeviceInfoManagerImpl implements StarryNetDeviceInfoManager {
    private static final long MIN_UPDATE_INTERVAL = 600000;
    private static final String TAG = "StarryNetDeviceInfoManagerImpl";
    /* access modifiers changed from: private */
    public StarryNetDeviceInfo mDeviceInfo;
    /* access modifiers changed from: private */
    public boolean mIsUpdating;
    /* access modifiers changed from: private */
    public long mLastGetTime;
    private final MessageHandler mRequestUpdateHandler = new MessageHandler() {
        public int getHandleType() {
            return 5;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            ULog.i(StarryNetDeviceInfoManagerImpl.TAG, "request device info");
            StarryNetDeviceInfoManagerImpl.this.sendResult(StarryNetDeviceInfoManagerImpl.this.createDeviceInfo());
        }
    };
    private final MessageHandler mResponseHandler = new MessageHandler() {
        public int getHandleType() {
            return 6;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            ULog.i(StarryNetDeviceInfoManagerImpl.TAG, "receive device info");
            StarryNetDeviceInfoManagerImpl.this.mIsUpdating = false;
            StarryNetDeviceInfo starryNetDeviceInfo = (StarryNetDeviceInfo) function.parseData(StarryNetDeviceInfo.class);
            StarryNetDevice connectedDeviceWrapper = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper();
            if (connectedDeviceWrapper != null) {
                starryNetDeviceInfo.setDeviceName(connectedDeviceWrapper.getDeviceName());
            }
            StarryNetDeviceInfoManagerImpl.this.onReceiveResult(starryNetDeviceInfo);
            StarryNetDeviceInfoManagerImpl.this.mDeviceInfo = starryNetDeviceInfo;
            StarryNetDeviceInfoManagerImpl.this.mLastGetTime = SystemClock.elapsedRealtime();
        }
    };
    private final List<StarryNetDeviceInfoManager.DeviceInfoCallback> pendingCallback = new ArrayList();

    /* access modifiers changed from: private */
    public StarryNetDeviceInfo createDeviceInfo() {
        StarryNetDeviceInfo starryNetDeviceInfo = new StarryNetDeviceInfo();
        starryNetDeviceInfo.setMacAddress(XrSdkDeviceUtil.getMacAddress());
        starryNetDeviceInfo.setBuildNumber(Build.VERSION.RELEASE);
        starryNetDeviceInfo.setBluetoothAddress(XrSdkDeviceUtil.getBluetoothAddress());
        starryNetDeviceInfo.setModel(Build.MODEL);
        starryNetDeviceInfo.setBuildNumber(Build.DISPLAY);
        starryNetDeviceInfo.setSerialNumber(Build.getSerial());
        Pair<Long, Long> storageInfo = getStorageInfo();
        starryNetDeviceInfo.setTotalStorageSize(((Long) storageInfo.first).longValue());
        starryNetDeviceInfo.setFreeStorageSize(((Long) storageInfo.second).longValue());
        return starryNetDeviceInfo;
    }

    @RequiresApi
    private Pair<Long, Long> getStorageInfo() {
        try {
            StorageStatsManager storageStatsManager = (StorageStatsManager) InterconnectManager.getInstance().getContext().getSystemService(StorageStatsManager.class);
            UUID uuid = StorageManager.UUID_DEFAULT;
            return new Pair<>(Long.valueOf(storageStatsManager.getTotalBytes(uuid)), Long.valueOf(storageStatsManager.getFreeBytes(uuid)));
        } catch (Exception e) {
            ILog.w(CastConst.TAG, "Failed getting storage info: " + e.getLocalizedMessage() + "!");
            return new Pair<>(0L, 0L);
        }
    }

    /* access modifiers changed from: private */
    public void onReceiveResult(StarryNetDeviceInfo starryNetDeviceInfo) {
        for (StarryNetDeviceInfoManager.DeviceInfoCallback onReceiveDeviceInfo : this.pendingCallback) {
            onReceiveDeviceInfo.onReceiveDeviceInfo(starryNetDeviceInfo);
        }
        this.pendingCallback.clear();
    }

    private void requestUpdate() {
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(5, "").toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new IMessageSendListener() {
            public IBinder asBinder() {
                return null;
            }

            public void onFail(String str, int i) throws RemoteException {
                StarryNetDeviceInfoManagerImpl.this.mIsUpdating = false;
                StarryNetDeviceInfoManagerImpl.this.onReceiveResult((StarryNetDeviceInfo) null);
            }

            public void onSuccess(String str) throws RemoteException {
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendResult(StarryNetDeviceInfo starryNetDeviceInfo) {
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(6, starryNetDeviceInfo).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
    }

    private boolean shouldUpdateDeviceInfo() {
        return SystemClock.elapsedRealtime() - this.mLastGetTime > MIN_UPDATE_INTERVAL || this.mDeviceInfo == null;
    }

    public void clear() {
        this.mDeviceInfo = null;
    }

    public StarryNetDevice getBondedDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedDevice();
    }

    public StarryNetDevice getBondedGlassStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedGlassStarryNetDevice();
    }

    public StarryNetDevice getBondedRingStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getBondedStarryNetDeviceList() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedStarryNetDeviceList();
    }

    public String getConnectedDeviceType() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceType();
    }

    public StarryNetDevice getConnectedGlassStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedGlassStarryNetDevice();
    }

    public StarryNetDevice getConnectedRingStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getConnectedStarryNetDeviceList() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedStarryNetDeviceList();
    }

    public void getDeviceInfo(StarryNetDeviceInfoManager.DeviceInfoCallback deviceInfoCallback) {
        if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() == null) {
            deviceInfoCallback.onReceiveDeviceInfo((StarryNetDeviceInfo) null);
        } else if (this.mIsUpdating) {
            this.pendingCallback.add(deviceInfoCallback);
        } else if (shouldUpdateDeviceInfo()) {
            this.pendingCallback.add(deviceInfoCallback);
            this.mDeviceInfo = null;
            requestUpdate();
        } else {
            this.mDeviceInfo.setDeviceName(InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper().getDeviceName());
            deviceInfoCallback.onReceiveDeviceInfo(this.mDeviceInfo);
        }
    }

    public MessageHandler getRequestUpdateHandler() {
        return this.mRequestUpdateHandler;
    }

    public MessageHandler getResponseHandler() {
        return this.mResponseHandler;
    }

    public boolean isAir() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
    }

    public boolean isAirPro() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();
    }
}
