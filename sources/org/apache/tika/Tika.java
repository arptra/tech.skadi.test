package org.apache.tika;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.language.translate.Translator;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;

public class Tika {

    /* renamed from: a  reason: collision with root package name */
    public final Detector f4131a;
    public final Parser b;
    public final Translator c;
    public int d;

    public Tika(Detector detector, Parser parser) {
        this.d = 100000;
        this.f4131a = detector;
        this.b = parser;
        this.c = TikaConfig.m().B();
    }

    public String a(File file) {
        Metadata metadata = new Metadata();
        TikaInputStream c2 = TikaInputStream.c(file, metadata);
        try {
            String b2 = b(c2, metadata);
            if (c2 != null) {
                c2.close();
            }
            return b2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String b(InputStream inputStream, Metadata metadata) {
        return (inputStream == null || inputStream.markSupported()) ? this.f4131a.detect(inputStream, metadata).toString() : this.f4131a.detect(new BufferedInputStream(inputStream), metadata).toString();
    }

    public String toString() {
        InputStream resourceAsStream;
        String str = null;
        try {
            resourceAsStream = Tika.class.getResourceAsStream("/META-INF/maven/org.apache.tika/tika-core/pom.properties");
            if (resourceAsStream != null) {
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                str = properties.getProperty("version");
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        if (str == null) {
            return "Apache Tika";
        }
        return "Apache Tika " + str;
        throw th;
    }

    public Tika(Detector detector, Parser parser, Translator translator) {
        this.d = 100000;
        this.f4131a = detector;
        this.b = parser;
        this.c = translator;
    }

    public Tika(TikaConfig tikaConfig) {
        this(tikaConfig.u(), new AutoDetectParser(tikaConfig), tikaConfig.B());
    }

    public Tika() {
        this(TikaConfig.m());
    }

    public Tika(Detector detector) {
        this(detector, new AutoDetectParser(detector));
    }
}
