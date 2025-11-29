package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.MetadataLoader;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ClassPathResourceMetadataLoader implements MetadataLoader {
    private static final Logger logger = Logger.getLogger(ClassPathResourceMetadataLoader.class.getName());

    public InputStream loadMetadata(String str) {
        InputStream resourceAsStream = ClassPathResourceMetadataLoader.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            logger.log(Level.WARNING, String.format("File %s not found", new Object[]{str}));
        }
        return resourceAsStream;
    }
}
