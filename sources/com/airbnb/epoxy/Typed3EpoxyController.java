package com.airbnb.epoxy;

import android.os.Handler;

public abstract class Typed3EpoxyController<T, U, V> extends EpoxyController {
    private boolean allowModelBuildRequests;
    private T data1;
    private U data2;
    private V data3;

    public Typed3EpoxyController() {
    }

    public final void buildModels() {
        if (isBuildingModels()) {
            buildModels(this.data1, this.data2, this.data3);
            return;
        }
        throw new IllegalStateException("You cannot call `buildModels` directly. Call `setData` instead to trigger a model refresh with new data.");
    }

    public abstract void buildModels(T t, U u, V v);

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

    public void setData(T t, U u, V v) {
        this.data1 = t;
        this.data2 = u;
        this.data3 = v;
        this.allowModelBuildRequests = true;
        requestModelBuild();
        this.allowModelBuildRequests = false;
    }

    public Typed3EpoxyController(Handler handler, Handler handler2) {
        super(handler, handler2);
    }
}
