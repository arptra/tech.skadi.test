package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.sapp.utils.NetworkUtils;
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

@SourceDebugExtension({"SMAP\nTiciFileTipsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity$loadPage$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,258:1\n262#2,2:259\n*S KotlinDebug\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity$loadPage$1\n*L\n181#1:259,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciFileTipsActivity$loadPage$1", f = "TiciFileTipsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciFileTipsActivity$loadPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFreshStart;
    int label;
    final /* synthetic */ TiciFileTipsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciFileTipsActivity$loadPage$1(TiciFileTipsActivity ticiFileTipsActivity, boolean z, Continuation<? super TiciFileTipsActivity$loadPage$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiFileTipsActivity;
        this.$isFreshStart = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciFileTipsActivity$loadPage$1(this.this$0, this.$isFreshStart, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean g = NetworkUtils.f7898a.g();
            CommonExtKt.e("loadPage, hasNetwork: " + g, "TiciFileTipsActivity");
            CommonNetErrorView commonNetErrorView = this.this$0.F0().b;
            Intrinsics.checkNotNullExpressionValue(commonNetErrorView, "coommonError");
            commonNetErrorView.setVisibility(g ^ true ? 0 : 8);
            if (g) {
                String v0 = this.this$0.E0();
                CommonExtKt.e("loadUrl: " + v0, "TiciFileTipsActivity");
                this.this$0.F0().d.loadUrl(v0);
                if (this.$isFreshStart) {
                    this.this$0.d = 1;
                } else {
                    TiciFileTipsActivity ticiFileTipsActivity = this.this$0;
                    ticiFileTipsActivity.d = ticiFileTipsActivity.d + 1;
                }
            } else {
                this.this$0.c = true;
                this.this$0.F0().b.setErrorType(0);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciFileTipsActivity$loadPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
