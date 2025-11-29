package org.apache.tika.metadata;

import org.apache.tika.metadata.Property;

public final class PropertyTypeException extends IllegalArgumentException {
    public PropertyTypeException(String str) {
        super(str);
    }

    public PropertyTypeException(Property.PropertyType propertyType, Property.PropertyType propertyType2) {
        super("Expected a property of type " + propertyType + ", but received " + propertyType2);
    }

    public PropertyTypeException(Property.ValueType valueType, Property.ValueType valueType2) {
        super("Expected a property with a " + valueType + " value, but received a " + valueType2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PropertyTypeException(org.apache.tika.metadata.Property.PropertyType r2) {
        /*
            r1 = this;
            org.apache.tika.metadata.Property$PropertyType r0 = org.apache.tika.metadata.Property.PropertyType.COMPOSITE
            if (r2 == r0) goto L_0x0016
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = " is not supported"
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            goto L_0x0018
        L_0x0016:
            java.lang.String r2 = "Composite Properties must not include other Composite Properties as either Primary or Secondary"
        L_0x0018:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.metadata.PropertyTypeException.<init>(org.apache.tika.metadata.Property$PropertyType):void");
    }
}
