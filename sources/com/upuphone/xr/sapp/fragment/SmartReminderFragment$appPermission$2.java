package com.upuphone.xr.sapp.fragment;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSmartReminderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$appPermission$2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,489:1\n37#2,2:490\n*S KotlinDebug\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$appPermission$2\n*L\n88#1:490,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$appPermission$2 extends Lambda implements Function0<String[]> {
    public static final SmartReminderFragment$appPermission$2 INSTANCE = new SmartReminderFragment$appPermission$2();

    public SmartReminderFragment$appPermission$2() {
        super(0);
    }

    @NotNull
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_PHONE_STATE");
        return (String[]) arrayList.toArray(new String[0]);
    }
}
