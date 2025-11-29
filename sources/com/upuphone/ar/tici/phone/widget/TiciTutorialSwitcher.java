package com.upuphone.ar.tici.phone.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciTutorialTextBinding;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010'R\u0014\u0010(\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010)¨\u0006,"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "getNextView", "", "f", "()V", "", "isVisible", "onVisibilityAggregated", "(Z)V", "e", "g", "Landroid/widget/TextView;", "textView", "d", "(Landroid/widget/TextView;)V", "Landroid/view/animation/Animation;", "a", "Lkotlin/Lazy;", "getAnimShow", "()Landroid/view/animation/Animation;", "animShow", "b", "getAnimHide", "animHide", "c", "I", "currentIndex", "Landroid/widget/TextView;", "textView2", "Z", "isHighlighted", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciTutorialSwitcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciTutorialSwitcher.kt\ncom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,159:1\n283#2,2:160\n262#2,2:162\n262#2,2:164\n*S KotlinDebug\n*F\n+ 1 TiciTutorialSwitcher.kt\ncom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher\n*L\n64#1:160,2\n138#1:162,2\n147#1:164,2\n*E\n"})
public final class TiciTutorialSwitcher extends FrameLayout {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6009a;
    public final Lazy b;
    public int c;
    public final TextView d;
    public final TextView e;
    public boolean f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTutorialSwitcher(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Animation getAnimHide() {
        Object value = this.b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getAnimShow() {
        Object value = this.f6009a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final View getCurrentView() {
        int childCount = this.c % getChildCount();
        this.c = childCount;
        View childAt = getChildAt(childCount);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        return childAt;
    }

    private final View getNextView() {
        int i = this.c + 1;
        this.c = i;
        int childCount = i % getChildCount();
        this.c = childCount;
        View childAt = getChildAt(childCount);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        return childAt;
    }

    public final void d(TextView textView) {
        try {
            int lineStart = textView.getLayout().getLineStart(1);
            int lineEnd = textView.getLayout().getLineEnd(3);
            SpannableString spannableString = new SpannableString(textView.getText().toString());
            spannableString.setSpan(new TextAppearanceSpan(textView.getContext(), R.style.TiciTutorialHighlight), lineStart, lineEnd, 18);
            textView.setText(spannableString);
            this.f = true;
        } catch (Exception e2) {
            this.f = false;
            CommonExtKt.d("highlightText, error: " + e2, "TiciTutorialSwitcher", (Throwable) null, 2, (Object) null);
        }
    }

    public final void e() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new TiciTutorialSwitcher$loadDefaultContent$1(this, (Continuation<? super TiciTutorialSwitcher$loadDefaultContent$1>) null), 3, (Object) null);
    }

    public final void f() {
        View currentView = getCurrentView();
        currentView.setVisibility(0);
        getAnimHide().setAnimationListener(new TiciTutorialSwitcher$showNext$1$1(currentView));
        currentView.startAnimation(getAnimHide());
        View nextView = getNextView();
        nextView.setVisibility(0);
        nextView.startAnimation(getAnimShow());
    }

    public final void g() {
        try {
            CommonExtKt.b("splitTextContent", "TiciTutorialSwitcher");
            int lineStart = this.d.getLayout().getLineStart(3);
            String obj = this.d.getText().toString();
            d(this.d);
            TextView textView = this.e;
            String substring = obj.substring(lineStart);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            textView.setText(substring);
            d(this.e);
            this.f = true;
        } catch (Exception e2) {
            this.f = false;
            CommonExtKt.d("splitTextContent, error: " + e2, "TiciTutorialSwitcher", (Throwable) null, 2, (Object) null);
        }
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        CommonExtKt.b("onVisibilityAggregated, isVisible: " + z, "TiciTutorialSwitcher");
        if (z && !this.f) {
            e();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTutorialSwitcher(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TiciTutorialSwitcher(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTutorialSwitcher(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6009a = LazyKt.lazy(new TiciTutorialSwitcher$animShow$2(context));
        this.b = LazyKt.lazy(new TiciTutorialSwitcher$animHide$2(context));
        TiciTutorialTextBinding c2 = TiciTutorialTextBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        TiciTutorialTextBinding c3 = TiciTutorialTextBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c3, "inflate(...)");
        TextView b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        this.d = b2;
        TextView b3 = c3.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        this.e = b3;
        b3.setVisibility(4);
    }
}
