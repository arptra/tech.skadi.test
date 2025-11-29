package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    public double d;
    public double e;

    public Schlick(String str) {
        this.f498a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.e = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    public double a(double d2) {
        return e(d2);
    }

    public double b(double d2) {
        return d(d2);
    }

    public final double d(double d2) {
        double d3 = this.e;
        if (d2 < d3) {
            double d4 = this.d;
            return ((d4 * d3) * d3) / ((((d3 - d2) * d4) + d2) * ((d4 * (d3 - d2)) + d2));
        }
        double d5 = this.d;
        return (((d3 - 1.0d) * d5) * (d3 - 1.0d)) / (((((-d5) * (d3 - d2)) - d2) + 1.0d) * ((((-d5) * (d3 - d2)) - d2) + 1.0d));
    }

    public final double e(double d2) {
        double d3 = this.e;
        return d2 < d3 ? (d3 * d2) / (d2 + (this.d * (d3 - d2))) : ((1.0d - d3) * (d2 - 1.0d)) / ((1.0d - d2) - (this.d * (d3 - d2)));
    }
}
