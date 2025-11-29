package com.xjsd.ai.assistant.skill.call.util;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.call.SimCardBean;
import java.util.ArrayList;
import java.util.List;

public class SimCardUtil {

    public static class SimCardInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f8681a;
        public int b;
        public int c;
        public List d;

        public SimCardInfo(int i, int i2, int i3, List list) {
            this.f8681a = i;
            this.b = i2;
            this.c = i3;
            this.d = list;
        }

        public int a() {
            return this.b;
        }

        public List b() {
            return this.d;
        }

        public int c() {
            return this.c;
        }

        public String toString() {
            return "SimCardInfo{defaultSimCardId=" + this.f8681a + ", defaultSimCardIndex=" + this.b + ", simCardCount=" + this.c + ", simCardBeanList=" + this.d + '}';
        }
    }

    public static int a(Context context) {
        List b = b(context);
        if (b == null) {
            return 0;
        }
        return b.size();
    }

    public static List b(Context context) {
        if (g(context, "android.permission.READ_PHONE_STATE")) {
            return ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
        }
        return null;
    }

    public static int c() {
        return SubscriptionManager.getDefaultVoiceSubscriptionId();
    }

    public static int d(Context context) {
        List b;
        int c = c();
        if (c == -1 || (b = b(context)) == null) {
            return -1;
        }
        for (int i = 0; i < b.size(); i++) {
            if (((SubscriptionInfo) b.get(i)).getSubscriptionId() == c) {
                return i;
            }
        }
        return -1;
    }

    public static SimCardInfo e(Context context) {
        return new SimCardInfo(c(), d(context), a(context), f(context));
    }

    public static List f(Context context) {
        ArrayList arrayList = new ArrayList();
        List b = b(context);
        if (b != null) {
            for (int i = 0; i < b.size(); i++) {
                SubscriptionInfo subscriptionInfo = (SubscriptionInfo) b.get(i);
                int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                int subscriptionId = subscriptionInfo.getSubscriptionId();
                String number = subscriptionInfo.getNumber();
                if (g(context, "android.permission.READ_PHONE_NUMBERS") && TextUtils.isEmpty(number)) {
                    try {
                        number = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getPhoneNumber(subscriptionId);
                    } catch (Throwable th) {
                        ILog.c("PhoneCall#SimCardUtil", "getSimCards: catch exception", th.getMessage());
                    }
                }
                SimCardBean simCardBean = new SimCardBean();
                simCardBean.setSlotId(simSlotIndex);
                simCardBean.setSubId(subscriptionId);
                if (simSlotIndex == 0) {
                    simCardBean.setName("卡一");
                } else if (simSlotIndex == 1) {
                    simCardBean.setName("卡二");
                }
                if (TextUtils.isEmpty(number)) {
                    simCardBean.setNumber("");
                } else {
                    simCardBean.setNumber(number);
                }
                arrayList.add(simCardBean);
            }
        }
        return arrayList;
    }

    public static boolean g(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
