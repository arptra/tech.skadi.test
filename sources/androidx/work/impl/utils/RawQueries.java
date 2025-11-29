package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/work/WorkQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "b", "(Landroidx/work/WorkQuery;)Landroidx/sqlite/db/SupportSQLiteQuery;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "count", "", "a", "(Ljava/lang/StringBuilder;I)V", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRawQueries.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawQueries.kt\nandroidx/work/impl/utils/RawQueries\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1549#2:74\n1620#2,3:75\n1549#2:78\n1620#2,3:79\n37#3,2:82\n1#4:84\n*S KotlinDebug\n*F\n+ 1 RawQueries.kt\nandroidx/work/impl/utils/RawQueries\n*L\n35#1:74\n35#1:75,3\n43#1:78\n43#1:79,3\n64#1:82,2\n*E\n"})
@JvmName(name = "RawQueries")
public final class RawQueries {
    public static final void a(StringBuilder sb, int i) {
        if (i > 0) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add("?");
            }
            sb.append(CollectionsKt.joinToString$default(arrayList, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    public static final SupportSQLiteQuery b(WorkQuery workQuery) {
        Intrinsics.checkNotNullParameter(workQuery, "<this>");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        List b = workQuery.b();
        Intrinsics.checkNotNullExpressionValue(b, "states");
        String str = " AND";
        String str2 = " WHERE";
        if (!b.isEmpty()) {
            List<WorkInfo.State> b2 = workQuery.b();
            Intrinsics.checkNotNullExpressionValue(b2, "states");
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(b2, 10));
            for (WorkInfo.State state : b2) {
                Intrinsics.checkNotNull(state);
                arrayList2.add(Integer.valueOf(WorkTypeConverters.j(state)));
            }
            sb.append(str2 + " state IN (");
            a(sb, arrayList2.size());
            sb.append(")");
            arrayList.addAll(arrayList2);
            str2 = str;
        }
        List a2 = workQuery.a();
        Intrinsics.checkNotNullExpressionValue(a2, "ids");
        if (!a2.isEmpty()) {
            List<UUID> a3 = workQuery.a();
            Intrinsics.checkNotNullExpressionValue(a3, "ids");
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(a3, 10));
            for (UUID uuid : a3) {
                arrayList3.add(uuid.toString());
            }
            sb.append(str2 + " id IN (");
            a(sb, workQuery.a().size());
            sb.append(")");
            arrayList.addAll(arrayList3);
            str2 = str;
        }
        List c = workQuery.c();
        Intrinsics.checkNotNullExpressionValue(c, "tags");
        if (!c.isEmpty()) {
            sb.append(str2 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            a(sb, workQuery.c().size());
            sb.append("))");
            List c2 = workQuery.c();
            Intrinsics.checkNotNullExpressionValue(c2, "tags");
            arrayList.addAll(c2);
        } else {
            str = str2;
        }
        List d = workQuery.d();
        Intrinsics.checkNotNullExpressionValue(d, "uniqueWorkNames");
        if (!d.isEmpty()) {
            sb.append(str + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            a(sb, workQuery.d().size());
            sb.append("))");
            List d2 = workQuery.d();
            Intrinsics.checkNotNullExpressionValue(d2, "uniqueWorkNames");
            arrayList.addAll(d2);
        }
        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return new SimpleSQLiteQuery(sb2, arrayList.toArray(new Object[0]));
    }
}
