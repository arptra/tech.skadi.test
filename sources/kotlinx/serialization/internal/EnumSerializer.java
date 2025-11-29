package kotlinx.serialization.internal;

import com.honey.account.constant.AccountConstantKt;
import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@SourceDebugExtension({"SMAP\nEnums.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumSerializer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,151:1\n13309#2,2:152\n*S KotlinDebug\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumSerializer\n*L\n123#1:152,2\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u00168VX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlinx/serialization/internal/EnumSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "", "serialName", "", "values", "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "i", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "h", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "g", "(Ljava/lang/String;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "a", "[Ljava/lang/Enum;", "b", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "overriddenDescriptor", "c", "Lkotlin/Lazy;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Enum[] f4031a;
    public SerialDescriptor b;
    public final Lazy c;

    public EnumSerializer(String str, Enum[] enumArr) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(enumArr, "values");
        this.f4031a = enumArr;
        this.c = LazyKt.lazy(new EnumSerializer$descriptor$2(this, str));
    }

    public final SerialDescriptor g(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f4031a.length);
        for (Enum name : this.f4031a) {
            PluginGeneratedSerialDescriptor.l(enumDescriptor, name.name(), false, 2, (Object) null);
        }
        return enumDescriptor;
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    /* renamed from: h */
    public Enum c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int s = decoder.s(getDescriptor());
        if (s >= 0) {
            Enum[] enumArr = this.f4031a;
            if (s < enumArr.length) {
                return enumArr[s];
            }
        }
        throw new SerializationException(s + " is not among valid " + getDescriptor().h() + " enum values, values size is " + this.f4031a.length);
    }

    /* renamed from: i */
    public void a(Encoder encoder, Enum enumR) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(enumR, AccountConstantKt.RESPONSE_VALUE);
        int indexOf = ArraysKt.indexOf((T[]) this.f4031a, enumR);
        if (indexOf != -1) {
            encoder.g(getDescriptor(), indexOf);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(enumR);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().h());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(this.f4031a);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        sb.append(arrays);
        throw new SerializationException(sb.toString());
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + Typography.greater;
    }
}
