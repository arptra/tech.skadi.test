package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class MapBackedMetadataContainer<T> implements MetadataContainer {
    private final KeyProvider<T> keyProvider;
    private final ConcurrentMap<T, Phonemetadata.PhoneMetadata> metadataMap = new ConcurrentHashMap();

    public interface KeyProvider<T> {
        T getKeyOf(Phonemetadata.PhoneMetadata phoneMetadata);
    }

    private MapBackedMetadataContainer(KeyProvider<T> keyProvider2) {
        this.keyProvider = keyProvider2;
    }

    public static MapBackedMetadataContainer<Integer> byCountryCallingCode() {
        return new MapBackedMetadataContainer<>(new KeyProvider<Integer>() {
            public Integer getKeyOf(Phonemetadata.PhoneMetadata phoneMetadata) {
                return Integer.valueOf(phoneMetadata.getCountryCode());
            }
        });
    }

    public static MapBackedMetadataContainer<String> byRegionCode() {
        return new MapBackedMetadataContainer<>(new KeyProvider<String>() {
            public String getKeyOf(Phonemetadata.PhoneMetadata phoneMetadata) {
                return phoneMetadata.getId();
            }
        });
    }

    public void accept(Phonemetadata.PhoneMetadata phoneMetadata) {
        this.metadataMap.put(this.keyProvider.getKeyOf(phoneMetadata), phoneMetadata);
    }

    public KeyProvider<T> getKeyProvider() {
        return this.keyProvider;
    }

    public Phonemetadata.PhoneMetadata getMetadataBy(T t) {
        if (t != null) {
            return this.metadataMap.get(t);
        }
        return null;
    }
}
