package org.apache.tika.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.utils.ServiceLoaderUtils;

public class CompositeRenderer implements Renderer, Initializable {
    private Map<MediaType, Renderer> rendererMap;

    public CompositeRenderer(ServiceLoader serviceLoader) {
        this(getDefaultRenderers(serviceLoader));
    }

    private static List<Renderer> getDefaultRenderers(ServiceLoader serviceLoader) {
        List<Renderer> m = serviceLoader.m(Renderer.class);
        ServiceLoaderUtils.b(m);
        return m;
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) throws TikaConfigException {
    }

    public Renderer getLeafRenderer(MediaType mediaType) {
        return this.rendererMap.get(mediaType);
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.rendererMap.keySet();
    }

    public void initialize(Map<String, Param> map) throws TikaConfigException {
    }

    public RenderResults render(InputStream inputStream, Metadata metadata, ParseContext parseContext, RenderRequest... renderRequestArr) throws IOException, TikaException {
        String str = metadata.get(TikaCoreProperties.K);
        if (str != null) {
            MediaType parse = MediaType.parse(str);
            if (parse != null) {
                Renderer renderer = this.rendererMap.get(parse);
                if (renderer != null) {
                    return renderer.render(inputStream, metadata, parseContext, renderRequestArr);
                }
                throw new TikaException("I regret I can't find a renderer for " + parse);
            }
            throw new TikaException("can't parse mediaType: " + str);
        }
        throw new TikaException("need to specify file type in metadata");
    }

    public CompositeRenderer(List<Renderer> list) {
        this.rendererMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ParseContext parseContext = new ParseContext();
        for (Renderer next : list) {
            for (MediaType put : next.getSupportedTypes(parseContext)) {
                concurrentHashMap.put(put, next);
            }
        }
        this.rendererMap = Collections.unmodifiableMap(concurrentHashMap);
    }
}
