package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.o4.a;
import com.honey.account.o4.b;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.CommonAddress;

public class AddressView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5815a;
    public ImageView b;
    public CommonAddress c;
    public AddressViewActionistener d;

    public interface AddressViewActionistener {
        void a(CommonAddress commonAddress);

        void b(CommonAddress commonAddress);
    }

    public AddressView(Context context) {
        super(context);
        i(context);
        j();
    }

    private void i(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.address_view_layout, this);
    }

    private void j() {
        TextView textView = (TextView) findViewById(R.id.address_name);
        this.f5815a = textView;
        textView.setText(this.c.j());
        this.f5815a.setOnClickListener(new a(this));
        ImageView imageView = (ImageView) findViewById(R.id.address_menu);
        this.b = imageView;
        imageView.setOnClickListener(new b(this));
    }

    public CommonAddress getAddress() {
        return this.c;
    }

    public TextView getAddressName() {
        return this.f5815a;
    }

    public AddressViewActionistener getViewActionListener() {
        return this.d;
    }

    public final /* synthetic */ void k(View view) {
        AddressViewActionistener addressViewActionistener = this.d;
        if (addressViewActionistener != null) {
            addressViewActionistener.a(this.c);
        }
    }

    public final /* synthetic */ void l(View view) {
        AddressViewActionistener addressViewActionistener = this.d;
        if (addressViewActionistener != null) {
            addressViewActionistener.b(this.c);
        }
    }

    public void setAddress(CommonAddress commonAddress) {
        this.c = commonAddress;
    }

    public void setAddressName(String str) {
        this.f5815a.setText(str);
    }

    public void setViewActionListener(AddressViewActionistener addressViewActionistener) {
        this.d = addressViewActionistener;
    }

    public AddressView(Context context, CommonAddress commonAddress) {
        super(context);
        this.c = commonAddress;
        i(context);
        j();
    }

    public AddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
        j();
    }

    public AddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i(context);
        j();
    }
}
