package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u000e\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fH@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "Lkotlinx/serialization/json/JsonElement;", "e", "()Lkotlinx/serialization/json/JsonElement;", "i", "Lkotlin/DeepRecursiveScope;", "", "h", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "", "isString", "Lkotlinx/serialization/json/JsonPrimitive;", "j", "(Z)Lkotlinx/serialization/json/JsonPrimitive;", "g", "a", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "b", "Z", "isLenient", "c", "trailingCommaAllowed", "", "d", "I", "stackDepth", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nJsonTreeReader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonTreeReader.kt\nkotlinx/serialization/json/internal/JsonTreeReader\n+ 2 AbstractJsonLexer.kt\nkotlinx/serialization/json/internal/AbstractJsonLexer\n*L\n1#1,121:1\n27#1,25:122\n27#1,25:147\n531#2,3:172\n*S KotlinDebug\n*F\n+ 1 JsonTreeReader.kt\nkotlinx/serialization/json/internal/JsonTreeReader\n*L\n19#1:122,25\n24#1:147,25\n64#1:172,3\n*E\n"})
public final class JsonTreeReader {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractJsonLexer f4115a;
    public final boolean b;
    public final boolean c;
    public int d;

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        this.f4115a = abstractJsonLexer;
        this.b = jsonConfiguration.o();
        this.c = jsonConfiguration.c();
    }

    public final JsonElement e() {
        byte H = this.f4115a.H();
        if (H == 1) {
            return j(true);
        }
        if (H == 0) {
            return j(false);
        }
        if (H == 6) {
            int i = this.d + 1;
            this.d = i;
            this.d--;
            return i == 200 ? g() : i();
        } else if (H == 8) {
            return f();
        } else {
            AbstractJsonLexer.x(this.f4115a, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.c(H), 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final JsonElement f() {
        byte j = this.f4115a.j();
        if (this.f4115a.H() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.f4115a.e()) {
                arrayList.add(e());
                j = this.f4115a.j();
                if (j != 4) {
                    AbstractJsonLexer abstractJsonLexer = this.f4115a;
                    boolean z = j == 9;
                    int i = abstractJsonLexer.f4093a;
                    if (!z) {
                        AbstractJsonLexer.x(abstractJsonLexer, "Expected end of the array or comma", i, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (j == 8) {
                this.f4115a.k((byte) 9);
            } else if (j == 4) {
                if (this.c) {
                    this.f4115a.k((byte) 9);
                } else {
                    JsonExceptionsKt.h(this.f4115a, "array");
                    throw new KotlinNothingValueException();
                }
            }
            return new JsonArray(arrayList);
        }
        AbstractJsonLexer.x(this.f4115a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final JsonElement g() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, (Continuation<? super JsonTreeReader$readDeepRecursive$1>) null)), Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.DeepRecursiveScope r20, kotlin.coroutines.Continuation r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r2 == 0) goto L_0x0017
            r2 = r1
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 6
            r6 = 7
            r7 = 4
            r8 = 1
            if (r4 == 0) goto L_0x004d
            if (r4 != r8) goto L_0x0045
            java.lang.Object r0 = r2.L$3
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r2.L$2
            java.util.LinkedHashMap r4 = (java.util.LinkedHashMap) r4
            java.lang.Object r9 = r2.L$1
            kotlinx.serialization.json.internal.JsonTreeReader r9 = (kotlinx.serialization.json.internal.JsonTreeReader) r9
            java.lang.Object r10 = r2.L$0
            kotlin.DeepRecursiveScope r10 = (kotlin.DeepRecursiveScope) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r4
            r4 = r2
            r2 = r17
            goto L_0x00a5
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.f4115a
            byte r1 = r1.k(r5)
            kotlinx.serialization.json.internal.AbstractJsonLexer r4 = r0.f4115a
            byte r4 = r4.H()
            if (r4 == r7) goto L_0x00fb
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r9 = r4
            r4 = r2
            r2 = r1
            r1 = r20
        L_0x0068:
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r0.f4115a
            boolean r10 = r10.e()
            if (r10 == 0) goto L_0x00d5
            boolean r2 = r0.b
            if (r2 == 0) goto L_0x007b
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.f4115a
            java.lang.String r2 = r2.q()
            goto L_0x0081
        L_0x007b:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.f4115a
            java.lang.String r2 = r2.o()
        L_0x0081:
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r0.f4115a
            r11 = 5
            r10.k(r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r4.L$0 = r1
            r4.L$1 = r0
            r4.L$2 = r9
            r4.L$3 = r2
            r4.label = r8
            java.lang.Object r10 = r1.callRecursive(r10, r4)
            if (r10 != r3) goto L_0x009a
            return r3
        L_0x009a:
            r17 = r9
            r9 = r0
            r0 = r2
            r2 = r17
            r18 = r10
            r10 = r1
            r1 = r18
        L_0x00a5:
            kotlinx.serialization.json.JsonElement r1 = (kotlinx.serialization.json.JsonElement) r1
            r2.put(r0, r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r9.f4115a
            byte r0 = r0.j()
            if (r0 == r7) goto L_0x00cd
            if (r0 != r6) goto L_0x00bb
            r17 = r2
            r2 = r0
            r0 = r9
            r9 = r17
            goto L_0x00d5
        L_0x00bb:
            kotlinx.serialization.json.internal.AbstractJsonLexer r11 = r9.f4115a
            r15 = 6
            r16 = 0
            java.lang.String r12 = "Expected end of the object or comma"
            r13 = 0
            r14 = 0
            kotlinx.serialization.json.internal.AbstractJsonLexer.x(r11, r12, r13, r14, r15, r16)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00cd:
            r1 = r10
            r17 = r2
            r2 = r0
            r0 = r9
            r9 = r17
            goto L_0x0068
        L_0x00d5:
            if (r2 != r5) goto L_0x00dd
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.f4115a
            r0.k(r6)
            goto L_0x00f5
        L_0x00dd:
            if (r2 != r7) goto L_0x00f5
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x00e9
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.f4115a
            r0.k(r6)
            goto L_0x00f5
        L_0x00e9:
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.f4115a
            r1 = 0
            kotlinx.serialization.json.internal.JsonExceptionsKt.i(r0, r1, r8, r1)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00f5:
            kotlinx.serialization.json.JsonObject r0 = new kotlinx.serialization.json.JsonObject
            r0.<init>(r9)
            return r0
        L_0x00fb:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.f4115a
            r5 = 6
            r6 = 0
            java.lang.String r2 = "Unexpected leading comma"
            r3 = 0
            r4 = 0
            kotlinx.serialization.json.internal.AbstractJsonLexer.x(r1, r2, r3, r4, r5, r6)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JsonElement i() {
        byte k = this.f4115a.k((byte) 6);
        if (this.f4115a.H() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.f4115a.e()) {
                    break;
                }
                String q = this.b ? this.f4115a.q() : this.f4115a.o();
                this.f4115a.k((byte) 5);
                linkedHashMap.put(q, e());
                k = this.f4115a.j();
                if (k != 4) {
                    if (k != 7) {
                        AbstractJsonLexer.x(this.f4115a, "Expected end of the object or comma", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (k == 6) {
                this.f4115a.k((byte) 7);
            } else if (k == 4) {
                if (this.c) {
                    this.f4115a.k((byte) 7);
                } else {
                    JsonExceptionsKt.i(this.f4115a, (String) null, 1, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.x(this.f4115a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final JsonPrimitive j(boolean z) {
        String q = (this.b || !z) ? this.f4115a.q() : this.f4115a.o();
        return (z || !Intrinsics.areEqual((Object) q, (Object) "null")) ? new JsonLiteral(q, z, (SerialDescriptor) null, 4, (DefaultConstructorMarker) null) : JsonNull.INSTANCE;
    }
}
