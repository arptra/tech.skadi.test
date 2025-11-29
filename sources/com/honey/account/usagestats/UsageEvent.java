package com.honey.account.usagestats;

import com.honey.account.AccountHelper;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.utils.system.DeviceUtilsKt;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/honey/account/usagestats/UsageEvent;", "", "()V", "LIB_PKG_NAME", "", "TAG", "mDefaultProperties", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "mOnEventLibMethod", "Ljava/lang/reflect/Method;", "mUsageStatsProxy3Obj", "onEventLib", "", "eventName", "pageName", "properties", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UsageEvent {
    @NotNull
    public static final UsageEvent INSTANCE = new UsageEvent();
    @NotNull
    private static final String LIB_PKG_NAME = "com.meizu.account.outlib";
    @NotNull
    private static final String TAG = "UsageEvent";
    @NotNull
    private static LinkedHashMap<String, String> mDefaultProperties;
    @Nullable
    private static Method mOnEventLibMethod;
    @Nullable
    private static Object mUsageStatsProxy3Obj;

    static {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        mDefaultProperties = linkedHashMap;
        AccountHelper accountHelper = AccountHelper.INSTANCE;
        String packageName = accountHelper.getMApplicationContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        linkedHashMap.put(AccountConstantKt.EVENT_APP_ID, packageName);
        mDefaultProperties.put("brand", DeviceUtilsKt.getBrand());
        mDefaultProperties.put(AccountConstantKt.EVENT_EN, DeviceUtilsKt.getImeiOrOtherId(accountHelper.getMApplicationContext()));
    }

    private UsageEvent() {
    }

    public static /* synthetic */ void onEventLib$default(UsageEvent usageEvent, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        usageEvent.onEventLib(str, str2, map);
    }

    public final void onEventLib(@NotNull String str, @NotNull String str2, @Nullable Map<String, String> map) {
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "pageName");
        if (map == null) {
            map = mDefaultProperties;
        }
        try {
            if (mUsageStatsProxy3Obj == null) {
                Method declaredMethod = Class.forName("com.meizu.statsapp.v3.UsageStatsProxy3").getDeclaredMethod("getInstance", (Class[]) null);
                declaredMethod.setAccessible(true);
                mUsageStatsProxy3Obj = declaredMethod.invoke((Object) null, (Object[]) null);
            }
            if (mOnEventLibMethod == null) {
                Method declaredMethod2 = Class.forName("com.meizu.statsapp.v3.UsageStatsProxy3").getDeclaredMethod("onEventLib", (Class[]) Arrays.copyOf(new Class[]{cls, cls, Map.class, cls}, 4));
                mOnEventLibMethod = declaredMethod2;
                if (declaredMethod2 != null) {
                    declaredMethod2.setAccessible(true);
                }
            }
            Method method = mOnEventLibMethod;
            if (method != null) {
                method.invoke(mUsageStatsProxy3Obj, new Object[]{str, str2, map, LIB_PKG_NAME});
            }
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.d(TAG, "onEventLib error, " + e.getMessage());
        }
    }
}
