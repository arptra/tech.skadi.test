package com.upuphone.xr.sapp.permission;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/permission/Permission;", "", "(Ljava/lang/String;I)V", "CallPhone", "ReadContact", "CallLog", "Location", "Bluetooth", "PostNotification", "NotificationListener", "FileAccess", "Accessibility", "RecordAudio", "Camera", "Album", "Calendar", "AlertWindow", "AppOverlay", "SportsHealth", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public enum Permission {
    CallPhone,
    ReadContact,
    CallLog,
    Location,
    Bluetooth,
    PostNotification,
    NotificationListener,
    FileAccess,
    Accessibility,
    RecordAudio,
    Camera,
    Album,
    Calendar,
    AlertWindow,
    AppOverlay,
    SportsHealth;

    static {
        Permission[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    @NotNull
    public static EnumEntries<Permission> getEntries() {
        return $ENTRIES;
    }
}
