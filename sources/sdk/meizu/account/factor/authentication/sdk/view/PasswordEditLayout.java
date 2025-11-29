package sdk.meizu.account.factor.authentication.sdk.view;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ+\u0010\u001f\u001a\u00020\u001b2#\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016J\u0010\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001eH\u0002J\u0006\u0010%\u001a\u00020#J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010#J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/view/PasswordEditLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "clearView", "Landroid/widget/ImageView;", "errorTv", "Landroid/widget/TextView;", "mIvInputPwdShow", "", "passwordEdit", "Landroid/widget/EditText;", "showPwdView", "textChangedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "s", "", "titleTv", "vertivalView", "Landroid/view/View;", "bindTextChangedListener", "callback", "bindTitle", "title", "", "clearEdit", "getText", "onClick", "v", "showError", "error", "tooglePwd", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class PasswordEditLayout extends Hilt_PasswordEditLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    @Nullable
    public ImageView clearView;
    @Nullable
    private TextView errorTv;
    private boolean mIvInputPwdShow;
    /* access modifiers changed from: private */
    @Nullable
    public EditText passwordEdit;
    @Nullable
    private ImageView showPwdView;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super CharSequence, Unit> textChangedListener;
    @Nullable
    private TextView titleTv;
    /* access modifiers changed from: private */
    @Nullable
    public View vertivalView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textChangedListener = PasswordEditLayout$textChangedListener$1.INSTANCE;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_password_edit, this, true);
        this.titleTv = (TextView) inflate.findViewById(R.id.view_password_edit_title);
        this.errorTv = (TextView) inflate.findViewById(R.id.view_password_edit_error);
        this.passwordEdit = (EditText) inflate.findViewById(R.id.view_password_edit);
        this.clearView = (ImageView) inflate.findViewById(R.id.view_password_edit_clear);
        this.vertivalView = inflate.findViewById(R.id.view_password_edit_vertival);
        this.showPwdView = (ImageView) inflate.findViewById(R.id.view_password_edit_show_pwd);
        ImageView imageView = this.clearView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.showPwdView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        EditText editText = this.passwordEdit;
        if (editText != null) {
            editText.addTextChangedListener(new PasswordEditLayout$1$1(this));
        }
    }

    private final void clearEdit(View view) {
        EditText editText = this.passwordEdit;
        if (editText != null) {
            editText.setText("");
        }
        view.setVisibility(8);
    }

    private final void tooglePwd(ImageView imageView) {
        boolean z = !this.mIvInputPwdShow;
        this.mIvInputPwdShow = z;
        EditText editText = this.passwordEdit;
        if (editText != null) {
            editText.setTransformationMethod(z ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
            editText.setSelection(editText.getText().length());
        }
        imageView.setSelected(this.mIvInputPwdShow);
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

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getText()).toString();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getText() {
        /*
            r0 = this;
            android.widget.EditText r0 = r0.passwordEdit
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
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.view.PasswordEditLayout.getText():java.lang.String");
    }

    public void onClick(@Nullable View view) {
        if (view != null && view.getId() == R.id.view_password_edit_clear) {
            clearEdit(view);
        } else if (view != null && view.getId() == R.id.view_password_edit_show_pwd) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
            tooglePwd((ImageView) view);
        }
    }

    public final void showError(@Nullable String str) {
        Unit unit;
        if (str != null) {
            TextView textView = this.errorTv;
            if (textView != null) {
                textView.setText(str);
                textView.setVisibility(0);
            }
            EditText editText = this.passwordEdit;
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
        EditText editText2 = this.passwordEdit;
        if (editText2 != null) {
            editText2.setBackgroundResource(R.drawable.factor_edit_text_bg);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PasswordEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PasswordEditLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
