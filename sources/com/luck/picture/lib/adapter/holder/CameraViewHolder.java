package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;

public class CameraViewHolder extends BaseRecyclerMediaHolder {
    public CameraViewHolder(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(R.id.tvCamera);
        SelectorConfig d = SelectorProviders.c().d();
        this.e = d;
        SelectMainStyle c = d.K0.c();
        int a2 = c.a();
        if (StyleUtils.c(a2)) {
            textView.setBackgroundColor(a2);
        }
        int b = c.b();
        if (StyleUtils.c(b)) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, b, 0, 0);
        }
        String string = StyleUtils.c(c.e()) ? view.getContext().getString(c.e()) : c.c();
        if (StyleUtils.f(string)) {
            textView.setText(string);
        } else if (this.e.f9404a == SelectMimeType.b()) {
            textView.setText(view.getContext().getString(R.string.ps_tape));
        }
        int f = c.f();
        if (StyleUtils.b(f)) {
            textView.setTextSize((float) f);
        }
        int d2 = c.d();
        if (StyleUtils.c(d2)) {
            textView.setTextColor(d2);
        }
    }
}
