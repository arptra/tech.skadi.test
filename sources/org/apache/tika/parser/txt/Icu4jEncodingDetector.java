package org.apache.tika.parser.txt;

import com.ucar.databus.proto.UCarProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.utils.CharsetUtils;

public class Icu4jEncodingDetector implements EncodingDetector {
    private Set<String> ignoreCharsets = new HashSet();
    @Field
    private int markLimit = UCarProto.SampleRate.SAMPLE_RATE_12000_VALUE;
    @Field
    private boolean stripMarkup = false;

    public Charset detect(InputStream inputStream, Metadata metadata) throws IOException {
        String a2;
        MediaType parse;
        if (inputStream == null) {
            return null;
        }
        CharsetDetector charsetDetector = new CharsetDetector(this.markLimit);
        String str = metadata.get("Content-Encoding");
        String str2 = metadata.get("Content-Type");
        if (!(str != null || str2 == null || (parse = MediaType.parse(str2)) == null)) {
            str = parse.getParameters().get("charset");
        }
        if (!(str == null || (a2 = CharsetUtils.a(str)) == null)) {
            charsetDetector.e(a2);
        }
        charsetDetector.c(true);
        charsetDetector.f(inputStream);
        CharsetMatch[] b = charsetDetector.b();
        int length = b.length;
        int i = 0;
        while (i < length) {
            CharsetMatch charsetMatch = b[i];
            try {
                if (!this.ignoreCharsets.contains(charsetMatch.g())) {
                    return CharsetUtils.b(charsetMatch.g());
                }
                i++;
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public List<String> getIgnoreCharsets() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.ignoreCharsets);
        Collections.sort(arrayList);
        return arrayList;
    }

    public int getMarkLimit() {
        return this.markLimit;
    }

    public int getMarkLimt() {
        return this.markLimit;
    }

    public boolean isStripMarkup() {
        return this.stripMarkup;
    }

    @Field
    public void setIgnoreCharsets(List<String> list) {
        this.ignoreCharsets.addAll(list);
    }

    @Field
    public void setMarkLimit(int i) {
        this.markLimit = i;
    }

    @Field
    public void setStripMarkup(boolean z) {
        this.stripMarkup = z;
    }
}
