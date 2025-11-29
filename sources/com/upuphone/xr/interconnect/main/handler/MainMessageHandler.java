package com.upuphone.xr.interconnect.main.handler;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.Map;

public class MainMessageHandler extends MessageReceiver implements MessageHandlerManager {
    private static final String TAG = "MainMessageHandler";
    private Map<Integer, MessageHandler> mMessageHandlerMap = new HashMap();

    public void addHandler(MessageHandler messageHandler) {
        this.mMessageHandlerMap.put(Integer.valueOf(messageHandler.getHandleType()), messageHandler);
    }

    public MessageHandler getHandler(int i) {
        return this.mMessageHandlerMap.get(Integer.valueOf(i));
    }

    public void onMessageReceive(StarryNetMessage starryNetMessage) throws RemoteException {
        try {
            Function parse = Function.parse(starryNetMessage.getMessage());
            if (parse != null) {
                MessageHandler handler = getHandler(parse.getType());
                if (handler != null) {
                    handler.handle(starryNetMessage, parse);
                    return;
                }
                ILog.d(TAG, parse.getType() + "对应Handler不存在");
                return;
            }
            ILog.v(TAG, "解析对象为空");
        } catch (Exception e) {
            ILog.v(TAG, "数据转换失败", e);
        }
    }
}
