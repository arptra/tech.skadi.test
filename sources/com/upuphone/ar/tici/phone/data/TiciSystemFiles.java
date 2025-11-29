package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciSystemFiles;", "", "files", "", "", "", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "(Ljava/util/Map;)V", "getFiles", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class TiciSystemFiles {
    @NotNull
    private final Map<String, List<SystemFileInfo>> files;

    public TiciSystemFiles(@NotNull Map<String, ? extends List<SystemFileInfo>> map) {
        Intrinsics.checkNotNullParameter(map, "files");
        this.files = map;
    }

    public static /* synthetic */ TiciSystemFiles copy$default(TiciSystemFiles ticiSystemFiles, Map<String, List<SystemFileInfo>> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = ticiSystemFiles.files;
        }
        return ticiSystemFiles.copy(map);
    }

    @NotNull
    public final Map<String, List<SystemFileInfo>> component1() {
        return this.files;
    }

    @NotNull
    public final TiciSystemFiles copy(@NotNull Map<String, ? extends List<SystemFileInfo>> map) {
        Intrinsics.checkNotNullParameter(map, "files");
        return new TiciSystemFiles(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TiciSystemFiles) && Intrinsics.areEqual((Object) this.files, (Object) ((TiciSystemFiles) obj).files);
    }

    @NotNull
    public final Map<String, List<SystemFileInfo>> getFiles() {
        return this.files;
    }

    public int hashCode() {
        return this.files.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, List<SystemFileInfo>> map = this.files;
        return "TiciSystemFiles(files=" + map + ")";
    }
}
