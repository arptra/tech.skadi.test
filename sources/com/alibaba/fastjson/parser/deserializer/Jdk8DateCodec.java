package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.time.DurationKt;
import okhttp3.internal.connection.RealConnection;

public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern(defaultPatttern).withZone(ZoneId.systemDefault());
    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(defaultPatttern);
    private static final DateTimeFormatter defaultFormatter_23 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    private static final DateTimeFormatter formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter_d10_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    private static final DateTimeFormatter formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter formatter_d10_us = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter formatter_d8 = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    private static final DateTimeFormatter formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_us = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_iso8601 = DateTimeFormatter.ofPattern(formatter_iso8601_pattern);
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        Type type2 = type;
        String str2 = str;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Class<Instant> cls = Instant.class;
        Class<ZonedDateTime> cls2 = ZonedDateTime.class;
        Class<LocalTime> cls3 = LocalTime.class;
        Class<LocalDate> cls4 = LocalDate.class;
        Class<LocalDateTime> cls5 = LocalDateTime.class;
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            DateTimeFormatter ofPattern = str2 != null ? defaultPatttern.equals(str2) ? defaultFormatter : DateTimeFormatter.ofPattern(str) : null;
            if ("".equals(stringVal)) {
                return null;
            }
            if (type2 == cls5) {
                return (stringVal.length() == 10 || stringVal.length() == 8) ? LocalDateTime.of(parseLocalDate(stringVal, str2, ofPattern), LocalTime.MIN) : parseDateTime(stringVal, ofPattern);
            }
            if (type2 != cls4) {
                int i2 = 0;
                if (type2 == cls3) {
                    if (stringVal.length() == 23) {
                        LocalDateTime parse = LocalDateTime.parse(stringVal);
                        return LocalTime.of(parse.getHour(), parse.getMinute(), parse.getSecond(), parse.getNano());
                    }
                    while (true) {
                        if (i2 < stringVal.length()) {
                            char charAt = stringVal.charAt(i2);
                            if (charAt < '0' || charAt > '9') {
                                break;
                            }
                            i2++;
                        } else if (stringVal.length() > 8 && stringVal.length() < 19) {
                            return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(stringVal)), JSON.defaultTimeZone.toZoneId()).toLocalTime();
                        }
                    }
                    return LocalTime.parse(stringVal);
                } else if (type2 == cls2) {
                    if (ofPattern == defaultFormatter) {
                        ofPattern = ISO_FIXED_FORMAT;
                    }
                    if (ofPattern == null && stringVal.length() <= 19) {
                        JSONScanner jSONScanner = new JSONScanner(stringVal);
                        TimeZone timeZone = defaultJSONParser2.lexer.getTimeZone();
                        jSONScanner.setTimeZone(timeZone);
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            return ZonedDateTime.ofInstant(jSONScanner.getCalendar().getTime().toInstant(), timeZone.toZoneId());
                        }
                    }
                    return parseZonedDateTime(stringVal, ofPattern);
                } else if (type2 == OffsetDateTime.class) {
                    return OffsetDateTime.parse(stringVal);
                } else {
                    if (type2 == OffsetTime.class) {
                        return OffsetTime.parse(stringVal);
                    }
                    if (type2 == ZoneId.class) {
                        return ZoneId.of(stringVal);
                    }
                    if (type2 == Period.class) {
                        return Period.parse(stringVal);
                    }
                    if (type2 == Duration.class) {
                        return Duration.parse(stringVal);
                    }
                    if (type2 != cls) {
                        return null;
                    }
                    while (true) {
                        if (i2 < stringVal.length()) {
                            char charAt2 = stringVal.charAt(i2);
                            if (charAt2 < '0' || charAt2 > '9') {
                                break;
                            }
                            i2++;
                        } else if (stringVal.length() > 8 && stringVal.length() < 19) {
                            return Instant.ofEpochMilli(Long.parseLong(stringVal));
                        }
                    }
                    return Instant.parse(stringVal);
                }
            } else if (stringVal.length() != 23) {
                return parseLocalDate(stringVal, str2, ofPattern);
            } else {
                LocalDateTime parse2 = LocalDateTime.parse(stringVal);
                return LocalDate.of(parse2.getYear(), parse2.getMonthValue(), parse2.getDayOfMonth());
            }
        } else if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken();
            if ("unixtime".equals(str2)) {
                longValue *= 1000;
            } else if ("yyyyMMddHHmmss".equals(str2)) {
                int i3 = (int) (longValue / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
                int i4 = (int) ((longValue / 100000000) % 100);
                int i5 = (int) ((longValue / 1000000) % 100);
                int i6 = (int) ((longValue / 10000) % 100);
                int i7 = (int) ((longValue / 100) % 100);
                int i8 = (int) (longValue % 100);
                if (type2 == cls5) {
                    return LocalDateTime.of(i3, i4, i5, i6, i7, i8);
                }
            }
            if (type2 == cls5) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            if (type2 == cls4) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalDate();
            }
            if (type2 == cls3) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalTime();
            }
            if (type2 == cls2) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            if (type2 == cls) {
                return Instant.ofEpochMilli(longValue);
            }
            throw new UnsupportedOperationException();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.time.LocalDateTime parseDateTime(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = 0
            r2 = 19
            r3 = 48
            if (r18 != 0) goto L_0x0115
            int r4 = r17.length()
            r5 = 32
            r6 = 16
            r7 = 13
            r8 = 7
            r9 = 46
            r10 = 1
            r11 = 4
            r12 = 58
            r13 = 10
            r14 = 45
            if (r4 != r2) goto L_0x00b9
            char r4 = r0.charAt(r11)
            char r8 = r0.charAt(r8)
            char r15 = r0.charAt(r13)
            char r7 = r0.charAt(r7)
            char r6 = r0.charAt(r6)
            if (r7 != r12) goto L_0x00e8
            if (r6 != r12) goto L_0x00e8
            if (r4 != r14) goto L_0x004a
            if (r8 != r14) goto L_0x004a
            r4 = 84
            if (r15 != r4) goto L_0x0044
            java.time.format.DateTimeFormatter r4 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
            goto L_0x00ea
        L_0x0044:
            if (r15 != r5) goto L_0x00e8
            java.time.format.DateTimeFormatter r4 = defaultFormatter
            goto L_0x00ea
        L_0x004a:
            r5 = 47
            if (r4 != r5) goto L_0x0054
            if (r8 != r5) goto L_0x0054
            java.time.format.DateTimeFormatter r4 = formatter_dt19_tw
            goto L_0x00ea
        L_0x0054:
            char r6 = r0.charAt(r1)
            char r7 = r0.charAt(r10)
            r8 = 2
            char r8 = r0.charAt(r8)
            r12 = 3
            char r12 = r0.charAt(r12)
            r15 = 5
            char r15 = r0.charAt(r15)
            if (r8 != r5) goto L_0x00ab
            if (r15 != r5) goto L_0x00ab
            int r6 = r6 - r3
            int r6 = r6 * r13
            int r7 = r7 - r3
            int r6 = r6 + r7
            int r12 = r12 - r3
            int r12 = r12 * r13
            int r4 = r4 - r3
            int r12 = r12 + r4
            r4 = 12
            if (r6 <= r4) goto L_0x007f
            java.time.format.DateTimeFormatter r4 = formatter_dt19_eur
            goto L_0x00ea
        L_0x007f:
            if (r12 <= r4) goto L_0x0085
            java.time.format.DateTimeFormatter r4 = formatter_dt19_us
            goto L_0x00ea
        L_0x0085:
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            java.lang.String r5 = "US"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0098
            java.time.format.DateTimeFormatter r4 = formatter_dt19_us
            goto L_0x00ea
        L_0x0098:
            java.lang.String r5 = "BR"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00a8
            java.lang.String r5 = "AU"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00e8
        L_0x00a8:
            java.time.format.DateTimeFormatter r4 = formatter_dt19_eur
            goto L_0x00ea
        L_0x00ab:
            if (r8 != r9) goto L_0x00b2
            if (r15 != r9) goto L_0x00b2
            java.time.format.DateTimeFormatter r4 = formatter_dt19_de
            goto L_0x00ea
        L_0x00b2:
            if (r8 != r14) goto L_0x00e8
            if (r15 != r14) goto L_0x00e8
            java.time.format.DateTimeFormatter r4 = formatter_dt19_in
            goto L_0x00ea
        L_0x00b9:
            int r4 = r17.length()
            r15 = 23
            if (r4 != r15) goto L_0x00e8
            char r4 = r0.charAt(r11)
            char r8 = r0.charAt(r8)
            char r13 = r0.charAt(r13)
            char r7 = r0.charAt(r7)
            char r6 = r0.charAt(r6)
            char r15 = r0.charAt(r2)
            if (r7 != r12) goto L_0x00e8
            if (r6 != r12) goto L_0x00e8
            if (r4 != r14) goto L_0x00e8
            if (r8 != r14) goto L_0x00e8
            if (r13 != r5) goto L_0x00e8
            if (r15 != r9) goto L_0x00e8
            java.time.format.DateTimeFormatter r4 = defaultFormatter_23
            goto L_0x00ea
        L_0x00e8:
            r4 = r18
        L_0x00ea:
            int r5 = r17.length()
            r6 = 17
            if (r5 < r6) goto L_0x0117
            char r5 = r0.charAt(r11)
            r6 = 24180(0x5e74, float:3.3883E-41)
            if (r5 != r6) goto L_0x010d
            int r4 = r17.length()
            int r4 = r4 - r10
            char r4 = r0.charAt(r4)
            r5 = 31186(0x79d2, float:4.3701E-41)
            if (r4 != r5) goto L_0x010a
            java.time.format.DateTimeFormatter r4 = formatter_dt19_cn_1
            goto L_0x0117
        L_0x010a:
            java.time.format.DateTimeFormatter r4 = formatter_dt19_cn
            goto L_0x0117
        L_0x010d:
            r6 = 45380(0xb144, float:6.3591E-41)
            if (r5 != r6) goto L_0x0117
            java.time.format.DateTimeFormatter r4 = formatter_dt19_kr
            goto L_0x0117
        L_0x0115:
            r4 = r18
        L_0x0117:
            if (r4 != 0) goto L_0x016a
            com.alibaba.fastjson.parser.JSONScanner r5 = new com.alibaba.fastjson.parser.JSONScanner
            r5.<init>(r0)
            boolean r6 = r5.scanISO8601DateIfMatch(r1)
            if (r6 == 0) goto L_0x0135
            java.util.Calendar r0 = r5.getCalendar()
            java.time.Instant r0 = r0.toInstant()
            java.time.ZoneId r1 = java.time.ZoneId.systemDefault()
            java.time.LocalDateTime r0 = java.time.LocalDateTime.ofInstant(r0, r1)
            return r0
        L_0x0135:
            int r5 = r17.length()
            if (r1 >= r5) goto L_0x0149
            char r5 = r0.charAt(r1)
            if (r5 < r3) goto L_0x016a
            r6 = 57
            if (r5 <= r6) goto L_0x0146
            goto L_0x016a
        L_0x0146:
            int r1 = r1 + 1
            goto L_0x0135
        L_0x0149:
            int r1 = r17.length()
            r3 = 8
            if (r1 <= r3) goto L_0x016a
            int r1 = r17.length()
            if (r1 >= r2) goto L_0x016a
            long r0 = java.lang.Long.parseLong(r17)
            java.time.Instant r0 = java.time.Instant.ofEpochMilli(r0)
            java.util.TimeZone r1 = com.alibaba.fastjson.JSON.defaultTimeZone
            java.time.ZoneId r1 = r1.toZoneId()
            java.time.LocalDateTime r0 = java.time.LocalDateTime.ofInstant(r0, r1)
            return r0
        L_0x016a:
            if (r4 != 0) goto L_0x0171
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r17)
            goto L_0x0175
        L_0x0171:
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r0, r4)
        L_0x0175:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            int i = 0;
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i2 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter3 = formatter_d10_eur;
                    } else if (i2 > 12) {
                        dateTimeFormatter3 = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (charAt5 == '.' && charAt7 == '.') {
                    dateTimeFormatter = formatter_d10_de;
                } else if (charAt5 == '-' && charAt7 == '-') {
                    dateTimeFormatter = formatter_d10_in;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter2 = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter2 = formatter_d10_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i < str.length()) {
                    char charAt9 = str.charAt(i);
                    if (charAt9 < '0' || charAt9 > '9') {
                        break;
                    }
                    i++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId()).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    public ZonedDateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            int i = 0;
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = defaultFormatter;
                        }
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i2 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = formatter_dt19_eur;
                            } else if (i2 > 12) {
                                dateTimeFormatter = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? formatter_dt19_cn_1 : formatter_dt19_cn;
                } else if (charAt11 == 45380) {
                    dateTimeFormatter2 = formatter_dt19_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i < str.length()) {
                    char charAt12 = str.charAt(i);
                    if (charAt12 < '0' || charAt12 > '9') {
                        break;
                    }
                    i++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId());
                }
            }
        }
        return dateTimeFormatter == null ? ZonedDateTime.parse(str) : ZonedDateTime.parse(str, dateTimeFormatter);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int nano;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
            int mask = serializerFeature.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                int i2 = i & mask;
                dateFormatPattern = formatter_iso8601_pattern;
                if (i2 == 0 && !jSONSerializer.isEnabled(serializerFeature) && (nano = localDateTime.getNano()) != 0) {
                    dateFormatPattern = nano % DurationKt.NANOS_IN_MILLIS == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                }
            }
            write(serializeWriter, (TemporalAccessor) localDateTime, dateFormatPattern);
            return;
        }
        serializeWriter.writeString(obj.toString());
    }

    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, (TemporalAccessor) obj, beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatter;
        Instant instant;
        if ("unixtime".equals(str)) {
            if (temporalAccessor instanceof ChronoZonedDateTime) {
                serializeWriter.writeInt((int) ((ChronoZonedDateTime) temporalAccessor).toEpochSecond());
                return;
            } else if (temporalAccessor instanceof LocalDateTime) {
                serializeWriter.writeInt((int) ((LocalDateTime) temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (temporalAccessor instanceof ChronoZonedDateTime) {
                instant = ((ChronoZonedDateTime) temporalAccessor).toInstant();
            } else {
                instant = temporalAccessor instanceof LocalDateTime ? ((LocalDateTime) temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toInstant() : null;
            }
            if (instant != null) {
                serializeWriter.writeLong(instant.toEpochMilli());
                return;
            }
        }
        if (str == formatter_iso8601_pattern) {
            dateTimeFormatter = formatter_iso8601;
        } else {
            dateTimeFormatter = DateTimeFormatter.ofPattern(str);
        }
        serializeWriter.writeString(dateTimeFormatter.format(temporalAccessor));
    }
}
