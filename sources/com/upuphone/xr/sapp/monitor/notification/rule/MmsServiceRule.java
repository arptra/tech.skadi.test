package com.upuphone.xr.sapp.monitor.notification.rule;

import android.app.Notification;
import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
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

@SourceDebugExtension({"SMAP\nMmsServiceRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MmsServiceRule.kt\ncom/upuphone/xr/sapp/monitor/notification/rule/MmsServiceRule\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n526#2:61\n511#2,6:62\n125#3:68\n152#3,3:69\n1855#4,2:72\n*S KotlinDebug\n*F\n+ 1 MmsServiceRule.kt\ncom/upuphone/xr/sapp/monitor/notification/rule/MmsServiceRule\n*L\n52#1:61\n52#1:62,6\n54#1:68\n54#1:69,3\n55#1:72,2\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R7\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f`\u00128BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/MmsServiceRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "data", "", "f", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "", "postTime", "", "d", "(J)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Lkotlin/Lazy;", "e", "()Ljava/util/HashMap;", "cache", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MmsServiceRule extends Rule<AiSdkResult> {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(MmsServiceRule$cache$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/MmsServiceRule$Companion;", "", "()V", "expiratTime", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public String a() {
        return "com.android.mms.service";
    }

    public final void d(long j) {
        HashMap e = e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : e.entrySet()) {
            if (j - ((Number) entry.getValue()).longValue() > 43200000) {
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

    public final HashMap e() {
        return (HashMap) this.b.getValue();
    }

    /* renamed from: f */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        Notification notification = aiSdkResult.getSbn().getNotification();
        d(aiSdkResult.getSbn().getPostTime());
        int id = aiSdkResult.getSbn().getId();
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
        String str3 = id + g + str2;
        if (str3.length() == 0) {
            ULog.f6446a.a(b(), "message and content is empty");
            return false;
        }
        Long l = (Long) e().get(str3);
        if (l == null || aiSdkResult.getSbn().getPostTime() - l.longValue() >= 43200000) {
            e().put(str3, Long.valueOf(aiSdkResult.getSbn().getPostTime()));
            return Intrinsics.areEqual((Object) notification.category, (Object) PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        }
        ULog.f6446a.a(b(), "message repeat time");
        return false;
    }
}
