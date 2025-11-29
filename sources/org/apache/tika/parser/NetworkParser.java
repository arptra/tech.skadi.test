package org.apache.tika.parser;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.sax.TaggedContentHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.utils.XMLReaderUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NetworkParser extends AbstractParser {
    private final Set<MediaType> supportedTypes;
    private final URI uri;

    public static class MetaHandler extends DefaultHandler {

        /* renamed from: a  reason: collision with root package name */
        public final Metadata f3246a;

        public MetaHandler(Metadata metadata) {
            this.f3246a = metadata;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if ("http://www.w3.org/1999/xhtml".equals(str) && "meta".equals(str2)) {
                String value = attributes.getValue("", "name");
                String value2 = attributes.getValue("", "content");
                if (value != null && value2 != null) {
                    this.f3246a.add(value, value2);
                }
            }
        }
    }

    public static class ParsingTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final TikaInputStream f3247a;
        public final OutputStream b;
        public volatile Exception c = null;

        public ParsingTask(TikaInputStream tikaInputStream, OutputStream outputStream) {
            this.f3247a = tikaInputStream;
            this.b = outputStream;
        }

        public void a(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
            Thread thread = new Thread(this, "Tika network parser");
            thread.start();
            TaggedContentHandler taggedContentHandler = new TaggedContentHandler(contentHandler);
            try {
                XMLReaderUtils.parseSAX(inputStream, (ContentHandler) new TeeContentHandler(taggedContentHandler, new MetaHandler(metadata)), parseContext);
                try {
                    thread.join(1000);
                    if (this.c != null) {
                        this.f3247a.throwIfCauseOf(this.c);
                        throw new TikaException("Unexpected network parser error", this.c);
                    }
                } catch (InterruptedException e) {
                    throw new TikaException("Network parser interrupted", e);
                }
            } catch (SAXException e2) {
                taggedContentHandler.c(e2);
                throw new TikaException("Invalid network parser output", e2);
            } catch (IOException e3) {
                throw new TikaException("Unable to read network parser output", e3);
            } catch (Throwable th) {
                try {
                    thread.join(1000);
                    if (this.c != null) {
                        this.f3247a.throwIfCauseOf(this.c);
                        throw new TikaException("Unexpected network parser error", this.c);
                    }
                    throw th;
                } catch (InterruptedException e4) {
                    throw new TikaException("Network parser interrupted", e4);
                }
            }
        }

        public void run() {
            try {
                IOUtils.copy((InputStream) this.f3247a, this.b);
                this.b.close();
            } catch (Exception e) {
                this.c = e;
            } catch (Throwable th) {
                this.b.close();
                throw th;
            }
        }
    }

    public NetworkParser(URI uri2, Set<MediaType> set) {
        this.uri = uri2;
        this.supportedTypes = set;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.supportedTypes;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        TemporaryResources temporaryResources = new TemporaryResources();
        try {
            parse(TikaInputStream.g(inputStream, temporaryResources, metadata), contentHandler, metadata, parseContext);
        } finally {
            temporaryResources.dispose();
        }
    }

    public NetworkParser(URI uri2) {
        this(uri2, Collections.singleton(MediaType.OCTET_STREAM));
    }

    private void parse(TikaInputStream tikaInputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        if ("telnet".equals(this.uri.getScheme())) {
            final Socket socket = new Socket(this.uri.getHost(), this.uri.getPort());
            try {
                new ParsingTask(tikaInputStream, new FilterOutputStream(socket.getOutputStream()) {
                    public void close() {
                        socket.shutdownOutput();
                    }
                }).a(socket.getInputStream(), contentHandler, metadata, parseContext);
                socket.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            URLConnection openConnection = this.uri.toURL().openConnection();
            openConnection.setDoOutput(true);
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            try {
                new ParsingTask(tikaInputStream, openConnection.getOutputStream()).a(new CloseShieldInputStream(inputStream), contentHandler, metadata, parseContext);
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        throw th;
        throw th;
    }
}
