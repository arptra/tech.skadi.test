package com.xjsd.ai.assistant.phone.vui;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.common.stks.OfflineKeyManager;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.api.music.MediaModel;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.NewFunctionCompact;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.media.MediaHelper;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.stks.HotWordControl;
import com.xjsd.ai.assistant.stks.dto.STKSResponse;

public class GlobalVuiHandler implements VuiHandler {
    public boolean a(VuiModel vuiModel) {
        String name = vuiModel.getHeader().getName();
        JSONObject payload = vuiModel.getPayload();
        if ("SayVisible".equals(name)) {
            String string = payload.getString("stks");
            HotWordControl hotWordControl = new HotWordControl();
            hotWordControl.setControl(2);
            hotWordControl.setData(string);
            ILog.e("stks_func_data", GsonUtils.b(string, STKSResponse.class));
            Communicator.b(107, hotWordControl, new SendMsgCallback() {
                public void onFail(int i, String str) {
                    ILog.a("GlobalVuiHandler", "发送stks到眼镜端失败，原因->" + str);
                }

                public void onSuccess() {
                    ILog.a("GlobalVuiHandler", "发送stks到眼镜端成功");
                }
            });
            return true;
        } else if ("GeneralDirective".equals(name)) {
            String string2 = payload.getString("directive");
            if (TextUtils.isEmpty(string2)) {
                UnSupportFeatureManager.f8414a.c();
                return true;
            }
            if ("ReturnDesktop".equalsIgnoreCase(string2) || "Cancel".equalsIgnoreCase(string2) || "Back".equalsIgnoreCase(string2) || "Exit".equalsIgnoreCase(string2)) {
                WakeupControlDelegate.g.p(true);
            }
            return false;
        } else if ("MediaDirective".equals(name)) {
            return b(payload.getString("directive"));
        } else {
            if ("FreeWake".equals(name)) {
                return b(payload.getString("stks"));
            }
            return false;
        }
    }

    public final boolean b(String str) {
        boolean z;
        boolean z2 = true;
        if (VoiceAssistantApi.isOversea) {
            return false;
        }
        MediaModel mediaModel = new MediaModel();
        mediaModel.setCmdType("Control");
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -836144065:
                if (str.equals("MediaPre")) {
                    c = 0;
                    break;
                }
                break;
            case -376049518:
                if (str.equals("MediaPause")) {
                    c = 1;
                    break;
                }
                break;
            case -150733609:
                if (str.equals("MediaNext")) {
                    c = 2;
                    break;
                }
                break;
            case -150668008:
                if (str.equals("MediaPlay")) {
                    c = 3;
                    break;
                }
                break;
            case 19857184:
                if (str.equals("上一首")) {
                    c = 4;
                    break;
                }
                break;
            case 19858145:
                if (str.equals("下一首")) {
                    c = 5;
                    break;
                }
                break;
            case 110173065:
                if (str.equals("MediaPre_stks")) {
                    c = 6;
                    break;
                }
                break;
            case 793936558:
                if (str.equals("播放音乐")) {
                    c = 7;
                    break;
                }
                break;
            case 802771031:
                if (str.equals("暂停音乐")) {
                    c = 8;
                    break;
                }
                break;
            case 999870871:
                if (str.equals("继续播放")) {
                    c = 9;
                    break;
                }
                break;
            case 1288261905:
                if (str.equals("MediaResume")) {
                    c = 10;
                    break;
                }
                break;
            case 1819030001:
                if (str.equals("MediaNext_stks")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 4:
            case 6:
                mediaModel.setControlType("Prev");
                if (!NewFunctionCompact.b()) {
                    z = OfflineKeyManager.f("上一首", true);
                    break;
                } else {
                    z = OfflineKeyManager.f("上一个", true);
                    break;
                }
            case 1:
            case 8:
                mediaModel.setControlType("Parse");
                z = OfflineKeyManager.f("暂停播放", true);
                break;
            case 2:
            case 5:
            case 11:
                mediaModel.setControlType("Next");
                if (!NewFunctionCompact.b()) {
                    z = OfflineKeyManager.f("下一首", true);
                    break;
                } else {
                    z = OfflineKeyManager.f("下一个", true);
                    break;
                }
            case 3:
            case 7:
                mediaModel.setCmdType("Control");
                mediaModel.setControlType("Open");
                z = false;
                break;
            case 9:
            case 10:
                mediaModel.setControlType("Resume");
                z = OfflineKeyManager.f("继续播放", true);
                break;
            default:
                z = false;
                z2 = false;
                break;
        }
        if (!z) {
            MediaHelper.e(mediaModel, false);
        }
        return z2;
    }

    public String getHandleType() {
        return VuiModelType.GLOBAL;
    }
}
