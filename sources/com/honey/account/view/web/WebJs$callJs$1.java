package com.honey.account.view.web;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.honey.account.view.web.data.WebResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.web.WebJs$callJs$1", f = "WebJs.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WebJs$callJs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cbName;
    final /* synthetic */ WebResult<T> $result;
    int label;
    final /* synthetic */ WebJs this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebJs$callJs$1(WebJs webJs, String str, WebResult<T> webResult, Continuation<? super WebJs$callJs$1> continuation) {
        super(2, continuation);
        this.this$0 = webJs;
        this.$cbName = str;
        this.$result = webResult;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WebJs$callJs$1(this.this$0, this.$cbName, this.$result, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WebView access$getWebView$p = this.this$0.webView;
            access$getWebView$p.evaluateJavascript(this.$cbName + "('" + this.$result + "');", (ValueCallback) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WebJs$callJs$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
