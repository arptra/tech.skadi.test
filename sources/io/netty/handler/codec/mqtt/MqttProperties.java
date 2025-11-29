package io.netty.handler.codec.mqtt;

import io.netty.util.collection.IntObjectHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class MqttProperties {
    public static final MqttProperties NO_PROPERTIES = new MqttProperties(false);
    private final boolean canModify;
    private IntObjectHashMap<MqttProperty> props;
    private List<IntegerProperty> subscriptionIds;
    private List<UserProperty> userProperties;

    public static final class BinaryProperty extends MqttProperty<byte[]> {
        public BinaryProperty(int i, byte[] bArr) {
            super(i, bArr);
        }

        public String toString() {
            return "BinaryProperty(" + this.propertyId + ", " + ((byte[]) this.value).length + " bytes)";
        }
    }

    public static final class IntegerProperty extends MqttProperty<Integer> {
        public IntegerProperty(int i, Integer num) {
            super(i, num);
        }

        public String toString() {
            return "IntegerProperty(" + this.propertyId + ", " + this.value + ")";
        }
    }

    public static abstract class MqttProperty<T> {
        final int propertyId;
        final T value;

        public MqttProperty(int i, T t) {
            this.propertyId = i;
            this.value = t;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MqttProperty mqttProperty = (MqttProperty) obj;
            return this.propertyId == mqttProperty.propertyId && this.value.equals(mqttProperty.value);
        }

        public int hashCode() {
            return this.propertyId + (this.value.hashCode() * 31);
        }

        public int propertyId() {
            return this.propertyId;
        }

        public T value() {
            return this.value;
        }
    }

    public enum MqttPropertyType {
        PAYLOAD_FORMAT_INDICATOR(1),
        REQUEST_PROBLEM_INFORMATION(23),
        REQUEST_RESPONSE_INFORMATION(25),
        MAXIMUM_QOS(36),
        RETAIN_AVAILABLE(37),
        WILDCARD_SUBSCRIPTION_AVAILABLE(40),
        SUBSCRIPTION_IDENTIFIER_AVAILABLE(41),
        SHARED_SUBSCRIPTION_AVAILABLE(42),
        SERVER_KEEP_ALIVE(19),
        RECEIVE_MAXIMUM(33),
        TOPIC_ALIAS_MAXIMUM(34),
        TOPIC_ALIAS(35),
        PUBLICATION_EXPIRY_INTERVAL(2),
        SESSION_EXPIRY_INTERVAL(17),
        WILL_DELAY_INTERVAL(24),
        MAXIMUM_PACKET_SIZE(39),
        SUBSCRIPTION_IDENTIFIER(11),
        CONTENT_TYPE(3),
        RESPONSE_TOPIC(8),
        ASSIGNED_CLIENT_IDENTIFIER(18),
        AUTHENTICATION_METHOD(21),
        RESPONSE_INFORMATION(26),
        SERVER_REFERENCE(28),
        REASON_STRING(31),
        USER_PROPERTY(38),
        CORRELATION_DATA(9),
        AUTHENTICATION_DATA(22);
        
        private static final MqttPropertyType[] VALUES = null;
        /* access modifiers changed from: private */
        public final int value;

        static {
            VALUES = new MqttPropertyType[43];
            for (MqttPropertyType mqttPropertyType : values()) {
                VALUES[mqttPropertyType.value] = mqttPropertyType;
            }
        }

        private MqttPropertyType(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static MqttPropertyType valueOf(int i) {
            MqttPropertyType mqttPropertyType;
            try {
                mqttPropertyType = VALUES[i];
            } catch (ArrayIndexOutOfBoundsException unused) {
                mqttPropertyType = null;
            }
            if (mqttPropertyType != null) {
                return mqttPropertyType;
            }
            throw new IllegalArgumentException("unknown property type: " + i);
        }
    }

    public static final class StringPair {
        public final String key;
        public final String value;

        public StringPair(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || StringPair.class != obj.getClass()) {
                return false;
            }
            StringPair stringPair = (StringPair) obj;
            return stringPair.key.equals(this.key) && stringPair.value.equals(this.value);
        }

        public int hashCode() {
            return this.key.hashCode() + (this.value.hashCode() * 31);
        }
    }

    public static final class StringProperty extends MqttProperty<String> {
        public StringProperty(int i, String str) {
            super(i, str);
        }

        public String toString() {
            return "StringProperty(" + this.propertyId + ", " + ((String) this.value) + ")";
        }
    }

    public static final class UserProperties extends MqttProperty<List<StringPair>> {
        public UserProperties() {
            super(MqttPropertyType.USER_PROPERTY.value, new ArrayList());
        }

        /* access modifiers changed from: private */
        public static UserProperties fromUserPropertyCollection(Collection<UserProperty> collection) {
            UserProperties userProperties = new UserProperties();
            for (UserProperty userProperty : collection) {
                T t = userProperty.value;
                userProperties.add(new StringPair(((StringPair) t).key, ((StringPair) t).value));
            }
            return userProperties;
        }

        public void add(StringPair stringPair) {
            ((List) this.value).add(stringPair);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UserProperties(");
            boolean z = true;
            for (StringPair stringPair : (List) this.value) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(stringPair.key + "->" + stringPair.value);
                z = false;
            }
            sb.append(")");
            return sb.toString();
        }

        public UserProperties(Collection<StringPair> collection) {
            this();
            ((List) this.value).addAll(collection);
        }

        public void add(String str, String str2) {
            ((List) this.value).add(new StringPair(str, str2));
        }
    }

    public static final class UserProperty extends MqttProperty<StringPair> {
        public UserProperty(String str, String str2) {
            super(MqttPropertyType.USER_PROPERTY.value, new StringPair(str, str2));
        }

        public String toString() {
            return "UserProperty(" + ((StringPair) this.value).key + ", " + ((StringPair) this.value).value + ")";
        }
    }

    public MqttProperties() {
        this(true);
    }

    public static MqttProperties withEmptyDefaults(MqttProperties mqttProperties) {
        return mqttProperties == null ? NO_PROPERTIES : mqttProperties;
    }

    public void add(MqttProperty mqttProperty) {
        if (this.canModify) {
            IntObjectHashMap<MqttProperty> intObjectHashMap = this.props;
            if (mqttProperty.propertyId == MqttPropertyType.USER_PROPERTY.value) {
                List list = this.userProperties;
                if (list == null) {
                    list = new ArrayList(1);
                    this.userProperties = list;
                }
                if (mqttProperty instanceof UserProperty) {
                    list.add((UserProperty) mqttProperty);
                } else if (mqttProperty instanceof UserProperties) {
                    for (StringPair stringPair : (List) ((UserProperties) mqttProperty).value) {
                        list.add(new UserProperty(stringPair.key, stringPair.value));
                    }
                } else {
                    throw new IllegalArgumentException("User property must be of UserProperty or UserProperties type");
                }
            } else if (mqttProperty.propertyId == MqttPropertyType.SUBSCRIPTION_IDENTIFIER.value) {
                List list2 = this.subscriptionIds;
                if (list2 == null) {
                    list2 = new ArrayList(1);
                    this.subscriptionIds = list2;
                }
                if (mqttProperty instanceof IntegerProperty) {
                    list2.add((IntegerProperty) mqttProperty);
                    return;
                }
                throw new IllegalArgumentException("Subscription ID must be an integer property");
            } else {
                if (intObjectHashMap == null) {
                    intObjectHashMap = new IntObjectHashMap<>();
                    this.props = intObjectHashMap;
                }
                intObjectHashMap.put(mqttProperty.propertyId, mqttProperty);
            }
        } else {
            throw new UnsupportedOperationException("adding property isn't allowed");
        }
    }

    public List<? extends MqttProperty> getProperties(int i) {
        if (i == MqttPropertyType.USER_PROPERTY.value) {
            List<UserProperty> list = this.userProperties;
            return list == null ? Collections.emptyList() : list;
        } else if (i == MqttPropertyType.SUBSCRIPTION_IDENTIFIER.value) {
            List<IntegerProperty> list2 = this.subscriptionIds;
            return list2 == null ? Collections.emptyList() : list2;
        } else {
            IntObjectHashMap<MqttProperty> intObjectHashMap = this.props;
            return (intObjectHashMap == null || !intObjectHashMap.containsKey(i)) ? Collections.emptyList() : Collections.singletonList(intObjectHashMap.get(i));
        }
    }

    public MqttProperty getProperty(int i) {
        if (i == MqttPropertyType.USER_PROPERTY.value) {
            List<UserProperty> list = this.userProperties;
            if (list == null) {
                return null;
            }
            return UserProperties.fromUserPropertyCollection(list);
        } else if (i == MqttPropertyType.SUBSCRIPTION_IDENTIFIER.value) {
            List<IntegerProperty> list2 = this.subscriptionIds;
            if (list2 == null || list2.isEmpty()) {
                return null;
            }
            return list2.get(0);
        } else {
            IntObjectHashMap<MqttProperty> intObjectHashMap = this.props;
            if (intObjectHashMap == null) {
                return null;
            }
            return intObjectHashMap.get(i);
        }
    }

    public boolean isEmpty() {
        IntObjectHashMap<MqttProperty> intObjectHashMap = this.props;
        return intObjectHashMap == null || intObjectHashMap.isEmpty();
    }

    public Collection<? extends MqttProperty> listAll() {
        IntObjectHashMap<MqttProperty> intObjectHashMap = this.props;
        if (intObjectHashMap == null && this.subscriptionIds == null && this.userProperties == null) {
            return Collections.emptyList();
        }
        List<IntegerProperty> list = this.subscriptionIds;
        if (list == null && this.userProperties == null) {
            return intObjectHashMap.values();
        }
        if (intObjectHashMap == null && this.userProperties == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(intObjectHashMap != null ? intObjectHashMap.size() : 1);
        if (intObjectHashMap != null) {
            arrayList.addAll(intObjectHashMap.values());
        }
        List<IntegerProperty> list2 = this.subscriptionIds;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        List<UserProperty> list3 = this.userProperties;
        if (list3 != null) {
            arrayList.add(UserProperties.fromUserPropertyCollection(list3));
        }
        return arrayList;
    }

    private MqttProperties(boolean z) {
        this.canModify = z;
    }
}
