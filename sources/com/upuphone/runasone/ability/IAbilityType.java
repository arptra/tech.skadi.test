package com.upuphone.runasone.ability;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/upuphone/runasone/ability/IAbilityType;", "", "children", "", "code", "", "desc", "", "core-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAbilityType {
    @NotNull
    List<IAbilityType> children();

    int code();

    @NotNull
    String desc();
}
