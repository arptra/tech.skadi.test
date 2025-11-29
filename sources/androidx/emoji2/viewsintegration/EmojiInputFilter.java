package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi
@RestrictTo
final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f1239a;
    public EmojiCompat.InitCallback b;

    @RequiresApi
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Reference f1240a;
        public final Reference b;

        public InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f1240a = new WeakReference(textView);
            this.b = new WeakReference(emojiInputFilter);
        }

        public void b() {
            CharSequence text;
            CharSequence o;
            super.b();
            TextView textView = (TextView) this.f1240a.get();
            if (c(textView, (InputFilter) this.b.get()) && textView.isAttachedToWindow() && (text = textView.getText()) != (o = EmojiCompat.b().o(text))) {
                int selectionStart = Selection.getSelectionStart(o);
                int selectionEnd = Selection.getSelectionEnd(o);
                textView.setText(o);
                if (o instanceof Spannable) {
                    EmojiInputFilter.b((Spannable) o, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public EmojiInputFilter(TextView textView) {
        this.f1239a = textView;
    }

    public static void b(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }

    public final EmojiCompat.InitCallback a() {
        if (this.b == null) {
            this.b = new InitCallbackImpl(this.f1239a, this);
        }
        return this.b;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f1239a.isInEditMode()) {
            return charSequence;
        }
        int d = EmojiCompat.b().d();
        if (d != 0) {
            if (d != 1) {
                if (d != 3) {
                    return charSequence;
                }
            } else if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.f1239a.getText()) || charSequence == null) {
                return charSequence;
            } else {
                if (!(i == 0 && i2 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return EmojiCompat.b().p(charSequence, 0, charSequence.length());
            }
        }
        EmojiCompat.b().s(a());
        return charSequence;
    }
}
