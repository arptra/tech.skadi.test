package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.util.Arrays;

public class Easing {
    public static Easing b = new Easing();
    public static String[] c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a  reason: collision with root package name */
    public String f498a = "identity";

    public static class CubicEasing extends Easing {
        public static double h = 0.01d;
        public static double i = 1.0E-4d;
        public double d;
        public double e;
        public double f;
        public double g;

        public CubicEasing(String str) {
            this.f498a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.e = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.f = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        public double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > h) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d(d5);
            double d7 = d4 + d3;
            double d8 = d(d7);
            double e2 = e(d5);
            return (((e(d7) - e2) * (d2 - d6)) / (d8 - d6)) + e2;
        }

        public double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > i) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (e(d6) - e(d5)) / (d(d6) - d(d5));
        }

        public final double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.d * d3 * d4 * d2) + (this.f * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        public final double e(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.e * d3 * d4 * d2) + (this.g * d4 * d2 * d2) + (d2 * d2 * d2);
        }
    }

    public static Easing c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals("anticipate")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals("overshoot")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new CubicEasing("cubic(0.36, 0, 0.66, -0.56)");
            case 3:
                return new CubicEasing("cubic(1, 1, 0, 0)");
            case 4:
                return new CubicEasing("cubic(0.34, 1.56, 0.64, 1)");
            case 5:
                return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(c));
                return b;
        }
    }

    public double a(double d) {
        return d;
    }

    public double b(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.f498a;
    }
}
