package org.zeromq;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.zeromq.ZMQ;
import org.zeromq.ZThread;

public class ZStar implements ZAgent {

    /* renamed from: a  reason: collision with root package name */
    public final ZAgent f3512a;

    public interface Entourage extends TimeTaker {
        void d(ZContext zContext, Fortune fortune, ZMQ.Socket socket, Object... objArr);
    }

    public interface Exit {
        void b();
    }

    public interface Fortune extends TimeTaker {
        Star a(ZContext zContext, ZMQ.Socket socket, int i, Star star, Object... objArr);

        String b(ZMQ.Socket socket, Object... objArr);

        boolean c(ZMQ.Socket socket);
    }

    public static final class Plateau implements ZThread.IAttachedRunnable, Exit {
        public static final AtomicInteger c = new AtomicInteger();

        /* renamed from: a  reason: collision with root package name */
        public final int f3513a;
        public final CountDownLatch b;

        public void a(Object[] objArr, ZContext zContext, ZMQ.Socket socket) {
            Fortune fortune = objArr[1];
            Entourage entourage = objArr[3];
            ZContext zContext2 = objArr[2];
            Set set = objArr[0];
            String str = objArr[4];
            int length = objArr.length - 5;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 5, objArr2, 0, length);
            if (entourage != null) {
                entourage.d(zContext, fortune, socket, objArr2);
            }
            try {
                set.b(fortune.b(socket, objArr2), this.f3513a);
                c(zContext, set, socket, fortune, objArr2);
                try {
                    if (fortune.c(socket) && str != null) {
                        socket.v(str);
                    }
                    fortune.e(zContext);
                    if (entourage != null) {
                        entourage.e(zContext);
                    }
                    zContext.close();
                    if (zContext2 != null) {
                        zContext2.close();
                    }
                    this.b.countDown();
                } catch (Throwable th) {
                    this.b.countDown();
                    throw th;
                }
            } catch (Throwable th2) {
                this.b.countDown();
                throw th2;
            }
        }

        public void b() {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:2:0x0011 A[LOOP:1: B:2:0x0011->B:7:0x0026, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(org.zeromq.ZContext r8, org.zeromq.ZStar.Set r9, org.zeromq.ZMQ.Socket r10, org.zeromq.ZStar.Fortune r11, java.lang.Object... r12) {
            /*
                r7 = this;
                r7 = 0
                r0 = 0
                r4 = r7
                r5 = r0
            L_0x0004:
                int r7 = r4 + 1
                r1 = r11
                r2 = r8
                r3 = r10
                r6 = r12
                org.zeromq.ZStar$Star r5 = r1.a(r2, r3, r4, r5, r6)
                r5.prepare()
            L_0x0011:
                boolean r0 = r9.a()
                if (r0 != 0) goto L_0x0028
                int r0 = r5.f()
                boolean r0 = r5.a(r0)
                if (r0 != 0) goto L_0x0022
                goto L_0x0028
            L_0x0022:
                boolean r0 = r5.c()
                if (r0 != 0) goto L_0x0011
            L_0x0028:
                boolean r0 = r5.b()
                if (r0 != 0) goto L_0x002f
                return
            L_0x002f:
                r4 = r7
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: org.zeromq.ZStar.Plateau.c(org.zeromq.ZContext, org.zeromq.ZStar$Set, org.zeromq.ZMQ$Socket, org.zeromq.ZStar$Fortune, java.lang.Object[]):void");
        }
    }

    public interface Set {
        boolean a();

        void b(String str, int i);
    }

    public static class SimpleSet implements Set {
        public static String c(String str, int i) {
            return String.format(str, new Object[]{Integer.valueOf(i)});
        }

        public boolean a() {
            return Thread.currentThread().isInterrupted();
        }

        public void b(String str, int i) {
            if (str == null) {
                str = c("Star-%d", i);
            }
            Thread.currentThread().setName(str);
        }
    }

    public interface Star {
        boolean a(int i);

        boolean b();

        boolean c();

        int f();

        void prepare();
    }

    public interface TimeTaker {
        void e(ZContext zContext);
    }

    public ZMsg a() {
        return this.f3512a.a();
    }

    public boolean b(ZMsg zMsg) {
        return this.f3512a.b(zMsg);
    }

    public void close() {
        this.f3512a.close();
    }

    public boolean send(String str) {
        return this.f3512a.send(str);
    }
}
