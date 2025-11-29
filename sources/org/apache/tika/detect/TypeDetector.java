package org.apache.tika.detect;

public class TypeDetector implements Detector {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = org.apache.tika.mime.MediaType.parse(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.tika.mime.MediaType detect(java.io.InputStream r1, org.apache.tika.metadata.Metadata r2) {
        /*
            r0 = this;
            java.lang.String r0 = "Content-Type"
            java.lang.String r0 = r2.get((java.lang.String) r0)
            if (r0 == 0) goto L_0x000f
            org.apache.tika.mime.MediaType r0 = org.apache.tika.mime.MediaType.parse(r0)
            if (r0 == 0) goto L_0x000f
            return r0
        L_0x000f:
            org.apache.tika.mime.MediaType r0 = org.apache.tika.mime.MediaType.OCTET_STREAM
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.detect.TypeDetector.detect(java.io.InputStream, org.apache.tika.metadata.Metadata):org.apache.tika.mime.MediaType");
    }
}
