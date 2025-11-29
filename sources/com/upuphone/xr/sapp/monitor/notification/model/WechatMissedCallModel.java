package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/WechatMissedCallModel;", "", "name", "", "date", "", "(Ljava/lang/String;J)V", "getDate", "()J", "getName", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class WechatMissedCallModel {
    @ColumnInfo
    @PrimaryKey
    private final long date;
    @ColumnInfo
    @NotNull
    private final String name;

    public WechatMissedCallModel(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.date = j;
    }

    public final long getDate() {
        return this.date;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
