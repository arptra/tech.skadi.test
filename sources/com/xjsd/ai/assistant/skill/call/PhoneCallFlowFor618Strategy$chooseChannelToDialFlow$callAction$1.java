package com.xjsd.ai.assistant.skill.call;

import android.os.Handler;
import android.os.Looper;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.skill.call.util.CallType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "callType", "Lcom/xjsd/ai/assistant/skill/call/util/CallType;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1 extends Lambda implements Function1<CallType, Object> {
    final /* synthetic */ int $cardIndex;
    final /* synthetic */ String $tel;
    final /* synthetic */ PhoneCallFlowFor618Strategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1(PhoneCallFlowFor618Strategy phoneCallFlowFor618Strategy, int i, String str) {
        super(1);
        this.this$0 = phoneCallFlowFor618Strategy;
        this.$cardIndex = i;
        this.$tel = str;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(PhoneCallFlowFor618Strategy phoneCallFlowFor618Strategy, int i, String str, CallType callType) {
        Intrinsics.checkNotNullParameter(phoneCallFlowFor618Strategy, "this$0");
        Intrinsics.checkNotNullParameter(str, "$tel");
        Intrinsics.checkNotNullParameter(callType, "$callType");
        phoneCallFlowFor618Strategy.n(i, str, callType);
    }

    @NotNull
    public final Object invoke(@NotNull CallType callType) {
        Intrinsics.checkNotNullParameter(callType, "callType");
        ILog.a("PhoneCallFlowFor618Strategy", "chooseChannelToDialFlow: 进入call action");
        if (DeviceUtils.d()) {
            return Boolean.valueOf(new Handler(Looper.getMainLooper()).postDelayed(new a(this.this$0, this.$cardIndex, this.$tel, callType), 1000));
        }
        this.this$0.n(this.$cardIndex, this.$tel, callType);
        return Unit.INSTANCE;
    }
}
