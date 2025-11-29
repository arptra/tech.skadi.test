package com.benjaminabel.vibration;

import android.media.AudioAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.util.List;

public class Vibration {

    /* renamed from: a  reason: collision with root package name */
    public final Vibrator f2412a;

    public Vibration(Vibrator vibrator) {
        this.f2412a = vibrator;
    }

    public Vibrator a() {
        return this.f2412a;
    }

    public void b(long j, int i) {
        if (!this.f2412a.hasVibrator()) {
            return;
        }
        if (this.f2412a.hasAmplitudeControl()) {
            this.f2412a.vibrate(VibrationEffect.createOneShot(j, i), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
        } else {
            this.f2412a.vibrate(VibrationEffect.createOneShot(j, -1), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
        }
    }

    public void c(List list, int i) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = (long) ((Integer) list.get(i2)).intValue();
        }
        if (this.f2412a.hasVibrator()) {
            this.f2412a.vibrate(VibrationEffect.createWaveform(jArr, i), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
        }
    }

    public void d(List list, int i, List list2) {
        int size = list.size();
        long[] jArr = new long[size];
        int size2 = list2.size();
        int[] iArr = new int[size2];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = (long) ((Integer) list.get(i2)).intValue();
        }
        for (int i3 = 0; i3 < size2; i3++) {
            iArr[i3] = ((Integer) list2.get(i3)).intValue();
        }
        if (!this.f2412a.hasVibrator()) {
            return;
        }
        if (this.f2412a.hasAmplitudeControl()) {
            this.f2412a.vibrate(VibrationEffect.createWaveform(jArr, iArr, i), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
        } else {
            this.f2412a.vibrate(VibrationEffect.createWaveform(jArr, i), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
        }
    }
}
