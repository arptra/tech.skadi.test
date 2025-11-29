package com.upuphone.runasone;

import android.os.Bundle;
import com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.api.IAbility;
import com.upuphone.runasone.utils.LogUtil;
import java.util.Map;

public class CoreAbility implements IAbility {
    private final IDeviceManagerApiAdapter deviceManagerApiAdapter = new IDeviceManagerApiAdapter(DeviceManagerImpl.getInstance());
    private final String flymelinkAppPkg = "com.flyme.linkUnion";
    private final String superAppPkg = "com.upuphone.star.launcher";

    public void appStateChanged(int i, String str, String str2, int i2) {
        if (i2 == 0) {
            LogUtil.d("packageName died :  " + str + ", pid : " + i);
            DeviceManagerImpl.getInstance().stopDiscovery(String.valueOf(i));
            DeviceManagerImpl.getInstance().unRegisterDeviceStatusListener(i, (String) null, true);
            for (Map.Entry<String, StarryDevice> value : DeviceManagerImpl.getInstance().getConnectionManager().getConnectDevice().entrySet()) {
                ((StarryDevice) value.getValue()).delConnectCount(String.valueOf(i));
            }
            if ("com.upuphone.star.launcher".equals(str)) {
                DeviceManagerImpl.getInstance().setFastConnectProcess(0);
            }
            if ("com.flyme.linkUnion".equals(str)) {
                DeviceManagerImpl.getInstance().stopMultiDeviceFound(true);
                DeviceManagerImpl.getInstance().setAdvertiseEnableMode(0);
            }
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        this.deviceManagerApiAdapter.adapt(bundle, bundle2);
    }
}
