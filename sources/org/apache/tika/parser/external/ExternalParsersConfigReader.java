package org.apache.tika.parser.external;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.apache.tika.exception.TikaException;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.utils.XMLReaderUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class ExternalParsersConfigReader implements ExternalParsersConfigReaderMetKeys {
    public static String a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 3) {
                stringBuffer.append(item.getNodeValue());
            }
        }
        return stringBuffer.toString();
    }

    public static List b(InputStream inputStream) {
        try {
            return c(XMLReaderUtils.getDocumentBuilder().parse(new InputSource(inputStream)));
        } catch (SAXException e) {
            throw new TikaException("Invalid parser configuration", e);
        }
    }

    public static List c(Document document) {
        return d(document.getDocumentElement());
    }

    public static List d(Element element) {
        ExternalParser h;
        ArrayList arrayList = new ArrayList();
        if (element == null || !element.getTagName().equals("external-parsers")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not a <external-parsers/> configuration document: ");
            sb.append(element != null ? element.getTagName() : "n/a");
            throw new MimeTypeException(sb.toString());
        }
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("parser") && (h = h(element2)) != null) {
                    arrayList.add(h);
                }
            }
        }
        return arrayList;
    }

    public static boolean e(Element element) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = element.getChildNodes();
        String str = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("command")) {
                    str = a(element2);
                }
                if (element2.getTagName().equals("error-codes")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(a(element2), MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    while (stringTokenizer.hasMoreElements()) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        if (str == null) {
            return true;
        }
        String[] split = str.split(" ");
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return ExternalParser.check(split, iArr);
    }

    public static Map f(Element element) {
        HashMap hashMap = new HashMap();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("match")) {
                    hashMap.put(Pattern.compile(a(element2)), element2.getAttribute(IntentKey.ACTIVITY.ACTION_KEY));
                }
            }
        }
        return hashMap;
    }

    public static Set g(Element element) {
        HashSet hashSet = new HashSet();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("mime-type")) {
                    hashSet.add(MediaType.parse(a(element2)));
                }
            }
        }
        return hashSet;
    }

    public static ExternalParser h(Element element) {
        ExternalParser externalParser = new ExternalParser();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                tagName.hashCode();
                char c = 65535;
                switch (tagName.hashCode()) {
                    case -450004177:
                        if (tagName.equals("metadata")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 94627080:
                        if (tagName.equals("check")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 950394699:
                        if (tagName.equals("command")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1081186720:
                        if (tagName.equals("mime-types")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        externalParser.setMetadataExtractionPatterns(f(element2));
                        break;
                    case 1:
                        if (e(element2)) {
                            break;
                        } else {
                            return null;
                        }
                    case 2:
                        externalParser.setCommand(a(element2));
                        break;
                    case 3:
                        externalParser.setSupportedTypes(g(element2));
                        break;
                    default:
                        throw new IllegalArgumentException("reaction not defined for " + element2.getTagName());
                }
            }
        }
        return externalParser;
    }
}
