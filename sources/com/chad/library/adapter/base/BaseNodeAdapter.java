package com.chad.library.adapter.base;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0019j\b\u0012\u0004\u0012\u00020\u0003`\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "", "position", "F0", "(I)I", "E0", "", "list", "", "isExpanded", "", "C0", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "type", "a0", "(I)Z", "", "i0", "(I)V", "index", "data", "G0", "(ILcom/chad/library/adapter/base/entity/node/BaseNode;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "D", "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseNodeAdapter extends BaseProviderMultiAdapter<BaseNode> {
    public final HashSet D;

    public static /* synthetic */ List D0(BaseNodeAdapter baseNodeAdapter, Collection collection, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return baseNodeAdapter.C0(collection, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    public final List C0(Collection collection, Boolean bool) {
        BaseNode a2;
        List a3;
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            BaseNode baseNode = (BaseNode) it.next();
            arrayList.add(baseNode);
            if (baseNode instanceof BaseExpandNode) {
                if ((Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE) || ((BaseExpandNode) baseNode).b()) && (a3 = baseNode.a()) != null && !a3.isEmpty()) {
                    arrayList.addAll(C0(a3, bool));
                }
                if (bool != null) {
                    ((BaseExpandNode) baseNode).c(bool.booleanValue());
                }
            } else {
                List a4 = baseNode.a();
                if (a4 != null && !a4.isEmpty()) {
                    arrayList.addAll(C0(a4, bool));
                }
            }
            if ((baseNode instanceof NodeFooterImp) && (a2 = ((NodeFooterImp) baseNode).a()) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r5 = (com.chad.library.adapter.base.entity.node.BaseNode) getData().get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int E0(int r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.getData()
            int r0 = r0.size()
            r1 = 0
            if (r5 < r0) goto L_0x000c
            return r1
        L_0x000c:
            java.util.List r0 = r4.getData()
            java.lang.Object r5 = r0.get(r5)
            com.chad.library.adapter.base.entity.node.BaseNode r5 = (com.chad.library.adapter.base.entity.node.BaseNode) r5
            java.util.List r0 = r5.a()
            if (r0 == 0) goto L_0x0063
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0023
            goto L_0x0063
        L_0x0023:
            boolean r0 = r5 instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode
            r2 = 2
            r3 = 0
            if (r0 == 0) goto L_0x004b
            r0 = r5
            com.chad.library.adapter.base.entity.node.BaseExpandNode r0 = (com.chad.library.adapter.base.entity.node.BaseExpandNode) r0
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0063
            java.util.List r5 = r5.a()
            if (r5 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x003b:
            java.util.List r5 = D0(r4, r5, r3, r2, r3)
            java.util.List r4 = r4.getData()
            r4.removeAll(r5)
            int r1 = r5.size()
            goto L_0x0063
        L_0x004b:
            java.util.List r5 = r5.a()
            if (r5 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0054:
            java.util.List r5 = D0(r4, r5, r3, r2, r3)
            java.util.List r4 = r4.getData()
            r4.removeAll(r5)
            int r1 = r5.size()
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.BaseNodeAdapter.E0(int):int");
    }

    public final int F0(int i) {
        if (i >= getData().size()) {
            return 0;
        }
        int E0 = E0(i);
        getData().remove(i);
        int i2 = E0 + 1;
        BaseNode baseNode = (BaseNode) getData().get(i);
        if (!(baseNode instanceof NodeFooterImp) || ((NodeFooterImp) baseNode).a() == null) {
            return i2;
        }
        getData().remove(i);
        return E0 + 2;
    }

    /* renamed from: G0 */
    public void j0(int i, BaseNode baseNode) {
        int F0 = F0(i);
        List D0 = D0(this, CollectionsKt.arrayListOf(baseNode), (Boolean) null, 2, (Object) null);
        getData().addAll(i, D0);
        if (F0 == D0.size()) {
            notifyItemRangeChanged(i + M(), F0);
            return;
        }
        notifyItemRangeRemoved(M() + i, F0);
        notifyItemRangeInserted(i + M(), D0.size());
    }

    public boolean a0(int i) {
        return super.a0(i) || this.D.contains(Integer.valueOf(i));
    }

    public void i0(int i) {
        notifyItemRangeRemoved(i + M(), F0(i));
        z(0);
    }
}
