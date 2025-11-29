package com.xingin.xhssharesdk.o;

import com.xingin.xhssharesdk.i.d;
import com.xingin.xhssharesdk.log.IShareLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static IShareLogger f8196a;
    public static volatile ExecutorService b;

    public interface a {
        void a(Exception exc);

        void onSuccess(String str);
    }

    /* renamed from: com.xingin.xhssharesdk.o.b$b  reason: collision with other inner class name */
    public interface C0032b {
        Map a();
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public final a f8197a;

        public c(d dVar) {
            this.f8197a = dVar;
        }

        public final void a(Exception exc) {
            com.xingin.xhssharesdk.p.b.a(new com.honey.account.k9.c(this, exc));
        }

        public final /* synthetic */ void d(String str) {
            a aVar = this.f8197a;
            if (aVar != null) {
                aVar.onSuccess(str);
            }
        }

        public final /* synthetic */ void e(Exception exc) {
            a aVar = this.f8197a;
            if (aVar != null) {
                aVar.a(exc);
            }
        }

        public final void onSuccess(String str) {
            com.xingin.xhssharesdk.p.b.a(new com.honey.account.k9.b(this, str));
        }
    }

    public static void a(String str, C0032b bVar, d dVar) {
        c cVar = new c(dVar);
        if (b == null) {
            b = Executors.newCachedThreadPool();
        }
        b.execute(new com.honey.account.k9.a(str, (Map) null, bVar, cVar));
    }

    public static /* synthetic */ void b(String str, Map map, C0032b bVar, c cVar) {
        Exception e;
        String str2;
        IShareLogger iShareLogger;
        try {
            IShareLogger iShareLogger2 = f8196a;
            if (iShareLogger2 != null) {
                iShareLogger2.d("XhsShare_NetworkManager", "Post start, url is " + str);
            }
            HashMap hashMap = new HashMap();
            if (map == null) {
                if (bVar == null || (map = bVar.a()) == null) {
                    map = hashMap;
                }
            }
            String a2 = c.a(str, map);
            IShareLogger iShareLogger3 = f8196a;
            if (iShareLogger3 != null) {
                iShareLogger3.d("XhsShare_NetworkManager", "Post end, response is " + a2);
            }
            cVar.onSuccess(a2);
        } catch (IOException e2) {
            e = e2;
            iShareLogger = f8196a;
            if (iShareLogger != null) {
                str2 = "IOException!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            cVar.a(e);
        } catch (com.xingin.xhssharesdk.l.b e3) {
            e = e3;
            iShareLogger = f8196a;
            if (iShareLogger != null) {
                str2 = "Network Error!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            cVar.a(e);
        } catch (com.xingin.xhssharesdk.l.c e4) {
            e = e4;
            iShareLogger = f8196a;
            if (iShareLogger != null) {
                str2 = "Invalid Params!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            cVar.a(e);
        }
    }
}
