package com.upuphone.xr.sapp.glass;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.i8.e;
import com.honey.account.view.web.WebJs;
import com.meizu.common.widget.CircleProgressBar;
import com.tencent.mmkv.MMKV;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.star.download.manager.Utils;
import com.upuphone.star.fota.phone.GlassCheckUpdateResult;
import com.upuphone.star.fota.phone.GlassCheckUpdateResultKt;
import com.upuphone.star.fota.phone.GlassUpdateApiManager;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.star.fota.phone.HostProvider;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.common.ActivityLifecycleManager;
import com.upuphone.xr.sapp.common.ApplicationVisibilityCallback;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfoKt;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateStateKt;
import com.upuphone.xr.sapp.entity.GlassUpdateDialogReminder;
import com.upuphone.xr.sapp.entity.GlassUpdateDialogResult;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadEvent;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.entity.GlassUpdateStateKt;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.DateUtil;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.NotificationUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.SuperFunctionUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.File;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0006©\u0001Ú\u0001Þ\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u001d\u0010\u001c\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J+\u0010&\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J%\u0010,\u001a\u00020\u00072\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\nH\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010\u0003J+\u00105\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u00106J\u001f\u0010:\u001a\u00020\n2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b<\u0010!J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u0003J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\nH\u0002¢\u0006\u0004\bC\u0010\u0003J\u0017\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJ\u0015\u0010J\u001a\u00020\n2\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ!\u0010O\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020\n¢\u0006\u0004\bQ\u0010\u0003J!\u0010R\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bR\u0010PJ\u0015\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0004¢\u0006\u0004\bT\u0010UJ\u001d\u0010V\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u0004¢\u0006\u0004\bX\u0010\u0017J3\u0010[\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010Z\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b[\u0010\\J\r\u0010]\u001a\u00020\n¢\u0006\u0004\b]\u0010\u0003J-\u0010_\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\ba\u0010!J%\u0010e\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010\u00042\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\n0c¢\u0006\u0004\be\u0010fJ\u0015\u0010h\u001a\u00020\n2\u0006\u0010g\u001a\u00020\u0004¢\u0006\u0004\bh\u0010\u0017J\u0015\u0010i\u001a\u00020\n2\u0006\u0010g\u001a\u00020\u0004¢\u0006\u0004\bi\u0010\u0017J\u0019\u0010k\u001a\u0004\u0018\u00010j2\b\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bk\u0010lJ\r\u0010m\u001a\u00020\n¢\u0006\u0004\bm\u0010\u0003J\u0019\u0010p\u001a\u00020\n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n¢\u0006\u0004\bp\u0010qJ1\u0010u\u001a\u00020\n2\"\u0010t\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e0(\u0012\u0004\u0012\u00020\n0rj\u0002`s¢\u0006\u0004\bu\u0010vJ\r\u0010w\u001a\u00020\u0004¢\u0006\u0004\bw\u0010xJ\u0012\u0010y\u001a\u0004\u0018\u00010)H@¢\u0006\u0004\by\u0010zJ\u0012\u0010{\u001a\u0004\u0018\u00010)H@¢\u0006\u0004\b{\u0010zJ\u0017\u0010~\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010|¢\u0006\u0004\b~\u0010R \u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010n0\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010n0\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010>0\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010>0\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u0012\u0012\r\u0012\u000b \u0001*\u0004\u0018\u00010\u00070\u00070\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010¤\u0001\u001a\u000f\u0012\n\u0012\b0 \u0001j\u0003`¡\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010¬\u0001\u001a\u00030©\u00018\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R%\u0010°\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00018\u0006¢\u0006\u0010\n\u0006\b­\u0001\u0010\u0001\u001a\u0006\b®\u0001\u0010¯\u0001R#\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00018\u0006¢\u0006\u0010\n\u0006\b±\u0001\u0010\u0001\u001a\u0006\b²\u0001\u0010\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010´\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010¹\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¸\u0001\u0010TR\u001c\u0010½\u0001\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¼\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010À\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R'\u0010Æ\u0001\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R:\u0010È\u0001\u001a%\u0012 \u0012\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e0(\u0012\u0004\u0012\u00020\n0rj\u0002`s0\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010£\u0001R \u0010Ê\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010)0\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010\u0001R%\u0010Í\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010)0\u00018\u0006¢\u0006\u0010\n\u0006\bË\u0001\u0010\u0001\u001a\u0006\bÌ\u0001\u0010\u0001R\u001e\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u00020D0Î\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R#\u0010×\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ò\u00018\u0006¢\u0006\u0010\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001R$\u0010Ù\u0001\u001a\u000f\u0012\n\u0012\b0 \u0001j\u0003`¡\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010£\u0001R\u0018\u0010Ý\u0001\u001a\u00030Ú\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0018\u0010á\u0001\u001a\u00030Þ\u00018\u0002X\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001c\u0010ã\u0001\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010¼\u0001R\u001c\u0010å\u0001\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bä\u0001\u0010¼\u0001R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8BX\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0019\u0010ê\u0001\u001a\u0004\u0018\u00010)8BX\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010é\u0001R\u0017\u0010í\u0001\u001a\u00020\u00078BX\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010ì\u0001R+\u0010ð\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\u000e\u001a\u0005\bî\u0001\u0010x\"\u0005\bï\u0001\u0010\u0017R+\u0010ó\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\u000e\u001a\u0005\bñ\u0001\u0010x\"\u0005\bò\u0001\u0010\u0017R7\u0010ù\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040ô\u00012\r\u0010\u0012\u001a\t\u0012\u0004\u0012\u00020\u00040ô\u00018B@BX\u000e¢\u0006\u0010\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R,\u0010ý\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r8B@BX\u000e¢\u0006\u000f\u001a\u0006\bú\u0001\u0010û\u0001\"\u0005\bü\u0001\u0010\u0014R-\u0010\u0002\u001a\u0004\u0018\u00010j2\b\u0010\u0012\u001a\u0004\u0018\u00010j8B@BX\u000e¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0002\u0010\u0002R+\u0010\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\u000e\u001a\u0005\b\u0002\u0010x\"\u0005\b\u0002\u0010\u0017R)\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@BX\u000e¢\u0006\u0010\u001a\u0006\b\u0002\u0010ì\u0001\"\u0006\b\u0002\u0010\u0002R/\u0010\u0002\u001a\u0005\u0018\u00010\u00022\t\u0010\u0012\u001a\u0005\u0018\u00010\u00028B@BX\u000e¢\u0006\u0010\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u00030\u00028\u0016X\u0005¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0014\u0010\u0002\u001a\u00020\u00078F¢\u0006\b\u001a\u0006\b\u0002\u0010ì\u0001R,\u0010\u0002\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r8@@@X\u000e¢\u0006\u000f\u001a\u0006\b\u0002\u0010û\u0001\"\u0005\b\u0002\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00078F¢\u0006\b\u001a\u0006\b\u0002\u0010ì\u0001R\u0015\u0010\u0002\u001a\u00030À\u00018F¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R+\u0010 \u0002\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0002\u0010x\"\u0005\b\u0002\u0010\u0017R+\u0010£\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b¡\u0002\u0010x\"\u0005\b¢\u0002\u0010\u0017R+\u0010¦\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b¤\u0002\u0010x\"\u0005\b¥\u0002\u0010\u0017¨\u0006§\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassUpdateHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "title", "latestVersion", "", "silent", "onGoing", "", "F1", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "updateState", "needNotify", "u1", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;Z)V", "value", "g1", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)V", "path", "V", "(Ljava/lang/String;)V", "l0", "", "Ljava/io/File;", "excludeFiles", "m0", "(Ljava/util/List;)V", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "a0", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "digest", "file", "", "percent", "m1", "(Ljava/lang/String;Ljava/io/File;F)V", "Lkotlin/Pair;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "pair", "Y", "(Lkotlin/Pair;)Z", "serial", "q1", "(Ljava/lang/String;Ljava/lang/String;)V", "k1", "c1", "version", "installId", "n1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;", "result", "isAir", "X0", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;Z)V", "e0", "j1", "Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "progress", "Y0", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;)V", "I1", "i1", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadEvent;", "downloadEvent", "o0", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadEvent;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "X", "(Landroidx/lifecycle/LifecycleOwner;)V", "", "delayTime", "isForcible", "h0", "(JZ)V", "l1", "j0", "glassUpdateVersion", "Z", "(Ljava/lang/String;)Z", "f1", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "E1", "wifiRequired", "installRequired", "H1", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;ZZZ)V", "b0", "downloadFile", "n0", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;ZZ)V", "a1", "uid", "Lkotlin/Function0;", "action", "Z0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "msg", "d1", "e1", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadProgress;", "G0", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadProgress;", "h1", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "glassCheckUpdateState", "p1", "(Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;)V", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/glass/GlassUpdateStartCallback;", "callback", "W", "(Lkotlin/jvm/functions/Function1;)V", "u0", "()Ljava/lang/String;", "s0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "z0", "Landroid/app/Activity;", "activity", "c0", "(Landroid/app/Activity;)Z", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_glassCheckUpdateResultData", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "y0", "()Landroidx/lifecycle/LiveData;", "glassCheckUpdateResultData", "e", "_glassUpdateInfoData", "f", "I0", "glassUpdateInfoData", "g", "_glassUpdateProgressData", "h", "K0", "glassUpdateProgressData", "kotlin.jvm.PlatformType", "i", "_glassUpdateBadgeData", "j", "C0", "glassUpdateBadgeData", "k", "_hasGlassUpdateData", "l", "P0", "hasGlassUpdateData", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "m", "Ljava/util/concurrent/CopyOnWriteArraySet;", "connectActions", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "n", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "lastConnectGlass", "com/upuphone/xr/sapp/glass/GlassUpdateHelper$connectListener$1", "o", "Lcom/upuphone/xr/sapp/glass/GlassUpdateHelper$connectListener$1;", "connectListener", "p", "M0", "()Landroidx/lifecycle/MutableLiveData;", "glassUpdateStateData", "q", "getGlassUpdatingData", "glassUpdatingData", "Lcom/upuphone/xr/sapp/entity/DownloadingUpdateConfig;", "r", "Lcom/upuphone/xr/sapp/entity/DownloadingUpdateConfig;", "downloadingUpdateConfig", "s", "isAppInitialized", "Lkotlinx/coroutines/Job;", "t", "Lkotlinx/coroutines/Job;", "checkUpdateJob", "u", "checkUpdateStateResultJob", "", "v", "Ljava/lang/Integer;", "savedGlassUpdateBatteryLimit", "w", "Lkotlin/Pair;", "currentGlassUpdatePair", "x", "glassUpdateStartCallbacks", "y", "_glassInfoData", "z", "A0", "glassInfoData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "A", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_glassUpdateDownloadEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "B", "Lkotlinx/coroutines/flow/SharedFlow;", "F0", "()Lkotlinx/coroutines/flow/SharedFlow;", "glassUpdateDownloadEvent", "C", "networkAvailableActions", "com/upuphone/xr/sapp/glass/GlassUpdateHelper$networkCallback$1", "D", "Lcom/upuphone/xr/sapp/glass/GlassUpdateHelper$networkCallback$1;", "networkCallback", "com/upuphone/xr/sapp/glass/GlassUpdateHelper$innerDownloadListener$1", "E", "Lcom/upuphone/xr/sapp/glass/GlassUpdateHelper$innerDownloadListener$1;", "innerDownloadListener", "F", "installUpdateJob", "G", "restoreGlassUpdateStateJob", "H0", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "v0", "()Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "currentGlassInfo", "R0", "()Z", "needShowNotification", "W0", "D1", "savedUpdateStateId", "V0", "C1", "savedGlassUpdateVersion", "", "w0", "()Ljava/util/Set;", "o1", "(Ljava/util/Set;)V", "downloadGlassUpdateFiles", "U0", "()Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "B1", "savedGlassUpdateState", "T0", "()Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadProgress;", "A1", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadProgress;)V", "savedGlassUpdateDownloadProgress", "D0", "s1", "glassUpdateBadgeVersion", "Q0", "y1", "(Z)V", "needCheckGlassUpdateResult", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogReminder;", "S0", "()Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogReminder;", "z1", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogReminder;)V", "savedGlassUpdateDialogReminder", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "B0", "glassRomReady", "L0", "v1", "glassUpdateState", "b1", "isUpdating", "E0", "()I", "glassUpdateBatteryLimit", "O0", "x1", "glassUpdateTargetVersion", "N0", "w1", "glassUpdateTargetDigest", "J0", "t1", "glassUpdateInstallId", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper\n+ 2 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n+ 3 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1750:1\n64#2,5:1751\n29#3,5:1756\n29#3,5:1761\n29#3,5:1766\n1855#4,2:1771\n*S KotlinDebug\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper\n*L\n779#1:1751,5\n1128#1:1756,5\n1301#1:1761,5\n1544#1:1766,5\n1621#1:1771,2\n*E\n"})
public final class GlassUpdateHelper implements CoroutineScope {
    public static final MutableSharedFlow A;
    public static final SharedFlow B;
    public static final CopyOnWriteArraySet C = new CopyOnWriteArraySet();
    public static final GlassUpdateHelper$networkCallback$1 D;
    public static final GlassUpdateHelper$innerDownloadListener$1 E = new GlassUpdateHelper$innerDownloadListener$1();
    public static Job F;
    public static Job G;
    public static final GlassUpdateHelper b;
    public static final MutableLiveData c;
    public static final LiveData d;
    public static final MutableLiveData e;
    public static final LiveData f;
    public static final MutableLiveData g;
    public static final LiveData h;
    public static final MutableLiveData i;
    public static final LiveData j;
    public static final MutableLiveData k;
    public static final LiveData l;
    public static final CopyOnWriteArraySet m = new CopyOnWriteArraySet();
    public static StarryNetDevice n;
    public static final GlassUpdateHelper$connectListener$1 o;
    public static final MutableLiveData p;
    public static final LiveData q;
    public static DownloadingUpdateConfig r;
    public static boolean s;
    public static Job t;
    public static Job u;
    public static Integer v;
    public static Pair w;
    public static final CopyOnWriteArraySet x = new CopyOnWriteArraySet();
    public static final MutableLiveData y;
    public static final LiveData z;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7062a = CoroutineScopeKt.b();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$11", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.GlassUpdateHelper$11  reason: invalid class name */
    public static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass11(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GlassUpdateHelper.b.y0().observeForever(new GlassUpdateHelper$sam$androidx_lifecycle_Observer$0(AnonymousClass1.INSTANCE));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        GlassUpdateHelper glassUpdateHelper = new GlassUpdateHelper();
        b = glassUpdateHelper;
        MutableLiveData mutableLiveData = new MutableLiveData();
        c = mutableLiveData;
        d = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        e = mutableLiveData2;
        f = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        g = mutableLiveData3;
        h = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData(Boolean.FALSE);
        i = mutableLiveData4;
        j = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        k = mutableLiveData5;
        l = mutableLiveData5;
        GlassUpdateHelper$connectListener$1 glassUpdateHelper$connectListener$1 = new GlassUpdateHelper$connectListener$1();
        o = glassUpdateHelper$connectListener$1;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        p = mutableLiveData6;
        q = Transformations.a(Transformations.c(mutableLiveData6, GlassUpdateHelper$glassUpdatingData$1.INSTANCE));
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        y = mutableLiveData7;
        z = mutableLiveData7;
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        A = b2;
        B = FlowKt.b(b2);
        GlassUpdateHelper$networkCallback$1 glassUpdateHelper$networkCallback$1 = new GlassUpdateHelper$networkCallback$1();
        D = glassUpdateHelper$networkCallback$1;
        glassUpdateHelper.d1("GlassUpdateHelper#init");
        GlassUpdateApiManager.f6471a.j(new HostProvider() {
            public String a() {
                return NetConfig.f6666a.v("sArOta");
            }
        });
        ActivityLifecycleManager.f6654a.e(new ApplicationVisibilityCallback() {
            public void a() {
                ULog.f6446a.a("GlassUpdateHelper", "onApplicationVisible");
                GlassUpdateHelper.i0(GlassUpdateHelper.b, 0, false, 3, (Object) null);
            }

            public void b() {
                ULog.f6446a.a("GlassUpdateHelper", "onApplicationInvisible");
                GlassUpdateResultHelper.G(GlassUpdateResultHelper.b, 0, 1, (Object) null);
            }
        });
        GlassHelper glassHelper = GlassHelper.f7049a;
        n = glassHelper.x();
        glassHelper.l(glassUpdateHelper$connectListener$1);
        glassHelper.q(AnonymousClass3.INSTANCE);
        AirHelper airHelper = AirHelper.b;
        airHelper.r(AnonymousClass4.INSTANCE);
        glassHelper.o(AnonymousClass5.INSTANCE);
        airHelper.m(AnonymousClass6.INSTANCE);
        GlassUpdateState U0 = glassUpdateHelper.U0();
        if (U0 != null) {
            glassUpdateHelper.d1("GlassUpdateHelper#init, savedGlassUpdateState: " + U0);
            glassUpdateHelper.u1(U0, false);
            if (U0 instanceof GlassUpdateState.Installing) {
                glassUpdateHelper.d1("GlassUpdateHelper#init, needCheckGlassUpdateResult");
                glassUpdateHelper.j0(AssistantConstants.TIMEOUT_VAD_MUTE, true);
            }
        }
        glassUpdateHelper.c1();
        NetworkUtils.f7898a.o((LifecycleOwner) null, glassUpdateHelper$networkCallback$1);
        GlassUpdateResultHelper glassUpdateResultHelper = GlassUpdateResultHelper.b;
        glassHelper.p(AnonymousClass8.INSTANCE);
        airHelper.n(AnonymousClass9.INSTANCE);
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceBondStateListener(new DeviceBondStateListener() {
            public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
                GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
                glassUpdateHelper.d1("onDeviceBondStateChange, device: " + starryNetDevice + ", newState: " + i);
                if (i == 0 && starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                    glassUpdateHelper.i1();
                }
            }
        });
        AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
        Job unused = BuildersKt__Builders_commonKt.d(glassUpdateHelper, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass11((Continuation<? super AnonymousClass11>) null), 3, (Object) null);
    }

    public static /* synthetic */ void G1(GlassUpdateHelper glassUpdateHelper, String str, String str2, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            z3 = false;
        }
        glassUpdateHelper.F1(str, str2, z2, z3);
    }

    public static final void g0(GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "$glassUpdateInfo");
        b.e0(glassUpdateInfo);
    }

    public static /* synthetic */ void i0(GlassUpdateHelper glassUpdateHelper, long j2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 1000;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        glassUpdateHelper.h0(j2, z2);
    }

    public static /* synthetic */ void k0(GlassUpdateHelper glassUpdateHelper, long j2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 1000;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        glassUpdateHelper.j0(j2, z2);
    }

    public static /* synthetic */ void r1(GlassUpdateHelper glassUpdateHelper, GlassCheckUpdateState glassCheckUpdateState, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            glassCheckUpdateState = (GlassCheckUpdateState) d.getValue();
        }
        glassUpdateHelper.p1(glassCheckUpdateState);
    }

    public final LiveData A0() {
        return z;
    }

    public final void A1(GlassUpdateDownloadProgress glassUpdateDownloadProgress) {
        if (glassUpdateDownloadProgress == null) {
            MMKV.n().E("update._glass_update_download_progress2");
            d1("delete GlassUpdateDownloadProgress");
            return;
        }
        MMKV.n().u("update._glass_update_download_progress2", JsonUtils.f7893a.d(glassUpdateDownloadProgress));
    }

    public final boolean B0() {
        Boolean bool = (Boolean) l.getValue();
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void B1(GlassUpdateState glassUpdateState) {
        String str;
        if (glassUpdateState == null) {
            MMKV.n().E("update._glass_update_state");
            d1("delete savedGlassUpdateState");
            return;
        }
        String d2 = JsonUtils.f7893a.d(glassUpdateState);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class", glassUpdateState.getClass().getName());
            jSONObject.put("json", d2);
            str = jSONObject.toString();
        } catch (Exception e2) {
            e1("savedGlassUpdateState error: " + e2);
            str = null;
        }
        MMKV.n().u("update._glass_update_state", str);
        d1("savedGlassUpdateState success: " + str);
    }

    public final LiveData C0() {
        return j;
    }

    public final void C1(String str) {
        MMKV.n().u("update._glass_update_version", str);
    }

    public final String D0() {
        return MMKV.n().j("update._glass_update_badge");
    }

    public final void D1(String str) {
        MMKV.n().u("update._glass_update_state_id", str);
    }

    public final int E0() {
        Integer num = v;
        return num != null ? RangesKt.coerceAtLeast(Math.min(num.intValue(), 50), 1) : GlassUpdateAdapter.b.m();
    }

    public final void E1(String str) {
        Intrinsics.checkNotNullParameter(str, "glassUpdateVersion");
        C1(str);
    }

    public final SharedFlow F0() {
        return B;
    }

    public final void F1(String str, String str2, boolean z2, boolean z3) {
        String str3 = str2;
        d1("showNotification, title: " + str + ", latestVersion: " + str3 + ", silent: " + z2 + ", onGoing: " + z3);
        Context f2 = GlobalExtKt.f();
        Context f3 = GlobalExtKt.f();
        Intent intent = new Intent(f3, GlassUpdateInfoActivity.class);
        if (!(f3 instanceof Activity)) {
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        }
        PendingIntent activity = PendingIntent.getActivity(f2, 0, intent, CircleProgressBar.RIM_COLOR_DEF);
        if (str3 == null) {
            GlassUpdateHelper glassUpdateHelper = b;
            glassUpdateHelper.d1("showNotification, latestVersion is null");
            GlassUpdateInfo H0 = glassUpdateHelper.H0();
            str3 = H0 != null ? H0.getVersionFullName() : null;
        }
        if (str3 == null) {
            str3 = "";
        }
        NotificationUtils.j(NotificationUtils.f7900a, 257, "channel_glass_update", str, str3, 0, 0, activity, (Integer) null, false, z2, z3, 432, (Object) null);
    }

    public final GlassUpdateDownloadProgress G0(String str) {
        String filePath;
        if (str == null) {
            return null;
        }
        try {
            GlassUpdateDownloadProgress T0 = T0();
            if (!(T0 == null || !Intrinsics.areEqual((Object) T0.getDigest(), (Object) str) || (filePath = T0.getFilePath()) == null)) {
                if (filePath.length() != 0) {
                    File file = new File(T0.getFilePath());
                    if (!file.exists() || file.length() <= 0) {
                        return null;
                    }
                    return T0;
                }
            }
            return null;
        } catch (Exception e2) {
            e1("getGlassUpdateDownloadProgress error: " + e2);
        }
    }

    public final GlassUpdateInfo H0() {
        return (GlassUpdateInfo) f.getValue();
    }

    public final void H1(GlassUpdateInfo glassUpdateInfo, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        d1("startDownload, wifiRequired: " + z2 + ", installRequired: " + z3 + ", silent: " + z4);
        String packLink = glassUpdateInfo.getPackLink();
        String digest = glassUpdateInfo.getDigest();
        if (packLink == null || packLink.length() == 0 || digest == null || digest.length() == 0) {
            e1("packLink or digest is empty");
            ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
            return;
        }
        a0(glassUpdateInfo);
        Utils utils = Utils.f6462a;
        Context f2 = GlobalExtKt.f();
        r = new DownloadingUpdateConfig(DownloadManager.t(DownloadManager.b, packLink, utils.a(f2, "glass_ota", digest + ".zip"), z2, 3, 0, E, 16, (Object) null), glassUpdateInfo, z3, z4);
    }

    public final LiveData I0() {
        return f;
    }

    public final void I1() {
        Job job = G;
        if (job == null || !job.isActive()) {
            G = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$tryToRestoreGlassUpdateState$1((Continuation<? super GlassUpdateHelper$tryToRestoreGlassUpdateState$1>) null), 3, (Object) null);
            return;
        }
        d1("restoreGlassUpdateStateJob.isActive, return");
    }

    public final String J0() {
        return MMKV.n().j("update._glass_update_install_id");
    }

    public final LiveData K0() {
        return h;
    }

    public final GlassUpdateState L0() {
        return (GlassUpdateState) p.getValue();
    }

    public final MutableLiveData M0() {
        return p;
    }

    public final String N0() {
        return MMKV.n().j("update._glass_update_target_digest");
    }

    public final String O0() {
        return MMKV.n().j("update._glass_update_target_version");
    }

    public final LiveData P0() {
        return l;
    }

    public final boolean Q0() {
        return MMKV.n().d("update._need_check_glass_update_result", false);
    }

    public final boolean R0() {
        return !ActivityLifecycleManager.f6654a.d(GlassUpdateInfoActivity.class);
    }

    public final GlassUpdateDialogReminder S0() {
        Object obj;
        String j2 = MMKV.n().j("update._glass_update_dialog_reminder");
        JsonUtils jsonUtils = JsonUtils.f7893a;
        Type type = new GlassUpdateHelper$_get_savedGlassUpdateDialogReminder_$lambda$11$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j2, type);
        }
        return (GlassUpdateDialogReminder) obj;
    }

    public final GlassUpdateDownloadProgress T0() {
        Object obj;
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String j2 = MMKV.n().j("update._glass_update_download_progress2");
        Type type = new GlassUpdateHelper$special$$inlined$fromJson$2().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j2, type);
        }
        return (GlassUpdateDownloadProgress) obj;
    }

    public final GlassUpdateState U0() {
        String j2 = MMKV.n().j("update._glass_update_state");
        if (!(j2 == null || j2.length() == 0)) {
            try {
                JSONObject jSONObject = new JSONObject(j2);
                String string = jSONObject.getString("class");
                String string2 = jSONObject.getString("json");
                JsonUtils jsonUtils = JsonUtils.f7893a;
                Class<?> cls = Class.forName(string);
                Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
                return (GlassUpdateState) jsonUtils.a(string2, cls);
            } catch (Exception e2) {
                e1("get savedGlassUpdateState error: " + e2);
            }
        }
        return null;
    }

    public final void V(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(w0());
        linkedHashSet.add(str);
        o1(linkedHashSet);
    }

    public final String V0() {
        return MMKV.n().j("update._glass_update_version");
    }

    public final void W(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        x.add(function1);
    }

    public final String W0() {
        return MMKV.n().j("update._glass_update_state_id");
    }

    public final void X(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().a(new GlassUpdateHelper$bindLifecycle$1());
    }

    public final void X0(GlassUpdateDialogResult glassUpdateDialogResult, boolean z2) {
        d1("handleGlassUpdateDialogResult, result: " + glassUpdateDialogResult + ", isAir: " + z2);
        GlassUpdateState L0 = L0();
        if (!(L0 instanceof GlassUpdateState.WaitingUpdateDialogResult)) {
            e1("handleGlassUpdateDialogResult, not WaitingUpdateDialogResult");
            return;
        }
        GlassUpdateState.WaitingUpdateDialogResult waitingUpdateDialogResult = (GlassUpdateState.WaitingUpdateDialogResult) L0;
        String latestVersion = waitingUpdateDialogResult.getGlassUpdateInfo().getLatestVersion();
        if (latestVersion == null) {
            b.e1("handleGlassUpdateDialogResult, glassUpdateInfo.latestVersion is null");
            latestVersion = "V0.0.0.0";
        }
        String str = latestVersion;
        if (Intrinsics.areEqual((Object) glassUpdateDialogResult.getNeedInstallUpdate(), (Object) Boolean.TRUE)) {
            z1(new GlassUpdateDialogReminder(false, str, (Long) null, (String) null, (Boolean) null, (String) null, 60, (DefaultConstructorMarker) null));
            d1("handleGlassUpdateDialogResult, closeNavi");
            SuperFunctionUtils.b.a().c();
            d1("handleGlassUpdateDialogResult, transferFileAndInstall");
            GlassUpdateAdapter.b.y(waitingUpdateDialogResult.getDownloadFile(), waitingUpdateDialogResult.getGlassUpdateInfo(), GlassUpdateHelper$handleGlassUpdateDialogResult$1.INSTANCE);
            return;
        }
        v1(new GlassUpdateState.UpdateDialogGlassCanceled(waitingUpdateDialogResult.getGlassUpdateInfo()));
        GlassUpdateDialogReminder S0 = S0();
        d1("handleGlassUpdateDialogResult, savedConfig: " + S0);
        if (S0 == null || !Intrinsics.areEqual((Object) S0.getVersion(), (Object) waitingUpdateDialogResult.getGlassUpdateInfo().getLatestVersion())) {
            long currentTimeMillis = System.currentTimeMillis();
            z1(new GlassUpdateDialogReminder(true, str, Long.valueOf(currentTimeMillis), waitingUpdateDialogResult.getGlassUpdateInfo().getDigest(), Boolean.valueOf(z2), waitingUpdateDialogResult.getDownloadFile().getAbsolutePath()));
            return;
        }
        z1(new GlassUpdateDialogReminder(false, str, (Long) null, (String) null, (Boolean) null, (String) null, 60, (DefaultConstructorMarker) null));
    }

    public final boolean Y(Pair pair) {
        BasicGlassInfo basicGlassInfo;
        GlassUpdateInfo a2;
        String latestVersion;
        if (pair == null || (basicGlassInfo = (BasicGlassInfo) pair.getFirst()) == null || (a2 = GlassCheckUpdateResultKt.a((GlassCheckUpdateResult) pair.getSecond())) == null || !a2.getExistsUpdate() || (latestVersion = a2.getLatestVersion()) == null) {
            return false;
        }
        return !Intrinsics.areEqual((Object) D0(), (Object) f1(basicGlassInfo.getSerial(), latestVersion));
    }

    public final void Y0(GlassUpdateProgress glassUpdateProgress) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$handleGlassUpdateProgress$1(glassUpdateProgress, (Continuation<? super GlassUpdateHelper$handleGlassUpdateProgress$1>) null), 3, (Object) null);
    }

    public final boolean Z(String str) {
        Intrinsics.checkNotNullParameter(str, "glassUpdateVersion");
        return !Intrinsics.areEqual((Object) V0(), (Object) str);
    }

    public final void Z0(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, WebJs.ACTION);
        if (!Intrinsics.areEqual((Object) W0(), (Object) str)) {
            D1(str);
            function0.invoke();
        }
    }

    public final void a0(GlassUpdateInfo glassUpdateInfo) {
        DownloadingUpdateConfig downloadingUpdateConfig = r;
        if (downloadingUpdateConfig == null) {
            return;
        }
        if (!Intrinsics.areEqual((Object) downloadingUpdateConfig.getGlassUpdateInfo().getLatestVersion(), (Object) glassUpdateInfo.getLatestVersion()) || !Intrinsics.areEqual((Object) downloadingUpdateConfig.getGlassUpdateInfo().getDigest(), (Object) glassUpdateInfo.getDigest())) {
            GlassUpdateHelper glassUpdateHelper = b;
            DownloadTask downloadTask = downloadingUpdateConfig.getDownloadTask();
            glassUpdateHelper.d1("cancelDownloadIfNotMatch, cancelDownload: " + downloadTask);
            DownloadManager.b.j(downloadingUpdateConfig.getDownloadTask(), true);
            r = null;
            if ((glassUpdateHelper.L0() instanceof GlassUpdateState.Downloading) || (glassUpdateHelper.L0() instanceof GlassUpdateState.DownloadFail)) {
                glassUpdateHelper.d1("cancelDownloadIfNotMatch, clear Downloading state");
                glassUpdateHelper.u1((GlassUpdateState) null, false);
            }
        }
    }

    public final void a1(GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Job job = F;
        if (job == null || !job.isActive()) {
            F = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$installUpdateNow$1(glassUpdateInfo, (Continuation<? super GlassUpdateHelper$installUpdateNow$1>) null), 3, (Object) null);
            return;
        }
        d1("installUpdateNow, installUpdateJob.isActive, return");
    }

    public final void b0() {
        NotificationUtils.f7900a.a(256, 257);
    }

    public final boolean b1() {
        if (!GlassHelper.f7049a.E()) {
            return false;
        }
        return GlassUpdateStateKt.isUpdating((GlassUpdateState) p.getValue());
    }

    public final boolean c0(Activity activity) {
        if (!b1()) {
            return false;
        }
        if (activity == null) {
            return true;
        }
        StaticMethodUtilsKt.N(activity);
        return true;
    }

    public final void c1() {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.b(), (CoroutineStart) null, new GlassUpdateHelper$loadUpdateBatteryLimit$1((Continuation<? super GlassUpdateHelper$loadUpdateBatteryLimit$1>) null), 2, (Object) null);
    }

    public final void d1(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ULog.f6446a.a("GlassUpdateHelper", str);
    }

    public final void e0(GlassUpdateInfo glassUpdateInfo) {
        String str;
        try {
            GlassUpdateDialogReminder S0 = S0();
            d1("checkShouldShowUpdateDialogOnGlass, savedConfig: " + S0);
            if (S0 == null) {
                return;
            }
            if (S0.getNeedReminder()) {
                if (Intrinsics.areEqual((Object) S0.getVersion(), (Object) glassUpdateInfo.getLatestVersion())) {
                    if (Intrinsics.areEqual((Object) S0.getDigest(), (Object) glassUpdateInfo.getDigest())) {
                        if (b1()) {
                            d1("checkShouldShowUpdateDialogOnGlass, isUpdating");
                            return;
                        }
                        Long lastTime = S0.getLastTime();
                        if (lastTime != null) {
                            str = DateUtil.f7876a.b(new Date(lastTime.longValue()));
                        } else {
                            str = null;
                        }
                        String a2 = DateUtil.f7876a.a();
                        if (Intrinsics.areEqual((Object) str, (Object) a2)) {
                            d1("checkShouldShowUpdateDialogOnGlass, same day: " + a2);
                            return;
                        }
                        String filePath = S0.getFilePath();
                        if (filePath == null) {
                            b.d1("checkShouldShowUpdateDialogOnGlass, filePath is null");
                            return;
                        }
                        File file = new File(filePath);
                        if (file.exists()) {
                            if (file.length() > 0) {
                                if (!GlassHelper.f7049a.E()) {
                                    d1("checkShouldShowUpdateDialogOnGlass, disconnect, retry later");
                                    m.add(new e(glassUpdateInfo));
                                    return;
                                }
                                String latestVersion = glassUpdateInfo.getLatestVersion();
                                if (latestVersion == null) {
                                    b.e1("checkShouldShowUpdateDialogOnGlass, glassUpdateInfo.latestVersion is null");
                                    latestVersion = "V0.0.0.0";
                                }
                                d1("checkShouldShowUpdateDialogOnGlass, sendShowUpdateDialogCmd");
                                j1();
                                GlassUpdateAdapter.b.x(glassUpdateInfo, file, new GlassUpdateHelper$checkShouldShowUpdateDialogOnGlass$2(latestVersion));
                                return;
                            }
                        }
                        d1("checkShouldShowUpdateDialogOnGlass, file error");
                        return;
                    }
                }
                d1("checkShouldShowUpdateDialogOnGlass, glassUpdateInfo not match");
            }
        } catch (Exception e2) {
            e1("checkShouldShowUpdateDialogOnGlass, error: " + e2);
        }
    }

    public final void e1(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ULog.f6446a.c("GlassUpdateHelper", str);
    }

    public final String f1(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "serial");
        Intrinsics.checkNotNullParameter(str2, "version");
        return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
    }

    public final void g1(GlassUpdateState glassUpdateState) {
        if (glassUpdateState instanceof GlassUpdateState.DownloadFail) {
            if (R0()) {
                Z0(((GlassUpdateState.DownloadFail) glassUpdateState).getUid(), new GlassUpdateHelper$notifyGlassUpdateState$1(glassUpdateState));
            }
        } else if (glassUpdateState instanceof GlassUpdateState.InstallFail) {
            if (R0()) {
                Z0(((GlassUpdateState.InstallFail) glassUpdateState).getUid(), new GlassUpdateHelper$notifyGlassUpdateState$2(glassUpdateState));
            }
        } else if (glassUpdateState instanceof GlassUpdateState.TransferFail) {
            if (R0()) {
                Z0(((GlassUpdateState.TransferFail) glassUpdateState).getUid(), new GlassUpdateHelper$notifyGlassUpdateState$3(glassUpdateState));
            }
        } else if (glassUpdateState instanceof GlassUpdateState.GlassUpdateFail) {
            if (R0()) {
                Z0(((GlassUpdateState.GlassUpdateFail) glassUpdateState).getUid(), new GlassUpdateHelper$notifyGlassUpdateState$4(glassUpdateState));
            }
        } else if (glassUpdateState instanceof GlassUpdateState.GlassUpdateSuccess) {
            ContextExtKt.e(R.string.update_success, 0, 2, (Object) null);
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7062a.getCoroutineContext();
    }

    public final void h0(long j2, boolean z2) {
        if (!s && !z2) {
            d1("checkUpdate, isAppInitialized = false, return");
        } else if (b1()) {
            d1("checkUpdate, isUpdating = true, return");
        } else {
            Job job = t;
            if (job == null || !job.isActive()) {
                t = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$checkUpdate$1(j2, (Continuation<? super GlassUpdateHelper$checkUpdate$1>) null), 3, (Object) null);
                return;
            }
            d1("checkUpdateJob isActive, return");
        }
    }

    public final void h1() {
        d1("onAppInitialized");
        s = true;
        i0(this, 0, false, 3, (Object) null);
        k0(this, 0, false, 3, (Object) null);
    }

    public final void i1() {
        GlassUpdateState L0 = L0();
        d1("glass unbounded, glassUpdateState: " + L0);
        if (L0 != null) {
            GlassUpdateState.GlassUpdateIdle glassUpdateIdle = GlassUpdateState.GlassUpdateIdle.INSTANCE;
            if (!Intrinsics.areEqual((Object) L0, (Object) glassUpdateIdle)) {
                d1("glass unbounded, reset glassUpdateState");
                v1(glassUpdateIdle);
            }
        }
        y.postValue(null);
    }

    public final void j0(long j2, boolean z2) {
        if (s || z2) {
            Job job = u;
            if (job == null || !job.isActive()) {
                u = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$checkUpdateStateResult$1(j2, (Continuation<? super GlassUpdateHelper$checkUpdateStateResult$1>) null), 3, (Object) null);
                return;
            }
            ULog.f6446a.a("GlassUpdateHelper", "checkUpdateStateResult, checkUpdateStateResultJob.isActive=true, return");
            return;
        }
        ULog.f6446a.a("GlassUpdateHelper", "checkUpdateStateResult, isAppInitialized = false, return");
    }

    public final void j1() {
        Pair pair = w;
        d1("onGlassUpdateStarted: " + pair);
        Pair pair2 = w;
        if (pair2 != null) {
            for (Function1 invoke : x) {
                invoke.invoke(pair2);
            }
        }
    }

    public final void k1() {
        Pair<BasicGlassInfo, GlassCheckUpdateResult> resultOrNull;
        GlassCheckUpdateState glassCheckUpdateState = (GlassCheckUpdateState) d.getValue();
        if (glassCheckUpdateState != null && (resultOrNull = GlassCheckUpdateStateKt.getResultOrNull(glassCheckUpdateState)) != null) {
            GlassUpdateHelper glassUpdateHelper = b;
            boolean Y = glassUpdateHelper.Y(resultOrNull);
            glassUpdateHelper.d1("refreshGlassUpdateBadge, showGlassUpdateBadge: " + Y);
            i.setValue(Boolean.valueOf(Y));
        }
    }

    public final void l0() {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.b(), (CoroutineStart) null, new GlassUpdateHelper$clearGlassUpdateData$1((Continuation<? super GlassUpdateHelper$clearGlassUpdateData$1>) null), 2, (Object) null);
    }

    public final void l1() {
        ULog.f6446a.a("GlassUpdateHelper", "release");
    }

    public final void m0(List list) {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.b(), (CoroutineStart) null, new GlassUpdateHelper$clearGlassUpdateFiles$1(list, (Continuation<? super GlassUpdateHelper$clearGlassUpdateFiles$1>) null), 2, (Object) null);
    }

    public final void m1(String str, File file, float f2) {
        try {
            A1(new GlassUpdateDownloadProgress(str, file != null ? file.getPath() : null, f2));
        } catch (Exception e2) {
            e1("saveGlassUpdateDownloadProgress error: " + e2);
        }
    }

    public final void n0(File file, GlassUpdateInfo glassUpdateInfo, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(file, "downloadFile");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        boolean z4 = z3;
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$downloadCompleted$1(z4, glassUpdateInfo, file, glassUpdateInfo.getDigest(), z2, (Continuation<? super GlassUpdateHelper$downloadCompleted$1>) null), 3, (Object) null);
    }

    public final void n1(String str, String str2, String str3) {
        x1(str);
        w1(str2);
        t1(str3);
        d1("saveGlassUpdateTargetValue, version: " + str + ", digest: " + str2 + ", installId: " + str3);
    }

    public final void o0(GlassUpdateDownloadEvent glassUpdateDownloadEvent) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$emitDownloadEvent$1(glassUpdateDownloadEvent, (Continuation<? super GlassUpdateHelper$emitDownloadEvent$1>) null), 3, (Object) null);
    }

    public final void o1(Set set) {
        MMKV.n().u("update._glass_update_files", JsonUtils.f7893a.d(set));
    }

    public final void p1(GlassCheckUpdateState glassCheckUpdateState) {
        Pair<BasicGlassInfo, GlassCheckUpdateResult> resultOrNull;
        String latestVersion;
        if (glassCheckUpdateState != null && (resultOrNull = GlassCheckUpdateStateKt.getResultOrNull(glassCheckUpdateState)) != null) {
            BasicGlassInfo first = resultOrNull.getFirst();
            GlassUpdateInfo a2 = GlassCheckUpdateResultKt.a(resultOrNull.getSecond());
            if (a2 != null && a2.getExistsUpdate() && (latestVersion = a2.getLatestVersion()) != null) {
                b.q1(first.getSerial(), latestVersion);
            }
        }
    }

    public final void q1(String str, String str2) {
        String f1 = f1(str, str2);
        d1("setGlassUpdateBadgeShown, mixVersion: " + f1);
        s1(f1);
        k1();
    }

    public final Object s0(Continuation continuation) {
        BasicGlassInfo v0 = v0();
        return v0 != null ? v0 : z0(continuation);
    }

    public final void s1(String str) {
        MMKV.n().u("update._glass_update_badge", str);
    }

    public final void t1(String str) {
        MMKV.n().u("update._glass_update_install_id", str);
    }

    public final String u0() {
        BasicGlassInfo basicGlassInfo;
        String safeDisplayName;
        Pair pair = w;
        if (pair != null && (basicGlassInfo = (BasicGlassInfo) pair.getFirst()) != null && (safeDisplayName = BasicGlassInfoKt.getSafeDisplayName(basicGlassInfo)) != null && safeDisplayName.length() > 0) {
            return safeDisplayName;
        }
        StarryNetDevice x2 = GlassHelper.f7049a.x();
        return (x2 == null || !AirHelper.b.I(x2)) ? GlobalExtKt.h(R.string.star_glass_display_name) : GlobalExtKt.h(R.string.air_glass_display_name);
    }

    public final void u1(GlassUpdateState glassUpdateState, boolean z2) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$setGlassUpdateState$1(glassUpdateState, z2, (Continuation<? super GlassUpdateHelper$setGlassUpdateState$1>) null), 3, (Object) null);
    }

    public final BasicGlassInfo v0() {
        return (BasicGlassInfo) z.getValue();
    }

    public final void v1(GlassUpdateState glassUpdateState) {
        u1(glassUpdateState, true);
    }

    public final Set w0() {
        Object obj;
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String j2 = MMKV.n().j("update._glass_update_files");
        Type type = new GlassUpdateHelper$special$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j2, type);
        }
        Set set = (Set) obj;
        return set == null ? SetsKt.emptySet() : set;
    }

    public final void w1(String str) {
        MMKV.n().u("update._glass_update_target_digest", str);
    }

    public final void x1(String str) {
        MMKV.n().u("update._glass_update_target_version", str);
    }

    public final LiveData y0() {
        return d;
    }

    public final void y1(boolean z2) {
        MMKV.n().w("update._need_check_glass_update_result", z2);
        d1("save needCheckGlassUpdateResult: " + z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z0(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.glass.GlassUpdateHelper$getGlassInfoByDevice$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.glass.GlassUpdateHelper$getGlassInfoByDevice$1 r0 = (com.upuphone.xr.sapp.glass.GlassUpdateHelper$getGlassInfoByDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper$getGlassInfoByDevice$1 r0 = new com.upuphone.xr.sapp.glass.GlassUpdateHelper$getGlassInfoByDevice$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.xr.sapp.glass.GlassHelper r4 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r4 = r4.x()
            if (r4 != 0) goto L_0x003e
            return r2
        L_0x003e:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r1 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            r0.label = r3
            java.lang.Object r4 = r1.l(r4, r0)
            if (r4 != r5) goto L_0x0049
            return r5
        L_0x0049:
            com.upuphone.xr.sapp.entity.BasicGlassInfo r4 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r4
            if (r4 == 0) goto L_0x0053
            androidx.lifecycle.MutableLiveData r5 = y
            r5.postValue(r4)
            r2 = r4
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateHelper.z0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void z1(GlassUpdateDialogReminder glassUpdateDialogReminder) {
        String d2 = JsonUtils.f7893a.d(glassUpdateDialogReminder);
        MMKV.n().u("update._glass_update_dialog_reminder", d2);
        GlassUpdateHelper glassUpdateHelper = b;
        glassUpdateHelper.d1("save GlassUpdateDialogReminder: " + d2);
    }
}
