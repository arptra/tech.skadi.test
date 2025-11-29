package org.apache.tika.fork;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class ForkParser extends AbstractParser implements Closeable {
    private static final long serialVersionUID = -4962742892274663950L;
    private int currentlyInUse;
    private List<String> java;
    private final ClassLoader loader;
    @Field
    private int maxFilesProcessedPerClient;
    private final Parser parser;
    private final ParserFactoryFactory parserFactoryFactory;
    private final Queue<ForkClient> pool;
    @Field
    private int poolSize;
    @Field
    private long serverParseTimeoutMillis;
    @Field
    private long serverPulseMillis;
    @Field
    private long serverWaitTimeoutMillis;
    private final Path tikaBin;

    public ForkParser(Path path, ParserFactoryFactory parserFactoryFactory2) {
        this.pool = new LinkedList();
        this.java = Arrays.asList(new String[]{"java", "-Xmx32m", "-Djava.awt.headless=true"});
        this.poolSize = 5;
        this.currentlyInUse = 0;
        this.serverPulseMillis = 1000;
        this.serverParseTimeoutMillis = 60000;
        this.serverWaitTimeoutMillis = 60000;
        this.maxFilesProcessedPerClient = -1;
        this.loader = null;
        this.parser = null;
        this.tikaBin = path;
        this.parserFactoryFactory = parserFactoryFactory2;
    }

    private synchronized ForkClient acquireClient() throws IOException, TikaException {
        ForkClient poll;
        while (true) {
            try {
                poll = this.pool.poll();
                if (poll == null && this.currentlyInUse < this.poolSize) {
                    poll = newClient();
                }
                if (poll != null && !poll.f()) {
                    poll.b();
                    poll = null;
                }
                if (poll != null) {
                    this.currentlyInUse++;
                } else if (this.currentlyInUse >= this.poolSize) {
                    wait();
                }
            } catch (InterruptedException e) {
                throw new TikaException("Interrupted while waiting for a fork parser", e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return poll;
    }

    private ForkClient newClient() throws IOException, TikaException {
        TimeoutLimits timeoutLimits = new TimeoutLimits(this.serverPulseMillis, this.serverParseTimeoutMillis, this.serverWaitTimeoutMillis);
        ClassLoader classLoader = this.loader;
        if (classLoader == null && this.parser == null && this.tikaBin != null && this.parserFactoryFactory != null) {
            return new ForkClient(this.tikaBin, this.parserFactoryFactory, (List) this.java, timeoutLimits);
        }
        if (classLoader != null && this.parser != null && this.tikaBin == null && this.parserFactoryFactory == null) {
            return new ForkClient(this.loader, (Object) this.parser, (List) this.java, timeoutLimits);
        }
        if (classLoader != null && this.parser == null && this.tikaBin != null && this.parserFactoryFactory != null) {
            return new ForkClient(this.tikaBin, this.parserFactoryFactory, this.loader, this.java, timeoutLimits);
        }
        throw new IllegalStateException("Unexpected combination of state items");
    }

    private synchronized void releaseClient(ForkClient forkClient, boolean z) {
        try {
            int i = this.currentlyInUse - 1;
            this.currentlyInUse = i;
            if (i + this.pool.size() >= this.poolSize || !z) {
                forkClient.b();
            } else {
                if (this.maxFilesProcessedPerClient <= 0 || forkClient.e() < this.maxFilesProcessedPerClient) {
                    this.pool.offer(forkClient);
                } else {
                    forkClient.b();
                }
                notifyAll();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() {
        try {
            for (ForkClient b : this.pool) {
                b.b();
            }
            this.pool.clear();
            this.poolSize = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public String getJavaCommand() {
        StringBuilder sb = new StringBuilder();
        for (String append : getJavaCommandAsList()) {
            sb.append(append);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public List<String> getJavaCommandAsList() {
        return Collections.unmodifiableList(this.java);
    }

    public synchronized int getPoolSize() {
        return this.poolSize;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.parser.getSupportedTypes(parseContext);
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        ForkClient acquireClient;
        boolean z = false;
        if (inputStream != null) {
            acquireClient = acquireClient();
            try {
                if (!(contentHandler instanceof AbstractRecursiveParserWrapperHandler)) {
                    contentHandler = new TeeContentHandler(contentHandler, new MetadataContentHandler(metadata));
                }
                Throwable a2 = acquireClient.a("parse", inputStream, contentHandler, metadata, parseContext);
                releaseClient(acquireClient, true);
                if (a2 instanceof IOException) {
                    throw ((IOException) a2);
                } else if (a2 instanceof SAXException) {
                    throw ((SAXException) a2);
                } else if (a2 instanceof TikaException) {
                    throw ((TikaException) a2);
                } else if (a2 != null) {
                    throw new TikaException("Unexpected error in forked server process", a2);
                } else {
                    return;
                }
            } catch (TikaException e) {
                throw e;
            } catch (IOException e2) {
                throw new TikaException("Failed to communicate with a forked parser process. The process has most likely crashed due to some error like running out of memory. A new process will be started for the next parsing request.", e2);
            } catch (Throwable th) {
                th = th;
                z = true;
            }
        } else {
            throw new NullPointerException("null stream");
        }
        releaseClient(acquireClient, z);
        throw th;
    }

    public void setJavaCommand(List<String> list) {
        this.java = new ArrayList(list);
    }

    public void setMaxFilesProcessedPerServer(int i) {
        this.maxFilesProcessedPerClient = i;
    }

    public synchronized void setPoolSize(int i) {
        this.poolSize = i;
    }

    public void setServerParseTimeoutMillis(long j) {
        this.serverParseTimeoutMillis = j;
    }

    public void setServerPulseMillis(long j) {
        this.serverPulseMillis = j;
    }

    public void setServerWaitTimeoutMillis(long j) {
        this.serverWaitTimeoutMillis = j;
    }

    @Deprecated
    public void setJavaCommand(String str) {
        setJavaCommand((List<String>) Arrays.asList(str.split(" ")));
    }

    public ForkParser(Path path, ParserFactoryFactory parserFactoryFactory2, ClassLoader classLoader) {
        this.pool = new LinkedList();
        this.java = Arrays.asList(new String[]{"java", "-Xmx32m", "-Djava.awt.headless=true"});
        this.poolSize = 5;
        this.currentlyInUse = 0;
        this.serverPulseMillis = 1000;
        this.serverParseTimeoutMillis = 60000;
        this.serverWaitTimeoutMillis = 60000;
        this.maxFilesProcessedPerClient = -1;
        this.parser = null;
        this.loader = classLoader;
        this.tikaBin = path;
        this.parserFactoryFactory = parserFactoryFactory2;
    }

    public ForkParser(ClassLoader classLoader, Parser parser2) {
        this.pool = new LinkedList();
        this.java = Arrays.asList(new String[]{"java", "-Xmx32m", "-Djava.awt.headless=true"});
        this.poolSize = 5;
        this.currentlyInUse = 0;
        this.serverPulseMillis = 1000;
        this.serverParseTimeoutMillis = 60000;
        this.serverWaitTimeoutMillis = 60000;
        this.maxFilesProcessedPerClient = -1;
        if (!(parser2 instanceof ForkParser)) {
            this.tikaBin = null;
            this.parserFactoryFactory = null;
            this.loader = classLoader;
            this.parser = parser2;
            return;
        }
        throw new IllegalArgumentException("The underlying parser of a ForkParser should not be a ForkParser, but a specific implementation.");
    }

    public ForkParser(ClassLoader classLoader) {
        this(classLoader, (Parser) new AutoDetectParser());
    }

    public ForkParser() {
        this(ForkParser.class.getClassLoader());
    }
}
