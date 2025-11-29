package zmq.poll;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import zmq.SocketBase;

public class PollItem {

    /* renamed from: a  reason: collision with root package name */
    public final SocketBase f3653a;
    public final SelectableChannel b;
    public final int c;
    public final int d;
    public int e;

    public PollItem(SocketBase socketBase, int i) {
        this(socketBase, (SelectableChannel) null, i);
    }

    public SelectableChannel a() {
        SocketBase socketBase = this.f3653a;
        return socketBase != null ? socketBase.O1() : this.b;
    }

    public SelectableChannel b() {
        return this.b;
    }

    public boolean c(int i) {
        return (this.c & i) > 0;
    }

    public final int d(int i) {
        int i2 = 1;
        int i3 = (i & 1) > 0 ? 1 : 0;
        if ((i & 2) <= 0) {
            i2 = i3;
        } else if (this.f3653a == null) {
            i2 = i3 | 4;
        }
        this.e = 0;
        return i2;
    }

    public int e() {
        return this.d;
    }

    public boolean f() {
        return (this.e & 1) > 0;
    }

    public boolean g() {
        return (this.e & 2) > 0;
    }

    public int h() {
        return this.e;
    }

    public int i(SelectionKey selectionKey, int i) {
        this.e = 0;
        SocketBase socketBase = this.f3653a;
        if (socketBase != null) {
            int Q1 = socketBase.Q1(15);
            if (Q1 < 0) {
                return -1;
            }
            int i2 = this.c;
            if ((i2 & 2) > 0 && (Q1 & 2) > 0) {
                this.e |= 2;
            }
            if ((i2 & 1) > 0 && (Q1 & 1) > 0) {
                this.e |= 1;
            }
        } else if (i > 0) {
            if (selectionKey.isReadable()) {
                this.e |= 1;
            }
            if (selectionKey.isWritable()) {
                this.e |= 2;
            }
            if (!selectionKey.isValid() || selectionKey.isAcceptable() || selectionKey.isConnectable()) {
                this.e |= 4;
            }
        }
        return this.e;
    }

    public int j() {
        return this.c;
    }

    public PollItem(SelectableChannel selectableChannel, int i) {
        this((SocketBase) null, selectableChannel, i);
    }

    public PollItem(SocketBase socketBase, SelectableChannel selectableChannel, int i) {
        this.f3653a = socketBase;
        this.b = selectableChannel;
        this.c = i;
        this.d = d(i);
    }
}
