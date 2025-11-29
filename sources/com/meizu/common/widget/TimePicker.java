package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimePicker extends FrameLayout {
    private static final int ITEM_COUNT_DEFAULT = 5;
    private static final int ITEM_COUNT_SMALL = 3;
    private static final String TAG = "TimePicker";
    private ScrollTextView mAmPmPicker;
    /* access modifiers changed from: private */
    public String mAmText;
    /* access modifiers changed from: private */
    public int mCurrentHour;
    /* access modifiers changed from: private */
    public int mCurrentMinute;
    /* access modifiers changed from: private */
    public ScrollTextView mHourPicker;
    String[] mHourTexts;
    private TextView mHourUnit;
    private Boolean mIs24HourView;
    private boolean mIsAccessibilityEnable;
    /* access modifiers changed from: private */
    public boolean mIsAm;
    private boolean mIsDrawLine;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mMinTexts;
    /* access modifiers changed from: private */
    public ScrollTextView mMinutePicker;
    private TextView mMinuteUnit;
    /* access modifiers changed from: private */
    public OnTimeChangedListener mOnTimeChangedListener;
    /* access modifiers changed from: private */
    public int mOneScreenCount;
    private LinearLayout mPickerHolder;
    /* access modifiers changed from: private */
    public String mPmText;
    private int mWidthPadding;

    public interface OnTimeChangedListener {
        void onTimeChanged(TimePicker timePicker, int i, int i2);
    }

    public class TimeAdapter implements ScrollTextView.IDataAdapter {
        static final int SET_AMPM = 3;
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
                    return TimePicker.this.mMinTexts[i];
                }
                if (i2 != 3) {
                    return null;
                }
                if (i == 0) {
                    return TimePicker.this.mAmText;
                }
                if (i == 1) {
                    return TimePicker.this.mPmText;
                }
                return null;
            } else if (TimePicker.this.is24HourView()) {
                return TimePicker.this.mHourTexts[i];
            } else {
                if (i == 0) {
                    i = 12;
                }
                return TimePicker.this.mHourTexts[i];
            }
        }

        public void onChanged(View view, int i, int i2) {
            int i3 = this.mType;
            boolean z = true;
            if (i3 == 1) {
                int unused = TimePicker.this.mCurrentHour = i2;
            } else if (i3 == 2) {
                int unused2 = TimePicker.this.mCurrentMinute = i2;
            } else if (i3 == 3) {
                TimePicker timePicker = TimePicker.this;
                if (i2 != 0) {
                    z = false;
                }
                boolean unused3 = timePicker.mIsAm = z;
            } else {
                return;
            }
            if (TimePicker.this.mOnTimeChangedListener != null) {
                OnTimeChangedListener access$300 = TimePicker.this.mOnTimeChangedListener;
                TimePicker timePicker2 = TimePicker.this;
                access$300.onTimeChanged(timePicker2, timePicker2.getCurrentHour(), TimePicker.this.getCurrentMinute().intValue());
            }
            TimePicker.this.sendAccessibilityEvents(this.mType);
        }
    }

    public TimePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    private String getTimeText(int i) {
        if (i == 1) {
            int i2 = this.mCurrentHour;
            if (is24HourView()) {
                return String.valueOf(i2);
            }
            if (i2 == 0) {
                i2 = 12;
            }
            return String.valueOf(i2);
        } else if (i == 2) {
            return String.valueOf(this.mCurrentMinute);
        } else {
            if (i != 3) {
                return "";
            }
            boolean z = !this.mIsAm;
            return !z ? this.mAmText : z ? this.mPmText : "";
        }
    }

    private void inflateLayout() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.mIs24HourView.booleanValue()) {
            init24HourView();
        } else {
            init12HourView();
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        int color2 = getContext().getResources().getColor(R.color.mc_picker_unselected_color);
        this.mHourPicker.setTextColor(color, (List<Integer>) arrayList);
        this.mMinutePicker.setTextColor(color, (List<Integer>) arrayList);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.setTextColor(color, color2);
        }
        this.mHourUnit.setTextColor(color);
        this.mMinuteUnit.setTextColor(color);
        if (!isEnabled()) {
            setEnabled(false);
        }
    }

    private void init12HourView() {
        if (!this.mIs24HourView.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
            this.mHourUnit = textView;
            if (textView != null) {
                textView.setText(R.string.mc_date_time_hour);
            }
            TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.mMinuteUnit = textView2;
            if (textView2 != null) {
                textView2.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.mHourPicker = scrollTextView;
            scrollTextView.setData(new TimeAdapter(1), -1.0f, this.mCurrentHour, 12, this.mOneScreenCount, 0, 11, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.mMinutePicker = scrollTextView2;
            scrollTextView2.setData(new TimeAdapter(2), -1.0f, this.mCurrentMinute, 60, this.mOneScreenCount, 0, 59, true);
            ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.mAmPmPicker = scrollTextView3;
            scrollTextView3.setData(new TimeAdapter(3), -1.0f, this.mIsAm ^ true ? 1 : 0, 2, this.mOneScreenCount, 0, 1, false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float min = (float) Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.mHourPicker.setTextSize(min, (List<Float>) arrayList);
            this.mMinutePicker.setTextSize(min, (List<Float>) arrayList);
            this.mAmPmPicker.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two));
        }
    }

    private void init24HourView() {
        if (this.mIs24HourView.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_24, this);
            TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
            this.mHourUnit = textView;
            if (textView != null) {
                textView.setText(R.string.mc_date_time_hour);
            }
            TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.mMinuteUnit = textView2;
            if (textView2 != null) {
                textView2.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.mHourPicker = scrollTextView;
            scrollTextView.setData(new TimeAdapter(1), -1.0f, this.mCurrentHour, 24, this.mOneScreenCount, 0, 23, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.mMinutePicker = scrollTextView2;
            scrollTextView2.setData(new TimeAdapter(2), -1.0f, this.mCurrentMinute, 60, this.mOneScreenCount, 0, 59, true);
            this.mAmPmPicker = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float min = (float) Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.mHourPicker.setTextSize(min, (List<Float>) arrayList);
            this.mMinutePicker.setTextSize(min, (List<Float>) arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void layoutTextUnit() {
        int height = (int) ((((float) getHeight()) - (((float) this.mHourUnit.getLineHeight()) - this.mHourUnit.getTextSize())) / 2.0f);
        TextView textView = this.mHourUnit;
        textView.setPadding(textView.getPaddingLeft(), height, this.mHourUnit.getPaddingRight(), this.mHourUnit.getPaddingBottom());
        TextView textView2 = this.mMinuteUnit;
        textView2.setPadding(textView2.getPaddingLeft(), height, this.mMinuteUnit.getPaddingRight(), this.mMinuteUnit.getPaddingBottom());
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvents(int i) {
        View findViewById;
        if (this.mIsAccessibilityEnable) {
            setContentDescription();
            if (i == 3) {
                View findViewById2 = findViewById(R.id.mc_column3Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 1) {
                View findViewById3 = findViewById(R.id.mc_column1Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 2 && (findViewById = findViewById(R.id.mc_column2Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    private void setContentDescription() {
        if (this.mIsAccessibilityEnable) {
            View findViewById = findViewById(R.id.mc_column3Layout);
            View findViewById2 = findViewById(R.id.mc_column2Layout);
            View findViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.mIs24HourView.booleanValue()) {
                str = str + getTimeText(3);
            }
            String str2 = str + getTimeText(1) + this.mHourUnit.getText() + getTimeText(2) + this.mMinuteUnit.getText();
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置上下午，当前时间是" + str2);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置时，当前时间是" + str2);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置分，当前时间是" + str2);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.mIsAccessibilityEnable || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.mIs24HourView.booleanValue()) {
            str = str + getTimeText(3);
        }
        accessibilityEvent.getText().add(str + getTimeText(1) + this.mHourUnit.getText() + getTimeText(2) + this.mMinuteUnit.getText());
        return false;
    }

    public int getCurrentHour() {
        return this.mIs24HourView.booleanValue() ? this.mCurrentHour : this.mIsAm ? this.mCurrentHour : this.mCurrentHour + 12;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mCurrentMinute);
    }

    public boolean is24HourView() {
        return this.mIs24HourView.booleanValue();
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
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        update(savedState.mHour, savedState.mMinute, this.mIs24HourView.booleanValue());
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.mCurrentMinute);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            update(num.intValue(), this.mCurrentMinute, this.mIs24HourView.booleanValue());
        }
    }

    public void setCurrentMinute(Integer num) {
        update(getCurrentHour(), num.intValue(), this.mIs24HourView.booleanValue());
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mMinutePicker.setEnabled(z);
        this.mHourPicker.setEnabled(z);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z);
        }
    }

    public void setIs24HourView(Boolean bool) {
        update(getCurrentHour(), this.mCurrentMinute, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z) {
        this.mIsDrawLine = z;
    }

    public void setLineHeight(int i, int i2) {
        this.mLineOneHeight = i;
        this.mLineTwoHeight = i2;
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mHourPicker.setTextColor(i, i2);
        this.mMinutePicker.setTextColor(i, i2);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.setTextColor(i, i2);
        }
        this.mHourUnit.setTextColor(i3);
        this.mMinuteUnit.setTextColor(i3);
    }

    public void update(int i, int i2, boolean z) {
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
        public final int mHour;
        /* access modifiers changed from: private */
        public final int mMinute;

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.mCurrentHour = 0;
        this.mCurrentMinute = 0;
        this.mIs24HourView = Boolean.FALSE;
        this.mIsAm = true;
        this.mIsAccessibilityEnable = false;
        this.mOneScreenCount = 5;
        String format = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{0});
        this.mHourTexts = new String[100];
        for (int i3 = 0; i3 < 100; i3++) {
            this.mHourTexts[i3] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)});
            if (i3 <= 9) {
                this.mHourTexts[i3] = format + this.mHourTexts[i3];
            }
        }
        this.mMinTexts = new String[100];
        for (int i4 = 0; i4 < 100; i4++) {
            this.mMinTexts[i4] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i4)});
            if (i4 <= 9) {
                this.mMinTexts[i4] = format + this.mMinTexts[i4];
            }
        }
        Calendar instance = Calendar.getInstance();
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
        inflateLayout();
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.MZTheme);
        int i5 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes.recycle();
        this.mLinePaint.setColor(i5);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mPickerHolder = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
        setContentDescription();
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                TimePicker.this.getViewTreeObserver().removeOnPreDrawListener(this);
                int itemHeight = (TimePicker.this.mHourPicker.getItemHeight() * (TimePicker.this.mOneScreenCount - 1)) + TimePicker.this.mHourPicker.getSelectedItemHeight();
                if (TimePicker.this.getHeight() < itemHeight) {
                    Log.i(TimePicker.TAG, "picker expired height:" + itemHeight + ",but height is:" + TimePicker.this.getHeight() + ",so item count should reduce now.");
                    int unused = TimePicker.this.mOneScreenCount = 3;
                    TimePicker.this.mHourPicker.setVisibleItems(3);
                    TimePicker.this.mMinutePicker.setVisibleItems(3);
                }
                TimePicker.this.layoutTextUnit();
                return false;
            }
        });
    }
}
