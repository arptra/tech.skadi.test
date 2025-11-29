package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.R;
import com.meizu.common.util.SmoothCornerPathGenerator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 N2\u00020\u0001:\u0002NOB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0014J(\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J\b\u0010K\u001a\u00020AH\u0002J\u0012\u0010L\u001a\u00020A2\b\b\u0002\u0010M\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001c@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u0017R$\u0010#\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u0017R&\u0010'\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020&8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R$\u0010/\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u0017R$\u00102\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u0017R\u001e\u0010>\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b?\u0010\u0017¨\u0006P"}, d2 = {"Lcom/meizu/common/widget/SmoothCornerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "defaultClipToOutline", "", "defaultOutlineProvider", "Landroid/view/ViewOutlineProvider;", "value", "exactMode", "getExactMode", "()Z", "setExactMode", "(Z)V", "", "heightFloat", "setHeightFloat", "(F)V", "maxSmoothRadius", "getMaxSmoothRadius", "()F", "needRegenPath", "Landroid/graphics/Path;", "path", "setPath", "(Landroid/graphics/Path;)V", "radius", "getRadius", "setRadius", "radiusDp", "getRadiusDp", "setRadiusDp", "Lcom/meizu/common/widget/SmoothCornerView$SmoothGenMode;", "renderMode", "getRenderMode", "()Lcom/meizu/common/widget/SmoothCornerView$SmoothGenMode;", "setRenderMode", "(Lcom/meizu/common/widget/SmoothCornerView$SmoothGenMode;)V", "smoothCornerEnable", "getSmoothCornerEnable", "setSmoothCornerEnable", "smoothness", "getSmoothness", "setSmoothness", "strokeColor", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokePaint", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "strokeWidthExt", "getStrokeWidthExt", "setStrokeWidthExt", "widthFloat", "setWidthFloat", "adjustPathFillType", "", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "refreshSmoothCorner", "trySmoothPath", "force", "Companion", "SmoothGenMode", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SmoothCornerView extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean defaultClipToOutline;
    @Nullable
    private final ViewOutlineProvider defaultOutlineProvider;
    private float heightFloat;
    private boolean needRegenPath;
    /* access modifiers changed from: private */
    @NotNull
    public Path path;
    private float radius;
    @NotNull
    private SmoothGenMode renderMode;
    private boolean smoothCornerEnable;
    private float smoothness;
    private int strokeColor;
    @NotNull
    private final Paint strokePaint;
    private float strokeWidthExt;
    private float widthFloat;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004J\u001c\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/meizu/common/widget/SmoothCornerView$Companion;", "", "()V", "density", "", "Landroid/content/Context;", "getDensity", "(Landroid/content/Context;)F", "dp2PxFloat", "dpValue", "px2Dp", "pxValue", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ float dp2PxFloat$default(Companion companion, Context context, float f, float f2, int i, Object obj) {
            if ((i & 2) != 0) {
                f2 = companion.getDensity(context);
            }
            return companion.dp2PxFloat(context, f, f2);
        }

        public static /* synthetic */ float px2Dp$default(Companion companion, Context context, float f, float f2, int i, Object obj) {
            if ((i & 2) != 0) {
                f2 = companion.getDensity(context);
            }
            return companion.px2Dp(context, f, f2);
        }

        public final float dp2PxFloat(@NotNull Context context, float f, float f2) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            return f * f2;
        }

        public final float getDensity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            return context.getResources().getDisplayMetrics().density;
        }

        public final float px2Dp(@NotNull Context context, float f, float f2) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            return f / f2;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/meizu/common/widget/SmoothCornerView$SmoothGenMode;", "", "(Ljava/lang/String;I)V", "ClipPath", "ClearPixel", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum SmoothGenMode {
        ClipPath,
        ClearPixel
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.meizu.common.widget.SmoothCornerView$SmoothGenMode[] r0 = com.meizu.common.widget.SmoothCornerView.SmoothGenMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.meizu.common.widget.SmoothCornerView$SmoothGenMode r1 = com.meizu.common.widget.SmoothCornerView.SmoothGenMode.ClipPath     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.meizu.common.widget.SmoothCornerView$SmoothGenMode r1 = com.meizu.common.widget.SmoothCornerView.SmoothGenMode.ClearPixel     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.SmoothCornerView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCornerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void adjustPathFillType() {
        int i = WhenMappings.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i == 1) {
            this.path.setFillType(Path.FillType.WINDING);
        } else if (i == 2) {
            this.path.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    private final void refreshSmoothCorner() {
        int i = WhenMappings.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i == 1) {
            invalidateOutline();
        } else if (i == 2) {
            invalidate();
        }
    }

    private final void setHeightFloat(float f) {
        if (this.heightFloat != f) {
            this.heightFloat = f;
            this.needRegenPath = true;
        }
    }

    private final void setPath(Path path2) {
        this.path = path2;
        adjustPathFillType();
    }

    private final void setWidthFloat(float f) {
        if (this.widthFloat != f) {
            this.widthFloat = f;
            this.needRegenPath = true;
        }
    }

    private final void trySmoothPath(boolean z) {
        if (this.needRegenPath || z) {
            setPath(SmoothCornerPathGenerator.genSmoothCornerPath$default(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false, 64, (Object) null));
            this.needRegenPath = false;
        }
    }

    public static /* synthetic */ void trySmoothPath$default(SmoothCornerView smoothCornerView, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            smoothCornerView.trySmoothPath(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trySmoothPath");
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == SmoothGenMode.ClearPixel) {
            trySmoothPath$default(this, false, 1, (Object) null);
            canvas.drawPath(this.path, SmoothCornerPathGenerator.INSTANCE.getClearBitmapPaint());
        }
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    public final float getMaxSmoothRadius() {
        return SmoothCornerPathGenerator.INSTANCE.getSmoothnessRadiusLimit(this.widthFloat, this.heightFloat, this.smoothness);
    }

    public final float getRadius() {
        return RangesKt.coerceIn(this.radius, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Companion companion = Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return Companion.px2Dp$default(companion, context, getRadius(), 0.0f, 2, (Object) null);
    }

    @NotNull
    public final SmoothGenMode getRenderMode() {
        return this.strokePaint.getStrokeWidth() > ((float) 0) ? SmoothGenMode.ClearPixel : this.renderMode;
    }

    public final boolean getSmoothCornerEnable() {
        return this.smoothCornerEnable;
    }

    public final float getSmoothness() {
        return this.smoothness;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    @NotNull
    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
        float f = (float) 2;
        Path genSmoothCornerPath$default = SmoothCornerPathGenerator.genSmoothCornerPath$default((this.strokePaint.getStrokeWidth() / f) + 0.0f, (this.strokePaint.getStrokeWidth() / f) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f), this.heightFloat - (this.strokePaint.getStrokeWidth() / f), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f), false, 64, (Object) null);
        genSmoothCornerPath$default.setFillType(Path.FillType.WINDING);
        canvas.drawPath(genSmoothCornerPath$default, this.strokePaint);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setWidthFloat((float) i);
        setHeightFloat((float) i2);
        if (getRenderMode() == SmoothGenMode.ClearPixel) {
            trySmoothPath$default(this, false, 1, (Object) null);
        }
    }

    public final void setExactMode(boolean z) {
        if (z) {
            setLayerType(2, (Paint) null);
        } else {
            setLayerType(0, (Paint) null);
        }
    }

    public final void setRadius(float f) {
        if (f != this.radius) {
            this.needRegenPath = true;
            this.radius = f;
            refreshSmoothCorner();
        }
    }

    public final void setRadiusDp(float f) {
        Companion companion = Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setRadius(Companion.dp2PxFloat$default(companion, context, f, 0.0f, 2, (Object) null));
    }

    public final void setRenderMode(@NotNull SmoothGenMode smoothGenMode) {
        Intrinsics.checkNotNullParameter(smoothGenMode, AccountConstantKt.RESPONSE_VALUE);
        this.renderMode = smoothGenMode;
        int i = WhenMappings.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i == 1) {
            setClipToOutline(true);
            setOutlineProvider(new SmoothCornerView$renderMode$1(this));
        } else if (i == 2) {
            setWillNotDraw(false);
            setClipToOutline(this.defaultClipToOutline);
            setOutlineProvider(this.defaultOutlineProvider);
        }
        adjustPathFillType();
        trySmoothPath(true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z) {
        if (this.smoothCornerEnable != z) {
            this.smoothCornerEnable = z;
            this.needRegenPath = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f) {
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        if (coerceIn != this.smoothness) {
            this.needRegenPath = true;
            this.smoothness = coerceIn;
            refreshSmoothCorner();
        }
    }

    public final void setStrokeColor(int i) {
        if (i != this.strokeColor) {
            this.strokeColor = i;
            this.strokePaint.setColor(i);
            refreshSmoothCorner();
        }
    }

    public final void setStrokeWidthExt(float f) {
        if (f != this.strokeWidthExt) {
            this.strokeWidthExt = f;
            this.strokePaint.setStrokeWidth(f);
            refreshSmoothCorner();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCornerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCornerView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmoothCornerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCornerView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.smoothCornerEnable = true;
        SmoothGenMode smoothGenMode = SmoothGenMode.ClearPixel;
        this.renderMode = smoothGenMode;
        this.defaultOutlineProvider = getOutlineProvider();
        this.defaultClipToOutline = getClipToOutline();
        this.smoothness = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothCornerView, i, i2).getFloat(R.styleable.SmoothCornerView_mzCornerSmoothness, 0.2f);
        this.radius = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothCornerView, i, i2).getDimension(R.styleable.SmoothCornerView_mzCornerRadius, getResources().getDimension(R.dimen.fd_sys_radius_corner_none));
        this.strokeWidthExt = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothCornerView, i, i2).getDimension(R.styleable.SmoothCornerView_mzCornerStrokeWidth, 0.0f);
        this.strokeColor = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothCornerView, i, i2).getColor(R.styleable.SmoothCornerView_mzCornerStrokeColor, getResources().getColor(R.color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.strokeWidthExt);
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
        setRenderMode(Build.VERSION.SDK_INT >= 30 ? SmoothGenMode.ClipPath : smoothGenMode);
        setExactMode(true);
    }
}
