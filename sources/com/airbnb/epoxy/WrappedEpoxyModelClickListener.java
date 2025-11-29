package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import com.airbnb.epoxy.EpoxyModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@SourceDebugExtension({"SMAP\nWrappedEpoxyModelClickListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WrappedEpoxyModelClickListener.kt\ncom/airbnb/epoxy/WrappedEpoxyModelClickListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,156:1\n288#2,2:157\n*S KotlinDebug\n*F\n+ 1 WrappedEpoxyModelClickListener.kt\ncom/airbnb/epoxy/WrappedEpoxyModelClickListener\n*L\n77#1:157,2\n*E\n"})
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u0004\b\u0001\u0010\u00032\u00020\u00042\u00020\u0005:\u0001*J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060$*\u00020\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060$*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010(¨\u0006+"}, d2 = {"Lcom/airbnb/epoxy/WrappedEpoxyModelClickListener;", "Lcom/airbnb/epoxy/EpoxyModel;", "T", "V", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "", "onLongClick", "(Landroid/view/View;)Z", "Landroid/view/ViewGroup;", "", "e", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/airbnb/epoxy/WrappedEpoxyModelClickListener$ClickedModelInfo;", "d", "(Landroid/view/View;)Lcom/airbnb/epoxy/WrappedEpoxyModelClickListener$ClickedModelInfo;", "Lcom/airbnb/epoxy/OnModelClickListener;", "a", "Lcom/airbnb/epoxy/OnModelClickListener;", "originalClickListener", "Lcom/airbnb/epoxy/OnModelLongClickListener;", "b", "Lcom/airbnb/epoxy/OnModelLongClickListener;", "originalLongClickListener", "Lkotlin/sequences/Sequence;", "c", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "children", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "allViewsInHierarchy", "ClickedModelInfo", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class WrappedEpoxyModelClickListener<T extends EpoxyModel<?>, V> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final OnModelClickListener f2321a;
    public final OnModelLongClickListener b;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\r\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/airbnb/epoxy/WrappedEpoxyModelClickListener$ClickedModelInfo;", "", "Lcom/airbnb/epoxy/EpoxyModel;", "model", "", "adapterPosition", "boundObject", "<init>", "(Lcom/airbnb/epoxy/EpoxyModel;ILjava/lang/Object;)V", "a", "Lcom/airbnb/epoxy/EpoxyModel;", "c", "()Lcom/airbnb/epoxy/EpoxyModel;", "b", "I", "()I", "Ljava/lang/Object;", "()Ljava/lang/Object;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class ClickedModelInfo {

        /* renamed from: a  reason: collision with root package name */
        public final EpoxyModel f2322a;
        public final int b;
        public final Object c;

        public ClickedModelInfo(EpoxyModel epoxyModel, int i, Object obj) {
            Intrinsics.checkNotNullParameter(epoxyModel, "model");
            Intrinsics.checkNotNullParameter(obj, "boundObject");
            this.f2322a = epoxyModel;
            this.b = i;
            this.c = obj;
        }

        public final int a() {
            return this.b;
        }

        public final Object b() {
            return this.c;
        }

        public final EpoxyModel c() {
            return this.f2322a;
        }
    }

    public final Sequence b(View view) {
        return view instanceof ViewGroup ? SequencesKt.plus(SequencesKt.flatMap(c((ViewGroup) view), new WrappedEpoxyModelClickListener$allViewsInHierarchy$1(this)), view) : SequencesKt.sequenceOf(view);
    }

    public final Sequence c(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return new WrappedEpoxyModelClickListener$children$1(this, viewGroup);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.airbnb.epoxy.EpoxyViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.airbnb.epoxy.EpoxyViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.airbnb.epoxy.EpoxyViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.airbnb.epoxy.EpoxyViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.airbnb.epoxy.WrappedEpoxyModelClickListener.ClickedModelInfo d(android.view.View r8) {
        /*
            r7 = this;
            com.airbnb.epoxy.EpoxyViewHolder r0 = com.airbnb.epoxy.ListenersUtils.b(r8)
            if (r0 == 0) goto L_0x0063
            int r1 = r0.getAdapterPosition()
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L_0x000f
            return r3
        L_0x000f:
            java.lang.Object r2 = r0.e()
            java.lang.String r4 = "epoxyHolder.objectToBind()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r4 = r2 instanceof com.airbnb.epoxy.ModelGroupHolder
            if (r4 == 0) goto L_0x004b
            com.airbnb.epoxy.ModelGroupHolder r2 = (com.airbnb.epoxy.ModelGroupHolder) r2
            java.util.ArrayList r2 = r2.i()
            java.util.Iterator r2 = r2.iterator()
        L_0x0026:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0045
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.airbnb.epoxy.EpoxyViewHolder r5 = (com.airbnb.epoxy.EpoxyViewHolder) r5
            android.view.View r5 = r5.itemView
            java.lang.String r6 = "it.itemView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            kotlin.sequences.Sequence r5 = r7.b(r5)
            boolean r5 = kotlin.sequences.SequencesKt.contains(r5, r8)
            if (r5 == 0) goto L_0x0026
            r3 = r4
        L_0x0045:
            com.airbnb.epoxy.EpoxyViewHolder r3 = (com.airbnb.epoxy.EpoxyViewHolder) r3
            if (r3 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r0 = r3
        L_0x004b:
            com.airbnb.epoxy.WrappedEpoxyModelClickListener$ClickedModelInfo r7 = new com.airbnb.epoxy.WrappedEpoxyModelClickListener$ClickedModelInfo
            com.airbnb.epoxy.EpoxyModel r8 = r0.d()
            java.lang.String r2 = "holderToUse.model"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            java.lang.Object r0 = r0.e()
            java.lang.String r2 = "holderToUse.objectToBind()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r7.<init>(r8, r1, r0)
            return r7
        L_0x0063:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Could not find RecyclerView holder for clicked view"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.WrappedEpoxyModelClickListener.d(android.view.View):com.airbnb.epoxy.WrappedEpoxyModelClickListener$ClickedModelInfo");
    }

    public final Iterator e(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return new WrappedEpoxyModelClickListener$iterator$1(viewGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WrappedEpoxyModelClickListener)) {
            return false;
        }
        OnModelClickListener onModelClickListener = this.f2321a;
        if (onModelClickListener == null ? ((WrappedEpoxyModelClickListener) obj).f2321a != null : !Intrinsics.areEqual((Object) onModelClickListener, (Object) ((WrappedEpoxyModelClickListener) obj).f2321a)) {
            return false;
        }
        OnModelLongClickListener onModelLongClickListener = this.b;
        return onModelLongClickListener != null ? Intrinsics.areEqual((Object) onModelLongClickListener, (Object) ((WrappedEpoxyModelClickListener) obj).b) : ((WrappedEpoxyModelClickListener) obj).b == null;
    }

    public int hashCode() {
        OnModelClickListener onModelClickListener = this.f2321a;
        int i = 0;
        int hashCode = (onModelClickListener != null ? onModelClickListener.hashCode() : 0) * 31;
        OnModelLongClickListener onModelLongClickListener = this.b;
        if (onModelLongClickListener != null) {
            i = onModelLongClickListener.hashCode();
        }
        return hashCode + i;
    }

    public void onClick(View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        ClickedModelInfo d = d(view);
        if (d != null) {
            OnModelClickListener onModelClickListener = this.f2321a;
            if (onModelClickListener != null) {
                EpoxyModel c = d.c();
                Intrinsics.checkNotNull(c, "null cannot be cast to non-null type T of com.airbnb.epoxy.WrappedEpoxyModelClickListener");
                onModelClickListener.a(c, d.b(), view, d.a());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("Original click listener is null".toString());
            }
        }
    }

    public boolean onLongClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ClickedModelInfo d = d(view);
        if (d == null) {
            return false;
        }
        OnModelLongClickListener onModelLongClickListener = this.b;
        if (onModelLongClickListener != null) {
            EpoxyModel c = d.c();
            Intrinsics.checkNotNull(c, "null cannot be cast to non-null type T of com.airbnb.epoxy.WrappedEpoxyModelClickListener");
            return onModelLongClickListener.a(c, d.b(), view, d.a());
        }
        throw new IllegalStateException("Original long click listener is null".toString());
    }
}
