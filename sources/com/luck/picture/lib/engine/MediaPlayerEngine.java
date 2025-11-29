package com.luck.picture.lib.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.widget.MediaPlayerView;
import java.util.concurrent.CopyOnWriteArrayList;

public class MediaPlayerEngine implements VideoPlayerEngine<MediaPlayerView> {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f9416a = new CopyOnWriteArrayList();

    public void a(OnPlayerListener onPlayerListener) {
        if (onPlayerListener != null) {
            this.f9416a.remove(onPlayerListener);
        } else {
            this.f9416a.clear();
        }
    }

    public void c(OnPlayerListener onPlayerListener) {
        if (!this.f9416a.contains(onPlayerListener)) {
            this.f9416a.add(onPlayerListener);
        }
    }

    public View g(Context context) {
        return new MediaPlayerView(context);
    }

    /* renamed from: l */
    public void b(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.e();
    }

    /* renamed from: m */
    public boolean f(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    /* renamed from: n */
    public void j(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    /* renamed from: o */
    public void e(final MediaPlayerView mediaPlayerView) {
        MediaPlayer d = mediaPlayerView.d();
        d.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                for (int i = 0; i < MediaPlayerEngine.this.f9416a.size(); i++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.f9416a.get(i)).a();
                }
            }
        });
        d.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                for (int i = 0; i < MediaPlayerEngine.this.f9416a.size(); i++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.f9416a.get(i)).b();
                }
                mediaPlayerView.b();
            }
        });
        d.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                for (int i3 = 0; i3 < MediaPlayerEngine.this.f9416a.size(); i3++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.f9416a.get(i3)).c();
                }
                return false;
            }
        });
    }

    /* renamed from: p */
    public void i(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.e();
    }

    /* renamed from: q */
    public void h(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /* renamed from: r */
    public void d(MediaPlayerView mediaPlayerView, LocalMedia localMedia) {
        String availablePath = localMedia.getAvailablePath();
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        mediaPlayerView.getSurfaceView().setZOrderOnTop(PictureMimeType.g(availablePath));
        mediaPlayer.setLooping(SelectorProviders.c().d().C0);
        mediaPlayerView.f(availablePath);
    }
}
