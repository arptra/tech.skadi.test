package com.xjsd.ai.assistant.skill.call;

import android.os.Handler;
import android.os.Looper;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ int $cardIndex;
    final /* synthetic */ String $tel;
    final /* synthetic */ PhoneCallFlowForSpringStrategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1(PhoneCallFlowForSpringStrategy phoneCallFlowForSpringStrategy, int i, String str) {
        super(0);
        this.this$0 = phoneCallFlowForSpringStrategy;
        this.$cardIndex = i;
        this.$tel = str;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(PhoneCallFlowForSpringStrategy phoneCallFlowForSpringStrategy, int i, String str) {
        Intrinsics.checkNotNullParameter(phoneCallFlowForSpringStrategy, "this$0");
        Intrinsics.checkNotNullParameter(str, "$tel");
        phoneCallFlowForSpringStrategy.d(i, str);
    }

    @NotNull
    public final Object invoke() {
        ILog.a("PhoneCallFlowForSpringStrategy", "performDial: 进入call action");
        if (DeviceUtils.d()) {
            return Boolean.valueOf(new Handler(Looper.getMainLooper()).postDelayed(new c(this.this$0, this.$cardIndex, this.$tel), 1000));
        }
        this.this$0.d(this.$cardIndex, this.$tel);
        return Unit.INSTANCE;
    }
}
