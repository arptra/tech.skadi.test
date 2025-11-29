package zmq.msg;

import zmq.Msg;

public class MsgAllocatorThreshold implements MsgAllocator {
    public static final MsgAllocator b = new MsgAllocatorDirect();
    public static final MsgAllocator c = new MsgAllocatorHeap();

    /* renamed from: a  reason: collision with root package name */
    public final int f3647a;

    public MsgAllocatorThreshold(int i) {
        this.f3647a = i;
    }

    public Msg a(int i) {
        int i2 = this.f3647a;
        return (i2 <= 0 || i <= i2) ? c.a(i) : b.a(i);
    }
}
