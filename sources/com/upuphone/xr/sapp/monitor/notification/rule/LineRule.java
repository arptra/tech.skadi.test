package com.upuphone.xr.sapp.monitor.notification.rule;

import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/LineRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "data", "", "d", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LineRule extends Rule<AiSdkResult> {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/LineRule$Companion;", "", "()V", "GROUP_TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public String a() {
        return "jp.naver.line.android";
    }

    /* renamed from: d */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        return !Intrinsics.areEqual((Object) aiSdkResult.getSbn().getTag(), (Object) "NOTIFICATION_TAG_MESSAGE");
    }
}
