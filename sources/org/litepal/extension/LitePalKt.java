package org.litepal.extension;

import android.content.ContentValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a%\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a\u0015\u0010\t\u001a\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u001d\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u001d\u0010\r\u001a\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a2\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00150\u0015\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00150\u0015\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a$\u0010\u0018\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\b¢\u0006\u0002\u0010\u0019\u001a2\u0010\u0018\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\b¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u001f0\u001e\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010 \u001a\u00020!\"\u00020\u000fH\b\u001aE\u0010\u001d\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u001f0\u001e\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\u0010 \u001a\u00020!\"\u00020\u000fH\b\u001aM\u0010\"\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010#0#\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010 \u001a\u00020!\"\u00020\u000fH\b\u001aE\u0010\"\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010#0#\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\u0010 \u001a\u00020!\"\u00020\u000fH\b\u001aA\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a2\u0010$\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\b¢\u0006\u0002\u0010\u001c\u001a\"\u0010&\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b¢\u0006\u0002\u0010'\u001a*\u0010&\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\b¢\u0006\u0002\u0010(\u001a9\u0010)\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001aA\u0010)\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\b\u001a\"\u0010*\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b¢\u0006\u0002\u0010'\u001a*\u0010*\u001a\n \b*\u0004\u0018\u0001H\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\b¢\u0006\u0002\u0010(\u001a9\u0010+\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001aA\u0010+\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\b\u001a2\u0010,\u001a\u00020\u001b\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010-\u001a2\u0010.\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00101\u001a2\u0010.\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00103\u001aI\u00104\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b\u001aI\u00104\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b\u001a2\u00105\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00101\u001a2\u00105\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00103\u001aI\u00106\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b\u001aI\u00106\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b\u001a\u0018\u00107\u001a\u00020\u001b*\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b09\u001a\u001a\u0010:\u001a\u00020\u001b\"\b\b\u0000\u0010\u0002*\u00020;*\b\u0012\u0004\u0012\u0002H\u00020<\u001a2\u0010=\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00101\u001a2\u0010=\u001a\n \b*\u0004\u0018\u0001H/H/\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b¢\u0006\u0002\u00103\u001aI\u0010>\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010/\u0018\u0001*\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\b\u001aI\u0010>\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/ \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H/H/\u0018\u00010%0%\"\u0006\b\u0000\u0010/\u0018\u0001*\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\b\u001a%\u0010?\u001a\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a:\u0010B\u001a\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010C\u001aB\u0010D\u001a\n \b*\u0004\u0018\u00010\u00150\u0015\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010E\u001a-\u0010F\u001a\n \b*\u0004\u0018\u00010\u00150\u0015\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fH\b¨\u0006G"}, d2 = {"average", "", "T", "Lorg/litepal/LitePal;", "column", "", "averageAsync", "Lorg/litepal/crud/async/AverageExecutor;", "kotlin.jvm.PlatformType", "count", "", "countAsync", "Lorg/litepal/crud/async/CountExecutor;", "delete", "id", "", "deleteAll", "conditions", "", "(Lorg/litepal/LitePal;[Ljava/lang/String;)I", "deleteAllAsync", "Lorg/litepal/crud/async/UpdateOrDeleteExecutor;", "(Lorg/litepal/LitePal;[Ljava/lang/String;)Lorg/litepal/crud/async/UpdateOrDeleteExecutor;", "deleteAsync", "find", "(Lorg/litepal/LitePal;J)Ljava/lang/Object;", "isEager", "", "(Lorg/litepal/LitePal;JZ)Ljava/lang/Object;", "findAll", "", "", "ids", "", "findAllAsync", "Lorg/litepal/crud/async/FindMultiExecutor;", "findAsync", "Lorg/litepal/crud/async/FindExecutor;", "findFirst", "(Lorg/litepal/LitePal;)Ljava/lang/Object;", "(Lorg/litepal/LitePal;Z)Ljava/lang/Object;", "findFirstAsync", "findLast", "findLastAsync", "isExist", "(Lorg/litepal/LitePal;[Ljava/lang/String;)Z", "max", "R", "columnName", "(Lorg/litepal/LitePal;Ljava/lang/String;)Ljava/lang/Object;", "tableName", "(Lorg/litepal/LitePal;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "maxAsync", "min", "minAsync", "runInTransaction", "block", "Lkotlin/Function0;", "saveAll", "Lorg/litepal/crud/LitePalSupport;", "", "sum", "sumAsync", "update", "values", "Landroid/content/ContentValues;", "updateAll", "(Lorg/litepal/LitePal;Landroid/content/ContentValues;[Ljava/lang/String;)I", "updateAllAsync", "(Lorg/litepal/LitePal;Landroid/content/ContentValues;[Ljava/lang/String;)Lorg/litepal/crud/async/UpdateOrDeleteExecutor;", "updateAsync", "core_release"}, k = 2, mv = {1, 4, 1})
public final class LitePalKt {
    public static final /* synthetic */ <T> double average(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$average");
        Intrinsics.checkNotNullParameter(str, "column");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.average((Class<?>) Object.class, str);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> AverageExecutor averageAsync(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$averageAsync");
        Intrinsics.checkNotNullParameter(str, "column");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.averageAsync((Class<?>) Object.class, str);
    }

    public static final /* synthetic */ <T> int count(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$count");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.count((Class<?>) Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> CountExecutor countAsync(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$countAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.countAsync((Class<?>) Object.class);
    }

    public static final /* synthetic */ <T> int delete(LitePal litePal, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$delete");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.delete(Object.class, j);
    }

    public static final /* synthetic */ <T> int deleteAll(LitePal litePal, String... strArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$deleteAll");
        Intrinsics.checkNotNullParameter(strArr, "conditions");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.deleteAll((Class<?>) Object.class, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> UpdateOrDeleteExecutor deleteAllAsync(LitePal litePal, String... strArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$deleteAllAsync");
        Intrinsics.checkNotNullParameter(strArr, "conditions");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.deleteAllAsync((Class<?>) Object.class, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> UpdateOrDeleteExecutor deleteAsync(LitePal litePal, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$deleteAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.deleteAsync(Object.class, j);
    }

    public static final /* synthetic */ <T> T find(LitePal litePal, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$find");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.find(Object.class, j);
    }

    public static final /* synthetic */ <T> List<T> findAll(LitePal litePal, long... jArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAll");
        Intrinsics.checkNotNullParameter(jArr, "ids");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findAll(Object.class, Arrays.copyOf(jArr, jArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindMultiExecutor<T> findAllAsync(LitePal litePal, long... jArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAllAsync");
        Intrinsics.checkNotNullParameter(jArr, "ids");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findAllAsync(Object.class, Arrays.copyOf(jArr, jArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findAsync(LitePal litePal, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findAsync(Object.class, j);
    }

    public static final /* synthetic */ <T> T findFirst(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findFirst");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findFirst(Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findFirstAsync(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findFirstAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findFirstAsync(Object.class);
    }

    public static final /* synthetic */ <T> T findLast(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findLast");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findLast(Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findLastAsync(LitePal litePal) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findLastAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findLastAsync(Object.class);
    }

    public static final /* synthetic */ <T> boolean isExist(LitePal litePal, String... strArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$isExist");
        Intrinsics.checkNotNullParameter(strArr, "conditions");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.isExist(Object.class, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final /* synthetic */ <T, R> R max(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$max");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.max((Class<?>) cls, str, cls);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T, R> FindExecutor<R> maxAsync(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$maxAsync");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.maxAsync((Class<?>) cls, str, cls);
    }

    public static final /* synthetic */ <T, R> R min(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$min");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.min((Class<?>) cls, str, cls);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T, R> FindExecutor<R> minAsync(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$minAsync");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.minAsync((Class<?>) cls, str, cls);
    }

    public static final synchronized boolean runInTransaction(@NotNull LitePal litePal, @NotNull Function0<Boolean> function0) {
        boolean z;
        synchronized (LitePalKt.class) {
            Intrinsics.checkNotNullParameter(litePal, "$this$runInTransaction");
            Intrinsics.checkNotNullParameter(function0, "block");
            LitePal.beginTransaction();
            try {
                z = function0.invoke().booleanValue();
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                LitePal.setTransactionSuccessful();
            }
            LitePal.endTransaction();
        }
        return z;
    }

    public static final <T extends LitePalSupport> boolean saveAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$saveAll");
        return LitePal.saveAll(collection);
    }

    public static final /* synthetic */ <T, R> R sum(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$sum");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.sum((Class<?>) cls, str, cls);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T, R> FindExecutor<R> sumAsync(LitePal litePal, String str) {
        Intrinsics.checkNotNullParameter(litePal, "$this$sumAsync");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return LitePal.sumAsync((Class<?>) cls, str, cls);
    }

    public static final /* synthetic */ <T> int update(LitePal litePal, ContentValues contentValues, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$update");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.update(Object.class, contentValues, j);
    }

    public static final /* synthetic */ <T> int updateAll(LitePal litePal, ContentValues contentValues, String... strArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$updateAll");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        Intrinsics.checkNotNullParameter(strArr, "conditions");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.updateAll((Class<?>) Object.class, contentValues, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> UpdateOrDeleteExecutor updateAllAsync(LitePal litePal, ContentValues contentValues, String... strArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$updateAllAsync");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        Intrinsics.checkNotNullParameter(strArr, "conditions");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.updateAllAsync((Class<?>) Object.class, contentValues, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> UpdateOrDeleteExecutor updateAsync(LitePal litePal, ContentValues contentValues, long j) {
        Intrinsics.checkNotNullParameter(litePal, "$this$updateAsync");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.updateAsync(Object.class, contentValues, j);
    }

    public static final /* synthetic */ <T> T find(LitePal litePal, long j, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$find");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.find(Object.class, j, z);
    }

    public static final /* synthetic */ <T> List<T> findAll(LitePal litePal, boolean z, long... jArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAll");
        Intrinsics.checkNotNullParameter(jArr, "ids");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findAll(Object.class, z, Arrays.copyOf(jArr, jArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindMultiExecutor<T> findAllAsync(LitePal litePal, boolean z, long... jArr) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAllAsync");
        Intrinsics.checkNotNullParameter(jArr, "ids");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findAllAsync(Object.class, z, Arrays.copyOf(jArr, jArr.length));
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> T findAsync(LitePal litePal, long j, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.find(Object.class, j, z);
    }

    public static final /* synthetic */ <T> T findFirst(LitePal litePal, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findFirst");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findFirst(Object.class, z);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findFirstAsync(LitePal litePal, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findFirstAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findFirstAsync(Object.class, z);
    }

    public static final /* synthetic */ <T> T findLast(LitePal litePal, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findLast");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findLast(Object.class, z);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findLastAsync(LitePal litePal, boolean z) {
        Intrinsics.checkNotNullParameter(litePal, "$this$findLastAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return LitePal.findLastAsync(Object.class, z);
    }

    public static final /* synthetic */ <R> R max(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$max");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.max(str, str2, Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <R> FindExecutor<R> maxAsync(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$maxAsync");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.maxAsync(str, str2, Object.class);
    }

    public static final /* synthetic */ <R> R min(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$min");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.min(str, str2, Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <R> FindExecutor<R> minAsync(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$minAsync");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.minAsync(str, str2, Object.class);
    }

    public static final /* synthetic */ <R> R sum(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$sum");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.sum(str, str2, Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <R> FindExecutor<R> sumAsync(LitePal litePal, String str, String str2) {
        Intrinsics.checkNotNullParameter(litePal, "$this$sumAsync");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return LitePal.sumAsync(str, str2, Object.class);
    }
}
