package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.upuphone.runasone.share.lib.TransferHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int f9526a;
    protected long b;
    protected long c;
    private int d;
    private int e;
    private final Context f;
    private final int g;
    private final byte[] h;
    private final aa i;
    private final ac j;
    private final af k;
    private final ai l;
    private final int m;
    private final ah n;
    private final ah o;
    private String p;
    private final String q;
    private final Map<String, String> r;
    private boolean s;

    public aj(Context context, int i2, int i3, byte[] bArr, String str, String str2, ah ahVar, boolean z) {
        this(context, i2, i3, bArr, str, str2, ahVar, 2, TransferHandler.TIMEOUT, z);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j2) {
        this.c += j2;
    }

    public final void run() {
        String str;
        boolean z;
        Pair pair;
        ac acVar;
        try {
            this.f9526a = 0;
            this.b = 0;
            this.c = 0;
            if (ab.c(this.f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.h;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        if (!(this.f == null || this.i == null || (acVar = this.j) == null)) {
                            if (this.k != null) {
                                str = acVar.c() == null ? "illegal local strategy" : null;
                            }
                        }
                        str = "illegal access error";
                    }
                }
                str = "request package is empty!";
            }
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] a2 = ap.a(this.h);
            if (a2 == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap hashMap = new HashMap(10);
            hashMap.put("tls", "1");
            hashMap.put("prodId", this.i.e());
            hashMap.put("bundleId", this.i.c);
            hashMap.put("appVer", this.i.o);
            Map<String, String> map = this.r;
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("cmd", Integer.toString(this.g));
            hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
            hashMap.put("sdkVer", this.i.h);
            hashMap.put("strategylastUpdateTime", Long.toString(this.j.c().o));
            this.l.a(this.m, System.currentTimeMillis());
            String str2 = this.p;
            this.j.c();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i2 < this.d) {
                    if (i4 > 1) {
                        al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i4));
                        ap.b((long) this.e);
                        if (i4 == this.d) {
                            al.d("[Upload] Use the back-up url at the last time: %s", this.q);
                            str2 = this.q;
                        }
                    }
                    al.c("[Upload] Send %d bytes", Integer.valueOf(a2.length));
                    str2 = b(str2);
                    al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str2, Integer.valueOf(this.g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a3 = this.k.a(str2, a2, this, (Map<String, String>) hashMap);
                    Map<String, String> map2 = this.k.c;
                    Pair<Boolean, Boolean> a4 = a(a3, map2);
                    if (!((Boolean) a4.first).booleanValue()) {
                        z = ((Boolean) a4.second).booleanValue();
                    } else {
                        Pair<Boolean, Boolean> a5 = a(map2);
                        if (!((Boolean) a5.first).booleanValue()) {
                            z = ((Boolean) a5.second).booleanValue();
                        } else {
                            byte[] b2 = ap.b(a3);
                            if (b2 != null) {
                                a3 = b2;
                            }
                            br a6 = ae.a(a3);
                            if (a6 == null) {
                                a(false, 1, "failed to decode response package");
                                Boolean bool = Boolean.FALSE;
                                pair = new Pair(bool, bool);
                            } else {
                                Integer valueOf = Integer.valueOf(a6.b);
                                byte[] bArr2 = a6.c;
                                al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", valueOf, Integer.valueOf(bArr2 == null ? 0 : bArr2.length));
                                if (!a(a6, this.i, this.j)) {
                                    a(false, 2, "failed to process response package");
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                } else {
                                    a(true, 2, "successfully uploaded");
                                    Boolean bool3 = Boolean.TRUE;
                                    pair = new Pair(bool3, bool3);
                                }
                            }
                            z = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                        }
                    }
                    if (z) {
                        i3 = 1;
                        i2 = i4;
                    } else {
                        return;
                    }
                } else {
                    a(false, i3, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public aj(Context context, int i2, int i3, byte[] bArr, String str, String str2, ah ahVar, int i4, int i5, boolean z) {
        this.d = 2;
        this.e = TransferHandler.TIMEOUT;
        this.p = null;
        this.f9526a = 0;
        this.b = 0;
        this.c = 0;
        this.s = false;
        this.f = context;
        this.i = aa.a(context);
        this.h = bArr;
        this.j = ac.a();
        if (af.f9517a == null) {
            af.f9517a = new af(context);
        }
        this.k = af.f9517a;
        ai a2 = ai.a();
        this.l = a2;
        this.m = i2;
        this.p = str;
        this.q = str2;
        this.n = ahVar;
        this.o = a2.f9523a;
        this.g = i3;
        if (i4 > 0) {
            this.d = i4;
        }
        if (i5 > 0) {
            this.e = i5;
        }
        this.s = z;
        this.r = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.g
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L_0x001a
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L_0x0017
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L_0x001a
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L_0x0017
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x001c
        L_0x0017:
            java.lang.String r0 = "userinfo"
            goto L_0x001c
        L_0x001a:
            java.lang.String r0 = "crash"
        L_0x001c:
            if (r5 == 0) goto L_0x0028
            java.lang.String r6 = "[Upload] Success: %s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r0)
            goto L_0x0035
        L_0x0028:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r0, r7}
            java.lang.String r0 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.al.e(r0, r6)
        L_0x0035:
            long r0 = r4.b
            long r2 = r4.c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0055
            com.tencent.bugly.proguard.ai r6 = r4.l
            boolean r0 = r4.s
            long r0 = r6.a((boolean) r0)
            long r2 = r4.b
            long r0 = r0 + r2
            long r2 = r4.c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.l
            boolean r2 = r4.s
            r6.a((long) r0, (boolean) r2)
        L_0x0055:
            com.tencent.bugly.proguard.ah r6 = r4.n
            if (r6 == 0) goto L_0x005c
            r6.a(r5, r7)
        L_0x005c:
            com.tencent.bugly.proguard.ah r4 = r4.o
            if (r4 == 0) goto L_0x0063
            r4.a(r5, r7)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", new Object[]{str, UUID.randomUUID().toString()});
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = brVar.f9573a;
        if (b2 != 0) {
            al.e("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!ap.b(brVar.g) && !aa.b().i().equals(brVar.g)) {
                w.a().a(ac.f9515a, "device", brVar.g.getBytes("UTF-8"), true);
                aaVar.d(brVar.g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.m = brVar.e;
        int i2 = brVar.b;
        if (i2 == 510) {
            byte[] bArr = brVar.c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", next.getKey(), next.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j2) {
        this.f9526a++;
        this.b += j2;
    }

    private Pair<Boolean, Boolean> a(Map<String, String> map) {
        int i2;
        if (map == null || map.size() == 0) {
            al.d("[Upload] Headers is empty.", new Object[0]);
        } else if (!map.containsKey("status")) {
            al.d("[Upload] Headers does not contain %s", "status");
        } else if (!map.containsKey("Bugly-Version")) {
            al.d("[Upload] Headers does not contain %s", "Bugly-Version");
        } else {
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                al.d("[Upload] Bugly version is not valid: %s", str);
            } else {
                al.c("[Upload] Bugly version from headers is: %s", str);
                try {
                    i2 = Integer.parseInt(map.get("status"));
                    try {
                        al.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (i2 != 0) {
                            a(false, 1, "status of server is ".concat(String.valueOf(i2)));
                            Boolean bool = Boolean.FALSE;
                            return new Pair<>(bool, bool);
                        }
                        Boolean bool2 = Boolean.TRUE;
                        return new Pair<>(bool2, bool2);
                    } catch (Throwable unused) {
                        a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i2));
                        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                    }
                } catch (Throwable unused2) {
                    i2 = -1;
                    a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i2));
                    return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                }
            }
        }
        al.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        a("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                al.c(String.format("[key]: %s, [value]: %s", new Object[]{next.getKey(), next.getValue()}), new Object[0]);
            }
        }
        al.c("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }
}
