package org.apache.tika.parser.external2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.EmptyParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.utils.FileProcessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class ExternalParser extends AbstractParser implements Initializable {
    public static final long DEFAULT_TIMEOUT_MS = 60000;
    public static final String INPUT_FILE_TOKEN = "${INPUT_FILE}";
    private static Pattern INPUT_TOKEN_MATCHER = Pattern.compile("\\$\\{INPUT_FILE}");
    private static final Logger LOG = LoggerFactory.k(ExternalParser.class);
    public static final String OUTPUT_FILE_TOKEN = "${OUTPUT_FILE}";
    private static Pattern OUTPUT_TOKEN_MATCHER = Pattern.compile("\\$\\{OUTPUT_FILE}");
    private List<String> commandLine = new ArrayList();
    private int maxStdErr = 10000;
    private int maxStdOut = 10000;
    private Parser outputParser = EmptyParser.INSTANCE;
    private boolean returnStderr = true;
    private boolean returnStdout = false;
    private Set<MediaType> supportedTypes = new HashSet();
    private long timeoutMs = 60000;

    private void handleOutput(FileProcessResult fileProcessResult, Path path, XHTMLContentHandler xHTMLContentHandler, Metadata metadata, ParseContext parseContext) throws SAXException, TikaException, IOException {
        if (this.outputParser == EmptyParser.INSTANCE) {
            if (path != null) {
                BufferedReader newBufferedReader = Files.newBufferedReader(path);
                try {
                    for (String readLine = newBufferedReader.readLine(); readLine != null; readLine = newBufferedReader.readLine()) {
                        xHTMLContentHandler.m(readLine);
                        xHTMLContentHandler.q();
                    }
                    newBufferedReader.close();
                    return;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                xHTMLContentHandler.m(fileProcessResult.d());
                return;
            }
        } else if (path != null) {
            TikaInputStream i = TikaInputStream.i(path);
            try {
                this.outputParser.parse(i, new BodyContentHandler((ContentHandler) xHTMLContentHandler), metadata, parseContext);
                if (i != null) {
                    i.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            TikaInputStream o = TikaInputStream.o(fileProcessResult.d().getBytes(StandardCharsets.UTF_8));
            try {
                this.outputParser.parse(o, new BodyContentHandler((ContentHandler) xHTMLContentHandler), metadata, parseContext);
                if (o != null) {
                    o.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        }
        throw th;
        throw th;
        throw th;
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) throws TikaConfigException {
        if (this.supportedTypes.size() == 0) {
            throw new TikaConfigException("supportedTypes size must be > 0");
        } else if (this.commandLine.isEmpty()) {
            throw new TikaConfigException("commandLine is empty?!");
        } else if (this.outputParser == EmptyParser.INSTANCE) {
            LOG.debug("no parser selected for the output; contents will be written to the content handler");
        }
    }

    public Parser getOutputParser() {
        return this.outputParser;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.supportedTypes;
    }

    public void initialize(Map<String, Param> map) throws TikaConfigException {
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.io.InputStream r16, org.xml.sax.ContentHandler r17, org.apache.tika.metadata.Metadata r18, org.apache.tika.parser.ParseContext r19) throws java.io.IOException, org.xml.sax.SAXException, org.apache.tika.exception.TikaException {
        /*
            r15 = this;
            r0 = r15
            r5 = r18
            java.lang.String r1 = ""
            r2 = 0
            org.apache.tika.io.TemporaryResources r7 = new org.apache.tika.io.TemporaryResources     // Catch:{ all -> 0x0139 }
            r7.<init>()     // Catch:{ all -> 0x0139 }
            r3 = r16
            org.apache.tika.io.TikaInputStream r3 = org.apache.tika.io.TikaInputStream.g(r3, r7, r5)     // Catch:{ all -> 0x005c }
            java.nio.file.Path r3 = r3.J()     // Catch:{ all -> 0x005c }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            r4.<init>()     // Catch:{ all -> 0x005c }
            java.util.regex.Pattern r6 = INPUT_TOKEN_MATCHER     // Catch:{ all -> 0x005c }
            java.util.regex.Matcher r6 = r6.matcher(r1)     // Catch:{ all -> 0x005c }
            java.util.regex.Pattern r8 = OUTPUT_TOKEN_MATCHER     // Catch:{ all -> 0x005c }
            java.util.regex.Matcher r8 = r8.matcher(r1)     // Catch:{ all -> 0x005c }
            java.util.List<java.lang.String> r9 = r0.commandLine     // Catch:{ all -> 0x005c }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x005c }
            r10 = 0
            r11 = r10
        L_0x002e:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x005c }
            java.lang.String r13 = "tika-external2-"
            if (r12 == 0) goto L_0x008b
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x005c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x005c }
            java.util.regex.Matcher r14 = r6.reset(r12)     // Catch:{ all -> 0x005c }
            boolean r14 = r14.find()     // Catch:{ all -> 0x005c }
            if (r14 == 0) goto L_0x0060
            java.lang.String r13 = "${INPUT_FILE}"
            java.nio.file.Path r14 = r3.toAbsolutePath()     // Catch:{ all -> 0x005c }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x005c }
            java.lang.String r14 = org.apache.tika.utils.ProcessUtils.b(r14)     // Catch:{ all -> 0x005c }
            java.lang.String r12 = r12.replace(r13, r14)     // Catch:{ all -> 0x005c }
            r4.add(r12)     // Catch:{ all -> 0x005c }
            goto L_0x002e
        L_0x005c:
            r0 = move-exception
            r1 = r0
            goto L_0x012f
        L_0x0060:
            java.util.regex.Matcher r14 = r8.reset(r12)     // Catch:{ all -> 0x005c }
            boolean r14 = r14.find()     // Catch:{ all -> 0x005c }
            if (r14 == 0) goto L_0x0087
            java.nio.file.attribute.FileAttribute[] r11 = new java.nio.file.attribute.FileAttribute[r10]     // Catch:{ all -> 0x005c }
            java.nio.file.Path r2 = java.nio.file.Files.createTempFile(r13, r1, r11)     // Catch:{ all -> 0x005c }
            java.lang.String r11 = "${OUTPUT_FILE}"
            java.nio.file.Path r13 = r2.toAbsolutePath()     // Catch:{ all -> 0x005c }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x005c }
            java.lang.String r13 = org.apache.tika.utils.ProcessUtils.b(r13)     // Catch:{ all -> 0x005c }
            java.lang.String r11 = r12.replace(r11, r13)     // Catch:{ all -> 0x005c }
            r4.add(r11)     // Catch:{ all -> 0x005c }
            r11 = 1
            goto L_0x002e
        L_0x0087:
            r4.add(r12)     // Catch:{ all -> 0x005c }
            goto L_0x002e
        L_0x008b:
            long r8 = r0.timeoutMs     // Catch:{ all -> 0x005c }
            r6 = r19
            long r8 = org.apache.tika.config.TikaTaskTimeout.b(r6, r8)     // Catch:{ all -> 0x005c }
            if (r11 == 0) goto L_0x00a5
            java.lang.ProcessBuilder r1 = new java.lang.ProcessBuilder     // Catch:{ all -> 0x005c }
            r1.<init>(r4)     // Catch:{ all -> 0x005c }
            int r3 = r0.maxStdOut     // Catch:{ all -> 0x005c }
            int r4 = r0.maxStdErr     // Catch:{ all -> 0x005c }
            org.apache.tika.utils.FileProcessResult r1 = org.apache.tika.utils.ProcessUtils.c(r1, r8, r3, r4)     // Catch:{ all -> 0x005c }
        L_0x00a2:
            r8 = r2
            r2 = r1
            goto L_0x00b7
        L_0x00a5:
            java.nio.file.attribute.FileAttribute[] r3 = new java.nio.file.attribute.FileAttribute[r10]     // Catch:{ all -> 0x005c }
            java.nio.file.Path r2 = java.nio.file.Files.createTempFile(r13, r1, r3)     // Catch:{ all -> 0x005c }
            java.lang.ProcessBuilder r1 = new java.lang.ProcessBuilder     // Catch:{ all -> 0x005c }
            r1.<init>(r4)     // Catch:{ all -> 0x005c }
            int r3 = r0.maxStdErr     // Catch:{ all -> 0x005c }
            org.apache.tika.utils.FileProcessResult r1 = org.apache.tika.utils.ProcessUtils.d(r1, r8, r2, r3)     // Catch:{ all -> 0x005c }
            goto L_0x00a2
        L_0x00b7:
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.h     // Catch:{ all -> 0x00fb }
            boolean r3 = r2.h()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (boolean) r3)     // Catch:{ all -> 0x00fb }
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.g     // Catch:{ all -> 0x00fb }
            int r3 = r2.a()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (int) r3)     // Catch:{ all -> 0x00fb }
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.e     // Catch:{ all -> 0x00fb }
            long r3 = r2.e()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (long) r3)     // Catch:{ all -> 0x00fb }
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.c     // Catch:{ all -> 0x00fb }
            boolean r3 = r2.g()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (boolean) r3)     // Catch:{ all -> 0x00fb }
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.f     // Catch:{ all -> 0x00fb }
            long r3 = r2.c()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (long) r3)     // Catch:{ all -> 0x00fb }
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.d     // Catch:{ all -> 0x00fb }
            boolean r3 = r2.f()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (boolean) r3)     // Catch:{ all -> 0x00fb }
            boolean r1 = r0.returnStdout     // Catch:{ all -> 0x00fb }
            if (r1 == 0) goto L_0x00ff
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.f7108a     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r2.d()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r0 = move-exception
            r1 = r0
            r2 = r8
            goto L_0x012f
        L_0x00ff:
            boolean r1 = r0.returnStderr     // Catch:{ all -> 0x00fb }
            if (r1 == 0) goto L_0x010c
            org.apache.tika.metadata.Property r1 = org.apache.tika.metadata.ExternalProcess.b     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r2.b()     // Catch:{ all -> 0x00fb }
            r5.set((org.apache.tika.metadata.Property) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00fb }
        L_0x010c:
            org.apache.tika.sax.XHTMLContentHandler r9 = new org.apache.tika.sax.XHTMLContentHandler     // Catch:{ all -> 0x00fb }
            r1 = r17
            r9.<init>(r1, r5)     // Catch:{ all -> 0x00fb }
            r9.startDocument()     // Catch:{ all -> 0x00fb }
            r1 = r15
            r3 = r8
            r4 = r9
            r5 = r18
            r6 = r19
            r1.handleOutput(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00fb }
            r9.endDocument()     // Catch:{ all -> 0x00fb }
            r7.close()     // Catch:{ all -> 0x012c }
            if (r8 == 0) goto L_0x012b
            java.nio.file.Files.delete(r8)
        L_0x012b:
            return
        L_0x012c:
            r0 = move-exception
            r2 = r8
            goto L_0x013a
        L_0x012f:
            r7.close()     // Catch:{ all -> 0x0133 }
            goto L_0x0138
        L_0x0133:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)     // Catch:{ all -> 0x0139 }
        L_0x0138:
            throw r1     // Catch:{ all -> 0x0139 }
        L_0x0139:
            r0 = move-exception
        L_0x013a:
            if (r2 == 0) goto L_0x013f
            java.nio.file.Files.delete(r2)
        L_0x013f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.external2.ExternalParser.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    @Field
    public void setCommandLine(List<String> list) {
        this.commandLine = list;
    }

    @Field
    public void setMaxStdErr(int i) {
        this.maxStdErr = i;
    }

    @Field
    public void setMaxStdOut(int i) {
        this.maxStdOut = i;
    }

    @Field
    public void setOutputParser(Parser parser) {
        this.outputParser = parser;
    }

    @Field
    public void setReturnStderr(boolean z) {
        this.returnStderr = z;
    }

    @Field
    public void setReturnStdout(boolean z) {
        this.returnStdout = z;
    }

    @Field
    public void setSupportedTypes(List<String> list) {
        if (this.supportedTypes.size() <= 0) {
            for (String parse : list) {
                this.supportedTypes.add(MediaType.parse(parse));
            }
            return;
        }
        throw new IllegalStateException("can't set supportedTypes after initialization");
    }

    @Field
    public void setTimeoutMs(long j) {
        this.timeoutMs = j;
    }
}
