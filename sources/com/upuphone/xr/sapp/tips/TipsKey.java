package com.upuphone.xr.sapp.tips;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/tips/TipsKey;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "TIPS_USER_GUIDE", "TIPS_PERMISSION", "TIPS_SPORT", "TIPS_PRIVACY_AI", "TIPS_PRIVACY_ASST", "TIPS_PRIVACY_NAVI", "TIPS_PRIVACY_TRANSLATOR", "TIPS_PRIVACY_TICI", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum TipsKey {
    TIPS_USER_GUIDE(99),
    TIPS_PERMISSION(100),
    TIPS_SPORT(100),
    TIPS_PRIVACY_AI(101),
    TIPS_PRIVACY_ASST(102),
    TIPS_PRIVACY_NAVI(102),
    TIPS_PRIVACY_TRANSLATOR(102),
    TIPS_PRIVACY_TICI(102);
    
    private final int priority;

    static {
        TipsKey[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private TipsKey(int i) {
        this.priority = i;
    }

    @NotNull
    public static EnumEntries<TipsKey> getEntries() {
        return $ENTRIES;
    }

    public final int getPriority() {
        return this.priority;
    }
}
