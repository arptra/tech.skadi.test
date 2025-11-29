package androidx.databinding;

import android.view.View;
import android.view.ViewStub;

public class ViewStubProxy {

    /* renamed from: a  reason: collision with root package name */
    public ViewStub f984a;
    public ViewDataBinding b;
    public View c;
    public ViewStub.OnInflateListener d;
    public ViewDataBinding e;

    /* renamed from: androidx.databinding.ViewStubProxy$1  reason: invalid class name */
    public class AnonymousClass1 implements ViewStub.OnInflateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewStubProxy f985a;

        public void onInflate(ViewStub viewStub, View view) {
            View unused = this.f985a.c = view;
            ViewStubProxy viewStubProxy = this.f985a;
            ViewDataBinding unused2 = viewStubProxy.b = DataBindingUtil.a(viewStubProxy.e.k, view, viewStub.getLayoutResource());
            ViewStub unused3 = this.f985a.f984a = null;
            if (this.f985a.d != null) {
                this.f985a.d.onInflate(viewStub, view);
                ViewStub.OnInflateListener unused4 = this.f985a.d = null;
            }
            this.f985a.e.t();
            this.f985a.e.p();
        }
    }
}
