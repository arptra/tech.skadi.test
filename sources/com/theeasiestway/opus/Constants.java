package com.theeasiestway.opus;

import androidx.annotation.IntRange;
import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.app.SlideNotice;
import com.meizu.common.widget.CircularProgressButton;
import com.ucar.databus.proto.UCarProto;
import io.flutter.plugin.platform.PlatformPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/theeasiestway/opus/Constants;", "", "()V", "Application", "Bitrate", "Channels", "Complexity", "FrameSize", "SampleRate", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Constants {
    @NotNull
    public static final Constants INSTANCE = new Constants();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$Application;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Application {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/theeasiestway/opus/Constants$Application$Companion;", "", "()V", "audio", "Lcom/theeasiestway/opus/Constants$Application;", "lowdelay", "voip", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Application audio() {
                return new Application(2049, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Application lowdelay() {
                return new Application(2051, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Application voip() {
                return new Application(2048, (DefaultConstructorMarker) null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Application(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Application(int i) {
            this.v = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$Bitrate;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Bitrate {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/theeasiestway/opus/Constants$Bitrate$Companion;", "", "()V", "auto", "Lcom/theeasiestway/opus/Constants$Bitrate;", "instance", "value", "", "max", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Bitrate auto() {
                return new Bitrate(-1000, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Bitrate instance(@IntRange int i) {
                return i < 500 ? new Bitrate(500, (DefaultConstructorMarker) null) : i > 512000 ? new Bitrate(512000, (DefaultConstructorMarker) null) : new Bitrate(i, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Bitrate max() {
                return new Bitrate(-1, (DefaultConstructorMarker) null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Bitrate(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Bitrate(int i) {
            this.v = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$Channels;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Channels {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/theeasiestway/opus/Constants$Channels$Companion;", "", "()V", "mono", "Lcom/theeasiestway/opus/Constants$Channels;", "stereo", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Channels mono() {
                return new Channels(1, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Channels stereo() {
                return new Channels(2, (DefaultConstructorMarker) null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Channels(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Channels(int i) {
            this.v = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$Complexity;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Complexity {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/theeasiestway/opus/Constants$Complexity$Companion;", "", "()V", "instance", "Lcom/theeasiestway/opus/Constants$Complexity;", "value", "", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Complexity instance(@IntRange int i) {
                return i < 0 ? new Complexity(0, (DefaultConstructorMarker) null) : i > 10 ? new Complexity(10, (DefaultConstructorMarker) null) : new Complexity(i, (DefaultConstructorMarker) null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Complexity(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Complexity(int i) {
            this.v = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$FrameSize;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FrameSize {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, d2 = {"Lcom/theeasiestway/opus/Constants$FrameSize$Companion;", "", "()V", "_120", "Lcom/theeasiestway/opus/Constants$FrameSize;", "_1280", "_160", "_1920", "_240", "_2560", "_2880", "_320", "_480", "_640", "_960", "_custom", "value", "", "fromValue", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final FrameSize _120() {
                return new FrameSize(120, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _1280() {
                return new FrameSize(PlatformPlugin.DEFAULT_SYSTEM_UI, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _160() {
                return new FrameSize(160, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _1920() {
                return new FrameSize(1920, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _240() {
                return new FrameSize(CircularProgressButton.MorphingAnimation.DURATION_NORMAL, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _2560() {
                return new FrameSize(2560, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _2880() {
                return new FrameSize(2880, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _320() {
                return new FrameSize(SlideNotice.SHOW_ANIMATION_DURATION, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _480() {
                return new FrameSize(OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _640() {
                return new FrameSize(640, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _960() {
                return new FrameSize(OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize _custom(int i) {
                return new FrameSize(i, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final FrameSize fromValue(int i) {
                switch (i) {
                    case 120:
                        return _120();
                    case 160:
                        return _160();
                    case CircularProgressButton.MorphingAnimation.DURATION_NORMAL:
                        return _240();
                    case SlideNotice.SHOW_ANIMATION_DURATION:
                        return _320();
                    case OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES:
                        return _480();
                    case 640:
                        return _640();
                    case OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES:
                        return _960();
                    case PlatformPlugin.DEFAULT_SYSTEM_UI:
                        return _1280();
                    case 1920:
                        return _1920();
                    case 2560:
                        return _2560();
                    case 2880:
                        return _2880();
                    default:
                        return _custom(i);
                }
            }

            private Companion() {
            }
        }

        public /* synthetic */ FrameSize(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private FrameSize(int i) {
            this.v = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/theeasiestway/opus/Constants$SampleRate;", "", "v", "", "(I)V", "getV", "()I", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SampleRate {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int v;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/theeasiestway/opus/Constants$SampleRate$Companion;", "", "()V", "_12000", "Lcom/theeasiestway/opus/Constants$SampleRate;", "_16000", "_24000", "_48000", "_8000", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SampleRate _12000() {
                return new SampleRate(UCarProto.SampleRate.SAMPLE_RATE_12000_VALUE, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final SampleRate _16000() {
                return new SampleRate(16000, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final SampleRate _24000() {
                return new SampleRate(UCarProto.SampleRate.SAMPLE_RATE_24000_VALUE, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final SampleRate _48000() {
                return new SampleRate(UCarProto.SampleRate.SAMPLE_RATE_48000_VALUE, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final SampleRate _8000() {
                return new SampleRate(UCarProto.SampleRate.SAMPLE_RATE_8000_VALUE, (DefaultConstructorMarker) null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ SampleRate(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private SampleRate(int i) {
            this.v = i;
        }
    }

    private Constants() {
    }
}
