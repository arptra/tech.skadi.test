package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;

public final class Errors {
    public static final int ERRNO_EAGAIN_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoEAGAIN());
    public static final int ERRNO_EBADF_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoEBADF());
    public static final int ERRNO_ECONNRESET_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoECONNRESET());
    public static final int ERRNO_EINPROGRESS_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS());
    public static final int ERRNO_ENOENT_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoENOENT());
    public static final int ERRNO_ENOTCONN_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoENOTCONN());
    public static final int ERRNO_EPIPE_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoEPIPE());
    public static final int ERRNO_EWOULDBLOCK_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK());
    /* access modifiers changed from: private */
    public static final String[] ERRORS = new String[512];
    public static final int ERROR_EALREADY_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errorEALREADY());
    public static final int ERROR_ECONNREFUSED_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED());
    public static final int ERROR_EISCONN_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errorEISCONN());
    public static final int ERROR_ENETUNREACH_NEGATIVE = (-ErrorsStaticallyReferencedJniMethods.errorENETUNREACH());

    public static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        public NativeConnectException(String str, int i) {
            super(str + "(..) failed: " + Errors.ERRORS[-i]);
            this.expectedErr = i;
        }

        public int expectedErr() {
            return this.expectedErr;
        }
    }

    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;
        private final boolean fillInStackTrace;

        public NativeIoException(String str, int i) {
            this(str, i, true);
        }

        public int expectedErr() {
            return this.expectedErr;
        }

        public synchronized Throwable fillInStackTrace() {
            if (!this.fillInStackTrace) {
                return this;
            }
            return super.fillInStackTrace();
        }

        public NativeIoException(String str, int i, boolean z) {
            super(str + "(..) failed: " + Errors.ERRORS[-i]);
            this.expectedErr = i;
            this.fillInStackTrace = z;
        }
    }

    static {
        int i = 0;
        while (true) {
            String[] strArr = ERRORS;
            if (i < strArr.length) {
                strArr[i] = ErrorsStaticallyReferencedJniMethods.strError(i);
                i++;
            } else {
                return;
            }
        }
    }

    private Errors() {
    }

    public static boolean handleConnectErrno(String str, int i) throws IOException {
        if (i == ERRNO_EINPROGRESS_NEGATIVE || i == ERROR_EALREADY_NEGATIVE) {
            return false;
        }
        throw newConnectException0(str, i);
    }

    @Deprecated
    public static int ioResult(String str, int i, NativeIoException nativeIoException, ClosedChannelException closedChannelException) throws IOException {
        if (i == ERRNO_EAGAIN_NEGATIVE || i == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i == nativeIoException.expectedErr()) {
            throw nativeIoException;
        } else if (i == ERRNO_EBADF_NEGATIVE) {
            throw closedChannelException;
        } else if (i == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        } else if (i == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        } else {
            throw newIOException(str, i);
        }
    }

    private static IOException newConnectException0(String str, int i) {
        if (i == ERROR_ENETUNREACH_NEGATIVE) {
            return new NoRouteToHostException();
        }
        if (i == ERROR_EISCONN_NEGATIVE) {
            throw new AlreadyConnectedException();
        } else if (i == ERRNO_ENOENT_NEGATIVE) {
            return new FileNotFoundException();
        } else {
            return new ConnectException(str + "(..) failed: " + ERRORS[-i]);
        }
    }

    public static NativeIoException newConnectionResetException(String str, int i) {
        NativeIoException nativeIoException = new NativeIoException(str, i, false);
        nativeIoException.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return nativeIoException;
    }

    public static NativeIoException newIOException(String str, int i) {
        return new NativeIoException(str, i);
    }

    @Deprecated
    public static void throwConnectException(String str, int i) throws IOException {
        if (i == ERROR_EALREADY_NEGATIVE) {
            throw new ConnectionPendingException();
        }
        throw newConnectException0(str, i);
    }

    public static int ioResult(String str, int i) throws IOException {
        if (i == ERRNO_EAGAIN_NEGATIVE || i == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i == ERRNO_EBADF_NEGATIVE) {
            throw new ClosedChannelException();
        } else if (i == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        } else if (i == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        } else {
            throw new NativeIoException(str, i, false);
        }
    }
}
