package com.xjsd.ai.assistant.skill.navigation.optimize;

import com.meizu.common.util.LunarCalendar;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.protocol.nav.TypedPoiResult;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001c\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010*¨\u0006,"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/optimize/NavOptimizer;", "", "<init>", "()V", "", "accountId", "", "g", "(Ljava/lang/String;)V", "poi", "Lcom/xjsd/ai/assistant/skill/navigation/optimize/NavPoiHistory;", "e", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/skill/navigation/optimize/NavPoiHistory;", "designatedNavMode", "designatedRouteMode", "", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/upuphone/xr/interconnect/entity/PoiResult;", "poiResult", "Lcom/xjsd/ai/assistant/skill/navigation/NavManager$NavConfig;", "navConfig", "j", "(Lcom/upuphone/xr/interconnect/entity/PoiResult;Lcom/xjsd/ai/assistant/skill/navigation/NavManager$NavConfig;)V", "", "standard", "", "edit", "h", "(Ljava/util/List;Ljava/util/Map;)V", "k", "f", "(Lcom/upuphone/xr/interconnect/entity/PoiResult;)Ljava/lang/String;", "d", "(Ljava/lang/String;)Ljava/lang/String;", "b", "Ljava/lang/String;", "loginAccountId", "Ljava/util/Stack;", "c", "Ljava/util/Stack;", "poiStack", "Ljava/util/Map;", "historyMap", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNavOptimizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavOptimizer.kt\ncom/xjsd/ai/assistant/skill/navigation/optimize/NavOptimizer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,144:1\n1855#2,2:145\n551#3:147\n536#3,6:148\n215#4,2:154\n*S KotlinDebug\n*F\n+ 1 NavOptimizer.kt\ncom/xjsd/ai/assistant/skill/navigation/optimize/NavOptimizer\n*L\n114#1:145,2\n117#1:147\n117#1:148,6\n118#1:154,2\n*E\n"})
public final class NavOptimizer {

    /* renamed from: a  reason: collision with root package name */
    public static final NavOptimizer f8690a = new NavOptimizer();
    public static String b = "";
    public static final Stack c = new Stack();
    public static final Map d = new LinkedHashMap();

    public final String d(String str) {
        return "nav_history_" + str;
    }

    public final NavPoiHistory e(String str) {
        Intrinsics.checkNotNullParameter(str, "poi");
        List<PoiResult> freqVisitedAddress = SuperAppAbilityManager.e().f().getFreqVisitedAddress();
        if (freqVisitedAddress == null || freqVisitedAddress.isEmpty()) {
            d.clear();
            return null;
        }
        Map map = d;
        h(freqVisitedAddress, map);
        NavPoiHistory navPoiHistory = (NavPoiHistory) map.get(str);
        if (navPoiHistory != null) {
            return navPoiHistory;
        }
        Stack stack = c;
        if (!stack.isEmpty()) {
            stack.pop();
        }
        stack.push(str);
        return null;
    }

    public final String f(PoiResult poiResult) {
        String name = poiResult.getName();
        double latitude = poiResult.getLatitude();
        double longitude = poiResult.getLongitude();
        return name + LunarCalendar.DATE_SEPARATOR + latitude + LunarCalendar.DATE_SEPARATOR + longitude;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        if (!Intrinsics.areEqual((Object) b, (Object) str)) {
            b = str;
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new NavOptimizer$loadUserData$1((Continuation<? super NavOptimizer$loadUserData$1>) null), 3, (Object) null);
        }
    }

    public final void h(List list, Map map) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(f8690a.f((PoiResult) it.next()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!hashSet.contains(f8690a.f((PoiResult) entry.getValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry key : linkedHashMap.entrySet()) {
            map.remove((String) key.getKey());
        }
        if (!linkedHashMap.isEmpty()) {
            k();
        }
    }

    public final boolean i(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "poi");
        NavPoiHistory e = e(str);
        if (e == null) {
            return false;
        }
        if (str2 == null && (str2 = e.getNavMode()) == null) {
            str2 = "default";
        }
        if (str3 == null && (str3 = e.getRouteMode()) == null) {
            str3 = "default";
        }
        NavManager.j().z(str2);
        NavManager.j().A(str3);
        NavManager.j().p(new TypedPoiResult(e, 0));
        return true;
    }

    public final void j(PoiResult poiResult, NavManager.NavConfig navConfig) {
        Intrinsics.checkNotNullParameter(poiResult, "poiResult");
        Intrinsics.checkNotNullParameter(navConfig, "navConfig");
        Stack stack = c;
        if (!stack.isEmpty()) {
            String str = (String) stack.pop();
            Map map = d;
            Intrinsics.checkNotNull(str);
            map.put(str, new NavPoiHistory(poiResult, navConfig.d().getMode(), navConfig.c().getMode()));
            k();
        }
    }

    public final void k() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new NavOptimizer$updateHistory$1((Continuation<? super NavOptimizer$updateHistory$1>) null), 3, (Object) null);
    }
}
