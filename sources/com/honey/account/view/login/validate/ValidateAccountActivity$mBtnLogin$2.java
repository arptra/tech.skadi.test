package com.honey.account.view.login.validate;

import android.widget.Button;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ValidateAccountActivity$mBtnLogin$2 extends Lambda implements Function0<Button> {
    final /* synthetic */ ValidateAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAccountActivity$mBtnLogin$2(ValidateAccountActivity validateAccountActivity) {
        super(0);
        this.this$0 = validateAccountActivity;
    }

    public final Button invoke() {
        return (Button) this.this$0.findViewById(R.id.btn_login);
    }
}
