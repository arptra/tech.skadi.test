package com.honey.account.oc;

import org.apache.tika.utils.XMLReaderUtils;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public final /* synthetic */ class e implements EntityResolver {
    public final InputSource resolveEntity(String str, String str2) {
        return XMLReaderUtils.lambda$static$0(str, str2);
    }
}
