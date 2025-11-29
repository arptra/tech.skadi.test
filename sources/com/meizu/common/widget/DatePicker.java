package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.DateTimeUtils;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class DatePicker extends FrameLayout {
    private static final int DEFAULT_END_YEAR = 2099;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final int NUMBER_OF_MONTHS = 12;
    /* access modifiers changed from: private */
    public boolean isLunar;
    private boolean isRTL;
    /* access modifiers changed from: private */
    public int mDay;
    /* access modifiers changed from: private */
    public ScrollTextView mDayPicker;
    private TextView mDayUnit;
    private Calendar mEndCal;
    private int mEndYear;
    String[] mGregorianDays;
    private boolean mIsAccessibilityEnable;
    private boolean mIsDrawLine;
    boolean mIsLayoutRtl;
    private int mLayoutResId;
    String mLeap;
    private TextView mLeapUnit;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mLunarMouths;
    String[] mLunardays;
    /* access modifiers changed from: private */
    public int mMonth;
    private volatile Locale mMonthLocale;
    /* access modifiers changed from: private */
    public int mMonthOfDays;
    /* access modifiers changed from: private */
    public ScrollTextView mMonthPicker;
    private TextView mMonthUnit;
    private Object mMonthUpdateLock;
    /* access modifiers changed from: private */
    public String[] mMonths;
    private float mNormalItemHeight;
    private List<Float> mNumberNormalTextSizes;
    private int mNumberSelectTextSize;
    private int mOldMonth;
    /* access modifiers changed from: private */
    public int mOldMonthIndex;
    private int mOldYear;
    /* access modifiers changed from: private */
    public OnDateChangedListener mOnDateChangedListener;
    private int mOneScreenCount;
    String mOrder;
    private LinearLayout mPickerHolder;
    private float mSelectItemHeight;
    private String[] mShortMonths;
    /* access modifiers changed from: private */
    public Calendar mStartCal;
    /* access modifiers changed from: private */
    public int mStartYear;
    private int mWidthPadding;
    private List<Float> mWordNormalTextSizes;
    private int mWordSelectTextSize;
    /* access modifiers changed from: private */
    public int mYear;
    /* access modifiers changed from: private */
    public int mYearOfMonths;
    /* access modifiers changed from: private */
    public ScrollTextView mYearPicker;
    private TextView mYearUnit;

    public class DateAdapter implements ScrollTextView.IDataAdapter {
        static final int SET_DAY = 3;
        static final int SET_MONTH = 2;
        static final int SET_YEAR = 1;
        int mType;

        public DateAdapter(int i) {
            this.mType = i;
        }

        public String getItemText(int i) {
            int i2 = this.mType;
            if (i2 == 1) {
                return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i + DatePicker.this.mStartYear)});
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                if (DatePicker.this.isLunar) {
                    return DatePicker.this.getLunarDays(i);
                }
                if (DatePicker.this.mStartCal == null || DatePicker.this.mStartCal.get(1) != DatePicker.this.mYear || DatePicker.this.mStartCal.get(2) != DatePicker.this.mMonth) {
                    return DatePicker.this.mGregorianDays[i + 1];
                }
                DatePicker datePicker = DatePicker.this;
                return datePicker.mGregorianDays[i + datePicker.mStartCal.get(5)];
            } else if (DatePicker.this.isLunar) {
                return DatePicker.this.getLunarMonths(i);
            } else {
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear) {
                    i += DatePicker.this.mStartCal.get(2);
                }
                if (i < DatePicker.this.mMonths.length) {
                    return DatePicker.this.mMonths[i];
                }
                return null;
            }
        }

        public void onChanged(View view, int i, int i2) {
            int access$700 = DatePicker.this.getMonthDays();
            int unused = DatePicker.this.getYearMonths();
            int i3 = this.mType;
            if (i3 == 1) {
                int access$400 = DatePicker.this.mYear;
                DatePicker datePicker = DatePicker.this;
                int unused2 = datePicker.mYear = i2 + datePicker.mStartYear;
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear && DatePicker.this.mMonth < DatePicker.this.mStartCal.get(2)) {
                    DatePicker datePicker2 = DatePicker.this;
                    int unused3 = datePicker2.mMonth = datePicker2.mStartCal.get(2);
                }
                if (DatePicker.this.mMonthPicker != null) {
                    int access$800 = DatePicker.this.getYearMonths();
                    if (DatePicker.this.isLunar) {
                        int leapMonth = LunarCalendar.leapMonth(access$400);
                        int leapMonth2 = LunarCalendar.leapMonth(DatePicker.this.mYear);
                        DatePicker datePicker3 = DatePicker.this;
                        int access$1100 = datePicker3.getMonthOffset(leapMonth, leapMonth2, datePicker3.mOldMonthIndex);
                        int unused4 = DatePicker.this.mYearOfMonths = access$800;
                        DatePicker.this.mMonthPicker.refreshCount(access$800, access$1100);
                        DatePicker datePicker4 = DatePicker.this;
                        int unused5 = datePicker4.mMonth = datePicker4.mMonthPicker.getCurrentItem();
                    } else {
                        int unused6 = DatePicker.this.mYearOfMonths = access$800;
                        DatePicker.this.mMonthPicker.refreshCount(access$800);
                    }
                    int i4 = access$800 - 1;
                    if (i4 < DatePicker.this.mMonth) {
                        int unused7 = DatePicker.this.mDay = access$700;
                        int unused8 = DatePicker.this.mMonth = i4;
                        DatePicker.this.mMonthPicker.setCurrentItem(DatePicker.this.mMonth, true);
                    }
                }
                if (!(access$700 == DatePicker.this.getMonthDays() || DatePicker.this.mDayPicker == null)) {
                    int access$7002 = DatePicker.this.getMonthDays();
                    int unused9 = DatePicker.this.mMonthOfDays = access$7002;
                    DatePicker.this.mDayPicker.refreshCount(access$7002);
                    if (access$7002 < DatePicker.this.mDay) {
                        int unused10 = DatePicker.this.mDay = access$7002;
                        DatePicker.this.mDayPicker.setCurrentItem(DatePicker.this.mDay - 1, true);
                    }
                }
            } else if (i3 == 2) {
                int unused11 = DatePicker.this.mMonth = i2;
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear) {
                    DatePicker datePicker5 = DatePicker.this;
                    DatePicker.access$612(datePicker5, datePicker5.mStartCal.get(2));
                }
                if (!(access$700 == DatePicker.this.getMonthDays() || DatePicker.this.mDayPicker == null)) {
                    int access$7003 = DatePicker.this.getMonthDays();
                    int unused12 = DatePicker.this.mMonthOfDays = access$7003;
                    DatePicker.this.mDayPicker.refreshCount(access$7003);
                    if (access$7003 < DatePicker.this.mDay) {
                        int unused13 = DatePicker.this.mDay = access$7003;
                        DatePicker.this.mDayPicker.setCurrentItem(DatePicker.this.mDay - 1, true);
                    }
                }
            } else if (i3 == 3) {
                if (DatePicker.this.mDayPicker.getVisibility() != 8) {
                    int unused14 = DatePicker.this.mDay = i2 + 1;
                    if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear && DatePicker.this.mStartCal.get(2) == DatePicker.this.mMonth) {
                        DatePicker datePicker6 = DatePicker.this;
                        int unused15 = datePicker6.mDay = i2 + datePicker6.mStartCal.get(5);
                    }
                }
            } else {
                return;
            }
            DatePicker datePicker7 = DatePicker.this;
            datePicker7.setDayRange(datePicker7.mMonth);
            DatePicker datePicker8 = DatePicker.this;
            datePicker8.setMonthRange(datePicker8.mYear);
            if (DatePicker.this.mOnDateChangedListener != null) {
                OnDateChangedListener access$1800 = DatePicker.this.mOnDateChangedListener;
                DatePicker datePicker9 = DatePicker.this;
                access$1800.onDateChanged(datePicker9, datePicker9.mYear, DatePicker.this.mMonth, DatePicker.this.mDay);
            }
            int i5 = this.mType;
            if (i5 == 1 || i5 == 2) {
                DatePicker datePicker10 = DatePicker.this;
                datePicker10.setLeapUnitVisibility(datePicker10.mMonth);
            }
            if (DatePicker.this.mMonthPicker != null) {
                DatePicker datePicker11 = DatePicker.this;
                int unused16 = datePicker11.mOldMonthIndex = datePicker11.mMonthPicker.getCurrentItem();
            }
            DatePicker.this.sendAccessibilityEvents(this.mType);
        }
    }

    public interface OnDateChangedListener {
        void onDateChanged(DatePicker datePicker, int i, int i2, int i3);
    }

    public DatePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int access$612(DatePicker datePicker, int i) {
        int i2 = datePicker.mMonth + i;
        datePicker.mMonth = i2;
        return i2;
    }

    private void adjustLayout4FocusedPosition() {
        TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
        this.mMonthUnit = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.mDayUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.mYearUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_year);
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
    public String getLunarMonths(int i) {
        int leapMonth = LunarCalendar.leapMonth(this.mYear);
        if (leapMonth == 0) {
            if (i >= 12) {
                return null;
            }
        } else if (i >= 13) {
            return null;
        }
        return (leapMonth == 0 || i <= leapMonth + -1) ? this.mLunarMouths[i] : i == leapMonth ? this.mLunarMouths[i - 1] : this.mLunarMouths[i - 1];
    }

    /* access modifiers changed from: private */
    public int getMonthDays() {
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

    /* access modifiers changed from: private */
    public int getMonthOffset(int i, int i2, int i3) {
        if (i > i2 && i2 == 0 && i3 >= i) {
            return -1;
        }
        if (i >= i2 || i != 0 || i3 < i2) {
            if (i < i2 && i != 0 && i <= i3 && i2 > i3) {
                return -1;
            }
            if (i <= i2 || i2 == 0 || i <= i3 || i2 > i3) {
                return 0;
            }
        }
        return 1;
    }

    private String[] getShortMonths() {
        Locale locale = Locale.getDefault();
        int i = 0;
        if (!locale.equals(this.mMonthLocale) || this.mShortMonths == null) {
            synchronized (this.mMonthUpdateLock) {
                try {
                    if (!locale.equals(this.mMonthLocale)) {
                        this.mShortMonths = new String[12];
                        for (int i2 = 0; i2 < 12; i2++) {
                            this.mShortMonths[i2] = DateUtils.getMonthString(i2, 20);
                        }
                        if (this.mShortMonths[0].startsWith("1")) {
                            int i3 = 0;
                            while (true) {
                                String[] strArr = this.mShortMonths;
                                if (i3 >= strArr.length) {
                                    break;
                                }
                                int i4 = i3 + 1;
                                strArr[i3] = String.valueOf(i4);
                                if (i3 < 9) {
                                    this.mShortMonths[i3] = "0" + this.mShortMonths[i3];
                                }
                                i3 = i4;
                            }
                        }
                        this.mMonthLocale = locale;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        ScrollTextView scrollTextView = this.mMonthPicker;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.mShortMonths != null) {
            while (true) {
                String[] strArr2 = this.mShortMonths;
                if (i >= strArr2.length) {
                    break;
                } else if (this.mMonthPicker.measureTextWidth(strArr2[i]) > this.mMonthPicker.getWidth()) {
                    this.mShortMonths = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                } else {
                    i++;
                }
            }
        }
        return this.mShortMonths;
    }

    private String getTimeText(int i) {
        if (i == 1) {
            return String.valueOf(this.mYear);
        }
        if (i == 2) {
            int i2 = this.mMonth;
            if (this.isLunar) {
                return getLunarMonths(i2);
            }
            if (this.mMonths == null) {
                this.mMonths = getShortMonths();
            }
            String[] strArr = this.mMonths;
            return i2 < strArr.length ? strArr[i2] : "";
        } else if (i != 3) {
            return "";
        } else {
            int i3 = this.mDay;
            return this.isLunar ? getLunarDays(i3 - 1) : String.valueOf(i3);
        }
    }

    /* access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.isLunar || LunarCalendar.leapMonth(this.mYear) == 0) ? 12 : 13;
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

    private boolean isZh() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private void refreshTextPreference() {
        if (!this.isLunar || !isZh()) {
            this.mMonthPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
            this.mDayPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        } else {
            this.mMonthPicker.setTextSize((float) this.mWordSelectTextSize, this.mWordNormalTextSizes);
            this.mDayPicker.setTextSize((float) this.mWordSelectTextSize, this.mWordNormalTextSizes);
        }
        this.mYearPicker.setTextSize((float) this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
    }

    private void reorderPickers(String[] strArr) {
        boolean z;
        boolean z2;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.mOrder = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.mOrder = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R.id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.mOrder.contentEquals("dd‏/MM‏/y") || this.mOrder.contentEquals("d בMMM y")) {
            this.mOrder = "yy/M/d";
        }
        if (this.isRTL) {
            this.mOrder = "d/M/yy";
        }
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (i < this.mOrder.length()) {
            char charAt = this.mOrder.charAt(i);
            if (charAt == '\'') {
                z5 = !z5;
            }
            if (!z5) {
                z = z5;
                if (charAt == 'd' && !z4) {
                    linearLayout.addView(frameLayout2);
                    z2 = true;
                    z4 = true;
                } else if ((charAt == 'M' || charAt == 'L') && !z3) {
                    linearLayout.addView(frameLayout);
                    z2 = true;
                    z3 = true;
                } else if (charAt != 'y' || z6) {
                    z2 = false;
                } else {
                    linearLayout.addView(frameLayout3);
                    z2 = true;
                    z6 = true;
                }
                if (true == z2) {
                    if (!z7) {
                        linearLayout.addView(imageView);
                        z7 = true;
                    } else if (!z8) {
                        linearLayout.addView(imageView2);
                        z8 = true;
                    }
                }
            } else {
                z = z5;
            }
            i++;
            z5 = z;
        }
        if (!z3) {
            linearLayout.addView(frameLayout);
        }
        if (!z4) {
            linearLayout.addView(frameLayout2);
        }
        if (!z6) {
            linearLayout.addView(frameLayout3);
        }
        if (!isZh()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.mYearPicker.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
                if (com.meizu.common.widget.DatePicker.access$2100(r2.this$0).getLayoutDirection() == 1) goto L_0x0017;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r2 = this;
                    com.meizu.common.widget.DatePicker r0 = com.meizu.common.widget.DatePicker.this
                    com.meizu.common.widget.ScrollTextView r1 = r0.mYearPicker
                    if (r1 == 0) goto L_0x0016
                    com.meizu.common.widget.DatePicker r2 = com.meizu.common.widget.DatePicker.this
                    com.meizu.common.widget.ScrollTextView r2 = r2.mYearPicker
                    int r2 = r2.getLayoutDirection()
                    r1 = 1
                    if (r2 != r1) goto L_0x0016
                    goto L_0x0017
                L_0x0016:
                    r1 = 0
                L_0x0017:
                    r0.mIsLayoutRtl = r1
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.DatePicker.AnonymousClass4.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvents(int i) {
        View findViewById;
        if (this.mIsAccessibilityEnable) {
            setContentDescription();
            if (i == 1) {
                View findViewById2 = findViewById(R.id.mc_column3Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 2) {
                View findViewById3 = findViewById(R.id.mc_column1Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 3 && (findViewById = findViewById(R.id.mc_column2Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    private void setContentDescription() {
        String str;
        if (this.mIsAccessibilityEnable) {
            View findViewById = findViewById(R.id.mc_column3Layout);
            View findViewById2 = findViewById(R.id.mc_column1Layout);
            View findViewById3 = findViewById(R.id.mc_column2Layout);
            if (findViewById3 == null || findViewById3.getVisibility() != 8) {
                str = (getTimeText(1) + this.mYearUnit.getText() + getTimeText(2) + this.mMonthUnit.getText() + getTimeText(3) + this.mDayUnit.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                str = (getTimeText(1) + this.mYearUnit.getText() + getTimeText(2) + this.mMonthUnit.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            }
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置年，当前日期是" + str);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置月，当前日期是" + str);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置日，当前日期是" + str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r1 == r9.mStartCal.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
        if (r1 == r9.mEndCal.getActualMaximum(5)) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0119, code lost:
        if (r1 == r9.mEndCal.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014e, code lost:
        if (r1 == r9.mStartCal.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017c, code lost:
        if (r1 == r9.mEndCal.getActualMaximum(5)) goto L_0x017e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0189 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDayRange(int r10) {
        /*
            r9 = this;
            java.util.Calendar r0 = r9.mStartCal
            if (r0 == 0) goto L_0x0195
            java.util.Calendar r0 = r9.mEndCal
            if (r0 != 0) goto L_0x000a
            goto L_0x0195
        L_0x000a:
            int r0 = r9.mOldYear
            int r1 = r9.mYear
            if (r0 != r1) goto L_0x0015
            int r0 = r9.mOldMonth
            if (r0 != r10) goto L_0x0015
            return
        L_0x0015:
            r9.mOldMonth = r10
            java.util.Calendar r0 = r9.getCurrentCalendar()
            int r1 = r9.getMonthDays()
            int r2 = r9.mDay
            r3 = 1
            int r2 = r2 - r3
            r4 = 5
            int r0 = r0.getActualMaximum(r4)
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            r7 = 2
            r8 = 0
            if (r5 != r6) goto L_0x0077
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            if (r5 == r6) goto L_0x0077
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x0052
            r2 = r8
            goto L_0x005a
        L_0x0052:
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x005a:
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.getActualMaximum(r4)
            java.util.Calendar r0 = r9.mStartCal
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
        L_0x0071:
            r10 = r3
            goto L_0x0074
        L_0x0073:
            r10 = r8
        L_0x0074:
            r0 = r1
            goto L_0x017f
        L_0x0077:
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            if (r5 == r6) goto L_0x00bc
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            if (r5 != r6) goto L_0x00bc
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.get(r4)
            if (r2 < r10) goto L_0x00a3
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.get(r4)
            int r2 = r10 + -1
        L_0x00a3:
            java.util.Calendar r10 = r9.mEndCal
            int r1 = r10.get(r4)
            java.util.Calendar r10 = r9.mEndCal
            int r0 = r10.get(r4)
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x00b9
            goto L_0x017e
        L_0x00b9:
            r10 = r8
            goto L_0x017f
        L_0x00bc:
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            if (r5 != r6) goto L_0x017e
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r3)
            int r6 = r9.mYear
            if (r5 != r6) goto L_0x017e
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r7)
            if (r5 > r10) goto L_0x017e
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r7)
            if (r5 < r10) goto L_0x017e
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x011d
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x011d
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x00fc
            r2 = r8
            goto L_0x0104
        L_0x00fc:
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x0104:
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.get(r4)
            java.util.Calendar r0 = r9.mStartCal
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
            goto L_0x0071
        L_0x011d:
            java.util.Calendar r5 = r9.mStartCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x0152
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x0131
            r2 = r8
            goto L_0x0139
        L_0x0131:
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x0139:
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.getActualMaximum(r4)
            java.util.Calendar r0 = r9.mStartCal
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.mStartCal
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
            goto L_0x0071
        L_0x0152:
            java.util.Calendar r5 = r9.mEndCal
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.get(r4)
            if (r2 < r10) goto L_0x016a
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.get(r4)
            int r2 = r10 + -1
        L_0x016a:
            java.util.Calendar r10 = r9.mEndCal
            int r1 = r10.get(r4)
            java.util.Calendar r10 = r9.mEndCal
            int r0 = r10.get(r4)
            java.util.Calendar r10 = r9.mEndCal
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x00b9
        L_0x017e:
            r10 = r3
        L_0x017f:
            if (r10 == 0) goto L_0x018a
            com.meizu.common.widget.ScrollTextView r4 = r9.mDayPicker
            boolean r4 = r4.isCyclic()
            if (r4 == 0) goto L_0x018a
            return
        L_0x018a:
            com.meizu.common.widget.ScrollTextView r4 = r9.mDayPicker
            r4.setCyclic(r10)
            com.meizu.common.widget.ScrollTextView r9 = r9.mDayPicker
            int r0 = r0 - r3
            r9.refreshData(r1, r2, r8, r0)
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.DatePicker.setDayRange(int):void");
    }

    /* access modifiers changed from: private */
    public void setLeapUnitVisibility(int i) {
        if (!isLunar() || !isLeapMonth(i)) {
            this.mLeapUnit.setVisibility(8);
        } else {
            this.mLeapUnit.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void setMonthRange(int i) {
        int i2;
        boolean z;
        int i3;
        Calendar calendar = this.mStartCal;
        if (calendar != null && this.mEndCal != null && this.mOldYear != i) {
            this.mOldYear = i;
            this.mOldMonth = -1;
            boolean z2 = true;
            if (calendar.get(1) <= i && this.mEndCal.get(1) >= i) {
                int i4 = this.mMonth - this.mStartCal.get(2) < 0 ? 0 : this.mMonth - this.mStartCal.get(2);
                int leapMonth = LunarCalendar.leapMonth(i);
                if (this.mStartCal.get(1) == i && this.mEndCal.get(1) == i) {
                    i2 = (this.mEndCal.get(2) - this.mStartCal.get(2)) + 1;
                } else if (this.mStartCal.get(1) == i) {
                    i2 = (this.mStartCal.getActualMaximum(2) + 1) - this.mStartCal.get(2);
                    if (this.isLunar && leapMonth > 0 && leapMonth < i2) {
                        i2++;
                    }
                } else if (this.mEndCal.get(1) == i) {
                    int i5 = this.mEndCal.get(2);
                    int i6 = this.mMonth;
                    if (i5 - i6 < 0) {
                        i6 = 0;
                    }
                    int i7 = this.mEndCal.get(2);
                    int i8 = i7 + 1;
                    i2 = (!this.isLunar || leapMonth <= 0 || leapMonth >= i8) ? i8 : i7 + 2;
                    i3 = i2 - 1;
                    z = false;
                    if ((this.isLunar || i2 != this.mStartCal.getActualMaximum(2) + 1) && ((!this.isLunar || leapMonth <= 0 || i2 != this.mStartCal.getActualMaximum(2) + 2) && !(this.isLunar && leapMonth == 0 && i2 == this.mStartCal.getActualMaximum(2) + 1))) {
                        z2 = z;
                    }
                    this.mMonthPicker.setCyclic(z2);
                    this.mMonthPicker.refreshData(i2, i4, 0, i3);
                } else if (!this.mMonthPicker.isCyclic()) {
                    i4 = this.mMonth;
                    i2 = this.mStartCal.getActualMaximum(2) + 1;
                    i3 = this.mStartCal.getActualMaximum(2);
                    z = true;
                    z2 = z;
                    this.mMonthPicker.setCyclic(z2);
                    this.mMonthPicker.refreshData(i2, i4, 0, i3);
                } else {
                    return;
                }
                i3 = i2;
                z = false;
                z2 = z;
                this.mMonthPicker.setCyclic(z2);
                this.mMonthPicker.refreshData(i2, i4, 0, i3);
            }
        }
    }

    private void updateYearPicker() {
        ScrollTextView scrollTextView = this.mYearPicker;
        DateAdapter dateAdapter = new DateAdapter(1);
        int i = this.mYear;
        int i2 = this.mStartYear;
        int i3 = this.mEndYear;
        scrollTextView.setData(dateAdapter, -1.0f, i - i2, (i3 - i2) + 1, this.mOneScreenCount, 0, i3 - i2, false);
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getDayOfMonth() {
        return this.mDay;
    }

    public TextView getDayUnit() {
        return this.mDayUnit;
    }

    public String getLunarDays(int i) {
        String[] strArr = this.mLunardays;
        if (i > strArr.length - 1) {
            return null;
        }
        return strArr[i];
    }

    public int getMonth() {
        return this.mMonth;
    }

    public String getTimePreviewText(boolean z, int i, int i2, int i3, boolean z2) {
        boolean z3;
        String str;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int i7 = i5 + 1;
        String string = getResources().getString(R.string.mc_date_time_year);
        String string2 = getResources().getString(R.string.mc_date_time_month);
        String string3 = getResources().getString(R.string.mc_date_time_day);
        if (z) {
            int leapMonth = LunarCalendar.leapMonth(i);
            String[] stringArray = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
            String string4 = getResources().getString(R.string.mc_time_picker_leap);
            if (leapMonth == 0 || i7 <= leapMonth) {
                if (i5 >= stringArray.length) {
                    i7 = stringArray.length - 1;
                }
                if (i7 - 1 < 0) {
                    i7 = 1;
                }
                z3 = false;
                int i8 = i7;
                str = stringArray[i7 - 1];
                i5 = i8;
            } else if (i5 == leapMonth) {
                str = string4 + stringArray[i5 - 1];
                z3 = true;
            } else {
                str = stringArray[i5 - 1];
                z3 = false;
            }
            int[] lunarToSolar = LunarCalendar.lunarToSolar(i4, i5, i6, z3);
            if (isZh()) {
                if (z2) {
                    return i4 + string + str + string2 + getLunarDays(i6 - 1) + " " + DateTimeUtils.getWeek(getContext(), lunarToSolar[0], lunarToSolar[1] - 1, lunarToSolar[2]);
                }
                return i4 + string + str + string2;
            } else if (i5 <= 0 || i5 > stringArray.length) {
                return "";
            } else {
                if (z2) {
                    return DateTimeUtils.getWeek(getContext(), lunarToSolar[0], lunarToSolar[1] - 1, lunarToSolar[2]) + ", " + str + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)}) + ", " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
                }
                return str + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
            }
        } else if (!isZh()) {
            String[] stringArray2 = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
            if (i7 <= 0 || i7 > stringArray2.length) {
                return "";
            }
            if (!z2) {
                return stringArray2[i5] + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
            } else if (this.isRTL) {
                return stringArray2[i5] + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)}) + ", " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}) + " " + DateTimeUtils.getWeek(getContext(), i4, i5, i6);
            } else {
                return DateTimeUtils.getWeek(getContext(), i4, i5, i6) + ", " + stringArray2[i5] + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)}) + ", " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
            }
        } else if (z2) {
            return i4 + string + i7 + string2 + i6 + string3 + " " + DateTimeUtils.getWeek(getContext(), i4, i5, i6);
        } else {
            return i4 + string + i7 + string2;
        }
    }

    public int getYear() {
        return this.mYear;
    }

    public void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener, boolean z) {
        if (!(this.mYear == i && this.mMonth == i2 && this.mDay == i3)) {
            updateDate(i, i2, i3, z);
        }
        this.mOnDateChangedListener = onDateChangedListener;
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
        if (z) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.mMonths = shortMonths;
            if (!this.mOrder.equals(pattern)) {
                reorderPickers(this.mMonths);
            }
        }
    }

    public void refresh() {
        updateYearPicker();
        this.mOldYear = -1;
        setMonthRange(this.mYear);
        this.mOldMonth = -1;
        setDayRange(this.mMonth);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mDayPicker.setEnabled(z);
        this.mMonthPicker.setEnabled(z);
        this.mYearPicker.setEnabled(z);
    }

    public void setIsDrawFading(boolean z) {
        this.mYearPicker.setIsDrawFading(z);
        this.mMonthPicker.setIsDrawFading(z);
        this.mDayPicker.setIsDrawFading(z);
    }

    public void setIsDrawLine(boolean z) {
        this.mIsDrawLine = z;
    }

    public void setItemHeight(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        this.mDayPicker.setItemHeight(f, f2);
        this.mMonthPicker.setItemHeight(f, f2);
        this.mYearPicker.setItemHeight(f, f2);
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
        if (this.isLunar != z) {
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
                this.mDayUnit.setAlpha(0.0f);
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
                    this.mDayUnit.setAlpha(1.0f);
                    iArr = LunarCalendar.lunarToSolar(iArr2[0], i, iArr2[2], z3);
                }
                z3 = false;
                this.mDayUnit.setAlpha(1.0f);
                iArr = LunarCalendar.lunarToSolar(iArr2[0], i, iArr2[2], z3);
            }
            refreshTextPreference();
            int i6 = iArr[0];
            int i7 = iArr[1];
            updateDate(i6, i7 + -1 < 0 ? 12 : i7 - 1, iArr[2], z2, false);
            setLeapUnitVisibility(this.mMonth);
        }
    }

    public void setMaxDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        this.mEndCal = instance;
        this.mEndYear = instance.get(1);
        refresh();
    }

    public void setMinDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        this.mStartCal = instance;
        this.mStartYear = instance.get(1);
        refresh();
    }

    public void setShowDayColumn(boolean z) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column2Layout);
        if (frameLayout != null) {
            int i = 8;
            frameLayout.setVisibility(z ? 0 : 8);
            setContentDescription();
            ScrollTextView scrollTextView = this.mDayPicker;
            if (z) {
                i = 0;
            }
            scrollTextView.setVisibility(i);
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mDayPicker.setTextColor(i, i2);
        this.mMonthPicker.setTextColor(i, i2);
        this.mYearPicker.setTextColor(i, i2);
        this.mDayUnit.setTextColor(i3);
        this.mMonthUnit.setTextColor(i3);
        this.mYearUnit.setTextColor(i3);
    }

    public void updateDate(int i, int i2, int i3) {
        updateDate(i, i2, i3, true);
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

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void updateDate(int i, int i2, int i3, boolean z) {
        updateDate(i, i2, i3, z, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.isLunar = false;
        this.mMonthUpdateLock = new Object();
        this.mOneScreenCount = 5;
        this.mLayoutResId = R.layout.mc_date_picker;
        this.mIsAccessibilityEnable = false;
        this.mIsLayoutRtl = false;
        this.isRTL = false;
        this.mOldMonthIndex = 0;
        this.isRTL = context.getResources().getConfiguration().getLayoutDirection() == 1;
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
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.DatePicker);
        this.mStartYear = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcStartYear, DEFAULT_START_YEAR);
        this.mEndYear = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcEndYear, 2099);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.DatePicker_mcInternalLayout, this.mLayoutResId);
        this.mOneScreenCount = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcVisibleRow, this.mOneScreenCount);
        this.mSelectItemHeight = obtainStyledAttributes.getDimension(R.styleable.DatePicker_mcSelectItemHeight, this.mSelectItemHeight);
        this.mNormalItemHeight = obtainStyledAttributes.getDimension(R.styleable.DatePicker_mcNormalItemHeight, this.mNormalItemHeight);
        obtainStyledAttributes.recycle();
        View.inflate(getContext(), this.mLayoutResId, this);
        this.mLeapUnit = (TextView) findViewById(R.id.mc_leap);
        TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
        this.mMonthUnit = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.mDayUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.mYearUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_year);
        }
        Calendar instance = Calendar.getInstance();
        this.mYear = instance.get(1);
        this.mMonth = instance.get(2);
        this.mDay = instance.get(5);
        this.mOnDateChangedListener = null;
        int actualMaximum = instance.getActualMaximum(5);
        this.mPickerHolder = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll2);
        this.mDayPicker = scrollTextView;
        float f = this.mSelectItemHeight;
        if (f != 0.0f) {
            float f2 = this.mNormalItemHeight;
            if (f2 != 0.0f) {
                scrollTextView.setItemHeight((float) ((int) f), (float) ((int) f2));
            }
        }
        this.mDayPicker.setData(new DateAdapter(3), -1.0f, this.mDay - 1, actualMaximum, this.mOneScreenCount, 0, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll1);
        this.mMonthPicker = scrollTextView2;
        float f3 = this.mSelectItemHeight;
        if (f3 != 0.0f) {
            float f4 = this.mNormalItemHeight;
            if (f4 != 0.0f) {
                scrollTextView2.setItemHeight((float) ((int) f3), (float) ((int) f4));
            }
        }
        this.mMonths = getShortMonths();
        this.mMonthPicker.setData(new DateAdapter(2), -1.0f, this.mMonth, 12, this.mOneScreenCount, 0, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
        this.mYearPicker = scrollTextView3;
        float f5 = this.mSelectItemHeight;
        if (f5 != 0.0f) {
            float f6 = this.mNormalItemHeight;
            if (f6 != 0.0f) {
                scrollTextView3.setItemHeight((float) ((int) f5), (float) ((int) f6));
            }
        }
        refreshTextPreference();
        updateYearPicker();
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
        reorderPickers(this.mMonths);
        boolean isZh = isZh();
        this.mDayUnit.setVisibility(isZh ? 0 : 8);
        this.mMonthUnit.setVisibility(isZh ? 0 : 8);
        this.mYearUnit.setVisibility(isZh ? 0 : 8);
        adjustLayout4FocusedPosition();
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(R.styleable.MZTheme);
        int i2 = obtainStyledAttributes2.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes2.recycle();
        this.mLinePaint.setColor(i2);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mLunarMouths = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.mLunardays = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        String format = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{0});
        this.mGregorianDays = new String[100];
        for (int i3 = 0; i3 < 100; i3++) {
            this.mGregorianDays[i3] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)});
            if (i3 <= 9) {
                String[] strArr = this.mGregorianDays;
                strArr[i3] = format + this.mGregorianDays[i3];
            }
        }
        String string = getResources().getString(R.string.mc_time_picker_leap);
        this.mLeap = string;
        this.mLeapUnit.setText(string);
        this.mLeapUnit.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.mYearPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }

                public void onScrollingStarted(ScrollTextView scrollTextView) {
                }
            });
            this.mMonthPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }

                public void onScrollingStarted(ScrollTextView scrollTextView) {
                }
            });
            this.mDayPicker.addScrollingListener(new ScrollTextView.OnScrollTextViewScrollListener() {
                public void onScrollingFinished(ScrollTextView scrollTextView) {
                    DatePicker.this.setIsDrawFading(true);
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

    private void updateDate(int i, int i2, int i3, boolean z, boolean z2) {
        int i4 = this.mStartYear;
        if (i >= i4) {
            i4 = i;
        }
        this.mYear = i4;
        int i5 = this.mEndYear;
        if (i > i5) {
            i = i5;
        }
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mMonths = null;
        this.mMonths = getShortMonths();
        this.mYearPicker.stopScrolling();
        this.mMonthPicker.stopScrolling();
        this.mDayPicker.stopScrolling();
        if (this.mYearOfMonths != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.mYearOfMonths = yearMonths;
            this.mMonthPicker.refreshCount(yearMonths);
        }
        if (this.mMonthOfDays != getMonthDays()) {
            this.mMonthOfDays = getMonthDays();
            this.mDayPicker.refreshCount(getMonthDays());
        }
        if (z) {
            this.mYearPicker.setCurrentItem(this.mYear - this.mStartYear, true);
            this.mMonth = i2;
            this.mMonthPicker.setCurrentItem(i2, true);
            this.mDayPicker.setCurrentItem(this.mDay - 1, true);
        } else {
            this.mYearPicker.refreshCurrent(this.mYear - this.mStartYear);
            this.mMonth = i2;
            this.mMonthPicker.refreshCurrent(i2);
            this.mDayPicker.refreshCurrent(this.mDay - 1);
        }
        if (z2) {
            reorderPickers(this.mMonths);
        }
    }

    public void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener, boolean z, boolean z2) {
        if (!(this.mYear == i && this.mMonth == i2 && this.mDay == i3 && this.isLunar == z)) {
            if (z) {
                this.isLunar = z;
                this.mDayUnit.setAlpha(0.0f);
                int leapMonth = LunarCalendar.leapMonth(i);
                if (!(leapMonth == 0 || i2 + 1 == leapMonth)) {
                    z2 = false;
                }
                if (leapMonth != 0 && (z2 || i2 > leapMonth)) {
                    i2++;
                }
                updateDate(i, i2, i3, false);
            } else {
                updateDate(i, i2, i3, false);
            }
        }
        refreshTextPreference();
        this.mOnDateChangedListener = onDateChangedListener;
        setContentDescription();
    }

    public void setTextColor(int i, List<Integer> list, int i2) {
        this.mDayPicker.setTextColor(i, list);
        this.mMonthPicker.setTextColor(i, list);
        this.mYearPicker.setTextColor(i, list);
        this.mDayUnit.setTextColor(i2);
        this.mMonthUnit.setTextColor(i2);
        this.mYearUnit.setTextColor(i2);
    }

    public void setLunar(boolean z) {
        setLunar(z, true);
    }
}
