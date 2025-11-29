package com.upuphone.xr.interconnect.main.handler;

import android.app.AlarmManager;
import android.os.SystemClock;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.SyncTimeResponseInfo;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.xjsd.ai.assistant.protocol.VuiModelType;

public class TimeSyncResponseMessageHandler implements MessageHandler {
    private static final String TAG = "TimeSyncResponseMessageHandler";

    public int getHandleType() {
        return 3;
    }

    public void handle(StarryNetMessage starryNetMessage, Function function) {
        ILog.d(TAG, "收到手机同步时间的数据");
        SyncTimeResponseInfo syncTimeResponseInfo = (SyncTimeResponseInfo) function.parseData(SyncTimeResponseInfo.class);
        long syncTimeData = syncTimeResponseInfo.getSyncTimeData();
        Long valueOf = Long.valueOf(syncTimeData);
        String syncTimeZone = syncTimeResponseInfo.getSyncTimeZone();
        ILog.d(TAG, "修改系统时间--" + valueOf + "，时区--" + syncTimeZone);
        ((AlarmManager) InterconnectManager.getInstance().getContext().getSystemService(VuiModelType.ALARM)).setTimeZone(syncTimeZone);
        SystemClock.setCurrentTimeMillis(syncTimeData);
    }
}
