package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class GuidePopupWindow extends PopupWindow {
    public static final int GUIDE_LAYOUT_MODE_AUTO = 6;
    public static final int GUIDE_LAYOUT_MODE_CENTER = 3;
    public static final int GUIDE_LAYOUT_MODE_CENTER_HORIZONTAL = 1;
    public static final int GUIDE_LAYOUT_MODE_CENTER_VERTICAL = 2;
    public static final int GUIDE_LAYOUT_MODE_DOWN = 5;
    public static final int GUIDE_LAYOUT_MODE_UP = 4;
    /* access modifiers changed from: private */
    public View mAnchorView;
    private int mArrowOffx;
    private Context mContext;
    private HandleView mHandleView;
    private int mLayoutMode;
    private int mOffX;
    private int mOffY;
    /* access modifiers changed from: private */
    public OnCloseIconClickListener mOnCloseIconClickListener;
    private View mParentView;
    private int mPopX;
    private int mPopY;

    public class HandleView extends FrameLayout {
        private int layoutResourceId = R.layout.mc_guide_popup_window;
        private int mArrowLeft = -1;
        private int mArrowPadding;
        private View mBgLeft;
        private View mBgMiddle;
        private Rect mBgPadding = new Rect();
        private View mBgRight;
        private LinearLayout mBgVertical;
        private ImageView mCloseIcon;
        /* access modifiers changed from: private */
        public LinearLayout mContentView;
        private Drawable mLeftDrawable;
        private int mLeftMinWidth;
        private int mMarging;
        private TextView mMessageTextView;
        private int mMidMinWidth;
        private Drawable mMiddleDrawable;
        private Drawable mMiddleDrawableUp;
        private int mMinHeight;
        private int mMinWidth;
        private Resources mResources;
        private Drawable mRightDrawable;
        private int mRightMinWidth;
        private boolean mWithArrow = true;

        public HandleView(Context context, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            super(context);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.layoutResourceId, this, true);
            this.mResources = context.getResources();
            this.mMessageTextView = (TextView) inflate.findViewById(R.id.guide_message);
            this.mCloseIcon = (ImageView) inflate.findViewById(R.id.guide_close);
            this.mContentView = (LinearLayout) inflate.findViewById(R.id.guide_content);
            this.mBgLeft = inflate.findViewById(R.id.guide_bg_left);
            this.mBgMiddle = inflate.findViewById(R.id.guide_bg_middle);
            this.mBgRight = inflate.findViewById(R.id.guide_bg_right);
            this.mBgVertical = (LinearLayout) inflate.findViewById(R.id.guide_bg_vertical);
            this.mMinHeight = this.mResources.getDimensionPixelSize(R.dimen.mc_guide_popup_min_height);
            this.mLeftDrawable = drawable;
            this.mMiddleDrawable = drawable2;
            this.mMiddleDrawableUp = drawable3;
            this.mRightDrawable = drawable4;
            this.mBgLeft.setBackgroundDrawable(drawable);
            this.mBgRight.setBackgroundDrawable(this.mRightDrawable);
            this.mBgMiddle.setBackgroundDrawable(this.mMiddleDrawable);
            this.mArrowPadding = this.mResources.getDimensionPixelSize(R.dimen.mc_guide_popup_arrow_padding);
            this.mMarging = this.mResources.getDimensionPixelSize(R.dimen.mc_guide_popup_marging);
            Rect rect = new Rect();
            this.mLeftDrawable.getPadding(rect);
            Rect rect2 = this.mBgPadding;
            rect2.left = Math.max(rect.left, rect2.left);
            Rect rect3 = this.mBgPadding;
            rect3.top = Math.max(rect.top, rect3.top);
            Rect rect4 = this.mBgPadding;
            rect4.bottom = Math.max(rect.bottom, rect4.bottom);
            this.mMiddleDrawable.getPadding(rect);
            Rect rect5 = this.mBgPadding;
            rect5.top = Math.max(rect.top, rect5.top);
            Rect rect6 = this.mBgPadding;
            rect6.bottom = Math.max(rect.bottom, rect6.bottom);
            this.mRightDrawable.getPadding(rect);
            Rect rect7 = this.mBgPadding;
            rect7.right = Math.max(rect.right, rect7.right);
            Rect rect8 = this.mBgPadding;
            rect8.top = Math.max(rect.top, rect8.top);
            Rect rect9 = this.mBgPadding;
            rect9.bottom = Math.max(rect.bottom, rect9.bottom);
            this.mLeftMinWidth = this.mLeftDrawable.getIntrinsicWidth();
            this.mMidMinWidth = this.mMiddleDrawable.getIntrinsicWidth();
            int intrinsicWidth = this.mRightDrawable.getIntrinsicWidth();
            this.mRightMinWidth = intrinsicWidth;
            int i = this.mLeftMinWidth + this.mMidMinWidth + intrinsicWidth;
            this.mMinWidth = i;
            this.mContentView.setMinimumWidth(i);
            LinearLayout linearLayout = this.mContentView;
            int i2 = this.mMinHeight;
            Rect rect10 = this.mBgPadding;
            linearLayout.setMinimumHeight(i2 + rect10.top + rect10.bottom);
            LinearLayout linearLayout2 = this.mContentView;
            Rect rect11 = this.mBgPadding;
            linearLayout2.setPadding(rect11.left, rect11.top, rect11.right, rect11.bottom);
            this.mCloseIcon.setOnClickListener(new View.OnClickListener(GuidePopupWindow.this) {
                public void onClick(View view) {
                    if (GuidePopupWindow.this.mOnCloseIconClickListener != null) {
                        GuidePopupWindow.this.mOnCloseIconClickListener.onIconClick(GuidePopupWindow.this);
                    }
                    GuidePopupWindow.this.dismiss();
                }
            });
        }

        /* access modifiers changed from: private */
        public int getPopMarging() {
            return this.mMarging;
        }

        /* access modifiers changed from: private */
        public void setMessageWidth(int i) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mMessageTextView.getLayoutParams();
            layoutParams.width = i;
            this.mMessageTextView.setLayoutParams(layoutParams);
        }

        public void disableArrow(boolean z) {
            this.mWithArrow = !z;
        }

        public int getArrowPadding() {
            return this.mArrowPadding;
        }

        public int getArrowWidth() {
            return this.mMiddleDrawable.getMinimumWidth();
        }

        public int getBackgroundLeftMinWidth() {
            return this.mLeftMinWidth;
        }

        public int getBackgroundMidMinWidth() {
            return this.mMidMinWidth;
        }

        public int getBackgroundMinWidth() {
            return this.mMinWidth;
        }

        public int getBackgroundRightMinWidth() {
            return this.mRightMinWidth;
        }

        public int getCloseIconWidth() {
            return this.mCloseIcon.getMeasuredWidth();
        }

        public TextView getMessageTextView() {
            return this.mMessageTextView;
        }

        public int getPaddingLeft() {
            return this.mBgPadding.left;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.mContentView.measure(0, 0);
            int measuredHeight = this.mContentView.getMeasuredHeight();
            int measuredWidth = this.mContentView.getMeasuredWidth();
            setMeasuredDimension(measuredWidth, measuredHeight);
            this.mBgVertical.measure(measuredWidth, measuredHeight);
            if (!this.mWithArrow) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBgLeft.getLayoutParams();
                layoutParams.width = measuredWidth - this.mRightDrawable.getMinimumWidth();
                layoutParams.height = measuredHeight;
                this.mBgLeft.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBgRight.getLayoutParams();
                layoutParams2.width = this.mRightDrawable.getMinimumWidth();
                layoutParams2.height = measuredHeight;
                this.mBgRight.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mBgMiddle.getLayoutParams();
                layoutParams3.width = 0;
                layoutParams3.height = measuredHeight;
                this.mBgMiddle.setLayoutParams(layoutParams3);
            } else if (this.mArrowLeft > 0) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.mBgLeft.getLayoutParams();
                layoutParams4.width = this.mArrowLeft;
                layoutParams4.height = measuredHeight;
                this.mBgLeft.setLayoutParams(layoutParams4);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mBgRight.getLayoutParams();
                layoutParams5.width = (measuredWidth - this.mMiddleDrawable.getMinimumWidth()) - this.mArrowLeft;
                layoutParams5.height = measuredHeight;
                this.mBgRight.setLayoutParams(layoutParams5);
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.mBgMiddle.getLayoutParams();
                layoutParams6.width = this.mMiddleDrawable.getMinimumWidth();
                layoutParams6.height = measuredHeight;
                this.mBgMiddle.setLayoutParams(layoutParams6);
            } else {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.mBgLeft.getLayoutParams();
                layoutParams7.width = (measuredWidth - this.mMiddleDrawable.getMinimumWidth()) / 2;
                layoutParams7.height = measuredHeight;
                this.mBgLeft.setLayoutParams(layoutParams7);
                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.mBgRight.getLayoutParams();
                layoutParams8.width = (measuredWidth - this.mMiddleDrawable.getMinimumWidth()) / 2;
                layoutParams8.height = measuredHeight;
                this.mBgRight.setLayoutParams(layoutParams8);
                LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.mBgMiddle.getLayoutParams();
                layoutParams9.width = this.mMiddleDrawable.getMinimumWidth();
                layoutParams9.height = measuredHeight;
                this.mBgMiddle.setLayoutParams(layoutParams9);
            }
        }

        public void setArrowDown() {
            this.mBgMiddle.setBackgroundDrawable(this.mMiddleDrawable);
        }

        public void setArrowPosition(int i) {
            this.mArrowLeft = i;
        }

        public void setArrowUp() {
            this.mBgMiddle.setBackgroundDrawable(this.mMiddleDrawableUp);
        }

        public void setMessageOnClickListener(View.OnClickListener onClickListener) {
            this.mMessageTextView.setOnClickListener(onClickListener);
        }

        public void setText(String str) {
            this.mMessageTextView.setText(str);
        }

        public void setTextSize(int i) {
            this.mMessageTextView.setTextSize(1, (float) i);
        }
    }

    public interface OnCloseIconClickListener {
        void onIconClick(GuidePopupWindow guidePopupWindow);
    }

    public GuidePopupWindow(Context context) {
        this(context, (AttributeSet) null);
    }

    private void computeGuidePosition(int[] iArr, View view) {
        if (view != null) {
            this.mHandleView.measure(0, 0);
            int measuredWidth = this.mHandleView.mContentView.getMeasuredWidth();
            int measuredWidth2 = (view.getMeasuredWidth() - measuredWidth) / 2;
            int[] iArr2 = new int[2];
            getAnchorPosition(view, iArr2);
            int i = iArr[2];
            int i2 = iArr[0];
            int i3 = i - i2;
            if (measuredWidth >= i3) {
                this.mPopX = i2 - iArr2[0];
                HandleView handleView = this.mHandleView;
                handleView.setMessageWidth((i3 - (handleView.getPopMarging() * 2)) - this.mHandleView.getCloseIconWidth());
                this.mHandleView.measure(0, 0);
            } else {
                int i4 = iArr2[0];
                if (i4 + measuredWidth2 <= i2) {
                    this.mPopX = i2 - i4;
                } else if (i4 + measuredWidth2 + measuredWidth > i) {
                    this.mPopX = (i - measuredWidth) - i4;
                } else {
                    this.mPopX = measuredWidth2;
                }
            }
            int i5 = this.mLayoutMode;
            if (i5 == 4) {
                this.mPopY = (-this.mHandleView.getMeasuredHeight()) - view.getMeasuredHeight();
                this.mHandleView.setArrowDown();
            } else if (i5 == 5) {
                this.mPopY = 0;
                this.mHandleView.setArrowUp();
            } else if ((iArr2[1] - this.mHandleView.getMeasuredHeight()) + this.mHandleView.getArrowPadding() < iArr[1]) {
                this.mPopY = 0;
                this.mHandleView.setArrowUp();
            } else {
                this.mPopY = (-this.mHandleView.getMeasuredHeight()) - view.getMeasuredHeight();
                this.mHandleView.setArrowDown();
            }
            int i6 = this.mLayoutMode;
            if (i6 == 1) {
                this.mPopX = (iArr[0] + ((i3 - this.mHandleView.getMeasuredWidth()) / 2)) - iArr2[0];
            } else if (i6 == 2) {
                int i7 = iArr[1];
                this.mPopY = ((i7 + (((iArr[3] - i7) - this.mHandleView.getMeasuredHeight()) / 2)) - iArr2[1]) - view.getMeasuredHeight();
            } else if (i6 == 3) {
                this.mPopX = (iArr[0] + ((i3 - this.mHandleView.getMeasuredWidth()) / 2)) - iArr2[0];
                int i8 = iArr[1];
                this.mPopY = ((i8 + (((iArr[3] - i8) - this.mHandleView.getMeasuredHeight()) / 2)) - iArr2[1]) - view.getMeasuredHeight();
            }
            int i9 = this.mPopX + this.mOffX;
            this.mPopX = i9;
            this.mPopY += this.mOffY;
            int measuredWidth3 = (((-i9) + (view.getMeasuredWidth() / 2)) - (this.mHandleView.getArrowWidth() / 2)) + this.mArrowOffx;
            int measuredWidth4 = this.mHandleView.getMeasuredWidth() - (this.mHandleView.getBackgroundMidMinWidth() + this.mHandleView.getBackgroundRightMinWidth());
            int backgroundLeftMinWidth = this.mHandleView.getBackgroundLeftMinWidth();
            if (measuredWidth3 > measuredWidth4) {
                measuredWidth3 = measuredWidth4;
            } else if (measuredWidth3 < backgroundLeftMinWidth) {
                measuredWidth3 = backgroundLeftMinWidth;
            }
            this.mHandleView.setArrowPosition(measuredWidth3);
            if (view.getLayoutDirection() == 1) {
                this.mPopX -= view.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: private */
    public void doShow(int[] iArr) {
        computeGuidePosition(iArr, this.mAnchorView);
        showAsDropDown(this.mAnchorView, this.mPopX, this.mPopY);
    }

    private void getAnchorPosition(View view, int[] iArr) {
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
    }

    private void getParentBound(View view, int[] iArr) {
        if (view == null) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = displayMetrics.widthPixels;
            iArr[3] = displayMetrics.heightPixels;
            return;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[0];
        iArr[0] = i;
        iArr[1] = iArr2[1];
        iArr[2] = i + view.getWidth();
        iArr[3] = iArr[1] + view.getHeight();
    }

    private void tryShow(final int[] iArr, View view, int i, int i2) {
        if (view != null) {
            this.mAnchorView = view;
            this.mOffX = i;
            this.mOffY = i2;
            int[] iArr2 = new int[2];
            getAnchorPosition(view, iArr2);
            if (iArr2[0] == 0 || iArr2[1] == 0) {
                this.mAnchorView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        GuidePopupWindow.this.mAnchorView.getViewTreeObserver().removeOnPreDrawListener(this);
                        GuidePopupWindow.this.doShow(iArr);
                        return true;
                    }
                });
                this.mAnchorView.invalidate();
                return;
            }
            doShow(iArr);
        }
    }

    public void disableArrow(boolean z) {
        this.mHandleView.disableArrow(z);
    }

    public TextView getMessageTextView() {
        return this.mHandleView.getMessageTextView();
    }

    public void setArrowPosition(int i) {
        this.mArrowOffx = i;
    }

    public void setColorStyle(int i) {
    }

    public void setHorizontalOffset(int i) {
        this.mOffX = i;
    }

    public void setLayoutMode(int i) {
        this.mLayoutMode = i;
    }

    public void setMessage(String str) {
        this.mHandleView.setText(str);
    }

    public void setMessageOnClickListener(View.OnClickListener onClickListener) {
        this.mHandleView.setMessageOnClickListener(onClickListener);
    }

    public void setOnCloseIconClickListener(OnCloseIconClickListener onCloseIconClickListener) {
        this.mOnCloseIconClickListener = onCloseIconClickListener;
    }

    public void setTextSize(int i) {
        this.mHandleView.setTextSize(i);
    }

    public void setVerticalOffset(int i) {
        this.mOffY = i;
    }

    public void show(View view) {
        show((View) null, view);
    }

    @TargetApi(19)
    public void update(int i, int i2, int i3, int i4, boolean z) {
        if (this.mAnchorView.isAttachedToWindow()) {
            super.update(i, i2, i3, i4, z);
        }
    }

    public void updatePosition() {
        if (this.mAnchorView != null) {
            int[] iArr = new int[4];
            getParentBound(this.mParentView, iArr);
            computeGuidePosition(iArr, this.mAnchorView);
            int[] iArr2 = new int[2];
            getAnchorPosition(this.mAnchorView, iArr2);
            update(this.mPopX + iArr2[0], this.mPopY + iArr2[1] + this.mAnchorView.getMeasuredHeight(), -1, -1);
        }
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void show(View view, int i, int i2) {
        show((View) null, view, i, i2);
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public void show(View view, View view2) {
        show(view, view2, this.mOffX, this.mOffY);
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mLayoutMode = 6;
        this.mContext = context;
        setTouchable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        setWindowLayoutMode(-2, -2);
        setInputMethodMode(2);
        setBackgroundDrawable(new ColorDrawable(0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.GuidePopupWindow, R.attr.MeizuCommon_GuidePopupWindow, i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundLeft);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundMidArrowDown);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundMidArrowUp);
        Drawable drawable4 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundRight);
        obtainStyledAttributes.recycle();
        if (drawable == null || drawable2 == null || drawable3 == null || drawable4 == null) {
            drawable = context.getResources().getDrawable(R.drawable.mz_guide_left_color_blue);
            drawable2 = context.getResources().getDrawable(R.drawable.mz_guide_middle_down_color_blue);
            drawable3 = context.getResources().getDrawable(R.drawable.mz_guide_middle_up_color_blue);
            drawable4 = context.getResources().getDrawable(R.drawable.mz_guide_right_color_blue);
        }
        Drawable drawable5 = drawable;
        Drawable drawable6 = drawable2;
        Drawable drawable7 = drawable3;
        Drawable drawable8 = drawable4;
        int color = context.getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorPrimary, context));
        drawable5.setTint(color);
        drawable6.setTint(color);
        drawable7.setTint(color);
        drawable8.setTint(color);
        HandleView handleView = new HandleView(this.mContext, drawable5, drawable6, drawable7, drawable8);
        this.mHandleView = handleView;
        setContentView(handleView);
    }

    public void show(View view, View view2, int i, int i2) {
        int[] iArr = new int[4];
        this.mParentView = view;
        getParentBound(view, iArr);
        tryShow(iArr, view2, i, i2);
    }

    public void show(Rect rect, View view) {
        show(rect, view, this.mOffX, this.mOffY);
    }

    public void show(Rect rect, View view, int i, int i2) {
        tryShow(new int[]{rect.left, rect.top, rect.right, rect.bottom}, view, i, i2);
    }
}
