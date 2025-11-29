package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.config.Field;
import org.apache.tika.metadata.Metadata;

public class NonDetectingEncodingDetector implements EncodingDetector {
    private Charset charset;

    public NonDetectingEncodingDetector() {
        this.charset = StandardCharsets.UTF_8;
    }

    @Field
    private void setCharset(String str) {
        this.charset = Charset.forName(str);
    }

    public Charset detect(InputStream inputStream, Metadata metadata) throws IOException {
        return this.charset;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public NonDetectingEncodingDetector(Charset charset2) {
        Charset charset3 = StandardCharsets.UTF_8;
        this.charset = charset2;
    }
}
