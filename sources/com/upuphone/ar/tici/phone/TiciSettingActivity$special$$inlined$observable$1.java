package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@SourceDebugExtension({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$observable$1\n+ 2 TiciSettingActivity.kt\ncom/upuphone/ar/tici/phone/TiciSettingActivity\n*L\n1#1,73:1\n65#2,6:74\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciSettingActivity$special$$inlined$observable$1 extends ObservableProperty<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciSettingActivity f5906a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciSettingActivity$special$$inlined$observable$1(Object obj, TiciSettingActivity ticiSettingActivity) {
        super(obj);
        this.f5906a = ticiSettingActivity;
    }

    public void afterChange(KProperty kProperty, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        int intValue = ((Number) obj2).intValue();
        int intValue2 = ((Number) obj).intValue();
        CommonExtKt.e("ticiMode changed, oldValue: " + intValue2 + ", newValue: " + intValue, "TiciSettingActivity");
        if (intValue2 != intValue) {
            TiciSettingActivity.M0(this.f5906a, intValue, false, 2, (Object) null);
        }
    }
}
