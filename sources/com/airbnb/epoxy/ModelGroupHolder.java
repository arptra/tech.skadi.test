package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.viewmodeladapter.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 )2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u00020\u00112\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!2\f\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0002¢\u0006\u0004\b$\u0010%J#\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\b\u00030!H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010/R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020(0\u001d8\u0006¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b1\u00102R \u00109\u001a\u0002048\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u00105\u0012\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R$\u0010>\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00148\u0006@BX.¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010;R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010A¨\u0006D"}, d2 = {"Lcom/airbnb/epoxy/ModelGroupHolder;", "Lcom/airbnb/epoxy/EpoxyHolder;", "Landroid/view/ViewParent;", "modelGroupParent", "<init>", "(Landroid/view/ViewParent;)V", "Landroid/view/View;", "itemView", "", "a", "(Landroid/view/View;)V", "Lcom/airbnb/epoxy/EpoxyModelGroup;", "group", "c", "(Lcom/airbnb/epoxy/EpoxyModelGroup;)V", "k", "()V", "", "l", "()Z", "Landroid/view/ViewGroup;", "outermostRoot", "f", "(Landroid/view/ViewGroup;)Landroid/view/ViewGroup;", "viewGroup", "", "Lcom/airbnb/epoxy/ViewStubData;", "e", "(Landroid/view/ViewGroup;)Ljava/util/List;", "Ljava/util/ArrayList;", "stubs", "d", "(Landroid/view/ViewGroup;Ljava/util/ArrayList;)V", "Lcom/airbnb/epoxy/EpoxyModel;", "model1", "model2", "b", "(Lcom/airbnb/epoxy/EpoxyModel;Lcom/airbnb/epoxy/EpoxyModel;)Z", "parent", "model", "Lcom/airbnb/epoxy/EpoxyViewHolder;", "h", "(Landroid/view/ViewGroup;Lcom/airbnb/epoxy/EpoxyModel;)Lcom/airbnb/epoxy/EpoxyViewHolder;", "", "modelPosition", "j", "(I)V", "Landroid/view/ViewParent;", "Ljava/util/ArrayList;", "i", "()Ljava/util/ArrayList;", "viewHolders", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getViewPool$annotations", "viewPool", "<set-?>", "Landroid/view/ViewGroup;", "g", "()Landroid/view/ViewGroup;", "rootView", "childContainer", "Ljava/util/List;", "Lcom/airbnb/epoxy/EpoxyModelGroup;", "boundGroup", "Companion", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class ModelGroupHolder extends EpoxyHolder {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static final HelperAdapter i = new HelperAdapter();

    /* renamed from: a  reason: collision with root package name */
    public final ViewParent f2307a;
    public final ArrayList b = new ArrayList(4);
    public final RecyclerView.RecycledViewPool c;
    public ViewGroup d;
    public ViewGroup e;
    public List f;
    public EpoxyModelGroup g;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/airbnb/epoxy/ModelGroupHolder$Companion;", "", "<init>", "()V", "Landroid/view/ViewParent;", "view", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "(Landroid/view/ViewParent;)Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/airbnb/epoxy/HelperAdapter;", "HELPER_ADAPTER", "Lcom/airbnb/epoxy/HelperAdapter;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecyclerView.RecycledViewPool b(ViewParent viewParent) {
            RecyclerView.RecycledViewPool recycledViewPool = null;
            while (recycledViewPool == null) {
                if (viewParent instanceof RecyclerView) {
                    recycledViewPool = ((RecyclerView) viewParent).getRecycledViewPool();
                } else {
                    ViewParent parent = viewParent.getParent();
                    recycledViewPool = parent != null ? b(parent) : new LocalGroupRecycledViewPool();
                }
            }
            return recycledViewPool;
        }

        public Companion() {
        }
    }

    public ModelGroupHolder(ViewParent viewParent) {
        Intrinsics.checkNotNullParameter(viewParent, "modelGroupParent");
        this.f2307a = viewParent;
        this.c = h.b(viewParent);
    }

    public void a(View view) {
        List list;
        Intrinsics.checkNotNullParameter(view, "itemView");
        if (view instanceof ViewGroup) {
            this.d = (ViewGroup) view;
            ViewGroup f2 = f(g());
            this.e = f2;
            ViewGroup viewGroup = null;
            if (f2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childContainer");
                f2 = null;
            }
            if (f2.getChildCount() != 0) {
                ViewGroup viewGroup2 = this.e;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("childContainer");
                } else {
                    viewGroup = viewGroup2;
                }
                list = e(viewGroup);
            } else {
                list = CollectionsKt.emptyList();
            }
            this.f = list;
            return;
        }
        throw new IllegalStateException("The layout provided to EpoxyModelGroup must be a ViewGroup");
    }

    public final boolean b(EpoxyModel epoxyModel, EpoxyModel epoxyModel2) {
        return ViewTypeManager.b(epoxyModel) == ViewTypeManager.b(epoxyModel2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0092, code lost:
        r7 = r0.l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.airbnb.epoxy.EpoxyModelGroup r12) {
        /*
            r11 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.airbnb.epoxy.EpoxyModelGroup r0 = r11.g
            if (r0 != r12) goto L_0x000a
            return
        L_0x000a:
            if (r0 == 0) goto L_0x0032
            java.util.List r1 = r0.l
            int r1 = r1.size()
            java.util.List r2 = r12.l
            int r2 = r2.size()
            if (r1 <= r2) goto L_0x0032
            java.util.List r1 = r0.l
            int r1 = r1.size()
            int r1 = r1 + -1
            java.util.List r2 = r12.l
            int r2 = r2.size()
            if (r2 > r1) goto L_0x0032
        L_0x002a:
            r11.j(r1)
            if (r1 == r2) goto L_0x0032
            int r1 = r1 + -1
            goto L_0x002a
        L_0x0032:
            r11.g = r12
            java.util.List r1 = r12.l
            int r2 = r1.size()
            boolean r3 = r11.l()
            java.lang.String r4 = "stubs"
            r5 = 0
            if (r3 == 0) goto L_0x0082
            java.util.List r3 = r11.f
            if (r3 != 0) goto L_0x004b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r5
        L_0x004b:
            int r3 = r3.size()
            if (r3 >= r2) goto L_0x0082
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Insufficient view stubs for EpoxyModelGroup. "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " models were provided but only "
            r0.append(r1)
            java.util.List r11 = r11.f
            if (r11 != 0) goto L_0x006d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x006e
        L_0x006d:
            r5 = r11
        L_0x006e:
            int r11 = r5.size()
            r0.append(r11)
            java.lang.String r11 = " view stubs exist."
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.<init>(r11)
            throw r12
        L_0x0082:
            java.util.ArrayList r3 = r11.b
            r3.ensureCapacity(r2)
            r3 = 0
        L_0x0088:
            if (r3 >= r2) goto L_0x00f9
            java.lang.Object r6 = r1.get(r3)
            com.airbnb.epoxy.EpoxyModel r6 = (com.airbnb.epoxy.EpoxyModel) r6
            if (r0 == 0) goto L_0x009d
            java.util.List r7 = r0.l
            if (r7 == 0) goto L_0x009d
            java.lang.Object r7 = kotlin.collections.CollectionsKt.getOrNull(r7, r3)
            com.airbnb.epoxy.EpoxyModel r7 = (com.airbnb.epoxy.EpoxyModel) r7
            goto L_0x009e
        L_0x009d:
            r7 = r5
        L_0x009e:
            java.util.List r8 = r11.f
            if (r8 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r5
        L_0x00a6:
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r8, r3)
            com.airbnb.epoxy.ViewStubData r8 = (com.airbnb.epoxy.ViewStubData) r8
            java.lang.String r9 = "childContainer"
            if (r8 == 0) goto L_0x00b6
            android.view.ViewGroup r10 = r8.a()
            if (r10 != 0) goto L_0x00be
        L_0x00b6:
            android.view.ViewGroup r10 = r11.e
            if (r10 != 0) goto L_0x00be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r10 = r5
        L_0x00be:
            if (r7 == 0) goto L_0x00ca
            boolean r7 = r11.b(r7, r6)
            if (r7 == 0) goto L_0x00c7
            goto L_0x00f6
        L_0x00c7:
            r11.j(r3)
        L_0x00ca:
            java.lang.String r7 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.airbnb.epoxy.EpoxyViewHolder r7 = r11.h(r10, r6)
            if (r8 != 0) goto L_0x00e3
            android.view.ViewGroup r6 = r11.e
            if (r6 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r6 = r5
        L_0x00dd:
            android.view.View r8 = r7.itemView
            r6.addView(r8, r3)
            goto L_0x00f1
        L_0x00e3:
            android.view.View r9 = r7.itemView
            java.lang.String r10 = "holder.itemView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            boolean r6 = r12.o0(r6, r3)
            r8.d(r9, r6)
        L_0x00f1:
            java.util.ArrayList r6 = r11.b
            r6.add(r3, r7)
        L_0x00f6:
            int r3 = r3 + 1
            goto L_0x0088
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.ModelGroupHolder.c(com.airbnb.epoxy.EpoxyModelGroup):void");
    }

    public final void d(ViewGroup viewGroup, ArrayList arrayList) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                d((ViewGroup) childAt, arrayList);
            } else if (childAt instanceof ViewStub) {
                arrayList.add(new ViewStubData(viewGroup, (ViewStub) childAt, i2));
            }
        }
    }

    public final List e(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList(4);
        d(viewGroup, arrayList);
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new IllegalStateException("No view stubs found. If viewgroup is not empty it must contain ViewStubs.");
    }

    public final ViewGroup f(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.epoxy_model_group_child_container);
        ViewGroup viewGroup2 = findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
        return viewGroup2 == null ? viewGroup : viewGroup2;
    }

    public final ViewGroup g() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final EpoxyViewHolder h(ViewGroup viewGroup, EpoxyModel epoxyModel) {
        int b2 = ViewTypeManager.b(epoxyModel);
        RecyclerView.ViewHolder recycledView = this.c.getRecycledView(b2);
        EpoxyViewHolder epoxyViewHolder = recycledView instanceof EpoxyViewHolder ? (EpoxyViewHolder) recycledView : null;
        return epoxyViewHolder == null ? i.g(this.f2307a, epoxyModel, viewGroup, b2) : epoxyViewHolder;
    }

    public final ArrayList i() {
        return this.b;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.view.ViewGroup] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(int r3) {
        /*
            r2 = this;
            boolean r0 = r2.l()
            r1 = 0
            if (r0 == 0) goto L_0x001c
            java.util.List r0 = r2.f
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = "stubs"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0012
        L_0x0011:
            r1 = r0
        L_0x0012:
            java.lang.Object r0 = r1.get(r3)
            com.airbnb.epoxy.ViewStubData r0 = (com.airbnb.epoxy.ViewStubData) r0
            r0.c()
            goto L_0x002a
        L_0x001c:
            android.view.ViewGroup r0 = r2.e
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "childContainer"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0027
        L_0x0026:
            r1 = r0
        L_0x0027:
            r1.removeViewAt(r3)
        L_0x002a:
            java.util.ArrayList r0 = r2.b
            java.lang.Object r3 = r0.remove(r3)
            java.lang.String r0 = "viewHolders.removeAt(modelPosition)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            com.airbnb.epoxy.EpoxyViewHolder r3 = (com.airbnb.epoxy.EpoxyViewHolder) r3
            r3.g()
            androidx.recyclerview.widget.RecyclerView$RecycledViewPool r2 = r2.c
            r2.putRecycledView(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.ModelGroupHolder.j(int):void");
    }

    public final void k() {
        if (this.g != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                j(this.b.size() - 1);
            }
            this.g = null;
            return;
        }
        throw new IllegalStateException("Group is not bound");
    }

    public final boolean l() {
        List list = this.f;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stubs");
            list = null;
        }
        return !list.isEmpty();
    }
}
