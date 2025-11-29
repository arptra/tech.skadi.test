package com.upuphone.xr.sapp.debug;

import android.net.Uri;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import com.upuphone.xr.sapp.glass.GlassLogUpdateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/debug/SuperAppDebugActivity$shareListener$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperAppDebugActivity$shareListener$1 implements ShareListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperAppDebugActivity f6932a;

    public SuperAppDebugActivity$shareListener$1(SuperAppDebugActivity superAppDebugActivity) {
        this.f6932a = superAppDebugActivity;
    }

    public void onError(String str, int i) {
        SuperAppDebugActivity superAppDebugActivity = this.f6932a;
        superAppDebugActivity.S0("requestGlassLog::onError, taskId->" + str + ", code->" + i);
        GlassLogUpdateHelper.e.a().i();
        this.f6932a.V0();
    }

    public void onFinish(String str) {
        SuperAppDebugActivity superAppDebugActivity = this.f6932a;
        superAppDebugActivity.S0("requestGlassLog::onFinish, taskId->" + str);
        GlassLogUpdateHelper.e.a().i();
    }

    public void onProgress(String str, Uri uri, int i) {
        SuperAppDebugActivity superAppDebugActivity = this.f6932a;
        superAppDebugActivity.S0("requestGlassLog::onProgress, taskId->" + str + ", uri->" + uri + ", progress->" + i);
        this.f6932a.b.removeCallbacksAndMessages((Object) null);
    }

    public void onStart(String str) {
        SuperAppDebugActivity superAppDebugActivity = this.f6932a;
        superAppDebugActivity.S0("requestGlassLog::onStart, taskId->" + str);
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        SuperAppDebugActivity superAppDebugActivity = this.f6932a;
        superAppDebugActivity.S0("requestGlassLog::onSuccess, taskId->" + str + ", sendUri->" + uri + ", receiveUri->" + uri2);
        if (uri2 != null) {
            if (BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new SuperAppDebugActivity$shareListener$1$onSuccess$1$1(this.f6932a, uri2, (Continuation<? super SuperAppDebugActivity$shareListener$1$onSuccess$1$1>) null), 3, (Object) null) != null) {
                return;
            }
        }
        this.f6932a.V0();
        Unit unit = Unit.INSTANCE;
    }
}
