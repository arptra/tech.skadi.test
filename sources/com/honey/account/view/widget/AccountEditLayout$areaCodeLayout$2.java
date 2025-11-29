package com.honey.account.view.widget;

import android.view.ViewGroup;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountEditLayout$areaCodeLayout$2 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ AccountEditLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountEditLayout$areaCodeLayout$2(AccountEditLayout accountEditLayout) {
        super(0);
        this.this$0 = accountEditLayout;
    }

    public final ViewGroup invoke() {
        return (ViewGroup) this.this$0.findViewById(R.id.account_edit_layout_area_code);
    }
}
