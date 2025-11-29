package io.ktor.websocket;

import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0000H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lio/ktor/websocket/ProtocolViolationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/CopyableThrowable;", "violation", "", "(Ljava/lang/String;)V", "message", "getMessage", "()Ljava/lang/String;", "getViolation", "createCopy", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtocolViolationException extends Exception implements CopyableThrowable<ProtocolViolationException> {
    @NotNull
    private final String violation;

    public ProtocolViolationException(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "violation");
        this.violation = str;
    }

    @NotNull
    public String getMessage() {
        return "Received illegal frame: " + this.violation;
    }

    @NotNull
    public final String getViolation() {
        return this.violation;
    }

    @NotNull
    public ProtocolViolationException createCopy() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException(this.violation);
        ExceptionUtilsJvmKt.a(protocolViolationException, this);
        return protocolViolationException;
    }
}
