package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\bH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0003H\u0014¢\u0006\u0004\b)\u0010'J\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b*\u0010#R'\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0+8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "T", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "data", "<init>", "(Ljava/util/List;)V", "", "", "position", "z0", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "provider", "", "v0", "(Lcom/chad/library/adapter/base/provider/BaseItemProvider;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "d0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "J", "(I)I", "holder", "item", "A", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "B", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "viewHolder", "x", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "y0", "(I)Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "g0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "B0", "x0", "w0", "Landroid/util/SparseArray;", "C", "Lkotlin/Lazy;", "A0", "()Landroid/util/SparseArray;", "mItemProviders", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    public final Lazy C = LazyKt.lazy(LazyThreadSafetyMode.NONE, BaseProviderMultiAdapter$mItemProviders$2.INSTANCE);

    public BaseProviderMultiAdapter(List list) {
        super(0, list);
    }

    public void A(BaseViewHolder baseViewHolder, Object obj) {
        BaseItemProvider y0 = y0(baseViewHolder.getItemViewType());
        if (y0 == null) {
            Intrinsics.throwNpe();
        }
        y0.a(baseViewHolder, obj);
    }

    public final SparseArray A0() {
        return (SparseArray) this.C.getValue();
    }

    public void B(BaseViewHolder baseViewHolder, Object obj, List list) {
        BaseItemProvider y0 = y0(baseViewHolder.getItemViewType());
        if (y0 == null) {
            Intrinsics.throwNpe();
        }
        y0.b(baseViewHolder, obj, list);
    }

    /* renamed from: B0 */
    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        BaseItemProvider y0 = y0(baseViewHolder.getItemViewType());
        if (y0 != null) {
            y0.p(baseViewHolder);
        }
    }

    public int J(int i) {
        return z0(getData(), i);
    }

    public BaseViewHolder d0(ViewGroup viewGroup, int i) {
        BaseItemProvider y0 = y0(i);
        if (y0 != null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "parent.context");
            y0.s(context);
            BaseViewHolder m = y0.m(viewGroup, i);
            y0.q(m, i);
            return m;
        }
        throw new IllegalStateException(("ViewType: " + i + " no such provider found，please use addItemProvider() first!").toString());
    }

    /* renamed from: g0 */
    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        BaseItemProvider y0 = y0(baseViewHolder.getItemViewType());
        if (y0 != null) {
            y0.o(baseViewHolder);
        }
    }

    public void v0(BaseItemProvider baseItemProvider) {
        baseItemProvider.r(this);
        A0().put(baseItemProvider.g(), baseItemProvider);
    }

    public void w0(BaseViewHolder baseViewHolder, int i) {
        BaseItemProvider y0;
        if (T() == null) {
            BaseItemProvider y02 = y0(i);
            if (y02 != null) {
                for (Number intValue : y02.c()) {
                    View findViewById = baseViewHolder.itemView.findViewById(intValue.intValue());
                    if (findViewById != null) {
                        if (!findViewById.isClickable()) {
                            findViewById.setClickable(true);
                        }
                        findViewById.setOnClickListener(new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1(this, baseViewHolder, y02));
                    }
                }
            } else {
                return;
            }
        }
        if (U() == null && (y0 = y0(i)) != null) {
            for (Number intValue2 : y0.d()) {
                View findViewById2 = baseViewHolder.itemView.findViewById(intValue2.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$2(this, baseViewHolder, y0));
                }
            }
        }
    }

    public void x(BaseViewHolder baseViewHolder, int i) {
        super.x(baseViewHolder, i);
        x0(baseViewHolder);
        w0(baseViewHolder, i);
    }

    public void x0(BaseViewHolder baseViewHolder) {
        if (V() == null) {
            baseViewHolder.itemView.setOnClickListener(new BaseProviderMultiAdapter$bindClick$1(this, baseViewHolder));
        }
        if (W() == null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseProviderMultiAdapter$bindClick$2(this, baseViewHolder));
        }
    }

    public BaseItemProvider y0(int i) {
        return (BaseItemProvider) A0().get(i);
    }

    public abstract int z0(List list, int i);
}
