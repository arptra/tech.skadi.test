package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u001d\u001e\u001f !\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH¦\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\t8\u0016XD¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u0016¨\u0006#"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "", "isNullableAllowed", "<init>", "(Z)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "f", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "a", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "e", "(Ljava/lang/String;)Ljava/lang/Object;", "d", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "Z", "c", "()Z", "b", "Ljava/lang/String;", "name", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public abstract class NavType<T> {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final NavType d = new NavType$Companion$IntType$1();
    public static final NavType e = new NavType$Companion$ReferenceType$1();
    public static final NavType f = new NavType$Companion$IntArrayType$1();
    public static final NavType g = new NavType$Companion$LongType$1();
    public static final NavType h = new NavType$Companion$LongArrayType$1();
    public static final NavType i = new NavType$Companion$FloatType$1();
    public static final NavType j = new NavType$Companion$FloatArrayType$1();
    public static final NavType k = new NavType$Companion$BoolType$1();
    public static final NavType l = new NavType$Companion$BoolArrayType$1();
    public static final NavType m = new NavType$Companion$StringType$1();
    public static final NavType n = new NavType$Companion$StringArrayType$1();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1492a;
    public final String b = "nav_type";

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0011R\"\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!0\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "<init>", "()V", "", "type", "packageName", "Landroidx/navigation/NavType;", "a", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;", "value", "b", "(Ljava/lang/String;)Landroidx/navigation/NavType;", "c", "(Ljava/lang/Object;)Landroidx/navigation/NavType;", "", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "ReferenceType", "", "StringArrayType", "StringType", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public NavType a(String str, String str2) {
            NavType navType = NavType.d;
            if (Intrinsics.areEqual((Object) navType.b(), (Object) str)) {
                return navType;
            }
            NavType navType2 = NavType.f;
            if (Intrinsics.areEqual((Object) navType2.b(), (Object) str)) {
                return navType2;
            }
            NavType navType3 = NavType.g;
            if (Intrinsics.areEqual((Object) navType3.b(), (Object) str)) {
                return navType3;
            }
            NavType navType4 = NavType.h;
            if (Intrinsics.areEqual((Object) navType4.b(), (Object) str)) {
                return navType4;
            }
            NavType navType5 = NavType.k;
            if (Intrinsics.areEqual((Object) navType5.b(), (Object) str)) {
                return navType5;
            }
            NavType navType6 = NavType.l;
            if (Intrinsics.areEqual((Object) navType6.b(), (Object) str)) {
                return navType6;
            }
            NavType navType7 = NavType.m;
            if (Intrinsics.areEqual((Object) navType7.b(), (Object) str)) {
                return navType7;
            }
            NavType navType8 = NavType.n;
            if (Intrinsics.areEqual((Object) navType8.b(), (Object) str)) {
                return navType8;
            }
            NavType navType9 = NavType.i;
            if (Intrinsics.areEqual((Object) navType9.b(), (Object) str)) {
                return navType9;
            }
            NavType navType10 = NavType.j;
            if (Intrinsics.areEqual((Object) navType10.b(), (Object) str)) {
                return navType10;
            }
            NavType navType11 = NavType.e;
            if (Intrinsics.areEqual((Object) navType11.b(), (Object) str)) {
                return navType11;
            }
            if (str == null || str.length() == 0) {
                return navType7;
            }
            try {
                String stringPlus = (!StringsKt.startsWith$default(str, ".", false, 2, (Object) null) || str2 == null) ? str : Intrinsics.stringPlus(str2, str);
                Class<Serializable> cls = Serializable.class;
                Class<Parcelable> cls2 = Parcelable.class;
                if (StringsKt.endsWith$default(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null)) {
                    stringPlus = stringPlus.substring(0, stringPlus.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(stringPlus, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls3 = Class.forName(stringPlus);
                    if (cls2.isAssignableFrom(cls3)) {
                        return new ParcelableArrayType(cls3);
                    }
                    if (cls.isAssignableFrom(cls3)) {
                        return new SerializableArrayType(cls3);
                    }
                } else {
                    Class<?> cls4 = Class.forName(stringPlus);
                    if (cls2.isAssignableFrom(cls4)) {
                        return new ParcelableType(cls4);
                    }
                    if (Enum.class.isAssignableFrom(cls4)) {
                        return new EnumType(cls4);
                    }
                    if (cls.isAssignableFrom(cls4)) {
                        return new SerializableType(cls4);
                    }
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus(stringPlus, " is not Serializable or Parcelable."));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = androidx.navigation.NavType.k;
            r0.e(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
            return androidx.navigation.NavType.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r0 = androidx.navigation.NavType.g;
            r0.e(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            r0 = androidx.navigation.NavType.i;
            r0.e(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.NavType b(java.lang.String r1) {
            /*
                r0 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                androidx.navigation.NavType r0 = androidx.navigation.NavType.d     // Catch:{ IllegalArgumentException -> 0x000b }
                r0.e(r1)     // Catch:{ IllegalArgumentException -> 0x000b }
                return r0
            L_0x000b:
                androidx.navigation.NavType r0 = androidx.navigation.NavType.g     // Catch:{ IllegalArgumentException -> 0x0011 }
                r0.e(r1)     // Catch:{ IllegalArgumentException -> 0x0011 }
                return r0
            L_0x0011:
                androidx.navigation.NavType r0 = androidx.navigation.NavType.i     // Catch:{ IllegalArgumentException -> 0x0017 }
                r0.e(r1)     // Catch:{ IllegalArgumentException -> 0x0017 }
                return r0
            L_0x0017:
                androidx.navigation.NavType r0 = androidx.navigation.NavType.k     // Catch:{ IllegalArgumentException -> 0x001d }
                r0.e(r1)     // Catch:{ IllegalArgumentException -> 0x001d }
                return r0
            L_0x001d:
                androidx.navigation.NavType r0 = androidx.navigation.NavType.m
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.Companion.b(java.lang.String):androidx.navigation.NavType");
        }

        public final NavType c(Object obj) {
            if (obj instanceof Integer) {
                return NavType.d;
            }
            if (obj instanceof int[]) {
                return NavType.f;
            }
            if (obj instanceof Long) {
                return NavType.g;
            }
            if (obj instanceof long[]) {
                return NavType.h;
            }
            if (obj instanceof Float) {
                return NavType.i;
            }
            if (obj instanceof float[]) {
                return NavType.j;
            }
            if (obj instanceof Boolean) {
                return NavType.k;
            }
            if (obj instanceof boolean[]) {
                return NavType.l;
            }
            if ((obj instanceof String) || obj == null) {
                return NavType.m;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return NavType.n;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    if (componentType2 != null) {
                        return new ParcelableArrayType(componentType2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    if (componentType4 != null) {
                        return new SerializableArrayType(componentType4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                }
            }
            if (obj instanceof Parcelable) {
                return new ParcelableType(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new EnumType(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new SerializableType(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\f\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "", "D", "Landroidx/navigation/NavType$SerializableType;", "Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;)V", "", "value", "j", "(Ljava/lang/String;)Ljava/lang/Enum;", "p", "Ljava/lang/Class;", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        public final Class p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumType(Class cls) {
            super(false, cls);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (cls.isEnum()) {
                this.p = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        public String b() {
            String name = this.p.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        /* renamed from: j */
        public Enum h(String str) {
            Enum enumR;
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            Object[] enumConstants = this.p.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    enumR = null;
                    break;
                }
                enumR = enumConstants[i];
                i++;
                if (StringsKt.equals(((Enum) enumR).name(), str, true)) {
                    break;
                }
            }
            Enum enumR2 = enumR;
            if (enumR2 != null) {
                return enumR2;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.p.getName() + '.');
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "Landroid/os/Parcelable;", "D", "Landroidx/navigation/NavType;", "", "Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "i", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "h", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "o", "Ljava/lang/Class;", "arrayType", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        public final Class o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.o = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public String b() {
            String name = this.o.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!Intrinsics.areEqual((Object) ParcelableArrayType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.o, (Object) ((ParcelableArrayType) obj).o);
        }

        /* renamed from: g */
        public Parcelable[] a(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            return (Parcelable[]) bundle.get(str);
        }

        /* renamed from: h */
        public Parcelable[] e(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        /* renamed from: i */
        public void f(Bundle bundle, String str, Parcelable[] parcelableArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            this.o.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "f", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "a", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "e", "(Ljava/lang/String;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "o", "Ljava/lang/Class;", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class ParcelableType<D> extends NavType<D> {
        public final Class o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public Object a(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            return bundle.get(str);
        }

        public String b() {
            String name = this.o.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public Object e(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!Intrinsics.areEqual((Object) ParcelableType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.o, (Object) ((ParcelableType) obj).o);
        }

        public void f(Bundle bundle, String str, Object obj) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            this.o.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }

        public int hashCode() {
            return this.o.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/NavType;", "", "Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "i", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "h", "(Ljava/lang/String;)[Ljava/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "o", "Ljava/lang/Class;", "arrayType", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        public final Class o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.o = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public String b() {
            String name = this.o.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!Intrinsics.areEqual((Object) SerializableArrayType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.o, (Object) ((SerializableArrayType) obj).o);
        }

        /* renamed from: g */
        public Serializable[] a(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            return (Serializable[]) bundle.get(str);
        }

        /* renamed from: h */
        public Serializable[] e(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: i */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(android.os.Bundle r2, java.lang.String r3, java.io.Serializable[] r4) {
            /*
                r1 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "key"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.Class r1 = r1.o
                r1.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.SerializableArrayType.f(android.os.Bundle, java.lang.String, java.io.Serializable[]):void");
        }
    }

    public NavType(boolean z) {
        this.f1492a = z;
    }

    public abstract Object a(Bundle bundle, String str);

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.f1492a;
    }

    public final Object d(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        Object e2 = e(str2);
        f(bundle, str, e2);
        return e2;
    }

    public abstract Object e(String str);

    public abstract void f(Bundle bundle, String str, Object obj);

    public String toString() {
        return b();
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001f\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/NavType;", "Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;)V", "", "nullableAllowed", "(ZLjava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "i", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "h", "(Ljava/lang/String;)Ljava/io/Serializable;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "o", "Ljava/lang/Class;", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        public final Class o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(Class cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (true ^ cls.isEnum()) {
                this.o = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        public String b() {
            String name = this.o.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.o, (Object) ((SerializableType) obj).o);
        }

        /* renamed from: g */
        public Serializable a(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            return (Serializable) bundle.get(str);
        }

        /* renamed from: h */
        public Serializable e(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        /* renamed from: i */
        public void f(Bundle bundle, String str, Serializable serializable) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            Intrinsics.checkNotNullParameter(serializable, AccountConstantKt.RESPONSE_VALUE);
            this.o.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z, Class cls) {
            super(z);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }
}
