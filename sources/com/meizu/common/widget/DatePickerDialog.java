package com.meizu.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.DatePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private final OnDateSetListener mCallBack;
    private final DatePicker mDatePicker;
    private boolean mIsShowDay;
    private DatePicker.OnDateChangedListener mOnDateChangedListener;
    private TextView mTimerPreview;

    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    public DatePickerDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    public DatePicker getDatePicker() {
        return this.mDatePicker;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mCallBack != null) {
            this.mDatePicker.clearFocus();
            OnDateSetListener onDateSetListener = this.mCallBack;
            DatePicker datePicker = this.mDatePicker;
            onDateSetListener.onDateSet(datePicker, datePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
        }
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        TextView textView = this.mTimerPreview;
        DatePicker datePicker2 = this.mDatePicker;
        textView.setText(datePicker2.getTimePreviewText(datePicker2.isLunar(), this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth(), this.mIsShowDay));
        DatePicker.OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(datePicker, i, i2, i3);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDatePicker.init(bundle.getInt("year"), bundle.getInt("month"), bundle.getInt(DAY), this, false);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("year", this.mDatePicker.getYear());
        onSaveInstanceState.putInt("month", this.mDatePicker.getMonth());
        onSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        return onSaveInstanceState;
    }

    public void setMaxYear(int i) {
        if (i > 2099) {
            i = 2099;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i, 11, 31);
        this.mDatePicker.setMaxDate(instance.getTimeInMillis());
    }

    public void setMinYear(int i) {
        if (i < 1900) {
            i = 1900;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i, 0, 1);
        this.mDatePicker.setMinDate(instance.getTimeInMillis());
    }

    public void setOnDateChangedListener(DatePicker.OnDateChangedListener onDateChangedListener) {
        this.mOnDateChangedListener = onDateChangedListener;
    }

    public void setShowDayColumn(boolean z) {
        this.mIsShowDay = z;
        this.mDatePicker.setShowDayColumn(z);
        TextView textView = this.mTimerPreview;
        DatePicker datePicker = this.mDatePicker;
        textView.setText(datePicker.getTimePreviewText(datePicker.isLunar(), this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth(), this.mIsShowDay));
    }

    public void setTextColor(int i, int i2, int i3) {
        this.mDatePicker.setTextColor(i, i2, i3);
    }

    public void updateDate(int i, int i2, int i3) {
        updateDate(i, i2, i3, true);
    }

    public DatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, i, onDateSetListener, i2, i3, i4, false, false);
    }

    public void updateDate(int i, int i2, int i3, boolean z) {
        this.mDatePicker.updateDate(i, i2, i3, z);
    }

    public DatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4, boolean z, boolean z2) {
        super(context, i);
        this.mIsShowDay = true;
        this.mCallBack = onDateSetListener;
        setButton(-1, context.getText(R.string.mc_yes), this);
        setButton(-2, context.getText(17039360), (DialogInterface.OnClickListener) null);
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_date_picker_dialog, (ViewGroup) null);
        setView(inflate);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                inflate.removeOnLayoutChangeListener(this);
                LinearLayout linearLayout = (LinearLayout) DatePickerDialog.this.findViewById(16908316);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                }
            }
        });
        DatePicker datePicker = (DatePicker) inflate.findViewById(R.id.datePicker);
        this.mDatePicker = datePicker;
        DatePicker datePicker2 = datePicker;
        datePicker2.init(i2, i3, i4, this, z, z2);
        int color = context.getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(context.getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(context.getResources().getColor(R.color.mc_picker_unselected_color_two)));
        datePicker.setTextColor(color, (List<Integer>) arrayList, color);
        datePicker.setIsDrawLine(false);
        datePicker.setLineHeight(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_one_height), context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_two_height));
        TextView textView = (TextView) inflate.findViewById(R.id.time_preview);
        this.mTimerPreview = textView;
        textView.setText(datePicker2.getTimePreviewText(datePicker.isLunar(), datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), this.mIsShowDay));
    }
}
