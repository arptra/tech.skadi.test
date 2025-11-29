package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/xjsd/ai/assistant/flutter/AndroidAssistantApiHandler$broadcastEventToFlutter$1$1", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$VoidResult;", "error", "", "", "success", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AndroidAssistantApiHandler$broadcastEventToFlutter$1$1 implements AndroidAssistantApi.VoidResult {
    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ILog.a("AndroidAssistantApiHandler", "broadcastEventToFlutter: 发送通知事件给flutter失败");
    }

    public void success() {
        ILog.a("AndroidAssistantApiHandler", "broadcastEventToFlutter: 发送通知事件给flutter成功");
    }
}
