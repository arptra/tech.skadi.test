package com.honey.account.sysconfig.db;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/honey/account/sysconfig/db/SysConfigTable;", "", "()V", "COUNTRY_INIT", "", "CREATE_SQL", "INIT_SQL", "TABLE_NAME", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SysConfigTable {
    @NotNull
    public static final String COUNTRY_INIT = "country_init";
    @NotNull
    public static final String CREATE_SQL = "create table if not exists sys_config (country_init Integer )";
    @NotNull
    public static final String INIT_SQL = "insert into sys_config (country_init) values(0)";
    @NotNull
    public static final SysConfigTable INSTANCE = new SysConfigTable();
    @NotNull
    public static final String TABLE_NAME = "sys_config";

    private SysConfigTable() {
    }
}
