package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataStoreUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/xr/sapp/utils/DataStoreUtils$hasUnassociatedData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,279:1\n53#2:280\n55#2:284\n50#3:281\n55#3:283\n107#4:282\n*S KotlinDebug\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/xr/sapp/utils/DataStoreUtils$hasUnassociatedData$1\n*L\n117#1:280\n117#1:284\n117#1:281\n117#1:283\n117#1:282\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataStoreUtils$hasUnassociatedData$1", f = "DataStoreUtils.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
final class DataStoreUtils$hasUnassociatedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $mContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$hasUnassociatedData$1(DataStoreUtils dataStoreUtils, Context context, Continuation<? super DataStoreUtils$hasUnassociatedData$1> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreUtils;
        this.$mContext = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataStoreUtils$hasUnassociatedData$1 dataStoreUtils$hasUnassociatedData$1 = new DataStoreUtils$hasUnassociatedData$1(this.this$0, this.$mContext, continuation);
        dataStoreUtils$hasUnassociatedData$1.L$0 = obj;
        return dataStoreUtils$hasUnassociatedData$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DataStoreUtils dataStoreUtils = this.this$0;
            Context context = this.$mContext;
            Result.Companion companion = Result.Companion;
            DataStoreUtils$hasUnassociatedData$1$invokeSuspend$lambda$1$$inlined$map$1 dataStoreUtils$hasUnassociatedData$1$invokeSuspend$lambda$1$$inlined$map$1 = new DataStoreUtils$hasUnassociatedData$1$invokeSuspend$lambda$1$$inlined$map$1(dataStoreUtils.k(context).getData(), "notification_brighten_screen_key");
            this.label = 1;
            obj = FlowKt.w(dataStoreUtils$hasUnassociatedData$1$invokeSuspend$lambda$1$$inlined$map$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m20constructorimpl((Boolean) obj);
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        Boolean bool = (Boolean) obj2;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DataStoreUtils", "hasUnassociatedData " + bool);
        if (bool == null) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((DataStoreUtils$hasUnassociatedData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
