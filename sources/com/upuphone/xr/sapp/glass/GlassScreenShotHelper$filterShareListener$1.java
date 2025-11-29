package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/glass/GlassScreenShotHelper$filterShareListener$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassScreenShotHelper$filterShareListener$1 implements ShareListener {
    public void onError(String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "onError, taskId: " + str + ", code: " + i);
        if (str != null) {
            GlassScreenShotHelper.j.remove(str);
            if (!Intrinsics.areEqual((Object) str, (Object) GlassScreenShotHelper.d)) {
                delegate.a("GlassScreenShotHelper", "taskId mismatch, do noting");
            } else {
                GlassScreenShotHelper.b.H(str, 999);
            }
        }
    }

    public void onFinish(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "onFinish, taskId: " + str);
        if (str != null) {
            GlassScreenShotHelper.j.remove(str);
        }
    }

    public void onProgress(String str, Uri uri, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "onProgress, taskId: " + str + ", uri: " + uri + ", progress: " + i);
        if (str != null && Intrinsics.areEqual((Object) str, (Object) GlassScreenShotHelper.d)) {
            GlassScreenShotHelper.b.G(str, i);
        }
    }

    public void onStart(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "onStart, taskId: " + str);
        if (str != null) {
            GlassScreenShotHelper.j.add(str);
            GlassScreenShotHelper.b.w();
        }
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "onSuccess, taskId: " + str + " , sendUri: " + uri + ", receiveUri: " + uri2);
        if (str != null) {
            if (!Intrinsics.areEqual((Object) str, (Object) GlassScreenShotHelper.d)) {
                delegate.c("GlassScreenShotHelper", "taskId mismatch, do noting");
            } else if (uri2 == null) {
                GlassScreenShotHelper.b.H(str, 999);
            } else {
                Job unused = BuildersKt__Builders_commonKt.d(GlassScreenShotHelper.b, (CoroutineContext) null, (CoroutineStart) null, new GlassScreenShotHelper$filterShareListener$1$onSuccess$1(uri2, str, (Continuation<? super GlassScreenShotHelper$filterShareListener$1$onSuccess$1>) null), 3, (Object) null);
            }
        }
    }
}
