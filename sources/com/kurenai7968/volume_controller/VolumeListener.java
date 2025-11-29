package com.kurenai7968.volume_controller;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import io.flutter.plugin.common.EventChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/kurenai7968/volume_controller/VolumeListener;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "arguments", "Lio/flutter/plugin/common/EventChannel$EventSink;", "events", "", "onListen", "(Ljava/lang/Object;Lio/flutter/plugin/common/EventChannel$EventSink;)V", "onCancel", "(Ljava/lang/Object;)V", "a", "()V", "", "b", "()D", "Landroid/content/Context;", "", "Ljava/lang/String;", "VOLUME_CHANGED_ACTION", "Lcom/kurenai7968/volume_controller/VolumeBroadcastReceiver;", "c", "Lcom/kurenai7968/volume_controller/VolumeBroadcastReceiver;", "volumeBroadcastReceiver", "Landroid/media/AudioManager;", "d", "Landroid/media/AudioManager;", "audioManager", "e", "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "volume_controller_release"}, k = 1, mv = {1, 7, 1})
public final class VolumeListener implements EventChannel.StreamHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9258a;
    public final String b = "android.media.VOLUME_CHANGED_ACTION";
    public VolumeBroadcastReceiver c;
    public AudioManager d;
    public EventChannel.EventSink e;

    public VolumeListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9258a = context;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter(this.b);
        Context context = this.f9258a;
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.c;
        if (volumeBroadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBroadcastReceiver");
            volumeBroadcastReceiver = null;
        }
        context.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }

    public final double b() {
        AudioManager audioManager = this.d;
        AudioManager audioManager2 = null;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager = null;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        AudioManager audioManager3 = this.d;
        if (audioManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        } else {
            audioManager2 = audioManager3;
        }
        double d2 = (double) 10000;
        return Math.rint((((double) streamVolume) / ((double) audioManager2.getStreamMaxVolume(3))) * d2) / d2;
    }

    public void onCancel(Object obj) {
        Context context = this.f9258a;
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.c;
        if (volumeBroadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBroadcastReceiver");
            volumeBroadcastReceiver = null;
        }
        context.unregisterReceiver(volumeBroadcastReceiver);
        this.e = null;
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.e = eventSink;
        Object systemService = this.f9258a.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.d = (AudioManager) systemService;
        this.c = new VolumeBroadcastReceiver(this.e);
        a();
        EventChannel.EventSink eventSink2 = this.e;
        if (eventSink2 != null) {
            eventSink2.success(Double.valueOf(b()));
        }
    }
}
