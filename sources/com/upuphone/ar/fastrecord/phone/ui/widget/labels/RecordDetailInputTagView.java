package com.upuphone.ar.fastrecord.phone.ui.widget.labels;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.honey.account.b4.b;
import com.honey.account.b4.c;
import com.honey.account.b4.d;
import com.honey.account.b4.e;
import com.honey.account.b4.f;
import com.honey.account.b4.g;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordEditTitleInputFilter;
import com.upuphone.star.common.phone.UToast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordDetailInputTagView extends LinearLayout {
    private static final int DELAY_SHOW_TIME = 500;
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
    private static final String KEY_TEXT_STYLE_STATE = "key_text_style_state";
    private static final String KEY_WORD_MARGIN_STATE = "key_word_margin_state";
    private static final String TAG = "RecordDetailInputTagView";
    private static final int TAG_TYPE_CONTENT = 200;
    private static final int TAG_TYPE_PERSON = 100;
    /* access modifiers changed from: private */
    public int curTagType = 200;
    private Boolean isShowSoftInput = Boolean.FALSE;
    private boolean isTextBold = false;
    private final Context mContext;
    private FastRecordDrawableEditText mEditText;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final LayoutInflater mInflater;
    private Drawable mLabelBg;
    private int mLabelGravity = 17;
    private int mLabelHeight = -2;
    private int mLabelWidth = -2;
    private final ArrayList<Object> mLabels = new ArrayList<>();
    private int mLineMargin;
    /* access modifiers changed from: private */
    public OnEditTextChange mOnEditTextChange;
    private OnLabelAddFinishListener mOnLabelAddFinishListener;
    private OnLabelDelIvClickListener mOnLabelDelIvClickListener;
    private ColorStateList mTextColor;
    private int mTextPaddingBottom;
    private int mTextPaddingLeft;
    private int mTextPaddingRight;
    private int mTextPaddingTop;
    private float mTextSize;
    private int mWordMargin;
    private int sizeWidth;

    public interface LabelTextProvider<T> {
        CharSequence getLabelText(TextView textView, int i, T t);
    }

    public interface OnEditTextChange {
        void onTextChange(String str, Object obj);
    }

    public interface OnLabelAddFinishListener {
        void onFinish(String str);
    }

    public interface OnLabelDelIvClickListener {
        void onDelIv(Object obj, int i);
    }

    public RecordDetailInputTagView(Context context) {
        super(context);
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    private void addEditTextView(Object obj, int i) {
        View inflate = this.mInflater.inflate(R.layout.fast_record_layout_input_tag_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_del_tag);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tag);
        FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) inflate.findViewById(R.id.edt_tag_content);
        fastRecordDrawableEditText.setTag(KEY_DATA, obj);
        fastRecordDrawableEditText.setTag(KEY_POSITION, Integer.valueOf(i));
        fastRecordDrawableEditText.setFilters(new InputFilter[]{new FastRecordEditTitleInputFilter(20)});
        setTagEditText(fastRecordDrawableEditText, obj);
        if (obj instanceof RecordContentTagEntity) {
            setLabelShowStatus(imageView, textView, fastRecordDrawableEditText, ((RecordContentTagEntity) obj).isNewEditBean());
        } else if (obj instanceof RecordPersonEntity) {
            setLabelShowStatus(imageView, textView, fastRecordDrawableEditText, ((RecordPersonEntity) obj).isNewEditBean());
        }
        setTextChangedListener(fastRecordDrawableEditText, obj);
        setEditText(fastRecordDrawableEditText);
        fastRecordDrawableEditText.setOnEditorActionListener(new f(this));
        if (isRTL()) {
            addView(inflate, 0);
        } else {
            addView(inflate, getChildCount());
        }
        inflate.post(new g(this, inflate));
    }

    private <T> void addLabel(T t, int i, LabelTextProvider<T> labelTextProvider) {
        View inflate = this.mInflater.inflate(R.layout.fast_record_layout_input_tag_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_del_tag);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tag);
        FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) inflate.findViewById(R.id.edt_tag_content);
        fastRecordDrawableEditText.setEnabled(false);
        fastRecordDrawableEditText.setVisibility(8);
        textView.setBackground(this.mLabelBg.getConstantState().newDrawable());
        int i2 = KEY_DATA;
        textView.setTag(i2, t);
        int i3 = KEY_POSITION;
        textView.setTag(i3, Integer.valueOf(i));
        textView.setText(labelTextProvider.getLabelText(textView, i, t));
        imageView.setTag(i2, t);
        imageView.setTag(i3, Integer.valueOf(i));
        LogExt.logE("getLabels().size() = " + getLabels().size(), TAG);
        if (getLabels().size() <= 10) {
            fastRecordDrawableEditText.setTag(i2, t);
            fastRecordDrawableEditText.setTag(i3, Integer.valueOf(i));
            fastRecordDrawableEditText.setFilters(new InputFilter[]{new FastRecordEditTitleInputFilter(20)});
            setTagEditText(fastRecordDrawableEditText, t);
            if (t instanceof RecordContentTagEntity) {
                setLabelShowStatus(imageView, textView, fastRecordDrawableEditText, ((RecordContentTagEntity) t).isNewEditBean());
            } else if (t instanceof RecordPersonEntity) {
                setLabelShowStatus(imageView, textView, fastRecordDrawableEditText, ((RecordPersonEntity) t).isNewEditBean());
            }
            setTextChangedListener(fastRecordDrawableEditText, t);
            setEditText(fastRecordDrawableEditText);
            fastRecordDrawableEditText.setOnEditorActionListener(new b(this));
        }
        if (i >= 10) {
            return;
        }
        if (isRTL()) {
            addView(inflate, 0);
        } else {
            addView(inflate, this.mLabelWidth, this.mLabelHeight);
        }
    }

    private int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void ensureDelIvClickable() {
        int childCount = getChildCount();
        LogExt.logD("ensureDelIvClickable count = " + childCount, TAG);
        for (int i = 0; i < childCount; i++) {
            ((ImageView) getChildAt(i).findViewById(R.id.iv_del_tag)).setOnClickListener(new e(this));
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
            this.isTextBold = obtainStyledAttributes.getBoolean(R.styleable.LabelsView_isTextBold, false);
            obtainStyledAttributes.recycle();
        }
    }

    private <T> void insertAllLabels(List<T> list, LabelTextProvider<T> labelTextProvider) {
        removeAllViews();
        this.mLabels.clear();
        if (list != null) {
            this.mLabels.addAll(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                addLabel(list.get(i), i, labelTextProvider);
            }
            ensureDelIvClickable();
        }
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addEditTextView$1(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        LogExt.logD("tagEditText actionId =IME_ACTION_DONE,value = " + textView.getText(), TAG);
        this.mOnLabelAddFinishListener.onFinish(textView.getText().toString());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addEditTextView$2(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.mLabelHeight;
        layoutParams.width = this.mLabelWidth;
        invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addLabel$3(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        LogExt.logD("tagEditText actionId =IME_ACTION_DONE,value = " + textView.getText(), TAG);
        this.mOnLabelAddFinishListener.onFinish(textView.getText().toString());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addViewForIndex$0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = this.mLabelHeight;
        layoutParams.width = this.mLabelWidth;
        invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureDelIvClickable$5(View view) {
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

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showInput$4(EditText editText) {
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        LogExt.logE("inputMethodManager.isActive isShowSoftInput = " + this.isShowSoftInput, TAG);
        if (!this.isShowSoftInput.booleanValue()) {
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    private int layoutChildViewStatue(boolean z, int i, int i2) {
        if ((!z || i2 >= 0) && i2 < getChildCount()) {
            return i2;
        }
        return -1;
    }

    private void setEditText(FastRecordDrawableEditText fastRecordDrawableEditText) {
        LogExt.logE("setEditText finish", TAG);
        this.mEditText = fastRecordDrawableEditText;
    }

    private void setLabelShowStatus(ImageView imageView, TextView textView, EditText editText, boolean z) {
        if (z) {
            editText.setVisibility(0);
            textView.setVisibility(8);
            imageView.setVisibility(8);
            editText.setEnabled(true);
            showInput(editText);
            return;
        }
        editText.setVisibility(8);
        textView.setVisibility(0);
        imageView.setVisibility(0);
        editText.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void setTagEditText(EditText editText, Object obj) {
        if (obj instanceof RecordContentTagEntity) {
            if (getLabels().size() > 1) {
                editText.setHint("    ");
            } else {
                editText.setHint(this.mContext.getString(R.string.fast_record_input_tag_tip));
            }
        } else if (!(obj instanceof RecordPersonEntity)) {
        } else {
            if (getLabels().size() > 1) {
                editText.setHint("    ");
            } else {
                editText.setHint(this.mContext.getString(R.string.fast_record_input_person_tip));
            }
        }
    }

    private void setTextChangedListener(final FastRecordDrawableEditText fastRecordDrawableEditText, final Object obj) {
        fastRecordDrawableEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                LogExt.logD("afterTextChanged value text = " + obj, RecordDetailInputTagView.TAG);
                if (RecordDetailInputTagView.this.getLabels().size() > 10) {
                    Editable text = fastRecordDrawableEditText.getText();
                    Objects.requireNonNull(text);
                    if (!text.toString().isEmpty()) {
                        String string = RecordDetailInputTagView.this.getContext().getString(R.string.fast_record_max_tag_ten);
                        if (RecordDetailInputTagView.this.curTagType == 100) {
                            string = RecordDetailInputTagView.this.getContext().getString(R.string.fast_record_max_person_ten);
                        }
                        UToast.f(RecordDetailInputTagView.this.getContext(), string);
                        fastRecordDrawableEditText.setText("");
                    }
                }
                LogExt.logE("tagEditText.getText() = " + fastRecordDrawableEditText.getText(), RecordDetailInputTagView.TAG);
                if (fastRecordDrawableEditText.getText() == null || fastRecordDrawableEditText.getText().length() == 0) {
                    RecordDetailInputTagView.this.setTagEditText(fastRecordDrawableEditText, obj);
                }
                RecordDetailInputTagView.this.requestLayout();
                OnEditTextChange h = RecordDetailInputTagView.this.mOnEditTextChange;
                Editable text2 = fastRecordDrawableEditText.getText();
                Objects.requireNonNull(text2);
                h.onTextChange(text2.toString(), obj);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (fastRecordDrawableEditText.getHint() != null && fastRecordDrawableEditText.getHint().length() > 0) {
                    fastRecordDrawableEditText.setHint("");
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void showInput(EditText editText) {
        this.mHandler.postDelayed(new d(this, editText), 500);
    }

    private int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public <T> void addViewForIndex(Object obj, int i, LabelTextProvider<T> labelTextProvider) {
        View inflate = this.mInflater.inflate(R.layout.fast_record_layout_input_tag_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_del_tag);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tag);
        textView.setBackground(this.mLabelBg.getConstantState().newDrawable());
        int i2 = KEY_DATA;
        textView.setTag(i2, obj);
        int i3 = KEY_POSITION;
        textView.setTag(i3, Integer.valueOf(i));
        CharSequence labelText = labelTextProvider.getLabelText(textView, i, obj);
        textView.setText(labelText);
        imageView.setTag(i2, obj);
        imageView.setTag(i3, Integer.valueOf(i));
        LogExt.logE("addViewForIndex getLabels().size() = " + getLabels().size() + ", CharSequence value = " + labelText + ",position =" + i, TAG);
        if (i < 10) {
            if (isRTL()) {
                addView(inflate, getChildCount());
            } else {
                addView(inflate, 0);
            }
            inflate.post(new c(this, inflate));
        }
    }

    public void clearAllData() {
        LogExt.logD("clearAllData", TAG);
        removeAllViews();
        this.mLabels.clear();
        this.mEditText = null;
        requestLayout();
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public <T> List<T> getLabels() {
        return this.mLabels;
    }

    public Boolean getShowSoftInput() {
        return this.isShowSoftInput;
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
            setTextBold(bundle.getBoolean(KEY_TEXT_STYLE_STATE, this.isTextBold));
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
        bundle.putBoolean(KEY_TEXT_STYLE_STATE, this.isTextBold);
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
        LogExt.logD("setLabels size = " + list.size(), TAG);
        if (this.mLabels.isEmpty()) {
            LogExt.logE("setLabels insertAllLabels", TAG);
            insertAllLabels(list, labelTextProvider);
            return;
        }
        if (getEditText() != null) {
            getEditText().setText("");
            getEditText().setHint("    ");
        } else {
            addEditTextView(list.get(list.size() - 1), list.size() - 1);
        }
        int childCount = getChildCount() - 1;
        LogExt.logD("setLabels getChildCount size = " + getChildCount() + ",newLabels size = " + list.size(), TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("setLabels needDelSize = ");
        sb.append(childCount);
        LogExt.logD(sb.toString(), TAG);
        for (int i = 0; i < childCount; i++) {
            LogExt.logD("setLabels remove index = " + i, TAG);
            if (isRTL()) {
                removeViewAt(getChildCount() - 1);
            } else {
                removeViewAt(0);
            }
        }
        this.mLabels.clear();
        for (int size = list.size() - 2; size >= 0; size--) {
            addViewForIndex(list.get(size), size, labelTextProvider);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.mLabels.add(i2, list.get(i2));
        }
        if (!this.mLabels.isEmpty()) {
            if (this.mLabels.get(0) instanceof RecordContentTagEntity) {
                this.curTagType = 200;
            } else if (this.mLabels.get(0) instanceof RecordPersonEntity) {
                this.curTagType = 100;
            }
        }
        ensureDelIvClickable();
        if (getLabels().size() > 10 && getEditText() != null) {
            if (isRTL()) {
                LogExt.logD("removeViewAt last size = " + 0, TAG);
                removeViewAt(0);
            } else {
                int childCount2 = getChildCount() - 1;
                LogExt.logD("removeViewAt last size = " + childCount2, TAG);
                removeViewAt(childCount2);
            }
            this.mEditText = null;
        }
    }

    public void setLineMargin(int i) {
        if (this.mLineMargin != i) {
            this.mLineMargin = i;
            requestLayout();
        }
    }

    public void setMonEditTextChange(OnEditTextChange onEditTextChange) {
        this.mOnEditTextChange = onEditTextChange;
    }

    public void setOnDelIvClickListener(OnLabelDelIvClickListener onLabelDelIvClickListener) {
        this.mOnLabelDelIvClickListener = onLabelDelIvClickListener;
        ensureDelIvClickable();
    }

    public void setOnLabelAddFinishListener(OnLabelAddFinishListener onLabelAddFinishListener) {
        this.mOnLabelAddFinishListener = onLabelAddFinishListener;
    }

    public void setShowSoftInput(Boolean bool) {
        this.isShowSoftInput = bool;
    }

    public void setTextBold(boolean z) {
        if (this.isTextBold != z) {
            this.isTextBold = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView = (TextView) getChildAt(i);
                textView.getPaint().setFakeBoldText(this.isTextBold);
                textView.invalidate();
            }
        }
    }

    public void setWordMargin(int i) {
        if (this.mWordMargin != i) {
            this.mWordMargin = i;
            requestLayout();
        }
    }

    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    public RecordDetailInputTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        getAttrs(context, attributeSet);
    }

    public RecordDetailInputTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        getAttrs(context, attributeSet);
    }
}
