package androidx.databinding.adapters;

import android.widget.RadioGroup;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
public class RadioGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.RadioGroupBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioGroup.OnCheckedChangeListener f997a;
        public final /* synthetic */ InverseBindingListener b;

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.f997a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(radioGroup, i);
            }
            this.b.a();
        }
    }
}
