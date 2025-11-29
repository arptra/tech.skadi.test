package com.upuphone.ar.tici.phone.viewmodel;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nImportFileViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel$makeAdditionalDirs$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1603#2,9:118\n1855#2:127\n1856#2:129\n1612#2:130\n1#3:128\n*S KotlinDebug\n*F\n+ 1 ImportFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel$makeAdditionalDirs$2\n*L\n105#1:118,9\n105#1:127\n105#1:129\n105#1:130\n105#1:128\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel$makeAdditionalDirs$2", f = "ImportFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImportFileViewModel$makeAdditionalDirs$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ File $parentFile;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportFileViewModel$makeAdditionalDirs$2(File file, Continuation<? super ImportFileViewModel$makeAdditionalDirs$2> continuation) {
        super(2, continuation);
        this.$parentFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImportFileViewModel$makeAdditionalDirs$2(this.$parentFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IntRange intRange = new IntRange(1, 999);
            File file = this.$parentFile;
            ArrayList arrayList = new ArrayList();
            Iterator it = intRange.iterator();
            while (it.hasNext()) {
                String str = null;
                try {
                    File file2 = new File(file, String.valueOf(((IntIterator) it).nextInt()));
                    if (file2.exists()) {
                        str = file2.getAbsolutePath();
                    }
                } catch (Exception e) {
                    CommonExtKt.d("makeAdditionalDirs, error: " + e, "ImportFileViewModel", (Throwable) null, 2, (Object) null);
                }
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<String>> continuation) {
        return ((ImportFileViewModel$makeAdditionalDirs$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
