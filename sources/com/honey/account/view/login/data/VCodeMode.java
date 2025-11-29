package com.honey.account.view.login.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/login/data/VCodeMode;", "", "(Ljava/lang/String;I)V", "PHONE_CODE_VALIDATE", "EMAIL_CODE_VALIDATE", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum VCodeMode {
    PHONE_CODE_VALIDATE,
    EMAIL_CODE_VALIDATE;

    static {
        VCodeMode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    @NotNull
    public static EnumEntries<VCodeMode> getEntries() {
        return $ENTRIES;
    }
}
