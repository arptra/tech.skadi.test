package top.zibin.luban.io;

import android.content.ContentResolver;
import android.net.Uri;
import com.here.posclient.PositionEstimate;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayPoolProvide {
    public static ArrayPoolProvide d;

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f3586a = new HashSet();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final LruArrayPool c = new LruArrayPool(PositionEstimate.Value.WLAN_AP_TIMESTAMPS);

    public static void b(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static ArrayPoolProvide d() {
        if (d == null) {
            synchronized (ArrayPoolProvide.class) {
                try {
                    if (d == null) {
                        d = new ArrayPoolProvide();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public void a() {
        Iterator it = this.f3586a.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            b((BufferedInputStreamWrap) this.b.get(str));
            this.b.remove(str);
        }
        this.f3586a.clear();
        this.c.a();
    }

    public byte[] c(int i) {
        return (byte[]) this.c.e(i, byte[].class);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return h(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        return r3.openInputStream(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream e(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r2 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r2.b     // Catch:{ Exception -> 0x0017 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0017 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0017 }
            top.zibin.luban.io.BufferedInputStreamWrap r0 = (top.zibin.luban.io.BufferedInputStreamWrap) r0     // Catch:{ Exception -> 0x0017 }
            if (r0 == 0) goto L_0x0012
            r0.reset()     // Catch:{ Exception -> 0x0017 }
            goto L_0x0024
        L_0x0012:
            top.zibin.luban.io.BufferedInputStreamWrap r0 = r2.h(r3, r4)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0024
        L_0x0017:
            java.io.InputStream r2 = r3.openInputStream(r4)     // Catch:{ Exception -> 0x001c }
            return r2
        L_0x001c:
            r0 = move-exception
            r0.printStackTrace()
            top.zibin.luban.io.BufferedInputStreamWrap r0 = r2.h(r3, r4)
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.io.ArrayPoolProvide.e(android.content.ContentResolver, android.net.Uri):java.io.InputStream");
    }

    public InputStream f(String str) {
        try {
            BufferedInputStreamWrap bufferedInputStreamWrap = (BufferedInputStreamWrap) this.b.get(str);
            if (bufferedInputStreamWrap == null) {
                return i(str);
            }
            bufferedInputStreamWrap.reset();
            return bufferedInputStreamWrap;
        } catch (Exception unused) {
            return i(str);
        }
    }

    public void g(byte[] bArr) {
        this.c.n(bArr);
    }

    public final BufferedInputStreamWrap h(ContentResolver contentResolver, Uri uri) {
        BufferedInputStreamWrap bufferedInputStreamWrap = null;
        try {
            BufferedInputStreamWrap bufferedInputStreamWrap2 = new BufferedInputStreamWrap(contentResolver.openInputStream(uri));
            try {
                int available = bufferedInputStreamWrap2.available();
                if (available <= 0) {
                    available = PositionEstimate.Value.ACTIVITY;
                }
                bufferedInputStreamWrap2.mark(available);
                this.b.put(uri.toString(), bufferedInputStreamWrap2);
                this.f3586a.add(uri.toString());
                return bufferedInputStreamWrap2;
            } catch (Exception e) {
                e = e;
                bufferedInputStreamWrap = bufferedInputStreamWrap2;
                e.printStackTrace();
                return bufferedInputStreamWrap;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return bufferedInputStreamWrap;
        }
    }

    public final BufferedInputStreamWrap i(String str) {
        BufferedInputStreamWrap bufferedInputStreamWrap = null;
        try {
            BufferedInputStreamWrap bufferedInputStreamWrap2 = new BufferedInputStreamWrap(new FileInputStream(str));
            try {
                int available = bufferedInputStreamWrap2.available();
                if (available <= 0) {
                    available = PositionEstimate.Value.ACTIVITY;
                }
                bufferedInputStreamWrap2.mark(available);
                this.b.put(str, bufferedInputStreamWrap2);
                this.f3586a.add(str);
                return bufferedInputStreamWrap2;
            } catch (Exception e) {
                e = e;
                bufferedInputStreamWrap = bufferedInputStreamWrap2;
                e.printStackTrace();
                return bufferedInputStreamWrap;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return bufferedInputStreamWrap;
        }
    }
}
