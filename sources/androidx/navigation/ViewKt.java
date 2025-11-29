package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Landroidx/navigation/NavController;", "a", "(Landroid/view/View;)Landroidx/navigation/NavController;", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0})
public final class ViewKt {
    public static final NavController a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return Navigation.c(view);
    }
}
