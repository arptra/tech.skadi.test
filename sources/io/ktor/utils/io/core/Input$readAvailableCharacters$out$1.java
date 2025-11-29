package io.ktor.utils.io.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J\u001b\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\bJ-\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0005\u0010\fR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"io/ktor/utils/io/core/Input$readAvailableCharacters$out$1", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "value", "append", "(C)Ljava/lang/Appendable;", "", "(Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "startIndex", "endIndex", "(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "a", "I", "idx", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class Input$readAvailableCharacters$out$1 implements Appendable {

    /* renamed from: a  reason: collision with root package name */
    public int f9091a;
    public final /* synthetic */ char[] b;

    public Input$readAvailableCharacters$out$1(int i, char[] cArr) {
        this.b = cArr;
        this.f9091a = i;
    }

    public Appendable append(char c) {
        char[] cArr = this.b;
        int i = this.f9091a;
        this.f9091a = i + 1;
        cArr[i] = c;
        return this;
    }

    public Appendable append(CharSequence charSequence) {
        if (charSequence instanceof String) {
            String str = (String) charSequence;
            StringsJVMKt.a(str, this.b, this.f9091a);
            this.f9091a += str.length();
        } else if (charSequence != null) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char[] cArr = this.b;
                int i2 = this.f9091a;
                this.f9091a = i2 + 1;
                cArr[i2] = charSequence.charAt(i);
            }
        }
        return this;
    }

    public Appendable append(CharSequence charSequence, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
