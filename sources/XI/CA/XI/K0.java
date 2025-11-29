package XI.CA.XI;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.honey.account.constant.AccountConstantKt;

public class K0 {
    public static kM CA = null;
    public static volatile XI CV = null;
    public static Handler FL = null;
    public static HandlerThread J9 = null;
    public static boolean K0 = false;
    public static String WI;

    /* renamed from: XI  reason: collision with root package name */
    public static Context f43XI;
    public static String bs;
    public static String cs;
    public static kM kM;
    public static volatile K0 q6;
    public static Object vs = new Object();
    public static kM xo;

    public static class XI extends Handler {
        public XI(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                try {
                    String XI2 = K0.CV.XI(i, message.getData().getString(AccountConstantKt.REQUEST_HEADER_APP_ID));
                    if (i == 0) {
                        K0.WI = XI2;
                    } else if (i != 1) {
                        if (i == 2) {
                            if (XI2 != null) {
                                K0.cs = XI2;
                            }
                        }
                    } else if (XI2 != null) {
                        K0.bs = XI2;
                    }
                } catch (Exception e) {
                    e.toString();
                }
                synchronized (K0.vs) {
                    K0.vs.notify();
                }
            }
        }
    }

    public K0() {
        XI();
        CV = new XI(f43XI);
    }

    public static K0 XI(Context context) {
        if (!K0()) {
            return null;
        }
        if (f43XI == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f43XI = context;
        }
        if (q6 == null) {
            synchronized (K0.class) {
                try {
                    if (q6 == null) {
                        q6 = new K0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return q6;
    }

    public void K0(int i, String str) {
        Message obtainMessage = FL.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2) {
            bundle.putString(AccountConstantKt.REQUEST_HEADER_APP_ID, str);
        }
        obtainMessage.setData(bundle);
        FL.sendMessage(obtainMessage);
    }

    public static boolean K0() {
        Class<String> cls = String.class;
        String str = "0";
        if (!K0) {
            try {
                Class<?> cls2 = Class.forName("android.os.SystemProperties");
                str = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{"persist.sys.identifierid.supported", str});
            } catch (Exception unused) {
            }
            K0 = "1".equals(str);
        }
        return K0;
    }

    public static void XI() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        J9 = handlerThread;
        handlerThread.start();
        FL = new XI(J9.getLooper());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|5|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XI(int r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.Object r0 = vs
            monitor-enter(r0)
            r1.K0(r2, r3)     // Catch:{ all -> 0x0011 }
            android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = vs     // Catch:{ InterruptedException -> 0x0013 }
            r2 = 2000(0x7d0, double:9.88E-321)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0013 }
            goto L_0x0013
        L_0x0011:
            r1 = move-exception
            goto L_0x0018
        L_0x0013:
            android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.CA.XI.K0.XI(int, java.lang.String):void");
    }

    public static synchronized void XI(Context context, int i, String str) {
        ContentResolver contentResolver;
        Uri parse;
        kM kMVar;
        synchronized (K0.class) {
            try {
                String packageName = context.getPackageName();
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            if (CA == null) {
                                CA = new kM(q6, 2, packageName);
                                contentResolver = context.getContentResolver();
                                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + packageName);
                                kMVar = CA;
                            }
                        }
                    } else if (xo == null) {
                        xo = new kM(q6, 1, packageName);
                        contentResolver = context.getContentResolver();
                        parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + packageName);
                        kMVar = xo;
                    }
                    contentResolver.registerContentObserver(parse, false, kMVar);
                } else if (kM == null) {
                    kM = new kM(q6, 0, (String) null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, kM);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
