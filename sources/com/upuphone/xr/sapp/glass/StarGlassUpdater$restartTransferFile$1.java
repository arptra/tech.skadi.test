package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.glass.StarGlassUpdater;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.StarGlassUpdater$restartTransferFile$1", f = "StarGlassUpdater.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
public final class StarGlassUpdater$restartTransferFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    int label;
    final /* synthetic */ StarGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassUpdater$restartTransferFile$1(long j, GlassUpdateInfo glassUpdateInfo, StarGlassUpdater starGlassUpdater, File file, Continuation<? super StarGlassUpdater$restartTransferFile$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.$glassUpdateInfo = glassUpdateInfo;
        this.this$0 = starGlassUpdater;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarGlassUpdater$restartTransferFile$1(this.$delayTime, this.$glassUpdateInfo, this.this$0, this.$downloadFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$delayTime;
            this.label = 1;
            if (DelayKt.b(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        GlassUpdateInfo glassUpdateInfo = this.$glassUpdateInfo;
        companion.c("restartTransferFile, glassUpdateInfo: " + glassUpdateInfo);
        this.this$0.M(this.$downloadFile, this.$glassUpdateInfo, false);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarGlassUpdater$restartTransferFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
