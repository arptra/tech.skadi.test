package org.zeromq;

import java.util.Arrays;
import org.zeromq.ZMQ;

public interface ZAgent {

    public static class Creator {
    }

    @Deprecated
    public interface SelectorCreator {
    }

    public static final class SimpleAgent implements ZAgent {

        /* renamed from: a  reason: collision with root package name */
        public final ZMQ.Socket f3476a;
        public final byte[] b;
        public boolean c;

        public ZMsg a() {
            return c(true);
        }

        public boolean b(ZMsg zMsg) {
            if (this.c) {
                return false;
            }
            return zMsg.D(this.f3476a);
        }

        public ZMsg c(boolean z) {
            if (this.c) {
                return null;
            }
            try {
                ZMsg z2 = ZMsg.z(this.f3476a, z);
                if (z2 == null) {
                    return null;
                }
                if (z2.size() == 1) {
                    byte[] c2 = z2.peek().c();
                    byte[] bArr = this.b;
                    if (bArr != null && Arrays.equals(bArr, c2)) {
                        this.c = true;
                        this.f3476a.close();
                        return null;
                    }
                }
                return z2;
            } catch (ZMQException unused) {
                this.c = true;
                return null;
            }
        }

        public void close() {
            this.c = true;
            this.f3476a.close();
        }

        public boolean send(String str) {
            if (this.c) {
                return false;
            }
            return this.f3476a.v(str);
        }
    }

    ZMsg a();

    boolean b(ZMsg zMsg);

    void close();

    boolean send(String str);
}
