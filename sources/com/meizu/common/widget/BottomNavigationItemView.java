package com.meizu.common.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;

public interface BottomNavigationItemView {
    ButtonNavigationItem getItemData();

    View getView();

    void initialize(ButtonNavigationItem buttonNavigationItem);

    void setIcon(Drawable drawable);

    void setSelected(boolean z);

    void setSelectedIconColor(int i);

    void setSelectedIconTintEnabled(boolean z);

    void setTitle(CharSequence charSequence);

    void setTitleColor(ColorStateList colorStateList);
}
