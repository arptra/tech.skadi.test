package com.upuphone.ar.transcribe.phone.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.honey.account.y4.b;
import com.honey.account.y4.c;
import com.honey.account.y4.d;
import com.honey.account.y4.e;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.utils.RomUtils;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 62\u00020\u0001:\u00017B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0017J2\u0010!\u001a\u00020\f2#\b\u0002\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u000eJ\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u000eR3\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010,R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010)\u001a\u0004\b2\u00103\"\u0004\b4\u0010\"¨\u00068"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "m", "()V", "l", "id", "", "onTextContextMenuItem", "(I)Z", "k", "isClearFocus", "i", "(Z)V", "q", "()Z", "enabled", "setEnableClickEdit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enableEdit", "callback", "h", "(Lkotlin/jvm/functions/Function1;)V", "t", "s", "r", "e", "g", "a", "Lkotlin/jvm/functions/Function1;", "mEditCallback", "b", "Z", "mIsEnableEdit", "c", "mIsCopied", "d", "mIsEnableClickEdit", "getOnFocusChangeListener", "()Lkotlin/jvm/functions/Function1;", "setOnFocusChangeListener", "onFocusChangeListener", "f", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ClipboardEditText extends AppCompatEditText {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Function1 f6126a;
    public boolean b;
    public boolean c;
    public boolean d;
    public Function1 e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClipboardEditText(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void f(ClipboardEditText clipboardEditText, ClipboardManager clipboardManager) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "this$0");
        Intrinsics.checkNotNullParameter(clipboardManager, "$clipboard");
        if (!clipboardEditText.c || !clipboardManager.hasPrimaryClip()) {
            clipboardEditText.c = false;
            return;
        }
        clipboardEditText.c = false;
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("ClipboardEditText", primaryClip.getItemAt(0).getText().toString()));
        }
    }

    public static /* synthetic */ void j(ClipboardEditText clipboardEditText, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        clipboardEditText.i(z);
    }

    private final void l() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
    }

    private final void m() {
        setOnClickListener(new b(this));
        setOnLongClickListener(new c(this));
        setOnFocusChangeListener(new d(this));
        e();
        g();
    }

    public static final void n(ClipboardEditText clipboardEditText, View view) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "this$0");
        if (clipboardEditText.d && !clipboardEditText.b) {
            clipboardEditText.k();
        }
    }

    public static final boolean o(ClipboardEditText clipboardEditText, View view) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "this$0");
        if (!clipboardEditText.d || clipboardEditText.b) {
            return false;
        }
        clipboardEditText.k();
        return false;
    }

    public static final void p(ClipboardEditText clipboardEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ClipboardEditText", "focus changed: " + z);
        if (!z) {
            j(clipboardEditText, false, 1, (Object) null);
        }
        Function1 function1 = clipboardEditText.e;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public final void e() {
        Object systemService = getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        clipboardManager.addPrimaryClipChangedListener(new e(this, clipboardManager));
    }

    public final void g() {
        setCustomSelectionActionModeCallback(new ClipboardEditText$addContextMenuCallback$1());
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnFocusChangeListener() {
        return this.e;
    }

    public final void h(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.f6126a = function1;
    }

    public final void i(boolean z) {
        this.b = false;
        Function1 function1 = this.f6126a;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        setFocusable(false);
        setFocusableInTouchMode(false);
        setCursorVisible(false);
        setGravity(8388659);
        setSingleLine(false);
        setHorizontallyScrolling(false);
        if (z) {
            clearFocus();
        }
        l();
    }

    public final void k() {
        this.b = true;
        Function1 function1 = this.f6126a;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        setCursorVisible(true);
        setInputType(131073);
        setImeOptions(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        setGravity(8388659);
        setSingleLine(false);
        setHorizontallyScrolling(false);
        requestFocus();
        s();
    }

    public boolean onTextContextMenuItem(int i) {
        switch (i) {
            case 16908321:
                RomUtils romUtils = RomUtils.f6192a;
                if (romUtils.h() || romUtils.f() || romUtils.e()) {
                    t();
                } else if (Build.VERSION.SDK_INT <= 32) {
                    t();
                }
                this.c = true;
                break;
            case 16908322:
                r();
                return true;
        }
        return super.onTextContextMenuItem(i);
    }

    public final boolean q() {
        return this.b;
    }

    public final void r() {
        ClipData primaryClip;
        CharSequence text;
        Object systemService = getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (clipboardManager.hasPrimaryClip() && (primaryClip = clipboardManager.getPrimaryClip()) != null && primaryClip.getItemCount() > 0 && (text = primaryClip.getItemAt(0).getText()) != null) {
            Intrinsics.checkNotNull(text);
            int coerceAtLeast = RangesKt.coerceAtLeast(getSelectionStart(), 0);
            int coerceAtLeast2 = RangesKt.coerceAtLeast(getSelectionEnd(), 0);
            Editable text2 = getText();
            if (text2 != null) {
                text2.replace(RangesKt.coerceAtMost(coerceAtLeast, coerceAtLeast2), RangesKt.coerceAtLeast(coerceAtLeast, coerceAtLeast2), text.toString());
            }
        }
    }

    public final void s() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this, 0);
    }

    public final void setEnableClickEdit(boolean z) {
        this.d = z;
    }

    public final void setOnFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.e = function1;
    }

    public final void t() {
        UToast.Companion companion = UToast.f6444a;
        Context applicationContext = getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String string = getContext().getString(R.string.tl_copy_success);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.e(applicationContext, string, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClipboardEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClipboardEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClipboardEditText);
        if (obtainStyledAttributes.getBoolean(R.styleable.ClipboardEditText_clip_et_edit, false)) {
            k();
        } else {
            j(this, false, 1, (Object) null);
        }
        setEnableClickEdit(obtainStyledAttributes.getBoolean(R.styleable.ClipboardEditText_clip_et_click_edit, false));
        obtainStyledAttributes.recycle();
        m();
    }
}
