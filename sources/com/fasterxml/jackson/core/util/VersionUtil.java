package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class VersionUtil {
    private static final Pattern V_SEP = Pattern.compile("[-_./;:]");

    private static final void _close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @Deprecated
    public static Version mavenVersionFor(ClassLoader classLoader, String str, String str2) {
        InputStream resourceAsStream = classLoader.getResourceAsStream("META-INF/maven/" + str.replaceAll("\\.", "/") + "/" + str2 + "/pom.properties");
        if (resourceAsStream != null) {
            try {
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                return parseVersion(properties.getProperty("version"), properties.getProperty("groupId"), properties.getProperty("artifactId"));
            } catch (IOException unused) {
            } finally {
                _close(resourceAsStream);
            }
        }
        return Version.unknownVersion();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0048, code lost:
        throw new java.lang.IllegalArgumentException("Failed to get Versioned out of " + r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.core.Version packageVersionFor(java.lang.Class<?> r4) {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049 }
            r1.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.Package r2 = r4.getPackage()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0049 }
            r1.append(r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = ".PackageVersion"
            r1.append(r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0049 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ Exception -> 0x0049 }
            r2 = 1
            java.lang.Class r4 = java.lang.Class.forName(r1, r2, r4)     // Catch:{ Exception -> 0x0049 }
            java.lang.reflect.Constructor r1 = r4.getDeclaredConstructor(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r1 = r1.newInstance(r0)     // Catch:{ Exception -> 0x0032 }
            com.fasterxml.jackson.core.Versioned r1 = (com.fasterxml.jackson.core.Versioned) r1     // Catch:{ Exception -> 0x0032 }
            com.fasterxml.jackson.core.Version r0 = r1.version()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0049
        L_0x0032:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049 }
            r2.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r3 = "Failed to get Versioned out of "
            r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            r2.append(r4)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0049 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0049 }
            throw r1     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            if (r0 != 0) goto L_0x004f
            com.fasterxml.jackson.core.Version r0 = com.fasterxml.jackson.core.Version.unknownVersion()
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.VersionUtil.packageVersionFor(java.lang.Class):com.fasterxml.jackson.core.Version");
    }

    public static Version parseVersion(String str, String str2, String str3) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 0) {
                String[] split = V_SEP.split(trim);
                int i = 0;
                int parseVersionPart = parseVersionPart(split[0]);
                int parseVersionPart2 = split.length > 1 ? parseVersionPart(split[1]) : 0;
                if (split.length > 2) {
                    i = parseVersionPart(split[2]);
                }
                return new Version(parseVersionPart, parseVersionPart2, i, split.length > 3 ? split[3] : null, str2, str3);
            }
        }
        return Version.unknownVersion();
    }

    public static int parseVersionPart(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i = (i * 10) + (charAt - '0');
        }
        return i;
    }

    public static final void throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    public static Version versionFor(Class<?> cls) {
        Version packageVersionFor = packageVersionFor(cls);
        return packageVersionFor == null ? Version.unknownVersion() : packageVersionFor;
    }

    @Deprecated
    public Version version() {
        return Version.unknownVersion();
    }
}
