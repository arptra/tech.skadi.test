package kotlinx.serialization.json.internal;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b&\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010\u0003J\r\u0010#\u001a\u00020\u000f¢\u0006\u0004\b#\u0010\u0011J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010\u0014J\u000f\u0010&\u001a\u00020\u000fH&¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010'\u001a\u00020\u000fH&¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020+H\u0004¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u001f¢\u0006\u0004\b.\u0010\u0003J\u0015\u00100\u001a\u00020(2\u0006\u0010/\u001a\u00020(¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020+H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020+H\u0004¢\u0006\u0004\b4\u00103J!\u00108\u001a\u0002072\u0006\u00105\u001a\u00020(2\b\b\u0002\u00106\u001a\u00020\u000fH\u0000¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020(¢\u0006\u0004\b:\u0010*J\u0017\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u0010?J!\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u000fH&¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u0004\u0018\u00010\n2\u0006\u0010A\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u001f¢\u0006\u0004\bF\u0010\u0003J\u001f\u0010H\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010\fJ\u000f\u0010I\u001a\u00020\nH&¢\u0006\u0004\bI\u0010\u000eJ\r\u0010J\u001a\u00020\n¢\u0006\u0004\bJ\u0010\u000eJ'\u0010K\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0005¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020\n¢\u0006\u0004\bM\u0010\u000eJ\r\u0010N\u001a\u00020\n¢\u0006\u0004\bN\u0010\u000eJ\u001f\u0010Q\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0014¢\u0006\u0004\bQ\u0010RJ\u0015\u0010T\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u000f¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010\u000eJ\u0015\u0010X\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020\n¢\u0006\u0004\bX\u0010YJ)\u0010\\\u001a\u0002072\u0006\u0010Z\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\n¢\u0006\u0004\b\\\u0010]J\r\u0010_\u001a\u00020^¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020\u000f¢\u0006\u0004\ba\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010DR\u0014\u0010d\u001a\u00020b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010eR&\u0010n\u001a\u00060gj\u0002`h8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bQ\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0014\u0010\u0016\u001a\u00020\u00158$X¤\u0004¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006q"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", "", "lastPosition", "current", "b", "(II)I", "currentPosition", "", "s", "(II)Ljava/lang/String;", "N", "()Ljava/lang/String;", "", "S", "()Z", "startPosition", "a", "(I)I", "", "source", "startPos", "c", "(Ljava/lang/CharSequence;I)I", "B", "start", "f", "(I)Z", "literalSuffix", "", "h", "(Ljava/lang/String;I)V", "u", "E", "position", "J", "O", "e", "", "j", "()B", "", "F", "(C)Z", "v", "expected", "k", "(B)B", "l", "(C)V", "R", "expectedToken", "wasConsumed", "", "y", "(BZ)Ljava/lang/Void;", "H", "doConsume", "P", "(Z)Z", "L", "()I", "keyToMatch", "isLenient", "G", "(Ljava/lang/String;Z)Ljava/lang/String;", "I", "(Z)Ljava/lang/String;", "t", "endPos", "M", "i", "o", "p", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "r", "q", "fromIndex", "toIndex", "d", "(II)V", "allowLenientStrings", "K", "(Z)V", "toString", "key", "A", "(Ljava/lang/String;)V", "message", "hint", "w", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", "", "m", "()J", "g", "Lkotlinx/serialization/json/internal/JsonPath;", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Ljava/lang/String;", "peekedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "C", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "escapedString", "D", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAbstractJsonLexer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractJsonLexer.kt\nkotlinx/serialization/json/internal/AbstractJsonLexer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,765:1\n757#1,5:766\n1#2:771\n*S KotlinDebug\n*F\n+ 1 AbstractJsonLexer.kt\nkotlinx/serialization/json/internal/AbstractJsonLexer\n*L\n218#1:766,5\n*E\n"})
public abstract class AbstractJsonLexer {

    /* renamed from: a  reason: collision with root package name */
    public int f4093a;
    public final JsonPath b = new JsonPath();
    public String c;
    public StringBuilder d = new StringBuilder();

    public static /* synthetic */ boolean Q(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return abstractJsonLexer.P(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
    }

    public static final double n(long j, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -((double) j));
        }
        if (z) {
            return Math.pow(10.0d, (double) j);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Void x(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = abstractJsonLexer.f4093a;
            }
            if ((i2 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.w(str, i, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public static /* synthetic */ Void z(AbstractJsonLexer abstractJsonLexer, byte b2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return abstractJsonLexer.y(b2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final void A(String str) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) M(0, this.f4093a), str, 0, false, 6, (Object) null);
        w("Encountered an unknown key '" + str + '\'', lastIndexOf$default, "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    public final int B(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        x(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final StringBuilder C() {
        return this.d;
    }

    public abstract CharSequence D();

    public final boolean E() {
        return H() != 10;
    }

    public final boolean F(char c2) {
        return !(c2 == '}' || c2 == ']' || c2 == ':' || c2 == ',');
    }

    public abstract String G(String str, boolean z);

    public final byte H() {
        CharSequence D = D();
        int i = this.f4093a;
        while (true) {
            int J = J(i);
            if (J != -1) {
                char charAt = D.charAt(J);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i = J + 1;
                } else {
                    this.f4093a = J;
                    return AbstractJsonLexerKt.a(charAt);
                }
            } else {
                this.f4093a = J;
                return 10;
            }
        }
    }

    public final String I(boolean z) {
        String str;
        byte H = H();
        if (z) {
            if (H != 1 && H != 0) {
                return null;
            }
            str = q();
        } else if (H != 1) {
            return null;
        } else {
            str = o();
        }
        this.c = str;
        return str;
    }

    public abstract int J(int i);

    public final void K(boolean z) {
        ArrayList arrayList = new ArrayList();
        byte H = H();
        if (H == 8 || H == 6) {
            while (true) {
                byte H2 = H();
                if (H2 != 1) {
                    if (H2 == 8 || H2 == 6) {
                        arrayList.add(Byte.valueOf(H2));
                    } else if (H2 == 9) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 8) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            int i = this.f4093a;
                            throw JsonExceptionsKt.f(i, "found ] instead of } at path: " + this.b, D());
                        }
                    } else if (H2 == 7) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 6) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            int i2 = this.f4093a;
                            throw JsonExceptionsKt.f(i2, "found } instead of ] at path: " + this.b, D());
                        }
                    } else if (H2 == 10) {
                        x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    j();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z) {
                    q();
                } else {
                    i();
                }
            }
        } else {
            q();
        }
    }

    public int L() {
        int J;
        char charAt;
        int i = this.f4093a;
        while (true) {
            J = J(i);
            if (J == -1 || !((charAt = D().charAt(J)) == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.f4093a = J;
            } else {
                i = J + 1;
            }
        }
        this.f4093a = J;
        return J;
    }

    public String M(int i, int i2) {
        return D().subSequence(i, i2).toString();
    }

    public final String N() {
        String str = this.c;
        Intrinsics.checkNotNull(str);
        this.c = null;
        return str;
    }

    public abstract boolean O();

    public final boolean P(boolean z) {
        int J = J(L());
        int length = D().length() - J;
        if (length < 4 || J == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if ("null".charAt(i) != D().charAt(J + i)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.a(D().charAt(J + 4)) == 0) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.f4093a = J + 4;
        return true;
    }

    /* JADX INFO: finally extract failed */
    public final void R(char c2) {
        int i = this.f4093a;
        if (i > 0 && c2 == '\"') {
            try {
                this.f4093a = i - 1;
                String q = q();
                this.f4093a = i;
                if (Intrinsics.areEqual((Object) q, (Object) "null")) {
                    w("Expected string literal but 'null' literal was found", this.f4093a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.f4093a = i;
                throw th;
            }
        }
        z(this, AbstractJsonLexerKt.a(c2), false, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final boolean S() {
        return D().charAt(this.f4093a - 1) != '\"';
    }

    public final int a(int i) {
        int J = J(i);
        if (J != -1) {
            int i2 = J + 1;
            char charAt = D().charAt(J);
            if (charAt == 'u') {
                return c(D(), i2);
            }
            char b2 = AbstractJsonLexerKt.b(charAt);
            if (b2 != 0) {
                this.d.append(b2);
                return i2;
            }
            x(this, "Invalid escaped char '" + charAt + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        x(this, "Expected escape sequence to continue, got EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final int b(int i, int i2) {
        d(i, i2);
        return a(i2 + 1);
    }

    public final int c(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 >= charSequence.length()) {
            this.f4093a = i;
            u();
            if (this.f4093a + 4 < charSequence.length()) {
                return c(charSequence, this.f4093a);
            }
            x(this, "Unexpected EOF during unicode escape", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        this.d.append((char) ((B(charSequence, i) << 12) + (B(charSequence, i + 1) << 8) + (B(charSequence, i + 2) << 4) + B(charSequence, i + 3)));
        return i2;
    }

    public void d(int i, int i2) {
        this.d.append(D(), i, i2);
    }

    public abstract boolean e();

    public final boolean f(int i) {
        int J = J(i);
        if (J >= D().length() || J == -1) {
            x(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        int i2 = J + 1;
        char charAt = D().charAt(J) | ' ';
        if (charAt == 'f') {
            h("alse", i2);
            return false;
        } else if (charAt == 't') {
            h("rue", i2);
            return true;
        } else {
            x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean g() {
        boolean z;
        int L = L();
        if (L != D().length()) {
            if (D().charAt(L) == '\"') {
                L++;
                z = true;
            } else {
                z = false;
            }
            boolean f = f(L);
            if (z) {
                if (this.f4093a == D().length()) {
                    x(this, "EOF", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (D().charAt(this.f4093a) == '\"') {
                    this.f4093a++;
                } else {
                    x(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return f;
        }
        x(this, "EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final void h(String str, int i) {
        if (D().length() - i >= str.length()) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                if (str.charAt(i2) == (D().charAt(i + i2) | ' ')) {
                    i2++;
                } else {
                    x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.f4093a = i + str.length();
            return;
        }
        x(this, "Unexpected end of boolean literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b2) {
        byte j = j();
        if (j == b2) {
            return j;
        }
        z(this, b2, false, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public void l(char c2) {
        u();
        CharSequence D = D();
        int i = this.f4093a;
        while (true) {
            int J = J(i);
            if (J != -1) {
                int i2 = J + 1;
                char charAt = D.charAt(J);
                if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                    this.f4093a = i2;
                    if (charAt != c2) {
                        R(c2);
                    } else {
                        return;
                    }
                }
                i = i2;
            } else {
                this.f4093a = J;
                R(c2);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        return -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0142, code lost:
        if (r8 == r1) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0144, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0146, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0147, code lost:
        if (r1 == r8) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
        if (r10 == false) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014d, code lost:
        if (r1 == (r8 - 1)) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014f, code lost:
        if (r2 == false) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0151, code lost:
        if (r4 == false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015d, code lost:
        if (D().charAt(r8) != '\"') goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0162, code lost:
        x(r17, "Expected closing quotation mark", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0172, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0173, code lost:
        x(r17, "EOF", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0183, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0184, code lost:
        r0.f4093a = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0186, code lost:
        if (r9 == false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0188, code lost:
        r1 = ((double) r11) * n(r13, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0192, code lost:
        if (r1 > 9.223372036854776E18d) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0198, code lost:
        if (r1 < -9.223372036854776E18d) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a0, code lost:
        if (java.lang.Math.floor(r1) != r1) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a2, code lost:
        r11 = (long) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a4, code lost:
        x(r17, "Can't convert " + r1 + " to Long", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c8, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c9, code lost:
        x(r17, "Numeric value overflow", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d9, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01da, code lost:
        if (r10 == false) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e1, code lost:
        if (r11 == Long.MIN_VALUE) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01e5, code lost:
        x(r17, "Numeric value overflow", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f5, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f6, code lost:
        x(r17, "Expected numeric literal", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0206, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m() {
        /*
            r17 = this;
            r0 = r17
            int r1 = r17.L()
            int r1 = r0.J(r1)
            java.lang.CharSequence r2 = r17.D()
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x0207
            r2 = -1
            if (r1 == r2) goto L_0x0207
            java.lang.CharSequence r2 = r17.D()
            char r2 = r2.charAt(r1)
            r3 = 34
            if (r2 != r3) goto L_0x0042
            int r1 = r1 + 1
            java.lang.CharSequence r2 = r17.D()
            int r2 = r2.length()
            if (r1 == r2) goto L_0x0031
            r2 = 1
            goto L_0x0043
        L_0x0031:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0042:
            r2 = 0
        L_0x0043:
            r6 = 0
            r8 = r1
            r11 = r6
            r13 = r11
            r9 = 0
            r10 = 0
        L_0x004a:
            r15 = 0
        L_0x004b:
            java.lang.CharSequence r16 = r17.D()
            int r4 = r16.length()
            if (r8 == r4) goto L_0x0142
            java.lang.CharSequence r4 = r17.D()
            char r4 = r4.charAt(r8)
            r5 = 101(0x65, float:1.42E-43)
            if (r4 == r5) goto L_0x0065
            r5 = 69
            if (r4 != r5) goto L_0x0093
        L_0x0065:
            if (r9 != 0) goto L_0x0093
            if (r8 == r1) goto L_0x006e
            int r8 = r8 + 1
            r9 = 1
        L_0x006c:
            r15 = 1
            goto L_0x004b
        L_0x006e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected symbol "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " in numeric literal"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0093:
            r5 = 45
            if (r4 != r5) goto L_0x00af
            if (r9 == 0) goto L_0x00af
            if (r8 == r1) goto L_0x009e
            int r8 = r8 + 1
            goto L_0x004a
        L_0x009e:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '-' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00af:
            r3 = 43
            if (r4 != r3) goto L_0x00cd
            if (r9 == 0) goto L_0x00cd
            if (r8 == r1) goto L_0x00bc
            int r8 = r8 + 1
            r3 = 34
            goto L_0x006c
        L_0x00bc:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '+' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00cd:
            if (r4 != r5) goto L_0x00e9
            if (r8 != r1) goto L_0x00d8
            int r8 = r8 + 1
            r3 = 34
            r10 = 1
            goto L_0x004b
        L_0x00d8:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '-' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00e9:
            byte r3 = kotlinx.serialization.json.internal.AbstractJsonLexerKt.a(r4)
            if (r3 != 0) goto L_0x0142
            int r8 = r8 + 1
            int r3 = r4 + -48
            if (r3 < 0) goto L_0x011d
            r5 = 10
            if (r3 >= r5) goto L_0x011d
            if (r9 == 0) goto L_0x0103
            long r4 = (long) r5
            long r13 = r13 * r4
            long r3 = (long) r3
            long r13 = r13 + r3
        L_0x00ff:
            r3 = 34
            goto L_0x004b
        L_0x0103:
            long r4 = (long) r5
            long r11 = r11 * r4
            long r3 = (long) r3
            long r11 = r11 - r3
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x010c
            goto L_0x00ff
        L_0x010c:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x011d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected symbol '"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = "' in numeric literal"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0142:
            if (r8 == r1) goto L_0x0146
            r4 = 1
            goto L_0x0147
        L_0x0146:
            r4 = 0
        L_0x0147:
            if (r1 == r8) goto L_0x01f6
            if (r10 == 0) goto L_0x014f
            int r3 = r8 + -1
            if (r1 == r3) goto L_0x01f6
        L_0x014f:
            if (r2 == 0) goto L_0x0184
            if (r4 == 0) goto L_0x0173
            java.lang.CharSequence r1 = r17.D()
            char r1 = r1.charAt(r8)
            r2 = 34
            if (r1 != r2) goto L_0x0162
            int r8 = r8 + 1
            goto L_0x0184
        L_0x0162:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Expected closing quotation mark"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0173:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0184:
            r0.f4093a = r8
            if (r9 == 0) goto L_0x01da
            double r1 = (double) r11
            double r3 = n(r13, r15)
            double r1 = r1 * r3
            r3 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01c9
            r3 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x01c9
            double r3 = java.lang.Math.floor(r1)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01a4
            long r11 = (long) r1
            goto L_0x01da
        L_0x01a4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't convert "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " to Long"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01c9:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01da:
            if (r10 == 0) goto L_0x01dd
            goto L_0x01e4
        L_0x01dd:
            r1 = -9223372036854775808
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x01e5
            long r11 = -r11
        L_0x01e4:
            return r11
        L_0x01e5:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01f6:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Expected numeric literal"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0207:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            r0 = r17
            x(r0, r1, r2, r3, r4, r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonLexer.m():long");
    }

    public final String o() {
        return this.c != null ? N() : i();
    }

    public final String p(CharSequence charSequence, int i, int i2) {
        int J;
        Intrinsics.checkNotNullParameter(charSequence, "source");
        char charAt = charSequence.charAt(i2);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                J = J(b(i, i2));
                if (J == -1) {
                    x(this, "Unexpected EOF", J, (String) null, 4, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i2++;
                if (i2 >= charSequence.length()) {
                    d(i, i2);
                    J = J(i2);
                    if (J == -1) {
                        x(this, "Unexpected EOF", J, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = charSequence.charAt(i2);
                }
            }
            z = true;
            i = J;
            i2 = i;
            charAt = charSequence.charAt(i2);
        }
        String M = !z ? M(i, i2) : s(i, i2);
        this.f4093a = i2 + 1;
        return M;
    }

    public final String q() {
        if (this.c != null) {
            return N();
        }
        int L = L();
        if (L >= D().length() || L == -1) {
            x(this, "EOF", L, (String) null, 4, (Object) null);
            throw new KotlinNothingValueException();
        }
        byte a2 = AbstractJsonLexerKt.a(D().charAt(L));
        if (a2 == 1) {
            return o();
        }
        if (a2 == 0) {
            boolean z = false;
            while (AbstractJsonLexerKt.a(D().charAt(L)) == 0) {
                L++;
                if (L >= D().length()) {
                    d(this.f4093a, L);
                    int J = J(L);
                    if (J == -1) {
                        this.f4093a = L;
                        return s(0, 0);
                    }
                    L = J;
                    z = true;
                }
            }
            String M = !z ? M(this.f4093a, L) : s(this.f4093a, L);
            this.f4093a = L;
            return M;
        }
        x(this, "Expected beginning of the string, but got " + D().charAt(L), 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String r() {
        String q = q();
        if (!Intrinsics.areEqual((Object) q, (Object) "null") || !S()) {
            return q;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String s(int i, int i2) {
        d(i, i2);
        String sb = this.d.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        this.d.setLength(0);
        return sb;
    }

    public final void t() {
        this.c = null;
    }

    public String toString() {
        return "JsonReader(source='" + D() + "', currentPosition=" + this.f4093a + ')';
    }

    public void u() {
    }

    public final void v() {
        if (j() != 10) {
            x(this, "Expected EOF after parsing, but had " + D().charAt(this.f4093a - 1) + " instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final Void w(String str, int i, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "hint");
        if (str2.length() == 0) {
            str3 = "";
        } else {
            str3 = 10 + str2;
        }
        throw JsonExceptionsKt.f(i, str + " at path: " + this.b.a() + str3, D());
    }

    public final Void y(byte b2, boolean z) {
        String c2 = AbstractJsonLexerKt.c(b2);
        int i = z ? this.f4093a - 1 : this.f4093a;
        String valueOf = (this.f4093a == D().length() || i < 0) ? "EOF" : String.valueOf(D().charAt(i));
        x(this, "Expected " + c2 + ", but had '" + valueOf + "' instead", i, (String) null, 4, (Object) null);
        throw new KotlinNothingValueException();
    }
}
