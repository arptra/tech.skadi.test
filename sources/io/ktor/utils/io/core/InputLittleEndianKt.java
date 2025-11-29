package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/utils/io/core/Input;", "", "a", "(Lio/ktor/utils/io/core/Input;)S", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInputLittleEndian.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputLittleEndian.kt\nio/ktor/utils/io/core/InputLittleEndianKt\n+ 2 ByteOrderJvm.kt\nio/ktor/utils/io/bits/ByteOrderJVMKt\n*L\n1#1,349:1\n344#1,3:350\n344#1,3:354\n344#1,3:358\n344#1,3:362\n344#1,3:372\n336#1:382\n336#1:384\n336#1:386\n336#1:388\n336#1:396\n336#1:404\n336#1:406\n336#1:408\n336#1:410\n336#1:418\n9#2:353\n15#2:357\n21#2:361\n30#2:365\n29#2:366\n28#2,5:367\n41#2:375\n40#2:376\n39#2,5:377\n9#2:383\n15#2:385\n21#2:387\n30#2:389\n29#2:390\n28#2,5:391\n41#2:397\n40#2:398\n39#2,5:399\n9#2:405\n15#2:407\n21#2:409\n30#2:411\n29#2:412\n28#2,5:413\n41#2:419\n40#2:420\n39#2,5:421\n9#2:426\n15#2:427\n21#2:428\n30#2:429\n29#2:430\n28#2,5:431\n41#2:436\n40#2:437\n39#2,5:438\n9#2:443\n15#2:444\n21#2:445\n30#2:446\n29#2:447\n28#2,5:448\n41#2:453\n40#2:454\n39#2,5:455\n9#2:460\n15#2:461\n21#2:462\n30#2:463\n29#2:464\n28#2,5:465\n41#2:470\n40#2:471\n39#2,5:472\n9#2:477\n15#2:478\n21#2:479\n30#2:480\n29#2:481\n28#2,5:482\n41#2:487\n40#2:488\n39#2,5:489\n*S KotlinDebug\n*F\n+ 1 InputLittleEndian.kt\nio/ktor/utils/io/core/InputLittleEndianKt\n*L\n9#1:350,3\n13#1:354,3\n17#1:358,3\n21#1:362,3\n25#1:372,3\n28#1:382\n31#1:384\n34#1:386\n37#1:388\n40#1:396\n43#1:404\n46#1:406\n49#1:408\n52#1:410\n55#1:418\n9#1:353\n13#1:357\n17#1:361\n21#1:365\n21#1:366\n21#1:367,5\n25#1:375\n25#1:376\n25#1:377,5\n28#1:383\n31#1:385\n34#1:387\n37#1:389\n37#1:390\n37#1:391,5\n40#1:397\n40#1:398\n40#1:399,5\n43#1:405\n46#1:407\n49#1:409\n52#1:411\n52#1:412\n52#1:413,5\n55#1:419\n55#1:420\n55#1:421,5\n68#1:426\n83#1:427\n98#1:428\n107#1:429\n107#1:430\n107#1:431,5\n116#1:436\n116#1:437\n116#1:438,5\n132#1:443\n150#1:444\n168#1:445\n180#1:446\n180#1:447\n180#1:448,5\n192#1:453\n192#1:454\n192#1:455,5\n209#1:460\n224#1:461\n239#1:462\n248#1:463\n248#1:464\n248#1:465,5\n257#1:470\n257#1:471\n257#1:472,5\n272#1:477\n288#1:478\n305#1:479\n317#1:480\n317#1:481\n317#1:482,5\n329#1:487\n329#1:488\n329#1:489,5\n*E\n"})
public final class InputLittleEndianKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            try {
                iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final short a(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Short.reverseBytes(InputPrimitivesKt.i(input));
    }
}
