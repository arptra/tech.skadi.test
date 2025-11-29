package com.upuphone.ar.navi.lite.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;

public class CustomDialog extends Dialog implements View.OnClickListener {
    public static final String r = ("NAVI-" + CustomDialog.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5823a;
    public LinearLayout b;
    public ImageView c;
    public String d;
    public String e;
    public String f;
    public String g;
    public View.OnClickListener h;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public boolean o = false;
    public boolean p = true;
    public boolean q = false;

    public CustomDialog(Context context) {
        super(context);
        this.f5823a = context;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public CustomDialog b(View.OnClickListener onClickListener) {
        this.h = onClickListener;
        return this;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public void d(boolean z) {
        this.q = z;
    }

    public CustomDialog e(String str, View.OnClickListener onClickListener) {
        this.g = str;
        this.i = onClickListener;
        return this;
    }

    public CustomDialog f(String str, View.OnClickListener onClickListener) {
        this.f = str;
        this.j = onClickListener;
        return this;
    }

    public CustomDialog g(int i2) {
        this.m = i2;
        return this;
    }

    public CustomDialog h(int i2) {
        this.k = i2;
        return this;
    }

    public CustomDialog i(String str) {
        this.e = str;
        return this;
    }

    public CustomDialog j(String str) {
        this.d = str;
        return this;
    }

    public final void k() {
        boolean b2 = CSharedPreferences.b(this.f5823a, "navi_show_back_ground_location_guid", true);
        String str = r;
        CLog.b(str, "updateCheckStatue  ########## showGuide=" + b2);
        boolean z = b2 ^ true;
        CLog.b(str, "updateCheckStatue  @@@@@@@@@@@ showGuide=" + z);
        this.c.setImageResource(z ? R.drawable.check_off : R.drawable.check_on);
        CSharedPreferences.p(this.f5823a, "navi_show_back_ground_location_guid", z);
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.confirm) {
            View.OnClickListener onClickListener2 = this.j;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id == R.id.cancel && (onClickListener = this.i) != null) {
            onClickListener.onClick(view);
        } else if (id == R.id.check_layout) {
            k();
            this.h.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.navi_custom_dialog_layout);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.width = (int) (((double) point.x) * 0.9d);
        int i2 = 17;
        getWindow().setGravity(this.o ? 80 : 17);
        getWindow().setAttributes(attributes);
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.message);
        if (!this.p) {
            i2 = 3;
        }
        textView2.setGravity(i2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.check_layout);
        this.b = linearLayout;
        linearLayout.setVisibility(this.q ? 0 : 8);
        this.c = (ImageView) findViewById(R.id.check_btn);
        TextView textView3 = (TextView) findViewById(R.id.cancel);
        TextView textView4 = (TextView) findViewById(R.id.confirm);
        View findViewById = findViewById(R.id.empty);
        if (!TextUtils.isEmpty(this.d)) {
            textView.setText(this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            textView2.setText(this.e);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.g)) {
            textView3.setText(this.g);
        }
        textView3.setVisibility(TextUtils.isEmpty(this.g) ? 8 : 0);
        if (!TextUtils.isEmpty(this.f)) {
            textView4.setText(this.f);
        }
        if (this.k != 0) {
            textView4.setTextColor(getContext().getColor(this.k));
        }
        int i3 = this.m;
        if (i3 != 0) {
            textView4.setBackgroundResource(i3);
        }
        if (this.l != 0) {
            textView3.setTextColor(getContext().getColor(this.l));
        }
        int i4 = this.n;
        if (i4 != 0) {
            textView3.setBackgroundResource(i4);
        }
        this.b.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView3.setVisibility(TextUtils.isEmpty(this.g) ? 8 : 0);
        textView4.setVisibility(TextUtils.isEmpty(this.f) ? 8 : 0);
        if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }
}
