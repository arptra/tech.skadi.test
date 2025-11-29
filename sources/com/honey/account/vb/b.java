package com.honey.account.vb;

import java.util.Comparator;
import org.apache.commons.io.ByteOrderMark;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((ByteOrderMark) obj2).length(), ((ByteOrderMark) obj).length());
    }
}
