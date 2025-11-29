package org.apache.tika.metadata.filter;

import java.util.List;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.utils.ServiceLoaderUtils;

public class DefaultMetadataFilter extends CompositeMetadataFilter {
    public DefaultMetadataFilter(ServiceLoader serviceLoader) {
        super(getDefaultFilters(serviceLoader));
    }

    private static List<MetadataFilter> getDefaultFilters(ServiceLoader serviceLoader) {
        List<MetadataFilter> m = serviceLoader.m(MetadataFilter.class);
        ServiceLoaderUtils.b(m);
        return m;
    }

    public DefaultMetadataFilter(List<MetadataFilter> list) {
        super(list);
    }

    public DefaultMetadataFilter() {
        this(new ServiceLoader());
    }
}
