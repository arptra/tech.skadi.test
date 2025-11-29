package com.xjsd.ai.assistant.skill.call;

import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.CallType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "lack", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$playTipFlow$1 extends Lambda implements Function1<CallConditionLack, Unit> {
    final /* synthetic */ Function1<CallType, Object> $callAction;
    final /* synthetic */ boolean $isReplyCall;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$playTipFlow$1(boolean z, Function1<? super CallType, ? extends Object> function1) {
        super(1);
        this.$isReplyCall = z;
        this.$callAction = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CallConditionLack) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CallConditionLack callConditionLack) {
        int i;
        Intrinsics.checkNotNullParameter(callConditionLack, "lack");
        if (callConditionLack == CallConditionLack.LOCK_SCREEN_618) {
            i = R.string.tts_call_lock_screen;
        } else {
            i = R.string.tts_call_app_in_background;
        }
        String b = ContextHelper.b(i, new Object[0]);
        if (this.$isReplyCall) {
            UniqueTtsPlayBuilder.TemplateTtsParams f = new UniqueTtsPlayBuilder().f(callConditionLack.getTemplate());
            Intrinsics.checkNotNull(b);
            UniqueTtsPlayBuilder.TemplateTtsParams n = f.j("Privilege", b).n(b);
            final Function1<CallType, Object> function1 = this.$callAction;
            UniqueTtsPlayBuilder.TtsParams g = n.g(new Function0<Unit>() {
                public final void invoke() {
                    function1.invoke(CallType.BLUETOOTH);
                }
            });
            final Function1<CallType, Object> function12 = this.$callAction;
            g.f(new Function0<Unit>() {
                public final void invoke() {
                    function12.invoke(CallType.BLUETOOTH);
                }
            }).a().d();
            return;
        }
        PhoneTtsPlayBuilder.TemplateTts e = new PhoneTtsPlayBuilder().e(callConditionLack.getTemplate());
        Intrinsics.checkNotNull(b);
        PhoneTtsPlayBuilder.PhoneTts g2 = e.k("Privilege", b).o(b).g(1);
        final Function1<CallType, Object> function13 = this.$callAction;
        PhoneTtsPlayBuilder.PhoneTts i2 = g2.i(new Function0<Unit>() {
            public final void invoke() {
                function13.invoke(CallType.BLUETOOTH);
            }
        });
        final Function1<CallType, Object> function14 = this.$callAction;
        i2.h(new Function0<Unit>() {
            public final void invoke() {
                function14.invoke(CallType.BLUETOOTH);
            }
        }).a().c();
    }
}
