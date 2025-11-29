package com.upuphone.xr.sapp.config;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/config/NetConfigResult;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "list", "", "Lcom/upuphone/xr/sapp/config/NetConfigSubItem;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "ver", "getVer", "setVer", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class NetConfigResult {
    private int count;
    @NotNull
    private List<NetConfigSubItem> list = new ArrayList();
    private int ver;

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<NetConfigSubItem> getList() {
        return this.list;
    }

    public final int getVer() {
        return this.ver;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setList(@NotNull List<NetConfigSubItem> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.list = list2;
    }

    public final void setVer(int i) {
        this.ver = i;
    }
}
