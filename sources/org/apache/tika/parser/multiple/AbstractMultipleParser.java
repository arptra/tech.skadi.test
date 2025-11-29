package org.apache.tika.parser.multiple;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ContentHandlerFactory;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public abstract class AbstractMultipleParser extends AbstractParser {
    protected static final String METADATA_POLICY_CONFIG_KEY = "metadataPolicy";
    private static final long serialVersionUID = 5383668090329836559L;
    private final Set<MediaType> offeredTypes;
    private final Collection<? extends Parser> parsers;
    private final MetadataPolicy policy;
    private MediaTypeRegistry registry;

    /* renamed from: org.apache.tika.parser.multiple.AbstractMultipleParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3259a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.tika.parser.multiple.AbstractMultipleParser$MetadataPolicy[] r0 = org.apache.tika.parser.multiple.AbstractMultipleParser.MetadataPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3259a = r0
                org.apache.tika.parser.multiple.AbstractMultipleParser$MetadataPolicy r1 = org.apache.tika.parser.multiple.AbstractMultipleParser.MetadataPolicy.FIRST_WINS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3259a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.tika.parser.multiple.AbstractMultipleParser$MetadataPolicy r1 = org.apache.tika.parser.multiple.AbstractMultipleParser.MetadataPolicy.LAST_WINS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3259a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.tika.parser.multiple.AbstractMultipleParser$MetadataPolicy r1 = org.apache.tika.parser.multiple.AbstractMultipleParser.MetadataPolicy.KEEP_ALL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.multiple.AbstractMultipleParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MetadataPolicy {
        DISCARD_ALL,
        FIRST_WINS,
        LAST_WINS,
        KEEP_ALL
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, Collection<? extends Parser> collection, Map<String, Param> map) {
        this(mediaTypeRegistry, getMetadataPolicy(map), collection);
    }

    public static MetadataPolicy getMetadataPolicy(Map<String, Param> map) {
        if (map.containsKey(METADATA_POLICY_CONFIG_KEY)) {
            return (MetadataPolicy) map.get(METADATA_POLICY_CONFIG_KEY).getValue();
        }
        throw new IllegalArgumentException("Required parameter 'metadataPolicy' not supplied");
    }

    public static Metadata mergeMetadata(Metadata metadata, Metadata metadata2, MetadataPolicy metadataPolicy) {
        if (metadataPolicy == MetadataPolicy.DISCARD_ALL) {
            return metadata;
        }
        for (String str : metadata2.names()) {
            if (!str.equals(TikaCoreProperties.o.getName()) && !str.equals(ParserUtils.f3341a.getName()) && !str.equals(TikaCoreProperties.i.getName())) {
                String[] values = metadata.getValues(str);
                String[] values2 = metadata2.getValues(str);
                if (values == null || values.length == 0) {
                    for (String add : values2) {
                        metadata.add(str, add);
                    }
                } else if (!Arrays.deepEquals(values2, values)) {
                    int i = AnonymousClass1.f3259a[metadataPolicy.ordinal()];
                    if (i == 1) {
                        metadata.remove(str);
                        for (String add2 : values2) {
                            metadata.add(str, add2);
                        }
                    } else if (i == 3) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(values2));
                        metadata.remove(str);
                        for (String add3 : values2) {
                            metadata.add(str, add3);
                        }
                        for (String str2 : values) {
                            if (!arrayList.contains(str2)) {
                                metadata.add(str, str2);
                                arrayList.add(str2);
                            }
                        }
                    }
                }
            }
        }
        return metadata;
    }

    public List<Parser> getAllParsers() {
        return Collections.unmodifiableList(new ArrayList(this.parsers));
    }

    public MediaTypeRegistry getMediaTypeRegistry() {
        return this.registry;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.offeredTypes;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        parse(inputStream, contentHandler, (ContentHandlerFactory) null, metadata, parseContext);
    }

    public abstract boolean parserCompleted(Parser parser, Metadata metadata, ContentHandler contentHandler, ParseContext parseContext, Exception exc);

    public void parserPrepare(Parser parser, Metadata metadata, ParseContext parseContext) {
    }

    public void setMediaTypeRegistry(MediaTypeRegistry mediaTypeRegistry) {
        this.registry = mediaTypeRegistry;
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, MetadataPolicy metadataPolicy, Parser... parserArr) {
        this(mediaTypeRegistry, metadataPolicy, (Collection<? extends Parser>) Arrays.asList(parserArr));
    }

    public void parse(InputStream inputStream, ContentHandlerFactory contentHandlerFactory, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        parse(inputStream, (ContentHandler) null, contentHandlerFactory, metadata, parseContext);
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, MetadataPolicy metadataPolicy, Collection<? extends Parser> collection) {
        this.policy = metadataPolicy;
        this.parsers = collection;
        this.registry = mediaTypeRegistry;
        this.offeredTypes = new HashSet();
        for (Parser supportedTypes : collection) {
            this.offeredTypes.addAll(supportedTypes.getSupportedTypes(new ParseContext()));
        }
    }

    private void parse(InputStream inputStream, ContentHandler contentHandler, ContentHandlerFactory contentHandlerFactory, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        Metadata metadata2;
        Parser parser;
        Metadata a2;
        Exception exc;
        Metadata metadata3 = metadata;
        ParseContext parseContext2 = parseContext;
        Metadata a3 = ParserUtils.a(metadata);
        TemporaryResources temporaryResources = new TemporaryResources();
        try {
            InputStream b = ParserUtils.b(inputStream, temporaryResources, metadata3);
            Iterator<? extends Parser> it = this.parsers.iterator();
            Metadata metadata4 = a3;
            InputStream inputStream2 = b;
            ContentHandler contentHandler2 = contentHandler;
            metadata2 = metadata4;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                parser = (Parser) it.next();
                if (contentHandlerFactory != null) {
                    contentHandler2 = contentHandlerFactory.getNewContentHandler();
                }
                ContentHandler contentHandler3 = contentHandler2;
                ParserUtils.e(parser, metadata3);
                a2 = ParserUtils.a(metadata);
                parserPrepare(parser, a2, parseContext2);
                parser.parse(inputStream2, contentHandler3, a2, parseContext2);
                exc = null;
                boolean parserCompleted = parserCompleted(parser, a2, contentHandler3, parseContext, exc);
                Metadata mergeMetadata = mergeMetadata(a2, metadata4, this.policy);
                if (parserCompleted) {
                    metadata4 = ParserUtils.a(mergeMetadata);
                    inputStream2 = ParserUtils.g(inputStream2, temporaryResources);
                    parseContext2 = parseContext;
                    metadata2 = mergeMetadata;
                    contentHandler2 = contentHandler3;
                } else if (exc == null) {
                    metadata2 = mergeMetadata;
                } else if (exc instanceof IOException) {
                    throw ((IOException) exc);
                } else if (exc instanceof SAXException) {
                    throw ((SAXException) exc);
                } else if (exc instanceof TikaException) {
                    throw ((TikaException) exc);
                } else {
                    throw new TikaException("Unexpected RuntimeException from " + parser, exc);
                }
            }
        } catch (Exception e) {
            Exception exc2 = e;
            ParserUtils.f(parser, exc2, metadata3);
            ParserUtils.f(parser, exc2, a2);
            exc = exc2;
        } catch (Throwable th) {
            temporaryResources.dispose();
            throw th;
        }
        temporaryResources.dispose();
        for (String str : metadata2.names()) {
            metadata3.remove(str);
            for (String add : metadata2.getValues(str)) {
                metadata3.add(str, add);
            }
        }
    }

    public MetadataPolicy getMetadataPolicy() {
        return this.policy;
    }
}
