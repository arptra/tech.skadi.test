package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.prefixmapper.PrefixTimeZonesMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneNumberToTimeZonesMapper {
    private static final String MAPPING_DATA_DIRECTORY = "/com/google/i18n/phonenumbers/timezones/data/";
    private static final String MAPPING_DATA_FILE_NAME = "map_data";
    private static final String UNKNOWN_TIMEZONE = "Etc/Unknown";
    static final List<String> UNKNOWN_TIME_ZONE_LIST;
    private static final Logger logger = Logger.getLogger(PhoneNumberToTimeZonesMapper.class.getName());
    private PrefixTimeZonesMap prefixTimeZonesMap;

    public static class LazyHolder {
        /* access modifiers changed from: private */
        public static final PhoneNumberToTimeZonesMapper INSTANCE = new PhoneNumberToTimeZonesMapper(PhoneNumberToTimeZonesMapper.loadPrefixTimeZonesMapFromFile("/com/google/i18n/phonenumbers/timezones/data/map_data"));

        private LazyHolder() {
        }
    }

    static {
        ArrayList arrayList = new ArrayList(1);
        UNKNOWN_TIME_ZONE_LIST = arrayList;
        arrayList.add(UNKNOWN_TIMEZONE);
    }

    private static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, e.toString());
            }
        }
    }

    private List<String> getCountryLevelTimeZonesforNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> lookupCountryLevelTimeZonesForNumber = this.prefixTimeZonesMap.lookupCountryLevelTimeZonesForNumber(phoneNumber);
        if (lookupCountryLevelTimeZonesForNumber.isEmpty()) {
            lookupCountryLevelTimeZonesForNumber = UNKNOWN_TIME_ZONE_LIST;
        }
        return Collections.unmodifiableList(lookupCountryLevelTimeZonesForNumber);
    }

    public static synchronized PhoneNumberToTimeZonesMapper getInstance() {
        PhoneNumberToTimeZonesMapper access$200;
        synchronized (PhoneNumberToTimeZonesMapper.class) {
            access$200 = LazyHolder.INSTANCE;
        }
        return access$200;
    }

    private List<String> getTimeZonesForGeocodableNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> lookupTimeZonesForNumber = this.prefixTimeZonesMap.lookupTimeZonesForNumber(phoneNumber);
        if (lookupTimeZonesForNumber.isEmpty()) {
            lookupTimeZonesForNumber = UNKNOWN_TIME_ZONE_LIST;
        }
        return Collections.unmodifiableList(lookupTimeZonesForNumber);
    }

    public static String getUnknownTimeZone() {
        return UNKNOWN_TIMEZONE;
    }

    /* access modifiers changed from: private */
    public static PrefixTimeZonesMap loadPrefixTimeZonesMapFromFile(String str) {
        InputStream resourceAsStream = PhoneNumberToTimeZonesMapper.class.getResourceAsStream(str);
        PrefixTimeZonesMap prefixTimeZonesMap2 = new PrefixTimeZonesMap();
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(resourceAsStream);
            try {
                prefixTimeZonesMap2.readExternal(objectInputStream2);
                close(objectInputStream2);
            } catch (IOException e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    logger.log(Level.WARNING, e.toString());
                    close(objectInputStream);
                    return prefixTimeZonesMap2;
                } catch (Throwable th) {
                    th = th;
                    close(objectInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                close(objectInputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            logger.log(Level.WARNING, e.toString());
            close(objectInputStream);
            return prefixTimeZonesMap2;
        }
        return prefixTimeZonesMap2;
    }

    public List<String> getTimeZonesForGeographicalNumber(Phonenumber.PhoneNumber phoneNumber) {
        return getTimeZonesForGeocodableNumber(phoneNumber);
    }

    public List<String> getTimeZonesForNumber(Phonenumber.PhoneNumber phoneNumber) {
        PhoneNumberUtil.PhoneNumberType numberType = PhoneNumberUtil.getInstance().getNumberType(phoneNumber);
        return numberType == PhoneNumberUtil.PhoneNumberType.UNKNOWN ? UNKNOWN_TIME_ZONE_LIST : !PhoneNumberUtil.getInstance().isNumberGeographical(numberType, phoneNumber.getCountryCode()) ? getCountryLevelTimeZonesforNumber(phoneNumber) : getTimeZonesForGeographicalNumber(phoneNumber);
    }

    public PhoneNumberToTimeZonesMapper(String str) {
        this.prefixTimeZonesMap = null;
        this.prefixTimeZonesMap = loadPrefixTimeZonesMapFromFile(str + MAPPING_DATA_FILE_NAME);
    }

    private PhoneNumberToTimeZonesMapper(PrefixTimeZonesMap prefixTimeZonesMap2) {
        this.prefixTimeZonesMap = prefixTimeZonesMap2;
    }
}
