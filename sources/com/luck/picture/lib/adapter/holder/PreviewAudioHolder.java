package com.luck.picture.lib.adapter.holder;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class PreviewAudioHolder extends BasePreviewHolder {
    public final Handler h = new Handler(Looper.getMainLooper());
    public ImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public SeekBar m;
    public ImageView n;
    public ImageView o;
    public MediaPlayer p = new MediaPlayer();
    public boolean q = false;
    public Runnable r = new Runnable() {
        public void run() {
            long currentPosition = (long) PreviewAudioHolder.this.p.getCurrentPosition();
            String b = DateUtils.b(currentPosition);
            if (!TextUtils.equals(b, PreviewAudioHolder.this.l.getText())) {
                PreviewAudioHolder.this.l.setText(b);
                if (((long) PreviewAudioHolder.this.p.getDuration()) - currentPosition > 1000) {
                    PreviewAudioHolder.this.m.setProgress((int) currentPosition);
                } else {
                    PreviewAudioHolder previewAudioHolder = PreviewAudioHolder.this;
                    previewAudioHolder.m.setProgress(previewAudioHolder.p.getDuration());
                }
            }
            PreviewAudioHolder.this.h.postDelayed(this, 1000 - (currentPosition % 1000));
        }
    };
    public final MediaPlayer.OnCompletionListener s = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            PreviewAudioHolder.this.Q();
            PreviewAudioHolder.this.H();
            PreviewAudioHolder.this.F(true);
        }
    };
    public final MediaPlayer.OnErrorListener t = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PreviewAudioHolder.this.H();
            PreviewAudioHolder.this.F(true);
            return false;
        }
    };
    public final MediaPlayer.OnPreparedListener u = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (mediaPlayer.isPlaying()) {
                PreviewAudioHolder.this.m.setMax(mediaPlayer.getDuration());
                PreviewAudioHolder.this.P();
                PreviewAudioHolder.this.G();
                return;
            }
            PreviewAudioHolder.this.Q();
            PreviewAudioHolder.this.H();
            PreviewAudioHolder.this.F(true);
        }
    };

    public PreviewAudioHolder(View view) {
        super(view);
        this.i = (ImageView) view.findViewById(R.id.iv_play_video);
        this.j = (TextView) view.findViewById(R.id.tv_audio_name);
        this.l = (TextView) view.findViewById(R.id.tv_current_time);
        this.k = (TextView) view.findViewById(R.id.tv_total_duration);
        this.m = (SeekBar) view.findViewById(R.id.music_seek_bar);
        this.n = (ImageView) view.findViewById(R.id.iv_play_back);
        this.o = (ImageView) view.findViewById(R.id.iv_play_fast);
    }

    public final void D() {
        long progress = ((long) this.m.getProgress()) + 3000;
        if (progress >= ((long) this.m.getMax())) {
            SeekBar seekBar = this.m;
            seekBar.setProgress(seekBar.getMax());
        } else {
            this.m.setProgress((int) progress);
        }
        K(this.m.getProgress());
        this.p.seekTo(this.m.getProgress());
    }

    public final void E() {
        this.p.pause();
        this.q = true;
        F(false);
        Q();
    }

    public final void F(boolean z) {
        Q();
        if (z) {
            this.m.setProgress(0);
            this.l.setText("00:00");
        }
        J(false);
        this.i.setImageResource(R.drawable.ps_ic_audio_play);
        BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = this.g;
        if (onPreviewEventListener != null) {
            onPreviewEventListener.b((String) null);
        }
    }

    public final void G() {
        P();
        J(true);
        this.i.setImageResource(R.drawable.ps_ic_audio_stop);
    }

    public final void H() {
        this.q = false;
        this.p.stop();
        this.p.reset();
    }

    public final void I() {
        this.p.seekTo(this.m.getProgress());
        this.p.start();
        P();
        G();
    }

    public final void J(boolean z) {
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        if (z) {
            this.n.setAlpha(1.0f);
            this.o.setAlpha(1.0f);
            return;
        }
        this.n.setAlpha(0.5f);
        this.o.setAlpha(0.5f);
    }

    public final void K(int i2) {
        this.l.setText(DateUtils.b((long) i2));
    }

    public final void L() {
        this.p.setOnCompletionListener(this.s);
        this.p.setOnErrorListener(this.t);
        this.p.setOnPreparedListener(this.u);
    }

    public final void M() {
        this.p.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
        this.p.setOnErrorListener((MediaPlayer.OnErrorListener) null);
        this.p.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
    }

    public final void N() {
        long progress = ((long) this.m.getProgress()) - 3000;
        if (progress <= 0) {
            this.m.setProgress(0);
        } else {
            this.m.setProgress((int) progress);
        }
        K(this.m.getProgress());
        this.p.seekTo(this.m.getProgress());
    }

    public final void O(String str) {
        try {
            if (PictureMimeType.c(str)) {
                this.p.setDataSource(this.itemView.getContext(), Uri.parse(str));
            } else {
                this.p.setDataSource(str);
            }
            this.p.prepare();
            this.p.seekTo(this.m.getProgress());
            this.p.start();
            this.q = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void P() {
        this.h.post(this.r);
    }

    public final void Q() {
        this.h.removeCallbacks(this.r);
    }

    public void a(final LocalMedia localMedia, int i2) {
        final String availablePath = localMedia.getAvailablePath();
        String f = DateUtils.f(localMedia.getDateAddedTime());
        String e = PictureFileUtils.e(localMedia.getSize());
        f(localMedia, -1, -1);
        StringBuilder sb = new StringBuilder();
        sb.append(localMedia.getFileName());
        sb.append(StringUtils.LF);
        sb.append(f);
        sb.append(" - ");
        sb.append(e);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
        String str = f + " - " + e;
        int indexOf = sb.indexOf(str);
        int length = str.length() + indexOf;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(DensityUtil.a(this.itemView.getContext(), 12.0f)), indexOf, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-10132123), indexOf, length, 17);
        this.j.setText(spannableStringBuilder);
        this.k.setText(DateUtils.b(localMedia.getDuration()));
        this.m.setMax((int) localMedia.getDuration());
        J(false);
        this.n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PreviewAudioHolder.this.N();
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PreviewAudioHolder.this.D();
            }
        });
        this.m.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    seekBar.setProgress(i);
                    PreviewAudioHolder.this.K(i);
                    if (PreviewAudioHolder.this.e()) {
                        PreviewAudioHolder.this.p.seekTo(seekBar.getProgress());
                    }
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.g;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (!DoubleUtils.a()) {
                        PreviewAudioHolder.this.g.b(localMedia.getFileName());
                        if (PreviewAudioHolder.this.e()) {
                            PreviewAudioHolder.this.E();
                        } else if (PreviewAudioHolder.this.q) {
                            PreviewAudioHolder.this.I();
                        } else {
                            PreviewAudioHolder.this.O(availablePath);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.g;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.a(localMedia);
                return false;
            }
        });
    }

    public void b(View view) {
    }

    public boolean e() {
        MediaPlayer mediaPlayer = this.p;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void f(LocalMedia localMedia, int i2, int i3) {
        this.j.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.ps_ic_audio_play_cover, 0, 0);
    }

    public void g() {
        this.f.setOnViewTapListener(new OnViewTapListener() {
            public void a(View view, float f, float f2) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.g;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void h(final LocalMedia localMedia) {
        this.f.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.g;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.a(localMedia);
                return false;
            }
        });
    }

    public void i() {
        this.q = false;
        L();
        F(true);
    }

    public void j() {
        this.q = false;
        this.h.removeCallbacks(this.r);
        M();
        H();
        F(true);
    }

    public void k() {
        this.h.removeCallbacks(this.r);
        if (this.p != null) {
            M();
            this.p.release();
            this.p = null;
        }
    }

    public void l() {
        if (e()) {
            E();
        } else {
            I();
        }
    }
}
