package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class ChangeTransform extends Transition {
    public static final String[] d = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final Property e = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") {
        /* renamed from: a */
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* renamed from: b */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.d(fArr);
        }
    };
    public static final Property f = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") {
        /* renamed from: a */
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* renamed from: b */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.c(pointF);
        }
    };
    public static final boolean g = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1837a;
    public boolean b;
    public Matrix c;

    public static class GhostListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public View f1839a;
        public GhostView b;

        public GhostListener(View view, GhostView ghostView) {
            this.f1839a = view;
            this.b = ghostView;
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.b(this.f1839a);
            this.f1839a.setTag(R.id.transition_transform, (Object) null);
            this.f1839a.setTag(R.id.parent_matrix, (Object) null);
        }

        public void onTransitionPause(Transition transition) {
            this.b.setVisibility(4);
        }

        public void onTransitionResume(Transition transition) {
            this.b.setVisibility(0);
        }
    }

    public static class PathAnimatorMatrix {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f1840a = new Matrix();
        public final View b;
        public final float[] c;
        public float d;
        public float e;

        public PathAnimatorMatrix(View view, float[] fArr) {
            this.b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.c = fArr2;
            this.d = fArr2[2];
            this.e = fArr2[5];
            b();
        }

        public Matrix a() {
            return this.f1840a;
        }

        public final void b() {
            float[] fArr = this.c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.f1840a.setValues(fArr);
            ViewUtils.f(this.b, this.f1840a);
        }

        public void c(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
            b();
        }
    }

    public static class Transforms {

        /* renamed from: a  reason: collision with root package name */
        public final float f1841a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;

        public Transforms(View view) {
            this.f1841a = view.getTranslationX();
            this.b = view.getTranslationY();
            this.c = ViewCompat.M(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.x(view, this.f1841a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f1841a == this.f1841a && transforms.b == this.b && transforms.c == this.c && transforms.d == this.d && transforms.e == this.e && transforms.f == this.f && transforms.g == this.g && transforms.h == this.h;
        }

        public int hashCode() {
            float f2 = this.f1841a;
            int i = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.h;
            if (f9 != 0.0f) {
                i = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i;
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.b;
        if (view.getVisibility() != 8) {
            transitionValues.f1876a.put("android:changeTransform:parent", view.getParent());
            transitionValues.f1876a.put("android:changeTransform:transforms", new Transforms(view));
            Matrix matrix = view.getMatrix();
            transitionValues.f1876a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.b) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                ViewUtils.j(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.f1876a.put("android:changeTransform:parentMatrix", matrix2);
                transitionValues.f1876a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                transitionValues.f1876a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    public static void v(View view) {
        x(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void x(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ViewCompat.a1(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!g) {
            ((ViewGroup) transitionValues.b.getParent()).startViewTransition(transitionValues.b);
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f1876a.containsKey("android:changeTransform:parent") || !transitionValues2.f1876a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.f1876a.get("android:changeTransform:parent");
        boolean z = this.b && !u(viewGroup2, (ViewGroup) transitionValues2.f1876a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) transitionValues.f1876a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            transitionValues.f1876a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.f1876a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            transitionValues.f1876a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            w(transitionValues, transitionValues2);
        }
        ObjectAnimator t = t(transitionValues, transitionValues2, z);
        if (z && t != null && this.f1837a) {
            s(viewGroup, transitionValues, transitionValues2);
        } else if (!g) {
            viewGroup2.endViewTransition(transitionValues.b);
        }
        return t;
    }

    public String[] getTransitionProperties() {
        return d;
    }

    public final void s(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.b;
        Matrix matrix = new Matrix((Matrix) transitionValues2.f1876a.get("android:changeTransform:parentMatrix"));
        ViewUtils.k(viewGroup, matrix);
        GhostView a2 = GhostViewUtils.a(view, viewGroup, matrix);
        if (a2 != null) {
            a2.a((ViewGroup) transitionValues.f1876a.get("android:changeTransform:parent"), transitionValues.b);
            while (true) {
                Transition transition = this.mParent;
                if (transition == null) {
                    break;
                }
                this = transition;
            }
            this.addListener(new GhostListener(view, a2));
            if (g) {
                View view2 = transitionValues.b;
                if (view2 != transitionValues2.b) {
                    ViewUtils.h(view2, 0.0f);
                }
                ViewUtils.h(view, 1.0f);
            }
        }
    }

    public final ObjectAnimator t(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z) {
        Matrix matrix = (Matrix) transitionValues.f1876a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f1876a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = MatrixUtils.f1856a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f1856a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.f1876a.get("android:changeTransform:transforms");
        final View view = transitionValues2.b;
        v(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(e, new FloatArrayEvaluator(new float[9]), new float[][]{fArr, fArr2}), PropertyValuesHolderUtils.a(f, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        final boolean z2 = z;
        AnonymousClass3 r1 = new AnimatorListenerAdapter() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f1838a;
            public Matrix b = new Matrix();

            public final void a(Matrix matrix) {
                this.b.set(matrix);
                view.setTag(R.id.transition_transform, this.b);
                transforms.a(view);
            }

            public void onAnimationCancel(Animator animator) {
                this.f1838a = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.f1838a) {
                    if (!z2 || !ChangeTransform.this.f1837a) {
                        view.setTag(R.id.transition_transform, (Object) null);
                        view.setTag(R.id.parent_matrix, (Object) null);
                    } else {
                        a(matrix3);
                    }
                }
                ViewUtils.f(view, (Matrix) null);
                transforms.a(view);
            }

            public void onAnimationPause(Animator animator) {
                a(pathAnimatorMatrix.a());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.v(view);
            }
        };
        ofPropertyValuesHolder.addListener(r1);
        AnimatorUtils.a(ofPropertyValuesHolder, r1);
        return ofPropertyValuesHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4 == r5) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r3.b) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            androidx.transition.TransitionValues r3 = r3.getMatchedTransitionValues(r4, r1)
            if (r3 == 0) goto L_0x0020
            android.view.View r3 = r3.b
            if (r5 != r3) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            r2 = r1
            goto L_0x0020
        L_0x001d:
            if (r4 != r5) goto L_0x001a
            goto L_0x001b
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.u(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    public final void w(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.f1876a.get("android:changeTransform:parentMatrix");
        transitionValues2.b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.c;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.f1876a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.f1876a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.f1876a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }
}
