package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ/\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b$\u0010%J/\u0010'\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b)\u0010%J/\u0010*\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b*\u0010(J\u001d\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,¢\u0006\u0004\b/\u0010.R\"\u00106\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00109\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u00108R+\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,8BX\u0002¢\u0006\f\n\u0004\b-\u0010:\u001a\u0004\b;\u0010.R+\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,8BX\u0002¢\u0006\f\n\u0004\b/\u0010:\u001a\u0004\b=\u0010.R\u0014\u0010A\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u00158gX¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@¨\u0006D"}, d2 = {"Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "T", "", "<init>", "()V", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "adapter", "", "r", "(Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "viewHolder", "q", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "holder", "o", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "p", "Landroid/view/View;", "view", "data", "position", "l", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)V", "", "n", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)Z", "j", "k", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "d", "Landroid/content/Context;", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "s", "(Landroid/content/Context;)V", "context", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdapter", "Lkotlin/Lazy;", "e", "clickViewIds", "i", "longClickViewIds", "g", "()I", "itemViewType", "h", "layoutId", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseItemProvider<T> {

    /* renamed from: a  reason: collision with root package name */
    public Context f2803a;
    public WeakReference b;
    public final Lazy c;
    public final Lazy d;

    public BaseItemProvider() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.c = LazyKt.lazy(lazyThreadSafetyMode, BaseItemProvider$clickViewIds$2.INSTANCE);
        this.d = LazyKt.lazy(lazyThreadSafetyMode, BaseItemProvider$longClickViewIds$2.INSTANCE);
    }

    public abstract void a(BaseViewHolder baseViewHolder, Object obj);

    public void b(BaseViewHolder baseViewHolder, Object obj, List list) {
    }

    public final ArrayList c() {
        return e();
    }

    public final ArrayList d() {
        return i();
    }

    public final ArrayList e() {
        return (ArrayList) this.c.getValue();
    }

    public final Context f() {
        Context context = this.f2803a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public abstract int g();

    public abstract int h();

    public final ArrayList i() {
        return (ArrayList) this.d.getValue();
    }

    public void j(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
    }

    public boolean k(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        return false;
    }

    public void l(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
    }

    public BaseViewHolder m(ViewGroup viewGroup, int i) {
        return new BaseViewHolder(AdapterUtilsKt.a(viewGroup, h()));
    }

    public boolean n(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        return false;
    }

    public void o(BaseViewHolder baseViewHolder) {
    }

    public void p(BaseViewHolder baseViewHolder) {
    }

    public void q(BaseViewHolder baseViewHolder, int i) {
    }

    public final void r(BaseProviderMultiAdapter baseProviderMultiAdapter) {
        this.b = new WeakReference(baseProviderMultiAdapter);
    }

    public final void s(Context context) {
        this.f2803a = context;
    }
}
