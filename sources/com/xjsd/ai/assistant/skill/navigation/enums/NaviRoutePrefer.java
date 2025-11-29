package com.xjsd.ai.assistant.skill.navigation.enums;

import com.xjsd.ai.assistant.phone.R;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;", "", "mode", "", "code", "", "nameRes", "(Ljava/lang/String;ILjava/lang/String;II)V", "getCode", "()I", "getMode", "()Ljava/lang/String;", "getNameRes", "DEFAULT", "MOST_INTELLIGENT", "SHORT", "CAR", "RIDE", "WALK", "FAST", "AVOID_HIGH_SPEED", "FREE", "HIGH_SPEED", "AVOID_JAM", "BIG", "UN_SUPPORT", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum NaviRoutePrefer {
    DEFAULT("default", 10, R.string.tts_navi_route_default),
    MOST_INTELLIGENT("mostIntelligent", 10, R.string.tts_navi_route_recommend),
    SHORT("short", 10, R.string.tts_navi_route_shortest),
    CAR("car", 10, R.string.tts_navi_driving_mode),
    RIDE("ride", 10, R.string.tts_navi_cycling_mode),
    WALK("walk", 10, R.string.tts_navi_walking_mode),
    FAST("fast", 4, R.string.tts_navi_route_fastest),
    AVOID_HIGH_SPEED("avoid_highspeed", 13, R.string.tts_navi_route_no_highway),
    FREE("free", 14, R.string.tts_navi_route_free),
    HIGH_SPEED("highspeed", 20, R.string.tts_navi_route_high_speed_priority),
    AVOID_JAM("avoid_jam", 1002, R.string.tts_navi_route_no_congested),
    BIG("big", 1003, R.string.tts_navi_route_main_road),
    UN_SUPPORT("", 1004, R.string.tts_navi_route_unsupport);
    
    @NotNull
    public static final Companion Companion = null;
    private final int code;
    @NotNull
    private final String mode;
    private final int nameRes;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer$Companion;", "", "<init>", "()V", "", "mode", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;", "a", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NaviRoutePrefer a(String str) {
            Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.MODE);
            for (NaviRoutePrefer naviRoutePrefer : NaviRoutePrefer.values()) {
                if (Intrinsics.areEqual((Object) str, (Object) naviRoutePrefer.getMode())) {
                    return naviRoutePrefer;
                }
            }
            return NaviRoutePrefer.UN_SUPPORT;
        }

        public Companion() {
        }
    }

    static {
        NaviRoutePrefer[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private NaviRoutePrefer(String str, int i, int i2) {
        this.mode = str;
        this.code = i;
        this.nameRes = i2;
    }

    @NotNull
    public static EnumEntries<NaviRoutePrefer> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    @NotNull
    public static final NaviRoutePrefer matchMode(@NotNull String str) {
        return Companion.a(str);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    public final int getNameRes() {
        return this.nameRes;
    }
}
