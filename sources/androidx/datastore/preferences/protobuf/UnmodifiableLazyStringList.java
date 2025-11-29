package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public final LazyStringList f1155a;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f1155a = lazyStringList;
    }

    /* renamed from: b */
    public String get(int i) {
        return (String) this.f1155a.get(i);
    }

    public void g(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public Object getRaw(int i) {
        return this.f1155a.getRaw(i);
    }

    public List getUnderlyingElements() {
        return this.f1155a.getUnderlyingElements();
    }

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public Iterator iterator() {
        return new Iterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            public Iterator f1157a;

            {
                this.f1157a = UnmodifiableLazyStringList.this.f1155a.iterator();
            }

            /* renamed from: a */
            public String next() {
                return (String) this.f1157a.next();
            }

            public boolean hasNext() {
                return this.f1157a.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public ListIterator listIterator(int i) {
        return new ListIterator<String>(i) {

            /* renamed from: a  reason: collision with root package name */
            public ListIterator f1156a;
            public final /* synthetic */ int b;

            {
                this.b = r2;
                this.f1156a = UnmodifiableLazyStringList.this.f1155a.listIterator(r2);
            }

            /* renamed from: a */
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            /* renamed from: b */
            public String next() {
                return (String) this.f1156a.next();
            }

            /* renamed from: c */
            public String previous() {
                return (String) this.f1156a.previous();
            }

            /* renamed from: d */
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return this.f1156a.hasNext();
            }

            public boolean hasPrevious() {
                return this.f1156a.hasPrevious();
            }

            public int nextIndex() {
                return this.f1156a.nextIndex();
            }

            public int previousIndex() {
                return this.f1156a.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return this.f1155a.size();
    }
}
