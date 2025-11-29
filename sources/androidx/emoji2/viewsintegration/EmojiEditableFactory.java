package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1237a = new Object();
    public static volatile Editable.Factory b;
    public static Class c;

    public EmojiEditableFactory() {
        try {
            c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (b == null) {
            synchronized (f1237a) {
                try {
                    if (b == null) {
                        b = new EmojiEditableFactory();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? SpannableBuilder.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
