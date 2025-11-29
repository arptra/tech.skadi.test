package zmq;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.apache.commons.lang3.BooleanUtils;
import zmq.ZError;
import zmq.poll.PollItem;
import zmq.util.Clock;
import zmq.util.Utils;

public class ZMQ {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3607a = new byte[0];
    public static final byte[] b = new byte[0];
    public static final Charset c;
    public static final byte[] d;
    public static final byte[] e;
    public static final byte[] f;
    public static final boolean g;

    static {
        Charset forName = Charset.forName("UTF-8");
        c = forName;
        d = "PAUSE".getBytes(forName);
        e = "RESUME".getBytes(forName);
        f = "TERMINATE".getBytes(forName);
        String property = System.getProperty("java.net.preferIPv4Stack");
        String property2 = System.getProperty("java.net.preferIPv6Addresses");
        if (BooleanUtils.FALSE.equalsIgnoreCase(property) || BooleanUtils.TRUE.equalsIgnoreCase(property2)) {
            g = true;
        } else {
            g = false;
        }
    }

    public static void a(Ctx ctx) {
        if (ctx == null || !ctx.t()) {
            throw new IllegalStateException();
        }
    }

    public static Ctx b() {
        return new Ctx();
    }

    public static Ctx c(int i) {
        Utils.b(i >= 0, "I/O threads must not be negative");
        Ctx b2 = b();
        h(b2, 1, i);
        return b2;
    }

    public static int d(Selector selector, PollItem[] pollItemArr, int i, long j) {
        long j2;
        int i2;
        Selector selector2 = selector;
        int i3 = i;
        long j3 = j;
        boolean z = true;
        Utils.b(pollItemArr != null, "items have to be supplied for polling");
        if (i3 != 0) {
            HashMap hashMap = new HashMap();
            for (SelectionKey next : selector.keys()) {
                if (next.isValid()) {
                    hashMap.put(next.channel(), next);
                }
            }
            for (int i4 = 0; i4 < i3; i4++) {
                PollItem pollItem = pollItemArr[i4];
                if (pollItem != null) {
                    SelectableChannel a2 = pollItem.a();
                    SelectionKey selectionKey = (SelectionKey) hashMap.remove(a2);
                    if (selectionKey != null) {
                        if (selectionKey.interestOps() != pollItem.e()) {
                            selectionKey.interestOps(pollItem.e());
                        }
                        selectionKey.attach(pollItem);
                    } else {
                        try {
                            a2.register(selector2, pollItem.e(), pollItem);
                        } catch (ClosedSelectorException unused) {
                            return -1;
                        } catch (ClosedChannelException e2) {
                            throw new ZError.IOException(e2);
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                for (SelectionKey cancel : hashMap.values()) {
                    cancel.cancel();
                }
            }
            int i5 = 0;
            long j4 = 0;
            long j5 = 0;
            while (true) {
                if (z) {
                    j2 = 0;
                } else if (j3 < 0) {
                    j2 = -1;
                } else {
                    j2 = TimeUnit.NANOSECONDS.toMillis(j4 - j5);
                    if (j2 == 0) {
                        j2 = 1;
                    }
                }
                int i6 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i6 < 0) {
                    try {
                        i2 = selector2.select(0);
                    } catch (ClosedSelectorException unused2) {
                        return -1;
                    } catch (IOException e3) {
                        throw new ZError.IOException(e3);
                    }
                } else {
                    i2 = i6 == 0 ? selector.selectNow() : selector2.select(j2);
                }
                for (SelectionKey next2 : selector.keys()) {
                    int i7 = ((PollItem) next2.attachment()).i(next2, i2);
                    if (i7 < 0) {
                        return -1;
                    }
                    if (i7 > 0) {
                        i5++;
                    }
                }
                selector.selectedKeys().clear();
                int i8 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                if (i8 == 0 || i5 > 0) {
                    break;
                }
                if (i8 < 0) {
                    if (!z) {
                    }
                } else if (z) {
                    j5 = Clock.b();
                    j4 = j5 + TimeUnit.MILLISECONDS.toNanos(j3);
                    if (j5 == j4) {
                        break;
                    }
                } else {
                    j5 = Clock.b();
                    if (j5 >= j4) {
                        break;
                    }
                }
                z = false;
            }
            return i5;
        } else if (j3 <= 0) {
            return 0;
        } else {
            LockSupport.parkNanos(TimeUnit.NANOSECONDS.convert(j3, TimeUnit.MILLISECONDS));
            return 0;
        }
    }

    public static int e(Selector selector, PollItem[] pollItemArr, long j) {
        return d(selector, pollItemArr, pollItemArr.length, j);
    }

    public static boolean f(SocketBase socketBase, SocketBase socketBase2, SocketBase socketBase3) {
        boolean z = false;
        Utils.b(socketBase != null, "Frontend socket has to be present for proxy");
        if (socketBase2 != null) {
            z = true;
        }
        Utils.b(z, "Backend socket has to be present for proxy");
        return Proxy.d(socketBase, socketBase2, socketBase3, (SocketBase) null);
    }

    public static boolean g(SocketBase socketBase, SocketBase socketBase2, SocketBase socketBase3, SocketBase socketBase4) {
        boolean z = false;
        Utils.b(socketBase != null, "Frontend socket has to be present for proxy");
        if (socketBase2 != null) {
            z = true;
        }
        Utils.b(z, "Backend socket has to be present for proxy");
        return Proxy.d(socketBase, socketBase2, socketBase3, socketBase4);
    }

    public static void h(Ctx ctx, int i, int i2) {
        a(ctx);
        ctx.y(i, i2);
    }

    public static class Event {

        /* renamed from: a  reason: collision with root package name */
        public final int f3608a;
        public final String b;
        public final Object c;
        public final int d;

        public Event(int i, String str, Object obj) {
            this.f3608a = i;
            this.b = str;
            this.c = obj;
            if (obj instanceof Integer) {
                this.d = 1;
            } else if (obj instanceof SelectableChannel) {
                this.d = 2;
            } else {
                this.d = 0;
            }
        }

        public static Event b(SocketBase socketBase, int i) {
            Msg b2 = socketBase.b2(i);
            Integer num = null;
            if (b2 == null) {
                return null;
            }
            ByteBuffer a2 = b2.a();
            int i2 = a2.getInt();
            byte[] bArr = new byte[a2.get()];
            a2.get(bArr);
            byte b3 = a2.get();
            if (b3 == 1 || b3 == 2) {
                num = Integer.valueOf(a2.getInt());
            }
            return new Event(i2, new String(bArr, ZMQ.c), num, b3);
        }

        public SelectableChannel a(SocketBase socketBase) {
            if (this.d == 2) {
                return socketBase.w().o((Integer) this.c);
            }
            return null;
        }

        public boolean c(SocketBase socketBase) {
            int length = this.b.length();
            int i = length + 6;
            int i2 = this.d;
            if (i2 == 1 || i2 == 2) {
                i = length + 10;
            }
            ByteBuffer order = ByteBuffer.allocate(i).order(ByteOrder.BIG_ENDIAN);
            order.putInt(this.f3608a);
            order.put((byte) this.b.length());
            order.put(this.b.getBytes(ZMQ.c));
            order.put((byte) this.d);
            int i3 = this.d;
            if (i3 == 1) {
                order.putInt(((Integer) this.c).intValue());
            } else if (i3 == 2) {
                order.putInt(socketBase.w().m((SelectableChannel) this.c));
            }
            order.flip();
            return socketBase.d2(new Msg(order), 0);
        }

        public Event(int i, String str, Object obj, int i2) {
            this.f3608a = i;
            this.b = str;
            this.c = obj;
            this.d = i2;
        }
    }
}
