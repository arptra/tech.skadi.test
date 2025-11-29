package com.upuphone.runasone.message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.utils.LogUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChannelMessageCache extends LinkedHashMap<Long, ChannelMessage> {
    private static String TAG = "ChannelMessageCache";
    private volatile int mCurSize = 0;
    private final long mExpiredTime;
    private final int mMaxCount;
    private final int mMaxSize;
    private final String mName;

    public ChannelMessageCache(String str, int i, int i2, long j) {
        this.mName = "[" + str + "]";
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mExpiredTime = j;
    }

    private int getMessageSize(ChannelMessage channelMessage) {
        byte[] bypass = (channelMessage == null || channelMessage.getAbilityMessage() == null) ? null : channelMessage.getAbilityMessage().getBypass();
        return (bypass != null ? bypass.length : 0) + 8;
    }

    private void minusSize(ChannelMessage channelMessage) {
        this.mCurSize -= getMessageSize(channelMessage);
        if (this.mCurSize < 0) {
            this.mCurSize = 0;
        }
    }

    public synchronized void clear() {
        String str = TAG;
        LogUtil.e(str, (Object) this.mName + "复位，清除所有缓存");
        this.mCurSize = 0;
        super.clear();
    }

    public synchronized void clearExpiredMessage() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = entrySet().iterator();
            ChannelMessage channelMessage = null;
            ChannelMessage channelMessage2 = null;
            while (it.hasNext()) {
                ChannelMessage channelMessage3 = (ChannelMessage) ((Map.Entry) it.next()).getValue();
                if (channelMessage3 != null && currentTimeMillis - channelMessage3.getCommitTime() > this.mExpiredTime) {
                    if (channelMessage == null) {
                        channelMessage = channelMessage3;
                    }
                    minusSize(channelMessage3);
                    it.remove();
                    channelMessage2 = channelMessage3;
                }
            }
            if (!(channelMessage == null || channelMessage2 == null)) {
                LogUtil.e(TAG, (Object) this.mName + "当前缓存数量" + size());
                LogUtil.e(TAG, (Object) this.mName + "清除过期缓存 reqId in [" + channelMessage.getRequestId() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + channelMessage2.getRequestId() + "]");
            }
        } finally {
        }
    }

    public void putAll(@NonNull Map map) {
        LogUtil.e(TAG, (Object) "not allow call putAll");
    }

    public boolean removeEldestEntry(Map.Entry<Long, ChannelMessage> entry) {
        boolean z = size() > this.mMaxCount && this.mCurSize > this.mMaxSize;
        ChannelMessage value = entry != null ? entry.getValue() : null;
        if (value == null) {
            return true;
        }
        if (z) {
            minusSize(value);
            LogUtil.e(TAG, (Object) String.format("removeEldestEntry->reqId= %s 当前总数量count = %s 当前内存总占用size = %s", new Object[]{(entry == null || entry.getValue() == null) ? "null" : Long.valueOf(entry.getValue().getRequestId()), Integer.valueOf(size()), Integer.valueOf(this.mCurSize)}));
        }
        return z;
    }

    @Nullable
    public synchronized ChannelMessage put(Long l, ChannelMessage channelMessage) {
        ChannelMessage channelMessage2;
        try {
            channelMessage.setCommitTime(System.currentTimeMillis());
            ChannelMessage channelMessage3 = (ChannelMessage) get(l);
            if (channelMessage3 != null) {
                minusSize(channelMessage3);
            }
            int messageSize = getMessageSize(channelMessage);
            this.mCurSize += messageSize;
            channelMessage2 = (ChannelMessage) super.put(l, channelMessage);
            LogUtil.e(TAG, (Object) String.format("%s添加到缓存队列 reqId=%s dataLen=%s 当前内存占用=%s 当前数量=%s", new Object[]{this.mName, l, Integer.valueOf(messageSize), Integer.valueOf(this.mCurSize), Integer.valueOf(size())}));
        } catch (Throwable th) {
            throw th;
        }
        return channelMessage2;
    }

    @Nullable
    public ChannelMessage putIfAbsent(Long l, ChannelMessage channelMessage) {
        LogUtil.e(TAG, (Object) "not allow call putIfAbsent");
        return null;
    }
}
