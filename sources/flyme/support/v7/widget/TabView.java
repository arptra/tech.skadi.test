package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.appcompat.R;

public class TabView extends RelativeLayout implements CustomTabView {
    private TitleBarBadgeView mTabBadgeView;
    private TextView mTextView;
    private View mView;

    public TabView(Context context) {
        this(context, (AttributeSet) null);
        setClipChildren(false);
    }

    public int getContentBottom() {
        TextView textView = this.mTextView;
        this = this;
        if (textView != null) {
            this = this;
            if (textView.getVisibility() == 0) {
                this = this.mTextView;
            }
        }
        return this.getBottom();
    }

    public int getRadius() {
        return this.mTabBadgeView.getBadgeRadius();
    }

    public String getTabText() {
        return (String) this.mTextView.getText();
    }

    public TextView getTabTextView() {
        return this.mTextView;
    }

    public TitleBarBadgeView getTitleBarBadgeView() {
        return this.mTabBadgeView;
    }

    public boolean isShowBadge() {
        return this.mTabBadgeView.isIsShow();
    }

    public void setBadgeNumber(int i) {
        this.mTabBadgeView.setBadgeNumber(i, this.mTextView);
    }

    public void setIsTitleBar(boolean z) {
        if (z) {
            this.mView = LayoutInflater.from(getContext()).inflate(CommonUtils.hasFullDisplay() ? R.layout.mz_title_bar_badge_layout_full_screen : R.layout.mz_title_bar_badge_layout, this);
        } else {
            this.mView = LayoutInflater.from(getContext()).inflate(R.layout.mz_tab_bar_badge_layout, this);
        }
        View view = this.mView;
        if (view == null) {
            Log.w("TabView", "can not inflate the view");
            return;
        }
        this.mTextView = (TextView) view.findViewById(R.id.tab_text);
        this.mTabBadgeView = (TitleBarBadgeView) this.mView.findViewById(R.id.tab_badge);
    }

    public void setRadius(int i) {
        this.mTabBadgeView.setBadgeRadius(i);
    }

    public void setShowBadge(boolean z) {
        this.mTabBadgeView.setShow(z);
    }

    public void setTabText(String str) {
        this.mTextView.setText(str);
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        this.mTextView.setTextColor(colorStateList);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
