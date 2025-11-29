package org.apache.tika.extractor;

import java.io.InputStream;
import org.apache.tika.mime.MediaType;

public interface EmbeddedResourceHandler {
    void a(String str, MediaType mediaType, InputStream inputStream);
}
