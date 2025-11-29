package com.upuphone.xr.interconnect.business.time;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/business/time/TimeManager;", "", "()V", "sendTimeRequest", "", "deviceId", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimeManager {
    public final void sendTimeRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        ILog.d(PrettyPrintExtKt.stringify(this), "眼镜发送时间同步请求");
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        String str2 = str;
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(str2, createInnerMessage.getSenderPkg(), createInnerMessage.getReceiverPkg(), new Function(2, (Object) null).toString(), (byte[]) null, (IMessageSendListener) null);
    }
}
