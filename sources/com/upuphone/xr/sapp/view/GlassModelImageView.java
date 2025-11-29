package com.upuphone.xr.sapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.glass.GlassHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005*\u0001 \b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/view/GlassModelImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "b", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "Landroid/graphics/drawable/Drawable;", "a", "Lkotlin/Lazy;", "getStarGlassImage", "()Landroid/graphics/drawable/Drawable;", "starGlassImage", "getConceptGlassImage", "conceptGlassImage", "c", "getAirGlassImage", "airGlassImage", "d", "getAirProGlassImage", "airProGlassImage", "com/upuphone/xr/sapp/view/GlassModelImageView$deviceConnectListener$1", "e", "Lcom/upuphone/xr/sapp/view/GlassModelImageView$deviceConnectListener$1;", "deviceConnectListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"AppCompatCustomView"})
public final class GlassModelImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f7972a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final GlassModelImageView$deviceConnectListener$1 e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlassModelImageView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable getAirGlassImage() {
        return (Drawable) this.c.getValue();
    }

    private final Drawable getAirProGlassImage() {
        return (Drawable) this.d.getValue();
    }

    private final Drawable getConceptGlassImage() {
        return (Drawable) this.b.getValue();
    }

    private final Drawable getStarGlassImage() {
        return (Drawable) this.f7972a.getValue();
    }

    public final void b(StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null) {
            GlassHelper glassHelper = GlassHelper.f7049a;
            if (glassHelper.D(starryNetDevice)) {
                setImageDrawable(getConceptGlassImage());
            } else if (glassHelper.F(starryNetDevice)) {
                setImageDrawable(getStarGlassImage());
            } else if (AirHelper.b.K(starryNetDevice)) {
                setImageDrawable(getAirProGlassImage());
            } else {
                setImageDrawable(getAirGlassImage());
            }
        } else {
            setImageDrawable(getAirGlassImage());
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GlassHelper.f7049a.l(this.e);
    }

    public void onDetachedFromWindow() {
        GlassHelper.f7049a.H(this.e);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlassModelImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassModelImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlassModelImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7972a = LazyKt.lazy(new GlassModelImageView$starGlassImage$2(context));
        this.b = LazyKt.lazy(new GlassModelImageView$conceptGlassImage$2(context));
        this.c = LazyKt.lazy(new GlassModelImageView$airGlassImage$2(context));
        this.d = LazyKt.lazy(new GlassModelImageView$airProGlassImage$2(context));
        this.e = new GlassModelImageView$deviceConnectListener$1(this);
        b(GlassHelper.f7049a.x());
    }
}
