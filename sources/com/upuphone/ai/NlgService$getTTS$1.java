package com.upuphone.ai;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "key", "", "value", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class NlgService$getTTS$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ String[] $sltKey;
    final /* synthetic */ String[] $sltValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NlgService$getTTS$1(Ref.IntRef intRef, String[] strArr, String[] strArr2) {
        super(2);
        this.$index = intRef;
        this.$sltKey = strArr;
        this.$sltValue = strArr2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        System.out.println("Index: " + this.$index.element + ", Key: " + str + ", Value: " + str2);
        String[] strArr = this.$sltKey;
        Ref.IntRef intRef = this.$index;
        int i = intRef.element;
        strArr[i] = str;
        this.$sltValue[i] = str2;
        intRef.element = i + 1;
    }
}
