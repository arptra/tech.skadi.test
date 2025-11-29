package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewSpline extends SplineSet {

    public static class AlphaSet extends ViewSpline {
        public void h(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    public static class CustomSet extends ViewSpline {
        public String f;
        public SparseArray g;
        public float[] h;

        public CustomSet(String str, SparseArray sparseArray) {
            this.f = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)[1];
            this.g = sparseArray;
        }

        public void c(int i, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void e(int i) {
            int size = this.g.size();
            int h2 = ((ConstraintAttribute) this.g.valueAt(0)).h();
            double[] dArr = new double[size];
            this.h = new float[h2];
            int[] iArr = new int[2];
            iArr[1] = h2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((double) this.g.keyAt(i2)) * 0.01d;
                ((ConstraintAttribute) this.g.valueAt(i2)).f(this.h);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.h;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.f509a = CurveFit.a(i, dArr, dArr2);
        }

        public void h(View view, float f2) {
            this.f509a.e((double) f2, this.h);
            CustomSupport.b((ConstraintAttribute) this.g.valueAt(0), view, this.h);
        }

        public void i(int i, ConstraintAttribute constraintAttribute) {
            this.g.append(i, constraintAttribute);
        }
    }

    public static class ElevationSet extends ViewSpline {
        public void h(View view, float f) {
            view.setElevation(a(f));
        }
    }

    public static class PathRotate extends ViewSpline {
        public void h(View view, float f) {
        }

        public void i(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    public static class PivotXset extends ViewSpline {
        public void h(View view, float f) {
            view.setPivotX(a(f));
        }
    }

    public static class PivotYset extends ViewSpline {
        public void h(View view, float f) {
            view.setPivotY(a(f));
        }
    }

    public static class ProgressSet extends ViewSpline {
        public boolean f = false;

        public void h(View view, float f2) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException e) {
                        Log.e("ViewSpline", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewSpline", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewSpline {
        public void h(View view, float f) {
            view.setRotation(a(f));
        }
    }

    public static class RotationXset extends ViewSpline {
        public void h(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    public static class RotationYset extends ViewSpline {
        public void h(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    public static class ScaleXset extends ViewSpline {
        public void h(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    public static class ScaleYset extends ViewSpline {
        public void h(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    public static class TranslationXset extends ViewSpline {
        public void h(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    public static class TranslationYset extends ViewSpline {
        public void h(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    public static class TranslationZset extends ViewSpline {
        public void h(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    public static ViewSpline f(String str, SparseArray sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewSpline g(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new PivotXset();
            case 10:
                return new PivotYset();
            case 11:
                return new RotationSet();
            case 12:
                return new ElevationSet();
            case 13:
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f);
}
