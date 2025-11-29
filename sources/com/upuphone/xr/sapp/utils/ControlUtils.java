package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.assistant.VoiceAssistantDelegate;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.entity.AdjustmentMode;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.entity.GlassFontSize;
import com.upuphone.xr.sapp.entity.ReqGlassData;
import com.upuphone.xr.sapp.entity.StabilizationMode;
import com.upuphone.xr.sapp.entity.StandbyWidgetOrderInfo;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.view.GenericMenuView;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.encrypt.DigestUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010\u001bJ\u0015\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0019¢\u0006\u0004\b!\u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0019¢\u0006\u0004\b\"\u0010\u001eJ\r\u0010#\u001a\u00020\u0019¢\u0006\u0004\b#\u0010\u001bJ\u0015\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0019¢\u0006\u0004\b%\u0010\u001eJ\r\u0010&\u001a\u00020\u0019¢\u0006\u0004\b&\u0010\u001bJ\r\u0010'\u001a\u00020\u0019¢\u0006\u0004\b'\u0010\u001bJ\r\u0010(\u001a\u00020\u000f¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0004¢\u0006\u0004\b0\u0010\u0014J\u0015\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0019¢\u0006\u0004\b2\u0010\u001eJ\r\u00103\u001a\u00020\u0019¢\u0006\u0004\b3\u0010\u001bJ\u001f\u00107\u001a\u00020\u00072\u0006\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u00020\u0004¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u000204¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\u0014J\u0015\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010/J\r\u0010B\u001a\u00020<¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u0004\u0018\u00010<¢\u0006\u0004\bD\u0010CJ\u0015\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010/J\u001d\u0010G\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\bG\u0010HJ%\u0010K\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bM\u0010/J\u0015\u0010N\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bN\u0010/J\u001d\u0010Q\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bS\u0010/J%\u0010U\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\bU\u0010\rJ\u0015\u0010V\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bV\u0010/J\u001d\u0010W\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bY\u0010/J%\u0010[\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020Z2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b[\u0010\\J\u0015\u0010]\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b]\u0010/J\u001d\u0010`\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aJ\u0015\u0010b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bb\u0010/J\u001d\u0010c\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\bc\u0010XJG\u0010g\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042(\u00105\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`f0d2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\bg\u0010hJ\u0015\u0010i\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bi\u0010/J\u0015\u0010j\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bj\u0010/J\u0015\u0010k\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bk\u0010/J%\u0010l\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\bl\u0010mJ\u001d\u0010o\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u0019¢\u0006\u0004\bo\u0010XJ\u0017\u0010p\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bp\u0010/J\u001d\u0010r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u0019¢\u0006\u0004\br\u0010XJ\u0015\u0010s\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bs\u0010/J\u001d\u0010u\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010t\u001a\u00020\u0019¢\u0006\u0004\bu\u0010XJ\u0017\u0010v\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bv\u0010/J\u001f\u0010x\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010w\u001a\u00020\u000f¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bz\u0010/J\u001f\u0010{\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\b{\u0010\tJ\u0015\u0010|\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b|\u0010/J\u0015\u0010}\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\b}\u0010/J\r\u0010~\u001a\u00020\u0004¢\u0006\u0004\b~\u0010\u0014J\u0015\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010/J\u001a\u0010\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u0001\u0010/J\u0017\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\b\u0001\u0010/J\u001c\u0010\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u0001\u0010XJ\u001a\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\b\u0001\u0010/J\u0018\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u0001\u0010\u001eJ\u000f\u0010\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u0001\u0010\u001bR\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bs\u0010\u0001R,\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001*\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u001f\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b&\u0010\u0001R\u0018\u0010¡\u0001\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b~\u0010 \u0001¨\u0006¢\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/utils/ControlUtils;", "", "<init>", "()V", "", "pkg", "msg", "", "M", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "listener", "N", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "O", "", "seconds", "v", "(I)Ljava/lang/String;", "u", "()Ljava/lang/String;", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "r", "()Ljava/util/List;", "", "D", "()Z", "state", "n0", "(Z)V", "d", "selected", "g0", "u0", "B", "auto", "h0", "e", "C", "s", "()I", "time", "q0", "(I)V", "lan", "o0", "(Ljava/lang/String;)V", "y", "isSelected", "r0", "E", "", "array", "id", "s0", "([FLjava/lang/String;)V", "w", "()[F", "x", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "k0", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;)V", "deviceInfoStr", "l0", "g", "()Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "o", "glassName", "j0", "b", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "language", "country", "V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "j", "J", "Lcom/upuphone/xr/sapp/entity/GlassFontSize;", "fontSize", "T", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/GlassFontSize;)V", "G", "appPackage", "Q", "H", "R", "(Ljava/lang/String;Z)V", "L", "Lcom/upuphone/xr/sapp/entity/StabilizationMode;", "d0", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/StabilizationMode;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "F", "Lcom/upuphone/xr/sapp/entity/AdjustmentMode;", "mode", "P", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/AdjustmentMode;)V", "K", "c0", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "v0", "(Ljava/lang/String;Ljava/util/List;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "w0", "x0", "I", "S", "(Ljava/lang/String;ZLcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "noDisturb", "X", "l", "airMode", "U", "c", "wearDetectionMode", "Z", "i", "screenOffTime", "Y", "(Ljava/lang/String;I)V", "t", "W", "h", "i0", "f", "z", "Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "info", "e0", "(Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;)V", "m", "()Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "ringName", "m0", "b0", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "f0", "(Lcom/upuphone/xr/sapp/entity/UnicronInfo;)V", "n", "()Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "q", "packageName", "musicTpControlMode", "a0", "k", "p0", "p", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "mGson", "Lcom/upuphone/xr/sapp/MainApplication;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Lkotlin/properties/ReadOnlyProperty;", "A", "(Lcom/upuphone/xr/sapp/MainApplication;)Landroidx/datastore/core/DataStore;", "wakeUpDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "mMessageCallback", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nControlUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControlUtils.kt\ncom/upuphone/xr/sapp/utils/ControlUtils\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,1240:1\n29#2,5:1241\n29#2,5:1246\n29#2,5:1251\n*S KotlinDebug\n*F\n+ 1 ControlUtils.kt\ncom/upuphone/xr/sapp/utils/ControlUtils\n*L\n340#1:1241,5\n352#1:1246,5\n1192#1:1251,5\n*E\n"})
public final class ControlUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ControlUtils f7858a;
    public static final /* synthetic */ KProperty[] b = {Reflection.property2(new PropertyReference2Impl(ControlUtils.class, "wakeUpDataStore", "getWakeUpDataStore(Lcom/upuphone/xr/sapp/MainApplication;)Landroidx/datastore/core/DataStore;", 0))};
    public static final Gson c = new Gson();
    public static final ReadOnlyProperty d = PreferenceDataStoreDelegateKt.b("assistant_setting", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    public static final DataStore e;
    public static SendMessageListener f = new ControlUtils$mMessageCallback$1();

    static {
        ControlUtils controlUtils = new ControlUtils();
        f7858a = controlUtils;
        e = controlUtils.A(MainApplication.k.f());
    }

    public static /* synthetic */ void t0(ControlUtils controlUtils, float[] fArr, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        controlUtils.s0(fArr, str);
    }

    public final DataStore A(MainApplication mainApplication) {
        return (DataStore) d.getValue(mainApplication, b[0]);
    }

    public final boolean B() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "set_wear_detection_mode", Boolean.TRUE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "call_voice_auto_adjust", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final boolean D() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "model_no_disturb", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    public final boolean E() {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "selected_voiceprint_privacy_policy", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final void F(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_image_adjustment_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void G(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_app_fast_open")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void H(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_auto_brightness_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void I(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_demo_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void J(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_font_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void K(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_glass_sound_effect_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void L(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "get_image_stabilization_mode")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void M(String str, String str2) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg(str);
        starryNetMessage.setMessage(str2);
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, f);
    }

    public final void N(String str, String str2, SendMessageListener sendMessageListener) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg(str);
        starryNetMessage.setMessage(str2);
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, sendMessageListener);
    }

    public final void O(String str, String str2) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg(str);
        starryNetMessage.setMessage(str2);
        starryNetMessage.setReceiverPkg(AssistantConstants.PKG_NAME_NAV);
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, f);
    }

    public final void P(String str, AdjustmentMode adjustmentMode) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(adjustmentMode, RtspHeaders.Values.MODE);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_image_adjustment_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, adjustmentMode))));
        DataStoreUtils.e.a().p("set_image_adjustment_mode", new Gson().toJson((Object) adjustmentMode), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void Q(String str, String str2, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(str2, "appPackage");
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_app_fast_open"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, str2))));
        DataStoreUtils.e.a().p("set_app_fast_open", str2, true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        N(str, json, sendMessageListener);
    }

    public final void R(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_auto_brightness_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, Boolean.valueOf(z)))));
        DataStoreUtils.e.a().p("set_auto_brightness_mode", Boolean.valueOf(z), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void S(String str, boolean z, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_demo_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, Boolean.valueOf(z)))));
        DataStoreUtils.e.a().p("set_glass_sound_effect_mode", Boolean.valueOf(z), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        N(str, json, sendMessageListener);
    }

    public final void T(String str, GlassFontSize glassFontSize) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(glassFontSize, "fontSize");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_font_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, Integer.valueOf(glassFontSize.ordinal() + 1)))));
        DataStoreUtils.e.a().p("set_font_mode", Integer.valueOf(glassFontSize.ordinal() + 1), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void U(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        HashMap hashMap = new HashMap();
        hashMap.put("air_mode", Boolean.valueOf(z));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_air_mode");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        String json = c.toJson((Object) hashMap3);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
        c(str);
    }

    public final void V(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(str2, "language");
        Intrinsics.checkNotNullParameter(str3, "country");
        HashMap hashMap = new HashMap();
        hashMap.put("language", str2);
        hashMap.put("country", str3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_language");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        DataStoreUtils.e.a().o("set_language", new Gson().toJson((Object) hashMap));
        String json = c.toJson((Object) hashMap3);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void W(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "glassName");
        if (str != null) {
            ControlUtils controlUtils = f7858a;
            controlUtils.j0(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("device_name", str2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WebJs.ACTION, "set_device_name");
            hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(WebJs.ACTION, "system");
            hashMap3.put("data", hashMap2);
            String json = c.toJson((Object) hashMap3);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
            controlUtils.h(str);
        }
    }

    public final void X(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        DataStoreUtils.e.a().p("set_zen_mode", Boolean.valueOf(z), true);
        HashMap hashMap = new HashMap();
        hashMap.put("zen_mode", Boolean.valueOf(z));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_zen_mode");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        if (NaviManager.getInstance(GlobalExtKt.f()).isNaving()) {
            String json = c.toJson((Object) hashMap3);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            O(str, json);
        } else {
            String json2 = c.toJson((Object) hashMap3);
            Intrinsics.checkNotNullExpressionValue(json2, "toJson(...)");
            M(str, json2);
        }
        l(str);
    }

    public final void Y(String str, int i) {
        DataStoreUtils.e.a().p("set_screen_off_time", Integer.valueOf(i), true);
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_off_time", Integer.valueOf(i));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WebJs.ACTION, "set_screen_off_time");
            hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(WebJs.ACTION, "system");
            hashMap3.put("data", hashMap2);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) hashMap3);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
            controlUtils.t(str);
        }
    }

    public final void Z(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        DataStoreUtils.e.a().p("set_wear_detection_mode", Boolean.valueOf(z), true);
        HashMap hashMap = new HashMap();
        hashMap.put("wear_detection_mode", Boolean.valueOf(z));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_wear_detection_mode");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        String json = c.toJson((Object) hashMap3);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
        i(str);
    }

    public final void a0(String str, boolean z) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("music_tp_control_mode", Boolean.valueOf(z));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WebJs.ACTION, "set_music_tp_control_mode");
            hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(WebJs.ACTION, "system");
            hashMap3.put("data", hashMap2);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) hashMap3);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
            controlUtils.k(str);
        }
    }

    public final void b(String str, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("do_recovery");
        ReqGlassData reqGlassData = new ReqGlassData();
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = c.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        N(str, json, sendMessageListener);
    }

    public final void b0(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Map mapOf = MapsKt.mapOf(TuplesKt.to(WebJs.ACTION, "set_unicron_name"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, MapsKt.mapOf(TuplesKt.to("dev_name", m().getDevName()))));
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ControlUtils", "setRingName msg = " + mapOf);
        String json = c.toJson((Object) mapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
        z(str);
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_air_mode");
        ReqGlassData reqGlassData = new ReqGlassData();
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = c.toJson((Object) reqGlassData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void c0(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_glass_sound_effect_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, Boolean.valueOf(z)))));
        DataStoreUtils.e.a().p("set_glass_sound_effect_mode", Boolean.valueOf(z), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final boolean d() {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "model_air", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final void d0(String str, StabilizationMode stabilizationMode, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(stabilizationMode, "state");
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_image_stabilization_mode"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, stabilizationMode))));
        DataStoreUtils.e.a().p("set_image_stabilization_mode", new Gson().toJson((Object) stabilizationMode), true);
        String json = c.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        N(str, json, sendMessageListener);
    }

    public final boolean e() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "auto_bri_change", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    public final void e0(UnicronBatteryInfo unicronBatteryInfo) {
        Intrinsics.checkNotNullParameter(unicronBatteryInfo, "info");
        DataStoreUtils.e.a().o("unicron_info", c.toJson((Object) unicronBatteryInfo));
    }

    public final String f() {
        DataStoreUtils a2 = DataStoreUtils.e.a();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        return (String) DataStoreUtils.i(a2, "starry_net_glass_name", bool.booleanValue() ? "MYVU AR" : "MYVU", (Context) null, 4, (Object) null);
    }

    public final void f0(UnicronInfo unicronInfo) {
        if (unicronInfo == null) {
            DataStoreUtils.e.a().o("unicron_model_info", "");
        } else {
            DataStoreUtils.e.a().o("unicron_model_info", c.toJson((Object) unicronInfo));
        }
    }

    public final DeviceInfo g() {
        Object obj;
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "device_info", "", (Context) null, 4, (Object) null);
        if (TextUtils.isEmpty(str)) {
            return new DeviceInfo("AR Glasses", "XJ", "", "1.000", "", "", "GB", "GB", "");
        }
        JsonUtils jsonUtils = JsonUtils.f7893a;
        Type type = new ControlUtils$getDeviceInfo$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(str, type);
        }
        Intrinsics.checkNotNull(obj);
        return (DeviceInfo) obj;
    }

    public final void g0(boolean z) {
        DataStoreUtils.e.a().o("model_air", Boolean.valueOf(z));
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_device_info");
        ReqGlassData reqGlassData = new ReqGlassData();
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = c.toJson((Object) reqGlassData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }

    public final void h0(boolean z) {
        DataStoreUtils.e.a().p("auto_bri_change", Boolean.valueOf(z), true);
    }

    public final void i(String str) {
        if (str != null) {
            ReqGlassData.Data data = new ReqGlassData.Data();
            data.setAction("get_wear_detection_mode");
            ReqGlassData reqGlassData = new ReqGlassData();
            reqGlassData.setAction("system");
            reqGlassData.setData(data);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) reqGlassData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
        }
    }

    public final void i0(String str) {
        Intrinsics.checkNotNullParameter(str, "glassName");
        DataStoreUtils.e.a().o("starry_net_glass_name", str);
    }

    public final void j(String str) {
        if (str != null) {
            ReqGlassData.Data data = new ReqGlassData.Data();
            data.setAction("get_language");
            ReqGlassData reqGlassData = new ReqGlassData();
            reqGlassData.setAction("system");
            reqGlassData.setData(data);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) reqGlassData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
        }
    }

    public final void j0(String str) {
        Intrinsics.checkNotNullParameter(str, "glassName");
        DeviceInfo g = g();
        g.setName(str);
        k0(g);
    }

    public final void k(String str) {
        if (str != null) {
            ReqGlassData.Data data = new ReqGlassData.Data();
            data.setAction("get_music_tp_control_mode");
            ReqGlassData reqGlassData = new ReqGlassData();
            reqGlassData.setAction("system");
            reqGlassData.setData(data);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) reqGlassData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
        }
    }

    public final void k0(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        l0(JsonUtils.f7893a.d(deviceInfo));
        String serialNo = deviceInfo.getSerialNo();
        if (serialNo != null) {
            String l = DigestUtils.l("RhdNS`Z?" + serialNo);
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            if (cacheAbility != null) {
                String name = cacheAbility.getClass().getName();
                Intrinsics.checkNotNull(name);
                if (StringsKt.contains$default((CharSequence) name, (CharSequence) "Proxy", false, 2, (Object) null)) {
                    VoiceAssistantDelegate.f6640a.d(GlobalExtKt.f(), "IotDeviceId", l);
                }
            }
            if (cacheAbility != null) {
                cacheAbility.persist("IotDeviceId", l);
            }
        }
        DataTrackUtil.f7875a.b(deviceInfo.getSerialNo(), deviceInfo.getModel(), deviceInfo.getRomVersion());
    }

    public final void l(String str) {
        if (str != null) {
            ReqGlassData.Data data = new ReqGlassData.Data();
            data.setAction("get_zen_mode");
            ReqGlassData reqGlassData = new ReqGlassData();
            reqGlassData.setAction("system");
            reqGlassData.setData(data);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) reqGlassData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
        }
    }

    public final void l0(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceInfoStr");
        DataStoreUtils.e.a().o("device_info", str);
    }

    public final UnicronBatteryInfo m() {
        try {
            Object fromJson = c.fromJson((String) DataStoreUtils.i(DataStoreUtils.e.a(), "unicron_info", "", (Context) null, 4, (Object) null), UnicronBatteryInfo.class);
            Intrinsics.checkNotNull(fromJson);
            return (UnicronBatteryInfo) fromJson;
        } catch (Exception unused) {
            return new UnicronBatteryInfo(0, false, "", false, "", false);
        }
    }

    public final void m0(String str) {
        Intrinsics.checkNotNullParameter(str, "ringName");
        UnicronBatteryInfo m = m();
        m.setDevName(str);
        e0(m);
    }

    public final UnicronInfo n() {
        try {
            Object fromJson = c.fromJson((String) DataStoreUtils.i(DataStoreUtils.e.a(), "unicron_model_info", "{}", (Context) null, 4, (Object) null), UnicronInfo.class);
            Intrinsics.checkNotNull(fromJson);
            return (UnicronInfo) fromJson;
        } catch (Exception unused) {
            return new UnicronInfo("", "", "", 0, "");
        }
    }

    public final void n0(boolean z) {
        DataStoreUtils.e.a().p("model_no_disturb", Boolean.valueOf(z), true);
    }

    public final DeviceInfo o() {
        Object obj;
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "device_info", "", (Context) null, 4, (Object) null);
        if (str == null || str.length() == 0) {
            return null;
        }
        JsonUtils jsonUtils = JsonUtils.f7893a;
        Type type = new ControlUtils$getSavedDeviceInfo$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(str, type);
        }
        return (DeviceInfo) obj;
    }

    public final void o0(String str) {
        Intrinsics.checkNotNullParameter(str, "lan");
        DataStoreUtils.e.a().o("glass_language", str);
    }

    public final boolean p() {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "music_tp_control_mode", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final void p0(boolean z) {
        DataStoreUtils.e.a().o("music_tp_control_mode", Boolean.valueOf(z));
    }

    public final UnicronInfo q() {
        Object obj;
        try {
            String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "unicron_model_info", "", (Context) null, 4, (Object) null);
            JsonUtils jsonUtils = JsonUtils.f7893a;
            Type type = new ControlUtils$getSavedUnicronInfo$$inlined$fromJson$1().getType();
            if (!Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass())) {
                if (!Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                    Intrinsics.checkNotNull(type);
                    obj = jsonUtils.a(str, type);
                    return (UnicronInfo) obj;
                }
            }
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
            return (UnicronInfo) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void q0(int i) {
        DataStoreUtils.e.a().o("screen_off_time", Integer.valueOf(i));
    }

    public final List r() {
        int intValue = ((Number) DataStoreUtils.i(DataStoreUtils.e.a(), "screen_off_time", 30, (Context) null, 4, (Object) null)).intValue();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (DynamicOperateUtil.f7880a.h() >= 3) {
            arrayList.add(new GenericMenuView.MenuItem(v(15), 15, intValue == 15));
        }
        arrayList.add(new GenericMenuView.MenuItem(v(30), 30, intValue == 30));
        arrayList.add(new GenericMenuView.MenuItem(v(60), 60, intValue == 60));
        arrayList.add(new GenericMenuView.MenuItem(v(120), 120, intValue == 120));
        if (VersionMatchHelper.e(VersionMatchHelper.f7930a, false, false, false, (String) null, (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.3")), (String) null, 92, (Object) null)) {
            arrayList.add(new GenericMenuView.MenuItem(v(300), 300, intValue == 300));
            arrayList.add(new GenericMenuView.MenuItem(v(600), 600, intValue == 600));
            String v = v(3600);
            if (intValue == 3600) {
                z = true;
            }
            arrayList.add(new GenericMenuView.MenuItem(v, 3600, z));
        }
        return arrayList;
    }

    public final void r0(boolean z) {
        DataStoreUtils.e.a().o("selected_voiceprint_privacy_policy", Boolean.valueOf(z));
    }

    public final int s() {
        return ((Number) DataStoreUtils.i(DataStoreUtils.e.a(), "screen_off_time", 30, (Context) null, 4, (Object) null)).intValue();
    }

    public final void s0(float[] fArr, String str) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        Intrinsics.checkNotNullParameter(str, "id");
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o("separate_role_voiceprint", SappArrayExtKt.e(SappKeyStoreHelper.f7913a.b(SappArrayExtKt.g(fArr))));
        companion.a().o("separate_role_voiceprint_id", str);
    }

    public final void t(String str) {
        if (str != null) {
            ReqGlassData.Data data = new ReqGlassData.Data();
            data.setAction("get_screen_off_time");
            ReqGlassData reqGlassData = new ReqGlassData();
            reqGlassData.setAction("system");
            reqGlassData.setData(data);
            ControlUtils controlUtils = f7858a;
            String json = c.toJson((Object) reqGlassData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            controlUtils.M(str, json);
        }
    }

    public final String u() {
        return v(s());
    }

    public final void u0(boolean z) {
        DataStoreUtils.e.a().p("set_wear_detection_mode", Boolean.valueOf(z), true);
    }

    public final String v(int i) {
        if (i < 3600) {
            int i2 = i / 60;
            if (i2 == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_sec), Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            } else if (i2 == 1) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_min), Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                return format2;
            } else {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_mins), Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                return format3;
            }
        } else {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_hour), Arrays.copyOf(new Object[]{String.valueOf(i / 3600)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            return format4;
        }
    }

    public final void v0(String str, List list, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(list, "array");
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String json = c.toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "sync_clone_data"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, list)))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        N(str, json, sendMessageListener);
    }

    public final float[] w() {
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "separate_role_voiceprint", "", (Context) null, 4, (Object) null);
        return StringsKt.isBlank(str) ? new float[0] : SappArrayExtKt.i(SappKeyStoreHelper.f7913a.a(SappArrayExtKt.a(str)));
    }

    public final void w0(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String str2 = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "standby_widget_order", "", true, (Context) null, 8, (Object) null);
        if (str2.length() > 0) {
            HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", GsonHelper.fromJson(str2, StandbyWidgetOrderInfo.class)));
            Gson gson = c;
            String json = gson.toJson((Object) hashMapOf);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            M(str, json);
            ULog.Delegate delegate = ULog.f6446a;
            String json2 = gson.toJson((Object) hashMapOf);
            delegate.a("StandbyPositionFragment", "syncStandbyWidgetOrderData:" + json2);
        }
    }

    public final String x() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "separate_role_voiceprint_id", "UnKnown_VprintId", (Context) null, 4, (Object) null);
    }

    public final void x0(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "set_standby_position"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, MapsKt.hashMapOf(TuplesKt.to("standby_position", Integer.valueOf(((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "set_standby_position", 4, true, (Context) null, 8, (Object) null)).intValue())))))));
        Gson gson = c;
        String json = gson.toJson((Object) hashMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
        ULog.Delegate delegate = ULog.f6446a;
        String json2 = gson.toJson((Object) hashMapOf);
        delegate.a("StandbyPositionFragment", "syncStandbyWidgetPositionData:" + json2);
    }

    public final String y() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "glass_language", "zh-CN", (Context) null, 4, (Object) null);
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        String json = c.toJson((Object) MapsKt.mapOf(TuplesKt.to(WebJs.ACTION, "unicron_battery"), TuplesKt.to(AccountConstantKt.RESPONSE_VALUE, MapsKt.mapOf(TuplesKt.to(WebJs.ACTION, "get_unicron_battery")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        M(str, json);
    }
}
