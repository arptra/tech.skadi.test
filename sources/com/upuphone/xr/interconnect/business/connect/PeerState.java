package com.upuphone.xr.interconnect.business.connect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerState;", "", "numericalLevel", "", "(Ljava/lang/String;II)V", "getNumericalLevel", "()I", "MISSING", "AVAILABLE", "STARTED", "NEGOTIATED", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum PeerState {
    MISSING(0),
    AVAILABLE(1),
    STARTED(2),
    NEGOTIATED(3);
    
    private final int numericalLevel;

    static {
        PeerState[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private PeerState(int i) {
        this.numericalLevel = i;
    }

    @NotNull
    public static EnumEntries<PeerState> getEntries() {
        return $ENTRIES;
    }

    public final int getNumericalLevel() {
        return this.numericalLevel;
    }
}
