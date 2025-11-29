package kotlinx.serialization.json.internal;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/CharsetReader;", "", "", "array", "", "offset", "length", "d", "([CII)I", "a", "b", "()I", "c", "Ljava/io/InputStream;", "Ljava/io/InputStream;", "inputStream", "Ljava/nio/charset/CharsetDecoder;", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuffer", "", "Z", "hasLeftoverPotentiallySurrogateChar", "", "e", "C", "leftoverChar", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class CharsetReader {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f4101a;
    public final CharsetDecoder b;
    public final ByteBuffer c;
    public boolean d;
    public char e;

    public final int a(char[] cArr, int i, int i2) {
        CharBuffer wrap = CharBuffer.wrap(cArr, i, i2);
        if (wrap.position() != 0) {
            wrap = wrap.slice();
        }
        boolean z = false;
        while (true) {
            CoderResult decode = this.b.decode(this.c, wrap, z);
            if (decode.isUnderflow()) {
                if (!z && wrap.hasRemaining()) {
                    if (b() < 0) {
                        if (wrap.position() == 0 && !this.c.hasRemaining()) {
                            z = true;
                            break;
                        }
                        this.b.reset();
                        z = true;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            } else if (decode.isOverflow()) {
                wrap.position();
                break;
            } else {
                decode.throwException();
            }
        }
        if (z) {
            this.b.reset();
        }
        if (wrap.position() == 0) {
            return -1;
        }
        return wrap.position();
    }

    public final int b() {
        this.c.compact();
        try {
            int limit = this.c.limit();
            int position = this.c.position();
            int read = this.f4101a.read(this.c.array(), this.c.arrayOffset() + position, position <= limit ? limit - position : 0);
            if (read < 0) {
                return read;
            }
            ByteBuffer byteBuffer = this.c;
            Intrinsics.checkNotNull(byteBuffer, "null cannot be cast to non-null type java.nio.Buffer");
            byteBuffer.position(position + read);
            this.c.flip();
            return this.c.remaining();
        } finally {
            this.c.flip();
        }
    }

    public final int c() {
        if (this.d) {
            this.d = false;
            return this.e;
        }
        char[] cArr = new char[2];
        int d2 = d(cArr, 0, 2);
        if (d2 == -1) {
            return -1;
        }
        if (d2 == 1) {
            return cArr[0];
        }
        if (d2 == 2) {
            this.e = cArr[1];
            this.d = true;
            return cArr[0];
        }
        throw new IllegalStateException(("Unreachable state: " + d2).toString());
    }

    public final int d(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i < 0 || i >= cArr.length || i2 < 0 || i + i2 > cArr.length) {
            throw new IllegalArgumentException(("Unexpected arguments: " + i + ", " + i2 + ", " + cArr.length).toString());
        }
        if (this.d) {
            cArr[i] = this.e;
            i++;
            i2--;
            this.d = false;
            if (i2 == 0) {
                return 1;
            }
            i3 = 1;
        }
        if (i2 != 1) {
            return a(cArr, i, i2) + i3;
        }
        int c2 = c();
        if (c2 != -1) {
            cArr[i] = (char) c2;
            return i3 + 1;
        } else if (i3 == 0) {
            return -1;
        } else {
            return i3;
        }
    }
}
