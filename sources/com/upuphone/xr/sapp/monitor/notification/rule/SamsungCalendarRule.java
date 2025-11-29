package com.upuphone.xr.sapp.monitor.notification.rule;

import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSamsungCalendarRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SamsungCalendarRule.kt\ncom/upuphone/xr/sapp/monitor/notification/rule/SamsungCalendarRule\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n526#2:64\n511#2,6:65\n125#3:71\n152#3,3:72\n1855#4,2:75\n*S KotlinDebug\n*F\n+ 1 SamsungCalendarRule.kt\ncom/upuphone/xr/sapp/monitor/notification/rule/SamsungCalendarRule\n*L\n55#1:64\n55#1:65,6\n57#1:71\n57#1:72,3\n58#1:75,2\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R7\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0011j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005`\u00128BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/SamsungCalendarRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "", "postTime", "", "d", "(J)V", "data", "", "f", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Lkotlin/Lazy;", "e", "()Ljava/util/HashMap;", "cache", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SamsungCalendarRule extends Rule<AiSdkResult> {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(SamsungCalendarRule$cache$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/SamsungCalendarRule$Companion;", "", "()V", "expiratTime", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void d(long j) {
        HashMap e = e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : e.entrySet()) {
            if (j - ((Number) entry.getValue()).longValue() > 300000) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        for (String remove : arrayList) {
            e().remove(remove);
        }
    }

    private final HashMap e() {
        return (HashMap) this.b.getValue();
    }

    public String a() {
        return "com.samsung.android.calendar";
    }

    /* renamed from: f */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        d(aiSdkResult.getSbn().getPostTime());
        ArSmartReminderModel model = aiSdkResult.getModel();
        String str = null;
        String g = model != null ? model.g() : null;
        String str2 = "";
        if (g == null) {
            g = str2;
        }
        ArSmartReminderModel model2 = aiSdkResult.getModel();
        if (model2 != null) {
            str = model2.a();
        }
        if (str != null) {
            str2 = str;
        }
        String str3 = g + str2;
        if (str3.length() == 0) {
            ULog.f6446a.a(b(), "Calendar message and content is empty");
            return false;
        }
        Long l = (Long) e().get(str3);
        if (l == null || aiSdkResult.getSbn().getPostTime() - l.longValue() >= 300000) {
            e().put(str3, Long.valueOf(aiSdkResult.getSbn().getPostTime()));
            return true;
        }
        ULog.f6446a.a(b(), "Calendar message repeat time");
        return false;
    }
}
