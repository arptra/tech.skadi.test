package com.upuphone.xr.sapp.fragment;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import com.xjsd.ai.assistant.chatgpt.ChatGptAbility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.ChatGptHistoryH5Fragment$loadUrl$1", f = "ChatGptHistoryH5Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatGptHistoryH5Fragment$loadUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatGptHistoryH5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatGptHistoryH5Fragment$loadUrl$1(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment, Continuation<? super ChatGptHistoryH5Fragment$loadUrl$1> continuation) {
        super(2, continuation);
        this.this$0 = chatGptHistoryH5Fragment;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1$lambda$0(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment, String str) {
        chatGptHistoryH5Fragment.O0(0);
        chatGptHistoryH5Fragment.I0().loadUrl(str);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$2(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment) {
        chatGptHistoryH5Fragment.O0(-2);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatGptHistoryH5Fragment$loadUrl$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ChatGptAbility D0 = this.this$0.H0();
            if (D0 == null || (str = D0.getRecordsPagePath()) == null) {
                str = "";
            }
            if (!StringsKt.isBlank(str)) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ChatGptHistoryH5Fragment", "initWebView url is: " + str);
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    Boxing.boxBoolean(new Handler(activity.getMainLooper()).post(new a(this.this$0, str)));
                }
            } else {
                ULog.f6446a.a("ChatGptHistoryH5Fragment", "刷新token失败");
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    Boxing.boxBoolean(new Handler(activity2.getMainLooper()).post(new b(this.this$0)));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatGptHistoryH5Fragment$loadUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
