package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class BlockingMetadataBootstrappingGuard<T extends MetadataContainer> implements MetadataBootstrappingGuard<T> {
    private final Map<String, String> loadedFiles = new ConcurrentHashMap();
    private final T metadataContainer;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;

    public BlockingMetadataBootstrappingGuard(MetadataLoader metadataLoader2, MetadataParser metadataParser2, T t) {
        this.metadataLoader = metadataLoader2;
        this.metadataParser = metadataParser2;
        this.metadataContainer = t;
    }

    private synchronized void bootstrapMetadata(String str) {
        try {
            if (!this.loadedFiles.containsKey(str)) {
                for (Phonemetadata.PhoneMetadata accept : read(str)) {
                    this.metadataContainer.accept(accept);
                }
                this.loadedFiles.put(str, str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Collection<Phonemetadata.PhoneMetadata> read(String str) {
        try {
            return this.metadataParser.parse(this.metadataLoader.loadMetadata(str));
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new IllegalStateException("Failed to read file " + str, e);
        }
    }

    public T getOrBootstrap(String str) {
        if (!this.loadedFiles.containsKey(str)) {
            bootstrapMetadata(str);
        }
        return this.metadataContainer;
    }
}
