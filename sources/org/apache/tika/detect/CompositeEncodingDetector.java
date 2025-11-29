package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.tika.metadata.Metadata;

public class CompositeEncodingDetector implements EncodingDetector, Serializable {
    private static final long serialVersionUID = 5980683158436430252L;
    private final List<EncodingDetector> detectors;

    public CompositeEncodingDetector(List<EncodingDetector> list, Collection<Class<? extends EncodingDetector>> collection) {
        this.detectors = new LinkedList();
        for (EncodingDetector next : list) {
            if (!isExcluded(collection, next.getClass())) {
                this.detectors.add(next);
            }
        }
    }

    private boolean assignableFrom(Collection<Class<? extends EncodingDetector>> collection, Class<? extends EncodingDetector> cls) {
        for (Class<? extends EncodingDetector> isAssignableFrom : collection) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExcluded(Collection<Class<? extends EncodingDetector>> collection, Class<? extends EncodingDetector> cls) {
        return collection.contains(cls) || assignableFrom(collection, cls);
    }

    public Charset detect(InputStream inputStream, Metadata metadata) throws IOException {
        for (EncodingDetector detect : getDetectors()) {
            Charset detect2 = detect.detect(inputStream, metadata);
            if (detect2 != null) {
                return detect2;
            }
        }
        return null;
    }

    public List<EncodingDetector> getDetectors() {
        return Collections.unmodifiableList(this.detectors);
    }

    public CompositeEncodingDetector(List<EncodingDetector> list) {
        LinkedList linkedList = new LinkedList();
        this.detectors = linkedList;
        linkedList.addAll(list);
    }
}
