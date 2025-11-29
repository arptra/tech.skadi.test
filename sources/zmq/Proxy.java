package zmq;

import java.nio.channels.Selector;
import java.util.Arrays;
import zmq.poll.PollItem;

class Proxy {

    /* renamed from: a  reason: collision with root package name */
    public State f3602a = State.ACTIVE;

    public enum State {
        ACTIVE,
        PAUSED,
        TERMINATED
    }

    public static boolean d(SocketBase socketBase, SocketBase socketBase2, SocketBase socketBase3, SocketBase socketBase4) {
        return new Proxy().e(socketBase, socketBase2, socketBase3, socketBase4);
    }

    public final boolean a(SocketBase socketBase, Msg msg, int i) {
        if (socketBase == null) {
            return true;
        }
        return socketBase.d2(new Msg(msg), i > 0 ? 2 : 0);
    }

    public final boolean b(SocketBase socketBase, SocketBase socketBase2, SocketBase socketBase3) {
        int Q1;
        do {
            Msg b2 = socketBase.b2(0);
            if (b2 == null || (Q1 = socketBase.Q1(13)) < 0 || !a(socketBase3, b2, Q1)) {
                return false;
            }
            if (!socketBase2.d2(b2, Q1 > 0 ? 2 : 0)) {
                return false;
            }
        } while (Q1 != 0);
        return true;
    }

    public final boolean c(PollItem pollItem, PollItem pollItem2, SocketBase socketBase, SocketBase socketBase2) {
        return this.f3602a == State.ACTIVE && pollItem.f() && (socketBase == socketBase2 || pollItem2.g());
    }

    public final boolean e(SocketBase socketBase, SocketBase socketBase2, SocketBase socketBase3, SocketBase socketBase4) {
        PollItem[] pollItemArr = new PollItem[(socketBase4 == null ? 2 : 3)];
        pollItemArr[0] = new PollItem(socketBase, 1);
        pollItemArr[1] = new PollItem(socketBase2, 1);
        if (socketBase4 != null) {
            pollItemArr[2] = new PollItem(socketBase4, 1);
        }
        PollItem[] pollItemArr2 = {new PollItem(socketBase, 2), new PollItem(socketBase2, 2)};
        Selector g = socketBase.w().g();
        while (true) {
            try {
                State state = this.f3602a;
                State state2 = State.TERMINATED;
                if (state != state2) {
                    if (ZMQ.e(g, pollItemArr, -1) < 0) {
                        break;
                    }
                    if (socketBase != socketBase2) {
                        if (ZMQ.e(g, pollItemArr2, 0) < 0) {
                            break;
                        }
                    }
                    if (socketBase4 != null && pollItemArr[2].f()) {
                        Msg b2 = socketBase4.b2(0);
                        if (b2 == null) {
                            break;
                        }
                        int Q1 = socketBase4.Q1(13);
                        if (Q1 < 0) {
                            break;
                        } else if (!a(socketBase3, b2, Q1)) {
                            break;
                        } else {
                            byte[] c = b2.c();
                            if (Arrays.equals(c, ZMQ.d)) {
                                this.f3602a = State.PAUSED;
                            } else if (Arrays.equals(c, ZMQ.e)) {
                                this.f3602a = State.ACTIVE;
                            } else if (Arrays.equals(c, ZMQ.f)) {
                                this.f3602a = state2;
                            } else {
                                System.out.printf("E: invalid command sent to proxy '%s'%n", new Object[]{new String(c, ZMQ.c)});
                            }
                        }
                    }
                    if (!c(pollItemArr[0], pollItemArr2[1], socketBase, socketBase2) || b(socketBase, socketBase2, socketBase3)) {
                        if (c(pollItemArr[1], pollItemArr2[0], socketBase, socketBase2) && !b(socketBase2, socketBase, socketBase3)) {
                            break;
                        }
                    }
                } else {
                    socketBase.w().d(g);
                    return true;
                }
            } finally {
                socketBase.w().d(g);
            }
        }
        return false;
    }
}
