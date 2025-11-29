package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1045a = true;

    public void a() {
        if (!this.f1045a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(Object obj) {
        a();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean isModifiable() {
        return this.f1045a;
    }

    public final void makeImmutable() {
        this.f1045a = false;
    }

    public Object remove(int i) {
        a();
        return super.remove(i);
    }

    public boolean removeAll(Collection collection) {
        a();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        a();
        return super.retainAll(collection);
    }

    public Object set(int i, Object obj) {
        a();
        return super.set(i, obj);
    }

    public void add(int i, Object obj) {
        a();
        super.add(i, obj);
    }

    public boolean addAll(int i, Collection collection) {
        a();
        return super.addAll(i, collection);
    }

    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }
}
