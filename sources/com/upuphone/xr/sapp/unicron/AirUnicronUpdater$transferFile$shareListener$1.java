package com.upuphone.xr.sapp.unicron;

import android.net.Uri;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/unicron/AirUnicronUpdater$transferFile$shareListener$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AirUnicronUpdater$transferFile$shareListener$1 implements ShareListener {
    public void onError(String str, int i) {
        AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
        airUnicronUpdater.r("ShareListener-onError, taskId: " + str + ", code: " + i);
        AirUnicronUpdater.d.b();
    }

    public void onFinish(String str) {
        AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
        airUnicronUpdater.q("ShareListener-onFinish, taskId: " + str);
        AirUnicronUpdater.d.b();
    }

    public void onProgress(String str, Uri uri, int i) {
        AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
        airUnicronUpdater.q("ShareListener-onProgress, taskId: " + str + ", progress: " + i);
    }

    public void onStart(String str) {
        AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
        airUnicronUpdater.q("ShareListener-onStart, taskId: " + str);
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
        airUnicronUpdater.q("ShareListener-onSuccess, taskId: " + str + ", sendUri: " + uri + ", receiveUri: " + uri2);
    }
}
