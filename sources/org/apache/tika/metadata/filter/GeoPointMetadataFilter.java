package org.apache.tika.metadata.filter;

import com.meizu.common.widget.MzContactsContract;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

public class GeoPointMetadataFilter extends MetadataFilter {
    String geoPointFieldName = "location";

    public void filter(Metadata metadata) throws TikaException {
        String str = metadata.get(TikaCoreProperties.S);
        if (!StringUtils.b(str)) {
            String str2 = metadata.get(TikaCoreProperties.T);
            if (!StringUtils.b(str2)) {
                String str3 = this.geoPointFieldName;
                metadata.set(str3, str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + str2);
            }
        }
    }

    @Field
    public void setGeoPointFieldName(String str) {
        this.geoPointFieldName = str;
    }
}
