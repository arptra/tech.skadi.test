package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DiffHelper {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2278a;
    public Map b;
    public final BaseEpoxyAdapter c;
    public final boolean d;

    /* renamed from: com.airbnb.epoxy.DiffHelper$1  reason: invalid class name */
    public class AnonymousClass1 extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DiffHelper f2279a;

        public void onChanged() {
            throw new UnsupportedOperationException("Diffing is enabled. You should use notifyModelsChanged instead of notifyDataSetChanged");
        }

        public void onItemRangeChanged(int i, int i2) {
            for (int i3 = i; i3 < i + i2; i3++) {
                ((ModelState) this.f2279a.f2278a.get(i3)).b = ((EpoxyModel) this.f2279a.c.j().get(i3)).hashCode();
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            if (i2 != 0) {
                if (i2 == 1 || i == this.f2279a.f2278a.size()) {
                    for (int i3 = i; i3 < i + i2; i3++) {
                        this.f2279a.f2278a.add(i3, this.f2279a.e(i3));
                    }
                } else {
                    ArrayList arrayList = new ArrayList(i2);
                    for (int i4 = i; i4 < i + i2; i4++) {
                        arrayList.add(this.f2279a.e(i4));
                    }
                    this.f2279a.f2278a.addAll(i, arrayList);
                }
                int size = this.f2279a.f2278a.size();
                for (int i5 = i + i2; i5 < size; i5++) {
                    ((ModelState) this.f2279a.f2278a.get(i5)).c += i2;
                }
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            if (i != i2) {
                if (i3 == 1) {
                    ModelState modelState = (ModelState) this.f2279a.f2278a.remove(i);
                    modelState.c = i2;
                    this.f2279a.f2278a.add(i2, modelState);
                    if (i < i2) {
                        while (i < i2) {
                            ((ModelState) this.f2279a.f2278a.get(i)).c--;
                            i++;
                        }
                        return;
                    }
                    for (int i4 = i2 + 1; i4 <= i; i4++) {
                        ((ModelState) this.f2279a.f2278a.get(i4)).c++;
                    }
                    return;
                }
                throw new IllegalArgumentException("Moving more than 1 item at a time is not supported. Number of items moved: " + i3);
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            if (i2 != 0) {
                List<ModelState> subList = this.f2279a.f2278a.subList(i, i + i2);
                for (ModelState modelState : subList) {
                    this.f2279a.b.remove(Long.valueOf(modelState.f2311a));
                }
                subList.clear();
                int size = this.f2279a.f2278a.size();
                while (i < size) {
                    ((ModelState) this.f2279a.f2278a.get(i)).c -= i2;
                    i++;
                }
            }
        }
    }

    public final ModelState e(int i) {
        EpoxyModel epoxyModel = (EpoxyModel) this.c.j().get(i);
        epoxyModel.d = true;
        ModelState a2 = ModelState.a(epoxyModel, i, this.d);
        ModelState modelState = (ModelState) this.b.put(Long.valueOf(a2.f2311a), a2);
        if (modelState == null) {
            return a2;
        }
        int i2 = modelState.c;
        throw new IllegalStateException("Two models have the same ID. ID's must be unique! Model at position " + i + ": " + epoxyModel + " Model at position " + i2 + ": " + ((EpoxyModel) this.c.j().get(i2)));
    }
}
