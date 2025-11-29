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
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;

public class PermissionDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public String f5840a;
    public String b;
    public String c;
    public String d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public boolean k = false;

    public PermissionDialog(Context context) {
        super(context);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public PermissionDialog b(String str, View.OnClickListener onClickListener) {
        this.d = str;
        this.e = onClickListener;
        return this;
    }

    public PermissionDialog c(String str, View.OnClickListener onClickListener) {
        this.c = str;
        this.f = onClickListener;
        return this;
    }

    public PermissionDialog d(String str) {
        this.b = str;
        return this;
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.confirm) {
            View.OnClickListener onClickListener2 = this.f;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id == R.id.cancel && (onClickListener = this.e) != null) {
            onClickListener.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.navi_permission_dialog_layout);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.width = (int) (((double) point.x) * 0.9d);
        getWindow().setGravity(this.k ? 80 : 17);
        getWindow().setAttributes(attributes);
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.message);
        TextView textView3 = (TextView) findViewById(R.id.cancel);
        TextView textView4 = (TextView) findViewById(R.id.confirm);
        View findViewById = findViewById(R.id.empty);
        if (!TextUtils.isEmpty(this.f5840a)) {
            textView.setText(this.f5840a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            textView2.setText(this.b);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.d)) {
            textView3.setText(this.d);
        }
        if (!TextUtils.isEmpty(this.c)) {
            textView4.setText(this.c);
        }
        if (this.g != 0) {
            textView4.setTextColor(getContext().getColor(this.g));
        }
        int i2 = this.i;
        if (i2 != 0) {
            textView4.setBackgroundResource(i2);
        }
        if (this.h != 0) {
            textView3.setTextColor(getContext().getColor(this.h));
        }
        int i3 = this.j;
        if (i3 != 0) {
            textView3.setBackgroundResource(i3);
        }
        textView4.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView3.setVisibility(TextUtils.isEmpty(this.d) ? 8 : 0);
        textView4.setVisibility(TextUtils.isEmpty(this.c) ? 8 : 0);
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.c)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }
}
