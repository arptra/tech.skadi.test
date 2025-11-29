package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.RecursiveParserWrapperHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class RecursiveMetadataContentHandlerResource implements ForkResource {
    public static final ContentHandler b = new DefaultHandler();

    /* renamed from: a  reason: collision with root package name */
    public final AbstractRecursiveParserWrapperHandler f10072a;

    public RecursiveMetadataContentHandlerResource(RecursiveParserWrapperHandler recursiveParserWrapperHandler) {
        this.f10072a = recursiveParserWrapperHandler;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: org.xml.sax.ContentHandler} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.DataInputStream r5) {
        /*
            r4 = this;
            byte r0 = r5.readByte()
            byte r1 = r5.readByte()
            org.xml.sax.ContentHandler r2 = b
            r3 = 3
            if (r1 != r3) goto L_0x0015
            java.lang.Object r1 = r4.c(r5)
            r2 = r1
            org.xml.sax.ContentHandler r2 = (org.xml.sax.ContentHandler) r2
            goto L_0x0018
        L_0x0015:
            r3 = 4
            if (r1 != r3) goto L_0x0065
        L_0x0018:
            java.lang.Object r1 = r4.c(r5)
            org.apache.tika.metadata.Metadata r1 = (org.apache.tika.metadata.Metadata) r1
            r3 = 1
            if (r0 != r3) goto L_0x0027
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r4 = r4.f10072a
            r4.endEmbeddedDocument(r2, r1)
            goto L_0x002f
        L_0x0027:
            r3 = 2
            if (r0 != r3) goto L_0x004e
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r4 = r4.f10072a
            r4.endDocument(r2, r1)
        L_0x002f:
            byte r4 = r5.readByte()
            r5 = 5
            if (r4 != r5) goto L_0x0037
            return
        L_0x0037:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected the 'complete' signal, but got: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L_0x004e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "Expected either 0x01 or 0x02, but got: "
            r5.append(r1)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0065:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Expected HANDLER_AND_METADATA or METADATA_ONLY, but got:"
            r5.append(r0)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.fork.RecursiveMetadataContentHandlerResource.b(java.io.DataInputStream):void");
    }

    public Throwable a(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        try {
            b(dataInputStream);
            return null;
        } catch (SAXException e) {
            return e;
        }
    }

    public final Object c(DataInputStream dataInputStream) {
        try {
            return ForkObjectInputStream.a(dataInputStream, getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}
