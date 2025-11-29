package org.extra.tools;

import android.app.Fragment;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class c extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final Set f3361a = Collections.newSetFromMap(new WeakHashMap());
    public final Object b = new Object();

    public void a(d dVar) {
        synchronized (this.b) {
            this.f3361a.add(dVar);
        }
    }

    public void onResume() {
        super.onResume();
        synchronized (this.b) {
            try {
                for (d dVar : this.f3361a) {
                    if (dVar != null) {
                        dVar.onResume();
                    }
                }
            } finally {
            }
        }
    }
}
