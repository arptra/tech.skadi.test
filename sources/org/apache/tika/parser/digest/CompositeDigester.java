package org.apache.tika.parser.digest;

import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.DigestingParser;
import org.apache.tika.parser.ParseContext;

public class CompositeDigester implements DigestingParser.Digester {

    /* renamed from: a  reason: collision with root package name */
    public final DigestingParser.Digester[] f3257a;

    public void a(InputStream inputStream, Metadata metadata, ParseContext parseContext) {
        TemporaryResources temporaryResources = new TemporaryResources();
        TikaInputStream g = TikaInputStream.g(inputStream, temporaryResources, metadata);
        try {
            for (DigestingParser.Digester a2 : this.f3257a) {
                a2.a(g, metadata, parseContext);
            }
            try {
            } catch (TikaException e) {
                throw new IOException(e);
            }
        } finally {
            try {
                temporaryResources.dispose();
            } catch (TikaException e2) {
                throw new IOException(e2);
            }
        }
    }
}
