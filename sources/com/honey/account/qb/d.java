package com.honey.account.qb;

import java.util.function.Consumer;
import org.apache.commons.csv.CSVPrinter;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CSVPrinter f7518a;

    public /* synthetic */ d(CSVPrinter cSVPrinter) {
        this.f7518a = cSVPrinter;
    }

    public final void accept(Object obj) {
        this.f7518a.lambda$printRecord$0(obj);
    }
}
