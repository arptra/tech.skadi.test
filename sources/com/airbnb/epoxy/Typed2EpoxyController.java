package com.airbnb.epoxy;

import android.os.Handler;

public abstract class Typed2EpoxyController<T, U> extends EpoxyController {
    private boolean allowModelBuildRequests;
    private T data1;
    private U data2;

    public Typed2EpoxyController() {
    }

    public final void buildModels() {
        if (isBuildingModels()) {
            buildModels(this.data1, this.data2);
            return;
        }
        throw new IllegalStateException("You cannot call `buildModels` directly. Call `setData` instead to trigger a model refresh with new data.");
    }

    public abstract void buildModels(T t, U u);

    public void moveModel(int i, int i2) {
        this.allowModelBuildRequests = true;
        super.moveModel(i, i2);
        this.allowModelBuildRequests = false;
    }

    public void requestDelayedModelBuild(int i) {
        if (this.allowModelBuildRequests) {
            super.requestDelayedModelBuild(i);
            return;
        }
        throw new IllegalStateException("You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a model refresh with new data.");
    }

    public final void requestModelBuild() {
        if (this.allowModelBuildRequests) {
            super.requestModelBuild();
            return;
        }
        throw new IllegalStateException("You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a model refresh with new data.");
    }

    public void setData(T t, U u) {
        this.data1 = t;
        this.data2 = u;
        this.allowModelBuildRequests = true;
        requestModelBuild();
        this.allowModelBuildRequests = false;
    }

    public Typed2EpoxyController(Handler handler, Handler handler2) {
        super(handler, handler2);
    }
}
