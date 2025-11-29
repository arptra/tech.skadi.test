package com.upuphone.ar.fastrecord.phone.utils;

import com.here.odnp.config.OdnpConfigStatic;
import com.theeasiestway.opus.Constants;
import com.theeasiestway.opus.Opus;
import com.ucar.databus.proto.UCarProto;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils;", "", "()V", "mOpusProximal", "Lcom/theeasiestway/opus/Opus;", "mOpusRemote", "mOpusScreen", "decodePhoneProximalFrame", "", "bytes", "isAir", "", "decodePhoneRemoteFrame", "decodeScreenFrame", "getFrameSizeOfByte", "Lcom/theeasiestway/opus/Constants$FrameSize;", "initOpusProximal", "", "initOpusRemote", "initOpusScreen", "unInit", "Companion", "SingleHolder", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordOpusCodecUtils {
    private static final int AIR_DEFAULT_DATA_SIZE = 1920;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_DATA_SIZE = 640;
    @NotNull
    private static final String TAG = "OpusCodecUtils";
    @NotNull
    private static final Constants.Application mApplication = Constants.Application.Companion.audio();
    private static final int mChannelDataSize = DEFAULT_DATA_SIZE;
    @NotNull
    private static final Constants.SampleRate mSampleRate = Constants.SampleRate.Companion._16000();
    @Nullable
    private Opus mOpusProximal;
    @Nullable
    private Opus mOpusRemote;
    @Nullable
    private Opus mOpusScreen;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils$Companion;", "", "()V", "AIR_DEFAULT_DATA_SIZE", "", "DEFAULT_DATA_SIZE", "TAG", "", "mApplication", "Lcom/theeasiestway/opus/Constants$Application;", "mChannelDataSize", "mSampleRate", "Lcom/theeasiestway/opus/Constants$SampleRate;", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RecordOpusCodecUtils getInstance() {
            return SingleHolder.INSTANCE.getInstance();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils$SingleHolder;", "", "()V", "instance", "Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils;", "getInstance", "()Lcom/upuphone/ar/fastrecord/phone/utils/RecordOpusCodecUtils;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SingleHolder {
        @NotNull
        public static final SingleHolder INSTANCE = new SingleHolder();
        @NotNull
        private static final RecordOpusCodecUtils instance = new RecordOpusCodecUtils();

        private SingleHolder() {
        }

        @NotNull
        public final RecordOpusCodecUtils getInstance() {
            return instance;
        }
    }

    private final Constants.FrameSize getFrameSizeOfByte(boolean z) {
        return z ? Constants.FrameSize.Companion.fromValue(OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES) : Constants.FrameSize.Companion.fromValue(mChannelDataSize / 2);
    }

    @JvmStatic
    @NotNull
    public static final RecordOpusCodecUtils getInstance() {
        return Companion.getInstance();
    }

    private final void initOpusProximal() {
        if (this.mOpusProximal != null) {
            LogExt.logI("initOpusProximal has init....", TAG);
            return;
        }
        LogExt.logI("initOpusProximal is init.... start", TAG);
        Opus opus = new Opus();
        this.mOpusProximal = opus;
        opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
        Constants.Channels mono = Constants.Channels.Companion.mono();
        Opus opus2 = this.mOpusProximal;
        if (opus2 != null) {
            opus2.encoderInit(mSampleRate, mono, mApplication);
        }
        Opus opus3 = this.mOpusProximal;
        if (opus3 != null) {
            opus3.decoderInit(mSampleRate, mono);
        }
        LogExt.logI("initOpusProximal is init.... end", TAG);
    }

    private final void initOpusRemote() {
        if (this.mOpusRemote != null) {
            LogExt.logI("initOpusRemote has init....", TAG);
            return;
        }
        LogExt.logI("initOpusRemote is init.... start", TAG);
        Opus opus = new Opus();
        this.mOpusRemote = opus;
        opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
        Constants.Channels mono = Constants.Channels.Companion.mono();
        Opus opus2 = this.mOpusRemote;
        if (opus2 != null) {
            opus2.encoderInit(mSampleRate, mono, mApplication);
        }
        Opus opus3 = this.mOpusRemote;
        if (opus3 != null) {
            opus3.decoderInit(mSampleRate, mono);
        }
        LogExt.logI("initOpusRemote is init.... end", TAG);
    }

    private final void initOpusScreen() {
        if (this.mOpusScreen != null) {
            LogExt.logI("initOpusScreen has init....", TAG);
            return;
        }
        LogExt.logI("initOpusScreen is init.... start", TAG);
        Opus opus = new Opus();
        this.mOpusScreen = opus;
        opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
        Constants.Channels mono = Constants.Channels.Companion.mono();
        Opus opus2 = this.mOpusScreen;
        if (opus2 != null) {
            opus2.encoderInit(mSampleRate, mono, mApplication);
        }
        Opus opus3 = this.mOpusScreen;
        if (opus3 != null) {
            opus3.decoderInit(mSampleRate, mono);
        }
        LogExt.logI("initOpusScreen is init.... end", TAG);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
        r8 = com.theeasiestway.opus.Opus.decode$default(r2, r9, getFrameSizeOfByte(r10), 0, 4, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] decodePhoneProximalFrame(@org.jetbrains.annotations.NotNull byte[] r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.theeasiestway.opus.Constants$FrameSize r0 = r8.getFrameSizeOfByte(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decodePhoneProximalFrame frameSize = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "OpusCodecUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            com.theeasiestway.opus.Opus r0 = r8.mOpusProximal
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "mOpus == null initOpusProximal"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r0, r1)
            r8.initOpusProximal()
        L_0x002b:
            com.theeasiestway.opus.Opus r2 = r8.mOpusProximal
            if (r2 == 0) goto L_0x003d
            com.theeasiestway.opus.Constants$FrameSize r4 = r8.getFrameSizeOfByte(r10)
            r6 = 4
            r7 = 0
            r5 = 0
            r3 = r9
            byte[] r8 = com.theeasiestway.opus.Opus.decode$default((com.theeasiestway.opus.Opus) r2, (byte[]) r3, (com.theeasiestway.opus.Constants.FrameSize) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            if (r8 != 0) goto L_0x0040
        L_0x003d:
            r8 = 0
            byte[] r8 = new byte[r8]
        L_0x0040:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils.decodePhoneProximalFrame(byte[], boolean):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
        r8 = com.theeasiestway.opus.Opus.decode$default(r2, r9, getFrameSizeOfByte(r10), 0, 4, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] decodePhoneRemoteFrame(@org.jetbrains.annotations.NotNull byte[] r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.theeasiestway.opus.Constants$FrameSize r0 = r8.getFrameSizeOfByte(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decodePhoneRemoteFrame frameSize = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "OpusCodecUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            com.theeasiestway.opus.Opus r0 = r8.mOpusRemote
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "mOpus == null initOpusRemote"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r0, r1)
            r8.initOpusRemote()
        L_0x002b:
            com.theeasiestway.opus.Opus r2 = r8.mOpusRemote
            if (r2 == 0) goto L_0x003d
            com.theeasiestway.opus.Constants$FrameSize r4 = r8.getFrameSizeOfByte(r10)
            r6 = 4
            r7 = 0
            r5 = 0
            r3 = r9
            byte[] r8 = com.theeasiestway.opus.Opus.decode$default((com.theeasiestway.opus.Opus) r2, (byte[]) r3, (com.theeasiestway.opus.Constants.FrameSize) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            if (r8 != 0) goto L_0x0040
        L_0x003d:
            r8 = 0
            byte[] r8 = new byte[r8]
        L_0x0040:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils.decodePhoneRemoteFrame(byte[], boolean):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
        r8 = com.theeasiestway.opus.Opus.decode$default(r2, r9, getFrameSizeOfByte(r10), 0, 4, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] decodeScreenFrame(@org.jetbrains.annotations.NotNull byte[] r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.theeasiestway.opus.Constants$FrameSize r0 = r8.getFrameSizeOfByte(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decodeScreenFrame frameSize = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "OpusCodecUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            com.theeasiestway.opus.Opus r0 = r8.mOpusScreen
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "mOpus == null initOpusScreen"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r0, r1)
            r8.initOpusScreen()
        L_0x002b:
            com.theeasiestway.opus.Opus r2 = r8.mOpusScreen
            if (r2 == 0) goto L_0x003d
            com.theeasiestway.opus.Constants$FrameSize r4 = r8.getFrameSizeOfByte(r10)
            r6 = 4
            r7 = 0
            r5 = 0
            r3 = r9
            byte[] r8 = com.theeasiestway.opus.Opus.decode$default((com.theeasiestway.opus.Opus) r2, (byte[]) r3, (com.theeasiestway.opus.Constants.FrameSize) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            if (r8 != 0) goto L_0x0040
        L_0x003d:
            r8 = 0
            byte[] r8 = new byte[r8]
        L_0x0040:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils.decodeScreenFrame(byte[], boolean):byte[]");
    }

    public final void unInit() {
        LogExt.logI("OpusCodecUtils is unInit mOpusScreen....", TAG);
        Opus opus = this.mOpusScreen;
        if (opus != null) {
            opus.encoderRelease();
        }
        Opus opus2 = this.mOpusScreen;
        if (opus2 != null) {
            opus2.decoderRelease();
        }
        Opus opus3 = this.mOpusScreen;
        if (opus3 != null) {
            opus3.destroy();
        }
        this.mOpusScreen = null;
        LogExt.logI("OpusCodecUtils is unInit mOpusProximal....", TAG);
        Opus opus4 = this.mOpusProximal;
        if (opus4 != null) {
            opus4.encoderRelease();
        }
        Opus opus5 = this.mOpusProximal;
        if (opus5 != null) {
            opus5.decoderRelease();
        }
        Opus opus6 = this.mOpusProximal;
        if (opus6 != null) {
            opus6.destroy();
        }
        this.mOpusProximal = null;
        LogExt.logI("OpusCodecUtils is unInit mOpusRemote....", TAG);
        Opus opus7 = this.mOpusRemote;
        if (opus7 != null) {
            opus7.encoderRelease();
        }
        Opus opus8 = this.mOpusRemote;
        if (opus8 != null) {
            opus8.decoderRelease();
        }
        Opus opus9 = this.mOpusRemote;
        if (opus9 != null) {
            opus9.destroy();
        }
        this.mOpusRemote = null;
    }
}
