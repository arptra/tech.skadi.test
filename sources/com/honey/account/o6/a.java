package com.honey.account.o6;

import java.io.File;
import java.util.function.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return Long.valueOf(((File) obj).lastModified());
    }
}
