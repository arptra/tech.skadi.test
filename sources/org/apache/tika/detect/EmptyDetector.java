package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

public class EmptyDetector implements Detector {
    public static final EmptyDetector INSTANCE = new EmptyDetector();

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        return MediaType.OCTET_STREAM;
    }
}
