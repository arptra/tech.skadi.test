package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public class MotionLabel extends View implements FloatLayout {
    public static String V = "MotionLabel";
    public float A;
    public float B;
    public float C;
    public Drawable D;
    public Matrix E;
    public Bitmap F;
    public BitmapShader G;
    public Matrix H;
    public float I = Float.NaN;
    public float J = Float.NaN;
    public float K = 0.0f;
    public float L = 0.0f;
    public Paint M = new Paint();
    public int N = 0;
    public Rect O;
    public Paint P;
    public float Q;
    public float R = Float.NaN;
    public float S = Float.NaN;
    public float T = Float.NaN;
    public float U = Float.NaN;

    /* renamed from: a  reason: collision with root package name */
    public TextPaint f596a = new TextPaint();
    public Path b = new Path();
    public int c = 65535;
    public int d = 65535;
    public boolean e = false;
    public float f = 0.0f;
    public float g = Float.NaN;
    public ViewOutlineProvider h;
    public RectF i;
    public float j = 48.0f;
    public float k = Float.NaN;
    public int l;
    public int m;
    public float n = 0.0f;
    public String o = "Hello World";
    public boolean p = true;
    public Rect q = new Rect();
    public int r = 1;
    public int s = 1;
    public int t = 1;
    public int u = 1;
    public String v;
    public Layout w;
    public int x = 8388659;
    public int y = 0;
    public boolean z = false;

    public MotionLabel(Context context) {
        super(context);
        g(context, (AttributeSet) null);
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        TextPaint textPaint = this.f596a;
        String str = this.o;
        return (((((Float.isNaN(this.B) ? (float) getMeasuredWidth() : this.B) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - (f2 * textPaint.measureText(str, 0, str.length()))) * (this.K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        Paint.FontMetrics fontMetrics = this.f596a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.C) ? (float) getMeasuredHeight() : this.C) - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        return (((measuredHeight - ((f3 - f4) * f2)) * (1.0f - this.L)) / 2.0f) - (f2 * f4);
    }

    public void a(float f2, float f3, float f4, float f5) {
        int i2 = (int) (f2 + 0.5f);
        this.A = f2 - ((float) i2);
        int i3 = (int) (f4 + 0.5f);
        int i4 = i3 - i2;
        int i5 = (int) (f5 + 0.5f);
        int i6 = (int) (0.5f + f3);
        int i7 = i5 - i6;
        float f6 = f4 - f2;
        this.B = f6;
        float f7 = f5 - f3;
        this.C = f7;
        d(f2, f3, f4, f5);
        if (getMeasuredHeight() == i7 && getMeasuredWidth() == i4) {
            super.layout(i2, i6, i3, i5);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
            super.layout(i2, i6, i3, i5);
        }
        if (this.z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f596a);
                this.Q = this.P.getTextSize();
            }
            this.B = f6;
            this.C = f7;
            Paint paint = this.P;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            float height = ((float) this.O.height()) * 1.3f;
            float f8 = (f6 - ((float) this.s)) - ((float) this.r);
            float f9 = (f7 - ((float) this.u)) - ((float) this.t);
            float f10 = (float) width;
            if (f10 * f9 > height * f8) {
                this.f596a.setTextSize((this.Q * f8) / f10);
            } else {
                this.f596a.setTextSize((this.Q * f9) / height);
            }
            if (this.e || !Float.isNaN(this.k)) {
                f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
            }
        }
    }

    public final void d(float f2, float f3, float f4, float f5) {
        if (this.H != null) {
            this.B = f4 - f2;
            this.C = f5 - f3;
            l();
        }
    }

    public Bitmap e(Bitmap bitmap, int i2) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i3 = 0; i3 < i2 && width >= 32 && height >= 32; i3++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    public void f(float f2) {
        if (this.e || f2 != 1.0f) {
            this.b.reset();
            String str = this.o;
            int length = str.length();
            this.f596a.getTextBounds(str, 0, length, this.q);
            this.f596a.getTextPath(str, 0, length, 0.0f, 0.0f, this.b);
            if (f2 != 1.0f) {
                Log.v(V, Debug.a() + " scale " + f2);
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.b.transform(matrix);
            }
            Rect rect = this.q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.p = false;
        }
    }

    public final void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.v = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.k = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.k);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.j = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.j);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.l = obtainStyledAttributes.getInt(index, this.l);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.m = obtainStyledAttributes.getInt(index, this.m);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.c = obtainStyledAttributes.getColor(index, this.c);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.g);
                    this.g = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.f);
                    this.f = f2;
                    setRoundPercent(f2);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.y = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.d = obtainStyledAttributes.getInt(index, this.d);
                    this.e = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.n = obtainStyledAttributes.getDimension(index, this.n);
                    this.e = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.D = obtainStyledAttributes.getDrawable(index);
                    this.e = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.R = obtainStyledAttributes.getFloat(index, this.R);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.K = obtainStyledAttributes.getFloat(index, this.K);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.L = obtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.I = obtainStyledAttributes.getDimension(index, this.I);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.J = obtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.N = obtainStyledAttributes.getInt(index, this.N);
                }
            }
            obtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getScaleFromTextSize() {
        return this.k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.J;
    }

    public Typeface getTypeface() {
        return this.f596a.getTypeface();
    }

    public final void h(String str, int i2, int i3) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i3);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z2 = true;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 == 2) {
            typeface = Typeface.SERIF;
        } else if (i2 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f2 = 0.0f;
        if (i3 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setTypeface(defaultFromStyle);
            int i4 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i3;
            TextPaint textPaint = this.f596a;
            if ((i4 & 1) == 0) {
                z2 = false;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.f596a;
            if ((i4 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.f596a.setFakeBoldText(false);
        this.f596a.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    public final void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f596a;
        int i2 = typedValue.data;
        this.c = i2;
        textPaint.setColor(i2);
    }

    public void j() {
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        h(this.v, this.m, this.l);
        this.f596a.setColor(this.c);
        this.f596a.setStrokeWidth(this.n);
        this.f596a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f596a.setFlags(128);
        setTextSize(this.j);
        this.f596a.setAntiAlias(true);
    }

    public final void k() {
        if (this.D != null) {
            this.H = new Matrix();
            int intrinsicWidth = this.D.getIntrinsicWidth();
            int intrinsicHeight = this.D.getIntrinsicHeight();
            int i2 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.J) ? 128 : (int) this.J;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.I)) {
                    i2 = (int) this.I;
                }
                intrinsicHeight = i2;
            }
            if (this.N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.F);
            this.D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.D.setFilterBitmap(true);
            this.D.draw(canvas);
            if (this.N != 0) {
                this.F = e(this.F, 4);
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public final void l() {
        float f2 = 0.0f;
        float f3 = Float.isNaN(this.R) ? 0.0f : this.R;
        float f4 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f5 = Float.isNaN(this.T) ? 1.0f : this.T;
        if (!Float.isNaN(this.U)) {
            f2 = this.U;
        }
        this.H.reset();
        float width = (float) this.F.getWidth();
        float height = (float) this.F.getHeight();
        float f6 = Float.isNaN(this.J) ? this.B : this.J;
        float f7 = Float.isNaN(this.I) ? this.C : this.I;
        float f8 = f5 * (width * f7 < height * f6 ? f6 / width : f7 / height);
        this.H.postScale(f8, f8);
        float f9 = width * f8;
        float f10 = f6 - f9;
        float f11 = f8 * height;
        float f12 = f7 - f11;
        if (!Float.isNaN(this.I)) {
            f12 = this.I / 2.0f;
        }
        if (!Float.isNaN(this.J)) {
            f10 = this.J / 2.0f;
        }
        this.H.postTranslate((((f3 * f10) + f6) - f9) * 0.5f, (((f4 * f12) + f7) - f11) * 0.5f);
        this.H.postRotate(f2, f6 / 2.0f, f7 / 2.0f);
        this.G.setLocalMatrix(this.H);
    }

    public void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        boolean isNaN = Float.isNaN(this.k);
        float f2 = isNaN ? 1.0f : this.j / this.k;
        this.B = (float) (i4 - i2);
        this.C = (float) (i5 - i3);
        if (this.z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f596a);
                this.Q = this.P.getTextSize();
            }
            Paint paint = this.P;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            int height = (int) (((float) this.O.height()) * 1.3f);
            float f3 = (this.B - ((float) this.s)) - ((float) this.r);
            float f4 = (this.C - ((float) this.u)) - ((float) this.t);
            if (isNaN) {
                float f5 = (float) width;
                float f6 = (float) height;
                if (f5 * f4 > f6 * f3) {
                    this.f596a.setTextSize((this.Q * f3) / f5);
                } else {
                    this.f596a.setTextSize((this.Q * f4) / f6);
                }
            } else {
                float f7 = (float) width;
                float f8 = (float) height;
                f2 = f7 * f4 > f8 * f3 ? f3 / f7 : f4 / f8;
            }
        }
        if (this.e || !isNaN) {
            d((float) i2, (float) i3, (float) i4, (float) i5);
            f(f2);
        }
    }

    public void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        super.onDraw(canvas);
        if (this.e || f2 != 1.0f) {
            if (this.p) {
                f(f2);
            }
            if (this.E == null) {
                this.E = new Matrix();
            }
            if (this.e) {
                this.M.set(this.f596a);
                this.E.reset();
                float horizontalOffset = ((float) this.r) + getHorizontalOffset();
                float verticalOffset = ((float) this.t) + getVerticalOffset();
                this.E.postTranslate(horizontalOffset, verticalOffset);
                this.E.preScale(f2, f2);
                this.b.transform(this.E);
                if (this.G != null) {
                    this.f596a.setFilterBitmap(true);
                    this.f596a.setShader(this.G);
                } else {
                    this.f596a.setColor(this.c);
                }
                this.f596a.setStyle(Paint.Style.FILL);
                this.f596a.setStrokeWidth(this.n);
                canvas.drawPath(this.b, this.f596a);
                if (this.G != null) {
                    this.f596a.setShader((Shader) null);
                }
                this.f596a.setColor(this.d);
                this.f596a.setStyle(Paint.Style.STROKE);
                this.f596a.setStrokeWidth(this.n);
                canvas.drawPath(this.b, this.f596a);
                this.E.reset();
                this.E.postTranslate(-horizontalOffset, -verticalOffset);
                this.b.transform(this.E);
                this.f596a.set(this.M);
                return;
            }
            float horizontalOffset2 = ((float) this.r) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.t) + getVerticalOffset();
            this.E.reset();
            this.E.preTranslate(horizontalOffset2, verticalOffset2);
            this.b.transform(this.E);
            this.f596a.setColor(this.c);
            this.f596a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f596a.setStrokeWidth(this.n);
            canvas.drawPath(this.b, this.f596a);
            this.E.reset();
            this.E.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.b.transform(this.E);
            return;
        }
        canvas.drawText(this.o, this.A + ((float) this.r) + getHorizontalOffset(), ((float) this.t) + getVerticalOffset(), this.f596a);
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.z = false;
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f596a;
            String str = this.o;
            textPaint.getTextBounds(str, 0, str.length(), this.q);
            if (mode != 1073741824) {
                size = (int) (((float) this.q.width()) + 0.99999f);
            }
            size += this.r + this.s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.f596a.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.t + this.u + fontMetricsInt;
            }
        } else if (this.y != 0) {
            this.z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i2) {
        if ((i2 & 8388615) == 0) {
            i2 |= 8388611;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        if (i2 != this.x) {
            invalidate();
        }
        this.x = i2;
        int i3 = i2 & 112;
        if (i3 == 48) {
            this.L = -1.0f;
        } else if (i3 != 80) {
            this.L = 0.0f;
        } else {
            this.L = 1.0f;
        }
        int i4 = i2 & 8388615;
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 8388611) {
                    if (i4 != 8388613) {
                        this.K = 0.0f;
                        return;
                    }
                }
            }
            this.K = 1.0f;
            return;
        }
        this.K = -1.0f;
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.g = f2;
            float f3 = this.f;
            this.f = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z2 = this.g != f2;
        this.g = f2;
        if (f2 != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.g);
                    }
                };
                this.h = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.b.reset();
            Path path = this.b;
            RectF rectF = this.i;
            float f4 = this.g;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    @RequiresApi
    public void setRoundPercent(float f2) {
        boolean z2 = this.f != f2;
        this.f = f2;
        if (f2 != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.f) / 2.0f);
                    }
                };
                this.h = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f) / 2.0f;
            this.i.set(0.0f, 0.0f, (float) width, (float) height);
            this.b.reset();
            this.b.addRoundRect(this.i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.k = f2;
    }

    public void setText(CharSequence charSequence) {
        this.o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.R = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.S = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.U = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.T = f2;
        l();
        invalidate();
    }

    public void setTextFillColor(int i2) {
        this.c = i2;
        invalidate();
    }

    public void setTextOutlineColor(int i2) {
        this.d = i2;
        this.e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.n = f2;
        this.e = true;
        if (Float.isNaN(f2)) {
            this.n = 1.0f;
            this.e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.K = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.L = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.j = f2;
        String str = V;
        Log.v(str, Debug.a() + FastRecordHistoryDetailActivity.TAG_SPLIT + f2 + " / " + this.k);
        TextPaint textPaint = this.f596a;
        if (!Float.isNaN(this.k)) {
            f2 = this.k;
        }
        textPaint.setTextSize(f2);
        f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.I = f2;
        l();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.J = f2;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f596a.getTypeface() != typeface) {
            this.f596a.setTypeface(typeface);
            if (this.w != null) {
                this.w = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g(context, attributeSet);
    }
}
