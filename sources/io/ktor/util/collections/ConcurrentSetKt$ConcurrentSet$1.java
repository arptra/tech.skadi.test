package io.ktor.util.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableSet;

@SourceDebugExtension({"SMAP\nConcurrentSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentSet.kt\nio/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1726#2,3:51\n1726#2,3:54\n*S KotlinDebug\n*F\n+ 1 ConcurrentSet.kt\nio/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1\n*L\n20#1:51,3\n30#1:54,3\n*E\n"})
@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u001d\u0010\u0014\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001c¨\u0006\u001e"}, d2 = {"io/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1", "", "element", "", "add", "(Ljava/lang/Object;)Z", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "Lio/ktor/util/collections/ConcurrentMap;", "a", "Lio/ktor/util/collections/ConcurrentMap;", "delegate", "", "()I", "size", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class ConcurrentSetKt$ConcurrentSet$1 implements Set<Object>, KMutableSet {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap f9043a = new ConcurrentMap(0, 1, (DefaultConstructorMarker) null);

    public int a() {
        return this.f9043a.size();
    }

    public boolean add(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "element");
        if (this.f9043a.containsKey(obj)) {
            return false;
        }
        this.f9043a.put(obj, Unit.INSTANCE);
        return true;
    }

    public boolean addAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object add : collection) {
            if (!add(add)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.f9043a.clear();
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f9043a.containsKey(obj);
    }

    public boolean containsAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return collection.containsAll(this.f9043a.keySet());
    }

    public boolean isEmpty() {
        return this.f9043a.isEmpty();
    }

    public Iterator iterator() {
        return this.f9043a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        return (obj == null || this.f9043a.remove(obj) == null) ? false : true;
    }

    public boolean removeAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object remove : collection) {
            if (!remove(remove)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : this.f9043a.keySet()) {
            if (!collection.contains(next)) {
                linkedHashSet.add(next);
            }
        }
        return removeAll(linkedHashSet);
    }

    public final /* bridge */ int size() {
        return a();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public Object[] toArray(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        return CollectionToArray.toArray(this, objArr);
    }
}
