package com.meizu.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class WeekdayPicker extends LinearLayout {
    static final int DIFF_FRIDAY = 3;
    static final int DIFF_MONDAY = 0;
    static final int DIFF_SATURDAY = 2;
    static final int DIFF_SUNDAY = 1;
    static final int DIFF_THURSDAY = 4;
    static final int DIFF_TUESDAY = 6;
    static final int DIFF_WEDNESDAY = 5;
    static final int FIXED_DIFF_NORMAL_DAY = 0;
    static final String FIXED_WEEK_START_NORMAL_DAY = "-1";
    public static final int FRIDAY = 16;
    static final int HEIGHT_DELAY = 32;
    static final String IMG_SELECTED_TAG = "selected";
    static final String IMG_UNSELECTED_TAG = "unselected";
    public static final int MONDAY = 1;
    public static final int NO_DAY = 0;
    static final int PADDING_SIZE = 12;
    public static final int SATURDAY = 32;
    static final int SQUARE_WIDTH = 64;
    public static final int SUNDAY = 64;
    public static final int THURSDAY = 8;
    static final int TOTAL_ITEM_COUNT = 7;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 4;
    static final String WEEK_START_FRIDAY = "6";
    static final String WEEK_START_MONDAY = "2";
    static final String WEEK_START_NORMAL = "-1";
    static final String WEEK_START_NULL = "-2";
    static final String WEEK_START_SATURDAY = "7";
    static final String WEEK_START_SUNDAY = "1";
    static final String WEEK_START_THURSDAY = "5";
    static final String WEEK_START_TUESDAY = "3";
    static final String WEEK_START_WEDNESDAY = "4";
    private ImageView[] mBackgrouds;
    private Context mContext;
    private int mDiffWeekStart = 0;
    private int mHeightDelay = -1;
    private int mLastChangedIndex = -1;
    private int mLastLastChangedIndex = -1;
    private boolean mOutSide = false;
    private DaysOfWeek mRepeatData;
    private OnSelectChangedListener mSelectChangedListener = null;
    private int mSquareWidth = -1;
    private TextView[] mTexts;
    private String mWeekStart = "-1";

    public interface OnSelectChangedListener {
        void OnSelectChanged(int i);
    }

    public WeekdayPicker(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private int currentTouchIndex(float f) {
        int width = getWidth();
        float f2 = (float) (width / 7);
        float f3 = (f2 - ((float) this.mSquareWidth)) / 2.0f;
        if (getLayoutDirection() == 1) {
            f = ((float) width) - f;
        }
        int i = (int) (f / f2);
        if (i >= 7) {
            return -1;
        }
        int i2 = i - this.mDiffWeekStart;
        if (i2 < 0) {
            i2 += 7;
        }
        float f4 = f % f2;
        if (f4 < f3 || f4 - f3 > ((float) this.mSquareWidth)) {
            return -1;
        }
        return i2;
    }

    private void initView() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.mc_chooser_item_width);
        this.mSquareWidth = dimensionPixelSize;
        this.mHeightDelay = dimensionPixelSize / 2;
        this.mBackgrouds = new ImageView[7];
        this.mTexts = new TextView[7];
        String[] strArr = {getResources().getString(R.string.mc_monday), getResources().getString(R.string.mc_tuesday), getResources().getString(R.string.mc_wednesday), getResources().getString(R.string.mc_thursday), getResources().getString(R.string.mc_friday), getResources().getString(R.string.mc_saturday), getResources().getString(R.string.mc_sunday)};
        if (WEEK_START_NULL.equals(this.mWeekStart)) {
            this.mWeekStart = String.valueOf(Calendar.getInstance().getFirstDayOfWeek());
        } else if ("-1".equals(this.mWeekStart)) {
            this.mWeekStart = String.valueOf(Calendar.getInstance().getFirstDayOfWeek());
        }
        if ("1".equals(this.mWeekStart)) {
            this.mDiffWeekStart = 1;
        } else if ("2".equals(this.mWeekStart)) {
            this.mDiffWeekStart = 0;
        } else if ("3".equals(this.mWeekStart)) {
            this.mDiffWeekStart = 6;
        } else if (WEEK_START_WEDNESDAY.equals(this.mWeekStart)) {
            this.mDiffWeekStart = 5;
        } else if (WEEK_START_THURSDAY.equals(this.mWeekStart)) {
            this.mDiffWeekStart = 4;
        } else if (WEEK_START_FRIDAY.equals(this.mWeekStart)) {
            this.mDiffWeekStart = 3;
        } else if (WEEK_START_SATURDAY.equals(this.mWeekStart)) {
            this.mDiffWeekStart = 2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        if (this.mRepeatData == null) {
            this.mRepeatData = new DaysOfWeek(0);
        }
        boolean[] booleanArray = this.mRepeatData.getBooleanArray();
        int i = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.mc_weekday_picker_item, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            TextView textView = (TextView) inflate.findViewById(R.id.mc_chooser_text);
            textView.setText(strArr[i2]);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.mc_background_img);
            if (booleanArray == null) {
                imageView.setTag(IMG_UNSELECTED_TAG);
                imageView.setBackgroundResource(R.drawable.circle_white_shape);
                textView.setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected));
            } else if (booleanArray[i2]) {
                imageView.setTag(IMG_SELECTED_TAG);
                if (isEnabled()) {
                    imageView.setBackgroundResource(R.drawable.circle_blue_shape);
                } else {
                    imageView.setBackgroundResource(R.drawable.circle_white_shape);
                }
                textView.setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_selected));
            } else {
                imageView.setTag(IMG_UNSELECTED_TAG);
                if (isEnabled()) {
                    imageView.setBackgroundResource(R.drawable.circle_white_shape);
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                } else {
                    imageView.setBackgroundResource(R.drawable.circle_white_shape);
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected_disable));
                }
            }
            this.mBackgrouds[i2] = imageView;
            this.mTexts[i2] = textView;
            if (this.mDiffWeekStart + i2 >= 7) {
                addView(inflate, i);
                i++;
            } else {
                addView(inflate);
            }
        }
    }

    private void onBackgoundSelected(int i, boolean z) {
        int i2;
        ImageView imageView;
        ImageView[] imageViewArr = this.mBackgrouds;
        if (imageViewArr != null && i >= 0 && i < imageViewArr.length && imageViewArr[i] != null && this.mRepeatData != null) {
            if (z && (i2 = this.mLastLastChangedIndex) == i && i2 >= 0 && i2 < imageViewArr.length && (imageView = imageViewArr[this.mLastChangedIndex]) != null) {
                if (IMG_SELECTED_TAG.equals(imageView.getTag())) {
                    this.mBackgrouds[this.mLastChangedIndex].setTag(IMG_UNSELECTED_TAG);
                    this.mBackgrouds[this.mLastChangedIndex].setBackgroundResource(R.drawable.circle_white_shape);
                    this.mTexts[this.mLastChangedIndex].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                    this.mRepeatData.set(this.mLastChangedIndex, false);
                } else {
                    this.mBackgrouds[this.mLastChangedIndex].setTag(IMG_SELECTED_TAG);
                    this.mBackgrouds[this.mLastChangedIndex].setBackgroundResource(R.drawable.circle_blue_shape);
                    this.mTexts[this.mLastChangedIndex].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_selected));
                    this.mRepeatData.set(this.mLastChangedIndex, true);
                }
            }
            this.mLastLastChangedIndex = this.mLastChangedIndex;
            this.mLastChangedIndex = i;
            if (IMG_SELECTED_TAG.equals(this.mBackgrouds[i].getTag())) {
                this.mBackgrouds[i].setTag(IMG_UNSELECTED_TAG);
                this.mBackgrouds[i].setBackgroundResource(R.drawable.circle_white_shape);
                this.mTexts[i].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                this.mRepeatData.set(i, false);
                return;
            }
            this.mBackgrouds[i].setTag(IMG_SELECTED_TAG);
            this.mBackgrouds[i].setBackgroundResource(R.drawable.circle_blue_shape);
            this.mTexts[i].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_selected));
            this.mRepeatData.set(i, true);
        }
    }

    private void updateView() {
        DaysOfWeek daysOfWeek = this.mRepeatData;
        if (daysOfWeek != null && this.mBackgrouds != null) {
            boolean[] booleanArray = daysOfWeek.getBooleanArray();
            for (int i = 0; i < 7; i++) {
                if (booleanArray[i]) {
                    this.mBackgrouds[i].setTag(IMG_SELECTED_TAG);
                    this.mBackgrouds[i].setBackgroundResource(R.drawable.circle_blue_shape);
                    this.mTexts[i].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_selected));
                } else {
                    this.mBackgrouds[i].setTag(IMG_UNSELECTED_TAG);
                    this.mBackgrouds[i].setBackgroundResource(R.drawable.circle_white_shape);
                    this.mTexts[i].setTextColor(this.mContext.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                }
            }
        }
    }

    public boolean[] getSelectedArray() {
        return this.mRepeatData.getBooleanArray();
    }

    public int getSelectedDays() {
        return this.mRepeatData.getCoded();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(WeekdayPicker.class.getName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.isEnabled()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            boolean r9 = r8.isClickable()
            if (r9 != 0) goto L_0x0014
            boolean r8 = r8.isLongClickable()
            if (r8 == 0) goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            return r1
        L_0x0016:
            int r0 = r9.getAction()
            float r3 = r9.getX()
            float r9 = r9.getY()
            android.view.ViewParent r4 = r8.getParent()
            r5 = 7
            if (r0 == 0) goto L_0x00a7
            r6 = -1
            if (r0 == r2) goto L_0x008e
            r7 = 2
            if (r0 == r7) goto L_0x0034
            r9 = 3
            if (r0 == r9) goto L_0x008e
            goto L_0x00b9
        L_0x0034:
            boolean r0 = r8.mOutSide
            if (r0 == 0) goto L_0x003e
            if (r4 == 0) goto L_0x003d
            r4.requestDisallowInterceptTouchEvent(r1)
        L_0x003d:
            return r2
        L_0x003e:
            int r0 = r8.mHeightDelay
            int r0 = -r0
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            int r0 = r8.getWidth()
            int r7 = r8.mHeightDelay
            int r0 = r0 + r7
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            int r0 = -r7
            float r0 = (float) r0
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            int r0 = r8.getHeight()
            int r7 = r8.mHeightDelay
            int r0 = r0 + r7
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            int r9 = r8.currentTouchIndex(r3)
            if (r9 < 0) goto L_0x00b9
            if (r9 >= r5) goto L_0x00b9
            int r0 = r8.mLastChangedIndex
            if (r9 == r0) goto L_0x00b9
            r8.onBackgoundSelected(r9, r2)
            goto L_0x00b9
        L_0x0075:
            r8.mLastChangedIndex = r6
            r8.mLastLastChangedIndex = r6
            com.meizu.common.widget.WeekdayPicker$OnSelectChangedListener r9 = r8.mSelectChangedListener
            if (r9 == 0) goto L_0x0086
            com.meizu.common.widget.WeekdayPicker$DaysOfWeek r0 = r8.mRepeatData
            int r0 = r0.getCoded()
            r9.OnSelectChanged(r0)
        L_0x0086:
            r8.mOutSide = r2
            if (r4 == 0) goto L_0x008d
            r4.requestDisallowInterceptTouchEvent(r1)
        L_0x008d:
            return r2
        L_0x008e:
            r8.mOutSide = r1
            if (r4 == 0) goto L_0x0095
            r4.requestDisallowInterceptTouchEvent(r1)
        L_0x0095:
            r8.mLastChangedIndex = r6
            r8.mLastLastChangedIndex = r6
            com.meizu.common.widget.WeekdayPicker$OnSelectChangedListener r9 = r8.mSelectChangedListener
            if (r9 == 0) goto L_0x00b9
            com.meizu.common.widget.WeekdayPicker$DaysOfWeek r8 = r8.mRepeatData
            int r8 = r8.getCoded()
            r9.OnSelectChanged(r8)
            goto L_0x00b9
        L_0x00a7:
            if (r4 == 0) goto L_0x00ac
            r4.requestDisallowInterceptTouchEvent(r2)
        L_0x00ac:
            r8.mOutSide = r1
            int r9 = r8.currentTouchIndex(r3)
            if (r9 < 0) goto L_0x00b9
            if (r9 >= r5) goto L_0x00b9
            r8.onBackgoundSelected(r9, r1)
        L_0x00b9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.WeekdayPicker.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void resetView() {
        removeAllViews();
        initView();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        removeAllViews();
        initView();
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            i = 1;
        }
        this.mWeekStart = String.valueOf(i);
        resetView();
    }

    public void setOnSelectChangedListener(OnSelectChangedListener onSelectChangedListener) {
        this.mSelectChangedListener = onSelectChangedListener;
    }

    public void setSelectedDays(int i) {
        this.mRepeatData.setDays(i);
        updateView();
    }

    public static final class DaysOfWeek {
        private static int[] DAY_MAP = {2, 3, 4, 5, 6, 7, 1};
        private int mDays;

        public DaysOfWeek(int i) {
            this.mDays = i;
        }

        private boolean isSet(int i) {
            return (this.mDays & (1 << i)) > 0;
        }

        public boolean[] getBooleanArray() {
            boolean[] zArr = new boolean[7];
            for (int i = 0; i < 7; i++) {
                zArr[i] = isSet(i);
            }
            return zArr;
        }

        public int getCoded() {
            return this.mDays;
        }

        public void set(int i, boolean z) {
            if (z) {
                this.mDays = (1 << i) | this.mDays;
                return;
            }
            this.mDays = (~(1 << i)) & this.mDays;
        }

        public void setDays(int i) {
            this.mDays = i;
        }

        public String toString(Context context, boolean z) {
            StringBuilder sb = new StringBuilder();
            int i = this.mDays;
            if (i == 0) {
                return z ? context.getText(R.string.mc_never).toString() : "";
            }
            if (i == 127) {
                return context.getText(R.string.mc_every_day).toString();
            }
            if (i == 31) {
                return context.getText(R.string.mc_working_day).toString();
            }
            if (i == 96) {
                return context.getText(R.string.mc_weekend).toString();
            }
            int i2 = 0;
            while (i > 0) {
                if ((i & 1) == 1) {
                    i2++;
                }
                i >>= 1;
            }
            String[] shortWeekdays = new DateFormatSymbols().getShortWeekdays();
            for (int i3 = 0; i3 < 7; i3++) {
                if ((this.mDays & (1 << i3)) != 0) {
                    String str = shortWeekdays[DAY_MAP[i3]];
                    if (TextUtils.equals(Locale.getDefault().getLanguage(), "zh") && sb.length() > 0) {
                        str = str.substring(1);
                    }
                    sb.append(str);
                    i2--;
                    if (i2 > 0) {
                        sb.append(FastRecordHistoryDetailActivity.TAG_SPLIT);
                    }
                }
            }
            return sb.toString();
        }

        public void set(DaysOfWeek daysOfWeek) {
            this.mDays = daysOfWeek.mDays;
        }
    }

    public WeekdayPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public WeekdayPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }
}
