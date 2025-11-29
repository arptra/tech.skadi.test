package com.xjmz.myvu.modules.home;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.contract.ModulePrivacyManagerKt;
import com.upuphone.xr.sapp.entity.SubPolicyInfo;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/SubPolicyInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$addPrivacyAgreeObserve$1 extends Lambda implements Function1<SubPolicyInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$addPrivacyAgreeObserve$1(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubPolicyInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SubPolicyInfo subPolicyInfo) {
        MutableLiveData g0;
        if (subPolicyInfo != null) {
            HomeFragment homeFragment = this.this$0;
            ULog.Delegate delegate = ULog.f6446a;
            int module = subPolicyInfo.getModule();
            boolean isForeground = subPolicyInfo.isForeground();
            delegate.a("HomeFragment", " privacyAgreeModel it is: " + module + " this.isForeground=" + isForeground);
            if (subPolicyInfo.isForeground()) {
                ModulePrivacyManagerKt.j(homeFragment.requireActivity(), subPolicyInfo.getModule(), (Function0) null, 4, (Object) null);
            } else {
                FragmentActivity requireActivity = homeFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                ModulePrivacyManagerKt.n(requireActivity, subPolicyInfo.getModule());
            }
            SuperViewModel I0 = homeFragment.a1();
            if (I0 != null && (g0 = I0.g0()) != null) {
                g0.postValue(null);
            }
        }
    }
}
