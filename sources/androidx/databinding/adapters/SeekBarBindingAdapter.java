package androidx.databinding.adapters;

import android.widget.SeekBar;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
public class SeekBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnProgressChanged f1001a;
        public final /* synthetic */ InverseBindingListener b;
        public final /* synthetic */ OnStartTrackingTouch c;
        public final /* synthetic */ OnStopTrackingTouch d;

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            OnProgressChanged onProgressChanged = this.f1001a;
            if (onProgressChanged != null) {
                onProgressChanged.onProgressChanged(seekBar, i, z);
            }
            InverseBindingListener inverseBindingListener = this.b;
            if (inverseBindingListener != null) {
                inverseBindingListener.a();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            OnStartTrackingTouch onStartTrackingTouch = this.c;
            if (onStartTrackingTouch != null) {
                onStartTrackingTouch.onStartTrackingTouch(seekBar);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            OnStopTrackingTouch onStopTrackingTouch = this.d;
            if (onStopTrackingTouch != null) {
                onStopTrackingTouch.onStopTrackingTouch(seekBar);
            }
        }
    }

    public interface OnProgressChanged {
        void onProgressChanged(SeekBar seekBar, int i, boolean z);
    }

    public interface OnStartTrackingTouch {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    public interface OnStopTrackingTouch {
        void onStopTrackingTouch(SeekBar seekBar);
    }
}
