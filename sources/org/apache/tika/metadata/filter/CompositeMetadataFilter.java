package org.apache.tika.metadata.filter;

import java.util.List;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

public class CompositeMetadataFilter extends MetadataFilter {
    private final List<MetadataFilter> filters;

    public CompositeMetadataFilter(List<MetadataFilter> list) {
        this.filters = list;
    }

    public void filter(Metadata metadata) throws TikaException {
        for (MetadataFilter filter : this.filters) {
            filter.filter(metadata);
        }
    }
}
