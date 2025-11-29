package com.xjsd.ai.assistant.phone.business;

import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.vui.settings.SettingsHelper;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.setting.SettingBusinessData;

public class SettingsBusinessHandler implements BusinessHandler {
    public void a(BusinessData businessData) {
        ILog.a("SettingBusinessHandler", "收到settings业务数据->" + businessData.getData());
        SettingBusinessData settingBusinessData = (SettingBusinessData) businessData.parseData(SettingBusinessData.class);
        SettingsHelper.a(settingBusinessData.getTarget(), settingBusinessData.getOperation().equals("TurnOn"));
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.SETTING;
    }
}
