package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.MediaPlayerEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.IntentUtils;

public class PreviewVideoHolder extends BasePreviewHolder {
    public ImageView h;
    public ProgressBar i;
    public View j;
    public boolean k = false;
    public final OnPlayerListener l = new OnPlayerListener() {
        public void a() {
            PreviewVideoHolder.this.w();
        }

        public void b() {
            PreviewVideoHolder.this.v();
        }

        public void c() {
            PreviewVideoHolder.this.v();
        }
    };

    public PreviewVideoHolder(View view) {
        super(view);
        this.h = (ImageView) view.findViewById(R.id.iv_play_video);
        this.i = (ProgressBar) view.findViewById(R.id.progress);
        this.h.setVisibility(this.e.L ? 8 : 0);
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.T0 == null) {
            selectorConfig.T0 = new MediaPlayerEngine();
        }
        View g = this.e.T0.g(view.getContext());
        this.j = g;
        if (g != null) {
            if (g.getLayoutParams() == null) {
                this.j.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.indexOfChild(this.j) != -1) {
                viewGroup.removeView(this.j);
            }
            viewGroup.addView(this.j, 0);
            this.j.setVisibility(8);
            return;
        }
        throw new NullPointerException("onCreateVideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
    }

    /* access modifiers changed from: private */
    public void w() {
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setVisibility(8);
        this.j.setVisibility(0);
    }

    public void a(LocalMedia localMedia, int i2) {
        super.a(localMedia, i2);
        o(localMedia);
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.e.F0) {
                    previewVideoHolder.s();
                } else {
                    previewVideoHolder.x();
                }
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.e.F0) {
                    previewVideoHolder.s();
                    return;
                }
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = previewVideoHolder.g;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void b(View view) {
    }

    public boolean e() {
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        return videoPlayerEngine != null && videoPlayerEngine.f(this.j);
    }

    public void f(LocalMedia localMedia, int i2, int i3) {
        if (this.e.L0 != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i2 == -1 && i3 == -1) {
                this.e.L0.a(this.itemView.getContext(), availablePath, this.f);
            } else {
                this.e.L0.c(this.itemView.getContext(), this.f, availablePath, i2, i3);
            }
        }
    }

    public void g() {
        this.f.setOnViewTapListener(new OnViewTapListener() {
            public void a(View view, float f, float f2) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.g;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void h(final LocalMedia localMedia) {
        this.f.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.g;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.a(localMedia);
                return false;
            }
        });
    }

    public void i() {
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.e(this.j);
            this.e.T0.c(this.l);
        }
    }

    public void j() {
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.i(this.j);
            this.e.T0.a(this.l);
        }
        v();
    }

    public void k() {
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.a(this.l);
            this.e.T0.b(this.j);
        }
    }

    public void l() {
        if (e()) {
            t();
        } else {
            u();
        }
    }

    public void o(LocalMedia localMedia) {
        super.o(localMedia);
        if (!this.e.L && this.f9349a < this.b) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = this.f9349a;
                layoutParams2.height = this.c;
                layoutParams2.gravity = 17;
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = this.f9349a;
                layoutParams3.height = this.c;
                layoutParams3.addRule(13);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.width = this.f9349a;
                layoutParams4.height = this.c;
                layoutParams4.gravity = 17;
            } else if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams5.width = this.f9349a;
                layoutParams5.height = this.c;
                layoutParams5.i = 0;
                layoutParams5.l = 0;
            }
        }
    }

    public final void s() {
        if (!this.k) {
            x();
        } else if (e()) {
            t();
        } else {
            u();
        }
    }

    public void t() {
        this.h.setVisibility(0);
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.j(this.j);
        }
    }

    public final void u() {
        this.h.setVisibility(8);
        VideoPlayerEngine videoPlayerEngine = this.e.T0;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.h(this.j);
        }
    }

    public final void v() {
        this.k = false;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        this.j.setVisibility(8);
        BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = this.g;
        if (onPreviewEventListener != null) {
            onPreviewEventListener.b((String) null);
        }
    }

    public void x() {
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.J0) {
            IntentUtils.a(this.itemView.getContext(), this.d.getAvailablePath());
        } else if (this.j == null) {
            throw new NullPointerException("VideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
        } else if (selectorConfig.T0 != null) {
            this.i.setVisibility(0);
            this.h.setVisibility(8);
            this.g.b(this.d.getFileName());
            this.k = true;
            this.e.T0.d(this.j, this.d);
        }
    }
}
