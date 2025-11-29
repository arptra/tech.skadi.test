package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\b\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0012J\u001d\u0010\u001a\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u001d\u0010\u001b\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u0012J\u001d\u0010\u001d\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R%\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\b\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R%\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\b\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010/R\u001a\u00102\u001a\u00020#8\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u00100\u001a\u0004\b1\u0010%¨\u00063"}, d2 = {"Lio/ktor/util/DelegatingMutableSet;", "From", "To", "", "delegate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "convertTo", "convert", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "c", "(Ljava/util/Collection;)Ljava/util/Collection;", "d", "element", "", "add", "(Ljava/lang/Object;)Z", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()V", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "hashCode", "()I", "", "other", "equals", "", "toString", "()Ljava/lang/String;", "a", "Ljava/util/Set;", "b", "Lkotlin/jvm/functions/Function1;", "I", "e", "size", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDelegatingMutableSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DelegatingMutableSet.kt\nio/ktor/util/DelegatingMutableSet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1549#2:60\n1620#2,3:61\n1549#2:64\n1620#2,3:65\n*S KotlinDebug\n*F\n+ 1 DelegatingMutableSet.kt\nio/ktor/util/DelegatingMutableSet\n*L\n13#1:60\n13#1:61,3\n14#1:64\n14#1:65,3\n*E\n"})
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableSet {

    /* renamed from: a  reason: collision with root package name */
    public final Set f9025a;
    public final Function1 b;
    public final Function1 c;
    public final int d;

    public DelegatingMutableSet(Set set, Function1 function1, Function1 function12) {
        Intrinsics.checkNotNullParameter(set, "delegate");
        Intrinsics.checkNotNullParameter(function1, "convertTo");
        Intrinsics.checkNotNullParameter(function12, "convert");
        this.f9025a = set;
        this.b = function1;
        this.c = function12;
        this.d = set.size();
    }

    public boolean add(Object obj) {
        return this.f9025a.add(this.c.invoke(obj));
    }

    public boolean addAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9025a.addAll(c(collection));
    }

    public Collection c(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (Object invoke : collection) {
            arrayList.add(this.c.invoke(invoke));
        }
        return arrayList;
    }

    public void clear() {
        this.f9025a.clear();
    }

    public boolean contains(Object obj) {
        return this.f9025a.contains(this.c.invoke(obj));
    }

    public boolean containsAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9025a.containsAll(c(collection));
    }

    public Collection d(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (Object invoke : collection) {
            arrayList.add(this.b.invoke(invoke));
        }
        return arrayList;
    }

    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection d2 = d(this.f9025a);
        return ((Set) obj).containsAll(d2) && d2.containsAll((Collection) obj);
    }

    public int hashCode() {
        return this.f9025a.hashCode();
    }

    public boolean isEmpty() {
        return this.f9025a.isEmpty();
    }

    public Iterator iterator() {
        return new DelegatingMutableSet$iterator$1(this);
    }

    public boolean remove(Object obj) {
        return this.f9025a.remove(this.c.invoke(obj));
    }

    public boolean removeAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9025a.removeAll(c(collection));
    }

    public boolean retainAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.f9025a.retainAll(c(collection));
    }

    public final /* bridge */ int size() {
        return e();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return d(this.f9025a).toString();
    }

    public Object[] toArray(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        return CollectionToArray.toArray(this, objArr);
    }
}
