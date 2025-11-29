package com.xjmz.myvu.flutter.pigeon;

import com.upuphone.xr.sapp.audio.GlassVolInfo;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0006*\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "min", "max", "current", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$StreamType;", "streamType", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$GlassVolumeInfo;", "a", "(JJJLcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$StreamType;)Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$GlassVolumeInfo;", "Lcom/upuphone/xr/sapp/audio/GlassVolInfo;", "b", "(Lcom/upuphone/xr/sapp/audio/GlassVolInfo;)Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$GlassVolumeInfo;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class GlassVolumeInfoExtKt {
    public static final AndroidAirGlassControlApi.GlassVolumeInfo a(long j, long j2, long j3, AndroidAirGlassControlApi.StreamType streamType) {
        Intrinsics.checkNotNullParameter(streamType, "streamType");
        AndroidAirGlassControlApi.GlassVolumeInfo a2 = new AndroidAirGlassControlApi.GlassVolumeInfo.Builder().c(Long.valueOf(j2)).d(Long.valueOf(j)).b(Long.valueOf(j3)).e(streamType).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public static final AndroidAirGlassControlApi.GlassVolumeInfo b(GlassVolInfo glassVolInfo) {
        Intrinsics.checkNotNullParameter(glassVolInfo, "<this>");
        long current = (long) glassVolInfo.getCurrent();
        return a((long) glassVolInfo.getMin(), (long) glassVolInfo.getMax(), current, glassVolInfo.getStreamType() == 0 ? AndroidAirGlassControlApi.StreamType.STREAM_VOICE_CALL : AndroidAirGlassControlApi.StreamType.STREAM_MUSIC);
    }
}
