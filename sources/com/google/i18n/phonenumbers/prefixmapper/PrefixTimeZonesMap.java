package com.google.i18n.phonenumbers.prefixmapper;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class PrefixTimeZonesMap implements Externalizable {
    private static final String RAW_STRING_TIMEZONES_SEPARATOR = "&";
    private final PhonePrefixMap phonePrefixMap = new PhonePrefixMap();

    private List<String> lookupTimeZonesForNumber(long j) {
        String lookup = this.phonePrefixMap.lookup(j);
        if (lookup == null) {
            return new LinkedList();
        }
        return tokenizeRawOutputString(lookup);
    }

    private List<String> tokenizeRawOutputString(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, RAW_STRING_TIMEZONES_SEPARATOR);
        LinkedList linkedList = new LinkedList();
        while (stringTokenizer.hasMoreTokens()) {
            linkedList.add(stringTokenizer.nextToken());
        }
        return linkedList;
    }

    public List<String> lookupCountryLevelTimeZonesForNumber(Phonenumber.PhoneNumber phoneNumber) {
        return lookupTimeZonesForNumber((long) phoneNumber.getCountryCode());
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.phonePrefixMap.readExternal(objectInput);
    }

    public void readPrefixTimeZonesMap(SortedMap<Integer, String> sortedMap) {
        this.phonePrefixMap.readPhonePrefixMap(sortedMap);
    }

    public String toString() {
        return this.phonePrefixMap.toString();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        this.phonePrefixMap.writeExternal(objectOutput);
    }

    public List<String> lookupTimeZonesForNumber(Phonenumber.PhoneNumber phoneNumber) {
        return lookupTimeZonesForNumber(Long.parseLong(phoneNumber.getCountryCode() + PhoneNumberUtil.getInstance().getNationalSignificantNumber(phoneNumber)));
    }
}
