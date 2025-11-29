package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.navi.lite.R;

public class ActionBarView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public Button f5813a;
    public TextView b;
    public TextView c;

    public ActionBarView(Context context) {
        super(context);
        g(context);
    }

    private void h() {
        this.f5813a = (Button) findViewById(R.id.navi_bar_btn);
        this.b = (TextView) findViewById(R.id.navi_bar_text);
        this.c = (TextView) findViewById(R.id.navi_bar_text_end);
    }

    public final void g(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_actionbar_layout, this);
        h();
    }

    public Button getBackBtn() {
        return this.f5813a;
    }

    public TextView getBarText() {
        return this.b;
    }

    public TextView getBarTextEnd() {
        return this.c;
    }

    public void i(View.OnClickListener onClickListener, String str) {
        if (this.c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.c.setText(str);
                this.c.setOnClickListener(onClickListener);
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public void setBackBtnClick(View.OnClickListener onClickListener) {
        Button button = this.f5813a;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void setBarText(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public ActionBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
    }

    public ActionBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context);
    }
}
