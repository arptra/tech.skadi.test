package com.xjsd.ai.assistant.phone;

import android.app.Application;
import android.service.notification.StatusBarNotification;
import com.google.gson.JsonSyntaxException;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.xjsd.ai.assistant.adapt.ImDelegator;
import com.xjsd.ai.assistant.chatgpt.util.AccountUtil;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;

public final class VoiceAssistantApi {
    private static final String TAG = "VoiceAssistant";
    public static final boolean isOversea = BuildConfig.f8518a.booleanValue();
    private boolean hasInit = false;

    public synchronized void init(Application application) {
        if (this.hasInit) {
            ILog.a(TAG, "语音助理已经初始化");
            return;
        }
        this.hasInit = true;
        new Commander().init(application);
    }

    public void onReceiveNotification(StatusBarNotification statusBarNotification) {
        ImDelegator.f8381a.d().f(statusBarNotification);
    }

    public void onRemoveNotification(StatusBarNotification statusBarNotification, int i) {
        ImDelegator.f8381a.d().c(statusBarNotification, i);
    }

    public void startAssistant() {
        Communicator.b(110, (Object) null, new SendMsgCallback() {
            public void onFail(int i, String str) {
                ILog.a(VoiceAssistantApi.TAG, "发送拉起眼镜端语音助理命令失败->" + str);
            }

            public void onSuccess() {
                ILog.a(VoiceAssistantApi.TAG, "发送拉起眼镜端语音助理命令成功");
            }
        });
    }

    public void syncAccountInfo(String str) {
        if (this.hasInit) {
            ILog.a(TAG, "syncAccountInfo: " + str);
            try {
                AccountInfo accountInfo = (AccountInfo) GsonUtils.a(str, AccountInfo.class);
                if (accountInfo == null) {
                    accountInfo = new AccountInfo();
                    accountInfo.id = "";
                    accountInfo.mzUid = "";
                }
                AccountUtil.a(accountInfo);
            } catch (JsonSyntaxException e) {
                ILog.h(TAG, "syncAccountInfo: error", e);
            }
        }
    }
}
