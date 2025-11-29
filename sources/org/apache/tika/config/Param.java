package org.apache.tika.config;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.multiple.AbstractMultipleParser;
import org.apache.tika.utils.XMLReaderUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Param<T> implements Serializable {
    private static final String CLASS = "class";
    private static final String LIST = "list";
    private static final String MAP = "map";
    private static final Map<Class<?>, String> map;
    private static final Map<String, Class<?>> reverseMap = new HashMap();
    private static final Map<String, Class<?>> wellKnownMap = new HashMap();
    private T actualValue;
    private String name;
    private Class<T> type;
    private final Map<String, String> valueMap;
    private final List<String> valueStrings;

    static {
        HashMap hashMap = new HashMap();
        map = hashMap;
        hashMap.put(Boolean.class, "bool");
        hashMap.put(String.class, "string");
        hashMap.put(Byte.class, "byte");
        hashMap.put(Short.class, "short");
        hashMap.put(Integer.class, "int");
        hashMap.put(Long.class, "long");
        hashMap.put(BigInteger.class, "bigint");
        hashMap.put(Float.class, "float");
        hashMap.put(Double.class, "double");
        hashMap.put(File.class, "file");
        hashMap.put(URI.class, "uri");
        hashMap.put(URL.class, "url");
        hashMap.put(ArrayList.class, LIST);
        hashMap.put(Map.class, MAP);
        for (Map.Entry entry : hashMap.entrySet()) {
            reverseMap.put((String) entry.getValue(), (Class) entry.getKey());
        }
        wellKnownMap.put("metadataPolicy", AbstractMultipleParser.MetadataPolicy.class);
    }

    public Param() {
        this.valueStrings = new ArrayList();
        this.valueMap = new LinkedHashMap();
    }

    private static <T> Class<T> classFromType(String str) {
        Map<String, Class<?>> map2 = reverseMap;
        if (map2.containsKey(str)) {
            return map2.get(str);
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T getTypedValue(Class<T> cls, String str) {
        try {
            if (cls.isEnum()) {
                return Enum.valueOf(cls, str);
            }
            Constructor<T> constructor = cls.getConstructor(new Class[]{String.class});
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[]{str});
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(cls + " doesnt have a constructor that takes String arg", e);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static <T> Param<T> load(InputStream inputStream) throws SAXException, IOException, TikaException {
        return load(XMLReaderUtils.getDocumentBuilder().parse(inputStream).getFirstChild());
    }

    private static <T> void loadList(Param<T> param, Node node) {
        param.actualValue = new ArrayList();
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                ((List) param.actualValue).add(getTypedValue(classFromType(firstChild.getLocalName()), firstChild.getTextContent()));
                param.valueStrings.add(firstChild.getTextContent());
            }
        }
    }

    private static <T> void loadMap(Param<T> param, Node node) throws TikaConfigException {
        String str;
        String str2;
        param.actualValue = new HashMap();
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                if (firstChild.getAttributes().getNamedItem(IntentKey.ACTIVITY.ACTION_KEY) != null) {
                    str2 = firstChild.getAttributes().getNamedItem(IntentKey.ACTIVITY.ACTION_KEY).getNodeValue();
                    str = firstChild.getAttributes().getNamedItem(AccountConstantKt.RESPONSE_VALUE) != null ? firstChild.getAttributes().getNamedItem(AccountConstantKt.RESPONSE_VALUE).getNodeValue() : firstChild.getTextContent();
                } else {
                    str2 = firstChild.getLocalName();
                    str = firstChild.getTextContent();
                }
                if (!((Map) param.actualValue).containsKey(str2)) {
                    ((Map) param.actualValue).put(str2, str);
                    param.valueMap.put(str2, str);
                } else {
                    throw new TikaConfigException("Duplicate keys are not allowed: " + str2);
                }
            }
        }
    }

    private static <T> void loadObject(Param<T> param, Node node, Class cls) throws TikaConfigException {
        try {
            param.actualValue = cls.newInstance();
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (PayloadConstant.KEY_PARAMS.equals(item.getLocalName())) {
                    NodeList childNodes2 = item.getChildNodes();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        if ("param".equals(childNodes2.item(i2).getLocalName())) {
                            Param load = load(childNodes2.item(i2));
                            String str = "set" + load.getName().substring(0, 1).toUpperCase(Locale.US) + load.getName().substring(1);
                            try {
                                try {
                                    param.actualValue.getClass().getMethod(str, new Class[]{load.getType()}).invoke(param.actualValue, new Object[]{load.getValue()});
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    throw new TikaConfigException("can't set param value: " + load.getName(), e);
                                }
                            } catch (NoSuchMethodException e2) {
                                throw new TikaConfigException("can't find method: " + str, e2);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InstantiationException e3) {
            throw new TikaConfigException("can't build class: " + cls, e3);
        }
    }

    public String getName() {
        return this.name;
    }

    public Class<T> getType() {
        return this.type;
    }

    public String getTypeString() {
        Class<T> cls = this.type;
        if (cls == null) {
            return null;
        }
        if (List.class.isAssignableFrom(cls)) {
            return LIST;
        }
        Map<Class<?>, String> map2 = map;
        return map2.containsKey(this.type) ? map2.get(this.type) : this.type.getName();
    }

    public T getValue() {
        return this.actualValue;
    }

    public void save(OutputStream outputStream) throws TransformerException, TikaException {
        Document newDocument = XMLReaderUtils.getDocumentBuilder().newDocument();
        Element createElement = newDocument.createElement("param");
        newDocument.appendChild(createElement);
        save(newDocument, createElement);
        XMLReaderUtils.getTransformer().transform(new DOMSource(createElement), new StreamResult(outputStream));
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(Class<T> cls) {
        this.type = cls;
    }

    public void setTypeString(String str) {
        if (str != null && !str.isEmpty()) {
            this.type = classFromType(str);
            this.actualValue = null;
        }
    }

    public String toString() {
        return "Param{name='" + this.name + '\'' + ", valueStrings='" + this.valueStrings + '\'' + ", actualValue=" + this.actualValue + '}';
    }

    public Param(String str, Class<T> cls, T t) {
        ArrayList arrayList = new ArrayList();
        this.valueStrings = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.valueMap = linkedHashMap;
        this.name = str;
        this.type = cls;
        this.actualValue = t;
        if (List.class.isAssignableFrom(t.getClass())) {
            arrayList.addAll((List) t);
        } else {
            if (Map.class.isAssignableFrom(t.getClass())) {
                linkedHashMap.putAll((Map) t);
            } else {
                arrayList.add(t.toString());
            }
        }
        if (this.type == null) {
            this.type = wellKnownMap.get(str);
        }
    }

    public static <T> Param<T> load(Node node) throws TikaConfigException {
        Class<?> cls;
        String str;
        Node namedItem = node.getAttributes().getNamedItem("name");
        Node namedItem2 = node.getAttributes().getNamedItem("type");
        Node namedItem3 = node.getAttributes().getNamedItem(AccountConstantKt.RESPONSE_VALUE);
        Node namedItem4 = node.getAttributes().getNamedItem(CLASS);
        if (namedItem4 != null) {
            try {
                cls = Class.forName(namedItem4.getTextContent());
            } catch (ClassNotFoundException e) {
                throw new TikaConfigException("can't find class: " + namedItem4.getTextContent(), e);
            }
        } else {
            cls = null;
        }
        Node firstChild = node.getFirstChild();
        if (!(firstChild instanceof NodeList) || namedItem3 == null) {
            if (namedItem3 == null || !(firstChild == null || firstChild.getTextContent() == null)) {
                namedItem3 = firstChild;
            }
            Param<T> param = new Param<>();
            String textContent = namedItem.getTextContent();
            param.name = textContent;
            if (namedItem2 == null) {
                Class<T> cls2 = wellKnownMap.get(textContent);
                param.type = cls2;
                if (cls2 == null) {
                    param.type = cls;
                }
                if (param.type == null) {
                    throw new TikaConfigException("Must specify a \"type\" in: " + node.getLocalName());
                }
            } else if (!CLASS.equals(namedItem2.getTextContent())) {
                param.setTypeString(namedItem2.getTextContent());
            } else if (namedItem4 != null) {
                param.setType(cls);
            } else {
                throw new TikaConfigException("must specify a class attribute if type=\"class\"");
            }
            if (cls != null) {
                loadObject(param, node, cls);
            } else if (List.class.isAssignableFrom(param.type)) {
                loadList(param, node);
            } else if (Map.class.isAssignableFrom(param.type)) {
                loadMap(param, node);
            } else {
                if (namedItem3 != null) {
                    str = namedItem3.getTextContent();
                } else {
                    str = "";
                }
                param.actualValue = getTypedValue(param.type, str);
                param.valueStrings.add(str);
            }
            return param;
        }
        throw new TikaConfigException("can't specify a value attr _and_ a node list");
    }

    public void save(Document document, Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            element.setAttribute("name", getName());
            element.setAttribute("type", getTypeString());
            if (List.class.isAssignableFrom(this.actualValue.getClass())) {
                for (int i = 0; i < this.valueStrings.size(); i++) {
                    Element createElement = document.createElement(map.get(((List) this.actualValue).get(i).getClass()));
                    createElement.setTextContent(this.valueStrings.get(i));
                    element.appendChild(createElement);
                }
                return;
            }
            if (Map.class.isAssignableFrom(this.actualValue.getClass())) {
                for (String str : ((Map) this.actualValue).keySet()) {
                    Element createElement2 = document.createElement(str);
                    createElement2.setTextContent((String) ((Map) this.actualValue).get(str));
                    element.appendChild(createElement2);
                }
                return;
            }
            element.setTextContent(this.valueStrings.get(0));
            return;
        }
        throw new IllegalArgumentException("Not an Element : " + node);
    }

    public Param(String str, T t) {
        this(str, t.getClass(), t);
    }
}
