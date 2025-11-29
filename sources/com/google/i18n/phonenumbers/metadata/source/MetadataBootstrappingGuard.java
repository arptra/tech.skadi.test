package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;

public interface MetadataBootstrappingGuard<T extends MetadataContainer> {
    T getOrBootstrap(String str);
}
