package com.airbnb.epoxy;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.viewmodeladapter.R;
import com.honey.account.r0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0003WXYB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010#R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020+0/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u000603R\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u000607R\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000B8\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010N\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010G\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006Z"}, d2 = {"Lcom/airbnb/epoxy/EpoxyVisibilityTracker;", "", "<init>", "()V", "", "debug", "", "checkItemAnimator", "", "n", "(Ljava/lang/String;Z)V", "Landroid/view/View;", "detachedView", "p", "(Landroid/view/View;Ljava/lang/String;)V", "v", "child", "detachEvent", "eventOriginForDebug", "q", "(Landroid/view/View;ZLjava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/airbnb/epoxy/ModelGroupHolder;", "epoxyHolder", "u", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/ModelGroupHolder;ZLjava/lang/String;)V", "Lcom/airbnb/epoxy/EpoxyViewHolder;", "viewHolder", "r", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;ZLjava/lang/String;Lcom/airbnb/epoxy/EpoxyViewHolder;)V", "w", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;ZLjava/lang/String;)Z", "childRecyclerView", "s", "(Landroidx/recyclerview/widget/RecyclerView;)V", "t", "l", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemAnimatorFinishedListener;", "a", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemAnimatorFinishedListener;", "itemAnimatorFinishedListener", "Landroid/util/SparseArray;", "Lcom/airbnb/epoxy/EpoxyVisibilityItem;", "b", "Landroid/util/SparseArray;", "visibilityIdToItemMap", "", "c", "Ljava/util/List;", "visibilityIdToItems", "Lcom/airbnb/epoxy/EpoxyVisibilityTracker$Listener;", "d", "Lcom/airbnb/epoxy/EpoxyVisibilityTracker$Listener;", "listener", "Lcom/airbnb/epoxy/EpoxyVisibilityTracker$DataObserver;", "e", "Lcom/airbnb/epoxy/EpoxyVisibilityTracker$DataObserver;", "observer", "f", "Landroidx/recyclerview/widget/RecyclerView;", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "g", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "lastAdapterSeen", "", "h", "Ljava/util/Map;", "nestedTrackers", "i", "Z", "visibleDataChanged", "j", "getOnChangedEnabled", "()Z", "setOnChangedEnabled", "(Z)V", "onChangedEnabled", "", "k", "Ljava/lang/Integer;", "getPartialImpressionThresholdPercentage", "()Ljava/lang/Integer;", "setPartialImpressionThresholdPercentage", "(Ljava/lang/Integer;)V", "partialImpressionThresholdPercentage", "Companion", "DataObserver", "Listener", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEpoxyVisibilityTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpoxyVisibilityTracker.kt\ncom/airbnb/epoxy/EpoxyVisibilityTracker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,553:1\n1#2:554\n*E\n"})
public class EpoxyVisibilityTracker {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public static final int m = R.id.epoxy_visibility_tracker;

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.ItemAnimator.ItemAnimatorFinishedListener f2302a = new b(this);
    public final SparseArray b = new SparseArray();
    public final List c = new ArrayList();
    public final Listener d = new Listener();
    public final DataObserver e = new DataObserver();
    public RecyclerView f;
    public RecyclerView.Adapter g;
    public final Map h = new HashMap();
    public boolean i;
    public boolean j = true;
    public Integer k;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/airbnb/epoxy/EpoxyVisibilityTracker$Companion;", "", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/airbnb/epoxy/EpoxyVisibilityTracker;", "c", "(Landroidx/recyclerview/widget/RecyclerView;)Lcom/airbnb/epoxy/EpoxyVisibilityTracker;", "tracker", "", "d", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyVisibilityTracker;)V", "", "DEBUG_LOG", "Z", "", "TAG", "Ljava/lang/String;", "", "TAG_ID", "I", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EpoxyVisibilityTracker c(RecyclerView recyclerView) {
            return (EpoxyVisibilityTracker) recyclerView.getTag(EpoxyVisibilityTracker.m);
        }

        public final void d(RecyclerView recyclerView, EpoxyVisibilityTracker epoxyVisibilityTracker) {
            recyclerView.setTag(EpoxyVisibilityTracker.m, epoxyVisibilityTracker);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/airbnb/epoxy/EpoxyVisibilityTracker$DataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "<init>", "(Lcom/airbnb/epoxy/EpoxyVisibilityTracker;)V", "", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeInserted", "(II)V", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "(III)V", "b", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public final class DataObserver extends RecyclerView.AdapterDataObserver {
        public DataObserver() {
        }

        public final boolean a(RecyclerView recyclerView) {
            return recyclerView == null || !(recyclerView.getAdapter() instanceof BaseEpoxyAdapter);
        }

        public final void b(int i, int i2) {
            if (!a(EpoxyVisibilityTracker.this.f)) {
                for (EpoxyVisibilityItem epoxyVisibilityItem : EpoxyVisibilityTracker.this.c) {
                    int a2 = epoxyVisibilityItem.a();
                    if (a2 == i) {
                        epoxyVisibilityItem.l(i2 - i);
                        EpoxyVisibilityTracker.this.i = true;
                    } else if (i < i2) {
                        if (i + 1 <= a2 && a2 <= i2) {
                            epoxyVisibilityItem.l(-1);
                            EpoxyVisibilityTracker.this.i = true;
                        }
                    } else if (i > i2 && i2 <= a2 && a2 < i) {
                        epoxyVisibilityItem.l(1);
                        EpoxyVisibilityTracker.this.i = true;
                    }
                }
            }
        }

        public void onChanged() {
            if (!a(EpoxyVisibilityTracker.this.f)) {
                EpoxyVisibilityTracker.this.b.clear();
                EpoxyVisibilityTracker.this.c.clear();
                EpoxyVisibilityTracker.this.i = true;
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            if (!a(EpoxyVisibilityTracker.this.f)) {
                for (EpoxyVisibilityItem epoxyVisibilityItem : EpoxyVisibilityTracker.this.c) {
                    if (epoxyVisibilityItem.a() >= i) {
                        EpoxyVisibilityTracker.this.i = true;
                        epoxyVisibilityItem.l(i2);
                    }
                }
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            if (!a(EpoxyVisibilityTracker.this.f)) {
                for (int i4 = 0; i4 < i3; i4++) {
                    b(i + i4, i2 + i4);
                }
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            if (!a(EpoxyVisibilityTracker.this.f)) {
                for (EpoxyVisibilityItem epoxyVisibilityItem : EpoxyVisibilityTracker.this.c) {
                    if (epoxyVisibilityItem.a() >= i) {
                        EpoxyVisibilityTracker.this.i = true;
                        epoxyVisibilityItem.l(-i2);
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JP\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016¨\u0006\u0019"}, d2 = {"Lcom/airbnb/epoxy/EpoxyVisibilityTracker$Listener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View$OnLayoutChangeListener;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "(Lcom/airbnb/epoxy/EpoxyVisibilityTracker;)V", "onChildViewAttachedToWindow", "", "child", "Landroid/view/View;", "onChildViewDetachedFromWindow", "onLayoutChange", "recyclerView", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onScrolled", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Listener extends RecyclerView.OnScrollListener implements View.OnLayoutChangeListener, RecyclerView.OnChildAttachStateChangeListener {
        public Listener() {
        }

        public void onChildViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "child");
            if (view instanceof RecyclerView) {
                EpoxyVisibilityTracker.this.s((RecyclerView) view);
            }
            EpoxyVisibilityTracker.this.q(view, false, "onChildViewAttachedToWindow");
        }

        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "child");
            if (view instanceof RecyclerView) {
                EpoxyVisibilityTracker.this.t((RecyclerView) view);
            }
            if (EpoxyVisibilityTracker.this.i) {
                EpoxyVisibilityTracker.this.p(view, "onChildViewDetachedFromWindow");
                EpoxyVisibilityTracker.this.i = false;
                return;
            }
            EpoxyVisibilityTracker.this.q(view, true, "onChildViewDetachedFromWindow");
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullParameter(view, "recyclerView");
            EpoxyVisibilityTracker.o(EpoxyVisibilityTracker.this, "onLayoutChange", false, 2, (Object) null);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            EpoxyVisibilityTracker.o(EpoxyVisibilityTracker.this, "onScrolled", false, 2, (Object) null);
        }
    }

    public static final void m(EpoxyVisibilityTracker epoxyVisibilityTracker) {
        Intrinsics.checkNotNullParameter(epoxyVisibilityTracker, "this$0");
        epoxyVisibilityTracker.n("ItemAnimatorFinishedListener.onAnimationsFinished", false);
    }

    public static /* synthetic */ void o(EpoxyVisibilityTracker epoxyVisibilityTracker, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            epoxyVisibilityTracker.n(str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processChangeEvent");
    }

    public void l(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f = recyclerView;
        recyclerView.addOnScrollListener(this.d);
        recyclerView.addOnLayoutChangeListener(this.d);
        recyclerView.addOnChildAttachStateChangeListener(this.d);
        l.d(recyclerView, this);
    }

    public final void n(String str, boolean z) {
        RecyclerView recyclerView = this.f;
        if (recyclerView != null) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (!z || itemAnimator == null) {
                p((View) null, str);
            } else if (itemAnimator.isRunning(this.f2302a)) {
                p((View) null, str);
            }
        }
    }

    public final void p(View view, String str) {
        RecyclerView recyclerView = this.f;
        if (recyclerView != null) {
            v();
            if (view != null) {
                q(view, true, str);
            }
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (!(childAt == null || childAt == view)) {
                    q(childAt, false, str);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(android.view.View r9, boolean r10, java.lang.String r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r6 = r8.f
            if (r6 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto L_0x0014
            android.view.ViewParent r0 = r9.getParent()
            if (r0 != r6) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0018
        L_0x0014:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r6.getChildViewHolder(r9)
        L_0x0018:
            boolean r1 = r0 instanceof com.airbnb.epoxy.EpoxyViewHolder
            if (r1 == 0) goto L_0x0034
            r5 = r0
            com.airbnb.epoxy.EpoxyViewHolder r5 = (com.airbnb.epoxy.EpoxyViewHolder) r5
            com.airbnb.epoxy.EpoxyHolder r7 = r5.c()
            r0 = r8
            r1 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r0.r(r1, r2, r3, r4, r5)
            boolean r9 = r7 instanceof com.airbnb.epoxy.ModelGroupHolder
            if (r9 == 0) goto L_0x0034
            com.airbnb.epoxy.ModelGroupHolder r7 = (com.airbnb.epoxy.ModelGroupHolder) r7
            r8.u(r6, r7, r10, r11)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.EpoxyVisibilityTracker.q(android.view.View, boolean, java.lang.String):void");
    }

    public final void r(RecyclerView recyclerView, View view, boolean z, String str, EpoxyViewHolder epoxyViewHolder) {
        EpoxyVisibilityTracker epoxyVisibilityTracker;
        if (w(recyclerView, epoxyViewHolder, z, str) && (view instanceof RecyclerView) && (epoxyVisibilityTracker = (EpoxyVisibilityTracker) this.h.get(view)) != null) {
            o(epoxyVisibilityTracker, "parent", false, 2, (Object) null);
        }
    }

    public final void s(RecyclerView recyclerView) {
        EpoxyVisibilityTracker a2 = l.c(recyclerView);
        if (a2 == null) {
            a2 = new EpoxyVisibilityTracker();
            a2.k = this.k;
            a2.l(recyclerView);
        }
        this.h.put(recyclerView, a2);
    }

    public final void t(RecyclerView recyclerView) {
        this.h.remove(recyclerView);
    }

    public final void u(RecyclerView recyclerView, ModelGroupHolder modelGroupHolder, boolean z, String str) {
        Iterator it = modelGroupHolder.i().iterator();
        while (it.hasNext()) {
            EpoxyViewHolder epoxyViewHolder = (EpoxyViewHolder) it.next();
            View view = epoxyViewHolder.itemView;
            if (view instanceof RecyclerView) {
                if (z) {
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                    t((RecyclerView) view);
                } else {
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                    s((RecyclerView) view);
                }
            }
            View view2 = epoxyViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "groupChildHolder.itemView");
            Intrinsics.checkNotNullExpressionValue(epoxyViewHolder, "groupChildHolder");
            r(recyclerView, view2, z, str, epoxyViewHolder);
        }
    }

    public final void v() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this.f;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null && !Intrinsics.areEqual((Object) this.g, (Object) adapter)) {
            RecyclerView.Adapter adapter2 = this.g;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(this.e);
            }
            adapter.registerAdapterDataObserver(this.e);
            this.g = adapter;
        }
    }

    public final boolean w(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, boolean z, String str) {
        View view = epoxyViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "epoxyHolder.itemView");
        int identityHashCode = System.identityHashCode(view);
        Object obj = this.b.get(identityHashCode);
        if (obj == null) {
            obj = new EpoxyVisibilityItem(Integer.valueOf(epoxyViewHolder.getAdapterPosition()));
            this.b.put(identityHashCode, obj);
            this.c.add(obj);
        } else if (epoxyViewHolder.getAdapterPosition() != -1) {
            EpoxyVisibilityItem epoxyVisibilityItem = (EpoxyVisibilityItem) obj;
            if (epoxyVisibilityItem.a() != epoxyViewHolder.getAdapterPosition()) {
                epoxyVisibilityItem.k(epoxyViewHolder.getAdapterPosition());
            }
        }
        EpoxyVisibilityItem epoxyVisibilityItem2 = (EpoxyVisibilityItem) obj;
        if (!epoxyVisibilityItem2.m(view, recyclerView, z)) {
            return false;
        }
        epoxyVisibilityItem2.f(epoxyViewHolder, z);
        Integer num = this.k;
        if (num != null) {
            epoxyVisibilityItem2.e(epoxyViewHolder, z, num.intValue());
        }
        epoxyVisibilityItem2.c(epoxyViewHolder, z);
        epoxyVisibilityItem2.d(epoxyViewHolder, z);
        return epoxyVisibilityItem2.b(epoxyViewHolder, this.j);
    }
}
