package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds extends Transition {
    public static final String[] d = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property e;
    public static final Property f;
    public static final Property g;
    public static final Property h;
    public static final Property i;
    public static final Property j;
    public static RectEvaluator k = new RectEvaluator();

    /* renamed from: a  reason: collision with root package name */
    public int[] f1825a = new int[2];
    public boolean b = false;
    public boolean c = false;

    public static class ViewBounds {

        /* renamed from: a  reason: collision with root package name */
        public int f1831a;
        public int b;
        public int c;
        public int d;
        public View e;
        public int f;
        public int g;

        public ViewBounds(View view) {
            this.e = view;
        }

        public void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        public final void b() {
            ViewUtils.g(this.e, this.f1831a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        public void c(PointF pointF) {
            this.f1831a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        e = new Property<Drawable, PointF>(cls, "boundsOrigin") {

            /* renamed from: a  reason: collision with root package name */
            public Rect f1826a = new Rect();

            /* renamed from: a */
            public PointF get(Drawable drawable) {
                drawable.copyBounds(this.f1826a);
                Rect rect = this.f1826a;
                return new PointF((float) rect.left, (float) rect.top);
            }

            /* renamed from: b */
            public void set(Drawable drawable, PointF pointF) {
                drawable.copyBounds(this.f1826a);
                this.f1826a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.f1826a);
            }
        };
        f = new Property<ViewBounds, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.c(pointF);
            }
        };
        g = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.a(pointF);
            }
        };
        h = new Property<View, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        i = new Property<View, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        j = new Property<View, PointF>(cls, "position") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.b;
        if (ViewCompat.W(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f1876a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f1876a.put("android:changeBounds:parent", transitionValues.b.getParent());
            if (this.c) {
                transitionValues.b.getLocationInWindow(this.f1825a);
                transitionValues.f1876a.put("android:changeBounds:windowX", Integer.valueOf(this.f1825a[0]));
                transitionValues.f1876a.put("android:changeBounds:windowY", Integer.valueOf(this.f1825a[1]));
            }
            if (this.b) {
                transitionValues.f1876a.put("android:changeBounds:clip", ViewCompat.s(view));
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i2;
        View view;
        Animator animator;
        int i3;
        ObjectAnimator objectAnimator;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map map = transitionValues3.f1876a;
        Map map2 = transitionValues4.f1876a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.b;
        if (s(viewGroup2, viewGroup3)) {
            Rect rect = (Rect) transitionValues3.f1876a.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) transitionValues4.f1876a.get("android:changeBounds:bounds");
            int i4 = rect.left;
            int i5 = rect2.left;
            int i6 = rect.top;
            int i7 = rect2.top;
            int i8 = rect.right;
            int i9 = rect2.right;
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect3 = (Rect) transitionValues3.f1876a.get("android:changeBounds:clip");
            Rect rect4 = (Rect) transitionValues4.f1876a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect5 = rect4;
            if (!this.b) {
                view = view3;
                ViewUtils.g(view, i4, i6, i8, i10);
                if (i2 != 2) {
                    animator = (i4 == i5 && i6 == i7) ? ObjectAnimatorUtils.a(view, h, getPathMotion().getPath((float) i8, (float) i10, (float) i9, (float) i11)) : ObjectAnimatorUtils.a(view, i, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                } else if (i12 == i14 && i13 == i15) {
                    animator = ObjectAnimatorUtils.a(view, j, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                } else {
                    ViewBounds viewBounds = new ViewBounds(view);
                    ObjectAnimator a2 = ObjectAnimatorUtils.a(viewBounds, f, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                    ObjectAnimator a3 = ObjectAnimatorUtils.a(viewBounds, g, getPathMotion().getPath((float) i8, (float) i10, (float) i9, (float) i11));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{a2, a3});
                    animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ViewBounds f1828a;
                        private ViewBounds mViewBounds;

                        {
                            this.f1828a = r2;
                            this.mViewBounds = r2;
                        }
                    });
                    animator = animatorSet;
                }
            } else {
                view = view3;
                ViewUtils.g(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : ObjectAnimatorUtils.a(view, j, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                if (rect3 == null) {
                    i3 = 0;
                    rect3 = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (!rect3.equals(rect6)) {
                    ViewCompat.C0(view, rect3);
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", k, new Object[]{rect3, rect6});
                    final View view4 = view;
                    final Rect rect7 = rect5;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i11;
                    final int i19 = i9;
                    ofObject.addListener(new AnimatorListenerAdapter() {

                        /* renamed from: a  reason: collision with root package name */
                        public boolean f1829a;

                        public void onAnimationCancel(Animator animator) {
                            this.f1829a = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.f1829a) {
                                ViewCompat.C0(view4, rect7);
                                ViewUtils.g(view4, i16, i17, i19, i18);
                            }
                        }
                    });
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = TransitionUtils.c(a4, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.c(viewGroup4, true);
                addListener(new TransitionListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f1830a = false;

                    public void onTransitionCancel(Transition transition) {
                        ViewGroupUtils.c(viewGroup4, false);
                        this.f1830a = true;
                    }

                    public void onTransitionEnd(Transition transition) {
                        if (!this.f1830a) {
                            ViewGroupUtils.c(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    public void onTransitionPause(Transition transition) {
                        ViewGroupUtils.c(viewGroup4, false);
                    }

                    public void onTransitionResume(Transition transition) {
                        ViewGroupUtils.c(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.f1876a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues3.f1876a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues4.f1876a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues4.f1876a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f1825a);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = ViewUtils.c(view2);
        ViewUtils.h(view2, 0.0f);
        ViewUtils.b(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.f1825a;
        int i20 = iArr[0];
        int i21 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{PropertyValuesHolderUtils.a(e, pathMotion.getPath((float) (intValue - i20), (float) (intValue2 - i21), (float) (intValue3 - i20), (float) (intValue4 - i21)))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = c2;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewUtils.b(viewGroup5).remove(bitmapDrawable2);
                ViewUtils.h(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }

    public String[] getTransitionProperties() {
        return d;
    }

    public final boolean s(View view, View view2) {
        if (!this.c) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.b) {
            return true;
        }
        return false;
    }
}
