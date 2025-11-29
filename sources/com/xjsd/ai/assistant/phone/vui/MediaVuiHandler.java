package com.xjsd.ai.assistant.phone.vui;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.api.music.MediaModel;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.media.MediaHelper;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/MediaVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaVuiHandler implements VuiHandler {
    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        String name = vuiModel.getHeader().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String id = vuiModel.getUtterance().getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        JSONObject payload = vuiModel.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
        MediaModel b = MediaHelper.b(name, id, payload);
        String cmdType = b.getCmdType();
        if (cmdType == null || cmdType.length() == 0) {
            return false;
        }
        if (VoiceAssistantApi.isOversea) {
            UnSupportFeatureManager.f8414a.c();
            return true;
        }
        MediaHelper.f(b, false, 2, (Object) null);
        return true;
    }

    public String getHandleType() {
        return VuiModelType.MEDIA;
    }
}
