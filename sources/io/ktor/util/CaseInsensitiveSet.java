package io.ktor.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lio/ktor/util/CaseInsensitiveSet;", "", "", "element", "", "a", "(Ljava/lang/String;)Z", "d", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()V", "removeAll", "retainAll", "b", "containsAll", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "Lio/ktor/util/CaseInsensitiveMap;", "Lio/ktor/util/CaseInsensitiveMap;", "backingMap", "", "c", "()I", "size", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@InternalAPI
public final class CaseInsensitiveSet implements Set<String>, KMutableSet {

    /* renamed from: a  reason: collision with root package name */
    public final CaseInsensitiveMap f9020a;

    /* renamed from: a */
    public boolean add(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        if (this.f9020a.containsKey(str)) {
            return false;
        }
        this.f9020a.put(str, Boolean.TRUE);
        return true;
    }

    public boolean addAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add((String) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        return this.f9020a.containsKey(str);
    }

    public int c() {
        return this.f9020a.size();
    }

    public void clear() {
        this.f9020a.clear();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return b((String) obj);
    }

    public boolean containsAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9020a.keySet().containsAll(collection);
    }

    public boolean d(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        return Intrinsics.areEqual(this.f9020a.remove(str), (Object) Boolean.TRUE);
    }

    public boolean isEmpty() {
        return this.f9020a.isEmpty();
    }

    public Iterator iterator() {
        return this.f9020a.keySet().iterator();
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return d((String) obj);
    }

    public boolean removeAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9020a.keySet().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9020a.keySet().retainAll(collection);
    }

    public final /* bridge */ int size() {
        return c();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public Object[] toArray(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        return CollectionToArray.toArray(this, objArr);
    }
}
