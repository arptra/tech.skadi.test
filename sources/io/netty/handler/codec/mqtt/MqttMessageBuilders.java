package io.netty.handler.codec.mqtt;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttProperties;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UShort;

public final class MqttMessageBuilders {

    public static final class AuthBuilder {
        private MqttProperties properties;
        private byte reasonCode;

        public MqttMessage build() {
            return new MqttMessage(new MqttFixedHeader(MqttMessageType.AUTH, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttReasonCodeAndPropertiesVariableHeader(this.reasonCode, this.properties));
        }

        public AuthBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public AuthBuilder reasonCode(byte b) {
            this.reasonCode = b;
            return this;
        }
    }

    public static final class ConnAckBuilder {
        private MqttProperties properties;
        private ConnAckPropertiesBuilder propsBuilder;
        private MqttConnectReturnCode returnCode;
        private boolean sessionPresent;

        public MqttConnAckMessage build() {
            ConnAckPropertiesBuilder connAckPropertiesBuilder = this.propsBuilder;
            if (connAckPropertiesBuilder != null) {
                this.properties = connAckPropertiesBuilder.build();
            }
            return new MqttConnAckMessage(new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnAckVariableHeader(this.returnCode, this.sessionPresent, this.properties));
        }

        public ConnAckBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public ConnAckBuilder returnCode(MqttConnectReturnCode mqttConnectReturnCode) {
            this.returnCode = mqttConnectReturnCode;
            return this;
        }

        public ConnAckBuilder sessionPresent(boolean z) {
            this.sessionPresent = z;
            return this;
        }

        private ConnAckBuilder() {
            this.properties = MqttProperties.NO_PROPERTIES;
        }

        public ConnAckBuilder properties(PropertiesInitializer<ConnAckPropertiesBuilder> propertiesInitializer) {
            if (this.propsBuilder == null) {
                this.propsBuilder = new ConnAckPropertiesBuilder();
            }
            propertiesInitializer.apply(this.propsBuilder);
            return this;
        }
    }

    public static final class ConnAckPropertiesBuilder {
        private byte[] authenticationData;
        private String authenticationMethod;
        private String clientId;
        private Long maximumPacketSize;
        private Byte maximumQos;
        private String reasonString;
        private int receiveMaximum;
        private String responseInformation;
        private boolean retain;
        private Integer serverKeepAlive;
        private String serverReference;
        private Long sessionExpiryInterval;
        private Boolean sharedSubscriptionAvailable;
        private Boolean subscriptionIdentifiersAvailable;
        private int topicAliasMaximum;
        private final MqttProperties.UserProperties userProperties = new MqttProperties.UserProperties();
        private Boolean wildcardSubscriptionAvailable;

        public ConnAckPropertiesBuilder assignedClientId(String str) {
            this.clientId = str;
            return this;
        }

        public ConnAckPropertiesBuilder authenticationData(byte[] bArr) {
            this.authenticationData = (byte[]) bArr.clone();
            return this;
        }

        public ConnAckPropertiesBuilder authenticationMethod(String str) {
            this.authenticationMethod = str;
            return this;
        }

        public MqttProperties build() {
            MqttProperties mqttProperties = new MqttProperties();
            if (this.clientId != null) {
                mqttProperties.add(new MqttProperties.StringProperty(MqttProperties.MqttPropertyType.ASSIGNED_CLIENT_IDENTIFIER.value(), this.clientId));
            }
            if (this.sessionExpiryInterval != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.SESSION_EXPIRY_INTERVAL.value(), Integer.valueOf(this.sessionExpiryInterval.intValue())));
            }
            if (this.receiveMaximum > 0) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.RECEIVE_MAXIMUM.value(), Integer.valueOf(this.receiveMaximum)));
            }
            if (this.maximumQos != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.MAXIMUM_QOS.value(), Integer.valueOf(this.receiveMaximum)));
            }
            mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.RETAIN_AVAILABLE.value(), Integer.valueOf(this.retain ? 1 : 0)));
            if (this.maximumPacketSize != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.MAXIMUM_PACKET_SIZE.value(), Integer.valueOf(this.maximumPacketSize.intValue())));
            }
            mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.TOPIC_ALIAS_MAXIMUM.value(), Integer.valueOf(this.topicAliasMaximum)));
            if (this.reasonString != null) {
                mqttProperties.add(new MqttProperties.StringProperty(MqttProperties.MqttPropertyType.REASON_STRING.value(), this.reasonString));
            }
            mqttProperties.add(this.userProperties);
            if (this.wildcardSubscriptionAvailable != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.WILDCARD_SUBSCRIPTION_AVAILABLE.value(), Integer.valueOf(this.wildcardSubscriptionAvailable.booleanValue() ? 1 : 0)));
            }
            if (this.subscriptionIdentifiersAvailable != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.SUBSCRIPTION_IDENTIFIER_AVAILABLE.value(), Integer.valueOf(this.subscriptionIdentifiersAvailable.booleanValue() ? 1 : 0)));
            }
            if (this.sharedSubscriptionAvailable != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.SHARED_SUBSCRIPTION_AVAILABLE.value(), Integer.valueOf(this.sharedSubscriptionAvailable.booleanValue() ? 1 : 0)));
            }
            if (this.serverKeepAlive != null) {
                mqttProperties.add(new MqttProperties.IntegerProperty(MqttProperties.MqttPropertyType.SERVER_KEEP_ALIVE.value(), this.serverKeepAlive));
            }
            if (this.responseInformation != null) {
                mqttProperties.add(new MqttProperties.StringProperty(MqttProperties.MqttPropertyType.RESPONSE_INFORMATION.value(), this.responseInformation));
            }
            if (this.serverReference != null) {
                mqttProperties.add(new MqttProperties.StringProperty(MqttProperties.MqttPropertyType.SERVER_REFERENCE.value(), this.serverReference));
            }
            if (this.authenticationMethod != null) {
                mqttProperties.add(new MqttProperties.StringProperty(MqttProperties.MqttPropertyType.AUTHENTICATION_METHOD.value(), this.authenticationMethod));
            }
            if (this.authenticationData != null) {
                mqttProperties.add(new MqttProperties.BinaryProperty(MqttProperties.MqttPropertyType.AUTHENTICATION_DATA.value(), this.authenticationData));
            }
            return mqttProperties;
        }

        public ConnAckPropertiesBuilder maximumPacketSize(long j) {
            this.maximumPacketSize = Long.valueOf(ObjectUtil.checkPositive(j, "size"));
            return this;
        }

        public ConnAckPropertiesBuilder maximumQos(byte b) {
            if (b == 0 || b == 1) {
                this.maximumQos = Byte.valueOf(b);
                return this;
            }
            throw new IllegalArgumentException("maximum QoS property could be 0 or 1");
        }

        public ConnAckPropertiesBuilder reasonString(String str) {
            this.reasonString = str;
            return this;
        }

        public ConnAckPropertiesBuilder receiveMaximum(int i) {
            this.receiveMaximum = ObjectUtil.checkPositive(i, AccountConstantKt.RESPONSE_VALUE);
            return this;
        }

        public ConnAckPropertiesBuilder responseInformation(String str) {
            this.responseInformation = str;
            return this;
        }

        public ConnAckPropertiesBuilder retainAvailable(boolean z) {
            this.retain = z;
            return this;
        }

        public ConnAckPropertiesBuilder serverKeepAlive(int i) {
            this.serverKeepAlive = Integer.valueOf(i);
            return this;
        }

        public ConnAckPropertiesBuilder serverReference(String str) {
            this.serverReference = str;
            return this;
        }

        public ConnAckPropertiesBuilder sessionExpiryInterval(long j) {
            this.sessionExpiryInterval = Long.valueOf(j);
            return this;
        }

        public ConnAckPropertiesBuilder sharedSubscriptionAvailable(boolean z) {
            this.sharedSubscriptionAvailable = Boolean.valueOf(z);
            return this;
        }

        public ConnAckPropertiesBuilder subscriptionIdentifiersAvailable(boolean z) {
            this.subscriptionIdentifiersAvailable = Boolean.valueOf(z);
            return this;
        }

        public ConnAckPropertiesBuilder topicAliasMaximum(int i) {
            this.topicAliasMaximum = i;
            return this;
        }

        public ConnAckPropertiesBuilder userProperty(String str, String str2) {
            this.userProperties.add(str, str2);
            return this;
        }

        public ConnAckPropertiesBuilder wildcardSubscriptionAvailable(boolean z) {
            this.wildcardSubscriptionAvailable = Boolean.valueOf(z);
            return this;
        }
    }

    public static final class ConnectBuilder {
        private boolean cleanSession;
        private String clientId;
        private boolean hasPassword;
        private boolean hasUser;
        private int keepAliveSecs;
        private byte[] password;
        private MqttProperties properties;
        private String username;
        private MqttVersion version = MqttVersion.MQTT_3_1_1;
        private boolean willFlag;
        private byte[] willMessage;
        private MqttProperties willProperties;
        private MqttQoS willQos;
        private boolean willRetain;
        private String willTopic;

        public ConnectBuilder() {
            MqttProperties mqttProperties = MqttProperties.NO_PROPERTIES;
            this.willProperties = mqttProperties;
            this.willQos = MqttQoS.AT_MOST_ONCE;
            this.properties = mqttProperties;
        }

        public MqttConnectMessage build() {
            return new MqttConnectMessage(new MqttFixedHeader(MqttMessageType.CONNECT, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnectVariableHeader(this.version.protocolName(), this.version.protocolLevel(), this.hasUser, this.hasPassword, this.willRetain, this.willQos.value(), this.willFlag, this.cleanSession, this.keepAliveSecs, this.properties), new MqttConnectPayload(this.clientId, this.willProperties, this.willTopic, this.willMessage, this.username, this.password));
        }

        public ConnectBuilder cleanSession(boolean z) {
            this.cleanSession = z;
            return this;
        }

        public ConnectBuilder clientId(String str) {
            this.clientId = str;
            return this;
        }

        public ConnectBuilder hasPassword(boolean z) {
            this.hasPassword = z;
            return this;
        }

        public ConnectBuilder hasUser(boolean z) {
            this.hasUser = z;
            return this;
        }

        public ConnectBuilder keepAlive(int i) {
            this.keepAliveSecs = i;
            return this;
        }

        @Deprecated
        public ConnectBuilder password(String str) {
            password(str == null ? null : str.getBytes(CharsetUtil.UTF_8));
            return this;
        }

        public ConnectBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public ConnectBuilder protocolVersion(MqttVersion mqttVersion) {
            this.version = mqttVersion;
            return this;
        }

        public ConnectBuilder username(String str) {
            this.hasUser = str != null;
            this.username = str;
            return this;
        }

        public ConnectBuilder willFlag(boolean z) {
            this.willFlag = z;
            return this;
        }

        @Deprecated
        public ConnectBuilder willMessage(String str) {
            willMessage(str == null ? null : str.getBytes(CharsetUtil.UTF_8));
            return this;
        }

        public ConnectBuilder willProperties(MqttProperties mqttProperties) {
            this.willProperties = mqttProperties;
            return this;
        }

        public ConnectBuilder willQoS(MqttQoS mqttQoS) {
            this.willQos = mqttQoS;
            return this;
        }

        public ConnectBuilder willRetain(boolean z) {
            this.willRetain = z;
            return this;
        }

        public ConnectBuilder willTopic(String str) {
            this.willTopic = str;
            return this;
        }

        public ConnectBuilder password(byte[] bArr) {
            this.hasPassword = bArr != null;
            this.password = bArr;
            return this;
        }

        public ConnectBuilder willMessage(byte[] bArr) {
            this.willMessage = bArr;
            return this;
        }
    }

    public static final class DisconnectBuilder {
        private MqttProperties properties;
        private byte reasonCode;

        public MqttMessage build() {
            return new MqttMessage(new MqttFixedHeader(MqttMessageType.DISCONNECT, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttReasonCodeAndPropertiesVariableHeader(this.reasonCode, this.properties));
        }

        public DisconnectBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public DisconnectBuilder reasonCode(byte b) {
            this.reasonCode = b;
            return this;
        }
    }

    public interface PropertiesInitializer<T> {
        void apply(T t);
    }

    public static final class PubAckBuilder {
        private int packetId;
        private MqttProperties properties;
        private byte reasonCode;

        public MqttMessage build() {
            return new MqttMessage(new MqttFixedHeader(MqttMessageType.PUBACK, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttPubReplyMessageVariableHeader(this.packetId, this.reasonCode, this.properties));
        }

        public PubAckBuilder packetId(int i) {
            this.packetId = i;
            return this;
        }

        public PubAckBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public PubAckBuilder reasonCode(byte b) {
            this.reasonCode = b;
            return this;
        }

        @Deprecated
        public PubAckBuilder packetId(short s) {
            return packetId((int) s & UShort.MAX_VALUE);
        }
    }

    public static final class PublishBuilder {
        private int messageId;
        private MqttProperties mqttProperties;
        private ByteBuf payload;
        private MqttQoS qos;
        private boolean retained;
        private String topic;

        public MqttPublishMessage build() {
            return new MqttPublishMessage(new MqttFixedHeader(MqttMessageType.PUBLISH, false, this.qos, this.retained, 0), new MqttPublishVariableHeader(this.topic, this.messageId, this.mqttProperties), Unpooled.buffer().writeBytes(this.payload));
        }

        public PublishBuilder messageId(int i) {
            this.messageId = i;
            return this;
        }

        public PublishBuilder payload(ByteBuf byteBuf) {
            this.payload = byteBuf;
            return this;
        }

        public PublishBuilder properties(MqttProperties mqttProperties2) {
            this.mqttProperties = mqttProperties2;
            return this;
        }

        public PublishBuilder qos(MqttQoS mqttQoS) {
            this.qos = mqttQoS;
            return this;
        }

        public PublishBuilder retained(boolean z) {
            this.retained = z;
            return this;
        }

        public PublishBuilder topicName(String str) {
            this.topic = str;
            return this;
        }
    }

    public static final class SubAckBuilder {
        private final List<MqttQoS> grantedQoses = new ArrayList();
        private int packetId;
        private MqttProperties properties;

        public SubAckBuilder addGrantedQos(MqttQoS mqttQoS) {
            this.grantedQoses.add(mqttQoS);
            return this;
        }

        public SubAckBuilder addGrantedQoses(MqttQoS... mqttQoSArr) {
            this.grantedQoses.addAll(Arrays.asList(mqttQoSArr));
            return this;
        }

        public MqttSubAckMessage build() {
            MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.SUBACK, false, MqttQoS.AT_MOST_ONCE, false, 0);
            MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader = new MqttMessageIdAndPropertiesVariableHeader(this.packetId, this.properties);
            int[] iArr = new int[this.grantedQoses.size()];
            int i = 0;
            for (MqttQoS value : this.grantedQoses) {
                iArr[i] = value.value();
                i++;
            }
            return new MqttSubAckMessage(mqttFixedHeader, mqttMessageIdAndPropertiesVariableHeader, new MqttSubAckPayload(iArr));
        }

        public SubAckBuilder packetId(int i) {
            this.packetId = i;
            return this;
        }

        public SubAckBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        @Deprecated
        public SubAckBuilder packetId(short s) {
            return packetId((int) s & UShort.MAX_VALUE);
        }
    }

    public static final class UnsubAckBuilder {
        private int packetId;
        private MqttProperties properties;
        private final List<Short> reasonCodes = new ArrayList();

        public UnsubAckBuilder addReasonCode(short s) {
            this.reasonCodes.add(Short.valueOf(s));
            return this;
        }

        public UnsubAckBuilder addReasonCodes(Short... shArr) {
            this.reasonCodes.addAll(Arrays.asList(shArr));
            return this;
        }

        public MqttUnsubAckMessage build() {
            return new MqttUnsubAckMessage(new MqttFixedHeader(MqttMessageType.UNSUBACK, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttMessageIdAndPropertiesVariableHeader(this.packetId, this.properties), new MqttUnsubAckPayload((Iterable<Short>) this.reasonCodes));
        }

        public UnsubAckBuilder packetId(int i) {
            this.packetId = i;
            return this;
        }

        public UnsubAckBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        @Deprecated
        public UnsubAckBuilder packetId(short s) {
            return packetId((int) s & UShort.MAX_VALUE);
        }
    }

    public static final class UnsubscribeBuilder {
        private int messageId;
        private MqttProperties properties;
        private List<String> topicFilters;

        public UnsubscribeBuilder addTopicFilter(String str) {
            if (this.topicFilters == null) {
                this.topicFilters = new ArrayList(5);
            }
            this.topicFilters.add(str);
            return this;
        }

        public MqttUnsubscribeMessage build() {
            return new MqttUnsubscribeMessage(new MqttFixedHeader(MqttMessageType.UNSUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), new MqttMessageIdAndPropertiesVariableHeader(this.messageId, this.properties), new MqttUnsubscribePayload(this.topicFilters));
        }

        public UnsubscribeBuilder messageId(int i) {
            this.messageId = i;
            return this;
        }

        public UnsubscribeBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }
    }

    private MqttMessageBuilders() {
    }

    public static AuthBuilder auth() {
        return new AuthBuilder();
    }

    public static ConnAckBuilder connAck() {
        return new ConnAckBuilder();
    }

    public static ConnectBuilder connect() {
        return new ConnectBuilder();
    }

    public static DisconnectBuilder disconnect() {
        return new DisconnectBuilder();
    }

    public static PubAckBuilder pubAck() {
        return new PubAckBuilder();
    }

    public static PublishBuilder publish() {
        return new PublishBuilder();
    }

    public static SubAckBuilder subAck() {
        return new SubAckBuilder();
    }

    public static SubscribeBuilder subscribe() {
        return new SubscribeBuilder();
    }

    public static UnsubAckBuilder unsubAck() {
        return new UnsubAckBuilder();
    }

    public static UnsubscribeBuilder unsubscribe() {
        return new UnsubscribeBuilder();
    }

    public static final class SubscribeBuilder {
        private int messageId;
        private MqttProperties properties;
        private List<MqttTopicSubscription> subscriptions;

        private void ensureSubscriptionsExist() {
            if (this.subscriptions == null) {
                this.subscriptions = new ArrayList(5);
            }
        }

        public SubscribeBuilder addSubscription(MqttQoS mqttQoS, String str) {
            ensureSubscriptionsExist();
            this.subscriptions.add(new MqttTopicSubscription(str, mqttQoS));
            return this;
        }

        public MqttSubscribeMessage build() {
            return new MqttSubscribeMessage(new MqttFixedHeader(MqttMessageType.SUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), new MqttMessageIdAndPropertiesVariableHeader(this.messageId, this.properties), new MqttSubscribePayload(this.subscriptions));
        }

        public SubscribeBuilder messageId(int i) {
            this.messageId = i;
            return this;
        }

        public SubscribeBuilder properties(MqttProperties mqttProperties) {
            this.properties = mqttProperties;
            return this;
        }

        public SubscribeBuilder addSubscription(String str, MqttSubscriptionOption mqttSubscriptionOption) {
            ensureSubscriptionsExist();
            this.subscriptions.add(new MqttTopicSubscription(str, mqttSubscriptionOption));
            return this;
        }
    }
}
