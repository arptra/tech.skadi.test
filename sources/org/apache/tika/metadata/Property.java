package org.apache.tika.metadata;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class Property implements Comparable<Property> {
    public static final Map h = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f7112a;
    public final boolean b;
    public final PropertyType c;
    public final ValueType d;
    public final Property e;
    public final Property[] f;
    public final Set g;

    public enum PropertyType {
        SIMPLE,
        STRUCTURE,
        BAG,
        SEQ,
        ALT,
        COMPOSITE
    }

    public enum ValueType {
        BOOLEAN,
        OPEN_CHOICE,
        CLOSED_CHOICE,
        DATE,
        INTEGER,
        LOCALE,
        MIME_TYPE,
        PROPER_NAME,
        RATIONAL,
        REAL,
        TEXT,
        URI,
        URL,
        XPATH,
        PROPERTY
    }

    public Property(String str, boolean z, PropertyType propertyType, ValueType valueType, String[] strArr, Property property, Property[] propertyArr) {
        this.f7112a = str;
        this.b = z;
        this.c = propertyType;
        this.d = valueType;
        if (strArr != null) {
            this.g = Collections.unmodifiableSet(new HashSet(Arrays.asList((String[]) strArr.clone())));
        } else {
            this.g = null;
        }
        if (property != null) {
            this.e = property;
            this.f = propertyArr;
            return;
        }
        this.e = this;
        this.f = null;
        Map map = h;
        synchronized (map) {
            map.put(str, this);
        }
    }

    public static Property A(String str) {
        return new Property(str, true, ValueType.TEXT);
    }

    public static Property B(String str) {
        return new Property(str, true, PropertyType.BAG, ValueType.TEXT);
    }

    public static Property C(String str) {
        return new Property(str, true, ValueType.URI);
    }

    public static Property b(Property property, Property[] propertyArr) {
        if (property == null) {
            throw new NullPointerException("primaryProperty must not be null");
        } else if (property.p() != PropertyType.COMPOSITE) {
            if (propertyArr != null) {
                int length = propertyArr.length;
                int i = 0;
                while (i < length) {
                    Property property2 = propertyArr[i];
                    if (property2.p() != PropertyType.COMPOSITE) {
                        i++;
                    } else {
                        throw new PropertyTypeException(property2.p());
                    }
                }
            }
            return new Property(property.getName(), property.D(), PropertyType.COMPOSITE, ValueType.PROPERTY, property.n() != null ? (String[]) property.n().toArray(new String[0]) : null, property, propertyArr);
        } else {
            throw new PropertyTypeException(property.p());
        }
    }

    public static Property d(String str) {
        return new Property(str, false, ValueType.BOOLEAN);
    }

    public static Property f(String str, String... strArr) {
        return new Property(str, false, ValueType.CLOSED_CHOICE, strArr);
    }

    public static Property g(String str) {
        return new Property(str, false, ValueType.DATE);
    }

    public static Property h(String str) {
        return new Property(str, false, ValueType.INTEGER);
    }

    public static Property i(String str) {
        return new Property(str, false, ValueType.REAL);
    }

    public static Property j(String str) {
        return new Property(str, false, PropertyType.SEQ, ValueType.REAL);
    }

    public static Property k(String str) {
        return new Property(str, false, ValueType.TEXT);
    }

    public static Property l(String str) {
        return new Property(str, false, PropertyType.BAG, ValueType.TEXT);
    }

    public static Property m(String str) {
        return (Property) h.get(str);
    }

    public static Property s(String str) {
        return new Property(str, true, ValueType.BOOLEAN);
    }

    public static Property t(String str, String... strArr) {
        return new Property(str, true, ValueType.CLOSED_CHOICE, strArr);
    }

    public static Property u(String str) {
        return new Property(str, true, ValueType.DATE);
    }

    public static Property v(String str) {
        return new Property(str, true, PropertyType.BAG, ValueType.DATE);
    }

    public static Property w(String str) {
        return new Property(str, true, ValueType.INTEGER);
    }

    public static Property x(String str, String... strArr) {
        return new Property(str, true, ValueType.OPEN_CHOICE, strArr);
    }

    public static Property y(String str) {
        return new Property(str, true, ValueType.RATIONAL);
    }

    public static Property z(String str) {
        return new Property(str, true, ValueType.REAL);
    }

    public boolean D() {
        return this.b;
    }

    public boolean E() {
        PropertyType propertyType = this.c;
        if (propertyType == PropertyType.BAG || propertyType == PropertyType.SEQ || propertyType == PropertyType.ALT) {
            return true;
        }
        if (propertyType == PropertyType.COMPOSITE) {
            return this.e.E();
        }
        return false;
    }

    /* renamed from: a */
    public int compareTo(Property property) {
        return this.f7112a.compareTo(property.f7112a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Property) && this.f7112a.equals(((Property) obj).f7112a);
    }

    public String getName() {
        return this.f7112a;
    }

    public int hashCode() {
        return this.f7112a.hashCode();
    }

    public Set n() {
        return this.g;
    }

    public Property o() {
        return this.e;
    }

    public PropertyType p() {
        return this.c;
    }

    public Property[] q() {
        return this.f;
    }

    public ValueType r() {
        return this.d;
    }

    public Property(String str, boolean z, PropertyType propertyType, ValueType valueType, String[] strArr) {
        this(str, z, propertyType, valueType, strArr, (Property) null, (Property[]) null);
    }

    public Property(String str, boolean z, ValueType valueType, String[] strArr) {
        this(str, z, PropertyType.SIMPLE, valueType, strArr);
    }

    public Property(String str, boolean z, ValueType valueType) {
        this(str, z, PropertyType.SIMPLE, valueType, (String[]) null);
    }

    public Property(String str, boolean z, PropertyType propertyType, ValueType valueType) {
        this(str, z, propertyType, valueType, (String[]) null);
    }
}
