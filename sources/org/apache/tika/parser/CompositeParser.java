package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.sax.TaggedContentHandler;
import org.apache.tika.utils.ExceptionUtils;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class CompositeParser extends AbstractParser {
    private static final long serialVersionUID = 2192845797749627824L;
    private Parser fallback;
    private List<Parser> parsers;
    private MediaTypeRegistry registry;

    public CompositeParser(MediaTypeRegistry mediaTypeRegistry, List<Parser> list, Collection<Class<? extends Parser>> collection) {
        this.fallback = new EmptyParser();
        if (collection == null || collection.isEmpty()) {
            this.parsers = list;
        } else {
            this.parsers = new ArrayList();
            for (Parser next : list) {
                if (!isExcluded(collection, next.getClass())) {
                    this.parsers.add(next);
                }
            }
        }
        this.registry = mediaTypeRegistry;
    }

    private boolean assignableFrom(Collection<Class<? extends Parser>> collection, Class<? extends Parser> cls) {
        for (Class<? extends Parser> isAssignableFrom : collection) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExcluded(Collection<Class<? extends Parser>> collection, Class<? extends Parser> cls) {
        return collection.contains(cls) || assignableFrom(collection, cls);
    }

    private void recordEmbeddedMetadata(Metadata metadata, ParseContext parseContext) {
        ParseRecord parseRecord = (ParseRecord) parseContext.get(ParseRecord.class);
        if (parseRecord != null) {
            for (Exception b : parseRecord.f()) {
                metadata.add(TikaCoreProperties.i, ExceptionUtils.b(b));
            }
            for (String add : parseRecord.i()) {
                metadata.add(TikaCoreProperties.j, add);
            }
            if (parseRecord.j()) {
                metadata.set(TikaCoreProperties.k, true);
            }
            for (Metadata metadata2 : parseRecord.g()) {
                for (String str : metadata2.names()) {
                    for (String add2 : metadata2.getValues(str)) {
                        metadata.add(str, add2);
                    }
                }
            }
        }
    }

    public Map<MediaType, List<Parser>> findDuplicateParsers(ParseContext parseContext) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Parser next : this.parsers) {
            for (MediaType normalize : next.getSupportedTypes(parseContext)) {
                MediaType normalize2 = this.registry.normalize(normalize);
                if (hashMap.containsKey(normalize2)) {
                    List list = (List) hashMap2.get(normalize2);
                    if (list == null) {
                        list = new ArrayList();
                        list.add((Parser) hashMap.get(normalize2));
                        hashMap2.put(normalize2, list);
                    }
                    list.add(next);
                } else {
                    hashMap.put(normalize2, next);
                }
            }
        }
        return hashMap2;
    }

    public List<Parser> getAllComponentParsers() {
        return Collections.unmodifiableList(this.parsers);
    }

    public Parser getFallback() {
        return this.fallback;
    }

    public MediaTypeRegistry getMediaTypeRegistry() {
        return this.registry;
    }

    public Parser getParser(Metadata metadata) {
        return getParser(metadata, new ParseContext());
    }

    public Map<MediaType, Parser> getParsers(ParseContext parseContext) {
        HashMap hashMap = new HashMap();
        for (Parser next : this.parsers) {
            for (MediaType normalize : next.getSupportedTypes(parseContext)) {
                hashMap.put(this.registry.normalize(normalize), next);
            }
        }
        return hashMap;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getParsers(parseContext).keySet();
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        TikaInputStream g;
        TaggedContentHandler taggedContentHandler;
        Parser parser = getParser(metadata, parseContext);
        TemporaryResources temporaryResources = new TemporaryResources();
        Class cls = ParseRecord.class;
        ParseRecord parseRecord = (ParseRecord) parseContext.get(cls);
        if (parseRecord == null) {
            parseRecord = new ParseRecord();
            parseContext.set(cls, parseRecord);
        }
        try {
            g = TikaInputStream.g(inputStream, temporaryResources, metadata);
            taggedContentHandler = contentHandler != null ? new TaggedContentHandler(contentHandler) : null;
            String c = ParserUtils.c(parser);
            parseRecord.b(c);
            ParserUtils.d(c, metadata);
            parseRecord.d();
            parser.parse(g, taggedContentHandler, metadata, parseContext);
            temporaryResources.dispose();
            parseRecord.c();
            if (parseRecord.e() == 0) {
                metadata.set(TikaCoreProperties.p, parseRecord.h());
                recordEmbeddedMetadata(metadata, parseContext);
            }
        } catch (SecurityException e) {
            throw e;
        } catch (IOException e2) {
            g.throwIfCauseOf(e2);
            throw new TikaException("TIKA-198: Illegal IOException from " + parser, e2);
        } catch (SAXException e3) {
            WriteLimitReachedException.throwIfWriteLimitReached(e3);
            if (taggedContentHandler != null) {
                taggedContentHandler.c(e3);
            }
            throw new TikaException("TIKA-237: Illegal SAXException from " + parser, e3);
        } catch (RuntimeException e4) {
            throw new TikaException("Unexpected RuntimeException from " + parser, e4);
        } catch (Throwable th) {
            temporaryResources.dispose();
            parseRecord.c();
            if (parseRecord.e() == 0) {
                metadata.set(TikaCoreProperties.p, parseRecord.h());
                recordEmbeddedMetadata(metadata, parseContext);
            }
            throw th;
        }
    }

    public void setFallback(Parser parser) {
        this.fallback = parser;
    }

    public void setMediaTypeRegistry(MediaTypeRegistry mediaTypeRegistry) {
        this.registry = mediaTypeRegistry;
    }

    public void setParsers(Map<MediaType, Parser> map) {
        this.parsers = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            this.parsers.add(ParserDecorator.withTypes((Parser) next.getValue(), Collections.singleton((MediaType) next.getKey())));
        }
    }

    public Parser getParser(Metadata metadata, ParseContext parseContext) {
        Map<MediaType, Parser> parsers2 = getParsers(parseContext);
        String str = metadata.get(TikaCoreProperties.x);
        if (str == null) {
            str = metadata.get("Content-Type");
        }
        MediaType parse = MediaType.parse(str);
        if (parse != null) {
            parse = this.registry.normalize(parse);
        }
        while (parse != null) {
            Parser parser = parsers2.get(parse);
            if (parser != null) {
                return parser;
            }
            parse = this.registry.getSupertype(parse);
        }
        return this.fallback;
    }

    public Map<MediaType, Parser> getParsers() {
        return getParsers(new ParseContext());
    }

    public CompositeParser(MediaTypeRegistry mediaTypeRegistry, List<Parser> list) {
        this(mediaTypeRegistry, list, (Collection<Class<? extends Parser>>) null);
    }

    public CompositeParser(MediaTypeRegistry mediaTypeRegistry, Parser... parserArr) {
        this(mediaTypeRegistry, (List<Parser>) Arrays.asList(parserArr));
    }

    public CompositeParser() {
        this(new MediaTypeRegistry(), new Parser[0]);
    }
}
