package com.upuphone.ai.ttsengine.engines.cloud;

import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket2$onMessage$1", f = "TtsWebsocket2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsWebsocket2$onMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ byte[] $payload;
    final /* synthetic */ int $sequenceNumber;
    int label;
    final /* synthetic */ TtsWebsocket2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsWebsocket2$onMessage$1(TtsWebsocket2 ttsWebsocket2, byte[] bArr, byte[] bArr2, int i, Continuation<? super TtsWebsocket2$onMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = ttsWebsocket2;
        this.$data = bArr;
        this.$payload = bArr2;
        this.$sequenceNumber = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsWebsocket2$onMessage$1(this.this$0, this.$data, this.$payload, this.$sequenceNumber, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        File parentFile;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String b = this.this$0.c;
            int a2 = this.this$0.d;
            File file = new File(b + "/source_audio_" + a2 + ".data");
            File parentFile2 = file.getParentFile();
            if (!(parentFile2 == null || parentFile2.exists() || (parentFile = file.getParentFile()) == null)) {
                Boxing.boxBoolean(parentFile.mkdirs());
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            byte[] bArr = this.$data;
            Intrinsics.checkNotNullExpressionValue(bArr, "$data");
            FilesKt.writeBytes(file, bArr);
            String b2 = this.this$0.c;
            int a3 = this.this$0.d;
            File file2 = new File(b2 + "/oggopus_audio_" + a3 + ".data");
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            byte[] bArr2 = this.$payload;
            byte[] copyOf = Arrays.copyOf(bArr2, bArr2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            FilesKt.writeBytes(file2, copyOf);
            TtsWebsocket2 ttsWebsocket2 = this.this$0;
            ttsWebsocket2.d = ttsWebsocket2.d + 1;
            if (this.$sequenceNumber < 0) {
                this.this$0.d = 0;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsWebsocket2$onMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
