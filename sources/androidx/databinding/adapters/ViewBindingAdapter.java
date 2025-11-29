package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
public class ViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnViewAttachedToWindow f1006a;
        public final /* synthetic */ OnViewDetachedFromWindow b;

        public void onViewAttachedToWindow(View view) {
            OnViewAttachedToWindow onViewAttachedToWindow = this.f1006a;
            if (onViewAttachedToWindow != null) {
                onViewAttachedToWindow.onViewAttachedToWindow(view);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            OnViewDetachedFromWindow onViewDetachedFromWindow = this.b;
            if (onViewDetachedFromWindow != null) {
                onViewDetachedFromWindow.onViewDetachedFromWindow(view);
            }
        }
    }

    @TargetApi(12)
    public interface OnViewAttachedToWindow {
        void onViewAttachedToWindow(View view);
    }

    @TargetApi(12)
    public interface OnViewDetachedFromWindow {
        void onViewDetachedFromWindow(View view);
    }
}
