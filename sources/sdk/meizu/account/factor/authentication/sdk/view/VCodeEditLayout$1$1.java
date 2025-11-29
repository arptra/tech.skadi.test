package sdk.meizu.account.factor.authentication.sdk.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/view/VCodeEditLayout$1$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VCodeEditLayout$1$1 implements TextWatcher {
    final /* synthetic */ VCodeEditLayout this$0;

    public VCodeEditLayout$1$1(VCodeEditLayout vCodeEditLayout) {
        this.this$0 = vCodeEditLayout;
    }

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        this.this$0.showError((String) null);
        EditText access$getVCodeEdit$p = this.this$0.vCodeEdit;
        if (access$getVCodeEdit$p != null) {
            access$getVCodeEdit$p.setBackgroundResource(R.drawable.factor_edit_text_bg);
        }
        this.this$0.textChangedListener.invoke(charSequence);
    }
}
