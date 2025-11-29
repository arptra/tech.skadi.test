package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$showAsrDuringProgress$1", f = "FastRecordHistoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryDetailActivity$showAsrDuringProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsrDuringProgress $event;
    int label;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$showAsrDuringProgress$1(AsrDuringProgress asrDuringProgress, FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, Continuation<? super FastRecordHistoryDetailActivity$showAsrDuringProgress$1> continuation) {
        super(2, continuation);
        this.$event = asrDuringProgress;
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryDetailActivity$showAsrDuringProgress$1(this.$event, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$event.isFail() && !this.$event.isFinish() && this.$event.getCurAsrTime() > 0 && this.$event.getTotalTime() > 0) {
                String string = this.this$0.getString(R.string.fast_record_loading);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (RecordViewKt.isRtl(this.this$0)) {
                    str = " %" + ((int) ((((float) this.$event.getCurAsrTime()) / ((float) this.$event.getTotalTime())) * ((float) 100)));
                } else {
                    str = " " + ((int) ((((float) this.$event.getCurAsrTime()) / ((float) this.$event.getTotalTime())) * ((float) 100))) + "%";
                }
                this.this$0.getLayout().h.c.setText(string + str);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryDetailActivity$showAsrDuringProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
