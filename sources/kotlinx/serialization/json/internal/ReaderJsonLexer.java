package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00101\u001a\u00020,8\u0014X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "O", "()Z", "e", "", "position", "J", "(I)I", "", "j", "()B", "", "u", "()V", "", "i", "()Ljava/lang/String;", "", "char", "startPos", "U", "(CI)I", "endPos", "M", "(II)Ljava/lang/String;", "fromIndex", "toIndex", "d", "(II)V", "keyToMatch", "isLenient", "G", "(Ljava/lang/String;Z)Ljava/lang/String;", "unprocessedCount", "V", "(I)V", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "reader", "f", "I", "threshold", "Lkotlinx/serialization/json/internal/ArrayAsSequence;", "g", "Lkotlinx/serialization/json/internal/ArrayAsSequence;", "T", "()Lkotlinx/serialization/json/internal/ArrayAsSequence;", "source", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class ReaderJsonLexer extends AbstractJsonLexer {
    public final InternalJsonReader e;
    public int f;
    public final ArrayAsSequence g;

    public String G(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "keyToMatch");
        return null;
    }

    public int J(int i) {
        if (i < D().length()) {
            return i;
        }
        this.f4093a = i;
        u();
        return (this.f4093a != 0 || D().length() == 0) ? -1 : 0;
    }

    public String M(int i, int i2) {
        return D().e(i, i2);
    }

    public boolean O() {
        int L = L();
        if (L >= D().length() || L == -1 || D().charAt(L) != ',') {
            return false;
        }
        this.f4093a++;
        return true;
    }

    /* renamed from: T */
    public ArrayAsSequence D() {
        return this.g;
    }

    public int U(char c, int i) {
        ArrayAsSequence T = D();
        int length = T.length();
        while (i < length) {
            if (T.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final void V(int i) {
        char[] b = D().b();
        if (i != 0) {
            int i2 = this.f4093a;
            ArraysKt.copyInto(b, b, 0, i2, i2 + i);
        }
        int length = D().length();
        while (true) {
            if (i == length) {
                break;
            }
            int a2 = this.e.a(b, i, length - i);
            if (a2 == -1) {
                D().f(i);
                this.f = -1;
                break;
            }
            i += a2;
        }
        this.f4093a = 0;
    }

    public void d(int i, int i2) {
        StringBuilder C = C();
        C.append(D().b(), i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(C, "append(...)");
    }

    public boolean e() {
        u();
        int i = this.f4093a;
        while (true) {
            int J = J(i);
            if (J != -1) {
                char charAt = D().charAt(J);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i = J + 1;
                } else {
                    this.f4093a = J;
                    return F(charAt);
                }
            } else {
                this.f4093a = J;
                return false;
            }
        }
    }

    public String i() {
        l('\"');
        int i = this.f4093a;
        int U = U('\"', i);
        if (U == -1) {
            int J = J(i);
            if (J != -1) {
                return p(D(), this.f4093a, J);
            }
            AbstractJsonLexer.z(this, (byte) 1, false, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        for (int i2 = i; i2 < U; i2++) {
            if (D().charAt(i2) == '\\') {
                return p(D(), this.f4093a, i2);
            }
        }
        this.f4093a = U + 1;
        return M(i, U);
    }

    public byte j() {
        u();
        ArrayAsSequence T = D();
        int i = this.f4093a;
        while (true) {
            int J = J(i);
            if (J != -1) {
                int i2 = J + 1;
                byte a2 = AbstractJsonLexerKt.a(T.charAt(J));
                if (a2 != 3) {
                    this.f4093a = i2;
                    return a2;
                }
                i = i2;
            } else {
                this.f4093a = J;
                return 10;
            }
        }
    }

    public void u() {
        int length = D().length() - this.f4093a;
        if (length <= this.f) {
            V(length);
        }
    }
}
