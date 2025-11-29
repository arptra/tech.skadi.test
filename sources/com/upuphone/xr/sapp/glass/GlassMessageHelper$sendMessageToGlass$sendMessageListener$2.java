package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.common.ResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/glass/GlassMessageHelper$sendMessageToGlass$sendMessageListener$2", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msgId", "", "errorCode", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassMessageHelper$sendMessageToGlass$sendMessageListener$2 extends SendMessageListener {
    final /* synthetic */ String $msg;
    final /* synthetic */ String $uid;

    public GlassMessageHelper$sendMessageToGlass$sendMessageListener$2(String str, String str2) {
        this.$msg = str;
        this.$uid = str2;
    }

    public void onFail(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.$msg;
        delegate.a("GlassMessageHelper", "sendMessageToGlass-onFail, msg: " + str2 + ", msgId: " + str + ", errorCode: " + i);
        ResultListener e = GlassMessageHelper.f7054a.e(this.$uid);
        if (e != null) {
            e.onFail(i, str);
        }
    }

    public void onSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.$msg;
        delegate.a("GlassMessageHelper", "sendMessageToGlass-onSuccess, msg: " + str2 + ", msgId: " + str);
        ResultListener e = GlassMessageHelper.f7054a.e(this.$uid);
        if (e != null) {
            e.onSuccess(str);
        }
    }
}
