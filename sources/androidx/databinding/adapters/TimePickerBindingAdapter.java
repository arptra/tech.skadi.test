package androidx.databinding.adapters;

import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;

@RestrictTo
public class TimePickerBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TimePickerBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements TimePicker.OnTimeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TimePicker.OnTimeChangedListener f1005a;
        public final /* synthetic */ InverseBindingListener b;
        public final /* synthetic */ InverseBindingListener c;

        public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            TimePicker.OnTimeChangedListener onTimeChangedListener = this.f1005a;
            if (onTimeChangedListener != null) {
                onTimeChangedListener.onTimeChanged(timePicker, i, i2);
            }
            InverseBindingListener inverseBindingListener = this.b;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
            InverseBindingListener inverseBindingListener2 = this.c;
            if (inverseBindingListener2 != null) {
                inverseBindingListener2.a();
            }
        }
    }
}
