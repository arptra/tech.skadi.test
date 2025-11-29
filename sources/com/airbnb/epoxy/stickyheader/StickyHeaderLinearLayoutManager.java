package com.airbnb.epoxy.stickyheader;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.BaseEpoxyAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002tuJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0018\u00010\u0013R\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001bH\u0002¢\u0006\u0004\b(\u0010)J!\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020,2\u0006\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u00101J\u001f\u00104\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0014H\u0016¢\u0006\u0004\b7\u00108J+\u0010:\u001a\u00020\u00042\f\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b:\u0010;J\u0011\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020<H\u0016¢\u0006\u0004\b@\u0010AJ+\u0010D\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ+\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bG\u0010EJ#\u0010H\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\bL\u00105J\u0017\u0010M\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bO\u0010NJ\u0017\u0010P\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bP\u0010NJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bQ\u0010NJ\u0017\u0010R\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bR\u0010NJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bS\u0010NJ\u0019\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010WJ5\u0010Z\u001a\u0004\u0018\u00010\u001b2\u0006\u0010X\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0013R\u00020\u00142\u0006\u0010?\u001a\u00020CH\u0016¢\u0006\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010\u0011R\u0016\u0010c\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010\u0011R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00070d8\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u00060hR\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010\u0005R\u0016\u0010q\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010\u0005R\u0016\u0010s\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010\u0005¨\u0006v"}, d2 = {"Lcom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "newAdapter", "", "I", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", "position", "offset", "", "adjustForStickyHeader", "H", "(IIZ)V", "T", "Lkotlin/Function0;", "operation", "F", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "layout", "K", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Z)V", "w", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;I)V", "Landroid/view/View;", "stickyHeader", "v", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroid/view/View;I)V", "E", "(Landroid/view/View;)V", "G", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "view", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "params", "D", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Z", "C", "(Landroid/view/View;)Z", "headerView", "nextHeaderView", "", "B", "(Landroid/view/View;Landroid/view/View;)F", "A", "x", "(I)I", "y", "z", "J", "(II)V", "recyclerView", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "oldAdapter", "onAdapterChanged", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "dy", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I", "dx", "scrollHorizontallyBy", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "scrollToPosition", "(I)V", "scrollToPositionWithOffset", "computeVerticalScrollExtent", "(Landroidx/recyclerview/widget/RecyclerView$State;)I", "computeVerticalScrollOffset", "computeVerticalScrollRange", "computeHorizontalScrollExtent", "computeHorizontalScrollOffset", "computeHorizontalScrollRange", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "(I)Landroid/graphics/PointF;", "focused", "focusDirection", "onFocusSearchFailed", "(Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)Landroid/view/View;", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "a", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "adapter", "b", "translationX", "c", "translationY", "", "d", "Ljava/util/List;", "headerPositions", "Lcom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager$HeaderPositionsAdapterDataObserver;", "e", "Lcom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager$HeaderPositionsAdapterDataObserver;", "headerPositionsObserver", "f", "Landroid/view/View;", "g", "stickyHeaderPosition", "h", "scrollPosition", "i", "scrollOffset", "HeaderPositionsAdapterDataObserver", "SavedState", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStickyHeaderLinearLayoutManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StickyHeaderLinearLayoutManager.kt\ncom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,641:1\n1#2:642\n*E\n"})
public final class StickyHeaderLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    public BaseEpoxyAdapter f2333a;
    public float b;
    public float c;
    public final List d;
    public final HeaderPositionsAdapterDataObserver e;
    public View f;
    public int g;
    public int h;
    public int i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ'\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager$HeaderPositionsAdapterDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeInserted", "(II)V", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "(III)V", "index", "a", "(I)V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public final class HeaderPositionsAdapterDataObserver extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickyHeaderLinearLayoutManager f2334a;

        public final void a(int i) {
            int intValue = ((Number) this.f2334a.d.remove(i)).intValue();
            int i2 = this.f2334a.z(intValue);
            if (i2 != -1) {
                this.f2334a.d.add(i2, Integer.valueOf(intValue));
            } else {
                this.f2334a.d.add(Integer.valueOf(intValue));
            }
        }

        public void onChanged() {
            this.f2334a.d.clear();
            BaseEpoxyAdapter j = this.f2334a.f2333a;
            int itemCount = j != null ? j.getItemCount() : 0;
            for (int i = 0; i < itemCount; i++) {
                BaseEpoxyAdapter j2 = this.f2334a.f2333a;
                if (j2 != null ? j2.o(i) : false) {
                    this.f2334a.d.add(Integer.valueOf(i));
                }
            }
            if (this.f2334a.f != null && !this.f2334a.d.contains(Integer.valueOf(this.f2334a.g))) {
                this.f2334a.G((RecyclerView.Recycler) null);
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            int size = this.f2334a.d.size();
            if (size > 0) {
                int i3 = this.f2334a.z(i);
                while (i3 != -1 && i3 < size) {
                    this.f2334a.d.set(i3, Integer.valueOf(((Number) this.f2334a.d.get(i3)).intValue() + i2));
                    i3++;
                }
            }
            int i4 = i2 + i;
            while (i < i4) {
                BaseEpoxyAdapter j = this.f2334a.f2333a;
                if (j != null ? j.o(i) : false) {
                    int i5 = this.f2334a.z(i);
                    if (i5 != -1) {
                        this.f2334a.d.add(i5, Integer.valueOf(i));
                    } else {
                        this.f2334a.d.add(Integer.valueOf(i));
                    }
                }
                i++;
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            int size = this.f2334a.d.size();
            if (size <= 0) {
                return;
            }
            if (i < i2) {
                int i4 = this.f2334a.z(i);
                while (i4 != -1 && i4 < size) {
                    int intValue = ((Number) this.f2334a.d.get(i4)).intValue();
                    if (intValue >= i && intValue < i + i3) {
                        this.f2334a.d.set(i4, Integer.valueOf(intValue - (i2 - i)));
                        a(i4);
                    } else if (intValue >= i + i3 && intValue <= i2) {
                        this.f2334a.d.set(i4, Integer.valueOf(intValue - i3));
                        a(i4);
                    } else {
                        return;
                    }
                    i4++;
                }
                return;
            }
            int i5 = this.f2334a.z(i2);
            while (i5 != -1 && i5 < size) {
                int intValue2 = ((Number) this.f2334a.d.get(i5)).intValue();
                if (intValue2 >= i && intValue2 < i + i3) {
                    this.f2334a.d.set(i5, Integer.valueOf(intValue2 + (i2 - i)));
                    a(i5);
                } else if (i2 <= intValue2 && intValue2 <= i) {
                    this.f2334a.d.set(i5, Integer.valueOf(intValue2 + i3));
                    a(i5);
                } else {
                    return;
                }
                i5++;
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            int size = this.f2334a.d.size();
            if (size > 0) {
                int i3 = i + i2;
                int i4 = i3 - 1;
                if (i <= i4) {
                    while (true) {
                        int h = this.f2334a.x(i4);
                        if (h != -1) {
                            this.f2334a.d.remove(h);
                            size--;
                        }
                        if (i4 == i) {
                            break;
                        }
                        i4--;
                    }
                }
                if (this.f2334a.f != null && !this.f2334a.d.contains(Integer.valueOf(this.f2334a.g))) {
                    this.f2334a.G((RecyclerView.Recycler) null);
                }
                int i5 = this.f2334a.z(i3);
                while (i5 != -1 && i5 < size) {
                    this.f2334a.d.set(i5, Integer.valueOf(((Number) this.f2334a.d.get(i5)).intValue() - i2));
                    i5++;
                }
            }
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager$SavedState;", "Landroid/os/Parcelable;", "superState", "scrollPosition", "", "scrollOffset", "(Landroid/os/Parcelable;II)V", "getScrollOffset", "()I", "getScrollPosition", "getSuperState", "()Landroid/os/Parcelable;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SavedState implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final int scrollOffset;
        private final int scrollPosition;
        @NotNull
        private final Parcelable superState;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(parcel.readParcelable(SavedState.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            }

            /* renamed from: b */
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NotNull Parcelable parcelable, int i, int i2) {
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            this.superState = parcelable;
            this.scrollPosition = i;
            this.scrollOffset = i2;
        }

        public static /* synthetic */ SavedState copy$default(SavedState savedState, Parcelable parcelable, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                parcelable = savedState.superState;
            }
            if ((i3 & 2) != 0) {
                i = savedState.scrollPosition;
            }
            if ((i3 & 4) != 0) {
                i2 = savedState.scrollOffset;
            }
            return savedState.copy(parcelable, i, i2);
        }

        @NotNull
        public final Parcelable component1() {
            return this.superState;
        }

        public final int component2() {
            return this.scrollPosition;
        }

        public final int component3() {
            return this.scrollOffset;
        }

        @NotNull
        public final SavedState copy(@NotNull Parcelable parcelable, int i, int i2) {
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            return new SavedState(parcelable, i, i2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SavedState)) {
                return false;
            }
            SavedState savedState = (SavedState) obj;
            return Intrinsics.areEqual((Object) this.superState, (Object) savedState.superState) && this.scrollPosition == savedState.scrollPosition && this.scrollOffset == savedState.scrollOffset;
        }

        public final int getScrollOffset() {
            return this.scrollOffset;
        }

        public final int getScrollPosition() {
            return this.scrollPosition;
        }

        @NotNull
        public final Parcelable getSuperState() {
            return this.superState;
        }

        public int hashCode() {
            return (((this.superState.hashCode() * 31) + Integer.hashCode(this.scrollPosition)) * 31) + Integer.hashCode(this.scrollOffset);
        }

        @NotNull
        public String toString() {
            return "SavedState(superState=" + this.superState + ", scrollPosition=" + this.scrollPosition + ", scrollOffset=" + this.scrollOffset + ')';
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.superState, i);
            parcel.writeInt(this.scrollPosition);
            parcel.writeInt(this.scrollOffset);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float A(android.view.View r7, android.view.View r8) {
        /*
            r6 = this;
            int r0 = r6.getOrientation()
            if (r0 != 0) goto L_0x0061
            float r0 = r6.b
            boolean r1 = r6.getReverseLayout()
            if (r1 == 0) goto L_0x0019
            int r1 = r6.getWidth()
            int r2 = r7.getWidth()
            int r1 = r1 - r2
            float r1 = (float) r1
            float r0 = r0 + r1
        L_0x0019:
            if (r8 == 0) goto L_0x0060
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            r3 = 0
            if (r2 == 0) goto L_0x0027
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            goto L_0x0028
        L_0x0027:
            r1 = r3
        L_0x0028:
            r2 = 0
            if (r1 == 0) goto L_0x002e
            int r1 = r1.leftMargin
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            android.view.ViewGroup$LayoutParams r4 = r8.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 == 0) goto L_0x003a
            r3 = r4
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
        L_0x003a:
            if (r3 == 0) goto L_0x003e
            int r2 = r3.rightMargin
        L_0x003e:
            boolean r6 = r6.getReverseLayout()
            if (r6 == 0) goto L_0x0050
            int r6 = r8.getRight()
            int r6 = r6 + r2
            float r6 = (float) r6
            float r6 = kotlin.ranges.RangesKt.coerceAtLeast((float) r6, (float) r0)
        L_0x004e:
            r0 = r6
            goto L_0x0060
        L_0x0050:
            int r6 = r8.getLeft()
            int r6 = r6 - r1
            int r7 = r7.getWidth()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r6 = kotlin.ranges.RangesKt.coerceAtMost((float) r6, (float) r0)
            goto L_0x004e
        L_0x0060:
            return r0
        L_0x0061:
            float r6 = r6.b
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager.A(android.view.View, android.view.View):float");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float B(android.view.View r7, android.view.View r8) {
        /*
            r6 = this;
            int r0 = r6.getOrientation()
            r1 = 1
            if (r0 != r1) goto L_0x0062
            float r0 = r6.c
            boolean r1 = r6.getReverseLayout()
            if (r1 == 0) goto L_0x001a
            int r1 = r6.getHeight()
            int r2 = r7.getHeight()
            int r1 = r1 - r2
            float r1 = (float) r1
            float r0 = r0 + r1
        L_0x001a:
            if (r8 == 0) goto L_0x0061
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            r3 = 0
            if (r2 == 0) goto L_0x0028
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            goto L_0x0029
        L_0x0028:
            r1 = r3
        L_0x0029:
            r2 = 0
            if (r1 == 0) goto L_0x002f
            int r1 = r1.bottomMargin
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            android.view.ViewGroup$LayoutParams r4 = r8.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 == 0) goto L_0x003b
            r3 = r4
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
        L_0x003b:
            if (r3 == 0) goto L_0x003f
            int r2 = r3.topMargin
        L_0x003f:
            boolean r6 = r6.getReverseLayout()
            if (r6 == 0) goto L_0x0051
            int r6 = r8.getBottom()
            int r6 = r6 + r1
            float r6 = (float) r6
            float r6 = kotlin.ranges.RangesKt.coerceAtLeast((float) r6, (float) r0)
        L_0x004f:
            r0 = r6
            goto L_0x0061
        L_0x0051:
            int r6 = r8.getTop()
            int r6 = r6 - r2
            int r7 = r7.getHeight()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r6 = kotlin.ranges.RangesKt.coerceAtMost((float) r6, (float) r0)
            goto L_0x004f
        L_0x0061:
            return r0
        L_0x0062:
            float r6 = r6.c
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager.B(android.view.View, android.view.View):float");
    }

    public final boolean C(View view) {
        if (getOrientation() == 1) {
            if (getReverseLayout()) {
                if (((float) view.getBottom()) - view.getTranslationY() <= ((float) getHeight()) + this.c) {
                    return false;
                }
            } else if (((float) view.getTop()) + view.getTranslationY() >= this.c) {
                return false;
            }
        } else if (getReverseLayout()) {
            if (((float) view.getRight()) - view.getTranslationX() <= ((float) getWidth()) + this.b) {
                return false;
            }
        } else if (((float) view.getLeft()) + view.getTranslationX() >= this.b) {
            return false;
        }
        return true;
    }

    public final boolean D(View view, RecyclerView.LayoutParams layoutParams) {
        if (layoutParams.isItemRemoved() || layoutParams.isViewInvalid()) {
            return false;
        }
        if (getOrientation() == 1) {
            if (getReverseLayout()) {
                if (((float) view.getTop()) + view.getTranslationY() > ((float) getHeight()) + this.c) {
                    return false;
                }
            } else if (((float) view.getBottom()) - view.getTranslationY() < this.c) {
                return false;
            }
        } else if (getReverseLayout()) {
            if (((float) view.getLeft()) + view.getTranslationX() > ((float) getWidth()) + this.b) {
                return false;
            }
        } else if (((float) view.getRight()) - view.getTranslationX() < this.b) {
            return false;
        }
        return true;
    }

    public final void E(View view) {
        measureChildWithMargins(view, 0, 0);
        if (getOrientation() == 1) {
            view.layout(getPaddingLeft(), 0, getWidth() - getPaddingRight(), view.getMeasuredHeight());
        } else {
            view.layout(0, getPaddingTop(), view.getMeasuredWidth(), getHeight() - getPaddingBottom());
        }
    }

    public final Object F(Function0 function0) {
        View view = this.f;
        if (view != null) {
            detachView(view);
        }
        Object invoke = function0.invoke();
        View view2 = this.f;
        if (view2 != null) {
            attachView(view2);
        }
        return invoke;
    }

    public final void G(RecyclerView.Recycler recycler) {
        View view = this.f;
        if (view != null) {
            this.f = null;
            this.g = -1;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            BaseEpoxyAdapter baseEpoxyAdapter = this.f2333a;
            if (baseEpoxyAdapter != null) {
                baseEpoxyAdapter.F(view);
            }
            stopIgnoringView(view);
            removeView(view);
            if (recycler != null) {
                recycler.recycleView(view);
            }
        }
    }

    public final void H(int i2, int i3, boolean z) {
        J(-1, Integer.MIN_VALUE);
        if (!z) {
            super.scrollToPositionWithOffset(i2, i3);
            return;
        }
        int y = y(i2);
        if (y == -1 || x(i2) != -1) {
            super.scrollToPositionWithOffset(i2, i3);
            return;
        }
        int i4 = i2 - 1;
        if (x(i4) != -1) {
            super.scrollToPositionWithOffset(i4, i3);
        } else if (this.f == null || y != x(this.g)) {
            J(i2, i3);
            super.scrollToPositionWithOffset(i2, i3);
        } else {
            if (i3 == Integer.MIN_VALUE) {
                i3 = 0;
            }
            View view = this.f;
            Intrinsics.checkNotNull(view);
            super.scrollToPositionWithOffset(i2, i3 + view.getHeight());
        }
    }

    public final void I(RecyclerView.Adapter adapter) {
        BaseEpoxyAdapter baseEpoxyAdapter = this.f2333a;
        if (baseEpoxyAdapter != null) {
            baseEpoxyAdapter.unregisterAdapterDataObserver(this.e);
        }
        if (adapter instanceof BaseEpoxyAdapter) {
            BaseEpoxyAdapter baseEpoxyAdapter2 = (BaseEpoxyAdapter) adapter;
            this.f2333a = baseEpoxyAdapter2;
            if (baseEpoxyAdapter2 != null) {
                baseEpoxyAdapter2.registerAdapterDataObserver(this.e);
            }
            this.e.onChanged();
            return;
        }
        this.f2333a = null;
        this.d.clear();
    }

    public final void J(int i2, int i3) {
        this.h = i2;
        this.i = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (getItemViewType(r5) == r6.getItemViewType(r7)) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (getPosition(r10) != r7) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(androidx.recyclerview.widget.RecyclerView.Recycler r9, boolean r10) {
        /*
            r8 = this;
            java.util.List r0 = r8.d
            int r0 = r0.size()
            int r1 = r8.getChildCount()
            if (r0 <= 0) goto L_0x00c4
            if (r1 <= 0) goto L_0x00c4
            r2 = 0
        L_0x000f:
            r3 = 0
            r4 = -1
            if (r2 >= r1) goto L_0x0033
            android.view.View r5 = r8.getChildAt(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            java.lang.String r7 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            androidx.recyclerview.widget.RecyclerView$LayoutParams r6 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r6
            boolean r7 = r8.D(r5, r6)
            if (r7 == 0) goto L_0x0030
            int r1 = r6.getViewAdapterPosition()
            goto L_0x0036
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0033:
            r5 = r3
            r1 = r4
            r2 = r1
        L_0x0036:
            if (r5 == 0) goto L_0x00c4
            if (r1 == r4) goto L_0x00c4
            int r6 = r8.y(r1)
            if (r6 == r4) goto L_0x004d
            java.util.List r7 = r8.d
            java.lang.Object r7 = r7.get(r6)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L_0x004e
        L_0x004d:
            r7 = r4
        L_0x004e:
            int r6 = r6 + 1
            if (r0 <= r6) goto L_0x005f
            java.util.List r0 = r8.d
            java.lang.Object r0 = r0.get(r6)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            goto L_0x0060
        L_0x005f:
            r0 = r4
        L_0x0060:
            if (r7 == r4) goto L_0x00c4
            if (r7 != r1) goto L_0x006a
            boolean r5 = r8.C(r5)
            if (r5 == 0) goto L_0x00c4
        L_0x006a:
            int r5 = r7 + 1
            if (r0 == r5) goto L_0x00c4
            android.view.View r5 = r8.f
            if (r5 == 0) goto L_0x0087
            com.airbnb.epoxy.BaseEpoxyAdapter r6 = r8.f2333a
            if (r6 == 0) goto L_0x0084
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r8.getItemViewType(r5)
            int r6 = r6.getItemViewType(r7)
            if (r5 != r6) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r8.G(r9)
        L_0x0087:
            android.view.View r5 = r8.f
            if (r5 != 0) goto L_0x008e
            r8.w(r9, r7)
        L_0x008e:
            if (r10 != 0) goto L_0x009b
            android.view.View r10 = r8.f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            int r10 = r8.getPosition(r10)
            if (r10 == r7) goto L_0x00a3
        L_0x009b:
            android.view.View r10 = r8.f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r8.v(r9, r10, r7)
        L_0x00a3:
            android.view.View r9 = r8.f
            if (r9 == 0) goto L_0x00c3
            if (r0 == r4) goto L_0x00b5
            int r0 = r0 - r1
            int r2 = r2 + r0
            android.view.View r10 = r8.getChildAt(r2)
            android.view.View r0 = r8.f
            if (r10 != r0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r3 = r10
        L_0x00b5:
            float r10 = r8.A(r9, r3)
            r9.setTranslationX(r10)
            float r8 = r8.B(r9, r3)
            r9.setTranslationY(r8)
        L_0x00c3:
            return
        L_0x00c4:
            android.view.View r10 = r8.f
            if (r10 == 0) goto L_0x00cb
            r8.G(r9)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager.K(androidx.recyclerview.widget.RecyclerView$Recycler, boolean):void");
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeHorizontalScrollExtent$1(this, state))).intValue();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeHorizontalScrollOffset$1(this, state))).intValue();
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeHorizontalScrollRange$1(this, state))).intValue();
    }

    public PointF computeScrollVectorForPosition(int i2) {
        return (PointF) F(new StickyHeaderLinearLayoutManager$computeScrollVectorForPosition$1(this, i2));
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeVerticalScrollExtent$1(this, state))).intValue();
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeVerticalScrollOffset$1(this, state))).intValue();
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ((Number) F(new StickyHeaderLinearLayoutManager$computeVerticalScrollRange$1(this, state))).intValue();
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        super.onAdapterChanged(adapter, adapter2);
        I(adapter2);
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToWindow(recyclerView);
        I(recyclerView.getAdapter());
    }

    public View onFocusSearchFailed(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(view, "focused");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return (View) F(new StickyHeaderLinearLayoutManager$onFocusSearchFailed$1(this, view, i2, recycler, state));
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        F(new StickyHeaderLinearLayoutManager$onLayoutChildren$1(this, recycler, state));
        if (!state.isPreLayout()) {
            K(recycler, true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        SavedState savedState = (SavedState) parcelable;
        this.h = savedState.getScrollPosition();
        this.i = savedState.getScrollOffset();
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState != null) {
            return new SavedState(onSaveInstanceState, this.h, this.i);
        }
        return null;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int intValue = ((Number) F(new StickyHeaderLinearLayoutManager$scrollHorizontallyBy$scrolled$1(this, i2, recycler, state))).intValue();
        if (intValue != 0) {
            K(recycler, false);
        }
        return intValue;
    }

    public void scrollToPosition(int i2) {
        scrollToPositionWithOffset(i2, Integer.MIN_VALUE);
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        H(i2, i3, true);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int intValue = ((Number) F(new StickyHeaderLinearLayoutManager$scrollVerticallyBy$scrolled$1(this, i2, recycler, state))).intValue();
        if (intValue != 0) {
            K(recycler, false);
        }
        return intValue;
    }

    public final void v(RecyclerView.Recycler recycler, View view, int i2) {
        recycler.bindViewToPosition(view, i2);
        this.g = i2;
        E(view);
        if (this.h != -1) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new StickyHeaderLinearLayoutManager$bindStickyHeader$1(view, this));
        }
    }

    public final void w(RecyclerView.Recycler recycler, int i2) {
        View viewForPosition = recycler.getViewForPosition(i2);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(position)");
        BaseEpoxyAdapter baseEpoxyAdapter = this.f2333a;
        if (baseEpoxyAdapter != null) {
            baseEpoxyAdapter.E(viewForPosition);
        }
        addView(viewForPosition);
        E(viewForPosition);
        ignoreView(viewForPosition);
        this.f = viewForPosition;
        this.g = i2;
    }

    public final int x(int i2) {
        int size = this.d.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            if (((Number) this.d.get(i4)).intValue() > i2) {
                size = i4 - 1;
            } else if (((Number) this.d.get(i4)).intValue() >= i2) {
                return i4;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public final int y(int i2) {
        int size = this.d.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            if (((Number) this.d.get(i4)).intValue() > i2) {
                size = i4 - 1;
            } else {
                if (i4 < this.d.size() - 1) {
                    int i5 = i4 + 1;
                    if (((Number) this.d.get(i5)).intValue() <= i2) {
                        i3 = i5;
                    }
                }
                return i4;
            }
        }
        return -1;
    }

    public final int z(int i2) {
        int size = this.d.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            if (i4 > 0) {
                int i5 = i4 - 1;
                if (((Number) this.d.get(i5)).intValue() >= i2) {
                    size = i5;
                }
            }
            if (((Number) this.d.get(i4)).intValue() >= i2) {
                return i4;
            }
            i3 = i4 + 1;
        }
        return -1;
    }
}
