package com.upuphone.ar.tici.phone.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig;", "", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;", "b", "Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;", "getHostProvider", "()Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;", "(Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;)V", "hostProvider", "", "a", "()Ljava/lang/String;", "fileTipsUrl", "HostProvider", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciHostConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final TiciHostConfig f6003a = new TiciHostConfig();
    public static HostProvider b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;", "", "", "a", "()Ljava/lang/String;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public interface HostProvider {
        String a();
    }

    public final String a() {
        String str;
        HostProvider hostProvider = b;
        if (hostProvider == null || (str = hostProvider.a()) == null) {
            str = "";
        }
        return str + "/#/help/prompt/export-tutorial";
    }

    public final void b(HostProvider hostProvider) {
        b = hostProvider;
    }
}
