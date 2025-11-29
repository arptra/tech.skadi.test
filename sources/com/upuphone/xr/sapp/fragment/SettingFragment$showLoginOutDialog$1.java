package com.upuphone.xr.sapp.fragment;

import androidx.navigation.fragment.FragmentKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.utils.AppUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingFragment.kt\ncom/upuphone/xr/sapp/fragment/SettingFragment$showLoginOutDialog$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1#2:179\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SettingFragment$showLoginOutDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingFragment$showLoginOutDialog$1(SettingFragment settingFragment) {
        super(0);
        this.this$0 = settingFragment;
    }

    public final void invoke() {
        if (this.this$0.getContext() != null) {
            MzAccountManager.Companion companion = MzAccountManager.c;
            companion.b().f();
            SettingFragment settingFragment = this.this$0;
            companion.e(false);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("SettingFragment", "account  logout forceLogin mineFragment");
            FragmentKt.a(settingFragment).W(R.id.empty_fragment, false);
            delegate.c("SettingFragment", "account  logout by buttonAction unbind device");
            companion.d();
            AppUtils.f7842a.s();
        }
    }
}
