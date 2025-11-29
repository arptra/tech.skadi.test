package com.meizu.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.DayTimeDatePicker;
import java.util.ArrayList;
import java.util.List;

public class DayTimeDatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DayTimeDatePicker.OnTimeChangedListener {
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    /* access modifiers changed from: private */
    public boolean isShowLunar;
    private final OnTimeSetListener mCallback;
    /* access modifiers changed from: private */
    public long mDuration;
    int mInitialHourOfDay;
    int mInitialMinute;
    int mInitialMonth;
    int mInitialYear;
    int mInitialday;
    boolean mIs24HourView;
    private String mShowGregorianStr;
    private String mShowLunarStr;
    private TextView mSwitchLunarShow;
    /* access modifiers changed from: private */
    public final DayTimeDatePicker mTimePicker;
    private TextView mTimerPreview;

    public interface OnTimeSetListener {
        void onTimeSet(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5);
    }

    public DayTimeDatePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(context, 0, onTimeSetListener, i, i2, i3, i4, i5, z);
    }

    private void initView(Context context, View view) {
        this.mSwitchLunarShow = (TextView) view.findViewById(R.id.switchshowlunar);
        this.mTimerPreview = (TextView) view.findViewById(R.id.time_preview);
        updateTxtSwitchLunar();
        int color = context.getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(context.getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(context.getResources().getColor(R.color.mc_picker_unselected_color_two)));
        this.mTimePicker.setTextColor(color, (List<Integer>) arrayList, context.getResources().getColor(R.color.mc_picker_text_color));
        this.mSwitchLunarShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DayTimeDatePickerDialog dayTimeDatePickerDialog = DayTimeDatePickerDialog.this;
                boolean unused = dayTimeDatePickerDialog.isShowLunar = !dayTimeDatePickerDialog.isShowLunar;
                DayTimeDatePickerDialog.this.updateTxtSwitchLunar();
                if (Build.DEVICE.equals("mx4pro")) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            DayTimeDatePickerDialog.this.mTimePicker.setIsDrawFading(false);
                            DayTimeDatePickerDialog.this.mTimePicker.setLunar(DayTimeDatePickerDialog.this.isShowLunar);
                        }
                    }, DayTimeDatePickerDialog.this.mDuration);
                } else {
                    DayTimeDatePickerDialog.this.mTimePicker.setLunar(DayTimeDatePickerDialog.this.isShowLunar);
                }
                DayTimeDatePickerDialog.this.updateDateTimerPreview();
            }
        });
        updateDateTimerPreview();
    }

    /* access modifiers changed from: private */
    public void updateDateTimerPreview() {
        TextView textView = this.mTimerPreview;
        DayTimeDatePicker dayTimeDatePicker = this.mTimePicker;
        textView.setText(dayTimeDatePicker.getTimePreviewText(dayTimeDatePicker.isLunar(), this.mTimePicker.getYear(), this.mTimePicker.getMonth()));
    }

    /* access modifiers changed from: private */
    public void updateTxtSwitchLunar() {
        if (this.isShowLunar) {
            this.mSwitchLunarShow.setText(this.mShowGregorianStr);
        } else {
            this.mSwitchLunarShow.setText(this.mShowLunarStr);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mCallback != null) {
            this.mTimePicker.clearFocus();
            int year = this.mTimePicker.getYear();
            int month = this.mTimePicker.getMonth();
            int i2 = month + 1;
            boolean isLunar = this.mTimePicker.isLunar();
            boolean z = false;
            if (isLunar) {
                int leapMonth = LunarCalendar.leapMonth(year);
                if (leapMonth == 0 || i2 <= leapMonth) {
                    month = i2;
                } else if (month == leapMonth) {
                    z = true;
                }
            }
            boolean z2 = z;
            this.mCallback.onTimeSet(isLunar, year, z2, month, this.mTimePicker.getDayOfMonth(), this.mTimePicker.getCurrentHour(), this.mTimePicker.getCurrentMinute().intValue());
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("hour");
        int i2 = bundle.getInt(MINUTE);
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("hour", this.mTimePicker.getCurrentHour());
        onSaveInstanceState.putInt(MINUTE, this.mTimePicker.getCurrentMinute().intValue());
        return onSaveInstanceState;
    }

    public void onTimeChanged(int i, int i2, int i3, int i4, int i5) {
        updateDateTimerPreview();
    }

    public void setLunar(boolean z, boolean z2) {
        this.isShowLunar = z;
        this.mTimePicker.setLunar(z, z2);
        updateTxtSwitchLunar();
        updateDateTimerPreview();
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mTimePicker.setTextColor(i, i2, i3);
    }

    public void updateTime(int i, int i2) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayTimeDatePickerDialog(Context context, int i, OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(context, i);
        Context context2 = context;
        this.isShowLunar = false;
        this.mDuration = 200;
        this.mCallback = onTimeSetListener;
        this.mInitialYear = i2;
        this.mInitialMonth = i3;
        this.mInitialday = i4;
        this.mInitialHourOfDay = i5;
        this.mInitialMinute = i6;
        this.mIs24HourView = z;
        setButton(-1, context.getText(R.string.mc_yes), this);
        setButton(-2, context.getText(17039360), (DialogInterface.OnClickListener) null);
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_date_picker_day_time_dialog, (ViewGroup) null);
        setView(inflate);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                inflate.removeOnLayoutChangeListener(this);
                LinearLayout linearLayout = (LinearLayout) DayTimeDatePickerDialog.this.findViewById(16908316);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                }
            }
        });
        DayTimeDatePicker dayTimeDatePicker = (DayTimeDatePicker) inflate.findViewById(R.id.day_time_picker);
        this.mTimePicker = dayTimeDatePicker;
        dayTimeDatePicker.init(i2, i3, i4, i5, i6, this, false);
        dayTimeDatePicker.setIsDrawLine(false);
        dayTimeDatePicker.setLineHeight(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_one_height), context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_two_height));
        this.mShowLunarStr = context.getResources().getString(R.string.mc_custom_date_time_show_lunar);
        this.mShowGregorianStr = context.getResources().getString(R.string.mc_custom_date_time_show_gregorian);
        dayTimeDatePicker.setCurrentHour(Integer.valueOf(this.mInitialHourOfDay));
        dayTimeDatePicker.setCurrentMinute(Integer.valueOf(this.mInitialMinute));
        dayTimeDatePicker.setOnTimeChangedListener(this);
        dayTimeDatePicker.setIsDrawLine(false);
        dayTimeDatePicker.setLineHeight(context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_one_height), context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_two_height));
        initView(context, inflate);
    }
}
