package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$restartDownload$1", f = "UnicronUpdateHelper.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$restartDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$restartDownload$1(long j, GlassUpdateInfo glassUpdateInfo, Continuation<? super UnicronUpdateHelper$restartDownload$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$restartDownload$1(this.$delayTime, this.$glassUpdateInfo, continuation);
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
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        GlassUpdateInfo glassUpdateInfo = this.$glassUpdateInfo;
        unicronUpdateHelper.L("restartDownload, glassUpdateInfo: " + glassUpdateInfo);
        UnicronUpdateHelper.Z(unicronUpdateHelper, GlobalExtKt.f(), this.$glassUpdateInfo, false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$restartDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
