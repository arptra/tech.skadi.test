package com.honey.account.view.login.data;

import com.here.sdk.search.PlaceCategory;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/honey/account/view/login/data/VCodeMethod;", "", "method", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "STRICT", "LOGIN_PHONE", "LOGIN_EMAIL", "VALIDATE", "BINDING", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum VCodeMethod {
    STRICT("18"),
    LOGIN_PHONE("200"),
    LOGIN_EMAIL(PlaceCategory.TRANSPORT),
    VALIDATE("9"),
    BINDING("202");
    
    @NotNull
    private final String method;

    static {
        VCodeMethod[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private VCodeMethod(String str) {
        this.method = str;
    }

    @NotNull
    public static EnumEntries<VCodeMethod> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public String toString() {
        return this.method;
    }
}
