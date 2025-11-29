package io.netty.handler.codec.http.cookie;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.ObjectUtil;

public class DefaultCookie implements Cookie {
    private String domain;
    private boolean httpOnly;
    private long maxAge = Long.MIN_VALUE;
    private final String name;
    private String path;
    private CookieHeaderNames.SameSite sameSite;
    private boolean secure;
    private String value;
    private boolean wrap;

    public DefaultCookie(String str, String str2) {
        this.name = ObjectUtil.checkNonEmptyAfterTrim(str, "name");
        setValue(str2);
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (!name().equals(cookie.name())) {
            return false;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return false;
            }
        } else if (cookie.path() == null || !path().equals(cookie.path())) {
            return false;
        }
        return domain() == null ? cookie.domain() == null : domain().equalsIgnoreCase(cookie.domain());
    }

    public int hashCode() {
        return name().hashCode();
    }

    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public long maxAge() {
        return this.maxAge;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public CookieHeaderNames.SameSite sameSite() {
        return this.sameSite;
    }

    public void setDomain(String str) {
        this.domain = CookieUtil.validateAttributeValue("domain", str);
    }

    public void setHttpOnly(boolean z) {
        this.httpOnly = z;
    }

    public void setMaxAge(long j) {
        this.maxAge = j;
    }

    public void setPath(String str) {
        this.path = CookieUtil.validateAttributeValue("path", str);
    }

    public void setSameSite(CookieHeaderNames.SameSite sameSite2) {
        this.sameSite = sameSite2;
    }

    public void setSecure(boolean z) {
        this.secure = z;
    }

    public void setValue(String str) {
        this.value = (String) ObjectUtil.checkNotNull(str, AccountConstantKt.RESPONSE_VALUE);
    }

    public void setWrap(boolean z) {
        this.wrap = z;
    }

    public String toString() {
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        stringBuilder.append(name());
        stringBuilder.append('=');
        stringBuilder.append(value());
        if (domain() != null) {
            stringBuilder.append(", domain=");
            stringBuilder.append(domain());
        }
        if (path() != null) {
            stringBuilder.append(", path=");
            stringBuilder.append(path());
        }
        if (maxAge() >= 0) {
            stringBuilder.append(", maxAge=");
            stringBuilder.append(maxAge());
            stringBuilder.append('s');
        }
        if (isSecure()) {
            stringBuilder.append(", secure");
        }
        if (isHttpOnly()) {
            stringBuilder.append(", HTTPOnly");
        }
        if (sameSite() != null) {
            stringBuilder.append(", SameSite=");
            stringBuilder.append(sameSite());
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public String validateValue(String str, String str2) {
        return CookieUtil.validateAttributeValue(str, str2);
    }

    public String value() {
        return this.value;
    }

    public boolean wrap() {
        return this.wrap;
    }

    public int compareTo(Cookie cookie) {
        int compareTo = name().compareTo(cookie.name());
        if (compareTo != 0) {
            return compareTo;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return -1;
            }
        } else if (cookie.path() == null) {
            return 1;
        } else {
            int compareTo2 = path().compareTo(cookie.path());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        if (domain() == null) {
            if (cookie.domain() != null) {
                return -1;
            }
            return 0;
        } else if (cookie.domain() == null) {
            return 1;
        } else {
            return domain().compareToIgnoreCase(cookie.domain());
        }
    }
}
