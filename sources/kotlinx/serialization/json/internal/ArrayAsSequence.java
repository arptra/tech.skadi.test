package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00148\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/ArrayAsSequence;", "", "", "index", "", "a", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "e", "(II)Ljava/lang/String;", "newSize", "", "f", "(I)V", "toString", "()Ljava/lang/String;", "", "[C", "b", "()[C", "buffer", "I", "c", "()I", "d", "length", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class ArrayAsSequence implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f4096a;
    public int b;

    public char a(int i) {
        return this.f4096a[i];
    }

    public final char[] b() {
        return this.f4096a;
    }

    public int c() {
        return this.b;
    }

    public final /* bridge */ char charAt(int i) {
        return a(i);
    }

    public void d(int i) {
        this.b = i;
    }

    public final String e(int i, int i2) {
        return StringsKt.concatToString(this.f4096a, i, Math.min(i2, length()));
    }

    public final void f(int i) {
        d(Math.min(this.f4096a.length, i));
    }

    public final /* bridge */ int length() {
        return c();
    }

    public CharSequence subSequence(int i, int i2) {
        return StringsKt.concatToString(this.f4096a, i, Math.min(i2, length()));
    }

    public String toString() {
        return e(0, length());
    }
}
