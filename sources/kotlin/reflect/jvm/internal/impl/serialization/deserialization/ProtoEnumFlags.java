package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoEnumFlags {
    @NotNull
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        /* JADX WARNING: Can't wrap try/catch for region: R(78:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|(2:33|34)|35|37|38|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|83|84|85|86|87|88|(2:89|90)|91|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|37|38|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|83|84|85|86|87|88|(2:89|90)|91|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(80:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|37|38|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|83|84|85|86|87|88|(2:89|90)|91|93|94|95|96|97|98|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|37|38|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|83|84|85|86|87|88|(2:89|90)|91|93|94|95|96|97|98|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|83|84|85|86|87|88|89|90|91|93|94|95|96|97|98|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(89:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|83|84|85|86|87|88|89|90|91|93|94|95|96|97|98|99|101) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ea */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0102 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0123 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x013c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x014c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0165 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x016d */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality[] r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r2 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.FINAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r3 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.OPEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r4 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.ABSTRACT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.SEALED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                kotlin.reflect.jvm.internal.impl.descriptors.Modality[] r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$1 = r0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility[] r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.INTERNAL     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PRIVATE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PRIVATE_TO_THIS     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PROTECTED     // Catch:{ NoSuchFieldError -> 0x007d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                r5 = 5
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PUBLIC     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                r6 = 6
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.LOCAL     // Catch:{ NoSuchFieldError -> 0x008f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                $EnumSwitchMapping$2 = r0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind[] r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.CLASS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.INTERFACE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r7] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ENUM_CLASS     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r0[r7] = r3     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ENUM_ENTRY     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r0[r7] = r4     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ANNOTATION_CLASS     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r0[r7] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.OBJECT     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.COMPANION_OBJECT     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r8 = 7
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                $EnumSwitchMapping$3 = r0
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind[] r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE     // Catch:{ NoSuchFieldError -> 0x00ea }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ea }
                r0[r7] = r2     // Catch:{ NoSuchFieldError -> 0x00ea }
            L_0x00ea:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r0[r7] = r3     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r0[r7] = r4     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r0[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT     // Catch:{ NoSuchFieldError -> 0x010a }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x010a }
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x010a }
            L_0x010a:
                $EnumSwitchMapping$4 = r0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance[] r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.IN     // Catch:{ NoSuchFieldError -> 0x011b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.OUT     // Catch:{ NoSuchFieldError -> 0x0123 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0123 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0123 }
            L_0x0123:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.INV     // Catch:{ NoSuchFieldError -> 0x012b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x012b }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x012b }
            L_0x012b:
                $EnumSwitchMapping$5 = r0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection[] r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.IN     // Catch:{ NoSuchFieldError -> 0x013c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x013c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x013c }
            L_0x013c:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.OUT     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.INV     // Catch:{ NoSuchFieldError -> 0x014c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x014c }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x014c }
            L_0x014c:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.STAR     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                $EnumSwitchMapping$6 = r0
                kotlin.reflect.jvm.internal.impl.types.Variance[] r0 = kotlin.reflect.jvm.internal.impl.types.Variance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE     // Catch:{ NoSuchFieldError -> 0x0165 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0165 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0165 }
            L_0x0165:
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE     // Catch:{ NoSuchFieldError -> 0x016d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x016d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x016d }
            L_0x016d:
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0175 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0175 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0175 }
            L_0x0175:
                $EnumSwitchMapping$7 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings.<clinit>():void");
        }
    }

    private ProtoEnumFlags() {
    }

    @NotNull
    public final ClassKind classKind(@Nullable ProtoBuf.Class.Kind kind) {
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$3[kind.ordinal()]) {
            case 1:
                return ClassKind.CLASS;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
            default:
                return ClassKind.CLASS;
        }
    }

    @NotNull
    public final Modality modality(@Nullable ProtoBuf.Modality modality) {
        int i = modality == null ? -1 : WhenMappings.$EnumSwitchMapping$0[modality.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Modality.FINAL : Modality.SEALED : Modality.ABSTRACT : Modality.OPEN : Modality.FINAL;
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        Intrinsics.checkNotNullParameter(variance, "variance");
        int i = WhenMappings.$EnumSwitchMapping$5[variance.ordinal()];
        if (i == 1) {
            return Variance.IN_VARIANCE;
        }
        if (i == 2) {
            return Variance.OUT_VARIANCE;
        }
        if (i == 3) {
            return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection projection) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        int i = WhenMappings.$EnumSwitchMapping$6[projection.ordinal()];
        if (i == 1) {
            return Variance.IN_VARIANCE;
        }
        if (i == 2) {
            return Variance.OUT_VARIANCE;
        }
        if (i == 3) {
            return Variance.INVARIANT;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
    }
}
