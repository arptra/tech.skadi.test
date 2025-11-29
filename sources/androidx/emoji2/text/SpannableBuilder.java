package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo
public final class SpannableBuilder extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Class f1213a;
    public final List b = new ArrayList();

    public static class WatcherWrapper implements TextWatcher, SpanWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1214a;
        public final AtomicInteger b = new AtomicInteger(0);

        public WatcherWrapper(Object obj) {
            this.f1214a = obj;
        }

        public final void a() {
            this.b.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f1214a).afterTextChanged(editable);
        }

        public final boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f1214a).beforeTextChanged(charSequence, i, i2, i3);
        }

        public final void c() {
            this.b.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1214a).onSpanAdded(spannable, obj, i, i2);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (this.b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1214a).onSpanChanged(spannable, obj, i, i2, i3, i4);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1214a).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f1214a).onTextChanged(charSequence, i, i2, i3);
        }
    }

    public SpannableBuilder(Class cls, CharSequence charSequence) {
        super(charSequence);
        Preconditions.i(cls, "watcherClass cannot be null");
        this.f1213a = cls;
    }

    public static SpannableBuilder c(Class cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    public void a() {
        b();
    }

    public final void b() {
        for (int i = 0; i < this.b.size(); i++) {
            ((WatcherWrapper) this.b.get(i)).a();
        }
    }

    public void d() {
        i();
        e();
    }

    public final void e() {
        for (int i = 0; i < this.b.size(); i++) {
            ((WatcherWrapper) this.b.get(i)).onTextChanged(this, 0, length(), length());
        }
    }

    public final WatcherWrapper f(Object obj) {
        for (int i = 0; i < this.b.size(); i++) {
            WatcherWrapper watcherWrapper = (WatcherWrapper) this.b.get(i);
            if (watcherWrapper.f1214a == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    public final boolean g(Class cls) {
        return this.f1213a == cls;
    }

    public int getSpanEnd(Object obj) {
        WatcherWrapper f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        WatcherWrapper f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        WatcherWrapper f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanStart(obj);
    }

    public Object[] getSpans(int i, int i2, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i, i2, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i, i2, WatcherWrapper.class);
        Object[] objArr = (Object[]) Array.newInstance(cls, watcherWrapperArr.length);
        for (int i3 = 0; i3 < watcherWrapperArr.length; i3++) {
            objArr[i3] = watcherWrapperArr[i3].f1214a;
        }
        return objArr;
    }

    public final boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    public final void i() {
        for (int i = 0; i < this.b.size(); i++) {
            ((WatcherWrapper) this.b.get(i)).c();
        }
    }

    public int nextSpanTransition(int i, int i2, Class<WatcherWrapper> cls) {
        if (cls == null || g(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (h(obj)) {
            watcherWrapper = f(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.b.remove(watcherWrapper);
        }
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (h(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.b.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i, i2, i3);
    }

    public CharSequence subSequence(int i, int i2) {
        return new SpannableBuilder(this.f1213a, this, i, i2);
    }

    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        b();
        super.replace(i, i2, charSequence);
        i();
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    public SpannableBuilder(Class cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        Preconditions.i(cls, "watcherClass cannot be null");
        this.f1213a = cls;
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        b();
        super.replace(i, i2, charSequence, i3, i4);
        i();
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
