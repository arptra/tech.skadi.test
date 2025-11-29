package com.fasterxml.jackson.datatype.jsr310;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.DurationDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310StringParsableDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.MonthDayDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.OffsetTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.DurationKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.InstantKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.MonthDayKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.PeriodKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.YearKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.YearMothKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.ZoneIdKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.ZoneOffsetKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.ZonedDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.MonthDaySerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.key.ZonedDateTimeKeySerializer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class JavaTimeModule extends SimpleModule {
    private static final long serialVersionUID = 1;

    public JavaTimeModule() {
        super(PackageVersion.VERSION);
        Class<Instant> cls = Instant.class;
        addDeserializer(cls, InstantDeserializer.INSTANT);
        Class<OffsetDateTime> cls2 = OffsetDateTime.class;
        addDeserializer(cls2, InstantDeserializer.OFFSET_DATE_TIME);
        Class<ZonedDateTime> cls3 = ZonedDateTime.class;
        addDeserializer(cls3, InstantDeserializer.ZONED_DATE_TIME);
        Class<Duration> cls4 = Duration.class;
        addDeserializer(cls4, DurationDeserializer.INSTANCE);
        Class<LocalDateTime> cls5 = LocalDateTime.class;
        addDeserializer(cls5, LocalDateTimeDeserializer.INSTANCE);
        Class<LocalDate> cls6 = LocalDate.class;
        addDeserializer(cls6, LocalDateDeserializer.INSTANCE);
        Class<LocalTime> cls7 = LocalTime.class;
        addDeserializer(cls7, LocalTimeDeserializer.INSTANCE);
        Class<MonthDay> cls8 = MonthDay.class;
        addDeserializer(cls8, MonthDayDeserializer.INSTANCE);
        Class<OffsetTime> cls9 = OffsetTime.class;
        addDeserializer(cls9, OffsetTimeDeserializer.INSTANCE);
        Class<Period> cls10 = Period.class;
        addDeserializer(cls10, JSR310StringParsableDeserializer.PERIOD);
        Class<Year> cls11 = Year.class;
        addDeserializer(cls11, YearDeserializer.INSTANCE);
        Class<YearMonth> cls12 = YearMonth.class;
        addDeserializer(cls12, YearMonthDeserializer.INSTANCE);
        Class<ZoneId> cls13 = ZoneId.class;
        addDeserializer(cls13, JSR310StringParsableDeserializer.ZONE_ID);
        Class<ZoneOffset> cls14 = ZoneOffset.class;
        addDeserializer(cls14, JSR310StringParsableDeserializer.ZONE_OFFSET);
        addSerializer(cls4, DurationSerializer.INSTANCE);
        addSerializer(cls, InstantSerializer.INSTANCE);
        addSerializer(cls5, LocalDateTimeSerializer.INSTANCE);
        addSerializer(cls6, LocalDateSerializer.INSTANCE);
        addSerializer(cls7, LocalTimeSerializer.INSTANCE);
        addSerializer(cls8, MonthDaySerializer.INSTANCE);
        addSerializer(cls2, OffsetDateTimeSerializer.INSTANCE);
        addSerializer(cls9, OffsetTimeSerializer.INSTANCE);
        addSerializer(cls10, new ToStringSerializer(cls10));
        addSerializer(cls11, YearSerializer.INSTANCE);
        addSerializer(cls12, YearMonthSerializer.INSTANCE);
        addSerializer(cls3, ZonedDateTimeSerializer.INSTANCE);
        addSerializer(cls13, new ToStringSerializer(cls13));
        addSerializer(cls14, new ToStringSerializer(cls14));
        addKeySerializer(cls3, ZonedDateTimeKeySerializer.INSTANCE);
        addKeyDeserializer(cls4, DurationKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls, InstantKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls5, LocalDateTimeKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls6, LocalDateKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls7, LocalTimeKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls8, MonthDayKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls2, OffsetDateTimeKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls9, OffsetTimeKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls10, PeriodKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls11, YearKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls12, YearMothKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls3, ZonedDateTimeKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls13, ZoneIdKeyDeserializer.INSTANCE);
        addKeyDeserializer(cls14, ZoneOffsetKeyDeserializer.INSTANCE);
    }

    public AnnotatedMethod _findFactory(AnnotatedClass annotatedClass, String str, Class<?>... clsArr) {
        int length = clsArr.length;
        for (AnnotatedMethod next : annotatedClass.getFactoryMethods()) {
            if (str.equals(next.getName()) && next.getParameterCount() == length) {
                for (int i = 0; i < length; i++) {
                    next.getParameter(i).getRawType().isAssignableFrom(clsArr[i]);
                }
                return next;
            }
        }
        return null;
    }

    public void setupModule(Module.SetupContext setupContext) {
        super.setupModule(setupContext);
        setupContext.addValueInstantiators(new ValueInstantiators.Base() {
            public ValueInstantiator findValueInstantiator(DeserializationConfig deserializationConfig, BeanDescription beanDescription, ValueInstantiator valueInstantiator) {
                AnnotatedMethod _findFactory;
                Class<?> rawClass = beanDescription.getType().getRawClass();
                Class<ZoneId> cls = ZoneId.class;
                if (cls.isAssignableFrom(rawClass) && (valueInstantiator instanceof StdValueInstantiator)) {
                    StdValueInstantiator stdValueInstantiator = (StdValueInstantiator) valueInstantiator;
                    AnnotatedClass classInfo = rawClass == cls ? beanDescription.getClassInfo() : AnnotatedClassResolver.resolve(deserializationConfig, deserializationConfig.constructType((Class<?>) cls), deserializationConfig);
                    if (!stdValueInstantiator.canCreateFromString() && (_findFactory = JavaTimeModule.this._findFactory(classInfo, "of", String.class)) != null) {
                        stdValueInstantiator.configureFromStringCreator(_findFactory);
                    }
                }
                return valueInstantiator;
            }
        });
    }
}
