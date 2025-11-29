package XI.K0.XI;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface XI extends IInterface {

    public class K0 {
        public ServiceConnection CA = new C0001XI();
        public String K0 = null;

        /* renamed from: XI  reason: collision with root package name */
        public XI f46XI = null;
        public String kM = null;
        public final Object xo = new Object();

        /* renamed from: XI.K0.XI.XI$K0$K0  reason: collision with other inner class name */
        public static class C0000K0 {

            /* renamed from: XI  reason: collision with root package name */
            public static final K0 f47XI = new K0();
        }

        /* renamed from: XI.K0.XI.XI$K0$XI  reason: collision with other inner class name */
        public class C0001XI implements ServiceConnection {
            public C0001XI() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                XI xi;
                K0 k0 = K0.this;
                int i = C0002XI.f49XI;
                if (iBinder == null) {
                    xi = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    xi = (queryLocalInterface == null || !(queryLocalInterface instanceof XI)) ? new C0002XI.C0003XI(iBinder) : (XI) queryLocalInterface;
                }
                k0.f46XI = xi;
                synchronized (K0.this.xo) {
                    K0.this.xo.notify();
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                K0.this.f46XI = null;
            }
        }

        /* JADX INFO: finally extract failed */
        public final String K0(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.K0)) {
                this.K0 = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.kM)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.K0, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest instance = MessageDigest.getInstance("SHA1");
                        if (instance != null) {
                            byte[] digest = instance.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.kM = str2;
            }
            XI xi = this.f46XI;
            if (xi == null) {
                context.getPackageName();
                return "";
            }
            String str3 = this.K0;
            String str4 = this.kM;
            C0002XI.C0003XI xi2 = (C0002XI.C0003XI) xi;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                xi2.f50XI.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return TextUtils.isEmpty(readString) ? "" : readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0041 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.lang.String XI(android.content.Context r5, java.lang.String r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ all -> 0x000f }
                android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x000f }
                if (r0 != r1) goto L_0x0011
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L_0x000f:
                r5 = move-exception
                goto L_0x0061
            L_0x0011:
                XI.K0.XI.XI r0 = r4.f46XI     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x0057
                android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x000f }
                r0.<init>()     // Catch:{ all -> 0x000f }
                android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ all -> 0x000f }
                java.lang.String r2 = "com.heytap.openid"
                java.lang.String r3 = "com.heytap.openid.IdentifyService"
                r1.<init>(r2, r3)     // Catch:{ all -> 0x000f }
                r0.setComponent(r1)     // Catch:{ all -> 0x000f }
                java.lang.String r1 = "action.com.heytap.openid.OPEN_ID_SERVICE"
                r0.setAction(r1)     // Catch:{ all -> 0x000f }
                android.content.ServiceConnection r1 = r4.CA     // Catch:{ all -> 0x000f }
                r2 = 1
                boolean r0 = r5.bindService(r0, r1, r2)     // Catch:{ all -> 0x000f }
                if (r0 == 0) goto L_0x0045
                java.lang.Object r0 = r4.xo     // Catch:{ all -> 0x000f }
                monitor-enter(r0)     // Catch:{ all -> 0x000f }
                java.lang.Object r1 = r4.xo     // Catch:{ InterruptedException -> 0x0041 }
                r2 = 3000(0xbb8, double:1.482E-320)
                r1.wait(r2)     // Catch:{ InterruptedException -> 0x0041 }
                goto L_0x0041
            L_0x003f:
                r5 = move-exception
                goto L_0x0043
            L_0x0041:
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                goto L_0x0045
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r5     // Catch:{ all -> 0x000f }
            L_0x0045:
                XI.K0.XI.XI r0 = r4.f46XI     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x004d
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L_0x004d:
                java.lang.String r5 = r4.K0(r5, r6)     // Catch:{ RemoteException -> 0x0053 }
                monitor-exit(r4)
                return r5
            L_0x0053:
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L_0x0057:
                java.lang.String r5 = r4.K0(r5, r6)     // Catch:{ RemoteException -> 0x005d }
                monitor-exit(r4)
                return r5
            L_0x005d:
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L_0x0061:
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: XI.K0.XI.XI.K0.XI(android.content.Context, java.lang.String):java.lang.String");
        }
    }

    /* renamed from: XI.K0.XI.XI$XI  reason: collision with other inner class name */
    public static abstract class C0002XI extends Binder implements XI {

        /* renamed from: XI  reason: collision with root package name */
        public static final /* synthetic */ int f49XI = 0;

        /* renamed from: XI.K0.XI.XI$XI$XI  reason: collision with other inner class name */
        public static class C0003XI implements XI {

            /* renamed from: XI  reason: collision with root package name */
            public IBinder f50XI;

            public C0003XI(IBinder iBinder) {
                this.f50XI = iBinder;
            }

            public IBinder asBinder() {
                return this.f50XI;
            }
        }
    }
}
