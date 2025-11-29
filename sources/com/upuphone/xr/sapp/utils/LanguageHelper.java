package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.entity.LanguageMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/LanguageHelper;", "", "<init>", "()V", "", "Lcom/upuphone/xr/sapp/entity/LanguageMode;", "a", "()Ljava/util/List;", "", "targetVersion", "", "b", "(Ljava/lang/String;)Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLanguageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageHelper.kt\ncom/upuphone/xr/sapp/utils/LanguageHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n1002#2,2:158\n*S KotlinDebug\n*F\n+ 1 LanguageHelper.kt\ncom/upuphone/xr/sapp/utils/LanguageHelper\n*L\n139#1:158,2\n*E\n"})
public final class LanguageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final LanguageHelper f7894a = new LanguageHelper();

    public final List a() {
        boolean isAir = InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LanguageMode(R.string.cn_zh, false, "zh-CN", 9, 2, (DefaultConstructorMarker) null));
        arrayList.add(new LanguageMode(R.string.en_us, false, "en-US", 0, 2, (DefaultConstructorMarker) null));
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            if (isAir) {
                arrayList.add(new LanguageMode(R.string.bahasa_melayu, false, "ms-MY", 6, 2, (DefaultConstructorMarker) null));
                arrayList.add(new LanguageMode(R.string.lan_th, false, "th-TH", 7, 2, (DefaultConstructorMarker) null));
                arrayList.add(new LanguageMode(R.string.lan_indonesia, false, "id-ID", 3, 2, (DefaultConstructorMarker) null));
                if (b("1.0.9.13")) {
                    arrayList.add(new LanguageMode(R.string.lan_de, false, "de-DE", 2, 2, (DefaultConstructorMarker) null));
                    arrayList.add(new LanguageMode(R.string.lan_fr, false, "fr-FR", 1, 2, (DefaultConstructorMarker) null));
                    arrayList.add(new LanguageMode(R.string.lan_it, false, "it-IT", 4, 2, (DefaultConstructorMarker) null));
                }
                if (b("1.0.10")) {
                    arrayList.add(new LanguageMode(R.string.lan_tr, false, "tr-TR", 7, 2, (DefaultConstructorMarker) null));
                }
            } else {
                arrayList.add(new LanguageMode(R.string.lan_de, false, "de-DE", 2, 2, (DefaultConstructorMarker) null));
                arrayList.add(new LanguageMode(R.string.lan_fr, false, "fr-FR", 1, 2, (DefaultConstructorMarker) null));
                if (b("1.1.4")) {
                    arrayList.add(new LanguageMode(R.string.lan_ko, false, "ko-KR", 1, 2, (DefaultConstructorMarker) null));
                    arrayList.add(new LanguageMode(R.string.lan_ja, false, "ja-JP", 1, 2, (DefaultConstructorMarker) null));
                    arrayList.add(new LanguageMode(R.string.lan_ar, false, "ar-SA", 1, 2, (DefaultConstructorMarker) null));
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new LanguageHelper$getSupportLanguage$$inlined$sortBy$1());
        }
        return arrayList;
    }

    public final boolean b(String str) {
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null) {
            return false;
        }
        String c = GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion()));
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MainApplication", "supportVersion glassVersion:" + c + " targetVersion:" + str);
        return GlassInfoExtKt.j(c, str) >= 0;
    }
}
