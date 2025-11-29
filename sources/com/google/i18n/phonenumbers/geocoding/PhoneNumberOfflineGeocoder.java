package com.google.i18n.phonenumbers.geocoding;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.prefixmapper.PrefixFileReader;
import java.util.List;
import java.util.Locale;

public class PhoneNumberOfflineGeocoder {
    private static PhoneNumberOfflineGeocoder instance;
    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    private final PrefixFileReader prefixFileReader;

    public PhoneNumberOfflineGeocoder(String str) {
        this.prefixFileReader = new PrefixFileReader(str);
    }

    private String getCountryNameForNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        List<String> regionCodesForCountryCode = this.phoneUtil.getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        if (regionCodesForCountryCode.size() == 1) {
            return getRegionDisplayName(regionCodesForCountryCode.get(0), locale);
        }
        String str = "ZZ";
        for (String next : regionCodesForCountryCode) {
            if (this.phoneUtil.isValidNumberForRegion(phoneNumber, next)) {
                if (!str.equals("ZZ")) {
                    return "";
                }
                str = next;
            }
        }
        return getRegionDisplayName(str, locale);
    }

    public static synchronized PhoneNumberOfflineGeocoder getInstance() {
        PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder;
        synchronized (PhoneNumberOfflineGeocoder.class) {
            try {
                if (instance == null) {
                    instance = new PhoneNumberOfflineGeocoder(DefaultMetadataDependenciesProvider.getInstance().getGeocodingDataDirectory());
                }
                phoneNumberOfflineGeocoder = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberOfflineGeocoder;
    }

    private String getRegionDisplayName(String str, Locale locale) {
        return (str == null || str.equals("ZZ") || str.equals("001")) ? "" : new Locale("", str).getDisplayCountry(locale);
    }

    public String getDescriptionForNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        PhoneNumberUtil.PhoneNumberType numberType = this.phoneUtil.getNumberType(phoneNumber);
        if (numberType == PhoneNumberUtil.PhoneNumberType.UNKNOWN) {
            return "";
        }
        if (!this.phoneUtil.isNumberGeographical(numberType, phoneNumber.getCountryCode())) {
            return getCountryNameForNumber(phoneNumber, locale);
        }
        return getDescriptionForValidNumber(phoneNumber, locale);
    }

    public String getDescriptionForValidNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        String str;
        Phonenumber.PhoneNumber phoneNumber2;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String countryMobileToken = PhoneNumberUtil.getCountryMobileToken(phoneNumber.getCountryCode());
        String nationalSignificantNumber = this.phoneUtil.getNationalSignificantNumber(phoneNumber);
        if (countryMobileToken.equals("") || !nationalSignificantNumber.startsWith(countryMobileToken)) {
            str = this.prefixFileReader.getDescriptionForNumber(phoneNumber, language, "", country);
        } else {
            try {
                phoneNumber2 = this.phoneUtil.parse(nationalSignificantNumber.substring(countryMobileToken.length()), this.phoneUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()));
            } catch (NumberParseException unused) {
                phoneNumber2 = phoneNumber;
            }
            str = this.prefixFileReader.getDescriptionForNumber(phoneNumber2, language, "", country);
        }
        return str.length() > 0 ? str : getCountryNameForNumber(phoneNumber, locale);
    }

    public String getDescriptionForNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale, String str) {
        PhoneNumberUtil.PhoneNumberType numberType = this.phoneUtil.getNumberType(phoneNumber);
        if (numberType == PhoneNumberUtil.PhoneNumberType.UNKNOWN) {
            return "";
        }
        if (!this.phoneUtil.isNumberGeographical(numberType, phoneNumber.getCountryCode())) {
            return getCountryNameForNumber(phoneNumber, locale);
        }
        return getDescriptionForValidNumber(phoneNumber, locale, str);
    }

    public String getDescriptionForValidNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale, String str) {
        String regionCodeForNumber = this.phoneUtil.getRegionCodeForNumber(phoneNumber);
        if (str.equals(regionCodeForNumber)) {
            return getDescriptionForValidNumber(phoneNumber, locale);
        }
        return getRegionDisplayName(regionCodeForNumber, locale);
    }
}
