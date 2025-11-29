package org.apache.tika.fork;

class ForkServer implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f10066a;
    public long b;
    public long c;
    public long d;
    public boolean e;
    public long f;

    public void run() {
        while (true) {
            try {
                synchronized (this.f10066a) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f;
                    boolean z = this.e;
                    if (!z || currentTimeMillis <= this.c) {
                        if (!z) {
                            long j = this.d;
                            if (j > 0 && currentTimeMillis > j) {
                            }
                        }
                    }
                }
                Thread.sleep(this.b);
            } catch (InterruptedException unused) {
                return;
            } catch (Throwable th) {
                while (true) {
                }
                throw th;
            }
        }
        System.exit(0);
    }
}
