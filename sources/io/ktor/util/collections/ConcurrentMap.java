package io.ktor.util.collections;

import com.honey.account.jb.a;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\u00162\u0014\u0010\u001c\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010\u000fJ\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R \u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\"R&\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000/8VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000/8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0001068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lio/ktor/util/collections/ConcurrentMap;", "Key", "Value", "", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "block", "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "", "clear", "()V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "()I", "", "other", "equals", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "delegate", "g", "size", "", "", "e", "()Ljava/util/Set;", "entries", "f", "keys", "", "h", "()Ljava/util/Collection;", "values", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f9042a;

    public ConcurrentMap(int i) {
        this.f9042a = new ConcurrentHashMap(i);
    }

    public static final Object d(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return function1.invoke(obj);
    }

    public final Object c(Object obj, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return this.f9042a.computeIfAbsent(obj, new a(new ConcurrentMap$computeIfAbsent$1(function0)));
    }

    public void clear() {
        this.f9042a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f9042a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f9042a.containsValue(obj);
    }

    public Set e() {
        Set entrySet = this.f9042a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "delegate.entries");
        return entrySet;
    }

    public final /* bridge */ Set entrySet() {
        return e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        return Intrinsics.areEqual(obj, (Object) this.f9042a);
    }

    public Set f() {
        Set keySet = this.f9042a.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "delegate.keys");
        return keySet;
    }

    public int g() {
        return this.f9042a.size();
    }

    public Object get(Object obj) {
        return this.f9042a.get(obj);
    }

    public Collection h() {
        Collection values = this.f9042a.values();
        Intrinsics.checkNotNullExpressionValue(values, "delegate.values");
        return values;
    }

    public int hashCode() {
        return this.f9042a.hashCode();
    }

    public boolean isEmpty() {
        return this.f9042a.isEmpty();
    }

    public final /* bridge */ Set keySet() {
        return f();
    }

    public Object put(Object obj, Object obj2) {
        return this.f9042a.put(obj, obj2);
    }

    public void putAll(Map map) {
        Intrinsics.checkNotNullParameter(map, "from");
        this.f9042a.putAll(map);
    }

    public Object remove(Object obj) {
        return this.f9042a.remove(obj);
    }

    public final /* bridge */ int size() {
        return g();
    }

    public String toString() {
        return "ConcurrentMapJvm by " + this.f9042a;
    }

    public final /* bridge */ Collection values() {
        return h();
    }

    public boolean remove(Object obj, Object obj2) {
        return this.f9042a.remove(obj, obj2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 32 : i);
    }
}
