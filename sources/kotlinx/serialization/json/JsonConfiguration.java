package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B«\u0001\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR \u0010\b\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b%\u0010\u001b\u0012\u0004\b'\u0010(\u001a\u0004\b&\u0010\u001dR \u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b,\u0010(\u001a\u0004\b+\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b%\u0010\u001dR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b\"\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b\u001a\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b/\u0010\u001dR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b2\u0010(\u001a\u0004\b.\u00101R \u0010\u0012\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b-\u0010\u001b\u0012\u0004\b3\u0010(\u001a\u0004\b)\u0010\u001dR \u0010\u0013\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b!\u0010\u001b\u0012\u0004\b4\u0010(\u001a\u0004\b \u0010\u001dR(\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b5\u00106\u0012\u0004\b:\u0010(\u001a\u0004\b#\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", "", "", "encodeDefaults", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "", "prettyPrintIndent", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "Lkotlinx/serialization/json/JsonNamingStrategy;", "namingStrategy", "decodeEnumsCaseInsensitive", "allowTrailingComma", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLkotlinx/serialization/json/JsonNamingStrategy;ZZLkotlinx/serialization/json/ClassDiscriminatorMode;)V", "toString", "()Ljava/lang/String;", "a", "Z", "h", "()Z", "b", "j", "c", "o", "d", "e", "getPrettyPrint", "f", "i", "getExplicitNulls$annotations", "()V", "g", "Ljava/lang/String;", "l", "getPrettyPrintIndent$annotations", "n", "k", "m", "Lkotlinx/serialization/json/JsonNamingStrategy;", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy$annotations", "getDecodeEnumsCaseInsensitive$annotations", "getAllowTrailingComma$annotations", "p", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4078a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final JsonNamingStrategy m;
    public final boolean n;
    public final boolean o;
    public ClassDiscriminatorMode p;

    public JsonConfiguration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, JsonNamingStrategy jsonNamingStrategy, boolean z11, boolean z12, ClassDiscriminatorMode classDiscriminatorMode) {
        ClassDiscriminatorMode classDiscriminatorMode2 = classDiscriminatorMode;
        Intrinsics.checkNotNullParameter(str, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(str2, "classDiscriminator");
        Intrinsics.checkNotNullParameter(classDiscriminatorMode2, "classDiscriminatorMode");
        this.f4078a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = str;
        this.h = z7;
        this.i = z8;
        this.j = str2;
        this.k = z9;
        this.l = z10;
        this.m = jsonNamingStrategy;
        this.n = z11;
        this.o = z12;
        this.p = classDiscriminatorMode2;
    }

    public final boolean a() {
        return this.k;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.o;
    }

    public final String d() {
        return this.j;
    }

    public final ClassDiscriminatorMode e() {
        return this.p;
    }

    public final boolean f() {
        return this.h;
    }

    public final boolean g() {
        return this.n;
    }

    public final boolean h() {
        return this.f4078a;
    }

    public final boolean i() {
        return this.f;
    }

    public final boolean j() {
        return this.b;
    }

    public final JsonNamingStrategy k() {
        return this.m;
    }

    public final String l() {
        return this.g;
    }

    public final boolean m() {
        return this.l;
    }

    public final boolean n() {
        return this.i;
    }

    public final boolean o() {
        return this.c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f4078a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=" + this.d + ", prettyPrint=" + this.e + ", explicitNulls=" + this.f + ", prettyPrintIndent='" + this.g + "', coerceInputValues=" + this.h + ", useArrayPolymorphism=" + this.i + ", classDiscriminator='" + this.j + "', allowSpecialFloatingPointValues=" + this.k + ", useAlternativeNames=" + this.l + ", namingStrategy=" + this.m + ", decodeEnumsCaseInsensitive=" + this.n + ", allowTrailingComma=" + this.o + ", classDiscriminatorMode=" + this.p + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JsonConfiguration(boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, java.lang.String r24, boolean r25, boolean r26, java.lang.String r27, boolean r28, boolean r29, kotlinx.serialization.json.JsonNamingStrategy r30, boolean r31, boolean r32, kotlinx.serialization.json.ClassDiscriminatorMode r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r22
        L_0x002a:
            r7 = r0 & 32
            r8 = 1
            if (r7 == 0) goto L_0x0031
            r7 = r8
            goto L_0x0033
        L_0x0031:
            r7 = r23
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            java.lang.String r9 = "    "
            goto L_0x003c
        L_0x003a:
            r9 = r24
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r25
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r26
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            java.lang.String r12 = "type"
            goto L_0x0055
        L_0x0053:
            r12 = r27
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005b
            r13 = 0
            goto L_0x005d
        L_0x005b:
            r13 = r28
        L_0x005d:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r8 = r29
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = 0
            goto L_0x006c
        L_0x006a:
            r14 = r30
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = 0
            goto L_0x0074
        L_0x0072:
            r15 = r31
        L_0x0074:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007a
            r2 = 0
            goto L_0x007c
        L_0x007a:
            r2 = r32
        L_0x007c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0086
            kotlinx.serialization.json.ClassDiscriminatorMode r0 = kotlinx.serialization.json.ClassDiscriminatorMode.POLYMORPHIC
            goto L_0x0088
        L_0x0086:
            r0 = r33
        L_0x0088:
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r8
            r30 = r14
            r31 = r15
            r32 = r2
            r33 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.JsonConfiguration.<init>(boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, boolean, java.lang.String, boolean, boolean, kotlinx.serialization.json.JsonNamingStrategy, boolean, boolean, kotlinx.serialization.json.ClassDiscriminatorMode, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
