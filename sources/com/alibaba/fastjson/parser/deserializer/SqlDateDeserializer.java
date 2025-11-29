package com.alibaba.fastjson.parser.deserializer;

public class SqlDateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
    public static final SqlDateDeserializer instance = new SqlDateDeserializer();
    public static final SqlDateDeserializer instance_timestamp = new SqlDateDeserializer(true);
    private boolean timestamp = false;

    public SqlDateDeserializer() {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r3 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0075 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T cast(com.alibaba.fastjson.parser.DefaultJSONParser r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            boolean r0 = r2.timestamp
            if (r0 == 0) goto L_0x0009
            java.lang.Object r2 = r2.castTimestamp(r3, r4, r5, r6)
            return r2
        L_0x0009:
            r2 = 0
            if (r6 != 0) goto L_0x000d
            return r2
        L_0x000d:
            boolean r4 = r6 instanceof java.util.Date
            if (r4 == 0) goto L_0x001d
            java.sql.Date r2 = new java.sql.Date
            java.util.Date r6 = (java.util.Date) r6
            long r3 = r6.getTime()
            r2.<init>(r3)
            goto L_0x003c
        L_0x001d:
            boolean r4 = r6 instanceof java.math.BigDecimal
            if (r4 == 0) goto L_0x002d
            java.sql.Date r2 = new java.sql.Date
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6
            long r3 = com.alibaba.fastjson.util.TypeUtils.longValue(r6)
            r2.<init>(r3)
            goto L_0x003c
        L_0x002d:
            boolean r4 = r6 instanceof java.lang.Number
            if (r4 == 0) goto L_0x003d
            java.sql.Date r2 = new java.sql.Date
            java.lang.Number r6 = (java.lang.Number) r6
            long r3 = r6.longValue()
            r2.<init>(r3)
        L_0x003c:
            return r2
        L_0x003d:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x0086
            java.lang.String r6 = (java.lang.String) r6
            int r4 = r6.length()
            if (r4 != 0) goto L_0x004a
            return r2
        L_0x004a:
            com.alibaba.fastjson.parser.JSONScanner r2 = new com.alibaba.fastjson.parser.JSONScanner
            r2.<init>(r6)
            boolean r4 = r2.scanISO8601DateIfMatch()     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0060
            java.util.Calendar r3 = r2.getCalendar()     // Catch:{ all -> 0x005e }
            long r3 = r3.getTimeInMillis()     // Catch:{ all -> 0x005e }
            goto L_0x0079
        L_0x005e:
            r3 = move-exception
            goto L_0x0082
        L_0x0060:
            java.text.DateFormat r3 = r3.getDateFormat()     // Catch:{ all -> 0x005e }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x0075 }
            java.sql.Date r4 = new java.sql.Date     // Catch:{ ParseException -> 0x0075 }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x0075 }
            r4.<init>(r0)     // Catch:{ ParseException -> 0x0075 }
            r2.close()
            return r4
        L_0x0075:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x005e }
        L_0x0079:
            r2.close()
            java.sql.Date r2 = new java.sql.Date
            r2.<init>(r3)
            return r2
        L_0x0082:
            r2.close()
            throw r3
        L_0x0086:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "parse error : "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.cast(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x008b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T castTimestamp(com.alibaba.fastjson.parser.DefaultJSONParser r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2 = 0
            if (r6 != 0) goto L_0x0004
            return r2
        L_0x0004:
            boolean r4 = r6 instanceof java.util.Date
            if (r4 == 0) goto L_0x0014
            java.sql.Timestamp r2 = new java.sql.Timestamp
            java.util.Date r6 = (java.util.Date) r6
            long r3 = r6.getTime()
            r2.<init>(r3)
            return r2
        L_0x0014:
            boolean r4 = r6 instanceof java.math.BigDecimal
            if (r4 == 0) goto L_0x0024
            java.sql.Timestamp r2 = new java.sql.Timestamp
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6
            long r3 = com.alibaba.fastjson.util.TypeUtils.longValue(r6)
            r2.<init>(r3)
            return r2
        L_0x0024:
            boolean r4 = r6 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0034
            java.sql.Timestamp r2 = new java.sql.Timestamp
            java.lang.Number r6 = (java.lang.Number) r6
            long r3 = r6.longValue()
            r2.<init>(r3)
            return r2
        L_0x0034:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x009c
            java.lang.String r6 = (java.lang.String) r6
            int r4 = r6.length()
            if (r4 != 0) goto L_0x0041
            return r2
        L_0x0041:
            com.alibaba.fastjson.parser.JSONScanner r2 = new com.alibaba.fastjson.parser.JSONScanner
            r2.<init>(r6)
            r4 = 0
            boolean r4 = r2.scanISO8601DateIfMatch(r4)     // Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x0058
            java.util.Calendar r3 = r2.getCalendar()     // Catch:{ all -> 0x0056 }
            long r3 = r3.getTimeInMillis()     // Catch:{ all -> 0x0056 }
            goto L_0x008f
        L_0x0056:
            r3 = move-exception
            goto L_0x0098
        L_0x0058:
            int r4 = r6.length()     // Catch:{ all -> 0x0056 }
            r5 = 29
            if (r4 != r5) goto L_0x0076
            java.lang.String r4 = r3.getDateFomartPattern()     // Catch:{ all -> 0x0056 }
            int r0 = r4.length()     // Catch:{ all -> 0x0056 }
            if (r0 == r5) goto L_0x0076
            java.lang.String r5 = com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT     // Catch:{ all -> 0x0056 }
            if (r4 != r5) goto L_0x0076
            java.sql.Timestamp r3 = java.sql.Timestamp.valueOf(r6)     // Catch:{ all -> 0x0056 }
            r2.close()
            return r3
        L_0x0076:
            java.text.DateFormat r3 = r3.getDateFormat()     // Catch:{ all -> 0x0056 }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x008b }
            java.sql.Timestamp r4 = new java.sql.Timestamp     // Catch:{ ParseException -> 0x008b }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x008b }
            r4.<init>(r0)     // Catch:{ ParseException -> 0x008b }
            r2.close()
            return r4
        L_0x008b:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0056 }
        L_0x008f:
            r2.close()
            java.sql.Timestamp r2 = new java.sql.Timestamp
            r2.<init>(r3)
            return r2
        L_0x0098:
            r2.close()
            throw r3
        L_0x009c:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = "parse error"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.castTimestamp(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public int getFastMatchToken() {
        return 2;
    }

    public SqlDateDeserializer(boolean z) {
    }
}
