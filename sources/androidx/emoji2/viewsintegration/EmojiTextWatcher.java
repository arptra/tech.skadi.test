package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi
@RestrictTo
final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f1245a;
    public final boolean b;
    public EmojiCompat.InitCallback c;
    public int d = Integer.MAX_VALUE;
    public int e = 0;
    public boolean f;

    @RequiresApi
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Reference f1246a;

        public InitCallbackImpl(EditText editText) {
            this.f1246a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            EmojiTextWatcher.c((EditText) this.f1246a.get(), 1);
        }
    }

    public EmojiTextWatcher(EditText editText, boolean z) {
        this.f1245a = editText;
        this.b = z;
        this.f = true;
    }

    public static void c(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.b().o(editableText);
            EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final EmojiCompat.InitCallback a() {
        if (this.c == null) {
            this.c = new InitCallbackImpl(this.f1245a);
        }
        return this.c;
    }

    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void d(boolean z) {
        if (this.f != z) {
            if (this.c != null) {
                EmojiCompat.b().t(this.c);
            }
            this.f = z;
            if (z) {
                c(this.f1245a, EmojiCompat.b().d());
            }
        }
    }

    public final boolean e() {
        return !this.f || (!this.b && !EmojiCompat.h());
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f1245a.isInEditMode() && !e() && i2 <= i3 && (charSequence instanceof Spannable)) {
            int d2 = EmojiCompat.b().d();
            if (d2 != 0) {
                if (d2 == 1) {
                    EmojiCompat.b().r((Spannable) charSequence, i, i + i3, this.d, this.e);
                    return;
                } else if (d2 != 3) {
                    return;
                }
            }
            EmojiCompat.b().s(a());
        }
    }
}
