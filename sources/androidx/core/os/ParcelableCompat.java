package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ParcelableCompat {

    public static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final ParcelableCompatCreatorCallbacks f779a;

        public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
            this.f779a = parcelableCompatCreatorCallbacks;
        }

        public Object createFromParcel(Parcel parcel) {
            return this.f779a.createFromParcel(parcel, (ClassLoader) null);
        }

        public Object[] newArray(int i) {
            return this.f779a.newArray(i);
        }

        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f779a.createFromParcel(parcel, classLoader);
        }
    }

    public static Parcelable.Creator a(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}
