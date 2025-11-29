package com.airbnb.epoxy;

import java.util.HashMap;
import java.util.Map;

class ViewTypeManager {
    public static final Map b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public EpoxyModel f2319a;

    public static int b(EpoxyModel epoxyModel) {
        int B = epoxyModel.B();
        if (B != 0) {
            return B;
        }
        Class<?> cls = epoxyModel.getClass();
        Map map = b;
        Integer num = (Integer) map.get(cls);
        if (num == null) {
            num = Integer.valueOf((-map.size()) - 1);
            map.put(cls, num);
        }
        return num.intValue();
    }

    public EpoxyModel a(BaseEpoxyAdapter baseEpoxyAdapter, int i) {
        EpoxyModel epoxyModel = this.f2319a;
        if (epoxyModel != null && b(epoxyModel) == i) {
            return this.f2319a;
        }
        baseEpoxyAdapter.s(new IllegalStateException("Last model did not match expected view type"));
        for (EpoxyModel epoxyModel2 : baseEpoxyAdapter.j()) {
            if (b(epoxyModel2) == i) {
                return epoxyModel2;
            }
        }
        HiddenEpoxyModel hiddenEpoxyModel = new HiddenEpoxyModel();
        if (i == hiddenEpoxyModel.B()) {
            return hiddenEpoxyModel;
        }
        throw new IllegalStateException("Could not find model for view type: " + i);
    }

    public int c(EpoxyModel epoxyModel) {
        this.f2319a = epoxyModel;
        return b(epoxyModel);
    }
}
