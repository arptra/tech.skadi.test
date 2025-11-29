package androidx.datastore.preferences.rxjava3;

import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class RxPreferenceDataStoreBuilder$build$delegate$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Callable<File> $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxPreferenceDataStoreBuilder$build$delegate$1(Callable<File> callable) {
        super(0);
        this.$produceFile = callable;
    }

    @NotNull
    public final File invoke() {
        File call = this.$produceFile.call();
        Intrinsics.checkNotNullExpressionValue(call, "produceFile.call()");
        return call;
    }
}
