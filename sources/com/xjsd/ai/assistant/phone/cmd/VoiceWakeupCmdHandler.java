package com.xjsd.ai.assistant.phone.cmd;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;

public class VoiceWakeupCmdHandler implements CmdHandler {
    public final boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public int getHandleCode() {
        return 7;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("VoiceWakeupCmdHandler", "收到低功耗语音唤醒指令->" + starryNetMessage.getMessage());
        ExitTimer.f8563a.d();
        if (!PhoneCallUtil.c()) {
            return;
        }
        if (a(ContextHelper.a(), "com.qualcomm.qti.sva")) {
            ILog.a("VoiceWakeupCmdHandler", "发送语音唤醒广播->高通平台");
            Intent intent = new Intent("com.ai.voice.assistant.LOW_POWER_WAKEUP");
            intent.putExtra("wakeUpWord", "小溪小溪");
            intent.setPackage("com.qualcomm.qti.sva");
            ContextHelper.a().sendBroadcast(intent);
            return;
        }
        ILog.a("VoiceWakeupCmdHandler", "发送语音唤醒广播->展锐平台");
        Intent intent2 = new Intent("com.ai.voice.assistant.LOW_POWER_WAKEUP");
        intent2.putExtra("wakeUpWord", "小溪小溪");
        intent2.setPackage("com.unisoc.soundtrigger");
        ContextHelper.a().sendBroadcast(intent2);
    }
}
