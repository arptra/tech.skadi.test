package com.upuphone.ai;

import android.app.Application;
import com.honey.account.m3.a;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H ¢\u0006\u0004\b\f\u0010\rJC\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ai/NlgService;", "", "<init>", "()V", "", "nlgId", "functionId", "", "slotKey", "slotValue", "speakId", "path", "getTtsFromJni", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "slots", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Application;", "c", "()Landroid/app/Application;", "a", "Landroid/app/Application;", "sApplication", "b", "Lkotlin/Lazy;", "e", "()Ljava/lang/String;", "nlg_path", "Companion", "SingleHolder", "nlg-sdk_release"}, k = 1, mv = {1, 8, 0})
public final class NlgService {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Application f5485a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ai/NlgService$Companion;", "", "<init>", "()V", "Lcom/upuphone/ai/NlgService;", "a", "()Lcom/upuphone/ai/NlgService;", "nlg-sdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NlgService a() {
            return SingleHolder.f5486a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ai/NlgService$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ai/NlgService;", "b", "Lcom/upuphone/ai/NlgService;", "a", "()Lcom/upuphone/ai/NlgService;", "holder", "nlg-sdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f5486a = new SingleHolder();
        public static final NlgService b = new NlgService((DefaultConstructorMarker) null);

        public final NlgService a() {
            return b;
        }
    }

    static {
        System.loadLibrary("nlg_sdk");
    }

    public /* synthetic */ NlgService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final NlgService d() {
        return c.a();
    }

    public static final void g(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    private final native String getTtsFromJni(String str, String str2, String[] strArr, String[] strArr2, String str3, String str4);

    public final Application c() {
        if (this.f5485a == null) {
            try {
                Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", (Class[]) null).invoke((Object) null, (Object[]) null);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.app.Application");
                this.f5485a = (Application) invoke;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f5485a;
    }

    public final String e() {
        return (String) this.b.getValue();
    }

    public final String f(String str, String str2, Map map, String str3) {
        int size = map != null ? map.size() : 0;
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = "";
        }
        String[] strArr2 = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr2[i2] = "";
        }
        Ref.IntRef intRef = new Ref.IntRef();
        if (map != null) {
            map.forEach(new a(new NlgService$getTTS$1(intRef, strArr, strArr2)));
        }
        String e = e();
        if (e == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        return getTtsFromJni(str, str2 == null ? "" : str2, strArr, strArr2, str3 == null ? "" : str3, e);
    }

    public NlgService() {
        this.b = LazyKt.lazy(new NlgService$nlg_path$2(this));
    }
}
