package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.mqtt.MqttProperties;
import io.netty.handler.codec.mqtt.MqttSubscriptionOption;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;

public final class MqttDecoder extends ReplayingDecoder<DecoderState> {
    private int bytesRemainingInVariablePart;
    private final int maxBytesInMessage;
    private final int maxClientIdLength;
    private MqttFixedHeader mqttFixedHeader;
    private Object variableHeader;

    /* renamed from: io.netty.handler.codec.mqtt.MqttDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType;

        /* JADX WARNING: Can't wrap try/catch for region: R(101:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(103:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(105:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(107:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(110:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|117|118|119|120|121|122|123|124|126) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(94:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(96:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(97:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(98:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(99:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|(2:113|114)|115|117|118|119|120|121|122|(3:123|124|126)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x019b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x01a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x01af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x01b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x01c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x01d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x01fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x0206 */
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
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.PUBLISH     // Catch:{ NoSuchFieldError -> 0x0155 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0155 }
                r15[r16] = r1     // Catch:{ NoSuchFieldError -> 0x0155 }
            L_0x0155:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x015f }
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREL     // Catch:{ NoSuchFieldError -> 0x015f }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x015f }
                r15[r16] = r0     // Catch:{ NoSuchFieldError -> 0x015f }
            L_0x015f:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0169 }
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.SUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x0169 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0169 }
                r15[r16] = r2     // Catch:{ NoSuchFieldError -> 0x0169 }
            L_0x0169:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0173 }
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x0173 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x0173 }
                r15[r16] = r3     // Catch:{ NoSuchFieldError -> 0x0173 }
            L_0x0173:
                int[] r15 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x017d }
                io.netty.handler.codec.mqtt.MqttMessageType r16 = io.netty.handler.codec.mqtt.MqttMessageType.AUTH     // Catch:{ NoSuchFieldError -> 0x017d }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x017d }
                r15[r16] = r4     // Catch:{ NoSuchFieldError -> 0x017d }
            L_0x017d:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0187 }
                io.netty.handler.codec.mqtt.MqttMessageType r15 = io.netty.handler.codec.mqtt.MqttMessageType.CONNACK     // Catch:{ NoSuchFieldError -> 0x0187 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x0187 }
                r4[r15] = r5     // Catch:{ NoSuchFieldError -> 0x0187 }
            L_0x0187:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0191 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.CONNECT     // Catch:{ NoSuchFieldError -> 0x0191 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0191 }
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0191 }
            L_0x0191:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x019b }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x019b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x019b }
                r4[r5] = r7     // Catch:{ NoSuchFieldError -> 0x019b }
            L_0x019b:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01a5 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.PINGREQ     // Catch:{ NoSuchFieldError -> 0x01a5 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a5 }
                r4[r5] = r8     // Catch:{ NoSuchFieldError -> 0x01a5 }
            L_0x01a5:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01af }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.PINGRESP     // Catch:{ NoSuchFieldError -> 0x01af }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01af }
                r4[r5] = r9     // Catch:{ NoSuchFieldError -> 0x01af }
            L_0x01af:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01b9 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.PUBACK     // Catch:{ NoSuchFieldError -> 0x01b9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b9 }
                r4[r5] = r10     // Catch:{ NoSuchFieldError -> 0x01b9 }
            L_0x01b9:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01c3 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.PUBCOMP     // Catch:{ NoSuchFieldError -> 0x01c3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c3 }
                r4[r5] = r11     // Catch:{ NoSuchFieldError -> 0x01c3 }
            L_0x01c3:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01cd }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREC     // Catch:{ NoSuchFieldError -> 0x01cd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cd }
                r4[r5] = r12     // Catch:{ NoSuchFieldError -> 0x01cd }
            L_0x01cd:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01d7 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.SUBACK     // Catch:{ NoSuchFieldError -> 0x01d7 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d7 }
                r4[r5] = r13     // Catch:{ NoSuchFieldError -> 0x01d7 }
            L_0x01d7:
                int[] r4 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x01e1 }
                io.netty.handler.codec.mqtt.MqttMessageType r5 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBACK     // Catch:{ NoSuchFieldError -> 0x01e1 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e1 }
                r4[r5] = r14     // Catch:{ NoSuchFieldError -> 0x01e1 }
            L_0x01e1:
                io.netty.handler.codec.mqtt.MqttDecoder$DecoderState[] r4 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState = r4
                io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r5 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_FIXED_HEADER     // Catch:{ NoSuchFieldError -> 0x01f2 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01f2 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x01f2 }
            L_0x01f2:
                int[] r1 = $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState     // Catch:{ NoSuchFieldError -> 0x01fc }
                io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r4 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_VARIABLE_HEADER     // Catch:{ NoSuchFieldError -> 0x01fc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x01fc }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x01fc }
            L_0x01fc:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState     // Catch:{ NoSuchFieldError -> 0x0206 }
                io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r1 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x0206 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0206 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0206 }
            L_0x0206:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState     // Catch:{ NoSuchFieldError -> 0x0210 }
                io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r1 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.BAD_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0210 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0210 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0210 }
            L_0x0210:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DecoderState {
        READ_FIXED_HEADER,
        READ_VARIABLE_HEADER,
        READ_PAYLOAD,
        BAD_MESSAGE
    }

    public static final class Result<T> {
        /* access modifiers changed from: private */
        public final int numberOfBytesConsumed;
        /* access modifiers changed from: private */
        public final T value;

        public Result(T t, int i) {
            this.value = t;
            this.numberOfBytesConsumed = i;
        }
    }

    public MqttDecoder() {
        this(MqttConstant.DEFAULT_MAX_BYTES_IN_MESSAGE, 23);
    }

    private static byte[] decodeByteArray(ByteBuf byteBuf) {
        byte[] bArr = new byte[decodeMsbLsb(byteBuf)];
        byteBuf.readBytes(bArr);
        return bArr;
    }

    private static Result<MqttConnAckVariableHeader> decodeConnAckVariableHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        MqttProperties mqttProperties;
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        boolean z = true;
        if ((byteBuf.readUnsignedByte() & 1) != 1) {
            z = false;
        }
        byte readByte = byteBuf.readByte();
        int i = 2;
        if (mqttVersion == MqttVersion.MQTT_5) {
            Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
            mqttProperties = (MqttProperties) decodeProperties.value;
            i = 2 + decodeProperties.numberOfBytesConsumed;
        } else {
            mqttProperties = MqttProperties.NO_PROPERTIES;
        }
        return new Result<>(new MqttConnAckVariableHeader(MqttConnectReturnCode.valueOf(readByte), z, mqttProperties), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static io.netty.handler.codec.mqtt.MqttDecoder.Result<io.netty.handler.codec.mqtt.MqttConnectPayload> decodeConnectionPayload(io.netty.buffer.ByteBuf r11, int r12, io.netty.handler.codec.mqtt.MqttConnectVariableHeader r13) {
        /*
            io.netty.handler.codec.mqtt.MqttDecoder$Result r0 = decodeString(r11)
            java.lang.Object r1 = r0.value
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r13.name()
            int r3 = r13.version()
            byte r3 = (byte) r3
            io.netty.handler.codec.mqtt.MqttVersion r2 = io.netty.handler.codec.mqtt.MqttVersion.fromProtocolNameAndLevel(r2, r3)
            boolean r12 = io.netty.handler.codec.mqtt.MqttCodecUtil.isValidClientId(r2, r12, r1)
            if (r12 == 0) goto L_0x00a4
            int r12 = r0.numberOfBytesConsumed
            boolean r1 = r13.isWillFlag()
            r3 = 0
            if (r1 == 0) goto L_0x0055
            io.netty.handler.codec.mqtt.MqttVersion r1 = io.netty.handler.codec.mqtt.MqttVersion.MQTT_5
            if (r2 != r1) goto L_0x003c
            io.netty.handler.codec.mqtt.MqttDecoder$Result r1 = decodeProperties(r11)
            java.lang.Object r2 = r1.value
            io.netty.handler.codec.mqtt.MqttProperties r2 = (io.netty.handler.codec.mqtt.MqttProperties) r2
            int r1 = r1.numberOfBytesConsumed
            int r12 = r12 + r1
            goto L_0x003e
        L_0x003c:
            io.netty.handler.codec.mqtt.MqttProperties r2 = io.netty.handler.codec.mqtt.MqttProperties.NO_PROPERTIES
        L_0x003e:
            r1 = 0
            r4 = 32767(0x7fff, float:4.5916E-41)
            io.netty.handler.codec.mqtt.MqttDecoder$Result r1 = decodeString(r11, r1, r4)
            int r4 = r1.numberOfBytesConsumed
            int r12 = r12 + r4
            byte[] r4 = decodeByteArray(r11)
            int r5 = r4.length
            int r5 = r5 + 2
            int r12 = r12 + r5
            r6 = r2
            r8 = r4
            goto L_0x005a
        L_0x0055:
            io.netty.handler.codec.mqtt.MqttProperties r2 = io.netty.handler.codec.mqtt.MqttProperties.NO_PROPERTIES
            r6 = r2
            r1 = r3
            r8 = r1
        L_0x005a:
            boolean r2 = r13.hasUserName()
            if (r2 == 0) goto L_0x006a
            io.netty.handler.codec.mqtt.MqttDecoder$Result r2 = decodeString(r11)
            int r4 = r2.numberOfBytesConsumed
            int r12 = r12 + r4
            goto L_0x006b
        L_0x006a:
            r2 = r3
        L_0x006b:
            boolean r13 = r13.hasPassword()
            if (r13 == 0) goto L_0x007b
            byte[] r11 = decodeByteArray(r11)
            int r13 = r11.length
            int r13 = r13 + 2
            int r12 = r12 + r13
            r10 = r11
            goto L_0x007c
        L_0x007b:
            r10 = r3
        L_0x007c:
            io.netty.handler.codec.mqtt.MqttConnectPayload r11 = new io.netty.handler.codec.mqtt.MqttConnectPayload
            java.lang.Object r13 = r0.value
            r5 = r13
            java.lang.String r5 = (java.lang.String) r5
            if (r1 == 0) goto L_0x008f
            java.lang.Object r13 = r1.value
            java.lang.String r13 = (java.lang.String) r13
            r7 = r13
            goto L_0x0090
        L_0x008f:
            r7 = r3
        L_0x0090:
            if (r2 == 0) goto L_0x0099
            java.lang.Object r13 = r2.value
            r3 = r13
            java.lang.String r3 = (java.lang.String) r3
        L_0x0099:
            r9 = r3
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            io.netty.handler.codec.mqtt.MqttDecoder$Result r13 = new io.netty.handler.codec.mqtt.MqttDecoder$Result
            r13.<init>(r11, r12)
            return r13
        L_0x00a4:
            io.netty.handler.codec.mqtt.MqttIdentifierRejectedException r11 = new io.netty.handler.codec.mqtt.MqttIdentifierRejectedException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "invalid clientIdentifier: "
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r11.<init>((java.lang.String) r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.decodeConnectionPayload(io.netty.buffer.ByteBuf, int, io.netty.handler.codec.mqtt.MqttConnectVariableHeader):io.netty.handler.codec.mqtt.MqttDecoder$Result");
    }

    private static Result<MqttConnectVariableHeader> decodeConnectionVariableHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        MqttProperties mqttProperties;
        Result<String> decodeString = decodeString(byteBuf);
        int access$100 = decodeString.numberOfBytesConsumed;
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel((String) decodeString.value, byteBuf.readByte());
        MqttCodecUtil.setMqttVersion(channelHandlerContext, fromProtocolNameAndLevel);
        short readUnsignedByte = byteBuf.readUnsignedByte();
        int decodeMsbLsb = decodeMsbLsb(byteBuf);
        int i = access$100 + 4;
        boolean z = (readUnsignedByte & 128) == 128;
        boolean z2 = (readUnsignedByte & 64) == 64;
        boolean z3 = (readUnsignedByte & 32) == 32;
        int i2 = (readUnsignedByte & 24) >> 3;
        boolean z4 = (readUnsignedByte & 4) == 4;
        boolean z5 = (readUnsignedByte & 2) == 2;
        if ((fromProtocolNameAndLevel == MqttVersion.MQTT_3_1_1 || fromProtocolNameAndLevel == MqttVersion.MQTT_5) && (readUnsignedByte & 1) != 0) {
            throw new DecoderException("non-zero reserved flag");
        }
        if (fromProtocolNameAndLevel == MqttVersion.MQTT_5) {
            Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
            i += decodeProperties.numberOfBytesConsumed;
            mqttProperties = (MqttProperties) decodeProperties.value;
        } else {
            mqttProperties = MqttProperties.NO_PROPERTIES;
        }
        return new Result<>(new MqttConnectVariableHeader(fromProtocolNameAndLevel.protocolName(), fromProtocolNameAndLevel.protocolLevel(), z, z2, z3, i2, z4, z5, decodeMsbLsb, mqttProperties), i);
    }

    private static MqttFixedHeader decodeFixedHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int i;
        short readUnsignedByte = byteBuf.readUnsignedByte();
        MqttMessageType valueOf = MqttMessageType.valueOf(readUnsignedByte >> 4);
        int i2 = 0;
        boolean z = (readUnsignedByte & 8) == 8;
        int i3 = (readUnsignedByte & 6) >> 1;
        boolean z2 = (readUnsignedByte & 1) != 0;
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[valueOf.ordinal()]) {
            case 1:
                if (i3 == 3) {
                    throw new DecoderException("Illegal QOS Level in fixed header of PUBLISH message (" + i3 + ')');
                }
                break;
            case 2:
            case 3:
            case 4:
                if (z) {
                    throw new DecoderException("Illegal BIT 3 in fixed header of " + valueOf + " message, must be 0, found 1");
                } else if (i3 != 1) {
                    throw new DecoderException("Illegal QOS Level in fixed header of " + valueOf + " message, must be 1, found " + i3);
                } else if (z2) {
                    throw new DecoderException("Illegal BIT 0 in fixed header of " + valueOf + " message, must be 0, found 1");
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                if (z) {
                    throw new DecoderException("Illegal BIT 3 in fixed header of " + valueOf + " message, must be 0, found 1");
                } else if (i3 != 0) {
                    throw new DecoderException("Illegal BIT 2 or 1 in fixed header of " + valueOf + " message, must be 0, found " + i3);
                } else if (z2) {
                    throw new DecoderException("Illegal BIT 0 in fixed header of " + valueOf + " message, must be 0, found 1");
                }
                break;
            default:
                throw new DecoderException("Unknown message type, do not know how to validate fixed header");
        }
        int i4 = 0;
        int i5 = 1;
        while (true) {
            short readUnsignedByte2 = byteBuf.readUnsignedByte();
            i = ((readUnsignedByte2 & 127) * i5) + i2;
            i5 *= 128;
            i4++;
            short s = readUnsignedByte2 & 128;
            if (s != 0 && i4 < 4) {
                i2 = i;
            } else if (i4 == 4 || s == 0) {
                return MqttCodecUtil.validateFixedHeader(channelHandlerContext, MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(valueOf, z, MqttQoS.valueOf(i3), z2, i)));
            } else {
                throw new DecoderException("remaining length exceeds 4 digits (" + valueOf + ')');
            }
        }
        if (i4 == 4) {
        }
        return MqttCodecUtil.validateFixedHeader(channelHandlerContext, MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(valueOf, z, MqttQoS.valueOf(i3), z2, i)));
    }

    private static int decodeMessageId(ByteBuf byteBuf) {
        int decodeMsbLsb = decodeMsbLsb(byteBuf);
        if (MqttCodecUtil.isValidMessageId(decodeMsbLsb)) {
            return decodeMsbLsb;
        }
        throw new DecoderException("invalid messageId: " + decodeMsbLsb);
    }

    private static Result<MqttMessageIdAndPropertiesVariableHeader> decodeMessageIdAndPropertiesVariableHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader;
        int i;
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        int decodeMessageId = decodeMessageId(byteBuf);
        if (mqttVersion == MqttVersion.MQTT_5) {
            Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
            mqttMessageIdAndPropertiesVariableHeader = new MqttMessageIdAndPropertiesVariableHeader(decodeMessageId, (MqttProperties) decodeProperties.value);
            i = decodeProperties.numberOfBytesConsumed;
        } else {
            mqttMessageIdAndPropertiesVariableHeader = new MqttMessageIdAndPropertiesVariableHeader(decodeMessageId, MqttProperties.NO_PROPERTIES);
            i = 0;
        }
        return new Result<>(mqttMessageIdAndPropertiesVariableHeader, i + 2);
    }

    private static int decodeMsbLsb(ByteBuf byteBuf) {
        short readUnsignedByte = byteBuf.readUnsignedByte() | (byteBuf.readUnsignedByte() << 8);
        if (readUnsignedByte < 0 || readUnsignedByte > 65535) {
            return -1;
        }
        return readUnsignedByte;
    }

    private static Result<?> decodePayload(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, MqttMessageType mqttMessageType, int i, int i2, Object obj) {
        int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessageType.ordinal()];
        return i3 != 1 ? i3 != 7 ? i3 != 3 ? i3 != 4 ? i3 != 14 ? i3 != 15 ? new Result<>(null, 0) : decodeUnsubAckPayload(channelHandlerContext, byteBuf, i) : decodeSubackPayload(byteBuf, i) : decodeUnsubscribePayload(byteBuf, i) : decodeSubscribePayload(byteBuf, i) : decodeConnectionPayload(byteBuf, i2, (MqttConnectVariableHeader) obj) : decodePublishPayload(byteBuf, i);
    }

    private static Result<MqttProperties> decodeProperties(ByteBuf byteBuf) {
        long decodeVariableByteInteger = decodeVariableByteInteger(byteBuf);
        int unpackA = unpackA(decodeVariableByteInteger);
        int unpackB = unpackB(decodeVariableByteInteger);
        MqttProperties mqttProperties = new MqttProperties();
        while (unpackB < unpackA) {
            long decodeVariableByteInteger2 = decodeVariableByteInteger(byteBuf);
            int unpackA2 = unpackA(decodeVariableByteInteger2);
            int unpackB2 = unpackB + unpackB(decodeVariableByteInteger2);
            MqttProperties.MqttPropertyType valueOf = MqttProperties.MqttPropertyType.valueOf(unpackA2);
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttProperties$MqttPropertyType[valueOf.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    unpackB = unpackB2 + 1;
                    mqttProperties.add(new MqttProperties.IntegerProperty(unpackA2, Integer.valueOf(byteBuf.readUnsignedByte())));
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                    unpackB = unpackB2 + 2;
                    mqttProperties.add(new MqttProperties.IntegerProperty(unpackA2, Integer.valueOf(decodeMsbLsb(byteBuf))));
                    break;
                case 13:
                case 14:
                case 15:
                case 16:
                    unpackB = unpackB2 + 4;
                    mqttProperties.add(new MqttProperties.IntegerProperty(unpackA2, Integer.valueOf(byteBuf.readInt())));
                    break;
                case 17:
                    long decodeVariableByteInteger3 = decodeVariableByteInteger(byteBuf);
                    unpackB = unpackB2 + unpackB(decodeVariableByteInteger3);
                    mqttProperties.add(new MqttProperties.IntegerProperty(unpackA2, Integer.valueOf(unpackA(decodeVariableByteInteger3))));
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    Result<String> decodeString = decodeString(byteBuf);
                    unpackB = unpackB2 + decodeString.numberOfBytesConsumed;
                    mqttProperties.add(new MqttProperties.StringProperty(unpackA2, (String) decodeString.value));
                    break;
                case 25:
                    Result<String> decodeString2 = decodeString(byteBuf);
                    Result<String> decodeString3 = decodeString(byteBuf);
                    unpackB = unpackB2 + decodeString2.numberOfBytesConsumed + decodeString3.numberOfBytesConsumed;
                    mqttProperties.add(new MqttProperties.UserProperty((String) decodeString2.value, (String) decodeString3.value));
                    break;
                case 26:
                case 27:
                    byte[] decodeByteArray = decodeByteArray(byteBuf);
                    unpackB = unpackB2 + decodeByteArray.length + 2;
                    mqttProperties.add(new MqttProperties.BinaryProperty(unpackA2, decodeByteArray));
                    break;
                default:
                    throw new DecoderException("Unknown property type: " + valueOf);
            }
        }
        return new Result<>(mqttProperties, unpackB);
    }

    private Result<MqttPubReplyMessageVariableHeader> decodePubReplyMessage(ByteBuf byteBuf) {
        MqttPubReplyMessageVariableHeader mqttPubReplyMessageVariableHeader;
        int decodeMessageId = decodeMessageId(byteBuf);
        int i = this.bytesRemainingInVariablePart;
        int i2 = 3;
        if (i > 3) {
            byte readByte = byteBuf.readByte();
            Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
            mqttPubReplyMessageVariableHeader = new MqttPubReplyMessageVariableHeader(decodeMessageId, readByte, (MqttProperties) decodeProperties.value);
            i2 = 3 + decodeProperties.numberOfBytesConsumed;
        } else if (i > 2) {
            mqttPubReplyMessageVariableHeader = new MqttPubReplyMessageVariableHeader(decodeMessageId, byteBuf.readByte(), MqttProperties.NO_PROPERTIES);
        } else {
            i2 = 2;
            mqttPubReplyMessageVariableHeader = new MqttPubReplyMessageVariableHeader(decodeMessageId, (byte) 0, MqttProperties.NO_PROPERTIES);
        }
        return new Result<>(mqttPubReplyMessageVariableHeader, i2);
    }

    private static Result<ByteBuf> decodePublishPayload(ByteBuf byteBuf, int i) {
        return new Result<>(byteBuf.readRetainedSlice(i), i);
    }

    private Result<MqttPublishVariableHeader> decodePublishVariableHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader2) {
        int i;
        MqttProperties mqttProperties;
        MqttVersion mqttVersion = MqttCodecUtil.getMqttVersion(channelHandlerContext);
        Result<String> decodeString = decodeString(byteBuf);
        if (MqttCodecUtil.isValidPublishTopicName((String) decodeString.value)) {
            int access$100 = decodeString.numberOfBytesConsumed;
            if (mqttFixedHeader2.qosLevel().value() > 0) {
                i = decodeMessageId(byteBuf);
                access$100 += 2;
            } else {
                i = -1;
            }
            if (mqttVersion == MqttVersion.MQTT_5) {
                Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
                mqttProperties = (MqttProperties) decodeProperties.value;
                access$100 += decodeProperties.numberOfBytesConsumed;
            } else {
                mqttProperties = MqttProperties.NO_PROPERTIES;
            }
            return new Result<>(new MqttPublishVariableHeader((String) decodeString.value, i, mqttProperties), access$100);
        }
        throw new DecoderException("invalid publish topic name: " + ((String) decodeString.value) + " (contains wildcards)");
    }

    private Result<MqttReasonCodeAndPropertiesVariableHeader> decodeReasonCodeAndPropertiesVariableHeader(ByteBuf byteBuf) {
        byte b;
        MqttProperties mqttProperties;
        int i = this.bytesRemainingInVariablePart;
        int i2 = 1;
        if (i > 1) {
            b = byteBuf.readByte();
            Result<MqttProperties> decodeProperties = decodeProperties(byteBuf);
            mqttProperties = (MqttProperties) decodeProperties.value;
            i2 = 1 + decodeProperties.numberOfBytesConsumed;
        } else if (i > 0) {
            b = byteBuf.readByte();
            mqttProperties = MqttProperties.NO_PROPERTIES;
        } else {
            mqttProperties = MqttProperties.NO_PROPERTIES;
            i2 = 0;
            b = 0;
        }
        return new Result<>(new MqttReasonCodeAndPropertiesVariableHeader(b, mqttProperties), i2);
    }

    private static Result<String> decodeString(ByteBuf byteBuf) {
        return decodeString(byteBuf, 0, Integer.MAX_VALUE);
    }

    private static Result<MqttSubAckPayload> decodeSubackPayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            i2++;
            arrayList.add(Integer.valueOf(byteBuf.readUnsignedByte()));
        }
        return new Result<>(new MqttSubAckPayload((Iterable<Integer>) arrayList), i2);
    }

    private static Result<MqttSubscribePayload> decodeSubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            int access$100 = i2 + decodeString.numberOfBytesConsumed;
            short readUnsignedByte = byteBuf.readUnsignedByte();
            i2 = access$100 + 1;
            arrayList.add(new MqttTopicSubscription((String) decodeString.value, new MqttSubscriptionOption(MqttQoS.valueOf((int) readUnsignedByte & 3), ((readUnsignedByte & 4) >> 2) == 1, ((readUnsignedByte & 8) >> 3) == 1, MqttSubscriptionOption.RetainedHandlingPolicy.valueOf((readUnsignedByte & 48) >> 4))));
        }
        return new Result<>(new MqttSubscribePayload(arrayList), i2);
    }

    private static Result<MqttUnsubAckPayload> decodeUnsubAckPayload(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            i2++;
            arrayList.add(Short.valueOf(byteBuf.readUnsignedByte()));
        }
        return new Result<>(new MqttUnsubAckPayload((Iterable<Short>) arrayList), i2);
    }

    private static Result<MqttUnsubscribePayload> decodeUnsubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            i2 += decodeString.numberOfBytesConsumed;
            arrayList.add(decodeString.value);
        }
        return new Result<>(new MqttUnsubscribePayload(arrayList), i2);
    }

    private static long decodeVariableByteInteger(ByteBuf byteBuf) {
        short s;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        do {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            i += (readUnsignedByte & 127) * i3;
            i3 *= 128;
            i2++;
            s = readUnsignedByte & 128;
            if (s == 0) {
                break;
            }
        } while (i2 < 4);
        if (i2 != 4 || s == 0) {
            return packInts(i, i2);
        }
        throw new DecoderException("MQTT protocol limits Remaining Length to 4 bytes");
    }

    private Result<?> decodeVariableHeader(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader2) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader2.messageType().ordinal()]) {
            case 1:
                return decodePublishVariableHeader(channelHandlerContext, byteBuf, mqttFixedHeader2);
            case 2:
            case 11:
            case 12:
            case 13:
                return decodePubReplyMessage(byteBuf);
            case 3:
            case 4:
            case 14:
            case 15:
                return decodeMessageIdAndPropertiesVariableHeader(channelHandlerContext, byteBuf);
            case 5:
            case 8:
                return decodeReasonCodeAndPropertiesVariableHeader(byteBuf);
            case 6:
                return decodeConnAckVariableHeader(channelHandlerContext, byteBuf);
            case 7:
                return decodeConnectionVariableHeader(channelHandlerContext, byteBuf);
            case 9:
            case 10:
                return new Result<>(null, 0);
            default:
                throw new DecoderException("Unknown message type: " + mqttFixedHeader2.messageType());
        }
    }

    private MqttMessage invalidMessage(Throwable th) {
        checkpoint(DecoderState.BAD_MESSAGE);
        return MqttMessageFactory.newInvalidMessage(this.mqttFixedHeader, this.variableHeader, th);
    }

    private static long packInts(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    private static int unpackA(long j) {
        return (int) (j >> 32);
    }

    private static int unpackB(long j) {
        return (int) j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090 A[Catch:{ Exception -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            r7 = this;
            int[] r0 = io.netty.handler.codec.mqtt.MqttDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState
            java.lang.Object r1 = r7.state()
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r1 = (io.netty.handler.codec.mqtt.MqttDecoder.DecoderState) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0028
            r1 = 2
            if (r0 == r1) goto L_0x0039
            r1 = 3
            if (r0 == r1) goto L_0x0057
            r8 = 4
            if (r0 != r8) goto L_0x0022
            int r7 = r7.actualReadableBytes()
            r9.skipBytes(r7)
            goto L_0x008d
        L_0x0022:
            java.lang.Error r7 = new java.lang.Error
            r7.<init>()
            throw r7
        L_0x0028:
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = decodeFixedHeader(r8, r9)     // Catch:{ Exception -> 0x00f3 }
            r7.mqttFixedHeader = r0     // Catch:{ Exception -> 0x00f3 }
            int r0 = r0.remainingLength()     // Catch:{ Exception -> 0x00f3 }
            r7.bytesRemainingInVariablePart = r0     // Catch:{ Exception -> 0x00f3 }
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r0 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_VARIABLE_HEADER     // Catch:{ Exception -> 0x00f3 }
            r7.checkpoint(r0)     // Catch:{ Exception -> 0x00f3 }
        L_0x0039:
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = r7.mqttFixedHeader     // Catch:{ Exception -> 0x00c4 }
            io.netty.handler.codec.mqtt.MqttDecoder$Result r0 = r7.decodeVariableHeader(r8, r9, r0)     // Catch:{ Exception -> 0x00c4 }
            java.lang.Object r1 = r0.value     // Catch:{ Exception -> 0x00c4 }
            r7.variableHeader = r1     // Catch:{ Exception -> 0x00c4 }
            int r1 = r7.bytesRemainingInVariablePart     // Catch:{ Exception -> 0x00c4 }
            int r2 = r7.maxBytesInMessage     // Catch:{ Exception -> 0x00c4 }
            if (r1 > r2) goto L_0x00c6
            int r0 = r0.numberOfBytesConsumed     // Catch:{ Exception -> 0x00c4 }
            int r1 = r1 - r0
            r7.bytesRemainingInVariablePart = r1     // Catch:{ Exception -> 0x00c4 }
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r0 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_PAYLOAD     // Catch:{ Exception -> 0x00c4 }
            r7.checkpoint(r0)     // Catch:{ Exception -> 0x00c4 }
        L_0x0057:
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = r7.mqttFixedHeader     // Catch:{ Exception -> 0x008e }
            io.netty.handler.codec.mqtt.MqttMessageType r3 = r0.messageType()     // Catch:{ Exception -> 0x008e }
            int r4 = r7.bytesRemainingInVariablePart     // Catch:{ Exception -> 0x008e }
            int r5 = r7.maxClientIdLength     // Catch:{ Exception -> 0x008e }
            java.lang.Object r6 = r7.variableHeader     // Catch:{ Exception -> 0x008e }
            r1 = r8
            r2 = r9
            io.netty.handler.codec.mqtt.MqttDecoder$Result r8 = decodePayload(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x008e }
            int r9 = r7.bytesRemainingInVariablePart     // Catch:{ Exception -> 0x008e }
            int r0 = r8.numberOfBytesConsumed     // Catch:{ Exception -> 0x008e }
            int r9 = r9 - r0
            r7.bytesRemainingInVariablePart = r9     // Catch:{ Exception -> 0x008e }
            if (r9 != 0) goto L_0x0090
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r9 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_FIXED_HEADER     // Catch:{ Exception -> 0x008e }
            r7.checkpoint(r9)     // Catch:{ Exception -> 0x008e }
            io.netty.handler.codec.mqtt.MqttFixedHeader r9 = r7.mqttFixedHeader     // Catch:{ Exception -> 0x008e }
            java.lang.Object r0 = r7.variableHeader     // Catch:{ Exception -> 0x008e }
            java.lang.Object r8 = r8.value     // Catch:{ Exception -> 0x008e }
            io.netty.handler.codec.mqtt.MqttMessage r8 = io.netty.handler.codec.mqtt.MqttMessageFactory.newMessage(r9, r0, r8)     // Catch:{ Exception -> 0x008e }
            r9 = 0
            r7.mqttFixedHeader = r9     // Catch:{ Exception -> 0x008e }
            r7.variableHeader = r9     // Catch:{ Exception -> 0x008e }
            r10.add(r8)     // Catch:{ Exception -> 0x008e }
        L_0x008d:
            return
        L_0x008e:
            r8 = move-exception
            goto L_0x00bc
        L_0x0090:
            io.netty.handler.codec.DecoderException r8 = new io.netty.handler.codec.DecoderException     // Catch:{ Exception -> 0x008e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e }
            r9.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = "non-zero remaining payload bytes: "
            r9.append(r0)     // Catch:{ Exception -> 0x008e }
            int r0 = r7.bytesRemainingInVariablePart     // Catch:{ Exception -> 0x008e }
            r9.append(r0)     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = " ("
            r9.append(r0)     // Catch:{ Exception -> 0x008e }
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = r7.mqttFixedHeader     // Catch:{ Exception -> 0x008e }
            io.netty.handler.codec.mqtt.MqttMessageType r0 = r0.messageType()     // Catch:{ Exception -> 0x008e }
            r9.append(r0)     // Catch:{ Exception -> 0x008e }
            r0 = 41
            r9.append(r0)     // Catch:{ Exception -> 0x008e }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x008e }
            r8.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x008e }
            throw r8     // Catch:{ Exception -> 0x008e }
        L_0x00bc:
            io.netty.handler.codec.mqtt.MqttMessage r7 = r7.invalidMessage(r8)
            r10.add(r7)
            return
        L_0x00c4:
            r8 = move-exception
            goto L_0x00eb
        L_0x00c6:
            int r8 = r7.actualReadableBytes()     // Catch:{ Exception -> 0x00c4 }
            r9.skipBytes(r8)     // Catch:{ Exception -> 0x00c4 }
            io.netty.handler.codec.TooLongFrameException r8 = new io.netty.handler.codec.TooLongFrameException     // Catch:{ Exception -> 0x00c4 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c4 }
            r9.<init>()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = "too large message: "
            r9.append(r0)     // Catch:{ Exception -> 0x00c4 }
            int r0 = r7.bytesRemainingInVariablePart     // Catch:{ Exception -> 0x00c4 }
            r9.append(r0)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = " bytes"
            r9.append(r0)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00c4 }
            r8.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x00c4 }
            throw r8     // Catch:{ Exception -> 0x00c4 }
        L_0x00eb:
            io.netty.handler.codec.mqtt.MqttMessage r7 = r7.invalidMessage(r8)
            r10.add(r7)
            return
        L_0x00f3:
            r8 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r7 = r7.invalidMessage(r8)
            r10.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public MqttDecoder(int i) {
        this(i, 23);
    }

    private static Result<String> decodeString(ByteBuf byteBuf, int i, int i2) {
        int decodeMsbLsb = decodeMsbLsb(byteBuf);
        if (decodeMsbLsb < i || decodeMsbLsb > i2) {
            byteBuf.skipBytes(decodeMsbLsb);
            return new Result<>(null, 2 + decodeMsbLsb);
        }
        String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), decodeMsbLsb, CharsetUtil.UTF_8);
        byteBuf.skipBytes(decodeMsbLsb);
        return new Result<>(byteBuf2, decodeMsbLsb + 2);
    }

    public MqttDecoder(int i, int i2) {
        super(DecoderState.READ_FIXED_HEADER);
        this.maxBytesInMessage = ObjectUtil.checkPositive(i, "maxBytesInMessage");
        this.maxClientIdLength = ObjectUtil.checkPositive(i2, "maxClientIdLength");
    }
}
