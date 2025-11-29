package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.encrypt.DigestUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.sys.SyncSysInfoReq;
import org.greenrobot.eventbus.EventBus;

public class SyncSysInfoReqCmdHandler implements CmdHandler {
    public int getHandleCode() {
        return 1;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("SyncSysInfoReqCmdHandler", "收到同步系统信息请求->" + starryNetMessage.getMessage());
        SyncSysInfoReq syncSysInfoReq = (SyncSysInfoReq) cmd.parsePayload(SyncSysInfoReq.class);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        cacheAbility.cache("isStar", Boolean.valueOf(syncSysInfoReq.isStar()));
        cacheAbility.cache("glassAssistantVersion", syncSysInfoReq.getVersionName());
        cacheAbility.cache("glassIsOtaFeature", Boolean.valueOf(syncSysInfoReq.isOtaFeature()));
        cacheAbility.cache("phoneIsOtaFeature", Boolean.valueOf(syncSysInfoReq.isOtaFeature()));
        cacheAbility.cache("rejectRoundTimes", Integer.valueOf(syncSysInfoReq.getRoundTimes()));
        cacheAbility.cache("glassSN", syncSysInfoReq.getGlassSN());
        String glassSN = syncSysInfoReq.getGlassSN();
        cacheAbility.cache("IotDeviceId", DigestUtils.l("RhdNS`Z?" + glassSN));
        EventBus.c().k(syncSysInfoReq);
    }
}
