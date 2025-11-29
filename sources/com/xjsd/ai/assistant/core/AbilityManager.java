package com.xjsd.ai.assistant.core;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.log.ILog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBus;

public class AbilityManager {
    public static final AbilityManager b = new AbilityManager();

    /* renamed from: a  reason: collision with root package name */
    public final Map f8452a = new ConcurrentHashMap();

    public final Object a(Class cls) {
        ILog.k("AbilityManager", "创建%s的代理类", cls.getName());
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) {
                ILog.k("AbilityManager", "执行代理类%s的方法%s", obj.getClass().getName(), method.getName());
                return null;
            }
        });
    }

    public Ability b(Class cls) {
        AbilityKey abilityKey = (AbilityKey) cls.getAnnotation(AbilityKey.class);
        if (abilityKey == null) {
            return null;
        }
        return this.f8452a.containsKey(abilityKey.value()) ? (Ability) this.f8452a.get(abilityKey.value()) : (Ability) a(cls);
    }

    public void c(Ability ability) {
        AbilityKey abilityKey;
        ILog.a("AbilityManager", "注册Ability->" + ability);
        Class[] interfaces = ability.getClass().getInterfaces();
        int length = interfaces.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                abilityKey = null;
                break;
            }
            Class cls = interfaces[i];
            if (cls.isInterface() && (abilityKey = (AbilityKey) cls.getAnnotation(AbilityKey.class)) != null) {
                break;
            }
            i++;
        }
        if (abilityKey != null) {
            String value = abilityKey.value();
            this.f8452a.put(value, ability);
            EventBus.c().k(new AbilityRegisterEvent(value));
            return;
        }
        throw new RuntimeException("Ability需要使用@AbilityKey标记其绑定Key");
    }
}
