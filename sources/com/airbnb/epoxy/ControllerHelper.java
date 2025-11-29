package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyController;
import java.util.List;

public abstract class ControllerHelper<T extends EpoxyController> {
    public abstract void resetAutoModels();

    public void setControllerToStageTo(EpoxyModel<?> epoxyModel, T t) {
        epoxyModel.f = t;
    }

    public void validateModelHashCodesHaveNotChanged(T t) {
        List H = t.getAdapter().H();
        for (int i = 0; i < H.size(); i++) {
            ((EpoxyModel) H.get(i)).S("Model has changed since it was added to the controller.", i);
        }
    }
}
