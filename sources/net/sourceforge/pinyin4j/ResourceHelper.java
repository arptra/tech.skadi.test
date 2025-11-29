package net.sourceforge.pinyin4j;

import java.io.BufferedInputStream;

class ResourceHelper {
    static /* synthetic */ Class class$net$sourceforge$pinyin4j$ResourceHelper;

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static BufferedInputStream getResourceInputStream(String str) {
        Class cls = class$net$sourceforge$pinyin4j$ResourceHelper;
        if (cls == null) {
            cls = class$("net.sourceforge.pinyin4j.ResourceHelper");
            class$net$sourceforge$pinyin4j$ResourceHelper = cls;
        }
        return new BufferedInputStream(cls.getResourceAsStream(str));
    }
}
