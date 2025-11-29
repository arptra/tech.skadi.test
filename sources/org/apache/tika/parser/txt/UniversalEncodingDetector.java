package org.apache.tika.parser.txt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.tika.config.Field;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.metadata.Metadata;

public class UniversalEncodingDetector implements EncodingDetector {
    private static final int BUFSIZE = 1024;
    private static final int DEFAULT_MARK_LIMIT = 16384;
    private int markLimit = 16384;

    public Charset detect(InputStream inputStream, Metadata metadata) throws IOException {
        if (inputStream == null) {
            return null;
        }
        inputStream.mark(this.markLimit);
        try {
            UniversalEncodingListener universalEncodingListener = new UniversalEncodingListener(metadata);
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr);
            int i = 0;
            while (read != -1 && i < this.markLimit && !universalEncodingListener.e()) {
                i += read;
                universalEncodingListener.c(bArr, 0, read);
                read = inputStream.read(bArr, 0, Math.min(1024, this.markLimit - i));
            }
            Charset b = universalEncodingListener.b();
            inputStream.reset();
            return b;
        } catch (LinkageError unused) {
            inputStream.reset();
            return null;
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    public int getMarkLimit() {
        return this.markLimit;
    }

    @Field
    public void setMarkLimit(int i) {
        this.markLimit = i;
    }
}
