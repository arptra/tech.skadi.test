package androidx.navigation;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/navigation/NavController$onBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavController$onBackPressedCallback$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f1475a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$onBackPressedCallback$1(NavController navController) {
        super(false);
        this.f1475a = navController;
    }

    public void handleOnBackPressed() {
        this.f1475a.V();
    }
}
