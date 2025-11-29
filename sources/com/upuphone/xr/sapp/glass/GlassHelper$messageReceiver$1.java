package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.sapp.entity.BaseActionValue;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.GlassBatteryInfo;
import com.upuphone.xr.sapp.entity.GlassUpdateDialogResult;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.entity.StarGlassUpdateResult;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$messageReceiver$1\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,649:1\n29#2,5:650\n29#2,5:659\n29#2,5:666\n29#2,5:673\n215#3:655\n216#3:658\n1855#4,2:656\n1855#4,2:664\n1855#4,2:671\n1855#4,2:678\n1855#4,2:680\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$messageReceiver$1\n*L\n110#1:650,5\n121#1:659,5\n129#1:666,5\n143#1:673,5\n112#1:655\n112#1:658\n114#1:656,2\n122#1:664,2\n130#1:671,2\n144#1:678,2\n152#1:680,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/glass/GlassHelper$messageReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "p0", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassHelper$messageReceiver$1 extends MessageReceiver {
    public void onMessageReceive(@NotNull StarryNetMessage starryNetMessage) {
        Object obj;
        Object obj2;
        String value;
        Integer intOrNull;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(starryNetMessage, "p0");
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String message = starryNetMessage.getMessage();
        Type type = new GlassHelper$messageReceiver$1$onMessageReceive$$inlined$fromJson$1().getType();
        Class<Void> cls = Void.class;
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) cls)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(message, type);
        }
        BaseActionValue baseActionValue = (BaseActionValue) obj;
        if (baseActionValue != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String message2 = starryNetMessage.getMessage();
            delegate.a("GlassHelper", "onMessageReceive: " + message2);
            for (Map.Entry entry : GlassHelper.e.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), (Object) baseActionValue.getAction())) {
                    for (GlassMessageListener a2 : (Iterable) entry.getValue()) {
                        a2.a((String) entry.getKey(), baseActionValue.getValue());
                    }
                }
            }
            String action = baseActionValue.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -1045474393:
                        if (action.equals("sync_glass_battery_info")) {
                            JsonUtils jsonUtils2 = JsonUtils.f7893a;
                            String value2 = baseActionValue.getValue();
                            Type type2 = new GlassHelper$messageReceiver$1$onMessageReceive$$inlined$fromJson$3().getType();
                            if (Intrinsics.areEqual((Object) type2, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type2, (Object) cls)) {
                                Intrinsics.checkNotNull(type2);
                                obj2 = jsonUtils2.a("{}", type2);
                            } else {
                                Intrinsics.checkNotNull(type2);
                                obj2 = jsonUtils2.a(value2, type2);
                            }
                            GlassBatteryInfo glassBatteryInfo = (GlassBatteryInfo) obj2;
                            if (glassBatteryInfo != null) {
                                for (Function1 invoke : GlassHelper.f) {
                                    invoke.invoke(glassBatteryInfo);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case -982902916:
                        if (action.equals("sync_glass_update_progress") && (value = baseActionValue.getValue()) != null && (intOrNull = StringsKt.toIntOrNull(value)) != null) {
                            int intValue = intOrNull.intValue();
                            for (Function1 invoke2 : GlassHelper.h) {
                                invoke2.invoke(new GlassUpdateProgress(intValue));
                            }
                            return;
                        }
                        return;
                    case 1115187973:
                        if (action.equals("sync_glass_update_dialog_result")) {
                            GlassHelper glassHelper = GlassHelper.f7049a;
                            JsonUtils jsonUtils3 = JsonUtils.f7893a;
                            glassHelper.M("ota", "sync_glass_update_dialog_result", jsonUtils3.d(BasicGlassResponse.Companion.success()));
                            String value3 = baseActionValue.getValue();
                            Type type3 = new GlassHelper$messageReceiver$1$onMessageReceive$$inlined$fromJson$4().getType();
                            if (Intrinsics.areEqual((Object) type3, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type3, (Object) cls)) {
                                Intrinsics.checkNotNull(type3);
                                obj3 = jsonUtils3.a("{}", type3);
                            } else {
                                Intrinsics.checkNotNull(type3);
                                obj3 = jsonUtils3.a(value3, type3);
                            }
                            GlassUpdateDialogResult glassUpdateDialogResult = (GlassUpdateDialogResult) obj3;
                            if (glassUpdateDialogResult != null) {
                                for (Function1 invoke3 : GlassHelper.g) {
                                    invoke3.invoke(glassUpdateDialogResult);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 1443243308:
                        if (action.equals("sync_glass_update_result")) {
                            JsonUtils jsonUtils4 = JsonUtils.f7893a;
                            String value4 = baseActionValue.getValue();
                            Type type4 = new GlassHelper$messageReceiver$1$onMessageReceive$$inlined$fromJson$2().getType();
                            if (Intrinsics.areEqual((Object) type4, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type4, (Object) cls)) {
                                Intrinsics.checkNotNull(type4);
                                obj4 = jsonUtils4.a("{}", type4);
                            } else {
                                Intrinsics.checkNotNull(type4);
                                obj4 = jsonUtils4.a(value4, type4);
                            }
                            StarGlassUpdateResult starGlassUpdateResult = (StarGlassUpdateResult) obj4;
                            if (starGlassUpdateResult != null) {
                                for (Function1 invoke4 : GlassHelper.c) {
                                    invoke4.invoke(starGlassUpdateResult);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
