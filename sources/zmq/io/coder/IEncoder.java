package zmq.io.coder;

import zmq.Msg;
import zmq.util.ValueReference;

public interface IEncoder {
    void a(Msg msg);

    int b(ValueReference valueReference, int i);

    void destroy();

    void encoded();
}
