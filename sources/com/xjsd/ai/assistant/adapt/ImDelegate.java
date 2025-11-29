package com.xjsd.ai.assistant.adapt;

import android.app.Application;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import com.xjsd.ai.assistant.protocol.wechat.WechatData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/adapt/ImDelegate;", "", "Landroid/app/Application;", "application", "", "d", "(Landroid/app/Application;)V", "Landroid/content/Context;", "context", "b", "(Landroid/content/Context;)V", "Landroid/service/notification/StatusBarNotification;", "sbn", "f", "(Landroid/service/notification/StatusBarNotification;)V", "", "reason", "c", "(Landroid/service/notification/StatusBarNotification;I)V", "", "connect", "e", "(Z)V", "Lcom/xjsd/ai/assistant/protocol/wechat/WechatData;", "data", "a", "(Lcom/xjsd/ai/assistant/protocol/wechat/WechatData;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface ImDelegate {
    void a(WechatData wechatData);

    void b(Context context);

    void c(StatusBarNotification statusBarNotification, int i);

    void d(Application application);

    void e(boolean z);

    void f(StatusBarNotification statusBarNotification);
}
