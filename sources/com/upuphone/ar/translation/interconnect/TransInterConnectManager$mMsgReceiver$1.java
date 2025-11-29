package com.upuphone.ar.translation.interconnect;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.translation.interconnect.listener.OnInterConnectMsgListener;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/translation/interconnect/TransInterConnectManager$mMsgReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$mMsgReceiver$1 extends MessageReceiver {
    final /* synthetic */ TransInterConnectManager this$0;

    public TransInterConnectManager$mMsgReceiver$1(TransInterConnectManager transInterConnectManager) {
        this.this$0 = transInterConnectManager;
    }

    public void onMessageReceive(@Nullable StarryNetMessage starryNetMessage) {
        Unit unit;
        if (starryNetMessage == null) {
            LogExt.j("mMsgReceiver:: 互联互通消息为空！", "TransInterConnectManager");
            return;
        }
        try {
            if (Intrinsics.areEqual((Object) starryNetMessage.getSenderPkg(), (Object) "System")) {
                OnInterConnectMsgListener g = this.this$0.k;
                if (g != null) {
                    g.onRemoteDie();
                    return;
                }
                return;
            }
            String message = starryNetMessage.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            InterConnectMessage interConnectMessage = (InterConnectMessage) GsonUtils.a(message, InterConnectMessage.class);
            int msgCmd = interConnectMessage.getMsgCmd();
            OnInterConnectMsgListener a2 = this.this$0.m;
            if (a2 != null) {
                String data = interConnectMessage.getData();
                byte[] data2 = starryNetMessage.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                byte[] copyOf = Arrays.copyOf(data2, data2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                a2.onInterConnectMessage(msgCmd, data, copyOf);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LogExt.j("onMessageReceive-> mConnectMsgReceiver为空，不能处理消息", "TransInterConnectManager");
            }
        } catch (Exception e) {
            String message2 = starryNetMessage.getMessage();
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.h("mMsgReceiver:: 消息解析失败！StarryNetMessage = " + message2 + ", \nerrorMsg=" + stackTraceToString, "TransInterConnectManager");
        }
    }
}
