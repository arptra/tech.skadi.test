package com.upuphone.ar.tici.phone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.t4.a;
import com.honey.account.t4.b;
import com.honey.account.t4.c;
import com.upuphone.ar.tici.databinding.TiciScreenLocationViewBinding;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002%&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "position", "", "n", "(I)V", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;", "location", "m", "(Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;)V", "Lcom/upuphone/ar/tici/databinding/TiciScreenLocationViewBinding;", "a", "Lcom/upuphone/ar/tici/databinding/TiciScreenLocationViewBinding;", "binding", "", "Landroid/view/View;", "b", "Ljava/util/List;", "btnList", "c", "textList", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;", "d", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;", "getItemClickListener", "()Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;", "setItemClickListener", "(Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;)V", "itemClickListener", "ItemClickListener", "Location", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciScreenLocationView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciScreenLocationView.kt\ncom/upuphone/ar/tici/phone/widget/TiciScreenLocationView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1864#2,3:80\n1864#2,3:83\n*S KotlinDebug\n*F\n+ 1 TiciScreenLocationView.kt\ncom/upuphone/ar/tici/phone/widget/TiciScreenLocationView\n*L\n68#1:80,3\n71#1:83,3\n*E\n"})
public final class TiciScreenLocationView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public final TiciScreenLocationViewBinding f6006a;
    public final List b;
    public final List c;
    public ItemClickListener d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;", "", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;", "location", "", "a", "(Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;)V", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public interface ItemClickListener {
        void a(Location location);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Bottom", "Middle", "Top", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Location {
        Bottom(0),
        Middle(1),
        Top(2);
        
        private final int value;

        static {
            Location[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private Location(int i) {
            this.value = i;
        }

        @NotNull
        public static EnumEntries<Location> getEntries() {
            return $ENTRIES;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciScreenLocationView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void j(TiciScreenLocationView ticiScreenLocationView, View view) {
        Intrinsics.checkNotNullParameter(ticiScreenLocationView, "this$0");
        ticiScreenLocationView.m(Location.Bottom);
    }

    public static final void k(TiciScreenLocationView ticiScreenLocationView, View view) {
        Intrinsics.checkNotNullParameter(ticiScreenLocationView, "this$0");
        ticiScreenLocationView.m(Location.Middle);
    }

    public static final void l(TiciScreenLocationView ticiScreenLocationView, View view) {
        Intrinsics.checkNotNullParameter(ticiScreenLocationView, "this$0");
        ticiScreenLocationView.m(Location.Top);
    }

    @Nullable
    public final ItemClickListener getItemClickListener() {
        return this.d;
    }

    public final void m(Location location) {
        ItemClickListener itemClickListener = this.d;
        if (itemClickListener != null) {
            itemClickListener.a(location);
        }
    }

    public final void n(int i) {
        Iterator it = this.b.iterator();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) next;
            if (i2 != i) {
                z = false;
            }
            view.setSelected(z);
            i2 = i3;
        }
        int i4 = 0;
        for (Object next2 : this.c) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((View) next2).setSelected(i4 == i);
            i4 = i5;
        }
    }

    public final void setItemClickListener(@Nullable ItemClickListener itemClickListener) {
        this.d = itemClickListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciScreenLocationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TiciScreenLocationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciScreenLocationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        TiciScreenLocationViewBinding b2 = TiciScreenLocationViewBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b2, "inflate(...)");
        this.f6006a = b2;
        ImageView imageView = b2.b;
        Intrinsics.checkNotNull(imageView);
        arrayList.add(imageView);
        ViewExtKt.b(imageView, new a(this));
        ImageView imageView2 = b2.c;
        Intrinsics.checkNotNull(imageView2);
        arrayList.add(imageView2);
        ViewExtKt.b(imageView2, new b(this));
        ImageView imageView3 = b2.d;
        Intrinsics.checkNotNull(imageView3);
        arrayList.add(imageView3);
        ViewExtKt.b(imageView3, new c(this));
        TextView textView = b2.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvScreenLocationBottom");
        arrayList2.add(textView);
        TextView textView2 = b2.g;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvScreenLocationMiddle");
        arrayList2.add(textView2);
        TextView textView3 = b2.h;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvScreenLocationTop");
        arrayList2.add(textView3);
    }
}
