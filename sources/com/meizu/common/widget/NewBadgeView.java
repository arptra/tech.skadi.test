package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class NewBadgeView extends ViewGroup {
    public static final int BADGE_STYLE_SHOW_DOT = 0;
    public static final int BADGE_STYLE_SHOW_NUMBER = 1;
    public static int BADGE_VIEW_MODE_AVATAR = 1;
    public static int BADGE_VIEW_MODE_ICON_LAUNCH = 2;
    public static int BADGE_VIEW_MODE_ICON_SYSTEM = 3;
    public static int BADGE_VIEW_MODE_TEXTVIEW = 0;
    private static int CONTENT_VIEW_TYPE_DEFAULT = 1;
    public static int CONTENT_VIEW_TYPE_ICON = 1;
    public static int CONTENT_VIEW_TYPE_STRING = 0;
    public static int POINT_CENTER_AT_BOTH_INSIDE = 0;
    public static int POINT_CENTER_AT_BOTH_OUTSIDE = 1;
    public static int POINT_CENTER_AT_BOTH_OUTSIDE_BOTTOM_RIGHT = 8;
    public static int POINT_CENTER_AT_BOTH_OUTSIDE_TOP_LEFT = 7;
    private static int POINT_CENTER_AT_DEFAULT = 2;
    public static int POINT_CENTER_AT_INSIDE_RIGHT_BOTTOM = 6;
    public static int POINT_CENTER_AT_INSIDE_TOP_LEFT = 4;
    public static int POINT_CENTER_AT_OUTSIDE_RIGHT_TOP = 5;
    public static int POINT_CENTER_AT_OUTSIDE_TOP_RIGHT = 3;
    private static final int POINT_CENTER_AT_TOP_LEFT_RTL = 9;
    public static int POINT_CENTER_AT_TOP_RIGHT = 2;
    private static Boolean SHOW_POINT_VIEW_BORDER_DEFAULT = Boolean.FALSE;
    private Drawable mContainerDrawable;
    private int mContainerDrawableId;
    private String mContainerText;
    private int mContentViewType;
    private int mGravity;
    private ImageView mIconContent;
    private int mLaunchIconNumPadding;
    private int mLaunchIconPadding;
    private int mModeType;
    private NewMessageView mNewMessageView;
    private int mPointCenterLocation;
    private int mPointMaxHeight;
    private int mPointMaxWidth;
    private View mPointView;
    private int mPointViewBorder;
    private float mPointViewTextSize;
    private Boolean mShowPointViewBorder;
    private TextView mStringContent;
    private int mSystemIconNumLeftPadding;
    private int mSystemIconNumTopPadding;

    public NewBadgeView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initAttrs(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mzNewBadgeView);
        int i2 = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcContentViewType, CONTENT_VIEW_TYPE_DEFAULT);
        this.mContentViewType = i2;
        if (i2 == CONTENT_VIEW_TYPE_STRING) {
            this.mPointCenterLocation = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointCenterLocation, POINT_CENTER_AT_OUTSIDE_TOP_RIGHT);
        } else {
            this.mPointCenterLocation = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointCenterLocation, POINT_CENTER_AT_DEFAULT);
        }
        this.mShowPointViewBorder = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mzNewBadgeView_mcPointViewBorderShow, SHOW_POINT_VIEW_BORDER_DEFAULT.booleanValue()));
        int dp2px = (int) ResourceUtils.dp2px((float) obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointViewBorder, 0), context);
        this.mPointViewBorder = dp2px;
        if (dp2px > 0) {
            this.mShowPointViewBorder = Boolean.TRUE;
        }
        this.mContainerText = obtainStyledAttributes.getString(R.styleable.mzNewBadgeView_mcContentTextViewText);
        this.mContainerDrawableId = obtainStyledAttributes.getResourceId(R.styleable.mzNewBadgeView_mcContentImageViewSrc, 0);
        this.mPointViewTextSize = obtainStyledAttributes.getFloat(R.styleable.mzNewBadgeView_mcPointViewTextSize, 10.0f);
        obtainStyledAttributes.recycle();
        this.mLaunchIconPadding = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_launch_icon_padding);
        this.mLaunchIconNumPadding = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_launch_icon_num_padding);
        this.mSystemIconNumLeftPadding = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_system_icon_padding_left);
        this.mSystemIconNumTopPadding = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_system_icon_padding_top);
    }

    private void initView(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        this.mIconContent = (ImageView) from.inflate(R.layout.mc_badge_view_image_item, this, false);
        this.mStringContent = (TextView) from.inflate(R.layout.mc_badge_view_text_item, this, false);
        int i = this.mContentViewType;
        if (i == CONTENT_VIEW_TYPE_STRING) {
            String str = this.mContainerText;
            if (str != null && !str.equals("")) {
                this.mStringContent.setText(this.mContainerText);
            }
            addView(this.mStringContent);
        } else if (i == CONTENT_VIEW_TYPE_ICON) {
            int i2 = this.mContainerDrawableId;
            if (i2 != 0) {
                this.mIconContent.setImageResource(i2);
            }
            addView(this.mIconContent);
        }
        View inflate = from.inflate(R.layout.mc_badge_view_point_view_item, this, false);
        this.mPointView = inflate;
        addView(inflate);
        NewMessageView newMessageView = (NewMessageView) findViewById(R.id.mz_new_message_view);
        this.mNewMessageView = newMessageView;
        this.mPointMaxHeight = newMessageView.getViewMaxHeight();
        this.mPointMaxWidth = this.mNewMessageView.getViewMaxWidth();
        setShowPointViewBorder(this.mShowPointViewBorder.booleanValue());
    }

    public int getBadgeNumber() {
        return this.mNewMessageView.getNewMessageNum().intValue();
    }

    public int getBadgeViewBorder() {
        return this.mPointViewBorder;
    }

    public int getContentViewType() {
        return this.mContentViewType;
    }

    public Drawable getDrawable() {
        return this.mContainerDrawable;
    }

    public int getModeType() {
        return this.mModeType;
    }

    public int getPointCenterLocation() {
        return this.mPointCenterLocation;
    }

    public String getText() {
        return this.mContainerText;
    }

    public void measureChildView(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ViewCompat.z(this) == 1) {
            setPointCenterLocation(9);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        int paddingTop2;
        int i10;
        View view = this.mPointView;
        int i11 = this.mContentViewType;
        View view2 = i11 == CONTENT_VIEW_TYPE_ICON ? this.mIconContent : i11 == CONTENT_VIEW_TYPE_STRING ? this.mStringContent : null;
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        int measuredWidth3 = getMeasuredWidth();
        int paddingLeft = getPaddingLeft();
        if ((this.mGravity & 7) == 1) {
            paddingLeft += (((measuredWidth3 - paddingLeft) - getPaddingRight()) - measuredWidth) / 2;
        }
        int i12 = this.mPointCenterLocation;
        if (i12 == POINT_CENTER_AT_BOTH_INSIDE) {
            i7 = getPaddingTop();
            if (this.mModeType == BADGE_VIEW_MODE_ICON_LAUNCH) {
                i8 = ((paddingLeft + measuredWidth) - measuredWidth2) - this.mLaunchIconPadding;
                paddingTop = getPaddingTop();
                i9 = this.mLaunchIconPadding;
            } else {
                i6 = (paddingLeft + measuredWidth) - measuredWidth2;
                i5 = getPaddingTop();
                view2.layout(paddingLeft, i7, measuredWidth + paddingLeft, measuredHeight + i7);
                view.layout(i6, i5, measuredWidth2 + i6, measuredHeight2 + i5);
            }
        } else {
            if (i12 == POINT_CENTER_AT_BOTH_OUTSIDE) {
                i7 = getPaddingTop() + this.mPointMaxHeight;
                i6 = paddingLeft + measuredWidth;
                paddingTop2 = getPaddingTop();
                i10 = this.mPointMaxHeight;
            } else if (i12 == POINT_CENTER_AT_TOP_RIGHT) {
                i7 = getPaddingTop() + (this.mPointMaxHeight / 2);
                if (this.mModeType == BADGE_VIEW_MODE_ICON_SYSTEM) {
                    i8 = ((paddingLeft + measuredWidth) - (measuredWidth2 / 2)) - this.mSystemIconNumLeftPadding;
                    paddingTop = getPaddingTop() + ((this.mPointMaxHeight - measuredHeight2) / 2);
                    i9 = this.mSystemIconNumTopPadding;
                } else {
                    i8 = (paddingLeft + measuredWidth) - (measuredWidth2 / 2);
                    paddingTop = getPaddingTop();
                    i9 = (this.mPointMaxHeight - measuredHeight2) / 2;
                }
            } else if (i12 == POINT_CENTER_AT_OUTSIDE_TOP_RIGHT) {
                i7 = getPaddingTop() + (this.mPointMaxHeight / 2);
                i8 = paddingLeft + measuredWidth;
                paddingTop = getPaddingTop();
                i9 = (this.mPointMaxHeight - measuredHeight2) / 2;
            } else if (i12 == POINT_CENTER_AT_INSIDE_TOP_LEFT) {
                i7 = getPaddingTop() + (this.mPointMaxHeight / 2);
                i8 = (paddingLeft + measuredWidth) - measuredWidth2;
                paddingTop = getPaddingTop();
                i9 = (this.mPointMaxHeight - measuredHeight2) / 2;
            } else if (i12 == POINT_CENTER_AT_OUTSIDE_RIGHT_TOP) {
                i7 = getPaddingTop() + this.mPointMaxHeight;
                i6 = (paddingLeft + measuredWidth) - (measuredWidth2 / 2);
                paddingTop2 = getPaddingTop();
                i10 = this.mPointMaxHeight;
            } else {
                if (i12 == POINT_CENTER_AT_INSIDE_RIGHT_BOTTOM) {
                    i7 = getPaddingTop();
                    if (this.mModeType == BADGE_VIEW_MODE_ICON_LAUNCH) {
                        i6 = ((paddingLeft + measuredWidth) - (measuredWidth2 / 2)) - this.mLaunchIconNumPadding;
                        i5 = getPaddingTop();
                    } else {
                        i6 = (paddingLeft + measuredWidth) - (measuredWidth2 / 2);
                        i5 = getPaddingTop();
                    }
                } else if (i12 == POINT_CENTER_AT_BOTH_OUTSIDE_TOP_LEFT) {
                    i7 = getPaddingTop() + this.mPointMaxHeight;
                    i6 = (paddingLeft + measuredWidth) - measuredWidth2;
                    paddingTop2 = getPaddingTop();
                    i10 = this.mPointMaxHeight;
                } else if (i12 == POINT_CENTER_AT_BOTH_OUTSIDE_BOTTOM_RIGHT) {
                    i7 = getPaddingTop();
                    i6 = paddingLeft + measuredWidth;
                    i5 = getPaddingTop();
                } else {
                    i5 = 0;
                    if (i12 == 9) {
                        i7 = this.mModeType == BADGE_VIEW_MODE_ICON_SYSTEM ? getPaddingTop() + (this.mSystemIconNumLeftPadding * 2) : getPaddingTop();
                        if (this.mContentViewType == CONTENT_VIEW_TYPE_STRING) {
                            i6 = (paddingLeft - (measuredWidth2 / 2)) - (this.mSystemIconNumLeftPadding * 2);
                            i5 = Math.max((getPaddingTop() + ((this.mPointMaxHeight - measuredHeight2) / 2)) - (this.mSystemIconNumTopPadding * 3), 0);
                        } else {
                            int i13 = this.mModeType;
                            if (i13 == BADGE_VIEW_MODE_TEXTVIEW || i13 == BADGE_VIEW_MODE_ICON_LAUNCH) {
                                i8 = (paddingLeft - (measuredWidth2 / 2)) + (this.mSystemIconNumLeftPadding * 2);
                                paddingTop = getPaddingTop();
                                i9 = (this.mPointMaxHeight - measuredHeight2) / 2;
                            } else if (i13 == BADGE_VIEW_MODE_AVATAR || i13 == BADGE_VIEW_MODE_ICON_SYSTEM) {
                                i6 = (paddingLeft - (measuredWidth2 / 2)) + this.mSystemIconNumLeftPadding;
                                i5 = Math.max((getPaddingTop() + ((this.mPointMaxHeight - measuredHeight2) / 2)) - (this.mSystemIconNumTopPadding * 2), 0);
                            } else {
                                i5 = getPaddingTop();
                            }
                        }
                    } else {
                        i7 = 0;
                        paddingLeft = 0;
                    }
                    i6 = paddingLeft;
                }
                view2.layout(paddingLeft, i7, measuredWidth + paddingLeft, measuredHeight + i7);
                view.layout(i6, i5, measuredWidth2 + i6, measuredHeight2 + i5);
            }
            i5 = (paddingTop2 + i10) - measuredHeight2;
            view2.layout(paddingLeft, i7, measuredWidth + paddingLeft, measuredHeight + i7);
            view.layout(i6, i5, measuredWidth2 + i6, measuredHeight2 + i5);
        }
        i5 = paddingTop + i9;
        view2.layout(paddingLeft, i7, measuredWidth + paddingLeft, measuredHeight + i7);
        view.layout(i6, i5, measuredWidth2 + i6, measuredHeight2 + i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            int r0 = r9.getPaddingLeft()
            int r1 = r9.getPaddingRight()
            int r0 = r0 + r1
            int r10 = r10 - r0
            int r11 = android.view.View.MeasureSpec.getSize(r11)
            int r1 = r9.getPaddingTop()
            int r2 = r9.getPaddingBottom()
            int r1 = r1 + r2
            int r11 = r11 - r1
            int r2 = r9.mContentViewType
            int r3 = CONTENT_VIEW_TYPE_ICON
            if (r2 != r3) goto L_0x0028
            android.widget.ImageView r2 = r9.mIconContent
            r9.measureChildView(r2, r10, r11)
            goto L_0x0031
        L_0x0028:
            int r3 = CONTENT_VIEW_TYPE_STRING
            if (r2 != r3) goto L_0x0031
            android.widget.TextView r2 = r9.mStringContent
            r9.measureChildView(r2, r10, r11)
        L_0x0031:
            android.view.View r2 = r9.mPointView
            if (r2 == 0) goto L_0x0038
            r9.measureChildView(r2, r10, r11)
        L_0x0038:
            int r10 = r9.getChildCount()
            r11 = 0
            r2 = r11
            r3 = r2
            r4 = r3
        L_0x0040:
            if (r2 >= r10) goto L_0x00e6
            android.view.View r5 = r9.getChildAt(r2)
            int r6 = r5.getMeasuredWidth()
            int r5 = r5.getMeasuredHeight()
            if (r2 != 0) goto L_0x0054
            r4 = r5
            r3 = r6
            goto L_0x00e2
        L_0x0054:
            r5 = 1
            if (r2 != r5) goto L_0x00e2
            int r6 = r9.mPointCenterLocation
            int r7 = POINT_CENTER_AT_BOTH_INSIDE
            if (r6 != r7) goto L_0x0061
        L_0x005d:
            r6 = r11
            r7 = r6
            goto L_0x00d6
        L_0x0061:
            int r7 = POINT_CENTER_AT_BOTH_OUTSIDE
            if (r6 != r7) goto L_0x006b
            int r6 = r9.mPointMaxWidth
            int r7 = r9.mPointMaxHeight
            goto L_0x00d6
        L_0x006b:
            int r7 = POINT_CENTER_AT_TOP_RIGHT
            if (r6 != r7) goto L_0x0079
            int r6 = r9.mPointMaxWidth
            int r6 = r6 / 2
            int r7 = r9.mPointMaxHeight
            int r7 = r7 / 2
            goto L_0x00d6
        L_0x0079:
            int r7 = POINT_CENTER_AT_OUTSIDE_TOP_RIGHT
            if (r6 != r7) goto L_0x0084
            int r6 = r9.mPointMaxWidth
            int r7 = r9.mPointMaxHeight
            int r7 = r7 / 2
            goto L_0x00d6
        L_0x0084:
            int r7 = POINT_CENTER_AT_INSIDE_TOP_LEFT
            if (r6 != r7) goto L_0x008e
            int r6 = r9.mPointMaxHeight
            int r7 = r6 / 2
        L_0x008c:
            r6 = r11
            goto L_0x00d6
        L_0x008e:
            int r7 = POINT_CENTER_AT_OUTSIDE_RIGHT_TOP
            if (r6 != r7) goto L_0x0099
            int r6 = r9.mPointMaxWidth
            int r6 = r6 / 2
            int r7 = r9.mPointMaxHeight
            goto L_0x00d6
        L_0x0099:
            int r7 = POINT_CENTER_AT_INSIDE_RIGHT_BOTTOM
            if (r6 != r7) goto L_0x00a3
            int r6 = r9.mPointMaxWidth
            int r6 = r6 / 2
        L_0x00a1:
            r7 = r11
            goto L_0x00d6
        L_0x00a3:
            int r7 = POINT_CENTER_AT_BOTH_OUTSIDE_TOP_LEFT
            if (r6 != r7) goto L_0x00aa
            int r7 = r9.mPointMaxHeight
            goto L_0x008c
        L_0x00aa:
            int r7 = POINT_CENTER_AT_BOTH_OUTSIDE_BOTTOM_RIGHT
            if (r6 != r7) goto L_0x00b1
            int r6 = r9.mPointMaxWidth
            goto L_0x00a1
        L_0x00b1:
            r7 = 9
            if (r6 != r7) goto L_0x005d
            int r6 = r9.mContentViewType
            int r7 = CONTENT_VIEW_TYPE_STRING
            if (r6 == r7) goto L_0x00d1
            int r6 = r9.mModeType
            int r7 = BADGE_VIEW_MODE_ICON_LAUNCH
            if (r6 == r7) goto L_0x00d1
            int r7 = BADGE_VIEW_MODE_AVATAR
            if (r6 != r7) goto L_0x00c6
            goto L_0x00d1
        L_0x00c6:
            int r7 = BADGE_VIEW_MODE_ICON_SYSTEM
            if (r6 != r7) goto L_0x005d
            int r6 = r9.mPointMaxWidth
            int r6 = r6 / 2
            int r7 = r9.mPointMaxHeight
            goto L_0x00d6
        L_0x00d1:
            int r6 = r9.mPointMaxWidth
            int r6 = r6 / 2
            goto L_0x00a1
        L_0x00d6:
            int r8 = r9.mGravity
            r8 = r8 & 7
            if (r8 != r5) goto L_0x00de
            int r6 = r6 * 2
        L_0x00de:
            int r6 = r6 + r0
            int r3 = r3 + r6
            int r7 = r7 + r1
            int r4 = r4 + r7
        L_0x00e2:
            int r2 = r2 + 1
            goto L_0x0040
        L_0x00e6:
            r9.setMeasuredDimension(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.NewBadgeView.onMeasure(int, int):void");
    }

    public void setBadgeNumber(int i) {
        this.mNewMessageView.setNewMessageNum(i);
        setBadgeStyle(1);
    }

    public void setBadgeStyle(int i) {
        this.mNewMessageView.setCurrentStage(i);
        if (i == 1) {
            int i2 = this.mModeType;
            if (i2 == BADGE_VIEW_MODE_TEXTVIEW) {
                this.mPointCenterLocation = POINT_CENTER_AT_OUTSIDE_TOP_RIGHT;
            } else if (i2 == BADGE_VIEW_MODE_AVATAR || i2 == BADGE_VIEW_MODE_ICON_LAUNCH) {
                this.mPointCenterLocation = POINT_CENTER_AT_INSIDE_RIGHT_BOTTOM;
            } else if (i2 == BADGE_VIEW_MODE_ICON_SYSTEM) {
                this.mPointCenterLocation = POINT_CENTER_AT_TOP_RIGHT;
            }
            setPointViewTextSize(this.mPointViewTextSize);
        }
        requestLayout();
    }

    public void setBadgeViewBorder(int i) {
        this.mPointViewBorder = i;
        setShowPointViewBorder(true);
    }

    public void setBadgeViewVisibility(int i) {
        this.mPointView.setVisibility(i);
    }

    public void setContentViewType(int i) {
        this.mContentViewType = i;
    }

    public void setDrawable(Drawable drawable) {
        this.mContainerDrawable = drawable;
        this.mContainerDrawableId = 0;
        int i = this.mContentViewType;
        int i2 = CONTENT_VIEW_TYPE_ICON;
        if (i != i2) {
            setContentViewType(i2);
            removeView(this.mStringContent);
            addView(this.mIconContent, 0);
        }
        this.mIconContent.setImageDrawable(drawable);
    }

    public void setDrawableId(int i) {
        this.mContainerDrawable = null;
        this.mContainerDrawableId = i;
        int i2 = this.mContentViewType;
        int i3 = CONTENT_VIEW_TYPE_ICON;
        if (i2 != i3) {
            setContentViewType(i3);
            removeView(this.mStringContent);
            addView(this.mIconContent, 0);
        }
        this.mIconContent.setImageResource(i);
    }

    public void setModeType(int i) {
        this.mModeType = i;
        if (i == BADGE_VIEW_MODE_TEXTVIEW) {
            int i2 = this.mContentViewType;
            int i3 = CONTENT_VIEW_TYPE_STRING;
            if (i2 != i3) {
                setContentViewType(i3);
                removeView(this.mIconContent);
                addView(this.mStringContent, 0);
            }
            this.mPointCenterLocation = POINT_CENTER_AT_OUTSIDE_TOP_RIGHT;
        } else if (i == BADGE_VIEW_MODE_AVATAR || i == BADGE_VIEW_MODE_ICON_LAUNCH || i == BADGE_VIEW_MODE_ICON_SYSTEM) {
            int i4 = this.mContentViewType;
            int i5 = CONTENT_VIEW_TYPE_ICON;
            if (i4 != i5) {
                setContentViewType(i5);
                removeView(this.mStringContent);
                addView(this.mIconContent, 0);
            }
            this.mPointCenterLocation = POINT_CENTER_AT_BOTH_INSIDE;
            if (i == BADGE_VIEW_MODE_AVATAR) {
                setBadgeViewBorder(1);
                setShowPointViewBorder(false);
                this.mNewMessageView.setNewMessageSpace(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_space_normal));
            } else if (i == BADGE_VIEW_MODE_ICON_LAUNCH) {
                this.mNewMessageView.setNewMessageSpace(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_space_normal));
                setBadgeViewBorder(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_launch_border_width));
            } else if (i == BADGE_VIEW_MODE_ICON_SYSTEM) {
                this.mNewMessageView.setNewMessageSpace(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_space_normal));
                setBadgeViewBorder(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_border_width));
            }
        }
        requestLayout();
    }

    public void setPointCenterLocation(int i) {
        this.mPointCenterLocation = i;
    }

    public void setPointViewTextSize(float f) {
        this.mPointViewTextSize = f;
        this.mNewMessageView.setTextSize(f);
        requestLayout();
    }

    public void setShowPointViewBorder(boolean z) {
        this.mShowPointViewBorder = Boolean.valueOf(z);
        int i = this.mPointViewBorder;
        if (i > 0) {
            this.mNewMessageView.setBorderWidth(i);
        }
        this.mNewMessageView.setShowBorder(z);
        this.mNewMessageView.requestLayout();
    }

    public void setText(String str) {
        this.mContainerText = str;
        int i = this.mContentViewType;
        int i2 = CONTENT_VIEW_TYPE_STRING;
        if (i != i2) {
            setContentViewType(i2);
            removeView(this.mIconContent);
            addView(this.mStringContent, 0);
        }
        this.mStringContent.setText(str);
    }

    public NewBadgeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewBadgeView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mModeType = -1;
        this.mContentViewType = CONTENT_VIEW_TYPE_DEFAULT;
        this.mPointCenterLocation = POINT_CENTER_AT_DEFAULT;
        this.mGravity = 81;
        initAttrs(context, attributeSet, i);
        initView(context);
    }
}
