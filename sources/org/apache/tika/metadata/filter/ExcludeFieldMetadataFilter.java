package org.apache.tika.metadata.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

public class ExcludeFieldMetadataFilter extends MetadataFilter {
    private final Set<String> excludeSet;

    public ExcludeFieldMetadataFilter() {
        this(new HashSet());
    }

    public void filter(Metadata metadata) throws TikaException {
        for (String remove : this.excludeSet) {
            metadata.remove(remove);
        }
    }

    @Field
    public void setExclude(List<String> list) {
        this.excludeSet.addAll(list);
    }

    public ExcludeFieldMetadataFilter(Set<String> set) {
        this.excludeSet = set;
    }
}
