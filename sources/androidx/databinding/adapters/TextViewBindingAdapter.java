package androidx.databinding.adapters;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;

@BindingMethods
@RestrictTo
public class TextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TextViewBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BeforeTextChanged f1004a;
        public final /* synthetic */ OnTextChanged b;
        public final /* synthetic */ InverseBindingListener c;
        public final /* synthetic */ AfterTextChanged d;

        public void afterTextChanged(Editable editable) {
            AfterTextChanged afterTextChanged = this.d;
            if (afterTextChanged != null) {
                afterTextChanged.afterTextChanged(editable);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            BeforeTextChanged beforeTextChanged = this.f1004a;
            if (beforeTextChanged != null) {
                beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            OnTextChanged onTextChanged = this.b;
            if (onTextChanged != null) {
                onTextChanged.onTextChanged(charSequence, i, i2, i3);
            }
            InverseBindingListener inverseBindingListener = this.c;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
        }
    }

    public interface AfterTextChanged {
        void afterTextChanged(Editable editable);
    }

    public interface BeforeTextChanged {
        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public interface OnTextChanged {
        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void b(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence == text) {
            return;
        }
        if (charSequence != null || text.length() != 0) {
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!a(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }
}
