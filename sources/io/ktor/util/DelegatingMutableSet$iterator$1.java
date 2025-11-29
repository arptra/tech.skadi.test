package io.ktor.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"io/ktor/util/DelegatingMutableSet$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "a", "Ljava/util/Iterator;", "getDelegateIterator", "()Ljava/util/Iterator;", "delegateIterator", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class DelegatingMutableSet$iterator$1 implements Iterator<To>, KMutableIterator {

    /* renamed from: a  reason: collision with root package name */
    public final Iterator f9026a;
    public final /* synthetic */ DelegatingMutableSet b;

    public DelegatingMutableSet$iterator$1(DelegatingMutableSet delegatingMutableSet) {
        this.b = delegatingMutableSet;
        this.f9026a = delegatingMutableSet.f9025a.iterator();
    }

    public boolean hasNext() {
        return this.f9026a.hasNext();
    }

    public Object next() {
        return this.b.b.invoke(this.f9026a.next());
    }

    public void remove() {
        this.f9026a.remove();
    }
}
