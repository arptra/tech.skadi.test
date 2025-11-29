package com.ucar.vehiclesdk.util;

import android.content.Context;
import android.media.AudioTrack;
import com.easy.logger.EasyLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioTrackUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f5482a = new AtomicBoolean(false);

    public static int a(Context context) {
        return context.getSharedPreferences("at_info", 0).getInt("hwl", 100);
    }

    public static void b(Context context, AudioTrack audioTrack) {
        if (f5482a.compareAndSet(false, true)) {
            try {
                try {
                    int intValue = ((Integer) AudioTrack.class.getMethod("getLatency", (Class[]) null).invoke(audioTrack, (Object[]) null)).intValue();
                    context.getSharedPreferences("at_info", 0).edit().putInt("hwl", intValue).apply();
                    EasyLog.e("AudioTrackUtil", "sHWLatency: " + intValue);
                } catch (Exception e) {
                    EasyLog.d("AudioTrackUtil", "invoke getLatency failed.", e);
                }
            } catch (Exception e2) {
                EasyLog.d("AudioTrackUtil", "get getLatency method failed.", e2);
            }
        } else {
            EasyLog.e("AudioTrackUtil", "current is invoked, not need refresh. local HWLatency: " + a(context));
        }
    }
}
