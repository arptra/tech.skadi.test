package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f726a = versionedParcel.p(iconCompat.f726a, 1);
        iconCompat.c = versionedParcel.j(iconCompat.c, 2);
        iconCompat.d = versionedParcel.r(iconCompat.d, 3);
        iconCompat.e = versionedParcel.p(iconCompat.e, 4);
        iconCompat.f = versionedParcel.p(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) versionedParcel.r(iconCompat.g, 6);
        iconCompat.i = versionedParcel.t(iconCompat.i, 7);
        iconCompat.j = versionedParcel.t(iconCompat.j, 8);
        iconCompat.t();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.u(versionedParcel.f());
        int i = iconCompat.f726a;
        if (-1 != i) {
            versionedParcel.F(i, 1);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            versionedParcel.F(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            versionedParcel.F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
