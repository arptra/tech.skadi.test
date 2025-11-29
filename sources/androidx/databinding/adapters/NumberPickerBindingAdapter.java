package androidx.databinding.adapters;

import android.widget.NumberPicker;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@BindingMethods
@InverseBindingMethods
@RestrictTo
public class NumberPickerBindingAdapter {

    /* renamed from: androidx.databinding.adapters.NumberPickerBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements NumberPicker.OnValueChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NumberPicker.OnValueChangeListener f994a;
        public final /* synthetic */ InverseBindingListener b;

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            NumberPicker.OnValueChangeListener onValueChangeListener = this.f994a;
            if (onValueChangeListener != null) {
                onValueChangeListener.onValueChange(numberPicker, i, i2);
            }
            this.b.a();
        }
    }
}
