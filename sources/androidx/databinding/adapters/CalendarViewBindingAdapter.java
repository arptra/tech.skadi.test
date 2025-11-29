package androidx.databinding.adapters;

import android.widget.CalendarView;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
public class CalendarViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.CalendarViewBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements CalendarView.OnDateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CalendarView.OnDateChangeListener f990a;
        public final /* synthetic */ InverseBindingListener b;

        public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
            CalendarView.OnDateChangeListener onDateChangeListener = this.f990a;
            if (onDateChangeListener != null) {
                onDateChangeListener.onSelectedDayChange(calendarView, i, i2, i3);
            }
            this.b.a();
        }
    }
}
