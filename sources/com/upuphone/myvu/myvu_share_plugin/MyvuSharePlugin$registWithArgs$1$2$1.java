package com.upuphone.myvu.myvu_share_plugin;

import android.util.Log;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0001\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/upuphone/myvu/myvu_share_plugin/MyvuSharePlugin$registWithArgs$1$2$1", "Lcom/xingin/xhssharesdk/callback/XhsShareRegisterCallback;", "onError", "", "errorCode", "", "errorMessage", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MyvuSharePlugin$registWithArgs$1$2$1 implements XhsShareRegisterCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6431a;

    public MyvuSharePlugin$registWithArgs$1$2$1(MethodChannel.Result result) {
        this.f6431a = result;
    }

    public void onError(int i, String str, Exception exc) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Log.i("MyvuSharePlugin", "onError: 注册小红书失败！errorCode: " + i + " errorMessage: " + str + " exception: " + exc);
        this.f6431a.success(Boolean.FALSE);
    }

    public void onSuccess() {
        Log.i("MyvuSharePlugin", "onSuccess: 注册小红书成功！");
        this.f6431a.success(Boolean.TRUE);
    }
}
