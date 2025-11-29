package org.apache.tika.mime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.tika.Tika;
import org.apache.tika.detect.Detector;
import org.apache.tika.detect.TextDetector;
import org.apache.tika.detect.XmlRootExtractor;
import org.apache.tika.metadata.Metadata;
import org.eclipse.jetty.util.URIUtil;

public final class MimeTypes implements Detector, Serializable {
    private static final Map<ClassLoader, MimeTypes> CLASSLOADER_SPECIFIC_DEFAULT_TYPES = new HashMap();
    private static MimeTypes DEFAULT_TYPES = null;
    public static final String OCTET_STREAM = "application/octet-stream";
    public static final String PLAIN_TEXT = "text/plain";
    public static final String XML = "application/xml";
    private static final long serialVersionUID = -1350863170146349036L;
    private final MimeType htmlMimeType;
    private final List<Magic> magics;
    private final Patterns patterns;
    private final MediaTypeRegistry registry;
    private final MimeType rootMimeType;
    private final List<MimeType> rootMimeTypeL;
    private final MimeType textMimeType;
    private final Map<MediaType, MimeType> types = new HashMap();
    private final MimeType xmlMimeType;
    private final List<MimeType> xmls;

    public MimeTypes() {
        MediaTypeRegistry mediaTypeRegistry = new MediaTypeRegistry();
        this.registry = mediaTypeRegistry;
        this.patterns = new Patterns(mediaTypeRegistry);
        this.magics = new ArrayList();
        this.xmls = new ArrayList();
        MimeType mimeType = new MimeType(MediaType.OCTET_STREAM);
        this.rootMimeType = mimeType;
        MimeType mimeType2 = new MimeType(MediaType.TEXT_PLAIN);
        this.textMimeType = mimeType2;
        this.htmlMimeType = new MimeType(MediaType.TEXT_HTML);
        MimeType mimeType3 = new MimeType(MediaType.APPLICATION_XML);
        this.xmlMimeType = mimeType3;
        this.rootMimeTypeL = Collections.singletonList(mimeType);
        add(mimeType);
        add(mimeType2);
        add(mimeType3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.apache.tika.mime.MimeType> applyHint(java.util.List<org.apache.tika.mime.MimeType> r5, org.apache.tika.mime.MimeType r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0035
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0009
            goto L_0x0035
        L_0x0009:
            java.util.Iterator r0 = r5.iterator()
        L_0x000d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            org.apache.tika.mime.MimeType r1 = (org.apache.tika.mime.MimeType) r1
            boolean r2 = r6.equals(r1)
            if (r2 != 0) goto L_0x002f
            org.apache.tika.mime.MediaTypeRegistry r2 = r4.registry
            org.apache.tika.mime.MediaType r3 = r6.getType()
            org.apache.tika.mime.MediaType r1 = r1.getType()
            boolean r1 = r2.isSpecializationOf(r3, r1)
            if (r1 == 0) goto L_0x000d
        L_0x002f:
            java.util.List r4 = java.util.Collections.singletonList(r6)
            return r4
        L_0x0034:
            return r5
        L_0x0035:
            java.util.List r4 = java.util.Collections.singletonList(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.mime.MimeTypes.applyHint(java.util.List, org.apache.tika.mime.MimeType):java.util.List");
    }

    public static synchronized MimeTypes getDefaultMimeTypes() {
        MimeTypes defaultMimeTypes;
        synchronized (MimeTypes.class) {
            defaultMimeTypes = getDefaultMimeTypes((ClassLoader) null);
        }
        return defaultMimeTypes;
    }

    public void add(MimeType mimeType) {
        this.registry.addType(mimeType.getType());
        this.types.put(mimeType.getType(), mimeType);
        if (mimeType.hasMagic()) {
            this.magics.addAll(mimeType.getMagics());
        }
        if (mimeType.hasRootXML()) {
            this.xmls.add(mimeType);
        }
    }

    public synchronized void addAlias(MimeType mimeType, MediaType mediaType) {
        this.registry.addAlias(mimeType.getType(), mediaType);
    }

    public void addPattern(MimeType mimeType, String str) throws MimeTypeException {
        addPattern(mimeType, str, false);
    }

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        List<MimeType> list;
        boolean z;
        int lastIndexOf;
        String str = null;
        if (inputStream != null) {
            inputStream.mark(getMinLength());
            try {
                list = getMimeType(readMagicHeader(inputStream));
            } finally {
                inputStream.reset();
            }
        } else {
            list = null;
        }
        String str2 = metadata.get("resourceName");
        if (str2 != null) {
            try {
                URI uri = new URI(str2);
                String scheme = uri.getScheme();
                z = scheme != null && scheme.startsWith(URIUtil.HTTP);
                try {
                    String path = uri.getPath();
                    if (path != null && (lastIndexOf = path.lastIndexOf(47) + 1) < path.length()) {
                        str = path.substring(lastIndexOf);
                    }
                    str2 = str;
                } catch (URISyntaxException unused) {
                }
            } catch (URISyntaxException unused2) {
                z = false;
            }
            if (str2 != null) {
                MimeType mimeType = getMimeType(str2);
                if (!z || !mimeType.isInterpreted()) {
                    list = applyHint(list, mimeType);
                }
            }
        }
        String str3 = metadata.get("Content-Type");
        if (str3 != null) {
            try {
                list = applyHint(list, forName(str3));
            } catch (MimeTypeException unused3) {
            }
        }
        return (list == null || list.isEmpty()) ? MediaType.OCTET_STREAM : list.get(0).getType();
    }

    public MimeType forName(String str) throws MimeTypeException {
        MediaType parse = MediaType.parse(str);
        if (parse != null) {
            MediaType normalize = this.registry.normalize(parse);
            MimeType mimeType = this.types.get(normalize);
            if (mimeType == null) {
                synchronized (this) {
                    try {
                        MimeType mimeType2 = this.types.get(normalize);
                        if (mimeType2 == null) {
                            mimeType2 = new MimeType(parse);
                            add(mimeType2);
                            this.types.put(parse, mimeType2);
                        }
                        mimeType = mimeType2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return mimeType;
        }
        throw new MimeTypeException("Invalid media type name: " + str);
    }

    public MediaTypeRegistry getMediaTypeRegistry() {
        return this.registry;
    }

    public MimeType getMimeType(String str) {
        MimeType matches = this.patterns.matches(str);
        if (matches != null) {
            return matches;
        }
        MimeType matches2 = this.patterns.matches(str.toLowerCase(Locale.ENGLISH));
        if (matches2 != null) {
            return matches2;
        }
        return this.rootMimeType;
    }

    public int getMinLength() {
        return 65536;
    }

    public MimeType getRegisteredMimeType(String str) throws MimeTypeException {
        MediaType parse = MediaType.parse(str);
        if (parse != null) {
            MediaType normalize = this.registry.normalize(parse);
            MimeType mimeType = this.types.get(normalize);
            if (mimeType != null) {
                return mimeType;
            }
            if (normalize.hasParameters()) {
                return this.types.get(normalize.getBaseType());
            }
            return null;
        }
        throw new MimeTypeException("Invalid media type name: " + str);
    }

    public void init() {
        for (MimeType next : this.types.values()) {
            this.magics.addAll(next.getMagics());
            if (next.hasRootXML()) {
                this.xmls.add(next);
            }
        }
        Collections.sort(this.magics);
        Collections.sort(this.xmls);
    }

    public byte[] readMagicHeader(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            int minLength = getMinLength();
            byte[] bArr = new byte[minLength];
            int read = inputStream.read(bArr);
            int i = 0;
            while (read != -1) {
                i += read;
                if (i == minLength) {
                    return bArr;
                }
                read = inputStream.read(bArr, i, minLength - i);
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        throw new IllegalArgumentException("InputStream is missing");
    }

    public synchronized void setSuperType(MimeType mimeType, MediaType mediaType) {
        this.registry.addSuperType(mimeType.getType(), mediaType);
    }

    public static synchronized MimeTypes getDefaultMimeTypes(ClassLoader classLoader) {
        MimeTypes mimeTypes;
        synchronized (MimeTypes.class) {
            mimeTypes = DEFAULT_TYPES;
            if (classLoader != null) {
                mimeTypes = CLASSLOADER_SPECIFIC_DEFAULT_TYPES.get(classLoader);
            }
            if (mimeTypes == null) {
                try {
                    mimeTypes = MimeTypesFactory.b("tika-mimetypes.xml", "custom-mimetypes.xml", classLoader);
                    if (classLoader == null) {
                        DEFAULT_TYPES = mimeTypes;
                    } else {
                        CLASSLOADER_SPECIFIC_DEFAULT_TYPES.put(classLoader, mimeTypes);
                    }
                } catch (MimeTypeException e) {
                    throw new RuntimeException("Unable to parse the default media type registry", e);
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to read the default media type registry", e2);
                }
            }
        }
        return mimeTypes;
    }

    public void addPattern(MimeType mimeType, String str, boolean z) throws MimeTypeException {
        this.patterns.add(str, z, mimeType);
    }

    public MimeType getMimeType(File file) throws MimeTypeException, IOException {
        return forName(new Tika((Detector) this).a(file));
    }

    public List<MimeType> getMimeType(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Data is missing");
        } else if (bArr.length == 0) {
            return this.rootMimeTypeL;
        } else {
            ArrayList arrayList = new ArrayList(1);
            int i = -1;
            for (Magic next : this.magics) {
                if (i > 0 && i > next.getPriority()) {
                    break;
                } else if (next.eval(bArr)) {
                    arrayList.add(next.getType());
                    i = next.getPriority();
                }
            }
            if (!arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    MimeType mimeType = (MimeType) arrayList.get(i2);
                    if (XML.equals(mimeType.getName()) || "text/html".equals(mimeType.getName())) {
                        QName b = new XmlRootExtractor().b(bArr);
                        if (b != null) {
                            Iterator<MimeType> it = this.xmls.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                MimeType next2 = it.next();
                                if (next2.matchesXML(b.getNamespaceURI(), b.getLocalPart())) {
                                    arrayList.set(i2, next2);
                                    break;
                                }
                            }
                        } else if (XML.equals(mimeType.getName())) {
                            Iterator<Magic> it2 = this.magics.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    arrayList.set(i2, this.textMimeType);
                                    break;
                                }
                                Magic next3 = it2.next();
                                if (next3.getType().equals(this.htmlMimeType) && next3.eval(bArr)) {
                                    arrayList.set(i2, this.htmlMimeType);
                                    break;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
            try {
                return Collections.singletonList(forName(new TextDetector(getMinLength()).detect(new UnsynchronizedByteArrayInputStream(bArr), new Metadata()).toString()));
            } catch (Exception unused) {
                return this.rootMimeTypeL;
            }
        }
    }
}
