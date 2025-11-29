package com.xjmz.myvu.account;

import android.widget.TextView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AccountInfo;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.DebugLoginActivity$onCreate$2$1", f = "DebugLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DebugLoginActivity$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugLoginActivity$onCreate$2$1(DebugLoginActivity debugLoginActivity, Continuation<? super DebugLoginActivity$onCreate$2$1> continuation) {
        super(2, continuation);
        this.this$0 = debugLoginActivity;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(AccountInfo accountInfo, CoroutineScope coroutineScope, DebugLoginActivity debugLoginActivity) {
        Unit unit;
        if (accountInfo != null) {
            TextView textView = debugLoginActivity.C0().l;
            String phone = accountInfo.getPhone();
            String id = accountInfo.getId();
            String mzUid = accountInfo.getMzUid();
            textView.setText(phone + " - " + id + " - " + mzUid);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            debugLoginActivity.C0().l.setText("没有用户信息");
        }
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DebugLoginActivity$onCreate$2$1 debugLoginActivity$onCreate$2$1 = new DebugLoginActivity$onCreate$2$1(this.this$0, continuation);
        debugLoginActivity$onCreate$2$1.L$0 = obj;
        return debugLoginActivity$onCreate$2$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AccountInfo a2 = MzAccountManager.c.a();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("DebugLoginActivity", "accountInfo-> " + a2);
            DebugLoginActivity debugLoginActivity = this.this$0;
            debugLoginActivity.runOnUiThread(new c(a2, (CoroutineScope) this.L$0, debugLoginActivity));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DebugLoginActivity$onCreate$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
