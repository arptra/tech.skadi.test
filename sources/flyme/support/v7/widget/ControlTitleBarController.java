package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import flyme.support.v7.widget.ToolbarWidgetWrapper;

public class ControlTitleBarController {
    private ControlTitleBar mControlTitleBar;
    private ToolbarWidgetWrapper.ControlButtonImpl mNegativeButtonData;
    private View.OnClickListener mNegativeClickListener;
    private ToolbarWidgetWrapper.ControlButtonImpl mPositiveButtonData;
    private View.OnClickListener mPositiveClickListener;
    private boolean mPreventDispatchingItemsChanged = false;
    private CharSequence mTitle;

    public void bindButton(int i, ToolbarWidgetWrapper.ControlButtonImpl controlButtonImpl, View.OnClickListener onClickListener) {
        controlButtonImpl.setControlTitleBarController(this);
        if (i == 1) {
            this.mPositiveButtonData = controlButtonImpl;
            this.mPositiveClickListener = onClickListener;
            return;
        }
        this.mNegativeButtonData = controlButtonImpl;
        this.mNegativeClickListener = onClickListener;
    }

    public ControlTitleBar getControlTitleBar(Context context) {
        if (this.mControlTitleBar == null) {
            this.mControlTitleBar = new ControlTitleBar(context);
        }
        return this.mControlTitleBar;
    }

    public View.OnClickListener getNegativeClickListener() {
        return this.mNegativeClickListener;
    }

    public View.OnClickListener getPositiveClickListener() {
        return this.mPositiveClickListener;
    }

    public void onItemDataChanged() {
        Drawable drawable;
        String str;
        int i;
        Drawable drawable2;
        if (!this.mPreventDispatchingItemsChanged) {
            this.mControlTitleBar.setTitle(this.mTitle);
            ToolbarWidgetWrapper.ControlButtonImpl controlButtonImpl = this.mPositiveButtonData;
            int i2 = -1;
            String str2 = null;
            if (controlButtonImpl != null) {
                i = controlButtonImpl.getId();
                str = this.mPositiveButtonData.getTitle();
                drawable = this.mPositiveButtonData.getIcon();
            } else {
                i = -1;
                str = null;
                drawable = null;
            }
            ToolbarWidgetWrapper.ControlButtonImpl controlButtonImpl2 = this.mNegativeButtonData;
            if (controlButtonImpl2 != null) {
                i2 = controlButtonImpl2.getId();
                str2 = this.mNegativeButtonData.getTitle();
                drawable2 = this.mNegativeButtonData.getIcon();
            } else {
                drawable2 = null;
            }
            this.mControlTitleBar.setButton(0, str2, drawable2, this.mNegativeClickListener);
            this.mControlTitleBar.setButton(1, str, drawable, this.mPositiveClickListener);
            View positiveItemView = this.mControlTitleBar.getPositiveItemView();
            positiveItemView.setEnabled(this.mPositiveButtonData.isEnabled());
            positiveItemView.setId(i);
            if (!this.mPositiveButtonData.isVisible() || (this.mPositiveButtonData.getIcon() == null && TextUtils.isEmpty(this.mPositiveButtonData.getTitle()))) {
                positiveItemView.setVisibility(8);
            } else {
                positiveItemView.setVisibility(0);
            }
            View negativeItemView = this.mControlTitleBar.getNegativeItemView();
            negativeItemView.setEnabled(this.mNegativeButtonData.isEnabled());
            negativeItemView.setId(i2);
            if (!this.mNegativeButtonData.isVisible() || (this.mNegativeButtonData.getIcon() == null && TextUtils.isEmpty(this.mNegativeButtonData.getTitle()))) {
                negativeItemView.setVisibility(8);
            } else {
                negativeItemView.setVisibility(0);
            }
        }
    }

    public void setNegativeClickListener(View.OnClickListener onClickListener) {
        this.mNegativeClickListener = onClickListener;
    }

    public void setPositiveClickListener(View.OnClickListener onClickListener) {
        this.mPositiveClickListener = onClickListener;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        ControlTitleBar controlTitleBar = this.mControlTitleBar;
        if (controlTitleBar != null) {
            controlTitleBar.setTitle(charSequence);
        }
    }

    public void setTitleColor(int i) {
        ControlTitleBar controlTitleBar = this.mControlTitleBar;
        if (controlTitleBar != null) {
            controlTitleBar.setTitleColor(i);
        }
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        onItemDataChanged();
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
        }
    }
}
