package zmq;

import java.net.SocketException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import org.zeromq.UncheckedZMQException;
import org.zeromq.ZMQ;

public class ZError {

    public static class CtxTerminatedException extends UncheckedZMQException {
        private static final long serialVersionUID = -4404921838608052956L;
    }

    public static class IOException extends UncheckedZMQException {
        private static final long serialVersionUID = 9202470691157986262L;

        public IOException(java.io.IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static class InstantiationException extends UncheckedZMQException {
        private static final long serialVersionUID = -4404921838608052955L;

        public InstantiationException(Throwable th) {
            super(th);
        }

        public InstantiationException(String str, Throwable th) {
            super(str, th);
        }

        public InstantiationException(String str) {
            super(str);
        }
    }

    public static int a(java.io.IOException iOException) {
        if (iOException instanceof SocketException) {
            return 156384818;
        }
        if (iOException instanceof ClosedByInterruptException) {
            return 4;
        }
        return iOException instanceof ClosedChannelException ? 57 : 156384817;
    }

    public static String b(int i) {
        return ZMQ.Error.findByCode(i).getMessage();
    }
}
