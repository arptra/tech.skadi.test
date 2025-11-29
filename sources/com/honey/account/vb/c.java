package com.honey.account.vb;

import java.util.function.IntPredicate;
import org.apache.commons.io.input.CharacterFilterReader;

public final /* synthetic */ class c implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7638a;

    public /* synthetic */ c(int i) {
        this.f7638a = i;
    }

    public final boolean test(int i) {
        return CharacterFilterReader.lambda$new$0(this.f7638a, i);
    }
}
