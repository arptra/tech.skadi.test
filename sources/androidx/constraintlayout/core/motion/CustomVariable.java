package androidx.constraintlayout.core.motion;

public class CustomVariable {

    /* renamed from: a  reason: collision with root package name */
    public String f489a;
    public int b;
    public int c;
    public float d;
    public String e;
    public boolean f;

    public static String a(int i) {
        String str = "00000000" + Integer.toHexString(i);
        return "#" + str.substring(str.length() - 8);
    }

    public void b(float[] fArr) {
        switch (this.b) {
            case 900:
                fArr[0] = (float) this.c;
                return;
            case 901:
                fArr[0] = this.d;
                return;
            case 902:
                int i = this.c;
                float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i >> 24) & 255)) / 255.0f;
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                fArr[0] = this.f ? 1.0f : 0.0f;
                return;
            case 905:
                fArr[0] = this.d;
                return;
            default:
                return;
        }
    }

    public int c() {
        return this.b != 902 ? 1 : 4;
    }

    public String toString() {
        String str = this.f489a + ':';
        switch (this.b) {
            case 900:
                return str + this.c;
            case 901:
                return str + this.d;
            case 902:
                return str + a(this.c);
            case 903:
                return str + this.e;
            case 904:
                return str + Boolean.valueOf(this.f);
            case 905:
                return str + this.d;
            default:
                return str + "????";
        }
    }
}
