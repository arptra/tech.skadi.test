package io.ktor.websocket;

import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0000H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/FrameTooBigException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/CopyableThrowable;", "frameSize", "", "(J)V", "getFrameSize", "()J", "message", "", "getMessage", "()Ljava/lang/String;", "createCopy", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FrameTooBigException extends Exception implements CopyableThrowable<FrameTooBigException> {
    private final long frameSize;

    public FrameTooBigException(long j) {
        this.frameSize = j;
    }

    public final long getFrameSize() {
        return this.frameSize;
    }

    @NotNull
    public String getMessage() {
        return "Frame is too big: " + this.frameSize;
    }

    @NotNull
    public FrameTooBigException createCopy() {
        FrameTooBigException frameTooBigException = new FrameTooBigException(this.frameSize);
        ExceptionUtilsJvmKt.a(frameTooBigException, this);
        return frameTooBigException;
    }
}
