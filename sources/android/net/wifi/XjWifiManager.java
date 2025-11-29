package android.net.wifi;

import android.os.RemoteException;

public class XjWifiManager {

    /* renamed from: a  reason: collision with root package name */
    public IXjWifiManager f85a;

    public void a(String str) {
        try {
            this.f85a.setStaticIp(str);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
