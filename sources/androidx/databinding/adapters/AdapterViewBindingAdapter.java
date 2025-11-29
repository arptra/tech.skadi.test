package androidx.databinding.adapters;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@BindingMethods
@RestrictTo
@InverseBindingMethods
public class AdapterViewBindingAdapter {

    public interface OnItemSelected {
        void onItemSelected(AdapterView adapterView, View view, int i, long j);
    }

    public static class OnItemSelectedComponentListener implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        public final OnItemSelected f988a;
        public final OnNothingSelected b;
        public final InverseBindingListener c;

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            OnItemSelected onItemSelected = this.f988a;
            if (onItemSelected != null) {
                onItemSelected.onItemSelected(adapterView, view, i, j);
            }
            InverseBindingListener inverseBindingListener = this.c;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
            OnNothingSelected onNothingSelected = this.b;
            if (onNothingSelected != null) {
                onNothingSelected.onNothingSelected(adapterView);
            }
            InverseBindingListener inverseBindingListener = this.c;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
        }
    }

    public interface OnNothingSelected {
        void onNothingSelected(AdapterView adapterView);
    }
}
