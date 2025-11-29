package com.meizu.flyme.openidsdk;

import org.apache.commons.lang3.time.DateUtils;

class ValueData {
    public int code;
    public long expired = (System.currentTimeMillis() + DateUtils.MILLIS_PER_DAY);
    public String value;

    public ValueData(String str, int i) {
        this.value = str;
        this.code = i;
    }

    public String toString() {
        return "ValueData{value='" + this.value + '\'' + ", code=" + this.code + ", expired=" + this.expired + '}';
    }
}
