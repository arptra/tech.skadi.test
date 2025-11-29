package com.upuphone.xr.sapp.monitor.air;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.ContactHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/air/AirFunctionHelper;", "", "<init>", "()V", "", "data", "", "a", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/monitor/air/AirRequestModel;", "model", "e", "(Lcom/upuphone/xr/sapp/monitor/air/AirRequestModel;)V", "d", "c", "Lcom/upuphone/xr/sapp/monitor/air/AirResultModel;", "b", "(Lcom/upuphone/xr/sapp/monitor/air/AirRequestModel;)Lcom/upuphone/xr/sapp/monitor/air/AirResultModel;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AirFunctionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7737a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/air/AirFunctionHelper$Companion;", "", "()V", "ACTION", "", "PHONE_NO_ERR_MSG", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        if (str.length() == 0) {
            ULog.f6446a.c("AirFunctionHelper", "data is empty");
            return;
        }
        AirRequestModel airRequestModel = (AirRequestModel) new Gson().fromJson(str, TypeToken.get(AirRequestModel.class));
        if (airRequestModel.getFunctionName().length() == 0) {
            ULog.f6446a.c("AirFunctionHelper", "function name is empty");
        } else if (airRequestModel.getTargetPackage().length() == 0) {
            ULog.f6446a.c("AirFunctionHelper", "target package is empty");
        } else {
            ULog.Delegate delegate = ULog.f6446a;
            String functionName = airRequestModel.getFunctionName();
            delegate.c("AirFunctionHelper", "deal air function request:" + functionName);
            String functionName2 = airRequestModel.getFunctionName();
            int hashCode = functionName2.hashCode();
            if (hashCode != -495431831) {
                if (hashCode != 1270719742) {
                    if (hashCode == 1700316989 && functionName2.equals("QUERY_ADDRESS")) {
                        Intrinsics.checkNotNull(airRequestModel);
                        c(airRequestModel);
                    }
                } else if (functionName2.equals("QUERY_CONTACT_ADDRESS")) {
                    Intrinsics.checkNotNull(airRequestModel);
                    e(airRequestModel);
                }
            } else if (functionName2.equals("QUERY_CONTACT")) {
                Intrinsics.checkNotNull(airRequestModel);
                d(airRequestModel);
            }
        }
    }

    public final AirResultModel b(AirRequestModel airRequestModel) {
        return new AirResultModel(airRequestModel.getFunctionName(), airRequestModel.getRequestId(), new HashMap(), 0, (String) null, 24, (DefaultConstructorMarker) null);
    }

    public final void c(AirRequestModel airRequestModel) {
        AirResultModel b = b(airRequestModel);
        if (!airRequestModel.getParam().containsKey("phoneNo")) {
            b.setMsg("miss parma phoneNo");
            b.setCode(0);
            StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "AIR_FUNCTION", b, (SendMessageListener) null, airRequestModel.getTargetPackage(), 9, (Object) null);
            return;
        }
        b.getData().put("geo", ContactHelper.f7857a.d(String.valueOf(airRequestModel.getParam().get("phoneNo"))));
        StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "AIR_FUNCTION", b, (SendMessageListener) null, airRequestModel.getTargetPackage(), 9, (Object) null);
    }

    public final void d(AirRequestModel airRequestModel) {
        AirResultModel b = b(airRequestModel);
        if (!airRequestModel.getParam().containsKey("phoneNo")) {
            b.setMsg("miss parma phoneNo");
            b.setCode(0);
            StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "AIR_FUNCTION", b, (SendMessageListener) null, airRequestModel.getTargetPackage(), 9, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(SuperNotificationManager.f7749a.u(), (CoroutineContext) null, (CoroutineStart) null, new AirFunctionHelper$queryContact$1(airRequestModel, b, (Continuation<? super AirFunctionHelper$queryContact$1>) null), 3, (Object) null);
    }

    public final void e(AirRequestModel airRequestModel) {
        AirResultModel b = b(airRequestModel);
        if (!airRequestModel.getParam().containsKey("phoneNo")) {
            b.setMsg("miss parma phoneNo");
            b.setCode(0);
            StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "AIR_FUNCTION", b, (SendMessageListener) null, airRequestModel.getTargetPackage(), 9, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(SuperNotificationManager.f7749a.u(), (CoroutineContext) null, (CoroutineStart) null, new AirFunctionHelper$queryContactAddress$1(airRequestModel, b, (Continuation<? super AirFunctionHelper$queryContactAddress$1>) null), 3, (Object) null);
    }
}
