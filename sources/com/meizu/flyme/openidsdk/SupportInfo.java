package com.meizu.flyme.openidsdk;

import android.text.TextUtils;

class SupportInfo {
    public Boolean support;
    public String version;

    public boolean isCached() {
        return this.support != null;
    }

    public boolean isSameVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.version, str);
    }

    public boolean isSupport() {
        Boolean bool = this.support;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setSupport(boolean z) {
        this.support = Boolean.valueOf(z);
    }

    public void setVersionName(String str) {
        this.version = str;
    }
}
