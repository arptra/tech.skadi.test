package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    public static float l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    public int f476a = 0;
    public final ArrayRow b;
    public final Cache c;
    public int d = 8;
    public SolverVariable e = null;
    public int[] f = new int[8];
    public int[] g = new int[8];
    public float[] h = new float[8];
    public int i = -1;
    public int j = -1;
    public boolean k = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.b = arrayRow;
        this.c = cache;
    }

    public int c() {
        return this.f476a;
    }

    public final void clear() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            SolverVariable solverVariable = this.c.d[this.f[i2]];
            if (solverVariable != null) {
                solverVariable.f(this.b);
            }
            i2 = this.g[i2];
            i3++;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f476a = 0;
    }

    public boolean d(SolverVariable solverVariable) {
        int i2 = this.i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            if (this.f[i2] == solverVariable.c) {
                return true;
            }
            i2 = this.g[i2];
            i3++;
        }
        return false;
    }

    public SolverVariable e(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f476a) {
            if (i4 == i2) {
                return this.c.d[this.f[i3]];
            }
            i3 = this.g[i3];
            i4++;
        }
        return null;
    }

    public final void f(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            k(solverVariable, true);
            return;
        }
        int i2 = this.i;
        if (i2 == -1) {
            this.i = 0;
            this.h[0] = f2;
            this.f[0] = solverVariable.c;
            this.g[0] = -1;
            solverVariable.m++;
            solverVariable.a(this.b);
            this.f476a++;
            if (!this.k) {
                int i3 = this.j + 1;
                this.j = i3;
                int[] iArr = this.f;
                if (i3 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f476a) {
            int i6 = this.f[i2];
            int i7 = solverVariable.c;
            if (i6 == i7) {
                this.h[i2] = f2;
                return;
            }
            if (i6 < i7) {
                i5 = i2;
            }
            i2 = this.g[i2];
            i4++;
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr2 = this.f;
            if (iArr2[i8] != -1) {
                i8 = iArr2.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr3 = this.f;
        if (i8 >= iArr3.length && this.f476a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f;
                if (i10 >= iArr4.length) {
                    break;
                } else if (iArr4[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr5 = this.f;
        if (i8 >= iArr5.length) {
            i8 = iArr5.length;
            int i11 = this.d * 2;
            this.d = i11;
            this.k = false;
            this.j = i8 - 1;
            this.h = Arrays.copyOf(this.h, i11);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i8] = solverVariable.c;
        this.h[i8] = f2;
        if (i5 != -1) {
            int[] iArr6 = this.g;
            iArr6[i8] = iArr6[i5];
            iArr6[i5] = i8;
        } else {
            this.g[i8] = this.i;
            this.i = i8;
        }
        solverVariable.m++;
        solverVariable.a(this.b);
        int i12 = this.f476a + 1;
        this.f476a = i12;
        if (!this.k) {
            this.j++;
        }
        int[] iArr7 = this.f;
        if (i12 >= iArr7.length) {
            this.k = true;
        }
        if (this.j >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    public final float g(SolverVariable solverVariable) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            if (this.f[i2] == solverVariable.c) {
                return this.h[i2];
            }
            i2 = this.g[i2];
            i3++;
        }
        return 0.0f;
    }

    public void h(float f2) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.g[i2];
            i3++;
        }
    }

    public void i(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = l;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.i;
            if (i2 == -1) {
                this.i = 0;
                this.h[0] = f2;
                this.f[0] = solverVariable.c;
                this.g[0] = -1;
                solverVariable.m++;
                solverVariable.a(this.b);
                this.f476a++;
                if (!this.k) {
                    int i3 = this.j + 1;
                    this.j = i3;
                    int[] iArr = this.f;
                    if (i3 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f476a) {
                int i6 = this.f[i2];
                int i7 = solverVariable.c;
                if (i6 == i7) {
                    float[] fArr = this.h;
                    float f4 = fArr[i2] + f2;
                    float f5 = l;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    fArr[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.i) {
                            this.i = this.g[i2];
                        } else {
                            int[] iArr2 = this.g;
                            iArr2[i5] = iArr2[i2];
                        }
                        if (z) {
                            solverVariable.f(this.b);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        solverVariable.m--;
                        this.f476a--;
                        return;
                    }
                    return;
                }
                if (i6 < i7) {
                    i5 = i2;
                }
                i2 = this.g[i2];
                i4++;
            }
            int i8 = this.j;
            int i9 = i8 + 1;
            if (this.k) {
                int[] iArr3 = this.f;
                if (iArr3[i8] != -1) {
                    i8 = iArr3.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr4 = this.f;
            if (i8 >= iArr4.length && this.f476a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f;
                    if (i10 >= iArr5.length) {
                        break;
                    } else if (iArr5[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr6 = this.f;
            if (i8 >= iArr6.length) {
                i8 = iArr6.length;
                int i11 = this.d * 2;
                this.d = i11;
                this.k = false;
                this.j = i8 - 1;
                this.h = Arrays.copyOf(this.h, i11);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i8] = solverVariable.c;
            this.h[i8] = f2;
            if (i5 != -1) {
                int[] iArr7 = this.g;
                iArr7[i8] = iArr7[i5];
                iArr7[i5] = i8;
            } else {
                this.g[i8] = this.i;
                this.i = i8;
            }
            solverVariable.m++;
            solverVariable.a(this.b);
            this.f476a++;
            if (!this.k) {
                this.j++;
            }
            int i12 = this.j;
            int[] iArr8 = this.f;
            if (i12 >= iArr8.length) {
                this.k = true;
                this.j = iArr8.length - 1;
            }
        }
    }

    public void j() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.g[i2];
            i3++;
        }
    }

    public final float k(SolverVariable solverVariable, boolean z) {
        if (this.e == solverVariable) {
            this.e = null;
        }
        int i2 = this.i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f476a) {
            if (this.f[i2] == solverVariable.c) {
                if (i2 == this.i) {
                    this.i = this.g[i2];
                } else {
                    int[] iArr = this.g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.f(this.b);
                }
                solverVariable.m--;
                this.f476a--;
                this.f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public float l(ArrayRow arrayRow, boolean z) {
        float g2 = g(arrayRow.f477a);
        k(arrayRow.f477a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.e;
        int c2 = arrayRowVariables.c();
        for (int i2 = 0; i2 < c2; i2++) {
            SolverVariable e2 = arrayRowVariables.e(i2);
            i(e2, arrayRowVariables.g(e2) * g2, z);
        }
        return g2;
    }

    public float m(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f476a) {
            if (i4 == i2) {
                return this.h[i3];
            }
            i3 = this.g[i3];
            i4++;
        }
        return 0.0f;
    }

    public String toString() {
        int i2 = this.i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f476a) {
            str = ((str + " -> ") + this.h[i2] + " : ") + this.c.d[this.f[i2]];
            i2 = this.g[i2];
            i3++;
        }
        return str;
    }
}
