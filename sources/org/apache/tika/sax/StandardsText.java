package org.apache.tika.sax;

import com.meizu.common.util.CommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.sax.StandardReference;

public class StandardsText {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3329a;
    public static final String b;

    static {
        String a2 = StandardOrganizations.a();
        f3329a = a2;
        b = CommonConstants.IS_FLYME_OS_4_MATCH + a2 + ".+" + a2 + "?.*";
    }

    public static ArrayList a(String str, double d) {
        return c(str, b(str), d);
    }

    public static Map b(String str) {
        TreeMap treeMap = new TreeMap();
        Matcher matcher = Pattern.compile("(\\d{1,10}+\\.(\\d{1,10}+\\.?){0,10}+)\\p{Blank}+([A-Z]{1,64}+(\\s[A-Z]{1,64}+){0,256}+){5,10}+").matcher(str);
        while (matcher.find()) {
            treeMap.put(Integer.valueOf(matcher.start()), matcher.group());
        }
        return treeMap;
    }

    public static ArrayList c(String str, Map map, double d) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\(?(?<mainOrganization>[A-Z]\\w{1,64}+)\\)?((\\s?(?<separator>\\/)\\s?)(\\w{1,64}+\\s)*\\(?(?<secondOrganization>[A-Z]\\w{1,64}+)\\)?)?(\\s(?i:Publication|Standard))?(-|\\s)?(?<identifier>([0-9]{3,64}+|([A-Z]{1,64}+(-|_|\\.)?[0-9]{2,64}+))((-|_|\\.)?[A-Z0-9]{1,64}+){0,64}+)").matcher(str);
        while (matcher.find()) {
            StandardReference.StandardReferenceBuilder c = new StandardReference.StandardReferenceBuilder(matcher.group("mainOrganization"), matcher.group("identifier")).c(matcher.group("separator"), matcher.group("secondOrganization"));
            double d2 = matcher.group().matches(b) ? 0.5d : 0.25d;
            if (matcher.group().matches(".*(\\s(?i:Publication|Standard)).*")) {
                d2 += 0.25d;
            }
            Iterator it = map.entrySet().iterator();
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (it.hasNext() && !z) {
                int intValue = ((Integer) ((Map.Entry) it.next()).getKey()).intValue();
                if (intValue > matcher.start()) {
                    z = true;
                }
                int i3 = i2;
                i2 = intValue;
                i = i3;
            }
            if (((String) map.get(Integer.valueOf(i))) != null && ((String) map.get(Integer.valueOf(i))).matches("(?i:.*APPLICABLE\\sDOCUMENTS|REFERENCE|STANDARD|REQUIREMENT|GUIDELINE|COMPLIANCE.*)")) {
                d2 += 0.25d;
            }
            c.b(d2);
            if (d2 >= d) {
                arrayList.add(c.a());
            }
        }
        return arrayList;
    }
}
