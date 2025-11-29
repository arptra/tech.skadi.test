package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class DayTimeDatePicker extends FrameLayout {
    private static final int DEFAULT_END_YEAR = 2099;
    private static final int DEFAULT_START_YEAR = 1900;
    /* access modifiers changed from: private */
    public boolean isLunar;
    /* access modifiers changed from: private */
    public int mDay;
    /* access modifiers changed from: private */
    public String mDayString;
    private Calendar mEndCal;
    private int mEndYear;
    String[] mGregorianDays;
    /* access modifiers changed from: private */
    public int mHour;
    private ScrollTextView mHourPicker;
    String[] mHourTexts;
    private TextView mHourUnit;
    private boolean mIsAccessibilityEnable;
    private boolean mIsDrawLine;
    boolean mIsLayoutRtl;
    String mLeap;
    private TextView mLeapMonthUnit;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mLunarMouths;
    String[] mLunardays;
    /* access modifiers changed from: private */
    public int mMin;
    private ScrollTextView mMinPicker;
    String[] mMinTexts;
    private TextView mMinUnit;
    /* access modifiers changed from: private */
    public int mMonth;
    private ScrollTextView mMonthDayPicker;
    private int mMonthOfDays;
    /* access modifiers changed from: private */
    public String mMonthString;
    private float mNormalItemHeight;
    private Typeface mNumTpyeface;
    private List<Float> mNumberNormalTextSizes;
    private int mNumberSelectTextSize;
    private int mOldMonth;
    /* access modifiers changed from: private */
    public OnTimeChangedListener mOnTimeChangedListener;
    private int mOneScreenCount;
    private LinearLayout mPickerHolder;
    private float mSelectItemHeight;
    /* access modifiers changed from: private */
    public Calendar mStartCal;
    private int mStartYear;
    private int mWidthPadding;
    private List<Float> mWordNormalTextSizes;
    private int mWordSelectTextSize;
    /* access modifiers changed from: private */
    public int mYear;
    private int mYearOfMonths;
    private Typeface mZhTypeface;

    public class DateAdapter implements ScrollTextView.IDataAdapter {
        static final int SET_HOUR = 4;
        static final int SET_MIN = 5;
        static final int SET_MOUNT_DAY = 6;
        int mType;

        public DateAdapter(int i) {
            this.mType = i;
        }

        public String getItemText(int i) {
            int i2 = this.mType;
            if (i2 == 4) {
                return DayTimeDatePicker.this.mHourTexts[i];
            }
            if (i2 == 5) {
                return DayTimeDatePicker.this.mMinTexts[i];
            }
            if (i2 != 6) {
                return null;
            }
            String str = " ";
            if (DayTimeDatePicker.this.isLunar) {
                int access$100 = DayTimeDatePicker.this.mYear;
                int access$200 = DayTimeDatePicker.this.getMonthNumFromPosition(i);
                if (access$200 > DayTimeDatePicker.this.getYearMonths(access$100) - 1) {
                    access$200 -= DayTimeDatePicker.this.getYearMonths(access$100);
                    access$100++;
                } else if (access$200 < 0) {
                    access$200 += DayTimeDatePicker.this.getYearMonths(access$100 - 1);
                    access$100--;
                }
                DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                String access$400 = dayTimeDatePicker.getLunarMonth(access$100, access$200 + 1, dayTimeDatePicker.mLunarMouths);
                int access$500 = DayTimeDatePicker.this.getDayNumFromPosition(i);
                StringBuilder sb = new StringBuilder();
                sb.append(access$400);
                if (DayTimeDatePicker.this.isZh()) {
                    str = DayTimeDatePicker.this.mMonthString;
                }
                sb.append(str);
                sb.append(DayTimeDatePicker.this.getLunarDays(access$500 - 1));
                return sb.toString();
            }
            int access$2002 = DayTimeDatePicker.this.getMonthNumFromPosition(i);
            DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
            if (access$2002 > dayTimeDatePicker2.getYearMonths(dayTimeDatePicker2.mYear) - 1) {
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                access$2002 -= dayTimeDatePicker3.getYearMonths(dayTimeDatePicker3.mYear);
            } else if (access$2002 < 0) {
                DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                access$2002 += dayTimeDatePicker4.getYearMonths(dayTimeDatePicker4.mYear);
            }
            if (DayTimeDatePicker.this.isZh()) {
                int i3 = access$2002 + 1;
                if (DayTimeDatePicker.this.mStartCal != null && DayTimeDatePicker.this.mStartCal.get(1) == DayTimeDatePicker.this.mYear && DayTimeDatePicker.this.mStartCal.get(2) == DayTimeDatePicker.this.mMonth) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i3);
                    sb2.append(DayTimeDatePicker.this.mMonthString);
                    DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                    sb2.append(dayTimeDatePicker5.mGregorianDays[(dayTimeDatePicker5.getDayNumFromPosition(i) - 1) + DayTimeDatePicker.this.mStartCal.get(5)]);
                    sb2.append(DayTimeDatePicker.this.mDayString);
                    return sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i3);
                sb3.append(DayTimeDatePicker.this.mMonthString);
                DayTimeDatePicker dayTimeDatePicker6 = DayTimeDatePicker.this;
                sb3.append(dayTimeDatePicker6.mGregorianDays[dayTimeDatePicker6.getDayNumFromPosition(i)]);
                sb3.append(DayTimeDatePicker.this.mDayString);
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(DayTimeDatePicker.this.mLunarMouths[access$2002]);
            sb4.append(str);
            DayTimeDatePicker dayTimeDatePicker7 = DayTimeDatePicker.this;
            sb4.append(dayTimeDatePicker7.mGregorianDays[dayTimeDatePicker7.getDayNumFromPosition(i)]);
            return sb4.toString();
        }

        public void onChanged(View view, int i, int i2) {
            int i3 = this.mType;
            if (i3 == 4) {
                int unused = DayTimeDatePicker.this.mHour = i2;
            } else if (i3 == 5) {
                int unused2 = DayTimeDatePicker.this.mMin = i2;
            } else if (i3 == 6) {
                if (DayTimeDatePicker.this.mStartCal != null && DayTimeDatePicker.this.mStartCal.get(1) == DayTimeDatePicker.this.mYear && DayTimeDatePicker.this.mStartCal.get(2) == DayTimeDatePicker.this.mMonth) {
                    DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                    int unused3 = dayTimeDatePicker.mDay = dayTimeDatePicker.mStartCal.get(5) + i2;
                }
                int access$200 = DayTimeDatePicker.this.getMonthNumFromPosition(i2);
                DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
                int unused4 = dayTimeDatePicker2.mDay = dayTimeDatePicker2.getDayNumFromPosition(i2);
                int unused5 = DayTimeDatePicker.this.mMonth = access$200;
                int access$900 = DayTimeDatePicker.this.mMonth;
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                if (access$900 > dayTimeDatePicker3.getYearMonths(dayTimeDatePicker3.mYear) - 1) {
                    DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                    DayTimeDatePicker.access$920(dayTimeDatePicker4, dayTimeDatePicker4.getYearMonths(dayTimeDatePicker4.mYear));
                    DayTimeDatePicker.access$112(DayTimeDatePicker.this, 1);
                } else if (DayTimeDatePicker.this.mMonth < 0) {
                    DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                    DayTimeDatePicker.access$912(dayTimeDatePicker5, dayTimeDatePicker5.getYearMonths(dayTimeDatePicker5.mYear - 1));
                    DayTimeDatePicker.access$120(DayTimeDatePicker.this, 1);
                }
                DayTimeDatePicker.this.resetMonthDayData();
            } else {
                return;
            }
            if (DayTimeDatePicker.this.mOnTimeChangedListener != null) {
                DayTimeDatePicker.this.mOnTimeChangedListener.onTimeChanged(DayTimeDatePicker.this.mYear, DayTimeDatePicker.this.mMonth, DayTimeDatePicker.this.mDay, DayTimeDatePicker.this.mHour, DayTimeDatePicker.this.mMin);
            }
            DayTimeDatePicker.this.sendAccessibilityEvents(this.mType);
        }
    }

    public interface OnTimeChangedListener {
        void onTimeChanged(int i, int i2, int i3, int i4, int i5);
    }

    public DayTimeDatePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int access$112(DayTimeDatePicker dayTimeDatePicker, int i) {
        int i2 = dayTimeDatePicker.mYear + i;
        dayTimeDatePicker.mYear = i2;
        return i2;
    }

    public static /* synthetic */ int access$120(DayTimeDatePicker dayTimeDatePicker, int i) {
        int i2 = dayTimeDatePicker.mYear - i;
        dayTimeDatePicker.mYear = i2;
        return i2;
    }

    public static /* synthetic */ int access$912(DayTimeDatePicker dayTimeDatePicker, int i) {
        int i2 = dayTimeDatePicker.mMonth + i;
        dayTimeDatePicker.mMonth = i2;
        return i2;
    }

    public static /* synthetic */ int access$920(DayTimeDatePicker dayTimeDatePicker, int i) {
        int i2 = dayTimeDatePicker.mMonth - i;
        dayTimeDatePicker.mMonth = i2;
        return i2;
    }

    private void adjustLayout4FocusedPosition() {
        TextView textView = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.mHourUnit = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_hour);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.mMinUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_min);
        }
    }

    private Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.mYear);
        instance.set(2, this.mMonth);
        return instance;
    }

    /* access modifiers changed from: private */
    public int getDayNumFromPosition(int i) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int monthDays = getMonthDays(this.mYear, this.mMonth) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + monthDays;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i >= twoMonthBeforeMonthDays) {
            if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
                i -= twoMonthBeforeMonthDays;
            } else if (i >= oneMonthBeforeMonthDays && i < monthDays) {
                i -= oneMonthBeforeMonthDays;
            } else if (i >= monthDays && i < oneMonthAfterMonthDays) {
                i -= monthDays;
            } else if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
                return 1;
            } else {
                i -= oneMonthAfterMonthDays;
            }
        }
        return 1 + i;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.mDay;
    }

    /* access modifiers changed from: private */
    public String getLunarMonth(int i, int i2, String[] strArr) {
        int leapMonth = LunarCalendar.leapMonth(i);
        if (leapMonth != 0 && i2 > leapMonth) {
            return strArr[i2 - 2];
        }
        if (i2 - 1 >= strArr.length) {
            i2 = strArr.length - 1;
        }
        return strArr[i2 - 1];
    }

    private int getMonthDays() {
        boolean z = true;
        if (this.isLunar) {
            int i = this.mMonth;
            int leapMonth = LunarCalendar.leapMonth(this.mYear);
            boolean z2 = false;
            if (leapMonth != 0) {
                if (leapMonth != i) {
                    z = false;
                }
                z2 = z;
            }
            if (leapMonth == 0 || (leapMonth != 0 && this.mMonth < leapMonth)) {
                i++;
            }
            return LunarCalendar.daysInMonth(this.mYear, i, z2);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.mYear);
        instance.set(2, this.mMonth);
        return instance.getActualMaximum(5);
    }

    private int getMonthDaysCount() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + getMonthDays(this.mYear, this.mMonth) + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    /* access modifiers changed from: private */
    public int getMonthNumFromPosition(int i) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int monthDays = getMonthDays(this.mYear, this.mMonth) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + monthDays;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i < twoMonthBeforeMonthDays) {
            return this.mMonth - 2;
        }
        if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
            return this.mMonth - 1;
        }
        if (i >= oneMonthBeforeMonthDays && i < monthDays) {
            return this.mMonth;
        }
        if (i >= monthDays && i < oneMonthAfterMonthDays) {
            return this.mMonth + 1;
        }
        if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
            return 0;
        }
        return this.mMonth + 2;
    }

    private int getOneMonthAfterMonthDays() {
        if (this.mMonth <= getYearMonths(this.mYear) - 2) {
            return getMonthDays(this.mYear, this.mMonth + 1);
        }
        int i = this.mYear;
        return getMonthDays(i + 1, (this.mMonth + 1) - getYearMonths(i));
    }

    private int getOneMonthBeforeMonthDays() {
        int i = this.mMonth;
        if (i >= 1) {
            return getMonthDays(this.mYear, i - 1);
        }
        int i2 = this.mYear;
        return getMonthDays(i2 - 1, (i - 1) + getYearMonths(i2 - 1));
    }

    private String getTimeText(int i) {
        return i != 4 ? i != 5 ? "" : String.valueOf(this.mMin) : String.valueOf(this.mHour);
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.mMonth <= getYearMonths(this.mYear) - 3) {
            return getMonthDays(this.mYear, this.mMonth + 2);
        }
        int i = this.mYear;
        return getMonthDays(i + 1, (this.mMonth + 2) - getYearMonths(i));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i = this.mMonth;
        if (i >= 2) {
            return getMonthDays(this.mYear, i - 2);
        }
        int i2 = this.mYear;
        return getMonthDays(i2 - 1, (i - 2) + getYearMonths(i2 - 1));
    }

    /* access modifiers changed from: private */
    public int getYearMonths(int i) {
        return (!this.isLunar || LunarCalendar.leapMonth(i) == 0) ? 12 : 13;
    }

    private boolean isLeapMonth(int i) {
        if (!isZh()) {
            return false;
        }
        int leapMonth = LunarCalendar.leapMonth(this.mYear);
        if (leapMonth == 0) {
            if (i >= 12) {
                return false;
            }
        } else if (i >= 13) {
            return false;
        }
        return leapMonth != 0 && i > leapMonth + -1 && i == leapMonth;
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* access modifiers changed from: private */
    public boolean isZh() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private void refreshTextPreference() {
        if (!this.isLunar || !isZh()) {
            this.mMonthDayPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
            this.mMonthDayPicker.setTypeface(this.mNumTpyeface);
        } else {
            this.mMonthDayPicker.setTextSize((float) this.mWordSelectTextSize, this.mWordNormalTextSizes);
            this.mMonthDayPicker.setTypeface(this.mZhTypeface);
        }
        this.mHourPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        this.mHourPicker.setTypeface(this.mNumTpyeface);
        this.mMinPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        this.mMinPicker.setTypeface(this.mNumTpyeface);
    }

    /* access modifiers changed from: private */
    public void resetMonthDayData() {
        int monthDaysCount = getMonthDaysCount();
        int daysPosition = getDaysPosition();
        ScrollTextView scrollTextView = this.mMonthDayPicker;
        scrollTextView.setData(new DateAdapter(6), -1.0f, daysPosition - 1, monthDaysCount, this.mOneScreenCount, 0, monthDaysCount - 1, false);
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvents(int i) {
        View findViewById;
        if (this.mIsAccessibilityEnable) {
            setContentDescription();
            if (i == 5) {
                View findViewById2 = findViewById(R.id.mc_column_min_Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 4) {
                View findViewById3 = findViewById(R.id.mc_column_hour_Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 6 && (findViewById = findViewById(R.id.mc_column_day_Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    private void setContentDescription() {
        if (this.mIsAccessibilityEnable) {
            View findViewById = findViewById(R.id.mc_column_min_Layout);
            View findViewById2 = findViewById(R.id.mc_column_day_Layout);
            View findViewById3 = findViewById(R.id.mc_column_hour_Layout);
            String replace = (getTimeText(6) + getTimeText(4) + this.mHourUnit.getText() + getTimeText(5) + this.mMinUnit.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置分，当前日期是" + replace);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置日，当前日期是" + replace);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置时，当前日期是" + replace);
            }
        }
    }

    private void setDayRange(int i) {
    }

    private void setLeapUnitVisibility(int i) {
        if (!isLunar() || !isLeapMonth(i)) {
            this.mLeapMonthUnit.setVisibility(8);
        } else {
            this.mLeapMonthUnit.setVisibility(0);
        }
    }

    private void setMonthRange(int i) {
    }

    private void updateYearPicker() {
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getCurrentHour() {
        return this.mHour;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mMin);
    }

    public int getDayOfMonth() {
        return this.mDay;
    }

    public String getLunarDays(int i) {
        String[] strArr = this.mLunardays;
        if (i > strArr.length - 1) {
            return null;
        }
        return strArr[i];
    }

    public TextView getMinUnit() {
        return this.mMinUnit;
    }

    public int getMonth() {
        return this.mMonth;
    }

    public String getTimePreviewText(boolean z, int i, int i2) {
        String str;
        int i3 = i2 + 1;
        String string = getResources().getString(R.string.mc_date_time_year);
        String string2 = getResources().getString(R.string.mc_date_time_month);
        if (z) {
            int leapMonth = LunarCalendar.leapMonth(i);
            String string3 = getResources().getString(R.string.mc_time_picker_leap);
            if (leapMonth == 0 || i3 <= leapMonth) {
                String[] strArr = this.mLunarMouths;
                i2 = i2 >= strArr.length ? strArr.length - 1 : i3;
                str = strArr[i2 - 1];
            } else if (i2 == leapMonth) {
                str = string3 + this.mLunarMouths[i2 - 1];
            } else {
                str = this.mLunarMouths[i2 - 1];
            }
            if (isZh()) {
                return i + string + str + string2;
            } else if (i2 > 0 && i2 <= this.mLunarMouths.length) {
                return str + " " + i;
            }
        } else if (isZh()) {
            return i + string + i3 + string2;
        } else if (i3 > 0 && i3 <= this.mLunarMouths.length) {
            return this.mLunarMouths[i2] + " " + i;
        }
        return "";
    }

    public int getYear() {
        return this.mYear;
    }

    public void init(int i, int i2, int i3, int i4, int i5, OnTimeChangedListener onTimeChangedListener, boolean z) {
        if (!(this.mYear == i && this.mMonth == i2 && this.mDay == i3)) {
            updateDate(i, i2, i3, i4, i5, z);
        }
        this.mOnTimeChangedListener = onTimeChangedListener;
        setContentDescription();
    }

    public boolean isLunar() {
        return this.isLunar;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsDrawLine) {
            int width = getWidth();
            int width2 = this.mPickerHolder.getWidth() - (this.mWidthPadding * 2);
            int i = (width - width2) / 2;
            int i2 = this.mLineOneHeight;
            Canvas canvas2 = canvas;
            float f = (float) i;
            float f2 = (float) (i + width2);
            canvas2.drawLine(f, (float) i2, f2, (float) i2, this.mLinePaint);
            int i3 = this.mLineTwoHeight;
            canvas2.drawLine(f, (float) i3, f2, (float) i3, this.mLinePaint);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mYear = savedState.getYear();
        this.mMonth = savedState.getMonth();
        this.mDay = savedState.getDay();
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mYear, this.mMonth, this.mDay);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            updateDate(this.mYear, this.mMonth, this.mDay, num.intValue(), this.mMin);
        }
    }

    public void setCurrentMinute(Integer num) {
        updateDate(this.mYear, this.mMonth, this.mDay, getCurrentHour(), num.intValue());
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mMonthDayPicker.setEnabled(z);
        this.mHourPicker.setEnabled(z);
        this.mMinPicker.setEnabled(z);
    }

    public void setIsDrawFading(boolean z) {
        this.mMinPicker.setIsDrawFading(z);
        this.mHourPicker.setIsDrawFading(z);
        this.mMonthDayPicker.setIsDrawFading(z);
    }

    public void setIsDrawLine(boolean z) {
        this.mIsDrawLine = z;
    }

    public void setItemHeight(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        this.mMonthDayPicker.setItemHeight(f, f2);
        this.mHourPicker.setItemHeight(f, f2);
        this.mMinPicker.setItemHeight(f, f2);
    }

    public void setLineHeight(int i, int i2) {
        this.mLineOneHeight = i;
        this.mLineTwoHeight = i2;
    }

    public void setLunar(boolean z, boolean z2) {
        int[] iArr;
        boolean z3;
        int i;
        int i2;
        this.isLunar = z;
        int[] iArr2 = {this.mYear, this.mMonth + 1, this.mDay, 0};
        int i3 = iArr2[0];
        int leapMonth = LunarCalendar.leapMonth(i3);
        int leapMonth2 = LunarCalendar.leapMonth(iArr2[0] - 1);
        if (this.isLunar) {
            iArr = LunarCalendar.solarToLunar(iArr2[0], iArr2[1], iArr2[2]);
            int i4 = iArr[0];
            if (!(i3 == i4 || leapMonth2 == 0 || (iArr[3] != 1 && iArr[1] <= leapMonth2)) || (i3 == i4 && leapMonth != 0 && (iArr[3] == 1 || iArr[1] > leapMonth))) {
                iArr[1] = iArr[1] + 1;
            }
        } else {
            if (leapMonth == 0 || leapMonth >= (i2 = iArr2[1])) {
                i = iArr2[1];
            } else {
                int i5 = leapMonth + 1;
                if (i5 == i2) {
                    i = i2 - 1;
                    z3 = true;
                } else if (i5 < i2) {
                    i = i2 - 1;
                } else {
                    i = 0;
                    z3 = false;
                }
                iArr = LunarCalendar.lunarToSolar(iArr2[0], i, iArr2[2], z3);
            }
            z3 = false;
            iArr = LunarCalendar.lunarToSolar(iArr2[0], i, iArr2[2], z3);
        }
        refreshTextPreference();
        int i6 = iArr[0];
        int i7 = iArr[1];
        updateDate(i6, i7 + -1 < 0 ? 12 : i7 - 1, iArr[2], this.mHour, this.mMin, z2);
        setLeapUnitVisibility(this.mMonth);
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mMonthDayPicker.setTextColor(i, i2);
        this.mHourPicker.setTextColor(i, i2);
        this.mMinPicker.setTextColor(i, i2);
        this.mMinUnit.setTextColor(i3);
        this.mHourUnit.setTextColor(i3);
    }

    public void updateDate(int i, int i2, int i3, int i4, int i5) {
        updateDate(i, i2, i3, i4, i5, false);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        public int getDay() {
            return this.mDay;
        }

        public int getMonth() {
            return this.mMonth;
        }

        public int getYear() {
            return this.mYear;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void updateDate(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = this.mStartYear;
        if (i >= i6) {
            i6 = i;
        }
        this.mYear = i6;
        int i7 = this.mEndYear;
        if (i > i7) {
            i = i7;
        }
        this.mYear = i;
        if (i2 > 11) {
            i2 = 11;
        }
        this.mMonth = i2;
        this.mDay = i3;
        this.mHour = i4;
        this.mMin = i5;
        this.mHourPicker.setCurrentItem(i4, z);
        this.mMinPicker.setCurrentItem(this.mMin, z);
        if (this.mMonthOfDays != getMonthDaysCount()) {
            int monthDaysCount = getMonthDaysCount();
            this.mMonthOfDays = monthDaysCount;
            this.mMonthDayPicker.refreshCount(monthDaysCount);
        }
        this.mMonthDayPicker.setCurrentItem(getDaysPosition() - 1, z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayTimeDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.isLunar = false;
        this.mOneScreenCount = 5;
        this.mIsAccessibilityEnable = false;
        this.mIsLayoutRtl = false;
        this.mZhTypeface = Typeface.create("sans-serif-medium", 0);
        this.mNumTpyeface = Typeface.create("DINPro-medium", 0);
        ArrayList arrayList = new ArrayList();
        this.mWordNormalTextSizes = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        this.mWordNormalTextSizes.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.mWordSelectTextSize = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.mNumberNormalTextSizes = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        this.mNumberNormalTextSizes.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.mNumberSelectTextSize = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        this.mStartYear = DEFAULT_START_YEAR;
        this.mEndYear = 2099;
        this.mHourTexts = new String[100];
        for (int i2 = 0; i2 < 100; i2++) {
            this.mHourTexts[i2] = String.valueOf(i2);
            if (i2 <= 9) {
                this.mHourTexts[i2] = "0" + this.mHourTexts[i2];
            }
        }
        this.mLeap = getResources().getString(R.string.mc_time_picker_leap);
        this.mMonthString = getResources().getString(R.string.mc_date_time_month);
        this.mDayString = getResources().getString(R.string.mc_date_time_day);
        this.mMinTexts = new String[100];
        for (int i3 = 0; i3 < 100; i3++) {
            this.mMinTexts[i3] = String.valueOf(i3);
            if (i3 <= 9) {
                this.mMinTexts[i3] = "0" + this.mMinTexts[i3];
            }
        }
        View.inflate(getContext(), R.layout.mc_date_picker_day_time_layout, this);
        TextView textView = (TextView) findViewById(R.id.mc_scroll_month_leap);
        this.mLeapMonthUnit = textView;
        if (textView != null) {
            textView.setText(this.mLeap);
            this.mLeapMonthUnit.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.mHourUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_hour);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.mMinUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_min);
        }
        Calendar instance = Calendar.getInstance();
        this.mYear = instance.get(1);
        this.mMonth = instance.get(2);
        this.mDay = instance.get(5);
        this.mOnTimeChangedListener = null;
        this.mPickerHolder = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll_day);
        this.mMonthDayPicker = scrollTextView;
        scrollTextView.setTypeface(this.mZhTypeface);
        float f = this.mSelectItemHeight;
        if (f != 0.0f) {
            float f2 = this.mNormalItemHeight;
            if (f2 != 0.0f) {
                this.mMonthDayPicker.setItemHeight((float) ((int) f), (float) ((int) f2));
            }
        }
        resetMonthDayData();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.mHourPicker = scrollTextView2;
        scrollTextView2.setTypeface(this.mNumTpyeface);
        float f3 = this.mSelectItemHeight;
        if (f3 != 0.0f) {
            float f4 = this.mNormalItemHeight;
            if (f4 != 0.0f) {
                this.mHourPicker.setItemHeight((float) ((int) f3), (float) ((int) f4));
            }
        }
        this.mHourPicker.setData(new DateAdapter(4), -1.0f, this.mHour, 24, this.mOneScreenCount, 0, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.mMinPicker = scrollTextView3;
        float f5 = this.mSelectItemHeight;
        if (f5 != 0.0f) {
            float f6 = this.mNormalItemHeight;
            if (f6 != 0.0f) {
                scrollTextView3.setItemHeight((float) ((int) f5), (float) ((int) f6));
            }
        }
        this.mMinPicker.setData(new DateAdapter(5), -1.0f, this.mMin, 60, this.mOneScreenCount, 0, 59, true);
        refreshTextPreference();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar instance2 = Calendar.getInstance();
            this.mStartCal = instance2;
            instance2.setTime(simpleDateFormat.parse(this.mStartYear + "-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Calendar instance3 = Calendar.getInstance();
            this.mEndCal = instance3;
            instance3.setTime(simpleDateFormat.parse(this.mEndYear + "-12-31"));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        adjustLayout4FocusedPosition();
        int paddingTop = this.mHourUnit.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f7 = displayMetrics.scaledDensity;
        float f8 = getResources().getDisplayMetrics().scaledDensity;
        TextView textView4 = this.mHourUnit;
        int textSize = (int) (((float) paddingTop) - (((this.mHourUnit.getTextSize() / f8) * (f8 - f7)) / 1.3f));
        textView4.setPadding(textView4.getPaddingLeft(), textSize, this.mHourUnit.getPaddingRight(), this.mHourUnit.getPaddingBottom());
        TextView textView5 = this.mMinUnit;
        textView5.setPadding(textView5.getPaddingLeft(), textSize, this.mMinUnit.getPaddingRight(), this.mMinUnit.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(R.styleable.MZTheme);
        int i4 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes.recycle();
        this.mLinePaint.setColor(i4);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mLunarMouths = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.mLunardays = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.mGregorianDays = new String[100];
        for (int i5 = 0; i5 < 100; i5++) {
            this.mGregorianDays[i5] = String.valueOf(i5);
            if (isZh()) {
                this.mGregorianDays[i5] = String.valueOf(i5);
            }
            if (i5 <= 9) {
                this.mGregorianDays[i5] = "0" + this.mGregorianDays[i5];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.mMinPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }

                public void onScrollingStarted(ScrollTextView scrollTextView) {
                }
            });
            this.mHourPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }

                public void onScrollingStarted(ScrollTextView scrollTextView) {
                }
            });
            this.mMonthDayPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    DayTimeDatePicker.this.setIsDrawFading(true);
                }

                public void onScrollingStarted(ScrollTextView scrollTextView) {
                }
            });
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r7.isLunar == r0) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(int r9, int r10, int r11, int r12, int r13, com.meizu.common.widget.DayTimeDatePicker.OnTimeChangedListener r14, boolean r15, boolean r16) {
        /*
            r8 = this;
            r7 = r8
            r2 = r10
            r0 = r15
            int r1 = r7.mYear
            r3 = r9
            if (r1 != r3) goto L_0x0016
            int r1 = r7.mMonth
            if (r1 != r2) goto L_0x0016
            int r1 = r7.mDay
            r4 = r11
            if (r1 != r4) goto L_0x0017
            boolean r1 = r7.isLunar
            if (r1 == r0) goto L_0x0046
            goto L_0x0017
        L_0x0016:
            r4 = r11
        L_0x0017:
            if (r0 == 0) goto L_0x003c
            r7.isLunar = r0
            int r0 = com.meizu.common.util.LunarCalendar.leapMonth(r9)
            if (r0 == 0) goto L_0x0027
            int r1 = r2 + 1
            if (r1 == r0) goto L_0x0027
            r1 = 0
            goto L_0x0029
        L_0x0027:
            r1 = r16
        L_0x0029:
            if (r0 == 0) goto L_0x0032
            if (r1 != 0) goto L_0x002f
            if (r2 <= r0) goto L_0x0032
        L_0x002f:
            int r0 = r2 + 1
            r2 = r0
        L_0x0032:
            r6 = 0
            r0 = r8
            r1 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r0.updateDate(r1, r2, r3, r4, r5, r6)
            goto L_0x0046
        L_0x003c:
            r6 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r0.updateDate(r1, r2, r3, r4, r5, r6)
        L_0x0046:
            r8.refreshTextPreference()
            r0 = r14
            r7.mOnTimeChangedListener = r0
            r8.setContentDescription()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.DayTimeDatePicker.init(int, int, int, int, int, com.meizu.common.widget.DayTimeDatePicker$OnTimeChangedListener, boolean, boolean):void");
    }

    public void setTextColor(int i, List<Integer> list, int i2) {
        this.mMonthDayPicker.setTextColor(i, list);
        this.mHourPicker.setTextColor(i, list);
        this.mMinPicker.setTextColor(i, list);
        this.mMinUnit.setTextColor(i2);
        this.mHourUnit.setTextColor(i2);
    }

    private int getMonthDays(int i, int i2) {
        Calendar calendar = this.mStartCal;
        boolean z = false;
        if (calendar != null && this.mEndCal != null && ((calendar.get(1) == i && this.mStartCal.get(2) > i2) || this.mStartCal.get(1) > i || ((this.mEndCal.get(1) == i && this.mEndCal.get(2) < i2) || this.mEndCal.get(1) < i))) {
            return 0;
        }
        Calendar calendar2 = this.mStartCal;
        if (calendar2 != null && calendar2.get(1) == i && this.mStartCal.get(2) == i2) {
            return this.mStartCal.getActualMaximum(5) - this.mStartCal.get(5);
        }
        Calendar calendar3 = this.mEndCal;
        if (calendar3 != null && calendar3.get(1) == i && this.mEndCal.get(2) == i2) {
            if (!this.isLunar) {
                return this.mEndCal.get(5);
            }
            if (this.mEndCal.get(5) > 30) {
                return 30;
            }
            return this.mEndCal.get(5);
        } else if (this.isLunar) {
            int leapMonth = LunarCalendar.leapMonth(i);
            if (leapMonth != 0 && leapMonth == i2) {
                z = true;
            }
            if (leapMonth == 0 || (leapMonth != 0 && i2 < leapMonth)) {
                i2++;
            }
            return LunarCalendar.daysInMonth(i, i2, z);
        } else {
            Calendar instance = Calendar.getInstance();
            instance.set(5, 1);
            instance.set(1, i);
            instance.set(2, i2);
            return instance.getActualMaximum(5);
        }
    }

    public void setLunar(boolean z) {
        setLunar(z, true);
    }
}
