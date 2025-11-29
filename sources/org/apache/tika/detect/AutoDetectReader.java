package org.apache.tika.detect;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.config.LoadErrorHandler;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.utils.CharsetUtils;

public class AutoDetectReader extends BufferedReader {
    public static final ServiceLoader b;
    public static final EncodingDetector c;

    /* renamed from: a  reason: collision with root package name */
    public final Charset f10055a;

    static {
        ServiceLoader serviceLoader = new ServiceLoader(AutoDetectReader.class.getClassLoader());
        b = serviceLoader;
        c = new CompositeEncodingDetector(serviceLoader.l(EncodingDetector.class));
    }

    public AutoDetectReader(InputStream inputStream, Charset charset) {
        super(new InputStreamReader(inputStream, charset));
        this.f10055a = charset;
        mark(1);
        if (read() != 65279) {
            reset();
        }
    }

    public static Charset a(InputStream inputStream, Metadata metadata, List list, LoadErrorHandler loadErrorHandler) {
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EncodingDetector encodingDetector = (EncodingDetector) it.next();
            try {
                Charset detect = encodingDetector.detect(inputStream, metadata);
                if (detect != null) {
                    return detect;
                }
            } catch (NoClassDefFoundError e) {
                loadErrorHandler.a(encodingDetector.getClass().getName(), e);
            }
        }
        MediaType parse = MediaType.parse(metadata.get("Content-Type"));
        if (!(parse == null || (str = parse.getParameters().get("charset")) == null)) {
            try {
                return CharsetUtils.b(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        throw new TikaException("Failed to detect the character encoding of a document");
    }

    public static InputStream b(InputStream inputStream) {
        return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }

    public Charset c() {
        return this.f10055a;
    }

    public AutoDetectReader(InputStream inputStream, Metadata metadata, List list, LoadErrorHandler loadErrorHandler) {
        this(inputStream, a(inputStream, metadata, list, loadErrorHandler));
    }

    public AutoDetectReader(InputStream inputStream, Metadata metadata, EncodingDetector encodingDetector) {
        this(b(inputStream), metadata, Collections.singletonList(encodingDetector), b.e());
    }
}
