package androidx.databinding;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public class DataBindingUtil {

    /* renamed from: a  reason: collision with root package name */
    public static DataBinderMapper f968a = new DataBinderMapperImpl();
    public static DataBindingComponent b = null;

    public static ViewDataBinding a(DataBindingComponent dataBindingComponent, View view, int i) {
        return f968a.b(dataBindingComponent, view, i);
    }

    public static ViewDataBinding b(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        return f968a.c(dataBindingComponent, viewArr, i);
    }

    public static ViewDataBinding c(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return a(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return b(dataBindingComponent, viewArr, i2);
    }

    public static ViewDataBinding d(View view) {
        return ViewDataBinding.q(view);
    }

    public static ViewDataBinding e(Activity activity, int i) {
        return f(activity, i, b);
    }

    public static ViewDataBinding f(Activity activity, int i, DataBindingComponent dataBindingComponent) {
        activity.setContentView(i);
        return c(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i);
    }
}
