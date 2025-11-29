package com.xjsd.ai.assistant.nlu;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import com.xjsd.ai.assistant.nlu.bean.NluRequest;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.nlu.bean.TalkInfo;
import com.xjsd.ai.assistant.nlu.bean.UploadInfo;
import java.util.function.Consumer;

@AbilityKey("nlu")
public interface NluAbility extends Ability {
    void cancel(String str);

    NluRequest getTalkReq(TalkInfo talkInfo);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    NluResponse talkNlu(TalkInfo talkInfo);

    void talkNlu(TalkInfo talkInfo, Consumer<NluResponse> consumer);

    Object uploadNlu(UploadInfo uploadInfo);
}
