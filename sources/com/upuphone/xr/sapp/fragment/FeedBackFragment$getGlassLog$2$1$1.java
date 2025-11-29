package com.upuphone.xr.sapp.fragment;

import android.net.Uri;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.glass.GlassLogUpdateHelper;
import com.upuphone.xr.sapp.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/fragment/FeedBackFragment$getGlassLog$2$1$1", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "onError", "", "taskId", "", "code", "", "onFinish", "onProgress", "uri", "Landroid/net/Uri;", "progress", "onStart", "onSuccess", "sendUri", "receiveUri", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FeedBackFragment$getGlassLog$2$1$1 implements ShareListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6954a;

    public FeedBackFragment$getGlassLog$2$1$1(CancellableContinuation cancellableContinuation) {
        this.f6954a = cancellableContinuation;
    }

    public void onError(String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "ShareListener onError taskId:" + str);
        GlassLogUpdateHelper.e.a().i();
        this.f6954a.resumeWith(Result.m20constructorimpl((Object) null));
    }

    public void onFinish(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "ShareListener onFinish taskId:" + str);
        GlassLogUpdateHelper.e.a().i();
    }

    public void onProgress(String str, Uri uri, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "ShareListener onProgress taskId:" + str + " progress:" + i + " uri:" + uri);
    }

    public void onStart(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "ShareListener onStart taskId:" + str);
        if (str != null) {
            GlassLogUpdateHelper.e.a().e(str);
        }
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "ShareListener onSuccess taskId:" + str + " sendUri:" + uri + " receiveUri:" + uri2);
        if (uri2 != null) {
            String path = uri2.getPath();
            if (path == null) {
                path = "";
            }
            File file = new File(path);
            String name = file.getName();
            File file2 = new File("/data/data/com.upuphone.star.launcher.intl/files/ulog/glass_log_" + name);
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                file.renameTo(file2);
            } else {
                FileUtils.f7881a.a(file, file2);
            }
            this.f6954a.resumeWith(Result.m20constructorimpl(file2));
            return;
        }
        this.f6954a.resumeWith(Result.m20constructorimpl((Object) null));
    }
}
