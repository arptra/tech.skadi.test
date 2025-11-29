package com.upuphone.xr.sapp.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.meizu.common.R;
import com.upuphone.xr.sapp.view.CustomTimePicker;
import java.lang.ref.WeakReference;

public class CustomTimePickerDialog extends AlertDialog implements CustomTimePicker.OnTimeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final CustomTimePicker f7951a;
    public final OnTimeSetListener b;
    public int c;
    public int d;
    public boolean e;
    public CustomTimePicker.OnTimeChangedListener f;

    public static class OnPositiveClickListener implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f7953a;

        public void onClick(DialogInterface dialogInterface, int i) {
            CustomTimePickerDialog customTimePickerDialog = (CustomTimePickerDialog) this.f7953a.get();
            if (customTimePickerDialog != null && customTimePickerDialog.b != null) {
                customTimePickerDialog.f7951a.clearFocus();
                customTimePickerDialog.b.a(customTimePickerDialog.f7951a, customTimePickerDialog.f7951a.getCurrentHour(), customTimePickerDialog.f7951a.getCurrentMinute().intValue());
            }
        }

        public OnPositiveClickListener(CustomTimePickerDialog customTimePickerDialog) {
            this.f7953a = new WeakReference(customTimePickerDialog);
        }
    }

    public interface OnTimeSetListener {
        void a(CustomTimePicker customTimePicker, int i, int i2);
    }

    public CustomTimePickerDialog(Context context, int i, OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z) {
        super(context, i);
        this.b = onTimeSetListener;
        this.c = i2;
        this.d = i3;
        this.e = z;
        setButton(-1, context.getText(R.string.mc_yes), new OnPositiveClickListener());
        setButton(-2, context.getText(17039360), (DialogInterface.OnClickListener) null);
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.upuphone.xr.sapp.R.layout.custom_time_picker_dialog_layout, (ViewGroup) null);
        setView(inflate);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                inflate.removeOnLayoutChangeListener(this);
                LinearLayout linearLayout = (LinearLayout) CustomTimePickerDialog.this.findViewById(16908316);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                }
            }
        });
        CustomTimePicker customTimePicker = (CustomTimePicker) inflate.findViewById(R.id.timePicker);
        this.f7951a = customTimePicker;
        customTimePicker.setIs24HourView(Boolean.valueOf(this.e));
        customTimePicker.setCurrentHour(Integer.valueOf(this.c));
        customTimePicker.setCurrentMinute(Integer.valueOf(this.d));
        customTimePicker.setOnTimeChangedListener(this);
        customTimePicker.setIsDrawLine(false);
        customTimePicker.p(context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_one_height), context.getResources().getDimensionPixelSize(R.dimen.mc_time_picker_line_two_height));
    }

    public void a(CustomTimePicker customTimePicker, int i, int i2) {
        CustomTimePicker.OnTimeChangedListener onTimeChangedListener = this.f;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.a(customTimePicker, i, i2);
        }
    }

    public void d(int i, int i2) {
        this.f7951a.o(i, i2);
    }

    public void e(int i, int i2) {
        this.f7951a.q(i, i2);
    }

    public void f(CustomTimePicker.OnTimeChangedListener onTimeChangedListener) {
        this.f = onTimeChangedListener;
    }

    public void g(int i, int i2) {
        this.f7951a.setCurrentHour(Integer.valueOf(i));
        this.f7951a.setCurrentMinute(Integer.valueOf(i2));
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("hour");
        int i2 = bundle.getInt("minute");
        this.f7951a.setIs24HourView(Boolean.valueOf(bundle.getBoolean("is24hour")));
        this.f7951a.setCurrentHour(Integer.valueOf(i));
        this.f7951a.setCurrentMinute(Integer.valueOf(i2));
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("hour", this.f7951a.getCurrentHour());
        onSaveInstanceState.putInt("minute", this.f7951a.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean("is24hour", this.f7951a.l());
        return onSaveInstanceState;
    }
}
