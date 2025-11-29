package com.xjmz.myvu.flutter.pigeon.impl;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AirGlassControlApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$AirGlassControlApi;", "<init>", "()V", "", "current", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$StreamType;", "streamType", "", "isEnd", "", "j", "(JLcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$StreamType;Z)V", "i", "(JZ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AirGlassControlApiHandler implements AndroidAirGlassControlApi.AirGlassControlApi {

    /* renamed from: a  reason: collision with root package name */
    public static final AirGlassControlApiHandler f8339a = new AirGlassControlApiHandler();

    public /* bridge */ /* synthetic */ void a(Long l, Boolean bool) {
        i(l.longValue(), bool.booleanValue());
    }

    public /* bridge */ /* synthetic */ void d(Long l, AndroidAirGlassControlApi.StreamType streamType, Boolean bool) {
        j(l.longValue(), streamType, bool.booleanValue());
    }

    public void i(long j, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AirGlassControlApiHandler", "updateGlassBrightness: " + j + ", isEnd: " + z);
        if (z) {
            SuperMessageManger.m.a().o0((int) j);
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            int intValue = ((Number) DataStoreUtils.i(companion.a(), "app_slide_brightness", 1, (Context) null, 4, (Object) null)).intValue();
            DataTrackUtil.f7875a.i("app_slide_brightness", MapsKt.mapOf(TuplesKt.to("times", String.valueOf(intValue))));
            companion.a().o("app_slide_brightness", Integer.valueOf(intValue + 1));
            return;
        }
        SuperMessageManger.m.a().n0(String.valueOf(j));
    }

    public void j(long j, AndroidAirGlassControlApi.StreamType streamType, boolean z) {
        Intrinsics.checkNotNullParameter(streamType, "streamType");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AirGlassControlApiHandler", "updateGlassVolume: " + j + ", steamType: " + streamType + ", isEnd: " + z);
        SuperMessageManger.m.a().z0(String.valueOf(j), streamType == AndroidAirGlassControlApi.StreamType.STREAM_VOICE_CALL ? 0 : 3, z);
        if (z) {
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            int intValue = ((Number) DataStoreUtils.i(companion.a(), "app_slide_volume", 1, (Context) null, 4, (Object) null)).intValue();
            DataTrackUtil.f7875a.i("app_slide_volume", MapsKt.mapOf(TuplesKt.to("times", String.valueOf(intValue))));
            companion.a().o("app_slide_volume", Integer.valueOf(intValue + 1));
        }
    }
}
