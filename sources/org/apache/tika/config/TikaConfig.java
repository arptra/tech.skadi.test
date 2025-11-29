package org.apache.tika.config;

import com.upuphone.starrynet.payload.PayloadConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.tika.concurrent.ConfigurableThreadPoolExecutor;
import org.apache.tika.concurrent.SimpleThreadPoolExecutor;
import org.apache.tika.detect.CompositeDetector;
import org.apache.tika.detect.CompositeEncodingDetector;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.language.translate.DefaultTranslator;
import org.apache.tika.language.translate.Translator;
import org.apache.tika.metadata.filter.MetadataFilter;
import org.apache.tika.metadata.filter.NoOpFilter;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeTypesFactory;
import org.apache.tika.parser.AbstractEncodingDetectorParser;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.AutoDetectParserConfig;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.DefaultParser;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;
import org.apache.tika.parser.RenderingParser;
import org.apache.tika.parser.multiple.AbstractMultipleParser;
import org.apache.tika.renderer.CompositeRenderer;
import org.apache.tika.renderer.Renderer;
import org.apache.tika.utils.StringUtils;
import org.apache.tika.utils.XMLReaderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TikaConfig {
    public static final AtomicInteger k = new AtomicInteger();
    public static final Logger l = LoggerFactory.k(TikaConfig.class);

    /* renamed from: a  reason: collision with root package name */
    public final ServiceLoader f4138a;
    public final CompositeParser b;
    public final CompositeDetector c;
    public final Translator d;
    public final MimeTypes e;
    public final ExecutorService f;
    public final EncodingDetector g;
    public final Renderer h;
    public final MetadataFilter i;
    public final AutoDetectParserConfig j;

    public static class DetectorXmlLoader extends XmlLoader<CompositeDetector, Detector> {
        public DetectorXmlLoader() {
            super();
        }

        public Class e() {
            return Detector.class;
        }

        public String f() {
            return "detector";
        }

        public String h() {
            return "detectors";
        }

        public boolean i(Class cls) {
            return CompositeDetector.class.isAssignableFrom(cls);
        }

        public boolean o() {
            return true;
        }

        /* renamed from: p */
        public CompositeDetector b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return new CompositeDetector(mimeTypes.getMediaTypeRegistry(), list);
        }

        /* renamed from: q */
        public Detector a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            Detector detector;
            Class<Collection> cls2 = Collection.class;
            MediaTypeRegistry mediaTypeRegistry = mimeTypes.getMediaTypeRegistry();
            try {
                detector = (Detector) cls.getConstructor(new Class[]{MimeTypes.class, ServiceLoader.class, cls2}).newInstance(new Object[]{mimeTypes, serviceLoader, set});
            } catch (NoSuchMethodException unused) {
                detector = null;
            }
            Class<MediaTypeRegistry> cls3 = MediaTypeRegistry.class;
            Class<List> cls4 = List.class;
            if (detector == null) {
                try {
                    detector = (Detector) cls.getConstructor(new Class[]{cls3, cls4, cls2}).newInstance(new Object[]{mediaTypeRegistry, list, set});
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (detector == null) {
                try {
                    detector = (Detector) cls.getConstructor(new Class[]{cls3, cls4}).newInstance(new Object[]{mediaTypeRegistry, list});
                } catch (NoSuchMethodException unused3) {
                }
            }
            if (detector != null) {
                return detector;
            }
            try {
                return (Detector) cls.getConstructor(new Class[]{cls4}).newInstance(new Object[]{list});
            } catch (NoSuchMethodException unused4) {
                return detector;
            }
        }

        /* renamed from: r */
        public CompositeDetector c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.n(mimeTypes, serviceLoader);
        }

        /* renamed from: s */
        public Detector d(Detector detector, Element element) {
            return detector;
        }

        /* renamed from: t */
        public boolean j(Detector detector) {
            return detector instanceof CompositeDetector;
        }

        /* renamed from: u */
        public Detector n(Class cls, String str, MimeTypes mimeTypes) {
            if (MimeTypes.class.equals(cls)) {
                return mimeTypes;
            }
            return null;
        }
    }

    public static class EncodingDetectorXmlLoader extends XmlLoader<EncodingDetector, EncodingDetector> {
        public EncodingDetectorXmlLoader() {
            super();
        }

        public Class e() {
            return EncodingDetector.class;
        }

        public String f() {
            return "encodingDetector";
        }

        public String h() {
            return "encodingDetectors";
        }

        public boolean i(Class cls) {
            return CompositeEncodingDetector.class.isAssignableFrom(cls);
        }

        public boolean o() {
            return true;
        }

        /* renamed from: p */
        public CompositeEncodingDetector b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return new CompositeEncodingDetector(list);
        }

        /* renamed from: q */
        public EncodingDetector a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            EncodingDetector encodingDetector;
            try {
                encodingDetector = (EncodingDetector) cls.getConstructor(new Class[]{ServiceLoader.class, Collection.class}).newInstance(new Object[]{serviceLoader, set});
            } catch (NoSuchMethodException unused) {
                TikaConfig.l.debug("couldn't find constructor for service loader + collection for {}", (Object) cls);
                encodingDetector = null;
            }
            if (encodingDetector != null) {
                return encodingDetector;
            }
            try {
                return (EncodingDetector) cls.getConstructor(new Class[]{List.class}).newInstance(new Object[]{list});
            } catch (NoSuchMethodException unused2) {
                TikaConfig.l.debug("couldn't find constructor for EncodingDetector(List) for {}", (Object) cls);
                return encodingDetector;
            }
        }

        /* renamed from: r */
        public EncodingDetector c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.o(serviceLoader);
        }

        /* renamed from: s */
        public EncodingDetector d(EncodingDetector encodingDetector, Element element) {
            return encodingDetector;
        }

        /* renamed from: t */
        public boolean j(EncodingDetector encodingDetector) {
            return encodingDetector instanceof CompositeEncodingDetector;
        }

        /* renamed from: u */
        public EncodingDetector n(Class cls, String str, MimeTypes mimeTypes) {
            return null;
        }
    }

    public static class ExecutorServiceXmlLoader extends XmlLoader<ConfigurableThreadPoolExecutor, ConfigurableThreadPoolExecutor> {
        public ExecutorServiceXmlLoader() {
            super();
        }

        public Class e() {
            return ConfigurableThreadPoolExecutor.class;
        }

        public String f() {
            return "executor-service";
        }

        public String h() {
            return null;
        }

        public boolean i(Class cls) {
            return false;
        }

        public boolean o() {
            return false;
        }

        /* renamed from: p */
        public ConfigurableThreadPoolExecutor a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            throw new InstantiationException("Only one executor service supported");
        }

        /* renamed from: q */
        public ConfigurableThreadPoolExecutor b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return (ConfigurableThreadPoolExecutor) list.get(0);
        }

        /* renamed from: r */
        public ConfigurableThreadPoolExecutor c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.p();
        }

        /* renamed from: s */
        public ConfigurableThreadPoolExecutor d(ConfigurableThreadPoolExecutor configurableThreadPoolExecutor, Element element) {
            Element d = TikaConfig.k(element, "max-threads");
            if (d != null) {
                configurableThreadPoolExecutor.setMaximumPoolSize(Integer.parseInt(TikaConfig.z(d)));
            }
            Element d2 = TikaConfig.k(element, "core-threads");
            if (d2 != null) {
                configurableThreadPoolExecutor.setCorePoolSize(Integer.parseInt(TikaConfig.z(d2)));
            }
            return configurableThreadPoolExecutor;
        }

        /* renamed from: t */
        public boolean j(ConfigurableThreadPoolExecutor configurableThreadPoolExecutor) {
            return false;
        }

        /* renamed from: u */
        public ConfigurableThreadPoolExecutor k(Element element, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return (ConfigurableThreadPoolExecutor) super.k(element, mimeTypes, serviceLoader);
        }

        /* renamed from: v */
        public ConfigurableThreadPoolExecutor n(Class cls, String str, MimeTypes mimeTypes) {
            return null;
        }
    }

    public static class ParserXmlLoader extends XmlLoader<CompositeParser, Parser> {

        /* renamed from: a  reason: collision with root package name */
        public final EncodingDetector f4139a;
        public final Renderer b;

        public Class e() {
            return Parser.class;
        }

        public String f() {
            return "parser";
        }

        public String h() {
            return "parsers";
        }

        public boolean i(Class cls) {
            return CompositeParser.class.isAssignableFrom(cls) || AbstractMultipleParser.class.isAssignableFrom(cls) || ParserDecorator.class.isAssignableFrom(cls);
        }

        public boolean o() {
            return true;
        }

        /* renamed from: p */
        public CompositeParser b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return new CompositeParser(mimeTypes.getMediaTypeRegistry(), (List<Parser>) list);
        }

        /* renamed from: q */
        public Parser a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            Parser parser;
            Class<EncodingDetector> cls2 = EncodingDetector.class;
            Class<ServiceLoader> cls3 = ServiceLoader.class;
            Class<Collection> cls4 = Collection.class;
            Class<MediaTypeRegistry> cls5 = MediaTypeRegistry.class;
            MediaTypeRegistry mediaTypeRegistry = mimeTypes.getMediaTypeRegistry();
            try {
                parser = (Parser) cls.getConstructor(new Class[]{cls5, cls3, cls4, cls2, Renderer.class}).newInstance(new Object[]{mediaTypeRegistry, serviceLoader, set, this.f4139a, this.b});
            } catch (NoSuchMethodException unused) {
                parser = null;
            }
            if (parser == null) {
                try {
                    parser = (Parser) cls.getConstructor(new Class[]{cls5, cls3, cls4, cls2}).newInstance(new Object[]{mediaTypeRegistry, serviceLoader, set, this.f4139a});
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (parser == null) {
                try {
                    parser = (Parser) cls.getConstructor(new Class[]{cls5, cls3, cls4}).newInstance(new Object[]{mediaTypeRegistry, serviceLoader, set});
                } catch (NoSuchMethodException unused3) {
                }
            }
            Class<List> cls6 = List.class;
            if (parser == null) {
                try {
                    parser = (Parser) cls.getConstructor(new Class[]{cls5, cls6, cls4}).newInstance(new Object[]{mediaTypeRegistry, list, set});
                } catch (NoSuchMethodException unused4) {
                }
            }
            if (parser == null) {
                try {
                    parser = (Parser) cls.getConstructor(new Class[]{cls5, cls4, Map.class}).newInstance(new Object[]{mediaTypeRegistry, list, map});
                } catch (NoSuchMethodException unused5) {
                }
            }
            if (parser == null) {
                try {
                    parser = (Parser) cls.getConstructor(new Class[]{cls5, cls6}).newInstance(new Object[]{mediaTypeRegistry, list});
                } catch (NoSuchMethodException unused6) {
                }
            }
            if (parser != null || !ParserDecorator.class.isAssignableFrom(cls)) {
                return parser;
            }
            try {
                return (Parser) cls.getConstructor(new Class[]{Parser.class}).newInstance(new Object[]{(list.size() == 1 && set.size() == 0 && (list.get(0) instanceof CompositeParser)) ? (CompositeParser) list.get(0) : new CompositeParser(mediaTypeRegistry, list, set)});
            } catch (NoSuchMethodException unused7) {
                return parser;
            }
        }

        /* renamed from: r */
        public CompositeParser c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.r(mimeTypes, serviceLoader, this.f4139a, this.b);
        }

        /* renamed from: s */
        public Parser d(Parser parser, Element element) {
            Set a2 = TikaConfig.C(element, "mime");
            if (!a2.isEmpty()) {
                parser = ParserDecorator.withTypes(parser, a2);
            }
            Set a3 = TikaConfig.C(element, "mime-exclude");
            return !a3.isEmpty() ? ParserDecorator.withoutTypes(parser, a3) : parser;
        }

        /* renamed from: t */
        public boolean j(Parser parser) {
            return parser instanceof CompositeParser;
        }

        /* renamed from: u */
        public Parser m(Class cls) {
            Parser parser = AbstractEncodingDetectorParser.class.isAssignableFrom(cls) ? (Parser) cls.getConstructor(new Class[]{EncodingDetector.class}).newInstance(new Object[]{this.f4139a}) : (Parser) cls.newInstance();
            if (parser instanceof RenderingParser) {
                ((RenderingParser) parser).a(this.b);
            }
            return parser;
        }

        /* renamed from: v */
        public Parser n(Class cls, String str, MimeTypes mimeTypes) {
            if (!AutoDetectParser.class.isAssignableFrom(cls)) {
                return null;
            }
            throw new TikaException("AutoDetectParser not supported in a <parser> configuration element: " + str);
        }

        public ParserXmlLoader(EncodingDetector encodingDetector, Renderer renderer) {
            super();
            this.f4139a = encodingDetector;
            this.b = renderer;
        }
    }

    public static class RendererXmlLoader extends XmlLoader<Renderer, Renderer> {
        public RendererXmlLoader() {
            super();
        }

        public Class e() {
            return Renderer.class;
        }

        public String f() {
            return "renderer";
        }

        public String h() {
            return "renderers";
        }

        public boolean i(Class cls) {
            return CompositeRenderer.class.isAssignableFrom(cls);
        }

        public boolean o() {
            return true;
        }

        /* renamed from: p */
        public Renderer a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            Renderer renderer;
            try {
                renderer = (Renderer) cls.getConstructor(new Class[]{ServiceLoader.class, Collection.class}).newInstance(new Object[]{serviceLoader, set});
            } catch (NoSuchMethodException unused) {
                TikaConfig.l.debug("couldn't find constructor for service loader + collection for {}", (Object) null);
                renderer = null;
            }
            if (renderer != null) {
                return renderer;
            }
            try {
                return (Renderer) cls.getConstructor(new Class[]{List.class}).newInstance(new Object[]{list});
            } catch (NoSuchMethodException unused2) {
                TikaConfig.l.debug("couldn't find constructor for Renderer(List) for {}", (Object) cls);
                return renderer;
            }
        }

        /* renamed from: q */
        public Renderer b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return new CompositeRenderer((List<Renderer>) list);
        }

        /* renamed from: r */
        public Renderer c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.s(serviceLoader);
        }

        /* renamed from: s */
        public Renderer d(Renderer renderer, Element element) {
            return renderer;
        }

        /* renamed from: t */
        public boolean j(Renderer renderer) {
            return renderer instanceof CompositeRenderer;
        }

        /* renamed from: u */
        public Renderer n(Class cls, String str, MimeTypes mimeTypes) {
            return null;
        }
    }

    public static class TranslatorXmlLoader extends XmlLoader<Translator, Translator> {
        public TranslatorXmlLoader() {
            super();
        }

        public Class e() {
            return Translator.class;
        }

        public String f() {
            return "translator";
        }

        public String h() {
            return null;
        }

        public boolean i(Class cls) {
            return false;
        }

        public boolean o() {
            return false;
        }

        /* renamed from: p */
        public Translator a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            throw new InstantiationException("Only one translator supported");
        }

        /* renamed from: q */
        public Translator b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return (Translator) list.get(0);
        }

        /* renamed from: r */
        public Translator c(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            return TikaConfig.t(serviceLoader);
        }

        /* renamed from: s */
        public Translator d(Translator translator, Element element) {
            return translator;
        }

        /* renamed from: t */
        public boolean j(Translator translator) {
            return false;
        }

        /* renamed from: u */
        public Translator n(Class cls, String str, MimeTypes mimeTypes) {
            return null;
        }
    }

    public static abstract class XmlLoader<CT, T> {
        public XmlLoader() {
        }

        public abstract Object a(Class cls, List list, Set set, Map map, MimeTypes mimeTypes, ServiceLoader serviceLoader);

        public abstract Object b(List list, MimeTypes mimeTypes, ServiceLoader serviceLoader);

        public abstract Object c(MimeTypes mimeTypes, ServiceLoader serviceLoader);

        public abstract Object d(Object obj, Element element);

        public abstract Class e();

        public abstract String f();

        public Map g(Element element) {
            HashMap hashMap = new HashMap();
            Node firstChild = element.getFirstChild();
            while (true) {
                if (firstChild == null) {
                    break;
                } else if (!PayloadConstant.KEY_PARAMS.equals(firstChild.getNodeName())) {
                    firstChild = firstChild.getNextSibling();
                } else if (firstChild.hasChildNodes()) {
                    NodeList childNodes = firstChild.getChildNodes();
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node item = childNodes.item(i);
                        if (item.getNodeType() == 1) {
                            Param load = Param.load(item);
                            hashMap.put(load.getName(), load);
                        }
                    }
                }
            }
            return hashMap;
        }

        public abstract String h();

        public abstract boolean i(Class cls);

        public abstract boolean j(Object obj);

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x010a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x010b, code lost:
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
            throw new org.apache.tika.exception.TikaConfigException(r1.getMessage(), r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0136, code lost:
            throw new org.apache.tika.exception.TikaException("Unable to find the right constructor for " + f() + " class: " + r11, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
            throw new org.apache.tika.exception.TikaException("Unable to instantiate a " + f() + " class: " + r11, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0178, code lost:
            throw new org.apache.tika.exception.TikaException("Unable to create a " + f() + " class: " + r11, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0199, code lost:
            throw new org.apache.tika.exception.TikaException("Unable to access a " + f() + " class: " + r11, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a0, code lost:
            if (r19.e() != org.apache.tika.config.LoadErrorHandler.c) goto L_0x01a2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a2, code lost:
            r19.e().a(r11, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01aa, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01cb, code lost:
            throw new org.apache.tika.exception.TikaConfigException("Unable to find a " + f() + " class: " + r11, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c4 */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[Catch:{ Exception -> 0x010a, ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }, ExcHandler: NoSuchMethodException (r0v7 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:9:0x002c] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[Catch:{ Exception -> 0x010a, ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }, ExcHandler: InstantiationException (r0v6 'e' java.lang.InstantiationException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:9:0x002c] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[Catch:{ Exception -> 0x010a, ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }, ExcHandler: InvocationTargetException (r0v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:9:0x002c] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[Catch:{ Exception -> 0x010a, ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }, ExcHandler: IllegalAccessException (r0v4 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:9:0x002c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object k(org.w3c.dom.Element r17, org.apache.tika.mime.MimeTypes r18, org.apache.tika.config.ServiceLoader r19) {
            /*
                r16 = this;
                r8 = r16
                r0 = r17
                r6 = r18
                r9 = r19
                java.lang.String r10 = " class: "
                java.lang.String r1 = "class"
                java.lang.String r11 = r0.getAttribute(r1)
                if (r11 == 0) goto L_0x01cc
                java.lang.String r2 = "initializableProblemHandler"
                java.lang.String r2 = r0.getAttribute(r2)
                if (r2 == 0) goto L_0x0027
                int r3 = r2.length()
                if (r3 != 0) goto L_0x0021
                goto L_0x0027
            L_0x0021:
                org.apache.tika.config.InitializableProblemHandler r2 = org.apache.tika.config.TikaConfig.v(r2)
            L_0x0025:
                r12 = r2
                goto L_0x002c
            L_0x0027:
                org.apache.tika.config.InitializableProblemHandler r2 = r19.d()
                goto L_0x0025
            L_0x002c:
                java.lang.Class r2 = r16.e()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.Class r13 = r9.h(r2, r11)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.Object r2 = r8.n(r13, r11, r6)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r2 == 0) goto L_0x003b
                return r2
            L_0x003b:
                java.util.Map r14 = r16.g(r17)     // Catch:{ Exception -> 0x010a }
                boolean r2 = r8.i(r13)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r2 == 0) goto L_0x00ee
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r3.<init>()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r2 = r16.f()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                org.w3c.dom.NodeList r2 = r0.getElementsByTagName(r2)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                int r4 = r2.getLength()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r5 = 0
                if (r4 <= 0) goto L_0x0082
                r4 = r5
            L_0x005a:
                int r7 = r2.getLength()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r4 >= r7) goto L_0x0082
                org.w3c.dom.Node r7 = r2.item(r4)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                org.w3c.dom.Element r7 = (org.w3c.dom.Element) r7     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.Object r7 = r8.k(r7, r6, r9)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r7 == 0) goto L_0x007f
                r3.add(r7)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                goto L_0x007f
            L_0x0070:
                r0 = move-exception
                goto L_0x0116
            L_0x0073:
                r0 = move-exception
                goto L_0x0137
            L_0x0076:
                r0 = move-exception
                goto L_0x0158
            L_0x0079:
                r0 = move-exception
                goto L_0x0179
            L_0x007c:
                r0 = move-exception
                goto L_0x019a
            L_0x007f:
                int r4 = r4 + 1
                goto L_0x005a
            L_0x0082:
                java.util.HashSet r4 = new java.util.HashSet     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r4.<init>()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r2.<init>()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r7 = r16.f()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r2.append(r7)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r7 = "-exclude"
                r2.append(r7)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r2 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                org.w3c.dom.NodeList r2 = r0.getElementsByTagName(r2)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                int r7 = r2.getLength()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r7 <= 0) goto L_0x00db
            L_0x00a6:
                int r7 = r2.getLength()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r5 >= r7) goto L_0x00db
                org.w3c.dom.Node r7 = r2.item(r5)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                org.w3c.dom.Element r7 = (org.w3c.dom.Element) r7     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r7 = r7.getAttribute(r1)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.Class r15 = r16.e()     // Catch:{ ClassNotFoundException -> 0x00c4, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.Class r15 = r9.h(r15, r7)     // Catch:{ ClassNotFoundException -> 0x00c4, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r4.add(r15)     // Catch:{ ClassNotFoundException -> 0x00c4, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                int r5 = r5 + 1
                goto L_0x00a6
            L_0x00c4:
                org.apache.tika.exception.TikaConfigException r0 = new org.apache.tika.exception.TikaConfigException     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r1.<init>()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r2 = "Class not found in -exclude list: "
                r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r1.append(r7)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                throw r0     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
            L_0x00db:
                r1 = r16
                r2 = r13
                r5 = r14
                r6 = r18
                r7 = r19
                java.lang.Object r1 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r1 != 0) goto L_0x00f2
                java.lang.Object r1 = r8.m(r13)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                goto L_0x00f2
            L_0x00ee:
                java.lang.Object r1 = r8.m(r13)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
            L_0x00f2:
                org.apache.tika.utils.AnnotationUtils.b(r1, r14)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                boolean r2 = r1 instanceof org.apache.tika.config.Initializable     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                if (r2 == 0) goto L_0x0105
                r2 = r1
                org.apache.tika.config.Initializable r2 = (org.apache.tika.config.Initializable) r2     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r2.initialize(r14)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r2 = r1
                org.apache.tika.config.Initializable r2 = (org.apache.tika.config.Initializable) r2     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r2.checkInitialization(r12)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
            L_0x0105:
                java.lang.Object r0 = r8.d(r1, r0)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                return r0
            L_0x010a:
                r0 = move-exception
                r1 = r0
                org.apache.tika.exception.TikaConfigException r0 = new org.apache.tika.exception.TikaConfigException     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                java.lang.String r2 = r1.getMessage()     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                r0.<init>(r2, r1)     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
                throw r0     // Catch:{ ClassNotFoundException -> 0x007c, IllegalAccessException -> 0x0079, InvocationTargetException -> 0x0076, InstantiationException -> 0x0073, NoSuchMethodException -> 0x0070 }
            L_0x0116:
                org.apache.tika.exception.TikaException r1 = new org.apache.tika.exception.TikaException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to find the right constructor for "
                r2.append(r3)
                java.lang.String r3 = r16.f()
                r2.append(r3)
                r2.append(r10)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2, r0)
                throw r1
            L_0x0137:
                org.apache.tika.exception.TikaException r1 = new org.apache.tika.exception.TikaException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to instantiate a "
                r2.append(r3)
                java.lang.String r3 = r16.f()
                r2.append(r3)
                r2.append(r10)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2, r0)
                throw r1
            L_0x0158:
                org.apache.tika.exception.TikaException r1 = new org.apache.tika.exception.TikaException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to create a "
                r2.append(r3)
                java.lang.String r3 = r16.f()
                r2.append(r3)
                r2.append(r10)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2, r0)
                throw r1
            L_0x0179:
                org.apache.tika.exception.TikaException r1 = new org.apache.tika.exception.TikaException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to access a "
                r2.append(r3)
                java.lang.String r3 = r16.f()
                r2.append(r3)
                r2.append(r10)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2, r0)
                throw r1
            L_0x019a:
                org.apache.tika.config.LoadErrorHandler r1 = r19.e()
                org.apache.tika.config.LoadErrorHandler r2 = org.apache.tika.config.LoadErrorHandler.c
                if (r1 == r2) goto L_0x01ab
                org.apache.tika.config.LoadErrorHandler r1 = r19.e()
                r1.a(r11, r0)
                r0 = 0
                return r0
            L_0x01ab:
                org.apache.tika.exception.TikaConfigException r1 = new org.apache.tika.exception.TikaConfigException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to find a "
                r2.append(r3)
                java.lang.String r3 = r16.f()
                r2.append(r3)
                r2.append(r10)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2, r0)
                throw r1
            L_0x01cc:
                org.apache.tika.exception.TikaConfigException r1 = new org.apache.tika.exception.TikaConfigException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "class attribute must not be null: "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.config.TikaConfig.XmlLoader.k(org.w3c.dom.Element, org.apache.tika.mime.MimeTypes, org.apache.tika.config.ServiceLoader):java.lang.Object");
        }

        public Object l(Element element, MimeTypes mimeTypes, ServiceLoader serviceLoader) {
            ArrayList arrayList = new ArrayList();
            for (Element k : TikaConfig.A(element, h(), f())) {
                Object k2 = k(k, mimeTypes, serviceLoader);
                if (k2 != null) {
                    arrayList.add(k2);
                }
            }
            if (arrayList.isEmpty()) {
                return c(mimeTypes, serviceLoader);
            }
            if (arrayList.size() == 1) {
                Object obj = arrayList.get(0);
                if (j(obj)) {
                    return obj;
                }
            } else if (!o()) {
                if (arrayList.size() == 1) {
                    return arrayList.get(0);
                }
                if (arrayList.size() > 1) {
                    throw new TikaConfigException("Composite not supported for " + h() + ". Must specify only one child!");
                }
            }
            return b(arrayList, mimeTypes, serviceLoader);
        }

        public Object m(Class cls) {
            return cls.newInstance();
        }

        public abstract Object n(Class cls, String str, MimeTypes mimeTypes);

        public abstract boolean o();
    }

    public TikaConfig() {
        InputStream l2;
        String property = System.getProperty("tika.config");
        if (!StringUtils.a(property)) {
            l.debug("loading tika config from system property 'tika.config'");
        }
        if (property == null || property.trim().equals("")) {
            property = System.getenv("TIKA_CONFIG");
            if (!StringUtils.a(property)) {
                l.debug("loading tika config from environment variable 'TIKA_CONFIG'");
            }
        }
        if (property == null || property.trim().equals("")) {
            l.debug("loading tika config from defaults; no config file specified");
            ServiceLoader serviceLoader = new ServiceLoader();
            this.f4138a = serviceLoader;
            MimeTypes q = q(ServiceLoader.c());
            this.e = q;
            CompositeEncodingDetector o = o(serviceLoader);
            this.g = o;
            CompositeRenderer s = s(serviceLoader);
            this.h = s;
            this.b = r(q, serviceLoader, o, s);
            this.c = n(q, serviceLoader);
            this.d = t(serviceLoader);
            this.f = p();
            this.i = new NoOpFilter();
            this.j = AutoDetectParserConfig.DEFAULT;
        } else {
            ServiceLoader serviceLoader2 = new ServiceLoader();
            Logger logger = l;
            logger.debug("loading tika config from: " + property);
            try {
                l2 = l(property, serviceLoader2);
                Element documentElement = XMLReaderUtils.buildDOM(l2).getDocumentElement();
                H(documentElement);
                ServiceLoader F = F(documentElement, serviceLoader2.f());
                this.f4138a = F;
                DetectorXmlLoader detectorXmlLoader = new DetectorXmlLoader();
                EncodingDetectorXmlLoader encodingDetectorXmlLoader = new EncodingDetectorXmlLoader();
                RendererXmlLoader rendererXmlLoader = new RendererXmlLoader();
                TranslatorXmlLoader translatorXmlLoader = new TranslatorXmlLoader();
                ExecutorServiceXmlLoader executorServiceXmlLoader = new ExecutorServiceXmlLoader();
                MimeTypes G = G(documentElement);
                this.e = G;
                EncodingDetector encodingDetector = (EncodingDetector) encodingDetectorXmlLoader.l(documentElement, G, F);
                this.g = encodingDetector;
                Renderer renderer = (Renderer) rendererXmlLoader.l(documentElement, G, F);
                this.h = renderer;
                this.b = (CompositeParser) new ParserXmlLoader(encodingDetector, renderer).l(documentElement, G, F);
                this.c = (CompositeDetector) detectorXmlLoader.l(documentElement, G, F);
                this.d = (Translator) translatorXmlLoader.l(documentElement, G, F);
                this.f = (ExecutorService) executorServiceXmlLoader.l(documentElement, G, F);
                this.i = MetadataFilter.load(documentElement, true);
                this.j = AutoDetectParserConfig.load(documentElement);
                if (l2 != null) {
                    l2.close();
                }
            } catch (SAXException e2) {
                throw new TikaException("Specified Tika configuration has syntax errors: " + property, e2);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        k.incrementAndGet();
        return;
        throw th;
    }

    public static List A(Element element, String str, String str2) {
        Node node = element;
        if (str != null) {
            NodeList elementsByTagName = element.getElementsByTagName(str);
            if (elementsByTagName.getLength() <= 1) {
                node = elementsByTagName.getLength() == 1 ? elementsByTagName.item(0) : null;
            } else {
                throw new TikaException("Properties may not contain multiple " + str + " entries");
            }
        }
        if (node == null) {
            return Collections.emptyList();
        }
        NodeList childNodes = node.getChildNodes();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node item = childNodes.item(i2);
            if (item instanceof Element) {
                Element element2 = (Element) item;
                if (str2.equals(element2.getTagName())) {
                    arrayList.add(element2);
                }
            }
        }
        return arrayList;
    }

    public static Set C(Element element, String str) {
        NodeList childNodes = element.getChildNodes();
        HashSet hashSet = null;
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node item = childNodes.item(i2);
            if (item instanceof Element) {
                Element element2 = (Element) item;
                if (!str.equals(element2.getTagName())) {
                    continue;
                } else {
                    String z = z(element2);
                    MediaType parse = MediaType.parse(z);
                    if (parse != null) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(parse);
                    } else {
                        throw new TikaException("Invalid media type name: " + z);
                    }
                }
            }
        }
        return hashSet != null ? hashSet : Collections.emptySet();
    }

    public static void D(String str, String str2) {
        if (str2 == null || str2.trim().equals("")) {
            throw new IllegalArgumentException("parameter '" + str + "' must be set in the config file");
        }
    }

    public static void E(String str, Path path) {
        if (path == null) {
            throw new IllegalArgumentException("parameter '" + str + "' must be set in the config file");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        if (r3.toString().equalsIgnoreCase(r2) != false) goto L_0x0026;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.config.ServiceLoader F(org.w3c.dom.Element r5, java.lang.ClassLoader r6) {
        /*
            java.lang.String r0 = "service-loader"
            org.w3c.dom.Element r5 = k(r5, r0)
            if (r5 == 0) goto L_0x0056
            java.lang.String r0 = "dynamic"
            java.lang.String r0 = r5.getAttribute(r0)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            org.apache.tika.config.LoadErrorHandler r1 = org.apache.tika.config.LoadErrorHandler.c
            java.lang.String r2 = "loadErrorHandler"
            java.lang.String r2 = r5.getAttribute(r2)
            org.apache.tika.config.LoadErrorHandler r3 = org.apache.tika.config.LoadErrorHandler.b
            java.lang.String r4 = r3.toString()
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x0028
        L_0x0026:
            r1 = r3
            goto L_0x0040
        L_0x0028:
            java.lang.String r3 = r1.toString()
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x0033
            goto L_0x0040
        L_0x0033:
            org.apache.tika.config.LoadErrorHandler r3 = org.apache.tika.config.LoadErrorHandler.f4134a
            java.lang.String r4 = r3.toString()
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0040
            goto L_0x0026
        L_0x0040:
            java.lang.String r2 = "initializableProblemHandler"
            java.lang.String r5 = r5.getAttribute(r2)
            org.apache.tika.config.InitializableProblemHandler r5 = v(r5)
            if (r6 != 0) goto L_0x0050
            java.lang.ClassLoader r6 = org.apache.tika.config.ServiceLoader.c()
        L_0x0050:
            org.apache.tika.config.ServiceLoader r2 = new org.apache.tika.config.ServiceLoader
            r2.<init>(r6, r1, r5, r0)
            goto L_0x0063
        L_0x0056:
            if (r6 == 0) goto L_0x005e
            org.apache.tika.config.ServiceLoader r2 = new org.apache.tika.config.ServiceLoader
            r2.<init>(r6)
            goto L_0x0063
        L_0x005e:
            org.apache.tika.config.ServiceLoader r2 = new org.apache.tika.config.ServiceLoader
            r2.<init>()
        L_0x0063:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.config.TikaConfig.F(org.w3c.dom.Element, java.lang.ClassLoader):org.apache.tika.config.ServiceLoader");
    }

    public static MimeTypes G(Element element) {
        Element k2 = k(element, "mimeTypeRepository");
        return (k2 == null || !k2.hasAttribute("resource")) ? q((ClassLoader) null) : MimeTypesFactory.a(k2.getAttribute("resource"));
    }

    public static Element k(Element element, String str) {
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1 && str.equals(firstChild.getNodeName())) {
                return (Element) firstChild;
            }
        }
        return null;
    }

    public static InputStream l(String str, ServiceLoader serviceLoader) {
        InputStream inputStream;
        try {
            inputStream = new URL(str).openStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            inputStream = serviceLoader.g(str);
        }
        if (inputStream == null) {
            Path path = Paths.get(str, new String[0]);
            if (Files.isRegularFile(path, new LinkOption[0])) {
                inputStream = Files.newInputStream(path, new OpenOption[0]);
            }
        }
        if (inputStream != null) {
            return inputStream;
        }
        throw new TikaException("Specified Tika configuration not found: " + str);
    }

    public static TikaConfig m() {
        try {
            return new TikaConfig();
        } catch (IOException e2) {
            throw new RuntimeException("Unable to read default configuration", e2);
        } catch (TikaException e3) {
            throw new RuntimeException("Unable to access default configuration", e3);
        }
    }

    public static CompositeDetector n(MimeTypes mimeTypes, ServiceLoader serviceLoader) {
        return new DefaultDetector(mimeTypes, serviceLoader);
    }

    public static CompositeEncodingDetector o(ServiceLoader serviceLoader) {
        return new DefaultEncodingDetector(serviceLoader);
    }

    public static ConfigurableThreadPoolExecutor p() {
        return new SimpleThreadPoolExecutor();
    }

    public static MimeTypes q(ClassLoader classLoader) {
        return MimeTypes.getDefaultMimeTypes(classLoader);
    }

    public static CompositeParser r(MimeTypes mimeTypes, ServiceLoader serviceLoader, EncodingDetector encodingDetector, Renderer renderer) {
        return new DefaultParser(mimeTypes.getMediaTypeRegistry(), serviceLoader, encodingDetector, renderer);
    }

    public static CompositeRenderer s(ServiceLoader serviceLoader) {
        return new CompositeRenderer(serviceLoader);
    }

    public static Translator t(ServiceLoader serviceLoader) {
        return new DefaultTranslator(serviceLoader);
    }

    public static InitializableProblemHandler v(String str) {
        if (str == null || str.length() == 0) {
            return InitializableProblemHandler.e;
        }
        InitializableProblemHandler initializableProblemHandler = InitializableProblemHandler.f4133a;
        if (initializableProblemHandler.toString().equalsIgnoreCase(str)) {
            return initializableProblemHandler;
        }
        InitializableProblemHandler initializableProblemHandler2 = InitializableProblemHandler.b;
        if (initializableProblemHandler2.toString().equalsIgnoreCase(str)) {
            return initializableProblemHandler2;
        }
        InitializableProblemHandler initializableProblemHandler3 = InitializableProblemHandler.c;
        if (initializableProblemHandler3.toString().equalsIgnoreCase(str)) {
            return initializableProblemHandler3;
        }
        InitializableProblemHandler initializableProblemHandler4 = InitializableProblemHandler.d;
        if (initializableProblemHandler4.toString().equalsIgnoreCase(str)) {
            return initializableProblemHandler4;
        }
        throw new TikaConfigException(String.format(Locale.US, "Couldn't parse non-null '%s'. Must be one of 'ignore', 'info', 'warn' or 'throw'", new Object[]{str}));
    }

    public static String z(Node node) {
        if (node.getNodeType() == 3) {
            return node.getNodeValue();
        }
        if (node.getNodeType() != 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            sb.append(z(childNodes.item(i2)));
        }
        return sb.toString();
    }

    public Translator B() {
        return this.d;
    }

    public final void H(Element element) {
        Element k2 = k(element, "xml-reader-utils");
        if (k2 != null) {
            if (k2.hasAttribute("maxEntityExpansions")) {
                XMLReaderUtils.setMaxEntityExpansions(Integer.parseInt(k2.getAttribute("maxEntityExpansions")));
            }
            if (k2.hasAttribute("poolSize")) {
                XMLReaderUtils.setPoolSize(Integer.parseInt(k2.getAttribute("poolSize")));
            }
        }
    }

    public AutoDetectParserConfig j() {
        return this.j;
    }

    public Detector u() {
        return this.c;
    }

    public MediaTypeRegistry w() {
        return this.e.getMediaTypeRegistry();
    }

    public MimeTypes x() {
        return this.e;
    }

    public Parser y() {
        return this.b;
    }
}
