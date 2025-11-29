package com.upuphone.xr.sapp.air;

import com.google.gson.reflect.TypeToken;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.sapp.glass.TwinActionMessageListener;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nGlassMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$addTwinActionResultListener$1\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 3 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,344:1\n29#2,5:345\n130#3:350\n131#3,2:352\n133#3:355\n1855#4:351\n1856#4:354\n*S KotlinDebug\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$addTwinActionResultListener$1\n+ 2 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper\n*L\n164#1:345,5\n130#2:351\n130#2:354\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"com/upuphone/xr/sapp/glass/GlassMessageHelper$addTwinActionResultListener$1", "Lcom/upuphone/xr/sapp/glass/TwinActionMessageListener;", "", "action", "subAction", "data", "", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AirHelper$special$$inlined$addTwinActionResultListener$4 implements TwinActionMessageListener {
    public void a(String str, String str2, String str3) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        JsonUtils jsonUtils = JsonUtils.f7893a;
        Type type = new TypeToken<Unit>() {
        }.getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(str3, type);
        }
        if (obj != null) {
            Unit unit = (Unit) obj;
            for (Function0 invoke : AirHelper.g) {
                invoke.invoke();
            }
        }
    }
}
