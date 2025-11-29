package androidx.databinding.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
public class ViewGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnChildViewAdded f1007a;
        public final /* synthetic */ OnChildViewRemoved b;

        public void onChildViewAdded(View view, View view2) {
            OnChildViewAdded onChildViewAdded = this.f1007a;
            if (onChildViewAdded != null) {
                onChildViewAdded.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            OnChildViewRemoved onChildViewRemoved = this.b;
            if (onChildViewRemoved != null) {
                onChildViewRemoved.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$2  reason: invalid class name */
    class AnonymousClass2 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnAnimationStart f1008a;
        public final /* synthetic */ OnAnimationEnd b;
        public final /* synthetic */ OnAnimationRepeat c;

        public void onAnimationEnd(Animation animation) {
            OnAnimationEnd onAnimationEnd = this.b;
            if (onAnimationEnd != null) {
                onAnimationEnd.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            OnAnimationRepeat onAnimationRepeat = this.c;
            if (onAnimationRepeat != null) {
                onAnimationRepeat.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            OnAnimationStart onAnimationStart = this.f1008a;
            if (onAnimationStart != null) {
                onAnimationStart.onAnimationStart(animation);
            }
        }
    }

    public interface OnAnimationEnd {
        void onAnimationEnd(Animation animation);
    }

    public interface OnAnimationRepeat {
        void onAnimationRepeat(Animation animation);
    }

    public interface OnAnimationStart {
        void onAnimationStart(Animation animation);
    }

    public interface OnChildViewAdded {
        void onChildViewAdded(View view, View view2);
    }

    public interface OnChildViewRemoved {
        void onChildViewRemoved(View view, View view2);
    }
}
