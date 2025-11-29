package com.meizu.common.widget;

import android.graphics.Rect;

class Insets {
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;

    /* renamed from: top  reason: collision with root package name */
    public final int f9496top;

    private Insets(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f9496top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public static Insets of(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return NONE;
        }
        return new Insets(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        if (this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right) {
            return this.f9496top == insets.f9496top;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.f9496top) * 31) + this.right) * 31) + this.bottom;
    }

    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.f9496top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    public static Insets of(Rect rect) {
        return rect == null ? NONE : of(rect.left, rect.top, rect.right, rect.bottom);
    }
}
