package androidx.databinding;

import androidx.core.util.Pools;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;

public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {
    public static final Pools.SynchronizedPool f = new Pools.SynchronizedPool(10);
    public static final CallbackRegistry.NotifierCallback g = new CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges>() {
        /* renamed from: b */
        public void a(ObservableList.OnListChangedCallback onListChangedCallback, ObservableList observableList, int i, ListChanges listChanges) {
            if (i == 1) {
                onListChangedCallback.c(observableList, listChanges.f969a, listChanges.b);
            } else if (i == 2) {
                onListChangedCallback.d(observableList, listChanges.f969a, listChanges.b);
            } else if (i == 3) {
                onListChangedCallback.e(observableList, listChanges.f969a, listChanges.c, listChanges.b);
            } else if (i != 4) {
                onListChangedCallback.a(observableList);
            } else {
                onListChangedCallback.f(observableList, listChanges.f969a, listChanges.b);
            }
        }
    };

    public static class ListChanges {

        /* renamed from: a  reason: collision with root package name */
        public int f969a;
        public int b;
        public int c;
    }

    public ListChangeRegistry() {
        super(g);
    }

    public static ListChanges m(int i, int i2, int i3) {
        ListChanges listChanges = (ListChanges) f.acquire();
        if (listChanges == null) {
            listChanges = new ListChanges();
        }
        listChanges.f969a = i;
        listChanges.c = i2;
        listChanges.b = i3;
        return listChanges;
    }

    /* renamed from: n */
    public synchronized void e(ObservableList observableList, int i, ListChanges listChanges) {
        super.e(observableList, i, listChanges);
        if (listChanges != null) {
            f.a(listChanges);
        }
    }

    public void o(ObservableList observableList, int i, int i2) {
        e(observableList, 1, m(i, 0, i2));
    }

    public void p(ObservableList observableList, int i, int i2) {
        e(observableList, 2, m(i, 0, i2));
    }

    public void q(ObservableList observableList, int i, int i2) {
        e(observableList, 4, m(i, 0, i2));
    }
}
