package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
public class AutoCompleteTextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements AutoCompleteTextView.Validator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IsValid f989a;
        public final /* synthetic */ FixText b;

        public CharSequence fixText(CharSequence charSequence) {
            FixText fixText = this.b;
            return fixText != null ? fixText.fixText(charSequence) : charSequence;
        }

        public boolean isValid(CharSequence charSequence) {
            IsValid isValid = this.f989a;
            if (isValid != null) {
                return isValid.isValid(charSequence);
            }
            return true;
        }
    }

    public interface FixText {
        CharSequence fixText(CharSequence charSequence);
    }

    public interface IsValid {
        boolean isValid(CharSequence charSequence);
    }
}
