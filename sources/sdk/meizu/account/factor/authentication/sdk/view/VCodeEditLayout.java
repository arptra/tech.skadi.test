package sdk.meizu.account.factor.authentication.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ+\u0010\u001c\u001a\u00020\u00182#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013J\u0010\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010!\u001a\u00020 J\u0015\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u0007¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010 R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/view/VCodeEditLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "errorTv", "Landroid/widget/TextView;", "sendVCodeTv", "getSendVCodeTv", "()Landroid/widget/TextView;", "setSendVCodeTv", "(Landroid/widget/TextView;)V", "textChangedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "s", "", "titleTv", "vCodeEdit", "Landroid/widget/EditText;", "bindTextChangedListener", "callback", "bindTitle", "title", "", "getText", "repeatTime", "second", "(I)Lkotlin/Unit;", "showError", "error", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class VCodeEditLayout extends Hilt_VCodeEditLayout {
    @Nullable
    private TextView errorTv;
    @Nullable
    private TextView sendVCodeTv;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super CharSequence, Unit> textChangedListener;
    @Nullable
    private TextView titleTv;
    /* access modifiers changed from: private */
    @Nullable
    public EditText vCodeEdit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VCodeEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textChangedListener = VCodeEditLayout$textChangedListener$1.INSTANCE;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_vcode_edit, this, true);
        this.titleTv = (TextView) inflate.findViewById(R.id.view_vcode_edit_title);
        this.errorTv = (TextView) inflate.findViewById(R.id.tv_login_code_error_msg);
        this.sendVCodeTv = (TextView) inflate.findViewById(R.id.tv_send_login_code);
        EditText editText = (EditText) inflate.findViewById(R.id.view_vcode_edit);
        this.vCodeEdit = editText;
        if (editText != null) {
            editText.addTextChangedListener(new VCodeEditLayout$1$1(this));
        }
    }

    public final void bindTextChangedListener(@NotNull Function1<? super CharSequence, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.textChangedListener = function1;
    }

    public final void bindTitle(@Nullable String str) {
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setVisibility((str == null || str.length() == 0) ? 8 : 0);
        }
        TextView textView2 = this.titleTv;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Nullable
    public final TextView getSendVCodeTv() {
        return this.sendVCodeTv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getText()).toString();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getText() {
        /*
            r0 = this;
            android.widget.EditText r0 = r0.vCodeEdit
            if (r0 == 0) goto L_0x0010
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = ""
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout.getText():java.lang.String");
    }

    @Nullable
    public final Unit repeatTime(int i) {
        TextView textView = this.sendVCodeTv;
        if (textView == null) {
            return null;
        }
        if (i != 100) {
            if (i <= 0) {
                textView.setEnabled(true);
                textView.setText(textView.getResources().getString(R.string.get_vcode));
            } else {
                textView.setEnabled(false);
                String string = textView.getResources().getString(R.string.reget_vcode);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        }
        return Unit.INSTANCE;
    }

    public final void setSendVCodeTv(@Nullable TextView textView) {
        this.sendVCodeTv = textView;
    }

    public final void showError(@Nullable String str) {
        Unit unit;
        if (str != null) {
            TextView textView = this.errorTv;
            if (textView != null) {
                textView.setText(str);
                textView.setVisibility(0);
            }
            EditText editText = this.vCodeEdit;
            if (editText != null) {
                editText.setBackgroundResource(R.drawable.edit_waring_bg);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        TextView textView2 = this.errorTv;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        EditText editText2 = this.vCodeEdit;
        if (editText2 != null) {
            editText2.setBackgroundResource(R.drawable.factor_edit_text_bg);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VCodeEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VCodeEditLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
