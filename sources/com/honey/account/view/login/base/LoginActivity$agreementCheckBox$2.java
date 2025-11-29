package com.honey.account.view.login.base;

import android.widget.CheckBox;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LoginActivity$agreementCheckBox$2 extends Lambda implements Function0<CheckBox> {
    final /* synthetic */ LoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginActivity$agreementCheckBox$2(LoginActivity loginActivity) {
        super(0);
        this.this$0 = loginActivity;
    }

    public final CheckBox invoke() {
        return (CheckBox) this.this$0.findViewById(R.id.checkbox_agreement);
    }
}
