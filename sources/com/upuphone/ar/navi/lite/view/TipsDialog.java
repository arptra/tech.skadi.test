package com.upuphone.ar.navi.lite.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;

public class TipsDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public String f5852a;
    public String b;
    public int c = 17;

    public TipsDialog(Context context) {
        super(context);
    }

    public final void a() {
        TextView textView = (TextView) findViewById(R.id.tips_title);
        textView.setText(!TextUtils.isEmpty(this.f5852a) ? this.f5852a : textView.getText());
        TextView textView2 = (TextView) findViewById(R.id.tips_message);
        textView2.setText(!TextUtils.isEmpty(this.b) ? this.b : textView2.getText());
        textView2.setVisibility(!TextUtils.isEmpty(this.b) ? 0 : 8);
    }

    public final void b() {
        getWindow().setGravity(this.c);
    }

    public void c(int i) {
        this.c = i;
    }

    public TipsDialog d(String str) {
        this.b = str;
        return this;
    }

    public TipsDialog e(String str) {
        this.f5852a = str;
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.navi_tip_dialog_layout);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.width = (int) (((double) point.x) * 0.95d);
        getWindow().setAttributes(attributes);
        b();
        a();
    }
}
