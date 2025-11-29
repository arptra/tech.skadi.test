package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public SafeIterableMap f1370a = new SafeIterableMap();

    public static class Source<V> implements Observer<V> {

        /* renamed from: a  reason: collision with root package name */
        public final LiveData f1371a;
        public final Observer b;
        public int c = -1;

        public Source(LiveData liveData, Observer observer) {
            this.f1371a = liveData;
            this.b = observer;
        }

        public void a() {
            this.f1371a.observeForever(this);
        }

        public void b() {
            this.f1371a.removeObserver(this);
        }

        public void onChanged(Object obj) {
            if (this.c != this.f1371a.getVersion()) {
                this.c = this.f1371a.getVersion();
                this.b.onChanged(obj);
            }
        }
    }

    public void c(LiveData liveData, Observer observer) {
        if (liveData != null) {
            Source source = new Source(liveData, observer);
            Source source2 = (Source) this.f1370a.f(liveData, source);
            if (source2 != null && source2.b != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (source2 == null && hasActiveObservers()) {
                source.a();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    public void d(LiveData liveData) {
        Source source = (Source) this.f1370a.h(liveData);
        if (source != null) {
            source.b();
        }
    }

    public void onActive() {
        Iterator it = this.f1370a.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).a();
        }
    }

    public void onInactive() {
        Iterator it = this.f1370a.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).b();
        }
    }
}
