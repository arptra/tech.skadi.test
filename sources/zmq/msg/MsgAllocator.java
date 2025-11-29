package zmq.msg;

import zmq.Msg;

public interface MsgAllocator {
    Msg a(int i);
}
