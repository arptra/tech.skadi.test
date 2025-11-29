package zmq.msg;

import java.nio.ByteBuffer;
import zmq.Msg;

public class MsgAllocatorDirect implements MsgAllocator {
    public Msg a(int i) {
        return new Msg(ByteBuffer.allocateDirect(i));
    }
}
