package com.honey.account.country.db;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/honey/account/country/db/CountryTable;", "", "()V", "BRIEF", "", "CODE", "COUNTRY", "CREATE_SQL", "IS_FIRST", "PRIMARY_KEY", "SIMPLE_CODE", "SORT_KEY", "TABLE_NAME", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryTable {
    @NotNull
    public static final String BRIEF = "brief";
    @NotNull
    public static final String CODE = "code";
    @NotNull
    public static final String COUNTRY = "country";
    @NotNull
    public static final String CREATE_SQL = "create table if not exists country (primary_key INTEGER PRIMARY KEY NOT NULL, brief text, country text,code text,simple_code text,is_first Integer,sort_key text)";
    @NotNull
    public static final CountryTable INSTANCE = new CountryTable();
    @NotNull
    public static final String IS_FIRST = "is_first";
    @NotNull
    public static final String PRIMARY_KEY = "primary_key";
    @NotNull
    public static final String SIMPLE_CODE = "simple_code";
    @NotNull
    public static final String SORT_KEY = "sort_key";
    @NotNull
    public static final String TABLE_NAME = "country";

    private CountryTable() {
    }
}
