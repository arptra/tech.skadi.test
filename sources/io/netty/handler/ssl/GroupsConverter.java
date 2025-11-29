package io.netty.handler.ssl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class GroupsConverter {
    private static final Map<String, String> mappings;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("secp224r1", "P-224");
        hashMap.put("prime256v1", "P-256");
        hashMap.put("secp256r1", "P-256");
        hashMap.put("secp384r1", "P-384");
        hashMap.put("secp521r1", "P-521");
        hashMap.put("x25519", "X25519");
        mappings = Collections.unmodifiableMap(hashMap);
    }

    private GroupsConverter() {
    }

    public static String toOpenSsl(String str) {
        String str2 = mappings.get(str);
        return str2 == null ? str : str2;
    }
}
