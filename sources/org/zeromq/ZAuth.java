package org.zeromq;

import com.upuphone.xr.sapp.common.PermissionType;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.zeromq.ZActor;
import org.zeromq.ZCertStore;
import org.zeromq.ZMQ;
import org.zeromq.ZStar;
import org.zeromq.util.ZMetadata;
import zmq.io.mechanism.Mechanisms;

public class ZAuth implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final ZAgent f3477a;
    public final ZStar.Exit b;
    public final ZAgent c;

    public interface Auth {
        boolean a(ZMsg zMsg, boolean z);

        boolean b(ZapRequest zapRequest, boolean z);
    }

    public static class AuthActor extends ZActor.SimpleActor {

        /* renamed from: a  reason: collision with root package name */
        public final String f3478a;
        public final Properties b;
        public final Properties c;
        public final Map d;
        public final String e;
        public boolean f;
        public ZMQ.Socket g;
        public boolean h;

        /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(org.zeromq.ZMQ.Socket r3, org.zeromq.ZMQ.Socket r4, org.zeromq.ZPoller r5, int r6) {
            /*
                r2 = this;
                r4 = 1
                org.zeromq.ZAuth$ZapRequest r3 = org.zeromq.ZAuth.ZapRequest.c(r3, r4)
                r5 = 0
                if (r3 != 0) goto L_0x0009
                return r5
            L_0x0009:
                java.util.Properties r6 = r2.b
                boolean r6 = r6.isEmpty()
                if (r6 != 0) goto L_0x0043
                java.util.Properties r6 = r2.b
                java.lang.String r0 = r3.e
                boolean r6 = r6.containsKey(r0)
                if (r6 == 0) goto L_0x002f
                boolean r6 = r2.h
                if (r6 == 0) goto L_0x002c
                java.io.PrintStream r6 = java.lang.System.out
                java.lang.String r0 = r3.e
                java.lang.Object[] r0 = new java.lang.Object[]{r0}
                java.lang.String r1 = "ZAuth: Passed (whitelist) address = %s\n"
                r6.printf(r1, r0)
            L_0x002c:
                r0 = r4
                r6 = r5
                goto L_0x007b
            L_0x002f:
                boolean r6 = r2.h
                if (r6 == 0) goto L_0x0040
                java.io.PrintStream r6 = java.lang.System.out
                java.lang.String r0 = r3.e
                java.lang.Object[] r0 = new java.lang.Object[]{r0}
                java.lang.String r1 = "ZAuth: Denied (not in whitelist) address = %s\n"
                r6.printf(r1, r0)
            L_0x0040:
                r6 = r4
                r0 = r5
                goto L_0x007b
            L_0x0043:
                java.util.Properties r6 = r2.c
                boolean r6 = r6.isEmpty()
                if (r6 != 0) goto L_0x0079
                java.util.Properties r6 = r2.c
                java.lang.String r0 = r3.e
                boolean r6 = r6.containsKey(r0)
                if (r6 == 0) goto L_0x0067
                boolean r6 = r2.h
                if (r6 == 0) goto L_0x0040
                java.io.PrintStream r6 = java.lang.System.out
                java.lang.String r0 = r3.e
                java.lang.Object[] r0 = new java.lang.Object[]{r0}
                java.lang.String r1 = "ZAuth: Denied (blacklist) address = %s\n"
                r6.printf(r1, r0)
                goto L_0x0040
            L_0x0067:
                boolean r6 = r2.h
                if (r6 == 0) goto L_0x002c
                java.io.PrintStream r6 = java.lang.System.out
                java.lang.String r0 = r3.e
                java.lang.Object[] r0 = new java.lang.Object[]{r0}
                java.lang.String r1 = "ZAuth: Passed (not in blacklist) address = %s\n"
                r6.printf(r1, r0)
                goto L_0x002c
            L_0x0079:
                r6 = r5
                r0 = r6
            L_0x007b:
                if (r6 != 0) goto L_0x009d
                java.util.Map r6 = r2.d
                java.lang.String r0 = r3.g
                java.lang.Object r6 = r6.get(r0)
                org.zeromq.ZAuth$Auth r6 = (org.zeromq.ZAuth.Auth) r6
                if (r6 != 0) goto L_0x0097
                java.io.PrintStream r2 = java.lang.System.out
                java.lang.String r3 = r3.g
                java.lang.Object[] r3 = new java.lang.Object[]{r3}
                java.lang.String r4 = "ZAuth E: Skipping unhandled mechanism %s%n"
                r2.printf(r4, r3)
                return r5
            L_0x0097:
                boolean r5 = r2.h
                boolean r0 = r6.b(r3, r5)
            L_0x009d:
                boolean r5 = r2.f
                r6 = 0
                if (r5 == 0) goto L_0x00a5
                org.zeromq.ZMQ$Socket r2 = r2.g
                goto L_0x00a6
            L_0x00a5:
                r2 = r6
            L_0x00a6:
                if (r0 == 0) goto L_0x00b0
                r5 = 200(0xc8, float:2.8E-43)
                java.lang.String r6 = "OK"
                r3.d(r5, r6, r2)
                goto L_0x00b9
            L_0x00b0:
                r3.m = r6
                r5 = 400(0x190, float:5.6E-43)
                java.lang.String r6 = "NO ACCESS"
                r3.d(r5, r6, r2)
            L_0x00b9:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.zeromq.ZAuth.AuthActor.d(org.zeromq.ZMQ$Socket, org.zeromq.ZMQ$Socket, org.zeromq.ZPoller, int):boolean");
        }

        public boolean e(ZMQ.Socket socket, ZPoller zPoller, int i) {
            boolean z;
            ZMsg x = ZMsg.x(socket);
            String v = x.v();
            if (v == null) {
                System.out.printf("ZAuth: Closing auth: No command%n", new Object[0]);
                return false;
            }
            if ("ALLOW".equals(v)) {
                String v2 = x.v();
                if (this.h) {
                    System.out.printf("ZAuth: Whitelisting IP address=%s\n", new Object[]{v2});
                }
                this.b.put(v2, PermissionType.OK);
                z = socket.v(PermissionType.OK);
            } else if ("DENY".equals(v)) {
                String v3 = x.v();
                if (this.h) {
                    System.out.printf("ZAuth: Blacklisting IP address=%s\n", new Object[]{v3});
                }
                this.c.put(v3, PermissionType.OK);
                z = socket.v(PermissionType.OK);
            } else if ("VERBOSE".equals(v)) {
                this.h = Boolean.parseBoolean(x.v());
                z = socket.v(PermissionType.OK);
            } else if ("REPLIES".equals(v)) {
                boolean parseBoolean = Boolean.parseBoolean(x.v());
                this.f = parseBoolean;
                if (this.h) {
                    if (parseBoolean) {
                        System.out.println("ZAuth: Enabled replies");
                    } else {
                        System.out.println("ZAuth: Disabled replies");
                    }
                }
                z = socket.v(PermissionType.OK);
            } else if ("TERMINATE".equals(v)) {
                if (this.f) {
                    this.g.v(this.e);
                }
                if (this.h) {
                    System.out.println("ZAuth: Terminated");
                }
                socket.v(PermissionType.OK);
                return false;
            } else {
                Auth auth = (Auth) this.d.get(v);
                if (auth != null) {
                    z = auth.a(x, this.h) ? socket.v(PermissionType.OK) : socket.v("ERROR");
                } else {
                    System.out.printf("ZAuth: Invalid command %s%n", new Object[]{v});
                    z = true;
                }
            }
            x.f();
            if (!z) {
                System.out.printf("ZAuth: Command in error %s%n", new Object[]{v});
            }
            return z;
        }

        public String f(ZMQ.Socket socket) {
            return this.f3478a;
        }

        public List g(ZContext zContext, Object... objArr) {
            this.g = zContext.b(SocketType.PAIR);
            return Arrays.asList(new ZMQ.Socket[]{zContext.b(SocketType.REP), this.g});
        }

        public void j(ZMQ.Socket socket, List list, ZPoller zPoller) {
            try {
                this.g.c(this.e);
                ZMQ.Socket socket2 = (ZMQ.Socket) list.get(0);
                socket2.c("inproc://zeromq.zap.01");
                zPoller.o(socket2, 1);
                socket.v(PermissionType.OK);
            } catch (ZMQException e2) {
                System.out.println("ZAuth: Error");
                e2.printStackTrace();
                socket.v("ERROR");
            }
        }
    }

    public static class SimpleCurveAuth implements Auth {

        /* renamed from: a  reason: collision with root package name */
        public final ZCertStore.Fingerprinter f3479a;
        public ZCertStore b;
        public boolean c;

        public boolean a(ZMsg zMsg, boolean z) {
            String v = zMsg.v();
            boolean equals = v.equals("*");
            this.c = equals;
            if (!equals) {
                if (z) {
                    System.out.printf("ZAuth: Using %s as certificates directory%n", new Object[]{v});
                }
                this.b = new ZCertStore(v, this.f3479a);
                return true;
            } else if (!z) {
                return true;
            } else {
                System.out.println("ZAuth: Allowing all clients");
                return true;
            }
        }

        public boolean b(ZapRequest zapRequest, boolean z) {
            if (this.c) {
                if (z) {
                    System.out.println("ZAuth: allowed (CURVE allow any client)");
                }
                return true;
            }
            ZCertStore zCertStore = this.b;
            if (zCertStore != null) {
                if (zCertStore.d(zapRequest.j)) {
                    if (z) {
                        System.out.printf("ZAuth: Allowed (CURVE) client_key=%s\n", new Object[]{zapRequest.j});
                    }
                    String str = zapRequest.j;
                    zapRequest.l = str;
                    zapRequest.m = this.b.e(str);
                    return true;
                } else if (z) {
                    System.out.printf("ZAuth: Denied (CURVE) client_key=%s\n", new Object[]{zapRequest.j});
                }
            }
            return false;
        }
    }

    public static class SimpleNullAuth implements Auth {
        public boolean a(ZMsg zMsg, boolean z) {
            return true;
        }

        public boolean b(ZapRequest zapRequest, boolean z) {
            return true;
        }
    }

    public static class SimplePlainAuth implements Auth {

        /* renamed from: a  reason: collision with root package name */
        public final Properties f3480a;
        public File b;
        public long c;

        public boolean a(ZMsg zMsg, boolean z) {
            zMsg.v();
            File file = new File(zMsg.v());
            this.b = file;
            if (z) {
                System.out.printf("ZAuth: activated plain-mechanism with password-file: %s%n", new Object[]{file.getAbsolutePath()});
            }
            try {
                c(true);
            } catch (IOException unused) {
            }
            return true;
        }

        public boolean b(ZapRequest zapRequest, boolean z) {
            try {
                c(false);
            } catch (IOException unused) {
            }
            String property = this.f3480a.getProperty(zapRequest.h);
            if (property == null || !property.equals(zapRequest.i)) {
                if (z) {
                    System.out.printf("ZAuth: Denied (PLAIN) username=%s\n", new Object[]{zapRequest.h});
                }
                return false;
            }
            if (z) {
                System.out.printf("ZAuth: Allowed (PLAIN) username=%s\n", new Object[]{zapRequest.h});
            }
            zapRequest.l = zapRequest.h;
            return true;
        }

        public final void c(boolean z) {
            if (!z) {
                long lastModified = this.b.lastModified();
                long currentTimeMillis = System.currentTimeMillis() - lastModified;
                if (lastModified > this.c && currentTimeMillis > 1000) {
                    this.f3480a.clear();
                } else {
                    return;
                }
            }
            this.c = this.b.lastModified();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.b));
            try {
                this.f3480a.load(bufferedReader);
            } catch (IOException | IllegalArgumentException unused) {
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
            bufferedReader.close();
        }
    }

    public static class ZapReply {

        /* renamed from: a  reason: collision with root package name */
        public final String f3481a;
        public final String b;
        public final int c;
        public final String d;
        public final String e;
        public final ZMetadata f;
        public final String g;
        public final String h;

        public final ZMsg b() {
            ZMsg zMsg = new ZMsg();
            zMsg.a(this.f3481a);
            zMsg.a(this.b);
            zMsg.a(Integer.toString(this.c));
            zMsg.a(this.d);
            String str = this.e;
            if (str == null) {
                str = "";
            }
            zMsg.a(str);
            ZMetadata zMetadata = this.f;
            zMsg.c(zMetadata == null ? new byte[0] : zMetadata.a());
            return zMsg;
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            String str4;
            StringBuilder sb = new StringBuilder();
            sb.append("ZapReply [");
            String str5 = "";
            if (this.f3481a != null) {
                str = "version=" + this.f3481a + ", ";
            } else {
                str = str5;
            }
            sb.append(str);
            if (this.b != null) {
                str2 = "sequence=" + this.b + ", ";
            } else {
                str2 = str5;
            }
            sb.append(str2);
            sb.append("statusCode=");
            sb.append(this.c);
            sb.append(", ");
            if (this.d != null) {
                str3 = "statusText=" + this.d + ", ";
            } else {
                str3 = str5;
            }
            sb.append(str3);
            if (this.e != null) {
                str4 = "userId=" + this.e + ", ";
            } else {
                str4 = str5;
            }
            sb.append(str4);
            if (this.f != null) {
                str5 = "metadata=" + this.f;
            }
            sb.append(str5);
            sb.append("]");
            return sb.toString();
        }

        public ZapReply(String str, String str2, int i, String str3, String str4, ZMetadata zMetadata) {
            this(str, str2, i, str3, str4, zMetadata, (String) null, (String) null);
        }

        public ZapReply(String str, String str2, int i, String str3, String str4, ZMetadata zMetadata, String str5, String str6) {
            this.f3481a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = str4;
            this.f = zMetadata;
            this.g = str5;
            this.h = str6;
        }
    }

    public static class ZapRequest {

        /* renamed from: a  reason: collision with root package name */
        public final ZMQ.Socket f3482a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public String l;
        public ZMetadata m;

        public ZapRequest(ZMQ.Socket socket, ZMsg zMsg) {
            this.f3482a = socket;
            this.b = zMsg.v();
            this.c = zMsg.v();
            this.d = zMsg.v();
            this.e = zMsg.v();
            this.f = zMsg.v();
            String v = zMsg.v();
            this.g = v;
            if (ZMQ.Socket.Mechanism.PLAIN.name().equals(v)) {
                this.h = zMsg.v();
                this.i = zMsg.v();
                this.j = null;
                this.k = null;
            } else if (ZMQ.Socket.Mechanism.CURVE.name().equals(v)) {
                byte[] c2 = zMsg.pop().c();
                this.h = null;
                this.i = null;
                this.j = ZMQ.Curve.a(c2);
                this.k = null;
            } else if (Mechanisms.GSSAPI.name().equals(v)) {
                this.h = null;
                this.i = null;
                this.j = null;
                this.k = zMsg.v();
            } else {
                this.h = null;
                this.i = null;
                this.j = null;
                this.k = null;
            }
        }

        public static ZapRequest c(ZMQ.Socket socket, boolean z) {
            ZMsg z2 = ZMsg.z(socket, z);
            if (z2 == null) {
                return null;
            }
            ZapRequest zapRequest = new ZapRequest(socket, z2);
            z2.f();
            return zapRequest;
        }

        public final void d(int i2, String str, ZMQ.Socket socket) {
            ZMsg a2 = new ZapReply("1.0", this.c, i2, str, this.l, this.m).b();
            a2.E(this.f3482a, socket == null);
            if (socket != null) {
                a2.a(this.e);
                a2.a(this.f);
                a2.D(socket);
            }
        }
    }

    public void a() {
        b("TERMINATE", new String[0]);
        this.b.b();
        this.f3477a.close();
        this.c.close();
    }

    public ZAuth b(String str, String... strArr) {
        ZMsg zMsg = new ZMsg();
        zMsg.a(str);
        for (String a2 : strArr) {
            zMsg.a(a2);
        }
        this.f3477a.b(zMsg);
        zMsg.f();
        this.f3477a.a();
        return this;
    }

    public void close() {
        a();
    }
}
