package com.honey.account.view.login.pwd;

import android.text.Editable;
import android.widget.Button;
import com.honey.account.utils.system.SimpleTextWatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/honey/account/view/login/pwd/PasswordLoginActivity$textWatch$1", "Lcom/honey/account/utils/system/SimpleTextWatch;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PasswordLoginActivity$textWatch$1 extends SimpleTextWatch {
    final /* synthetic */ PasswordLoginActivity this$0;

    public PasswordLoginActivity$textWatch$1(PasswordLoginActivity passwordLoginActivity) {
        this.this$0 = passwordLoginActivity;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        boolean z;
        super.afterTextChanged(editable);
        Button access$getLoginBtn = this.this$0.getLoginBtn();
        if (this.this$0.getAccountEditLayout().getEdit().getText().toString().length() > 0) {
            String text = this.this$0.getPasswordEdit().getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                z = true;
                access$getLoginBtn.setEnabled(z);
            }
        }
        z = false;
        access$getLoginBtn.setEnabled(z);
    }
}
