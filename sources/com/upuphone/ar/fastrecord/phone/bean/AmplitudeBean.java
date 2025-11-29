package com.upuphone.ar.fastrecord.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "", "amplitude", "", "time", "", "mark", "", "(FIZ)V", "getAmplitude", "()F", "setAmplitude", "(F)V", "animating", "getAnimating", "()Z", "setAnimating", "(Z)V", "getMark", "setMark", "getTime", "()I", "setTime", "(I)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AmplitudeBean {
    private static final int BASE_RATE = 1200;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private float amplitude;
    private boolean animating;
    private boolean mark;
    private int time;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean$Companion;", "", "()V", "BASE_RATE", "", "amplitude2db", "", "amplitude", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float amplitude2db(int i) {
            float f = ((float) i) / ((float) AmplitudeBean.BASE_RATE);
            if (f > 2.0f) {
                return (float) (((double) 20) * Math.log10((double) f));
            }
            if (f <= 1.0f || f > 2.0f) {
                return 1.0f;
            }
            return f * ((float) 3);
        }

        private Companion() {
        }
    }

    public AmplitudeBean() {
        this(0.0f, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AmplitudeBean copy$default(AmplitudeBean amplitudeBean, float f, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = amplitudeBean.amplitude;
        }
        if ((i2 & 2) != 0) {
            i = amplitudeBean.time;
        }
        if ((i2 & 4) != 0) {
            z = amplitudeBean.mark;
        }
        return amplitudeBean.copy(f, i, z);
    }

    public final float component1() {
        return this.amplitude;
    }

    public final int component2() {
        return this.time;
    }

    public final boolean component3() {
        return this.mark;
    }

    @NotNull
    public final AmplitudeBean copy(float f, int i, boolean z) {
        return new AmplitudeBean(f, i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AmplitudeBean)) {
            return false;
        }
        AmplitudeBean amplitudeBean = (AmplitudeBean) obj;
        return Float.compare(this.amplitude, amplitudeBean.amplitude) == 0 && this.time == amplitudeBean.time && this.mark == amplitudeBean.mark;
    }

    public final float getAmplitude() {
        return this.amplitude;
    }

    public final boolean getAnimating() {
        return this.animating;
    }

    public final boolean getMark() {
        return this.mark;
    }

    public final int getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((Float.hashCode(this.amplitude) * 31) + Integer.hashCode(this.time)) * 31) + Boolean.hashCode(this.mark);
    }

    public final void setAmplitude(float f) {
        this.amplitude = f;
    }

    public final void setAnimating(boolean z) {
        this.animating = z;
    }

    public final void setMark(boolean z) {
        this.mark = z;
    }

    public final void setTime(int i) {
        this.time = i;
    }

    @NotNull
    public String toString() {
        float f = this.amplitude;
        int i = this.time;
        boolean z = this.mark;
        return "AmplitudeBean(amplitude=" + f + ", time=" + i + ", mark=" + z + ")";
    }

    public AmplitudeBean(float f, int i, boolean z) {
        this.amplitude = f;
        this.time = i;
        this.mark = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmplitudeBean(float f, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z);
    }
}
