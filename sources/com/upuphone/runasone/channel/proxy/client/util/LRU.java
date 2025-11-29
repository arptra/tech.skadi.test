package com.upuphone.runasone.channel.proxy.client.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1;
    private RemoveListener mRemoveListener;
    private int maxSize;

    public interface RemoveListener<KK, VV> {
        void onRemove(Map.Entry<KK, VV> entry);
    }

    public LRU(int i, float f, boolean z, int i2) {
        super(i, f, z);
        this.maxSize = i2;
    }

    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() <= this.maxSize) {
            return false;
        }
        RemoveListener removeListener = this.mRemoveListener;
        if (removeListener == null) {
            return true;
        }
        removeListener.onRemove(entry);
        return true;
    }

    public void setRemoveListener(RemoveListener removeListener) {
        this.mRemoveListener = removeListener;
    }
}
