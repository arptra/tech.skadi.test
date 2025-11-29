package javax.obex;

import com.meizu.common.widget.CircularProgressButton;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Calendar;

public final class HeaderSet {

    /* renamed from: a  reason: collision with root package name */
    public Long f3690a;
    public String b;
    public boolean c;
    public String d;
    public Long e;
    public Calendar f;
    public Calendar g;
    public String h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public String[] n = new String[16];
    public byte[][] o = new byte[16][];
    public Byte[] p = new Byte[16];
    public Long[] q = new Long[16];
    public final SecureRandom r = new SecureRandom();
    public byte[] s;
    public byte[] t;
    public byte[] u;
    public byte[] v;
    public int w = -1;

    public boolean a() {
        return this.c;
    }

    public Object b(int i2) {
        if (i2 == 1) {
            return this.b;
        }
        if (i2 == 5) {
            return this.h;
        }
        if (i2 == 66) {
            return this.d;
        }
        if (i2 == 68) {
            return this.f;
        }
        if (i2 == 74) {
            return this.k;
        }
        if (i2 == 76) {
            return this.l;
        }
        if (i2 == 79) {
            return this.m;
        }
        if (i2 == 192) {
            return this.f3690a;
        }
        if (i2 == 203) {
            return this.v;
        }
        if (i2 == 70) {
            return this.i;
        }
        if (i2 == 71) {
            return this.j;
        }
        if (i2 == 195) {
            return this.e;
        }
        if (i2 == 196) {
            return this.g;
        }
        if (i2 >= 48 && i2 <= 63) {
            return this.n[i2 - 48];
        }
        if (i2 >= 112 && i2 <= 127) {
            return this.o[i2 - 112];
        }
        if (i2 >= 176 && i2 <= 191) {
            return this.p[i2 - 176];
        }
        if (i2 >= 240 && i2 <= 255) {
            return this.q[i2 - CircularProgressButton.MorphingAnimation.DURATION_NORMAL];
        }
        throw new IllegalArgumentException("Invalid Header Identifier");
    }

    public int[] c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f3690a != null) {
            byteArrayOutputStream.write(192);
        }
        if (this.b != null) {
            byteArrayOutputStream.write(1);
        }
        if (this.d != null) {
            byteArrayOutputStream.write(66);
        }
        if (this.e != null) {
            byteArrayOutputStream.write(195);
        }
        if (this.f != null) {
            byteArrayOutputStream.write(68);
        }
        if (this.g != null) {
            byteArrayOutputStream.write(196);
        }
        if (this.h != null) {
            byteArrayOutputStream.write(5);
        }
        if (this.i != null) {
            byteArrayOutputStream.write(70);
        }
        if (this.j != null) {
            byteArrayOutputStream.write(71);
        }
        if (this.k != null) {
            byteArrayOutputStream.write(74);
        }
        if (this.l != null) {
            byteArrayOutputStream.write(76);
        }
        if (this.m != null) {
            byteArrayOutputStream.write(79);
        }
        for (int i2 = 48; i2 < 64; i2++) {
            if (this.n[i2 - 48] != null) {
                byteArrayOutputStream.write(i2);
            }
        }
        for (int i3 = 112; i3 < 128; i3++) {
            if (this.o[i3 - 112] != null) {
                byteArrayOutputStream.write(i3);
            }
        }
        for (int i4 = 176; i4 < 192; i4++) {
            if (this.p[i4 - 176] != null) {
                byteArrayOutputStream.write(i4);
            }
        }
        for (int i5 = CircularProgressButton.MorphingAnimation.DURATION_NORMAL; i5 < 256; i5++) {
            if (this.q[i5 - 240] != null) {
                byteArrayOutputStream.write(i5);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i6 = 0; i6 < byteArray.length; i6++) {
            iArr[i6] = byteArray[i6] & 255;
        }
        return iArr;
    }

    public int d() {
        int i2 = this.w;
        if (i2 != -1) {
            return i2;
        }
        throw new IOException("May not be called on a server");
    }

    public void e(int i2, Object obj) {
        if (i2 != 1) {
            if (i2 != 5) {
                if (i2 != 66) {
                    if (i2 != 68) {
                        if (i2 != 74) {
                            if (i2 != 76) {
                                if (i2 != 79) {
                                    if (i2 != 192) {
                                        if (i2 != 70) {
                                            if (i2 != 71) {
                                                if (i2 != 195) {
                                                    if (i2 != 196) {
                                                        if (i2 < 48 || i2 > 63) {
                                                            if (i2 < 112 || i2 > 127) {
                                                                if (i2 < 176 || i2 > 191) {
                                                                    if (i2 < 240 || i2 > 255) {
                                                                        throw new IllegalArgumentException("Invalid Header Identifier");
                                                                    } else if (obj instanceof Long) {
                                                                        Long l2 = (Long) obj;
                                                                        long longValue = l2.longValue();
                                                                        if (longValue < 0 || longValue > 4294967295L) {
                                                                            throw new IllegalArgumentException("Integer User Defined must be between 0 and 0xFFFFFFFF");
                                                                        }
                                                                        this.q[i2 - CircularProgressButton.MorphingAnimation.DURATION_NORMAL] = l2;
                                                                    } else if (obj == null) {
                                                                        this.q[i2 - CircularProgressButton.MorphingAnimation.DURATION_NORMAL] = null;
                                                                    } else {
                                                                        throw new IllegalArgumentException("Integer User Defined must be a Long");
                                                                    }
                                                                } else if (obj == null || (obj instanceof Byte)) {
                                                                    this.p[i2 - 176] = (Byte) obj;
                                                                } else {
                                                                    throw new IllegalArgumentException("ByteUser Defined must be a Byte");
                                                                }
                                                            } else if (obj == null) {
                                                                this.o[i2 - 112] = null;
                                                            } else if (obj instanceof byte[]) {
                                                                byte[] bArr = new byte[((byte[]) obj).length];
                                                                this.o[i2 - 112] = bArr;
                                                                System.arraycopy(obj, 0, bArr, 0, bArr.length);
                                                            } else {
                                                                throw new IllegalArgumentException("Byte Sequence User Defined must be a byte array");
                                                            }
                                                        } else if (obj == null || (obj instanceof String)) {
                                                            this.n[i2 - 48] = (String) obj;
                                                        } else {
                                                            throw new IllegalArgumentException("Unicode String User Defined must be a String");
                                                        }
                                                    } else if (obj == null || (obj instanceof Calendar)) {
                                                        this.g = (Calendar) obj;
                                                    } else {
                                                        throw new IllegalArgumentException("Time 4 Byte must be a Calendar");
                                                    }
                                                } else if (obj instanceof Long) {
                                                    Long l3 = (Long) obj;
                                                    long longValue2 = l3.longValue();
                                                    if (longValue2 < 0 || longValue2 > 4294967295L) {
                                                        throw new IllegalArgumentException("Length must be between 0 and 0xFFFFFFFF");
                                                    }
                                                    this.e = l3;
                                                } else if (obj == null) {
                                                    this.e = null;
                                                } else {
                                                    throw new IllegalArgumentException("Length must be a Long");
                                                }
                                            } else if (obj == null) {
                                                this.j = null;
                                            } else if (obj instanceof byte[]) {
                                                byte[] bArr2 = new byte[((byte[]) obj).length];
                                                this.j = bArr2;
                                                System.arraycopy(obj, 0, bArr2, 0, bArr2.length);
                                            } else {
                                                throw new IllegalArgumentException("HTTP must be a byte array");
                                            }
                                        } else if (obj == null) {
                                            this.i = null;
                                        } else if (obj instanceof byte[]) {
                                            byte[] bArr3 = new byte[((byte[]) obj).length];
                                            this.i = bArr3;
                                            System.arraycopy(obj, 0, bArr3, 0, bArr3.length);
                                        } else {
                                            throw new IllegalArgumentException("Target must be a byte array");
                                        }
                                    } else if (obj instanceof Long) {
                                        Long l4 = (Long) obj;
                                        long longValue3 = l4.longValue();
                                        if (longValue3 < 0 || longValue3 > 4294967295L) {
                                            throw new IllegalArgumentException("Count must be between 0 and 0xFFFFFFFF");
                                        }
                                        this.f3690a = l4;
                                    } else if (obj == null) {
                                        this.f3690a = null;
                                    } else {
                                        throw new IllegalArgumentException("Count must be a Long");
                                    }
                                } else if (obj == null) {
                                    this.m = null;
                                } else if (obj instanceof byte[]) {
                                    byte[] bArr4 = new byte[((byte[]) obj).length];
                                    this.m = bArr4;
                                    System.arraycopy(obj, 0, bArr4, 0, bArr4.length);
                                } else {
                                    throw new IllegalArgumentException("Object Class must be a byte array");
                                }
                            } else if (obj == null) {
                                this.l = null;
                            } else if (obj instanceof byte[]) {
                                byte[] bArr5 = new byte[((byte[]) obj).length];
                                this.l = bArr5;
                                System.arraycopy(obj, 0, bArr5, 0, bArr5.length);
                            } else {
                                throw new IllegalArgumentException("Application Parameter must be a byte array");
                            }
                        } else if (obj == null) {
                            this.k = null;
                        } else if (obj instanceof byte[]) {
                            byte[] bArr6 = new byte[((byte[]) obj).length];
                            this.k = bArr6;
                            System.arraycopy(obj, 0, bArr6, 0, bArr6.length);
                        } else {
                            throw new IllegalArgumentException("WHO must be a byte array");
                        }
                    } else if (obj == null || (obj instanceof Calendar)) {
                        this.f = (Calendar) obj;
                    } else {
                        throw new IllegalArgumentException("Time ISO 8601 must be a Calendar");
                    }
                } else if (obj == null || (obj instanceof String)) {
                    this.d = (String) obj;
                } else {
                    throw new IllegalArgumentException("Type must be a String");
                }
            } else if (obj == null || (obj instanceof String)) {
                this.h = (String) obj;
            } else {
                throw new IllegalArgumentException("Description must be a String");
            }
        } else if (obj == null || (obj instanceof String)) {
            this.c = false;
            this.b = (String) obj;
        } else {
            throw new IllegalArgumentException("Name must be a String");
        }
    }
}
