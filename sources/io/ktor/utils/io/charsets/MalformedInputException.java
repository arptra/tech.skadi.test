package io.ktor.utils.io.charsets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/charsets/MalformedInputException;", "Ljava/nio/charset/MalformedInputException;", "message", "", "(Ljava/lang/String;)V", "_message", "getMessage", "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MalformedInputException extends java.nio.charset.MalformedInputException {
    @NotNull
    private final String _message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MalformedInputException(@NotNull String str) {
        super(0);
        Intrinsics.checkNotNullParameter(str, "message");
        this._message = str;
    }

    @Nullable
    public String getMessage() {
        return this._message;
    }
}
