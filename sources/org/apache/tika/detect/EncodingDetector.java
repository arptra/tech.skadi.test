package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.apache.tika.metadata.Metadata;

public interface EncodingDetector extends Serializable {
    Charset detect(InputStream inputStream, Metadata metadata) throws IOException;
}
