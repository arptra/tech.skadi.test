package io.ktor.util;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u00192\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010\u0010R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&¨\u0006("}, d2 = {"Lio/ktor/util/StringValuesSingleImpl;", "Lio/ktor/util/StringValues;", "", "name", "", "a", "(Ljava/lang/String;)Ljava/util/List;", "", "", "entries", "()Ljava/util/Set;", "", "isEmpty", "()Z", "names", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function2;", "", "body", "c", "(Lkotlin/jvm/functions/Function2;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Z", "b", "caseInsensitiveName", "d", "Ljava/lang/String;", "e", "Ljava/util/List;", "()Ljava/util/List;", "values", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public class StringValuesSingleImpl implements StringValues {
    public final boolean c;
    public final String d;
    public final List e;

    public List a(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (StringsKt.equals(this.d, str, b())) {
            return this.e;
        }
        return null;
    }

    public boolean b() {
        return this.c;
    }

    public void c(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        function2.invoke(this.d, this.e);
    }

    public final String d() {
        return this.d;
    }

    public final List e() {
        return this.e;
    }

    public Set entries() {
        return SetsKt.setOf(new StringValuesSingleImpl$entries$1(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (b() != stringValues.b()) {
            return false;
        }
        return StringValuesKt.d(entries(), stringValues.entries());
    }

    public String get(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (StringsKt.equals(str, this.d, b())) {
            return (String) CollectionsKt.firstOrNull(this.e);
        }
        return null;
    }

    public int hashCode() {
        return StringValuesKt.e(entries(), Boolean.hashCode(b()) * 31);
    }

    public boolean isEmpty() {
        return false;
    }

    public Set names() {
        return SetsKt.setOf(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringValues(case=");
        sb.append(!b());
        sb.append(") ");
        sb.append(entries());
        return sb.toString();
    }
}
