package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;

@Deprecated
public class OverrideDetector implements Detector {
    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        String str = metadata.get(TikaCoreProperties.x);
        if (str != null) {
            return MediaType.parse(str);
        }
        String str2 = metadata.get(TikaCoreProperties.w);
        return str2 != null ? MediaType.parse(str2) : MediaType.OCTET_STREAM;
    }
}
