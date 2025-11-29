package com.upuphone.xr.sapp.monitor.notification.algorithm;

import com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/WeatherParse;", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/BaseParse;", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArNotificationModel;", "", "a", "()Ljava/lang/String;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WeatherParse extends BaseParse<ArNotificationModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7754a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/WeatherParse$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public String a() {
        return "SHOW_NOTIFICATION";
    }
}
