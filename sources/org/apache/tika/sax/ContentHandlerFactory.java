package org.apache.tika.sax;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.xml.sax.ContentHandler;

public interface ContentHandlerFactory extends Serializable {
    ContentHandler getNewContentHandler();

    @Deprecated
    ContentHandler getNewContentHandler(OutputStream outputStream, String str) throws UnsupportedEncodingException;

    ContentHandler getNewContentHandler(OutputStream outputStream, Charset charset);
}
