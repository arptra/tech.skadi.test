package org.apache.tika.metadata.filter;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

public class FieldNameMappingFilter extends MetadataFilter {
    boolean excludeUnmapped = true;
    Map<String, String> mappings = new LinkedHashMap();

    public void filter(Metadata metadata) throws TikaException {
        if (this.excludeUnmapped) {
            for (String str : metadata.names()) {
                if (this.mappings.containsKey(str)) {
                    String[] values = metadata.getValues(str);
                    metadata.remove(str);
                    for (String add : values) {
                        metadata.add(this.mappings.get(str), add);
                    }
                } else {
                    metadata.remove(str);
                }
            }
            return;
        }
        for (String str2 : metadata.names()) {
            if (this.mappings.containsKey(str2)) {
                String[] values2 = metadata.getValues(str2);
                metadata.remove(str2);
                for (String add2 : values2) {
                    metadata.add(this.mappings.get(str2), add2);
                }
            }
        }
    }

    @Field
    public void setExcludeUnmapped(boolean z) {
        this.excludeUnmapped = z;
    }

    @Field
    public void setMappings(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            this.mappings.put((String) next.getKey(), (String) next.getValue());
        }
    }
}
