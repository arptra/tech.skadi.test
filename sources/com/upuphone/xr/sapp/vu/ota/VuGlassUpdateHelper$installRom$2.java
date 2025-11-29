package com.upuphone.xr.sapp.vu.ota;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVuGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassUpdateHelper.kt\ncom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper$installRom$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n314#2,11:429\n*S KotlinDebug\n*F\n+ 1 VuGlassUpdateHelper.kt\ncom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper$installRom$2\n*L\n205#1:429,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$2", f = "VuGlassUpdateHelper.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassUpdateHelper$installRom$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ Function1<Integer, Unit> $onProgress;
    final /* synthetic */ int $type;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateHelper$installRom$2(File file, int i, Function1<? super Integer, Unit> function1, Continuation<? super VuGlassUpdateHelper$installRom$2> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$type = i;
        this.$onProgress = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassUpdateHelper$installRom$2(this.$file, this.$type, this.$onProgress, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            File file = this.$file;
            int i2 = this.$type;
            Function1<Integer, Unit> function1 = this.$onProgress;
            this.L$0 = file;
            this.L$1 = function1;
            this.I$0 = i2;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            VuGlassUpdateHelper$installRom$2$1$listener$1 vuGlassUpdateHelper$installRom$2$1$listener$1 = new VuGlassUpdateHelper$installRom$2$1$listener$1(cancellableContinuationImpl, i2, function1);
            cancellableContinuationImpl.E(new VuGlassUpdateHelper$installRom$2$1$1(vuGlassUpdateHelper$installRom$2$1$listener$1));
            VuGlassesEventDispatcher vuGlassesEventDispatcher = VuGlassesEventDispatcher.f8098a;
            vuGlassesEventDispatcher.g(vuGlassUpdateHelper$installRom$2$1$listener$1);
            try {
                ULog.Delegate delegate = ULog.f6446a;
                String path = file.getPath();
                delegate.g("VuGlassUpdateHelper", "setFirmwareFilepath start: " + path + ", type: " + i2);
                VuGlassesHidUtil vuGlassesHidUtil = VuGlassesHidUtil.f8104a;
                String path2 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                boolean A = vuGlassesHidUtil.A(path2, i2);
                String path3 = file.getPath();
                delegate.g("VuGlassUpdateHelper", "setFirmwareFilepath end: " + path3 + ", type: " + i2 + ", installResult: " + A);
                if (!A) {
                    vuGlassesEventDispatcher.q(vuGlassUpdateHelper$installRom$2$1$listener$1);
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Boxing.boxBoolean(false)));
                }
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.c("VuGlassUpdateHelper", "installRom: " + e);
                VuGlassesEventDispatcher.f8098a.q(vuGlassUpdateHelper$installRom$2$1$listener$1);
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Boxing.boxBoolean(false)));
            }
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Function1 function12 = (Function1) this.L$1;
            File file2 = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((VuGlassUpdateHelper$installRom$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
