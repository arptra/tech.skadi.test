package com.xjmz.myvu.modules.home;

import androidx.fragment.app.FragmentActivity;
import com.xjmz.myvu.permissions.PermissionAndStateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjmz/myvu/permissions/PermissionAndStateHelper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$permissionAndStateHelper$2 extends Lambda implements Function0<PermissionAndStateHelper> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$permissionAndStateHelper$2(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    @NotNull
    public final PermissionAndStateHelper invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        final HomeFragment homeFragment = this.this$0;
        return new PermissionAndStateHelper(requireActivity, new Function0<Unit>() {
            public final void invoke() {
                homeFragment.f1();
            }
        });
    }
}
