package com.xjsd.ai.assistant.skill.navigation.enums;

import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.phone.R;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;", "", "mode", "", "code", "", "resId", "(Ljava/lang/String;ILjava/lang/String;II)V", "getCode", "()I", "getMode", "()Ljava/lang/String;", "getResId", "getModeName", "DEFAULT", "DRIVING", "CYCLING", "CYCLING2", "WALKING", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum NavTravelMode {
    DEFAULT("default", -1, -1),
    DRIVING("car", 0, R.string.tts_navi_driving_mode),
    CYCLING("bicycle", 1, R.string.tts_navi_cycling_mode),
    CYCLING2("ride", 1, R.string.tts_navi_cycling_mode),
    WALKING("walk", 2, R.string.tts_navi_walking_mode);
    
    @NotNull
    public static final Companion Companion = null;
    private final int code;
    @NotNull
    private final String mode;
    private final int resId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode$Companion;", "", "<init>", "()V", "", "mode", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;", "a", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavTravelMode a(String str) {
            Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.MODE);
            for (NavTravelMode navTravelMode : NavTravelMode.values()) {
                if (Intrinsics.areEqual((Object) str, (Object) navTravelMode.getMode())) {
                    return navTravelMode;
                }
            }
            return NavTravelMode.DEFAULT;
        }

        public Companion() {
        }
    }

    static {
        NavTravelMode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private NavTravelMode(String str, int i, int i2) {
        this.mode = str;
        this.code = i;
        this.resId = i2;
    }

    @NotNull
    public static EnumEntries<NavTravelMode> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    @NotNull
    public static final NavTravelMode matchMode(@NotNull String str) {
        return Companion.a(str);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    @Nullable
    public final String getModeName() {
        int i = this.resId;
        if (i == -1) {
            return null;
        }
        return ContextHelper.b(i, new Object[0]);
    }

    public final int getResId() {
        return this.resId;
    }
}
