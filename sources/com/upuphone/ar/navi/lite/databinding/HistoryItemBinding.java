package com.upuphone.ar.navi.lite.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.upuphone.ar.navi.lite.base.Record;

public abstract class HistoryItemBinding extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    public Record C;
    public final ImageView z;

    public HistoryItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.z = imageView;
        this.A = textView;
        this.B = textView2;
    }
}
