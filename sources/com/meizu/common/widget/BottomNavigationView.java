package com.meizu.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.R;
import java.util.Map;

public class BottomNavigationView extends FrameLayout {
    private Map<Integer, ButtonNavigationItem> mItems;
    private Configuration mLastConfiguration;
    private LinearLayout mNavigationBarMenuView;
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    private View.OnClickListener mOnItemViewClickListener;
    private int mSelectedIconColor;
    private boolean mSelectedIconColorTintEnabled;

    public static class ButtonNavigationItemImpl implements ButtonNavigationItem {
        private static final int CHECKABLE = 1;
        private static final int CHECKED = 2;
        private static final int ENABLED = 16;
        private static final int EXCLUSIVE = 4;
        private static final int HIDDEN = 8;
        private static final int IS_ACTION = 32;
        private static final int SELECTED = 64;
        private int mBadgeCount;
        private boolean mBadgeVisible;
        private ColorStateList mColor;
        private int mFlags = 16;
        private Drawable mIconDrawable;
        private int mId;
        private Configuration mLastConfiguration;
        private BottomNavigationView mLayout;
        private NavigationMenuItemView mMenuItemView;
        private String mTitle;

        public ButtonNavigationItemImpl(int i, BottomNavigationView bottomNavigationView) {
            this.mId = i;
            this.mLayout = bottomNavigationView;
            this.mLastConfiguration = new Configuration(bottomNavigationView.getContext().getResources().getConfiguration());
        }

        public int getBadgeCount() {
            return this.mBadgeCount;
        }

        public Drawable getIcon() {
            return this.mIconDrawable;
        }

        public int getId() {
            return this.mId;
        }

        public BottomNavigationItemView getItemView() {
            if (this.mMenuItemView == null) {
                this.mMenuItemView = this.mLayout.createItemView(this);
            }
            return this.mMenuItemView;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public ColorStateList getTitleColor() {
            return this.mColor;
        }

        public boolean isBadgeVisible() {
            return this.mBadgeVisible;
        }

        public boolean isSelected() {
            return (this.mFlags & 64) != 0;
        }

        public void onConfigurationChanged(Configuration configuration) {
            if (this.mLastConfiguration == null) {
                this.mLastConfiguration = new Configuration(configuration);
            }
            int diff = this.mLastConfiguration.diff(configuration);
            this.mLastConfiguration.setTo(configuration);
            if ((diff & 128) != 0) {
                this.mMenuItemView = this.mLayout.createItemView(this);
            }
        }

        public ButtonNavigationItem setBadgeCount(int i) {
            if (this.mBadgeCount != i) {
                this.mBadgeCount = i;
                getItemView().initialize(this);
            }
            return this;
        }

        public ButtonNavigationItem setBadgeVisible(boolean z) {
            if (this.mBadgeVisible != z) {
                this.mBadgeVisible = z;
                getItemView().initialize(this);
            }
            return this;
        }

        public ButtonNavigationItem setIcon(Drawable drawable) {
            this.mIconDrawable = drawable;
            getItemView().initialize(this);
            return this;
        }

        public ButtonNavigationItem setId(int i) {
            return this;
        }

        public void setItemView(NavigationMenuItemView navigationMenuItemView) {
            this.mMenuItemView = navigationMenuItemView;
        }

        public ButtonNavigationItem setSelected(boolean z) {
            if (z) {
                this.mFlags |= 64;
            } else {
                this.mFlags &= -65;
            }
            getItemView().initialize(this);
            return this;
        }

        public ButtonNavigationItem setTitle(String str) {
            this.mTitle = str;
            getItemView().initialize(this);
            return this;
        }

        public ButtonNavigationItem setTitleColor(ColorStateList colorStateList) {
            this.mColor = colorStateList;
            getItemView().initialize(this);
            return this;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ButtonNavigationItem buttonNavigationItem);
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public NavigationMenuItemView createItemView(ButtonNavigationItem buttonNavigationItem) {
        return (NavigationMenuItemView) LayoutInflater.from(getContext()).inflate(R.layout.mz_navigation_bar_item_content, (ViewGroup) null, false);
    }

    private void ensureNavigationBarMenuView() {
        if (this.mNavigationBarMenuView == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mNavigationBarMenuView = linearLayout;
            addView(linearLayout, -1, -1);
        }
    }

    public void addItem(ButtonNavigationItem buttonNavigationItem) {
        ensureNavigationBarMenuView();
        BottomNavigationItemView itemView = buttonNavigationItem.getItemView();
        if (itemView != null) {
            itemView.setSelectedIconColor(this.mSelectedIconColor);
            itemView.setSelectedIconTintEnabled(this.mSelectedIconColorTintEnabled);
            itemView.initialize(buttonNavigationItem);
            this.mItems.put(Integer.valueOf(buttonNavigationItem.getId()), buttonNavigationItem);
            View view = itemView.getView();
            if (view != null) {
                view.setOnClickListener(this.mOnItemViewClickListener);
                view.setTag(buttonNavigationItem);
                LinearLayout.LayoutParams layoutParams = this.mLastConfiguration.orientation == 1 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-2, -1);
                layoutParams.weight = 1.0f;
                this.mNavigationBarMenuView.addView(view, layoutParams);
            }
        }
    }

    public ButtonNavigationItem getItem(int i) {
        return this.mItems.get(Integer.valueOf(i));
    }

    public ButtonNavigationItem newItem(int i) {
        return new ButtonNavigationItemImpl(i, this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int diff = this.mLastConfiguration.diff(configuration);
        this.mLastConfiguration.setTo(configuration);
        if (this.mItems.size() > 0) {
            for (ButtonNavigationItem onConfigurationChanged : this.mItems.values()) {
                onConfigurationChanged.onConfigurationChanged(configuration);
            }
            if ((diff & 128) != 0) {
                this.mNavigationBarMenuView.removeAllViews();
                for (ButtonNavigationItem addItem : this.mItems.values()) {
                    addItem(addItem);
                }
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setSelectedIconColor(@ColorInt int i) {
        if (this.mSelectedIconColor != i) {
            this.mSelectedIconColor = i;
            for (ButtonNavigationItem itemView : this.mItems.values()) {
                BottomNavigationItemView itemView2 = itemView.getItemView();
                if (itemView2 != null) {
                    itemView2.setSelectedIconColor(this.mSelectedIconColor);
                }
            }
        }
    }

    public void setSelectedIconTintEnabled(boolean z) {
        this.mSelectedIconColorTintEnabled = z;
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzBottomNavigationViewStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItems = new ArrayMap();
        this.mOnItemViewClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Object tag = view.getTag();
                if (BottomNavigationView.this.mOnItemClickListener != null && (tag instanceof ButtonNavigationItemImpl)) {
                    BottomNavigationView.this.mOnItemClickListener.onItemClick((ButtonNavigationItem) tag);
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mzBottomNavigationLayout, i, 0);
        this.mSelectedIconColor = obtainStyledAttributes.getColor(R.styleable.mzBottomNavigationLayout_mzSelectedIconColor, context.getResources().getColor(R.color.mz_theme_color_blue));
        this.mSelectedIconColorTintEnabled = obtainStyledAttributes.getBoolean(R.styleable.mzBottomNavigationLayout_mzSelectedIconTintEnable, true);
        obtainStyledAttributes.recycle();
        this.mLastConfiguration = new Configuration(context.getResources().getConfiguration());
    }
}
