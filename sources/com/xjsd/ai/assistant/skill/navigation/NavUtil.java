package com.xjsd.ai.assistant.skill.navigation;

import android.content.Context;
import android.location.LocationManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AssistantLifecycle;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper;
import com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/NavUtil;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NavUnusableReason;", "a", "()Lcom/xjsd/ai/assistant/skill/navigation/enums/NavUnusableReason;", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NavUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final NavUtil f8684a = new NavUtil();

    public static final NavUnusableReason a() {
        if (AssistantProtocolHelper.g() && !AssistantProtocolHelper.i()) {
            return NavUnusableReason.NOT_AGREE_PROTOCOL;
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        if (!b(a2)) {
            return NavUnusableReason.NOT_OPEN_GPS;
        }
        List<String> findDeniedPermissions = SuperAppAbilityManager.e().f().findDeniedPermissions();
        if (findDeniedPermissions.contains("android.permission.ACCESS_NETWORK_STATE")) {
            return NavUnusableReason.LACK_ACCESS_NETWORK_STATE;
        }
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        for (int i = 0; i < 2; i++) {
            if (findDeniedPermissions.contains(strArr[i])) {
                return NavUnusableReason.LACK_LOCATION_PERMISSION;
            }
        }
        if (AssistantLifecycle.a() || !ContextHelper.f("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return null;
        }
        ILog.a("NavUtil", "app is in background & lack background location permission");
        return NavUnusableReason.LACK_BACKGROUND_LOCATION_PERMISSION;
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }
}
