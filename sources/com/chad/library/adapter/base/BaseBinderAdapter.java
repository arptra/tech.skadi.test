package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u00020\u00062\n\u0010$\u001a\u0006\u0012\u0002\b\u00030#H\u0004¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b'\u0010\u001eJ\u001f\u0010(\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b(\u0010\u001cRH\u0010.\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*0)j\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R8\u00100\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020\u00060)j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020\u0006`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010-R$\u00104\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0013018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "d0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "A", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "B", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "y0", "(I)Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "z0", "position", "J", "(I)I", "viewHolder", "x", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "g0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "B0", "", "A0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Z", "Ljava/lang/Class;", "clazz", "x0", "(Ljava/lang/Class;)I", "w0", "v0", "Ljava/util/HashMap;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlin/collections/HashMap;", "C", "Ljava/util/HashMap;", "classDiffMap", "D", "mTypeMap", "Landroid/util/SparseArray;", "E", "Landroid/util/SparseArray;", "mBinderArray", "ItemCallback", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseBinderAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public final HashMap C;
    public final HashMap D;
    public final SparseArray E;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\b\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "oldItem", "newItem", "", "areItemsTheSame", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "areContentsTheSame", "getChangePayload", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public final class ItemCallback extends DiffUtil.ItemCallback<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseBinderAdapter f2763a;

        public boolean areContentsTheSame(Object obj, Object obj2) {
            DiffUtil.ItemCallback itemCallback;
            if (!Intrinsics.areEqual((Object) obj.getClass(), (Object) obj2.getClass()) || (itemCallback = (DiffUtil.ItemCallback) this.f2763a.C.get(obj.getClass())) == null) {
                return true;
            }
            return itemCallback.areContentsTheSame(obj, obj2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
            r2 = (androidx.recyclerview.widget.DiffUtil.ItemCallback) com.chad.library.adapter.base.BaseBinderAdapter.u0(r2.f2763a).get(r3.getClass());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean areItemsTheSame(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                java.lang.Class r0 = r3.getClass()
                java.lang.Class r1 = r4.getClass()
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 == 0) goto L_0x0025
                com.chad.library.adapter.base.BaseBinderAdapter r2 = r2.f2763a
                java.util.HashMap r2 = r2.C
                java.lang.Class r0 = r3.getClass()
                java.lang.Object r2 = r2.get(r0)
                androidx.recyclerview.widget.DiffUtil$ItemCallback r2 = (androidx.recyclerview.widget.DiffUtil.ItemCallback) r2
                if (r2 == 0) goto L_0x0025
                boolean r2 = r2.areItemsTheSame(r3, r4)
                return r2
            L_0x0025:
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.BaseBinderAdapter.ItemCallback.areItemsTheSame(java.lang.Object, java.lang.Object):boolean");
        }

        public Object getChangePayload(Object obj, Object obj2) {
            DiffUtil.ItemCallback itemCallback;
            if (!Intrinsics.areEqual((Object) obj.getClass(), (Object) obj2.getClass()) || (itemCallback = (DiffUtil.ItemCallback) this.f2763a.C.get(obj.getClass())) == null) {
                return null;
            }
            return itemCallback.getChangePayload(obj, obj2);
        }
    }

    public void A(BaseViewHolder baseViewHolder, Object obj) {
        y0(baseViewHolder.getItemViewType()).a(baseViewHolder, obj);
    }

    /* renamed from: A0 */
    public boolean onFailedToRecycleView(BaseViewHolder baseViewHolder) {
        BaseItemBinder z0 = z0(baseViewHolder.getItemViewType());
        if (z0 != null) {
            return z0.k(baseViewHolder);
        }
        return false;
    }

    public void B(BaseViewHolder baseViewHolder, Object obj, List list) {
        y0(baseViewHolder.getItemViewType()).b(baseViewHolder, obj, list);
    }

    /* renamed from: B0 */
    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        BaseItemBinder z0 = z0(baseViewHolder.getItemViewType());
        if (z0 != null) {
            z0.n(baseViewHolder);
        }
    }

    public int J(int i) {
        return x0(getData().get(i).getClass());
    }

    public BaseViewHolder d0(ViewGroup viewGroup, int i) {
        BaseItemBinder y0 = y0(i);
        y0.o(H());
        return y0.j(viewGroup, i);
    }

    /* renamed from: g0 */
    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        BaseItemBinder z0 = z0(baseViewHolder.getItemViewType());
        if (z0 != null) {
            z0.m(baseViewHolder);
        }
    }

    public void v0(BaseViewHolder baseViewHolder, int i) {
        if (T() == null) {
            BaseItemBinder y0 = y0(i);
            for (Number intValue : y0.c()) {
                View findViewById = baseViewHolder.itemView.findViewById(intValue.intValue());
                if (findViewById != null) {
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1(this, baseViewHolder, y0));
                }
            }
        }
        if (U() == null) {
            BaseItemBinder y02 = y0(i);
            for (Number intValue2 : y02.d()) {
                View findViewById2 = baseViewHolder.itemView.findViewById(intValue2.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$2(this, baseViewHolder, y02));
                }
            }
        }
    }

    public void w0(BaseViewHolder baseViewHolder) {
        if (V() == null) {
            baseViewHolder.itemView.setOnClickListener(new BaseBinderAdapter$bindClick$1(this, baseViewHolder));
        }
        if (W() == null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseBinderAdapter$bindClick$2(this, baseViewHolder));
        }
    }

    public void x(BaseViewHolder baseViewHolder, int i) {
        super.x(baseViewHolder, i);
        w0(baseViewHolder);
        v0(baseViewHolder, i);
    }

    public final int x0(Class cls) {
        Integer num = (Integer) this.D.get(cls);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(("findViewType: ViewType: " + cls + " Not Find!").toString());
    }

    public BaseItemBinder y0(int i) {
        BaseItemBinder baseItemBinder = (BaseItemBinder) this.E.get(i);
        if (baseItemBinder != null) {
            return baseItemBinder;
        }
        throw new IllegalStateException(("getItemBinder: viewType '" + i + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    public BaseItemBinder z0(int i) {
        BaseItemBinder baseItemBinder = (BaseItemBinder) this.E.get(i);
        if (!(baseItemBinder instanceof BaseItemBinder)) {
            return null;
        }
        return baseItemBinder;
    }
}
