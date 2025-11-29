package org.apache.tika.extractor;

import java.io.IOException;
import java.io.Serializable;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;

public interface ContainerExtractor extends Serializable {
    void extract(TikaInputStream tikaInputStream, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler) throws IOException, TikaException;

    boolean isSupported(TikaInputStream tikaInputStream) throws IOException;
}
