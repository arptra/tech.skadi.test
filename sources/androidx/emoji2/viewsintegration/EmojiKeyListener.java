package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi
@RestrictTo
final class EmojiKeyListener implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final KeyListener f1241a;
    public final EmojiCompatHandleKeyDownHelper b;

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean a(Editable editable, int i, KeyEvent keyEvent) {
            return EmojiCompat.f(editable, i, keyEvent);
        }
    }

    public EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    public void clearMetaKeyState(View view, Editable editable, int i) {
        this.f1241a.clearMetaKeyState(view, editable, i);
    }

    public int getInputType() {
        return this.f1241a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.b.a(editable, i, keyEvent) || this.f1241a.onKeyDown(view, editable, i, keyEvent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f1241a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f1241a.onKeyUp(view, editable, i, keyEvent);
    }

    public EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f1241a = keyListener;
        this.b = emojiCompatHandleKeyDownHelper;
    }
}
