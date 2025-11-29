package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavController;", "a", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;", "navigation-fragment_release"}, k = 2, mv = {1, 6, 0})
public final class FragmentKt {
    public static final NavController a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return NavHostFragment.f.c(fragment);
    }
}
