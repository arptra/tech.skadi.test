package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionManagerFragment$initListener$15$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PermissionManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionManagerFragment$initListener$15$1(PermissionManagerFragment permissionManagerFragment) {
        super(0);
        this.this$0 = permissionManagerFragment;
    }

    public final void invoke() {
        HuaWeiFeatureParser b = HuaWeiFeatureParser.b();
        Context context = this.this$0.getContext();
        final PermissionManagerFragment permissionManagerFragment = this.this$0;
        b.a(context, new HuaWeiFeatureParser.HUAWEICancelAuthorizationListener() {
        });
    }
}
