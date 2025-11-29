package flyme.support.v7.view.menu;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

public interface FMenuItem extends SupportMenuItem {
    /* synthetic */ boolean collapseActionView();

    /* synthetic */ boolean expandActionView();

    @Nullable
    /* synthetic */ View getActionView();

    /* synthetic */ int getAlphabeticModifiers();

    @Nullable
    /* synthetic */ CharSequence getContentDescription();

    @Nullable
    /* synthetic */ ColorStateList getIconTintList();

    @Nullable
    /* synthetic */ PorterDuff.Mode getIconTintMode();

    int getLittleSpotCount();

    /* synthetic */ int getNumericModifiers();

    @Nullable
    /* synthetic */ ActionProvider getSupportActionProvider();

    ColorStateList getTitleColor();

    @Nullable
    /* synthetic */ CharSequence getTooltipText();

    /* synthetic */ boolean isActionViewExpanded();

    boolean isLittleSpotVisible();

    boolean isSelected();

    /* synthetic */ boolean requiresActionButton();

    /* synthetic */ boolean requiresOverflow();

    @NonNull
    /* synthetic */ MenuItem setActionView(int i);

    @NonNull
    /* synthetic */ MenuItem setActionView(@Nullable View view);

    @NonNull
    /* synthetic */ MenuItem setAlphabeticShortcut(char c, int i);

    @NonNull
    /* synthetic */ SupportMenuItem setContentDescription(@Nullable CharSequence charSequence);

    @NonNull
    /* synthetic */ MenuItem setIconTintList(@Nullable ColorStateList colorStateList);

    @NonNull
    /* synthetic */ MenuItem setIconTintMode(@Nullable PorterDuff.Mode mode);

    MenuItem setLittleSpotCount(int i);

    MenuItem setLittleSpotVisible(boolean z);

    @NonNull
    /* synthetic */ MenuItem setNumericShortcut(char c, int i);

    MenuItem setSelected(boolean z);

    @NonNull
    /* synthetic */ MenuItem setShortcut(char c, char c2, int i, int i2);

    /* synthetic */ void setShowAsAction(int i);

    @NonNull
    /* synthetic */ MenuItem setShowAsActionFlags(int i);

    @NonNull
    /* synthetic */ SupportMenuItem setSupportActionProvider(@Nullable ActionProvider actionProvider);

    MenuItem setTitleColor(ColorStateList colorStateList);

    @NonNull
    /* synthetic */ SupportMenuItem setTooltipText(@Nullable CharSequence charSequence);
}
