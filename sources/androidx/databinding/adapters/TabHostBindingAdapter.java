package androidx.databinding.adapters;

import android.widget.TabHost;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;

@RestrictTo
public class TabHostBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TabHostBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements TabHost.OnTabChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabHost.OnTabChangeListener f1002a;
        public final /* synthetic */ InverseBindingListener b;

        public void onTabChanged(String str) {
            TabHost.OnTabChangeListener onTabChangeListener = this.f1002a;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
            this.b.a();
        }
    }
}
