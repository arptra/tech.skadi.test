package zmq.socket.pubsub;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import zmq.Msg;
import zmq.pipe.Pipe;
import zmq.util.Utils;

class Mtrie {

    /* renamed from: a  reason: collision with root package name */
    public Set f3662a = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public Mtrie[] e = null;

    public interface IMtrieHandler {
        void a(Pipe pipe, byte[] bArr, int i, XPub xPub);
    }

    public boolean a(Msg msg, Pipe pipe) {
        return b(msg, 1, msg.O() - 1, pipe);
    }

    public final boolean b(Msg msg, int i, int i2, Pipe pipe) {
        boolean z = false;
        if (i2 == 0) {
            Set set = this.f3662a;
            if (set == null) {
                z = true;
            }
            if (set == null) {
                this.f3662a = new HashSet();
            }
            this.f3662a.add(pipe);
            return z;
        }
        byte e2 = msg.e(i);
        int i3 = this.b;
        if (e2 < i3 || e2 >= this.c + i3) {
            int i4 = this.c;
            if (i4 == 0) {
                this.b = e2;
                this.c = 1;
                this.e = null;
            } else if (i4 == 1) {
                Mtrie mtrie = this.e[0];
                int i5 = (i3 < e2 ? e2 - i3 : i3 - e2) + 1;
                this.c = i5;
                this.e = new Mtrie[i5];
                int min = Math.min(i3, e2);
                this.b = min;
                this.e[i3 - min] = mtrie;
            } else if (i3 < e2) {
                int i6 = (e2 - i3) + 1;
                this.c = i6;
                this.e = f(this.e, i6, true);
            } else {
                int i7 = (i3 + i4) - e2;
                this.c = i7;
                this.e = f(this.e, i7, false);
                this.b = e2;
            }
        }
        if (this.c == 1) {
            if (this.e == null) {
                Mtrie[] mtrieArr = new Mtrie[1];
                this.e = mtrieArr;
                mtrieArr[0] = new Mtrie();
                this.d++;
            }
            return this.e[0].b(msg, i + 1, i2 - 1, pipe);
        }
        Mtrie[] mtrieArr2 = this.e;
        int i8 = this.b;
        if (mtrieArr2[e2 - i8] == null) {
            mtrieArr2[e2 - i8] = new Mtrie();
            this.d++;
        }
        return this.e[e2 - this.b].b(msg, i + 1, i2 - 1, pipe);
    }

    public final boolean c(Pipe pipe) {
        return b((Msg) null, 0, 0, pipe);
    }

    public final boolean d() {
        return this.f3662a == null && this.d == 0;
    }

    public void e(ByteBuffer byteBuffer, int i, IMtrieHandler iMtrieHandler, XPub xPub) {
        int i2 = 0;
        while (true) {
            Set<Pipe> set = r5.f3662a;
            if (set != null) {
                for (Pipe a2 : set) {
                    iMtrieHandler.a(a2, (byte[]) null, 0, xPub);
                }
            }
            if (i != 0 && r5.c != 0) {
                byte b2 = byteBuffer.get(i2);
                int i3 = r5.c;
                if (i3 != 1) {
                    int i4 = r5.b;
                    if (b2 >= i4 && b2 < i3 + i4) {
                        Mtrie[] mtrieArr = r5.e;
                        if (mtrieArr[b2 - i4] != null) {
                            r5 = mtrieArr[b2 - i4];
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (b2 == r5.b) {
                    r5 = r5.e[0];
                } else {
                    return;
                }
                i2++;
                i--;
            } else {
                return;
            }
        }
    }

    public final Mtrie[] f(Mtrie[] mtrieArr, int i, boolean z) {
        return (Mtrie[]) Utils.i(Mtrie.class, mtrieArr, i, z);
    }

    public boolean g(Msg msg, Pipe pipe) {
        return i(msg, 1, msg.O() - 1, pipe);
    }

    public boolean h(Pipe pipe, IMtrieHandler iMtrieHandler, XPub xPub) {
        return j(pipe, new byte[0], 0, 0, iMtrieHandler, xPub);
    }

    public final boolean i(Msg msg, int i, int i2, Pipe pipe) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1;
        if (i2 == 0) {
            Set set = this.f3662a;
            if (set != null) {
                set.remove(pipe);
                if (this.f3662a.isEmpty()) {
                    this.f3662a = null;
                }
            }
            return this.f3662a == null;
        }
        byte e2 = msg.e(i);
        int i8 = this.c;
        if (i8 == 0 || e2 < (i3 = this.b) || e2 >= i3 + i8) {
            return false;
        }
        Mtrie mtrie = i8 == 1 ? this.e[0] : this.e[e2 - i3];
        if (mtrie == null) {
            return false;
        }
        boolean i9 = mtrie.i(msg, i + 1, i2 - 1, pipe);
        if (mtrie.d()) {
            int i10 = this.c;
            if (i10 == 1) {
                this.e = null;
                this.c = 0;
                this.d--;
            } else {
                Mtrie[] mtrieArr = this.e;
                int i11 = this.b;
                mtrieArr[e2 - i11] = null;
                int i12 = this.d - 1;
                this.d = i12;
                if (i12 == 1) {
                    while (i6 < this.c && this.e[i6] == null) {
                        i6++;
                    }
                    this.b += i6;
                    this.c = 1;
                    this.e = new Mtrie[]{this.e[i6]};
                } else if (e2 == i11) {
                    int i13 = 1;
                    while (true) {
                        i5 = this.c;
                        if (i13 >= i5 || this.e[i13] != null) {
                            this.b += i13;
                            int i14 = i5 - i13;
                            this.c = i14;
                            this.e = f(this.e, i14, true);
                        } else {
                            i13++;
                        }
                    }
                    this.b += i13;
                    int i142 = i5 - i13;
                    this.c = i142;
                    this.e = f(this.e, i142, true);
                } else if (e2 == (i11 + i10) - 1) {
                    while (true) {
                        i4 = this.c;
                        if (i7 >= i4 || this.e[(i4 - 1) - i7] != null) {
                            int i15 = i4 - i7;
                            this.c = i15;
                            this.e = f(this.e, i15, false);
                        } else {
                            i7++;
                        }
                    }
                    int i152 = i4 - i7;
                    this.c = i152;
                    this.e = f(this.e, i152, false);
                }
            }
        }
        return i9;
    }

    public final boolean j(Pipe pipe, byte[] bArr, int i, int i2, IMtrieHandler iMtrieHandler, XPub xPub) {
        int i3;
        int i4;
        int i5;
        int i6;
        byte[] bArr2 = bArr;
        int i7 = i;
        Set set = this.f3662a;
        Pipe pipe2 = pipe;
        if (set == null || !set.remove(pipe2) || !this.f3662a.isEmpty()) {
            IMtrieHandler iMtrieHandler2 = iMtrieHandler;
            XPub xPub2 = xPub;
        } else {
            iMtrieHandler.a((Pipe) null, bArr2, i7, xPub);
            this.f3662a = null;
        }
        int i8 = i2;
        if (i7 >= i8) {
            i8 = i7 + 256;
            bArr2 = Utils.h(bArr2, i8);
        }
        int i9 = i8;
        int i10 = this.c;
        if (i10 == 0) {
            return true;
        }
        if (i10 == 1) {
            bArr2[i7] = (byte) this.b;
            this.e[0].j(pipe, bArr2, i7 + 1, i9, iMtrieHandler, xPub);
            if (this.e[0].d()) {
                this.e = null;
                this.c = 0;
                this.d--;
            }
            return true;
        }
        int i11 = this.b;
        int i12 = (i10 + i11) - 1;
        int i13 = i11;
        int i14 = 0;
        while (true) {
            i3 = this.c;
            if (i14 == i3) {
                break;
            }
            bArr2[i7] = (byte) (this.b + i14);
            Mtrie mtrie = this.e[i14];
            if (mtrie != null) {
                i4 = i14;
                int i15 = i13;
                int i16 = i12;
                mtrie.j(pipe, bArr2, i7 + 1, i9, iMtrieHandler, xPub);
                if (this.e[i4].d()) {
                    this.e[i4] = null;
                    this.d--;
                    i5 = i15;
                    i6 = i16;
                    i12 = i6;
                } else {
                    int i17 = this.b;
                    int i18 = i16;
                    i12 = i4 + i17 < i18 ? i4 + i17 : i18;
                    i5 = i15;
                    if (i4 + i17 > i5) {
                        i13 = i4 + i17;
                        i14 = i4 + 1;
                    }
                }
            } else {
                i4 = i14;
                i5 = i13;
                i6 = i12;
                i12 = i6;
            }
            i13 = i5;
            i14 = i4 + 1;
        }
        int i19 = i13;
        int i20 = i12;
        int i21 = this.d;
        if (i21 == 0) {
            this.e = null;
            this.c = 0;
        } else if (i21 == 1) {
            this.e = new Mtrie[]{this.e[i20 - this.b]};
            this.c = 1;
            this.b = i20;
        } else {
            int i22 = this.b;
            if (i20 > i22 || i19 < (i3 + i22) - 1) {
                Mtrie[] mtrieArr = this.e;
                int i23 = (i19 - i20) + 1;
                this.c = i23;
                Mtrie[] mtrieArr2 = new Mtrie[i23];
                this.e = mtrieArr2;
                System.arraycopy(mtrieArr, i20 - i22, mtrieArr2, 0, i23);
                this.b = i20;
            }
        }
        return true;
    }
}
