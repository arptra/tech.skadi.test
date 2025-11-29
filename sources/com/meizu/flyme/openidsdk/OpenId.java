package com.meizu.flyme.openidsdk;

class OpenId {
    public int code;
    public long expiredTime;
    public String type;
    public String value;

    public OpenId(String str) {
        this.type = str;
    }

    public boolean isValid() {
        return this.expiredTime > System.currentTimeMillis();
    }

    public void setDataExpired() {
        this.expiredTime = 0;
    }

    public void updateCode(int i) {
        this.code = i;
    }

    public void updateExpiredTime(long j) {
        this.expiredTime = j;
    }

    public void updateValue(String str) {
        this.value = str;
    }
}
