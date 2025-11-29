package com.upuphone.xr.sapp.monitor.notification.algorithm;

import android.content.Context;
import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.sdk.ICallback;
import com.upuphone.sdk.ResultType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "Lcom/upuphone/sdk/ICallback;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/upuphone/sdk/ArSmartReminderModel;", "model", "Lcom/upuphone/sdk/ResultType;", "type", "", "a", "(Lcom/upuphone/sdk/ArSmartReminderModel;Lcom/upuphone/sdk/ResultType;)V", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "result", "Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;", "b", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;", "", "msgType", "c", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse;", "Lkotlin/Lazy;", "d", "()Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse;", "taxiParse", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AiHandleDataCall implements ICallback {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f7751a;
    public final Lazy b = LazyKt.lazy(AiHandleDataCall$taxiParse$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall$Companion;", "", "()V", "FLIGHT", "", "HOTEL", "IM", "REMINDER", "TAG", "TAKEOUT", "TAXI", "WEATHER", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AiHandleDataCall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7751a = context;
    }

    public void a(ArSmartReminderModel arSmartReminderModel, ResultType resultType) {
        ULog.Delegate delegate = ULog.f6446a;
        String d = arSmartReminderModel != null ? arSmartReminderModel.d() : null;
        delegate.a("AiHandleDataCall", "perform data parsing | msgType:" + d);
        if (arSmartReminderModel != null) {
            String d2 = arSmartReminderModel.d();
            Intrinsics.checkNotNullExpressionValue(d2, "getMsgType(...)");
            if (Intrinsics.areEqual((Object) c(d2), (Object) "taxi")) {
                d().j(arSmartReminderModel);
            } else {
                delegate.a("AiHandleDataCall", "not currently implemented");
            }
        }
    }

    public final DiscernResultModel b(AiSdkResult aiSdkResult) {
        ArSmartReminderModel model;
        String d;
        if (aiSdkResult == null || (model = aiSdkResult.getModel()) == null || (d = model.d()) == null) {
            return null;
        }
        int hashCode = d.hashCode();
        if (hashCode != -1903077448) {
            if (hashCode != 70723354) {
                if (hashCode != 642216616 || !d.equals("verificationCode")) {
                    return null;
                }
            } else if (!d.equals("Im:im")) {
                return null;
            }
        } else if (!d.equals("Im:phone")) {
            return null;
        }
        String d2 = model.d();
        Intrinsics.checkNotNullExpressionValue(d2, "getMsgType(...)");
        HashMap e = model.e();
        Intrinsics.checkNotNullExpressionValue(e, "getMsgTypeEntity(...)");
        return new DiscernResultModel(d2, e);
    }

    public final String c(String str) {
        return StringsKt.startsWith$default(str, "reminder", false, 2, (Object) null) ? "reminder" : StringsKt.startsWith$default(str, "Im", false, 2, (Object) null) ? "Im" : StringsKt.startsWith$default(str, VuiModelType.WEATHER, false, 2, (Object) null) ? VuiModelType.WEATHER : StringsKt.startsWith$default(str, "takeout", false, 2, (Object) null) ? "takeout" : StringsKt.startsWith$default(str, "taxi", false, 2, (Object) null) ? "taxi" : StringsKt.startsWith$default(str, "flight", false, 2, (Object) null) ? "flight" : StringsKt.startsWith$default(str, "hotel", false, 2, (Object) null) ? "hotel" : "";
    }

    public final TaxiParse d() {
        return (TaxiParse) this.b.getValue();
    }
}
