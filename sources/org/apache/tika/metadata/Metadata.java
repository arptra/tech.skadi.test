package org.apache.tika.metadata;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TimeZone;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.writefilter.MetadataWriteFilter;
import org.apache.tika.utils.DateUtils;

public class Metadata implements CreativeCommons, Geographic, HttpHeaders, Message, ClimateForcast, TIFF, TikaMimeKeys, Serializable {
    private static final MetadataWriteFilter ACCEPT_ALL = new MetadataWriteFilter() {
        private String[] appendValues(String[] strArr, String str) {
            if (str == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[(length + 1)];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length] = str;
            return strArr2;
        }

        public void add(String str, String str2, Map<String, String[]> map) {
            String[] strArr = map.get(str);
            if (strArr == null) {
                set(str, str2, map);
            } else {
                map.put(str, appendValues(strArr, str2));
            }
        }

        public void filterExisting(Map<String, String[]> map) {
        }

        public void set(String str, String str2, Map<String, String[]> map) {
            if (str2 != null) {
                map.put(str, new String[]{str2});
            } else {
                map.remove(str);
            }
        }
    };
    private static final DateUtils DATE_UTILS = new DateUtils();
    private static final long serialVersionUID = 5623926545693153182L;
    private Map<String, String[]> metadata;
    private MetadataWriteFilter writeFilter;

    public Metadata() {
        this.metadata = null;
        this.writeFilter = ACCEPT_ALL;
        this.metadata = new HashMap();
    }

    private String[] _getValues(String str) {
        String[] strArr = this.metadata.get(str);
        return strArr == null ? new String[0] : strArr;
    }

    private static DateFormat createDateFormat(String str, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, new DateFormatSymbols(Locale.US));
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    private int getMetadataEntryHashCode(Map.Entry<String, String[]> entry) {
        return Objects.hashCode(entry.getKey()) ^ Arrays.hashCode((Object[]) entry.getValue());
    }

    private static synchronized Date parseDate(String str) {
        Date f;
        synchronized (Metadata.class) {
            f = DATE_UTILS.f(str);
        }
        return f;
    }

    public void add(String str, String str2) {
        this.writeFilter.add(str, str2, this.metadata);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Metadata metadata2 = (Metadata) obj;
            if (metadata2.size() != size()) {
                return false;
            }
            for (String str : names()) {
                String[] _getValues = metadata2._getValues(str);
                String[] _getValues2 = _getValues(str);
                if (_getValues.length != _getValues2.length) {
                    return false;
                }
                for (int i = 0; i < _getValues.length; i++) {
                    if (!_getValues[i].equals(_getValues2[i])) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public String get(String str) {
        String[] strArr = this.metadata.get(str);
        if (strArr == null) {
            return null;
        }
        return strArr[0];
    }

    public Date getDate(Property property) {
        String str;
        if (property.o().p() == Property.PropertyType.SIMPLE && property.o().r() == Property.ValueType.DATE && (str = get(property)) != null) {
            return parseDate(str);
        }
        return null;
    }

    public Integer getInt(Property property) {
        String str;
        if (property.o().p() != Property.PropertyType.SIMPLE || property.o().r() != Property.ValueType.INTEGER || (str = get(property)) == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public int[] getIntValues(Property property) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SEQ;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.INTEGER;
            if (r == valueType) {
                String[] values = getValues(property);
                int[] iArr = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    iArr[i] = Integer.parseInt(values[i]);
                }
                return iArr;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public long[] getLongValues(Property property) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SEQ;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.REAL;
            if (r == valueType) {
                String[] values = getValues(property);
                long[] jArr = new long[values.length];
                for (int i = 0; i < values.length; i++) {
                    jArr[i] = Long.parseLong(values[i]);
                }
                return jArr;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public String[] getValues(Property property) {
        return _getValues(property.getName());
    }

    public int hashCode() {
        int i = 0;
        for (Map.Entry<String, String[]> metadataEntryHashCode : this.metadata.entrySet()) {
            i += getMetadataEntryHashCode(metadataEntryHashCode);
        }
        return i;
    }

    public boolean isMultiValued(Property property) {
        return this.metadata.get(property.getName()) != null && this.metadata.get(property.getName()).length > 1;
    }

    public String[] names() {
        return (String[]) this.metadata.keySet().toArray(new String[0]);
    }

    public void remove(String str) {
        this.metadata.remove(str);
    }

    public void set(String str, String str2) {
        this.writeFilter.set(str, str2, this.metadata);
    }

    public void setAll(Properties properties) {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            this.metadata.put(str, new String[]{properties.getProperty(str)});
        }
    }

    public void setMetadataWriteFilter(MetadataWriteFilter metadataWriteFilter) {
        this.writeFilter = metadataWriteFilter;
        metadataWriteFilter.filterExisting(this.metadata);
    }

    public int size() {
        return this.metadata.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : names()) {
            for (String str2 : _getValues(str)) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    public void add(String str, String[] strArr) {
        if (this.metadata.get(str) == null) {
            set(str, strArr);
            return;
        }
        for (String add : strArr) {
            add(str, add);
        }
    }

    public String[] getValues(String str) {
        return _getValues(str);
    }

    public void set(String str, String[] strArr) {
        if (strArr != null) {
            this.metadata.remove(str);
            for (String add : strArr) {
                add(str, add);
            }
            return;
        }
        this.metadata.remove(str);
    }

    public String get(Property property) {
        return get(property.getName());
    }

    public boolean isMultiValued(String str) {
        return this.metadata.get(str) != null && this.metadata.get(str).length > 1;
    }

    public void add(Property property, String str) {
        if (property == null) {
            throw new NullPointerException("property must not be null");
        } else if (property.p() == Property.PropertyType.COMPOSITE) {
            add(property.o(), str);
            if (property.q() != null) {
                for (Property add : property.q()) {
                    add(add, str);
                }
            }
        } else if (this.metadata.get(property.getName()) == null) {
            set(property, str);
        } else if (property.E()) {
            add(property.getName(), str);
        } else {
            throw new PropertyTypeException(property.getName() + " : " + property.p());
        }
    }

    public void set(Property property, String str) {
        if (property == null) {
            throw new NullPointerException("property must not be null");
        } else if (property.p() == Property.PropertyType.COMPOSITE) {
            set(property.o(), str);
            if (property.q() != null) {
                for (Property property2 : property.q()) {
                    set(property2, str);
                }
            }
        } else {
            set(property.getName(), str);
        }
    }

    public void set(Property property, String[] strArr) {
        if (property == null) {
            throw new NullPointerException("property must not be null");
        } else if (property.p() == Property.PropertyType.COMPOSITE) {
            set(property.o(), strArr);
            if (property.q() != null) {
                for (Property property2 : property.q()) {
                    set(property2, strArr);
                }
            }
        } else {
            set(property.getName(), strArr);
        }
    }

    public void add(Property property, int i) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SEQ;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.INTEGER;
            if (r == valueType) {
                add(property, Integer.toString(i));
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public void set(Property property, int i) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SIMPLE;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.INTEGER;
            if (r == valueType) {
                set(property, Integer.toString(i));
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public void add(Property property, Calendar calendar) {
        Property.ValueType r = property.o().r();
        Property.ValueType valueType = Property.ValueType.DATE;
        if (r == valueType) {
            add(property, calendar != null ? DateUtils.c(calendar) : null);
            return;
        }
        throw new PropertyTypeException(valueType, property.o().r());
    }

    public void set(Property property, long j) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SIMPLE;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.REAL;
            if (r == valueType) {
                set(property, Long.toString(j));
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public void set(Property property, boolean z) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SIMPLE;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.BOOLEAN;
            if (r == valueType) {
                set(property, Boolean.toString(z));
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public void set(Property property, double d) {
        Property.ValueType r = property.o().r();
        Property.ValueType valueType = Property.ValueType.REAL;
        if (r == valueType || property.o().r() == Property.ValueType.RATIONAL) {
            set(property, Double.toString(d));
            return;
        }
        throw new PropertyTypeException(valueType, property.o().r());
    }

    public void set(Property property, Date date) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SIMPLE;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.DATE;
            if (r == valueType) {
                set(property, date != null ? DateUtils.d(date) : null);
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }

    public void set(Property property, Calendar calendar) {
        Property.PropertyType p = property.o().p();
        Property.PropertyType propertyType = Property.PropertyType.SIMPLE;
        if (p == propertyType) {
            Property.ValueType r = property.o().r();
            Property.ValueType valueType = Property.ValueType.DATE;
            if (r == valueType) {
                set(property, calendar != null ? DateUtils.c(calendar) : null);
                return;
            }
            throw new PropertyTypeException(valueType, property.o().r());
        }
        throw new PropertyTypeException(propertyType, property.o().p());
    }
}
