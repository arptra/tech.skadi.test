package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class ContentToastLayout extends FrameLayout {
    private static final int MAX_ICON_SIZE = 32;
    public static final int TOAST_TYPE_ERROR = 1;
    public static final int TOAST_TYPE_NORMAL = 0;
    public static final int TOAST_TYPE_TEXT = 2;
    private ImageView mActionIconView;
    private int mActionTextAppearance;
    private TextView mActionTextView;
    private Drawable mActionViewBackground;
    private LinearLayout mContainerLayout;
    private Drawable mDefaultActionIcon;
    private Drawable mDefaultWarningIcon;
    private Drawable mLayoutBackground;
    private int mMaxIconSize;
    private LinearLayout mParentLayout;
    private View mSeparatorView;
    private String mText;
    private int mTitleTextAppearance;
    private TextView mTitleView;
    private int mToastType;
    private Drawable mWarningIcon;
    private ImageView mWarningView;
    private LinearLayout mWidgetLayout;
    private View mWidgetView;

    public ContentToastLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void ensureActionView() {
        int i = this.mToastType;
        if (i == 0 || i == 1) {
            this.mActionIconView.setVisibility(0);
            this.mActionTextView.setVisibility(8);
        } else if (i == 2) {
            this.mActionTextView.setVisibility(0);
            this.mActionIconView.setVisibility(8);
        }
    }

    public String getText() {
        return this.mText;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ContentToastLayout.class.getName());
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        ensureActionView();
        this.mWidgetLayout.setOnClickListener(onClickListener);
    }

    public void setActionIcon(Drawable drawable) {
        ensureActionView();
        this.mDefaultActionIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.mMaxIconSize;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i) / ((float) intrinsicHeight)));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        this.mActionIconView.setImageDrawable(drawable);
    }

    public void setActionText(CharSequence charSequence) {
        ensureActionView();
        this.mActionTextView.setText(charSequence);
    }

    public void setBackground(Drawable drawable) {
        LinearLayout linearLayout = this.mParentLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(drawable);
        }
    }

    public void setContainerLayoutPadding(int i) {
        this.mContainerLayout.setPadding(i, 0, i, 0);
    }

    public void setIsShowSeparator(boolean z) {
        if (z) {
            this.mSeparatorView.setVisibility(0);
        } else {
            this.mSeparatorView.setVisibility(8);
        }
    }

    public void setLayoutBackground(Drawable drawable) {
        this.mLayoutBackground = drawable;
        this.mParentLayout.setBackgroundDrawable(drawable);
    }

    public void setParentLayoutPadding(int i) {
        this.mParentLayout.setPadding(i, 0, i, 0);
    }

    public void setText(String str) {
        this.mText = str;
        this.mTitleView.setText(str);
    }

    public void setTextColor(int i) {
        this.mTitleView.setTextColor(i);
    }

    public void setTitleGravity(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
        int i2 = i & 112;
        if (i2 == 16) {
            layoutParams.addRule(15);
        } else if (i2 == 48) {
            layoutParams.addRule(10);
        } else if (i2 == 80) {
            layoutParams.addRule(12);
        }
        int i3 = i & 7;
        if (i3 == 1) {
            layoutParams.addRule(14);
        } else if (i3 == 3) {
            layoutParams.addRule(9);
        } else if (i3 == 5) {
            layoutParams.addRule(11);
        }
        layoutParams.addRule(14);
        this.mTitleView.setLayoutParams(layoutParams);
    }

    public void setTitleTextMaxLine(int i) {
        this.mTitleView.setMaxLines(i);
    }

    public void setToastType(int i) {
        this.mToastType = i;
        if (i == 0) {
            setWarningIcon((Drawable) null);
            setActionIcon(this.mDefaultActionIcon);
        } else if (i != 1) {
            if (i != 2) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleTextAppearance);
                this.mParentLayout.setBackgroundDrawable(this.mLayoutBackground);
                this.mWarningView.setVisibility(8);
            }
            setActionIcon((Drawable) null);
            setWarningIcon((Drawable) null);
        } else {
            Drawable drawable = getResources().getDrawable(R.drawable.mz_ic_content_toast_warning);
            this.mDefaultWarningIcon = drawable;
            setWarningIcon(drawable);
            setActionIcon(getResources().getDrawable(R.drawable.mz_arrow_next_right_warning));
            this.mTitleView.setTextColor(getResources().getColor(R.color.mc_content_toast_text_color_error));
            this.mParentLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.mc_content_toast_bg_error));
            this.mWarningView.setVisibility(0);
        }
    }

    public void setWarningIcon(Drawable drawable) {
        this.mWarningIcon = drawable;
        this.mWarningView.setImageDrawable(drawable);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzContentToastLayoutStyle);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mToastType = 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mzContentToastLayout, i, 0);
        this.mActionTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.mzContentToastLayout_mzActionTextAppearance, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.mzContentToastLayout_mzTitleTextAppearance, 0);
        this.mLayoutBackground = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzContentToastBackground);
        this.mDefaultActionIcon = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzActionIcon);
        this.mActionViewBackground = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzActionViewBackground);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.mzContentToastLayout_mzContentLayout, R.layout.mc_content_toast_layout_light);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((getResources().getDisplayMetrics().density * 32.0f) + 0.5f);
        LayoutInflater.from(context).inflate(resourceId, this);
        this.mParentLayout = (LinearLayout) findViewById(R.id.mc_content_toast_parent);
        this.mLayoutBackground.setTint(getContext().getColor(R.color.fd_sys_color_surface_container_lowest_default));
        this.mParentLayout.setBackgroundDrawable(this.mLayoutBackground);
        this.mWidgetLayout = (LinearLayout) findViewById(16908312);
        TextView textView = (TextView) findViewById(16908310);
        this.mTitleView = textView;
        textView.setTextAppearance(context, this.mTitleTextAppearance);
        this.mWarningView = (ImageView) findViewById(16908294);
        this.mSeparatorView = findViewById(R.id.mc_toast_separator);
        this.mContainerLayout = (LinearLayout) findViewById(R.id.mc_content_toast_container);
        this.mActionTextView = (TextView) findViewById(R.id.mz_action_text);
        this.mActionIconView = (ImageView) findViewById(R.id.mz_action_icon);
    }
}
