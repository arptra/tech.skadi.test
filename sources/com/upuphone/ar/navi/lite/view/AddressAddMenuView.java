package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.navi.lite.R;

public class AddressAddMenuView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5814a;
    public TextView b;
    public NaviTopViewActionistener c;

    public interface NaviTopViewActionistener {
    }

    public AddressAddMenuView(Context context) {
        super(context);
        g(context);
        h();
    }

    private void g(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.address_add_menu_view_layout, this);
    }

    private void h() {
        this.f5814a = (TextView) findViewById(R.id.address_add);
        this.b = (TextView) findViewById(R.id.address_full);
        this.b.setText(String.format(getContext().getString(R.string.addr_more_full), new Object[]{"12"}));
    }

    public NaviTopViewActionistener getViewActionListener() {
        return this.c;
    }

    public void setInfoVisible(boolean z) {
        int i = 0;
        this.f5814a.setVisibility(z ? 8 : 0);
        TextView textView = this.b;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void setViewActionListener(NaviTopViewActionistener naviTopViewActionistener) {
        this.c = naviTopViewActionistener;
    }

    public AddressAddMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
        h();
    }

    public AddressAddMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context);
        h();
    }
}
