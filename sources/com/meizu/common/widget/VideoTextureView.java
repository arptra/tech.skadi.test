package com.meizu.common.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer;
    private PlayerVideo mPlayerVideo;
    /* access modifiers changed from: private */
    public Surface mSurface;
    /* access modifiers changed from: private */
    public Uri mUri;

    public class PlayerVideo extends Thread {
        private PlayerVideo() {
        }

        public void run() {
            try {
                MediaPlayer unused = VideoTextureView.this.mMediaPlayer = new MediaPlayer();
                VideoTextureView.this.mMediaPlayer.setSurface(VideoTextureView.this.mSurface);
                VideoTextureView.this.mMediaPlayer.setDataSource(VideoTextureView.this.getContext(), VideoTextureView.this.mUri);
                VideoTextureView.this.mMediaPlayer.setAudioStreamType(3);
                VideoTextureView.this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        VideoTextureView.this.mMediaPlayer.start();
                    }
                });
                VideoTextureView.this.mMediaPlayer.setLooping(true);
                VideoTextureView.this.mMediaPlayer.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public VideoTextureView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurface = new Surface(surfaceTexture);
        if (this.mPlayerVideo == null) {
            PlayerVideo playerVideo = new PlayerVideo();
            this.mPlayerVideo = playerVideo;
            playerVideo.start();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mPlayerVideo = null;
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        this.mMediaPlayer.pause();
    }

    public void setSourceUri(Uri uri) {
        this.mUri = uri;
    }

    public void start() {
        this.mMediaPlayer.start();
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }

    public void updateSourceUri(Uri uri) {
        this.mUri = uri;
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        PlayerVideo playerVideo = new PlayerVideo();
        this.mPlayerVideo = playerVideo;
        playerVideo.start();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
