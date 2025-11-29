package com.upuphone.xr.sapp.vu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.b9.t;
import com.honey.account.b9.u;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.DrawableEditText;
import com.upuphone.xr.sapp.view.SelectionWatcherEditText;
import com.upuphone.xr.sapp.vu.arspace.EditTextInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0003#$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuInputDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/upuphone/xr/sapp/vu/arspace/EditTextInfo;", "textInfo", "", "j", "(Lcom/upuphone/xr/sapp/vu/arspace/EditTextInfo;)V", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnEditorActionListener;", "listener", "h", "(Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnEditorActionListener;)V", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnTextChangeListener;", "i", "(Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnTextChangeListener;)V", "Lcom/upuphone/xr/sapp/view/DrawableEditText;", "a", "Lkotlin/Lazy;", "g", "()Lcom/upuphone/xr/sapp/view/DrawableEditText;", "editInput", "b", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnTextChangeListener;", "onTextChangeListener", "c", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnEditorActionListener;", "onEditorActionListener", "Landroid/text/TextWatcher;", "d", "Landroid/text/TextWatcher;", "textWatcher", "e", "Companion", "OnEditorActionListener", "OnTextChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuInputDialog extends Dialog {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f8029a = LazyKt.lazy(new VuInputDialog$editInput$2(this));
    public OnTextChangeListener b;
    public OnEditorActionListener c;
    public final TextWatcher d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuInputDialog$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnEditorActionListener;", "", "", "action", "", "a", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnEditorActionListener {
        void a(int i);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnTextChangeListener;", "", "", "text", "", "b", "(Ljava/lang/String;)V", "", "start", "end", "a", "(II)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnTextChangeListener {
        void a(int i, int i2);

        void b(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuInputDialog(Context context) {
        super(context, R.style.ViewInputDialog);
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(R.layout.dialog_vu_input);
        setCanceledOnTouchOutside(true);
        g().setShowSoftInputOnFocus(true);
        g().setOnDrawableClickListener(new DrawableEditText.OnDrawableClickListener() {
            public void a(int i, DrawableEditText drawableEditText) {
                Intrinsics.checkNotNullParameter(drawableEditText, "editText");
                drawableEditText.setText("");
            }
        });
        g().setOnEditorActionListener(new t(this));
        g().setOnSelectionChangedListener(new SelectionWatcherEditText.OnSelectionChangedListener(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ VuInputDialog f8030a;

            {
                this.f8030a = r1;
            }

            public void a(int i, int i2) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.g("VuInputDialog", "onSelectionChanged: " + i + ", " + i2);
                OnTextChangeListener f = this.f8030a.b;
                if (f != null) {
                    f.a(this.f8030a.g().getSelectionStart(), this.f8030a.g().getSelectionEnd());
                }
            }
        });
        setOnShowListener(new u(this));
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = null;
        if (window != null) {
            window.setBackgroundDrawable((Drawable) null);
            window.setSoftInputMode(5);
        }
        Window window2 = getWindow();
        if (!(window2 == null || (attributes = window2.getAttributes()) == null)) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            layoutParams = attributes;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
        this.d = new TextWatcher(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ VuInputDialog f8031a;

            {
                this.f8031a = r1;
            }

            public void afterTextChanged(Editable editable) {
                OnTextChangeListener f = this.f8031a.b;
                if (f != null) {
                    f.b(String.valueOf(editable));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    public static final boolean c(VuInputDialog vuInputDialog, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(vuInputDialog, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuInputDialog", "setOnEditorActionListener: " + i);
        OnEditorActionListener onEditorActionListener = vuInputDialog.c;
        if (onEditorActionListener == null) {
            return true;
        }
        onEditorActionListener.a(i);
        return true;
    }

    public static final void d(VuInputDialog vuInputDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(vuInputDialog, "this$0");
        vuInputDialog.g().requestFocus();
    }

    public final DrawableEditText g() {
        Object value = this.f8029a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (DrawableEditText) value;
    }

    public final void h(OnEditorActionListener onEditorActionListener) {
        Intrinsics.checkNotNullParameter(onEditorActionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = onEditorActionListener;
    }

    public final void i(OnTextChangeListener onTextChangeListener) {
        Intrinsics.checkNotNullParameter(onTextChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = onTextChangeListener;
    }

    public final void j(EditTextInfo editTextInfo) {
        Intrinsics.checkNotNullParameter(editTextInfo, "textInfo");
        super.show();
        ULog.Delegate delegate = ULog.f6446a;
        String str = editTextInfo.text;
        int i = editTextInfo.selectionStart;
        int i2 = editTextInfo.selectionEnd;
        delegate.a("VuInputDialog", "show: " + str + ", " + i + ", " + i2);
        g().removeTextChangedListener(this.d);
        g().setImeOptions(3);
        DrawableEditText g = g();
        String str2 = editTextInfo.hint;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        g.setHint(str2);
        String valueOf = g().getText() == null ? str3 : String.valueOf(g().getText());
        delegate.a("VuInputDialog", "current text: " + valueOf);
        if (!Intrinsics.areEqual((Object) valueOf, (Object) editTextInfo.text)) {
            delegate.a("VuInputDialog", "not same: setTextAgain");
            DrawableEditText g2 = g();
            String str4 = editTextInfo.text;
            if (str4 != null) {
                str3 = str4;
            }
            g2.setText(str3);
        }
        String str5 = editTextInfo.text;
        if (str5 != null && str5.length() > 0) {
            int i3 = editTextInfo.selectionEnd;
            if (i3 < 0) {
                i3 = editTextInfo.text.length();
            }
            int coerceAtMost = RangesKt.coerceAtMost(i3, editTextInfo.text.length());
            int i4 = editTextInfo.selectionStart;
            if (i4 < 0) {
                i4 = coerceAtMost;
            }
            g().setSelection(RangesKt.coerceAtMost(i4, coerceAtMost), coerceAtMost);
        }
        g().setImeOptions(editTextInfo.imeAction);
        g().addTextChangedListener(this.d);
    }
}
