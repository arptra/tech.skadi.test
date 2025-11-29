package com.honey.account.tb;

import java.io.File;
import java.util.function.Predicate;
import org.apache.commons.io.filefilter.IOFileFilter;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFileFilter f7620a;

    public /* synthetic */ a(IOFileFilter iOFileFilter) {
        this.f7620a = iOFileFilter;
    }

    public final boolean test(Object obj) {
        return this.f7620a.accept((File) obj);
    }
}
