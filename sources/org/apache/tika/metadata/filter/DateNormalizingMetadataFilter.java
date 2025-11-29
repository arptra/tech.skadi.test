package org.apache.tika.metadata.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateNormalizingMetadataFilter extends MetadataFilter {
    private static final Logger LOGGER = LoggerFactory.k(DateNormalizingMetadataFilter.class);
    private static TimeZone UTC = TimeZone.getTimeZone("UTC");
    private TimeZone defaultTimeZone = UTC;

    public void filter(Metadata metadata) throws TikaException {
        SimpleDateFormat simpleDateFormat = null;
        SimpleDateFormat simpleDateFormat2 = null;
        for (String m : metadata.names()) {
            Property m2 = Property.m(m);
            if (m2 != null && m2.r().equals(Property.ValueType.DATE)) {
                String str = metadata.get(m2);
                if (!str.endsWith("Z")) {
                    if (simpleDateFormat == null) {
                        Locale locale = Locale.US;
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
                        simpleDateFormat.setTimeZone(this.defaultTimeZone);
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale);
                        simpleDateFormat3.setTimeZone(UTC);
                        simpleDateFormat2 = simpleDateFormat3;
                    }
                    try {
                        metadata.set(m2, simpleDateFormat2.format(simpleDateFormat.parse(str)));
                    } catch (ParseException unused) {
                        LOGGER.warn("Couldn't convert date to default time zone: >" + str + "<");
                    }
                }
            }
        }
    }

    @Field
    public void setDefaultTimeZone(String str) {
        this.defaultTimeZone = TimeZone.getTimeZone(ZoneId.of(str));
    }
}
