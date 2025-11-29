package com.airbnb.epoxy;

import java.util.List;

public class SimpleEpoxyController extends EpoxyController {
    private List<? extends EpoxyModel<?>> currentModels;
    private boolean insideSetModels;

    public final void buildModels() {
        if (isBuildingModels()) {
            add(this.currentModels);
            return;
        }
        throw new IllegalEpoxyUsage("You cannot call `buildModels` directly. Call `setModels` instead.");
    }

    public final void requestModelBuild() {
        if (this.insideSetModels) {
            super.requestModelBuild();
            return;
        }
        throw new IllegalEpoxyUsage("You cannot call `requestModelBuild` directly. Call `setModels` instead.");
    }

    public void setModels(List<? extends EpoxyModel<?>> list) {
        this.currentModels = list;
        this.insideSetModels = true;
        requestModelBuild();
        this.insideSetModels = false;
    }
}
