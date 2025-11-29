package kotlinx.serialization.json.internal;

import com.meizu.common.widget.CircularProgressButton;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010(R\u0016\u0010+\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010*¨\u0006,"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToJavaStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "", "value", "", "writeLong", "(J)V", "", "char", "a", "(C)V", "", "text", "write", "(Ljava/lang/String;)V", "b", "", "currentSize", "string", "c", "(ILjava/lang/String;)V", "oldSize", "additional", "d", "(II)I", "e", "()V", "", "count", "f", "([CI)V", "codePoint", "g", "(I)V", "Ljava/io/OutputStream;", "Ljava/io/OutputStream;", "stream", "", "[B", "buffer", "[C", "charArray", "I", "indexInBuffer", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nJvmJsonStreams.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmJsonStreams.kt\nkotlinx/serialization/json/internal/JsonToJavaStreamWriter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,268:1\n130#1:269\n117#1:271\n130#1:272\n118#1,3:273\n125#1,2:276\n130#1:278\n125#1,2:279\n117#1:281\n130#1:282\n118#1,3:283\n125#1,2:286\n125#1,2:288\n117#1:290\n130#1:291\n118#1,3:292\n125#1,2:295\n125#1,2:297\n125#1,2:299\n117#1:301\n130#1:302\n118#1,3:303\n125#1,2:306\n117#1:308\n130#1:309\n118#1,3:310\n125#1,2:313\n125#1,2:315\n125#1,2:317\n125#1,2:319\n117#1:321\n130#1:322\n118#1,3:323\n125#1,2:326\n117#1:328\n130#1:329\n118#1,3:330\n125#1,2:333\n125#1,2:335\n117#1:337\n130#1:338\n118#1,3:339\n125#1,2:342\n117#1:344\n130#1:345\n118#1,3:346\n125#1,2:349\n125#1,2:351\n125#1,2:353\n117#1:355\n130#1:356\n118#1,3:357\n125#1,2:360\n125#1,2:362\n125#1,2:364\n125#1,2:366\n1#2:270\n*S KotlinDebug\n*F\n+ 1 JvmJsonStreams.kt\nkotlinx/serialization/json/internal/JsonToJavaStreamWriter\n*L\n117#1:269\n148#1:271\n148#1:272\n148#1:273,3\n149#1:276,2\n151#1:278\n158#1:279,2\n165#1:281\n165#1:282\n165#1:283,3\n166#1:286,2\n167#1:288,2\n173#1:290\n173#1:291\n173#1:292,3\n174#1:295,2\n175#1:297,2\n176#1:299,2\n186#1:301\n186#1:302\n186#1:303,3\n187#1:306,2\n196#1:308\n196#1:309\n196#1:310,3\n197#1:313,2\n198#1:315,2\n199#1:317,2\n200#1:319,2\n215#1:321\n215#1:322\n215#1:323,3\n216#1:326,2\n221#1:328\n221#1:329\n221#1:330,3\n222#1:333,2\n223#1:335,2\n228#1:337\n228#1:338\n228#1:339,3\n229#1:342,2\n234#1:344\n234#1:345\n234#1:346,3\n235#1:349,2\n236#1:351,2\n237#1:353,2\n242#1:355\n242#1:356\n242#1:357,3\n243#1:360,2\n244#1:362,2\n245#1:364,2\n246#1:366,2\n*E\n"})
public final class JsonToJavaStreamWriter implements InternalJsonWriter {

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f4113a;
    public final byte[] b;
    public char[] c;
    public int d;

    public void a(char c2) {
        g(c2);
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        d(0, str.length() + 2);
        char[] cArr = this.c;
        cArr[0] = '\"';
        int length = str.length();
        int i = 1;
        str.getChars(0, length, cArr, 1);
        int i2 = length + 1;
        while (i < i2) {
            char c2 = cArr[i];
            if (c2 >= StringOpsKt.a().length || StringOpsKt.a()[c2] == 0) {
                i++;
            } else {
                c(i, str);
                return;
            }
        }
        cArr[i2] = '\"';
        f(cArr, length + 2);
        e();
    }

    public final void c(int i, String str) {
        int i2;
        int length = str.length();
        for (int i3 = i - 1; i3 < length; i3++) {
            int d2 = d(i, 2);
            char charAt = str.charAt(i3);
            if (charAt < StringOpsKt.a().length) {
                byte b2 = StringOpsKt.a()[charAt];
                if (b2 == 0) {
                    i2 = d2 + 1;
                    this.c[d2] = (char) charAt;
                } else {
                    if (b2 == 1) {
                        String str2 = StringOpsKt.b()[charAt];
                        Intrinsics.checkNotNull(str2);
                        int d3 = d(d2, str2.length());
                        str2.getChars(0, str2.length(), this.c, d3);
                        i = d3 + str2.length();
                    } else {
                        char[] cArr = this.c;
                        cArr[d2] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr[d2 + 1] = (char) b2;
                        i = d2 + 2;
                    }
                }
            } else {
                i2 = d2 + 1;
                this.c[d2] = (char) charAt;
            }
            i = i2;
        }
        d(i, 1);
        char[] cArr2 = this.c;
        cArr2[i] = '\"';
        f(cArr2, i + 1);
        e();
    }

    public final int d(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.c;
        if (cArr.length <= i3) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i3, i * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.c = copyOf;
        }
        return i;
    }

    public final void e() {
        this.f4113a.write(this.b, 0, this.d);
        this.d = 0;
    }

    public final void f(char[] cArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0".toString());
        } else if (i <= cArr.length) {
            int i2 = 0;
            while (i2 < i) {
                char c2 = cArr[i2];
                if (c2 < 128) {
                    if (this.b.length - this.d < 1) {
                        e();
                    }
                    byte[] bArr = this.b;
                    int i3 = this.d;
                    int i4 = i3 + 1;
                    this.d = i4;
                    bArr[i3] = (byte) c2;
                    i2++;
                    int min = Math.min(i, (bArr.length - i4) + i2);
                    while (i2 < min) {
                        char c3 = cArr[i2];
                        if (c3 >= 128) {
                            break;
                        }
                        byte[] bArr2 = this.b;
                        int i5 = this.d;
                        this.d = i5 + 1;
                        bArr2[i5] = (byte) c3;
                        i2++;
                    }
                } else {
                    if (c2 < 2048) {
                        if (this.b.length - this.d < 2) {
                            e();
                        }
                        byte[] bArr3 = this.b;
                        int i6 = this.d;
                        bArr3[i6] = (byte) ((c2 >> 6) | 192);
                        this.d = i6 + 2;
                        bArr3[i6 + 1] = (byte) ((c2 & '?') | 128);
                    } else if (c2 < 55296 || c2 > 57343) {
                        if (this.b.length - this.d < 3) {
                            e();
                        }
                        byte[] bArr4 = this.b;
                        int i7 = this.d;
                        bArr4[i7] = (byte) ((c2 >> 12) | 224);
                        bArr4[i7 + 1] = (byte) (((c2 >> 6) & 63) | 128);
                        this.d = i7 + 3;
                        bArr4[i7 + 2] = (byte) ((c2 & '?') | 128);
                    } else {
                        int i8 = i2 + 1;
                        char c4 = i8 < i ? cArr[i8] : 0;
                        if (c2 > 56319 || 56320 > c4 || c4 >= 57344) {
                            if (this.b.length - this.d < 1) {
                                e();
                            }
                            byte[] bArr5 = this.b;
                            int i9 = this.d;
                            this.d = i9 + 1;
                            bArr5[i9] = (byte) 63;
                            i2 = i8;
                        } else {
                            int i10 = (((c2 & 1023) << 10) | (c4 & 1023)) + 0;
                            if (this.b.length - this.d < 4) {
                                e();
                            }
                            int i11 = (i10 >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL;
                            byte[] bArr6 = this.b;
                            int i12 = this.d;
                            bArr6[i12] = (byte) i11;
                            bArr6[i12 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr6[i12 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            this.d = i12 + 4;
                            bArr6[i12 + 3] = (byte) ((i10 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
        } else {
            throw new IllegalArgumentException(("count > string.length: " + i + " > " + cArr.length).toString());
        }
    }

    public final void g(int i) {
        if (i < 128) {
            if (this.b.length - this.d < 1) {
                e();
            }
            byte[] bArr = this.b;
            int i2 = this.d;
            this.d = i2 + 1;
            bArr[i2] = (byte) i;
        } else if (i < 2048) {
            if (this.b.length - this.d < 2) {
                e();
            }
            byte[] bArr2 = this.b;
            int i3 = this.d;
            bArr2[i3] = (byte) ((i >> 6) | 192);
            this.d = i3 + 2;
            bArr2[i3 + 1] = (byte) ((i & 63) | 128);
        } else if (55296 <= i && i < 57344) {
            if (this.b.length - this.d < 1) {
                e();
            }
            byte[] bArr3 = this.b;
            int i4 = this.d;
            this.d = i4 + 1;
            bArr3[i4] = (byte) 63;
        } else if (i < 65536) {
            if (this.b.length - this.d < 3) {
                e();
            }
            byte[] bArr4 = this.b;
            int i5 = this.d;
            bArr4[i5] = (byte) ((i >> 12) | 224);
            bArr4[i5 + 1] = (byte) (((i >> 6) & 63) | 128);
            this.d = i5 + 3;
            bArr4[i5 + 2] = (byte) ((i & 63) | 128);
        } else if (i <= 1114111) {
            if (this.b.length - this.d < 4) {
                e();
            }
            int i6 = (i >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL;
            byte[] bArr5 = this.b;
            int i7 = this.d;
            bArr5[i7] = (byte) i6;
            bArr5[i7 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr5[i7 + 2] = (byte) (((i >> 6) & 63) | 128);
            this.d = i7 + 4;
            bArr5[i7 + 3] = (byte) ((i & 63) | 128);
        } else {
            throw new JsonEncodingException("Unexpected code point: " + i);
        }
    }

    public void write(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        int length = str.length();
        d(0, length);
        str.getChars(0, length, this.c, 0);
        f(this.c, length);
    }

    public void writeLong(long j) {
        write(String.valueOf(j));
    }
}
