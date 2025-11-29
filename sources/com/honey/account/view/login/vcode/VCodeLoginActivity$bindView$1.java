package com.honey.account.view.login.vcode;

import android.text.Editable;
import com.honey.account.utils.system.SimpleTextWatch;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/honey/account/view/login/vcode/VCodeLoginActivity$bindView$1", "Lcom/honey/account/utils/system/SimpleTextWatch;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VCodeLoginActivity$bindView$1 extends SimpleTextWatch {
    final /* synthetic */ VCodeLoginActivity this$0;

    public VCodeLoginActivity$bindView$1(VCodeLoginActivity vCodeLoginActivity) {
        this.this$0 = vCodeLoginActivity;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        this.this$0.getGetVCodeBtn().setEnabled(String.valueOf(editable).length() > 0);
        this.this$0.showError((String) null);
    }
}
