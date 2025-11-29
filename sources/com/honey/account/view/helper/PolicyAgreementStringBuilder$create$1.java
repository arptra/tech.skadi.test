package com.honey.account.view.helper;

import android.view.View;
import com.honey.account.view.helper.PolicyAgreementStringBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/honey/account/view/helper/PolicyAgreementStringBuilder$create$1", "Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$PermissionClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolicyAgreementStringBuilder$create$1 extends PolicyAgreementStringBuilder.PermissionClickableSpan {
    final /* synthetic */ PolicyAgreementStringBuilder this$0;

    public PolicyAgreementStringBuilder$create$1(PolicyAgreementStringBuilder policyAgreementStringBuilder) {
        this.this$0 = policyAgreementStringBuilder;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        super.onClick(view);
        this.this$0.getMOnClickListener().onUserAgreementClick(view.getContext());
    }
}
