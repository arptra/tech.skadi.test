package com.kurenai7968.volume_controller;

import android.content.Context;
import android.media.AudioManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/kurenai7968/volume_controller/VolumeObserver;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "volume", "", "showSystemUI", "", "b", "(DZ)V", "a", "()D", "Landroid/content/Context;", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "audioManager", "volume_controller_release"}, k = 1, mv = {1, 7, 1})
public final class VolumeObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9259a;
    public AudioManager b;

    public VolumeObserver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9259a = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.b = (AudioManager) systemService;
    }

    public final double a() {
        double d = (double) 10000;
        return Math.rint((((double) this.b.getStreamVolume(3)) / ((double) this.b.getStreamMaxVolume(3))) * d) / d;
    }

    public final void b(double d, boolean z) {
        double d2 = 1.0d;
        if (d <= 1.0d) {
            d2 = d;
        }
        if (d < 0.0d) {
            d2 = 0.0d;
        }
        this.b.setStreamVolume(3, (int) Math.rint(d2 * ((double) this.b.getStreamMaxVolume(3))), z ? 1 : 0);
    }
}
