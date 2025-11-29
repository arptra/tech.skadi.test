package com.dexterous.flutterlocalnotifications;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.AlarmManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media.app.NotificationCompat;
import com.dexterous.flutterlocalnotifications.isolate.IsolatePreferences;
import com.dexterous.flutterlocalnotifications.models.BitmapSource;
import com.dexterous.flutterlocalnotifications.models.DateTimeComponents;
import com.dexterous.flutterlocalnotifications.models.IconSource;
import com.dexterous.flutterlocalnotifications.models.MessageDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationAction;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelGroupDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationStyle;
import com.dexterous.flutterlocalnotifications.models.PersonDetails;
import com.dexterous.flutterlocalnotifications.models.ScheduleMode;
import com.dexterous.flutterlocalnotifications.models.ScheduledNotificationRepeatFrequency;
import com.dexterous.flutterlocalnotifications.models.SoundSource;
import com.dexterous.flutterlocalnotifications.models.styles.BigPictureStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.BigTextStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.DefaultStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.InboxStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.MessagingStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.StyleInformation;
import com.dexterous.flutterlocalnotifications.utils.BooleanUtils;
import com.dexterous.flutterlocalnotifications.utils.LongUtils;
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.here.posclient.PositionEstimate;
import com.meizu.common.widget.CircleProgressBar;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.runasone.uupcast.CaptureType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

@Keep
public class FlutterLocalNotificationsPlugin implements MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, FlutterPlugin, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ACTION_ID = "actionId";
    private static final String ARE_NOTIFICATIONS_ENABLED_METHOD = "areNotificationsEnabled";
    private static final String CALLBACK_HANDLE = "callback_handle";
    private static final String CANCEL_ALL_METHOD = "cancelAll";
    private static final String CANCEL_ID = "id";
    private static final String CANCEL_METHOD = "cancel";
    static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CANCEL_TAG = "tag";
    private static final String CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD = "canScheduleExactNotifications";
    private static final String CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD = "createNotificationChannelGroup";
    private static final String CREATE_NOTIFICATION_CHANNEL_METHOD = "createNotificationChannel";
    private static final String DEFAULT_ICON = "defaultIcon";
    private static final String DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD = "deleteNotificationChannelGroup";
    private static final String DELETE_NOTIFICATION_CHANNEL_METHOD = "deleteNotificationChannel";
    private static final String DISPATCHER_HANDLE = "dispatcher_handle";
    private static final String DRAWABLE = "drawable";
    private static final String EXACT_ALARMS_PERMISSION_ERROR_CODE = "exact_alarms_not_permitted";
    static final int EXACT_ALARM_PERMISSION_REQUEST_CODE = 2;
    static final int FULL_SCREEN_INTENT_PERMISSION_REQUEST_CODE = 3;
    private static final String GET_ACTIVE_NOTIFICATIONS_ERROR_MESSAGE = "Android version must be 6.0 or newer to use getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATIONS_METHOD = "getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE = "getActiveNotificationMessagingStyleError";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD = "getActiveNotificationMessagingStyle";
    private static final String GET_CALLBACK_HANDLE_METHOD = "getCallbackHandle";
    private static final String GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD = "getNotificationAppLaunchDetails";
    private static final String GET_NOTIFICATION_CHANNELS_ERROR_CODE = "getNotificationChannelsError";
    private static final String GET_NOTIFICATION_CHANNELS_METHOD = "getNotificationChannels";
    private static final String INITIALIZE_METHOD = "initialize";
    private static final String INPUT = "input";
    private static final String INPUT_RESULT = "FlutterLocalNotificationsPluginInputResult";
    private static final String INVALID_BIG_PICTURE_ERROR_CODE = "invalid_big_picture";
    private static final String INVALID_DRAWABLE_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a drawable resource to your Android head project.";
    private static final String INVALID_ICON_ERROR_CODE = "invalid_icon";
    private static final String INVALID_LARGE_ICON_ERROR_CODE = "invalid_large_icon";
    private static final String INVALID_LED_DETAILS_ERROR_CODE = "invalid_led_details";
    private static final String INVALID_LED_DETAILS_ERROR_MESSAGE = "Must specify both ledOnMs and ledOffMs to configure the blink cycle on older versions of Android before Oreo";
    private static final String INVALID_RAW_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a raw resource to your Android head project.";
    private static final String INVALID_SOUND_ERROR_CODE = "invalid_sound";
    private static final String METHOD_CHANNEL = "dexterous.com/flutter/local_notifications";
    static String NOTIFICATION_DETAILS = "notificationDetails";
    static final String NOTIFICATION_ID = "notificationId";
    private static final String NOTIFICATION_LAUNCHED_APP = "notificationLaunchedApp";
    static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 1;
    private static final String NOTIFICATION_RESPONSE_TYPE = "notificationResponseType";
    static final String NOTIFICATION_TAG = "notificationTag";
    static final String PAYLOAD = "payload";
    private static final String PENDING_NOTIFICATION_REQUESTS_METHOD = "pendingNotificationRequests";
    private static final String PERIODICALLY_SHOW_METHOD = "periodicallyShow";
    private static final String PERIODICALLY_SHOW_WITH_DURATION = "periodicallyShowWithDuration";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE = "permissionRequestInProgress";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE = "Another permission request is already in progress";
    private static final String REQUEST_EXACT_ALARMS_PERMISSION_METHOD = "requestExactAlarmsPermission";
    private static final String REQUEST_FULL_SCREEN_INTENT_PERMISSION_METHOD = "requestFullScreenIntentPermission";
    private static final String REQUEST_NOTIFICATIONS_PERMISSION_METHOD = "requestNotificationsPermission";
    private static final String SCHEDULED_NOTIFICATIONS = "scheduled_notifications";
    private static final String SELECT_FOREGROUND_NOTIFICATION_ACTION = "SELECT_FOREGROUND_NOTIFICATION";
    private static final String SELECT_NOTIFICATION = "SELECT_NOTIFICATION";
    private static final String SHARED_PREFERENCES_KEY = "notification_plugin_cache";
    private static final String SHOW_METHOD = "show";
    private static final String START_FOREGROUND_SERVICE = "startForegroundService";
    private static final String STOP_FOREGROUND_SERVICE = "stopForegroundService";
    private static final String TAG = "FLTLocalNotifPlugin";
    private static final String UNSUPPORTED_OS_VERSION_ERROR_CODE = "unsupported_os_version";
    private static final String ZONED_SCHEDULE_METHOD = "zonedSchedule";
    static Gson gson;
    private Context applicationContext;
    private PermissionRequestListener callback;
    private MethodChannel channel;
    private Activity mainActivity;
    private PermissionRequestProgress permissionRequestProgress = PermissionRequestProgress.None;

    /* renamed from: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2812a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009c */
        static {
            /*
                com.dexterous.flutterlocalnotifications.models.NotificationStyle[] r0 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                com.dexterous.flutterlocalnotifications.models.NotificationStyle r2 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.BigPicture     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.dexterous.flutterlocalnotifications.models.NotificationStyle r3 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.BigText     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.dexterous.flutterlocalnotifications.models.NotificationStyle r4 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.Inbox     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.dexterous.flutterlocalnotifications.models.NotificationStyle r5 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.Messaging     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.dexterous.flutterlocalnotifications.models.NotificationStyle r6 = com.dexterous.flutterlocalnotifications.models.NotificationStyle.Media     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.dexterous.flutterlocalnotifications.models.IconSource[] r5 = com.dexterous.flutterlocalnotifications.models.IconSource.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                b = r5
                com.dexterous.flutterlocalnotifications.models.IconSource r6 = com.dexterous.flutterlocalnotifications.models.IconSource.DrawableResource     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.dexterous.flutterlocalnotifications.models.IconSource r6 = com.dexterous.flutterlocalnotifications.models.IconSource.BitmapFilePath     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.dexterous.flutterlocalnotifications.models.IconSource r6 = com.dexterous.flutterlocalnotifications.models.IconSource.ContentUri     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x006d }
                com.dexterous.flutterlocalnotifications.models.IconSource r6 = com.dexterous.flutterlocalnotifications.models.IconSource.FlutterBitmapAsset     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x0077 }
                com.dexterous.flutterlocalnotifications.models.IconSource r6 = com.dexterous.flutterlocalnotifications.models.IconSource.ByteArray     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                com.dexterous.flutterlocalnotifications.models.RepeatInterval[] r4 = com.dexterous.flutterlocalnotifications.models.RepeatInterval.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2812a = r4
                com.dexterous.flutterlocalnotifications.models.RepeatInterval r5 = com.dexterous.flutterlocalnotifications.models.RepeatInterval.EveryMinute     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r1 = f2812a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.dexterous.flutterlocalnotifications.models.RepeatInterval r4 = com.dexterous.flutterlocalnotifications.models.RepeatInterval.Hourly     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f2812a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.dexterous.flutterlocalnotifications.models.RepeatInterval r1 = com.dexterous.flutterlocalnotifications.models.RepeatInterval.Daily     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f2812a     // Catch:{ NoSuchFieldError -> 0x00a6 }
                com.dexterous.flutterlocalnotifications.models.RepeatInterval r1 = com.dexterous.flutterlocalnotifications.models.RepeatInterval.Weekly     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.AnonymousClass5.<clinit>():void");
        }
    }

    public static class ExactAlarmPermissionException extends PluginException {
        public ExactAlarmPermissionException() {
            super(FlutterLocalNotificationsPlugin.EXACT_ALARMS_PERMISSION_ERROR_CODE, "Exact alarms are not permitted");
        }
    }

    public enum PermissionRequestProgress {
        None,
        RequestingNotificationPermission,
        RequestingExactAlarmsPermission,
        RequestingFullScreenIntentPermission
    }

    public static class PluginException extends RuntimeException {
        public final String code;

        public PluginException(String str, String str2) {
            super(str2);
            this.code = str;
        }
    }

    private static void applyGrouping(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.groupKey).booleanValue()) {
            builder.t(notificationDetails.groupKey);
            if (BooleanUtils.getValue(notificationDetails.setAsGroupSummary)) {
                builder.v(true);
            }
            builder.u(notificationDetails.groupAlertBehavior.intValue());
        }
    }

    private void areNotificationsEnabled(MethodChannel.Result result) {
        result.success(Boolean.valueOf(getNotificationManager(this.applicationContext).a()));
    }

    @NonNull
    public static Gson buildGson() {
        if (gson == null) {
            gson = new GsonBuilder().registerTypeAdapter(ScheduleMode.class, new ScheduleMode.Deserializer()).registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(StyleInformation.class).registerSubtype(DefaultStyleInformation.class).registerSubtype(BigTextStyleInformation.class).registerSubtype(BigPictureStyleInformation.class).registerSubtype(InboxStyleInformation.class).registerSubtype(MessagingStyleInformation.class)).create();
        }
        return gson;
    }

    private static Person buildPerson(Context context, PersonDetails personDetails) {
        IconSource iconSource;
        if (personDetails == null) {
            return null;
        }
        Person.Builder builder = new Person.Builder();
        builder.b(BooleanUtils.getValue(personDetails.bot));
        Object obj = personDetails.icon;
        if (!(obj == null || (iconSource = personDetails.iconBitmapSource) == null)) {
            builder.c(getIconFromSource(context, obj, iconSource));
        }
        builder.d(BooleanUtils.getValue(personDetails.important));
        String str = personDetails.key;
        if (str != null) {
            builder.e(str);
        }
        String str2 = personDetails.name;
        if (str2 != null) {
            builder.f(str2);
        }
        String str3 = personDetails.uri;
        if (str3 != null) {
            builder.g(str3);
        }
        return builder.a();
    }

    private static long calculateNextNotificationTrigger(long j, long j2) {
        while (j < System.currentTimeMillis()) {
            j += j2;
        }
        return j;
    }

    private static long calculateRepeatIntervalMilliseconds(NotificationDetails notificationDetails) {
        Integer num = notificationDetails.repeatIntervalMilliseconds;
        if (num != null) {
            return (long) num.intValue();
        }
        int i = AnonymousClass5.f2812a[notificationDetails.repeatInterval.ordinal()];
        if (i == 1) {
            return 60000;
        }
        if (i != 2) {
            return i != 3 ? i != 4 ? 0 : 604800000 : DateUtils.MILLIS_PER_DAY;
        }
        return 3600000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r3.channelAction;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean canCreateNotificationChannel(android.content.Context r2, com.dexterous.flutterlocalnotifications.models.NotificationChannelDetails r3) {
        /*
            java.lang.String r0 = "notification"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            java.lang.String r0 = r3.id
            android.app.NotificationChannel r2 = r2.getNotificationChannel(r0)
            if (r2 != 0) goto L_0x0018
            com.dexterous.flutterlocalnotifications.models.NotificationChannelAction r0 = r3.channelAction
            if (r0 == 0) goto L_0x0020
            com.dexterous.flutterlocalnotifications.models.NotificationChannelAction r1 = com.dexterous.flutterlocalnotifications.models.NotificationChannelAction.CreateIfNotExists
            if (r0 == r1) goto L_0x0020
        L_0x0018:
            if (r2 == 0) goto L_0x0022
            com.dexterous.flutterlocalnotifications.models.NotificationChannelAction r2 = r3.channelAction
            com.dexterous.flutterlocalnotifications.models.NotificationChannelAction r3 = com.dexterous.flutterlocalnotifications.models.NotificationChannelAction.Update
            if (r2 != r3) goto L_0x0022
        L_0x0020:
            r2 = 1
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.canCreateNotificationChannel(android.content.Context, com.dexterous.flutterlocalnotifications.models.NotificationChannelDetails):java.lang.Boolean");
    }

    private void cancel(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments();
        cancelNotification((Integer) map.get("id"), (String) map.get(CANCEL_TAG));
        result.success((Object) null);
    }

    private void cancelAllNotifications(MethodChannel.Result result) {
        getNotificationManager(this.applicationContext).d();
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (loadScheduledNotifications == null || loadScheduledNotifications.isEmpty()) {
            result.success((Object) null);
            return;
        }
        Intent intent = new Intent(this.applicationContext, ScheduledNotificationReceiver.class);
        Iterator<NotificationDetails> it = loadScheduledNotifications.iterator();
        while (it.hasNext()) {
            getAlarmManager(this.applicationContext).cancel(getBroadcastPendingIntent(this.applicationContext, it.next().id.intValue(), intent));
        }
        saveScheduledNotifications(this.applicationContext, new ArrayList());
        result.success((Object) null);
    }

    private void cancelNotification(Integer num, String str) {
        getAlarmManager(this.applicationContext).cancel(getBroadcastPendingIntent(this.applicationContext, num.intValue(), new Intent(this.applicationContext, ScheduledNotificationReceiver.class)));
        NotificationManagerCompat notificationManager = getNotificationManager(this.applicationContext);
        if (str == null) {
            notificationManager.b(num.intValue());
        } else {
            notificationManager.c(str, num.intValue());
        }
        removeNotificationFromCache(this.applicationContext, num);
    }

    private static byte[] castObjectToByteArray(Object obj) {
        if (!(obj instanceof ArrayList)) {
            return (byte[]) obj;
        }
        ArrayList arrayList = (ArrayList) obj;
        byte[] bArr = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr[i] = (byte) ((Double) arrayList.get(i)).intValue();
        }
        return bArr;
    }

    private static void checkCanScheduleExactAlarms(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            throw new ExactAlarmPermissionException();
        }
    }

    private static NotificationCompat.MessagingStyle.Message createMessage(Context context, MessageDetails messageDetails) {
        String str;
        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(messageDetails.text, messageDetails.timestamp.longValue(), buildPerson(context, messageDetails.person));
        String str2 = messageDetails.dataUri;
        if (!(str2 == null || (str = messageDetails.dataMimeType) == null)) {
            message.j(str, Uri.parse(str2));
        }
        return message;
    }

    public static Notification createNotification(Context context, NotificationDetails notificationDetails) {
        Intent intent;
        int i;
        PendingIntent broadcast;
        IconSource iconSource;
        Context context2 = context;
        NotificationDetails notificationDetails2 = notificationDetails;
        NotificationChannelDetails fromNotificationDetails = NotificationChannelDetails.fromNotificationDetails(notificationDetails);
        if (canCreateNotificationChannel(context2, fromNotificationDetails).booleanValue()) {
            setupNotificationChannel(context2, fromNotificationDetails);
        }
        Intent launchIntent = getLaunchIntent(context);
        launchIntent.setAction(SELECT_NOTIFICATION);
        launchIntent.putExtra(NOTIFICATION_ID, notificationDetails2.id);
        launchIntent.putExtra(PAYLOAD, notificationDetails2.payload);
        PendingIntent activity = PendingIntent.getActivity(context2, notificationDetails2.id.intValue(), launchIntent, CircleProgressBar.RIM_COLOR_DEF);
        DefaultStyleInformation defaultStyleInformation = (DefaultStyleInformation) notificationDetails2.styleInformation;
        NotificationCompat.Builder B = new NotificationCompat.Builder(context2, notificationDetails2.channelId).n(defaultStyleInformation.htmlFormatTitle.booleanValue() ? fromHtml(notificationDetails2.title) : notificationDetails2.title).m(defaultStyleInformation.htmlFormatBody.booleanValue() ? fromHtml(notificationDetails2.body) : notificationDetails2.body).L(notificationDetails2.ticker).f(BooleanUtils.getValue(notificationDetails2.autoCancel)).l(activity).C(notificationDetails2.priority.intValue()).A(BooleanUtils.getValue(notificationDetails2.ongoing)).G(BooleanUtils.getValue(notificationDetails2.silent)).B(BooleanUtils.getValue(notificationDetails2.onlyAlertOnce));
        if (notificationDetails2.actions != null) {
            int intValue = notificationDetails2.id.intValue() * 16;
            for (NotificationAction next : notificationDetails2.actions) {
                IconCompat iconFromSource = (TextUtils.isEmpty(next.icon) || (iconSource = next.iconSource) == null) ? null : getIconFromSource(context2, next.icon, iconSource);
                Boolean bool = next.showsUserInterface;
                if (bool == null || !bool.booleanValue()) {
                    intent = new Intent(context2, ActionBroadcastReceiver.class);
                    intent.setAction("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED");
                } else {
                    intent = getLaunchIntent(context);
                    intent.setAction(SELECT_FOREGROUND_NOTIFICATION_ACTION);
                }
                intent.putExtra(NOTIFICATION_ID, notificationDetails2.id).putExtra(NOTIFICATION_TAG, notificationDetails2.tag).putExtra(ACTION_ID, next.id).putExtra(CANCEL_NOTIFICATION, next.cancelNotification).putExtra(PAYLOAD, notificationDetails2.payload);
                List<NotificationAction.NotificationActionInput> list = next.actionInputs;
                int i2 = (list == null || list.isEmpty()) ? CircleProgressBar.RIM_COLOR_DEF : Build.VERSION.SDK_INT >= 31 ? 167772160 : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW;
                Boolean bool2 = next.showsUserInterface;
                if (bool2 == null || !bool2.booleanValue()) {
                    i = intValue + 1;
                    broadcast = PendingIntent.getBroadcast(context2, intValue, intent, i2);
                } else {
                    i = intValue + 1;
                    broadcast = PendingIntent.getActivity(context2, intValue, intent, i2);
                }
                intValue = i;
                SpannableString spannableString = new SpannableString(next.title);
                if (next.titleColor != null) {
                    spannableString.setSpan(new ForegroundColorSpan(next.titleColor.intValue()), 0, spannableString.length(), 0);
                }
                NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(iconFromSource, spannableString, broadcast);
                Boolean bool3 = next.contextual;
                if (bool3 != null) {
                    builder.e(bool3.booleanValue());
                }
                Boolean bool4 = next.showsUserInterface;
                if (bool4 != null) {
                    builder.f(bool4.booleanValue());
                }
                Boolean bool5 = next.allowGeneratedReplies;
                if (bool5 != null) {
                    builder.d(bool5.booleanValue());
                }
                List<NotificationAction.NotificationActionInput> list2 = next.actionInputs;
                if (list2 != null) {
                    for (NotificationAction.NotificationActionInput next2 : list2) {
                        RemoteInput.Builder e = new RemoteInput.Builder(INPUT_RESULT).e(next2.label);
                        Boolean bool6 = next2.allowFreeFormInput;
                        if (bool6 != null) {
                            e.c(bool6.booleanValue());
                        }
                        List<String> list3 = next2.allowedMimeTypes;
                        if (list3 != null) {
                            for (String b : list3) {
                                e.b(b, true);
                            }
                        }
                        List<String> list4 = next2.choices;
                        if (list4 != null) {
                            e.d((CharSequence[]) list4.toArray(new CharSequence[0]));
                        }
                        builder.a(e.a());
                    }
                }
                B.b(builder.b());
            }
        }
        setSmallIcon(context2, notificationDetails2, B);
        B.w(getBitmapFromSource(context2, notificationDetails2.largeIcon, notificationDetails2.largeIconBitmapSource));
        Integer num = notificationDetails2.color;
        if (num != null) {
            B.j(num.intValue());
        }
        Boolean bool7 = notificationDetails2.colorized;
        if (bool7 != null) {
            B.k(bool7.booleanValue());
        }
        Boolean bool8 = notificationDetails2.showWhen;
        if (bool8 != null) {
            B.F(BooleanUtils.getValue(bool8));
        }
        Long l = notificationDetails2.when;
        if (l != null) {
            B.Q(l.longValue());
        }
        Boolean bool9 = notificationDetails2.usesChronometer;
        if (bool9 != null) {
            B.N(bool9.booleanValue());
        }
        Boolean bool10 = notificationDetails2.chronometerCountDown;
        if (bool10 != null) {
            B.i(bool10.booleanValue());
        }
        if (BooleanUtils.getValue(notificationDetails2.fullScreenIntent)) {
            B.s(activity, true);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails2.shortcutId).booleanValue()) {
            B.E(notificationDetails2.shortcutId);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails2.subText).booleanValue()) {
            B.K(notificationDetails2.subText);
        }
        Integer num2 = notificationDetails2.number;
        if (num2 != null) {
            B.z(num2.intValue());
        }
        setVisibility(notificationDetails2, B);
        applyGrouping(notificationDetails2, B);
        setSound(context2, notificationDetails2, B);
        setVibrationPattern(notificationDetails2, B);
        setLights(notificationDetails2, B);
        setStyle(context2, notificationDetails2, B);
        setProgress(notificationDetails2, B);
        setCategory(notificationDetails2, B);
        setTimeoutAfter(notificationDetails2, B);
        Notification c = B.c();
        int[] iArr = notificationDetails2.additionalFlags;
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                c.flags = i3 | c.flags;
            }
        }
        return c;
    }

    private void createNotificationChannel(MethodCall methodCall, MethodChannel.Result result) {
        setupNotificationChannel(this.applicationContext, NotificationChannelDetails.from((Map) methodCall.arguments()));
        result.success((Object) null);
    }

    private void createNotificationChannelGroup(MethodCall methodCall, MethodChannel.Result result) {
        NotificationChannelGroupDetails from = NotificationChannelGroupDetails.from((Map) methodCall.arguments());
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(from.id, from.name);
        notificationChannelGroup.setDescription(from.description);
        ((NotificationManager) this.applicationContext.getSystemService("notification")).createNotificationChannelGroup(notificationChannelGroup);
        result.success((Object) null);
    }

    private void deleteNotificationChannel(MethodCall methodCall, MethodChannel.Result result) {
        ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannel((String) methodCall.arguments());
        result.success((Object) null);
    }

    private void deleteNotificationChannelGroup(MethodCall methodCall, MethodChannel.Result result) {
        ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannelGroup((String) methodCall.arguments());
        result.success((Object) null);
    }

    private Map<String, Object> describeIcon(IconCompat iconCompat) {
        String str;
        IconSource iconSource;
        if (iconCompat == null) {
            return null;
        }
        int q = iconCompat.q();
        if (q == 2) {
            IconSource iconSource2 = IconSource.DrawableResource;
            str = this.applicationContext.getResources().getResourceEntryName(iconCompat.o());
            iconSource = iconSource2;
        } else if (q != 4) {
            return null;
        } else {
            iconSource = IconSource.ContentUri;
            str = iconCompat.r().toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(iconSource.ordinal()));
        hashMap.put("data", str);
        return hashMap;
    }

    private Map<String, Object> describePerson(Person person) {
        if (person == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(IntentKey.ACTIVITY.ACTION_KEY, person.d());
        hashMap.put("name", person.e());
        hashMap.put("uri", person.f());
        hashMap.put("bot", Boolean.valueOf(person.g()));
        hashMap.put("important", Boolean.valueOf(person.h()));
        hashMap.put("icon", describeIcon(person.c()));
        return hashMap;
    }

    private NotificationDetails extractNotificationDetails(MethodChannel.Result result, Map<String, Object> map) {
        NotificationDetails from = NotificationDetails.from(map);
        if (hasInvalidIcon(result, from.icon) || hasInvalidLargeIcon(result, from.largeIcon, from.largeIconBitmapSource) || hasInvalidBigPictureResources(result, from) || hasInvalidRawSoundResource(result, from) || hasInvalidLedDetails(result, from)) {
            return null;
        }
        return from;
    }

    public static Map<String, Object> extractNotificationResponseMap(Intent intent) {
        int intExtra = intent.getIntExtra(NOTIFICATION_ID, 0);
        HashMap hashMap = new HashMap();
        hashMap.put(NOTIFICATION_ID, Integer.valueOf(intExtra));
        hashMap.put(NOTIFICATION_TAG, intent.getStringExtra(NOTIFICATION_TAG));
        hashMap.put(ACTION_ID, intent.getStringExtra(ACTION_ID));
        hashMap.put(PAYLOAD, intent.getStringExtra(PAYLOAD));
        Bundle j = RemoteInput.j(intent);
        if (j != null) {
            hashMap.put(INPUT, j.getString(INPUT_RESULT));
        }
        if (SELECT_NOTIFICATION.equals(intent.getAction())) {
            hashMap.put(NOTIFICATION_RESPONSE_TYPE, 0);
        }
        if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            hashMap.put(NOTIFICATION_RESPONSE_TYPE, 1);
        }
        return hashMap;
    }

    private static Spanned fromHtml(String str) {
        if (str == null) {
            return null;
        }
        return Html.fromHtml(str, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r9 = r6.getNotification();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getActiveNotificationMessagingStyle(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = "person"
            android.content.Context r1 = r8.applicationContext
            java.lang.String r2 = "notification"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            java.lang.Object r9 = r9.arguments()     // Catch:{ all -> 0x0044 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "id"
            java.lang.Object r2 = r9.get(r2)     // Catch:{ all -> 0x0044 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0044 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "tag"
            java.lang.Object r9 = r9.get(r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0044 }
            android.service.notification.StatusBarNotification[] r1 = r1.getActiveNotifications()     // Catch:{ all -> 0x0044 }
            int r3 = r1.length     // Catch:{ all -> 0x0044 }
            r4 = 0
        L_0x002c:
            r5 = 0
            if (r4 >= r3) goto L_0x004f
            r6 = r1[r4]     // Catch:{ all -> 0x0044 }
            int r7 = r6.getId()     // Catch:{ all -> 0x0044 }
            if (r7 != r2) goto L_0x004c
            if (r9 == 0) goto L_0x0047
            java.lang.String r7 = r6.getTag()     // Catch:{ all -> 0x0044 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x0044 }
            if (r7 == 0) goto L_0x004c
            goto L_0x0047
        L_0x0044:
            r8 = move-exception
            goto L_0x00d2
        L_0x0047:
            android.app.Notification r9 = r6.getNotification()     // Catch:{ all -> 0x0044 }
            goto L_0x0050
        L_0x004c:
            int r4 = r4 + 1
            goto L_0x002c
        L_0x004f:
            r9 = r5
        L_0x0050:
            if (r9 != 0) goto L_0x0056
            r10.success(r5)     // Catch:{ all -> 0x0044 }
            return
        L_0x0056:
            androidx.core.app.NotificationCompat$MessagingStyle r9 = androidx.core.app.NotificationCompat.MessagingStyle.o(r9)     // Catch:{ all -> 0x0044 }
            if (r9 != 0) goto L_0x0060
            r10.success(r5)     // Catch:{ all -> 0x0044 }
            return
        L_0x0060:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "groupConversation"
            boolean r3 = r9.s()     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0044 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0044 }
            androidx.core.app.Person r2 = r9.r()     // Catch:{ all -> 0x0044 }
            java.util.Map r2 = r8.describePerson(r2)     // Catch:{ all -> 0x0044 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "conversationTitle"
            java.lang.CharSequence r3 = r9.p()     // Catch:{ all -> 0x0044 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            java.util.List r9 = r9.q()     // Catch:{ all -> 0x0044 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0044 }
        L_0x0093:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x00c9
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$MessagingStyle$Message r3 = (androidx.core.app.NotificationCompat.MessagingStyle.Message) r3     // Catch:{ all -> 0x0044 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "text"
            java.lang.CharSequence r6 = r3.h()     // Catch:{ all -> 0x0044 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "timestamp"
            long r6 = r3.i()     // Catch:{ all -> 0x0044 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0044 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0044 }
            androidx.core.app.Person r3 = r3.g()     // Catch:{ all -> 0x0044 }
            java.util.Map r3 = r8.describePerson(r3)     // Catch:{ all -> 0x0044 }
            r4.put(r0, r3)     // Catch:{ all -> 0x0044 }
            r2.add(r4)     // Catch:{ all -> 0x0044 }
            goto L_0x0093
        L_0x00c9:
            java.lang.String r8 = "messages"
            r1.put(r8, r2)     // Catch:{ all -> 0x0044 }
            r10.success(r1)     // Catch:{ all -> 0x0044 }
            goto L_0x00df
        L_0x00d2:
            java.lang.String r9 = r8.getMessage()
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)
            java.lang.String r0 = "getActiveNotificationMessagingStyleError"
            r10.error(r0, r9, r8)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.getActiveNotificationMessagingStyle(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private void getActiveNotifications(MethodChannel.Result result) {
        try {
            StatusBarNotification[] activeNotifications = ((NotificationManager) this.applicationContext.getSystemService("notification")).getActiveNotifications();
            ArrayList arrayList = new ArrayList();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", Integer.valueOf(statusBarNotification.getId()));
                Notification notification = statusBarNotification.getNotification();
                hashMap.put("channelId", notification.getChannelId());
                hashMap.put(CANCEL_TAG, statusBarNotification.getTag());
                hashMap.put("groupKey", notification.getGroup());
                hashMap.put("title", notification.extras.getCharSequence("android.title"));
                hashMap.put("body", notification.extras.getCharSequence("android.text"));
                hashMap.put("bigText", notification.extras.getCharSequence("android.bigText"));
                arrayList.add(hashMap);
            }
            result.success(arrayList);
        } catch (Throwable th) {
            result.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(VuiModelType.ALARM);
    }

    private static Bitmap getBitmapFromSource(Context context, Object obj, BitmapSource bitmapSource) {
        if (bitmapSource == BitmapSource.DrawableResource) {
            return BitmapFactory.decodeResource(context.getResources(), getDrawableResourceId(context, (String) obj));
        }
        if (bitmapSource == BitmapSource.FilePath) {
            return BitmapFactory.decodeFile((String) obj);
        }
        if (bitmapSource != BitmapSource.ByteArray) {
            return null;
        }
        byte[] castObjectToByteArray = castObjectToByteArray(obj);
        return BitmapFactory.decodeByteArray(castObjectToByteArray, 0, castObjectToByteArray.length);
    }

    private static PendingIntent getBroadcastPendingIntent(Context context, int i, Intent intent) {
        return PendingIntent.getBroadcast(context, i, intent, CircleProgressBar.RIM_COLOR_DEF);
    }

    private void getCallbackHandle(MethodChannel.Result result) {
        result.success(new IsolatePreferences(this.applicationContext).c());
    }

    private static int getDrawableResourceId(Context context, String str) {
        return context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName());
    }

    private static IconCompat getIconFromSource(Context context, Object obj, IconSource iconSource) {
        int i = AnonymousClass5.b[iconSource.ordinal()];
        if (i == 1) {
            return IconCompat.l(context, getDrawableResourceId(context, (String) obj));
        }
        if (i == 2) {
            return IconCompat.h(BitmapFactory.decodeFile((String) obj));
        }
        if (i == 3) {
            return IconCompat.j((String) obj);
        }
        if (i == 4) {
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(FlutterInjector.instance().flutterLoader().getLookupKeyForAsset((String) obj));
                FileInputStream createInputStream = openFd.createInputStream();
                IconCompat h = IconCompat.h(BitmapFactory.decodeStream(createInputStream));
                createInputStream.close();
                openFd.close();
                return h;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (i != 5) {
            return null;
        } else {
            byte[] castObjectToByteArray = castObjectToByteArray(obj);
            return IconCompat.k(castObjectToByteArray, 0, castObjectToByteArray.length);
        }
    }

    private static Intent getLaunchIntent(Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    }

    private HashMap<String, Object> getMappedNotificationChannel(NotificationChannel notificationChannel) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", notificationChannel.getId());
        hashMap.put("name", notificationChannel.getName());
        hashMap.put("description", notificationChannel.getDescription());
        hashMap.put("groupId", notificationChannel.getGroup());
        hashMap.put("showBadge", Boolean.valueOf(notificationChannel.canShowBadge()));
        hashMap.put("importance", Integer.valueOf(notificationChannel.getImportance()));
        Uri sound = notificationChannel.getSound();
        if (sound == null) {
            hashMap.put("sound", (Object) null);
            hashMap.put("playSound", Boolean.FALSE);
        } else {
            hashMap.put("playSound", Boolean.TRUE);
            List asList = Arrays.asList(SoundSource.values());
            if (sound.getScheme().equals("android.resource")) {
                String[] split = sound.toString().split("/");
                String str = split[split.length - 1];
                Integer tryParseInt = tryParseInt(str);
                if (tryParseInt == null) {
                    hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.RawResource)));
                    hashMap.put("sound", str);
                } else {
                    String resourceEntryName = this.applicationContext.getResources().getResourceEntryName(tryParseInt.intValue());
                    if (resourceEntryName != null) {
                        hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.RawResource)));
                        hashMap.put("sound", resourceEntryName);
                    }
                }
            } else {
                hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.Uri)));
                hashMap.put("sound", sound.toString());
            }
        }
        hashMap.put("enableVibration", Boolean.valueOf(notificationChannel.shouldVibrate()));
        hashMap.put("vibrationPattern", notificationChannel.getVibrationPattern());
        hashMap.put("enableLights", Boolean.valueOf(notificationChannel.shouldShowLights()));
        hashMap.put("ledColor", Integer.valueOf(notificationChannel.getLightColor()));
        AudioAttributes audioAttributes = notificationChannel.getAudioAttributes();
        hashMap.put("audioAttributesUsage", Integer.valueOf(audioAttributes == null ? 5 : audioAttributes.getUsage()));
        return hashMap;
    }

    private static String getNextFireDate(NotificationDetails notificationDetails) {
        ScheduledNotificationRepeatFrequency scheduledNotificationRepeatFrequency = notificationDetails.scheduledNotificationRepeatFrequency;
        if (scheduledNotificationRepeatFrequency == ScheduledNotificationRepeatFrequency.Daily) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(notificationDetails.scheduledDateTime).plusDays(1));
        } else if (scheduledNotificationRepeatFrequency != ScheduledNotificationRepeatFrequency.Weekly) {
            return null;
        } else {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(notificationDetails.scheduledDateTime).plusWeeks(1));
        }
    }

    private static String getNextFireDateMatchingDateTimeComponents(NotificationDetails notificationDetails) {
        ZoneId of = ZoneId.of(notificationDetails.timeZoneName);
        ZonedDateTime of2 = ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), of);
        ZonedDateTime now = ZonedDateTime.now(of);
        ZonedDateTime of3 = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), of2.getHour(), of2.getMinute(), of2.getSecond(), of2.getNano(), of);
        while (of3.isBefore(now)) {
            of3 = of3.plusDays(1);
        }
        DateTimeComponents dateTimeComponents = notificationDetails.matchDateTimeComponents;
        if (dateTimeComponents == DateTimeComponents.Time) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        }
        if (dateTimeComponents == DateTimeComponents.DayOfWeekAndTime) {
            while (of3.getDayOfWeek() != of2.getDayOfWeek()) {
                of3 = of3.plusDays(1);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        } else if (dateTimeComponents == DateTimeComponents.DayOfMonthAndTime) {
            while (of3.getDayOfMonth() != of2.getDayOfMonth()) {
                of3 = of3.plusDays(1);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        } else if (dateTimeComponents != DateTimeComponents.DateAndTime) {
            return null;
        } else {
            while (true) {
                if (of3.getMonthValue() == of2.getMonthValue() && of3.getDayOfMonth() == of2.getDayOfMonth()) {
                    return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
                }
                of3 = of3.plusDays(1);
            }
        }
    }

    private void getNotificationAppLaunchDetails(MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.FALSE;
        Activity activity = this.mainActivity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            boolean z = intent != null && (SELECT_NOTIFICATION.equals(intent.getAction()) || SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) && !launchedActivityFromHistory(intent);
            Boolean valueOf = Boolean.valueOf(z);
            if (z) {
                hashMap.put("notificationResponse", extractNotificationResponseMap(intent));
            }
            bool = valueOf;
        }
        hashMap.put(NOTIFICATION_LAUNCHED_APP, bool);
        result.success(hashMap);
    }

    private void getNotificationChannels(MethodChannel.Result result) {
        try {
            List<NotificationChannel> j = getNotificationManager(this.applicationContext).j();
            ArrayList arrayList = new ArrayList();
            for (NotificationChannel mappedNotificationChannel : j) {
                arrayList.add(getMappedNotificationChannel(mappedNotificationChannel));
            }
            result.success(arrayList);
        } catch (Throwable th) {
            result.error(GET_NOTIFICATION_CHANNELS_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private static NotificationManagerCompat getNotificationManager(Context context) {
        return NotificationManagerCompat.g(context);
    }

    private boolean hasInvalidBigPictureResources(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.style != NotificationStyle.BigPicture) {
            return false;
        }
        BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
        if (hasInvalidLargeIcon(result, bigPictureStyleInformation.largeIcon, bigPictureStyleInformation.largeIconBitmapSource)) {
            return true;
        }
        BitmapSource bitmapSource = bigPictureStyleInformation.bigPictureBitmapSource;
        if (bitmapSource == BitmapSource.DrawableResource) {
            String str = (String) bigPictureStyleInformation.bigPicture;
            return StringUtils.isNullOrEmpty(str).booleanValue() && !isValidDrawableResource(this.applicationContext, str, result, INVALID_BIG_PICTURE_ERROR_CODE);
        } else if (bitmapSource == BitmapSource.FilePath) {
            return StringUtils.isNullOrEmpty((String) bigPictureStyleInformation.bigPicture).booleanValue();
        } else {
            if (bitmapSource != BitmapSource.ByteArray) {
                return false;
            }
            byte[] bArr = (byte[]) bigPictureStyleInformation.bigPicture;
            return bArr == null || bArr.length == 0;
        }
    }

    private boolean hasInvalidIcon(MethodChannel.Result result, String str) {
        return !StringUtils.isNullOrEmpty(str).booleanValue() && !isValidDrawableResource(this.applicationContext, str, result, INVALID_ICON_ERROR_CODE);
    }

    private boolean hasInvalidLargeIcon(MethodChannel.Result result, Object obj, BitmapSource bitmapSource) {
        BitmapSource bitmapSource2 = BitmapSource.DrawableResource;
        if (bitmapSource == bitmapSource2 || bitmapSource == BitmapSource.FilePath) {
            String str = (String) obj;
            return !StringUtils.isNullOrEmpty(str).booleanValue() && bitmapSource == bitmapSource2 && !isValidDrawableResource(this.applicationContext, str, result, INVALID_LARGE_ICON_ERROR_CODE);
        } else if (bitmapSource == BitmapSource.ByteArray) {
            return ((byte[]) obj).length == 0;
        } else {
            return false;
        }
    }

    private boolean hasInvalidLedDetails(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.ledColor == null) {
            return false;
        }
        if (notificationDetails.ledOnMs != null && notificationDetails.ledOffMs != null) {
            return false;
        }
        result.error(INVALID_LED_DETAILS_ERROR_CODE, INVALID_LED_DETAILS_ERROR_MESSAGE, (Object) null);
        return true;
    }

    private boolean hasInvalidRawSoundResource(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (StringUtils.isNullOrEmpty(notificationDetails.sound).booleanValue()) {
            return false;
        }
        SoundSource soundSource = notificationDetails.soundSource;
        if ((soundSource != null && soundSource != SoundSource.RawResource) || this.applicationContext.getResources().getIdentifier(notificationDetails.sound, "raw", this.applicationContext.getPackageName()) != 0) {
            return false;
        }
        result.error(INVALID_SOUND_ERROR_CODE, String.format(INVALID_RAW_RESOURCE_ERROR_MESSAGE, new Object[]{notificationDetails.sound}), (Object) null);
        return true;
    }

    private void initialize(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) ((Map) methodCall.arguments()).get(DEFAULT_ICON);
        if (isValidDrawableResource(this.applicationContext, str, result, INVALID_ICON_ERROR_CODE)) {
            Long a2 = LongUtils.a(methodCall.argument(DISPATCHER_HANDLE));
            Long a3 = LongUtils.a(methodCall.argument(CALLBACK_HANDLE));
            if (!(a2 == null || a3 == null)) {
                new IsolatePreferences(this.applicationContext).e(a2, a3);
            }
            this.applicationContext.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).edit().putString(DEFAULT_ICON, str).apply();
            result.success(Boolean.TRUE);
        }
    }

    private static boolean isValidDrawableResource(Context context, String str, MethodChannel.Result result, String str2) {
        if (context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName()) != 0) {
            return true;
        }
        result.error(str2, String.format(INVALID_DRAWABLE_RESOURCE_ERROR_MESSAGE, new Object[]{str}), (Object) null);
        return false;
    }

    private static boolean launchedActivityFromHistory(Intent intent) {
        return intent != null && (intent.getFlags() & PositionEstimate.Value.SITUATION) == 1048576;
    }

    private static ArrayList<NotificationDetails> loadScheduledNotifications(Context context) {
        ArrayList<NotificationDetails> arrayList = new ArrayList<>();
        String string = context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).getString(SCHEDULED_NOTIFICATIONS, (String) null);
        return string != null ? (ArrayList) buildGson().fromJson(string, new TypeToken<ArrayList<NotificationDetails>>() {
        }.getType()) : arrayList;
    }

    private void pendingNotificationRequests(MethodChannel.Result result) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationDetails> it = loadScheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails next = it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("id", next.id);
            hashMap.put("title", next.title);
            hashMap.put("body", next.body);
            hashMap.put(PAYLOAD, next.payload);
            arrayList.add(hashMap);
        }
        result.success(arrayList);
    }

    private void processForegroundNotificationAction(Intent intent, Map<String, Object> map) {
        if (intent.getBooleanExtra(CANCEL_NOTIFICATION, false)) {
            NotificationManagerCompat.g(this.applicationContext).b(((Integer) map.get(NOTIFICATION_ID)).intValue());
        }
    }

    public static void removeNotificationFromCache(Context context, Integer num) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(context);
        Iterator<NotificationDetails> it = loadScheduledNotifications.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().id.equals(num)) {
                    it.remove();
                    break;
                }
            } else {
                break;
            }
        }
        saveScheduledNotifications(context, loadScheduledNotifications);
    }

    private void repeat(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            try {
                repeatNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                result.success((Object) null);
            } catch (PluginException e) {
                result.error(e.code, e.getMessage(), (Object) null);
            }
        }
    }

    private static void repeatNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        long calculateRepeatIntervalMilliseconds = calculateRepeatIntervalMilliseconds(notificationDetails);
        long longValue = notificationDetails.calledAt.longValue();
        if (notificationDetails.repeatTime != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.set(11, notificationDetails.repeatTime.hour.intValue());
            instance.set(12, notificationDetails.repeatTime.minute.intValue());
            instance.set(13, notificationDetails.repeatTime.second.intValue());
            Integer num = notificationDetails.day;
            if (num != null) {
                instance.set(7, num.intValue());
            }
            longValue = instance.getTimeInMillis();
        }
        long calculateNextNotificationTrigger = calculateNextNotificationTrigger(longValue, calculateRepeatIntervalMilliseconds);
        String json = buildGson().toJson((Object) notificationDetails);
        Intent intent = new Intent(context, ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.inexact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, calculateNextNotificationTrigger, broadcastPendingIntent);
        } else {
            alarmManager.setInexactRepeating(0, calculateNextNotificationTrigger, calculateRepeatIntervalMilliseconds, broadcastPendingIntent);
        }
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    public static void rescheduleNotifications(Context context) {
        Iterator<NotificationDetails> it = loadScheduledNotifications(context).iterator();
        while (it.hasNext()) {
            NotificationDetails next = it.next();
            try {
                if (next.repeatInterval == null) {
                    if (next.repeatIntervalMilliseconds == null) {
                        if (next.timeZoneName != null) {
                            zonedScheduleNotification(context, next, Boolean.FALSE);
                        } else {
                            scheduleNotification(context, next, Boolean.FALSE);
                        }
                    }
                }
                repeatNotification(context, next, Boolean.FALSE);
            } catch (ExactAlarmPermissionException e) {
                Log.e(TAG, e.getMessage());
                removeNotificationFromCache(context, next.id);
            }
        }
    }

    private static Uri retrieveSoundResourceUri(Context context, String str, SoundSource soundSource) {
        if (StringUtils.isNullOrEmpty(str).booleanValue()) {
            return RingtoneManager.getDefaultUri(2);
        }
        if (soundSource == null || soundSource == SoundSource.RawResource) {
            return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
        } else if (soundSource == SoundSource.Uri) {
            return Uri.parse(str);
        } else {
            return null;
        }
    }

    private static void saveScheduledNotification(Context context, NotificationDetails notificationDetails) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(context);
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationDetails> it = loadScheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails next = it.next();
            if (!next.id.equals(notificationDetails.id)) {
                arrayList.add(next);
            }
        }
        arrayList.add(notificationDetails);
        saveScheduledNotifications(context, arrayList);
    }

    private static void saveScheduledNotifications(Context context, ArrayList<NotificationDetails> arrayList) {
        context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).edit().putString(SCHEDULED_NOTIFICATIONS, buildGson().toJson((Object) arrayList)).apply();
    }

    public static void scheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        try {
            if (notificationDetails.scheduledNotificationRepeatFrequency != null) {
                zonedScheduleNextNotification(context, notificationDetails);
            } else if (notificationDetails.matchDateTimeComponents != null) {
                zonedScheduleNextNotificationMatchingDateComponents(context, notificationDetails);
            } else {
                if (notificationDetails.repeatInterval == null) {
                    if (notificationDetails.repeatIntervalMilliseconds == null) {
                        removeNotificationFromCache(context, notificationDetails.id);
                        return;
                    }
                }
                scheduleNextRepeatingNotification(context, notificationDetails);
            }
        } catch (ExactAlarmPermissionException e) {
            Log.e(TAG, e.getMessage());
            removeNotificationFromCache(context, notificationDetails.id);
        }
    }

    private static void scheduleNextRepeatingNotification(Context context, NotificationDetails notificationDetails) {
        long calculateNextNotificationTrigger = calculateNextNotificationTrigger(notificationDetails.calledAt.longValue(), calculateRepeatIntervalMilliseconds(notificationDetails));
        String json = buildGson().toJson((Object) notificationDetails);
        Intent intent = new Intent(context, ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exactAllowWhileIdle;
        }
        setupAllowWhileIdleAlarm(notificationDetails, alarmManager, calculateNextNotificationTrigger, broadcastPendingIntent);
        saveScheduledNotification(context, notificationDetails);
    }

    private static void scheduleNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        String json = buildGson().toJson((Object) notificationDetails);
        Intent intent = new Intent(context, ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        setupAlarm(notificationDetails, getAlarmManager(context), notificationDetails.millisecondsSinceEpoch.longValue(), getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent));
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    private Boolean sendNotificationPayloadMessage(Intent intent) {
        if (!SELECT_NOTIFICATION.equals(intent.getAction()) && !SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            return Boolean.FALSE;
        }
        Map<String, Object> extractNotificationResponseMap = extractNotificationResponseMap(intent);
        if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            processForegroundNotificationAction(intent, extractNotificationResponseMap);
        }
        this.channel.invokeMethod("didReceiveNotificationResponse", extractNotificationResponseMap);
        return Boolean.TRUE;
    }

    private void setActivity(Activity activity) {
        this.mainActivity = activity;
    }

    private static void setBigPictureStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        if (bigPictureStyleInformation.contentTitle != null) {
            bigPictureStyle.r(bigPictureStyleInformation.htmlFormatContentTitle.booleanValue() ? fromHtml(bigPictureStyleInformation.contentTitle) : bigPictureStyleInformation.contentTitle);
        }
        if (bigPictureStyleInformation.summaryText != null) {
            bigPictureStyle.s(bigPictureStyleInformation.htmlFormatSummaryText.booleanValue() ? fromHtml(bigPictureStyleInformation.summaryText) : bigPictureStyleInformation.summaryText);
        }
        if (bigPictureStyleInformation.hideExpandedLargeIcon.booleanValue()) {
            bigPictureStyle.o((Bitmap) null);
        } else {
            Object obj = bigPictureStyleInformation.largeIcon;
            if (obj != null) {
                bigPictureStyle.o(getBitmapFromSource(context, obj, bigPictureStyleInformation.largeIconBitmapSource));
            }
        }
        bigPictureStyle.p(getBitmapFromSource(context, bigPictureStyleInformation.bigPicture, bigPictureStyleInformation.bigPictureBitmapSource));
        builder.J(bigPictureStyle);
    }

    private static void setBigTextStyle(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        BigTextStyleInformation bigTextStyleInformation = (BigTextStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (bigTextStyleInformation.bigText != null) {
            bigTextStyle.n(bigTextStyleInformation.htmlFormatBigText.booleanValue() ? fromHtml(bigTextStyleInformation.bigText) : bigTextStyleInformation.bigText);
        }
        if (bigTextStyleInformation.contentTitle != null) {
            bigTextStyle.o(bigTextStyleInformation.htmlFormatContentTitle.booleanValue() ? fromHtml(bigTextStyleInformation.contentTitle) : bigTextStyleInformation.contentTitle);
        }
        if (bigTextStyleInformation.summaryText != null) {
            bigTextStyle.p(bigTextStyleInformation.htmlFormatSummaryText.booleanValue() ? fromHtml(bigTextStyleInformation.summaryText) : bigTextStyleInformation.summaryText);
        }
        builder.J(bigTextStyle);
    }

    private void setCanScheduleExactNotifications(MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 31) {
            result.success(Boolean.TRUE);
        } else {
            result.success(Boolean.valueOf(getAlarmManager(this.applicationContext).canScheduleExactAlarms()));
        }
    }

    private static void setCategory(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        String str = notificationDetails.category;
        if (str != null) {
            builder.g(str);
        }
    }

    private static void setInboxStyle(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        InboxStyleInformation inboxStyleInformation = (InboxStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (inboxStyleInformation.contentTitle != null) {
            inboxStyle.o(inboxStyleInformation.htmlFormatContentTitle.booleanValue() ? fromHtml(inboxStyleInformation.contentTitle) : inboxStyleInformation.contentTitle);
        }
        if (inboxStyleInformation.summaryText != null) {
            inboxStyle.p(inboxStyleInformation.htmlFormatSummaryText.booleanValue() ? fromHtml(inboxStyleInformation.summaryText) : inboxStyleInformation.summaryText);
        }
        ArrayList<String> arrayList = inboxStyleInformation.lines;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                inboxStyle.n(inboxStyleInformation.htmlFormatLines.booleanValue() ? fromHtml(next) : next);
            }
        }
        builder.J(inboxStyle);
    }

    private static void setLights(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.enableLights) && notificationDetails.ledOnMs != null && notificationDetails.ledOffMs != null) {
            builder.x(notificationDetails.ledColor.intValue(), notificationDetails.ledOnMs.intValue(), notificationDetails.ledOffMs.intValue());
        }
    }

    private static void setMediaStyle(NotificationCompat.Builder builder) {
        builder.J(new NotificationCompat.MediaStyle());
    }

    private static void setMessagingStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        MessagingStyleInformation messagingStyleInformation = (MessagingStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(buildPerson(context, messagingStyleInformation.person));
        messagingStyle.u(BooleanUtils.getValue(messagingStyleInformation.groupConversation));
        String str = messagingStyleInformation.conversationTitle;
        if (str != null) {
            messagingStyle.t(str);
        }
        ArrayList<MessageDetails> arrayList = messagingStyleInformation.messages;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<MessageDetails> it = messagingStyleInformation.messages.iterator();
            while (it.hasNext()) {
                messagingStyle.n(createMessage(context, it.next()));
            }
        }
        builder.J(messagingStyle);
    }

    private static void setProgress(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.showProgress)) {
            builder.D(notificationDetails.maxProgress.intValue(), notificationDetails.progress.intValue(), notificationDetails.indeterminate.booleanValue());
        }
    }

    private static void setSmallIcon(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.icon).booleanValue()) {
            builder.H(getDrawableResourceId(context, notificationDetails.icon));
            return;
        }
        String string = context.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).getString(DEFAULT_ICON, (String) null);
        if (StringUtils.isNullOrEmpty(string).booleanValue()) {
            builder.H(notificationDetails.iconResourceId.intValue());
        } else {
            builder.H(getDrawableResourceId(context, string));
        }
    }

    private static void setSound(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.playSound)) {
            builder.I(retrieveSoundResourceUri(context, notificationDetails.sound, notificationDetails.soundSource));
        } else {
            builder.I((Uri) null);
        }
    }

    private static void setStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        int i = AnonymousClass5.c[notificationDetails.style.ordinal()];
        if (i == 1) {
            setBigPictureStyle(context, notificationDetails, builder);
        } else if (i == 2) {
            setBigTextStyle(notificationDetails, builder);
        } else if (i == 3) {
            setInboxStyle(notificationDetails, builder);
        } else if (i == 4) {
            setMessagingStyle(context, notificationDetails, builder);
        } else if (i == 5) {
            setMediaStyle(builder);
        }
    }

    private static void setTimeoutAfter(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        Long l = notificationDetails.timeoutAfter;
        if (l != null) {
            builder.M(l.longValue());
        }
    }

    private static void setVibrationPattern(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.enableVibration)) {
            long[] jArr = notificationDetails.vibrationPattern;
            if (jArr != null && jArr.length > 0) {
                builder.O(jArr);
                return;
            }
            return;
        }
        builder.O(new long[]{0});
    }

    private static void setVisibility(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        int i;
        Integer num = notificationDetails.visibility;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue != 0) {
                i = 1;
                if (intValue != 1) {
                    if (intValue == 2) {
                        i = -1;
                    } else {
                        throw new IllegalArgumentException("Unknown index: " + notificationDetails.visibility);
                    }
                }
            } else {
                i = 0;
            }
            builder.P(i);
        }
    }

    private static void setupAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, j, pendingIntent);
        } else if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.c(alarmManager, 0, j, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.a(alarmManager, j, pendingIntent, pendingIntent);
        } else {
            alarmManager.set(0, j, pendingIntent);
        }
    }

    private static void setupAllowWhileIdleAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.d(alarmManager, 0, j, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.a(alarmManager, j, pendingIntent, pendingIntent);
        } else {
            AlarmManagerCompat.b(alarmManager, 0, j, pendingIntent);
        }
    }

    private static void setupNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        Integer num;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(notificationChannelDetails.id, notificationChannelDetails.name, notificationChannelDetails.importance.intValue());
        notificationChannel.setDescription(notificationChannelDetails.description);
        notificationChannel.setGroup(notificationChannelDetails.groupId);
        if (notificationChannelDetails.playSound.booleanValue()) {
            Integer num2 = notificationChannelDetails.audioAttributesUsage;
            notificationChannel.setSound(retrieveSoundResourceUri(context, notificationChannelDetails.sound, notificationChannelDetails.soundSource), new AudioAttributes.Builder().setUsage(num2 != null ? num2.intValue() : 5).build());
        } else {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        }
        notificationChannel.enableVibration(BooleanUtils.getValue(notificationChannelDetails.enableVibration));
        long[] jArr = notificationChannelDetails.vibrationPattern;
        if (jArr != null && jArr.length > 0) {
            notificationChannel.setVibrationPattern(jArr);
        }
        boolean value = BooleanUtils.getValue(notificationChannelDetails.enableLights);
        notificationChannel.enableLights(value);
        if (value && (num = notificationChannelDetails.ledColor) != null) {
            notificationChannel.setLightColor(num.intValue());
        }
        notificationChannel.setShowBadge(BooleanUtils.getValue(notificationChannelDetails.showBadge));
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private void show(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            showNotification(this.applicationContext, extractNotificationDetails);
            result.success((Object) null);
        }
    }

    public static void showNotification(Context context, NotificationDetails notificationDetails) {
        Notification createNotification = createNotification(context, notificationDetails);
        NotificationManagerCompat notificationManager = getNotificationManager(context);
        String str = notificationDetails.tag;
        if (str != null) {
            notificationManager.l(str, notificationDetails.id.intValue(), createNotification);
        } else {
            notificationManager.k(notificationDetails.id.intValue(), createNotification);
        }
    }

    private void startForegroundService(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.argument("notificationData");
        Integer num = (Integer) methodCall.argument("startType");
        ArrayList arrayList = (ArrayList) methodCall.argument("foregroundServiceTypes");
        if (arrayList != null && arrayList.size() == 0) {
            result.error("ARGUMENT_ERROR", "If foregroundServiceTypes is non-null it must not be empty!", (Object) null);
        } else if (map == null || num == null) {
            result.error("ARGUMENT_ERROR", "An argument passed to startForegroundService was null!", (Object) null);
        } else {
            NotificationDetails extractNotificationDetails = extractNotificationDetails(result, map);
            if (extractNotificationDetails == null) {
                return;
            }
            if (extractNotificationDetails.id.intValue() != 0) {
                ForegroundServiceStartParameter foregroundServiceStartParameter = new ForegroundServiceStartParameter(extractNotificationDetails, num.intValue(), arrayList);
                Intent intent = new Intent(this.applicationContext, ForegroundService.class);
                intent.putExtra(ForegroundServiceStartParameter.EXTRA, foregroundServiceStartParameter);
                ContextCompat.startForegroundService(this.applicationContext, intent);
                result.success((Object) null);
                return;
            }
            result.error("ARGUMENT_ERROR", "The id of the notification for a foreground service must not be 0!", (Object) null);
        }
    }

    private void stopForegroundService(MethodChannel.Result result) {
        this.applicationContext.stopService(new Intent(this.applicationContext, ForegroundService.class));
        result.success((Object) null);
    }

    private Integer tryParseInt(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private void zonedSchedule(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            if (extractNotificationDetails.matchDateTimeComponents != null) {
                extractNotificationDetails.scheduledDateTime = getNextFireDateMatchingDateTimeComponents(extractNotificationDetails);
            }
            try {
                zonedScheduleNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                result.success((Object) null);
            } catch (PluginException e) {
                result.error(e.code, e.getMessage(), (Object) null);
            }
        }
    }

    private static void zonedScheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        String nextFireDate = getNextFireDate(notificationDetails);
        if (nextFireDate != null) {
            notificationDetails.scheduledDateTime = nextFireDate;
            zonedScheduleNotification(context, notificationDetails, Boolean.TRUE);
        }
    }

    private static void zonedScheduleNextNotificationMatchingDateComponents(Context context, NotificationDetails notificationDetails) {
        String nextFireDateMatchingDateTimeComponents = getNextFireDateMatchingDateTimeComponents(notificationDetails);
        if (nextFireDateMatchingDateTimeComponents != null) {
            notificationDetails.scheduledDateTime = nextFireDateMatchingDateTimeComponents;
            zonedScheduleNotification(context, notificationDetails, Boolean.TRUE);
        }
    }

    private static void zonedScheduleNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        String json = buildGson().toJson((Object) notificationDetails);
        Intent intent = new Intent(context, ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        setupAlarm(notificationDetails, getAlarmManager(context), ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), ZoneId.of(notificationDetails.timeZoneName)).toInstant().toEpochMilli(), getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent));
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    public boolean onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 1 && i != 2 && i != 3) {
            return false;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingExactAlarmsPermission && i == 2 && Build.VERSION.SDK_INT >= 31) {
            this.callback.b(getAlarmManager(this.applicationContext).canScheduleExactAlarms());
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingFullScreenIntentPermission && i == 3 && Build.VERSION.SDK_INT >= 34) {
            this.callback.b(((NotificationManager) this.applicationContext.getSystemService("notification")).canUseFullScreenIntent());
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        return true;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
        Activity activity = activityPluginBinding.getActivity();
        this.mainActivity = activity;
        Intent intent = activity.getIntent();
        if (!launchedActivityFromHistory(intent) && SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            processForegroundNotificationAction(intent, extractNotificationResponseMap(intent));
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), METHOD_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
        this.applicationContext = null;
    }

    public void onMethodCall(MethodCall methodCall, @NonNull final MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2096263152:
                if (str.equals(STOP_FOREGROUND_SERVICE)) {
                    c = 0;
                    break;
                }
                break;
            case -2041662895:
                if (str.equals(GET_NOTIFICATION_CHANNELS_METHOD)) {
                    c = 1;
                    break;
                }
                break;
            case -1873731438:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c = 2;
                    break;
                }
                break;
            case -1785484984:
                if (str.equals(REQUEST_NOTIFICATIONS_PERMISSION_METHOD)) {
                    c = 3;
                    break;
                }
                break;
            case -1367724422:
                if (str.equals(CANCEL_METHOD)) {
                    c = 4;
                    break;
                }
                break;
            case -1108601471:
                if (str.equals(REQUEST_EXACT_ALARMS_PERMISSION_METHOD)) {
                    c = 5;
                    break;
                }
                break;
            case -950516363:
                if (str.equals(REQUEST_FULL_SCREEN_INTENT_PERMISSION_METHOD)) {
                    c = 6;
                    break;
                }
                break;
            case -799130106:
                if (str.equals(PENDING_NOTIFICATION_REQUESTS_METHOD)) {
                    c = 7;
                    break;
                }
                break;
            case -208611345:
                if (str.equals(GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD)) {
                    c = 8;
                    break;
                }
                break;
            case 3529469:
                if (str.equals(SHOW_METHOD)) {
                    c = 9;
                    break;
                }
                break;
            case 6625712:
                if (str.equals(PERIODICALLY_SHOW_METHOD)) {
                    c = 10;
                    break;
                }
                break;
            case 116003316:
                if (str.equals(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD)) {
                    c = 11;
                    break;
                }
                break;
            case 476547271:
                if (str.equals(CANCEL_ALL_METHOD)) {
                    c = 12;
                    break;
                }
                break;
            case 548573423:
                if (str.equals(ZONED_SCHEDULE_METHOD)) {
                    c = 13;
                    break;
                }
                break;
            case 767006947:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c = 14;
                    break;
                }
                break;
            case 825311171:
                if (str.equals(GET_CALLBACK_HANDLE_METHOD)) {
                    c = 15;
                    break;
                }
                break;
            case 871091088:
                if (str.equals(INITIALIZE_METHOD)) {
                    c = 16;
                    break;
                }
                break;
            case 891942317:
                if (str.equals(ARE_NOTIFICATIONS_ENABLED_METHOD)) {
                    c = 17;
                    break;
                }
                break;
            case 972029712:
                if (str.equals(CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD)) {
                    c = 18;
                    break;
                }
                break;
            case 1008472557:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_METHOD)) {
                    c = 19;
                    break;
                }
                break;
            case 1207771056:
                if (str.equals(START_FOREGROUND_SERVICE)) {
                    c = 20;
                    break;
                }
                break;
            case 1594833996:
                if (str.equals(GET_ACTIVE_NOTIFICATIONS_METHOD)) {
                    c = 21;
                    break;
                }
                break;
            case 1653467900:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_METHOD)) {
                    c = 22;
                    break;
                }
                break;
            case 2147197514:
                if (str.equals(PERIODICALLY_SHOW_WITH_DURATION)) {
                    c = 23;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                stopForegroundService(result);
                return;
            case 1:
                getNotificationChannels(result);
                return;
            case 2:
                deleteNotificationChannelGroup(methodCall, result);
                return;
            case 3:
                requestNotificationsPermission(new PermissionRequestListener() {
                    public void a(String str) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str, (Object) null);
                    }

                    public void b(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }
                });
                return;
            case 4:
                cancel(methodCall, result);
                return;
            case 5:
                requestExactAlarmsPermission(new PermissionRequestListener() {
                    public void a(String str) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str, (Object) null);
                    }

                    public void b(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }
                });
                return;
            case 6:
                requestFullScreenIntentPermission(new PermissionRequestListener() {
                    public void a(String str) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str, (Object) null);
                    }

                    public void b(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }
                });
                return;
            case 7:
                pendingNotificationRequests(result);
                return;
            case 8:
                getNotificationAppLaunchDetails(result);
                return;
            case 9:
                show(methodCall, result);
                return;
            case 10:
                repeat(methodCall, result);
                return;
            case 11:
                getActiveNotificationMessagingStyle(methodCall, result);
                return;
            case 12:
                cancelAllNotifications(result);
                return;
            case 13:
                zonedSchedule(methodCall, result);
                return;
            case 14:
                createNotificationChannelGroup(methodCall, result);
                return;
            case 15:
                getCallbackHandle(result);
                return;
            case 16:
                initialize(methodCall, result);
                return;
            case 17:
                areNotificationsEnabled(result);
                return;
            case 18:
                setCanScheduleExactNotifications(result);
                return;
            case 19:
                deleteNotificationChannel(methodCall, result);
                return;
            case 20:
                startForegroundService(methodCall, result);
                return;
            case 21:
                getActiveNotifications(result);
                return;
            case 22:
                createNotificationChannel(methodCall, result);
                return;
            case 23:
                repeat(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public boolean onNewIntent(Intent intent) {
        Activity activity;
        boolean booleanValue = sendNotificationPayloadMessage(intent).booleanValue();
        if (booleanValue && (activity = this.mainActivity) != null) {
            activity.setIntent(intent);
        }
        return booleanValue;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z = false;
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingNotificationPermission && i == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            this.callback.b(z);
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        return z;
    }

    public void requestExactAlarmsPermission(@NonNull PermissionRequestListener permissionRequestListener) {
        PermissionRequestProgress permissionRequestProgress2 = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress3 = PermissionRequestProgress.None;
        if (permissionRequestProgress2 != permissionRequestProgress3) {
            permissionRequestListener.a(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT < 31) {
            permissionRequestListener.b(true);
        } else if (!getAlarmManager(this.applicationContext).canScheduleExactAlarms()) {
            this.permissionRequestProgress = PermissionRequestProgress.RequestingExactAlarmsPermission;
            Activity activity = this.mainActivity;
            activity.startActivityForResult(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + this.applicationContext.getPackageName())), 2);
        } else {
            this.callback.b(true);
            this.permissionRequestProgress = permissionRequestProgress3;
        }
    }

    public void requestFullScreenIntentPermission(@NonNull PermissionRequestListener permissionRequestListener) {
        PermissionRequestProgress permissionRequestProgress2 = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress3 = PermissionRequestProgress.None;
        if (permissionRequestProgress2 != permissionRequestProgress3) {
            permissionRequestListener.a(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT >= 34) {
            getAlarmManager(this.applicationContext);
            if (!((NotificationManager) this.applicationContext.getSystemService("notification")).canUseFullScreenIntent()) {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingFullScreenIntentPermission;
                Activity activity = this.mainActivity;
                activity.startActivityForResult(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + this.applicationContext.getPackageName())), 3);
                return;
            }
            this.callback.b(true);
            this.permissionRequestProgress = permissionRequestProgress3;
            return;
        }
        permissionRequestListener.b(true);
    }

    public void requestNotificationsPermission(@NonNull PermissionRequestListener permissionRequestListener) {
        PermissionRequestProgress permissionRequestProgress2 = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress3 = PermissionRequestProgress.None;
        if (permissionRequestProgress2 != permissionRequestProgress3) {
            permissionRequestListener.a(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT < 33) {
            this.callback.b(NotificationManagerCompat.g(this.mainActivity).a());
        } else if (ContextCompat.checkSelfPermission(this.mainActivity, "android.permission.POST_NOTIFICATIONS") == 0) {
            this.callback.b(true);
            this.permissionRequestProgress = permissionRequestProgress3;
        } else {
            this.permissionRequestProgress = PermissionRequestProgress.RequestingNotificationPermission;
            ActivityCompat.e(this.mainActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }
    }
}
