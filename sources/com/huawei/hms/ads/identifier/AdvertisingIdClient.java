package com.huawei.hms.ads.identifier;

import XI.kM.XI.XI.XI.K0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.IOException;

@Keep
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    public static class XI implements Runnable {

        /* renamed from: XI  reason: collision with root package name */
        public final /* synthetic */ Context f9238XI;

        public XI(Context context) {
            this.f9238XI = context;
        }

        public final void run() {
            try {
                Info unused = AdvertisingIdClient.requestAdvertisingIdInfo(this.f9238XI);
            } catch (Throwable unused2) {
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
            String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                updateAdvertisingIdInfo(context);
                return new Info(string, Boolean.valueOf(string2).booleanValue());
            }
        } catch (Throwable unused) {
        }
        return requestAdvertisingIdInfo(context);
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) {
        Parcel obtain;
        Parcel obtain2;
        Parcel obtain3;
        Parcel obtain4;
        try {
            boolean z = false;
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            XI.kM.XI.XI.XI.XI xi = new XI.kM.XI.XI.XI.XI();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (context.bindService(intent, xi, 1)) {
                try {
                    if (!xi.f57a) {
                        xi.f57a = true;
                        IBinder iBinder = (IBinder) xi.b.take();
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                        obtain3 = Parcel.obtain();
                        obtain4 = Parcel.obtain();
                        obtain3.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        iBinder.transact(2, obtain3, obtain4, 0);
                        obtain4.readException();
                        if (obtain4.readInt() != 0) {
                            z = true;
                        }
                        obtain4.recycle();
                        obtain3.recycle();
                        Info info = new Info(readString, z);
                        try {
                            context.unbindService(xi);
                        } catch (Throwable unused) {
                        }
                        return info;
                    }
                    throw new IllegalStateException();
                } catch (InterruptedException unused2) {
                    throw new IOException("bind hms service InterruptedException");
                } catch (RemoteException unused3) {
                    try {
                        throw new IOException("bind hms service RemoteException");
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable th) {
                    obtain4.recycle();
                    obtain3.recycle();
                    throw th;
                }
            } else {
                throw new IOException("bind failed");
            }
            throw th;
        } catch (PackageManager.NameNotFoundException unused5) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        K0.f56a.execute(new XI(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z) {
        try {
            Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            return requestAdvertisingIdInfo != null && TextUtils.equals(str, requestAdvertisingIdInfo.getId()) && z == requestAdvertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable unused) {
            throw new AdIdVerifyException("Something wrong with verification, please try later.");
        }
    }
}
