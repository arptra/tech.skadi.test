package org.apache.tika.mime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class MimeTypesFactory {
    public static MimeTypes a(String str) {
        return c(MimeTypesReader.class.getResource(str));
    }

    public static MimeTypes b(String str, String str2, ClassLoader classLoader) {
        Class<MimeTypesReader> cls = MimeTypesReader.class;
        if (classLoader == null) {
            classLoader = cls.getClassLoader();
        }
        String str3 = cls.getPackage().getName().replace('.', '/') + "/";
        URL resource = classLoader.getResource(str3 + str);
        ArrayList<T> list = Collections.list(classLoader.getResources(str3 + str2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(resource);
        arrayList.addAll(list);
        String property = System.getProperty("tika.custom-mimetypes");
        if (property != null) {
            File file = new File(property);
            if (file.exists()) {
                arrayList.add(file.toURI().toURL());
            } else {
                throw new IOException("Specified custom mimetypes file not found: " + property);
            }
        }
        return e((URL[]) arrayList.toArray(new URL[0]));
    }

    public static MimeTypes c(URL url) {
        return e(url);
    }

    public static MimeTypes d(InputStream... inputStreamArr) {
        MimeTypes mimeTypes = new MimeTypes();
        MimeTypesReader mimeTypesReader = new MimeTypesReader(mimeTypes);
        for (InputStream g : inputStreamArr) {
            mimeTypesReader.g(g);
        }
        mimeTypes.init();
        return mimeTypes;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static org.apache.tika.mime.MimeTypes e(java.net.URL... r5) {
        /*
            int r0 = r5.length
            java.io.InputStream[] r1 = new java.io.InputStream[r0]
            r2 = 0
            r3 = r2
        L_0x0005:
            if (r3 >= r0) goto L_0x0012
            r4 = r5[r3]
            java.io.InputStream r4 = r4.openStream()
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x0005
        L_0x0012:
            org.apache.tika.mime.MimeTypes r5 = d(r1)     // Catch:{ all -> 0x0021 }
        L_0x0016:
            if (r2 >= r0) goto L_0x0020
            r3 = r1[r2]
            r3.close()
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0020:
            return r5
        L_0x0021:
            r5 = move-exception
        L_0x0022:
            if (r2 >= r0) goto L_0x002c
            r3 = r1[r2]
            r3.close()
            int r2 = r2 + 1
            goto L_0x0022
        L_0x002c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.mime.MimeTypesFactory.e(java.net.URL[]):org.apache.tika.mime.MimeTypes");
    }
}
