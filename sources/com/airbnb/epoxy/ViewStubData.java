package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/airbnb/epoxy/ViewStubData;", "", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/ViewStub;", "viewStub", "", "position", "<init>", "(Landroid/view/ViewGroup;Landroid/view/ViewStub;I)V", "Landroid/view/View;", "view", "", "useStubLayoutParams", "", "d", "(Landroid/view/View;Z)V", "c", "()V", "b", "a", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "Landroid/view/ViewStub;", "getViewStub", "()Landroid/view/ViewStub;", "I", "getPosition", "()I", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
final class ViewStubData {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f2318a;
    public final ViewStub b;
    public final int c;

    public ViewStubData(ViewGroup viewGroup, ViewStub viewStub, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.f2318a = viewGroup;
        this.b = viewStub;
        this.c = i;
    }

    public final ViewGroup a() {
        return this.f2318a;
    }

    public final void b() {
        View childAt = this.f2318a.getChildAt(this.c);
        if (childAt != null) {
            this.f2318a.removeView(childAt);
            return;
        }
        throw new IllegalStateException("No view exists at position " + this.c);
    }

    public final void c() {
        b();
        this.f2318a.addView(this.b, this.c);
    }

    public final void d(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        b();
        int inflatedId = this.b.getInflatedId();
        if (inflatedId != -1) {
            view.setId(inflatedId);
        }
        if (z) {
            this.f2318a.addView(view, this.c, this.b.getLayoutParams());
        } else {
            this.f2318a.addView(view, this.c);
        }
    }
}
