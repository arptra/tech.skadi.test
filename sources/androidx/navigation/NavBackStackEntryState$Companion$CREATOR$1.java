package androidx.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/navigation/NavBackStackEntryState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcel;", "inParcel", "a", "(Landroid/os/Parcel;)Landroidx/navigation/NavBackStackEntryState;", "", "size", "", "b", "(I)[Landroidx/navigation/NavBackStackEntryState;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public final class NavBackStackEntryState$Companion$CREATOR$1 implements Parcelable.Creator<NavBackStackEntryState> {
    /* renamed from: a */
    public NavBackStackEntryState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "inParcel");
        return new NavBackStackEntryState(parcel);
    }

    /* renamed from: b */
    public NavBackStackEntryState[] newArray(int i) {
        return new NavBackStackEntryState[i];
    }
}
