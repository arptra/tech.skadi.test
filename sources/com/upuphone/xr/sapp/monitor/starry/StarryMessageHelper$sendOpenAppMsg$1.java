package com.upuphone.xr.sapp.monitor.starry;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/monitor/starry/StarryMessageHelper$sendOpenAppMsg$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "", "msgId", "", "onSuccess", "(Ljava/lang/String;)V", "", "errorCode", "onFail", "(Ljava/lang/String;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StarryMessageHelper$sendOpenAppMsg$1 extends SendMessageListener {
    final /* synthetic */ JSONObject $jsonMsg;

    public StarryMessageHelper$sendOpenAppMsg$1(JSONObject jSONObject) {
        this.$jsonMsg = jSONObject;
    }

    public void onFail(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StarryMessageHelper", "send msg failed...id = " + str + ", msg = " + i);
    }

    public void onSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        ULog.Delegate delegate = ULog.f6446a;
        JSONObject jSONObject = this.$jsonMsg;
        delegate.a("StarryMessageHelper", "send msg success...id = " + str + ", msg = " + jSONObject);
    }
}
