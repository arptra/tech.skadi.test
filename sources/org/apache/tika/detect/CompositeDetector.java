package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.utils.StringUtils;

public class CompositeDetector implements Detector {
    private static final long serialVersionUID = 5980683158436430252L;
    private final List<Detector> detectors;
    private final MediaTypeRegistry registry;

    public CompositeDetector(MediaTypeRegistry mediaTypeRegistry, List<Detector> list, Collection<Class<? extends Detector>> collection) {
        if (collection == null || collection.isEmpty()) {
            this.detectors = list;
        } else {
            this.detectors = new ArrayList();
            for (Detector next : list) {
                if (!isExcluded(collection, next.getClass())) {
                    this.detectors.add(next);
                }
            }
        }
        this.registry = mediaTypeRegistry;
    }

    private boolean assignableFrom(Collection<Class<? extends Detector>> collection, Class<? extends Detector> cls) {
        for (Class<? extends Detector> isAssignableFrom : collection) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    private static MediaType detectOverrides(Metadata metadata) {
        MediaType parse;
        MediaType parse2;
        String str = metadata.get(TikaCoreProperties.w);
        if (!StringUtils.a(str) && (parse2 = MediaType.parse(str)) != null) {
            return parse2;
        }
        String str2 = metadata.get(TikaCoreProperties.x);
        if (StringUtils.a(str2) || (parse = MediaType.parse(str2)) == null) {
            return null;
        }
        return parse;
    }

    private boolean isExcluded(Collection<Class<? extends Detector>> collection, Class<? extends Detector> cls) {
        return collection.contains(cls) || assignableFrom(collection, cls);
    }

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        MediaType detectOverrides = detectOverrides(metadata);
        if (detectOverrides != null) {
            return detectOverrides;
        }
        MediaType mediaType = MediaType.OCTET_STREAM;
        for (Detector detect : getDetectors()) {
            MediaType detect2 = detect.detect(inputStream, metadata);
            if (this.registry.isSpecializationOf(detect2, mediaType)) {
                mediaType = detect2;
            }
        }
        return mediaType;
    }

    public List<Detector> getDetectors() {
        return Collections.unmodifiableList(this.detectors);
    }

    public CompositeDetector(MediaTypeRegistry mediaTypeRegistry, List<Detector> list) {
        this(mediaTypeRegistry, list, (Collection<Class<? extends Detector>>) null);
    }

    public CompositeDetector(List<Detector> list) {
        this(new MediaTypeRegistry(), list);
    }

    public CompositeDetector(Detector... detectorArr) {
        this((List<Detector>) Arrays.asList(detectorArr));
    }
}
