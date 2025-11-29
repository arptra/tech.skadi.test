package com.luck.picture.lib.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.IOException;

public class MediaPlayerView extends FrameLayout implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f9480a;
    public VideoSurfaceView b;

    public static class VideoSurfaceView extends SurfaceView {

        /* renamed from: a  reason: collision with root package name */
        public int f9482a;
        public int b;

        public VideoSurfaceView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void a(int i, int i2) {
            if (i != 0 && i2 != 0) {
                this.f9482a = i;
                this.b = i2;
                getHolder().setFixedSize(i, i2);
                requestLayout();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
            if (r1 > r6) goto L_0x0060;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f9482a
                int r0 = android.view.View.getDefaultSize(r0, r6)
                int r1 = r5.b
                int r1 = android.view.View.getDefaultSize(r1, r7)
                int r2 = r5.f9482a
                if (r2 <= 0) goto L_0x007a
                int r2 = r5.b
                if (r2 <= 0) goto L_0x007a
                int r0 = android.view.View.MeasureSpec.getMode(r6)
                int r6 = android.view.View.MeasureSpec.getSize(r6)
                int r1 = android.view.View.MeasureSpec.getMode(r7)
                int r7 = android.view.View.MeasureSpec.getSize(r7)
                r2 = 1073741824(0x40000000, float:2.0)
                if (r0 != r2) goto L_0x0043
                if (r1 != r2) goto L_0x0043
                int r0 = r5.f9482a
                int r1 = r0 * r7
                int r2 = r5.b
                int r3 = r6 * r2
                if (r1 >= r3) goto L_0x0038
                int r0 = r0 * r7
                int r0 = r0 / r2
            L_0x0036:
                r1 = r7
                goto L_0x007a
            L_0x0038:
                int r1 = r0 * r7
                int r3 = r6 * r2
                if (r1 <= r3) goto L_0x0060
                int r2 = r2 * r6
                int r1 = r2 / r0
            L_0x0041:
                r0 = r6
                goto L_0x007a
            L_0x0043:
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r0 != r2) goto L_0x0054
                int r0 = r5.b
                int r0 = r0 * r6
                int r2 = r5.f9482a
                int r0 = r0 / r2
                if (r1 != r3) goto L_0x0052
                if (r0 <= r7) goto L_0x0052
                goto L_0x0060
            L_0x0052:
                r1 = r0
                goto L_0x0041
            L_0x0054:
                if (r1 != r2) goto L_0x0064
                int r1 = r5.f9482a
                int r1 = r1 * r7
                int r2 = r5.b
                int r1 = r1 / r2
                if (r0 != r3) goto L_0x0062
                if (r1 <= r6) goto L_0x0062
            L_0x0060:
                r0 = r6
                goto L_0x0036
            L_0x0062:
                r0 = r1
                goto L_0x0036
            L_0x0064:
                int r2 = r5.f9482a
                int r4 = r5.b
                if (r1 != r3) goto L_0x0070
                if (r4 <= r7) goto L_0x0070
                int r1 = r7 * r2
                int r1 = r1 / r4
                goto L_0x0072
            L_0x0070:
                r1 = r2
                r7 = r4
            L_0x0072:
                if (r0 != r3) goto L_0x0062
                if (r1 <= r6) goto L_0x0062
                int r4 = r4 * r6
                int r1 = r4 / r2
                goto L_0x0041
            L_0x007a:
                r5.setMeasuredDimension(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.MediaPlayerView.VideoSurfaceView.onMeasure(int, int):void");
        }

        public VideoSurfaceView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public MediaPlayerView(@NonNull Context context) {
        super(context);
        c();
    }

    public void b() {
        this.b.getHolder().setFormat(-1);
        this.b.getHolder().setFormat(-2);
    }

    public final void c() {
        this.b = new VideoSurfaceView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        SurfaceHolder holder = this.b.getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
    }

    public MediaPlayer d() {
        if (this.f9480a == null) {
            this.f9480a = new MediaPlayer();
        }
        this.f9480a.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                MediaPlayerView.this.b.a(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        return this.f9480a;
    }

    public void e() {
        MediaPlayer mediaPlayer = this.f9480a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f9480a.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
            this.f9480a.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
            this.f9480a.setOnErrorListener((MediaPlayer.OnErrorListener) null);
            this.f9480a = null;
        }
    }

    public void f(String str) {
        try {
            if (PictureMimeType.c(str)) {
                this.f9480a.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.f9480a.setDataSource(str);
            }
            this.f9480a.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.f9480a;
    }

    public VideoSurfaceView getSurfaceView() {
        return this.b;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f9480a.setAudioStreamType(3);
        this.f9480a.setDisplay(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public MediaPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public MediaPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }
}
