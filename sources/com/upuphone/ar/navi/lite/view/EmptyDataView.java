package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;

public class EmptyDataView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f5825a;
    public TextView b;

    public EmptyDataView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.empty_data_layout, this);
        this.f5825a = (ImageView) findViewById(R.id.icon_image);
        this.b = (TextView) findViewById(R.id.desp);
    }

    public TextView getDesp() {
        return this.b;
    }

    public ImageView getIconImage() {
        return this.f5825a;
    }

    public void setDesp(int i) {
        this.b.setText(i);
    }

    public void setIconImage(int i) {
        this.f5825a.setImageResource(i);
    }

    public EmptyDataView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
