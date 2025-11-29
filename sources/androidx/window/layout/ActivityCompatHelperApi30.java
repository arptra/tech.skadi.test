package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/window/layout/ActivityCompatHelperApi30;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/graphics/Rect;", "a", "(Landroid/app/Activity;)Landroid/graphics/Rect;", "b", "window_release"}, k = 1, mv = {1, 6, 0})
public final class ActivityCompatHelperApi30 {

    /* renamed from: a  reason: collision with root package name */
    public static final ActivityCompatHelperApi30 f2017a = new ActivityCompatHelperApi30();

    public final Rect a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect a2 = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(a2, "activity.windowManager.currentWindowMetrics.bounds");
        return a2;
    }

    public final Rect b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect a2 = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(a2, "activity.windowManager.maximumWindowMetrics.bounds");
        return a2;
    }
}
