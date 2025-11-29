package androidx.databinding.adapters;

import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@BindingMethods
@InverseBindingMethods
@RestrictTo
public class CompoundButtonBindingAdapter {

    /* renamed from: androidx.databinding.adapters.CompoundButtonBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CompoundButton.OnCheckedChangeListener f991a;
        public final /* synthetic */ InverseBindingListener b;

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f991a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z);
            }
            this.b.a();
        }
    }
}
