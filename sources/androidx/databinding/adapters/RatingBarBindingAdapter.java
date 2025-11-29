package androidx.databinding.adapters;

import android.widget.RatingBar;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
public class RatingBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.RatingBarBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RatingBar.OnRatingBarChangeListener f998a;
        public final /* synthetic */ InverseBindingListener b;

        public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
            RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = this.f998a;
            if (onRatingBarChangeListener != null) {
                onRatingBarChangeListener.onRatingChanged(ratingBar, f, z);
            }
            this.b.a();
        }
    }
}
