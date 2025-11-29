package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.sapp.widget.CommonNetErrorView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciFileTipsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity$onLoadPageFail$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,258:1\n262#2,2:259\n*S KotlinDebug\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity$onLoadPageFail$1\n*L\n210#1:259,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciFileTipsActivity$onLoadPageFail$1", f = "TiciFileTipsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciFileTipsActivity$onLoadPageFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciFileTipsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciFileTipsActivity$onLoadPageFail$1(TiciFileTipsActivity ticiFileTipsActivity, Continuation<? super TiciFileTipsActivity$onLoadPageFail$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiFileTipsActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciFileTipsActivity$onLoadPageFail$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int y0 = this.this$0.d;
            CommonExtKt.e("onLoadPageFail, loadCount: " + y0, "TiciFileTipsActivity");
            if (this.this$0.d < 2) {
                CommonExtKt.e("onLoadPageFail, retry", "TiciFileTipsActivity");
                this.this$0.H0(false);
            } else {
                this.this$0.c = true;
                CommonNetErrorView commonNetErrorView = this.this$0.F0().b;
                Intrinsics.checkNotNullExpressionValue(commonNetErrorView, "coommonError");
                commonNetErrorView.setVisibility(0);
                this.this$0.F0().b.setErrorType(1);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciFileTipsActivity$onLoadPageFail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
