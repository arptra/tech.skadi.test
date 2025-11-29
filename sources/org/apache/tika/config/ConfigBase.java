package org.apache.tika.config;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.utils.XMLReaderUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class ConfigBase {
    private static Class[] SUPPORTED_PRIMITIVES = {String.class, Boolean.TYPE, Long.TYPE, Integer.TYPE, Double.TYPE, Float.TYPE};

    public static class SetterClassPair {

        /* renamed from: a  reason: collision with root package name */
        public final Method f4132a;
        public final Class b;

        public SetterClassPair(Method method, Class cls) {
            this.f4132a = method;
            this.b = cls;
        }

        public String toString() {
            return "SetterClassPair{setterMethod=" + this.f4132a + ", itemClass=" + this.b + '}';
        }
    }

    public static Object a(Node node, String str, Class cls) {
        String name = cls.getName();
        Node namedItem = node.getAttributes().getNamedItem("class");
        if (namedItem != null) {
            name = namedItem.getTextContent();
        }
        try {
            Class<?> cls2 = Class.forName(name);
            if (cls.isAssignableFrom(cls2)) {
                return cls2.newInstance();
            }
            throw new TikaConfigException(str + " with class name " + name + " must be of type '" + cls.getName() + "'");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new TikaConfigException("problem loading " + str + " with class " + cls.getName(), e);
        }
    }

    public static SetterClassPair b(Object obj, String str) {
        Class<String> cls;
        String str2 = "set" + str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
        Method[] methods = obj.getClass().getMethods();
        int length = methods.length;
        Method method = null;
        int i = 0;
        Class cls2 = null;
        while (true) {
            cls = String.class;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (str2.equals(method2.getName())) {
                Class[] parameterTypes = method2.getParameterTypes();
                if (parameterTypes.length == 1 && (cls2 == null || parameterTypes[0].equals(cls))) {
                    cls2 = parameterTypes[0];
                    method = method2;
                }
            }
            i++;
        }
        if (method != null && cls2 != null) {
            return new SetterClassPair(method, cls2);
        }
        String str3 = "add" + str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
        for (Method method3 : obj.getClass().getMethods()) {
            if (str3.equals(method3.getName())) {
                Class[] parameterTypes2 = method3.getParameterTypes();
                if (parameterTypes2.length == 1 && (cls2 == null || parameterTypes2[0].equals(cls))) {
                    cls2 = parameterTypes2[0];
                    method = method3;
                }
            }
        }
        if (method != null || cls2 != null) {
            return new SetterClassPair(method, cls2);
        }
        throw new TikaConfigException("Couldn't find setter '" + str2 + "' or adder '" + str3 + "' for " + str + " of class: " + obj.getClass());
    }

    public static <P, T> P buildComposite(String str, Class<P> cls, String str2, Class<T> cls2, InputStream inputStream) throws TikaConfigException, IOException {
        try {
            return buildComposite(str, cls, str2, cls2, XMLReaderUtils.buildDOM(inputStream).getDocumentElement());
        } catch (SAXException e) {
            throw new IOException(e);
        } catch (TikaException e2) {
            throw new TikaConfigException("problem loading xml to dom", e2);
        }
    }

    public static <T> T buildSingle(String str, Class<T> cls, InputStream inputStream) throws TikaConfigException, IOException {
        try {
            Element documentElement = XMLReaderUtils.buildDOM(inputStream).getDocumentElement();
            if (documentElement.getLocalName().equals("properties")) {
                return buildSingle(str, cls, documentElement, (Object) null);
            }
            throw new TikaConfigException("expect properties as root node");
        } catch (SAXException e) {
            throw new IOException(e);
        } catch (TikaException e2) {
            throw new TikaConfigException("problem loading xml to dom", e2);
        }
    }

    public static boolean c(Node node) {
        return node.hasAttributes() && node.getAttributes().getNamedItem("class") != null;
    }

    public static boolean d(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && item.hasAttributes()) {
                if (item.getAttributes().getNamedItem("from") != null && item.getAttributes().getNamedItem("to") != null) {
                    return true;
                }
                if (!(item.getAttributes().getNamedItem("k") == null || item.getAttributes().getNamedItem(ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION) == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean i(Class cls) {
        int i = 0;
        while (true) {
            Class[] clsArr = SUPPORTED_PRIMITIVES;
            if (i >= clsArr.length) {
                return false;
            }
            if (clsArr[i].equals(cls)) {
                return true;
            }
            i++;
        }
    }

    public static List j(Node node, String str, Class cls) {
        NodeList childNodes = node.getChildNodes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && str.equals(item.getLocalName())) {
                Object a2 = a(item, str, cls);
                n(a2, item, new HashSet());
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static void n(Object obj, Node node, Set set) {
        r(obj, node, set, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ea A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void r(java.lang.Object r9, org.w3c.dom.Node r10, java.util.Set r11, java.lang.String r12) {
        /*
            org.w3c.dom.NodeList r10 = r10.getChildNodes()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x000b:
            int r3 = r10.getLength()
            if (r2 >= r3) goto L_0x003c
            org.w3c.dom.Node r3 = r10.item(r2)
            java.lang.String r4 = r3.getLocalName()
            java.lang.String r5 = "params"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0036
            org.w3c.dom.NodeList r3 = r3.getChildNodes()
            r4 = r1
        L_0x0026:
            int r5 = r3.getLength()
            if (r4 >= r5) goto L_0x0039
            org.w3c.dom.Node r5 = r3.item(r4)
            r0.add(r5)
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0036:
            r0.add(r3)
        L_0x0039:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x003c:
            int r10 = r0.size()
            if (r1 >= r10) goto L_0x00ee
            java.lang.Object r10 = r0.get(r1)
            org.w3c.dom.Node r10 = (org.w3c.dom.Node) r10
            short r2 = r10.getNodeType()
            r3 = 1
            if (r2 == r3) goto L_0x0051
            goto L_0x00ea
        L_0x0051:
            java.lang.String r2 = r10.getLocalName()
            if (r2 == 0) goto L_0x00ea
            boolean r3 = r2.equals(r12)
            if (r3 == 0) goto L_0x005f
            goto L_0x00ea
        L_0x005f:
            java.lang.String r3 = r10.getTextContent()
            java.lang.String r4 = r10.getLocalName()
            org.apache.tika.config.ConfigBase$SetterClassPair r5 = b(r9, r4)
            boolean r6 = c(r10)
            if (r6 != 0) goto L_0x0097
            java.lang.Class r6 = r5.b
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r6 = r6.isAssignableFrom(r7)
            if (r6 == 0) goto L_0x0087
            boolean r6 = d(r10)
            if (r6 == 0) goto L_0x0087
            v(r9, r10)
            goto L_0x00cc
        L_0x0087:
            java.lang.Class r6 = r5.b
            java.lang.Class<java.util.List> r7 = java.util.List.class
            boolean r6 = r6.isAssignableFrom(r7)
            if (r6 == 0) goto L_0x0097
            u(r9, r10)
            goto L_0x00cc
        L_0x0097:
            java.lang.Class r6 = r5.b
            boolean r6 = i(r6)
            if (r6 == 0) goto L_0x00a9
            java.lang.String r10 = r10.getTextContent()
            w(r9, r5, r10)
            goto L_0x00cc
        L_0x00a9:
            java.lang.Class r6 = r5.b
            java.lang.Object r6 = a(r10, r4, r6)
            java.lang.Class r7 = r5.b
            java.lang.Object r7 = r7.cast(r6)
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            n(r7, r10, r8)
            java.lang.reflect.Method r10 = r5.f4132a     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00d2 }
            java.lang.Object[] r5 = new java.lang.Object[]{r6}     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00d2 }
            r10.invoke(r9, r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00d2 }
        L_0x00cc:
            if (r3 == 0) goto L_0x00ea
            r11.add(r2)
            goto L_0x00ea
        L_0x00d2:
            r9 = move-exception
            org.apache.tika.exception.TikaConfigException r10 = new org.apache.tika.exception.TikaConfigException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "problem creating "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11, r9)
            throw r10
        L_0x00ea:
            int r1 = r1 + 1
            goto L_0x003c
        L_0x00ee:
            boolean r10 = r9 instanceof org.apache.tika.config.Initializable
            if (r10 == 0) goto L_0x00fe
            org.apache.tika.config.Initializable r9 = (org.apache.tika.config.Initializable) r9
            java.util.Map r10 = java.util.Collections.EMPTY_MAP
            r9.initialize(r10)
            org.apache.tika.config.InitializableProblemHandler r10 = org.apache.tika.config.InitializableProblemHandler.d
            r9.checkInitialization(r10)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.config.ConfigBase.r(java.lang.Object, org.w3c.dom.Node, java.util.Set, java.lang.String):void");
    }

    public static void s(Object obj, Node node) {
        String localName = node.getLocalName();
        try {
            Class<?> cls = Class.forName(node.getAttributes().getNamedItem("class").getTextContent());
            ArrayList arrayList = new ArrayList();
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Object a2 = a(item, item.getLocalName(), cls);
                    n(a2, item, new HashSet());
                    arrayList.add(a2);
                }
            }
            obj.getClass().getMethod("set" + localName.substring(0, 1).toUpperCase(Locale.US) + localName.substring(1), new Class[]{List.class}).invoke(obj, new Object[]{arrayList});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new TikaConfigException("couldn't build class for " + localName, e);
        }
    }

    public static void u(Object obj, Node node) {
        if (c(node)) {
            s(obj, node);
        } else {
            z(obj, node);
        }
    }

    public static void v(Object obj, Node node) {
        String localName = node.getLocalName();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                NamedNodeMap attributes = item.getAttributes();
                String str = null;
                String textContent = attributes.getNamedItem("from") != null ? attributes.getNamedItem("from").getTextContent() : attributes.getNamedItem(IntentKey.ACTIVITY.ACTION_KEY) != null ? attributes.getNamedItem(IntentKey.ACTIVITY.ACTION_KEY).getTextContent() : attributes.getNamedItem("k") != null ? attributes.getNamedItem("k").getTextContent() : null;
                if (attributes.getNamedItem("to") != null) {
                    str = attributes.getNamedItem("to").getTextContent();
                } else if (attributes.getNamedItem(AccountConstantKt.RESPONSE_VALUE) != null) {
                    str = attributes.getNamedItem(AccountConstantKt.RESPONSE_VALUE).getTextContent();
                } else if (attributes.getNamedItem(ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION) != null) {
                    str = attributes.getNamedItem(ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION).getTextContent();
                }
                if (textContent == null) {
                    throw new TikaConfigException("must specify a 'key' or 'from' value in a map object : " + node);
                } else if (str != null) {
                    linkedHashMap.put(textContent, str);
                } else {
                    throw new TikaConfigException("must specify a 'value' or 'to' value in a map object : " + node);
                }
            }
        }
        try {
            obj.getClass().getMethod("set" + localName.substring(0, 1).toUpperCase(Locale.US) + localName.substring(1), new Class[]{Map.class}).invoke(obj, new Object[]{linkedHashMap});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new TikaConfigException("can't set " + localName, e);
        }
    }

    public static void w(Object obj, SetterClassPair setterClassPair, String str) {
        try {
            if (setterClassPair.b == Integer.TYPE) {
                setterClassPair.f4132a.invoke(obj, new Object[]{Integer.valueOf(Integer.parseInt(str))});
            } else if (setterClassPair.b == Long.TYPE) {
                setterClassPair.f4132a.invoke(obj, new Object[]{Long.valueOf(Long.parseLong(str))});
            } else if (setterClassPair.b == Float.TYPE) {
                setterClassPair.f4132a.invoke(obj, new Object[]{Float.valueOf(Float.parseFloat(str))});
            } else if (setterClassPair.b == Double.TYPE) {
                setterClassPair.f4132a.invoke(obj, new Object[]{Double.valueOf(Double.parseDouble(str))});
            } else if (setterClassPair.b == Boolean.TYPE) {
                setterClassPair.f4132a.invoke(obj, new Object[]{Boolean.valueOf(Boolean.parseBoolean(str))});
            } else {
                setterClassPair.f4132a.invoke(obj, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new TikaConfigException("bad parameter " + setterClassPair + " " + str, e);
        }
    }

    public static void z(Object obj, Node node) {
        String textContent;
        String localName = node.getLocalName();
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && (textContent = item.getTextContent()) != null) {
                arrayList.add(textContent);
            }
        }
        try {
            obj.getClass().getMethod("set" + localName.substring(0, 1).toUpperCase(Locale.US) + localName.substring(1), new Class[]{List.class}).invoke(obj, new Object[]{arrayList});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new TikaConfigException("can't set " + localName, e);
        }
    }

    public Set<String> configure(String str, InputStream inputStream) throws TikaConfigException, IOException {
        HashSet hashSet = new HashSet();
        try {
            Element documentElement = XMLReaderUtils.buildDOM(inputStream).getDocumentElement();
            if (documentElement.getLocalName().equals("properties")) {
                NodeList childNodes = documentElement.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node item = childNodes.item(i);
                    if (str.equals(item.getLocalName())) {
                        n(this, item, hashSet);
                    }
                }
                return hashSet;
            }
            throw new TikaConfigException("expect properties as root node");
        } catch (SAXException e) {
            throw new IOException(e);
        } catch (TikaException e2) {
            throw new TikaConfigException("problem loading xml to dom", e2);
        }
    }

    public void handleSettings(Set<String> set) {
    }

    public static <P, T> P buildComposite(String str, Class<P> cls, String str2, Class<T> cls2, Element element) throws TikaConfigException, IOException {
        if (element.getLocalName().equals("properties")) {
            NodeList childNodes = element.getChildNodes();
            int i = 0;
            while (i < childNodes.getLength()) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1 && str.equals(item.getLocalName())) {
                    try {
                        P newInstance = cls.getConstructor(new Class[]{List.class}).newInstance(new Object[]{j(item, str2, cls2)});
                        r(newInstance, item, new HashSet(), str2);
                        return newInstance;
                    } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                        throw new TikaConfigException("can't build composite class", e);
                    }
                } else {
                    i++;
                }
            }
            throw new TikaConfigException("could not find " + str);
        }
        throw new TikaConfigException("expect properties as root node");
    }

    public static <T> T buildSingle(String str, Class<T> cls, Element element, T t) throws TikaConfigException, IOException {
        NodeList childNodes = element.getChildNodes();
        T t2 = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && str.equals(item.getLocalName())) {
                if (t2 == null) {
                    t2 = a(item, str, cls);
                    n(t2, item, new HashSet());
                } else {
                    throw new TikaConfigException("There can only be one " + str + " in a config");
                }
            }
        }
        if (t2 != null) {
            return t2;
        }
        if (t != null) {
            return t;
        }
        throw new TikaConfigException("could not find " + str);
    }
}
