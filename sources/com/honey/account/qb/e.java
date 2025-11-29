package com.honey.account.qb;

import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.commons.csv.CSVRecord;

public final /* synthetic */ class e implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CSVRecord f7519a;
    public final /* synthetic */ Map b;

    public /* synthetic */ e(CSVRecord cSVRecord, Map map) {
        this.f7519a = cSVRecord;
        this.b = map;
    }

    public final void accept(Object obj, Object obj2) {
        this.f7519a.lambda$putIn$0(this.b, (String) obj, (Integer) obj2);
    }
}
