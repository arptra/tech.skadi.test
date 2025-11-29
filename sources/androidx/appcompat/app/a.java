package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class a implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f197a;

    public /* synthetic */ a(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f197a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f197a.C0();
    }
}
