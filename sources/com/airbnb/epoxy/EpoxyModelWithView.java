package com.airbnb.epoxy;

import android.view.View;

public abstract class EpoxyModelWithView<T extends View> extends EpoxyModel<T> {
    public int B() {
        return 0;
    }

    public final int x() {
        throw new UnsupportedOperationException("Layout resources are unsupported. Views must be created with `buildView`");
    }
}
