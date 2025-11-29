package com.honey.account.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.geetest.sdk.s;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/honey/account/view/PersonalInfoActivity$mTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PersonalInfoActivity$mTextWatcher$1 implements TextWatcher {
    final /* synthetic */ PersonalInfoActivity this$0;

    public PersonalInfoActivity$mTextWatcher$1(PersonalInfoActivity personalInfoActivity) {
        this.this$0 = personalInfoActivity;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, s.f);
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, s.f);
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, s.f);
        EditText access$getMEdVcodeEdit$p = this.this$0.mEdVcodeEdit;
        TextView textView = null;
        if (access$getMEdVcodeEdit$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
            access$getMEdVcodeEdit$p = null;
        }
        if (access$getMEdVcodeEdit$p.getText().toString().length() > 0) {
            LinearLayout access$getMEdNickNameLay$p = this.this$0.mEdNickNameLay;
            if (access$getMEdNickNameLay$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdNickNameLay");
                access$getMEdNickNameLay$p = null;
            }
            access$getMEdNickNameLay$p.setBackground(this.this$0.getDrawable(R.drawable.ha_et_bg_blue));
            Button access$getMBtDialogOk$p = this.this$0.mBtDialogOk;
            if (access$getMBtDialogOk$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
                access$getMBtDialogOk$p = null;
            }
            access$getMBtDialogOk$p.setTextColor(this.this$0.getResources().getColor(R.color.ha_blue));
            Button access$getMBtDialogOk$p2 = this.this$0.mBtDialogOk;
            if (access$getMBtDialogOk$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
                access$getMBtDialogOk$p2 = null;
            }
            access$getMBtDialogOk$p2.setClickable(true);
            Button access$getMBtDialogOk$p3 = this.this$0.mBtDialogOk;
            if (access$getMBtDialogOk$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
                access$getMBtDialogOk$p3 = null;
            }
            access$getMBtDialogOk$p3.setEnabled(true);
            ImageView access$getMIvClearText$p = this.this$0.mIvClearText;
            if (access$getMIvClearText$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvClearText");
                access$getMIvClearText$p = null;
            }
            access$getMIvClearText$p.setVisibility(0);
            TextView access$getMTvErrorMsg$p = this.this$0.mTvErrorMsg;
            if (access$getMTvErrorMsg$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvErrorMsg");
            } else {
                textView = access$getMTvErrorMsg$p;
            }
            textView.setVisibility(8);
            return;
        }
        Button access$getMBtDialogOk$p4 = this.this$0.mBtDialogOk;
        if (access$getMBtDialogOk$p4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            access$getMBtDialogOk$p4 = null;
        }
        access$getMBtDialogOk$p4.setTextColor(this.this$0.getResources().getColor(R.color.ha_blue_25));
        Button access$getMBtDialogOk$p5 = this.this$0.mBtDialogOk;
        if (access$getMBtDialogOk$p5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            access$getMBtDialogOk$p5 = null;
        }
        access$getMBtDialogOk$p5.setClickable(false);
        Button access$getMBtDialogOk$p6 = this.this$0.mBtDialogOk;
        if (access$getMBtDialogOk$p6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            access$getMBtDialogOk$p6 = null;
        }
        access$getMBtDialogOk$p6.setEnabled(false);
        ImageView access$getMIvClearText$p2 = this.this$0.mIvClearText;
        if (access$getMIvClearText$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvClearText");
            access$getMIvClearText$p2 = null;
        }
        access$getMIvClearText$p2.setVisibility(8);
        TextView access$getMTvErrorMsg$p2 = this.this$0.mTvErrorMsg;
        if (access$getMTvErrorMsg$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvErrorMsg");
        } else {
            textView = access$getMTvErrorMsg$p2;
        }
        textView.setVisibility(8);
    }
}
