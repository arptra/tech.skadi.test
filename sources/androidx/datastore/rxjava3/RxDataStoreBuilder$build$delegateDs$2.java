package androidx.datastore.rxjava3;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "T", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class RxDataStoreBuilder$build$delegateDs$2 extends Lambda implements Function0<File> {
    final /* synthetic */ RxDataStoreBuilder<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxDataStoreBuilder$build$delegateDs$2(RxDataStoreBuilder<T> rxDataStoreBuilder) {
        super(0);
        this.this$0 = rxDataStoreBuilder;
    }

    @NotNull
    public final File invoke() {
        Context a2 = this.this$0.b;
        Intrinsics.checkNotNull(a2);
        String b = this.this$0.c;
        Intrinsics.checkNotNull(b);
        return DataStoreFile.a(a2, b);
    }
}
