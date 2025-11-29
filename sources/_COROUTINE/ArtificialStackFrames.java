package _COROUTINE;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"L_COROUTINE/ArtificialStackFrames;", "", "<init>", "()V", "Ljava/lang/StackTraceElement;", "b", "()Ljava/lang/StackTraceElement;", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class ArtificialStackFrames {
    public final StackTraceElement a() {
        return CoroutineDebuggingKt.b(new Exception(), _BOUNDARY.class.getSimpleName());
    }

    public final StackTraceElement b() {
        return CoroutineDebuggingKt.b(new Exception(), _CREATION.class.getSimpleName());
    }
}
