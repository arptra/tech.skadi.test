package com.here.services.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.here.odnp.config.OdnpConfigStatic;
import com.here.odnp.util.ClientLooper;
import com.here.odnp.util.Log;
import com.here.posclient.InitOptions;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.common.Types;
import com.here.services.internal.ILocationServiceController;
import com.here.services.internal.ServiceController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonServiceController {
    private static final String TAG = "services.internal.CommonServiceController";
    private boolean mAutoDisconnect;
    /* access modifiers changed from: private */
    public final HereLocationApiClient.ConnectionCallbacks mCallbacks;
    private final ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.w(CommonServiceController.TAG, "onServiceConnected", new Object[0]);
            synchronized (CommonServiceController.this) {
                ILocationServiceController unused = CommonServiceController.this.mServiceController = ILocationServiceController.Stub.asInterface(iBinder);
                CommonServiceController.this.onControllerConnected();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.w(CommonServiceController.TAG, "onServiceDisconnected", new Object[0]);
            synchronized (CommonServiceController.this) {
                try {
                    if (CommonServiceController.this.mServiceController != null) {
                        ILocationServiceController unused = CommonServiceController.this.mServiceController = null;
                        CommonServiceController.this.onControllerDisconnected();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public ILocationServiceController mServiceController;
    private final Set<Api.ServiceOptions> mServiceOptions = new HashSet();
    /* access modifiers changed from: private */
    public final Map<Api<? extends Api.Options>, ServiceController> mServices = new HashMap();

    public CommonServiceController(Context context, List<Api.ServiceOptions> list, HereLocationApiClient.ConnectionCallbacks connectionCallbacks, Map<Api<? extends Api.Options>, Api.Options> map) {
        Log.v(TAG, "CommonServiceController", new Object[0]);
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (connectionCallbacks != null) {
            this.mHandler = new Handler(ClientLooper.getLooper());
            this.mContext = context;
            this.mCallbacks = connectionCallbacks;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            for (Api.ServiceOptions next : list) {
                if (next != null) {
                    this.mServiceOptions.add(next);
                }
            }
            for (Map.Entry next2 : map.entrySet()) {
                ServiceController createController = ((Api) next2.getKey()).createController(this.mContext, (Api.Options) next2.getValue());
                if (createController != null) {
                    if (next2.getValue() instanceof Api.ServiceOptions) {
                        this.mServiceOptions.add((Api.ServiceOptions) next2.getValue());
                    }
                    this.mServices.put((Api) next2.getKey(), createController);
                }
            }
        } else {
            throw new IllegalArgumentException("callbacks is null");
        }
    }

    private static Types.Storage getRadioMapStorage(Bundle bundle) {
        Types.Storage storage = Types.Storage.Internal;
        String string = bundle.getString(InitOptions.KEY_OPTION_RADIO_MAP_STORAGE);
        if (string == null) {
            return storage;
        }
        try {
            return Types.Storage.valueOf(string);
        } catch (Exception e) {
            Log.e(TAG, "getRadioMapStorage: Erroneous storage value: '%s': %s", string, Log.getStackTraceString(e));
            return storage;
        }
    }

    private Bundle getServiceOptions() {
        Bundle bundle = new Bundle();
        for (Api.ServiceOptions next : this.mServiceOptions) {
            if (next != null) {
                next.put(this.mContext, bundle);
            }
        }
        return bundle;
    }

    /* access modifiers changed from: private */
    public synchronized void onControllerConnected() {
        if (this.mAutoDisconnect) {
            Log.e(TAG, "onControllerConnected: no service allowed without user consent", new Object[0]);
            processUserConsentStateChange(false);
            this.mHandler.post(new Runnable() {
                public void run() {
                    CommonServiceController.this.stopServiceAndDisconnect();
                    CommonServiceController.this.mCallbacks.onConnectionFailed(HereLocationApiClient.Reason.UserConsentNotGranted);
                }
            });
            return;
        }
        Log.v(TAG, "onControllerConnected", new Object[0]);
        AnonymousClass4 r0 = new ServiceController.ConnectionListener() {
            final Set<Api<? extends Api.Options>> mConnectedApis = new HashSet();
            boolean mOnConnectedCalled = false;
            final Set<Api<? extends Api.Options>> mPendingApis;

            {
                this.mPendingApis = new HashSet(CommonServiceController.this.mServices.keySet());
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void checkAndReportOnConnected() {
                /*
                    r2 = this;
                    monitor-enter(r2)
                    boolean r0 = r2.mOnConnectedCalled     // Catch:{ all -> 0x0021 }
                    if (r0 == 0) goto L_0x0007
                    monitor-exit(r2)
                    return
                L_0x0007:
                    java.util.Set<com.here.services.Api<? extends com.here.services.Api$Options>> r0 = r2.mPendingApis     // Catch:{ all -> 0x0021 }
                    boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0021 }
                    if (r0 == 0) goto L_0x0023
                    com.here.services.internal.CommonServiceController r0 = com.here.services.internal.CommonServiceController.this     // Catch:{ all -> 0x0021 }
                    android.os.Handler r0 = r0.mHandler     // Catch:{ all -> 0x0021 }
                    com.here.services.internal.CommonServiceController$4$3 r1 = new com.here.services.internal.CommonServiceController$4$3     // Catch:{ all -> 0x0021 }
                    r1.<init>()     // Catch:{ all -> 0x0021 }
                    boolean r0 = r0.post(r1)     // Catch:{ all -> 0x0021 }
                    r2.mOnConnectedCalled = r0     // Catch:{ all -> 0x0021 }
                    goto L_0x0023
                L_0x0021:
                    r0 = move-exception
                    goto L_0x0025
                L_0x0023:
                    monitor-exit(r2)
                    return
                L_0x0025:
                    monitor-exit(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.here.services.internal.CommonServiceController.AnonymousClass4.checkAndReportOnConnected():void");
            }

            public void onServiceConnected(Api<? extends Api.Options> api) {
                Log.i(CommonServiceController.TAG, "onServiceConnected: %s", api);
                this.mConnectedApis.add(api);
                this.mPendingApis.remove(api);
                checkAndReportOnConnected();
            }

            public void onServiceConnectionFailed(Api<? extends Api.Options> api) {
                Log.i(CommonServiceController.TAG, "onServiceConnectionFailed: %s", api);
                this.mPendingApis.remove(api);
                CommonServiceController.this.mCallbacks.onInitializationFailed(api);
                if (!this.mPendingApis.isEmpty() || !this.mConnectedApis.isEmpty()) {
                    checkAndReportOnConnected();
                } else {
                    CommonServiceController.this.mHandler.post(new Runnable() {
                        public void run() {
                            CommonServiceController.this.stopServiceAndDisconnect();
                        }
                    });
                }
            }

            public void onServiceDisconnect(Api<? extends Api.Options> api) {
                Log.i(CommonServiceController.TAG, "onServiceDisconnect: %s", api);
                this.mConnectedApis.remove(api);
                if (!this.mPendingApis.isEmpty() || !this.mConnectedApis.isEmpty()) {
                    checkAndReportOnConnected();
                } else {
                    CommonServiceController.this.mHandler.post(new Runnable() {
                        public void run() {
                            CommonServiceController.this.stopServiceAndDisconnect();
                        }
                    });
                }
            }
        };
        Iterator it = new ArrayList(this.mServices.values()).iterator();
        while (it.hasNext()) {
            ((ServiceController) it.next()).connect(r0);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|(2:6|4)|30|9|10|11|(2:13|14)|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|20|21|(2:23|24)|25|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0041 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0041=Splitter:B:25:0x0041, B:16:0x0034=Splitter:B:16:0x0034} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onControllerDisconnected() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0021 }
            java.util.Map<com.here.services.Api<? extends com.here.services.Api$Options>, com.here.services.internal.ServiceController> r2 = r3.mServices     // Catch:{ all -> 0x0021 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0021 }
        L_0x0011:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0021 }
            com.here.services.internal.ServiceController r2 = (com.here.services.internal.ServiceController) r2     // Catch:{ all -> 0x0021 }
            r2.disconnect()     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0021:
            r1 = move-exception
            goto L_0x0038
        L_0x0023:
            java.util.Map<com.here.services.Api<? extends com.here.services.Api$Options>, com.here.services.internal.ServiceController> r1 = r3.mServices     // Catch:{ all -> 0x0021 }
            r1.clear()     // Catch:{ all -> 0x0021 }
            boolean r1 = r3.mAutoDisconnect     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0034
            com.here.services.HereLocationApiClient$ConnectionCallbacks r1 = r3.mCallbacks     // Catch:{ Exception -> 0x0034 }
            r1.onDisconnected()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0034
        L_0x0032:
            r0 = move-exception
            goto L_0x0044
        L_0x0034:
            r3.mServiceController = r0     // Catch:{ all -> 0x0032 }
            monitor-exit(r3)
            return
        L_0x0038:
            boolean r2 = r3.mAutoDisconnect     // Catch:{ all -> 0x0032 }
            if (r2 != 0) goto L_0x0041
            com.here.services.HereLocationApiClient$ConnectionCallbacks r2 = r3.mCallbacks     // Catch:{ Exception -> 0x0041 }
            r2.onDisconnected()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r3.mServiceController = r0     // Catch:{ all -> 0x0032 }
            throw r1     // Catch:{ all -> 0x0032 }
        L_0x0044:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.internal.CommonServiceController.onControllerDisconnected():void");
    }

    private boolean processUserConsentStateChange(boolean z) {
        try {
            return this.mServiceController.updateUserConsentState(z);
        } catch (RemoteException unused) {
            return false;
        }
    }

    private boolean validatePermissions(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        boolean z = true;
        for (String str : arrayList) {
            if (this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                Log.e(TAG, "validatePermissions: Missing permission: %s", str);
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean changeServiceOptions(HereLocationApiClient.Options options) {
        if (options == null) {
            throw new IllegalArgumentException("options is null");
        } else if (!isConnected()) {
            Log.w(TAG, "changeServiceOptions: not connected, ignored", new Object[0]);
            return false;
        } else {
            try {
                Bundle bundle = new Bundle();
                options.put(this.mContext, bundle);
                return this.mServiceController.updateOptions(bundle);
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public synchronized ServiceController getServiceController(Api<? extends Api.Options> api) {
        return this.mServices.get(api);
    }

    public String getServiceVersion() {
        return OdnpConfigStatic.SW_VERSION;
    }

    public synchronized boolean isConnected() {
        return this.mServiceController != null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startServiceAndConnect() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.isConnected()     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r1 = "services.internal.CommonServiceController"
            java.lang.String r2 = "startServiceAndConnect: already connected -> ignored"
            com.here.odnp.util.Log.v(r1, r2, r0)     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)
            return
        L_0x0013:
            r0 = move-exception
            goto L_0x0082
        L_0x0015:
            java.util.Map<com.here.services.Api<? extends com.here.services.Api$Options>, com.here.services.internal.ServiceController> r0 = r4.mServices     // Catch:{ all -> 0x0013 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x002f
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r1 = "services.internal.CommonServiceController"
            java.lang.String r2 = "startServiceAndConnect: no services defined -> ServiceConfigurationError"
            com.here.odnp.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$ConnectionCallbacks r0 = r4.mCallbacks     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.ServiceConfigurationError     // Catch:{ all -> 0x0013 }
            r0.onConnectionFailed(r1)     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)
            return
        L_0x002f:
            android.os.Bundle r0 = r4.getServiceOptions()     // Catch:{ all -> 0x0013 }
            boolean r2 = r4.validatePermissions(r0)     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x004b
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r1 = "services.internal.CommonServiceController"
            java.lang.String r2 = "startServiceAndConnect: Missing permissions"
            com.here.odnp.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$ConnectionCallbacks r0 = r4.mCallbacks     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.MissingPermissions     // Catch:{ all -> 0x0013 }
            r0.onConnectionFailed(r1)     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)
            return
        L_0x004b:
            android.content.Context r2 = r4.mContext     // Catch:{ all -> 0x0013 }
            boolean r2 = com.here.services.internal.UserConsent.isGranted(r2)     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x005f
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "services.internal.CommonServiceController"
            java.lang.String r3 = "startServiceAndConnect: Missing user consent -> auto-disconnect"
            com.here.odnp.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0013 }
            r1 = 1
            r4.mAutoDisconnect = r1     // Catch:{ all -> 0x0013 }
        L_0x005f:
            android.content.Context r1 = r4.mContext     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            android.content.ServiceConnection r2 = r4.mConnection     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            boolean r0 = com.here.services.internal.ServiceUtil.bindLocationService(r1, r2, r0)     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            if (r0 != 0) goto L_0x0080
            com.here.services.HereLocationApiClient$ConnectionCallbacks r0 = r4.mCallbacks     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.ServiceInitializationError     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            r0.onConnectionFailed(r1)     // Catch:{ ServiceNotFoundException -> 0x0079, SecurityException -> 0x0071 }
            goto L_0x0080
        L_0x0071:
            com.here.services.HereLocationApiClient$ConnectionCallbacks r0 = r4.mCallbacks     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.PermissionDenied     // Catch:{ all -> 0x0013 }
            r0.onConnectionFailed(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0080
        L_0x0079:
            com.here.services.HereLocationApiClient$ConnectionCallbacks r0 = r4.mCallbacks     // Catch:{ all -> 0x0013 }
            com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.ServiceNotFound     // Catch:{ all -> 0x0013 }
            r0.onConnectionFailed(r1)     // Catch:{ all -> 0x0013 }
        L_0x0080:
            monitor-exit(r4)
            return
        L_0x0082:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.internal.CommonServiceController.startServiceAndConnect():void");
    }

    public synchronized void stopServiceAndDisconnect() {
        if (!isConnected()) {
            Log.v(TAG, "stopServiceAndDisconnect: not connected -> ignored", new Object[0]);
            return;
        }
        try {
            Log.i(TAG, "onControllerDisconnected: unbindService", new Object[0]);
            this.mContext.unbindService(this.mConnection);
            onControllerDisconnected();
        } catch (Exception unused) {
        }
    }

    public boolean updateUserConsentState(boolean z) {
        if (UserConsent.update(this.mContext, z)) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateUserConsentState: user consent has been ");
            sb.append(z ? "granted" : "revoked");
            Log.v(TAG, sb.toString(), new Object[0]);
            if (z || !isConnected()) {
                return true;
            }
            processUserConsentStateChange(z);
            this.mHandler.post(new Runnable() {
                public void run() {
                    CommonServiceController.this.stopServiceAndDisconnect();
                }
            });
            return true;
        }
        Log.v(TAG, "updateUserConsentState: user consent cannot be changed", new Object[0]);
        return false;
    }
}
