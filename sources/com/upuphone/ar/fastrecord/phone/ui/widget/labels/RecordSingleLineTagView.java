package com.upuphone.ar.fastrecord.phone.ui.widget.labels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.List;

public class RecordSingleLineTagView extends ViewGroup {
    private static final boolean DEFAULT_CAN_TAG_CLICK = true;
    private static final String DEFAULT_END_TEXT_STRING = " … ";
    private static final int DEFAULT_RIGHT_IMAGE = R.mipmap.ic_fast_record_arrow_right;
    private static final boolean DEFAULT_SHOW_END_TEXT = true;
    private static final boolean DEFAULT_SHOW_RIGHT_IMAGE = true;
    private static final int DEFAULT_TAG_RES_ID = R.layout.fast_record_item_tag;
    private static final int DEFAULT_TEXT_BACKGROUND = R.drawable.bg_fast_record_item_tag;
    private static final int DEFAULT_TEXT_BORDER_HORIZONTAL = 8;
    private static final int DEFAULT_TEXT_BORDER_VERTICAL = 5;
    private static final int DEFAULT_TEXT_COLOR = FastRecordManager.getInstance().appContext().getColor(R.color.fast_record_item_tag_color);
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int DEFAULT_VIEW_BORDER = 6;
    private static final String TAG = "RecordSingleLineTagView";
    private static final int TYPE_TEXT_NORMAL = 1;
    private TextView endText;
    private int endTextHeight;
    private final String endTextString;
    private int endTextWidth;
    private int imageHeight;
    private ImageView imageView;
    private int imageWidth;
    private final int mBackground;
    private final boolean mCanTagClick;
    private final LayoutInflater mInflater;
    private final int mRightImageResId;
    private final boolean mShowEndText;
    private final boolean mShowRightImage;
    private final int mTagBorderHor;
    private final int mTagBorderVer;
    private final int mTagColor;
    private final int mTagResId;
    private final float mTagSize;
    private final int mViewBorder;
    private int sizeWidth;

    public RecordSingleLineTagView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getTextTotalWidth() {
        if (getChildCount() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                i += childAt.getMeasuredWidth() + this.mViewBorder;
            }
        }
        return i + (this.mTagBorderHor * 2);
    }

    private void initSingleLineView(int i, int i2) {
        if (this.mShowRightImage) {
            ImageView imageView2 = new ImageView(getContext());
            this.imageView = imageView2;
            imageView2.setImageResource(this.mRightImageResId);
            this.imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            measureChild(this.imageView, i, i2);
            this.imageWidth = this.imageView.getMeasuredWidth();
            this.imageHeight = this.imageView.getMeasuredHeight();
            addView(this.imageView);
        }
        if (this.mShowEndText) {
            TextView textView = (TextView) this.mInflater.inflate(this.mTagResId, (ViewGroup) null);
            this.endText = textView;
            if (this.mTagResId == DEFAULT_TAG_RES_ID) {
                textView.setBackgroundResource(this.mBackground);
                this.endText.setTextSize(2, this.mTagSize);
                this.endText.setTextColor(this.mTagColor);
            }
            this.endText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TextView textView2 = this.endText;
            String str = this.endTextString;
            textView2.setText((str == null || str.isEmpty()) ? DEFAULT_END_TEXT_STRING : this.endTextString);
            measureChild(this.endText, i, i2);
            this.endTextHeight = this.endText.getMeasuredHeight();
            this.endTextWidth = this.endText.getMeasuredWidth();
            addView(this.endText);
        }
    }

    private boolean isRtl() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    private int layoutChildUiAndGetSingleTotalHeight() {
        int i = this.mViewBorder;
        int i2 = this.mTagBorderVer;
        int i3 = 0;
        if (getTextTotalWidth() < this.sizeWidth - this.imageWidth) {
            this.endText = null;
            this.endTextWidth = 0;
        }
        while (true) {
            if (i3 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i3 == 0) {
                i += measuredWidth;
                i2 = this.mViewBorder + measuredHeight;
            } else {
                i += this.mTagBorderHor + measuredWidth;
            }
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                int i4 = this.mViewBorder;
                if (this.mTagBorderHor + i + i4 + i4 + this.endTextWidth + this.imageWidth >= this.sizeWidth) {
                    i -= measuredWidth + i4;
                    break;
                } else if (isRtl()) {
                    int i5 = this.sizeWidth;
                    int i6 = this.mTagBorderVer;
                    childAt.layout((i5 - i) + i6, i2 - measuredHeight, (i5 - i) + measuredWidth + i6, i2);
                } else {
                    int i7 = this.mTagBorderVer;
                    childAt.layout((i - measuredWidth) + i7, i2 - measuredHeight, i7 + i, i2);
                }
            }
            i3++;
        }
        TextView textView = this.endText;
        if (textView != null) {
            int i8 = this.mViewBorder;
            int i9 = this.mTagBorderVer;
            textView.layout(i + i8 + i9, i2 - this.endTextHeight, i + i8 + i9 + this.endTextWidth, i2);
        }
        int i10 = this.mViewBorder;
        int i11 = i2 + i10;
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            int i12 = this.sizeWidth;
            int i13 = this.imageHeight;
            imageView2.layout((i12 - this.imageWidth) - i10, (i11 - i13) / 2, i12 - i10, ((i11 - i13) / 2) + i13);
        }
        return i11;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.mCanTagClick || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        this.sizeWidth = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        measureChildren(i, i2);
        initSingleLineView(i, i2);
        int i3 = this.sizeWidth;
        if (mode != 1073741824) {
            size = layoutChildUiAndGetSingleTotalHeight();
        }
        setMeasuredDimension(i3, size);
        LogExt.logD("sizeWidth = $sizeWidth", TAG);
    }

    public void setTags(List<String> list) {
        removeAllViews();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                TextView textView = (TextView) this.mInflater.inflate(this.mTagResId, (ViewGroup) null);
                textView.setClickable(false);
                if (this.mTagResId == DEFAULT_TAG_RES_ID) {
                    textView.setBackgroundResource(this.mBackground);
                    textView.setTextSize(2, this.mTagSize);
                    textView.setTextColor(this.mTagColor);
                }
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
                textView.setGravity(0);
                textView.setLayoutParams(layoutParams);
                textView.setText(list.get(i));
                textView.setTag(1);
                addView(textView);
            }
        }
        postInvalidate();
    }

    public RecordSingleLineTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordSingleLineTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imageView = null;
        this.endTextWidth = 0;
        this.endTextHeight = 0;
        this.endText = null;
        this.mInflater = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TagCloudView, i, i);
        this.mTagSize = (float) obtainStyledAttributes.getInteger(R.styleable.TagCloudView_tcvTextSize, 14);
        this.mTagColor = obtainStyledAttributes.getColor(R.styleable.TagCloudView_tcvTextColor, DEFAULT_TEXT_COLOR);
        this.mBackground = obtainStyledAttributes.getResourceId(R.styleable.TagCloudView_tcvBackground, DEFAULT_TEXT_BACKGROUND);
        this.mViewBorder = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagCloudView_tcvBorder, 6);
        this.mTagBorderHor = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagCloudView_tcvItemBorderHorizontal, 8);
        this.mTagBorderVer = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagCloudView_tcvItemBorderVertical, 5);
        this.mCanTagClick = obtainStyledAttributes.getBoolean(R.styleable.TagCloudView_tcvCanTagClick, true);
        this.mRightImageResId = obtainStyledAttributes.getResourceId(R.styleable.TagCloudView_tcvRightResId, DEFAULT_RIGHT_IMAGE);
        this.mShowRightImage = obtainStyledAttributes.getBoolean(R.styleable.TagCloudView_tcvShowRightImg, true);
        this.mShowEndText = obtainStyledAttributes.getBoolean(R.styleable.TagCloudView_tcvShowEndText, true);
        this.endTextString = obtainStyledAttributes.getString(R.styleable.TagCloudView_tcvEndText);
        this.mTagResId = obtainStyledAttributes.getResourceId(R.styleable.TagCloudView_tcvTagResId, DEFAULT_TAG_RES_ID);
        obtainStyledAttributes.recycle();
    }
}
