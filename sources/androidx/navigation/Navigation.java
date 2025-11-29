package androidx.navigation;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Landroidx/navigation/Navigation;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "viewId", "Landroidx/navigation/NavController;", "b", "(Landroid/app/Activity;I)Landroidx/navigation/NavController;", "Landroid/view/View;", "view", "c", "(Landroid/view/View;)Landroidx/navigation/NavController;", "controller", "", "f", "(Landroid/view/View;Landroidx/navigation/NavController;)V", "d", "e", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public final class Navigation {

    /* renamed from: a  reason: collision with root package name */
    public static final Navigation f1493a = new Navigation();

    public static final NavController b(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View f = ActivityCompat.f(activity, i);
        Intrinsics.checkNotNullExpressionValue(f, "requireViewById<View>(activity, viewId)");
        NavController d = f1493a.d(f);
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    public static final NavController c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController d = f1493a.d(view);
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static final void f(View view, NavController navController) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    public final NavController d(View view) {
        return (NavController) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(view, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    public final NavController e(View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
