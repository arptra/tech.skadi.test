package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionManagerFragment$addObserver$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ PermissionManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionManagerFragment$addObserver$1(PermissionManagerFragment permissionManagerFragment) {
        super(1);
        this.this$0 = permissionManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("PermissionManagerFragment", "addObserver :" + bool);
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            GenericWindowManger.c.a().j(Opcodes.IF_ACMPNE);
            this.this$0.s.removeMessages(0);
            if (this.this$0.o) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                String string = this.this$0.getString(R.string.clear_contact_data);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(requireContext, string);
            }
        }
    }
}
