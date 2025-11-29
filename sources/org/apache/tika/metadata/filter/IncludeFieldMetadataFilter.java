package org.apache.tika.metadata.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

public class IncludeFieldMetadataFilter extends MetadataFilter {
    private final Set<String> includeSet;

    public IncludeFieldMetadataFilter() {
        this(new HashSet());
    }

    public void filter(Metadata metadata) throws TikaException {
        for (String str : metadata.names()) {
            if (!this.includeSet.contains(str)) {
                metadata.remove(str);
            }
        }
    }

    @Field
    public void setInclude(List<String> list) {
        this.includeSet.addAll(list);
    }

    public IncludeFieldMetadataFilter(Set<String> set) {
        this.includeSet = set;
    }
}
