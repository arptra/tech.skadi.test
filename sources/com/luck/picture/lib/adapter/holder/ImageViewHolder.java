package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.StyleUtils;

public class ImageViewHolder extends BaseRecyclerMediaHolder {
    public final ImageView l;
    public final TextView m;

    public ImageViewHolder(View view, SelectorConfig selectorConfig) {
        super(view, selectorConfig);
        this.m = (TextView) view.findViewById(R.id.tv_media_tag);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivEditor);
        this.l = imageView;
        SelectMainStyle c = this.e.K0.c();
        int m2 = c.m();
        if (StyleUtils.c(m2)) {
            imageView.setImageResource(m2);
        }
        int[] l2 = c.l();
        if (StyleUtils.a(l2) && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).removeRule(12);
            for (int addRule : l2) {
                ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).addRule(addRule);
            }
        }
        int[] w = c.w();
        if (StyleUtils.a(w) && (this.m.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) this.m.getLayoutParams()).removeRule(21);
            ((RelativeLayout.LayoutParams) this.m.getLayoutParams()).removeRule(12);
            for (int addRule2 : w) {
                ((RelativeLayout.LayoutParams) this.m.getLayoutParams()).addRule(addRule2);
            }
        }
        int v = c.v();
        if (StyleUtils.c(v)) {
            this.m.setBackgroundResource(v);
        }
        int y = c.y();
        if (StyleUtils.b(y)) {
            this.m.setTextSize((float) y);
        }
        int x = c.x();
        if (StyleUtils.c(x)) {
            this.m.setTextColor(x);
        }
    }

    public void d(LocalMedia localMedia, int i) {
        super.d(localMedia, i);
        if (!localMedia.isEditorImage() || !localMedia.isCut()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.m.setVisibility(0);
        if (PictureMimeType.f(localMedia.getMimeType())) {
            this.m.setText(this.d.getString(R.string.ps_gif_tag));
        } else if (PictureMimeType.j(localMedia.getMimeType())) {
            this.m.setText(this.d.getString(R.string.ps_webp_tag));
        } else if (MediaUtils.p(localMedia.getWidth(), localMedia.getHeight())) {
            this.m.setText(this.d.getString(R.string.ps_long_chart));
        } else {
            this.m.setVisibility(8);
        }
    }
}
