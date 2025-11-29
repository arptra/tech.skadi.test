package com.upuphone.starrynet.core.p2p.halbinder;

import android.os.IBinder;
import android.os.ServiceManager;
import com.upuphone.starrynet.common.StLog;
import java.util.HashMap;
import java.util.Map;
import vendor.xj.hardware.wifi.supplicant.ISupplicantXj;
import vendor.xj.hardware.wifi.supplicant.ISupplicantXjStaIface;
import vendor.xj.hardware.wifi.supplicant.IXjIfaceInfo;

public class XjSupplicantStaIfaceHalAidlImpl implements IXjSupplicantStaIfaceHal {
    private static final String HAL_INSTANCE_NAME = (ISupplicantXj.DESCRIPTOR + "/default");
    private static final String TAG = "XjSupplicantStaIfaceHalAidlImpl";
    private ISupplicantXj mISupplicantXj;
    private final Map<String, ISupplicantXjStaIface> mISupplicantXjStaIfaces = new HashMap();
    private final SupplicantDeathRecipient mSupplicantXjDeathRecipient;

    public class SupplicantDeathRecipient implements IBinder.DeathRecipient {
        private SupplicantDeathRecipient() {
        }

        public void binderDied() {
            StLog.w(XjSupplicantStaIfaceHalAidlImpl.TAG, "ISupplicant binder died.");
            XjSupplicantStaIfaceHalAidlImpl.this.supplicantXjServiceDiedHandler();
        }
    }

    public XjSupplicantStaIfaceHalAidlImpl() {
        StLog.d(TAG, TAG);
        this.mSupplicantXjDeathRecipient = new SupplicantDeathRecipient();
    }

    private synchronized void fetchXjStaIface() {
        ISupplicantXj iSupplicantXj = this.mISupplicantXj;
        if (iSupplicantXj != null) {
            try {
                IXjIfaceInfo[] listXjInterfaces = iSupplicantXj.listXjInterfaces();
                if (listXjInterfaces.length == 0) {
                    StLog.e(TAG, "Got zero HIDL supplicant vendor Sta ifaces. Stopping supplicant vendor HIDL startup.");
                    return;
                }
                for (IXjIfaceInfo iXjIfaceInfo : listXjInterfaces) {
                    try {
                        this.mISupplicantXjStaIfaces.put(iXjIfaceInfo.name, this.mISupplicantXj.getXjInterface(iXjIfaceInfo));
                    } catch (Exception e) {
                        StLog.e(TAG, "fetchXjStaIface exception: " + e);
                        supplicantXjServiceDiedHandler();
                    }
                }
            } catch (Exception e2) {
                StLog.e(TAG, "ISupplicantXj.listInterfaces exception: " + e2);
                supplicantXjServiceDiedHandler();
            }
        }
    }

    private boolean getSupplicantXjInstance() {
        if (this.mISupplicantXj != null) {
            StLog.d(TAG, "getSupplicantXjInstance already get");
            return true;
        }
        ISupplicantXj supplicantXjMockable = getSupplicantXjMockable();
        this.mISupplicantXj = supplicantXjMockable;
        if (supplicantXjMockable == null) {
            StLog.e(TAG, "Unable to obtain ISupplicant binder.");
            return false;
        }
        StLog.d(TAG, "Obtained ISupplicantXj binder.");
        fetchXjStaIface();
        try {
            IBinder asBinder = this.mISupplicantXj.asBinder();
            if (asBinder == null) {
                return false;
            }
            asBinder.linkToDeath(this.mSupplicantXjDeathRecipient, 0);
            return true;
        } catch (Exception e) {
            StLog.e(TAG, "getSupplicantXjInstance Exception ", (Throwable) e);
            return false;
        }
    }

    public static boolean serviceDeclared() {
        StLog.d(TAG, "serviceDeclared.");
        return ServiceManager.isDeclared(HAL_INSTANCE_NAME);
    }

    /* access modifiers changed from: private */
    public synchronized void supplicantXjServiceDiedHandler() {
        this.mISupplicantXj = null;
        this.mISupplicantXjStaIfaces.clear();
    }

    public synchronized String doXjSupplicantCmd(String str, String str2) {
        String str3;
        str3 = "";
        ISupplicantXjStaIface iSupplicantXjStaIface = this.mISupplicantXjStaIfaces.get(str);
        if (iSupplicantXjStaIface == null) {
            StLog.e(TAG, "doXjSupplicantCmd xjStaIface is null");
            return null;
        }
        try {
            str3 = iSupplicantXjStaIface.doXJSupplicantCmd(str2);
        } catch (Exception e) {
            StLog.e(TAG, "reply error", (Throwable) e);
        }
        return str3;
    }

    public synchronized ISupplicantXj getSupplicantXjMockable() {
        try {
        } catch (Exception e) {
            StLog.e(TAG, "Unable to get ISupplicantVendor service, " + e);
            return null;
        }
        return ISupplicantXj.Stub.asInterface((IBinder) ServiceManager.class.getMethod("waitForDeclaredService", new Class[]{String.class}).invoke((Object) null, new Object[]{HAL_INSTANCE_NAME}));
    }

    public synchronized boolean initialize() {
        if (this.mISupplicantXj != null) {
            StLog.d(TAG, "Service is already initialized, skipping initialize method");
            return true;
        }
        StLog.d(TAG, "initialize");
        this.mISupplicantXjStaIfaces.clear();
        if (!getSupplicantXjInstance()) {
            return false;
        }
        return serviceDeclared();
    }
}
