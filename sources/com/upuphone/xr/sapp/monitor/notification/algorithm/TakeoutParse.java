package com.upuphone.xr.sapp.monitor.notification.algorithm;

import com.upuphone.xr.sapp.monitor.notification.model.ArTakeoutModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTakeoutParse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TakeoutParse.kt\ncom/upuphone/xr/sapp/monitor/notification/algorithm/TakeoutParse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,274:1\n1#2:275\n766#3:276\n857#3,2:277\n766#3:279\n857#3,2:280\n*S KotlinDebug\n*F\n+ 1 TakeoutParse.kt\ncom/upuphone/xr/sapp/monitor/notification/algorithm/TakeoutParse\n*L\n157#1:276\n157#1:277,2\n171#1:279\n171#1:280,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TakeoutParse;", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/BaseParse;", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArTakeoutModel;", "", "a", "()Ljava/lang/String;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TakeoutParse extends BaseParse<ArTakeoutModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7752a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TakeoutParse$Companion;", "", "()V", "CHAT", "", "ELE", "MEI_TUAN", "TAG", "TAKEOUT_STATE", "cancelOrder", "deliveryPickedUp", "mealDelivered", "merchantReceivesOrder", "noDelivery", "orderLate", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public String a() {
        return "SYNC_SMART_REMINDER_TAKEOUT";
    }
}
