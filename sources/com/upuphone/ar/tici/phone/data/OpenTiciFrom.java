package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TiciHomePage", "TiciFileListPage", "RunningTiciEdit", "ResetToDefaultTici", "Glass", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum OpenTiciFrom {
    TiciHomePage(0),
    TiciFileListPage(1),
    RunningTiciEdit(2),
    ResetToDefaultTici(3),
    Glass(4);
    
    private final int value;

    static {
        OpenTiciFrom[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private OpenTiciFrom(int i) {
        this.value = i;
    }

    @NotNull
    public static EnumEntries<OpenTiciFrom> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }
}
