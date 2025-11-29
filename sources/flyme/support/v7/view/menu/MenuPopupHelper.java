package flyme.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.menu.MenuPresenter;
import flyme.support.v7.view.menu.MenuView;
import flyme.support.v7.widget.ListPopupWindow;
import java.util.ArrayList;

public class MenuPopupHelper implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, MenuPresenter {
    static final int ITEM_LAYOUT = R.layout.mz_popup_menu_item_layout;
    private static final String TAG = "MenuPopupHelper";
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mDropDownGravity;
    private int mFlymeAnimationStyle;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    /* access modifiers changed from: private */
    public final LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public int mMaxLines;
    private ViewGroup mMeasureParent;
    /* access modifiers changed from: private */
    public final MenuBuilder mMenu;
    private View.OnClickListener mOnClickListener;
    /* access modifiers changed from: private */
    public final boolean mOverflowOnly;
    /* access modifiers changed from: private */
    public ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    public class MenuAdapter extends BaseAdapter {
        /* access modifiers changed from: private */
        public MenuBuilder mAdapterMenu;
        private int mExpandedIndex = -1;

        public MenuAdapter(MenuBuilder menuBuilder) {
            this.mAdapterMenu = menuBuilder;
            findExpandedIndex();
        }

        public void findExpandedIndex() {
            MenuItemImpl expandedItem = MenuPopupHelper.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.mMenu.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.mExpandedIndex = i;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }

        public int getCount() {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            return this.mExpandedIndex < 0 ? nonActionItems.size() : nonActionItems.size() - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, viewGroup, false);
            }
            view.setTag(Integer.valueOf(i));
            MenuView.ItemView itemView = (MenuView.ItemView) view.findViewById(R.id.lmiv_container);
            if (MenuPopupHelper.this.mMaxLines > 0) {
                itemView.setTitleMaxLines(MenuPopupHelper.this.mMaxLines);
            }
            if (MenuPopupHelper.this.mForceShowIcon) {
                ((ListMenuItemView) itemView).setForceShowIcon(true);
            }
            itemView.initialize(getItem(i), 0);
            int count = getCount();
            int dimensionPixelSize = MenuPopupHelper.this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_popup_menu_item_padding_ext);
            if (count == 1) {
                view.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            } else if (i == 0) {
                view.setPadding(0, dimensionPixelSize, 0, 0);
            } else if (i == count - 1) {
                view.setPadding(0, 0, 0, dimensionPixelSize);
            } else {
                view.setPadding(0, 0, 0, 0);
            }
            return view;
        }

        public boolean isEnabled(int i) {
            MenuItemImpl item = getItem(i);
            return item == null ? super.isEnabled(i) : item.isEnabled();
        }

        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }

        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            int i2 = this.mExpandedIndex;
            if (i2 >= 0 && i >= i2) {
                i++;
            }
            return nonActionItems.get(i);
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, androidx.appcompat.R.attr.popupMenuStyle);
    }

    private int measureContentWidth() {
        MenuAdapter menuAdapter = this.mAdapter;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = menuAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = menuAdapter.getItemViewType(i3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = new FrameLayout(this.mContext);
            }
            view = menuAdapter.getView(i3, view, this.mMeasureParent);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int i4 = this.mPopupMaxWidth;
            if (measuredWidth >= i4) {
                return i4;
            }
            if (measuredWidth > i) {
                i = measuredWidth;
            }
        }
        return i;
    }

    public void applyFlymeAnimation(int i) {
        this.mFlymeAnimationStyle = i;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public ListPopupWindow getPopup() {
        return this.mPopup;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public boolean isShowing() {
        ListPopupWindow listPopupWindow = this.mPopup;
        return listPopupWindow != null && listPopupWindow.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.mAnchorView;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.mPopup.show();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuAdapter menuAdapter = this.mAdapter;
        menuAdapter.mAdapterMenu.performItemAction(menuAdapter.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.mAnchorView);
            menuPopupHelper.setCallback(this.mPresenterCallback);
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            menuPopupHelper.setForceShowIcon(z);
            if (menuPopupHelper.tryShow()) {
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setItemMaxLines(int i) {
        this.mMaxLines = i;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        ListPopupWindow listPopupWindow = new ListPopupWindow(this.mContext, (AttributeSet) null, this.mPopupStyleAttr, this.mPopupStyleRes);
        this.mPopup = listPopupWindow;
        listPopupWindow.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.setModal(true);
        if (this.mDropDownGravity == 0) {
            ListPopupWindow listPopupWindow2 = this.mPopup;
            int i = this.mFlymeAnimationStyle;
            if (i == -1) {
                i = 0;
            }
            listPopupWindow2.applyFlymeAnimation(i);
        } else {
            int i2 = this.mFlymeAnimationStyle;
            if (i2 != -1) {
                this.mPopup.applyFlymeAnimation(i2);
            }
        }
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        boolean z = this.mTreeObserver == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.mTreeObserver = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.mPopup.setAnchorView(view);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (!this.mHasContentWidth) {
            this.mContentWidth = measureContentWidth();
            this.mHasContentWidth = true;
        }
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setClippingEnabled(false);
        this.mPopup.show();
        this.mPopup.getListView().setOnKeyListener(this);
        return true;
    }

    public void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, androidx.appcompat.R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.mDropDownGravity = 0;
        this.mMaxLines = -1;
        this.mOnClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuPopupHelper.this.isShowing()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    ListView listView = MenuPopupHelper.this.mPopup.getListView();
                    MenuPopupHelper.this.onItemClick(listView, listView.getChildAt(intValue - listView.getFirstVisiblePosition()), intValue, listView.getAdapter().getItemId(intValue));
                }
            }
        };
        this.mFlymeAnimationStyle = -1;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = menuBuilder;
        this.mAdapter = new MenuAdapter(menuBuilder);
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mPopupMaxWidth = context.getResources().getDimensionPixelSize(com.meizu.common.R.dimen.mz_popup_menu_width_max);
        this.mAnchorView = view;
        menuBuilder.addMenuPresenter(this, context);
    }
}
