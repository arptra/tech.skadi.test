package com.upuphone.starrynetsdk.ability.audio;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/audio/PhoneAbility;", "Lcom/upuphone/starrynetsdk/ability/audio/BaseAudioAbility;", "()V", "dail", "", "action", "phoneNum", "", "registerPhoneListener", "listener", "Lcom/upuphone/starrynetsdk/ability/audio/PhoneListener;", "syncAddressBook", "unregisterPhoneListener", "Companion", "core-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PhoneAbility extends BaseAudioAbility {
    public static final int ACTION_ACCEPT = 0;
    public static final int ACTION_DAIL = 4;
    public static final int ACTION_HOLD = 2;
    public static final int ACTION_REJECT = 1;
    public static final int ACTION_TERMINAL = 3;
    public static final int ADDRESS_BOOK_SYNC_STATE_DONE = 1;
    public static final int ADDRESS_BOOK_SYNC_STATE_FAIL = 2;
    public static final int ADDRESS_BOOK_SYNC_STATE_START = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PHONE_STATE_ACTIVE = 0;
    public static final int PHONE_STATE_ALERTING = 3;
    public static final int PHONE_STATE_DIALING = 2;
    public static final int PHONE_STATE_HELD = 1;
    public static final int PHONE_STATE_HELD_BY_RESPONSE_AND_HOLD = 6;
    public static final int PHONE_STATE_INACTIVE = 8;
    public static final int PHONE_STATE_INCOMING = 4;
    public static final int PHONE_STATE_TERMINATED = 7;
    public static final int PHONE_STATE_WAITING = 5;
    @NotNull
    private static final String TAG = "PhoneAbility";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/audio/PhoneAbility$Companion;", "", "()V", "ACTION_ACCEPT", "", "ACTION_DAIL", "ACTION_HOLD", "ACTION_REJECT", "ACTION_TERMINAL", "ADDRESS_BOOK_SYNC_STATE_DONE", "ADDRESS_BOOK_SYNC_STATE_FAIL", "ADDRESS_BOOK_SYNC_STATE_START", "PHONE_STATE_ACTIVE", "PHONE_STATE_ALERTING", "PHONE_STATE_DIALING", "PHONE_STATE_HELD", "PHONE_STATE_HELD_BY_RESPONSE_AND_HOLD", "PHONE_STATE_INACTIVE", "PHONE_STATE_INCOMING", "PHONE_STATE_TERMINATED", "PHONE_STATE_WAITING", "TAG", "", "core-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ int dail$default(PhoneAbility phoneAbility, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return phoneAbility.dail(i, str);
    }

    @JvmOverloads
    public final int dail(int i) {
        return dail$default(this, i, (String) null, 2, (Object) null);
    }

    public final int registerPhoneListener(@NotNull PhoneListener phoneListener) {
        Intrinsics.checkNotNullParameter(phoneListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SNSLog.d(TAG, "registerPhoneListener");
        getListenerManager().registerPhoneListener(phoneListener);
        return 0;
    }

    public final int syncAddressBook() {
        SNSLog.d(TAG, "syncAddressBook");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,syncAddressBook failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            getApi().operateAction(1, 0);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "syncAddressBook failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "syncAddressBook failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public final int unregisterPhoneListener(@NotNull PhoneListener phoneListener) {
        Intrinsics.checkNotNullParameter(phoneListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SNSLog.d(TAG, "unregisterPhoneListener");
        getListenerManager().unregisterPhoneListener(phoneListener);
        return 0;
    }

    @JvmOverloads
    public final int dail(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phoneNum");
        SNSLog.d(TAG, "dail: " + i);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,dail failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        if (i == 4) {
            try {
                getApi().dial(str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "dail failed.", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "dail failed.", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        } else {
            getApi().operateAction(0, i);
        }
        return 0;
    }
}
