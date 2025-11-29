package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0019¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "source", "<init>", "(Ljava/lang/String;)V", "", "position", "J", "(I)I", "", "j", "()B", "", "O", "()Z", "e", "L", "()I", "", "expected", "", "l", "(C)V", "i", "()Ljava/lang/String;", "keyToMatch", "isLenient", "G", "(Ljava/lang/String;Z)Ljava/lang/String;", "Ljava/lang/String;", "T", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStringJsonLexer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringJsonLexer.kt\nkotlinx/serialization/json/internal/StringJsonLexer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n1855#2,2:128\n*S KotlinDebug\n*F\n+ 1 StringJsonLexer.kt\nkotlinx/serialization/json/internal/StringJsonLexer\n*L\n107#1:128,2\n*E\n"})
public final class StringJsonLexer extends AbstractJsonLexer {
    public final String e;

    public StringJsonLexer(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.e = str;
    }

    public String G(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "keyToMatch");
        int i = this.f4093a;
        try {
            if (j() == 6) {
                if (Intrinsics.areEqual((Object) I(z), (Object) str)) {
                    t();
                    if (j() == 5) {
                        String I = I(z);
                        this.f4093a = i;
                        t();
                        return I;
                    }
                }
            }
            return null;
        } finally {
            this.f4093a = i;
            t();
        }
    }

    public int J(int i) {
        if (i < D().length()) {
            return i;
        }
        return -1;
    }

    public int L() {
        int i = this.f4093a;
        if (i == -1) {
            return i;
        }
        while (i < D().length() && ((r1 = D().charAt(i)) == ' ' || r1 == 10 || r1 == 13 || r1 == 9)) {
            i++;
        }
        this.f4093a = i;
        return i;
    }

    public boolean O() {
        int L = L();
        if (L == D().length() || L == -1 || D().charAt(L) != ',') {
            return false;
        }
        this.f4093a++;
        return true;
    }

    /* renamed from: T */
    public String D() {
        return this.e;
    }

    public boolean e() {
        int i = this.f4093a;
        if (i == -1) {
            return false;
        }
        while (i < D().length()) {
            char charAt = D().charAt(i);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i++;
            } else {
                this.f4093a = i;
                return F(charAt);
            }
        }
        this.f4093a = i;
        return false;
    }

    public String i() {
        l('\"');
        int i = this.f4093a;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) D(), '\"', i, false, 4, (Object) null);
        if (indexOf$default != -1) {
            for (int i2 = i; i2 < indexOf$default; i2++) {
                if (D().charAt(i2) == '\\') {
                    return p(D(), this.f4093a, i2);
                }
            }
            this.f4093a = indexOf$default + 1;
            String substring = D().substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        q();
        y((byte) 1, false);
        throw new KotlinNothingValueException();
    }

    public byte j() {
        byte a2;
        String T = D();
        do {
            int i = this.f4093a;
            if (i == -1 || i >= T.length()) {
                return 10;
            }
            int i2 = this.f4093a;
            this.f4093a = i2 + 1;
            a2 = AbstractJsonLexerKt.a(T.charAt(i2));
        } while (a2 == 3);
        return a2;
    }

    public void l(char c) {
        if (this.f4093a == -1) {
            R(c);
        }
        String T = D();
        while (this.f4093a < T.length()) {
            int i = this.f4093a;
            this.f4093a = i + 1;
            char charAt = T.charAt(i);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                if (charAt != c) {
                    R(c);
                } else {
                    return;
                }
            }
        }
        this.f4093a = -1;
        R(c);
    }
}
