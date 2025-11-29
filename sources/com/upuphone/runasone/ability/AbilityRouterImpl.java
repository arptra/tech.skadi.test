package com.upuphone.runasone.ability;

import android.os.Bundle;
import androidx.core.util.Consumer;
import com.google.gson.Gson;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.virtual.ChannelType;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AbilityRouterImpl implements IAbilityRouter {
    /* access modifiers changed from: private */
    public static final String TAG = "AbilityRouterImpl";
    private static CopyOnWriteArrayList<String> abilityList = new CopyOnWriteArrayList<>();
    private static ConcurrentHashMap<EnumLinkStrategy, ConcurrentHashMap<String, ActorAgent>> abilityMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ActorAgent> balanceStrategyMap = new ConcurrentHashMap<>();
    private static Map<String, String> componentMap = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, ActorAgent> defaultStrategyMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ActorAgent> highStrategyMap = new ConcurrentHashMap<>();
    private static AbilityRouterImpl instance;
    private static ConcurrentHashMap<String, ActorAgent> simplifiedStrategyMap = new ConcurrentHashMap<>();

    /* renamed from: com.upuphone.runasone.ability.AbilityRouterImpl$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$host$core$api$AbilityMessage$Qos;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.upuphone.runasone.host.core.api.AbilityMessage$Qos[] r0 = com.upuphone.runasone.host.core.api.AbilityMessage.Qos.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$host$core$api$AbilityMessage$Qos = r0
                com.upuphone.runasone.host.core.api.AbilityMessage$Qos r1 = com.upuphone.runasone.host.core.api.AbilityMessage.Qos.AM_QOS_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$host$core$api$AbilityMessage$Qos     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.host.core.api.AbilityMessage$Qos r1 = com.upuphone.runasone.host.core.api.AbilityMessage.Qos.AM_QOS_2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$upuphone$runasone$host$core$api$AbilityMessage$Qos     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.runasone.host.core.api.AbilityMessage$Qos r1 = com.upuphone.runasone.host.core.api.AbilityMessage.Qos.AM_QOS_3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.ability.AbilityRouterImpl.AnonymousClass3.<clinit>():void");
        }
    }

    private AbilityRouterImpl() {
    }

    private void attachActorAgent(EnumAbility enumAbility, ActorAgent actorAgent, ConcurrentHashMap<String, ActorAgent> concurrentHashMap) {
        if (!concurrentHashMap.containsKey(enumAbility.getName())) {
            String str = TAG;
            LogUtil.d(str, (Object) "attachAbility ability: " + enumAbility.getName());
            concurrentHashMap.put(enumAbility.getName(), actorAgent);
            return;
        }
        String str2 = TAG;
        LogUtil.e(str2, (Object) "attachAbility fail, ability:" + enumAbility.getName() + " is already attach");
    }

    /* access modifiers changed from: private */
    public QosLevel convertQos(AbilityMessage.Qos qos) {
        int i = AnonymousClass3.$SwitchMap$com$upuphone$runasone$host$core$api$AbilityMessage$Qos[qos.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? QosLevel.QOS_0 : QosLevel.QOS_3 : QosLevel.QOS_2 : QosLevel.QOS_1;
    }

    private static synchronized AbilityRouterImpl createInstance() {
        AbilityRouterImpl abilityRouterImpl;
        synchronized (AbilityRouterImpl.class) {
            try {
                if (instance == null) {
                    instance = new AbilityRouterImpl();
                    abilityMap.put(EnumLinkStrategy.STRATEGY_DEFAULT, defaultStrategyMap);
                    abilityMap.put(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE, highStrategyMap);
                    abilityMap.put(EnumLinkStrategy.STRATEGY_SIMPLIFIED, simplifiedStrategyMap);
                    abilityMap.put(EnumLinkStrategy.STRATEGY_BALANCE, balanceStrategyMap);
                }
                abilityRouterImpl = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abilityRouterImpl;
    }

    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, ActorAgent> getAbilitySlotMap(EnumLinkStrategy enumLinkStrategy) {
        return abilityMap.get(enumLinkStrategy);
    }

    public static AbilityRouterImpl getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    public synchronized void attachAbility(EnumAbility enumAbility, IAbilitySlot iAbilitySlot, EnumLinkStrategy enumLinkStrategy, ComponentProperty componentProperty) {
        try {
            ActorAgent actorAgent = new ActorAgent();
            if (componentProperty != null) {
                String json = new Gson().toJson((Object) componentProperty);
                String str = TAG;
                LogUtil.dPrimary(str, enumAbility.getName() + " ---prop--- " + json);
                componentMap.put(enumAbility.getName(), json);
            }
            actorAgent.installInputPort(enumAbility, iAbilitySlot, enumLinkStrategy);
            EnumLinkStrategy enumLinkStrategy2 = EnumLinkStrategy.STRATEGY_DEFAULT;
            if (enumLinkStrategy2 == enumLinkStrategy) {
                for (Map.Entry<EnumLinkStrategy, ConcurrentHashMap<String, ActorAgent>> key : abilityMap.entrySet()) {
                    EnumLinkStrategy enumLinkStrategy3 = (EnumLinkStrategy) key.getKey();
                    LogUtil.d("attachAbility STRATEGY_DEFAULT key:" + enumLinkStrategy3);
                    attachActorAgent(enumAbility, actorAgent, abilityMap.get(enumLinkStrategy3));
                }
            } else {
                EnumLinkStrategy enumLinkStrategy4 = EnumLinkStrategy.STRATEGY_BALANCE;
                if (enumLinkStrategy4 == enumLinkStrategy) {
                    attachActorAgent(enumAbility, actorAgent, abilityMap.get(enumLinkStrategy2));
                    attachActorAgent(enumAbility, actorAgent, abilityMap.get(enumLinkStrategy4));
                } else {
                    LogUtil.d("attachAbility strategy:" + enumLinkStrategy);
                    attachActorAgent(enumAbility, actorAgent, abilityMap.get(enumLinkStrategy));
                }
            }
            if (!abilityList.contains(enumAbility.getName())) {
                abilityList.add(enumAbility.getName());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean bindChannel(final IChannel iChannel, EnumLinkStrategy enumLinkStrategy) {
        try {
            ConcurrentHashMap<String, ActorAgent> abilitySlotMap = getAbilitySlotMap(enumLinkStrategy);
            iChannel.setIoObserver(new IChannel.BiObserver() {
                public void input(ChannelMessage channelMessage) {
                    String id = channelMessage.getId();
                    String category = channelMessage.getCategory();
                    EnumLinkStrategy linkStrategy = channelMessage.getLinkStrategy();
                    String access$000 = AbilityRouterImpl.TAG;
                    LogUtil.dPrimary(access$000, "---> input <" + id + "> category <" + category + "> linkStrategy <" + linkStrategy + "> getRequestId <" + channelMessage.getRequestId() + ">");
                    ActorAgent actorAgent = (ActorAgent) AbilityRouterImpl.this.getAbilitySlotMap(linkStrategy).get(category);
                    if (actorAgent != null) {
                        actorAgent.injection(channelMessage);
                        return;
                    }
                    LogUtil.e("category <" + category + "> msg un-match, actorAgentMap is null");
                }
            });
            for (Map.Entry next : abilitySlotMap.entrySet()) {
                final String str = (String) next.getKey();
                if (EnumLinkStrategy.STRATEGY_SIMPLIFIED == enumLinkStrategy || iChannel.getChannelType() == ChannelType.VIRTUAL) {
                    LogUtil.d("STRATEGY_SIMPLIFIED ability <" + str + "> is match");
                } else {
                    boolean contains = iChannel.getRemoteAbilityList().contains(str);
                    String str2 = TAG;
                    LogUtil.d(str2, (Object) "bindChannel attach ---> " + str + " match:" + contains);
                    if (!contains) {
                        LogUtil.e("ability <" + str + "> is not match, no need bind");
                    }
                }
                abilitySlotMap.get(next.getKey()).bindChannel(iChannel, new IAbilitySlot.SlotObserver() {
                    public int commonFun(int i, Bundle bundle, Consumer<Object> consumer) {
                        LogUtil.d("commonFun ,operateType =" + i);
                        return 0;
                    }

                    public void onError(StarryDevice starryDevice, int i) {
                        String access$000 = AbilityRouterImpl.TAG;
                        LogUtil.e(access$000, (Object) "onError " + starryDevice.getId() + " errorCode:" + i);
                    }

                    public int output(StarryDevice starryDevice, AbilityMessage abilityMessage) {
                        ChannelType channelType = iChannel.getChannelType();
                        QosLevel access$200 = abilityMessage.getQos() != null ? AbilityRouterImpl.this.convertQos(abilityMessage.getQos()) : QosLevel.QOS_0;
                        String access$000 = AbilityRouterImpl.TAG;
                        LogUtil.dPrimary(access$000, "<--- output <" + starryDevice.getName() + LunarCalendar.DATE_SEPARATOR + starryDevice.getId() + "> category <" + str + "> selfId <" + starryDevice.getSelfId() + "> qosLevel <" + access$200 + "> channelType <" + channelType + ">");
                        return iChannel.output(ChannelMessage.newBuilder().setId(starryDevice.getSelfId()).setCategory(str).setQos(access$200).setDstId(starryDevice.getId()).setSrcId(starryDevice.getSelfId()).setMessageType(StreamType.BYPASS).setAbilityMessage(abilityMessage).build());
                    }
                });
            }
        } finally {
        }
        return true;
    }

    public synchronized void detachAbility(EnumAbility enumAbility) {
        try {
            for (Map.Entry<EnumLinkStrategy, ConcurrentHashMap<String, ActorAgent>> key : abilityMap.entrySet()) {
                ConcurrentHashMap concurrentHashMap = abilityMap.get(key.getKey());
                if (concurrentHashMap.containsKey(enumAbility.getName())) {
                    String str = TAG;
                    LogUtil.d(str, (Object) "detachAbility ability: " + enumAbility.getName());
                    ((ActorAgent) concurrentHashMap.get(enumAbility.getName())).uninstallInputPort();
                    concurrentHashMap.remove(enumAbility.getName());
                } else {
                    String str2 = TAG;
                    LogUtil.e(str2, (Object) "detachAbility fail, ability:" + enumAbility.getName() + " is un-valid");
                }
            }
        } finally {
        }
    }

    public Map<String, String> getLocalAbilityAttr() {
        return componentMap;
    }

    public synchronized void unbindChannel(IChannel iChannel, EnumLinkStrategy enumLinkStrategy) {
        try {
            ConcurrentHashMap<String, ActorAgent> abilitySlotMap = getAbilitySlotMap(enumLinkStrategy);
            for (Map.Entry next : abilitySlotMap.entrySet()) {
                ActorAgent actorAgent = abilitySlotMap.get(next.getKey());
                if (iChannel.isLinkUp() && EnumLinkStrategy.STRATEGY_DEFAULT == actorAgent.getStrategy()) {
                    String str = TAG;
                    LogUtil.d(str, (Object) "ability <" + ((String) next.getKey()) + " > strategy is default and channel still link up, so no need unbind ... ");
                } else if (actorAgent.isBind(iChannel)) {
                    String str2 = TAG;
                    LogUtil.d(str2, (Object) "detach ability ---> <" + ((String) next.getKey()) + "> strategy:" + enumLinkStrategy);
                    actorAgent.unbindChannel(iChannel);
                } else {
                    String str3 = TAG;
                    LogUtil.d(str3, (Object) "ability <" + ((String) next.getKey()) + " strategy:" + enumLinkStrategy + " > is already unbind");
                }
            }
            if (!iChannel.isLinkUp()) {
                iChannel.setIoObserver((IChannel.BiObserver) null);
            }
        } finally {
        }
    }

    public void updateAbility(EnumAbility enumAbility, ComponentProperty componentProperty) {
        if (componentProperty != null) {
            String json = new Gson().toJson((Object) componentProperty);
            String str = TAG;
            LogUtil.dPrimary(str, enumAbility.getName() + " ---prop--- " + json);
            componentMap.put(enumAbility.getName(), json);
        }
    }

    public CopyOnWriteArrayList<String> getLocalAbilityList() {
        return abilityList;
    }
}
