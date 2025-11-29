package org.apache.tika.extractor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.tika.exception.CorruptedFileException;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.DelegatingParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.ParseRecord;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.EmbeddedContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

public class ParsingEmbeddedDocumentExtractor implements EmbeddedDocumentExtractor {
    public static final File c = new File("");
    public static final Parser d = new DelegatingParser();

    /* renamed from: a  reason: collision with root package name */
    public boolean f10061a = true;
    public final ParseContext b;

    public ParsingEmbeddedDocumentExtractor(ParseContext parseContext) {
        this.b = parseContext;
    }

    public void a(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, boolean z) {
        TemporaryResources temporaryResources;
        Object z2;
        if (z) {
            AttributesImpl attributesImpl = new AttributesImpl();
            attributesImpl.addAttribute("", "class", "class", "CDATA", "package-entry");
            contentHandler.startElement("http://www.w3.org/1999/xhtml", "div", "div", attributesImpl);
        }
        String str = metadata.get("resourceName");
        if (this.f10061a && str != null && str.length() > 0 && z) {
            contentHandler.startElement("http://www.w3.org/1999/xhtml", "h1", "h1", new AttributesImpl());
            char[] charArray = str.toCharArray();
            contentHandler.characters(charArray, 0, charArray.length);
            contentHandler.endElement("http://www.w3.org/1999/xhtml", "h1", "h1");
        }
        try {
            temporaryResources = new TemporaryResources();
            TikaInputStream g = TikaInputStream.g(new CloseShieldInputStream(inputStream), temporaryResources, metadata);
            if ((inputStream instanceof TikaInputStream) && (z2 = ((TikaInputStream) inputStream).z()) != null) {
                g.c0(z2);
            }
            d.parse(g, new EmbeddedContentHandler(new BodyContentHandler(contentHandler)), metadata, this.b);
            temporaryResources.close();
        } catch (EncryptedDocumentException e) {
            c(e, this.b);
        } catch (CorruptedFileException e2) {
            throw new IOException(e2);
        } catch (TikaException e3) {
            c(e3, this.b);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        if (z) {
            contentHandler.endElement("http://www.w3.org/1999/xhtml", "div", "div");
            return;
        }
        return;
        throw th;
    }

    public boolean b(Metadata metadata) {
        String str;
        DocumentSelector documentSelector = (DocumentSelector) this.b.get(DocumentSelector.class);
        if (documentSelector != null) {
            return documentSelector.a(metadata);
        }
        FilenameFilter filenameFilter = (FilenameFilter) this.b.get(FilenameFilter.class);
        if (filenameFilter == null || (str = metadata.get("resourceName")) == null) {
            return true;
        }
        return filenameFilter.accept(c, str);
    }

    public final void c(Exception exc, ParseContext parseContext) {
        ParseRecord parseRecord = (ParseRecord) parseContext.get(ParseRecord.class);
        if (parseRecord != null) {
            parseRecord.a(exc);
        }
    }

    public void d(boolean z) {
        this.f10061a = z;
    }
}
