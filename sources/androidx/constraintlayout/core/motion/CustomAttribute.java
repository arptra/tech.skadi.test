package androidx.constraintlayout.core.motion;

public class CustomAttribute {

    /* renamed from: a  reason: collision with root package name */
    public AttributeType f487a;
    public int b;
    public float c;
    public boolean d;
    public int e;

    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f488a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType[] r0 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f488a = r0
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f488a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.CustomAttribute.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public void a(float[] fArr) {
        switch (AnonymousClass1.f488a[this.f487a.ordinal()]) {
            case 2:
                fArr[0] = this.d ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = this.e;
                float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.b;
                return;
            case 7:
                fArr[0] = this.c;
                return;
            case 8:
                fArr[0] = this.c;
                return;
            default:
                return;
        }
    }

    public int b() {
        int i = AnonymousClass1.f488a[this.f487a.ordinal()];
        return (i == 4 || i == 5) ? 4 : 1;
    }
}
