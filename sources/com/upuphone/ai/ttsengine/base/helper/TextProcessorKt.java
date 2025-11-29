package com.upuphone.ai.ttsengine.base.helper;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a3\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "", "Lkotlin/Function1;", "", "predicate", "", "b", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)I", "aar_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class TextProcessorKt {
    public static final int b(List list, Function1 function1) {
        int size = list.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return -1;
            }
            if (((Boolean) function1.invoke(list.get(size))).booleanValue()) {
                return size;
            }
        }
    }
}
