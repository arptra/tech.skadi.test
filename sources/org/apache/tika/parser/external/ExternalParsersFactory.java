package org.apache.tika.parser.external;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.tika.config.ServiceLoader;

public class ExternalParsersFactory {
    public static List a() {
        return c(new ServiceLoader());
    }

    public static List b(String str, ServiceLoader serviceLoader) {
        return d((URL[]) Collections.list(serviceLoader.b(ExternalParsersFactory.class.getPackage().getName().replace('.', '/') + "/" + str)).toArray(new URL[0]));
    }

    public static List c(ServiceLoader serviceLoader) {
        return b("tika-external-parsers.xml", serviceLoader);
    }

    public static List d(URL... urlArr) {
        ArrayList arrayList = new ArrayList();
        int length = urlArr.length;
        int i = 0;
        while (i < length) {
            InputStream openStream = urlArr[i].openStream();
            try {
                arrayList.addAll(ExternalParsersConfigReader.b(openStream));
                if (openStream != null) {
                    openStream.close();
                }
                i++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return arrayList;
        throw th;
    }
}
