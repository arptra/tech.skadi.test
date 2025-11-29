package io.ktor.websocket.serialization;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSession;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 1, 1}, l = {95, 104}, m = "receiveDeserializedBase", n = {"typeInfo", "converter", "charset", "typeInfo", "frame"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class WebsocketChannelSerializationKt$receiveDeserializedBase$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public WebsocketChannelSerializationKt$receiveDeserializedBase$2(Continuation<? super WebsocketChannelSerializationKt$receiveDeserializedBase$2> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WebsocketChannelSerializationKt.a((WebSocketSession) null, (TypeInfo) null, (WebsocketContentConverter) null, (Charset) null, this);
    }
}
