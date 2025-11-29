package com.airbnb.epoxy;

import android.os.Handler;
import androidx.annotation.Nullable;

public abstract class TypedEpoxyController<T> extends EpoxyController {
    private boolean allowModelBuildRequests;
    private T currentData;

    public TypedEpoxyController() {
    }

    public final void buildModels() {
        if (isBuildingModels()) {
            buildModels(this.currentData);
            return;
        }
        throw new IllegalStateException("You cannot call `buildModels` directly. Call `setData` instead to trigger a model refresh with new data.");
    }

    public abstract void buildModels(T t);

    @Nullable
    public final T getCurrentData() {
        return this.currentData;
    }

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

    public final void setData(T t) {
        this.currentData = t;
        this.allowModelBuildRequests = true;
        requestModelBuild();
        this.allowModelBuildRequests = false;
    }

    public TypedEpoxyController(Handler handler, Handler handler2) {
        super(handler, handler2);
    }
}
