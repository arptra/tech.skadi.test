package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.BaseActionValue;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nGlassMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$messageReceiver$1\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,344:1\n29#2,5:345\n215#3:350\n216#3:353\n1855#4,2:351\n*S KotlinDebug\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$messageReceiver$1\n*L\n42#1:345,5\n46#1:350\n46#1:353\n49#1:351,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/glass/GlassMessageHelper$messageReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "starryNetMessage", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassMessageHelper$messageReceiver$1 extends MessageReceiver {
    public void onMessageReceive(@NotNull StarryNetMessage starryNetMessage) {
        Object obj;
        String action;
        BaseActionValue data;
        String action2;
        Intrinsics.checkNotNullParameter(starryNetMessage, "starryNetMessage");
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String message = starryNetMessage.getMessage();
        Type type = new GlassMessageHelper$messageReceiver$1$onMessageReceive$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(message, type);
        }
        BaseActionData baseActionData = (BaseActionData) obj;
        if (baseActionData != null && (action = baseActionData.getAction()) != null && (data = baseActionData.getData()) != null && (action2 = data.getAction()) != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String message2 = starryNetMessage.getMessage();
            delegate.a("GlassMessageHelper", "onMessageReceive: " + message2);
            for (Map.Entry entry : GlassMessageHelper.c.entrySet()) {
                Pair pair = (Pair) entry.getKey();
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (Intrinsics.areEqual((Object) str, (Object) action) && Intrinsics.areEqual((Object) str2, (Object) action2)) {
                    for (TwinActionMessageListener twinActionMessageListener : (Iterable) entry.getValue()) {
                        BaseActionValue data2 = baseActionData.getData();
                        twinActionMessageListener.a(str, str2, data2 != null ? data2.getValue() : null);
                    }
                }
            }
        }
    }
}
