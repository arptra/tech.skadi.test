package androidx.navigation;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/app/Activity;", "", "viewId", "Landroidx/navigation/NavController;", "a", "(Landroid/app/Activity;I)Landroidx/navigation/NavController;", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0})
public final class ActivityKt {
    public static final NavController a(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return Navigation.b(activity, i);
    }
}
