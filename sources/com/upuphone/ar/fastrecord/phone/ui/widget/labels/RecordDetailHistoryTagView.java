package com.upuphone.ar.fastrecord.phone.ui.widget.labels;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.honey.account.b4.a;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.List;

public class RecordDetailHistoryTagView extends LinearLayout implements View.OnClickListener {
    private static final int KEY_DATA = R.id.tag_key_data;
    private static final String KEY_LABEL_GRAVITY_STATE = "key_label_gravity_state";
    private static final String KEY_LABEL_HEIGHT_STATE = "key_label_height_state";
    private static final String KEY_LABEL_WIDTH_STATE = "key_label_width_state";
    private static final String KEY_LINE_MARGIN_STATE = "key_line_margin_state";
    private static final String KEY_PADDING_STATE = "key_padding_state";
    private static final int KEY_POSITION = R.id.tag_key_position;
    private static final String KEY_SUPER_STATE = "key_super_state";
    private static final String KEY_TEXT_COLOR_STATE = "key_text_color_state";
    private static final String KEY_TEXT_SIZE_STATE = "key_text_size_state";
    private static final String KEY_WORD_MARGIN_STATE = "key_word_margin_state";
    private static final String TAG = "RecordDetailHistoryTagView";
    private final LayoutInflater mInflater;
    private Drawable mLabelBg;
    private OnLabelClickListener mLabelClickListener;
    private int mLabelGravity = 17;
    private int mLabelHeight = -2;
    private int mLabelWidth = -2;
    private final ArrayList<Object> mLabels = new ArrayList<>();
    private int mLineMargin;
    private OnLabelDelIvClickListener mOnLabelDelIvClickListener;
    private ColorStateList mTextColor;
    private int mTextPaddingBottom;
    private int mTextPaddingLeft;
    private int mTextPaddingRight;
    private int mTextPaddingTop;
    private float mTextSize;
    private int mWordMargin;

    public interface LabelTextProvider<T> {
        CharSequence getLabelText(TextView textView, int i, T t);
    }

    public interface OnLabelClickListener {
        void onLabelClick(View view, Object obj, int i);
    }

    public interface OnLabelDelIvClickListener {
        void onDelIv(Object obj, int i);
    }

    public RecordDetailHistoryTagView(Context context) {
        super(context);
        this.mInflater = LayoutInflater.from(context);
    }

    private <T> void addLabel(T t, int i, LabelTextProvider<T> labelTextProvider) {
        View inflate = this.mInflater.inflate(R.layout.fast_record_layout_history_tag_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_del_tag);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tag);
        textView.setBackground(this.mLabelBg.getConstantState().newDrawable());
        int i2 = KEY_DATA;
        textView.setTag(i2, t);
        int i3 = KEY_POSITION;
        textView.setTag(i3, Integer.valueOf(i));
        inflate.setTag(i2, t);
        inflate.setTag(i3, Integer.valueOf(i));
        inflate.setOnClickListener(this);
        textView.setOnClickListener(this);
        if (isRTL()) {
            addView(inflate, 0);
        } else {
            addView(inflate, this.mLabelWidth, this.mLabelHeight);
        }
        textView.setText(labelTextProvider.getLabelText(textView, i, t));
        imageView.setTag(i2, t);
        imageView.setTag(i3, Integer.valueOf(i));
    }

    private int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void ensureDelIvClickable() {
        int childCount = getChildCount();
        LogExt.logD("ensureDelIvClickable count = " + childCount, TAG);
        for (int i = 0; i < childCount; i++) {
            ((ImageView) getChildAt(i).findViewById(R.id.iv_del_tag)).setOnClickListener(new a(this));
        }
    }

    private void ensureLabelClickable() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setClickable(this.mLabelClickListener != null);
        }
    }

    private void getAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelsView);
            this.mLabelGravity = obtainStyledAttributes.getInt(R.styleable.LabelsView_labelGravity, this.mLabelGravity);
            this.mLabelWidth = obtainStyledAttributes.getLayoutDimension(R.styleable.LabelsView_labelTextWidth, this.mLabelWidth);
            this.mLabelHeight = obtainStyledAttributes.getLayoutDimension(R.styleable.LabelsView_labelTextHeight, this.mLabelHeight);
            if (obtainStyledAttributes.hasValue(R.styleable.LabelsView_labelTextColor)) {
                this.mTextColor = obtainStyledAttributes.getColorStateList(R.styleable.LabelsView_labelTextColor);
            } else {
                this.mTextColor = ColorStateList.valueOf(-16777216);
            }
            this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.LabelsView_labelTextSize, (float) sp2px(15.0f));
            if (obtainStyledAttributes.hasValue(R.styleable.LabelsView_labelTextPadding)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPadding, 0);
                this.mTextPaddingBottom = dimensionPixelOffset;
                this.mTextPaddingRight = dimensionPixelOffset;
                this.mTextPaddingTop = dimensionPixelOffset;
                this.mTextPaddingLeft = dimensionPixelOffset;
            } else {
                this.mTextPaddingLeft = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingLeft, dp2px(10.0f));
                this.mTextPaddingTop = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingTop, dp2px(5.0f));
                this.mTextPaddingRight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingRight, dp2px(10.0f));
                this.mTextPaddingBottom = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingBottom, dp2px(5.0f));
            }
            this.mLineMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_lineMargin, dp2px(5.0f));
            this.mWordMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_wordMargin, dp2px(5.0f));
            if (obtainStyledAttributes.hasValue(R.styleable.LabelsView_labelBackground)) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LabelsView_labelBackground, 0);
                if (resourceId != 0) {
                    this.mLabelBg = ContextCompat.getDrawable(getContext(), resourceId);
                } else {
                    this.mLabelBg = new ColorDrawable(obtainStyledAttributes.getColor(R.styleable.LabelsView_labelBackground, 0));
                }
            } else {
                this.mLabelBg = ContextCompat.getDrawable(getContext(), R.drawable.bg_default_label);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureDelIvClickable$0(View view) {
        if (this.mOnLabelDelIvClickListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("mOnLabelDelIvClickListener ,label data = ");
            int i = KEY_DATA;
            sb.append(view.getTag(i));
            sb.append(", pos =");
            int i2 = KEY_POSITION;
            sb.append(view.getTag(i2));
            LogExt.logD(sb.toString(), TAG);
            this.mOnLabelDelIvClickListener.onDelIv(view.getTag(i), ((Integer) view.getTag(i2)).intValue());
        }
    }

    private int layoutChildViewStatue(boolean z, int i, int i2) {
        if ((!z || i2 >= 0) && i2 < getChildCount()) {
            return i2;
        }
        return -1;
    }

    private int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void onClick(View view) {
        LogExt.logD("onclick", TAG);
        OnLabelClickListener onLabelClickListener = this.mLabelClickListener;
        if (onLabelClickListener != null) {
            onLabelClickListener.onLabelClick(view, view.getTag(KEY_DATA), ((Integer) view.getTag(KEY_POSITION)).intValue());
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z2 = getLayoutDirection() == 1;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int width2 = z2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount() > 0 ? z2 ? getChildCount() - 1 : 0 : -1;
        int i8 = width2;
        int i9 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i10 = layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin;
            if (!z2 ? i10 + i8 > getPaddingLeft() + width : i8 - i10 < getPaddingLeft()) {
                paddingTop += i9;
                i8 = width2;
                i9 = 0;
            }
            if (z2) {
                i7 = i8 - layoutParams.rightMargin;
                i6 = i7 - measuredWidth;
                i5 = i6 - layoutParams.leftMargin;
            } else {
                int i11 = i8 + layoutParams.leftMargin;
                int i12 = measuredWidth + i11;
                i5 = layoutParams.rightMargin + i12;
                int i13 = i12;
                i6 = i11;
                i7 = i13;
            }
            int i14 = layoutParams.topMargin;
            int i15 = paddingTop + i14;
            i9 = Math.max(i9, measuredHeight + i14 + layoutParams.bottomMargin);
            childAt.layout(i6, i15, i7, i15 + measuredHeight);
            childCount = layoutChildViewStatue(z2, getChildCount(), z2 ? childCount - 1 : childCount + 1);
            i8 = i5;
        }
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            measureChildWithMargins(childAt, i, 0, i2, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            if (i5 + measuredWidth > paddingLeft) {
                i3 += i4;
                i4 = 0;
                i5 = 0;
            }
            i5 += measuredWidth;
            i4 = Math.max(i4, measuredHeight);
        }
        setMeasuredDimension(size, i3 + i4 + getPaddingTop() + getPaddingBottom());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(KEY_SUPER_STATE));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable(KEY_TEXT_COLOR_STATE);
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat(KEY_TEXT_SIZE_STATE, this.mTextSize));
            this.mLabelWidth = bundle.getInt(KEY_LABEL_WIDTH_STATE, this.mLabelWidth);
            this.mLabelHeight = bundle.getInt(KEY_LABEL_HEIGHT_STATE, this.mLabelHeight);
            setLabelGravity(bundle.getInt(KEY_LABEL_GRAVITY_STATE, this.mLabelGravity));
            int[] intArray = bundle.getIntArray(KEY_PADDING_STATE);
            if (intArray != null && intArray.length == 4) {
                setLabelTextPadding(intArray[0], intArray[1], intArray[2], intArray[3]);
            }
            setWordMargin(bundle.getInt(KEY_WORD_MARGIN_STATE, this.mWordMargin));
            setLineMargin(bundle.getInt(KEY_LINE_MARGIN_STATE, this.mLineMargin));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState());
        ColorStateList colorStateList = this.mTextColor;
        if (colorStateList != null) {
            bundle.putParcelable(KEY_TEXT_COLOR_STATE, colorStateList);
        }
        bundle.putFloat(KEY_TEXT_SIZE_STATE, this.mTextSize);
        bundle.putInt(KEY_LABEL_WIDTH_STATE, this.mLabelWidth);
        bundle.putInt(KEY_LABEL_HEIGHT_STATE, this.mLabelHeight);
        bundle.putInt(KEY_LABEL_GRAVITY_STATE, this.mLabelGravity);
        bundle.putIntArray(KEY_PADDING_STATE, new int[]{this.mTextPaddingLeft, this.mTextPaddingTop, this.mTextPaddingRight, this.mTextPaddingBottom});
        bundle.putInt(KEY_WORD_MARGIN_STATE, this.mWordMargin);
        bundle.putInt(KEY_LINE_MARGIN_STATE, this.mLineMargin);
        return bundle;
    }

    public void setLabelGravity(int i) {
        if (this.mLabelGravity != i) {
            this.mLabelGravity = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setGravity(i);
            }
        }
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        this.mTextColor = colorStateList;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setTextColor(this.mTextColor);
        }
    }

    public void setLabelTextPadding(int i, int i2, int i3, int i4) {
        if (this.mTextPaddingLeft != i || this.mTextPaddingTop != i2 || this.mTextPaddingRight != i3 || this.mTextPaddingBottom != i4) {
            this.mTextPaddingLeft = i;
            this.mTextPaddingTop = i2;
            this.mTextPaddingRight = i3;
            this.mTextPaddingBottom = i4;
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ((TextView) getChildAt(i5)).setPadding(i, i2, i3, i4);
            }
        }
    }

    public void setLabelTextSize(float f) {
        if (this.mTextSize != f) {
            this.mTextSize = f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setTextSize(0, f);
            }
        }
    }

    public <T> void setLabels(List<T> list, LabelTextProvider<T> labelTextProvider) {
        removeAllViews();
        this.mLabels.clear();
        if (list != null) {
            ULog.f(TAG, "setLabels labels size = " + list.size());
            ArrayList arrayList = new ArrayList(list);
            this.mLabels.addAll(arrayList);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                addLabel(arrayList.get(i), i, labelTextProvider);
            }
            ensureLabelClickable();
            ensureDelIvClickable();
        }
    }

    public void setLineMargin(int i) {
        if (this.mLineMargin != i) {
            this.mLineMargin = i;
            requestLayout();
        }
    }

    public void setOnDelIvClickListener(OnLabelDelIvClickListener onLabelDelIvClickListener) {
        this.mOnLabelDelIvClickListener = onLabelDelIvClickListener;
        ensureDelIvClickable();
    }

    public void setOnLabelClickListener(OnLabelClickListener onLabelClickListener) {
        this.mLabelClickListener = onLabelClickListener;
        ensureLabelClickable();
    }

    public void setWordMargin(int i) {
        if (this.mWordMargin != i) {
            this.mWordMargin = i;
            requestLayout();
        }
    }

    public RecordDetailHistoryTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInflater = LayoutInflater.from(context);
        getAttrs(context, attributeSet);
    }

    public RecordDetailHistoryTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInflater = LayoutInflater.from(context);
        getAttrs(context, attributeSet);
    }
}
