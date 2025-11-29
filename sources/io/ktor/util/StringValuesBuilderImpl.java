package io.ktor.util;

import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00140\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!H\u0016¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0017H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b*\u0010'J\u0017\u0010+\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\bH\u0014¢\u0006\u0004\b+\u0010'J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u0010\u0013R,\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0,008\u0004X\u0004¢\u0006\f\n\u0004\b/\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "", "caseInsensitiveName", "", "size", "<init>", "(ZI)V", "", "name", "", "a", "(Ljava/lang/String;)Ljava/util/List;", "contains", "(Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "value", "", "k", "(Ljava/lang/String;Ljava/lang/String;)V", "h", "(Ljava/lang/String;)Ljava/lang/String;", "e", "Lio/ktor/util/StringValues;", "stringValues", "d", "(Lio/ktor/util/StringValues;)V", "", "values", "c", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "f", "j", "(Ljava/lang/String;)V", "clear", "()V", "l", "m", "", "g", "Z", "b", "", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStringValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesBuilderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,422:1\n1855#2,2:423\n766#2:425\n857#2,2:426\n515#3:428\n500#3,6:429\n1#4:435\n*S KotlinDebug\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesBuilderImpl\n*L\n248#1:423,2\n258#1:425\n258#1:426,2\n266#1:428\n266#1:429,6\n*E\n"})
public class StringValuesBuilderImpl implements StringValuesBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9039a;
    public final Map b;

    public StringValuesBuilderImpl(boolean z, int i) {
        this.f9039a = z;
        this.b = z ? CollectionsKt.a() : new LinkedHashMap(i);
    }

    public List a(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return (List) this.b.get(str);
    }

    public final boolean b() {
        return this.f9039a;
    }

    public void c(String str, Iterable iterable) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iterable, "values");
        List g = g(str);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            m(str2);
            g.add(str2);
        }
    }

    public void clear() {
        this.b.clear();
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.b.containsKey(str);
    }

    public void d(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.c(new StringValuesBuilderImpl$appendAll$1(this));
    }

    public void e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        m(str2);
        g(str).add(str2);
    }

    public Set entries() {
        return CollectionsJvmKt.a(this.b.entrySet());
    }

    public void f(String str, Iterable iterable) {
        Set set;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iterable, "values");
        List list = (List) this.b.get(str);
        if (list == null || (set = CollectionsKt.toSet(list)) == null) {
            set = SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!set.contains((String) next)) {
                arrayList.add(next);
            }
        }
        c(str, arrayList);
    }

    public final List g(String str) {
        List list = (List) this.b.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        l(str);
        this.b.put(str, arrayList);
        return arrayList;
    }

    public String h(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        List a2 = a(str);
        if (a2 != null) {
            return (String) CollectionsKt.firstOrNull(a2);
        }
        return null;
    }

    public final Map i() {
        return this.b;
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public void j(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.b.remove(str);
    }

    public void k(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        m(str2);
        List g = g(str);
        g.clear();
        g.add(str2);
    }

    public void l(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
    }

    public void m(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
    }

    public Set names() {
        return this.b.keySet();
    }
}
