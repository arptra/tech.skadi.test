package org.apache.tika.metadata.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

public class ClearByMimeMetadataFilter extends MetadataFilter {
    private final Set<String> mimes;

    public ClearByMimeMetadataFilter() {
        this(new HashSet());
    }

    public void filter(Metadata metadata) throws TikaException {
        String str = metadata.get("Content-Type");
        if (str != null) {
            MediaType parse = MediaType.parse(str);
            if (parse != null) {
                str = parse.getBaseType().toString();
            }
            if (this.mimes.contains(str)) {
                for (String remove : metadata.names()) {
                    metadata.remove(remove);
                }
            }
        }
    }

    @Field
    public void setMimes(List<String> list) {
        this.mimes.addAll(list);
    }

    public ClearByMimeMetadataFilter(Set<String> set) {
        this.mimes = set;
    }
}
