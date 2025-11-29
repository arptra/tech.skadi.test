package com.upuphone.ar.navi.lite.manger;

import android.content.Context;
import android.os.PowerManager;
import com.honey.account.h4.i;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.datatrack.NaviDataTrackUtil;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviExitType;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J \u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J(\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0007J\u001a\u0010#\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/upuphone/ar/navi/lite/manger/NaviDataTrackManager;", "", "()V", "FailExist", "", "TAG", "UserExist", "isFinishNav", "isNotFinishNavi", "isScreenOn", "", "context", "Landroid/content/Context;", "reportCancelNaviForCancelTypeTask", "", "cancelTypeValue", "cancelCurrentPosition", "navTaskIsFinish", "reportCancelNaviTask", "Lcom/upuphone/ar/navi/lite/util/NaviExitType;", "reportChangeWaysModeTask", "preWaysMode", "nextWaysMode", "currentPosition", "reportCommonAddressesNavTask", "commonAddressesDetails", "startNavPosition", "reportCommonAddressesNavTaskForBackThread", "curSearchModel", "Lcom/upuphone/ar/navi/lite/base/SearchModel;", "reportStartNaviTask", "startTypeValue", "waysModeValue", "navStartPositionValue", "navEndPosition", "reportStatusNaviTask", "displayStatus", "ar-navi_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NaviDataTrackManager {
    @NotNull
    public static final String FailExist = "1";
    @NotNull
    public static final NaviDataTrackManager INSTANCE = new NaviDataTrackManager();
    @NotNull
    private static final String TAG = "NaviDataTrackUtil";
    @NotNull
    public static final String UserExist = "0";
    @NotNull
    public static final String isFinishNav = "1";
    @NotNull
    public static final String isNotFinishNavi = "0";

    private NaviDataTrackManager() {
    }

    private final boolean isScreenOn(Context context) {
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isInteractive();
    }

    @JvmStatic
    public static final void reportCancelNaviForCancelTypeTask(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "cancelTypeValue");
        Intrinsics.checkNotNullParameter(str2, "cancelCurrentPosition");
        Intrinsics.checkNotNullParameter(str3, "navTaskIsFinish");
        NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
        HashMap hashMap = new HashMap();
        hashMap.put("cancel_type", str);
        hashMap.put("cancel_current_position", str2);
        hashMap.put("nav_task_is_finish", str3);
        hashMap.put("time_pagefrom_button", String.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        naviDataTrackUtil.a("cancel_nav_task", hashMap);
    }

    @JvmStatic
    public static final void reportCancelNaviTask(@NotNull NaviExitType naviExitType, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(naviExitType, "cancelTypeValue");
        Intrinsics.checkNotNullParameter(str, "cancelCurrentPosition");
        Intrinsics.checkNotNullParameter(str2, "navTaskIsFinish");
        String str3 = (naviExitType == NaviExitType.GLASS_ABNORMAL_EXIT || naviExitType == NaviExitType.PHONE_NAVI_COMPLETE_EXIT) ? "0" : "1";
        NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
        HashMap hashMap = new HashMap();
        hashMap.put("cancel_type", str3);
        hashMap.put("cancel_current_position", str);
        hashMap.put("nav_task_is_finish", str2);
        hashMap.put("time_pagefrom_button", String.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        naviDataTrackUtil.a("cancel_nav_task", hashMap);
    }

    @JvmStatic
    public static final void reportChangeWaysModeTask(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "preWaysMode");
        Intrinsics.checkNotNullParameter(str2, "nextWaysMode");
        Intrinsics.checkNotNullParameter(str3, "currentPosition");
        NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
        HashMap hashMap = new HashMap();
        hashMap.put("pre_ways_mode", str);
        hashMap.put("next_ways_mode", str2);
        hashMap.put("current_position", str3);
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        naviDataTrackUtil.a("change_ways_mode", hashMap);
    }

    @JvmStatic
    public static final void reportCommonAddressesNavTask(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "commonAddressesDetails");
        Intrinsics.checkNotNullParameter(str2, "startNavPosition");
        NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
        HashMap hashMap = new HashMap();
        hashMap.put("common_addresses_details", str);
        hashMap.put("start_nav_position", str2);
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        naviDataTrackUtil.a("common_addresses_nav", hashMap);
    }

    @JvmStatic
    public static final void reportCommonAddressesNavTaskForBackThread(@NotNull Context context, @NotNull SearchModel searchModel, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchModel, "curSearchModel");
        Intrinsics.checkNotNullParameter(str, "startNavPosition");
        new Thread(new i(context, searchModel)).start();
    }

    /* access modifiers changed from: private */
    public static final void reportCommonAddressesNavTaskForBackThread$lambda$5(Context context, SearchModel searchModel) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(searchModel, "$curSearchModel");
        String name = Thread.currentThread().getName();
        CLog.c(TAG, "reportCommonAddressesNavTaskForBackThread curThread = " + name);
        if (NaviUtil.K0(context, searchModel)) {
            String address = searchModel.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
            String d = LocationManager.f().d();
            Intrinsics.checkNotNullExpressionValue(d, "getCurPosition(...)");
            reportCommonAddressesNavTask(address, d);
        }
    }

    @JvmStatic
    public static final void reportStartNaviTask(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "startTypeValue");
        Intrinsics.checkNotNullParameter(str2, "waysModeValue");
        Intrinsics.checkNotNullParameter(str3, "navStartPositionValue");
        Intrinsics.checkNotNullParameter(str4, "navEndPosition");
        NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
        HashMap hashMap = new HashMap();
        hashMap.put("start_type", str);
        hashMap.put("ways_mode", str2);
        hashMap.put("nav_start_position", str3);
        hashMap.put("nav_end_position", str4);
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        naviDataTrackUtil.a("start_nav_task", hashMap);
    }

    @JvmStatic
    public static final void reportStatusNaviTask(@Nullable Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "displayStatus");
        if (context == null) {
            CLog.c(TAG, "reportStatusNaviTask context == null");
        }
        if (context != null) {
            NaviDataTrackUtil naviDataTrackUtil = NaviDataTrackUtil.f5757a;
            HashMap hashMap = new HashMap();
            hashMap.put("screen_status", INSTANCE.isScreenOn(context) ? "1" : "0");
            hashMap.put("display_status", str);
            Unit unit = Unit.INSTANCE;
            naviDataTrackUtil.a("status_naving", hashMap);
        }
    }
}
