package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import android.content.Context;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.star.common.phone.UToast;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$showComplianceFail$1", f = "FastRecordHistoryAsrOperator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperator$showComplianceFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $action;
    final /* synthetic */ String $msgCode;
    final /* synthetic */ String $msgContent;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$showComplianceFail$1(String str, String str2, String str3, Continuation<? super FastRecordHistoryAsrOperator$showComplianceFail$1> continuation) {
        super(2, continuation);
        this.$action = str;
        this.$msgContent = str2;
        this.$msgCode = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperator$showComplianceFail$1(this.$action, this.$msgContent, this.$msgCode, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context appContext = FastRecordManager.Companion.getInstance().appContext();
            if (Intrinsics.areEqual((Object) "LOCKED", (Object) this.$action)) {
                UToast.f6444a.d(appContext, this.$msgContent);
            } else if (Intrinsics.areEqual((Object) "2001", (Object) this.$msgCode)) {
                UToast.Companion companion = UToast.f6444a;
                String string = appContext.getString(R.string.fr_extract_sensitive_req_tips);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(appContext, string);
            } else {
                UToast.Companion companion2 = UToast.f6444a;
                String string2 = appContext.getString(R.string.fr_extract_sensitive_rep_tips);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                companion2.d(appContext, string2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperator$showComplianceFail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
