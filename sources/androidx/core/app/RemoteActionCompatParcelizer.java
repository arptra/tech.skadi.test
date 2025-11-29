package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f679a = (IconCompat) versionedParcel.v(remoteActionCompat.f679a, 1);
        remoteActionCompat.b = versionedParcel.l(remoteActionCompat.b, 2);
        remoteActionCompat.c = versionedParcel.l(remoteActionCompat.c, 3);
        remoteActionCompat.d = (PendingIntent) versionedParcel.r(remoteActionCompat.d, 4);
        remoteActionCompat.e = versionedParcel.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = versionedParcel.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f679a, 1);
        versionedParcel.D(remoteActionCompat.b, 2);
        versionedParcel.D(remoteActionCompat.c, 3);
        versionedParcel.H(remoteActionCompat.d, 4);
        versionedParcel.z(remoteActionCompat.e, 5);
        versionedParcel.z(remoteActionCompat.f, 6);
    }
}
