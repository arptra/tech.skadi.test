package com.upuphone.ar.tici.phone.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.io.File;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R,\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u000b0#0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001bR/\u0010)\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u000b0#0\u001d8\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!¨\u0006,"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "m", "()V", "Ljava/io/File;", "parentFile", "", "", "l", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "b", "Ljava/time/LocalDate;", "today", "c", "recentWeek", "d", "recentMonth", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/tici/phone/data/ScanFileState;", "e", "Landroidx/lifecycle/MutableLiveData;", "_scanFileState", "Landroidx/lifecycle/LiveData;", "f", "Landroidx/lifecycle/LiveData;", "j", "()Landroidx/lifecycle/LiveData;", "scanFileState", "", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "g", "_systemFileGroup", "h", "k", "systemFileGroup", "i", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class ImportFileViewModel extends AndroidViewModel {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public final LocalDate b;
    public final LocalDate c;
    public final LocalDate d;
    public final MutableLiveData e;
    public final LiveData f;
    public final MutableLiveData g;
    public final LiveData h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportFileViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        LocalDate now = LocalDate.now();
        this.b = now;
        this.c = now.minusDays(7);
        this.d = now.minusDays(30);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData;
        this.f = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.g = mutableLiveData2;
        this.h = mutableLiveData2;
    }

    public final LiveData j() {
        return this.f;
    }

    public final LiveData k() {
        return this.h;
    }

    public final Object l(File file, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new ImportFileViewModel$makeAdditionalDirs$2(file, (Continuation<? super ImportFileViewModel$makeAdditionalDirs$2>) null), continuation);
    }

    public final void m() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ImportFileViewModel$scanTxtFiles$1(this, (Continuation<? super ImportFileViewModel$scanTxtFiles$1>) null), 3, (Object) null);
    }
}
