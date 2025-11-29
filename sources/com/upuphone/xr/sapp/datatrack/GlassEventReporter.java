package com.upuphone.xr.sapp.datatrack;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/GlassEventReporter;", "", "<init>", "()V", "", "", "", "events", "", "a", "(Ljava/util/List;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassEventReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassEventReporter.kt\ncom/upuphone/xr/sapp/datatrack/GlassEventReporter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1855#2,2:60\n800#2,11:62\n1549#2:73\n1620#2,3:74\n*S KotlinDebug\n*F\n+ 1 GlassEventReporter.kt\ncom/upuphone/xr/sapp/datatrack/GlassEventReporter\n*L\n18#1:60,2\n43#1:62,11\n50#1:73\n50#1:74,3\n*E\n"})
public final class GlassEventReporter {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassEventReporter f6918a = new GlassEventReporter();

    public final void a(List list) {
        String obj;
        Intrinsics.checkNotNullParameter(list, "events");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            Map mutableMap = MapsKt.toMutableMap(map);
            String str = null;
            try {
                Object obj2 = mutableMap.get("_event_attr_value_");
                Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
                if (map2 != null) {
                    Map mutableMap2 = MapsKt.toMutableMap(map2);
                    mutableMap2.put("phone_recv_time", Long.valueOf(System.currentTimeMillis()));
                    mutableMap.put("_event_attr_value_", mutableMap2);
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("GlassEventReporter", "reportGlassEvent, event: " + map + " error: " + e);
            }
            DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
            Object obj3 = mutableMap.get("_iot_device_id_");
            String obj4 = obj3 != null ? obj3.toString() : null;
            Object obj5 = mutableMap.get("_iot_device_model_");
            String obj6 = obj5 != null ? obj5.toString() : null;
            Object obj7 = mutableMap.get("_iot_device_rom_");
            if (obj7 == null || (obj = obj7.toString()) == null) {
                Object obj8 = mutableMap.get("iot_device_rom");
                if (obj8 != null) {
                    str = obj8.toString();
                }
            } else {
                str = obj;
            }
            dataTrackUtil.o(mutableMap, obj4, obj6, str);
        }
    }
}
