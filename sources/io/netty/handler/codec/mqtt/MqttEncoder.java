package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.mqtt.MqttProperties;
import io.netty.util.internal.EmptyArrays;
import java.util.List;

@ChannelHandler.Sharable
public final class MqttEncoder extends MessageToMessageEncoder<MqttMessage> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MqttEncoder INSTANCE = new MqttEncoder();

    /* renamed from: io.netty.handler.codec.mqtt.MqttEncoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType;

        /* JADX WARNING: Can't wrap try/catch for region: R(100:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|116) */
        /* JADX WARNING: Can't wrap try/catch for region: R(101:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|116) */
        /* JADX WARNING: Can't wrap try/catch for region: R(85:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(86:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(89:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(91:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(3:113|114|116)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(96:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|116) */
        /* JADX WARNING: Can't wrap try/catch for region: R(98:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|116) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x019b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x01a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x01af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x01b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x01c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x01d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0155 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x015f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0169 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0173 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x017d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0187 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0191 */
        static {
            /*
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType[] r0 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType = r0
                r1 = 1
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r2 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.PAYLOAD_FORMAT_INDICATOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r3 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.REQUEST_PROBLEM_INFORMATION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r4 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.REQUEST_RESPONSE_INFORMATION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r5 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.MAXIMUM_QOS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r6 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.RETAIN_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r7 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.WILDCARD_SUBSCRIPTION_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r8 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SUBSCRIPTION_IDENTIFIER_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r9 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SHARED_SUBSCRIPTION_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r10 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SERVER_KEEP_ALIVE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r11 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.RECEIVE_MAXIMUM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r12 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.TOPIC_ALIAS_MAXIMUM     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                r11 = 12
                int[] r12 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0090 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r13 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.TOPIC_ALIAS     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                r12 = 13
                int[] r13 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x009c }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r14 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.PUBLICATION_EXPIRY_INTERVAL     // Catch:{ NoSuchFieldError -> 0x009c }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r13[r14] = r12     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                r13 = 14
                int[] r14 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r15 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SESSION_EXPIRY_INTERVAL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r14[r15] = r13     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                r14 = 15
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.WILL_DELAY_INTERVAL     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r15[r16] = r14     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.MAXIMUM_PACKET_SIZE     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r17 = 16
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00cc }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SUBSCRIPTION_IDENTIFIER     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r17 = 17
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.CONTENT_TYPE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r17 = 18
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.RESPONSE_TOPIC     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r17 = 19
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.ASSIGNED_CLIENT_IDENTIFIER     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r17 = 20
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x00fc }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.AUTHENTICATION_METHOD     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r17 = 21
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0108 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.RESPONSE_INFORMATION     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r17 = 22
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0114 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.SERVER_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r17 = 23
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0120 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.REASON_STRING     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r17 = 24
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x012c }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.USER_PROPERTY     // Catch:{ NoSuchFieldError -> 0x012c }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r17 = 25
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0138 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.CORRELATION_DATA     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r17 = 26
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType     // Catch:{ NoSuchFieldError -> 0x0144 }
                io.netty.handler.codec.mqtt.MqttProperties$MqttPropertyType r16 = io.netty.handler.codec.mqtt.MqttProperties.MqttPropertyType.AUTHENTICATION_DATA     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r17 = 27
                r15[r16] = r17     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                io.netty.handler.codec.mqtt.MqttMessageType[] r15 = io.netty.handler.codec.mqtt.MqttMessageType.values()
                int r15 = r15.length
                int[] r15 = new int[r15]
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = r15
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.CONNECT     // Catch:{ NoSuchFieldError -> 0x0155 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0155 }
                r15[r16] = r1     // Catch:{ NoSuchFieldError -> 0x0155 }
            L_0x0155:
                int[] r1 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x015f }
                io.netty.handler.codec.mqtt.MqttMessageType r15 = io.netty.handler.codec.mqtt.MqttMessageType.CONNACK     // Catch:{ NoSuchFieldError -> 0x015f }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x015f }
                r1[r15] = r0     // Catch:{ NoSuchFieldError -> 0x015f }
            L_0x015f:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0169 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBLISH     // Catch:{ NoSuchFieldError -> 0x0169 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0169 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0169 }
            L_0x0169:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0173 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.SUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x0173 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0173 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0173 }
            L_0x0173:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x017d }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x017d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x017d }
            L_0x017d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0187 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.SUBACK     // Catch:{ NoSuchFieldError -> 0x0187 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0187 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0187 }
            L_0x0187:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0191 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBACK     // Catch:{ NoSuchFieldError -> 0x0191 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0191 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0191 }
            L_0x0191:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x019b }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBACK     // Catch:{ NoSuchFieldError -> 0x019b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x019b }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x019b }
            L_0x019b:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01a5 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREC     // Catch:{ NoSuchFieldError -> 0x01a5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a5 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x01a5 }
            L_0x01a5:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01af }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREL     // Catch:{ NoSuchFieldError -> 0x01af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01af }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x01af }
            L_0x01af:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01b9 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBCOMP     // Catch:{ NoSuchFieldError -> 0x01b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b9 }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x01b9 }
            L_0x01b9:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01c3 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x01c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c3 }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x01c3 }
            L_0x01c3:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01cd }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.AUTH     // Catch:{ NoSuchFieldError -> 0x01cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cd }
                r0[r1] = r12     // Catch:{ NoSuchFieldError -> 0x01cd }
            L_0x01cd:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01d7 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PINGREQ     // Catch:{ NoSuchFieldError -> 0x01d7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d7 }
                r0[r1] = r13     // Catch:{ NoSuchFieldError -> 0x01d7 }
            L_0x01d7:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01e1 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PINGRESP     // Catch:{ NoSuchFieldError -> 0x01e1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e1 }
                r0[r1] = r14     // Catch:{ NoSuchFieldError -> 0x01e1 }
            L_0x01e1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    private MqttEncoder() {
    }

    public static ByteBuf doEncode(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessage.fixedHeader().messageType().ordinal()]) {
            case 1:
                return encodeConnectMessage(channelHandlerContext, (MqttConnectMessage) mqttMessage);
            case 2:
                return encodeConnAckMessage(channelHandlerContext, (MqttConnAckMessage) mqttMessage);
            case 3:
                return encodePublishMessage(channelHandlerContext, (MqttPublishMessage) mqttMessage);
            case 4:
                return encodeSubscribeMessage(channelHandlerContext, (MqttSubscribeMessage) mqttMessage);
            case 5:
                return encodeUnsubscribeMessage(channelHandlerContext, (MqttUnsubscribeMessage) mqttMessage);
            case 6:
                return encodeSubAckMessage(channelHandlerContext, (MqttSubAckMessage) mqttMessage);
            case 7:
                return mqttMessage instanceof MqttUnsubAckMessage ? encodeUnsubAckMessage(channelHandlerContext, (MqttUnsubAckMessage) mqttMessage) : encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(channelHandlerContext.alloc(), mqttMessage);
            case 8:
            case 9:
            case 10:
            case 11:
                return encodePubReplyMessage(channelHandlerContext, mqttMessage);
            case 12:
            case 13:
                return encodeReasonCodePlusPropertiesMessage(channelHandlerContext, mqttMessage);
            case 14:
            case 15:
                return encodeMessageWithOnlySingleByteFixedHeader(channelHandlerContext.alloc(), mqttMessage);
            default:
                throw new IllegalArgumentException("Unknown message type: " + mqttMessage.fixedHeader().messageType().value());
        }
    }

    private static ByteBuf encodeConnAckMessage(ChannelHandlerContext channelHandlerContext, MqttConnAckMessage mqttConnAckMessage) {
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(MqttCodecUtil.getMqttVersion(channelHandlerContext), channelHandlerContext.alloc(), mqttConnAckMessage.variableHeader().properties());
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(encodePropertiesIfNeeded.readableBytes() + 4);
            buffer.writeByte(getFixedHeaderByte1(mqttConnAckMessage.fixedHeader()));
            writeVariableLengthInt(buffer, encodePropertiesIfNeeded.readableBytes() + 2);
            buffer.writeByte(mqttConnAckMessage.variableHeader().isSessionPresent() ? 1 : 0);
            buffer.writeByte(mqttConnAckMessage.variableHeader().connectReturnCode().byteValue());
            buffer.writeBytes(encodePropertiesIfNeeded);
            return buffer;
        } finally {
            encodePropertiesIfNeeded.release();
        }
    }

    private static ByteBuf encodeConnectMessage(ChannelHandlerContext channelHandlerContext, MqttConnectMessage mqttConnectMessage) {
        ByteBuf byteBuf;
        MqttFixedHeader fixedHeader = mqttConnectMessage.fixedHeader();
        MqttConnectVariableHeader variableHeader = mqttConnectMessage.variableHeader();
        MqttConnectPayload payload = mqttConnectMessage.payload();
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel(variableHeader.name(), (byte) variableHeader.version());
        MqttCodecUtil.setMqttVersion(channelHandlerContext, fromProtocolNameAndLevel);
        if (variableHeader.hasUserName() || !variableHeader.hasPassword()) {
            String clientIdentifier = payload.clientIdentifier();
            if (MqttCodecUtil.isValidClientId(fromProtocolNameAndLevel, 23, clientIdentifier)) {
                int utf8Bytes = ByteBufUtil.utf8Bytes(clientIdentifier);
                int i = utf8Bytes + 2;
                String willTopic = payload.willTopic();
                int nullableUtf8Bytes = nullableUtf8Bytes(willTopic);
                byte[] willMessageInBytes = payload.willMessageInBytes();
                if (willMessageInBytes == null) {
                    willMessageInBytes = EmptyArrays.EMPTY_BYTES;
                }
                if (variableHeader.isWillFlag()) {
                    i = i + nullableUtf8Bytes + 2 + willMessageInBytes.length + 2;
                }
                String userName = payload.userName();
                int nullableUtf8Bytes2 = nullableUtf8Bytes(userName);
                if (variableHeader.hasUserName()) {
                    i += nullableUtf8Bytes2 + 2;
                }
                byte[] passwordInBytes = payload.passwordInBytes();
                if (passwordInBytes == null) {
                    passwordInBytes = EmptyArrays.EMPTY_BYTES;
                }
                if (variableHeader.hasPassword()) {
                    i += passwordInBytes.length + 2;
                }
                byte[] protocolNameBytes = fromProtocolNameAndLevel.protocolNameBytes();
                ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(fromProtocolNameAndLevel, channelHandlerContext.alloc(), mqttConnectMessage.variableHeader().properties());
                try {
                    if (variableHeader.isWillFlag()) {
                        byteBuf = encodePropertiesIfNeeded(fromProtocolNameAndLevel, channelHandlerContext.alloc(), payload.willProperties());
                        i += byteBuf.readableBytes();
                    } else {
                        byteBuf = Unpooled.EMPTY_BUFFER;
                    }
                    int length = protocolNameBytes.length + 6 + encodePropertiesIfNeeded.readableBytes() + i;
                    ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(length) + 1 + length);
                    buffer.writeByte(getFixedHeaderByte1(fixedHeader));
                    writeVariableLengthInt(buffer, length);
                    buffer.writeShort(protocolNameBytes.length);
                    buffer.writeBytes(protocolNameBytes);
                    buffer.writeByte(variableHeader.version());
                    buffer.writeByte(getConnVariableHeaderFlag(variableHeader));
                    buffer.writeShort(variableHeader.keepAliveTimeSeconds());
                    buffer.writeBytes(encodePropertiesIfNeeded);
                    writeExactUTF8String(buffer, clientIdentifier, utf8Bytes);
                    if (variableHeader.isWillFlag()) {
                        buffer.writeBytes(byteBuf);
                        writeExactUTF8String(buffer, willTopic, nullableUtf8Bytes);
                        buffer.writeShort(willMessageInBytes.length);
                        buffer.writeBytes(willMessageInBytes, 0, willMessageInBytes.length);
                    }
                    if (variableHeader.hasUserName()) {
                        writeExactUTF8String(buffer, userName, nullableUtf8Bytes2);
                    }
                    if (variableHeader.hasPassword()) {
                        buffer.writeShort(passwordInBytes.length);
                        buffer.writeBytes(passwordInBytes, 0, passwordInBytes.length);
                    }
                    byteBuf.release();
                    encodePropertiesIfNeeded.release();
                    return buffer;
                } catch (Throwable th) {
                    encodePropertiesIfNeeded.release();
                    throw th;
                }
            } else {
                throw new MqttIdentifierRejectedException("invalid clientIdentifier: " + clientIdentifier);
            }
        } else {
            throw new EncoderException("Without a username, the password MUST be not set");
        }
    }

    private static ByteBuf encodeMessageWithOnlySingleByteFixedHeader(ByteBufAllocator byteBufAllocator, MqttMessage mqttMessage) {
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        ByteBuf buffer = byteBufAllocator.buffer(2);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        buffer.writeByte(0);
        return buffer;
    }

    private static ByteBuf encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(ByteBufAllocator byteBufAllocator, MqttMessage mqttMessage) {
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        int messageId = ((MqttMessageIdVariableHeader) mqttMessage.variableHeader()).messageId();
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(2) + 3);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        writeVariableLengthInt(buffer, 2);
        buffer.writeShort(messageId);
        return buffer;
    }

    private static ByteBuf encodeProperties(ByteBufAllocator byteBufAllocator, MqttProperties mqttProperties) {
        ByteBuf buffer;
        ByteBuf buffer2 = byteBufAllocator.buffer();
        try {
            buffer = byteBufAllocator.buffer();
            for (MqttProperties.MqttProperty mqttProperty : mqttProperties.listAll()) {
                MqttProperties.MqttPropertyType valueOf = MqttProperties.MqttPropertyType.valueOf(mqttProperty.propertyId);
                switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType[valueOf.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        buffer.writeByte(((Integer) ((MqttProperties.IntegerProperty) mqttProperty).value).byteValue());
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        buffer.writeShort(((Integer) ((MqttProperties.IntegerProperty) mqttProperty).value).shortValue());
                        break;
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        buffer.writeInt(((Integer) ((MqttProperties.IntegerProperty) mqttProperty).value).intValue());
                        break;
                    case 17:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        writeVariableLengthInt(buffer, ((Integer) ((MqttProperties.IntegerProperty) mqttProperty).value).intValue());
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        writeEagerUTF8String(buffer, (String) ((MqttProperties.StringProperty) mqttProperty).value);
                        break;
                    case 25:
                        for (MqttProperties.StringPair stringPair : (List) ((MqttProperties.UserProperties) mqttProperty).value) {
                            writeVariableLengthInt(buffer, mqttProperty.propertyId);
                            writeEagerUTF8String(buffer, stringPair.key);
                            writeEagerUTF8String(buffer, stringPair.value);
                        }
                        break;
                    case 26:
                    case 27:
                        writeVariableLengthInt(buffer, mqttProperty.propertyId);
                        byte[] bArr = (byte[]) ((MqttProperties.BinaryProperty) mqttProperty).value;
                        buffer.writeShort(bArr.length);
                        buffer.writeBytes(bArr, 0, bArr.length);
                        break;
                    default:
                        throw new EncoderException("Unknown property type: " + valueOf);
                }
            }
            writeVariableLengthInt(buffer2, buffer.readableBytes());
            buffer2.writeBytes(buffer);
            buffer.release();
            return buffer2;
        } catch (RuntimeException e) {
            buffer2.release();
            throw e;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    private static ByteBuf encodePropertiesIfNeeded(MqttVersion mqttVersion, ByteBufAllocator byteBufAllocator, MqttProperties mqttProperties) {
        return mqttVersion == MqttVersion.MQTT_5 ? encodeProperties(byteBufAllocator, mqttProperties) : Unpooled.EMPTY_BUFFER;
    }

    private static ByteBuf encodePubReplyMessage(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage) {
        boolean z;
        int i;
        ByteBuf byteBuf;
        if (!(mqttMessage.variableHeader() instanceof MqttPubReplyMessageVariableHeader)) {
            return encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(channelHandlerContext.alloc(), mqttMessage);
        }
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        MqttPubReplyMessageVariableHeader mqttPubReplyMessageVariableHeader = (MqttPubReplyMessageVariableHeader) mqttMessage.variableHeader();
        int messageId = mqttPubReplyMessageVariableHeader.messageId();
        if (MqttCodecUtil.getMqttVersion(channelHandlerContext) != MqttVersion.MQTT_5 || (mqttPubReplyMessageVariableHeader.reasonCode() == 0 && mqttPubReplyMessageVariableHeader.properties().isEmpty())) {
            byteBuf = Unpooled.EMPTY_BUFFER;
            z = false;
            i = 2;
        } else {
            byteBuf = encodeProperties(channelHandlerContext.alloc(), mqttPubReplyMessageVariableHeader.properties());
            i = byteBuf.readableBytes() + 3;
            z = true;
        }
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(i) + 1 + i);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, i);
            buffer.writeShort(messageId);
            if (z) {
                buffer.writeByte(mqttPubReplyMessageVariableHeader.reasonCode());
            }
            buffer.writeBytes(byteBuf);
            byteBuf.release();
            return buffer;
        } catch (Throwable th) {
            byteBuf.release();
            throw th;
        }
    }

    private static ByteBuf encodePublishMessage(ChannelHandlerContext channelHandlerContext, MqttPublishMessage mqttPublishMessage) {
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        MqttFixedHeader fixedHeader = mqttPublishMessage.fixedHeader();
        MqttPublishVariableHeader variableHeader = mqttPublishMessage.variableHeader();
        ByteBuf duplicate = mqttPublishMessage.payload().duplicate();
        String str = variableHeader.topicName();
        int utf8Bytes = ByteBufUtil.utf8Bytes(str);
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(mqttVersion, channelHandlerContext.alloc(), mqttPublishMessage.variableHeader().properties());
        try {
            int readableBytes = utf8Bytes + 2 + (fixedHeader.qosLevel().value() > 0 ? 2 : 0) + encodePropertiesIfNeeded.readableBytes() + duplicate.readableBytes();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(readableBytes) + 1 + readableBytes);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, readableBytes);
            writeExactUTF8String(buffer, str, utf8Bytes);
            if (fixedHeader.qosLevel().value() > 0) {
                buffer.writeShort(variableHeader.packetId());
            }
            buffer.writeBytes(encodePropertiesIfNeeded);
            buffer.writeBytes(duplicate);
            encodePropertiesIfNeeded.release();
            return buffer;
        } catch (Throwable th) {
            encodePropertiesIfNeeded.release();
            throw th;
        }
    }

    private static ByteBuf encodeReasonCodePlusPropertiesMessage(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage) {
        boolean z;
        int i;
        ByteBuf byteBuf;
        if (!(mqttMessage.variableHeader() instanceof MqttReasonCodeAndPropertiesVariableHeader)) {
            return encodeMessageWithOnlySingleByteFixedHeader(channelHandlerContext.alloc(), mqttMessage);
        }
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        MqttReasonCodeAndPropertiesVariableHeader mqttReasonCodeAndPropertiesVariableHeader = (MqttReasonCodeAndPropertiesVariableHeader) mqttMessage.variableHeader();
        if (mqttVersion != MqttVersion.MQTT_5 || (mqttReasonCodeAndPropertiesVariableHeader.reasonCode() == 0 && mqttReasonCodeAndPropertiesVariableHeader.properties().isEmpty())) {
            byteBuf = Unpooled.EMPTY_BUFFER;
            i = 0;
            z = false;
        } else {
            byteBuf = encodeProperties(channelHandlerContext.alloc(), mqttReasonCodeAndPropertiesVariableHeader.properties());
            i = byteBuf.readableBytes() + 1;
            z = true;
        }
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(i) + 1 + i);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, i);
            if (z) {
                buffer.writeByte(mqttReasonCodeAndPropertiesVariableHeader.reasonCode());
            }
            buffer.writeBytes(byteBuf);
            byteBuf.release();
            return buffer;
        } catch (Throwable th) {
            byteBuf.release();
            throw th;
        }
    }

    private static ByteBuf encodeSubAckMessage(ChannelHandlerContext channelHandlerContext, MqttSubAckMessage mqttSubAckMessage) {
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(MqttCodecUtil.getMqttVersion(channelHandlerContext), channelHandlerContext.alloc(), mqttSubAckMessage.idAndPropertiesVariableHeader().properties());
        try {
            int readableBytes = encodePropertiesIfNeeded.readableBytes() + 2 + mqttSubAckMessage.payload().grantedQoSLevels().size();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(readableBytes) + 1 + readableBytes);
            buffer.writeByte(getFixedHeaderByte1(mqttSubAckMessage.fixedHeader()));
            writeVariableLengthInt(buffer, readableBytes);
            buffer.writeShort(mqttSubAckMessage.variableHeader().messageId());
            buffer.writeBytes(encodePropertiesIfNeeded);
            for (Integer intValue : mqttSubAckMessage.payload().reasonCodes()) {
                buffer.writeByte(intValue.intValue());
            }
            return buffer;
        } finally {
            encodePropertiesIfNeeded.release();
        }
    }

    private static ByteBuf encodeSubscribeMessage(ChannelHandlerContext channelHandlerContext, MqttSubscribeMessage mqttSubscribeMessage) {
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(mqttVersion, channelHandlerContext.alloc(), mqttSubscribeMessage.idAndPropertiesVariableHeader().properties());
        try {
            int readableBytes = encodePropertiesIfNeeded.readableBytes() + 2;
            MqttFixedHeader fixedHeader = mqttSubscribeMessage.fixedHeader();
            MqttMessageIdVariableHeader variableHeader = mqttSubscribeMessage.variableHeader();
            MqttSubscribePayload payload = mqttSubscribeMessage.payload();
            int i = 0;
            for (MqttTopicSubscription mqttTopicSubscription : payload.topicSubscriptions()) {
                i = i + ByteBufUtil.utf8Bytes(mqttTopicSubscription.topicName()) + 2 + 1;
            }
            int i2 = readableBytes + i;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(i2) + 1 + i2);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, i2);
            buffer.writeShort(variableHeader.messageId());
            buffer.writeBytes(encodePropertiesIfNeeded);
            for (MqttTopicSubscription next : payload.topicSubscriptions()) {
                writeUnsafeUTF8String(buffer, next.topicName());
                if (mqttVersion != MqttVersion.MQTT_3_1_1) {
                    if (mqttVersion != MqttVersion.MQTT_3_1) {
                        MqttSubscriptionOption option = next.option();
                        int value = option.retainHandling().value() << 4;
                        if (option.isRetainAsPublished()) {
                            value |= 8;
                        }
                        if (option.isNoLocal()) {
                            value |= 4;
                        }
                        buffer.writeByte(option.qos().value() | value);
                    }
                }
                buffer.writeByte(next.qualityOfService().value());
            }
            encodePropertiesIfNeeded.release();
            return buffer;
        } catch (Throwable th) {
            encodePropertiesIfNeeded.release();
            throw th;
        }
    }

    private static ByteBuf encodeUnsubAckMessage(ChannelHandlerContext channelHandlerContext, MqttUnsubAckMessage mqttUnsubAckMessage) {
        if (!(mqttUnsubAckMessage.variableHeader() instanceof MqttMessageIdAndPropertiesVariableHeader)) {
            return encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(channelHandlerContext.alloc(), mqttUnsubAckMessage);
        }
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(MqttCodecUtil.getMqttVersion(channelHandlerContext), channelHandlerContext.alloc(), mqttUnsubAckMessage.idAndPropertiesVariableHeader().properties());
        try {
            int readableBytes = encodePropertiesIfNeeded.readableBytes() + 2;
            MqttUnsubAckPayload payload = mqttUnsubAckMessage.payload();
            int size = readableBytes + (payload == null ? 0 : payload.unsubscribeReasonCodes().size());
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(size) + 1 + size);
            buffer.writeByte(getFixedHeaderByte1(mqttUnsubAckMessage.fixedHeader()));
            writeVariableLengthInt(buffer, size);
            buffer.writeShort(mqttUnsubAckMessage.variableHeader().messageId());
            buffer.writeBytes(encodePropertiesIfNeeded);
            if (payload != null) {
                for (Short shortValue : payload.unsubscribeReasonCodes()) {
                    buffer.writeByte(shortValue.shortValue());
                }
            }
            return buffer;
        } finally {
            encodePropertiesIfNeeded.release();
        }
    }

    private static ByteBuf encodeUnsubscribeMessage(ChannelHandlerContext channelHandlerContext, MqttUnsubscribeMessage mqttUnsubscribeMessage) {
        ByteBuf encodePropertiesIfNeeded = encodePropertiesIfNeeded(MqttCodecUtil.getMqttVersion(channelHandlerContext), channelHandlerContext.alloc(), mqttUnsubscribeMessage.idAndPropertiesVariableHeader().properties());
        try {
            int readableBytes = encodePropertiesIfNeeded.readableBytes() + 2;
            MqttFixedHeader fixedHeader = mqttUnsubscribeMessage.fixedHeader();
            MqttMessageIdVariableHeader variableHeader = mqttUnsubscribeMessage.variableHeader();
            MqttUnsubscribePayload payload = mqttUnsubscribeMessage.payload();
            int i = 0;
            for (String utf8Bytes : payload.topics()) {
                i += ByteBufUtil.utf8Bytes(utf8Bytes) + 2;
            }
            int i2 = readableBytes + i;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(getVariableLengthInt(i2) + 1 + i2);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, i2);
            buffer.writeShort(variableHeader.messageId());
            buffer.writeBytes(encodePropertiesIfNeeded);
            for (String writeUnsafeUTF8String : payload.topics()) {
                writeUnsafeUTF8String(buffer, writeUnsafeUTF8String);
            }
            encodePropertiesIfNeeded.release();
            return buffer;
        } catch (Throwable th) {
            encodePropertiesIfNeeded.release();
            throw th;
        }
    }

    private static int getConnVariableHeaderFlag(MqttConnectVariableHeader mqttConnectVariableHeader) {
        int i = mqttConnectVariableHeader.hasUserName() ? 128 : 0;
        if (mqttConnectVariableHeader.hasPassword()) {
            i |= 64;
        }
        if (mqttConnectVariableHeader.isWillRetain()) {
            i |= 32;
        }
        int willQos = i | ((mqttConnectVariableHeader.willQos() & 3) << 3);
        if (mqttConnectVariableHeader.isWillFlag()) {
            willQos |= 4;
        }
        return mqttConnectVariableHeader.isCleanSession() ? willQos | 2 : willQos;
    }

    private static int getFixedHeaderByte1(MqttFixedHeader mqttFixedHeader) {
        int value = mqttFixedHeader.messageType().value() << 4;
        if (mqttFixedHeader.isDup()) {
            value |= 8;
        }
        int value2 = value | (mqttFixedHeader.qosLevel().value() << 1);
        return mqttFixedHeader.isRetain() ? value2 | 1 : value2;
    }

    private static int getVariableLengthInt(int i) {
        int i2 = 0;
        do {
            i /= 128;
            i2++;
        } while (i > 0);
        return i2;
    }

    private static int nullableMaxUtf8Bytes(String str) {
        if (str == null) {
            return 0;
        }
        return ByteBufUtil.utf8MaxBytes((CharSequence) str);
    }

    private static int nullableUtf8Bytes(String str) {
        if (str == null) {
            return 0;
        }
        return ByteBufUtil.utf8Bytes(str);
    }

    private static void writeEagerUTF8String(ByteBuf byteBuf, String str) {
        int nullableMaxUtf8Bytes = nullableMaxUtf8Bytes(str);
        byteBuf.ensureWritable(nullableMaxUtf8Bytes + 2);
        int writerIndex = byteBuf.writerIndex();
        byteBuf.writerIndex(writerIndex + 2);
        byteBuf.setShort(writerIndex, str != null ? ByteBufUtil.reserveAndWriteUtf8(byteBuf, str, nullableMaxUtf8Bytes) : 0);
    }

    private static void writeExactUTF8String(ByteBuf byteBuf, String str, int i) {
        byteBuf.ensureWritable(i + 2);
        byteBuf.writeShort(i);
        if (i > 0) {
            ByteBufUtil.reserveAndWriteUtf8(byteBuf, str, i);
        }
    }

    private static void writeUnsafeUTF8String(ByteBuf byteBuf, String str) {
        int writerIndex = byteBuf.writerIndex();
        byteBuf.writerIndex(writerIndex + 2);
        int i = 0;
        if (str != null) {
            i = ByteBufUtil.reserveAndWriteUtf8(byteBuf, str, 0);
        }
        byteBuf.setShort(writerIndex, i);
    }

    private static void writeVariableLengthInt(ByteBuf byteBuf, int i) {
        do {
            int i2 = i % 128;
            i /= 128;
            if (i > 0) {
                i2 |= 128;
            }
            byteBuf.writeByte(i2);
        } while (i > 0);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage, List<Object> list) throws Exception {
        list.add(doEncode(channelHandlerContext, mqttMessage));
    }
}
