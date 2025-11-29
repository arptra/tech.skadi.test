package com.upuphone.starrynetsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.honey.account.l7.a;
import com.upuphone.runasone.host.api.BaseAbility;
import com.upuphone.runasone.host.api.BaseComponent;
import com.upuphone.runasone.host.api.CoreInitApplication;
import com.upuphone.runasone.host.api.InitApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class Dispatcher {
    private final Map<String, BaseComponent> allComponents = new HashMap();
    private final Map<String, BaseComponent> businessComponents = new HashMap();
    private CoreInitApplication coreApplication;
    private final Handler handler = new Handler();
    private final ExecutorService initExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
        private static final String THREAD_NAME_STEM = "thread_init";

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(THREAD_NAME_STEM);
            return thread;
        }
    });
    private int unInitComponentCount;

    public interface InitListener {
        void onCompleted();
    }

    private void initCompleted(InitListener initListener) {
        if (this.coreApplication == null) {
            SLog.e("dispatch init failed,not contain core component.");
        } else if (this.allComponents.isEmpty()) {
            SLog.e("dispatch init failed,not contain component.");
        } else {
            this.coreApplication.initComponents(this.businessComponents);
            SLog.d("dispatch init competed.");
            initListener.onCompleted();
        }
    }

    private void initComponent(Context context, InitApplication initApplication, InitListener initListener) {
        initApplication.initHighPriority(context, new b(this, initApplication, context, initListener));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$1(InitApplication initApplication, BaseComponent baseComponent, Context context, InitListener initListener) {
        if (initApplication instanceof CoreInitApplication) {
            this.coreApplication = (CoreInitApplication) initApplication;
        } else {
            this.businessComponents.put(baseComponent.getName(), baseComponent);
        }
        this.allComponents.put(baseComponent.getName(), baseComponent);
        this.initExecutor.execute(new a(initApplication, context));
        SLog.d(String.format("load %s component success,contains abilities: %s", new Object[]{baseComponent.getName(), baseComponent.getAbilityNames()}));
        int i = this.unInitComponentCount - 1;
        this.unInitComponentCount = i;
        if (i == 0) {
            initCompleted(initListener);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$2(InitApplication initApplication, Context context, InitListener initListener, BaseComponent baseComponent) {
        if (baseComponent == null) {
            SLog.e("load component failed,component is null.");
        } else if (baseComponent.getName() == null || baseComponent.getName().isEmpty()) {
            SLog.e("load component failed,component name is null.");
        } else if (baseComponent.getAbilities() == null || baseComponent.getAbilities().isEmpty()) {
            SLog.e("load component failed,component abilities is null.");
        } else {
            this.handler.post(new a(this, initApplication, baseComponent, context, initListener));
        }
    }

    private void loadComponent(Context context, ServiceLoader<InitApplication> serviceLoader, InitListener initListener) {
        SLog.d("start loadComponent.");
        ArrayList<InitApplication> arrayList = new ArrayList<>();
        Iterator<InitApplication> it = serviceLoader.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        int size = arrayList.size();
        this.unInitComponentCount = size;
        SLog.d("component count: " + size);
        for (InitApplication initComponent : arrayList) {
            initComponent(context, initComponent, initListener);
        }
    }

    public void init(Context context, InitListener initListener) {
        SLog.d("start init dispatcher.");
        Thread.currentThread().setContextClassLoader(Dispatcher.class.getClassLoader());
        loadComponent(context, ServiceLoader.load(InitApplication.class), initListener);
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("component");
        String string2 = bundle.getString("ability");
        String string3 = bundle.getString("method");
        if (string2 == null) {
            SLog.e("transfer failed,ability is null.");
            return;
        }
        SLog.d(String.format("transfer %s to %s in %s.", new Object[]{string3, string2, string}));
        BaseComponent baseComponent = this.allComponents.get(string);
        if (baseComponent == null) {
            SLog.e(String.format("transfer failed,component %s not registered.", new Object[]{string}));
            return;
        }
        for (BaseAbility baseAbility : baseComponent.getAbilities()) {
            if (string2.equals(baseAbility.getName()) && baseAbility.getIAbility() != null) {
                baseAbility.getIAbility().transfer(bundle, bundle2);
                return;
            }
        }
    }
}
