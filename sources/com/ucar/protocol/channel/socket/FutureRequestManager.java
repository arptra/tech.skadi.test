package com.ucar.protocol.channel.socket;

import com.honey.account.g3.a;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.log.ProtocolLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeoutException;

public class FutureRequestManager {
    public static final FutureRequestManager e = new FutureRequestManager();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f9644a = false;
    public final DelayQueue b = new DelayQueue();
    public final Map c = new HashMap();
    public final Object d = new Object();

    public FutureRequestManager() {
        Thread thread = new Thread(new a(this, ProtocolConfig.b()), "req-timeout-task");
        thread.setDaemon(true);
        thread.start();
    }

    public static FutureRequestManager e() {
        return e;
    }

    public void b(RequestFuture requestFuture) {
        if (requestFuture != null) {
            int d2 = requestFuture.d();
            synchronized (this.d) {
                try {
                    if (this.c.containsKey(Integer.valueOf(d2))) {
                        ProtocolLogger b2 = ProtocolConfig.b();
                        b2.w("FutureRequestManager", "request id: " + d2 + " repeat add.");
                    }
                    this.c.put(Integer.valueOf(d2), requestFuture);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            this.b.put(requestFuture);
        }
    }

    public void c() {
        synchronized (this.d) {
            try {
                for (Map.Entry entry : this.c.entrySet()) {
                    ProtocolLogger b2 = ProtocolConfig.b();
                    b2.w("FutureRequestManager", "request id: " + entry.getKey() + " need force failed.");
                    ((RequestFuture) entry.getValue()).b(new IOException("ucar device disconnected, we need force failed"));
                }
                this.c.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.b.clear();
    }

    public void d(UCarMessage uCarMessage) {
        RequestFuture requestFuture;
        int k = uCarMessage.k();
        synchronized (this.d) {
            requestFuture = (RequestFuture) this.c.remove(Integer.valueOf(k));
        }
        if (requestFuture != null) {
            requestFuture.g(uCarMessage);
            return;
        }
        ProtocolLogger b2 = ProtocolConfig.b();
        b2.w("FutureRequestManager", "receive timeout or unknown response: " + k);
    }

    public final /* synthetic */ void f(ProtocolLogger protocolLogger) {
        this.f9644a = true;
        while (this.f9644a) {
            try {
                RequestFuture requestFuture = (RequestFuture) this.b.take();
                if (requestFuture != null && !requestFuture.isCancelled() && !requestFuture.isDone()) {
                    synchronized (this.d) {
                        try {
                            if (this.c.remove(Integer.valueOf(requestFuture.d())) != null) {
                                String str = "request " + requestFuture.d() + " timeout: " + requestFuture.f();
                                protocolLogger.e("FutureRequestManager", str);
                                requestFuture.b(new TimeoutException(str));
                            }
                        } finally {
                            while (true) {
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
        protocolLogger.i("FutureRequestManager", "FutureRequest timeout thread exit.");
    }

    public void g(int i) {
        synchronized (this.d) {
            this.c.remove(Integer.valueOf(i));
        }
    }
}
