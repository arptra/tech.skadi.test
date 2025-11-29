package com.xjsd.ai.assistant.skill.call;

import android.content.Context;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000e\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringStrategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "j", "()Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "", "Lcom/xjsd/ai/assistant/protocol/call/SimCardBean;", "simCards", "", "contactName", "phoneNumber", "", "b", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "cardIndex", "tel", "", "isReplyCall", "a", "(ILjava/lang/String;Ljava/lang/String;Z)V", "telNum", "e", "(ILjava/lang/String;)V", "flowType", "Lkotlin/Function0;", "", "flow", "k", "(ILkotlin/jvm/functions/Function0;)V", "lack", "l", "(ILcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallFlowForSpringStrategy extends PhoneCallFlowStrategy {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringStrategy$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(int i, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "tel");
        k(z ? 1 : 2, new PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1(z, this, i, str2, str));
    }

    public void b(List list, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "simCards");
        Intrinsics.checkNotNullParameter(str2, "phoneNumber");
        k(0, new PhoneCallFlowForSpringStrategy$chooseSimCardFlow$1(this, list, str, str2));
    }

    public void e(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "telNum");
        ILog.a("PhoneCallFlowForSpringStrategy", "makeCallByPhoneFail: 拨号失败，不处理");
    }

    public CallConditionLack j() {
        ILog.a("PhoneCallFlowForSpringStrategy", "validDialPrecondition: 拨打电话条件校验");
        CallConditionLack i = i();
        if (i != null) {
            return i;
        }
        return null;
    }

    public final void k(int i, Function0 function0) {
        if (PhoneCallUtil.c()) {
            function0.invoke();
            return;
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNull(a2);
        boolean i2 = PhoneCallUtil.i(a2);
        boolean f = PhoneCallUtil.f();
        if (!i2 && f) {
            function0.invoke();
        } else if (i2) {
            if (PhoneCallUtil.b(a2)) {
                function0.invoke();
            } else {
                l(i, CallConditionLack.LOCK_SCREEN);
            }
        } else if (PhoneCallUtil.a(a2)) {
            function0.invoke();
        } else {
            l(i, CallConditionLack.APP_IN_BACKGROUND);
        }
    }

    public final void l(int i, CallConditionLack callConditionLack) {
        if (i == 0) {
            if (!VoiceAssistantApi.isOversea) {
                callConditionLack = callConditionLack == CallConditionLack.LOCK_SCREEN ? CallConditionLack.LOCK_SCREEN_618 : CallConditionLack.APP_IN_BACKGROUND_618;
            }
            PhoneTtsPlayBuilder phoneTtsPlayBuilder = new PhoneTtsPlayBuilder();
            String tts = callConditionLack.getTemplate().getTts(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
            phoneTtsPlayBuilder.f(tts).g(0).a().c();
            return;
        }
        String tts2 = VoiceAssistantApi.isOversea ? callConditionLack.getTemplate().getTts(new Object[0]) : callConditionLack == CallConditionLack.LOCK_SCREEN ? ContextHelper.b(R.string.tts_call_lock_screen, new Object[0]) : ContextHelper.b(R.string.tts_call_app_in_background, new Object[0]);
        if (i == 1) {
            UniqueTtsPlayBuilder uniqueTtsPlayBuilder = new UniqueTtsPlayBuilder();
            Intrinsics.checkNotNull(tts2);
            uniqueTtsPlayBuilder.g(tts2).a().d();
            return;
        }
        PhoneTtsPlayBuilder phoneTtsPlayBuilder2 = new PhoneTtsPlayBuilder();
        Intrinsics.checkNotNull(tts2);
        phoneTtsPlayBuilder2.f(tts2).g(0).a().c();
    }
}
