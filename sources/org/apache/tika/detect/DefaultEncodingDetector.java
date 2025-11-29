package org.apache.tika.detect;

import java.util.Collection;
import org.apache.tika.config.ServiceLoader;

public class DefaultEncodingDetector extends CompositeEncodingDetector {
    public DefaultEncodingDetector() {
        this(new ServiceLoader(DefaultEncodingDetector.class.getClassLoader()));
    }

    public DefaultEncodingDetector(ServiceLoader serviceLoader) {
        super(serviceLoader.l(EncodingDetector.class));
    }

    public DefaultEncodingDetector(ServiceLoader serviceLoader, Collection<Class<? extends EncodingDetector>> collection) {
        super(serviceLoader.l(EncodingDetector.class), collection);
    }
}
