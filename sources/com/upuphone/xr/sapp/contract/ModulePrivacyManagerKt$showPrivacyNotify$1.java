package com.upuphone.xr.sapp.contract;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ModulePrivacyManagerKt$showPrivacyNotify$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $module;
    final /* synthetic */ FragmentActivity $rootActivity;
    final /* synthetic */ Ref.ObjectRef<TipsKey> $tipsKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModulePrivacyManagerKt$showPrivacyNotify$1(FragmentActivity fragmentActivity, int i, Ref.ObjectRef<TipsKey> objectRef) {
        super(0);
        this.$rootActivity = fragmentActivity;
        this.$module = i;
        this.$tipsKey = objectRef;
    }

    public final void invoke() {
        ModulePrivacyManagerKt.j(this.$rootActivity, this.$module, (Function0) null, 4, (Object) null);
        TipsManager.f7827a.d((TipsKey) this.$tipsKey.element);
    }
}
