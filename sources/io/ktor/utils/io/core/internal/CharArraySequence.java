package io.ktor.utils.io.core.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/utils/io/core/internal/CharArraySequence;", "", "", "array", "", "offset", "length", "<init>", "([CII)V", "index", "", "a", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "b", "(I)Ljava/lang/Void;", "[C", "I", "c", "getLength", "()I", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCharArraySequence.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharArraySequence.kt\nio/ktor/utils/io/core/internal/CharArraySequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
public final class CharArraySequence implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f9094a;
    public final int b;
    public final int c;

    public CharArraySequence(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.f9094a = cArr;
        this.b = i;
        this.c = i2;
    }

    public final char a(int i) {
        if (i < this.c) {
            return this.f9094a[i + this.b];
        }
        b(i);
        throw new KotlinNothingValueException();
    }

    public final Void b(int i) {
        throw new IndexOutOfBoundsException("String index out of bounds: " + i + " > " + this.c);
    }

    public final /* bridge */ char charAt(int i) {
        return a(i);
    }

    public final /* bridge */ int length() {
        return this.c;
    }

    public final CharSequence subSequence(int i, int i2) {
        if (i >= 0) {
            int i3 = this.c;
            if (i > i3) {
                throw new IllegalArgumentException(("startIndex is too large: " + i + " > " + this.c).toString());
            } else if (i + i2 > i3) {
                throw new IllegalArgumentException(("endIndex is too large: " + i2 + " > " + this.c).toString());
            } else if (i2 >= i) {
                return new CharArraySequence(this.f9094a, this.b + i, i2 - i);
            } else {
                throw new IllegalArgumentException(("endIndex should be greater or equal to startIndex: " + i + " > " + i2).toString());
            }
        } else {
            throw new IllegalArgumentException(("startIndex shouldn't be negative: " + i).toString());
        }
    }
}
