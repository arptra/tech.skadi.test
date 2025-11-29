package flyme.support.v7.widget.animations;

class InfinityStretch {
    private static final float INFINITY_STRETCH_COEFFICIENT = 1.0f;

    public static float distance(float f, float f2) {
        if (f < 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        float min = Math.min(f, f2 - 1.0E-5f);
        return ((f2 * min) / (f2 - min)) / 1.0f;
    }

    public static float offset(float f, float f2) {
        boolean z = false;
        boolean z2 = f < 0.0f;
        if (f2 <= 0.0f) {
            z = true;
        }
        if (z2 || z) {
            return 0.0f;
        }
        return (1.0f - (1.0f / (((f / f2) * 1.0f) + 1.0f))) * f2;
    }
}
