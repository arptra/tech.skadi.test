package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {157}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
public final class EncodersJvmKt$inflateTo$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    public EncodersJvmKt$inflateTo$1(Continuation<? super EncodersJvmKt$inflateTo$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EncodersJvmKt.d((Inflater) null, (ByteWriteChannel) null, (ByteBuffer) null, (Checksum) null, this);
    }
}
