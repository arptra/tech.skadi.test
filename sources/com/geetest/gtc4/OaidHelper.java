package com.geetest.gtc4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.concurrent.CountDownLatch;

public class OaidHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final e f2889a;

    public static class a extends j {
        public a() {
            super("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService", "com.asus.msa.action.ACCESS_DID", IDidAidlInterface.Stub.DESCRIPTOR);
        }
    }

    public static class b extends j {
        public b() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", (String) null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }
    }

    public static class c extends j {
        public c() {
            super("com.huawei.hwid", (String) null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    public static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f2890a;
        public final String b;

        public d(IBinder iBinder, String str) {
            this.f2890a = iBinder;
            this.b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0.recycle();
            r1.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            return "";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7) {
            /*
                r3 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = r3.b     // Catch:{ all -> 0x0036 }
                r0.writeInterfaceToken(r2)     // Catch:{ all -> 0x0036 }
                boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0036 }
                if (r2 != 0) goto L_0x0016
                r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            L_0x0016:
                boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0036 }
                if (r4 != 0) goto L_0x001f
                r0.writeString(r5)     // Catch:{ all -> 0x0036 }
            L_0x001f:
                boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0036 }
                if (r4 != 0) goto L_0x0028
                r0.writeString(r6)     // Catch:{ all -> 0x0036 }
            L_0x0028:
                android.os.IBinder r3 = r3.f2890a     // Catch:{ all -> 0x0036 }
                r4 = 0
                r3.transact(r7, r0, r1, r4)     // Catch:{ all -> 0x0036 }
                r1.readException()     // Catch:{ all -> 0x0036 }
                java.lang.String r3 = r1.readString()     // Catch:{ all -> 0x0036 }
                goto L_0x003e
            L_0x0036:
                r0.recycle()     // Catch:{ Exception -> 0x003c }
                r1.recycle()     // Catch:{ Exception -> 0x003c }
            L_0x003c:
                java.lang.String r3 = ""
            L_0x003e:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.gtc4.OaidHelper.d.a(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
        }

        public final IBinder asBinder() {
            return this.f2890a;
        }
    }

    public interface e {
    }

    public static class f extends j {
        public f() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", (String) null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    public static class g extends h {
        public g() {
            super("com.meizu.flyme.openidsdk", "");
        }
    }

    public static class h implements e {

        /* renamed from: a  reason: collision with root package name */
        public final String f2891a;
        public final String b;
        public boolean c = false;

        public h(String str, String str2) {
            this.f2891a = str;
            this.b = str2;
        }
    }

    public static class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public d f2892a;
        public final CountDownLatch b;
        public IBinder c;

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c = iBinder;
                this.b.countDown();
            } catch (Throwable unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f2892a = null;
            this.c = null;
        }
    }

    public static class j implements e {
        public static final CountDownLatch e = new CountDownLatch(1);

        /* renamed from: a  reason: collision with root package name */
        public final String f2893a;
        public final String b;
        public final String c;
        public final String d;

        public j(String str, String str2, String str3, String str4) {
            this.f2893a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }
    }

    public static class k extends j {
        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }
    }

    public static class l extends j {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", (String) null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    public static class m extends h {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class n implements e {

        /* renamed from: a  reason: collision with root package name */
        public Class f2894a = null;
    }

    static {
        e eVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        upperCase.hashCode();
        char c2 = 65535;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    c2 = 3;
                    break;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    c2 = 4;
                    break;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2432928:
                if (upperCase.equals(StarryNetConstant.DEVICE_NAME_OPPO)) {
                    c2 = 8;
                    break;
                }
                break;
            case 2634924:
                if (upperCase.equals("VIVO")) {
                    c2 = 9;
                    break;
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    c2 = 10;
                    break;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    c2 = 11;
                    break;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
                eVar = new f();
                break;
            case 1:
                eVar = new l();
                break;
            case 2:
            case 3:
            case 12:
                eVar = new n();
                break;
            case 4:
            case 8:
                eVar = new k();
                break;
            case 6:
                eVar = new a();
                break;
            case 7:
            case 9:
                eVar = new m();
                break;
            case 10:
            case 14:
            case 15:
                eVar = new c();
                break;
            case 11:
                eVar = new g();
                break;
            case 13:
                eVar = new b();
                break;
            default:
                eVar = null;
                break;
        }
        f2889a = eVar;
    }
}
