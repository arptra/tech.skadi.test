package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;

final class CompositeMetadataContainer implements MetadataContainer {
    private final MapBackedMetadataContainer<Integer> metadataByCountryCode = MapBackedMetadataContainer.byCountryCallingCode();
    private final MapBackedMetadataContainer<String> metadataByRegionCode = MapBackedMetadataContainer.byRegionCode();

    public void accept(Phonemetadata.PhoneMetadata phoneMetadata) {
        if (GeoEntityUtility.isGeoEntity(this.metadataByRegionCode.getKeyProvider().getKeyOf(phoneMetadata))) {
            this.metadataByRegionCode.accept(phoneMetadata);
        } else {
            this.metadataByCountryCode.accept(phoneMetadata);
        }
    }

    public Phonemetadata.PhoneMetadata getMetadataBy(String str) {
        return this.metadataByRegionCode.getMetadataBy(str);
    }

    public Phonemetadata.PhoneMetadata getMetadataBy(int i) {
        return this.metadataByCountryCode.getMetadataBy(Integer.valueOf(i));
    }
}
