package com.xjsd.ai.assistant.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import java.util.HashMap;
import java.util.Map;

class CacheAbilityImpl implements CacheAbility {
    private static final String TAG = "CacheAbilityImpl";
    private Map<String, Object> dataContainer = new HashMap();
    private Context mContext;

    public CacheAbilityImpl(Context context) {
        this.mContext = context;
    }

    public <V> void cache(String str, V v) {
        ILog.a(TAG, "缓存数据key->" + str + "，data->" + v);
        this.dataContainer.put(str, v);
    }

    public Object getCache(String str) {
        Object obj = this.dataContainer.get(str);
        ILog.a(TAG, "查询缓存key->" + str + "，data->" + obj);
        return obj;
    }

    public <V> V getCacheWithDefault(String str, @NonNull V v) {
        if (v != null) {
            V v2 = this.dataContainer.get(str);
            if (v2 == null) {
                ILog.a(TAG, "查询缓存key->" + str + "，data为空，返回默认值->" + v);
                return v;
            } else if (v.getClass() == v2.getClass()) {
                ILog.a(TAG, "查询缓存key->" + str + "，类型->" + v2.getClass().getName() + "，data->" + v2);
                return v2;
            } else {
                ILog.a(TAG, "查询缓存key->" + str + "，数据类型不匹配，返回默认值->" + v);
                return v;
            }
        } else {
            throw new RuntimeException("getCacheWithDefault参数defaultValue不能为null");
        }
    }

    public String getPersistValue(String str) {
        String str2 = (String) getCacheWithDefault(str, "");
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mContext.getSharedPreferences("assistant", 0).getString(str, "");
            if (!TextUtils.isEmpty(str2)) {
                cache(str, str2);
            }
        }
        ILog.a(TAG, "获取持久数据存储key->" + str + "，data->" + str2);
        return str2;
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public void persist(String str, String str2) {
        ILog.a(TAG, "持久化存储key->" + str + "，data->" + str2);
        this.mContext.getSharedPreferences("assistant", 0).edit().putString(str, str2).commit();
        cache(str, str2);
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void remove(String str) {
        Object remove = this.dataContainer.remove(str);
        ILog.a(TAG, "移除缓存key->" + str + "，data->" + remove);
    }

    public <V> V getCache(String str, Class<V> cls) {
        try {
            V v = this.dataContainer.get(str);
            ILog.a(TAG, "查询缓存key->" + str + "，data->" + v);
            if (v != null && v.getClass() == cls) {
                return v;
            }
            return null;
        } catch (Exception e) {
            ILog.a(TAG, "cache数据转换失败：" + e.getMessage());
        }
    }
}
