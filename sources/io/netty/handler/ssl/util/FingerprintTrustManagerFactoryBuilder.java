package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FingerprintTrustManagerFactoryBuilder {
    private final String algorithm;
    private final List<String> fingerprints = new ArrayList();

    public FingerprintTrustManagerFactoryBuilder(String str) {
        this.algorithm = (String) ObjectUtil.checkNotNull(str, "algorithm");
    }

    public FingerprintTrustManagerFactory build() {
        if (!this.fingerprints.isEmpty()) {
            return new FingerprintTrustManagerFactory(this.algorithm, FingerprintTrustManagerFactory.toFingerprintArray(this.fingerprints));
        }
        throw new IllegalStateException("No fingerprints provided");
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(CharSequence... charSequenceArr) {
        return fingerprints((Iterable<? extends CharSequence>) Arrays.asList((Object[]) ObjectUtil.checkNotNull(charSequenceArr, "fingerprints")));
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(iterable, "fingerprints");
        for (CharSequence charSequence : iterable) {
            ObjectUtil.checkNotNullWithIAE(charSequence, "fingerprint");
            this.fingerprints.add(charSequence.toString());
        }
        return this;
    }
}
