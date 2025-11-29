package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.listener.RecordOnInterConnectMsgListener;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.RecordInterConnectMessage;
import com.upuphone.ar.shorthand.phone.utils.RecordGsonUtils;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$mMsgReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$mMsgReceiver$1 extends MessageReceiver {
    final /* synthetic */ RecordConnectManager this$0;

    public RecordConnectManager$mMsgReceiver$1(RecordConnectManager recordConnectManager) {
        this.this$0 = recordConnectManager;
    }

    public void onMessageReceive(@Nullable StarryNetMessage starryNetMessage) {
        Unit unit;
        if (starryNetMessage == null) {
            LogExt.logI("mMsgReceiver:: 互联互通消息为空！", "FastRecordInterConnectHelper");
            return;
        }
        try {
            String message = starryNetMessage.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            RecordInterConnectMessage recordInterConnectMessage = (RecordInterConnectMessage) RecordGsonUtils.a(message, RecordInterConnectMessage.class);
            int msgCmd = recordInterConnectMessage.getMsgCmd();
            RecordOnInterConnectMsgListener access$getMConnectMsgReceiver$p = this.this$0.mConnectMsgReceiver;
            if (access$getMConnectMsgReceiver$p != null) {
                String fastRecordData = recordInterConnectMessage.getFastRecordData();
                byte[] data = starryNetMessage.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                access$getMConnectMsgReceiver$p.onInterConnectMessage(msgCmd, fastRecordData, copyOf);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LogExt.logI("onMessageReceive-> mConnectMsgReceiver为空，不能处理消息", "FastRecordInterConnectHelper");
            }
        } catch (Exception e) {
            String message2 = starryNetMessage.getMessage();
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logE("mMsgReceiver:: 消息解析失败！StarryNetMessage = " + message2 + ", \nerrorMsg=" + stackTraceToString, "FastRecordInterConnectHelper");
        }
    }
}
