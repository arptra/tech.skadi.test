package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/glass/AirGlassUpdater$handleRequestSendFile$1$shareListener$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AirGlassUpdater$handleRequestSendFile$1$shareListener$1 implements ShareListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirGlassUpdater f7037a;
    public final /* synthetic */ AirUpdateFileInfo b;

    public AirGlassUpdater$handleRequestSendFile$1$shareListener$1(AirGlassUpdater airGlassUpdater, AirUpdateFileInfo airUpdateFileInfo) {
        this.f7037a = airGlassUpdater;
        this.b = airUpdateFileInfo;
    }

    public void onError(String str, int i) {
        AirGlassUpdater.Companion companion = AirGlassUpdater.g;
        companion.d("ShareListener-onError, taskId: " + str + ", code: " + i);
        this.f7037a.d.b();
    }

    public void onFinish(String str) {
        AirGlassUpdater.Companion companion = AirGlassUpdater.g;
        companion.c("ShareListener-onFinish, taskId: " + str);
        this.f7037a.d.b();
    }

    public void onProgress(String str, Uri uri, int i) {
        AirGlassUpdater.Companion companion = AirGlassUpdater.g;
        companion.c("ShareListener-onProgress, taskId: " + str + ", progress: " + i);
    }

    public void onStart(String str) {
        AirGlassUpdater.Companion companion = AirGlassUpdater.g;
        companion.c("ShareListener-onStart, taskId: " + str);
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        AirGlassUpdater.Companion companion = AirGlassUpdater.g;
        companion.c("ShareListener-onSuccess, taskId: " + str + ", sendUri: " + uri + ", receiveUri: " + uri2);
        this.f7037a.f.add(this.b.getFilePath());
        this.f7037a.F();
    }
}
