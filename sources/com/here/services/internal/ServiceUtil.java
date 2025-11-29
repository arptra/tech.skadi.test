package com.here.services.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.config.OdnpConfigStatic;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpContext;
import com.here.services.internal.IServiceNotAvailable;

public class ServiceUtil {
    private static final String EXTRA_SERVICE_IS_MULTIUSER = "serviceIsMultiuser";
    private static final int OEM_BIND_FLAGS = 0;
    private static final int SDK_BIND_FLAGS = 1;
    private static final String TAG = "services.internal.ServiceUtil";
    private static final IServiceNotAvailable.Stub mServiceNotAvailableStub = new IServiceNotAvailable.Stub() {
    };

    public static class ServiceInfo {
        private final Context mContext;
        private final int mFlags;
        private final Intent mIntent;
        private final boolean mMultiUser;

        public ServiceInfo(Context context, Intent intent, int i, boolean z) {
            this.mContext = context;
            this.mIntent = intent;
            this.mFlags = i;
            this.mMultiUser = z;
        }

        public boolean bind(ServiceConnection serviceConnection) {
            return OdnpContext.bindService(this.mContext, this.mIntent, serviceConnection, this.mFlags, this.mMultiUser);
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public boolean isMultiUser() {
            return this.mMultiUser;
        }

        public void putExtras(Bundle bundle) {
            Intent intent;
            if (bundle != null && (intent = this.mIntent) != null) {
                intent.putExtras(bundle);
            }
        }
    }

    public static boolean bindLocationService(Context context, ServiceConnection serviceConnection, Bundle bundle) throws ServiceNotFoundException {
        if (serviceConnection != null) {
            ServiceInfo serviceInfo = getServiceInfo(context);
            if (serviceInfo != null) {
                serviceInfo.putExtras(bundle);
                return serviceInfo.bind(serviceConnection);
            }
            throw new ServiceNotFoundException("service not found");
        }
        throw new IllegalArgumentException("connection is null");
    }

    private static ServiceInfo getOemServiceInfo(Context context) {
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static ServiceInfo getSdkServiceInfo(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, OdnpConfigStatic.SDK_SERVICE_CLASS_NAME), 0) != null) {
                Log.i(TAG, "getSdkServiceInfo: Using SDK service", new Object[0]);
                int i = LocationService.$r8$clinit;
                Intent intent = new Intent(context, LocationService.class);
                intent.setAction(IBoundService.ACTION_BIND_CONTROLLER);
                return new ServiceInfo(context, intent, 1, false);
            }
            throw new Exception("getSdkServiceInfo: getServiceInfo returned null");
        } catch (Exception unused) {
            Log.i(TAG, "getSdkServiceInfo: SDK service not available: %s", OdnpConfigStatic.SDK_SERVICE_CLASS_NAME);
            return null;
        }
    }

    public static ServiceInfo getServiceInfo(Context context) throws ServiceNotFoundException {
        if (context != null) {
            ServiceInfo sdkServiceInfo = getSdkServiceInfo(context);
            if (sdkServiceInfo != null) {
                return sdkServiceInfo;
            }
            throw new ServiceNotFoundException("service not found");
        }
        throw new IllegalArgumentException("context is null");
    }

    private static boolean isServiceMultiUser(android.content.pm.ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            return serviceInfo.metaData.getBoolean(EXTRA_SERVICE_IS_MULTIUSER);
        }
        return false;
    }

    public static boolean isServiceNotAvailableBinder(IBinder iBinder) {
        if (iBinder == null) {
            return false;
        }
        try {
            return mServiceNotAvailableStub.getInterfaceDescriptor().equals(iBinder.getInterfaceDescriptor());
        } catch (RemoteException unused) {
        }
    }
}
