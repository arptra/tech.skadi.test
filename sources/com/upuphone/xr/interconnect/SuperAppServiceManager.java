package com.upuphone.xr.interconnect;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.inner.OperatorManagerCreator;
import com.upuphone.xr.interconnect.outer.StarryNetOperatorManager;
import com.upuphone.xr.interconnect.outer.SuperServiceStateListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public final class SuperAppServiceManager {
    private static final String DEFAULT_REMOTE_SERVICE_PKG_GLASS = "com.upuphone.star.launcher";
    private static final String DEFAULT_REMOTE_SERVICE_PKG_PHONE = "com.upuphone.star.launcher";
    private static final String TAG = "SuperAppServiceManager";
    private final InnerSuperAppServiceManager innerManager;
    private Map<String, OperatorManager> mOutOperatorManagerMap;

    @Target({ElementType.PARAMETER})
    @Keep
    @Retention(RetentionPolicy.CLASS)
    public @interface Platform {
        public static final int APP_GLASS = 1;
        public static final int APP_PHONE = 0;
    }

    public static final class SuperAppServiceManagerHolder {
        /* access modifiers changed from: private */
        public static final SuperAppServiceManager INSTANCE = new SuperAppServiceManager();

        private SuperAppServiceManagerHolder() {
        }
    }

    public static SuperAppServiceManager getInstance() {
        return SuperAppServiceManagerHolder.INSTANCE;
    }

    public OperatorManager getInnerOperatorManager(String str) {
        return this.innerManager.getInstances().get(str);
    }

    public OperatorManager getOuterOperatorManager(String str) {
        if (this.mOutOperatorManagerMap.containsKey(str)) {
            return this.mOutOperatorManagerMap.get(str);
        }
        Log.d(TAG, "对应OperatorManager为空，请先调用init()方法");
        return null;
    }

    public OperatorManager init(@NonNull String str) {
        if (this.innerManager.getInstances().containsKey(str)) {
            return this.innerManager.getInstances().get(str);
        }
        if (this.innerManager.getOperatorManagerCreator() != null) {
            OperatorManager create = this.innerManager.getOperatorManagerCreator().create(str);
            this.innerManager.getInstances().put(str, create);
            return create;
        }
        Log.d(TAG, "初始化失败->SPI机制失效，请先使用inject(OperatorManagerCreator creator)方法");
        return null;
    }

    public void inject(OperatorManagerCreator operatorManagerCreator) {
        this.innerManager.inject(operatorManagerCreator);
    }

    private SuperAppServiceManager() {
        this.innerManager = new InnerSuperAppServiceManager();
        this.mOutOperatorManagerMap = new HashMap();
    }

    public void init(@NonNull String str, @NonNull OperatorManagerCreateCallback operatorManagerCreateCallback) {
        this.innerManager.request(str, operatorManagerCreateCallback);
    }

    public OperatorManager init(@NonNull Context context, @NonNull String str, @Nullable SuperServiceStateListener superServiceStateListener, @Platform @NonNull int i) {
        return init(context, str, superServiceStateListener, "com.upuphone.star.launcher");
    }

    public OperatorManager init(@NonNull Context context, @Nullable SuperServiceStateListener superServiceStateListener, @Platform @NonNull int i) {
        return init(context, context.getPackageName(), superServiceStateListener, i);
    }

    public OperatorManager init(@NonNull Context context, @NonNull String str, @Nullable SuperServiceStateListener superServiceStateListener, @NonNull String str2) {
        if (this.mOutOperatorManagerMap.containsKey(str)) {
            return this.mOutOperatorManagerMap.get(str);
        }
        Log.i(TAG, "init OperatorManager");
        StarryNetOperatorManager starryNetOperatorManager = new StarryNetOperatorManager(context, str, superServiceStateListener, str2);
        this.mOutOperatorManagerMap.put(str, starryNetOperatorManager);
        return starryNetOperatorManager;
    }
}
