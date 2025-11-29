package org.java_websocket.extensions;

import com.meizu.common.widget.MzContactsContract;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExtensionRequestData {

    /* renamed from: a  reason: collision with root package name */
    public Map f3397a = new LinkedHashMap();
    public String b;

    public static ExtensionRequestData c(String str) {
        String str2;
        ExtensionRequestData extensionRequestData = new ExtensionRequestData();
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        extensionRequestData.b = split[0].trim();
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length > 1) {
                str2 = split2[1].trim();
                if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'") && str2.length() > 2)) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
            } else {
                str2 = "";
            }
            extensionRequestData.f3397a.put(split2[0].trim(), str2);
        }
        return extensionRequestData;
    }

    public String a() {
        return this.b;
    }

    public Map b() {
        return this.f3397a;
    }
}
