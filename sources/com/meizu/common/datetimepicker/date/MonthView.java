package com.meizu.common.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.meizu.common.R;
import com.meizu.common.datetimepicker.Utils;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.widget.DatePickerNativeDialog;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public abstract class MonthView extends View {
    protected static int DAY_SEPARATOR_WIDTH = 1;
    protected static int DEFAULT_HEIGHT = 32;
    protected static final int DEFAULT_NUM_DAYS = 7;
    protected static final int DEFAULT_NUM_ROWS = 6;
    protected static final int DEFAULT_SELECTED_DAY = -1;
    protected static final int DEFAULT_WEEK_START = 1;
    protected static final int MAX_NUM_ROWS = 6;
    protected static int MINI_DAY_NUMBER_TEXT_SIZE = 0;
    protected static int MONTH_DAY_LABEL_TEXT_SIZE = 0;
    private static final String TAG = "MonthView";
    public static final String VIEW_PARAMS_EVENT_REMIND = "event_remind";
    public static final String VIEW_PARAMS_HEIGHT = "height";
    public static final String VIEW_PARAMS_MONTH = "month";
    public static final String VIEW_PARAMS_PAINT_ALPHA = "paint_alpha";
    public static final String VIEW_PARAMS_SELECTED_DAY = "selected_day";
    public static final String VIEW_PARAMS_WEEK_START = "week_start";
    public static final String VIEW_PARAMS_WIDTH = "width";
    public static final String VIEW_PARAMS_YEAR = "year";
    protected boolean isRTL;
    protected int mBgMarginTop;
    protected int mBgPaddingLeftRight;
    private final Calendar mCalendar;
    protected int mCellWidth;
    protected DatePickerController mController;
    protected final Calendar mDayLabelCalendar;
    private int mDayOfWeekStart;
    protected int mDayTextColor;
    private String mDefaultTypefaceString;
    protected int mDisabledDayTextColor;
    protected int mEdgePadding;
    protected int mEventDotMarginTop;
    protected ArrayList<Integer> mEventRemind;
    protected int mEventRemindColor;
    protected Paint mEventRemindPaint;
    protected float mEventRemindRadios;
    protected float mEventRemindWidth;
    private final Formatter mFormatter;
    protected int mGregorianMarginTop;
    protected boolean mHasToday;
    protected int mHeight;
    private int mHeightPosition;
    private boolean mLockAccessibilityDelegate;
    protected int mLunarColor;
    private String mLunarDayTypefaceString;
    protected int mLunarPaintAlpha;
    protected int mMonth;
    protected Paint mMonthDayLabelPaint;
    protected Paint.FontMetricsInt mMonthLunarLabelFontMetrics;
    protected Paint.FontMetricsInt mMonthNumFontMetrics;
    protected Paint mMonthNumPaint;
    protected int mNumCells;
    protected int mNumDays;
    protected int mNumRows;
    protected int mOffsetX;
    protected OnDayClickListener mOnDayClickListener;
    protected int mPaddingOffset;
    DatePickerNativeDialog.HeightRecordCallBack mRecordCallback;
    protected int mRowHeight;
    protected int mSelectDayBgColor;
    protected int mSelectDayColor;
    protected int mSelectPaintAlpha;
    protected Paint mSelectedCirclePaint;
    protected int mSelectedDay;
    private final StringBuilder mStringBuilder;
    protected RectF mTempRect;
    protected int mToday;
    protected int mTodayNumberColor;
    private final MonthViewTouchHelper mTouchHelper;
    protected int mWeekStart;
    protected int mWidth;
    protected int mYear;

    public class MonthViewTouchHelper extends ExploreByTouchHelper {
        private static final String DATE_FORMAT = "dd MMMM yyyy";
        private final Calendar mTempCalendar = Calendar.getInstance();
        private final Rect mTempRect = new Rect();

        public MonthViewTouchHelper(View view) {
            super(view);
        }

        public void clearFocusedVirtualView() {
            int focusedVirtualView = getFocusedVirtualView();
            if (focusedVirtualView != Integer.MIN_VALUE) {
                getAccessibilityNodeProvider(MonthView.this).f(focusedVirtualView, 128, (Bundle) null);
            }
        }

        public void getItemBounds(int i, Rect rect) {
            MonthView monthView = MonthView.this;
            int i2 = monthView.mEdgePadding;
            int monthHeaderSize = monthView.getMonthHeaderSize();
            MonthView monthView2 = MonthView.this;
            int i3 = monthView2.mRowHeight;
            int i4 = (monthView2.mWidth - (monthView2.mEdgePadding * 2)) / monthView2.mNumDays;
            int findDayOffset = (i - 1) + monthView2.findDayOffset();
            int i5 = MonthView.this.mNumDays;
            int i6 = i2 + ((findDayOffset % i5) * i4);
            int i7 = monthHeaderSize + ((findDayOffset / i5) * i3);
            rect.set(i6, i7, i4 + i6, i3 + i7);
        }

        public CharSequence getItemDescription(int i) {
            Calendar calendar = this.mTempCalendar;
            MonthView monthView = MonthView.this;
            calendar.set(monthView.mYear, monthView.mMonth, i);
            CharSequence format = DateFormat.format(DATE_FORMAT, this.mTempCalendar.getTimeInMillis());
            MonthView monthView2 = MonthView.this;
            return i == monthView2.mSelectedDay ? monthView2.getContext().getString(R.string.item_is_selected, new Object[]{format}) : format;
        }

        public int getVirtualViewAt(float f, float f2) {
            int dayFromLocation = MonthView.this.getDayFromLocation(f, f2);
            if (dayFromLocation >= 0) {
                return dayFromLocation;
            }
            return Integer.MIN_VALUE;
        }

        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 1; i <= MonthView.this.mNumCells; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            MonthView.this.onDayClick(i);
            return true;
        }

        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getItemDescription(i));
        }

        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            getItemBounds(i, this.mTempRect);
            accessibilityNodeInfoCompat.l0(getItemDescription(i));
            accessibilityNodeInfoCompat.c0(this.mTempRect);
            accessibilityNodeInfoCompat.a(16);
            if (i == MonthView.this.mSelectedDay) {
                accessibilityNodeInfoCompat.G0(true);
            }
        }

        public void setFocusedVirtualView(int i) {
            getAccessibilityNodeProvider(MonthView.this).f(i, 64, (Bundle) null);
        }
    }

    public interface OnDayClickListener {
        void onDayClick(MonthView monthView, CalendarDay calendarDay);
    }

    public MonthView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int calculateNumRows() {
        int findDayOffset = findDayOffset();
        int i = this.mNumCells;
        int i2 = this.mNumDays;
        return ((findDayOffset + i) / i2) + ((findDayOffset + i) % i2 > 0 ? 1 : 0);
    }

    public static int getFontIncreasedHeight(Context context, int i, float f) {
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(i);
        float f2 = dimensionPixelSize / (context.getResources().getDisplayMetrics().scaledDensity / context.getResources().getDisplayMetrics().density);
        Paint paint = new Paint();
        paint.setTextSize(Math.min(f, dimensionPixelSize));
        paint.setTextSize(f2);
        return Math.max(0, (paint.getFontMetricsInt().descent - paint.getFontMetricsInt().top) - (paint.getFontMetricsInt().descent - paint.getFontMetricsInt().top));
    }

    private String getMonthAndYearString() {
        this.mStringBuilder.setLength(0);
        long timeInMillis = this.mCalendar.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), this.mFormatter, timeInMillis, timeInMillis, 56, TimeZone.getDefault().getID()).toString();
    }

    public static int getRowHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mc_native_date_picker_date_month_list_item_height) + getFontIncreasedHeight(context, R.dimen.mc_native_date_picker_month_gregorian_text_size, 73.0f) + getFontIncreasedHeight(context, R.dimen.mc_native_date_picker_month_lunar_text_size, 39.0f);
    }

    private boolean isAfterMax(int i, int i2, int i3) {
        Calendar maxDate;
        DatePickerController datePickerController = this.mController;
        if (datePickerController == null || (maxDate = datePickerController.getMaxDate()) == null) {
            return false;
        }
        if (i > maxDate.get(1)) {
            return true;
        }
        if (i < maxDate.get(1)) {
            return false;
        }
        if (i2 > maxDate.get(2)) {
            return true;
        }
        return i2 >= maxDate.get(2) && i3 > maxDate.get(5);
    }

    private boolean isBeforeMin(int i, int i2, int i3) {
        Calendar minDate;
        DatePickerController datePickerController = this.mController;
        if (datePickerController == null || (minDate = datePickerController.getMinDate()) == null) {
            return false;
        }
        if (i < minDate.get(1)) {
            return true;
        }
        if (i > minDate.get(1)) {
            return false;
        }
        if (i2 < minDate.get(2)) {
            return true;
        }
        return i2 <= minDate.get(2) && i3 < minDate.get(5);
    }

    /* access modifiers changed from: private */
    public void onDayClick(int i) {
        if (!isOutOfRange(this.mYear, this.mMonth, i)) {
            OnDayClickListener onDayClickListener = this.mOnDayClickListener;
            if (onDayClickListener != null) {
                onDayClickListener.onDayClick(this, new CalendarDay(this.mYear, this.mMonth, i));
            }
            this.mTouchHelper.sendEventForVirtualView(i, 1);
        }
    }

    private boolean sameDay(int i, Time time) {
        return this.mYear == time.year && this.mMonth == time.month && i == time.monthDay;
    }

    public void clearAccessibilityFocus() {
        this.mTouchHelper.clearFocusedVirtualView();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mTouchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public abstract void drawMonthDay(Canvas canvas, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6);

    public void drawMonthNums(Canvas canvas) {
        int monthHeaderSize = (((this.mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2) - DAY_SEPARATOR_WIDTH) + getMonthHeaderSize();
        float f = ((float) (this.mWidth - (this.mEdgePadding * 2))) / (((float) this.mNumDays) * 2.0f);
        int i = monthHeaderSize;
        int findDayOffset = findDayOffset();
        int i2 = 1;
        while (i2 <= this.mNumCells) {
            int i3 = this.mRowHeight;
            int i4 = ((MINI_DAY_NUMBER_TEXT_SIZE + i3) / 2) - DAY_SEPARATOR_WIDTH;
            float f2 = (float) ((int) ((((float) ((findDayOffset * 2) + 1)) * f) + ((float) this.mEdgePadding)));
            int i5 = i - i4;
            int i6 = i2;
            drawMonthDay(canvas, this.mYear, this.mMonth, i2, f2, (float) i, (float) ((int) (f2 - f)), (float) ((int) (f2 + f)), (float) i5, (float) (i3 + i5));
            findDayOffset++;
            if (findDayOffset == this.mNumDays) {
                i += this.mRowHeight;
                findDayOffset = 0;
            }
            i2 = i6 + 1;
        }
    }

    public int findDayOffset() {
        int i = this.mDayOfWeekStart;
        int i2 = this.mWeekStart;
        if (i < i2) {
            i += this.mNumDays;
        }
        return i - i2;
    }

    public CalendarDay getAccessibilityFocus() {
        int focusedVirtualView = this.mTouchHelper.getFocusedVirtualView();
        if (focusedVirtualView >= 0) {
            return new CalendarDay(this.mYear, this.mMonth, focusedVirtualView);
        }
        return null;
    }

    public int getDayFromLocation(float f, float f2) {
        int internalDayFromLocation = getInternalDayFromLocation(f, f2);
        if (internalDayFromLocation < 1 || internalDayFromLocation > this.mNumCells) {
            return -1;
        }
        return internalDayFromLocation;
    }

    public int getInternalDayFromLocation(float f, float f2) {
        int i = this.mEdgePadding;
        float f3 = (float) i;
        if (f < f3 || f > ((float) (this.mWidth - i))) {
            return -1;
        }
        int monthHeaderSize = ((int) (f2 - ((float) getMonthHeaderSize()))) / this.mRowHeight;
        float f4 = f - f3;
        int i2 = this.mNumDays;
        int i3 = (int) ((f4 * ((float) i2)) / ((float) ((this.mWidth - i) - this.mEdgePadding)));
        return (this.isRTL ? (((i2 - i3) - 1) - findDayOffset()) + 1 : (i3 - findDayOffset()) + 1) + (monthHeaderSize * this.mNumDays);
    }

    public int getMonth() {
        return this.mMonth;
    }

    public int getMonthHeaderSize() {
        return 0;
    }

    public MonthViewTouchHelper getMonthViewTouchHelper() {
        return new MonthViewTouchHelper(this);
    }

    public int getYear() {
        return this.mYear;
    }

    public void initView() {
        Paint paint = new Paint();
        this.mSelectedCirclePaint = paint;
        paint.setFakeBoldText(true);
        this.mSelectedCirclePaint.setAntiAlias(true);
        this.mSelectedCirclePaint.setColor(this.mSelectDayBgColor);
        Paint paint2 = this.mSelectedCirclePaint;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        Paint paint3 = this.mSelectedCirclePaint;
        Paint.Style style = Paint.Style.FILL;
        paint3.setStyle(style);
        Paint paint4 = new Paint();
        this.mMonthDayLabelPaint = paint4;
        paint4.setFakeBoldText(true);
        this.mMonthDayLabelPaint.setAntiAlias(true);
        this.mMonthDayLabelPaint.setColor(this.mLunarColor);
        this.mMonthDayLabelPaint.setTextAlign(align);
        this.mMonthDayLabelPaint.setStyle(style);
        this.mMonthDayLabelPaint.setTextSize((float) MONTH_DAY_LABEL_TEXT_SIZE);
        this.mMonthLunarLabelFontMetrics = this.mMonthDayLabelPaint.getFontMetricsInt();
        Paint paint5 = new Paint();
        this.mMonthNumPaint = paint5;
        paint5.setAntiAlias(true);
        this.mMonthNumPaint.setTextSize((float) MINI_DAY_NUMBER_TEXT_SIZE);
        this.mMonthNumPaint.setStyle(style);
        this.mMonthNumPaint.setTextAlign(align);
        this.mMonthNumPaint.setFakeBoldText(false);
        this.mMonthNumFontMetrics = this.mMonthNumPaint.getFontMetricsInt();
        Paint paint6 = new Paint();
        this.mEventRemindPaint = paint6;
        paint6.setFakeBoldText(true);
        this.mEventRemindPaint.setAntiAlias(true);
        this.mEventRemindPaint.setColor(this.mEventRemindColor);
        this.mEventRemindPaint.setTextAlign(align);
        this.mEventRemindPaint.setStyle(style);
    }

    public boolean isEventRemindDay(int i) {
        ArrayList<Integer> arrayList = this.mEventRemind;
        return arrayList != null && arrayList.contains(Integer.valueOf(i));
    }

    public boolean isOutOfRange(int i, int i2, int i3) {
        if (isBeforeMin(i, i2, i3)) {
            return true;
        }
        return isAfterMax(i, i2, i3);
    }

    public void onDraw(Canvas canvas) {
        drawMonthNums(canvas);
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.mWidth;
        if (i3 == -1) {
            i3 = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(i3, this.mHeight);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        int i5 = this.mEdgePadding;
        int i6 = this.mNumDays;
        int i7 = (i - (i5 * 2)) / i6;
        this.mCellWidth = i7;
        this.mOffsetX = ((i - (i5 * 2)) - (i7 * i6)) / 2;
        this.mTouchHelper.invalidateRoot();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int dayFromLocation;
        if (motionEvent.getAction() == 1 && (dayFromLocation = getDayFromLocation(motionEvent.getX(), motionEvent.getY())) >= 0) {
            this.mSelectedDay = dayFromLocation;
            invalidate();
            onDayClick(dayFromLocation);
        }
        return true;
    }

    public boolean restoreAccessibilityFocus(CalendarDay calendarDay) {
        int i;
        if (calendarDay.year != this.mYear || calendarDay.month != this.mMonth || (i = calendarDay.day) > this.mNumCells) {
            return false;
        }
        this.mTouchHelper.setFocusedVirtualView(i);
        return true;
    }

    public void reuse() {
        this.mNumRows = 6;
        requestLayout();
    }

    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (!this.mLockAccessibilityDelegate) {
            super.setAccessibilityDelegate(accessibilityDelegate);
        }
    }

    public void setDatePickerController(DatePickerController datePickerController) {
        this.mController = datePickerController;
    }

    public void setHeightRecordCallBack(int i, DatePickerNativeDialog.HeightRecordCallBack heightRecordCallBack) {
        this.mHeightPosition = i;
        this.mRecordCallback = heightRecordCallBack;
    }

    public void setMonthParams(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey(VIEW_PARAMS_MONTH) || hashMap.containsKey(VIEW_PARAMS_YEAR)) {
            setTag(hashMap);
            if (hashMap.containsKey(VIEW_PARAMS_HEIGHT)) {
                int intValue = ((Integer) hashMap.get(VIEW_PARAMS_HEIGHT)).intValue();
                this.mHeight = intValue;
                if (intValue < 300) {
                    this.mHeight = 300;
                }
            }
            if (hashMap.containsKey(VIEW_PARAMS_SELECTED_DAY)) {
                this.mSelectedDay = ((Integer) hashMap.get(VIEW_PARAMS_SELECTED_DAY)).intValue();
            }
            if (hashMap.containsKey(VIEW_PARAMS_WIDTH)) {
                this.mWidth = ((Integer) hashMap.get(VIEW_PARAMS_WIDTH)).intValue();
            }
            this.mMonth = ((Integer) hashMap.get(VIEW_PARAMS_MONTH)).intValue();
            this.mYear = ((Integer) hashMap.get(VIEW_PARAMS_YEAR)).intValue();
            Time time = new Time(Time.getCurrentTimezone());
            time.setToNow();
            int i = 0;
            this.mHasToday = false;
            this.mToday = -1;
            this.mCalendar.set(2, this.mMonth);
            this.mCalendar.set(1, this.mYear);
            this.mCalendar.set(5, 1);
            this.mDayOfWeekStart = this.mCalendar.get(7);
            if (hashMap.containsKey(VIEW_PARAMS_WEEK_START)) {
                this.mWeekStart = ((Integer) hashMap.get(VIEW_PARAMS_WEEK_START)).intValue();
            } else {
                this.mWeekStart = this.mCalendar.getFirstDayOfWeek();
            }
            this.mNumCells = Utils.getDaysInMonth(this.mMonth, this.mYear);
            while (i < this.mNumCells) {
                i++;
                if (sameDay(i, time)) {
                    this.mHasToday = true;
                    this.mToday = i;
                }
            }
            if (hashMap.containsKey(VIEW_PARAMS_EVENT_REMIND)) {
                this.mEventRemind = (ArrayList) hashMap.get(VIEW_PARAMS_EVENT_REMIND);
            } else {
                this.mEventRemind = null;
            }
            if (hashMap.containsKey(VIEW_PARAMS_PAINT_ALPHA)) {
                float floatValue = ((Float) hashMap.get(VIEW_PARAMS_PAINT_ALPHA)).floatValue();
                this.mLunarPaintAlpha = (int) (89.0f * floatValue);
                this.mSelectPaintAlpha = (int) (floatValue * 255.0f);
            }
            int calculateNumRows = calculateNumRows();
            this.mNumRows = calculateNumRows;
            DatePickerNativeDialog.HeightRecordCallBack heightRecordCallBack = this.mRecordCallback;
            if (heightRecordCallBack != null) {
                heightRecordCallBack.recordHeight(this.mHeightPosition, this.mRowHeight * calculateNumRows);
            }
            this.mTouchHelper.invalidateRoot();
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mOnDayClickListener = onDayClickListener;
    }

    public void setSelectedDay(int i) {
        this.mSelectedDay = i;
        invalidate();
    }

    public MonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.mEdgePadding = 0;
        this.mWidth = -1;
        this.mRowHeight = DEFAULT_HEIGHT;
        this.mHasToday = false;
        this.mSelectedDay = -1;
        this.mToday = -1;
        this.mWeekStart = 1;
        this.mNumDays = 7;
        this.mNumCells = 7;
        this.mTempRect = new RectF();
        this.mNumRows = 6;
        this.mLunarPaintAlpha = 89;
        this.mSelectPaintAlpha = 255;
        this.isRTL = false;
        this.mDayOfWeekStart = 0;
        Resources resources = context.getResources();
        this.mDayLabelCalendar = Calendar.getInstance();
        this.mCalendar = Calendar.getInstance();
        this.mDefaultTypefaceString = resources.getString(R.string.default_sans_serif);
        this.mLunarDayTypefaceString = resources.getString(R.string.flyme_sans_serif_normal);
        this.mDayTextColor = resources.getColor(R.color.fd_sys_color_on_surface_default);
        this.mTodayNumberColor = resources.getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorBrand, context));
        this.mDisabledDayTextColor = resources.getColor(R.color.mc_custom_date_picker_gregorian_text_disabled);
        this.mSelectDayColor = resources.getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorBrand, context));
        this.mLunarColor = resources.getColor(R.color.mc_custom_date_picker_lunar_color);
        this.mSelectDayBgColor = resources.getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorBrandContainer, context));
        this.mEventRemindColor = resources.getColor(R.color.mc_custom_date_picker_event_remind_color);
        StringBuilder sb = new StringBuilder(50);
        this.mStringBuilder = sb;
        this.mFormatter = new Formatter(sb, Locale.getDefault());
        MINI_DAY_NUMBER_TEXT_SIZE = Math.min(resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_month_gregorian_text_size), 73);
        MONTH_DAY_LABEL_TEXT_SIZE = Math.min(resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_month_lunar_text_size), 39);
        this.mRowHeight = getRowHeight(context);
        this.mPaddingOffset = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_text_padding_offset);
        this.mEventRemindRadios = (float) resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_Radios);
        this.mEventRemindWidth = (float) resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_width);
        this.mGregorianMarginTop = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_gregorian_text_margin_top);
        this.mEventDotMarginTop = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_margin_top);
        this.mBgMarginTop = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_bg_margin_top);
        this.mBgPaddingLeftRight = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_bg_padding_left_right);
        this.mHeight = this.mRowHeight * this.mNumRows;
        MonthViewTouchHelper monthViewTouchHelper = getMonthViewTouchHelper();
        this.mTouchHelper = monthViewTouchHelper;
        ViewCompat.u0(this, monthViewTouchHelper);
        ViewCompat.G0(this, 1);
        this.mLockAccessibilityDelegate = true;
        initView();
        this.isRTL = context.getResources().getConfiguration().getLayoutDirection() == 1 ? true : z;
    }
}
