package kotlinx.serialization.internal;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "f", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@PublishedApi
public final class UnitSerializer implements KSerializer<Unit> {
    public static final UnitSerializer b = new UnitSerializer();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjectSerializer f4073a = new ObjectSerializer("kotlin.Unit", Unit.INSTANCE);

    public /* bridge */ /* synthetic */ Object c(Decoder decoder) {
        e(decoder);
        return Unit.INSTANCE;
    }

    public void e(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.f4073a.c(decoder);
    }

    /* renamed from: f */
    public void a(Encoder encoder, Unit unit) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(unit, AccountConstantKt.RESPONSE_VALUE);
        this.f4073a.a(encoder, unit);
    }

    public SerialDescriptor getDescriptor() {
        return this.f4073a.getDescriptor();
    }
}
