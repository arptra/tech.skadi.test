package com.upuphone.xr.account;

public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final Boolean COUNTRY_INTL;
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "intl";
    public static final String LIBRARY_PACKAGE_NAME = "com.upuphone.xr.account";
    public static final Boolean THIRD_PLATFOM;

    static {
        Boolean bool = Boolean.TRUE;
        COUNTRY_INTL = bool;
        THIRD_PLATFOM = bool;
    }
}
