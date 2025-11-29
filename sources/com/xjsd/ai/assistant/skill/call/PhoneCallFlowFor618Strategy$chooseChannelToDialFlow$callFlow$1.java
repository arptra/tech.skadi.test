package com.xjsd.ai.assistant.skill.call;

import android.text.TextUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.call.util.CallType;
import com.xjsd.ai.assistant.template.TtsCallTemplate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "callType", "Lcom/xjsd/ai/assistant/skill/call/util/CallType;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callFlow$1 extends Lambda implements Function1<CallType, Unit> {
    final /* synthetic */ Function1<CallType, Object> $callAction;
    final /* synthetic */ int $cardIndex;
    final /* synthetic */ String $contactName;
    final /* synthetic */ boolean $isReplyCall;
    final /* synthetic */ String $tel;
    final /* synthetic */ PhoneCallFlowFor618Strategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callFlow$1(boolean z, PhoneCallFlowFor618Strategy phoneCallFlowFor618Strategy, int i, String str, String str2, Function1<? super CallType, ? extends Object> function1) {
        super(1);
        this.$isReplyCall = z;
        this.this$0 = phoneCallFlowFor618Strategy;
        this.$cardIndex = i;
        this.$tel = str;
        this.$contactName = str2;
        this.$callAction = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CallType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final CallType callType) {
        Intrinsics.checkNotNullParameter(callType, "callType");
        ILog.a("PhoneCallFlowFor618Strategy", "chooseChannelToDialFlow: 进入call flow");
        if (this.$isReplyCall) {
            this.this$0.n(this.$cardIndex, this.$tel, callType);
        } else if (TextUtils.isEmpty(this.$contactName)) {
            PhoneTtsPlayBuilder.PhoneTts g = new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P02).o(this.$tel).k("phoneNum", this.$tel).g(1);
            final Function1<CallType, Object> function1 = this.$callAction;
            PhoneTtsPlayBuilder.PhoneTts i = g.i(new Function0<Unit>() {
                public final void invoke() {
                    function1.invoke(callType);
                }
            });
            final Function1<CallType, Object> function12 = this.$callAction;
            i.h(new Function0<Unit>() {
                public final void invoke() {
                    function12.invoke(callType);
                }
            }).a().c();
        } else {
            PhoneTtsPlayBuilder.PhoneTts g2 = new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P01).g(1);
            final Function1<CallType, Object> function13 = this.$callAction;
            PhoneTtsPlayBuilder.PhoneTts i2 = g2.i(new Function0<Unit>() {
                public final void invoke() {
                    function13.invoke(callType);
                }
            });
            final Function1<CallType, Object> function14 = this.$callAction;
            i2.h(new Function0<Unit>() {
                public final void invoke() {
                    function14.invoke(callType);
                }
            }).a().c();
        }
    }
}
