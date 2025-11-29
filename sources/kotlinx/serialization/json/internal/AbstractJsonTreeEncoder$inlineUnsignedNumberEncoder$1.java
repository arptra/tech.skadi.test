package kotlinx.serialization.json.internal;

import com.geetest.sdk.s;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0018"}, d2 = {"kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "Lkotlinx/serialization/encoding/AbstractEncoder;", "", "s", "", "K", "(Ljava/lang/String;)V", "", "value", "(I)V", "", "A", "(J)V", "", "f", "(B)V", "", "k", "(S)V", "Lkotlinx/serialization/modules/SerializersModule;", "a", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1 extends AbstractEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final SerializersModule f4095a;
    public final /* synthetic */ AbstractJsonTreeEncoder b;
    public final /* synthetic */ String c;

    public AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str) {
        this.b = abstractJsonTreeEncoder;
        this.c = str;
        this.f4095a = abstractJsonTreeEncoder.d().c();
    }

    public void A(long j) {
        K(Long.toUnsignedString(ULong.m194constructorimpl(j)));
    }

    public final void K(String str) {
        Intrinsics.checkNotNullParameter(str, s.f);
        this.b.z0(this.c, new JsonLiteral(str, false, (SerialDescriptor) null, 4, (DefaultConstructorMarker) null));
    }

    public SerializersModule a() {
        return this.f4095a;
    }

    public void f(byte b2) {
        K(UByte.m82toStringimpl(UByte.m38constructorimpl(b2)));
    }

    public void k(short s) {
        K(UShort.m345toStringimpl(UShort.m301constructorimpl(s)));
    }

    public void s(int i) {
        K(Integer.toUnsignedString(UInt.m115constructorimpl(i)));
    }
}
