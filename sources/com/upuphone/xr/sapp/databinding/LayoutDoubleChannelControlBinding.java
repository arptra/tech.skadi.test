package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutDoubleChannelControlBinding extends ViewDataBinding {
    public final Button A;
    public final Button B;
    public final Button C;
    public final Button D;
    public final Button E;
    public final TextView F;
    public final TextView G;
    public final Button z;

    public LayoutDoubleChannelControlBinding(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.z = button;
        this.A = button2;
        this.B = button3;
        this.C = button4;
        this.D = button5;
        this.E = button6;
        this.F = textView;
        this.G = textView2;
    }
}
