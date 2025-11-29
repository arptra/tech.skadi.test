package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.common.net.HttpHeaders;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\n\u001a)\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "tableName", "Landroidx/room/util/TableInfo;", "f", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)Landroidx/room/util/TableInfo;", "", "Landroidx/room/util/TableInfo$ForeignKey;", "c", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)Ljava/util/Set;", "Landroid/database/Cursor;", "cursor", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "b", "(Landroid/database/Cursor;)Ljava/util/List;", "", "Landroidx/room/util/TableInfo$Column;", "a", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)Ljava/util/Map;", "Landroidx/room/util/TableInfo$Index;", "e", "name", "", "unique", "d", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Z)Landroidx/room/util/TableInfo$Index;", "room-runtime_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,646:1\n145#2,2:647\n148#2,2:654\n151#2:660\n145#2,7:661\n145#2,7:668\n145#2,7:675\n766#3:649\n857#3,2:650\n1855#3,2:652\n857#3,2:656\n1855#3,2:658\n*S KotlinDebug\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n*L\n477#1:647,2\n477#1:654,2\n477#1:660\n542#1:661,7\n580#1:668,7\n613#1:675,7\n497#1:649\n497#1:650,2\n499#1:652,2\n497#1:656,2\n499#1:658,2\n*E\n"})
public final class TableInfoKt {
    public static final Map a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        Closeable n0 = supportSQLiteDatabase.n0("PRAGMA table_info(`" + str + "`)");
        try {
            Cursor cursor = (Cursor) n0;
            if (cursor.getColumnCount() <= 0) {
                Map emptyMap = MapsKt.emptyMap();
                CloseableKt.closeFinally(n0, (Throwable) null);
                return emptyMap;
            }
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("notnull");
            int columnIndex4 = cursor.getColumnIndex("pk");
            int columnIndex5 = cursor.getColumnIndex("dflt_value");
            Map createMapBuilder = MapsKt.createMapBuilder();
            while (cursor.moveToNext()) {
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex2);
                boolean z = cursor.getInt(columnIndex3) != 0;
                int i = cursor.getInt(columnIndex4);
                String string3 = cursor.getString(columnIndex5);
                Intrinsics.checkNotNullExpressionValue(string, "name");
                Intrinsics.checkNotNullExpressionValue(string2, "type");
                TableInfo.Column column = r12;
                TableInfo.Column column2 = new TableInfo.Column(string, string2, z, i, string3, 2);
                createMapBuilder.put(string, column);
            }
            Map build = MapsKt.build(createMapBuilder);
            CloseableKt.closeFinally(n0, (Throwable) null);
            return build;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            CloseableKt.closeFinally(n0, th);
            throw th3;
        }
    }

    public static final List b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(RtspHeaders.Values.SEQ);
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List createListBuilder = CollectionsKt.createListBuilder();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            createListBuilder.add(new TableInfo.ForeignKeyWithSequence(i, i2, string, string2));
        }
        return CollectionsKt.sorted(CollectionsKt.build(createListBuilder));
    }

    public static final Set c(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Closeable n0 = supportSQLiteDatabase.n0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            Cursor cursor = (Cursor) n0;
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex(RtspHeaders.Values.SEQ);
            int columnIndex3 = cursor.getColumnIndex("table");
            int columnIndex4 = cursor.getColumnIndex("on_delete");
            int columnIndex5 = cursor.getColumnIndex("on_update");
            List b = b(cursor);
            cursor.moveToPosition(-1);
            Set createSetBuilder = SetsKt.createSetBuilder();
            while (cursor.moveToNext()) {
                if (cursor.getInt(columnIndex2) == 0) {
                    int i = cursor.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<TableInfo.ForeignKeyWithSequence> arrayList3 = new ArrayList<>();
                    for (Object next : b) {
                        if (((TableInfo.ForeignKeyWithSequence) next).f() == i) {
                            arrayList3.add(next);
                        }
                    }
                    for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.d());
                        arrayList2.add(foreignKeyWithSequence.g());
                    }
                    String string = cursor.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursor.getString(columnIndex4);
                    Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursor.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(onUpdateColumnIndex)");
                    createSetBuilder.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set build = SetsKt.build(createSetBuilder);
            CloseableKt.closeFinally(n0, (Throwable) null);
            return build;
        } catch (Throwable th) {
            CloseableKt.closeFinally(n0, th);
            throw th;
        }
    }

    public static final TableInfo.Index d(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        Closeable n0 = supportSQLiteDatabase.n0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            Cursor cursor = (Cursor) n0;
            int columnIndex = cursor.getColumnIndex("seqno");
            int columnIndex2 = cursor.getColumnIndex("cid");
            int columnIndex3 = cursor.getColumnIndex("name");
            int columnIndex4 = cursor.getColumnIndex("desc");
            if (!(columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1)) {
                if (columnIndex4 != -1) {
                    TreeMap treeMap = new TreeMap();
                    TreeMap treeMap2 = new TreeMap();
                    while (cursor.moveToNext()) {
                        if (cursor.getInt(columnIndex2) >= 0) {
                            int i = cursor.getInt(columnIndex);
                            String string = cursor.getString(columnIndex3);
                            String str2 = cursor.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                            Integer valueOf = Integer.valueOf(i);
                            Intrinsics.checkNotNullExpressionValue(string, "columnName");
                            treeMap.put(valueOf, string);
                            treeMap2.put(Integer.valueOf(i), str2);
                        }
                    }
                    Collection values = treeMap.values();
                    Intrinsics.checkNotNullExpressionValue(values, "columnsMap.values");
                    List list = CollectionsKt.toList(values);
                    Collection values2 = treeMap2.values();
                    Intrinsics.checkNotNullExpressionValue(values2, "ordersMap.values");
                    TableInfo.Index index = new TableInfo.Index(str, z, list, CollectionsKt.toList(values2));
                    CloseableKt.closeFinally(n0, (Throwable) null);
                    return index;
                }
            }
            CloseableKt.closeFinally(n0, (Throwable) null);
            return null;
        } catch (Throwable th) {
            CloseableKt.closeFinally(n0, th);
            throw th;
        }
    }

    public static final Set e(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Closeable n0 = supportSQLiteDatabase.n0("PRAGMA index_list(`" + str + "`)");
        try {
            Cursor cursor = (Cursor) n0;
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex(HttpHeaders.ReferrerPolicyValues.ORIGIN);
            int columnIndex3 = cursor.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    while (cursor.moveToNext()) {
                        if (Intrinsics.areEqual((Object) "c", (Object) cursor.getString(columnIndex2))) {
                            String string = cursor.getString(columnIndex);
                            boolean z = true;
                            if (cursor.getInt(columnIndex3) != 1) {
                                z = false;
                            }
                            Intrinsics.checkNotNullExpressionValue(string, "name");
                            TableInfo.Index d = d(supportSQLiteDatabase, string, z);
                            if (d == null) {
                                CloseableKt.closeFinally(n0, (Throwable) null);
                                return null;
                            }
                            createSetBuilder.add(d);
                        }
                    }
                    Set build = SetsKt.build(createSetBuilder);
                    CloseableKt.closeFinally(n0, (Throwable) null);
                    return build;
                }
            }
            CloseableKt.closeFinally(n0, (Throwable) null);
            return null;
        } catch (Throwable th) {
            CloseableKt.closeFinally(n0, th);
            throw th;
        }
    }

    public static final TableInfo f(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        Intrinsics.checkNotNullParameter(str, "tableName");
        return new TableInfo(str, a(supportSQLiteDatabase, str), c(supportSQLiteDatabase, str), e(supportSQLiteDatabase, str));
    }
}
