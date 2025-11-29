package com.honey.account.qb;

import java.util.function.Consumer;
import org.apache.commons.csv.CSVPrinter;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CSVPrinter f7517a;

    public /* synthetic */ c(CSVPrinter cSVPrinter) {
        this.f7517a = cSVPrinter;
    }

    public final void accept(Object obj) {
        this.f7517a.lambda$printRecords$1(obj);
    }
}
