package io.ktor.utils.io;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "cause", "", "b", "(Ljava/lang/Throwable;)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class ByteBufferChannelKt {
    public static final Void b(Throwable th) {
        Throwable th2;
        try {
            th2 = ExceptionUtilsJvmKt.e(th, th);
        } catch (Throwable unused) {
            th2 = null;
        }
        if (th2 != null) {
            th = th2;
        }
        throw th;
    }
}
