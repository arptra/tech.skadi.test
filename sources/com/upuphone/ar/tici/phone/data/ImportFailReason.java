package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFailReason;", "", "(Ljava/lang/String;I)V", "TextByteOverSize", "UnsupportedFile", "UnknownEncoding", "ReadFileError", "EmptyContent", "FileOver200K", "FileOver10M", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ImportFailReason {
    TextByteOverSize,
    UnsupportedFile,
    UnknownEncoding,
    ReadFileError,
    EmptyContent,
    FileOver200K,
    FileOver10M;

    static {
        ImportFailReason[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    @NotNull
    public static EnumEntries<ImportFailReason> getEntries() {
        return $ENTRIES;
    }
}
