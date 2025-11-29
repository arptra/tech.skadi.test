package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmptyView extends FrameLayout {
    private boolean ignoreSoftInput;
    private LimitedWHLinearLayout mContentPanel;
    private Context mContext;
    private View mDividerView;
    private ImageView mImageView;
    private boolean mIsShowDot;
    private CharSequence mSummary;
    private int mSummaryTextColor;
    /* access modifiers changed from: private */
    public TextView mSummaryView;
    private int mThemeColor;
    private ArrayList<String> mTips;
    private LinearLayout mTipsPanle;
    private CharSequence mTitle;
    private RelativeLayout mTitleLayout;
    private int mTitleLayoutHeight;
    private TextView mTitleView;

    public EmptyView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void viewControl() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        if (!TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSummary) && ((arrayList2 = this.mTips) == null || arrayList2.size() == 0)) {
            TextView textView = this.mTitleView;
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), this.mTitleView.getPaddingRight(), this.mTitleView.getPaddingBottom());
        } else if (!TextUtils.isEmpty(this.mTitle) && (arrayList = this.mTips) != null && arrayList.size() > 0) {
            ((LinearLayout.LayoutParams) this.mTitleView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.mc_empty_title_margin_top);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EmptyView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mImageView.getDrawable() == null) {
            this.mTitleLayoutHeight = (int) (((double) ((RelativeLayout) this.mTitleLayout.getParent()).getMeasuredHeight()) * 0.48d);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
            layoutParams.addRule(10);
            layoutParams.topMargin = this.mTitleLayoutHeight;
            this.mTitleLayout.setLayoutParams(layoutParams);
        }
    }

    public void setContentPanelMaxWidth(int i) {
        this.mContentPanel.setMaxWidth(i);
    }

    public void setEmptyMarginBottom(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z) {
        this.ignoreSoftInput = z;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentPanel.getLayoutParams();
        if (!z) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setIsShowDot(boolean z) {
        if (this.mIsShowDot != z) {
            this.mIsShowDot = z;
            setTextOfTips(this.mTips);
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mSummaryView.setVisibility(8);
            return;
        }
        this.mSummary = charSequence;
        this.mSummaryView.setText(charSequence);
        this.mSummaryView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = this.mSummaryView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    EmptyView.this.mSummaryView.getViewTreeObserver().removeOnPreDrawListener(this);
                    EmptyView.this.mSummaryView.post(new Runnable() {
                        public void run() {
                            EmptyView.this.mSummaryView.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                    });
                    return true;
                }
            });
        } else {
            this.mSummaryView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.mSummaryView.setLinkTextColor(this.mThemeColor);
        this.mSummaryView.setVisibility(0);
        ArrayList<String> arrayList = this.mTips;
        if (arrayList != null && arrayList.size() > 0) {
            this.mDividerView.setVisibility(0);
        }
    }

    public void setSummaryColor(int i) {
        this.mSummaryView.setTextColor(i);
    }

    public void setTextOfTips(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        setTextOfTips((ArrayList<String>) arrayList);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mTitleView.setVisibility(8);
            return;
        }
        this.mTitle = charSequence;
        this.mTitleView.setText(charSequence);
        this.mTitleView.setVisibility(0);
        ArrayList<String> arrayList = this.mTips;
        if (arrayList != null && arrayList.size() > 0) {
            this.mDividerView.setVisibility(0);
        }
    }

    public void setTitleColor(int i) {
        this.mTitleView.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.mTitleView.setTextSize(f);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        this.mImageView = (ImageView) inflate.findViewById(R.id.empty_image);
        this.mTitleView = (TextView) inflate.findViewById(R.id.empty_title);
        this.mSummaryView = (TextView) inflate.findViewById(R.id.empty_summary);
        this.mTipsPanle = (LinearLayout) inflate.findViewById(R.id.empty_tips_panel);
        this.mDividerView = inflate.findViewById(R.id.titleDivider);
        this.mContentPanel = (LimitedWHLinearLayout) inflate.findViewById(R.id.content_panel);
        this.mTitleLayout = (RelativeLayout) inflate.findViewById(R.id.layout);
        addView(inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmptyView, R.attr.MeizuCommon_EmptyViewStyle, 0);
        ((RelativeLayout.LayoutParams) this.mImageView.getLayoutParams()).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EmptyView_mcTopMarginOfImage, 0);
        ((RelativeLayout.LayoutParams) this.mContentPanel.getLayoutParams()).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EmptyView_mcTopMarginOfTips, 0);
        this.mContentPanel.setMaxWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.EmptyView_mcSrcOfImage);
        if (drawable != null) {
            this.mImageView.setImageDrawable(drawable);
        }
        this.mTitle = obtainStyledAttributes.getString(R.styleable.EmptyView_mcTitle);
        this.mSummary = obtainStyledAttributes.getString(R.styleable.EmptyView_mcSummary);
        String string = obtainStyledAttributes.getString(R.styleable.EmptyView_mcTextOfTips);
        this.mTips = ResourceUtils.getStringArray(getContext(), obtainStyledAttributes, R.styleable.EmptyView_mcTips);
        this.mIsShowDot = obtainStyledAttributes.getBoolean(R.styleable.EmptyView_mcIsShowDot, true);
        try {
            this.mSummaryView.setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(R.styleable.EmptyView_mcSummaryTextAppearance, R.style.TextAppearance_Small_EmptyView_Summary));
            this.mTitleView.setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(R.styleable.EmptyView_mcTitleTextAppearance, R.style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e) {
            e.printStackTrace();
        }
        obtainStyledAttributes.recycle();
        int identifierByAttrId = ResourceUtils.getIdentifierByAttrId(R.attr.colorPrimary, getContext());
        this.mThemeColor = getContext().getColor(R.color.fd_sys_color_primary_blue);
        if (identifierByAttrId != 0) {
            this.mThemeColor = getContext().getColor(identifierByAttrId);
        }
        setTitle(this.mTitle);
        setSummary(this.mSummary);
        if (string == null) {
            setTextOfTips(this.mTips);
        } else {
            setTextOfTips(string);
        }
        viewControl();
    }

    public void setTextOfTips(ArrayList<String> arrayList) {
        this.mTips = arrayList == null ? new ArrayList<>() : arrayList;
        this.mTipsPanle.removeAllViews();
        ArrayList<String> arrayList2 = this.mTips;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.mDividerView.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_margin_Bottom);
        layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_top);
        layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_right);
        float dimensionPixelSize = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.mc_default_word_point);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(48);
            if (this.mIsShowDot) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setLayoutParams(layoutParams2);
                imageView.setImageDrawable(drawable);
                linearLayout.addView(imageView);
            }
            TextView textView = new TextView(this.mContext);
            textView.setLayoutParams(layoutParams3);
            textView.setTextAppearance(getContext(), R.style.TextAppearance_Small_EmptyView);
            textView.setText(next);
            textView.setLineSpacing(dimensionPixelSize, 1.0f);
            linearLayout.addView(textView);
            this.mTipsPanle.addView(linearLayout);
        }
        if (!TextUtils.isEmpty(this.mTitle) || !TextUtils.isEmpty(this.mSummary)) {
            this.mDividerView.setVisibility(0);
        }
    }
}
