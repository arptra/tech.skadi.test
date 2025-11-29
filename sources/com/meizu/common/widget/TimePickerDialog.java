package com.meizu.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.meizu.common.R;
import com.meizu.common.widget.TimePicker;
import java.lang.ref.WeakReference;

public class TimePickerDialog extends AlertDialog implements TimePicker.OnTimeChangedListener {
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    /* access modifiers changed from: private */
    public final OnTimeSetListener mCallback;
    int mInitialHourOfDay;
    int mInitialMinute;
    boolean mIs24HourView;
    private TimePicker.OnTimeChangedListener mOnTimeChangedListener;
    /* access modifiers changed from: private */
    public final TimePicker mTimePicker;

    public static class OnPositiveClickListener implements DialogInterface.OnClickListener {
        private WeakReference<TimePickerDialog> mDialog;

        public void onClick(DialogInterface dialogInterface, int i) {
            TimePickerDialog timePickerDialog = this.mDialog.get();
            if (timePickerDialog != null && timePickerDialog.mCallback != null) {
                timePickerDialog.mTimePicker.clearFocus();
                timePickerDialog.mCallback.onTimeSet(timePickerDialog.mTimePicker, timePickerDialog.mTimePicker.getCurrentHour(), timePickerDialog.mTimePicker.getCurrentMinute().intValue());
            }
        }

        private OnPositiveClickListener(TimePickerDialog timePickerDialog) {
            this.mDialog = new WeakReference<>(timePickerDialog);
        }
    }

    public interface OnTimeSetListener {
        void onTimeSet(TimePicker timePicker, int i, int i2);
    }

    public TimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        this(context, 0, onTimeSetListener, i, i2, z);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("hour");
        int i2 = bundle.getInt(MINUTE);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(bundle.getBoolean(IS_24_HOUR)));
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("hour", this.mTimePicker.getCurrentHour());
        onSaveInstanceState.putInt(MINUTE, this.mTimePicker.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean(IS_24_HOUR, this.mTimePicker.is24HourView());
        return onSaveInstanceState;
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        TimePicker.OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(timePicker, i, i2);
        }
    }

    public void setOnTimeChangedListener(TimePicker.OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mTimePicker.setTextColor(i, i2, i3);
    }

    public void updateTime(int i, int i2) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    public TimePickerDialog(Context context, int i, OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z) {
        super(context, i);
        this.mCallback = onTimeSetListener;
        this.mInitialHourOfDay = i2;
        this.mInitialMinute = i3;
        this.mIs24HourView = z;
        setButton(-1, context.getText(R.string.mc_yes), new OnPositiveClickListener());
        setButton(-2, context.getText(17039360), (DialogInterface.OnClickListener) null);
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_time_picker_dialog, (ViewGroup) null);
        setView(inflate);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                inflate.removeOnLayoutChangeListener(this);
                LinearLayout linearLayout = (LinearLayout) TimePickerDialog.this.findViewById(16908316);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                }
            }
        });
        TimePicker timePicker = (TimePicker) inflate.findViewById(R.id.timePicker);
        this.mTimePicker = timePicker;
        timePicker.setIs24HourView(Boolean.valueOf(this.mIs24HourView));
        timePicker.setCurrentHour(Integer.valueOf(this.mInitialHourOfDay));
        timePicker.setCurrentMinute(Integer.valueOf(this.mInitialMinute));
        timePicker.setOnTimeChangedListener(this);
        timePicker.setIsDrawLine(false);
        timePicker.setLineHeight(context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_one_height), context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_two_height));
    }
}
