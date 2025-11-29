package org.zeromq;

import org.zeromq.ZMQ;

public class ZThread {

    public interface IAttachedRunnable {
        void a(Object[] objArr, ZContext zContext, ZMQ.Socket socket);
    }

    public interface IDetachedRunnable {
        void a(Object[] objArr);
    }

    public static class ShimThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public ZContext f3514a;
        public IAttachedRunnable b;
        public IDetachedRunnable c;
        public final Object[] d;
        public ZMQ.Socket e;

        public void run() {
            IAttachedRunnable iAttachedRunnable = this.b;
            if (iAttachedRunnable != null) {
                try {
                    iAttachedRunnable.a(this.d, this.f3514a, this.e);
                } catch (ZMQException e2) {
                    if (e2.getErrorCode() != ZMQ.Error.ETERM.getCode()) {
                        throw e2;
                    }
                }
                this.f3514a.c();
                return;
            }
            this.c.a(this.d);
        }
    }
}
