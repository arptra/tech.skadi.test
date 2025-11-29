package org.eclipse.jetty.util.ajax;

import com.honey.account.constant.AccountConstantKt;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class JSONDateConvertor implements JSON.Convertor {
    private static final Logger LOG = Log.getLogger((Class<?>) JSONDateConvertor.class);
    private final DateCache _dateCache;
    private final SimpleDateFormat _format;
    private final boolean _fromJSON;

    public JSONDateConvertor() {
        this(false);
    }

    public Object fromJSON(Map map) {
        Object parseObject;
        if (this._fromJSON) {
            try {
                synchronized (this._format) {
                    parseObject = this._format.parseObject((String) map.get(AccountConstantKt.RESPONSE_VALUE));
                }
                return parseObject;
            } catch (Exception e) {
                LOG.warn(e);
                return null;
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void toJSON(Object obj, JSON.Output output) {
        String format = this._dateCache.format((Date) obj);
        if (this._fromJSON) {
            output.addClass(obj.getClass());
            output.add(AccountConstantKt.RESPONSE_VALUE, (Object) format);
            return;
        }
        output.add(format);
    }

    public JSONDateConvertor(boolean z) {
        this(DateCache.DEFAULT_FORMAT, TimeZone.getTimeZone(TimeZones.GMT_ID), z);
    }

    public JSONDateConvertor(String str, TimeZone timeZone, boolean z) {
        DateCache dateCache = new DateCache(str);
        this._dateCache = dateCache;
        dateCache.setTimeZone(timeZone);
        this._fromJSON = z;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        this._format = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public JSONDateConvertor(String str, TimeZone timeZone, boolean z, Locale locale) {
        DateCache dateCache = new DateCache(str, locale);
        this._dateCache = dateCache;
        dateCache.setTimeZone(timeZone);
        this._fromJSON = z;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, new DateFormatSymbols(locale));
        this._format = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }
}
