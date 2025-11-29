package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class ai {
    private static ai b;

    /* renamed from: a  reason: collision with root package name */
    public ah f9523a;
    private final w c;
    private final Context d;
    private Map<Integer, Long> e = new HashMap();
    private long f;
    private long g;
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public final Object j = new Object();
    private long k = 0;
    private int l = 0;

    private ai(Context context) {
        this.d = context;
        this.c = w.a();
    }

    public static /* synthetic */ int b(ai aiVar) {
        int i2 = aiVar.l - 1;
        aiVar.l = i2;
        return i2;
    }

    public static synchronized ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            try {
                if (b == null) {
                    b = new ai(context);
                }
                aiVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiVar;
    }

    public final boolean b(int i2) {
        if (p.c) {
            al.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i2);
        al.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        al.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            aiVar = b;
        }
        return aiVar;
    }

    public final void a(int i2, bq bqVar, String str, String str2, ah ahVar, long j2, boolean z) {
        try {
            a(new aj(this.d, i2, bqVar.g, ae.a((Object) bqVar), str, str2, ahVar, z), true, true, j2);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        a(r4, (java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable>) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r5 <= 0) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        com.tencent.bugly.proguard.al.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        r0 = com.tencent.bugly.proguard.ak.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        r0.a(new com.tencent.bugly.proguard.ai.AnonymousClass2(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r7 = this;
            com.tencent.bugly.proguard.ak r0 = com.tencent.bugly.proguard.ak.a()
            java.util.concurrent.LinkedBlockingQueue r1 = new java.util.concurrent.LinkedBlockingQueue
            r1.<init>()
            java.util.concurrent.LinkedBlockingQueue r2 = new java.util.concurrent.LinkedBlockingQueue
            r2.<init>()
            java.lang.Object r3 = r7.j
            monitor-enter(r3)
            java.lang.String r4 = "[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)"
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0044 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0044 }
            int r6 = android.os.Process.myTid()     // Catch:{ all -> 0x0044 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0044 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6}     // Catch:{ all -> 0x0044 }
            com.tencent.bugly.proguard.al.c(r4, r5)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r4 = r7.h     // Catch:{ all -> 0x0044 }
            int r4 = r4.size()     // Catch:{ all -> 0x0044 }
            java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r5 = r7.i     // Catch:{ all -> 0x0044 }
            int r5 = r5.size()     // Catch:{ all -> 0x0044 }
            r6 = 0
            if (r4 != 0) goto L_0x0046
            if (r5 != 0) goto L_0x0046
            java.lang.String r7 = "[UploadManager] There is no upload task in queue."
            java.lang.Object[] r0 = new java.lang.Object[r6]     // Catch:{ all -> 0x0044 }
            com.tencent.bugly.proguard.al.c(r7, r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r7 = move-exception
            goto L_0x008b
        L_0x0046:
            if (r0 == 0) goto L_0x004e
            boolean r0 = r0.c()     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x004f
        L_0x004e:
            r5 = r6
        L_0x004f:
            java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r0 = r7.h     // Catch:{ all -> 0x0044 }
            a(r0, r1, r4)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r0 = r7.i     // Catch:{ all -> 0x0044 }
            a(r0, r2, r5)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            r7.a((int) r4, (java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable>) r1)
            if (r5 <= 0) goto L_0x007c
            java.lang.String r0 = "[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            int r3 = android.os.Process.myPid()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = android.os.Process.myTid()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r3, r4}
            com.tencent.bugly.proguard.al.c(r0, r1)
        L_0x007c:
            com.tencent.bugly.proguard.ak r0 = com.tencent.bugly.proguard.ak.a()
            if (r0 == 0) goto L_0x008a
            com.tencent.bugly.proguard.ai$2 r1 = new com.tencent.bugly.proguard.ai$2
            r1.<init>(r5, r2)
            r0.a(r1)
        L_0x008a:
            return
        L_0x008b:
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ai.b():void");
    }

    private void a(int i2, int i3, byte[] bArr, String str, String str2, ah ahVar, boolean z) {
        try {
            a(new aj(this.d, i2, i3, bArr, str, str2, ahVar, 0, 0, false), z, false, 0);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void a(int i2, bq bqVar, String str, String str2, ah ahVar, boolean z) {
        a(i2, bqVar.g, ae.a((Object) bqVar), str, str2, ahVar, z);
    }

    public final long a(boolean z) {
        long j2;
        long b2 = ap.b();
        int i2 = z ? 5 : 3;
        List<y> a2 = this.c.a(i2);
        if (a2 == null || a2.size() <= 0) {
            j2 = z ? this.g : this.f;
        } else {
            j2 = 0;
            try {
                y yVar = a2.get(0);
                if (yVar.e >= b2) {
                    j2 = ap.d(yVar.g);
                    if (i2 == 3) {
                        this.f = j2;
                    } else {
                        this.g = j2;
                    }
                    a2.remove(yVar);
                }
            } catch (Throwable th) {
                al.a(th);
            }
            if (a2.size() > 0) {
                this.c.a(a2);
            }
        }
        al.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    public final synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        try {
            y yVar = new y();
            yVar.b = i2;
            yVar.e = ap.b();
            yVar.c = "";
            yVar.d = "";
            yVar.g = ap.c(j2);
            this.c.b(i2);
            this.c.a(yVar);
            if (z) {
                this.g = j2;
            } else {
                this.f = j2;
            }
            al.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(int i2, long j2) {
        if (i2 >= 0) {
            this.e.put(Integer.valueOf(i2), Long.valueOf(j2));
            y yVar = new y();
            yVar.b = i2;
            yVar.e = j2;
            yVar.c = "";
            yVar.d = "";
            yVar.g = new byte[0];
            this.c.b(i2);
            this.c.a(yVar);
            al.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), ap.a(j2));
            return;
        }
        al.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto L_0x0019
            java.util.Map<java.lang.Integer, java.lang.Long> r0 = r2.e     // Catch:{ all -> 0x0017 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0017 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0017 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0026
            long r0 = r3.longValue()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return r0
        L_0x0017:
            r3 = move-exception
            goto L_0x002a
        L_0x0019:
            java.lang.String r0 = "[UploadManager] Unknown upload ID: %d"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0017 }
            java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ all -> 0x0017 }
            com.tencent.bugly.proguard.al.e(r0, r3)     // Catch:{ all -> 0x0017 }
        L_0x0026:
            monitor-exit(r2)
            r2 = 0
            return r2
        L_0x002a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ai.a(int):long");
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek != null) {
                try {
                    linkedBlockingQueue2.put(peek);
                    linkedBlockingQueue.poll();
                } catch (Throwable th) {
                    al.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        ak a2 = ak.a();
        if (i2 > 0) {
            al.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        int i3 = 0;
        while (i3 < i2) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll != null) {
                synchronized (this.j) {
                    try {
                        if (this.l < 2 || a2 == null) {
                            al.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                            if (ap.a((Runnable) new Runnable() {
                                public final void run() {
                                    poll.run();
                                    synchronized (ai.this.j) {
                                        ai.b(ai.this);
                                    }
                                }
                            }, "BUGLY_ASYNC_UPLOAD") != null) {
                                synchronized (this.j) {
                                    this.l++;
                                }
                            } else {
                                al.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                                a(poll, true);
                            }
                        } else {
                            a2.a(poll);
                        }
                    } finally {
                        while (true) {
                        }
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            al.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            al.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.j) {
                if (z) {
                    this.h.put(runnable);
                } else {
                    this.i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j2) {
        if (runnable == null) {
            al.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        al.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a2 == null) {
            al.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j2);
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            b();
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        al.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(runnable, j2);
            return;
        }
        a(runnable, z);
        b();
    }
}
