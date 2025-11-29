package flyme.support.v7.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.appcompat.R;

public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getActionBarButtonMaxHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, R.styleable.Toolbar, CommonUtils.hasFullDisplay() ? R.attr.mzToolbarStyleFullScreen : androidx.appcompat.R.attr.toolbarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(androidx.appcompat.R.styleable.Toolbar_maxButtonHeight, this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_action_button_min_height_appcompat));
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        return this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }

    public int getSplitActionBarPadding() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_action_mode_split_padding);
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_action_bar_stacked_max_height);
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getApplicationInfo().targetSdkVersion >= 16 ? this.mContext.getResources().getBoolean(androidx.appcompat.R.bool.abc_action_bar_embed_tabs) : this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
