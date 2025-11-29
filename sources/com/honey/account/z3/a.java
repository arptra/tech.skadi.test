package com.honey.account.z3;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.search.FastRecordSearchViewModel;
import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f5336a;

    public /* synthetic */ a(Function2 function2) {
        this.f5336a = function2;
    }

    public final int compare(Object obj, Object obj2) {
        return FastRecordSearchViewModel.sortRecordData$lambda$7(this.f5336a, obj, obj2);
    }
}
