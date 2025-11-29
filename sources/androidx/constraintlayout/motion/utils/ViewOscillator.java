package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewOscillator extends KeyCycleOscillator {

    public static class AlphaSet extends ViewOscillator {
        public void j(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    public static class CustomSet extends ViewOscillator {
        public float[] h = new float[1];
        public ConstraintAttribute i;

        public void c(Object obj) {
            this.i = (ConstraintAttribute) obj;
        }

        public void j(View view, float f) {
            this.h[0] = a(f);
            CustomSupport.b(this.i, view, this.h);
        }
    }

    public static class ElevationSet extends ViewOscillator {
        public void j(View view, float f) {
            view.setElevation(a(f));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public void j(View view, float f) {
        }

        public void k(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    public static class ProgressSet extends ViewOscillator {
        public boolean h = false;

        public void j(View view, float f) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
            } else if (!this.h) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.h = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f))});
                    } catch (IllegalAccessException e) {
                        Log.e("ViewOscillator", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewOscillator", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewOscillator {
        public void j(View view, float f) {
            view.setRotation(a(f));
        }
    }

    public static class RotationXset extends ViewOscillator {
        public void j(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    public static class RotationYset extends ViewOscillator {
        public void j(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    public static class ScaleXset extends ViewOscillator {
        public void j(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    public static class ScaleYset extends ViewOscillator {
        public void j(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    public static class TranslationXset extends ViewOscillator {
        public void j(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    public static class TranslationYset extends ViewOscillator {
        public void j(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    public static class TranslationZset extends ViewOscillator {
        public void j(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    public static ViewOscillator i(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 13;
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
                return new RotationSet();
            case 10:
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case 12:
                return new AlphaSet();
            case 13:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void j(View view, float f);
}
