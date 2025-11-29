package com.upuphone.starrynet.strategy.encrypt;

import androidx.collection.LruCache;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;

public final class StarryNetEncryptData {
    private static final String M_IV_PARAM_V2 = "0102030405060708";
    private final LruCache<String, KeyPair> mKeyPairMap;
    private KeyPair mKeyPairV2;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryNetEncryptData INSTANCE = new StarryNetEncryptData();

        private Holder() {
        }
    }

    public static StarryNetEncryptData getInstance() {
        return Holder.INSTANCE;
    }

    public String getIvParamV2() {
        return "0102030405060708";
    }

    public KeyPair getKeyPair(String str) {
        return this.mKeyPairMap.remove(str);
    }

    public KeyPair getKeyPairV2() {
        return this.mKeyPairV2;
    }

    public void saveKeyPair(String str, KeyPair keyPair) {
        this.mKeyPairMap.put(str, keyPair);
    }

    public void setKeyPairV2(KeyPair keyPair) {
        this.mKeyPairV2 = keyPair;
    }

    private StarryNetEncryptData() {
        this.mKeyPairMap = new LruCache<>(64);
    }
}
