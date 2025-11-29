package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public VectorDrawableCompatState b;
    public PorterDuffColorFilter c;
    public ColorFilter d;
    public boolean e;
    public boolean f;
    public Drawable.ConstantState g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1902a = PathParser.d(string2);
            }
            this.c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.p(xmlPullParser, "pathData")) {
                TypedArray q = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.d);
                f(q, xmlPullParser);
                q.recycle();
            }
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    public static abstract class VObject {
        public VObject() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f1904a;
        public VPathRenderer b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.c = null;
            this.d = VectorDrawableCompat.k;
            if (vectorDrawableCompatState != null) {
                this.f1904a = vectorDrawableCompatState.f1904a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.b);
                this.b = vPathRenderer;
                if (vectorDrawableCompatState.b.e != null) {
                    vPathRenderer.e = new Paint(vectorDrawableCompatState.b.e);
                }
                if (vectorDrawableCompatState.b.d != null) {
                    this.b.d = new Paint(vectorDrawableCompatState.b.d);
                }
                this.c = vectorDrawableCompatState.c;
                this.d = vectorDrawableCompatState.d;
                this.e = vectorDrawableCompatState.e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f.getWidth() && i3 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f == null || !a(i2, i3)) {
                this.f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean f() {
            return this.b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.b.f();
        }

        public int getChangingConfigurations() {
            return this.f1904a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.b.g(iArr);
            this.k |= g2;
            return g2;
        }

        public void i() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public void j(int i2, int i3) {
            this.f.eraseColor(0);
            this.b.b(new Canvas(this.f), i2, i3, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.c = null;
            this.d = VectorDrawableCompat.k;
            this.b = new VPathRenderer();
        }
    }

    public VectorDrawableCompat() {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.b = new VectorDrawableCompatState();
    }

    public static int a(int i2, float f2) {
        return (i2 & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    public static VectorDrawableCompat b(Resources resources, int i2, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f1900a = ResourcesCompat.f(resources, i2, theme);
        vectorDrawableCompat.g = new VectorDrawableDelegateState(vectorDrawableCompat.f1900a.getConstantState());
        return vectorDrawableCompat;
    }

    public static VectorDrawableCompat c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    public static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1900a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public Object d(String str) {
        return this.b.b.p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() > 0 && this.j.height() > 0) {
            ColorFilter colorFilter = this.d;
            if (colorFilter == null) {
                colorFilter = this.c;
            }
            canvas.getMatrix(this.i);
            this.i.getValues(this.h);
            float abs = Math.abs(this.h[0]);
            float abs2 = Math.abs(this.h[4]);
            float abs3 = Math.abs(this.h[1]);
            float abs4 = Math.abs(this.h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.j.offsetTo(0, 0);
                this.b.c(min, min2);
                if (!this.f) {
                    this.b.j(min, min2);
                } else if (!this.b.b()) {
                    this.b.j(min, min2);
                    this.b.i();
                }
                this.b.d(canvas, colorFilter, this.j);
                canvas.restoreToCount(save);
            }
        }
    }

    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.g(resources, attributeSet, theme, xmlPullParser);
                    vGroup.b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.p.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f1904a = vFullPath.d | vectorDrawableCompatState.f1904a;
                    z = false;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.e(resources, attributeSet, theme, xmlPullParser);
                    vGroup.b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.p.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f1904a = vClipPath.d | vectorDrawableCompatState.f1904a;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                    vGroup.b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.p.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f1904a = vGroup2.k | vectorDrawableCompatState.f1904a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        return isAutoMirrored() && DrawableCompat.f(this) == 1;
    }

    public int getAlpha() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.d(drawable) : this.b.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.e(drawable) : this.d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f1900a != null) {
            return new VectorDrawableDelegateState(this.f1900a.getConstantState());
        }
        this.b.f1904a = getChangingConfigurations();
        return this.b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.b.b.j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.b.b.i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void h(boolean z) {
        this.f = z;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
        vectorDrawableCompatState.d = g(TypedArrayUtils.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g2 = TypedArrayUtils.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g2 != null) {
            vectorDrawableCompatState.c = g2;
        }
        vectorDrawableCompatState.e = TypedArrayUtils.e(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.e);
        vPathRenderer.k = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.k);
        float j2 = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.l);
        vPathRenderer.l = j2;
        if (vPathRenderer.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (j2 > 0.0f) {
            vPathRenderer.i = typedArray.getDimension(3, vPathRenderer.i);
            float dimension = typedArray.getDimension(2, vPathRenderer.j);
            vPathRenderer.j = dimension;
            if (vPathRenderer.i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.j(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.n = string;
                    vPathRenderer.p.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.h(drawable) : this.b.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r1 = r1.b.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f1900a
            if (r0 == 0) goto L_0x0009
            boolean r1 = r0.isStateful()
            return r1
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r1 = r1.b
            android.content.res.ColorStateList r1 = r1.c
            if (r1 == 0) goto L_0x0026
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 0
            goto L_0x0029
        L_0x0028:
            r1 = 1
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.b = new VectorDrawableCompatState(this.b);
            this.e = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        ColorStateList colorStateList = vectorDrawableCompatState.c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.d) == null) {
            z = false;
        } else {
            this.c = j(this.c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!vectorDrawableCompatState.g() || !vectorDrawableCompatState.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.b.b.getRootAlpha() != i2) {
            this.b.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.j(drawable, z);
        } else {
            this.b.e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState.c != colorStateList) {
            vectorDrawableCompatState.c = colorStateList;
            this.c = j(this.c, colorStateList, vectorDrawableCompatState.d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState.d != mode) {
            vectorDrawableCompatState.d = mode;
            this.c = j(this.c, vectorDrawableCompatState.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f1905a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f1905a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1905a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1905a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1900a = (VectorDrawable) this.f1905a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1900a = (VectorDrawable) this.f1905a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1900a = (VectorDrawable) this.f1905a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.d = colorFilter;
        invalidateSelf();
    }

    public static abstract class VPath extends VObject {

        /* renamed from: a  reason: collision with root package name */
        public PathParser.PathDataNode[] f1902a = null;
        public String b;
        public int c = 0;
        public int d;

        public VPath() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f1902a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.i(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f1902a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.b(this.f1902a, pathDataNodeArr)) {
                this.f1902a = PathParser.f(pathDataNodeArr);
            } else {
                PathParser.k(this.f1902a, pathDataNodeArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.b = vPath.b;
            this.d = vPath.d;
            this.f1902a = PathParser.f(vPath.f1902a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        vectorDrawableCompatState.b = new VPathRenderer();
        TypedArray q = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f1891a);
        i(q, xmlPullParser, theme);
        q.recycle();
        vectorDrawableCompatState.f1904a = getChangingConfigurations();
        vectorDrawableCompatState.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.c = j(this.c, vectorDrawableCompatState.c, vectorDrawableCompatState.d);
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.b = vectorDrawableCompatState;
        this.c = j(this.c, vectorDrawableCompatState.c, vectorDrawableCompatState.d);
    }

    public static class VFullPath extends VPath {
        public int[] e;
        public ComplexColorCompat f;
        public float g = 0.0f;
        public ComplexColorCompat h;
        public float i = 1.0f;
        public float j = 1.0f;
        public float k = 0.0f;
        public float l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public VFullPath() {
        }

        public boolean a() {
            return this.h.i() || this.f.i();
        }

        public boolean b(int[] iArr) {
            return this.f.j(iArr) | this.h.j(iArr);
        }

        public final Paint.Cap e(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public final Paint.Join f(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray q = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.c);
            h(q, xmlPullParser, theme);
            q.recycle();
        }

        public float getFillAlpha() {
            return this.j;
        }

        @ColorInt
        public int getFillColor() {
            return this.h.e();
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        @ColorInt
        public int getStrokeColor() {
            return this.f.e();
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.e = null;
            if (TypedArrayUtils.p(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f1902a = PathParser.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.h = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.j = TypedArrayUtils.j(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.i = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
                this.g = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
                this.l = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 13, this.c);
            }
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.h.k(i2);
        }

        public void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f.k(i2);
        }

        public void setStrokeWidth(float f2) {
            this.g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.e = vFullPath.e;
            this.f = vFullPath.f;
            this.g = vFullPath.g;
            this.i = vFullPath.i;
            this.h = vFullPath.h;
            this.c = vFullPath.c;
            this.j = vFullPath.j;
            this.k = vFullPath.k;
            this.l = vFullPath.l;
            this.m = vFullPath.m;
            this.n = vFullPath.n;
            this.o = vFullPath.o;
            this.p = vFullPath.p;
        }
    }

    public static class VPathRenderer {
        public static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f1903a;
        public final Path b;
        public final Matrix c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public int g;
        public final VGroup h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final ArrayMap p;

        public VPathRenderer() {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new ArrayMap();
            this.h = new VGroup();
            this.f1903a = new Path();
            this.b = new Path();
        }

        public static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.h, q, canvas, i2, i3, colorFilter);
        }

        public final void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            vGroup.f1901a.set(matrix);
            vGroup.f1901a.preConcat(vGroup.j);
            canvas.save();
            for (int i4 = 0; i4 < vGroup.b.size(); i4++) {
                VObject vObject = (VObject) vGroup.b.get(i4);
                if (vObject instanceof VGroup) {
                    c((VGroup) vObject, vGroup.f1901a, canvas, i2, i3, colorFilter);
                } else if (vObject instanceof VPath) {
                    d(vGroup, (VPath) vObject, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(VGroup vGroup, VPath vPath, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.k;
            float f3 = ((float) i3) / this.l;
            float min = Math.min(f2, f3);
            Matrix matrix = vGroup.f1901a;
            this.c.set(matrix);
            this.c.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 != 0.0f) {
                vPath.d(this.f1903a);
                Path path = this.f1903a;
                this.b.reset();
                if (vPath.c()) {
                    this.b.setFillType(vPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.b.addPath(path, this.c);
                    canvas.clipPath(this.b);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                float f4 = vFullPath.k;
                if (!(f4 == 0.0f && vFullPath.l == 1.0f)) {
                    float f5 = vFullPath.m;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (vFullPath.l + f5) % 1.0f;
                    if (this.f == null) {
                        this.f = new PathMeasure();
                    }
                    this.f.setPath(this.f1903a, false);
                    float length = this.f.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.f.getSegment(f8, length, path, true);
                        this.f.getSegment(0.0f, f9, path, true);
                    } else {
                        this.f.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.b.addPath(path, this.c);
                if (vFullPath.h.l()) {
                    ComplexColorCompat complexColorCompat = vFullPath.h;
                    if (this.e == null) {
                        Paint paint = new Paint(1);
                        this.e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.e;
                    if (complexColorCompat.h()) {
                        Shader f10 = complexColorCompat.f();
                        f10.setLocalMatrix(this.c);
                        paint2.setShader(f10);
                        paint2.setAlpha(Math.round(vFullPath.j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.a(complexColorCompat.e(), vFullPath.j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.b.setFillType(vFullPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.b, paint2);
                }
                if (vFullPath.f.l()) {
                    ComplexColorCompat complexColorCompat2 = vFullPath.f;
                    if (this.d == null) {
                        Paint paint3 = new Paint(1);
                        this.d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.d;
                    Paint.Join join = vFullPath.o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = vFullPath.n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(vFullPath.p);
                    if (complexColorCompat2.h()) {
                        Shader f11 = complexColorCompat2.f();
                        f11.setLocalMatrix(this.c);
                        paint4.setShader(f11);
                        paint4.setAlpha(Math.round(vFullPath.i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.e(), vFullPath.i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(vFullPath.g * min * e2);
                    canvas.drawPath(this.b, paint4);
                }
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            ArrayMap arrayMap = new ArrayMap();
            this.p = arrayMap;
            this.h = new VGroup(vPathRenderer.h, arrayMap);
            this.f1903a = new Path(vPathRenderer.f1903a);
            this.b = new Path(vPathRenderer.b);
            this.i = vPathRenderer.i;
            this.j = vPathRenderer.j;
            this.k = vPathRenderer.k;
            this.l = vPathRenderer.l;
            this.g = vPathRenderer.g;
            this.m = vPathRenderer.m;
            this.n = vPathRenderer.n;
            String str = vPathRenderer.n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.o = vPathRenderer.o;
        }
    }

    public static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f1901a;
        public final ArrayList b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public VGroup(VGroup vGroup, ArrayMap arrayMap) {
            super();
            VPath vPath;
            this.f1901a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = vGroup.c;
            this.d = vGroup.d;
            this.e = vGroup.e;
            this.f = vGroup.f;
            this.g = vGroup.g;
            this.h = vGroup.h;
            this.i = vGroup.i;
            this.l = vGroup.l;
            String str = vGroup.m;
            this.m = str;
            this.k = vGroup.k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.j);
            ArrayList arrayList = vGroup.b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof VGroup) {
                    this.b.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) obj);
                    } else if (obj instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(vPath);
                    String str2 = vPath.b;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (((VObject) this.b.get(i2)).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= ((VObject) this.b.get(i2)).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray q = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.b);
            e(q, xmlPullParser);
            q.recycle();
        }

        public final void d() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = TypedArrayUtils.j(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = TypedArrayUtils.j(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = TypedArrayUtils.j(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                d();
            }
        }

        public VGroup() {
            super();
            this.f1901a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
