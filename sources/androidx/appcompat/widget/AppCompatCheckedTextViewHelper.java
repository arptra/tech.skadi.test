package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

@RestrictTo
class AppCompatCheckedTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    public final CheckedTextView f280a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.f280a = checkedTextView;
    }

    public void a() {
        Drawable a2 = CheckedTextViewCompat.a(this.f280a);
        if (a2 == null) {
            return;
        }
        if (this.d || this.e) {
            Drawable mutate = DrawableCompat.r(a2).mutate();
            if (this.d) {
                DrawableCompat.o(mutate, this.b);
            }
            if (this.e) {
                DrawableCompat.p(mutate, this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f280a.getDrawableState());
            }
            this.f280a.setCheckMarkDrawable(mutate);
        }
    }

    public ColorStateList b() {
        return this.b;
    }

    public PorterDuff.Mode c() {
        return this.c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(2:6|7)|9|10|(1:14)|15|(1:17)|18|(1:20)|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CheckedTextView r0 = r10.f280a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CheckedTextView
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r0, r11, r1, r12, r2)
            android.widget.CheckedTextView r3 = r10.f280a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CheckedTextView
            android.content.res.TypedArray r7 = r0.r()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.s0(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x003d }
            boolean r11 = r0.s(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x003d }
            int r11 = r0.n(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            android.widget.CheckedTextView r12 = r10.f280a     // Catch:{ NotFoundException -> 0x003f }
            android.content.Context r1 = r12.getContext()     // Catch:{ NotFoundException -> 0x003f }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r1, r11)     // Catch:{ NotFoundException -> 0x003f }
            r12.setCheckMarkDrawable(r11)     // Catch:{ NotFoundException -> 0x003f }
            goto L_0x005c
        L_0x003d:
            r10 = move-exception
            goto L_0x008c
        L_0x003f:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch:{ all -> 0x003d }
            boolean r11 = r0.s(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch:{ all -> 0x003d }
            int r11 = r0.n(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            android.widget.CheckedTextView r12 = r10.f280a     // Catch:{ all -> 0x003d }
            android.content.Context r1 = r12.getContext()     // Catch:{ all -> 0x003d }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r1, r11)     // Catch:{ all -> 0x003d }
            r12.setCheckMarkDrawable(r11)     // Catch:{ all -> 0x003d }
        L_0x005c:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x003d }
            boolean r11 = r0.s(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x006f
            android.widget.CheckedTextView r11 = r10.f280a     // Catch:{ all -> 0x003d }
            int r12 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x003d }
            android.content.res.ColorStateList r12 = r0.c(r12)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CheckedTextViewCompat.b(r11, r12)     // Catch:{ all -> 0x003d }
        L_0x006f:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x003d }
            boolean r11 = r0.s(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x0088
            android.widget.CheckedTextView r10 = r10.f280a     // Catch:{ all -> 0x003d }
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x003d }
            r12 = -1
            int r11 = r0.k(r11, r12)     // Catch:{ all -> 0x003d }
            r12 = 0
            android.graphics.PorterDuff$Mode r11 = androidx.appcompat.widget.DrawableUtils.e(r11, r12)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CheckedTextViewCompat.c(r10, r11)     // Catch:{ all -> 0x003d }
        L_0x0088:
            r0.w()
            return
        L_0x008c:
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextViewHelper.d(android.util.AttributeSet, int):void");
    }

    public void e() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        a();
    }

    public void f(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
