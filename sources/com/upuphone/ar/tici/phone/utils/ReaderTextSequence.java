package com.upuphone.ar.tici.phone.utils;

import java.io.Reader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/ReaderTextSequence;", "Lkotlin/sequences/Sequence;", "", "", "iterator", "()Ljava/util/Iterator;", "Ljava/io/Reader;", "a", "Ljava/io/Reader;", "reader", "", "b", "I", "maxLength", "c", "pageLimit", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class ReaderTextSequence implements Sequence<String> {

    /* renamed from: a  reason: collision with root package name */
    public final Reader f5996a;
    public final int b;
    public final int c;

    public Iterator iterator() {
        return new ReaderTextSequence$iterator$1(this);
    }
}
