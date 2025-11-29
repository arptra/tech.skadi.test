package androidx.databinding.adapters;

import android.widget.DatePicker;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
public class DatePickerBindingAdapter {

    public static class DateChangedListener implements DatePicker.OnDateChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public DatePicker.OnDateChangedListener f992a;
        public InverseBindingListener b;
        public InverseBindingListener c;
        public InverseBindingListener d;

        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            DatePicker.OnDateChangedListener onDateChangedListener = this.f992a;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(datePicker, i, i2, i3);
            }
            InverseBindingListener inverseBindingListener = this.b;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
            InverseBindingListener inverseBindingListener2 = this.c;
            if (inverseBindingListener2 != null) {
                inverseBindingListener2.a();
            }
            InverseBindingListener inverseBindingListener3 = this.d;
            if (inverseBindingListener3 != null) {
                inverseBindingListener3.a();
            }
        }
    }
}
