package com.chad.library.adapter.base.binder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004J\u001f\u0010\t\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J/\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010!\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u001eJ/\u0010\"\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010 J\u001d\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00070#j\b\u0012\u0004\u0012\u00020\u0007`$¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00070#j\b\u0012\u0004\u0012\u00020\u0007`$¢\u0006\u0004\b'\u0010&R+\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00070#j\b\u0012\u0004\u0012\u00020\u0007`$8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010&R+\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00070#j\b\u0012\u0004\u0012\u00020\u0007`$8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b+\u0010&R$\u00103\u001a\u0004\u0018\u00010-8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b%\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "data", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "", "k", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Z", "m", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "n", "Landroid/view/View;", "view", "position", "i", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)V", "l", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)Z", "g", "h", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "d", "Lkotlin/Lazy;", "e", "clickViewIds", "f", "longClickViewIds", "Landroid/content/Context;", "Landroid/content/Context;", "get_context$com_github_CymChad_brvah", "()Landroid/content/Context;", "o", "(Landroid/content/Context;)V", "_context", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseItemBinder<T, VH extends BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f2778a;
    public final Lazy b;
    public Context c;

    public abstract void a(BaseViewHolder baseViewHolder, Object obj);

    public void b(BaseViewHolder baseViewHolder, Object obj, List list) {
    }

    public final ArrayList c() {
        return e();
    }

    public final ArrayList d() {
        return f();
    }

    public final ArrayList e() {
        return (ArrayList) this.f2778a.getValue();
    }

    public final ArrayList f() {
        return (ArrayList) this.b.getValue();
    }

    public void g(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
    }

    public boolean h(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        return false;
    }

    public void i(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
    }

    public abstract BaseViewHolder j(ViewGroup viewGroup, int i);

    public boolean k(BaseViewHolder baseViewHolder) {
        return false;
    }

    public boolean l(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        return false;
    }

    public void m(BaseViewHolder baseViewHolder) {
    }

    public void n(BaseViewHolder baseViewHolder) {
    }

    public final void o(Context context) {
        this.c = context;
    }
}
