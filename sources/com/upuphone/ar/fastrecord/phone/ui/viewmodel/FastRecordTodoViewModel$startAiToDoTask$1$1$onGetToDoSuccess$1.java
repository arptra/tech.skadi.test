package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoViewModel$startAiToDoTask$1$1$onGetToDoSuccess$1 extends Lambda implements Function0<Unit> {
    public static final FastRecordTodoViewModel$startAiToDoTask$1$1$onGetToDoSuccess$1 INSTANCE = new FastRecordTodoViewModel$startAiToDoTask$1$1$onGetToDoSuccess$1();

    public FastRecordTodoViewModel$startAiToDoTask$1$1$onGetToDoSuccess$1() {
        super(0);
    }

    public final void invoke() {
        LogExt.logE("onGetToDoSuccess finish read form db after saveToDoBeanInfo from network", "TodoViewModel");
    }
}
