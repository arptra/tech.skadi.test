package com.honey.account.tb;

import java.nio.file.Path;
import java.util.function.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return ((Path) obj).getFileName().toString();
    }
}
