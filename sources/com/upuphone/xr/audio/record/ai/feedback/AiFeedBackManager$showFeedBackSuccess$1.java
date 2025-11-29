package com.upuphone.xr.audio.record.ai.feedback;

import android.content.Context;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.sapp.audio.record.R;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$showFeedBackSuccess$1", f = "AiFeedBackManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiFeedBackManager$showFeedBackSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AiFeedBackResponse $mockResponse;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiFeedBackManager$showFeedBackSuccess$1(AiFeedBackResponse aiFeedBackResponse, Continuation<? super AiFeedBackManager$showFeedBackSuccess$1> continuation) {
        super(2, continuation);
        this.$mockResponse = aiFeedBackResponse;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiFeedBackManager$showFeedBackSuccess$1(this.$mockResponse, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UToast.Companion companion = UToast.f6444a;
            SdkContext sdkContext = SdkContext.f6675a;
            Context context = sdkContext.c().getContext();
            String string = sdkContext.c().getContext().getString(R.string.fast_record_has_finish_feedback);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(context, string);
            ULog.Delegate delegate = ULog.f6446a;
            AiFeedBackResponse aiFeedBackResponse = this.$mockResponse;
            delegate.c("AiFeedBackManager", "reportAiIllegalEvent mockResponse = " + aiFeedBackResponse);
            ReportCallback a2 = AiFeedBackManager.c;
            if (a2 != null) {
                a2.onSuccess(this.$mockResponse);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiFeedBackManager$showFeedBackSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
