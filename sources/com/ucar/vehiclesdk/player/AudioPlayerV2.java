package com.ucar.vehiclesdk.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.SystemClock;
import android.view.Surface;
import com.easy.logger.EasyLog;
import com.honey.account.k3.h;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.util.AudioTrackUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AudioPlayerV2 {
    public static final ThreadLocal g = ThreadLocal.withInitial(new h());

    /* renamed from: a  reason: collision with root package name */
    public final AudioQueueManager f5464a;
    public PlayThread b;
    public AudioDecoder c = null;
    public final int d;
    public final String e;
    public boolean f = false;

    public static class AudioDecoder {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f5465a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public final AudioQueueManager c;
        public final AudioQueueManager d;
        public Thread e;
        public MediaCodec f;

        public AudioDecoder(AudioQueueManager audioQueueManager, UCarCommon.AudioType audioType, String str, int i, int i2) {
            this.c = new AudioQueueManager("aac@" + audioType);
            this.d = audioQueueManager;
            int i3 = i == 4 ? 1 : 2;
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(str, i2, i3);
            if (str.equals("audio/mp4a-latm")) {
                EasyLog.a("AudioPlayer.Decode", "init Sync Codec, mimeType is AAC channels = " + i3);
                createAudioFormat.setInteger("aac-profile", 2);
                createAudioFormat.setInteger("is-adts", 1);
                createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{17, -112}));
                try {
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(str);
                    this.f = createDecoderByType;
                    createDecoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.f.start();
                } catch (IOException unused) {
                    throw new RuntimeException("failed to create decoder");
                }
            } else {
                throw new RuntimeException("not support " + str);
            }
        }

        public AudioQueueManager f() {
            return this.c;
        }

        public final void g() {
            int i;
            ByteBuffer b2 = this.c.b();
            if (b2 != null && b2.remaining() != 0) {
                try {
                    i = this.f.dequeueInputBuffer(500000);
                } catch (Exception e2) {
                    EasyLog.d("AudioPlayer.Decode", "dequeueInputBuffer failed.", e2);
                    i = -1;
                }
                int i2 = i;
                if (i2 < 0) {
                    this.c.h(b2);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    int remaining = b2.remaining();
                    ByteBuffer inputBuffer = this.f.getInputBuffer(i2);
                    inputBuffer.clear();
                    inputBuffer.limit(remaining);
                    inputBuffer.put(b2);
                    this.f.queueInputBuffer(i2, 0, remaining, currentTimeMillis, 0);
                } catch (Exception e3) {
                    EasyLog.d("AudioPlayer.Decode", "queueInputBuffer failed.", e3);
                } catch (Throwable th) {
                    this.c.h(b2);
                    throw th;
                }
                this.c.h(b2);
            }
        }

        public final void h() {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f.dequeueOutputBuffer(bufferInfo, 500000);
            if (dequeueOutputBuffer >= 0 && bufferInfo.size != 0) {
                if (System.currentTimeMillis() - bufferInfo.presentationTimeUs < 1000) {
                    ByteBuffer outputBuffer = this.f.getOutputBuffer(dequeueOutputBuffer);
                    this.d.g(outputBuffer);
                    outputBuffer.clear();
                }
                this.f.releaseOutputBuffer(dequeueOutputBuffer, false);
            }
        }

        public final void i() {
            EasyLog.a("AudioPlayer.Decode", "release");
            try {
                MediaCodec mediaCodec = this.f;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                }
                MediaCodec mediaCodec2 = this.f;
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.release();
                    } catch (Exception e2) {
                        e = e2;
                    }
                    this.f = null;
                }
                return;
                EasyLog.d("AudioPlayer.Decode", "release audio decoder exception", e);
                this.f = null;
            } catch (Exception e3) {
                EasyLog.d("AudioPlayer.Decode", "release audio decoder exception", e3);
                MediaCodec mediaCodec3 = this.f;
                if (mediaCodec3 != null) {
                    try {
                        mediaCodec3.release();
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Throwable th) {
                MediaCodec mediaCodec4 = this.f;
                if (mediaCodec4 != null) {
                    try {
                        mediaCodec4.release();
                    } catch (Exception e5) {
                        EasyLog.d("AudioPlayer.Decode", "release audio decoder exception", e5);
                    }
                    this.f = null;
                }
                throw th;
            }
        }

        public void j() {
            if (!this.b.get()) {
                this.b.set(true);
                AnonymousClass1 r0 = new Thread("adec-input") {
                    public void run() {
                        AudioDecoder.this.f5465a.incrementAndGet();
                        while (AudioDecoder.this.b.get()) {
                            AudioDecoder.this.g();
                        }
                        if (AudioDecoder.this.f5465a.decrementAndGet() <= 0) {
                            AudioDecoder.this.i();
                        }
                    }
                };
                this.e = r0;
                r0.start();
                new Thread("adec-output") {
                    public void run() {
                        AudioDecoder.this.f5465a.incrementAndGet();
                        while (AudioDecoder.this.b.get()) {
                            AudioDecoder.this.h();
                        }
                        if (AudioDecoder.this.f5465a.decrementAndGet() <= 0) {
                            AudioDecoder.this.i();
                        }
                    }
                }.start();
            }
        }

        public void k() {
            EasyLog.a("AudioPlayer.Decode", "stop");
            this.b.set(false);
            Thread thread = this.e;
            if (thread != null) {
                try {
                    thread.interrupt();
                    this.e.join(50);
                } catch (InterruptedException e2) {
                    EasyLog.d("AudioPlayer.Decode", "stop failed.", e2);
                }
                this.e = null;
            }
        }
    }

    public interface IAudioBuffingChangedListener {
        void a(int i);
    }

    public static class PlayThread extends Thread {
        public int A = 0;
        public float B;
        public long C;
        public long D;

        /* renamed from: a  reason: collision with root package name */
        public final String f5468a;
        public final AudioQueueManager b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;
        public int g = 100;
        public float h = 1.0f;
        public volatile boolean i = true;
        public volatile boolean j = false;
        public AudioTrack k;
        public int l;
        public int m = -1;
        public int n = -1;
        public int o;
        public final int p;
        public final int q;
        public long r;
        public final IAudioBuffingChangedListener s;
        public long t;
        public long u;
        public long v;
        public long w;
        public long x;
        public boolean y = false;
        public int z = -1;

        public PlayThread(Context context, int i2, int i3, int i4, AudioAttributes audioAttributes, int i5, UCarCommon.AudioType audioType, boolean z2, IAudioBuffingChangedListener iAudioBuffingChangedListener) {
            int i6 = i2;
            int i7 = i3;
            UCarCommon.AudioType audioType2 = audioType;
            setName("Play@" + audioType2);
            this.f5468a = "AudioPlayer@" + audioType2 + ".Play";
            this.q = i7;
            this.b = new AudioQueueManager("pcm@" + audioType2);
            this.c = d(i2) * Integer.bitCount(i4) * i7;
            this.f = z2;
            this.s = iAudioBuffingChangedListener;
            int i8 = i4;
            int a2 = a(i2, i3, i4);
            this.p = a2;
            UCarCommon.AudioType audioType3 = UCarCommon.AudioType.STREAM_CAST_MUSIC;
            if (audioType2 == audioType3) {
                this.d = 600;
                this.e = 200;
            } else {
                this.d = 300;
                this.e = 100;
                n(false, 100, 0, 10);
            }
            AudioTrack b2 = b(i2, i3, i4, a2, audioAttributes, i5);
            this.k = b2;
            if (audioType2 == audioType3) {
                Context context2 = context;
                AudioTrackUtil.b(context, b2);
            }
        }

        public final int a(int i2, int i3, int i4) {
            return ((((int) Math.ceil((double) (((float) AudioTrack.getMinBufferSize(i3, i4, i2)) * 1.2f))) / 16) + 1) * 16;
        }

        public final AudioTrack b(int i2, int i3, int i4, int i5, AudioAttributes audioAttributes, int i6) {
            AudioFormat build = new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(i4).build();
            String str = this.f5468a;
            EasyLog.e(str, "createTrack, encoding: " + i2 + ", sampleRate: " + i3 + ", adjustStep: " + this.g + "ms, channelConfig: " + i4 + ", bufferSize: " + i5 + ", attributes: " + audioAttributes);
            return new AudioTrack.Builder().setAudioAttributes(audioAttributes).setAudioFormat(build).setTransferMode(1).setBufferSizeInBytes(i5).setSessionId(i6).build();
        }

        public final boolean c(float f2, int i2) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i3 = 2;
            if (i2 == 2) {
                if (this.z == i2 && this.B == f2) {
                    int i4 = this.A;
                    if (uptimeMillis - this.C >= ((long) (i4 - 1)) * 10) {
                        this.A = i4 + 1;
                        this.C = uptimeMillis;
                    }
                } else {
                    this.A = 1;
                    this.C = uptimeMillis;
                }
            } else if (i2 == 1) {
                if (this.z == i2 && this.B == f2) {
                    int i5 = this.A;
                    if (uptimeMillis - this.C >= ((long) (i5 - 1)) * 10) {
                        this.A = i5 + 1;
                        this.C = uptimeMillis;
                    }
                } else {
                    this.A = 1;
                    this.C = uptimeMillis;
                }
            } else if (this.z != i2) {
                this.A = 0;
                this.C = uptimeMillis;
            } else {
                this.A++;
                this.C = uptimeMillis;
            }
            this.B = f2;
            this.z = i2;
            if (i2 == 3) {
                this.A = 0;
                return true;
            }
            if (!this.y) {
                i3 = 3;
            }
            int i6 = this.A;
            if (this.f) {
                i3 += 2;
            }
            return i6 == i3;
        }

        public final int d(int i2) {
            int i3 = 1;
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        if (i2 != 13) {
                            throw new IllegalArgumentException("Bad audio format " + i2);
                        }
                    }
                }
                return i3;
            }
            return 2;
        }

        public AudioQueueManager e() {
            return this.b;
        }

        public final long f() {
            long playbackHeadPosition = ((long) this.k.getPlaybackHeadPosition()) & 4294967295L;
            if (this.v > playbackHeadPosition) {
                this.w++;
            }
            this.v = playbackHeadPosition;
            return playbackHeadPosition + (this.w << 32);
        }

        public final synchronized long g() {
            long f2 = f();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.u != f2) {
                this.u = f2;
                this.t = uptimeMillis;
                long j2 = (f2 * 1000) / ((long) this.q);
                this.x = j2;
                return j2;
            }
            return this.x + ((long) Math.round(((float) (uptimeMillis - this.t)) * this.h));
        }

        public void h() {
            this.j = true;
            this.b.a();
            AudioTrack audioTrack = this.k;
            if (audioTrack != null && audioTrack.getPlayState() == 3) {
                this.k.pause();
                this.k.flush();
            }
            i();
        }

        public final void i() {
            this.u = 0;
            this.t = 0;
            this.x = 0;
            this.r = 0;
            this.v = 0;
            this.w = 0;
        }

        public void j() {
            this.j = false;
            this.b.a();
            i();
            AudioTrack audioTrack = this.k;
            if (audioTrack == null) {
                EasyLog.i(this.f5468a, "track is null");
            } else if (audioTrack.getPlayState() == 2) {
                this.k.flush();
                this.k.play();
            }
        }

        public final void k(float f2) {
            if (f2 != this.h) {
                String str = this.f5468a;
                EasyLog.a(str, "try adjust playback speed from x" + this.h + " to x" + f2);
                try {
                    AudioTrack audioTrack = this.k;
                    if (audioTrack != null) {
                        PlaybackParams playbackParams = audioTrack.getPlaybackParams();
                        playbackParams.setSpeed(f2);
                        this.k.setPlaybackParams(playbackParams);
                        this.h = f2;
                    }
                } catch (IllegalArgumentException e2) {
                    EasyLog.j(this.f5468a, "setSpeed failed.", e2);
                }
            }
        }

        public void l(boolean z2) {
            this.y = z2;
        }

        public void m() {
            this.i = false;
            try {
                interrupt();
                join(50);
            } catch (InterruptedException e2) {
                EasyLog.d(this.f5468a, "stopPlay failed.", e2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void n(boolean r4, int r5, int r6, int r7) {
            /*
                r3 = this;
                monitor-enter(r3)
                int r0 = r3.d     // Catch:{ all -> 0x0020 }
                if (r5 > r0) goto L_0x0093
                int r1 = r3.e     // Catch:{ all -> 0x0020 }
                if (r7 <= r1) goto L_0x000b
                goto L_0x0093
            L_0x000b:
                r1 = 100
                if (r5 < r1) goto L_0x0091
                r1 = 10
                if (r7 >= r1) goto L_0x0015
                goto L_0x0091
            L_0x0015:
                r1 = -1
                if (r4 != 0) goto L_0x0022
                int r2 = r3.n     // Catch:{ all -> 0x0020 }
                if (r2 == r1) goto L_0x0022
                if (r2 == r5) goto L_0x0022
                monitor-exit(r3)
                return
            L_0x0020:
                r4 = move-exception
                goto L_0x0095
            L_0x0022:
                r3.g = r7     // Catch:{ all -> 0x0020 }
                int r6 = r6 + r5
                int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x0020 }
                r3.n = r6     // Catch:{ all -> 0x0020 }
                int r7 = r3.m     // Catch:{ all -> 0x0020 }
                if (r7 == r1) goto L_0x0040
                if (r4 == 0) goto L_0x0032
                goto L_0x0040
            L_0x0032:
                com.ucar.vehiclesdk.player.AudioPlayerV2$IAudioBuffingChangedListener r4 = r3.s     // Catch:{ all -> 0x0020 }
                if (r4 == 0) goto L_0x0042
                int r6 = r6 - r7
                r5 = 0
                int r5 = java.lang.Math.max(r6, r5)     // Catch:{ all -> 0x0020 }
                r4.a(r5)     // Catch:{ all -> 0x0020 }
                goto L_0x0042
            L_0x0040:
                r3.m = r5     // Catch:{ all -> 0x0020 }
            L_0x0042:
                int r4 = r3.c     // Catch:{ all -> 0x0020 }
                int r5 = r3.n     // Catch:{ all -> 0x0020 }
                int r4 = r4 * r5
                int r4 = r4 / 1000
                int r5 = r3.p     // Catch:{ all -> 0x0020 }
                int r5 = java.lang.Math.max(r4, r5)     // Catch:{ all -> 0x0020 }
                r3.o = r5     // Catch:{ all -> 0x0020 }
                int r5 = r5 / 2
                r3.l = r5     // Catch:{ all -> 0x0020 }
                java.lang.String r5 = r3.f5468a     // Catch:{ all -> 0x0020 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
                r6.<init>()     // Catch:{ all -> 0x0020 }
                java.lang.String r7 = "updateAudioPlayParams, bytesPerSecond: "
                r6.append(r7)     // Catch:{ all -> 0x0020 }
                int r7 = r3.c     // Catch:{ all -> 0x0020 }
                r6.append(r7)     // Catch:{ all -> 0x0020 }
                java.lang.String r7 = ", buffingBytes: "
                r6.append(r7)     // Catch:{ all -> 0x0020 }
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                java.lang.String r4 = ", adjustBuffingBytes: "
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                int r4 = r3.o     // Catch:{ all -> 0x0020 }
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                java.lang.String r4 = ", buffingCount: "
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                int r4 = r3.n     // Catch:{ all -> 0x0020 }
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                java.lang.String r4 = "ms"
                r6.append(r4)     // Catch:{ all -> 0x0020 }
                java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0020 }
                com.easy.logger.EasyLog.e(r5, r4)     // Catch:{ all -> 0x0020 }
                monitor-exit(r3)
                return
            L_0x0091:
                monitor-exit(r3)
                return
            L_0x0093:
                monitor-exit(r3)
                return
            L_0x0095:
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerV2.PlayThread.n(boolean, int, int, int):void");
        }

        public boolean o(int i2) {
            String str = this.f5468a;
            EasyLog.a(str, "wait buffer to fill bytes: " + i2);
            while (this.b.d() < i2) {
                this.b.j();
                if (!this.i) {
                    return false;
                }
            }
            String str2 = this.f5468a;
            EasyLog.a(str2, "buffer fill done, number: " + this.b.e() + ", bytes: " + this.b.d());
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x01c5, code lost:
            if (((float) r12) < r5) goto L_0x01c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01d3, code lost:
            if (((float) r12) >= r5) goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d5, code lost:
            if (r1 == false) goto L_0x01db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01d7, code lost:
            r1 = 1.1f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01db, code lost:
            r1 = 1.2f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x01e3, code lost:
            if (r0.c(r5, 1) == false) goto L_0x01ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01e9, code lost:
            if (r0.h == r1) goto L_0x01ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01eb, code lost:
            r0.k(r1);
            com.easy.logger.EasyLog.e(r0.f5468a, "play faster when remain: " + r12 + "ms, played: " + r10 + "ms, filled: " + r6 + "ms, received: " + r8 + "ms, under: " + r20 + r19);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0225, code lost:
            if (r0.y != false) goto L_0x01ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0227, code lost:
            r1 = r0.n;
            r2 = r0.g;
            r0.n(false, r1, r2, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0242, code lost:
            if (((float) r12) > r5) goto L_0x0244;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0250, code lost:
            if (((float) r12) <= r5) goto L_0x0252;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0252, code lost:
            if (r1 == false) goto L_0x0258;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0254, code lost:
            r1 = 0.9f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0258, code lost:
            r1 = 0.8f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0260, code lost:
            if (r0.c(r5, 2) == false) goto L_0x01ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0266, code lost:
            if (r0.h == r1) goto L_0x01ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0268, code lost:
            r0.k(r1);
            com.easy.logger.EasyLog.e(r0.f5468a, "play slower when remain: " + r12 + "ms, played: " + r10 + "ms, filled: " + r6 + "ms, received: " + r8 + "ms, under: " + r20 + r19);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x02b9, code lost:
            if (((float) r12) >= r14) goto L_0x02c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x02cd, code lost:
            if (((float) r12) >= r14) goto L_0x02d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x02e3, code lost:
            if (((float) r12) <= r14) goto L_0x02e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x02ef, code lost:
            if (((float) r12) > r14) goto L_0x02bc;
         */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02d9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r26 = this;
                r0 = r26
                int r1 = r0.o
                r0.o(r1)
                android.media.AudioTrack r1 = r0.k
                r1.play()
                android.media.AudioTrack r1 = r0.k
                r2 = 1065353216(0x3f800000, float:1.0)
                r1.setVolume(r2)
            L_0x0013:
                boolean r1 = r0.i
                if (r1 == 0) goto L_0x0337
                com.ucar.vehiclesdk.player.AudioQueueManager r1 = r0.b
                r3 = 10
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
                java.nio.ByteBuffer r1 = r1.c(r3, r5)
                r3 = 0
                if (r1 == 0) goto L_0x006a
                boolean r4 = r0.j
                if (r4 == 0) goto L_0x002e
                com.ucar.vehiclesdk.player.AudioQueueManager r3 = r0.b
                r3.h(r1)
                goto L_0x0013
            L_0x002e:
                int r4 = r1.remaining()
                boolean r5 = r1.hasArray()
                if (r5 == 0) goto L_0x004a
                android.media.AudioTrack r5 = r0.k
                byte[] r6 = r1.array()
                int r7 = r1.position()
                int r8 = r1.remaining()
                r5.write(r6, r7, r8, r3)
                goto L_0x005f
            L_0x004a:
                int r5 = r1.remaining()
                byte[] r5 = com.ucar.vehiclesdk.player.AudioPlayerV2.c(r5)
                int r6 = r5.length
                r1.get(r5, r3, r6)
                r1.clear()
                android.media.AudioTrack r6 = r0.k
                int r7 = r5.length
                r6.write(r5, r3, r7, r3)
            L_0x005f:
                long r5 = r0.r
                long r7 = (long) r4
                long r5 = r5 + r7
                r0.r = r5
                com.ucar.vehiclesdk.player.AudioQueueManager r4 = r0.b
                r4.h(r1)
            L_0x006a:
                boolean r1 = r0.i
                if (r1 != 0) goto L_0x0070
                goto L_0x0337
            L_0x0070:
                boolean r1 = r0.j
                if (r1 == 0) goto L_0x0075
                goto L_0x0013
            L_0x0075:
                long r4 = r0.r
                com.ucar.vehiclesdk.player.AudioQueueManager r1 = r0.b
                int r1 = r1.d()
                double r6 = (double) r4
                r8 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r6 = r6 * r8
                int r10 = r0.c
                double r10 = (double) r10
                double r6 = r6 / r10
                long r6 = (long) r6
                long r10 = r26.g()
                long r10 = java.lang.Math.min(r10, r6)
                long r12 = (long) r1
                long r4 = r4 + r12
                double r4 = (double) r4
                double r4 = r4 * r8
                int r1 = r0.c
                double r8 = (double) r1
                double r4 = r4 / r8
                long r4 = (long) r4
                long r8 = r6 - r10
                long r12 = r4 - r10
                r14 = 0
                int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                java.lang.String r3 = "ms."
                java.lang.String r14 = "ms, under: "
                java.lang.String r15 = "ms, received: "
                java.lang.String r2 = "ms, filled: "
                r19 = r3
                java.lang.String r3 = "ms, played: "
                if (r1 > 0) goto L_0x0104
                com.ucar.vehiclesdk.player.AudioQueueManager r1 = r0.b
                boolean r1 = r1.f()
                if (r1 == 0) goto L_0x0104
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r17 = r1
                java.lang.String r1 = "fill data when remain: "
                r0.append(r1)
                r0.append(r12)
                r0.append(r3)
                r0.append(r10)
                r0.append(r2)
                r0.append(r6)
                r0.append(r15)
                r0.append(r4)
                r0.append(r14)
                r0.append(r8)
                r1 = r19
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = r17
                com.easy.logger.EasyLog.e(r1, r0)
                r0 = r26
                int r1 = r0.l
                boolean r1 = r0.o(r1)
                if (r1 != 0) goto L_0x00fb
                goto L_0x0337
            L_0x00fb:
                r1 = 1065353216(0x3f800000, float:1.0)
                r0.k(r1)
                r24 = r4
                r4 = r8
                goto L_0x015a
            L_0x0104:
                r20 = r8
                long r8 = r0.D
                r22 = 100
                long r22 = r8 % r22
                r17 = 0
                int r1 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
                r17 = r8
                if (r1 != 0) goto L_0x0150
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "print remain : "
                r8.append(r9)
                r8.append(r12)
                r8.append(r3)
                r8.append(r10)
                r8.append(r2)
                r8.append(r6)
                r8.append(r15)
                r8.append(r4)
                r8.append(r14)
                r24 = r4
                r4 = r20
                r8.append(r4)
                r9 = r19
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                com.easy.logger.EasyLog.a(r1, r8)
                r8 = 1
                r0.D = r8
                goto L_0x015a
            L_0x0150:
                r24 = r4
                r4 = r20
                r8 = 1
                long r8 = r17 + r8
                r0.D = r8
            L_0x015a:
                r8 = 1500(0x5dc, double:7.41E-321)
                int r1 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                r8 = 3
                if (r1 <= 0) goto L_0x01b2
                com.ucar.vehiclesdk.player.AudioQueueManager r1 = r0.b
                r1.a()
                r1 = 0
                r0.c(r1, r8)
                r1 = 1065353216(0x3f800000, float:1.0)
                r0.k(r1)
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "discard all data when remain : "
                r8.append(r9)
                r8.append(r12)
                r8.append(r3)
                r8.append(r10)
                r8.append(r2)
                r8.append(r6)
                r8.append(r15)
                r2 = r24
                r8.append(r2)
                r8.append(r14)
                r8.append(r4)
                r9 = r19
                r8.append(r9)
                java.lang.String r2 = r8.toString()
                com.easy.logger.EasyLog.e(r1, r2)
                int r1 = r0.l
                boolean r1 = r0.o(r1)
                if (r1 != 0) goto L_0x01ae
                goto L_0x0337
            L_0x01ae:
                r8 = 1065353216(0x3f800000, float:1.0)
                goto L_0x0334
            L_0x01b2:
                r8 = r24
                boolean r1 = r0.y
                r20 = r4
                if (r1 == 0) goto L_0x01c7
                float r4 = (float) r12
                int r5 = r0.m
                float r5 = (float) r5
                r18 = 1067869798(0x3fa66666, float:1.3)
                float r5 = r5 * r18
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 >= 0) goto L_0x01d5
            L_0x01c7:
                if (r1 != 0) goto L_0x0231
                float r4 = (float) r12
                int r5 = r0.n
                float r5 = (float) r5
                r18 = 1071644672(0x3fe00000, float:1.75)
                float r5 = r5 * r18
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 < 0) goto L_0x0231
            L_0x01d5:
                if (r1 == 0) goto L_0x01db
                r1 = 1066192077(0x3f8ccccd, float:1.1)
                goto L_0x01de
            L_0x01db:
                r1 = 1067030938(0x3f99999a, float:1.2)
            L_0x01de:
                r4 = 1
                boolean r4 = r0.c(r5, r4)
                if (r4 == 0) goto L_0x01ae
                float r4 = r0.h
                int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r4 == 0) goto L_0x01ae
                r0.k(r1)
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "play faster when remain: "
                r4.append(r5)
                r4.append(r12)
                r4.append(r3)
                r4.append(r10)
                r4.append(r2)
                r4.append(r6)
                r4.append(r15)
                r4.append(r8)
                r4.append(r14)
                r2 = r20
                r4.append(r2)
                r5 = r19
                r4.append(r5)
                java.lang.String r2 = r4.toString()
                com.easy.logger.EasyLog.e(r1, r2)
                boolean r1 = r0.y
                if (r1 != 0) goto L_0x01ae
                int r1 = r0.n
                int r2 = r0.g
                r3 = 0
                r0.n(r3, r1, r2, r2)
                goto L_0x01ae
            L_0x0231:
                r4 = r20
                r20 = r4
                if (r1 == 0) goto L_0x0244
                float r4 = (float) r12
                int r5 = r0.m
                float r5 = (float) r5
                r16 = 1050253722(0x3e99999a, float:0.3)
                float r5 = r5 * r16
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x0252
            L_0x0244:
                if (r1 != 0) goto L_0x02a2
                float r4 = (float) r12
                int r5 = r0.m
                float r5 = (float) r5
                r16 = 1048576000(0x3e800000, float:0.25)
                float r5 = r5 * r16
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L_0x02a2
            L_0x0252:
                if (r1 == 0) goto L_0x0258
                r1 = 1063675494(0x3f666666, float:0.9)
                goto L_0x025b
            L_0x0258:
                r1 = 1061997773(0x3f4ccccd, float:0.8)
            L_0x025b:
                r4 = 2
                boolean r4 = r0.c(r5, r4)
                if (r4 == 0) goto L_0x01ae
                float r4 = r0.h
                int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r4 == 0) goto L_0x01ae
                r0.k(r1)
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "play slower when remain: "
                r4.append(r5)
                r4.append(r12)
                r4.append(r3)
                r4.append(r10)
                r4.append(r2)
                r4.append(r6)
                r4.append(r15)
                r4.append(r8)
                r4.append(r14)
                r2 = r20
                r4.append(r2)
                r5 = r19
                r4.append(r5)
                java.lang.String r2 = r4.toString()
                com.easy.logger.EasyLog.e(r1, r2)
                goto L_0x01ae
            L_0x02a2:
                float r4 = r0.h
                r5 = 1065353216(0x3f800000, float:1.0)
                int r16 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r16 <= 0) goto L_0x02d0
                if (r1 == 0) goto L_0x02be
                float r5 = (float) r12
                r16 = r14
                int r14 = r0.m
                float r14 = (float) r14
                r24 = r8
                r8 = 1065353216(0x3f800000, float:1.0)
                float r14 = r14 * r8
                int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
                if (r5 < 0) goto L_0x02bc
                goto L_0x02c3
            L_0x02bc:
                r1 = 3
                goto L_0x02f2
            L_0x02be:
                r24 = r8
                r16 = r14
                r8 = r5
            L_0x02c3:
                if (r1 != 0) goto L_0x02d5
                float r5 = (float) r12
                int r9 = r0.n
                float r9 = (float) r9
                float r14 = r9 * r8
                int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
                if (r5 < 0) goto L_0x02bc
                goto L_0x02d5
            L_0x02d0:
                r24 = r8
                r16 = r14
                r8 = r5
            L_0x02d5:
                int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r4 >= 0) goto L_0x0334
                if (r1 == 0) goto L_0x02e5
                float r4 = (float) r12
                int r5 = r0.m
                float r5 = (float) r5
                float r14 = r5 * r8
                int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r4 > 0) goto L_0x02bc
            L_0x02e5:
                if (r1 != 0) goto L_0x0334
                float r1 = (float) r12
                int r4 = r0.n
                float r4 = (float) r4
                float r14 = r4 * r8
                int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
                if (r1 <= 0) goto L_0x0334
                goto L_0x02bc
            L_0x02f2:
                boolean r1 = r0.c(r14, r1)
                if (r1 == 0) goto L_0x0334
                r0.k(r8)
                java.lang.String r1 = r0.f5468a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "play normalize when remain: "
                r4.append(r5)
                r4.append(r12)
                r4.append(r3)
                r4.append(r10)
                r4.append(r2)
                r4.append(r6)
                r4.append(r15)
                r2 = r24
                r4.append(r2)
                r2 = r16
                r4.append(r2)
                r6 = r20
                r4.append(r6)
                r2 = r19
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                com.easy.logger.EasyLog.a(r1, r2)
            L_0x0334:
                r2 = r8
                goto L_0x0013
            L_0x0337:
                android.media.AudioTrack r1 = r0.k
                r1.stop()
                android.media.AudioTrack r1 = r0.k
                r1.release()
                r1 = 0
                r0.k = r1
                com.ucar.vehiclesdk.player.AudioQueueManager r0 = r0.b
                r0.a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerV2.PlayThread.run():void");
        }
    }

    public AudioPlayerV2(Context context, AudioAttributes audioAttributes, UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, int i, boolean z, IAudioBuffingChangedListener iAudioBuffingChangedListener) {
        this.e = "AudioPlayer@" + audioType;
        this.d = audioAttributes.getUsage();
        int b2 = audioFormat.b();
        int d2 = audioFormat.d();
        int a2 = audioFormat.a();
        String c2 = audioFormat.c();
        this.b = new PlayThread(context, b2, d2, a2, audioAttributes, i, audioType, z, iAudioBuffingChangedListener);
        if (c2.equals("audio/pcm")) {
            this.f5464a = this.b.e();
            return;
        }
        AudioDecoder audioDecoder = new AudioDecoder(this.b.e(), audioType, c2, a2, d2);
        this.c = audioDecoder;
        audioDecoder.j();
        this.f5464a = this.c.f();
    }

    public static byte[] c(int i) {
        if (i < 131072) {
            return (byte[]) g.get();
        }
        EasyLog.i("AudioPlayer", "getTempBytes not use thread local array, maybe MAX_TEMP_ARRAY_SIZE is too small, require:" + i);
        return new byte[i];
    }

    public static /* synthetic */ byte[] d() {
        return new byte[131072];
    }

    public void e() {
        String str = this.e;
        EasyLog.a(str, "pause, usage: " + this.d);
        if (this.b != null && !this.f) {
            this.f = true;
            this.f5464a.a();
            this.b.h();
        }
    }

    public void f() {
        this.b.start();
    }

    public void g() {
        String str = this.e;
        EasyLog.a(str, "release, usage: " + this.d);
        this.c = null;
        this.b = null;
    }

    public void h() {
        String str = this.e;
        EasyLog.a(str, "resume, usage: " + this.d);
        if (this.b != null && this.f) {
            this.f = false;
            this.f5464a.a();
            this.b.j();
        }
    }

    public void i(boolean z) {
        String str = this.e;
        EasyLog.a(str, "setUseAVSynchronization, use: " + z);
        PlayThread playThread = this.b;
        if (playThread != null) {
            playThread.l(z);
        }
    }

    public void j() {
        String str = this.e;
        EasyLog.a(str, "stop, usage: " + this.d);
        AudioDecoder audioDecoder = this.c;
        if (audioDecoder != null) {
            audioDecoder.k();
        }
        PlayThread playThread = this.b;
        if (playThread != null) {
            playThread.m();
        }
    }

    public void k(int i, int i2, int i3) {
        if (i <= 0 || i3 <= 0) {
            String str = this.e;
            EasyLog.c(str, "error count = " + i + ", step = " + i3);
            return;
        }
        String str2 = this.e;
        EasyLog.a(str2, "updateAudioPlayParams, count: " + i + ", speedStep: " + i3);
        PlayThread playThread = this.b;
        if (playThread != null) {
            playThread.n(true, i, i2, i3);
        }
    }

    public void l(ByteBuffer byteBuffer) {
        if (!this.f) {
            this.f5464a.g(byteBuffer);
        }
    }
}
