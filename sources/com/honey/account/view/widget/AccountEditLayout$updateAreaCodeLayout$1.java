package com.honey.account.view.widget;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/honey/account/view/widget/AccountEditLayout$updateAreaCodeLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountEditLayout$updateAreaCodeLayout$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ AccountEditLayout this$0;

    public AccountEditLayout$updateAreaCodeLayout$1(AccountEditLayout accountEditLayout) {
        this.this$0 = accountEditLayout;
    }

    public void onGlobalLayout() {
        this.this$0.getAreaCodeLayout().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.this$0.getAccountEdit().setCompoundDrawablePadding(this.this$0.getAreaCodeLayout().getMeasuredWidth());
        this.this$0.getAccountEdit().postInvalidateDelayed(100);
    }
}
