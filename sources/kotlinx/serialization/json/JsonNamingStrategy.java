package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bç\u0001\u0018\u00002\u00020\u0001:\u0001\nJ'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "elementIndex", "", "serialName", "a", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)Ljava/lang/String;", "Builtins", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public interface JsonNamingStrategy {

    @SourceDebugExtension({"SMAP\nJsonNamingStrategy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonNamingStrategy.kt\nkotlinx/serialization/json/JsonNamingStrategy$Builtins\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1174#2:179\n1175#2:181\n1#3:180\n*S KotlinDebug\n*F\n+ 1 JsonNamingStrategy.kt\nkotlinx/serialization/json/JsonNamingStrategy$Builtins\n*L\n149#1:179\n149#1:181\n*E\n"})
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR \u0010\u000f\u001a\u00020\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u000b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\f\u0010\rR \u0010\u0013\u001a\u00020\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", "", "<init>", "()V", "", "serialName", "", "delimiter", "b", "(Ljava/lang/String;C)Ljava/lang/String;", "Lkotlinx/serialization/json/JsonNamingStrategy;", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "SnakeCase", "c", "getKebabCase", "getKebabCase$annotations", "KebabCase", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
    @ExperimentalSerializationApi
    public static final class Builtins {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Builtins f4085a = new Builtins();
        public static final JsonNamingStrategy b = new JsonNamingStrategy$Builtins$SnakeCase$1();
        public static final JsonNamingStrategy c = new JsonNamingStrategy$Builtins$KebabCase$1();

        public final String b(String str, char c2) {
            StringBuilder sb = new StringBuilder(str.length() * 2);
            Character ch = null;
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    if (i == 0 && sb.length() > 0 && StringsKt.last(sb) != c2) {
                        sb.append(c2);
                    }
                    if (ch != null) {
                        sb.append(ch.charValue());
                    }
                    i++;
                    ch = Character.valueOf(Character.toLowerCase(charAt));
                } else {
                    if (ch != null) {
                        if (i > 1 && Character.isLetter(charAt)) {
                            sb.append(c2);
                        }
                        sb.append(ch);
                        ch = null;
                        i = 0;
                    }
                    sb.append(charAt);
                }
            }
            if (ch != null) {
                sb.append(ch);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }

    String a(SerialDescriptor serialDescriptor, int i, String str);
}
