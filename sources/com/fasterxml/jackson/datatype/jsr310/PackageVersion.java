package com.fasterxml.jackson.datatype.jsr310;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion("2.9.9", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310");

    public Version version() {
        return VERSION;
    }
}
