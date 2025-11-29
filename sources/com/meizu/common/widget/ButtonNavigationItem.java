package com.meizu.common.widget;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;

public interface ButtonNavigationItem {
    int getBadgeCount();

    Drawable getIcon();

    int getId();

    BottomNavigationItemView getItemView();

    String getTitle();

    ColorStateList getTitleColor();

    boolean isBadgeVisible();

    boolean isSelected();

    void onConfigurationChanged(Configuration configuration);

    ButtonNavigationItem setBadgeCount(int i);

    ButtonNavigationItem setBadgeVisible(boolean z);

    ButtonNavigationItem setIcon(Drawable drawable);

    ButtonNavigationItem setId(int i);

    ButtonNavigationItem setSelected(boolean z);

    ButtonNavigationItem setTitle(String str);

    ButtonNavigationItem setTitleColor(ColorStateList colorStateList);
}
