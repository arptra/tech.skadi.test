package com.honey.account.utils.system;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.honey.account.i2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"closeInputMethod", "", "context", "Landroid/content/Context;", "editTexts", "", "Landroid/widget/EditText;", "(Landroid/content/Context;[Landroid/widget/EditText;)Z", "showInputMethod", "", "editText", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class InputMethodUtilsKt {
    public static final boolean closeInputMethod(@NotNull Context context, @NotNull EditText... editTextArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editTextArr, "editTexts");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager.isActive()) {
            for (EditText editText : editTextArr) {
                if (editText.hasFocus()) {
                    return inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
                }
            }
        }
        return false;
    }

    public static final void showInputMethod(@NotNull Context context, @NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.requestFocus();
        editText.post(new a(editText, context));
    }

    /* access modifiers changed from: private */
    public static final void showInputMethod$lambda$0(EditText editText, Context context) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Intrinsics.checkNotNullParameter(context, "$context");
        editText.requestFocus();
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }
}
