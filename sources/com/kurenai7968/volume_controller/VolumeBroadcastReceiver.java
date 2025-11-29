package com.kurenai7968.volume_controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import io.flutter.plugin.common.EventChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/kurenai7968/volume_controller/VolumeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Lio/flutter/plugin/common/EventChannel$EventSink;", "events", "<init>", "(Lio/flutter/plugin/common/EventChannel$EventSink;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Lio/flutter/plugin/common/EventChannel$EventSink;", "Landroid/media/AudioManager;", "b", "Landroid/media/AudioManager;", "audioManager", "", "c", "D", "volumePercentage", "", "d", "I", "currentVolume", "e", "maxVolume", "volume_controller_release"}, k = 1, mv = {1, 7, 1})
public final class VolumeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final EventChannel.EventSink f9256a;
    public AudioManager b;
    public double c;
    public int d;
    public int e;

    public VolumeBroadcastReceiver(EventChannel.EventSink eventSink) {
        this.f9256a = eventSink;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        this.b = audioManager;
        AudioManager audioManager2 = null;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager = null;
        }
        this.d = audioManager.getStreamVolume(3);
        AudioManager audioManager3 = this.b;
        if (audioManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        } else {
            audioManager2 = audioManager3;
        }
        int streamMaxVolume = audioManager2.getStreamMaxVolume(3);
        this.e = streamMaxVolume;
        double d2 = ((double) this.d) / ((double) streamMaxVolume);
        double d3 = (double) 10000;
        double rint = Math.rint(d2 * d3) / d3;
        this.c = rint;
        EventChannel.EventSink eventSink = this.f9256a;
        if (eventSink != null) {
            eventSink.success(Double.valueOf(rint));
        }
    }
}
