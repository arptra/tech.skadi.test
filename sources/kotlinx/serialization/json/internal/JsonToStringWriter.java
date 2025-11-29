package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\"¨\u0006$"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToStringWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "", "oldSize", "additional", "e", "(II)I", "", "value", "", "writeLong", "(J)V", "", "char", "a", "(C)V", "", "text", "write", "(Ljava/lang/String;)V", "b", "toString", "()Ljava/lang/String;", "firstEscapedChar", "currentSize", "string", "c", "(IILjava/lang/String;)V", "expected", "d", "(I)V", "", "[C", "array", "I", "size", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonToStringWriter implements InternalJsonWriter {

    /* renamed from: a  reason: collision with root package name */
    public char[] f4114a;
    public int b;

    private final int e(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.f4114a;
        if (cArr.length <= i3) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i3, i * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.f4114a = copyOf;
        }
        return i;
    }

    public void a(char c) {
        d(1);
        char[] cArr = this.f4114a;
        int i = this.b;
        this.b = i + 1;
        cArr[i] = c;
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        d(str.length() + 2);
        char[] cArr = this.f4114a;
        int i = this.b;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            if (c >= StringOpsKt.a().length || StringOpsKt.a()[c] == 0) {
                i4++;
            } else {
                c(i4 - i2, i4, str);
                return;
            }
        }
        cArr[i3] = '\"';
        this.b = i3 + 1;
    }

    public final void c(int i, int i2, String str) {
        int i3;
        int length = str.length();
        while (i < length) {
            int e = e(i2, 2);
            char charAt = str.charAt(i);
            if (charAt < StringOpsKt.a().length) {
                byte b2 = StringOpsKt.a()[charAt];
                if (b2 == 0) {
                    i3 = e + 1;
                    this.f4114a[e] = (char) charAt;
                } else {
                    if (b2 == 1) {
                        String str2 = StringOpsKt.b()[charAt];
                        Intrinsics.checkNotNull(str2);
                        int e2 = e(e, str2.length());
                        str2.getChars(0, str2.length(), this.f4114a, e2);
                        i2 = e2 + str2.length();
                        this.b = i2;
                    } else {
                        char[] cArr = this.f4114a;
                        cArr[e] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr[e + 1] = (char) b2;
                        i2 = e + 2;
                        this.b = i2;
                    }
                    i++;
                }
            } else {
                i3 = e + 1;
                this.f4114a[e] = (char) charAt;
            }
            i2 = i3;
            i++;
        }
        int e3 = e(i2, 1);
        this.f4114a[e3] = '\"';
        this.b = e3 + 1;
    }

    public final void d(int i) {
        e(this.b, i);
    }

    public String toString() {
        return new String(this.f4114a, 0, this.b);
    }

    public void write(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        int length = str.length();
        if (length != 0) {
            d(length);
            str.getChars(0, str.length(), this.f4114a, this.b);
            this.b += length;
        }
    }

    public void writeLong(long j) {
        write(String.valueOf(j));
    }
}
