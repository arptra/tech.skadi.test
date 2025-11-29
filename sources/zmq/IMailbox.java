package zmq;

import java.io.Closeable;

public interface IMailbox extends Closeable {
    void D(Command command);

    Command M(long j);
}
