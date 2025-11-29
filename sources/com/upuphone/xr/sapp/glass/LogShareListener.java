package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\bJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0003R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/glass/LogShareListener;", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "<init>", "()V", "", "taskId", "", "onStart", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "uri", "", "progress", "onProgress", "(Ljava/lang/String;Landroid/net/Uri;I)V", "sendUri", "receiveUri", "onSuccess", "(Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;)V", "onFinish", "code", "onError", "(Ljava/lang/String;I)V", "shareListener", "a", "(Lcom/upuphone/starrynetsdk/ability/share/ShareListener;)V", "c", "b", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "Ljava/lang/String;", "filterTaskId", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LogShareListener implements ShareListener {

    /* renamed from: a  reason: collision with root package name */
    public ShareListener f7069a;
    public String b;

    public final void a(ShareListener shareListener) {
        this.f7069a = shareListener;
    }

    public final void b() {
        this.f7069a = null;
        this.b = null;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        this.b = str;
    }

    public void onError(String str, int i) {
        ShareListener shareListener;
        if (Intrinsics.areEqual((Object) this.b, (Object) str) && (shareListener = this.f7069a) != null) {
            shareListener.onError(str, i);
        }
    }

    public void onFinish(String str) {
        ShareListener shareListener;
        if (Intrinsics.areEqual((Object) this.b, (Object) str) && (shareListener = this.f7069a) != null) {
            shareListener.onFinish(str);
        }
    }

    public void onProgress(String str, Uri uri, int i) {
        ShareListener shareListener;
        if (Intrinsics.areEqual((Object) this.b, (Object) str) && (shareListener = this.f7069a) != null) {
            shareListener.onProgress(str, uri, i);
        }
    }

    public void onStart(String str) {
        ShareListener shareListener = this.f7069a;
        if (shareListener != null) {
            shareListener.onStart(str);
        }
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        ShareListener shareListener;
        if (Intrinsics.areEqual((Object) this.b, (Object) str) && (shareListener = this.f7069a) != null) {
            shareListener.onSuccess(str, uri, uri2);
        }
    }
}
