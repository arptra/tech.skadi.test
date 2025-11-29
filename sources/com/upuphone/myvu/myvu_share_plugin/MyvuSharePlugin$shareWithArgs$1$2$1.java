package com.upuphone.myvu.myvu_share_plugin;

import android.util.Log;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J2\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/myvu/myvu_share_plugin/MyvuSharePlugin$shareWithArgs$1$2$1", "Lcom/xingin/xhssharesdk/callback/XhsShareCallback;", "onError", "", "sessionId", "", "errorCode", "", "errorMessage", "throwable", "", "onError2", "newErrorCode", "oldErrorCode", "onSuccess", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MyvuSharePlugin$shareWithArgs$1$2$1 implements XhsShareCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6432a;
    public final /* synthetic */ MyvuSharePlugin b;
    public final /* synthetic */ String c;

    public MyvuSharePlugin$shareWithArgs$1$2$1(MethodChannel.Result result, MyvuSharePlugin myvuSharePlugin, String str) {
        this.f6432a = result;
        this.b = myvuSharePlugin;
        this.c = str;
    }

    public void onError(String str, int i, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        Log.i("MyvuSharePlugin", "onError: 分享失败!! " + str + " " + i + " " + str2 + " " + th);
    }

    public void onError2(String str, int i, int i2, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        Log.i("MyvuSharePlugin", "onError: 分享小红书失败!! " + str + " " + i + " " + i2 + " " + str2 + " " + th);
        this.f6432a.success(this.b.b(2, str2));
        new File(this.c).delete();
        XhsShareSdk.setShareCallback((XhsShareCallback) null);
    }

    public void onSuccess(String str) {
        Log.i("MyvuSharePlugin", "onSuccess: 分享小红书成功！！！");
        this.f6432a.success(MyvuSharePlugin.c(this.b, 1, (String) null, 2, (Object) null));
        new File(this.c).delete();
        XhsShareSdk.setShareCallback((XhsShareCallback) null);
    }
}
