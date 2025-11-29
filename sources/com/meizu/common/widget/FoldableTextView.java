package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.common.R;
import com.meizu.common.datetimepicker.date.MonthView;
import com.meizu.common.util.ResourceUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.StringUtils;

public class FoldableTextView extends TextView implements View.OnClickListener {
    private static final boolean DEBUG = false;
    private static final String ELLIPSIS_THREE_DOTS = "...";
    private static final String TAG = "FoldableTextView";
    private static int TOUCH_STATE_LONGCLICK = 1;
    private static int TOUCH_STATE_NORMAL;
    private int CHAR_SIZE;
    private Layout layout;
    private boolean mAlignViewEdge;
    /* access modifiers changed from: private */
    public Float mAnimatorFraction;
    private final Runnable mCheckLongPress;
    private boolean mClickToFold;
    private int mDuration;
    private CharSequence mEllipseText;
    private int mFoldLineMax;
    private int mFoldTextMaxWidth;
    /* access modifiers changed from: private */
    public CharSequence mFoldedText;
    /* access modifiers changed from: private */
    public boolean mIsAnimating;
    private boolean mIsForbidden;
    /* access modifiers changed from: private */
    public boolean mIsfolded;
    private int mLinkColor;
    /* access modifiers changed from: private */
    public boolean mLinkHit;
    private FoldingListener mListener;
    /* access modifiers changed from: private */
    public int mMaxHeight;
    /* access modifiers changed from: private */
    public int mMinHeight;
    private CharSequence mMoreText;
    /* access modifiers changed from: private */
    public boolean mNonClicks;
    private boolean mNonSpanClickable;
    private int mTouchState;
    private float mTouchX;
    private float mTouchY;
    private CharSequence mainText;

    public interface FoldingListener {
        boolean onFolding(FoldableTextView foldableTextView, boolean z);
    }

    public static class LocalLinkMovementMethod extends LinkMovementMethod {
        static LocalLinkMovementMethod sInstance;
        public boolean isLinkClick = false;

        public static LocalLinkMovementMethod getInstance() {
            if (sInstance == null) {
                sInstance = new LocalLinkMovementMethod();
            }
            return sInstance;
        }

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            this.isLinkClick = false;
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            if (layout == null) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            MoreClickSpan[] moreClickSpanArr = (MoreClickSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, MoreClickSpan.class);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (moreClickSpanArr.length != 0) {
                if (action == 1) {
                    moreClickSpanArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(moreClickSpanArr[0]), spannable.getSpanEnd(moreClickSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    boolean unused = ((FoldableTextView) textView).mLinkHit = true;
                }
                return true;
            } else if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                    this.isLinkClick = true;
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    boolean unused2 = ((FoldableTextView) textView).mLinkHit = true;
                }
                return true;
            } else {
                Selection.removeSelection(spannable);
                Touch.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
        }
    }

    @SuppressLint({"ParcelCreator"})
    public class MoreClickSpan extends TypefaceSpan {
        WeakReference<FoldableTextView> mFoldableTextView;
        private int mLinkColor = 0;

        public MoreClickSpan(String str, CharSequence charSequence) {
            super(str);
        }

        public void onClick(View view) {
            WeakReference<FoldableTextView> weakReference = this.mFoldableTextView;
            if (weakReference != null && weakReference.get() != null) {
                this.mFoldableTextView.get().onMoreSpanClick();
            }
        }

        public void setFoldableTextView(FoldableTextView foldableTextView) {
            this.mFoldableTextView = new WeakReference<>(foldableTextView);
        }

        public void setLinkColor(int i) {
            this.mLinkColor = i;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int i = this.mLinkColor;
            if (i == 0) {
                textPaint.setColor(textPaint.linkColor);
            } else {
                textPaint.setColor(i);
            }
        }
    }

    public class ValueHolder {
        private int mHeight;

        private ValueHolder() {
        }

        public int getHeight() {
            return this.mHeight;
        }

        public void setHeight(int i) {
            this.mHeight = i;
        }
    }

    public FoldableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private CharSequence foldText(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        Layout layout2 = getLayout();
        this.layout = layout2;
        if (layout2 == null) {
            return charSequence2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        TextPaint paint = this.layout.getPaint();
        int i = this.mFoldTextMaxWidth;
        if (i == 0) {
            i = this.layout.getWidth();
        }
        int lineCount = new DynamicLayout(spannableStringBuilder, paint, i, this.layout.getAlignment(), 1.0f, 0.0f, false).getLineCount();
        int i2 = this.mFoldLineMax;
        if (lineCount <= i2 || i2 == 0) {
            return charSequence2;
        }
        TextPaint paint2 = getPaint();
        int i3 = this.mFoldTextMaxWidth;
        if (i3 == 0) {
            i3 = this.layout.getWidth();
        }
        float f = (float) i3;
        String[] split = spannableStringBuilder.toString().replaceAll(StringUtils.CR, "").split(StringUtils.LF);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        int length = split.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            String str = split[i4];
            StringBuilder sb = new StringBuilder();
            if (paint2.measureText(str) <= f) {
                sb.append(str);
                sb.append(StringUtils.LF);
                i5++;
            } else {
                int i6 = 0;
                float f2 = 0.0f;
                while (i6 != str.length()) {
                    char charAt = str.charAt(i6);
                    f2 += paint2.measureText(String.valueOf(charAt));
                    if (f2 <= f) {
                        sb.append(charAt);
                    } else {
                        i5++;
                        if (i5 >= this.mFoldLineMax) {
                            break;
                        }
                        sb.append(StringUtils.LF);
                        spannableStringBuilder2.append(sb);
                        sb.setLength(0);
                        i6--;
                        f2 = 0.0f;
                    }
                    i6++;
                }
                i5++;
                if (i5 < this.mFoldLineMax) {
                    sb.append(StringUtils.LF);
                }
            }
            if (i5 >= this.mFoldLineMax) {
                int indexOf = sb.indexOf(StringUtils.LF);
                if (indexOf != -1) {
                    sb.deleteCharAt(indexOf);
                }
                int length2 = sb.length();
                if (!TextUtils.isEmpty(this.mEllipseText)) {
                    sb.append(this.mEllipseText);
                }
                sb.append(' ');
                int length3 = sb.length();
                sb.append(this.mMoreText);
                if (paint2.measureText(sb.toString()) > f) {
                    for (int i7 = length2 - 1; i7 > 0; i7--) {
                        sb.delete(i7, i7 + 1);
                        length3--;
                        if (paint2.measureText(sb.toString()) < f) {
                            break;
                        }
                    }
                }
                spannableStringBuilder2.append(sb);
                MoreClickSpan moreClickSpan = new MoreClickSpan("sans-serif-medium", charSequence2);
                moreClickSpan.setLinkColor(this.mLinkColor);
                moreClickSpan.setFoldableTextView(this);
                spannableStringBuilder2.setSpan(moreClickSpan, spannableStringBuilder2.length() + length3, spannableStringBuilder2.length(), 33);
            } else {
                spannableStringBuilder2.append(sb);
                i4++;
            }
        }
        return spannableStringBuilder2;
    }

    private void initHeight(CharSequence charSequence) {
        Layout layout2 = getLayout();
        this.layout = layout2;
        if (layout2 != null) {
            this.mMaxHeight = (int) (((double) ((layout2.getLineBottom(layout2.getLineCount() - 1) - this.layout.getLineTop(0)) + getPaddingBottom() + getPaddingTop())) + 0.5d);
            int lineCount = this.layout.getLineCount();
            int i = this.mFoldLineMax;
            if (lineCount <= i) {
                this.mMinHeight = this.mMaxHeight;
            } else {
                this.mMinHeight = (int) (((double) ((this.layout.getLineBottom(i - 1) - this.layout.getLineTop(0)) + getPaddingBottom() + getPaddingTop())) + 0.5d + ((double) getLineSpacingExtra()));
            }
        }
    }

    /* access modifiers changed from: private */
    public void onMoreSpanClick() {
        if (!this.mIsAnimating && !this.mIsForbidden) {
            FoldingListener foldingListener = this.mListener;
            if (foldingListener == null || foldingListener.onFolding(this, false)) {
                this.mIsfolded = false;
                setText(this.mainText, TextView.BufferType.NORMAL);
                startAnimator();
            }
        }
    }

    private void setOnClickListener(boolean z) {
        if (z) {
            setOnClickListener(this);
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    private void setSelectionByPosition(float f, float f2) {
        Layout layout2 = getLayout();
        if (layout2 != null) {
            float min = Math.min((float) ((getHeight() - getTotalPaddingBottom()) - 1), Math.max(0.0f, f2 - ((float) getTotalPaddingTop()))) + ((float) getScrollY());
            float max = Math.max(0.0f, f - ((float) getTotalPaddingLeft()));
            int offsetForHorizontal = layout2.getOffsetForHorizontal(layout2.getLineForVertical((int) min), Math.min((float) ((getWidth() - getTotalPaddingRight()) - 1), max) + ((float) getScrollX()));
            if (offsetForHorizontal < getText().length()) {
                Selection.setSelection((Spannable) getText(), offsetForHorizontal, offsetForHorizontal + 1);
                try {
                    TextView.class.getDeclaredMethod("startSelectionActionMode", (Class[]) null).invoke(this, (Object[]) null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void startAnimator() {
        if (this.mFoldLineMax != 0) {
            this.mIsAnimating = true;
            ValueHolder valueHolder = new ValueHolder();
            boolean z = this.mIsfolded;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(valueHolder, MonthView.VIEW_PARAMS_HEIGHT, new int[]{z ? this.mMaxHeight : this.mMinHeight, z ? this.mMinHeight : this.mMaxHeight});
            ofInt.setDuration((long) this.mDuration);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    if (FoldableTextView.this.mIsfolded) {
                        FoldableTextView foldableTextView = FoldableTextView.this;
                        foldableTextView.setText(foldableTextView.mFoldedText, TextView.BufferType.SPANNABLE);
                        FoldableTextView foldableTextView2 = FoldableTextView.this;
                        foldableTextView2.setMeasuredDimension(foldableTextView2.getMeasuredWidth(), FoldableTextView.this.mMinHeight);
                    } else {
                        FoldableTextView foldableTextView3 = FoldableTextView.this;
                        foldableTextView3.setMeasuredDimension(foldableTextView3.getMeasuredWidth(), FoldableTextView.this.mMaxHeight);
                    }
                    boolean unused = FoldableTextView.this.mIsAnimating = false;
                }

                public void onAnimationEnd(Animator animator) {
                    if (FoldableTextView.this.mIsfolded) {
                        FoldableTextView foldableTextView = FoldableTextView.this;
                        foldableTextView.setText(foldableTextView.mFoldedText, TextView.BufferType.SPANNABLE);
                        FoldableTextView foldableTextView2 = FoldableTextView.this;
                        foldableTextView2.setMeasuredDimension(foldableTextView2.getMeasuredWidth(), FoldableTextView.this.mMinHeight);
                    } else {
                        FoldableTextView foldableTextView3 = FoldableTextView.this;
                        foldableTextView3.setMeasuredDimension(foldableTextView3.getMeasuredWidth(), FoldableTextView.this.mMaxHeight);
                    }
                    boolean unused = FoldableTextView.this.mIsAnimating = false;
                    FoldableTextView foldableTextView4 = FoldableTextView.this;
                    boolean unused2 = foldableTextView4.mNonClicks = !foldableTextView4.mNonClicks;
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = FoldableTextView.this.mAnimatorFraction = Float.valueOf(valueAnimator.getAnimatedFraction());
                    FoldableTextView.this.requestLayout();
                }
            });
            ofInt.start();
        }
    }

    public void changeFoldState() {
        if (!this.mIsAnimating && !this.mIsForbidden && this.mClickToFold) {
            if (this.mIsfolded) {
                FoldingListener foldingListener = this.mListener;
                if (foldingListener == null || foldingListener.onFolding(this, false)) {
                    this.mIsfolded = false;
                    setText(this.mainText, TextView.BufferType.NORMAL);
                    if (this.mMinHeight != 0) {
                        startAnimator();
                        return;
                    }
                    return;
                }
                return;
            }
            FoldingListener foldingListener2 = this.mListener;
            if (foldingListener2 == null || foldingListener2.onFolding(this, true)) {
                this.mIsfolded = true;
                if (this.mMaxHeight != 0 && getLayout() != null && getLayout().getLineCount() > this.mFoldLineMax) {
                    startAnimator();
                }
            }
        }
    }

    public int getFoldLineMax() {
        return this.mFoldLineMax;
    }

    public boolean getFoldStatus() {
        return this.mIsfolded;
    }

    public int getLinkColor() {
        return this.mLinkColor;
    }

    public CharSequence getMoreText() {
        return this.mMoreText;
    }

    public CharSequence getStrEllipse() {
        return this.mEllipseText;
    }

    public boolean hasFocusable() {
        return false;
    }

    public boolean isAlignViewEdge() {
        return this.mAlignViewEdge;
    }

    public boolean isClickToFold() {
        return this.mClickToFold;
    }

    public boolean isForbidden() {
        return this.mIsForbidden;
    }

    public boolean isNonSpanClickable() {
        return this.mNonSpanClickable;
    }

    public void onClick(View view) {
        if (!LocalLinkMovementMethod.getInstance().isLinkClick) {
            changeFoldState();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FoldableTextView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mainText == null) {
            this.mainText = getText();
        }
        initHeight(this.mainText);
        if (!this.mIsAnimating) {
            if (this.mFoldedText == null) {
                this.mFoldedText = foldText(this.mainText);
            }
            if (this.mFoldedText.equals(this.mainText) || ((!this.mIsfolded || this.mFoldLineMax <= 0) && !getText().equals(this.mainText))) {
                setText(this.mainText, TextView.BufferType.SPANNABLE);
                setMeasuredDimension(i, this.mMaxHeight);
            } else if (!getText().equals(this.mFoldedText)) {
                setText(this.mFoldedText, TextView.BufferType.SPANNABLE);
                setMeasuredDimension(i, this.mMinHeight);
            }
        } else if (!this.mIsfolded) {
            int i3 = this.mMinHeight;
            setMeasuredDimension(i, (int) (((float) i3) + (((float) (this.mMaxHeight - i3)) * this.mAnimatorFraction.floatValue())));
        } else {
            int i4 = this.mMaxHeight;
            setMeasuredDimension(i, (int) (((float) i4) - (((float) (i4 - this.mMinHeight)) * this.mAnimatorFraction.floatValue())));
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence charSequence2;
        super.onTextChanged(charSequence, i, i2, i3);
        CharSequence charSequence3 = this.mainText;
        if (charSequence3 == null || (charSequence2 = this.mFoldedText) == null || !(charSequence3 == null || charSequence2 == null || charSequence == null || charSequence.toString().equals(this.mainText.toString()) || charSequence.toString().equals(this.mFoldedText.toString()))) {
            this.mainText = charSequence;
            this.mFoldedText = null;
            initHeight(charSequence);
            if (this.mIsfolded) {
                setHeight(this.mMinHeight);
            } else {
                setHeight(this.mMaxHeight);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1 || this.mIsAnimating) {
            return false;
        }
        if (!this.mNonSpanClickable && this.mIsfolded) {
            return LocalLinkMovementMethod.getInstance().onTouchEvent(this, (Spannable) getText(), motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchX = motionEvent.getX();
            this.mTouchY = motionEvent.getY();
            this.mTouchState = TOUCH_STATE_NORMAL;
            removeCallbacks(this.mCheckLongPress);
            postDelayed(this.mCheckLongPress, (long) ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            if (this.mTouchState != TOUCH_STATE_LONGCLICK && !hasSelection()) {
                LocalLinkMovementMethod.getInstance().onTouchEvent(this, (Spannable) getText(), motionEvent);
                performClick();
                this.mTouchState = TOUCH_STATE_NORMAL;
            }
            if (hasSelection() && this.mTouchState != TOUCH_STATE_LONGCLICK) {
                Selection.setSelection((Spannable) getText(), 0);
            }
            removeCallbacks(this.mCheckLongPress);
        } else if (action == 2) {
            this.mTouchX = motionEvent.getX();
            this.mTouchY = motionEvent.getY();
        } else if (action == 3) {
            removeCallbacks(this.mCheckLongPress);
        }
        return !this.mNonClicks || this.mNonSpanClickable;
    }

    public boolean performLongClick() {
        boolean performLongClick = super.performLongClick();
        this.mTouchState = TOUCH_STATE_LONGCLICK;
        if (!performLongClick && this.mNonSpanClickable) {
            setSelectionByPosition(this.mTouchX, this.mTouchY);
        }
        return performLongClick;
    }

    public void setClickToFold(boolean z) {
        this.mClickToFold = z;
    }

    public void setFoldDuration(int i) {
        this.mDuration = i;
    }

    public void setFoldStatus(boolean z) {
        if (!this.mIsForbidden && this.mIsfolded != z) {
            this.mIsfolded = z;
            requestLayout();
            invalidate();
        }
    }

    public void setFoldText(String str, String str2, boolean z) {
        this.mAlignViewEdge = z;
        if (str != null) {
            this.mEllipseText = str;
        } else {
            this.mEllipseText = ELLIPSIS_THREE_DOTS;
        }
        if (str2 != null) {
            this.mMoreText = str2;
        } else {
            this.mMoreText = getContext().getString(R.string.more_item_label);
        }
    }

    public void setFoldTextMaxWidth(int i) {
        this.mFoldTextMaxWidth = i;
    }

    public void setFolding(int i, FoldingListener foldingListener) {
        if (this.mFoldLineMax != i) {
            this.mFoldLineMax = i;
            setText(this.mainText, TextView.BufferType.NORMAL);
        }
        this.mListener = foldingListener;
    }

    public void setForbidden(boolean z) {
        this.mIsForbidden = z;
    }

    public void setLinkColor(int i) {
        this.mLinkColor = i;
        invalidate();
    }

    public void setNonSpanClickable(boolean z) {
        this.mNonSpanClickable = z;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public FoldableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_FoldableTextViewStyle);
    }

    public FoldableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsfolded = true;
        this.mAlignViewEdge = false;
        this.mClickToFold = true;
        this.mLinkColor = 0;
        this.mMaxHeight = 0;
        this.mMinHeight = 0;
        this.layout = null;
        this.mDuration = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.mIsAnimating = false;
        this.mAnimatorFraction = Float.valueOf(1.0f);
        this.mNonClicks = true;
        this.mNonSpanClickable = true;
        this.mIsForbidden = false;
        this.mTouchState = 0;
        this.CHAR_SIZE = 50;
        this.mFoldTextMaxWidth = 0;
        this.mCheckLongPress = new Runnable() {
            public void run() {
                if (FoldableTextView.this.isLongClickable() && FoldableTextView.this.getWindowToken() != null && FoldableTextView.this.getParent() != null) {
                    FoldableTextView.this.performLongClick();
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FoldableTextView, i, R.style.Widget_MeizuCommon_FoldableTextView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.FoldableTextView_mzTextEllipse) {
                this.mEllipseText = obtainStyledAttributes.getText(index);
            } else if (index == R.styleable.FoldableTextView_mzTextUnfold) {
                this.mMoreText = obtainStyledAttributes.getText(index);
            } else if (index == R.styleable.FoldableTextView_mzMaxFoldLine) {
                this.mFoldLineMax = obtainStyledAttributes.getInt(index, 0);
            } else if (index == R.styleable.FoldableTextView_mzUnfoldAlignViewEdge) {
                this.mAlignViewEdge = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.FoldableTextView_mzClickToFold) {
                this.mClickToFold = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.FoldableTextView_mzNonSpanClickable) {
                this.mNonSpanClickable = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.FoldableTextView_mzLinkColor) {
                int color = obtainStyledAttributes.getColor(index, 0);
                this.mLinkColor = color;
                if (color == 0) {
                    this.mLinkColor = ResourceUtils.getIdentifierByAttrId(R.attr.colorBrand, context);
                }
            } else if (index == R.styleable.FoldableTextView_mzIsFold) {
                this.mIsfolded = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(this.mMoreText)) {
            this.mMoreText = context.getString(R.string.more_item_label);
        }
        if (TextUtils.isEmpty(this.mEllipseText)) {
            this.mEllipseText = ELLIPSIS_THREE_DOTS;
        }
        setMovementMethod(LocalLinkMovementMethod.getInstance());
        setOnClickListener(true);
    }
}
