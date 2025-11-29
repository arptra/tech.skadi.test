package kotlinx.serialization.json.internal;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "Lkotlinx/serialization/encoding/AbstractEncoder;", "", "value", "", "v", "(Ljava/lang/String;)V", "Lkotlinx/serialization/modules/SerializersModule;", "a", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1 extends AbstractEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractJsonTreeEncoder f4094a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SerialDescriptor c;

    public AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str, SerialDescriptor serialDescriptor) {
        this.f4094a = abstractJsonTreeEncoder;
        this.b = str;
        this.c = serialDescriptor;
    }

    public SerializersModule a() {
        return this.f4094a.d().c();
    }

    public void v(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.f4094a.z0(this.b, new JsonLiteral(str, false, this.c));
    }
}
