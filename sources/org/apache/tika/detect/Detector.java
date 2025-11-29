package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

public interface Detector extends Serializable {
    MediaType detect(InputStream inputStream, Metadata metadata) throws IOException;
}
