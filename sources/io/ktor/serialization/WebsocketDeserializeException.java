package io.ktor.serialization;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/serialization/WebsocketDeserializeException;", "Lio/ktor/serialization/WebsocketContentConvertException;", "message", "", "cause", "", "frame", "Lio/ktor/websocket/Frame;", "(Ljava/lang/String;Ljava/lang/Throwable;Lio/ktor/websocket/Frame;)V", "getFrame", "()Lio/ktor/websocket/Frame;", "ktor-serialization"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebsocketDeserializeException extends WebsocketContentConvertException {
    @NotNull
    private final Frame frame;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebsocketDeserializeException(String str, Throwable th, Frame frame2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th, frame2);
    }

    @NotNull
    public final Frame getFrame() {
        return this.frame;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebsocketDeserializeException(@NotNull String str, @Nullable Throwable th, @NotNull Frame frame2) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(frame2, "frame");
        this.frame = frame2;
    }
}
