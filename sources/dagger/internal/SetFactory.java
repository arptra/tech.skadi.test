package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SetFactory<T> implements Factory<Set<T>> {
    public static final Factory c = InstanceFactory.a(Collections.emptySet());

    /* renamed from: a  reason: collision with root package name */
    public final List f8784a;
    public final List b;

    public static final class Builder<T> {
    }

    /* renamed from: a */
    public Set get() {
        int size = this.f8784a.size();
        ArrayList arrayList = new ArrayList(this.b.size());
        int size2 = this.b.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) ((Provider) this.b.get(i)).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet b2 = DaggerCollections.b(size);
        int size3 = this.f8784a.size();
        for (int i2 = 0; i2 < size3; i2++) {
            b2.add(Preconditions.b(((Provider) this.f8784a.get(i2)).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object b3 : (Collection) arrayList.get(i3)) {
                b2.add(Preconditions.b(b3));
            }
        }
        return Collections.unmodifiableSet(b2);
    }
}
