package com.xjmz.myvu.account;

import android.content.Intent;
import com.upuphone.xr.account.interfaces.MzAuthListener;
import com.xjmz.myvu.account.MzTokenResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, d2 = {"com/xjmz/myvu/account/AccountManager$getMzToken$2$1", "Lcom/upuphone/xr/account/interfaces/MzAuthListener;", "onHandleIntent", "", "intent", "Landroid/content/Intent;", "onOriginalError", "p0", "", "p1", "p2", "", "onSuccess", "token", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$getMzToken$2$1 implements MzAuthListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8219a;
    public final /* synthetic */ boolean b;

    public AccountManager$getMzToken$2$1(CancellableContinuation cancellableContinuation, boolean z) {
        this.f8219a = cancellableContinuation;
        this.b = z;
    }

    public void onHandleIntent(Intent intent) {
        if (this.f8219a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f8219a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(new MzTokenResult(0, (String) null, intent, (MzTokenResult.OriginError) null, 10, (DefaultConstructorMarker) null)));
        }
    }

    public void onOriginalError(int i, int i2, String str) {
        if (this.f8219a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f8219a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(new MzTokenResult(2, (String) null, (Intent) null, new MzTokenResult.OriginError(i, i2, str), 6, (DefaultConstructorMarker) null)));
        }
    }

    public void onSuccess(String str) {
        if (this.f8219a.isActive()) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AccountManager$getMzToken$2$1$onSuccess$1(this.b, str, this.f8219a, (Continuation<? super AccountManager$getMzToken$2$1$onSuccess$1>) null), 3, (Object) null);
        }
    }
}
