package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.StyleUtils;

public class AudioViewHolder extends BaseRecyclerMediaHolder {
    public final TextView l;

    public AudioViewHolder(View view, SelectorConfig selectorConfig) {
        super(view, selectorConfig);
        TextView textView = (TextView) view.findViewById(R.id.tv_duration);
        this.l = textView;
        SelectMainStyle c = this.e.K0.c();
        int h = c.h();
        if (StyleUtils.c(h)) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(h, 0, 0, 0);
        }
        int k = c.k();
        if (StyleUtils.b(k)) {
            textView.setTextSize((float) k);
        }
        int j = c.j();
        if (StyleUtils.c(j)) {
            textView.setTextColor(j);
        }
        int g = c.g();
        if (StyleUtils.c(g)) {
            textView.setBackgroundResource(g);
        }
        int[] i = c.i();
        if (StyleUtils.a(i) && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) textView.getLayoutParams()).removeRule(12);
            for (int addRule : i) {
                ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).addRule(addRule);
            }
        }
    }

    public void d(LocalMedia localMedia, int i) {
        super.d(localMedia, i);
        this.l.setText(DateUtils.b(localMedia.getDuration()));
    }

    public void h(String str) {
        this.f9350a.setImageResource(R.drawable.ps_audio_placeholder);
    }
}
