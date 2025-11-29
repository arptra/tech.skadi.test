package org.litepal.extension;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.litepal.FluentQuery;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b\u001a9\u0010\f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u0001H\u0002H\u0002 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\r0\r\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001aA\u0010\f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u0001H\u0002H\u0002 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\r0\r\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u001c\u0010\u000f\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b¢\u0006\u0002\u0010\u0010\u001a$\u0010\u000f\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u001c\u0010\u0014\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0014\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\u0011\u001a*\u0010\u0015\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0018\u001a*\u0010\u0015\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u001a\u001a*\u0010\u001b\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0018\u001a*\u0010\u001b\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u001a\u001a*\u0010\u001c\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0018\u001a*\u0010\u001c\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u001a¨\u0006\u001d"}, d2 = {"average", "", "T", "Lorg/litepal/FluentQuery;", "column", "", "count", "", "find", "", "isEager", "", "findAsync", "Lorg/litepal/crud/async/FindMultiExecutor;", "kotlin.jvm.PlatformType", "findFirst", "(Lorg/litepal/FluentQuery;)Ljava/lang/Object;", "(Lorg/litepal/FluentQuery;Z)Ljava/lang/Object;", "findFirstAsync", "Lorg/litepal/crud/async/FindExecutor;", "findLast", "max", "R", "columnName", "(Lorg/litepal/FluentQuery;Ljava/lang/String;)Ljava/lang/Object;", "tableName", "(Lorg/litepal/FluentQuery;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "min", "sum", "core_release"}, k = 2, mv = {1, 4, 1})
public final class FluentQueryKt {
    public static final /* synthetic */ <T> double average(FluentQuery fluentQuery, String str) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$average");
        Intrinsics.checkNotNullParameter(str, "column");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.average((Class<?>) Object.class, str);
    }

    public static final /* synthetic */ <T> int count(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$count");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.count((Class<?>) Object.class);
    }

    public static final /* synthetic */ <T> List<T> find(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$find");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List<T> find = fluentQuery.find(Object.class);
        Intrinsics.checkNotNullExpressionValue(find, "find(T::class.java)");
        return find;
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindMultiExecutor<T> findAsync(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findAsync(Object.class);
    }

    public static final /* synthetic */ <T> T findFirst(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findFirst");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findFirst(Object.class);
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindExecutor<T> findFirstAsync(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findFirstAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FindExecutor<T> findFirstAsync = fluentQuery.findFirstAsync(Object.class);
        Intrinsics.checkNotNullExpressionValue(findFirstAsync, "findFirstAsync(T::class.java)");
        return findFirstAsync;
    }

    public static final /* synthetic */ <T> T findLast(FluentQuery fluentQuery) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findLast");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findLast(Object.class);
    }

    public static final /* synthetic */ <T, R> R max(FluentQuery fluentQuery, String str) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$max");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return fluentQuery.max((Class<?>) cls, str, cls);
    }

    public static final /* synthetic */ <T, R> R min(FluentQuery fluentQuery, String str) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$min");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return fluentQuery.min((Class<?>) cls, str, cls);
    }

    public static final /* synthetic */ <T, R> R sum(FluentQuery fluentQuery, String str) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$sum");
        Intrinsics.checkNotNullParameter(str, "columnName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        return fluentQuery.sum((Class<?>) cls, str, cls);
    }

    public static final /* synthetic */ <T> List<T> find(FluentQuery fluentQuery, boolean z) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$find");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List<T> find = fluentQuery.find(Object.class, z);
        Intrinsics.checkNotNullExpressionValue(find, "find(T::class.java, isEager)");
        return find;
    }

    @Deprecated(message = "This method is deprecated and will be removed in the future releases.", replaceWith = @ReplaceWith(expression = "Handle async db operation in your own logic instead.", imports = {}))
    public static final /* synthetic */ <T> FindMultiExecutor<T> findAsync(FluentQuery fluentQuery, boolean z) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findAsync");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findAsync(Object.class, z);
    }

    public static final /* synthetic */ <T> T findFirst(FluentQuery fluentQuery, boolean z) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findFirst");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findFirst(Object.class, z);
    }

    public static final /* synthetic */ <T> T findLast(FluentQuery fluentQuery, boolean z) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$findLast");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fluentQuery.findLast(Object.class, z);
    }

    public static final /* synthetic */ <R> R max(FluentQuery fluentQuery, String str, String str2) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$max");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return fluentQuery.max(str, str2, Object.class);
    }

    public static final /* synthetic */ <R> R min(FluentQuery fluentQuery, String str, String str2) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$min");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return fluentQuery.min(str, str2, Object.class);
    }

    public static final /* synthetic */ <R> R sum(FluentQuery fluentQuery, String str, String str2) {
        Intrinsics.checkNotNullParameter(fluentQuery, "$this$sum");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Intrinsics.reifiedOperationMarker(4, "R");
        return fluentQuery.sum(str, str2, Object.class);
    }
}
