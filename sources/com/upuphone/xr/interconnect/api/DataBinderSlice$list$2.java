package com.upuphone.xr.interconnect.api;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataBinderSlice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderSlice.kt\ncom/upuphone/xr/interconnect/api/DataBinderSlice$list$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,152:1\n766#2:153\n857#2,2:154\n1549#2:156\n1620#2,3:157\n*S KotlinDebug\n*F\n+ 1 DataBinderSlice.kt\ncom/upuphone/xr/interconnect/api/DataBinderSlice$list$2\n*L\n121#1:153\n121#1:154,2\n121#1:156\n121#1:157,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.api.DataBinderSlice$list$2", f = "DataBinderSlice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DataBinderSlice$list$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String[] $params;
    int label;
    final /* synthetic */ DataBinderSlice this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderSlice$list$2(DataBinderSlice dataBinderSlice, String[] strArr, String str, Continuation<? super DataBinderSlice$list$2> continuation) {
        super(2, continuation);
        this.this$0 = dataBinderSlice;
        this.$params = strArr;
        this.$deviceId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataBinderSlice$list$2(this.this$0, this.$params, this.$deviceId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String access$getDataName = this.this$0.getDataName(this.$params);
            List<String> list = this.this$0.operator.list(this.$deviceId);
            if (list == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (T next : list) {
                String str2 = (String) next;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                if (StringsKt.startsWith$default(str2, access$getDataName, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (String str3 : arrayList) {
                if (str3.length() == access$getDataName.length()) {
                    str = "";
                } else {
                    int length = str3.charAt(access$getDataName.length()) == '/' ? access$getDataName.length() + 1 : access$getDataName.length();
                    Intrinsics.checkNotNullExpressionValue(str3, "it");
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '/', length, false, 4, (Object) null);
                    if (indexOf$default == -1) {
                        str = str3.substring(length);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                    } else {
                        str = str3.substring(length, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                }
                arrayList2.add(str);
            }
            return CollectionsKt.distinct(arrayList2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<String>> continuation) {
        return ((DataBinderSlice$list$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
