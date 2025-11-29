package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import com.honey.account.x4.c;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.bean.IdTitleBean;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010*¨\u0006/"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator;", "", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "", "i", "()V", "k", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "noteBean", "f", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "", "ids", "d", "([J)V", "", "h", "()Ljava/lang/String;", "numStr", "", "j", "(Ljava/lang/String;)Z", "a", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;", "c", "Ljava/util/List;", "recordList", "", "", "Ljava/util/Set;", "sourceSet", "e", "targetSet", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TitleGenerator {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6107a;
    public final CoroutineScope b;
    public List c = new ArrayList();
    public Set d = new LinkedHashSet();
    public Set e = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TitleGenerator(Context context, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f6107a = context;
        this.b = coroutineScope;
    }

    public static final boolean e(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void d(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "ids");
        this.c.removeIf(new c(new TitleGenerator$deleteByIds$1(jArr)));
    }

    public final void f(TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        LogExt.g("deleteRecordTitle noteBean=" + transcribeBean, "TitleGenerator");
        int i = 0;
        for (IdTitleBean id : this.c) {
            int i2 = i + 1;
            if (Intrinsics.areEqual((Object) transcribeBean.getId(), (Object) id.getId())) {
                this.c.remove(i);
                return;
            }
            i = i2;
        }
    }

    public final Context g() {
        return this.f6107a;
    }

    public final String h() {
        this.d.clear();
        this.e.clear();
        String str = this.f6107a.getString(R.string.transcribe_app_name) + " ";
        int i = 0;
        for (IdTitleBean superTitle : this.c) {
            i++;
            this.d.add(Integer.valueOf(i));
            String superTitle2 = superTitle.getSuperTitle();
            if (superTitle2 != null && StringsKt.startsWith$default(superTitle2, str, false, 2, (Object) null)) {
                String substring = superTitle2.substring(str.length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (j(substring)) {
                    this.e.add(Integer.valueOf(Integer.parseInt(substring)));
                }
            }
        }
        if (this.d.isEmpty()) {
            return str + "1";
        }
        LogExt.g("getTitle mSourceSet[" + this.d + "], mTargetSet[" + this.e + "]", "TitleGenerator");
        List sorted = CollectionsKt.sorted(CollectionsKt.subtract(this.d, this.e));
        if (sorted.isEmpty()) {
            List sorted2 = CollectionsKt.sorted(this.d);
            return str + (((Number) sorted2.get(CollectionsKt.getLastIndex(sorted2))).intValue() + 1);
        }
        return str + sorted.get(0);
    }

    public final void i() {
        Job unused = BuildersKt__Builders_commonKt.d(this.b, (CoroutineContext) null, (CoroutineStart) null, new TitleGenerator$init$1(this, (Continuation<? super TitleGenerator$init$1>) null), 3, (Object) null);
    }

    public final boolean j(String str) {
        return !StringsKt.isBlank(str) && new Regex("\\d+").matches(str) && Integer.parseInt(str) > 0;
    }

    public final void k() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }
}
