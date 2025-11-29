package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Http2Exception extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -6941186345430164209L;
    private final Http2Error error;
    private final ShutdownHint shutdownHint;

    public static final class ClosedStreamCreationException extends Http2Exception {
        private static final long serialVersionUID = -6746542974372246206L;

        public ClosedStreamCreationException(Http2Error http2Error) {
            super(http2Error);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str) {
            super(http2Error, str);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str, Throwable th) {
            super(http2Error, str, th);
        }
    }

    public static final class CompositeStreamException extends Http2Exception implements Iterable<StreamException> {
        private static final long serialVersionUID = 7091134858213711015L;
        private final List<StreamException> exceptions;

        public CompositeStreamException(Http2Error http2Error, int i) {
            super(http2Error, ShutdownHint.NO_SHUTDOWN);
            this.exceptions = new ArrayList(i);
        }

        public void add(StreamException streamException) {
            this.exceptions.add(streamException);
        }

        public Iterator<StreamException> iterator() {
            return this.exceptions.iterator();
        }
    }

    public static final class HeaderListSizeException extends StreamException {
        private static final long serialVersionUID = -8807603212183882637L;
        private final boolean decode;

        public HeaderListSizeException(int i, Http2Error http2Error, String str, boolean z) {
            super(i, http2Error, str);
            this.decode = z;
        }

        public boolean duringDecode() {
            return this.decode;
        }
    }

    public enum ShutdownHint {
        NO_SHUTDOWN,
        GRACEFUL_SHUTDOWN,
        HARD_SHUTDOWN
    }

    public static final class StacklessHttp2Exception extends Http2Exception {
        private static final long serialVersionUID = 1077888485687219443L;

        public StacklessHttp2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint) {
            super(http2Error, str, shutdownHint);
        }

        public Throwable fillInStackTrace() {
            return this;
        }

        public StacklessHttp2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint, boolean z) {
            super(http2Error, str, shutdownHint, z);
        }
    }

    public static Http2Exception closedStreamError(Http2Error http2Error, String str, Object... objArr) {
        return new ClosedStreamCreationException(http2Error, formatErrorMessage(str, objArr));
    }

    public static Http2Exception connectionError(Http2Error http2Error, String str, Object... objArr) {
        return new Http2Exception(http2Error, formatErrorMessage(str, objArr));
    }

    private static String formatErrorMessage(String str, Object[] objArr) {
        if (str != null) {
            return String.format(str, objArr);
        }
        if (objArr == null || objArr.length == 0) {
            return "Unexpected error";
        }
        return "Unexpected error: " + Arrays.toString(objArr);
    }

    public static Http2Exception headerListSizeError(int i, Http2Error http2Error, boolean z, String str, Object... objArr) {
        return i == 0 ? connectionError(http2Error, str, objArr) : new HeaderListSizeException(i, http2Error, formatErrorMessage(str, objArr), z);
    }

    public static boolean isStreamError(Http2Exception http2Exception) {
        return http2Exception instanceof StreamException;
    }

    public static Http2Exception newStatic(Http2Error http2Error, String str, ShutdownHint shutdownHint2, Class<?> cls, String str2) {
        return (Http2Exception) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessHttp2Exception(http2Error, str, shutdownHint2, true) : new StacklessHttp2Exception(http2Error, str, shutdownHint2), cls, str2);
    }

    public static Http2Exception streamError(int i, Http2Error http2Error, String str, Object... objArr) {
        if (i == 0) {
            return connectionError(http2Error, str, objArr);
        }
        return new StreamException(i, http2Error, formatErrorMessage(str, objArr));
    }

    public static int streamId(Http2Exception http2Exception) {
        if (isStreamError(http2Exception)) {
            return ((StreamException) http2Exception).streamId();
        }
        return 0;
    }

    public Http2Error error() {
        return this.error;
    }

    public ShutdownHint shutdownHint() {
        return this.shutdownHint;
    }

    public static class StreamException extends Http2Exception {
        private static final long serialVersionUID = 602472544416984384L;
        private final int streamId;

        public StreamException(int i, Http2Error http2Error, String str) {
            super(http2Error, str, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i;
        }

        public int streamId() {
            return this.streamId;
        }

        public StreamException(int i, Http2Error http2Error, String str, Throwable th) {
            super(http2Error, str, th, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i;
        }
    }

    public Http2Exception(Http2Error http2Error) {
        this(http2Error, ShutdownHint.HARD_SHUTDOWN);
    }

    public static Http2Exception connectionError(Http2Error http2Error, Throwable th, String str, Object... objArr) {
        return new Http2Exception(http2Error, formatErrorMessage(str, objArr), th);
    }

    public Http2Exception(Http2Error http2Error, ShutdownHint shutdownHint2) {
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint2, "shutdownHint");
    }

    public static Http2Exception streamError(int i, Http2Error http2Error, Throwable th, String str, Object... objArr) {
        if (i == 0) {
            return connectionError(http2Error, th, str, objArr);
        }
        return new StreamException(i, http2Error, formatErrorMessage(str, objArr), th);
    }

    public Http2Exception(Http2Error http2Error, String str) {
        this(http2Error, str, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint2) {
        super(str);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint2, "shutdownHint");
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th) {
        this(http2Error, str, th, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th, ShutdownHint shutdownHint2) {
        super(str, th);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint2, "shutdownHint");
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint2, boolean z) {
        super(str, (Throwable) null, false, true);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint2, "shutdownHint");
    }
}
