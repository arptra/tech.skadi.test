package org.apache.tika.parser;

import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.EncodingDetector;

public abstract class AbstractEncodingDetectorParser extends AbstractParser {
    private EncodingDetector encodingDetector;

    public AbstractEncodingDetectorParser() {
        this.encodingDetector = new DefaultEncodingDetector();
    }

    public EncodingDetector getEncodingDetector(ParseContext parseContext) {
        EncodingDetector encodingDetector2 = (EncodingDetector) parseContext.get(EncodingDetector.class);
        if (encodingDetector2 != null) {
            return encodingDetector2;
        }
        return getEncodingDetector();
    }

    public void setEncodingDetector(EncodingDetector encodingDetector2) {
        this.encodingDetector = encodingDetector2;
    }

    public AbstractEncodingDetectorParser(EncodingDetector encodingDetector2) {
        this.encodingDetector = encodingDetector2;
    }

    public EncodingDetector getEncodingDetector() {
        return this.encodingDetector;
    }
}
