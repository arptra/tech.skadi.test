package zmq.msg;

import zmq.Msg;

public class MsgAllocatorHeap implements MsgAllocator {
    public Msg a(int i) {
        return new Msg(i);
    }
}
