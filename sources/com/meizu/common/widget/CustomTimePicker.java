package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import com.meizu.net.pedometerprovider.util.Constants;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class CustomTimePicker extends FrameLayout {
    private static final int NUMBER_OF_MONTHS = 12;
    private static final String TAG = "CustomTimePicker";
    /* access modifiers changed from: private */
    public boolean isLeapMonth;
    /* access modifiers changed from: private */
    public boolean isLunar;
    private boolean isShowMarquee;
    private ScrollTextView mAmPmPicker;
    /* access modifiers changed from: private */
    public final String mAmText;
    /* access modifiers changed from: private */
    public final Calendar mCalendar;
    /* access modifiers changed from: private */
    public int mCurrentHour;
    /* access modifiers changed from: private */
    public int mCurrentMinute;
    /* access modifiers changed from: private */
    public int mDay;
    /* access modifiers changed from: private */
    public DayPicker mDayPicker;
    private TextView mDayUnit;
    private int mGregorianColor;
    private ScrollTextView mHourPicker;
    private TextView mHourUnit;
    private Boolean mIs24HourView;
    /* access modifiers changed from: private */
    public boolean mIsAm;
    private int mLunarColor;
    /* access modifiers changed from: private */
    public int mLunarMonthCount;
    private int mLunarNormalTextSize;
    private int mLunarSelectTextSize;
    private ScrollTextView mMinutePicker;
    private TextView mMinuteUnit;
    /* access modifiers changed from: private */
    public int mMonth;
    /* access modifiers changed from: private */
    public volatile Locale mMonthLocale;
    private int mMonthOfDays;
    private MonthPicker mMonthPicker;
    private TextView mMonthUnit;
    /* access modifiers changed from: private */
    public Object mMonthUpdateLock;
    /* access modifiers changed from: private */
    public int mOneScreenCount;
    private FrameLayout mPickerHolder;
    /* access modifiers changed from: private */
    public final String mPmText;
    /* access modifiers changed from: private */
    public String[] mShortMonths;
    private int mSolarNormalTextSize;
    private int mSolarSelectTextSize;
    private int mUnSlectColor;
    /* access modifiers changed from: private */
    public int mYear;

    public class DayPicker implements ScrollTextView.OnScrollTextViewScrollListener {
        /* access modifiers changed from: private */
        public ScrollTextView picker;
        private int validEnd;
        private int validStart;

        public DayPicker(ScrollTextView scrollTextView) {
            this.picker = scrollTextView;
        }

        public int getCurrentItem() {
            return this.picker.getCurrentItem();
        }

        public int getValidEnd() {
            return this.validEnd;
        }

        public int getValidStart() {
            return this.validStart;
        }

        public void onScrollingFinished(ScrollTextView scrollTextView) {
            this.picker.setCurrentItem(Math.max(Math.min(this.picker.getCurrentItem(), getValidEnd()), getValidStart()), true);
        }

        public void onScrollingStarted(ScrollTextView scrollTextView) {
        }

        public void refreshCount(int i) {
            this.picker.refreshCount(i);
        }

        public void setCurrentItem(int i, boolean z) {
            this.picker.setCurrentItem(i, z);
        }

        public void setData(TimeAdapter timeAdapter, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            setValidEnd(i6);
            setValidStart(i5);
            this.picker.setData(timeAdapter, (float) i, i2, i3, i4, 0, i3 - 1, z);
            this.picker.addScrollingListener(this);
        }

        public void setSelectItemHeight(int i) {
            this.picker.setSelectItemHeight((float) i);
        }

        public void setTextColor(int i, int i2) {
            this.picker.setTextColor(i, i2);
        }

        public void setTextSize(int i, int i2) {
            this.picker.setTextSize((float) i, (float) i2);
        }

        public void setValidEnd(int i) {
            this.validEnd = i;
        }

        public void setValidStart(int i) {
            this.validStart = i;
        }
    }

    public class MonthPicker implements ScrollTextView.IDataAdapter {
        private int[] endDate = new int[4];
        private int endIndex;
        private int[] endLunarDate = new int[4];
        private int leapMonthIn1stYear;
        private int leapMonthIn2ndYear;
        private int lunarMonthsIn1stYear;
        private int lunarMonthsIn2ndYear;
        private String[] mMonths;
        /* access modifiers changed from: private */
        public ScrollTextView picker;
        private int[] startDate = new int[4];
        private int startIndex;
        private int[] startLunarDate = new int[4];

        public MonthPicker(ScrollTextView scrollTextView) {
            this.picker = scrollTextView;
            this.mMonths = getShortMonths();
            calculateValidDateField();
        }

        private void calculateValidDateField() {
            int[] iArr;
            int i;
            int[] iArr2;
            int i2;
            CustomTimePicker.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
            this.startDate[0] = CustomTimePicker.this.mCalendar.get(1);
            this.startDate[1] = CustomTimePicker.this.mCalendar.get(2) + 1;
            this.startDate[2] = CustomTimePicker.this.mCalendar.get(5);
            int[] iArr3 = this.startDate;
            iArr3[3] = 0;
            int[] iArr4 = this.endDate;
            int i3 = iArr3[1];
            int i4 = i3 == 1 ? iArr3[0] : iArr3[0] + 1;
            iArr4[0] = i4;
            int i5 = i3 + -1 <= 0 ? 12 : i3 - 1;
            iArr4[1] = i5;
            iArr4[2] = CustomTimePicker.this.getMonthDays(i4, i5, false);
            this.endDate[3] = 0;
            int[] iArr5 = this.startDate;
            this.startLunarDate = LunarCalendar.solarToLunar(iArr5[0], iArr5[1], iArr5[2]);
            int[] iArr6 = this.endDate;
            int[] solarToLunar = LunarCalendar.solarToLunar(iArr6[0], iArr6[1], iArr6[2]);
            this.endLunarDate = solarToLunar;
            int[] iArr7 = this.startLunarDate;
            int i6 = iArr7[0];
            if (i6 == solarToLunar[0]) {
                int i7 = (solarToLunar[1] - iArr7[1]) + 1;
                this.lunarMonthsIn1stYear = i7;
                this.lunarMonthsIn2ndYear = 0;
                int unused = CustomTimePicker.this.mLunarMonthCount = i7;
                return;
            }
            this.lunarMonthsIn1stYear = 13 - iArr7[1];
            int leapMonth = LunarCalendar.leapMonth(i6);
            this.leapMonthIn1stYear = leapMonth;
            if (leapMonth != 0 && ((i2 = iArr2[1]) < leapMonth || (leapMonth == i2 && (iArr2 = this.startLunarDate)[3] != 1))) {
                this.lunarMonthsIn1stYear++;
            }
            int[] iArr8 = this.endLunarDate;
            this.lunarMonthsIn2ndYear = iArr8[1];
            int leapMonth2 = LunarCalendar.leapMonth(iArr8[0]);
            this.leapMonthIn2ndYear = leapMonth2;
            if (leapMonth2 != 0 && ((i = iArr[1]) > leapMonth2 || (i == leapMonth2 && (iArr = this.endLunarDate)[3] == 1))) {
                this.lunarMonthsIn2ndYear++;
            }
            int unused2 = CustomTimePicker.this.mLunarMonthCount = this.lunarMonthsIn1stYear + this.lunarMonthsIn2ndYear;
        }

        private String getLunarMonths(int i, int i2) {
            int i3 = i % 13;
            int leapMonth = LunarCalendar.leapMonth(i2);
            if (leapMonth == 0) {
                if (i3 >= 12) {
                    return null;
                }
            } else if (i3 >= 13) {
                return null;
            }
            String[] stringArray = CustomTimePicker.this.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
            String string = CustomTimePicker.this.getResources().getString(R.string.mc_time_picker_leap);
            if (leapMonth == 0 || i3 <= leapMonth - 1) {
                return stringArray[i3];
            }
            if (i3 != leapMonth) {
                return stringArray[i3 - 1];
            }
            return string + stringArray[i3 - 1];
        }

        private String[] getShortMonths() {
            Locale locale = Locale.getDefault();
            if (locale.equals(CustomTimePicker.this.mMonthLocale) && CustomTimePicker.this.mShortMonths != null) {
                return CustomTimePicker.this.mShortMonths;
            }
            synchronized (CustomTimePicker.this.mMonthUpdateLock) {
                try {
                    if (!locale.equals(CustomTimePicker.this.mMonthLocale)) {
                        String[] unused = CustomTimePicker.this.mShortMonths = new String[12];
                        int i = 0;
                        for (int i2 = 0; i2 < 12; i2++) {
                            CustomTimePicker.this.mShortMonths[i2] = DateUtils.getMonthString(i2, 20);
                        }
                        if (CustomTimePicker.this.mShortMonths[0].startsWith("1")) {
                            while (i < CustomTimePicker.this.mShortMonths.length) {
                                int i3 = i + 1;
                                CustomTimePicker.this.mShortMonths[i] = String.valueOf(i3);
                                i = i3;
                            }
                        }
                        Locale unused2 = CustomTimePicker.this.mMonthLocale = locale;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return CustomTimePicker.this.mShortMonths;
        }

        public int getCurrentItem() {
            return this.picker.getCurrentItem() - (CustomTimePicker.this.mOneScreenCount / 2);
        }

        public String getItemText(int i) {
            int i2;
            int i3;
            if (CustomTimePicker.this.isLunar) {
                int access$2300 = i - (CustomTimePicker.this.mOneScreenCount / 2);
                if (access$2300 < 0 || access$2300 > CustomTimePicker.this.mLunarMonthCount - 1) {
                    return "";
                }
                int i4 = this.lunarMonthsIn1stYear;
                if (access$2300 >= i4) {
                    i2 = access$2300 - i4;
                    i3 = this.endLunarDate[0];
                } else {
                    int[] iArr = this.startLunarDate;
                    int i5 = iArr[1];
                    i2 = access$2300 + (i5 - 1);
                    int i6 = this.leapMonthIn1stYear;
                    if (i6 != 0 && (i5 > i6 || iArr[3] == 1 || (i5 < i6 && i2 >= i6))) {
                        i2++;
                    }
                    i3 = iArr[0];
                }
                return getLunarMonths(i2, i3);
            } else if (i < CustomTimePicker.this.mOneScreenCount / 2 || i > (CustomTimePicker.this.mOneScreenCount / 2) + 11) {
                return "";
            } else {
                return this.mMonths[(((this.startDate[1] - 1) + i) - (CustomTimePicker.this.mOneScreenCount / 2)) % 12];
            }
        }

        public int getMonth(int[] iArr) {
            int i;
            int currentItem = getCurrentItem();
            if (CustomTimePicker.this.isLunar) {
                int i2 = this.lunarMonthsIn1stYear;
                if (currentItem >= i2) {
                    i = currentItem - (i2 - 1);
                    if (iArr != null) {
                        iArr[0] = this.endLunarDate[0];
                    }
                    int i3 = this.leapMonthIn2ndYear;
                    if (i != i3 + 1 || iArr == null) {
                        iArr[1] = 0;
                    } else {
                        iArr[1] = 1;
                    }
                    if (i3 == 0 || i <= i3) {
                        return i;
                    }
                } else {
                    int[] iArr2 = this.startLunarDate;
                    i = currentItem + iArr2[1];
                    if (iArr != null) {
                        iArr[0] = iArr2[0];
                    }
                    int i4 = this.leapMonthIn1stYear;
                    if (i4 == 0) {
                        iArr[1] = 0;
                        return i;
                    } else if (iArr2[3] == 1 && i == i4) {
                        iArr[1] = 1;
                        return i;
                    } else if (i2 <= 13 - i4 || i <= i4) {
                        iArr[1] = 0;
                        return i;
                    } else {
                        iArr[1] = 1;
                    }
                }
                return i - 1;
            }
            int[] iArr3 = this.startDate;
            int i5 = iArr3[1];
            if (currentItem > 12 - i5) {
                int i6 = currentItem - (12 - i5);
                if (iArr == null) {
                    return i6;
                }
                iArr[0] = this.endDate[0];
                iArr[1] = 0;
                return i6;
            }
            int i7 = currentItem + i5;
            if (iArr == null) {
                return i7;
            }
            iArr[0] = iArr3[0];
            iArr[1] = 0;
            return i7;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
            if (r6 > r5) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
            if (r6 > r2) goto L_0x006e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onChanged(android.view.View r4, int r5, int r6) {
            /*
                r3 = this;
                com.meizu.common.widget.CustomTimePicker r4 = com.meizu.common.widget.CustomTimePicker.this
                int r5 = r4.mYear
                com.meizu.common.widget.CustomTimePicker r0 = com.meizu.common.widget.CustomTimePicker.this
                int r0 = r0.mMonth
                com.meizu.common.widget.CustomTimePicker r1 = com.meizu.common.widget.CustomTimePicker.this
                boolean r1 = r1.isLunar
                int r4 = r4.getMonthDays(r5, r0, r1)
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int r5 = r5.mOneScreenCount
                int r5 = r5 / 2
                int r6 = r6 - r5
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                boolean r5 = r5.isLunar
                r0 = 0
                r1 = 1
                if (r5 == 0) goto L_0x0041
                int r5 = r3.lunarMonthsIn1stYear
                if (r6 < r5) goto L_0x0037
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int[] r2 = r3.endLunarDate
                r0 = r2[r0]
                int unused = r5.mYear = r0
                goto L_0x005a
            L_0x0037:
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int[] r2 = r3.startLunarDate
                r0 = r2[r0]
                int unused = r5.mYear = r0
                goto L_0x005a
            L_0x0041:
                int[] r5 = r3.startDate
                r2 = r5[r1]
                int r2 = 12 - r2
                if (r6 <= r2) goto L_0x0053
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int[] r2 = r3.endDate
                r0 = r2[r0]
                int unused = r5.mYear = r0
                goto L_0x005a
            L_0x0053:
                com.meizu.common.widget.CustomTimePicker r2 = com.meizu.common.widget.CustomTimePicker.this
                r5 = r5[r0]
                int unused = r2.mYear = r5
            L_0x005a:
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                boolean r5 = r5.isLunar
                if (r5 == 0) goto L_0x0084
                int r5 = r3.lunarMonthsIn1stYear
                if (r6 < r5) goto L_0x0071
                int r5 = r5 - r1
                int r6 = r6 - r5
                int r5 = r3.leapMonthIn2ndYear
                if (r5 == 0) goto L_0x0091
                if (r6 <= r5) goto L_0x0091
            L_0x006e:
                int r6 = r6 + -1
                goto L_0x0091
            L_0x0071:
                int[] r5 = r3.startLunarDate
                r0 = r5[r1]
                int r6 = r6 + r0
                int r2 = r3.leapMonthIn1stYear
                if (r2 == 0) goto L_0x0091
                if (r0 > r2) goto L_0x0091
                r0 = 3
                r5 = r5[r0]
                if (r5 == r1) goto L_0x0091
                if (r6 <= r2) goto L_0x0091
                goto L_0x006e
            L_0x0084:
                int[] r5 = r3.startDate
                r5 = r5[r1]
                int r0 = 12 - r5
                if (r6 <= r0) goto L_0x0090
                int r5 = 12 - r5
                int r6 = r6 - r5
                goto L_0x0091
            L_0x0090:
                int r6 = r6 + r5
            L_0x0091:
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int unused = r5.mMonth = r6
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                int r6 = r5.mYear
                com.meizu.common.widget.CustomTimePicker r0 = com.meizu.common.widget.CustomTimePicker.this
                int r0 = r0.mMonth
                com.meizu.common.widget.CustomTimePicker r2 = com.meizu.common.widget.CustomTimePicker.this
                boolean r2 = r2.isLunar
                int r5 = r5.getMonthDays(r6, r0, r2)
                if (r4 == r5) goto L_0x00d5
                com.meizu.common.widget.CustomTimePicker r4 = com.meizu.common.widget.CustomTimePicker.this
                com.meizu.common.widget.CustomTimePicker$DayPicker r4 = r4.mDayPicker
                if (r4 == 0) goto L_0x00d5
                com.meizu.common.widget.CustomTimePicker r4 = com.meizu.common.widget.CustomTimePicker.this
                int r5 = r4.mYear
                com.meizu.common.widget.CustomTimePicker r6 = com.meizu.common.widget.CustomTimePicker.this
                int r6 = r6.mMonth
                com.meizu.common.widget.CustomTimePicker r0 = com.meizu.common.widget.CustomTimePicker.this
                boolean r0 = r0.isLunar
                int r4 = r4.getMonthDays(r5, r6, r0)
                com.meizu.common.widget.CustomTimePicker r5 = com.meizu.common.widget.CustomTimePicker.this
                com.meizu.common.widget.CustomTimePicker$DayPicker r5 = r5.mDayPicker
                r5.refreshCount(r4)
            L_0x00d5:
                com.meizu.common.widget.CustomTimePicker r4 = com.meizu.common.widget.CustomTimePicker.this
                com.meizu.common.widget.CustomTimePicker$DayPicker r4 = r4.mDayPicker
                int r4 = r4.getCurrentItem()
                int r4 = r4 + r1
                r3.setDayPickerValidField(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.CustomTimePicker.MonthPicker.onChanged(android.view.View, int, int):void");
        }

        public void refreshCountAndCurrent(int i, int i2) {
            this.picker.refreshCountAndCurrent(i + ((CustomTimePicker.this.mOneScreenCount / 2) * 2), i2 + (CustomTimePicker.this.mOneScreenCount / 2));
        }

        public void setData(ScrollTextView.IDataAdapter iDataAdapter, float f, int i, int i2, int i3, int i4, int i5, boolean z) {
            int i6 = i4;
            this.startIndex = i6;
            int i7 = (i3 / 2) * 2;
            int i8 = i5 + i7 + 1;
            this.endIndex = i8;
            this.picker.setData(this, f, i, i2 + i7, i3, i6, i8, z);
        }

        public void setDayPickerValidField(int i) {
            CustomTimePicker customTimePicker = CustomTimePicker.this;
            int access$2100 = customTimePicker.getMonthDays(customTimePicker.mYear, CustomTimePicker.this.mMonth, CustomTimePicker.this.isLunar);
            if (CustomTimePicker.this.isLunar) {
                if (CustomTimePicker.this.mYear == this.startLunarDate[0] && CustomTimePicker.this.mMonth == this.startLunarDate[1]) {
                    CustomTimePicker.this.mDayPicker.setValidStart(this.startLunarDate[2] - 1);
                } else {
                    CustomTimePicker.this.mDayPicker.setValidStart(0);
                }
                if (CustomTimePicker.this.mYear == this.endLunarDate[0] && CustomTimePicker.this.mMonth == this.endLunarDate[1]) {
                    CustomTimePicker.this.mDayPicker.setValidEnd(this.endLunarDate[2] - 1);
                } else {
                    CustomTimePicker.this.mDayPicker.setValidEnd(access$2100 - 1);
                }
            } else {
                if (CustomTimePicker.this.mYear == this.startDate[0] && CustomTimePicker.this.mMonth == this.startDate[1]) {
                    CustomTimePicker.this.mDayPicker.setValidStart(this.startDate[2] - 1);
                } else {
                    CustomTimePicker.this.mDayPicker.setValidStart(0);
                }
                if (CustomTimePicker.this.mYear == this.endDate[0] && CustomTimePicker.this.mMonth == this.endDate[1]) {
                    CustomTimePicker.this.mDayPicker.setValidEnd(this.endDate[2] - 1);
                } else {
                    CustomTimePicker.this.mDayPicker.setValidEnd(access$2100 - 1);
                }
            }
            int unused = CustomTimePicker.this.mDay = i;
            CustomTimePicker customTimePicker2 = CustomTimePicker.this;
            int unused2 = customTimePicker2.mDay = Math.min(customTimePicker2.mDay, access$2100);
            CustomTimePicker customTimePicker3 = CustomTimePicker.this;
            int unused3 = customTimePicker3.mDay = Math.min(customTimePicker3.mDay, CustomTimePicker.this.mDayPicker.getValidEnd() + 1);
            CustomTimePicker customTimePicker4 = CustomTimePicker.this;
            int unused4 = customTimePicker4.mDay = Math.max(customTimePicker4.mDay, CustomTimePicker.this.mDayPicker.getValidStart() + 1);
            CustomTimePicker.this.mDayPicker.setCurrentItem(CustomTimePicker.this.mDay - 1, true);
        }

        public void setMonth(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (i2 >= 0) {
                boolean unused = CustomTimePicker.this.isLeapMonth = z;
                if (CustomTimePicker.this.isLunar) {
                    int[] iArr = this.startLunarDate;
                    int i6 = iArr[0];
                    if (i == i6) {
                        int i7 = this.leapMonthIn1stYear;
                        if (i7 != 0 && i6 <= i7 && iArr[3] != 1 && (i2 > i7 || (i7 == i2 && z))) {
                            i2++;
                        }
                        refreshCountAndCurrent(CustomTimePicker.this.mLunarMonthCount, i2 - this.startLunarDate[1]);
                    } else if (i == this.endLunarDate[0]) {
                        int i8 = this.leapMonthIn2ndYear;
                        if (i8 != 0 && (i2 > i8 || (i8 == i2 && z))) {
                            i2++;
                        }
                        refreshCountAndCurrent(CustomTimePicker.this.mLunarMonthCount, (i2 + this.lunarMonthsIn1stYear) - 1);
                    }
                } else if (i2 <= 12) {
                    int[] iArr2 = this.startDate;
                    if (i != iArr2[0] || i2 < (i5 = iArr2[1])) {
                        int[] iArr3 = this.endDate;
                        if (i == iArr3[0] && i2 <= (i4 = iArr3[1])) {
                            refreshCountAndCurrent(12, 11 - (i4 - i2));
                        }
                    } else {
                        refreshCountAndCurrent(12, Math.min(11, i2 - i5));
                    }
                }
                setDayPickerValidField(i3);
            }
        }

        public void setSelectItemHeight(int i) {
            this.picker.setSelectItemHeight((float) i);
        }

        public void setTextColor(int i, int i2) {
            this.picker.setTextColor(i, i2);
        }

        public void setTextSize(int i, int i2) {
            this.picker.setTextSize((float) i, (float) i2);
        }
    }

    public class TimeAdapter implements ScrollTextView.IDataAdapter {
        static final int SET_AMPM = 3;
        static final int SET_DAY = 5;
        static final int SET_HOUR = 1;
        static final int SET_MIN = 2;
        int mType;

        public TimeAdapter(int i) {
            this.mType = i;
        }

        public String getItemText(int i) {
            int i2 = this.mType;
            if (i2 != 1) {
                if (i2 == 2) {
                    return String.valueOf(i);
                }
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                    return CustomTimePicker.this.isLunar ? CustomTimePicker.this.getLunarDays(i) : String.valueOf(i + 1);
                } else if (i == 0) {
                    return CustomTimePicker.this.mAmText;
                } else {
                    if (i == 1) {
                        return CustomTimePicker.this.mPmText;
                    }
                    return null;
                }
            } else if (CustomTimePicker.this.is24HourView()) {
                return String.valueOf(i);
            } else {
                if (i == 0) {
                    i = 12;
                }
                return String.valueOf(i);
            }
        }

        public void onChanged(View view, int i, int i2) {
            int i3 = this.mType;
            boolean z = true;
            if (i3 == 1) {
                int unused = CustomTimePicker.this.mCurrentHour = i2;
            } else if (i3 == 2) {
                int unused2 = CustomTimePicker.this.mCurrentMinute = i2;
            } else if (i3 == 3) {
                CustomTimePicker customTimePicker = CustomTimePicker.this;
                if (i2 != 0) {
                    z = false;
                }
                boolean unused3 = customTimePicker.mIsAm = z;
            } else if (i3 == 5) {
                int unused4 = CustomTimePicker.this.mDay = i2 + 1;
            }
        }
    }

    public CustomTimePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    private void doTabAnimate() {
        boolean z = this.isLunar;
        int i = z ? this.mGregorianColor : this.mLunarColor;
        setTabColor(i, !z, true);
        setTextColor(i, this.mUnSlectColor, i);
    }

    /* access modifiers changed from: private */
    public String getLunarDays(int i) {
        String[] stringArray = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        if (i > stringArray.length - 1) {
            return null;
        }
        return stringArray[i];
    }

    /* access modifiers changed from: private */
    public int getMonthDays(int i, int i2, boolean z) {
        boolean z2 = true;
        if (z) {
            int leapMonth = LunarCalendar.leapMonth(i);
            boolean z3 = false;
            if (leapMonth != 0) {
                if (leapMonth != i2) {
                    z2 = false;
                }
                z3 = z2;
            }
            return LunarCalendar.daysInMonth(i, i2, z3);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, i);
        instance.set(2, i2 - 1);
        return instance.getActualMaximum(5);
    }

    private int getMonthIndex(int i) {
        int i2 = this.mOneScreenCount / 2;
        if (i < 0 || i > 11) {
            return i2;
        }
        int i3 = this.mCalendar.get(2);
        return i >= i3 ? i2 + (i - i3) : i2 + (12 - i3) + i;
    }

    private void inflateLayout() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        getResources().getDisplayMetrics();
        this.mOneScreenCount = 3;
        int i = R.layout.mc_custom_picker_24hour;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mc_custom_time_picker_select_h);
        View.inflate(getContext(), i, this);
        this.mPickerHolder = (FrameLayout) findViewById(R.id.picker_holder);
        TextView textView = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.mHourUnit = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_hour);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.mMinuteUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_min);
        }
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.mHourPicker = scrollTextView;
        scrollTextView.setData(new TimeAdapter(1), -1.0f, this.mCurrentHour, this.mIs24HourView.booleanValue() ? 24 : 12, this.mOneScreenCount, 0, this.mIs24HourView.booleanValue() ? 23 : 11, true);
        float f = (float) dimensionPixelOffset;
        this.mHourPicker.setSelectItemHeight(f);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.mMinutePicker = scrollTextView2;
        scrollTextView2.setData(new TimeAdapter(2), -1.0f, this.mCurrentMinute, 60, this.mOneScreenCount, 0, 59, true);
        this.mMinutePicker.setSelectItemHeight(f);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll_ampm);
        this.mAmPmPicker = scrollTextView3;
        scrollTextView3.setData(new TimeAdapter(3), -1.0f, this.mIsAm ^ true ? 1 : 0, 2, this.mOneScreenCount, 0, 1, false);
        this.mAmPmPicker.setTextSize(getContext().getResources().getDimension(R.dimen.mz_picker_selected_ampm_size), getContext().getResources().getDimension(R.dimen.mz_picker_unselected_ampm_size));
        this.mAmPmPicker.setSelectItemHeight(f);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column_ampm);
        if (this.mIs24HourView.booleanValue()) {
            frameLayout.setVisibility(8);
        } else {
            frameLayout.setVisibility(0);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll_month_text);
        this.mMonthUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_month);
        }
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll_day_text);
        this.mDayUnit = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_day);
        }
        Calendar instance = Calendar.getInstance();
        this.mYear = instance.get(1);
        this.mMonth = instance.get(2);
        this.mDay = instance.get(5);
        int actualMaximum = instance.getActualMaximum(5);
        DayPicker dayPicker = new DayPicker((ScrollTextView) findViewById(R.id.mc_scroll_day));
        this.mDayPicker = dayPicker;
        TimeAdapter timeAdapter = new TimeAdapter(5);
        int i2 = this.mDay;
        dayPicker.setData(timeAdapter, -1, i2 - 1, actualMaximum, this.mOneScreenCount, i2 - 1, actualMaximum - 1, true);
        this.mDayPicker.setSelectItemHeight(dimensionPixelOffset);
        MonthPicker monthPicker = new MonthPicker((ScrollTextView) findViewById(R.id.mc_scroll_month));
        this.mMonthPicker = monthPicker;
        monthPicker.setData((ScrollTextView.IDataAdapter) null, -1.0f, getMonthIndex(this.mMonth), 12, this.mOneScreenCount, 0, 11, false);
        this.mMonthPicker.setSelectItemHeight(dimensionPixelOffset);
        initTabView();
        setShowMarquee(this.isShowMarquee);
    }

    private void initTabView() {
        this.mLunarColor = getResources().getColor(R.color.mc_custom_date_picker_selected_lunar_color);
        this.mGregorianColor = getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color);
        this.mUnSlectColor = getResources().getColor(R.color.mc_custom_date_picker_unselected_color);
    }

    private boolean isInternational() {
        return !getResources().getConfiguration().locale.getCountry().equals(Constants.CHINA_COUNTRY) && !getResources().getConfiguration().locale.getCountry().equals(Constants.TW_COUNTRY) && !getResources().getConfiguration().locale.getCountry().equals("HK");
    }

    private void setTabColor(int i, boolean z, boolean z2) {
        getContext().getResources().getColor(R.color.mc_custom_date_picker_unselected_tab_color);
    }

    public int getCurrentHour() {
        return this.mIs24HourView.booleanValue() ? this.mCurrentHour : this.mIsAm ? this.mCurrentHour : this.mCurrentHour + 12;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mCurrentMinute);
    }

    public void getTime(int[] iArr) {
        if (this.isLunar) {
            int[] lunarToSolar = LunarCalendar.lunarToSolar(this.mYear, this.mMonth, this.mDay, false);
            iArr[0] = lunarToSolar[0];
            iArr[1] = lunarToSolar[1];
            iArr[2] = lunarToSolar[2];
        } else {
            iArr[0] = this.mYear;
            iArr[1] = this.mMonth;
            iArr[2] = this.mDay;
        }
        iArr[3] = getCurrentHour();
        iArr[4] = getCurrentMinute().intValue();
        iArr[5] = this.isLunar;
    }

    public long getTimeMillis() {
        int[] iArr = new int[6];
        getTime(iArr);
        Calendar instance = Calendar.getInstance();
        instance.set(iArr[0], iArr[1] - 1, iArr[2], iArr[3], iArr[4], 0);
        return instance.getTimeInMillis();
    }

    public boolean is24HourView() {
        return this.mIs24HourView.booleanValue();
    }

    public boolean isShowMarquee() {
        return this.isShowMarquee;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_select_h);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_picker_height);
        this.mMonthPicker.setSelectItemHeight(dimensionPixelSize2);
        this.mDayPicker.setSelectItemHeight(dimensionPixelSize2);
        float f = (float) dimensionPixelSize2;
        this.mHourPicker.setSelectItemHeight(f);
        this.mMinutePicker.setSelectItemHeight(f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPickerHolder.getLayoutParams();
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize3;
        this.mPickerHolder.setLayoutParams(layoutParams);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CustomTimePicker.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        updateTime(savedState.h, savedState.min, this.mIs24HourView.booleanValue());
        boolean z = true;
        updateDate(savedState.y, savedState.mon, savedState.d, savedState.lunar == 1, savedState.leapmonth == 1, false);
        int i = savedState.lunar == 1 ? this.mLunarColor : this.mGregorianColor;
        if (savedState.lunar != 1) {
            z = false;
        }
        setTabColor(i, z, false);
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.mCurrentMinute, this.mYear, this.mMonth, this.mDay, this.isLunar, this.isLeapMonth);
    }

    public void onWindowFocusChanged(boolean z) {
        int i;
        super.onWindowFocusChanged(z);
        if (z) {
            boolean booleanValue = this.mIs24HourView.booleanValue();
            try {
                booleanValue = DateFormat.is24HourFormat(getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (booleanValue != this.mIs24HourView.booleanValue()) {
                updateTime(getCurrentHour(), this.mCurrentMinute, booleanValue);
            }
            if (this.isLunar) {
                this.mMonthPicker.setTextSize(this.mLunarSelectTextSize, this.mLunarNormalTextSize);
                this.mDayPicker.setTextSize(this.mLunarSelectTextSize, this.mLunarNormalTextSize);
                this.mDayUnit.setAlpha(0.0f);
                i = this.mLunarColor;
                setTabColor(i, this.isLunar, false);
            } else {
                this.mMonthPicker.setTextSize(this.mSolarSelectTextSize, this.mSolarNormalTextSize);
                this.mDayPicker.setTextSize(this.mSolarSelectTextSize, this.mSolarNormalTextSize);
                this.mDayUnit.setAlpha(1.0f);
                i = this.mGregorianColor;
            }
            this.mMonthPicker.setTextColor(i, this.mUnSlectColor);
            this.mDayPicker.setTextColor(i, this.mUnSlectColor);
            this.mHourPicker.setTextColor(i, this.mUnSlectColor);
            this.mMinutePicker.setTextColor(i, this.mUnSlectColor);
            this.mAmPmPicker.setTextColor(i, this.mUnSlectColor);
            this.mMonthUnit.setTextColor(i);
            this.mDayUnit.setTextColor(i);
            this.mHourUnit.setTextColor(i);
            this.mMinuteUnit.setTextColor(i);
        }
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            updateTime(num.intValue(), this.mCurrentMinute, this.mIs24HourView.booleanValue());
        }
    }

    public void setCurrentMinute(Integer num) {
        updateTime(getCurrentHour(), num.intValue(), this.mIs24HourView.booleanValue());
    }

    public void setLunar(boolean z) {
        int[] iArr;
        doTabAnimate();
        int[] iArr2 = new int[2];
        int[] iArr3 = {this.mYear, this.mMonthPicker.getMonth(iArr2), this.mDayPicker.getCurrentItem() + 1, 0};
        if (z) {
            iArr = LunarCalendar.solarToLunar(iArr3[0], iArr3[1], iArr3[2]);
        } else {
            iArr = LunarCalendar.lunarToSolar(iArr3[0], iArr3[1], iArr3[2], iArr2[1] == 1);
        }
        updateDate(iArr[0], iArr[1], iArr[2], z, iArr2[1] == 1);
    }

    public void setShowMarquee(boolean z) {
        this.isShowMarquee = z;
        ScrollTextView scrollTextView = this.mHourPicker;
        if (scrollTextView != null) {
            scrollTextView.setShowMarquee(z);
        }
        ScrollTextView scrollTextView2 = this.mMinutePicker;
        if (scrollTextView2 != null) {
            scrollTextView2.setShowMarquee(z);
        }
        ScrollTextView scrollTextView3 = this.mAmPmPicker;
        if (scrollTextView3 != null) {
            scrollTextView3.setShowMarquee(z);
        }
        MonthPicker monthPicker = this.mMonthPicker;
        if (!(monthPicker == null || monthPicker.picker == null)) {
            this.mMonthPicker.picker.setShowMarquee(z);
        }
        DayPicker dayPicker = this.mDayPicker;
        if (dayPicker != null && dayPicker.picker != null) {
            this.mDayPicker.picker.setShowMarquee(z);
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mMonthPicker.setTextColor(i, i2);
        this.mDayPicker.setTextColor(i, i2);
        this.mHourPicker.setTextColor(i, i2);
        this.mMinutePicker.setTextColor(i, i2);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.setTextColor(i, i2);
        }
        this.mHourUnit.setTextColor(i3);
        this.mMinuteUnit.setTextColor(i3);
        this.mMonthUnit.setTextColor(i3);
        this.mDayUnit.setTextColor(i3);
    }

    public void updateDate(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.isLunar = z;
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mMonthPicker.setMonth(i, i2, i3, z2);
        if (this.mMonthOfDays != getMonthDays(this.mYear, this.mMonth, z)) {
            this.mMonthOfDays = getMonthDays(this.mYear, this.mMonth, z);
            this.mDayPicker.refreshCount(getMonthDays(this.mYear, this.mMonth, z));
        }
        this.mDayPicker.setCurrentItem(this.mDay - 1, z3);
        if (this.isLunar) {
            this.mMonthPicker.setTextSize(this.mLunarSelectTextSize, this.mLunarNormalTextSize);
            this.mDayPicker.setTextSize(this.mLunarSelectTextSize, this.mLunarNormalTextSize);
            this.mDayUnit.setAlpha(0.0f);
            return;
        }
        this.mMonthPicker.setTextSize(this.mSolarSelectTextSize, this.mSolarNormalTextSize);
        this.mDayPicker.setTextSize(this.mSolarSelectTextSize, this.mSolarNormalTextSize);
        this.mDayUnit.setAlpha(1.0f);
    }

    public void updateTime(int i, int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!z) {
            this.mIsAm = true;
            if (this.mCurrentHour != i) {
                this.mCurrentHour = i;
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = this.mCurrentHour;
            if (i3 >= 12) {
                this.mCurrentHour = i3 - 12;
                this.mIsAm = false;
            }
        } else if (this.mCurrentHour != i) {
            this.mCurrentHour = i;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mCurrentMinute != i2) {
            this.mCurrentMinute = i2;
            z3 = true;
        }
        if (z != this.mIs24HourView.booleanValue()) {
            this.mIs24HourView = Boolean.valueOf(z);
            inflateLayout();
        }
        if (z2) {
            this.mHourPicker.refreshCurrent(this.mCurrentHour);
        }
        if (z3) {
            this.mMinutePicker.refreshCurrent(this.mCurrentMinute);
        }
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.refreshCurrent(this.mIsAm ^ true ? 1 : 0);
        }
    }

    public void updateTimeMillis(long j, boolean z) {
        this.mCalendar.setTimeInMillis(j);
        updateTime(this.mCalendar.get(11), this.mCalendar.get(12), this.mIs24HourView.booleanValue());
        updateDate(this.mCalendar.get(1), this.mCalendar.get(2) + 1, this.mCalendar.get(5), false, false, z);
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
        /* access modifiers changed from: private */
        public final int d;
        /* access modifiers changed from: private */
        public final int h;
        /* access modifiers changed from: private */
        public final int leapmonth;
        /* access modifiers changed from: private */
        public final int lunar;
        /* access modifiers changed from: private */
        public final int min;
        /* access modifiers changed from: private */
        public final int mon;
        /* access modifiers changed from: private */
        public final int y;

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
            parcel.writeInt(this.min);
            parcel.writeInt(this.y);
            parcel.writeInt(this.mon);
            parcel.writeInt(this.d);
            parcel.writeInt(this.lunar);
            parcel.writeInt(this.leapmonth);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            super(parcelable);
            this.h = i;
            this.min = i2;
            this.y = i3;
            this.mon = i4;
            this.d = i5;
            this.lunar = z ? 1 : 0;
            this.leapmonth = z2 ? 1 : 0;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.h = parcel.readInt();
            this.min = parcel.readInt();
            this.y = parcel.readInt();
            this.mon = parcel.readInt();
            this.d = parcel.readInt();
            this.lunar = parcel.readInt();
            this.leapmonth = parcel.readInt();
        }
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.mCurrentHour = 0;
        this.mCurrentMinute = 0;
        this.mIs24HourView = Boolean.FALSE;
        this.mIsAm = true;
        this.isLunar = false;
        this.isLeapMonth = false;
        this.mMonthUpdateLock = new Object();
        this.mOneScreenCount = 5;
        this.isShowMarquee = true;
        Calendar instance = Calendar.getInstance();
        this.mCalendar = instance;
        try {
            this.mCurrentHour = instance.get(11);
            this.mCurrentMinute = instance.get(12);
            this.mIs24HourView = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.mCurrentHour = 12;
            this.mCurrentMinute = 30;
            this.mIs24HourView = Boolean.TRUE;
        }
        if (!this.mIs24HourView.booleanValue() && (i2 = this.mCurrentHour) >= 12) {
            this.mCurrentHour = i2 - 12;
            this.mIsAm = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        this.mLunarNormalTextSize = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_normal_word_size);
        this.mLunarSelectTextSize = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        this.mSolarNormalTextSize = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_normal_number_size);
        this.mSolarSelectTextSize = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        inflateLayout();
        setBackgroundColor(-1);
    }

    public void updateDate(int i, int i2, int i3, boolean z, boolean z2) {
        updateDate(i, i2, i3, z, z2, true);
    }
}
