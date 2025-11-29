package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.prefixmapper.PrefixFileReader;
import java.util.Locale;

public class PhoneNumberToCarrierMapper {
    private static PhoneNumberToCarrierMapper instance;
    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    private final PrefixFileReader prefixFileReader;

    public PhoneNumberToCarrierMapper(String str) {
        this.prefixFileReader = new PrefixFileReader(str);
    }

    public static synchronized PhoneNumberToCarrierMapper getInstance() {
        PhoneNumberToCarrierMapper phoneNumberToCarrierMapper;
        synchronized (PhoneNumberToCarrierMapper.class) {
            try {
                if (instance == null) {
                    instance = new PhoneNumberToCarrierMapper(DefaultMetadataDependenciesProvider.getInstance().getCarrierDataDirectory());
                }
                phoneNumberToCarrierMapper = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberToCarrierMapper;
    }

    private boolean isMobile(PhoneNumberUtil.PhoneNumberType phoneNumberType) {
        return phoneNumberType == PhoneNumberUtil.PhoneNumberType.MOBILE || phoneNumberType == PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE || phoneNumberType == PhoneNumberUtil.PhoneNumberType.PAGER;
    }

    public String getNameForNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        return isMobile(this.phoneUtil.getNumberType(phoneNumber)) ? getNameForValidNumber(phoneNumber, locale) : "";
    }

    public String getNameForValidNumber(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        return this.prefixFileReader.getDescriptionForNumber(phoneNumber, locale.getLanguage(), "", locale.getCountry());
    }

    public String getSafeDisplayName(Phonenumber.PhoneNumber phoneNumber, Locale locale) {
        PhoneNumberUtil phoneNumberUtil = this.phoneUtil;
        return phoneNumberUtil.isMobileNumberPortableRegion(phoneNumberUtil.getRegionCodeForNumber(phoneNumber)) ? "" : getNameForNumber(phoneNumber, locale);
    }
}
