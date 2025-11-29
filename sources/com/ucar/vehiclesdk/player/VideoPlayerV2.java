package com.ucar.vehiclesdk.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.easy.logger.EasyLog;
import com.meizu.common.datetimepicker.date.MonthView;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayerV2 {
    public Runnable A;
    public DecodeVideoSizeListener B;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5473a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;
    public long f;
    public MediaCodec g;
    public HandlerThread h;
    public final Handler i;
    public final Handler j;
    public VideoQueueManager k;
    public Surface l;
    public SurfaceTexture m;
    public int n;
    public int o;
    public long p;
    public long q;
    public boolean r;
    public final ConcurrentHashMap s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public long y;
    public int z;

    /* renamed from: com.ucar.vehiclesdk.player.VideoPlayerV2$1  reason: invalid class name */
    class AnonymousClass1 extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayerV2 f5474a;

        public final /* synthetic */ void b(MediaCodec mediaCodec, int i) {
            VideoBufferUnit videoBufferUnit = null;
            while (true) {
                if (!this.f5474a.c) {
                    break;
                }
                videoBufferUnit = this.f5474a.k.b();
                if (this.f5474a.b) {
                    if (videoBufferUnit != null && videoBufferUnit.b()) {
                        boolean unused = this.f5474a.b = false;
                        break;
                    } else if (videoBufferUnit != null) {
                        this.f5474a.k.c(videoBufferUnit);
                    }
                } else if (videoBufferUnit != null) {
                    break;
                }
            }
            if (videoBufferUnit != null && videoBufferUnit.a().remaining() > 0) {
                if (!this.f5474a.r && this.f5474a.q == -1) {
                    if (this.f5474a.p == 0) {
                        VideoPlayerV2 videoPlayerV2 = this.f5474a;
                        long unused2 = videoPlayerV2.q = videoPlayerV2.f * 5;
                    } else if (videoBufferUnit.c() > this.f5474a.p) {
                        if (videoBufferUnit.c() - this.f5474a.p < 4294967296L) {
                            VideoPlayerV2 videoPlayerV22 = this.f5474a;
                            long unused3 = videoPlayerV22.q = videoPlayerV22.f * 5;
                        }
                    } else if (videoBufferUnit.c() == this.f5474a.p) {
                        VideoPlayerV2 videoPlayerV23 = this.f5474a;
                        long unused4 = videoPlayerV23.q = videoPlayerV23.f * 5;
                    } else if (this.f5474a.p - videoBufferUnit.c() > 4294967296L) {
                        VideoPlayerV2 videoPlayerV24 = this.f5474a;
                        long unused5 = videoPlayerV24.q = videoPlayerV24.f * 5;
                    }
                }
                try {
                    ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i);
                    inputBuffer.clear();
                    int remaining = videoBufferUnit.a().remaining();
                    inputBuffer.limit(remaining);
                    inputBuffer.put(videoBufferUnit.a());
                    VideoPlayerV2 videoPlayerV25 = this.f5474a;
                    videoPlayerV25.G(Long.valueOf(videoPlayerV25.f * 5), System.currentTimeMillis());
                    mediaCodec.queueInputBuffer(i, 0, remaining, this.f5474a.f * 5, 0);
                    VideoPlayerV2.r(this.f5474a);
                } catch (IllegalStateException e) {
                    EasyLog.d("VideoPlayerV2", "get input buffer failed ", e);
                    boolean unused6 = this.f5474a.e = true;
                } catch (Throwable th) {
                    this.f5474a.k.c(videoBufferUnit);
                    throw th;
                }
                this.f5474a.k.c(videoBufferUnit);
            }
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            EasyLog.c("VideoPlayerV2", "onError: when decode data. errorCode: " + codecException.getErrorCode() + ", isTransient: " + codecException.isTransient() + ", isRecoverable: " + codecException.isRecoverable() + ", message: " + codecException.getMessage());
            boolean unused = this.f5474a.e = true;
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            if (i < 0) {
                EasyLog.c("VideoPlayerV2", " index " + i);
            } else if (this.f5474a.c) {
                this.f5474a.i.post(new c(this, mediaCodec, i));
            }
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
            if (this.f5474a.t) {
                long K = this.f5474a.K(Long.valueOf(bufferInfo.presentationTimeUs));
                if (K > 0) {
                    VideoPlayerV2.v(this.f5474a);
                    VideoPlayerV2.y(this.f5474a, System.currentTimeMillis() - K);
                    if (this.f5474a.w == this.f5474a.v) {
                        EasyLog.a("VideoPlayerV2", "statics codec decoded now diff time ms avg: " + (this.f5474a.u / this.f5474a.w));
                        int unused = this.f5474a.v = 0;
                        int unused2 = this.f5474a.u = 0;
                    }
                }
            }
            boolean A = this.f5474a.d;
            if (A && !this.f5474a.r && this.f5474a.q != -1 && this.f5474a.q < bufferInfo.presentationTimeUs) {
                boolean unused3 = this.f5474a.r = true;
                synchronized (this.f5474a) {
                    try {
                        if (this.f5474a.A != null) {
                            this.f5474a.j.removeCallbacks(this.f5474a.A);
                            this.f5474a.j.post(this.f5474a.A);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (A) {
                try {
                    if (this.f5474a.t) {
                        if (this.f5474a.x % this.f5474a.w == 0 && this.f5474a.x != 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            VideoPlayerV2 videoPlayerV2 = this.f5474a;
                            int unused4 = videoPlayerV2.z = (int) (((long) (videoPlayerV2.x * 1000)) / (currentTimeMillis - this.f5474a.y));
                            EasyLog.a("VideoPlayerV2", "frame rate: " + this.f5474a.z);
                            int unused5 = this.f5474a.x = 0;
                            long unused6 = this.f5474a.y = System.currentTimeMillis();
                        }
                        VideoPlayerV2.f(this.f5474a);
                    }
                    mediaCodec.releaseOutputBuffer(i, System.nanoTime());
                } catch (Exception e) {
                    EasyLog.d("VideoPlayerV2", "release output buffer failed,", e);
                    boolean unused7 = this.f5474a.e = true;
                }
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            EasyLog.i("VideoPlayerV2", "onOutputFormatChanged: " + mediaFormat);
            int integer = mediaFormat.getInteger(MonthView.VIEW_PARAMS_WIDTH);
            if (mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-right")) {
                integer = (mediaFormat.getInteger("crop-right") + 1) - mediaFormat.getInteger("crop-left");
            }
            int integer2 = mediaFormat.getInteger(MonthView.VIEW_PARAMS_HEIGHT);
            if (mediaFormat.containsKey("crop-top") && mediaFormat.containsKey("crop-bottom")) {
                integer2 = (mediaFormat.getInteger("crop-bottom") + 1) - mediaFormat.getInteger("crop-top");
            }
            this.f5474a.B.a(integer, integer2);
        }
    }

    public interface DecodeVideoSizeListener {
        void a(int i, int i2);
    }

    public static /* synthetic */ int f(VideoPlayerV2 videoPlayerV2) {
        int i2 = videoPlayerV2.x;
        videoPlayerV2.x = i2 + 1;
        return i2;
    }

    public static /* synthetic */ long r(VideoPlayerV2 videoPlayerV2) {
        long j2 = videoPlayerV2.f;
        videoPlayerV2.f = 1 + j2;
        return j2;
    }

    public static /* synthetic */ int v(VideoPlayerV2 videoPlayerV2) {
        int i2 = videoPlayerV2.v;
        videoPlayerV2.v = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int y(VideoPlayerV2 videoPlayerV2, long j2) {
        int i2 = (int) (((long) videoPlayerV2.u) + j2);
        videoPlayerV2.u = i2;
        return i2;
    }

    public void G(Long l2, long j2) {
        if (!this.t) {
            return;
        }
        if (this.s.containsKey(l2)) {
            EasyLog.a("VideoPlayerV2", "lIndex: " + l2 + " is already existed");
            return;
        }
        this.s.put(l2, Long.valueOf(j2));
    }

    public final void H() {
        if (this.m == null || this.l == null) {
            I();
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            this.m = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(this.n, this.o);
            this.l = new Surface(this.m);
        }
    }

    public final void I() {
        SurfaceTexture surfaceTexture = this.m;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.release();
            } catch (Exception e2) {
                EasyLog.d("VideoPlayerV2", "dummy texture release failed", e2);
            }
            this.m = null;
        }
        Surface surface = this.l;
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e3) {
                EasyLog.d("VideoPlayerV2", "dummy surface release failed", e3);
            }
            this.l = null;
        }
    }

    public void J(boolean z2) {
        EasyLog.e("VideoPlayerV2", "enableRender " + z2);
        this.d = z2;
    }

    public long K(Long l2) {
        Long l3;
        if (!this.t || (l3 = (Long) this.s.remove(l2)) == null) {
            return -1;
        }
        return l3.longValue();
    }

    public synchronized boolean L() {
        return this.f5473a;
    }

    public synchronized void M() {
        EasyLog.a("VideoPlayerV2", "pause");
        H();
        try {
            this.g.setOutputSurface(this.l);
        } catch (IllegalStateException e2) {
            EasyLog.d("VideoPlayerV2", "pause: setOutputSurface failed", e2);
            this.e = true;
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.media.MediaCodec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.media.MediaCodec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.media.MediaCodec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.media.MediaCodec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void N() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "VideoPlayerV2"
            java.lang.String r1 = "release"
            com.easy.logger.EasyLog.a(r0, r1)     // Catch:{ all -> 0x0025 }
            android.os.Handler r0 = r4.i     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0025 }
            r0 = 0
            r4.c = r0     // Catch:{ all -> 0x0025 }
            android.os.HandlerThread r0 = r4.h     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            if (r0 == 0) goto L_0x0029
            r0.quit()     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            android.os.HandlerThread r0 = r4.h     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            r0.interrupt()     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            android.os.HandlerThread r0 = r4.h     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            r0.join()     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            r4.h = r1     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            goto L_0x0029
        L_0x0025:
            r0 = move-exception
            goto L_0x006e
        L_0x0027:
            r0 = move-exception
            goto L_0x0033
        L_0x0029:
            com.ucar.vehiclesdk.player.VideoQueueManager r0 = r4.k     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            if (r0 == 0) goto L_0x003a
            r0.a()     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            r4.k = r1     // Catch:{ IllegalStateException | InterruptedException -> 0x0027 }
            goto L_0x003a
        L_0x0033:
            java.lang.String r2 = "VideoPlayerV2"
            java.lang.String r3 = "release video player exception"
            com.easy.logger.EasyLog.d(r2, r3, r0)     // Catch:{ all -> 0x0025 }
        L_0x003a:
            android.media.MediaCodec r0 = r4.g     // Catch:{ IllegalStateException -> 0x0044 }
            if (r0 == 0) goto L_0x0046
            r0.stop()     // Catch:{ IllegalStateException -> 0x0044 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            goto L_0x0064
        L_0x0044:
            r0 = move-exception
            goto L_0x0050
        L_0x0046:
            android.media.MediaCodec r0 = r4.g     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x005f
            r0.release()     // Catch:{ all -> 0x0025 }
        L_0x004d:
            r4.g = r1     // Catch:{ all -> 0x0025 }
            goto L_0x005f
        L_0x0050:
            java.lang.String r2 = "VideoPlayerV2"
            java.lang.String r3 = "release video player exception"
            com.easy.logger.EasyLog.d(r2, r3, r0)     // Catch:{ all -> 0x0042 }
            android.media.MediaCodec r0 = r4.g     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x005f
            r0.release()     // Catch:{ all -> 0x0025 }
            goto L_0x004d
        L_0x005f:
            r4.I()     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)
            return
        L_0x0064:
            android.media.MediaCodec r2 = r4.g     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x006d
            r2.release()     // Catch:{ all -> 0x0025 }
            r4.g = r1     // Catch:{ all -> 0x0025 }
        L_0x006d:
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x006e:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.VideoPlayerV2.N():void");
    }

    public synchronized void O(long j2) {
        this.p = j2;
    }
}
