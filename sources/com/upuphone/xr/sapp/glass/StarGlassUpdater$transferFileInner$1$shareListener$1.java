package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import com.upuphone.xr.sapp.glass.StarGlassUpdater;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/glass/StarGlassUpdater$transferFileInner$1$shareListener$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarGlassUpdater$transferFileInner$1$shareListener$1 implements ShareListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarGlassUpdater f7071a;
    public final /* synthetic */ GlassUpdateInfo b;
    public final /* synthetic */ String c;
    public final /* synthetic */ File d;

    public StarGlassUpdater$transferFileInner$1$shareListener$1(StarGlassUpdater starGlassUpdater, GlassUpdateInfo glassUpdateInfo, String str, File file) {
        this.f7071a = starGlassUpdater;
        this.b = glassUpdateInfo;
        this.c = str;
        this.d = file;
    }

    public void onError(String str, int i) {
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        companion.d("ShareListener-onError, taskId: " + str + ", code: " + i);
        this.f7071a.d.b();
        this.f7071a.N(200);
        this.f7071a.H(this.d, this.b, this.c);
    }

    public void onFinish(String str) {
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        companion.c("ShareListener-onFinish, taskId: " + str);
        this.f7071a.d.b();
        this.f7071a.N(200);
        this.f7071a.G(this.b, this.c, 1500);
    }

    public void onProgress(String str, Uri uri, int i) {
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        companion.c("ShareListener-onProgress, taskId: " + str + ", progress: " + i);
    }

    public void onStart(String str) {
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        companion.c("ShareListener-onStart, taskId: " + str);
        if (str != null) {
            StarGlassUpdater starGlassUpdater = this.f7071a;
            starGlassUpdater.L(str, this.b, this.c, starGlassUpdater.E());
        }
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        StarGlassUpdater.Companion companion = StarGlassUpdater.j;
        companion.c("ShareListener-onSuccess, taskId: " + str + ", sendUri: " + uri + ", receiveUri: " + uri2);
    }
}
