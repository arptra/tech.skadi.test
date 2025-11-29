package com.meizu.textinputlayout;

import android.view.View;
import android.view.ViewOutlineProvider;

class ViewUtilsLollipop {
    public static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }
}
