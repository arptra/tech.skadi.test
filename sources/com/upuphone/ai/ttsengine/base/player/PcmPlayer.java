package com.upuphone.ai.ttsengine.base.player;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.honey.account.n3.e;
import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u00011B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J'\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u001c\u0010#\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u00100\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b/\u0010\u001d¨\u00062"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/player/PcmPlayer;", "Lcom/upuphone/ai/ttsengine/base/player/AbstractPlayer;", "Landroid/app/Application;", "context", "", "callingType", "sample", "channel", "", "disableBt", "<init>", "(Landroid/app/Application;IIIZ)V", "", "g", "(Landroid/app/Application;)V", "o", "()V", "i", "k", "p", "A", "j", "", "buff", "size", "block", "v", "([BIZ)V", "x", "()I", "I", "z", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Landroid/os/Handler;", "l", "Landroid/os/Handler;", "handler", "m", "audioAppendSize", "Landroid/media/AudioTrack;", "n", "Landroid/media/AudioTrack;", "audioTrack", "<set-?>", "y", "bufferSize", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPcmPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PcmPlayer.kt\ncom/upuphone/ai/ttsengine/base/player/PcmPlayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ExtentionUtils.kt\ncom/upuphone/ai/ttsengine/base/utils/ExtentionUtilsKt\n*L\n1#1,261:1\n288#2,2:262\n29#3,9:264\n29#3,9:273\n29#3,9:282\n29#3,9:291\n29#3,9:300\n29#3,9:309\n29#3,9:318\n*S KotlinDebug\n*F\n+ 1 PcmPlayer.kt\ncom/upuphone/ai/ttsengine/base/player/PcmPlayer\n*L\n88#1:262,2\n136#1:264,9\n152#1:273,9\n162#1:282,9\n189#1:291,9\n207#1:300,9\n218#1:309,9\n239#1:318,9\n*E\n"})
public final class PcmPlayer extends AbstractPlayer {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public static final ReentrantLock q = new ReentrantLock();
    public final int i;
    public final int j;
    public final AILOG k;
    public final Handler l;
    public volatile int m;
    public AudioTrack n;
    public int o;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/player/PcmPlayer$Companion;", "", "()V", "AUDIO_FORMAT", "", "END_MARK_DELAY_TIME", "MSG_PLAY_END_MARK", "SAMPLE_RATE_IN_HZ", "audioTrackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PcmPlayer(Application application, int i2, int i3, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 16000 : i3, (i5 & 8) != 0 ? 1 : i4, (i5 & 16) != 0 ? false : z);
    }

    public static final boolean r(PcmPlayer pcmPlayer, Message message) {
        Intrinsics.checkNotNullParameter(pcmPlayer, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        pcmPlayer.k.c("*** onMarker timeout reached", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            AudioTrack audioTrack = pcmPlayer.n;
            Integer valueOf = audioTrack != null ? Integer.valueOf(audioTrack.getPlaybackHeadPosition()) : null;
            AILOG ailog = pcmPlayer.k;
            ailog.c("on marker reached head : " + valueOf, new Object[0]);
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        pcmPlayer.A();
        TtsPlayListener e = pcmPlayer.e();
        if (e == null) {
            return true;
        }
        e.a();
        return true;
    }

    public static /* synthetic */ void w(PcmPlayer pcmPlayer, byte[] bArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        pcmPlayer.v(bArr, i2, z);
    }

    public final void A() {
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            this.k.c("stopAudioTrack", new Object[0]);
            this.m = 0;
            n(false);
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.pause();
            }
            AudioTrack audioTrack2 = this.n;
            if (audioTrack2 != null) {
                audioTrack2.flush();
            }
            AudioTrack audioTrack3 = this.n;
            if (audioTrack3 != null) {
                audioTrack3.release();
            }
            this.n = null;
            if (Build.VERSION.SDK_INT >= 31) {
                d();
            }
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
        this.k.c("stopAudioTrack END", new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0139, code lost:
        if (r4 == null) goto L_0x013b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(android.app.Application r10) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            super.g(r10)
            int r0 = r9.j
            r1 = 1
            if (r0 != r1) goto L_0x000f
            r0 = 4
            goto L_0x0011
        L_0x000f:
            r0 = 12
        L_0x0011:
            java.lang.String r2 = "audio"
            java.lang.Object r2 = r10.getSystemService(r2)
            boolean r3 = r2 instanceof android.media.AudioManager
            r4 = 0
            if (r3 == 0) goto L_0x001f
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            goto L_0x0020
        L_0x001f:
            r2 = r4
        L_0x0020:
            r9.l(r2)
            int r2 = r9.i
            r3 = 2
            int r2 = android.media.AudioTrack.getMinBufferSize(r2, r0, r3)
            r9.o = r2
            com.upuphone.ai.ttsengine.base.utils.AILOG r5 = r9.k
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "hardwareMinBufferSize: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r5.c(r2, r7)
            android.media.AudioTrack$Builder r2 = new android.media.AudioTrack$Builder
            r2.<init>()
            android.media.AudioAttributes r5 = r9.a()
            android.media.AudioTrack$Builder r2 = r2.setAudioAttributes(r5)
            android.media.AudioFormat$Builder r5 = new android.media.AudioFormat$Builder
            r5.<init>()
            android.media.AudioFormat$Builder r5 = r5.setEncoding(r3)
            int r7 = r9.i
            android.media.AudioFormat$Builder r5 = r5.setSampleRate(r7)
            android.media.AudioFormat$Builder r0 = r5.setChannelMask(r0)
            android.media.AudioFormat r0 = r0.build()
            android.media.AudioTrack$Builder r0 = r2.setAudioFormat(r0)
            int r2 = r9.o
            android.media.AudioTrack$Builder r0 = r0.setBufferSizeInBytes(r2)
            android.media.AudioTrack$Builder r0 = r0.setTransferMode(r1)
            android.media.AudioTrack r0 = r0.build()
            r9.n = r0
            if (r0 == 0) goto L_0x0161
            int r0 = r0.getState()
            if (r0 != r1) goto L_0x0161
            boolean r10 = com.upuphone.ai.ttsengine.base.utils.PackageUtils.b(r10)
            if (r10 != 0) goto L_0x0144
            boolean r10 = r9.d()
            if (r10 != 0) goto L_0x0144
            r10 = 7
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00c4 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c4 }
            r2 = 31
            if (r0 < r2) goto L_0x00d4
            int r0 = r9.f()     // Catch:{ all -> 0x00c4 }
            if (r0 != 0) goto L_0x00d4
            android.media.AudioManager r0 = r9.c()     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x00d4
            java.util.List r0 = r0.getAvailableCommunicationDevices()     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x00d4
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00c4 }
        L_0x00b0:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00c6
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00c4 }
            r5 = r2
            android.media.AudioDeviceInfo r5 = (android.media.AudioDeviceInfo) r5     // Catch:{ all -> 0x00c4 }
            int r5 = r5.getType()     // Catch:{ all -> 0x00c4 }
            if (r5 != r10) goto L_0x00b0
            goto L_0x00c7
        L_0x00c4:
            r0 = move-exception
            goto L_0x00da
        L_0x00c6:
            r2 = r4
        L_0x00c7:
            android.media.AudioDeviceInfo r2 = (android.media.AudioDeviceInfo) r2     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00d4
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r9.k     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "set communication device in sco"
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ all -> 0x00c4 }
            r0.c(r2, r5)     // Catch:{ all -> 0x00c4 }
        L_0x00d4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c4 }
            kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x00c4 }
            goto L_0x00e3
        L_0x00da:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m20constructorimpl(r0)
        L_0x00e3:
            android.media.AudioManager r0 = r9.c()
            if (r0 == 0) goto L_0x013b
            android.media.AudioDeviceInfo[] r0 = r0.getDevices(r3)
            if (r0 == 0) goto L_0x013b
            int r2 = r0.length
            r3 = r6
        L_0x00f1:
            if (r3 >= r2) goto L_0x010e
            r5 = r0[r3]
            int r7 = r5.getType()
            android.media.AudioManager r8 = r9.c()
            if (r8 == 0) goto L_0x0107
            boolean r8 = r8.isBluetoothScoOn()
            if (r8 != r1) goto L_0x0107
            r8 = r10
            goto L_0x0109
        L_0x0107:
            r8 = 8
        L_0x0109:
            if (r7 != r8) goto L_0x010c
            goto L_0x010f
        L_0x010c:
            int r3 = r3 + r1
            goto L_0x00f1
        L_0x010e:
            r5 = r4
        L_0x010f:
            if (r5 == 0) goto L_0x013b
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r9.k
            java.lang.CharSequence r0 = r5.getProductName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "set preferred device: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r10.c(r0, r1)
            android.media.AudioTrack r10 = r9.n
            if (r10 == 0) goto L_0x0139
            boolean r10 = r10.setPreferredDevice(r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r10)
        L_0x0139:
            if (r4 != 0) goto L_0x0144
        L_0x013b:
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r9.k
            java.lang.String r0 = "Didn't find a2dp or sco device"
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r10.h(r0, r1)
        L_0x0144:
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r9.k
            java.lang.String r0 = "init setNotificationMarkerPosition 0"
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r10.c(r0, r1)
            android.media.AudioTrack r10 = r9.n
            if (r10 == 0) goto L_0x0154
            r10.setNotificationMarkerPosition(r6)
        L_0x0154:
            android.media.AudioTrack r10 = r9.n
            if (r10 == 0) goto L_0x0160
            com.upuphone.ai.ttsengine.base.player.PcmPlayer$init$5 r0 = new com.upuphone.ai.ttsengine.base.player.PcmPlayer$init$5
            r0.<init>(r9)
            r10.setPlaybackPositionUpdateListener(r0)
        L_0x0160:
            return
        L_0x0161:
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r9.k
            android.media.AudioTrack r9 = r9.n
            if (r9 == 0) goto L_0x016f
            int r9 = r9.getState()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
        L_0x016f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "create audioTrack failed, state ="
            r9.append(r0)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r10.c(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.player.PcmPlayer.g(android.app.Application):void");
    }

    public void i() {
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.pause();
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
        TtsPlayListener e2 = e();
        if (e2 != null) {
            e2.b();
        }
    }

    public void j() {
        this.k.c("release audio tracker", new Object[0]);
        this.l.removeMessages(1);
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            n(false);
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.stop();
            }
            AudioTrack audioTrack2 = this.n;
            if (audioTrack2 != null) {
                audioTrack2.release();
            }
            this.n = null;
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
    }

    public void k() {
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.play();
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
        TtsPlayListener e2 = e();
        if (e2 != null) {
            e2.c();
        }
    }

    public void o() {
        this.k.c("start----->>", new Object[0]);
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            super.o();
            this.m = 0;
            this.k.c("AudioTrack play start", new Object[0]);
            n(true);
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.play();
            }
            this.k.c("AudioTrack call play end", new Object[0]);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
        TtsPlayListener e2 = e();
        if (e2 != null) {
            e2.d();
        }
        this.k.c("start END", new Object[0]);
    }

    public void p() {
        this.k.c("stop----->>", new Object[0]);
        try {
            this.l.removeMessages(1);
            n(false);
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                audioTrack.stop();
            }
            AudioTrack audioTrack2 = this.n;
            if (audioTrack2 != null) {
                audioTrack2.flush();
            }
            AudioTrack audioTrack3 = this.n;
            if (audioTrack3 != null) {
                audioTrack3.release();
            }
            this.n = null;
        } catch (Exception e) {
            AILOG ailog = this.k;
            String message = e.getMessage();
            ailog.h("stop error: " + message, new Object[0]);
        }
        this.k.c("stop END", new Object[0]);
    }

    public final synchronized void v(byte[] bArr, int i2, boolean z) {
        AudioTrack audioTrack;
        Intrinsics.checkNotNullParameter(bArr, "buff");
        this.k.c("audio append size = " + i2 + ", buffer size: " + bArr.length, new Object[0]);
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            this.m += i2;
            this.k.c("append audio data after lock, isPlaying: " + h(), new Object[0]);
            if (h() && (audioTrack = this.n) != null && audioTrack.getPlayState() == 3) {
                AudioTrack audioTrack2 = this.n;
                Integer valueOf = audioTrack2 != null ? Integer.valueOf(audioTrack2.write(bArr, 0, i2, z ^ true ? 1 : 0)) : null;
                this.k.c("append data state = " + valueOf, new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            try {
                Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + e.getMessage());
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    public final synchronized int x() {
        int i2;
        i2 = this.m / 2;
        ReentrantLock reentrantLock = q;
        reentrantLock.lock();
        try {
            AILOG ailog = this.k;
            ailog.c("appendAudioDateEnd setNotificationMarkerPosition " + i2, new Object[0]);
            AudioTrack audioTrack = this.n;
            if (audioTrack != null) {
                Integer num = null;
                Integer valueOf = audioTrack != null ? Integer.valueOf(audioTrack.getBufferSizeInFrames()) : null;
                AudioTrack audioTrack2 = this.n;
                if (audioTrack2 != null) {
                    num = Integer.valueOf(audioTrack2.getPlaybackHeadPosition());
                }
                AILOG ailog2 = this.k;
                int i3 = this.o;
                ailog2.c("bufferInFrame: " + valueOf + " , bufferSize: " + i3, new Object[0]);
                AILOG ailog3 = this.k;
                int i4 = this.m;
                ailog3.c("headPos: " + num + " , mAudioAppendSize: " + i4, new Object[0]);
                AudioTrack audioTrack3 = this.n;
                if (audioTrack3 != null) {
                    audioTrack3.setNotificationMarkerPosition(i2);
                }
                this.l.sendEmptyMessageDelayed(1, 1000);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            try {
                String message = e.getMessage();
                Log.e("AILOG[TTS]:SafeLock", "lock action exception: " + message);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return i2;
    }

    public final int y() {
        return this.o;
    }

    public final int z() {
        return this.i;
    }

    public PcmPlayer(Application application, int i2, int i3, int i4, boolean z) {
        super(i2, z);
        this.i = i3;
        this.j = i4;
        this.k = AILOG.a("PcmPlayer");
        this.o = 1024;
        this.l = new Handler(Looper.getMainLooper(), new e(this));
        Intrinsics.checkNotNull(application);
        g(application);
    }
}
