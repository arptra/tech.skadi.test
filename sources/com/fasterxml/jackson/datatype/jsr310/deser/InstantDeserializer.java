package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.honey.account.x0.b;
import com.honey.account.x0.c;
import com.honey.account.x0.d;
import com.honey.account.x0.e;
import com.honey.account.x0.f;
import com.honey.account.x0.g;
import com.honey.account.x0.h;
import com.honey.account.x0.i;
import com.honey.account.x0.j;
import com.honey.account.x0.k;
import com.honey.account.x0.l;
import com.honey.account.x0.m;
import com.honey.account.x0.n;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;

public class InstantDeserializer<T extends Temporal> extends JSR310DateTimeDeserializerBase<T> {
    public static final InstantDeserializer<Instant> INSTANT = new InstantDeserializer(Instant.class, DateTimeFormatter.ISO_INSTANT, new g(), new i(), new j(), (BiFunction) null, true);
    private static final Pattern ISO8601_UTC_ZERO_OFFSET_SUFFIX_REGEX = Pattern.compile("\\+00:?(00)?$");
    public static final InstantDeserializer<OffsetDateTime> OFFSET_DATE_TIME = new InstantDeserializer(OffsetDateTime.class, DateTimeFormatter.ISO_OFFSET_DATE_TIME, new k(), new l(), new m(), new n(), true);
    public static final InstantDeserializer<ZonedDateTime> ZONED_DATE_TIME = new InstantDeserializer(ZonedDateTime.class, DateTimeFormatter.ISO_ZONED_DATE_TIME, new c(), new d(), new e(), new h(), false);
    private static final long serialVersionUID = 1;
    protected final Boolean _adjustToContextTZOverride;
    protected final BiFunction<T, ZoneId, T> adjust;
    protected final Function<FromIntegerArguments, T> fromMilliseconds;
    protected final Function<FromDecimalArguments, T> fromNanoseconds;
    protected final Function<TemporalAccessor, T> parsedToValue;
    protected final boolean replaceZeroOffsetAsZ;

    public static class FromDecimalArguments {
        public final int fraction;
        public final long integer;
        public final ZoneId zoneId;

        private FromDecimalArguments(long j, int i, ZoneId zoneId2) {
            this.integer = j;
            this.fraction = i;
            this.zoneId = zoneId2;
        }
    }

    public static class FromIntegerArguments {
        public final long value;
        public final ZoneId zoneId;

        private FromIntegerArguments(long j, ZoneId zoneId2) {
            this.value = j;
            this.zoneId = zoneId2;
        }
    }

    public InstantDeserializer(Class<T> cls, DateTimeFormatter dateTimeFormatter, Function<TemporalAccessor, T> function, Function<FromIntegerArguments, T> function2, Function<FromDecimalArguments, T> function3, BiFunction<T, ZoneId, T> biFunction, boolean z) {
        super(cls, dateTimeFormatter);
        this.parsedToValue = function;
        this.fromMilliseconds = function2;
        this.fromNanoseconds = function3;
        if (biFunction == null) {
            new b
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: CONSTRUCTOR  (r6v2 ? I:com.honey.account.x0.b) =  call: com.honey.account.x0.b.<init>():void type: CONSTRUCTOR in method: com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.<init>(java.lang.Class, java.time.format.DateTimeFormatter, java.util.function.Function, java.util.function.Function, java.util.function.Function, java.util.function.BiFunction, boolean):void, dex: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                this = this;
                r0.<init>(r1, r2)
                r0.parsedToValue = r3
                r0.fromMilliseconds = r4
                r0.fromNanoseconds = r5
                if (r6 != 0) goto L_0x0010
                com.honey.account.x0.b r6 = new com.honey.account.x0.b
                r6.<init>()
            L_0x0010:
                r0.adjust = r6
                r0.replaceZeroOffsetAsZ = r7
                r1 = 0
                r0._adjustToContextTZOverride = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.<init>(java.lang.Class, java.time.format.DateTimeFormatter, java.util.function.Function, java.util.function.Function, java.util.function.Function, java.util.function.BiFunction, boolean):void");
        }

        private ZoneId getZone(DeserializationContext deserializationContext) {
            if (this._valueClass == Instant.class) {
                return null;
            }
            return deserializationContext.getTimeZone().toZoneId();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ FromDecimalArguments lambda$_fromDecimal$8(DeserializationContext deserializationContext, Long l, Integer num) {
            return new FromDecimalArguments(l.longValue(), num.intValue(), getZone(deserializationContext));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Temporal lambda$new$7(Temporal temporal, ZoneId zoneId) {
            return temporal;
        }

        private String replaceZeroOffsetAsZIfNecessary(String str) {
            return this.replaceZeroOffsetAsZ ? ISO8601_UTC_ZERO_OFFSET_SUFFIX_REGEX.matcher(str).replaceFirst("Z") : str;
        }

        public int _countPeriods(String str) {
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    if (charAt != '.') {
                        return -1;
                    }
                    i++;
                }
            }
            return i;
        }

        public T _fromDecimal(DeserializationContext deserializationContext, BigDecimal bigDecimal) {
            return (Temporal) this.fromNanoseconds.apply((FromDecimalArguments) DecimalUtils.extractSecondsAndNanos(bigDecimal, new f(this, deserializationContext)));
        }

        public T _fromLong(DeserializationContext deserializationContext, long j) {
            if (!deserializationContext.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
                return (Temporal) this.fromMilliseconds.apply(new FromIntegerArguments(j, getZone(deserializationContext)));
            }
            return (Temporal) this.fromNanoseconds.apply(new FromDecimalArguments(j, 0, getZone(deserializationContext)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r3 = findFormatOverrides(r3, r4, handledType());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.fasterxml.jackson.databind.JsonDeserializer<T> createContextual(com.fasterxml.jackson.databind.DeserializationContext r3, com.fasterxml.jackson.databind.BeanProperty r4) throws com.fasterxml.jackson.databind.JsonMappingException {
            /*
                r2 = this;
                com.fasterxml.jackson.databind.JsonDeserializer r0 = super.createContextual(r3, r4)
                com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer r0 = (com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer) r0
                if (r0 == r2) goto L_0x001d
                java.lang.Class r1 = r2.handledType()
                com.fasterxml.jackson.annotation.JsonFormat$Value r3 = r2.findFormatOverrides(r3, r4, r1)
                if (r3 == 0) goto L_0x001d
                com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer r2 = new com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer
                com.fasterxml.jackson.annotation.JsonFormat$Feature r4 = com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE
                java.lang.Boolean r3 = r3.getFeature(r4)
                r2.<init>(r0, (java.lang.Boolean) r3)
            L_0x001d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.createContextual(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonDeserializer");
        }

        public boolean shouldAdjustToContextTimezone(DeserializationContext deserializationContext) {
            Boolean bool = this._adjustToContextTZOverride;
            return bool != null ? bool.booleanValue() : deserializationContext.isEnabled(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        }

        public JsonDeserializer<T> withDateFormat(DateTimeFormatter dateTimeFormatter) {
            return dateTimeFormatter == this._formatter ? this : new InstantDeserializer(this, dateTimeFormatter);
        }

        public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            int currentTokenId = jsonParser.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (Temporal) _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (currentTokenId == 12) {
                return (Temporal) jsonParser.getEmbeddedObject();
            }
            if (currentTokenId == 6) {
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return null;
                }
                DateTimeFormatter dateTimeFormatter = this._formatter;
                if (dateTimeFormatter == DateTimeFormatter.ISO_INSTANT || dateTimeFormatter == DateTimeFormatter.ISO_OFFSET_DATE_TIME || dateTimeFormatter == DateTimeFormatter.ISO_ZONED_DATE_TIME) {
                    int _countPeriods = _countPeriods(trim);
                    if (_countPeriods >= 0) {
                        if (_countPeriods == 0) {
                            try {
                                return _fromLong(deserializationContext, Long.parseLong(trim));
                            } catch (NumberFormatException unused) {
                            }
                        } else if (_countPeriods == 1) {
                            return _fromDecimal(deserializationContext, new BigDecimal(trim));
                        }
                    }
                    trim = replaceZeroOffsetAsZIfNecessary(trim);
                }
                try {
                    T t = (Temporal) this.parsedToValue.apply(this._formatter.parse(trim));
                    if (shouldAdjustToContextTimezone(deserializationContext)) {
                        return (Temporal) this.adjust.apply(t, getZone(deserializationContext));
                    }
                    return t;
                } catch (DateTimeException e) {
                    return (Temporal) _handleDateTimeException(deserializationContext, e, trim);
                }
            } else if (currentTokenId == 7) {
                return _fromLong(deserializationContext, jsonParser.getLongValue());
            } else {
                if (currentTokenId != 8) {
                    return (Temporal) _handleUnexpectedToken(deserializationContext, jsonParser, JsonToken.VALUE_STRING, JsonToken.VALUE_NUMBER_INT, JsonToken.VALUE_NUMBER_FLOAT);
                }
                return _fromDecimal(deserializationContext, jsonParser.getDecimalValue());
            }
        }

        public InstantDeserializer(InstantDeserializer<T> instantDeserializer, DateTimeFormatter dateTimeFormatter) {
            super(instantDeserializer.handledType(), dateTimeFormatter);
            this.parsedToValue = instantDeserializer.parsedToValue;
            this.fromMilliseconds = instantDeserializer.fromMilliseconds;
            this.fromNanoseconds = instantDeserializer.fromNanoseconds;
            this.adjust = instantDeserializer.adjust;
            this.replaceZeroOffsetAsZ = this._formatter == DateTimeFormatter.ISO_INSTANT;
            this._adjustToContextTZOverride = instantDeserializer._adjustToContextTZOverride;
        }

        public InstantDeserializer(InstantDeserializer<T> instantDeserializer, Boolean bool) {
            super(instantDeserializer.handledType(), instantDeserializer._formatter);
            this.parsedToValue = instantDeserializer.parsedToValue;
            this.fromMilliseconds = instantDeserializer.fromMilliseconds;
            this.fromNanoseconds = instantDeserializer.fromNanoseconds;
            this.adjust = instantDeserializer.adjust;
            this.replaceZeroOffsetAsZ = instantDeserializer.replaceZeroOffsetAsZ;
            this._adjustToContextTZOverride = bool;
        }
    }
