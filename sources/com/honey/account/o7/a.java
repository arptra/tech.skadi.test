package com.honey.account.o7;

import com.upuphone.xr.account.util.StringUtil;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringJoiner f5020a;
    public final /* synthetic */ Map b;

    public /* synthetic */ a(StringJoiner stringJoiner, Map map) {
        this.f5020a = stringJoiner;
        this.b = map;
    }

    public final void accept(Object obj) {
        StringUtil.lambda$createLinkString$0(this.f5020a, this.b, (String) obj);
    }
}
