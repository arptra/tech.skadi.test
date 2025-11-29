package com.upuphone.starrynet.core.dns;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.api.StConstant;

public final class NsdServiceManager implements NsdManager.RegistrationListener, NsdManager.DiscoveryListener {
    public static final int DISCOVER_SERVICES_FAILED = 2;
    public static final int DISCOVER_SERVICES_STARTED = 1;
    public static final int REGISTER_SERVICE_FAILED = 7;
    public static final int REGISTER_SERVICE_SUCCEEDED = 8;
    public static final int RESOLVE_SERVICE_FAILED = 11;
    public static final int RESOLVE_SERVICE_SUCCEEDED = 12;
    public static final int SERVICE_FOUND = 3;
    public static final int SERVICE_LOST = 4;
    public static final int STOP_DISCOVERY_FAILED = 5;
    public static final int STOP_DISCOVERY_SUCCEEDED = 6;
    public static final String TAG = "NsdServiceManager";
    public static final int UNREGISTER_SERVICE_FAILED = 9;
    public static final int UNREGISTER_SERVICE_SUCCEEDED = 10;
    private final NsdManager mNsdManager;
    /* access modifiers changed from: private */
    public final INsdServiceCallback mNsdServiceCallback;
    /* access modifiers changed from: private */
    public final NsdServiceHandler mNsdServiceHandler = new NsdServiceHandler(Looper.getMainLooper());
    private volatile String mServiceType;

    public class NsdServiceHandler extends Handler {
        public NsdServiceHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    NsdServiceManager.this.mNsdServiceCallback.onStartDiscoveryStatus((String) message.obj, 0, true);
                    return;
                case 2:
                    int i = message.arg1;
                    NsdServiceManager.this.mNsdServiceCallback.onStartDiscoveryStatus(String.valueOf(message.obj), i, false);
                    return;
                case 3:
                    NsdServiceManager.this.mNsdServiceCallback.onServiceFound((NsdServiceInfo) message.obj);
                    return;
                case 4:
                    NsdServiceManager.this.mNsdServiceCallback.onServiceLost((NsdServiceInfo) message.obj);
                    return;
                case 5:
                    int i2 = message.arg1;
                    NsdServiceManager.this.mNsdServiceCallback.onStopDiscoveryStatus(String.valueOf(message.obj), i2, false);
                    return;
                case 6:
                    NsdServiceManager.this.mNsdServiceCallback.onStopDiscoveryStatus(String.valueOf(message.obj), 0, true);
                    return;
                case 7:
                    int i3 = message.arg1;
                    NsdServiceManager.this.mNsdServiceCallback.onServiceRegisterStatus((NsdServiceInfo) message.obj, i3, false);
                    return;
                case 8:
                    NsdServiceManager.this.mNsdServiceCallback.onServiceRegisterStatus((NsdServiceInfo) message.obj, 0, true);
                    return;
                case 9:
                    int i4 = message.arg1;
                    NsdServiceManager.this.mNsdServiceCallback.onServiceUnregisterStatus((NsdServiceInfo) message.obj, i4, false);
                    return;
                case 10:
                    NsdServiceManager.this.mNsdServiceCallback.onServiceUnregisterStatus((NsdServiceInfo) message.obj, 0, false);
                    return;
                case 11:
                    int i5 = message.arg1;
                    NsdServiceManager.this.mNsdServiceCallback.onServiceResolvedStatus((NsdServiceInfo) message.obj, i5, false);
                    return;
                case 12:
                    NsdServiceManager.this.mNsdServiceCallback.onServiceResolvedStatus((NsdServiceInfo) message.obj, 0, true);
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ServiceCast"})
    public NsdServiceManager(Context context, INsdServiceCallback iNsdServiceCallback) {
        this.mNsdManager = (NsdManager) context.getSystemService("servicediscovery");
        this.mNsdServiceCallback = iNsdServiceCallback;
    }

    public void onDiscoveryStarted(String str) {
        NsdLog.LOG.debug(TAG, "onDiscoveryStarted");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(1, str));
    }

    public void onDiscoveryStopped(String str) {
        NsdLog.LOG.debug(TAG, "onDiscoveryStopped");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(6, str));
    }

    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        NsdLog.LOG.debug(TAG, "onRegistrationFailed");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(7, i, 0, nsdServiceInfo));
    }

    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceFound:%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(3, nsdServiceInfo));
    }

    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceLost:%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(4, nsdServiceInfo));
    }

    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceRegistered");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(8, nsdServiceInfo));
    }

    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceUnregistered");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(10, nsdServiceInfo));
    }

    public void onStartDiscoveryFailed(String str, int i) {
        NsdLog.LOG.warn(TAG, "onStartDiscoveryFailed");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(2, i, 0, str));
    }

    public void onStopDiscoveryFailed(String str, int i) {
        NsdLog.LOG.warn(TAG, "onStopDiscoveryFailed");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(5, i, 0, str));
    }

    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        NsdLog.LOG.debug(TAG, "onUnregistrationFailed");
        NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
        nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(9, i, 0, nsdServiceInfo));
    }

    public void registerService(String str, String str2, int i, String str3) {
        this.mServiceType = str2;
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceName(str);
        nsdServiceInfo.setServiceType(str2);
        nsdServiceInfo.setPort(i);
        nsdServiceInfo.setAttribute(StConstant.HUD_PAYLOAD_KEY, str3);
        try {
            this.mNsdManager.registerService(nsdServiceInfo, 1, this);
        } catch (Exception e) {
            e.printStackTrace();
            NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
            nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(7, -100, 0, nsdServiceInfo));
        }
        NsdLog.LOG.debug(TAG, "registerService:name=%s type=%s data=%s", str, str2, str3);
    }

    public void resolvedService(NsdServiceInfo nsdServiceInfo) {
        this.mNsdManager.resolveService(nsdServiceInfo, new NsdManager.ResolveListener() {
            public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
                NsdLog.LOG.warn(NsdServiceManager.TAG, "onResolveFailed:%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
                NsdServiceManager.this.mNsdServiceHandler.sendMessage(NsdServiceManager.this.mNsdServiceHandler.obtainMessage(11, i, 0, nsdServiceInfo));
            }

            public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                NsdLog.LOG.debug(NsdServiceManager.TAG, "onServiceResolved:%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
                NsdServiceManager.this.mNsdServiceHandler.sendMessage(NsdServiceManager.this.mNsdServiceHandler.obtainMessage(12, nsdServiceInfo));
            }
        });
        NsdLog.LOG.debug(TAG, "resolveService nsdServerInfo=%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
    }

    public void startDiscovery(String str) {
        this.mServiceType = str;
        try {
            this.mNsdManager.discoverServices(str, 1, this);
        } catch (Exception e) {
            e.printStackTrace();
            NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
            nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(2, ErrorCode.ERROR_START_DIS_EXCEPTION, 0, str));
        }
        NsdLog.LOG.debug(TAG, "startDiscovery type=%s", this.mServiceType);
    }

    public void stopDiscovery() {
        try {
            this.mNsdManager.stopServiceDiscovery(this);
        } catch (Exception e) {
            e.printStackTrace();
            NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
            nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(5, ErrorCode.ERROR_STOP_DIS_EXCEPTION, 0, this.mServiceType));
        }
        NsdLog.LOG.debug(TAG, "stopDiscovery type=%s", this.mServiceType);
    }

    public void unRegisterService() {
        try {
            this.mNsdManager.unregisterService(this);
        } catch (Exception e) {
            NsdLog.LOG.debug(TAG, "no register");
            e.printStackTrace();
            NsdServiceHandler nsdServiceHandler = this.mNsdServiceHandler;
            nsdServiceHandler.sendMessage(nsdServiceHandler.obtainMessage(9, -101, 0, (Object) null));
        }
        NsdLog.LOG.debug(TAG, "unregisterService");
    }
}
