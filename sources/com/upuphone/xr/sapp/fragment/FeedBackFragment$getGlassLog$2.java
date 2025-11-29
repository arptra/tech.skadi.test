package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.glass.GlassLogUpdateHelper;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFeedBackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$getGlassLog$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,815:1\n314#2,11:816\n*S KotlinDebug\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$getGlassLog$2\n*L\n527#1:816,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FeedBackFragment$getGlassLog$2", f = "FeedBackFragment.kt", i = {}, l = {816}, m = "invokeSuspend", n = {}, s = {})
public final class FeedBackFragment$getGlassLog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    int label;

    public FeedBackFragment$getGlassLog$2(Continuation<? super FeedBackFragment$getGlassLog$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBackFragment$getGlassLog$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            if (DynamicOperateUtil.f7880a.h() >= 3) {
                GlassLogUpdateHelper.e.a().d(new FeedBackFragment$getGlassLog$2$1$1(cancellableContinuationImpl));
                SuperMessageManger a2 = SuperMessageManger.m.a();
                Boolean bool = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
                a2.p(bool.booleanValue() ? "/data/data/com.upuphone.star.launcher.intl/files/ulog/" : "");
            } else {
                ULog.f6446a.a("FeedBackFragment", "getGlassLog glass not support");
                cancellableContinuationImpl.resumeWith(Result.m20constructorimpl((Object) null));
            }
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super File> continuation) {
        return ((FeedBackFragment$getGlassLog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
