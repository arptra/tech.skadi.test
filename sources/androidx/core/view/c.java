package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f937a;

    public /* synthetic */ c(View view) {
        this.f937a = view;
    }

    public final void run() {
        ((InputMethodManager) this.f937a.getContext().getSystemService("input_method")).showSoftInput(this.f937a, 0);
    }
}
