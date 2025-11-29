package javax.obex;

import java.io.InputStream;
import java.io.OutputStream;

public interface ObexTransport {
    InputStream a();

    OutputStream b();

    void close();
}
