package com.upuphone.xr.interconnect.main.handler;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.SyncTimeResponseInfo;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.TimeZone;

public class TimeSyncRequestMessageHandler implements MessageHandler {
    private static final String TAG = "TimeSyncRequestMessageHandler";

    public int getHandleType() {
        return 2;
    }

    public void handle(StarryNetMessage starryNetMessage, Function function) {
        ILog.d(TAG, "收到眼镜同步时间请求，手机开始同步时间至眼镜");
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(3, new SyncTimeResponseInfo(System.currentTimeMillis(), TimeZone.getDefault().getID())).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
    }
}
