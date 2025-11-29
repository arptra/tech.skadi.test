package com.upuphone.xr.sapp.glass;

import com.upuphone.star.download.manager.ExtendsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$downloadCompleted$1$md5$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$downloadCompleted$1$md5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $downloadFile;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$downloadCompleted$1$md5$1(File file, Continuation<? super GlassUpdateHelper$downloadCompleted$1$md5$1> continuation) {
        super(2, continuation);
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$downloadCompleted$1$md5$1(this.$downloadFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return ExtendsKt.a(this.$downloadFile);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((GlassUpdateHelper$downloadCompleted$1$md5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
