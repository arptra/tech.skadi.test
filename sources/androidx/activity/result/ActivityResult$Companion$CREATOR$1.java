package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/activity/result/ActivityResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/ActivityResult;", "Landroid/os/Parcel;", "parcel", "a", "(Landroid/os/Parcel;)Landroidx/activity/result/ActivityResult;", "", "size", "", "b", "(I)[Landroidx/activity/result/ActivityResult;", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityResult$Companion$CREATOR$1 implements Parcelable.Creator<ActivityResult> {
    /* renamed from: a */
    public ActivityResult createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ActivityResult(parcel);
    }

    /* renamed from: b */
    public ActivityResult[] newArray(int i) {
        return new ActivityResult[i];
    }
}
