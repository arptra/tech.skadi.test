package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lokio/internal/ZipEntry;", "invoke", "(Lokio/internal/ZipEntry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ZipFilesKt$openZip$1 extends Lambda implements Function1<ZipEntry, Boolean> {
    public static final ZipFilesKt$openZip$1 INSTANCE = new ZipFilesKt$openZip$1();

    public ZipFilesKt$openZip$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull ZipEntry zipEntry) {
        Intrinsics.checkNotNullParameter(zipEntry, "it");
        return Boolean.TRUE;
    }
}
