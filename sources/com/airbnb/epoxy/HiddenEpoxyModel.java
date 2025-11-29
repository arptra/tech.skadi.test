package com.airbnb.epoxy;

import android.widget.Space;
import com.airbnb.viewmodeladapter.R;

class HiddenEpoxyModel extends EpoxyModel<Space> {
    public int A(int i, int i2, int i3) {
        return 0;
    }

    public int x() {
        return R.layout.view_holder_empty_view;
    }
}
