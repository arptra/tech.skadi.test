package com.alibaba.fastjson.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

public class JSONSerializer extends SerializeFilterable {
    protected final SerializeConfig config;
    protected SerialContext context;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private String indent;
    private int indentCount;
    protected Locale locale;
    public final SerializeWriter out;
    protected IdentityHashMap<Object, SerialContext> references;
    protected TimeZone timeZone;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    public static void write(Writer writer, Object obj) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write(obj);
            serializeWriter.writeTo(writer);
            serializeWriter.close();
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r2 = r2.contextValueFilters;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.contextValueFilters;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r2.valueFilters;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkValue(com.alibaba.fastjson.serializer.SerializeFilterable r2) {
        /*
            r1 = this;
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> r0 = r1.valueFilters
            if (r0 == 0) goto L_0x000a
            int r0 = r0.size()
            if (r0 > 0) goto L_0x002e
        L_0x000a:
            java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> r0 = r1.contextValueFilters
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            if (r0 > 0) goto L_0x002e
        L_0x0014:
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> r0 = r2.valueFilters
            if (r0 == 0) goto L_0x001e
            int r0 = r0.size()
            if (r0 > 0) goto L_0x002e
        L_0x001e:
            java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> r2 = r2.contextValueFilters
            if (r2 == 0) goto L_0x0028
            int r2 = r2.size()
            if (r2 > 0) goto L_0x002e
        L_0x0028:
            com.alibaba.fastjson.serializer.SerializeWriter r1 = r1.out
            boolean r1 = r1.writeNonStringValueAsString
            if (r1 == 0) goto L_0x0030
        L_0x002e:
            r1 = 1
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.checkValue(com.alibaba.fastjson.serializer.SerializeFilterable):boolean");
    }

    public void close() {
        this.out.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public boolean containsReference(Object obj) {
        SerialContext serialContext;
        IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
        if (identityHashMap == null || (serialContext = identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = serialContext.fieldName;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.timeZone);
        }
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat dateFormat2 = this.dateFormat;
        return dateFormat2 instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat2).toPattern() : this.dateFormatPattern;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return this.config.getObjectWriter(cls);
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.nameFilters;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasNameFilters(com.alibaba.fastjson.serializer.SerializeFilterable r1) {
        /*
            r0 = this;
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r0 = r0.nameFilters
            if (r0 == 0) goto L_0x000a
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0014
        L_0x000a:
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r0 = r1.nameFilters
            if (r0 == 0) goto L_0x0016
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.hasNameFilters(com.alibaba.fastjson.serializer.SerializeFilterable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.propertyFilters;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPropertyFilters(com.alibaba.fastjson.serializer.SerializeFilterable r1) {
        /*
            r0 = this;
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r0 = r0.propertyFilters
            if (r0 == 0) goto L_0x000a
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0014
        L_0x000a:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r0 = r1.propertyFilters
            if (r0 == 0) goto L_0x0016
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.hasPropertyFilters(com.alibaba.fastjson.serializer.SerializeFilterable):boolean");
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return this.out.isEnabled(serializerFeature);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = r1.context;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isWriteClassName(java.lang.reflect.Type r2, java.lang.Object r3) {
        /*
            r1 = this;
            com.alibaba.fastjson.serializer.SerializeWriter r3 = r1.out
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            boolean r3 = r3.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)
            if (r3 == 0) goto L_0x0020
            if (r2 != 0) goto L_0x001e
            com.alibaba.fastjson.serializer.SerializeWriter r2 = r1.out
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName
            boolean r2 = r2.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r3)
            if (r2 == 0) goto L_0x001e
            com.alibaba.fastjson.serializer.SerialContext r1 = r1.context
            if (r1 == 0) goto L_0x0020
            com.alibaba.fastjson.serializer.SerialContext r1 = r1.parent
            if (r1 == 0) goto L_0x0020
        L_0x001e:
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.isWriteClassName(java.lang.reflect.Type, java.lang.Object):boolean");
    }

    public void popContext() {
        SerialContext serialContext = this.context;
        if (serialContext != null) {
            this.context = serialContext.parent;
        }
    }

    public void println() {
        this.out.write(10);
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(this.indent);
        }
    }

    public void setContext(SerialContext serialContext) {
        this.context = serialContext;
    }

    public void setDateFormat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public String toString() {
        return this.out.toString();
    }

    public final void writeAs(Object obj, Class cls) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(cls).write(this, obj, (Object) null, (Type) null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeKeyValue(char c, String str, Object obj) {
        if (c != 0) {
            this.out.write((int) c);
        }
        this.out.writeFieldName(str);
        write(obj);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public void writeReference(Object obj) {
        SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext serialContext2 = serialContext.parent;
        if (serialContext2 == null || obj != serialContext2.object) {
            while (true) {
                SerialContext serialContext3 = serialContext.parent;
                if (serialContext3 == null) {
                    break;
                }
                serialContext = serialContext3;
            }
            if (obj == serialContext.object) {
                this.out.write("{\"$ref\":\"$\"}");
                return;
            }
            this.out.write("{\"$ref\":\"");
            this.out.write(this.references.get(obj).toString());
            this.out.write("\"}");
            return;
        }
        this.out.write("{\"$ref\":\"..\"}");
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        writeWithFieldName(obj, obj2, (Type) null, 0);
    }

    public final void writeWithFormat(Object obj, String str) {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.out.writeInt((int) (((Date) obj).getTime() / 1000));
            } else if ("millis".equals(str)) {
                this.out.writeLong(((Date) obj).getTime());
            } else {
                DateFormat dateFormat2 = getDateFormat();
                if (dateFormat2 == null) {
                    try {
                        dateFormat2 = new SimpleDateFormat(str, this.locale);
                    } catch (IllegalArgumentException unused) {
                        dateFormat2 = new SimpleDateFormat(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), this.locale);
                    }
                    dateFormat2.setTimeZone(this.timeZone);
                }
                this.out.writeString(dateFormat2.format((Date) obj));
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if ("gzip".equals(str) || "gzip,base64".equals(str)) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    this.out.writeByteArray(byteArrayOutputStream.toByteArray());
                    IOUtils.close(gZIPOutputStream);
                } catch (IOException e) {
                    throw new JSONException("write gzipBytes error", e);
                } catch (Throwable th) {
                    IOUtils.close((Closeable) null);
                    throw th;
                }
            } else if ("hex".equals(str)) {
                this.out.writeHex(bArr);
            } else {
                this.out.writeByteArray(bArr);
            }
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.out.write(91);
            for (int i = 0; i < collection.size(); i++) {
                Object next = it.next();
                if (i != 0) {
                    this.out.write(44);
                }
                writeWithFormat(next, str);
            }
            this.out.write(93);
        } else {
            write(obj);
        }
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.getGlobalInstance());
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        setContext(serialContext, obj, obj2, i, 0);
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i) {
        if (obj == null) {
            try {
                this.out.writeNull();
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } else {
            getObjectWriter(obj.getClass()).write(this, obj, obj2, type, i);
        }
    }

    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter(), serializeConfig);
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i, int i2) {
        if (!this.out.disableCircularReferenceDetect) {
            this.context = new SerialContext(serialContext, obj, obj2, i, i2);
            if (this.references == null) {
                this.references = new IdentityHashMap<>();
            }
            this.references.put(obj, this.context);
        }
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setContext(Object obj, Object obj2) {
        setContext(this.context, obj, obj2, 0);
    }

    public static void write(SerializeWriter serializeWriter, Object obj) {
        new JSONSerializer(serializeWriter).write(obj);
    }

    public final void write(Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(obj.getClass()).write(this, obj, (Object) null, (Type) null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void write(String str) {
        StringCodec.instance.write(this, str);
    }
}
