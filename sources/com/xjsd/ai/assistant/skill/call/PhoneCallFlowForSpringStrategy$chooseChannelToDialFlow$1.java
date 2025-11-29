package com.xjsd.ai.assistant.skill.call;

import android.text.TextUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.template.TtsCallTemplate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $cardIndex;
    final /* synthetic */ String $contactName;
    final /* synthetic */ boolean $isReplyCall;
    final /* synthetic */ String $tel;
    final /* synthetic */ PhoneCallFlowForSpringStrategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1(boolean z, PhoneCallFlowForSpringStrategy phoneCallFlowForSpringStrategy, int i, String str, String str2) {
        super(0);
        this.$isReplyCall = z;
        this.this$0 = phoneCallFlowForSpringStrategy;
        this.$cardIndex = i;
        this.$tel = str;
        this.$contactName = str2;
    }

    public final void invoke() {
        ILog.a("PhoneCallFlowForSpringStrategy", "chooseChannelToDialFlow: 进入call flow");
        if (this.$isReplyCall) {
            this.this$0.d(this.$cardIndex, this.$tel);
            return;
        }
        final PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1 phoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1 = new PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1(this.this$0, this.$cardIndex, this.$tel);
        if (TextUtils.isEmpty(this.$contactName)) {
            new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P02).o(this.$tel).k("phoneNum", this.$tel).g(1).i(new Function0<Unit>() {
                public final void invoke() {
                    phoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1.invoke();
                }
            }).h(new Function0<Unit>() {
                public final void invoke() {
                    phoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1.invoke();
                }
            }).a().c();
        } else {
            new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P01).g(1).i(new Function0<Unit>() {
                public final void invoke() {
                    phoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1.invoke();
                }
            }).h(new Function0<Unit>() {
                public final void invoke() {
                    phoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1.invoke();
                }
            }).a().c();
        }
    }
}
