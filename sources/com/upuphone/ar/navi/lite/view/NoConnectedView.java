package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.honey.account.o4.s;
import com.honey.account.o4.t;
import com.upuphone.ar.navi.lite.R;

public class NoConnectedView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5839a;
    public LinearLayout b;
    public RelativeLayout c;
    public boolean d = true;
    public RelativeLayout e;
    public NoConnectedViewActionistener f;

    public interface NoConnectedViewActionistener {
        void a();

        void b();
    }

    public NoConnectedView(Context context) {
        super(context);
        d(context);
    }

    public void c(boolean z) {
        this.f5839a.setVisibility(z ? 0 : 8);
    }

    public final void d(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.no_connected_view, this);
        e();
    }

    public final void e() {
        this.f5839a = (TextView) findViewById(R.id.device_connect);
        this.b = (LinearLayout) findViewById(R.id.no_network_view);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.not_network);
        this.e = relativeLayout;
        relativeLayout.setOnClickListener(new s(this));
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.close_icon);
        this.c = relativeLayout2;
        relativeLayout2.setOnClickListener(new t(this));
    }

    public final /* synthetic */ void f(View view) {
        NoConnectedViewActionistener noConnectedViewActionistener = this.f;
        if (noConnectedViewActionistener != null) {
            noConnectedViewActionistener.a();
        }
    }

    public final /* synthetic */ void g(View view) {
        NoConnectedViewActionistener noConnectedViewActionistener = this.f;
        if (noConnectedViewActionistener != null) {
            noConnectedViewActionistener.b();
        }
    }

    public NoConnectedViewActionistener getNoConnectedViewActionistener() {
        return this.f;
    }

    public void h(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }

    public void setConnected(boolean z) {
        this.d = z;
    }

    public void setNoConnectedViewActionistener(NoConnectedViewActionistener noConnectedViewActionistener) {
        this.f = noConnectedViewActionistener;
    }

    public NoConnectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public NoConnectedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }
}
