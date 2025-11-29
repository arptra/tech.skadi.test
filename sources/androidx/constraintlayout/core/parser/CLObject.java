package androidx.constraintlayout.core.parser;

import java.util.Iterator;

public class CLObject extends CLContainer implements Iterable<CLKey> {

    public class CLObjectIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        public CLObject f515a;
        public int b = 0;

        public CLObjectIterator(CLObject cLObject) {
            this.f515a = cLObject;
        }

        public boolean hasNext() {
            return this.b < this.f515a.size();
        }

        public Object next() {
            CLKey cLKey = (CLKey) this.f515a.e.get(this.b);
            this.b++;
            return cLKey;
        }
    }

    public Iterator iterator() {
        return new CLObjectIterator(this);
    }
}
