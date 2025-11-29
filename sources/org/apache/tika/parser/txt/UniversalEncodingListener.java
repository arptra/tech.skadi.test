package org.apache.tika.parser.txt;

import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.nio.charset.Charset;
import org.apache.tika.detect.TextStatistics;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.utils.CharsetUtils;
import org.mozilla.universalchardet.CharsetListener;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.UniversalDetector;

class UniversalEncodingListener implements CharsetListener {

    /* renamed from: a  reason: collision with root package name */
    public final TextStatistics f3288a = new TextStatistics();
    public final UniversalDetector b = new UniversalDetector(this);
    public String c = null;
    public Charset d = null;

    public UniversalEncodingListener(Metadata metadata) {
        MediaType parse = MediaType.parse(metadata.get("Content-Type"));
        if (parse != null) {
            this.c = parse.getParameters().get("charset");
        }
        if (this.c == null) {
            this.c = metadata.get("Content-Encoding");
        }
    }

    public void a(String str) {
        if (Constants.r.equals(str)) {
            String str2 = this.c;
            if (str2 != null) {
                str = str2;
            } else if (d().booleanValue() || this.f3288a.b(13) == 0) {
                str = this.f3288a.b(164) > 0 ? "ISO-8859-15" : "ISO-8859-1";
            }
        }
        try {
            this.d = CharsetUtils.b(str);
        } catch (IllegalArgumentException unused) {
        }
    }

    public Charset b() {
        this.b.a();
        if (this.d == null && this.f3288a.e()) {
            a(Constants.r);
        }
        return this.d;
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f3288a.a(bArr, i, i2);
        this.b.g(bArr, i, i2);
    }

    public final Boolean d() {
        return Boolean.valueOf(this.f3288a.b(129) > 0 || this.f3288a.b(141) > 0 || this.f3288a.b(143) > 0 || this.f3288a.b(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW) > 0 || this.f3288a.b(157) > 0);
    }

    public boolean e() {
        return this.b.h();
    }
}
