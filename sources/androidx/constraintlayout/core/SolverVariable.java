package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {
    public static int r = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f484a;
    public String b;
    public int c = -1;
    public int d = -1;
    public int e = 0;
    public float f;
    public boolean g = false;
    public float[] h = new float[9];
    public float[] i = new float[9];
    public Type j;
    public ArrayRow[] k = new ArrayRow[16];
    public int l = 0;
    public int m = 0;
    public boolean n = false;
    public int o = -1;
    public float p = 0.0f;
    public HashSet q = null;

    /* renamed from: androidx.constraintlayout.core.SolverVariable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f485a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.SolverVariable$Type[] r0 = androidx.constraintlayout.core.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f485a = r0
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f485a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f485a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f485a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f485a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.j = type;
    }

    public static void d() {
        r++;
    }

    public final void a(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i3 = this.l;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.k;
                if (i3 >= arrayRowArr.length) {
                    this.k = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.k;
                int i4 = this.l;
                arrayRowArr2[i4] = arrayRow;
                this.l = i4 + 1;
                return;
            } else if (this.k[i2] != arrayRow) {
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public int compareTo(SolverVariable solverVariable) {
        return this.c - solverVariable.c;
    }

    public final void f(ArrayRow arrayRow) {
        int i2 = this.l;
        int i3 = 0;
        while (i3 < i2) {
            if (this.k[i3] == arrayRow) {
                while (i3 < i2 - 1) {
                    ArrayRow[] arrayRowArr = this.k;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.l--;
                return;
            }
            i3++;
        }
    }

    public void g() {
        this.b = null;
        this.j = Type.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i2 = this.l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3] = null;
        }
        this.l = 0;
        this.m = 0;
        this.f484a = false;
        Arrays.fill(this.i, 0.0f);
    }

    public void h(LinearSystem linearSystem, float f2) {
        this.f = f2;
        this.g = true;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i2 = this.l;
        this.d = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3].A(linearSystem, this, false);
        }
        this.l = 0;
    }

    public void i(Type type, String str) {
        this.j = type;
    }

    public final void j(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i2 = this.l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3].B(linearSystem, arrayRow, false);
        }
        this.l = 0;
    }

    public String toString() {
        if (this.b != null) {
            return "" + this.b;
        }
        return "" + this.c;
    }
}
