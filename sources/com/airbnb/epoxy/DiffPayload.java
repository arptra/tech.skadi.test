package com.airbnb.epoxy;

import androidx.collection.LongSparseArray;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiffPayload {

    /* renamed from: a  reason: collision with root package name */
    public final EpoxyModel f2280a;
    public final LongSparseArray b;

    public DiffPayload(List list) {
        if (!list.isEmpty()) {
            int size = list.size();
            if (size == 1) {
                this.f2280a = (EpoxyModel) list.get(0);
                this.b = null;
                return;
            }
            this.f2280a = null;
            this.b = new LongSparseArray(size);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                EpoxyModel epoxyModel = (EpoxyModel) it.next();
                this.b.put(epoxyModel.D(), epoxyModel);
            }
            return;
        }
        throw new IllegalStateException("Models must not be empty");
    }

    public static EpoxyModel a(List list, long j) {
        if (list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DiffPayload diffPayload = (DiffPayload) it.next();
            EpoxyModel epoxyModel = diffPayload.f2280a;
            if (epoxyModel == null) {
                EpoxyModel epoxyModel2 = (EpoxyModel) diffPayload.b.get(j);
                if (epoxyModel2 != null) {
                    return epoxyModel2;
                }
            } else if (epoxyModel.D() == j) {
                return diffPayload.f2280a;
            }
        }
        return null;
    }

    public DiffPayload(EpoxyModel epoxyModel) {
        this(Collections.singletonList(epoxyModel));
    }
}
