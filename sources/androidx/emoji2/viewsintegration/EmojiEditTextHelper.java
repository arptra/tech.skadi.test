package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    public final HelperInternal f1235a;
    public int b = Integer.MAX_VALUE;
    public int c = 0;

    public static class HelperInternal {
        public KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        public boolean b() {
            return false;
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        public void d(boolean z) {
        }
    }

    @RequiresApi
    public static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        public final EditText f1236a;
        public final EmojiTextWatcher b;

        public HelperInternal19(EditText editText, boolean z) {
            this.f1236a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
            this.b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        public boolean b() {
            return this.b.b();
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.f1236a, inputConnection, editorInfo);
        }

        public void d(boolean z) {
            this.b.d(z);
        }
    }

    public EmojiEditTextHelper(EditText editText, boolean z) {
        Preconditions.i(editText, "editText cannot be null");
        this.f1235a = new HelperInternal19(editText, z);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f1235a.a(keyListener);
    }

    public boolean b() {
        return this.f1235a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f1235a.c(inputConnection, editorInfo);
    }

    public void d(boolean z) {
        this.f1235a.d(z);
    }
}
