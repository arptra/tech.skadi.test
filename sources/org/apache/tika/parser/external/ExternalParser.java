package org.apache.tika.parser.external;

import com.honey.account.kc.a;
import com.honey.account.kc.b;
import com.honey.account.kc.c;
import com.honey.account.kc.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.XHTMLContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class ExternalParser extends AbstractParser {
    public static final String INPUT_FILE_TOKEN = "${INPUT}";
    private static final Logger LOG = LoggerFactory.k(ExternalParser.class);
    public static final String OUTPUT_FILE_TOKEN = "${OUTPUT}";
    private static final long serialVersionUID = -1079128990650687037L;
    private String[] command = {"cat"};
    private LineConsumer ignoredLineConsumer = LineConsumer.NULL;
    private Map<Pattern, String> metadataPatterns = null;
    private Set<MediaType> supportedTypes = Collections.emptySet();
    private final long timeoutMs = 60000;

    public interface LineConsumer extends Serializable {
        public static final LineConsumer NULL = new d();

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$static$e2402a94$1(String str) {
        }

        void consume(String str);
    }

    public static boolean check(String str, int... iArr) {
        return check(new String[]{str}, iArr);
    }

    private void extractMetadata(InputStream inputStream, Metadata metadata) {
        Thread thread = new Thread(new b(this, inputStream, metadata));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    private void extractOutput(InputStream inputStream, XHTMLContentHandler xHTMLContentHandler) throws SAXException, IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try {
            xHTMLContentHandler.startDocument();
            xHTMLContentHandler.r("p");
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    xHTMLContentHandler.characters(cArr, 0, read);
                } else {
                    xHTMLContentHandler.n("p");
                    xHTMLContentHandler.endDocument();
                    inputStreamReader.close();
                    return;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void ignoreStream(InputStream inputStream) {
        ignoreStream(inputStream, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$extractMetadata$2(InputStream inputStream, Metadata metadata) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                boolean z = false;
                for (Map.Entry next : this.metadataPatterns.entrySet()) {
                    Matcher matcher = ((Pattern) next.getKey()).matcher(readLine);
                    if (matcher.find()) {
                        if (next.getValue() == null || ((String) next.getValue()).equals("")) {
                            metadata.add(matcher.group(1), matcher.group(2));
                        } else {
                            metadata.add((String) next.getValue(), matcher.group(1));
                        }
                        z = true;
                    }
                }
                if (!z) {
                    this.ignoredLineConsumer.consume(readLine);
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                IOUtils.closeQuietly((Reader) bufferedReader);
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        }
        IOUtils.closeQuietly((Reader) bufferedReader);
        IOUtils.closeQuietly(inputStream);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$ignoreStream$0(InputStream inputStream) {
        try {
            IOUtils.copy(inputStream, (OutputStream) NullOutputStream.NULL_OUTPUT_STREAM);
        } catch (IOException unused) {
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendInput$1(Process process, InputStream inputStream) {
        try {
            IOUtils.copy(inputStream, process.getOutputStream());
        } catch (IOException unused) {
        }
    }

    private void sendInput(Process process, InputStream inputStream) {
        Thread thread = new Thread(new c(process, inputStream));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    public String[] getCommand() {
        return this.command;
    }

    public LineConsumer getIgnoredLineConsumer() {
        return this.ignoredLineConsumer;
    }

    public Map<Pattern, String> getMetadataExtractionPatterns() {
        return this.metadataPatterns;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getSupportedTypes();
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
        TemporaryResources temporaryResources = new TemporaryResources();
        try {
            parse(TikaInputStream.g(inputStream, temporaryResources, metadata), xHTMLContentHandler, metadata, temporaryResources);
        } finally {
            temporaryResources.dispose();
        }
    }

    public void setCommand(String... strArr) {
        this.command = strArr;
    }

    public void setIgnoredLineConsumer(LineConsumer lineConsumer) {
        this.ignoredLineConsumer = lineConsumer;
    }

    public void setMetadataExtractionPatterns(Map<Pattern, String> map) {
        this.metadataPatterns = map;
    }

    public void setSupportedTypes(Set<MediaType> set) {
        this.supportedTypes = Collections.unmodifiableSet(new HashSet(set));
    }

    public static boolean check(String[] strArr, int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{127};
        }
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(strArr);
            Thread ignoreStream = ignoreStream(process.getErrorStream(), false);
            Thread ignoreStream2 = ignoreStream(process.getInputStream(), false);
            ignoreStream.join();
            ignoreStream2.join();
            if (process.waitFor(60000, TimeUnit.MILLISECONDS)) {
                int exitValue = process.exitValue();
                LOG.debug("exit value for {}: {}", strArr[0], Integer.valueOf(exitValue));
                for (int i : iArr) {
                    if (exitValue == i) {
                        process.destroyForcibly();
                        return false;
                    }
                }
                process.destroyForcibly();
                return true;
            }
            throw new TimeoutException();
        } catch (IOException | InterruptedException | TimeoutException e) {
            LOG.debug("exception trying to run  " + strArr[0], e);
            if (process != null) {
                process.destroyForcibly();
            }
            return false;
        } catch (SecurityException e2) {
            throw e2;
        } catch (Error e3) {
            if (e3.getMessage() == null || (!e3.getMessage().contains("posix_spawn") && !e3.getMessage().contains("UNIXProcess"))) {
                throw e3;
            }
            LOG.debug("(TIKA-1526): exception trying to run: " + strArr[0], (Throwable) e3);
            if (process != null) {
                process.destroyForcibly();
            }
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroyForcibly();
            }
            throw th;
        }
    }

    private static Thread ignoreStream(InputStream inputStream, boolean z) {
        Thread thread = new Thread(new a(inputStream));
        thread.start();
        if (z) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
            }
        }
        return thread;
    }

    public Set<MediaType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private void parse(TikaInputStream tikaInputStream, XHTMLContentHandler xHTMLContentHandler, Metadata metadata, TemporaryResources temporaryResources) throws IOException, SAXException, TikaException {
        String[] strArr;
        Process exec;
        Map<Pattern, String> map = this.metadataPatterns;
        boolean z = map != null && !map.isEmpty();
        String[] strArr2 = this.command;
        if (strArr2.length == 1) {
            strArr = strArr2[0].split(" ");
        } else {
            String[] strArr3 = new String[strArr2.length];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr = strArr3;
        }
        Process process = null;
        boolean z2 = true;
        boolean z3 = true;
        File file = null;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains(INPUT_FILE_TOKEN)) {
                strArr[i] = strArr[i].replace(INPUT_FILE_TOKEN, tikaInputStream.u().getPath());
                z2 = false;
            }
            if (strArr[i].contains(OUTPUT_FILE_TOKEN)) {
                file = temporaryResources.i();
                strArr[i] = strArr[i].replace(OUTPUT_FILE_TOKEN, file.getPath());
                z3 = false;
            }
        }
        try {
            if (strArr.length == 1) {
                exec = Runtime.getRuntime().exec(strArr[0]);
            } else {
                exec = Runtime.getRuntime().exec(strArr);
            }
            process = exec;
        } catch (Exception e) {
            LOG.warn("problem with process exec", (Throwable) e);
        }
        if (z2) {
            try {
                sendInput(process, tikaInputStream);
            } catch (Throwable th) {
                try {
                    process.waitFor();
                } catch (InterruptedException unused) {
                }
                throw th;
            }
        } else {
            process.getOutputStream().close();
        }
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        if (z) {
            extractMetadata(errorStream, metadata);
            if (z3) {
                extractOutput(inputStream, xHTMLContentHandler);
            } else {
                extractMetadata(inputStream, metadata);
            }
        } else {
            ignoreStream(errorStream);
            if (z3) {
                extractOutput(inputStream, xHTMLContentHandler);
            } else {
                ignoreStream(inputStream);
            }
        }
        try {
            process.waitFor();
        } catch (InterruptedException unused2) {
        }
        if (!z3) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                extractOutput(fileInputStream, xHTMLContentHandler);
                fileInputStream.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            return;
        }
        throw th;
    }
}
