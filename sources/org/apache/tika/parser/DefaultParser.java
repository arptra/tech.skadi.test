package org.apache.tika.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.renderer.CompositeRenderer;
import org.apache.tika.renderer.Renderer;
import org.apache.tika.utils.ServiceLoaderUtils;

public class DefaultParser extends CompositeParser {
    private static final long serialVersionUID = 3612324825403757520L;
    private final transient ServiceLoader loader;

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry, ServiceLoader serviceLoader, Collection<Class<? extends Parser>> collection, EncodingDetector encodingDetector, Renderer renderer) {
        super(mediaTypeRegistry, getDefaultParsers(serviceLoader, encodingDetector, renderer, collection));
        this.loader = serviceLoader;
    }

    private static List<Parser> getDefaultParsers(ServiceLoader serviceLoader, EncodingDetector encodingDetector, Renderer renderer, Collection<Class<? extends Parser>> collection) {
        List<Parser> n = serviceLoader.n(Parser.class, collection);
        if (encodingDetector != null) {
            for (Parser encodingDetector2 : n) {
                setEncodingDetector(encodingDetector2, encodingDetector);
            }
        }
        if (renderer != null) {
            for (Parser renderer2 : n) {
                setRenderer(renderer2, renderer);
            }
        }
        ServiceLoaderUtils.b(n);
        Collections.reverse(n);
        return n;
    }

    private static void setEncodingDetector(Parser parser, EncodingDetector encodingDetector) {
        if (parser instanceof AbstractEncodingDetectorParser) {
            ((AbstractEncodingDetectorParser) parser).setEncodingDetector(encodingDetector);
        } else if (parser instanceof CompositeParser) {
            for (Parser encodingDetector2 : ((CompositeParser) parser).getAllComponentParsers()) {
                setEncodingDetector(encodingDetector2, encodingDetector);
            }
        } else if (parser instanceof ParserDecorator) {
            setEncodingDetector(((ParserDecorator) parser).getWrappedParser(), encodingDetector);
        }
    }

    private static void setRenderer(Parser parser, Renderer renderer) {
        if (parser instanceof RenderingParser) {
            ((RenderingParser) parser).a(renderer);
        } else if (parser instanceof CompositeParser) {
            for (Parser renderer2 : ((CompositeParser) parser).getAllComponentParsers()) {
                setRenderer(renderer2, renderer);
            }
        } else if (parser instanceof ParserDecorator) {
            setRenderer(((ParserDecorator) parser).getWrappedParser(), renderer);
        }
    }

    public List<Parser> getAllComponentParsers() {
        List<Parser> allComponentParsers = super.getAllComponentParsers();
        if (this.loader == null) {
            return allComponentParsers;
        }
        ArrayList arrayList = new ArrayList(allComponentParsers);
        arrayList.addAll(this.loader.k(Parser.class));
        return arrayList;
    }

    public Map<MediaType, Parser> getParsers(ParseContext parseContext) {
        Map<MediaType, Parser> parsers = super.getParsers(parseContext);
        if (this.loader != null) {
            MediaTypeRegistry mediaTypeRegistry = getMediaTypeRegistry();
            List<Parser> k = this.loader.k(Parser.class);
            Collections.reverse(k);
            for (Parser parser : k) {
                for (MediaType normalize : parser.getSupportedTypes(parseContext)) {
                    parsers.put(mediaTypeRegistry.normalize(normalize), parser);
                }
            }
        }
        return parsers;
    }

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry, ServiceLoader serviceLoader, Collection<Class<? extends Parser>> collection) {
        super(mediaTypeRegistry, getDefaultParsers(serviceLoader, new DefaultEncodingDetector(serviceLoader), new CompositeRenderer(serviceLoader), collection));
        this.loader = serviceLoader;
    }

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry, ServiceLoader serviceLoader, EncodingDetector encodingDetector, Renderer renderer) {
        this(mediaTypeRegistry, serviceLoader, Collections.EMPTY_SET, encodingDetector, renderer);
    }

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry, ServiceLoader serviceLoader) {
        this(mediaTypeRegistry, serviceLoader, Collections.EMPTY_SET, new DefaultEncodingDetector(serviceLoader), new CompositeRenderer(serviceLoader));
    }

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry, ClassLoader classLoader) {
        this(mediaTypeRegistry, new ServiceLoader(classLoader));
    }

    public DefaultParser(ClassLoader classLoader) {
        this(MediaTypeRegistry.getDefaultRegistry(), new ServiceLoader(classLoader));
    }

    public DefaultParser(MediaTypeRegistry mediaTypeRegistry) {
        this(mediaTypeRegistry, new ServiceLoader());
    }

    public DefaultParser() {
        this(MediaTypeRegistry.getDefaultRegistry());
    }
}
