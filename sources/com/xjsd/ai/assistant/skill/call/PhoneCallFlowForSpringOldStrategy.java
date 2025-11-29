package com.xjsd.ai.assistant.skill.call;

import android.content.Context;
import android.text.TextUtils;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;
import com.xjsd.ai.assistant.template.TtsCallTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000e\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringOldStrategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "j", "()Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "", "Lcom/xjsd/ai/assistant/protocol/call/SimCardBean;", "simCards", "", "contactName", "phoneNumber", "", "b", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "cardIndex", "tel", "", "isReplyCall", "a", "(ILjava/lang/String;Ljava/lang/String;Z)V", "telNum", "e", "(ILjava/lang/String;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallFlowForSpringOldStrategy extends PhoneCallFlowStrategy {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringOldStrategy$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(int i, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "tel");
        ILog.a("PhoneCallFlowForSpringOldStrategy", "chooseChannelToDialFlow: 进入call flow");
        if (z) {
            d(i, str2);
            return;
        }
        PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1 phoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1 = new PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1(this, i, str2);
        if (TextUtils.isEmpty(str)) {
            new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P02).o(str2).k("phoneNum", str2).g(1).i(new PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$1(phoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1)).h(new PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$2(phoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1)).a().c();
        } else {
            new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P01).g(1).i(new PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$3(phoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1)).h(new PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$4(phoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1)).a().c();
        }
    }

    public void b(List list, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "simCards");
        Intrinsics.checkNotNullParameter(str2, "phoneNumber");
        h(list, str, str2);
    }

    public void e(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "telNum");
        ILog.a("PhoneCallFlowForSpringOldStrategy", "makeCallByPhoneFail: 拨号失败，不处理");
    }

    public CallConditionLack j() {
        ILog.a("PhoneCallFlowForSpringOldStrategy", "validDialPrecondition: 拨打电话条件校验");
        CallConditionLack i = i();
        if (i != null) {
            return i;
        }
        if (!PhoneCallUtil.d()) {
            return null;
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        if (PhoneCallUtil.i(a2)) {
            return CallConditionLack.LOCK_SCREEN;
        }
        if (PhoneCallUtil.e()) {
            return CallConditionLack.APP_IN_BACKGROUND;
        }
        return null;
    }
}
