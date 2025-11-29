package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.drawable.RippleDrawableComp;
import java.util.ArrayList;
import java.util.Iterator;

public class ControlTitleBar extends LinearLayoutCompat {
    public static final int BUTTON_MAX_WIDTH = 104;
    public static final int BUTTON_NEGATIVE = 0;
    public static final int BUTTON_POSITIVE = 1;
    public static final int ITEM_NEGATIVE = 0;
    public static final int ITEM_POSITIVE = 1;
    private int mItemMaxWidth;
    private int mNegativeItemLayout;
    private View mNegativeItemView;
    private ArrayList<OnTitleChangedListener> mOnTitleChangedListeners;
    private int mPositiveItemLayout;
    private View mPositiveItemView;
    private CharSequence mSubTitle;
    private int mSubtitleStyleRes;
    private final TextView mSubtitleView;
    private CharSequence mTitle;
    private int mTitleGravity;
    private View mTitleLayout;
    private int mTitleMinWidth;
    private int mTitleStyleRes;
    private final TextView mTitleView;

    public class ItemRippleDrawable extends RippleDrawableComp {
        public ItemRippleDrawable(View view) {
            super(view, R.attr.mzActionButtonRippleSplitStyle);
        }
    }

    public interface OnTitleChangedListener {
        void onSubTitleChanged(CharSequence charSequence);

        void onTitleChanged(CharSequence charSequence);
    }

    public ControlTitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean checkTitleBorder(int i, int i2, int i3, int i4, boolean z) {
        return z ? i2 + i >= i3 || i <= i4 : i <= i3 || i + i2 >= i4;
    }

    private int computeAvailableWidth(int i, int i2) {
        int i3;
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        if ((this.mTitleGravity & 7) != 1) {
            return i;
        }
        View view = this.mNegativeItemView;
        int i4 = 0;
        if (view == null || view.getParent() != this) {
            i3 = 0;
        } else {
            int measuredWidth = this.mNegativeItemView.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mNegativeItemView.getLayoutParams();
            i3 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
        View view2 = this.mPositiveItemView;
        if (view2 != null && view2.getParent() == this) {
            int measuredWidth2 = this.mPositiveItemView.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mPositiveItemView.getLayoutParams();
            i4 = measuredWidth2 + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        }
        return i3 >= i4 ? paddingLeft - (i3 * 2) : paddingLeft - (i4 * 2);
    }

    private void initTitle() {
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubTitle);
        boolean z = !TextUtils.isEmpty(this.mTitle);
        boolean z2 = !TextUtils.isEmpty(this.mSubTitle);
        int i = 8;
        this.mSubtitleView.setVisibility(z2 ? 0 : 8);
        View view = this.mTitleLayout;
        if (z || z2) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static int next(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i = ((paddingLeft - paddingRight) + width) / 2;
            int i2 = ((width - paddingLeft) - paddingRight) / 2;
            DrawableCompat.l(background, i - i2, 0, i + i2, view.getHeight());
        }
    }

    public void addOnTitleChangedListener(OnTitleChangedListener onTitleChangedListener) {
        if (this.mOnTitleChangedListeners == null) {
            this.mOnTitleChangedListeners = new ArrayList<>();
        }
        this.mOnTitleChangedListeners.add(onTitleChangedListener);
    }

    public View getNegativeItemView() {
        return this.mNegativeItemView;
    }

    public View getPositiveItemView() {
        return this.mPositiveItemView;
    }

    public CharSequence getSubTitle() {
        return this.mSubTitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public int measureChildView(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return view.getMeasuredWidth() + i3;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingRight;
        int paddingLeft;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight2 = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.mNegativeItemView;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mNegativeItemView.getLayoutParams();
            int i5 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = next(paddingRight2, i5, isLayoutRtl);
            paddingRight = next(next + positionChild(this.mNegativeItemView, next, paddingTop, paddingTop2, isLayoutRtl), i6, isLayoutRtl);
            setBackgroundHotspotBounds(this.mNegativeItemView);
        }
        int i7 = paddingRight;
        int paddingLeft2 = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        View view2 = this.mPositiveItemView;
        if (view2 == null || view2.getVisibility() == 8) {
            paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mPositiveItemView.getLayoutParams();
            int i8 = isLayoutRtl ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int next2 = next(paddingLeft2, isLayoutRtl ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin, !isLayoutRtl);
            paddingLeft = next(next2 + positionChild(this.mPositiveItemView, next2, paddingTop, paddingTop2, !isLayoutRtl), i8, !isLayoutRtl);
            setBackgroundHotspotBounds(this.mPositiveItemView);
        }
        int i9 = paddingLeft;
        View view3 = this.mTitleLayout;
        if (view3 != null && view3.getVisibility() != 8) {
            int measuredWidth = this.mTitleLayout.getMeasuredWidth();
            int i10 = (this.mTitleGravity & 7) == 1 ? ((i3 - i) - measuredWidth) / 2 : 0;
            if (checkTitleBorder(i10, measuredWidth, i7, i9, isLayoutRtl)) {
                positionChild(this.mTitleLayout, i7, paddingTop, paddingTop2, isLayoutRtl);
            } else {
                positionChild(this.mTitleLayout, i10, paddingTop, paddingTop2, false);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        View view;
        int measureChildView;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - paddingTop, Integer.MIN_VALUE);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPositiveItemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mNegativeItemView.getLayoutParams();
        View view2 = this.mNegativeItemView;
        int measureChildView2 = (view2 == null || view2.getVisibility() == 8) ? 0 : measureChildView(this.mNegativeItemView, paddingLeft, makeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        View view3 = this.mPositiveItemView;
        int measureChildView3 = (view3 == null || view3.getVisibility() == 8) ? 0 : measureChildView(this.mPositiveItemView, paddingLeft, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        View view4 = this.mNegativeItemView;
        if (!(view4 == null || (view = this.mPositiveItemView) == null || measureChildView2 + measureChildView3 <= paddingLeft)) {
            if (measureChildView2 < measureChildView3) {
                int i5 = paddingLeft / 2;
                if (measureChildView2 <= i5) {
                    measureChildView3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + measureChildView(view, ((paddingLeft - measureChildView2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0);
                } else {
                    int measureChildView4 = measureChildView(view, (i5 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    measureChildView2 = measureChildView(this.mNegativeItemView, (i5 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    measureChildView3 = measureChildView4;
                }
            } else {
                int i6 = paddingLeft / 2;
                if (measureChildView3 <= i6) {
                    measureChildView = measureChildView(view4, ((paddingLeft - measureChildView3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0);
                    i3 = marginLayoutParams2.leftMargin;
                    i4 = marginLayoutParams2.rightMargin;
                } else {
                    measureChildView3 = measureChildView(view, (i6 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    measureChildView = measureChildView(this.mNegativeItemView, (i6 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0);
                    i3 = marginLayoutParams2.leftMargin;
                    i4 = marginLayoutParams2.rightMargin;
                }
                measureChildView2 = i3 + i4 + measureChildView;
            }
        }
        if (this.mNegativeItemView != null) {
            paddingLeft -= measureChildView2;
        }
        if (this.mPositiveItemView != null) {
            paddingLeft -= measureChildView3;
        }
        if (paddingLeft <= this.mTitleMinWidth) {
            paddingLeft = 0;
        }
        View view5 = this.mTitleLayout;
        if (view5 != null) {
            measureChildView(view5, paddingLeft, makeMeasureSpec, 0);
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    public int positionChild(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void removeOnTitleChangedListener(OnTitleChangedListener onTitleChangedListener) {
        ArrayList<OnTitleChangedListener> arrayList = this.mOnTitleChangedListeners;
        if (arrayList != null) {
            arrayList.remove(onTitleChangedListener);
        }
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, View.OnClickListener onClickListener) {
        View view;
        if (i == 1) {
            try {
                view = this.mPositiveItemView;
            } catch (ClassCastException unused) {
                throw new IllegalStateException("the item view of ControlTitleBar is not a TextView, please check the style of mzControlTitleBarStyle ");
            }
        } else {
            view = this.mNegativeItemView;
        }
        TextView textView = (TextView) view;
        textView.setText(charSequence);
        if (drawable != null) {
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(isEmpty ? drawable : null, isEmpty ? null : drawable, (Drawable) null, (Drawable) null);
        }
        textView.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(charSequence) && drawable == null) {
            textView.setVisibility(8);
        }
    }

    public void setItemMaxWidth(int i) {
        this.mItemMaxWidth = i;
    }

    public void setOnItemClickListener(int i, View.OnClickListener onClickListener) {
        if (i == 0) {
            View view = this.mNegativeItemView;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        } else if (i == 1) {
            View view2 = this.mPositiveItemView;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
        } else {
            throw new IllegalArgumentException("Item does not exist");
        }
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.mNegativeItemView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.mPositiveItemView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (!TextUtils.equals(this.mSubTitle, charSequence)) {
            this.mSubTitle = charSequence;
            initTitle();
            ArrayList<OnTitleChangedListener> arrayList = this.mOnTitleChangedListeners;
            if (arrayList != null) {
                Iterator<OnTitleChangedListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onSubTitleChanged(this.mSubTitle);
                }
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.equals(this.mTitle, charSequence)) {
            this.mTitle = charSequence;
            initTitle();
            ArrayList<OnTitleChangedListener> arrayList = this.mOnTitleChangedListeners;
            if (arrayList != null) {
                Iterator<OnTitleChangedListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onTitleChanged(this.mTitle);
                }
            }
        }
    }

    public void setTitleColor(int i) {
        TextView textView = this.mTitleView;
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            this.mTitleView.setTextColor(i);
        }
    }

    public ControlTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzControlTitleBarStyle);
    }

    public ControlTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleGravity = 17;
        TintTypedArray v = TintTypedArray.v(context, attributeSet, R.styleable.MzControlTitleBar, i, 0);
        this.mTitleStyleRes = v.n(R.styleable.MzControlTitleBar_titleTextStyle, 0);
        this.mSubtitleStyleRes = v.n(R.styleable.MzControlTitleBar_subtitleTextStyle, 0);
        this.mNegativeItemLayout = v.n(R.styleable.MzControlTitleBar_mzNegativeButtonLayout, R.layout.mz_control_title_bar_negative_item);
        this.mPositiveItemLayout = v.n(R.styleable.MzControlTitleBar_mzPositiveButtonLayout, R.layout.mz_control_title_bar_positive_item);
        v.w();
        LayoutInflater from = LayoutInflater.from(context);
        this.mTitleMinWidth = getResources().getDimensionPixelSize(R.dimen.mz_action_bar_control_title_bar_min_title_width);
        View inflate = from.inflate(this.mNegativeItemLayout, this, false);
        this.mNegativeItemView = inflate;
        addView(inflate);
        View inflate2 = from.inflate(this.mPositiveItemLayout, this, false);
        this.mPositiveItemView = inflate2;
        addView(inflate2);
        View inflate3 = from.inflate(R.layout.mz_action_bar_title_item, this, false);
        this.mTitleLayout = inflate3;
        addView(inflate3);
        TextView textView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_title);
        this.mTitleView = textView;
        TextView textView2 = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
        this.mSubtitleView = textView2;
        if (this.mTitleStyleRes != 0) {
            textView.setTextAppearance(getContext(), this.mTitleStyleRes);
        }
        if (this.mSubtitleStyleRes != 0) {
            textView2.setTextAppearance(getContext(), this.mSubtitleStyleRes);
        }
        this.mItemMaxWidth = (int) (getResources().getDisplayMetrics().density * 104.0f);
    }
}
