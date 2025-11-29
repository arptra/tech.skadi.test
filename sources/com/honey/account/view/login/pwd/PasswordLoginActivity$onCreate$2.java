package com.honey.account.view.login.pwd;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.honey.account.utils.system.InputMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/honey/account/view/login/pwd/PasswordLoginActivity$onCreate$2", "Landroid/widget/TextView$OnEditorActionListener;", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PasswordLoginActivity$onCreate$2 implements TextView.OnEditorActionListener {
    final /* synthetic */ PasswordLoginActivity this$0;

    public PasswordLoginActivity$onCreate$2(PasswordLoginActivity passwordLoginActivity) {
        this.this$0 = passwordLoginActivity;
    }

    public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        Context applicationContext = this.this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        EditText edit = this.this$0.getAccountEditLayout().getEdit();
        EditText edit2 = this.this$0.getPasswordEdit().getEdit();
        Intrinsics.checkNotNullExpressionValue(edit2, "getEdit(...)");
        InputMethodUtilsKt.closeInputMethod(applicationContext, edit, edit2);
        this.this$0.confirm();
        return true;
    }
}
