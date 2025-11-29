package com.xjsd.ai.assistant.skill.call;

import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.call.SimCardBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $contactName;
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ List<SimCardBean> $simCards;
    final /* synthetic */ PhoneCallFlowFor618Strategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1(PhoneCallFlowFor618Strategy phoneCallFlowFor618Strategy, List<? extends SimCardBean> list, String str, String str2) {
        super(0);
        this.this$0 = phoneCallFlowFor618Strategy;
        this.$simCards = list;
        this.$contactName = str;
        this.$phoneNumber = str2;
    }

    public final void invoke() {
        ILog.a("PhoneCallFlowFor618Strategy", "chooseSimCardFlow: 进入选卡流程");
        this.this$0.h(this.$simCards, this.$contactName, this.$phoneNumber);
    }
}
