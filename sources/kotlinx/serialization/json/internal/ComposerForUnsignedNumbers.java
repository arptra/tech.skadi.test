package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writer", "", "forceQuoting", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "", "v", "", "i", "(I)V", "", "j", "(J)V", "", "e", "(B)V", "", "l", "(S)V", "c", "Z", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SuppressAnimalSniffer
public final class ComposerForUnsignedNumbers extends Composer {
    public final boolean c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter internalJsonWriter, boolean z) {
        super(internalJsonWriter);
        Intrinsics.checkNotNullParameter(internalJsonWriter, "writer");
        this.c = z;
    }

    public void e(byte b) {
        boolean z = this.c;
        String r2 = UByte.m82toStringimpl(UByte.m38constructorimpl(b));
        if (z) {
            n(r2);
        } else {
            k(r2);
        }
    }

    public void i(int i) {
        boolean z = this.c;
        String unsignedString = Integer.toUnsignedString(UInt.m115constructorimpl(i));
        if (z) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    public void j(long j) {
        boolean z = this.c;
        String unsignedString = Long.toUnsignedString(ULong.m194constructorimpl(j));
        if (z) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    public void l(short s) {
        boolean z = this.c;
        String r2 = UShort.m345toStringimpl(UShort.m301constructorimpl(s));
        if (z) {
            n(r2);
        } else {
            k(r2);
        }
    }
}
