package com.luck.picture.lib.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    public int A = 2;
    public float B;
    public boolean C = true;
    public ImageView.ScaleType D = ImageView.ScaleType.FIT_CENTER;
    public final OnGestureListener E;

    /* renamed from: a  reason: collision with root package name */
    public Interpolator f9444a = new AccelerateDecelerateInterpolator();
    public int b = 200;
    public float c = 1.0f;
    public float d = 1.75f;
    public float e = 3.0f;
    public boolean f = true;
    public boolean g = false;
    public final ImageView h;
    public GestureDetector i;
    public CustomGestureDetector j;
    public final Matrix k = new Matrix();
    public final Matrix l = new Matrix();
    public final Matrix m = new Matrix();
    public final RectF n = new RectF();
    public final float[] o = new float[9];
    public OnMatrixChangedListener p;
    public OnPhotoTapListener q;
    public OnOutsidePhotoTapListener r;
    public OnViewTapListener s;
    public View.OnClickListener t;
    public View.OnLongClickListener u;
    public OnScaleChangedListener v;
    public OnSingleFlingListener w;
    public OnViewDragListener x;
    public FlingRunnable y;
    public int z = 2;

    /* renamed from: com.luck.picture.lib.photoview.PhotoViewAttacher$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9448a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9448a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9448a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9448a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9448a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.photoview.PhotoViewAttacher.AnonymousClass4.<clinit>():void");
        }
    }

    public class AnimatedZoomRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final float f9449a;
        public final float b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;

        public AnimatedZoomRunnable(float f2, float f3, float f4, float f5) {
            this.f9449a = f4;
            this.b = f5;
            this.d = f2;
            this.e = f3;
        }

        public final float a() {
            return PhotoViewAttacher.this.f9444a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.c)) * 1.0f) / ((float) PhotoViewAttacher.this.b)));
        }

        public void run() {
            float a2 = a();
            float f2 = this.d;
            PhotoViewAttacher.this.E.d((f2 + ((this.e - f2) * a2)) / PhotoViewAttacher.this.K(), this.f9449a, this.b);
            if (a2 < 1.0f) {
                Compat.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    public class FlingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final OverScroller f9450a;
        public int b;
        public int c;

        public FlingRunnable(Context context) {
            this.f9450a = new OverScroller(context);
        }

        public void a() {
            this.f9450a.forceFinished(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF B = PhotoViewAttacher.this.B();
            if (B != null) {
                int round = Math.round(-B.left);
                float f = (float) i;
                if (f < B.width()) {
                    i5 = Math.round(B.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-B.top);
                float f2 = (float) i2;
                if (f2 < B.height()) {
                    i7 = Math.round(B.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.b = round;
                this.c = round2;
                if (round != i5 || round2 != i7) {
                    this.f9450a.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.f9450a.isFinished() && this.f9450a.computeScrollOffset()) {
                int currX = this.f9450a.getCurrX();
                int currY = this.f9450a.getCurrY();
                PhotoViewAttacher.this.m.postTranslate((float) (this.b - currX), (float) (this.c - currY));
                PhotoViewAttacher.this.z();
                this.b = currX;
                this.c = currY;
                Compat.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        AnonymousClass1 r0 = new OnGestureListener() {
            public void a(float f, float f2) {
                if (!PhotoViewAttacher.this.j.e()) {
                    if (PhotoViewAttacher.this.x != null) {
                        PhotoViewAttacher.this.x.a(f, f2);
                    }
                    PhotoViewAttacher.this.m.postTranslate(f, f2);
                    PhotoViewAttacher.this.z();
                    ViewParent parent = PhotoViewAttacher.this.h.getParent();
                    if (!PhotoViewAttacher.this.f || PhotoViewAttacher.this.j.e() || PhotoViewAttacher.this.g) {
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    } else if ((PhotoViewAttacher.this.z == 2 || ((PhotoViewAttacher.this.z == 0 && f >= 1.0f) || ((PhotoViewAttacher.this.z == 1 && f <= -1.0f) || ((PhotoViewAttacher.this.A == 0 && f2 >= 1.0f) || (PhotoViewAttacher.this.A == 1 && f2 <= -1.0f))))) && parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }
            }

            public void b(float f, float f2, float f3, float f4, float f5) {
                if (PhotoViewAttacher.this.K() < PhotoViewAttacher.this.e || f < 1.0f) {
                    if (PhotoViewAttacher.this.v != null) {
                        PhotoViewAttacher.this.v.a(f, f2, f3);
                    }
                    PhotoViewAttacher.this.m.postScale(f, f, f2, f3);
                    PhotoViewAttacher.this.m.postTranslate(f4, f5);
                    PhotoViewAttacher.this.z();
                }
            }

            public void c(float f, float f2, float f3, float f4) {
                PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                FlingRunnable unused = photoViewAttacher.y = new FlingRunnable(photoViewAttacher.h.getContext());
                FlingRunnable w = PhotoViewAttacher.this.y;
                PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                int c = photoViewAttacher2.G(photoViewAttacher2.h);
                PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                w.b(c, photoViewAttacher3.F(photoViewAttacher3.h), (int) f3, (int) f4);
                PhotoViewAttacher.this.h.post(PhotoViewAttacher.this.y);
            }

            public void d(float f, float f2, float f3) {
                b(f, f2, f3, 0.0f, 0.0f);
            }
        };
        this.E = r0;
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.B = 0.0f;
            this.j = new CustomGestureDetector(imageView.getContext(), r0);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (PhotoViewAttacher.this.w == null || PhotoViewAttacher.this.K() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                        return false;
                    }
                    return PhotoViewAttacher.this.w.onFling(motionEvent, motionEvent2, f, f2);
                }

                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.u != null) {
                        PhotoViewAttacher.this.u.onLongClick(PhotoViewAttacher.this.h);
                    }
                }
            });
            this.i = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float K = PhotoViewAttacher.this.K();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (K < PhotoViewAttacher.this.I()) {
                            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                            photoViewAttacher.g0(photoViewAttacher.I(), x, y, true);
                        } else if (K < PhotoViewAttacher.this.I() || K >= PhotoViewAttacher.this.H()) {
                            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                            photoViewAttacher2.g0(photoViewAttacher2.J(), x, y, true);
                        } else {
                            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                            photoViewAttacher3.g0(photoViewAttacher3.H(), x, y, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.t != null) {
                        PhotoViewAttacher.this.t.onClick(PhotoViewAttacher.this.h);
                    }
                    RectF B = PhotoViewAttacher.this.B();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (PhotoViewAttacher.this.s != null) {
                        PhotoViewAttacher.this.s.a(PhotoViewAttacher.this.h, x, y);
                    }
                    if (B == null) {
                        return false;
                    }
                    if (B.contains(x, y)) {
                        float width = (x - B.left) / B.width();
                        float height = (y - B.top) / B.height();
                        if (PhotoViewAttacher.this.q == null) {
                            return true;
                        }
                        PhotoViewAttacher.this.q.a(PhotoViewAttacher.this.h, width, height);
                        return true;
                    } else if (PhotoViewAttacher.this.r == null) {
                        return false;
                    } else {
                        PhotoViewAttacher.this.r.a(PhotoViewAttacher.this.h);
                        return false;
                    }
                }
            });
        }
    }

    public final boolean A() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF C2 = C(D());
        if (C2 == null) {
            return false;
        }
        float height = C2.height();
        float width = C2.width();
        float F = (float) F(this.h);
        float f7 = 0.0f;
        if (height <= F) {
            int i2 = AnonymousClass4.f9448a[this.D.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (F - height) / 2.0f;
                    f6 = C2.top;
                } else {
                    f5 = F - height;
                    f6 = C2.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -C2.top;
            }
            this.A = 2;
        } else {
            float f8 = C2.top;
            if (f8 > 0.0f) {
                this.A = 0;
                f2 = -f8;
            } else {
                float f9 = C2.bottom;
                if (f9 < F) {
                    this.A = 1;
                    f2 = F - f9;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        }
        float G = (float) G(this.h);
        if (width <= G) {
            int i3 = AnonymousClass4.f9448a[this.D.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (G - width) / 2.0f;
                    f4 = C2.left;
                } else {
                    f3 = G - width;
                    f4 = C2.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -C2.left;
            }
            this.z = 2;
        } else {
            float f10 = C2.left;
            if (f10 > 0.0f) {
                this.z = 0;
                f7 = -f10;
            } else {
                float f11 = C2.right;
                if (f11 < G) {
                    f7 = G - f11;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    public RectF B() {
        A();
        return C(D());
    }

    public final RectF C(Matrix matrix) {
        Drawable drawable = this.h.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    public final Matrix D() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    public Matrix E() {
        return this.l;
    }

    public final int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float H() {
        return this.e;
    }

    public float I() {
        return this.d;
    }

    public float J() {
        return this.c;
    }

    public float K() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) M(this.m, 0), 2.0d)) + ((float) Math.pow((double) M(this.m, 3), 2.0d))));
    }

    public ImageView.ScaleType L() {
        return this.D;
    }

    public final float M(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    public final void N() {
        this.m.reset();
        d0(this.B);
        P(D());
        A();
    }

    public void O(boolean z2) {
        this.f = z2;
    }

    public final void P(Matrix matrix) {
        RectF C2;
        this.h.setImageMatrix(matrix);
        if (this.p != null && (C2 = C(matrix)) != null) {
            this.p.a(C2);
        }
    }

    public void Q(float f2) {
        Util.a(this.c, this.d, f2);
        this.e = f2;
    }

    public void R(float f2) {
        Util.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void S(float f2) {
        Util.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void T(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void W(OnMatrixChangedListener onMatrixChangedListener) {
        this.p = onMatrixChangedListener;
    }

    public void X(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.r = onOutsidePhotoTapListener;
    }

    public void Y(OnPhotoTapListener onPhotoTapListener) {
        this.q = onPhotoTapListener;
    }

    public void Z(OnScaleChangedListener onScaleChangedListener) {
        this.v = onScaleChangedListener;
    }

    public void a0(OnSingleFlingListener onSingleFlingListener) {
        this.w = onSingleFlingListener;
    }

    public void b0(OnViewDragListener onViewDragListener) {
        this.x = onViewDragListener;
    }

    public void c0(OnViewTapListener onViewTapListener) {
        this.s = onViewTapListener;
    }

    public void d0(float f2) {
        this.m.postRotate(f2 % 360.0f);
        z();
    }

    public void e0(float f2) {
        this.m.setRotate(f2 % 360.0f);
        z();
    }

    public void f0(float f2) {
        h0(f2, false);
    }

    public void g0(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            this.h.post(new AnimatedZoomRunnable(K(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            z();
        }
    }

    public void h0(float f2, boolean z2) {
        g0(f2, (float) (this.h.getRight() / 2), (float) (this.h.getBottom() / 2), z2);
    }

    public void i0(ImageView.ScaleType scaleType) {
        if (Util.d(scaleType) && scaleType != this.D) {
            this.D = scaleType;
            l0();
        }
    }

    public void j0(int i2) {
        this.b = i2;
    }

    public void k0(boolean z2) {
        this.C = z2;
        l0();
    }

    public void l0() {
        if (this.C) {
            m0(this.h.getDrawable());
        } else {
            N();
        }
    }

    public final void m0(Drawable drawable) {
        if (drawable != null) {
            float G = (float) G(this.h);
            float F = (float) F(this.h);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.k.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = G / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = F / f4;
            ImageView.ScaleType scaleType = this.D;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.k.postTranslate((G - f2) / 2.0f, (F - f4) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.k.postScale(max, max);
                this.k.postTranslate((G - (f2 * max)) / 2.0f, (F - (f4 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.k.postScale(min, min);
                this.k.postTranslate((G - (f2 * min)) / 2.0f, (F - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, G, F);
                if (((int) this.B) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f4, f2);
                }
                int i2 = AnonymousClass4.f9448a[this.D.ordinal()];
                if (i2 == 1) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 2) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            N();
        }
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            m0(this.h.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.C
            r1 = 0
            if (r0 == 0) goto L_0x00be
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.luck.picture.lib.photoview.Util.c(r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x006e
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            float r0 = r10.K()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            android.graphics.RectF r0 = r10.B()
            if (r0 == 0) goto L_0x007a
            com.luck.picture.lib.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.luck.picture.lib.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.K()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x006c
        L_0x0044:
            float r0 = r10.K()
            float r3 = r10.e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            android.graphics.RectF r0 = r10.B()
            if (r0 == 0) goto L_0x007a
            com.luck.picture.lib.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.luck.picture.lib.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.K()
            float r6 = r10.e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L_0x006c:
            r11 = r2
            goto L_0x007b
        L_0x006e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0077
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0077:
            r10.y()
        L_0x007a:
            r11 = r1
        L_0x007b:
            com.luck.picture.lib.photoview.CustomGestureDetector r0 = r10.j
            if (r0 == 0) goto L_0x00b2
            boolean r11 = r0.e()
            com.luck.picture.lib.photoview.CustomGestureDetector r0 = r10.j
            boolean r0 = r0.d()
            com.luck.picture.lib.photoview.CustomGestureDetector r3 = r10.j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L_0x009b
            com.luck.picture.lib.photoview.CustomGestureDetector r11 = r10.j
            boolean r11 = r11.e()
            if (r11 != 0) goto L_0x009b
            r11 = r2
            goto L_0x009c
        L_0x009b:
            r11 = r1
        L_0x009c:
            if (r0 != 0) goto L_0x00a8
            com.luck.picture.lib.photoview.CustomGestureDetector r0 = r10.j
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x00a8
            r0 = r2
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            if (r0 == 0) goto L_0x00ae
            r1 = r2
        L_0x00ae:
            r10.g = r1
            r1 = r3
            goto L_0x00b3
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            android.view.GestureDetector r10 = r10.i
            if (r10 == 0) goto L_0x00be
            boolean r10 = r10.onTouchEvent(r12)
            if (r10 == 0) goto L_0x00be
            r1 = r2
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void y() {
        FlingRunnable flingRunnable = this.y;
        if (flingRunnable != null) {
            flingRunnable.a();
            this.y = null;
        }
    }

    public final void z() {
        if (A()) {
            P(D());
        }
    }
}
