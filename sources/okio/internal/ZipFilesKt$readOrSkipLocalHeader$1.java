package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "headerId", "", "dataSize", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ZipFilesKt$readOrSkipLocalHeader$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.ObjectRef<Long> $createdAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastAccessedAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastModifiedAtMillis;
    final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZipFilesKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = objectRef;
        this.$lastAccessedAtMillis = objectRef2;
        this.$createdAtMillis = objectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, long j) {
        if (i == 21589) {
            long j2 = 1;
            if (j >= 1) {
                byte readByte = this.$this_readOrSkipLocalHeader.readByte();
                boolean z = false;
                boolean z2 = (readByte & 1) == 1;
                boolean z3 = (readByte & 2) == 2;
                if ((readByte & 4) == 4) {
                    z = true;
                }
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                if (z2) {
                    j2 = 5;
                }
                if (z3) {
                    j2 += 4;
                }
                if (z) {
                    j2 += 4;
                }
                if (j >= j2) {
                    if (z2) {
                        this.$lastModifiedAtMillis.element = Long.valueOf(((long) bufferedSource.readIntLe()) * 1000);
                    }
                    if (z3) {
                        this.$lastAccessedAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                    }
                    if (z) {
                        this.$createdAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                        return;
                    }
                    return;
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            throw new IOException("bad zip: extended timestamp extra too short");
        }
    }
}
