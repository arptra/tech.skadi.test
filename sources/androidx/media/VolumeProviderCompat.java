package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    public final int f1461a;
    public final int b;
    public int c;
    public Callback d;
    public VolumeProvider e;

    public static abstract class Callback {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f1461a;
    }

    public Object d() {
        if (this.e == null) {
            this.e = new VolumeProvider(this.f1461a, this.b, this.c) {
                public void onAdjustVolume(int i) {
                    VolumeProviderCompat.this.e(i);
                }

                public void onSetVolumeTo(int i) {
                    VolumeProviderCompat.this.f(i);
                }
            };
        }
        return this.e;
    }

    public void e(int i) {
    }

    public void f(int i) {
    }

    public void g(Callback callback) {
        this.d = callback;
    }
}
