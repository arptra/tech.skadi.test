package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ConnectState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "setState", "(I)V", "UNCONNECTED", "CONNECTED", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public enum ConnectState {
    UNCONNECTED(0),
    CONNECTED(1);
    
    private int state;

    static {
        ConnectState[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private ConnectState(int i) {
        this.state = i;
    }

    @NotNull
    public static EnumEntries<ConnectState> getEntries() {
        return $ENTRIES;
    }

    public final int getState() {
        return this.state;
    }

    public final void setState(int i) {
        this.state = i;
    }
}
