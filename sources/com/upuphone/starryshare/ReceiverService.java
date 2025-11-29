package com.upuphone.starryshare;

import android.net.Uri;
import android.text.TextUtils;
import com.upuphone.starrycommon.threads.ThreadExecutorKit;
import com.upuphone.starrycommon.utils.StarryCastLog;
import com.upuphone.starryshare.listener.IOtaShareListener;
import com.upuphone.starryshare.server.FileReceiver;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public class ReceiverService {

    /* renamed from: a  reason: collision with root package name */
    public ServerRunnable f6550a;
    public int b;
    public IOtaShareListener c;
    public Executor d;
    public final Object e = new Object();
    public final Map f = new HashMap();
    public final Map g = new HashMap();
    public final Map h = new HashMap();

    public class ServerRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public volatile ServerSocket f6551a;
        public Object b = new Object();

        public ServerRunnable() {
        }

        public void b() {
            if (this.f6551a != null) {
                try {
                    this.f6551a.close();
                    this.f6551a = null;
                } catch (IOException e) {
                    StarryCastLog.c("ReceiverService", "close" + e.getMessage());
                }
            }
        }

        public final int c() {
            if (this.f6551a == null) {
                synchronized (this.b) {
                    try {
                        this.b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return this.f6551a.getLocalPort();
        }

        public void run() {
            StarryCastLog.d("ReceiverService", "------>>>Socket已经开启");
            try {
                this.f6551a = new ServerSocket(ReceiverService.this.b);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                while (!Thread.currentThread().isInterrupted()) {
                    final FileReceiver fileReceiver = new FileReceiver(this.f6551a.accept());
                    fileReceiver.j(new FileReceiver.OnReceiveListener() {
                        public void a(String str, int i, String str2) {
                            StarryCastLog.d("ReceiverService", "onProgress" + i);
                            if (ReceiverService.this.c != null) {
                                ReceiverService.this.c.onProgressChanged(str, i, Uri.parse(str2));
                            }
                        }

                        public void b(String str, Throwable th, int i) {
                            if (TextUtils.isEmpty(str)) {
                                Iterator it = ReceiverService.this.g.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String str2 = (String) it.next();
                                    if (!ReceiverService.this.f.containsKey(str2)) {
                                        str = str2;
                                        break;
                                    }
                                }
                            }
                            StarryCastLog.b("ReceiverService", "onFailure taskId:" + str);
                            if (ReceiverService.this.c != null) {
                                ReceiverService.this.c.onFailure(str, false, i);
                            }
                            ReceiverService.this.g.remove(str);
                            ReceiverService.this.f.remove(str);
                        }

                        public void c(String str) {
                            fileReceiver.k((String) ReceiverService.this.h.get(str));
                            ReceiverService.this.f.put(str, fileReceiver);
                            StarryCastLog.d("ReceiverService", "onTaskId");
                        }

                        public void onFinish(String str, String str2) {
                            if (ReceiverService.this.c != null) {
                                ReceiverService.this.c.onFinish(str, (Uri) null, Uri.parse(str2));
                            }
                            ReceiverService.this.g.remove(str);
                            ReceiverService.this.f.remove(str);
                            ReceiverService.this.h.remove(str);
                        }

                        public void onStart() {
                            StarryCastLog.d("ReceiverService", "onStart");
                        }

                        public void onSuccess(String str) {
                            StarryCastLog.d("ReceiverService", "onSuccess");
                            if (ReceiverService.this.c != null) {
                                ReceiverService.this.c.onSuccess(str);
                            }
                        }
                    });
                    ReceiverService.this.j().execute(fileReceiver);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ReceiverService(int i) {
        this.b = i;
    }

    public void g(String str) {
        FileReceiver fileReceiver = (FileReceiver) this.f.get(str);
        if (fileReceiver == null) {
            k(str);
            Runnable runnable = (Runnable) this.g.get(str);
            if (runnable != null) {
                runnable.run();
            }
        } else if (fileReceiver.f() < 3) {
            k(str);
        } else {
            fileReceiver.a();
        }
    }

    public void h() {
        StarryCastLog.d("ReceiverService", "------>>>close");
        ServerRunnable serverRunnable = this.f6550a;
        if (serverRunnable != null) {
            serverRunnable.b();
        }
    }

    public int i() {
        return this.f6550a.c();
    }

    public final Executor j() {
        if (this.d == null) {
            synchronized (this.e) {
                try {
                    if (this.d == null) {
                        this.d = ThreadExecutorKit.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.d;
    }

    public final void k(String str) {
        IOtaShareListener iOtaShareListener = this.c;
        if (iOtaShareListener != null) {
            iOtaShareListener.onFailure(str, false, 2);
        }
    }

    public void l(String str, String str2) {
        this.h.put(str, str2);
    }

    public void m(String str, Runnable runnable) {
        this.g.put(str, runnable);
    }

    public void n(IOtaShareListener iOtaShareListener) {
        this.c = iOtaShareListener;
    }

    public void o() {
        this.f6550a = new ServerRunnable();
        new Thread(this.f6550a).start();
    }
}
