package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;

public final class SizeFCompat {

    /* renamed from: a  reason: collision with root package name */
    public final float f851a;
    public final float b;

    @RequiresApi
    public static final class Api21Impl {
        @DoNotInline
        @NonNull
        public static SizeF a(@NonNull SizeFCompat sizeFCompat) {
            Preconditions.h(sizeFCompat);
            return new SizeF(sizeFCompat.b(), sizeFCompat.a());
        }

        @DoNotInline
        @NonNull
        public static SizeFCompat b(@NonNull SizeF sizeF) {
            Preconditions.h(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public SizeFCompat(float f, float f2) {
        this.f851a = Preconditions.c(f, MonthView.VIEW_PARAMS_WIDTH);
        this.b = Preconditions.c(f2, MonthView.VIEW_PARAMS_HEIGHT);
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.f851a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        return sizeFCompat.f851a == this.f851a && sizeFCompat.b == this.b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.b) ^ Float.floatToIntBits(this.f851a);
    }

    public String toString() {
        return this.f851a + x.f + this.b;
    }
}
