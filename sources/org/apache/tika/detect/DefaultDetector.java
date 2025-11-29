package org.apache.tika.detect;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.utils.ServiceLoaderUtils;

public class DefaultDetector extends CompositeDetector {
    private static final long serialVersionUID = -8170114575326908027L;
    private final transient ServiceLoader loader;

    public DefaultDetector(MimeTypes mimeTypes, ServiceLoader serviceLoader, Collection<Class<? extends Detector>> collection) {
        super(mimeTypes.getMediaTypeRegistry(), getDefaultDetectors(mimeTypes, serviceLoader, collection));
        this.loader = serviceLoader;
    }

    private static List<Detector> getDefaultDetectors(MimeTypes mimeTypes, ServiceLoader serviceLoader, Collection<Class<? extends Detector>> collection) {
        List<Detector> n = serviceLoader.n(Detector.class, collection);
        ServiceLoaderUtils.b(n);
        Iterator<Detector> it = n.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next() instanceof OverrideDetector) {
                break;
            } else {
                i++;
            }
        }
        if (i > -1) {
            n.add(0, n.remove(i));
        }
        n.add(mimeTypes);
        return n;
    }

    public List<Detector> getDetectors() {
        ServiceLoader serviceLoader = this.loader;
        if (serviceLoader == null || !serviceLoader.j()) {
            return super.getDetectors();
        }
        List<Detector> k = this.loader.k(Detector.class);
        if (k.size() <= 0) {
            return super.getDetectors();
        }
        k.addAll(super.getDetectors());
        return k;
    }

    public DefaultDetector(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
        this(mimeTypes, serviceLoader, Collections.EMPTY_SET);
    }

    public DefaultDetector(MimeTypes mimeTypes, ClassLoader classLoader) {
        this(mimeTypes, new ServiceLoader(classLoader));
    }

    public DefaultDetector(ClassLoader classLoader) {
        this(MimeTypes.getDefaultMimeTypes(), classLoader);
    }

    public DefaultDetector(MimeTypes mimeTypes) {
        this(mimeTypes, new ServiceLoader());
    }

    public DefaultDetector() {
        this(MimeTypes.getDefaultMimeTypes());
    }
}
