package io.netty.channel;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;

public class ChannelException extends RuntimeException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2908618315971075004L;

    public static final class StacklessChannelException extends ChannelException {
        private static final long serialVersionUID = -6384642137753538579L;

        public StacklessChannelException(String str, Throwable th) {
            super(str, th);
        }

        public Throwable fillInStackTrace() {
            return this;
        }

        public StacklessChannelException(String str, Throwable th, boolean z) {
            super(str, th, z);
        }
    }

    public ChannelException() {
    }

    public static ChannelException newStatic(String str, Class<?> cls, String str2) {
        return (ChannelException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessChannelException(str, (Throwable) null, true) : new StacklessChannelException(str, (Throwable) null), cls, str2);
    }

    public ChannelException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelException(String str) {
        super(str);
    }

    public ChannelException(Throwable th) {
        super(th);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    public ChannelException(String str, Throwable th, boolean z) {
        super(str, th, false, true);
    }
}
