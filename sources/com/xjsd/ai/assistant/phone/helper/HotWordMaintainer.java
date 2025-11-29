package com.xjsd.ai.assistant.phone.helper;

import com.honey.account.ka.b;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.stks.OfflineKey;
import com.xjsd.ai.assistant.common.util.StringUtil;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluContextDataMaintainer;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.protocol.stks.HotWordControl;
import com.xjsd.ai.assistant.protocol.stks.StksHotWordTransInfo;
import com.xjsd.ai.assistant.stks.dto.HotWord;
import com.xjsd.ai.assistant.stks.dto.STKSDto;
import com.xjsd.ai.assistant.stks.dto.STKSResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00130\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/HotWordMaintainer;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/stks/StksHotWordTransInfo;", "info", "", "b", "(Lcom/xjsd/ai/assistant/protocol/stks/StksHotWordTransInfo;)V", "c", "h", "Lcom/xjsd/ai/assistant/common/stks/OfflineKey;", "offlineKey", "", "Lcom/xjsd/ai/assistant/stks/dto/STKSResponse;", "i", "(Lcom/xjsd/ai/assistant/common/stks/OfflineKey;)Ljava/util/List;", "", "packageName", "Lcom/xjsd/ai/assistant/stks/dto/STKSDto;", "stksDto", "j", "(Ljava/lang/String;Lcom/xjsd/ai/assistant/stks/dto/STKSDto;)V", "f", "(Ljava/lang/String;Lcom/xjsd/ai/assistant/stks/dto/STKSDto;)Ljava/lang/String;", "Lcom/xjsd/ai/assistant/stks/dto/HotWord;", "dataInfo", "", "g", "(Lcom/xjsd/ai/assistant/common/stks/OfflineKey;Lcom/xjsd/ai/assistant/stks/dto/HotWord;)Z", "offline", "hotWord", "d", "(Lcom/xjsd/ai/assistant/stks/dto/STKSDto;Lcom/xjsd/ai/assistant/common/stks/OfflineKey;Lcom/xjsd/ai/assistant/stks/dto/HotWord;)Lcom/xjsd/ai/assistant/stks/dto/STKSResponse;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mHotWordCache", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHotWordMaintainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HotWordMaintainer.kt\ncom/xjsd/ai/assistant/phone/helper/HotWordMaintainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1855#2,2:184\n1360#2:188\n1446#2,2:189\n1360#2:191\n1446#2,2:192\n1603#2,9:194\n1855#2:203\n1856#2:205\n1612#2:206\n1448#2,3:207\n1448#2,3:210\n215#3,2:186\n215#3,2:213\n1#4:204\n*S KotlinDebug\n*F\n+ 1 HotWordMaintainer.kt\ncom/xjsd/ai/assistant/phone/helper/HotWordMaintainer\n*L\n35#1:184,2\n44#1:188\n44#1:189,2\n45#1:191\n45#1:192,2\n46#1:194,9\n46#1:203\n46#1:205\n46#1:206\n45#1:207,3\n44#1:210,3\n41#1:186,2\n123#1:213,2\n46#1:204\n*E\n"})
public final class HotWordMaintainer {

    /* renamed from: a  reason: collision with root package name */
    public static final HotWordMaintainer f8564a = new HotWordMaintainer();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    public static final boolean e(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void b(StksHotWordTransInfo stksHotWordTransInfo) {
        String str;
        Intrinsics.checkNotNullParameter(stksHotWordTransInfo, "info");
        String packageName = stksHotWordTransInfo.getPackageName();
        List<STKSDto> data = stksHotWordTransInfo.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        for (STKSDto sTKSDto : data) {
            HotWordMaintainer hotWordMaintainer = f8564a;
            Intrinsics.checkNotNull(packageName);
            Intrinsics.checkNotNull(sTKSDto);
            hotWordMaintainer.j(packageName, sTKSDto);
        }
        ArrayList<STKSDto> arrayList = new ArrayList<>();
        for (Map.Entry value : b.entrySet()) {
            arrayList.add((STKSDto) value.getValue());
        }
        ArrayList arrayList2 = new ArrayList();
        for (STKSDto data2 : arrayList) {
            Set<HotWord> data3 = data2.getData();
            Intrinsics.checkNotNullExpressionValue(data3, "getData(...)");
            ArrayList arrayList3 = new ArrayList();
            for (HotWord listValue : data3) {
                List<String> listValue2 = listValue.getListValue();
                Intrinsics.checkNotNullExpressionValue(listValue2, "getListValue(...)");
                ArrayList arrayList4 = new ArrayList();
                for (String str2 : listValue2) {
                    if (str2 != null) {
                        StringUtil stringUtil = StringUtil.f8447a;
                        Intrinsics.checkNotNull(str2);
                        str = stringUtil.c(str2);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        arrayList4.add(str);
                    }
                }
                CollectionsKt.addAll(arrayList3, arrayList4);
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        List distinct = CollectionsKt.distinct(arrayList2);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache("hotWords", distinct);
        }
        if (arrayList.isEmpty()) {
            NluContextDataMaintainer.f8512a.d("stks");
            return;
        }
        ContextData contextData = new ContextData("stks", "stksInfo");
        contextData.appendPayload("stks", arrayList);
        NluContextDataMaintainer.f8512a.a("stks", contextData);
    }

    public final void c() {
        b.clear();
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.remove("hotWords");
        }
        NluContextDataMaintainer.f8512a.d("stks");
    }

    public final STKSResponse d(STKSDto sTKSDto, OfflineKey offlineKey, HotWord hotWord) {
        STKSResponse sTKSResponse = new STKSResponse();
        sTKSResponse.setApkName(sTKSDto.getApkName());
        sTKSResponse.setSceneId(sTKSDto.getSceneId());
        sTKSResponse.setApkPackageName(sTKSDto.getApkPackageName());
        sTKSResponse.setFunc(offlineKey.getData().getFunc());
        sTKSResponse.setValue(Optional.ofNullable(offlineKey.getData().getNumber()).filter(new b(HotWordMaintainer$formatStksResult$1.INSTANCE)).orElse(offlineKey.getData().getSlot()));
        sTKSResponse.setAsr(offlineKey.getText());
        sTKSResponse.setId(hotWord.getId());
        sTKSResponse.setExtra(hotWord.getExtra());
        return sTKSResponse;
    }

    public final String f(String str, STKSDto sTKSDto) {
        String apkPackageName = sTKSDto.getApkPackageName();
        String sceneId = sTKSDto.getSceneId();
        return str + "#" + apkPackageName + "#" + sceneId;
    }

    public final boolean g(OfflineKey offlineKey, HotWord hotWord) {
        String func = offlineKey.getData().getFunc();
        String slot = offlineKey.getData().getSlot();
        String target = offlineKey.getData().getTarget();
        if (func == null || !Intrinsics.areEqual((Object) func, (Object) hotWord.getFunc())) {
            return false;
        }
        if (!hotWord.getListValue().isEmpty() && !hotWord.getListValue().contains(offlineKey.getText()) && !hotWord.getListValue().contains(slot) && !hotWord.getListValue().contains(target)) {
            return false;
        }
        String e = GsonUtils.e(hotWord);
        ILog.a("HotWordMaintainer", "isOfflineKeyMatched: 匹配到热词->" + e);
        return true;
    }

    public final void h() {
        HotWordControl hotWordControl = new HotWordControl();
        hotWordControl.setControl(4);
        Communicator.b(107, hotWordControl, new HotWordMaintainer$notifySyncHotWord$1$1());
    }

    public final List i(OfflineKey offlineKey) {
        Intrinsics.checkNotNullParameter(offlineKey, "offlineKey");
        ConcurrentHashMap concurrentHashMap = b;
        if (concurrentHashMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry value : concurrentHashMap.entrySet()) {
            STKSDto sTKSDto = (STKSDto) value.getValue();
            for (HotWord next : sTKSDto.getData()) {
                HotWordMaintainer hotWordMaintainer = f8564a;
                Intrinsics.checkNotNull(next);
                if (hotWordMaintainer.g(offlineKey, next)) {
                    arrayList.add(hotWordMaintainer.d(sTKSDto, offlineKey, next));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final void j(String str, STKSDto sTKSDto) {
        String f = f(str, sTKSDto);
        ConcurrentHashMap concurrentHashMap = b;
        STKSDto sTKSDto2 = (STKSDto) concurrentHashMap.get(f);
        if (sTKSDto.getData() != null && !sTKSDto.getData().isEmpty()) {
            if (sTKSDto2 == null) {
                concurrentHashMap.put(f, sTKSDto);
            } else {
                Set<HotWord> data = sTKSDto2.getData();
                Set<HotWord> data2 = sTKSDto.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                data.addAll(data2);
                sTKSDto = sTKSDto2;
            }
            String e = GsonUtils.e(sTKSDto);
            ILog.j("HotWordMaintainer", "热词->" + f + "，更新后->" + e);
        } else if (sTKSDto2 != null) {
            ILog.j("HotWordMaintainer", "热词->" + f + "，上传热词列表为空，删除本地缓存");
            concurrentHashMap.remove(f);
        } else {
            ILog.a("HotWordMaintainer", "热词->" + f + "，上传热词列表为空，本地无缓存");
        }
    }
}
