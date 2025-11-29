package com.luck.picture.lib.adapter.holder;

import android.view.View;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;

public class PreviewImageHolder extends BasePreviewHolder {
    public PreviewImageHolder(View view) {
        super(view);
    }

    public void b(View view) {
    }

    public void f(LocalMedia localMedia, int i, int i2) {
        if (this.e.L0 != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i == -1 && i2 == -1) {
                this.e.L0.a(this.itemView.getContext(), availablePath, this.f);
            } else {
                this.e.L0.c(this.itemView.getContext(), this.f, availablePath, i, i2);
            }
        }
    }

    public void g() {
        this.f.setOnViewTapListener(new OnViewTapListener() {
            public void a(View view, float f, float f2) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewImageHolder.this.g;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void h(final LocalMedia localMedia) {
        this.f.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewImageHolder.this.g;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.a(localMedia);
                return false;
            }
        });
    }
}
