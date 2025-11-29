package com.xjmz.myvu.account;

import android.content.Intent;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
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
@DebugMetadata(c = "com.xjmz.myvu.account.DebugLoginActivity$onCreate$1$1", f = "DebugLoginActivity.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class DebugLoginActivity$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugLoginActivity$onCreate$1$1(DebugLoginActivity debugLoginActivity, Continuation<? super DebugLoginActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugLoginActivity;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(DebugLoginActivity debugLoginActivity, MzTokenResult mzTokenResult) {
        debugLoginActivity.C0().h.setText(mzTokenResult.d());
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(DebugLoginActivity debugLoginActivity) {
        debugLoginActivity.C0().h.setText("");
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DebugLoginActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AccountManager accountManager = AccountManager.f8217a;
            this.label = 1;
            obj = accountManager.l(false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MzTokenResult mzTokenResult = (MzTokenResult) obj;
        int c = mzTokenResult.c();
        if (c == 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("DebugLoginActivity", "doLogin() 没有mztoken, 跳转到mz登陆. ");
            Intent a2 = mzTokenResult.a();
            delegate.g("DebugLoginActivity", "doLogin() intent: " + a2);
            Intent a3 = mzTokenResult.a();
            if (a3 != null) {
                DebugLoginActivity debugLoginActivity = this.this$0;
                if (Intrinsics.areEqual((Object) "com.meizu.account.action.auth_grant", (Object) a3.getAction())) {
                    debugLoginActivity.startActivityForResult(a3, MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
                } else {
                    debugLoginActivity.startActivityForResult(a3, 10000);
                }
            } else {
                AnonymousClass2 r5 = AnonymousClass2.INSTANCE;
            }
        } else if (c == 1) {
            ULog.f6446a.a("DebugLoginActivity", "onCreate-> 获取成功");
            DebugLoginActivity debugLoginActivity2 = this.this$0;
            debugLoginActivity2.runOnUiThread(new a(debugLoginActivity2, mzTokenResult));
        } else if (c == 2) {
            ULog.f6446a.a("DebugLoginActivity", "onCreate-> 获取失败");
            DebugLoginActivity debugLoginActivity3 = this.this$0;
            debugLoginActivity3.runOnUiThread(new b(debugLoginActivity3));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DebugLoginActivity$onCreate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
