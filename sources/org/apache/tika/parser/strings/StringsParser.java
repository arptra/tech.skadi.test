package org.apache.tika.parser.strings;

import com.honey.account.lc.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.IOUtils;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.detect.FileCommandDetector;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.external.ExternalParser;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.utils.SystemUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class StringsParser extends AbstractParser implements Initializable {
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.OCTET_STREAM);
    private static final long serialVersionUID = 802566634661575025L;
    private final StringsConfig defaultStringsConfig = new StringsConfig();
    private FileCommandDetector fileCommandDetector;
    private String filePath = "";
    private boolean hasEncodingOption = false;
    private String stringsPath = "";
    private boolean stringsPresent = false;

    private void checkForStrings() {
        String str = getStringsPath() + getStringsProg();
        try {
            boolean check = ExternalParser.check(new String[]{str, "--version"}, new int[0]);
            this.stringsPresent = check;
            if (check && !SystemUtils.m) {
                this.hasEncodingOption = ExternalParser.check(new String[]{str, "-e", "" + this.defaultStringsConfig.getEncoding().get(), "/dev/null"}, 1, 2);
            }
        } catch (NoClassDefFoundError unused) {
        }
    }

    private String doFile(TikaInputStream tikaInputStream) throws IOException {
        Metadata metadata = new Metadata();
        this.fileCommandDetector.detect(tikaInputStream, metadata);
        return metadata.get("Content-Type");
    }

    private int doStrings(File file, StringsConfig stringsConfig, XHTMLContentHandler xHTMLContentHandler) throws IOException, TikaException, SAXException {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(getStringsPath() + getStringsProg());
        arrayList.add("-n");
        arrayList.add("" + stringsConfig.getMinLength());
        if (this.hasEncodingOption) {
            arrayList.add("-e");
            arrayList.add("" + stringsConfig.getEncoding().get());
        }
        arrayList.add(file.getPath());
        Process start = new ProcessBuilder((String[]) arrayList.toArray(new String[0])).start();
        InputStream inputStream = start.getInputStream();
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread logStream = logStream(inputStream, xHTMLContentHandler, atomicInteger);
        logStream.start();
        try {
            if (start.waitFor((long) stringsConfig.getTimeoutSeconds(), TimeUnit.SECONDS)) {
                logStream.join(10000);
                start.destroyForcibly();
                return atomicInteger.get();
            }
            throw new TimeoutException("timed out");
        } catch (InterruptedException | TimeoutException e) {
            throw new TikaException("strings process failed", e);
        } catch (Throwable th) {
            start.destroyForcibly();
            throw th;
        }
    }

    public static String getStringsProg() {
        return SystemUtils.m ? "strings.exe" : "strings";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$logStream$0(InputStream inputStream, ContentHandler contentHandler, AtomicInteger atomicInteger) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] cArr = new char[1024];
        while (true) {
            try {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                contentHandler.characters(cArr, 0, read);
                atomicInteger.addAndGet(read);
            } catch (IOException | SAXException unused) {
            } catch (Throwable th) {
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        }
        IOUtils.closeQuietly(inputStream);
    }

    private Thread logStream(InputStream inputStream, ContentHandler contentHandler, AtomicInteger atomicInteger) {
        return new Thread(new a(inputStream, contentHandler, atomicInteger));
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) throws TikaConfigException {
    }

    public int getMinLength() {
        return this.defaultStringsConfig.getMinLength();
    }

    public StringsEncoding getStringsEncoding() {
        return this.defaultStringsConfig.getEncoding();
    }

    public String getStringsPath() {
        return this.stringsPath;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return SUPPORTED_TYPES;
    }

    public int getTimeoutSeconds() {
        return this.defaultStringsConfig.getTimeoutSeconds();
    }

    public void initialize(Map<String, Param> map) throws TikaConfigException {
        checkForStrings();
        FileCommandDetector fileCommandDetector2 = new FileCommandDetector();
        this.fileCommandDetector = fileCommandDetector2;
        fileCommandDetector2.setFilePath(this.filePath);
        this.fileCommandDetector.setTimeoutMs((long) (this.defaultStringsConfig.getTimeoutSeconds() * 1000));
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        if (this.stringsPresent) {
            StringsConfig stringsConfig = (StringsConfig) parseContext.get(StringsConfig.class, this.defaultStringsConfig);
            TemporaryResources temporaryResources = new TemporaryResources();
            try {
                TikaInputStream g = TikaInputStream.g(inputStream, temporaryResources, metadata);
                File u = g.u();
                metadata.set("strings:min-len", "" + stringsConfig.getMinLength());
                metadata.set("strings:encoding", stringsConfig.toString());
                metadata.set("strings:file_output", doFile(g));
                XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
                xHTMLContentHandler.startDocument();
                int doStrings = doStrings(u, stringsConfig, xHTMLContentHandler);
                xHTMLContentHandler.endDocument();
                metadata.set("strings:length", "" + doStrings);
                temporaryResources.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    @Field
    public void setEncoding(String str) {
        this.defaultStringsConfig.setEncoding(StringsEncoding.valueOf(str));
    }

    @Field
    public void setMinLength(int i) {
        this.defaultStringsConfig.setMinLength(i);
    }

    @Field
    public void setStringsPath(String str) {
        if (!str.isEmpty() && !str.endsWith(File.separator)) {
            str = str + File.separatorChar;
        }
        this.stringsPath = str;
    }

    @Field
    public void setTimeoutSeconds(int i) {
        this.defaultStringsConfig.setTimeoutSeconds(i);
    }
}
