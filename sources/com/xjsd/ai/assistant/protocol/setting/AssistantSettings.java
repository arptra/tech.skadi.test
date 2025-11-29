package com.xjsd.ai.assistant.protocol.setting;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/setting/AssistantSettings;", "", "type", "", "isSwitchChecked", "", "value", "", "(Ljava/lang/String;ZI)V", "()Z", "getType", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssistantSettings {
    private final boolean isSwitchChecked;
    @NotNull
    private final String type;
    private final int value;

    public AssistantSettings(@NotNull String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.isSwitchChecked = z;
        this.value = i;
    }

    public static /* synthetic */ AssistantSettings copy$default(AssistantSettings assistantSettings, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assistantSettings.type;
        }
        if ((i2 & 2) != 0) {
            z = assistantSettings.isSwitchChecked;
        }
        if ((i2 & 4) != 0) {
            i = assistantSettings.value;
        }
        return assistantSettings.copy(str, z, i);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isSwitchChecked;
    }

    public final int component3() {
        return this.value;
    }

    @NotNull
    public final AssistantSettings copy(@NotNull String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new AssistantSettings(str, z, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssistantSettings)) {
            return false;
        }
        AssistantSettings assistantSettings = (AssistantSettings) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) assistantSettings.type) && this.isSwitchChecked == assistantSettings.isSwitchChecked && this.value == assistantSettings.value;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Boolean.hashCode(this.isSwitchChecked)) * 31) + Integer.hashCode(this.value);
    }

    public final boolean isSwitchChecked() {
        return this.isSwitchChecked;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        boolean z = this.isSwitchChecked;
        int i = this.value;
        return "AssistantSettings(type=" + str + ", isSwitchChecked=" + z + ", value=" + i + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AssistantSettings(String str, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i2 & 4) != 0 ? 0 : i);
    }
}
