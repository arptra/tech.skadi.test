package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f621a = new SparseIntArray();
    public HashMap b = new HashMap();

    public interface SharedValuesListener {
    }

    public void a(int i, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.b.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.b.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void b(int i, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.b.get(Integer.valueOf(i));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
                if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }
}
