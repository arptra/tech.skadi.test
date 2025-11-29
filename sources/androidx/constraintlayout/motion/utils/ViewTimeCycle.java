package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    public static class AlphaSet extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        public String l;
        public SparseArray m;
        public SparseArray n = new SparseArray();
        public float[] o;
        public float[] p;

        public CustomSet(String str, SparseArray sparseArray) {
            this.l = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)[1];
            this.m = sparseArray;
        }

        public void b(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void e(int i) {
            int size = this.m.size();
            int h = ((ConstraintAttribute) this.m.valueAt(0)).h();
            double[] dArr = new double[size];
            int i2 = h + 2;
            this.o = new float[i2];
            this.p = new float[h];
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.m.keyAt(i3);
                float[] fArr = (float[]) this.n.valueAt(i3);
                dArr[i3] = ((double) keyAt) * 0.01d;
                ((ConstraintAttribute) this.m.valueAt(i3)).f(this.o);
                int i4 = 0;
                while (true) {
                    float[] fArr2 = this.o;
                    if (i4 >= fArr2.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr2[i4];
                    i4++;
                }
                double[] dArr3 = dArr2[i3];
                dArr3[h] = (double) fArr[0];
                dArr3[h + 1] = (double) fArr[1];
            }
            this.f512a = CurveFit.a(i, dArr, dArr2);
        }

        public boolean i(View view, float f, long j, KeyCache keyCache) {
            View view2 = view;
            long j2 = j;
            this.f512a.e((double) f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j3 = j2 - this.i;
            if (Float.isNaN(this.j)) {
                float a2 = keyCache.a(view2, this.l, 0);
                this.j = a2;
                if (Float.isNaN(a2)) {
                    this.j = 0.0f;
                }
            }
            float f4 = (float) ((((double) this.j) + ((((double) j3) * 1.0E-9d) * ((double) f2))) % 1.0d);
            this.j = f4;
            this.i = j2;
            float a3 = a(f4);
            this.h = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.p;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = this.h;
                float f5 = this.o[i];
                this.h = z | (((double) f5) != 0.0d);
                fArr2[i] = (f5 * a3) + f3;
                i++;
            }
            CustomSupport.b((ConstraintAttribute) this.m.valueAt(0), view2, this.p);
            if (f2 != 0.0f) {
                this.h = true;
            }
            return this.h;
        }

        public void j(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.m.append(i, constraintAttribute);
            this.n.append(i, new float[]{f, f2});
            this.b = Math.max(this.b, i2);
        }
    }

    public static class ElevationSet extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setElevation(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            return this.h;
        }

        public boolean j(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(f(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.h;
        }
    }

    public static class ProgressSet extends ViewTimeCycle {
        public boolean l = false;

        public boolean i(View view, float f, long j, KeyCache keyCache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(f(f, j, view, keyCache));
            } else if (this.l) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(f(f, j, view, keyCache))});
                    } catch (IllegalAccessException e) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e2);
                    }
                }
            }
            return this.h;
        }
    }

    public static class RotationSet extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class RotationXset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class RotationYset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class ScaleXset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class ScaleYset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class TranslationXset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class TranslationYset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static class TranslationZset extends ViewTimeCycle {
        public boolean i(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationZ(f(f, j, view, keyCache));
            return this.h;
        }
    }

    public static ViewTimeCycle g(String str, SparseArray sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle h(String str, long j) {
        ViewTimeCycle viewTimeCycle;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS)) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                viewTimeCycle = new RotationXset();
                break;
            case 1:
                viewTimeCycle = new RotationYset();
                break;
            case 2:
                viewTimeCycle = new TranslationXset();
                break;
            case 3:
                viewTimeCycle = new TranslationYset();
                break;
            case 4:
                viewTimeCycle = new TranslationZset();
                break;
            case 5:
                viewTimeCycle = new ProgressSet();
                break;
            case 6:
                viewTimeCycle = new ScaleXset();
                break;
            case 7:
                viewTimeCycle = new ScaleYset();
                break;
            case 8:
                viewTimeCycle = new RotationSet();
                break;
            case 9:
                viewTimeCycle = new ElevationSet();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new AlphaSet();
                break;
            default:
                return null;
        }
        viewTimeCycle.c(j);
        return viewTimeCycle;
    }

    public float f(float f, long j, View view, KeyCache keyCache) {
        long j2 = j;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.f512a.e((double) f, this.g);
        float[] fArr = this.g;
        float f2 = fArr[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i == 0) {
            this.h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.j)) {
            float a2 = keyCache2.a(view2, this.f, 0);
            this.j = a2;
            if (Float.isNaN(a2)) {
                this.j = 0.0f;
            }
        }
        float f3 = (float) ((((double) this.j) + ((((double) (j2 - this.i)) * 1.0E-9d) * ((double) f2))) % 1.0d);
        this.j = f3;
        keyCache2.b(view2, this.f, 0, f3);
        this.i = j2;
        float f4 = this.g[0];
        float a3 = (a(this.j) * f4) + this.g[2];
        this.h = (f4 == 0.0f && i == 0) ? false : true;
        return a3;
    }

    public abstract boolean i(View view, float f, long j, KeyCache keyCache);
}
