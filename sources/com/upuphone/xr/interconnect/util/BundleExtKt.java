package com.upuphone.xr.interconnect.util;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\b\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u001c\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"charSequenceArrayClass", "Ljava/lang/Class;", "", "", "parcelableArrayClass", "Landroid/os/Parcelable;", "stringArrayClass", "", "toBundle", "Landroid/os/Bundle;", "", "", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBundleExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BundleExt.kt\ncom/upuphone/xr/interconnect/util/BundleExtKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,69:1\n215#2,2:70\n*S KotlinDebug\n*F\n+ 1 BundleExt.kt\ncom/upuphone/xr/interconnect/util/BundleExtKt\n*L\n16#1:70,2\n*E\n"})
public final class BundleExtKt {
    @NotNull
    private static final Class<CharSequence[]> charSequenceArrayClass = CharSequence[].class;
    @NotNull
    private static final Class<Parcelable[]> parcelableArrayClass = Parcelable[].class;
    @NotNull
    private static final Class<String[]> stringArrayClass = String[].class;

    @NotNull
    public static final Bundle toBundle(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                bundle.putByte(str, ((Number) value).byteValue());
            } else if (value instanceof Character) {
                bundle.putChar(str, ((Character) value).charValue());
            } else if (value instanceof Short) {
                bundle.putShort(str, ((Number) value).shortValue());
            } else if (value instanceof Float) {
                bundle.putFloat(str, ((Number) value).floatValue());
            } else if (value instanceof Integer) {
                bundle.putInt(str, ((Number) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(str, ((Number) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(str, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                bundle.putString(str, (String) value);
            } else if (value instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) value);
            } else if (value instanceof Size) {
                bundle.putSize(str, (Size) value);
            } else if (value instanceof SizeF) {
                bundle.putSizeF(str, (SizeF) value);
            } else if (value instanceof Binder) {
                bundle.putBinder(str, (IBinder) value);
            } else if (value instanceof Bundle) {
                bundle.putBundle(str, (Bundle) value);
            } else if (value instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) value);
            } else if (value instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) value);
            } else if (value instanceof short[]) {
                bundle.putShortArray(str, (short[]) value);
            } else if (value instanceof char[]) {
                bundle.putCharArray(str, (char[]) value);
            } else if (value instanceof float[]) {
                bundle.putFloatArray(str, (float[]) value);
            } else if (value instanceof int[]) {
                bundle.putIntArray(str, (int[]) value);
            } else if (value instanceof long[]) {
                bundle.putLongArray(str, (long[]) value);
            } else if (value instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) value);
            } else if (value instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) value);
            } else if (value instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) value);
            } else if (value instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) value;
                if (arrayList.isEmpty()) {
                    bundle.putStringArrayList(str, new ArrayList());
                } else {
                    Object obj = arrayList.get(0);
                    if (obj instanceof Integer) {
                        bundle.putIntegerArrayList(str, arrayList);
                    } else if (obj instanceof String) {
                        bundle.putStringArrayList(str, arrayList);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequenceArrayList(str, arrayList);
                    } else if (obj instanceof Parcelable) {
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable>{ kotlin.collections.TypeAliasesKt.ArrayList<out android.os.Parcelable> }");
                        bundle.putParcelableArrayList(str, arrayList);
                    }
                }
            } else if (value instanceof SparseArray) {
                bundle.putSparseParcelableArray(str, (SparseArray) value);
            } else if (value == null) {
                bundle.putString(str, (String) null);
            } else {
                Class<?> cls = value.getClass();
                if (Intrinsics.areEqual((Object) cls, (Object) stringArrayClass)) {
                    bundle.putStringArray(str, (String[]) value);
                } else if (Intrinsics.areEqual((Object) cls, (Object) charSequenceArrayClass)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) value);
                } else if (Intrinsics.areEqual((Object) cls, (Object) parcelableArrayClass)) {
                    bundle.putParcelableArray(str, (Parcelable[]) value);
                }
            }
        }
        return bundle;
    }
}
