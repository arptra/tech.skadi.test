package com.meizu.flyme.policy.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.gson.Gson;
import com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity;
import com.meizu.flyme.policy.sdk.bean.PolicyData;
import com.meizu.flyme.policy.sdk.bean.PolicyFileDataResultBean;
import com.meizu.flyme.policy.sdk.bean.PolicyHistoryListResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean;
import com.meizu.flyme.policy.sdk.bean.PolicyNewestResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyOperateRecordResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyRecordBaseInfo;
import com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest;
import com.meizu.flyme.policy.sdk.bean.PolicyResponse;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.bean.PolicyVersionResponse;
import com.meizu.flyme.policy.sdk.config.PolicySdkErrorCode;
import com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkNetworkUtil;
import com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.app.PermissionDialogBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010'JM\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010'JT\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001d0/H\u0007J \u00101\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0007J@\u00103\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0002J5\u0010;\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010=J5\u0010>\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010=J\u0016\u0010?\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0004JM\u0010@\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/H\u0007¢\u0006\u0002\u0010CJW\u0010D\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010B2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001d0/H\u0007¢\u0006\u0002\u0010FJP\u0010G\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010E\u001a\u00020B2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/H\u0007J(\u0010H\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010E\u001a\u00020B2\u0006\u0010,\u001a\u00020\u0004H\u0007J\"\u0010I\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u0004H\u0007J\u0019\u0010K\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001b\u0010M\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010LJL\u0010N\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\"\u0010O\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Pj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`QH\u0007J \u0010R\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0007J \u0010S\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0007J(\u0010T\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0007J\u0010\u0010U\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J+\u0010V\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020+2\b\u0010X\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010YJ!\u0010Z\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\u0002\u0010[J[\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00106\u001a\u00020+2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040$2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u00107\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010cJ\u0001\u0010d\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00106\u001a\u00020+2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040$2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u00107\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010eJB\u0010f\u001a\u0004\u0018\u0001042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020h2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007J:\u0010k\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007Jw\u0010l\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010mJ:\u0010n\u001a\u0004\u0018\u0001042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007Jo\u0010o\u001a\u0004\u0018\u0001042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010pJw\u0010q\u001a\u0004\u0018\u0001042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010rJw\u0010s\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010t\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010u\u001a\u00020+2\u0006\u0010a\u001a\u00020b2\u0006\u0010v\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010xJg\u0010y\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010w\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010zJ\u0001\u0010{\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040$2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010w\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010|J:\u0010}\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010v\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007JB\u0010~\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007Jx\u0010\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0003\u0010\u0001JU\u0010\u0001\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007J\u0001\u0010\u0001\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:H\u0007¢\u0006\u0003\u0010\u0001JF\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020<2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001d0/H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/meizu/flyme/policy/sdk/PolicyManager;", "", "()V", "brand", "", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "mAppId", "getMAppId", "setMAppId", "mAppSecret", "getMAppSecret", "setMAppSecret", "mAppVersionName", "getMAppVersionName", "setMAppVersionName", "model", "getModel", "setModel", "osVersion", "getOsVersion", "setOsVersion", "autoUploadRecord", "", "context", "Landroid/content/Context;", "appId", "appSecret", "versionName", "categoryList", "", "userId", "operationType", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "autoUploadRecordOnline", "checkNewestPolicy", "isAutoRecord", "", "language", "category", "callBackPolicyResult", "Lkotlin/Function1;", "Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "copyPolicyFile", "toPath", "createReGrantDialogBuilder", "Lflyme/support/v7/app/PermissionDialogBuilder;", "methodType", "secondaryConfirmation", "title", "privacyPolicyName", "permissionDialogClickListener", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "createRecordRequest", "Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "createRecordRequestOnline", "getOnlinePolicyVersion", "getPolicyByVersion", "versionId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPolicyData", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPolicyHistoryList", "getPolicyHistoryUrl", "getPolicyNewestPath", "localPath", "getPolicyOperate", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPolicyOperateJson", "initSDK", "policyCategoryMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "openPolicyDataByBrowser", "openPolicyDataByWebView", "openPolicyMethod", "reTryUploadRecord", "savePolicyOperate", "isOperateSuccess", "operateJson", "(Landroid/content/Context;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOnlinePolicyVersion", "(Landroid/content/Context;[Ljava/lang/String;)V", "showCustomPolicyDialog", "Lflyme/support/v7/app/AlertDialog;", "permissionKey", "permissionSummary", "reminder", "customTerms", "", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showCustomPolicyDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showDialogByCustomThemeViewBuilder", "theme", "", "customNegativeButtonText", "customPositiveButtonText", "showDialogByCustomView", "showDialogByCustomViewAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showDialogByCustomViewBuilder", "showDialogByCustomViewBuilderRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/PermissionDialogBuilder;", "showDialogUploadRecordBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/PermissionDialogBuilder;", "showNewestDialogAndUploadRecord", "dialogTitle", "isRecord", "btnNegative", "btnPositive", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showOverSeasCustomPolicyDialogAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showOverSeasPermissionPolicyDialogAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showOverSeasWithdrawConsentDialog", "showReGrantDialog", "showReGrantDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "showReGrantTwoPolicyDialog", "userPrivacyPolicyName", "userCategory", "showReGrantTwoPolicyDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;)Lflyme/support/v7/app/AlertDialog;", "uploadPolicyOperateRecord", "policyRecordRequest", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyManager {
    @NotNull
    public static final PolicyManager INSTANCE = new PolicyManager();
    @NotNull
    private static String brand;
    @NotNull
    private static final CoroutineExceptionHandler exceptionHandler = new z(CoroutineExceptionHandler.a0);
    @NotNull
    private static String mAppId = "";
    @NotNull
    private static String mAppSecret = "";
    @NotNull
    private static String mAppVersionName = "";
    @NotNull
    private static String model;
    @NotNull
    private static String osVersion;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "policySdkResultBean", "Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function1<PolicySdkResultBean, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<PolicyRecordRequest> f3147a;
        public final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Ref.ObjectRef<PolicyRecordRequest> objectRef, Context context) {
            super(1);
            this.f3147a = objectRef;
            this.b = context;
        }

        public Object invoke(Object obj) {
            PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
            Intrinsics.checkNotNullParameter(policySdkResultBean, "policySdkResultBean");
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, PolicyManager.INSTANCE.getExceptionHandler(), (CoroutineStart) null, new a(policySdkResultBean, this.f3147a, this.b, (Continuation<? super a>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    public static final class a0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3148a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ PolicyRecordRequest e;
        public final /* synthetic */ Function1<PolicySdkResultBean, Unit> f;
        public final /* synthetic */ String g;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyOperateRecordResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1$response$1", f = "PolicyManager.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PolicyOperateRecordResponse>>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f3149a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ Ref.LongRef d;
            public final /* synthetic */ PolicyRecordRequest e;
            public final /* synthetic */ String f;
            public final /* synthetic */ Ref.ObjectRef<String> g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, Ref.LongRef longRef, PolicyRecordRequest policyRecordRequest, String str2, Ref.ObjectRef<String> objectRef2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
                this.d = longRef;
                this.e = policyRecordRequest;
                this.f = str2;
                this.g = objectRef2;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f3149a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.meizu.flyme.policy.sdk.e.a aVar = com.meizu.flyme.policy.sdk.f.b.b;
                    Intrinsics.checkNotNullParameter(aVar, "apiService");
                    String str = this.b;
                    long j = this.d.element;
                    PolicyRecordRequest policyRecordRequest = this.e;
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    String brand = policyManager.getBrand();
                    String model = policyManager.getModel();
                    String osVersion = policyManager.getOsVersion();
                    String str2 = this.f;
                    this.f3149a = 1;
                    obj = aVar.a(str, (String) this.c.element, j, policyRecordRequest, brand, model, osVersion, str2, (String) this.g.element, (Continuation<? super Response<PolicyOperateRecordResponse>>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(String str, String str2, Context context, PolicyRecordRequest policyRecordRequest, Function1<? super PolicySdkResultBean, Unit> function1, String str3, Continuation<? super a0> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = str2;
            this.d = context;
            this.e = policyRecordRequest;
            this.f = function1;
            this.g = str3;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a0(this.b, this.c, this.d, this.e, this.f, this.g, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ((a0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3148a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = System.currentTimeMillis();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
                objectRef.element = companion.getAppSign(this.b, this.c, longRef.element);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                T currentCountryCode = companion.getCurrentCountryCode(this.d);
                objectRef2.element = currentCountryCode;
                PolicySdkLogUtils.Companion.d("getCurrentCountryCode", Intrinsics.stringPlus("area =", currentCountryCode));
                if (objectRef2.element != null) {
                    CoroutineDispatcher b2 = Dispatchers.b();
                    a aVar = new a(this.b, objectRef, longRef, this.e, this.g, objectRef2, (Continuation<? super a>) null);
                    this.f3148a = 1;
                    obj = BuildersKt.g(b2, aVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) obj;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("PolicyManager", Intrinsics.stringPlus("response =", response));
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            if (response.isSuccessful()) {
                companion2.d("PolicyManager", "uploadPolicyOperateRecord response isSuccessful");
                companion2.d("PolicyManager", Intrinsics.stringPlus("uploadPolicyOperateRecord response.code()=", Boxing.boxInt(response.code())));
                companion2.d("PolicyManager", Intrinsics.stringPlus("uploadPolicyOperateRecord response.body() =", (PolicyOperateRecordResponse) response.body()));
                PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) response.body();
                if (policyOperateRecordResponse != null && policyOperateRecordResponse.getCode() == 200) {
                    policySdkResultBean.setCode(0);
                } else {
                    policySdkResultBean.setCode(-1);
                    policySdkResultBean.setPolicyRecordRequest(this.e);
                }
                this.f.invoke(policySdkResultBean);
            } else {
                policySdkResultBean.setCode(-1);
                policySdkResultBean.setPolicyRecordRequest(this.e);
                this.f.invoke(policySdkResultBean);
                companion2.d("PolicyManager", "uploadPolicyOperateRecord response failed");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", i = {}, l = {736}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3150a;
        public final /* synthetic */ Ref.ObjectRef<PolicyRecordRequest> b;
        public final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<PolicyRecordRequest> objectRef, Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = context;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new b(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3150a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String json = new Gson().toJson((Object) this.b.element);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.c;
                this.f3150a = 1;
                if (policyManager.savePolicyOperate(context, false, json, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "policySdkResultBean", "Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function1<PolicySdkResultBean, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<PolicyRecordRequest> f3151a;
        public final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Ref.ObjectRef<PolicyRecordRequest> objectRef, Context context) {
            super(1);
            this.f3151a = objectRef;
            this.b = context;
        }

        public Object invoke(Object obj) {
            PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
            Intrinsics.checkNotNullParameter(policySdkResultBean, "policySdkResultBean");
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, PolicyManager.INSTANCE.getExceptionHandler(), (CoroutineStart) null, new b(policySdkResultBean, this.f3151a, this.b, (Continuation<? super b>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$autoUploadRecordOnline$2", f = "PolicyManager.kt", i = {}, l = {779}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3152a;
        public final /* synthetic */ Ref.ObjectRef<PolicyRecordRequest> b;
        public final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Ref.ObjectRef<PolicyRecordRequest> objectRef, Context context, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = context;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new d(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3152a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String json = new Gson().toJson((Object) this.b.element);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.c;
                this.f3152a = 1;
                if (policyManager.savePolicyOperate(context, false, json, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", i = {0, 0, 0, 0}, l = {923}, m = "invokeSuspend", n = {"policySdkResultBean", "area", "policyNewestPathResultBean", "version"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f3153a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ Function1<PolicySdkResultBean, Unit> k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyNewestResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$checkNewestPolicy$1$response$1", f = "PolicyManager.kt", i = {}, l = {924}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PolicyNewestResponse>>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f3154a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.LongRef e;
            public final /* synthetic */ String f;
            public final /* synthetic */ Ref.ObjectRef<Long> g;
            public final /* synthetic */ String h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, String str2, Ref.LongRef longRef, String str3, Ref.ObjectRef<Long> objectRef2, String str4, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
                this.d = str2;
                this.e = longRef;
                this.f = str3;
                this.g = objectRef2;
                this.h = str4;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f3154a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.meizu.flyme.policy.sdk.e.a aVar = com.meizu.flyme.policy.sdk.f.b.b;
                    Intrinsics.checkNotNullParameter(aVar, "apiService");
                    String str = this.b;
                    String str2 = this.d;
                    long j = this.e.element;
                    String str3 = this.f;
                    long longValue = ((Number) this.g.element).longValue();
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    String brand = policyManager.getBrand();
                    String model = policyManager.getModel();
                    String osVersion = policyManager.getOsVersion();
                    String str4 = this.h;
                    this.f3154a = 1;
                    Object a2 = aVar.a(str, (String) this.c.element, str2, j, str3, longValue, brand, model, osVersion, str4, this);
                    return a2 == coroutine_suspended ? coroutine_suspended : a2;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Context context, String str, boolean z, String str2, String str3, Function1<? super PolicySdkResultBean, Unit> function1, String str4, String str5, Continuation<? super e> continuation) {
            super(2, continuation);
            this.f = context;
            this.g = str;
            this.h = z;
            this.i = str2;
            this.j = str3;
            this.k = function1;
            this.l = str4;
            this.m = str5;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ((e) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Ref.ObjectRef objectRef;
            int i2;
            PolicySdkResultBean policySdkResultBean;
            Function1<PolicySdkResultBean, Unit> function1;
            Ref.ObjectRef objectRef2;
            String str;
            Object obj2;
            Ref.ObjectRef objectRef3;
            Ref.ObjectRef objectRef4;
            PolicyResponse data;
            PolicyData data2;
            PolicySdkResultBean policySdkResultBean2;
            String versionDesc;
            PolicySdkResultBean policySdkResultBean3;
            String contentTypes;
            PolicyResponse data3;
            PolicyResponse data4;
            PolicyResponse data5;
            Long l2;
            PolicyResponse data6;
            PolicyData data7;
            String contentTypes2;
            PolicyResponse data8;
            PolicyData data9;
            String versionDesc2;
            PolicyResponse data10;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.e;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = new PolicySdkResultBean();
                objectRef2 = new Ref.ObjectRef();
                PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
                objectRef2.element = companion.getCurrentCountryCode(this.f);
                Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
                PolicySdkFileUtils.Companion companion2 = PolicySdkFileUtils.Companion;
                objectRef5.element = companion2.isNewestPolicyFileIsExists(this.f, this.g, (String) objectRef2.element);
                PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
                companion3.d("checkNewestPolicy");
                if (PolicySdkNetworkUtil.isNetworkAvailable(this.f)) {
                    if (this.h) {
                        PolicyManager.INSTANCE.reTryUploadRecord(this.f);
                    }
                    Ref.LongRef longRef = new Ref.LongRef();
                    longRef.element = System.currentTimeMillis();
                    Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                    objectRef6.element = companion.getAppSign(this.i, this.j, longRef.element);
                    str = "checkNewestPolicy";
                    companion3.d(str, Intrinsics.stringPlus(" policyNewestPath current isExists= ", Boxing.boxBoolean(((PolicyNewestPathResultBean) objectRef5.element).isExists())));
                    Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                    if (((PolicyNewestPathResultBean) objectRef5.element).isExists()) {
                        ((PolicySdkResultBean) objectRef.element).setPolicyNewestPath(((PolicyNewestPathResultBean) objectRef5.element).getNewestPolicyPath());
                        companion3.d(str, Intrinsics.stringPlus(" policyNewestPath current = ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                        PolicyFileDataResultBean policyDataFromFileName = companion2.getPolicyDataFromFileName(((PolicyNewestPathResultBean) objectRef5.element).getNewestPolicyName());
                        T boxLong = policyDataFromFileName == null ? null : Boxing.boxLong(policyDataFromFileName.getVersion());
                        objectRef7.element = boxLong;
                        companion3.d(str, Intrinsics.stringPlus(" getPolicyUsingGET version = ", boxLong));
                        if (this.g == null || objectRef7.element == null || this.l == null) {
                            companion3.d(str, Intrinsics.stringPlus(" errorcode = ", Boxing.boxInt(((PolicySdkResultBean) objectRef.element).getCode())));
                            companion3.d(str, Intrinsics.stringPlus(" policyNewestPath errorcode result= ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                            policySdkResultBean = (PolicySdkResultBean) objectRef.element;
                            i2 = PolicySdkErrorCode.PARAMETER_LOCAL_FILE_NAME_ERROR;
                        } else {
                            CoroutineDispatcher b2 = Dispatchers.b();
                            a aVar = new a(this.i, objectRef6, this.g, longRef, this.m, objectRef7, this.l, (Continuation<? super a>) null);
                            this.f3153a = objectRef;
                            this.b = objectRef2;
                            this.c = objectRef5;
                            this.d = objectRef7;
                            this.e = 1;
                            obj2 = BuildersKt.g(b2, aVar, this);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef4 = objectRef7;
                            objectRef3 = objectRef5;
                        }
                    } else {
                        ((PolicySdkResultBean) objectRef.element).setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                        companion3.e(str, "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
                        this.k.invoke(objectRef.element);
                        return Unit.INSTANCE;
                    }
                } else {
                    String str2 = "checkNewestPolicy";
                    companion3.d(str2, " not network");
                    if (((PolicyNewestPathResultBean) objectRef5.element).isExists()) {
                        ((PolicySdkResultBean) objectRef.element).setPolicyNewestPath(((PolicyNewestPathResultBean) objectRef5.element).getNewestPolicyPath());
                        companion3.d(str2, Intrinsics.stringPlus(" policyNewestPath not network result= ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                        policySdkResultBean = (PolicySdkResultBean) objectRef.element;
                        i2 = PolicySdkErrorCode.NOT_NETWORK;
                    } else {
                        ((PolicySdkResultBean) objectRef.element).setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                        companion3.e(str2, "-10001参数错误，请使用PolicySdk.initSDK 初始化");
                        function1 = this.k;
                        function1.invoke(objectRef.element);
                        return Unit.INSTANCE;
                    }
                }
                policySdkResultBean.setCode(i2);
                function1 = this.k;
                function1.invoke(objectRef.element);
                return Unit.INSTANCE;
            } else if (i3 == 1) {
                objectRef4 = (Ref.ObjectRef) this.d;
                objectRef3 = (Ref.ObjectRef) this.c;
                objectRef2 = (Ref.ObjectRef) this.b;
                objectRef = (Ref.ObjectRef) this.f3153a;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                str = "checkNewestPolicy";
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) obj2;
            if (response.isSuccessful()) {
                PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) response.body();
                ((PolicySdkResultBean) objectRef.element).setPolicyNewest(Intrinsics.areEqual((Object) (policyNewestResponse == null || (data10 = policyNewestResponse.getData()) == null) ? null : Boxing.boxBoolean(data10.getNewest()), (Object) Boxing.boxBoolean(true)));
                PolicyNewestResponse policyNewestResponse2 = (PolicyNewestResponse) response.body();
                if (policyNewestResponse2 != null && (data5 = policyNewestResponse2.getData()) != null && data5.getNewest() && ((l2 = (Long) objectRef4.element) == null || l2.longValue() != 0)) {
                    PolicySdkLogUtils.Companion companion4 = PolicySdkLogUtils.Companion;
                    companion4.d(str, Intrinsics.stringPlus(" policyNewestPath newest is true result= ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                    if (((PolicyNewestPathResultBean) objectRef3.element).isExists()) {
                        ((PolicySdkResultBean) objectRef.element).setPolicyNewestPath(((PolicyNewestPathResultBean) objectRef3.element).getNewestPolicyPath());
                        ((PolicySdkResultBean) objectRef.element).setCode(0);
                        PolicyNewestResponse policyNewestResponse3 = (PolicyNewestResponse) response.body();
                        if (!(policyNewestResponse3 == null || (data8 = policyNewestResponse3.getData()) == null || (data9 = data8.getData()) == null || (versionDesc2 = data9.getVersionDesc()) == null)) {
                            ((PolicySdkResultBean) objectRef.element).setVersionDesc(versionDesc2);
                        }
                        PolicyNewestResponse policyNewestResponse4 = (PolicyNewestResponse) response.body();
                        if (!(policyNewestResponse4 == null || (data6 = policyNewestResponse4.getData()) == null || (data7 = data6.getData()) == null || (contentTypes2 = data7.getContentTypes()) == null)) {
                            ((PolicySdkResultBean) objectRef.element).setContentTypes(contentTypes2);
                        }
                        function1 = this.k;
                        function1.invoke(objectRef.element);
                        return Unit.INSTANCE;
                    }
                    ((PolicySdkResultBean) objectRef.element).setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    companion4.e(str, "-10001参数错误，请使用PolicySdk.initSDK 初始化");
                    this.k.invoke(objectRef.element);
                    return Unit.INSTANCE;
                }
                PolicySdkLogUtils.Companion companion5 = PolicySdkLogUtils.Companion;
                PolicyNewestResponse policyNewestResponse5 = (PolicyNewestResponse) response.body();
                companion5.d("getNewestPolicyPath", Intrinsics.stringPlus("response.body()?.data?.data = ", policyNewestResponse5 == null ? null : policyNewestResponse5.getData()));
                PolicyNewestResponse policyNewestResponse6 = (PolicyNewestResponse) response.body();
                companion5.d("getNewestPolicyPath", Intrinsics.stringPlus("response.body()?.data?.data = ", (policyNewestResponse6 == null || (data4 = policyNewestResponse6.getData()) == null) ? null : data4.getData()));
                PolicyNewestResponse policyNewestResponse7 = (PolicyNewestResponse) response.body();
                if (((policyNewestResponse7 == null || (data3 = policyNewestResponse7.getData()) == null) ? null : data3.getData()) != null) {
                    companion5.d("getNewestPolicyPath", "  save path return ");
                    PolicyNewestResponse policyNewestResponse8 = (PolicyNewestResponse) response.body();
                    if (!(policyNewestResponse8 == null || (data = policyNewestResponse8.getData()) == null || (data2 = data.getData()) == null)) {
                        String str3 = this.g;
                        Context context = this.f;
                        function1 = this.k;
                        String policyUrl = data2.getPolicyUrl();
                        String str4 = str3 + '_' + ((String) objectRef2.element) + '_' + data2.getVersion() + ".html";
                        long version = (long) data2.getVersion();
                        if (str3 != null) {
                            PolicySdkFileUtils.Companion companion6 = PolicySdkFileUtils.Companion;
                            String str5 = str4;
                            if (companion6.savePolicyByUrl(context, str3, policyUrl, (String) objectRef2.element, version)) {
                                String policyFolderCachePath = companion6.getPolicyFolderCachePath(context, str3, (String) objectRef2.element);
                                if (((PolicyNewestPathResultBean) objectRef3.element).isExists()) {
                                    companion6.deleteFile(((PolicyNewestPathResultBean) objectRef3.element).getNewestPolicyPath());
                                }
                                ((PolicySdkResultBean) objectRef.element).setPolicyNewestPath(policyFolderCachePath + '/' + str5);
                                companion5.d("getNewestPolicyPath", Intrinsics.stringPlus(" policyNewestPath update result= ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                                boolean z = false;
                                ((PolicySdkResultBean) objectRef.element).setCode(0);
                                PolicySdkResultBean policySdkResultBean4 = (PolicySdkResultBean) objectRef.element;
                                if (data2.getRegrantFlag() == 1) {
                                    z = true;
                                }
                                policySdkResultBean4.setPolicyRegrantFlag(z);
                                if (data2.getVersionDesc() == null) {
                                    policySdkResultBean2 = (PolicySdkResultBean) objectRef.element;
                                    versionDesc = "";
                                } else {
                                    policySdkResultBean2 = (PolicySdkResultBean) objectRef.element;
                                    versionDesc = data2.getVersionDesc();
                                }
                                policySdkResultBean2.setVersionDesc(versionDesc);
                                if (data2.getContentTypes() == null) {
                                    policySdkResultBean3 = (PolicySdkResultBean) objectRef.element;
                                    contentTypes = "BASIC_INFO";
                                } else {
                                    policySdkResultBean3 = (PolicySdkResultBean) objectRef.element;
                                    contentTypes = data2.getContentTypes();
                                }
                                policySdkResultBean3.setContentTypes(contentTypes);
                                function1.invoke(objectRef.element);
                                companion6.saveOtherAreaPolicyByUrl(context, str3, (String) objectRef2.element);
                            }
                        }
                        companion5.d(str, "  savePolicyByUrl false ");
                        ((PolicySdkResultBean) objectRef.element).setCode(-1);
                        function1.invoke(objectRef.element);
                    }
                    return Unit.INSTANCE;
                }
                i2 = -1;
                companion5.d(str, "  direct return ");
                companion5.d(str, "response.body()?.data?.data == null");
                policySdkResultBean = (PolicySdkResultBean) objectRef.element;
            } else {
                ((PolicySdkResultBean) objectRef.element).setPolicyNewestPath(((PolicyNewestPathResultBean) objectRef3.element).getNewestPolicyPath());
                PolicySdkLogUtils.Companion.d(str, Intrinsics.stringPlus(" policyNewestPath fail result= ", ((PolicySdkResultBean) objectRef.element).getPolicyNewestPath()));
                policySdkResultBean = (PolicySdkResultBean) objectRef.element;
                i2 = -1;
            }
            policySdkResultBean.setCode(i2);
            function1 = this.k;
            function1.invoke(objectRef.element);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getOnlinePolicyVersion$1", f = "PolicyManager.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3155a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements Flow<String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Flow f3156a;
            public final /* synthetic */ String b;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: com.meizu.flyme.policy.sdk.PolicyManager$f$a$a  reason: collision with other inner class name */
            public static final class C0017a<T> implements FlowCollector, SuspendFunction {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FlowCollector f3157a;
                public final /* synthetic */ String b;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getOnlinePolicyVersion$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: com.meizu.flyme.policy.sdk.PolicyManager$f$a$a$a  reason: collision with other inner class name */
                public static final class C0018a extends ContinuationImpl {

                    /* renamed from: a  reason: collision with root package name */
                    public /* synthetic */ Object f3158a;
                    public int b;
                    public final /* synthetic */ C0017a c;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public C0018a(C0017a aVar, Continuation continuation) {
                        super(continuation);
                        this.c = aVar;
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f3158a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return this.c.emit((Object) null, this);
                    }
                }

                public C0017a(FlowCollector flowCollector, String str) {
                    this.f3157a = flowCollector;
                    this.b = str;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.meizu.flyme.policy.sdk.PolicyManager.f.a.C0017a.C0018a
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.meizu.flyme.policy.sdk.PolicyManager$f$a$a$a r0 = (com.meizu.flyme.policy.sdk.PolicyManager.f.a.C0017a.C0018a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L_0x0018
                    L_0x0013:
                        com.meizu.flyme.policy.sdk.PolicyManager$f$a$a$a r0 = new com.meizu.flyme.policy.sdk.PolicyManager$f$a$a$a
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f3158a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x004b
                    L_0x0029:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L_0x0031:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f3157a
                        androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                        java.lang.String r4 = r4.b
                        androidx.datastore.preferences.core.Preferences$Key r4 = androidx.datastore.preferences.core.PreferencesKeys.f(r4)
                        java.lang.Object r4 = r5.c(r4)
                        r0.b = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L_0x004b
                        return r1
                    L_0x004b:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.f.a.C0017a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            public a(Flow flow, String str) {
                this.f3156a = flow;
                this.b = str;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object collect = this.f3156a.collect(new C0017a(flowCollector, this.b), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Context context, String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new f(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3155a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = new a(d.a(this.b).getData(), this.c);
                this.f3155a = 1;
                obj = FlowKt.w(aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String valueOf = String.valueOf(obj);
            return Intrinsics.areEqual((Object) valueOf, (Object) "null") ? PolicySdkFileUtils.Companion.getPolicyVersion(this.b, this.c) : valueOf;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", i = {0}, l = {1435}, m = "invokeSuspend", n = {"policySdkResultBean"}, s = {"L$0"})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f3159a;
        public int b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Function1<PolicySdkResultBean, PolicySdkResultBean> g;
        public final /* synthetic */ String h;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyVersionResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyByVersion$1$response$1", f = "PolicyManager.kt", i = {}, l = {1437}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PolicyVersionResponse>>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f3160a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ Ref.LongRef d;
            public final /* synthetic */ String e;
            public final /* synthetic */ Long f;
            public final /* synthetic */ String g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, Ref.LongRef longRef, String str2, Long l, String str3, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
                this.d = longRef;
                this.e = str2;
                this.f = l;
                this.g = str3;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f3160a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
                    com.meizu.flyme.policy.sdk.e.a aVar = com.meizu.flyme.policy.sdk.f.b.b;
                    Intrinsics.checkNotNullParameter(aVar, "apiService");
                    String str = this.b;
                    long j = this.d.element;
                    String str2 = this.e;
                    long longValue = this.f.longValue();
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    String brand = policyManager.getBrand();
                    String model = policyManager.getModel();
                    String osVersion = policyManager.getOsVersion();
                    String str3 = this.g;
                    this.f3160a = 1;
                    Object a2 = aVar.a(str, (String) this.c.element, j, str2, longValue, brand, model, osVersion, str3, (Continuation<? super Response<PolicyVersionResponse>>) this);
                    return a2 == coroutine_suspended ? coroutine_suspended : a2;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Long l, String str, String str2, String str3, Function1<? super PolicySdkResultBean, PolicySdkResultBean> function1, String str4, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = l;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = function1;
            this.h = str4;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.c, this.d, this.e, this.f, this.g, this.h, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ((g) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            PolicySdkResultBean policySdkResultBean;
            PolicySdkResultBean policySdkResultBean2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                policySdkResultBean = new PolicySdkResultBean();
                if (this.c == null || this.d == null) {
                    policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean.getCode())));
                    this.g.invoke(policySdkResultBean);
                    return Unit.INSTANCE;
                }
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = System.currentTimeMillis();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = PolicySdkToolsUtils.Companion.getAppSign(this.e, this.f, longRef.element);
                CoroutineDispatcher b2 = Dispatchers.b();
                a aVar = new a(this.e, objectRef, longRef, this.h, this.c, this.d, (Continuation<? super a>) null);
                this.f3159a = policySdkResultBean;
                this.b = 1;
                Object g2 = BuildersKt.g(b2, aVar, this);
                if (g2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                policySdkResultBean2 = policySdkResultBean;
                obj = g2;
            } else if (i == 1) {
                policySdkResultBean2 = (PolicySdkResultBean) this.f3159a;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    th.getMessage();
                    companion.e("PolicyManager", Intrinsics.stringPlus("exception : ", th));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) obj;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("PolicyManager", Intrinsics.stringPlus("response", response));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (response.isSuccessful()) {
                companion2.d("PolicyManager", "response isSuccessful");
                companion2.d("PolicyManager", Intrinsics.stringPlus("response.code()=", Boxing.boxInt(response.code())));
                companion2.d("PolicyManager", Intrinsics.stringPlus("response.body() =", response.body()));
                T t = (PolicyVersionResponse) response.body();
                if (t != null) {
                    objectRef2.element = t;
                }
            } else {
                companion2.d("PolicyManager", "response failed");
            }
            policySdkResultBean2.setCode(0);
            PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) objectRef2.element;
            if (policyVersionResponse != null) {
                PolicyData data = policyVersionResponse.getData();
                if (data != null) {
                    policySdkResultBean2.setPolicyData(data);
                }
            }
            companion2.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean2.getCode())));
            policySdkResultBean = policySdkResultBean2;
            this.g.invoke(policySdkResultBean);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", i = {0}, l = {1278}, m = "invokeSuspend", n = {"policySdkResultBean"}, s = {"L$0"})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f3161a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Function1<PolicySdkResultBean, Unit> h;
        public final /* synthetic */ String i;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyNewestResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyData$1$response$1", f = "PolicyManager.kt", i = {}, l = {1280}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PolicyNewestResponse>>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f3162a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.LongRef e;
            public final /* synthetic */ String f;
            public final /* synthetic */ Long g;
            public final /* synthetic */ String h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, String str2, Ref.LongRef longRef, String str3, Long l, String str4, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
                this.d = str2;
                this.e = longRef;
                this.f = str3;
                this.g = l;
                this.h = str4;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f3162a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PolicySdkLogUtils.Companion.d("getPolicyData", "getPolicyUsingGET");
                    com.meizu.flyme.policy.sdk.e.a aVar = com.meizu.flyme.policy.sdk.f.b.b;
                    Intrinsics.checkNotNullParameter(aVar, "apiService");
                    String str = this.b;
                    String str2 = this.d;
                    long j = this.e.element;
                    String str3 = this.f;
                    long longValue = this.g.longValue();
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    String brand = policyManager.getBrand();
                    String model = policyManager.getModel();
                    String osVersion = policyManager.getOsVersion();
                    String str4 = this.h;
                    this.f3162a = 1;
                    Object a2 = aVar.a(str, (String) this.c.element, str2, j, str3, longValue, brand, model, osVersion, str4, this);
                    return a2 == coroutine_suspended ? coroutine_suspended : a2;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, Long l, String str2, String str3, String str4, Function1<? super PolicySdkResultBean, Unit> function1, String str5, Continuation<? super h> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = l;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = function1;
            this.i = str5;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.c, this.d, this.e, this.f, this.g, this.h, this.i, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ((h) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            PolicySdkResultBean policySdkResultBean;
            Object obj2;
            PolicySdkResultBean policySdkResultBean2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                policySdkResultBean = new PolicySdkResultBean();
                if (this.c == null || this.d == null || this.e == null) {
                    policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean.getCode())));
                    this.h.invoke(policySdkResultBean);
                    return Unit.INSTANCE;
                }
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = System.currentTimeMillis();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = PolicySdkToolsUtils.Companion.getAppSign(this.f, this.g, longRef.element);
                CoroutineDispatcher b2 = Dispatchers.b();
                a aVar = r8;
                a aVar2 = new a(this.f, objectRef, this.c, longRef, this.i, this.d, this.e, (Continuation<? super a>) null);
                this.f3161a = policySdkResultBean;
                this.b = 1;
                obj2 = BuildersKt.g(b2, aVar, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                policySdkResultBean2 = policySdkResultBean;
            } else if (i2 == 1) {
                policySdkResultBean2 = (PolicySdkResultBean) this.f3161a;
                try {
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                } catch (Throwable th) {
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    th.getMessage();
                    companion.e("PolicyManager", Intrinsics.stringPlus("Throwable : ", th));
                    PolicySdkResultBean policySdkResultBean3 = new PolicySdkResultBean();
                    policySdkResultBean3.setCode(PolicySdkErrorCode.NETWORK_ERROR);
                    this.h.invoke(policySdkResultBean3);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) obj2;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("getPolicyData", Intrinsics.stringPlus("response", response));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (response.isSuccessful()) {
                PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) response.body();
                if (policyNewestResponse != null) {
                    if (policyNewestResponse.getCode() == 200) {
                        companion2.d("getPolicyData", "response isSuccessful");
                        companion2.d("getPolicyData", Intrinsics.stringPlus("response.code()=", Boxing.boxInt(response.code())));
                        companion2.d("PolicyManager", Intrinsics.stringPlus("response.body() =", response.body()));
                        T t = (PolicyNewestResponse) response.body();
                        if (t != null) {
                            objectRef2.element = t;
                        }
                        PolicyNewestResponse policyNewestResponse2 = (PolicyNewestResponse) objectRef2.element;
                        if (policyNewestResponse2 != null) {
                            policySdkResultBean2.setCode(0);
                            PolicyResponse data = policyNewestResponse2.getData();
                            if (data != null) {
                                PolicyData data2 = data.getData();
                                if (data2 != null) {
                                    policySdkResultBean2.setPolicyData(data2);
                                    policySdkResultBean2.setPolicyUrl(data2.getPolicyUrl());
                                    policySdkResultBean2.setPolicyNewestVersion((long) data2.getVersion());
                                }
                            }
                            PolicyResponse data3 = policyNewestResponse2.getData();
                            if (data3 != null) {
                                policySdkResultBean2.setPolicyNewest(Boxing.boxBoolean(data3.getNewest()).booleanValue());
                            }
                        }
                        companion2.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean2.getCode())));
                        policySdkResultBean = policySdkResultBean2;
                        this.h.invoke(policySdkResultBean);
                        return Unit.INSTANCE;
                    }
                }
            }
            policySdkResultBean2.setCode(-1);
            companion2.d("PolicyManager", "response failed");
            companion2.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean2.getCode())));
            policySdkResultBean = policySdkResultBean2;
            this.h.invoke(policySdkResultBean);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", i = {0}, l = {1364}, m = "invokeSuspend", n = {"policySdkResultBean"}, s = {"L$0"})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f3163a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Function1<PolicySdkResultBean, PolicySdkResultBean> g;
        public final /* synthetic */ String h;
        public final /* synthetic */ long i;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyHistoryList$1$response$1", f = "PolicyManager.kt", i = {}, l = {1366}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PolicyHistoryListResponse>>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f3164a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.LongRef e;
            public final /* synthetic */ String f;
            public final /* synthetic */ long g;
            public final /* synthetic */ String h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, String str2, Ref.LongRef longRef, String str3, long j, String str4, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
                this.d = str2;
                this.e = longRef;
                this.f = str3;
                this.g = j;
                this.h = str4;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f3164a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
                    com.meizu.flyme.policy.sdk.e.a aVar = com.meizu.flyme.policy.sdk.f.b.b;
                    Intrinsics.checkNotNullParameter(aVar, "apiService");
                    String str = this.b;
                    String str2 = this.d;
                    long j = this.e.element;
                    String str3 = this.f;
                    long j2 = this.g;
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    String brand = policyManager.getBrand();
                    String model = policyManager.getModel();
                    String osVersion = policyManager.getOsVersion();
                    String str4 = this.h;
                    this.f3164a = 1;
                    Object b2 = aVar.b(str, (String) this.c.element, str2, j, str3, j2, brand, model, osVersion, str4, this);
                    return b2 == coroutine_suspended ? coroutine_suspended : b2;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, String str2, String str3, String str4, Function1<? super PolicySdkResultBean, PolicySdkResultBean> function1, String str5, long j, Continuation<? super i> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = function1;
            this.h = str5;
            this.i = j;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new i(this.c, this.d, this.e, this.f, this.g, this.h, this.i, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ((i) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            PolicySdkResultBean policySdkResultBean;
            Object obj2;
            PolicySdkResultBean policySdkResultBean2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                policySdkResultBean = new PolicySdkResultBean();
                if (this.c == null || this.d == null) {
                    policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean.getCode())));
                    this.g.invoke(policySdkResultBean);
                    return Unit.INSTANCE;
                }
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = System.currentTimeMillis();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = PolicySdkToolsUtils.Companion.getAppSign(this.e, this.f, longRef.element);
                CoroutineDispatcher b2 = Dispatchers.b();
                a aVar = r7;
                a aVar2 = new a(this.e, objectRef, this.c, longRef, this.h, this.i, this.d, (Continuation<? super a>) null);
                this.f3163a = policySdkResultBean;
                this.b = 1;
                obj2 = BuildersKt.g(b2, aVar, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                policySdkResultBean2 = policySdkResultBean;
            } else if (i2 == 1) {
                policySdkResultBean2 = (PolicySdkResultBean) this.f3163a;
                try {
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                } catch (Throwable th) {
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    th.getMessage();
                    companion.e("PolicyManager", Intrinsics.stringPlus("exception : ", th));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) obj2;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("PolicyManager", Intrinsics.stringPlus("response", response));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (response.isSuccessful()) {
                companion2.d("PolicyManager", "response isSuccessful");
                companion2.d("PolicyManager", Intrinsics.stringPlus("response.code()=", Boxing.boxInt(response.code())));
                companion2.d("PolicyManager", Intrinsics.stringPlus("response.body() =", response.body()));
                T t = (PolicyHistoryListResponse) response.body();
                if (t != null) {
                    objectRef2.element = t;
                }
            } else {
                companion2.d("PolicyManager", "response failed");
            }
            policySdkResultBean2.setCode(0);
            PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) objectRef2.element;
            if (policyHistoryListResponse != null) {
                policySdkResultBean2.setPolicyHistoryListResponse(policyHistoryListResponse);
            }
            companion2.e("PolicyManager", Intrinsics.stringPlus("return policySdkResultBean = : ", Boxing.boxInt(policySdkResultBean2.getCode())));
            policySdkResultBean = policySdkResultBean2;
            this.g.invoke(policySdkResultBean);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class j implements Flow<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Flow f3165a;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a<T> implements FlowCollector, SuspendFunction {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FlowCollector f3166a;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1$2", f = "PolicyManager.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
            /* renamed from: com.meizu.flyme.policy.sdk.PolicyManager$j$a$a  reason: collision with other inner class name */
            public static final class C0019a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f3167a;
                public int b;
                public final /* synthetic */ a c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0019a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.c = aVar;
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f3167a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.c.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f3166a = flowCollector;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.meizu.flyme.policy.sdk.PolicyManager.j.a.C0019a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.meizu.flyme.policy.sdk.PolicyManager$j$a$a r0 = (com.meizu.flyme.policy.sdk.PolicyManager.j.a.C0019a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.meizu.flyme.policy.sdk.PolicyManager$j$a$a r0 = new com.meizu.flyme.policy.sdk.PolicyManager$j$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f3167a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0047
                L_0x0029:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r4 = r4.f3166a
                    androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                    androidx.datastore.preferences.core.Preferences$Key<java.lang.Boolean> r6 = com.meizu.flyme.policy.sdk.d.c
                    java.lang.Object r5 = r5.c(r6)
                    r0.b = r3
                    java.lang.Object r4 = r4.emit(r5, r0)
                    if (r4 != r1) goto L_0x0047
                    return r1
                L_0x0047:
                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.j.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public j(Flow flow) {
            this.f3165a = flow;
        }

        @Nullable
        public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
            Object collect = this.f3165a.collect(new a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager", f = "PolicyManager.kt", i = {}, l = {106}, m = "getPolicyOperate", n = {}, s = {})
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f3168a;
        public final /* synthetic */ PolicyManager b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(PolicyManager policyManager, Continuation<? super k> continuation) {
            super(continuation);
            this.b = policyManager;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f3168a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.getPolicyOperate((Context) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class l implements Flow<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Flow f3169a;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a<T> implements FlowCollector, SuspendFunction {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FlowCollector f3170a;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2", f = "PolicyManager.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
            /* renamed from: com.meizu.flyme.policy.sdk.PolicyManager$l$a$a  reason: collision with other inner class name */
            public static final class C0020a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f3171a;
                public int b;
                public final /* synthetic */ a c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0020a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.c = aVar;
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f3171a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.c.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f3170a = flowCollector;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.meizu.flyme.policy.sdk.PolicyManager.l.a.C0020a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.meizu.flyme.policy.sdk.PolicyManager$l$a$a r0 = (com.meizu.flyme.policy.sdk.PolicyManager.l.a.C0020a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.meizu.flyme.policy.sdk.PolicyManager$l$a$a r0 = new com.meizu.flyme.policy.sdk.PolicyManager$l$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f3171a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0047
                L_0x0029:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r4 = r4.f3170a
                    androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                    androidx.datastore.preferences.core.Preferences$Key<java.lang.String> r6 = com.meizu.flyme.policy.sdk.d.d
                    java.lang.Object r5 = r5.c(r6)
                    r0.b = r3
                    java.lang.Object r4 = r4.emit(r5, r0)
                    if (r4 != r1) goto L_0x0047
                    return r1
                L_0x0047:
                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.l.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public l(Flow flow) {
            this.f3169a = flow;
        }

        @Nullable
        public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
            Object collect = this.f3169a.collect(new a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", i = {1}, l = {662, 665}, m = "invokeSuspend", n = {"isNeedReTry"}, s = {"I$0"})
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3172a;
        public int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ PolicyManager d;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "policySdkResultBean", "Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a extends Lambda implements Function1<PolicySdkResultBean, Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PolicyManager f3173a;
            public final /* synthetic */ Context b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(PolicyManager policyManager, Context context) {
                super(1);
                this.f3173a = policyManager;
                this.b = context;
            }

            public Object invoke(Object obj) {
                PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
                Intrinsics.checkNotNullParameter(policySdkResultBean, "policySdkResultBean");
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                if (policySdkResultBean.getCode() == 0) {
                    Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, PolicyManager.INSTANCE.getExceptionHandler(), (CoroutineStart) null, new c(this.f3173a, this.b, objectRef, (Continuation<? super c>) null), 2, (Object) null);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Context context, PolicyManager policyManager, Continuation<? super m> continuation) {
            super(2, continuation);
            this.c = context;
            this.d = policyManager;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new m(this.c, this.d, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new m(this.c, this.d, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.b
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0024
                if (r1 == r5) goto L_0x0020
                if (r1 != r4) goto L_0x0018
                int r0 = r12.f3172a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x005b
            L_0x0018:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L_0x0020:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x0034
            L_0x0024:
                kotlin.ResultKt.throwOnFailure(r13)
                com.meizu.flyme.policy.sdk.PolicyManager r13 = com.meizu.flyme.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r12.c
                r12.b = r5
                java.lang.Object r13 = r13.getPolicyOperate(r1, r12)
                if (r13 != r0) goto L_0x0034
                return r0
            L_0x0034:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                r13 = r13 ^ r5
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
                java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r6)
                r1.d(r3, r6)
                if (r13 == 0) goto L_0x00a5
                com.meizu.flyme.policy.sdk.PolicyManager r1 = com.meizu.flyme.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r6 = r12.c
                r12.f3172a = r13
                r12.b = r4
                java.lang.Object r1 = r1.getPolicyOperateJson(r6, r12)
                if (r1 != r0) goto L_0x0059
                return r0
            L_0x0059:
                r0 = r13
                r13 = r1
            L_0x005b:
                java.lang.String r13 = (java.lang.String) r13
                if (r13 == 0) goto L_0x00a5
                int r1 = r13.length()
                if (r1 <= 0) goto L_0x00a5
                com.google.gson.Gson r1 = new com.google.gson.Gson
                r1.<init>()
                java.lang.Class<com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest> r4 = com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest.class
                java.lang.Object r13 = r1.fromJson((java.lang.String) r13, r4)
                r10 = r13
                com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest r10 = (com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest) r10
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r13 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion
                if (r0 == 0) goto L_0x0078
                goto L_0x0079
            L_0x0078:
                r5 = 0
            L_0x0079:
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
                r13.d(r3, r0)
                android.content.Context r6 = r12.c
                com.meizu.flyme.policy.sdk.PolicyManager r13 = com.meizu.flyme.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r7 = r13.getMAppId()
                java.lang.String r8 = r13.getMAppSecret()
                java.lang.String r9 = r13.getMAppVersionName()
                java.lang.String r13 = "policyRecordRequest"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
                com.meizu.flyme.policy.sdk.PolicyManager$m$a r11 = new com.meizu.flyme.policy.sdk.PolicyManager$m$a
                com.meizu.flyme.policy.sdk.PolicyManager r13 = r12.d
                android.content.Context r12 = r12.c
                r11.<init>(r13, r12)
                com.meizu.flyme.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r6, r7, r8, r9, r10, r11)
            L_0x00a5:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager", f = "PolicyManager.kt", i = {0, 0, 0}, l = {80, 84}, m = "savePolicyOperate", n = {"context", "operateJson", "isOperateSuccess"}, s = {"L$0", "L$1", "Z$0"})
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f3174a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public final /* synthetic */ PolicyManager e;
        public int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(PolicyManager policyManager, Continuation<? super n> continuation) {
            super(continuation);
            this.e = policyManager;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.savePolicyOperate((Context) null, false, (String) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "policy_sdk_data", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f3175a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(boolean z, Continuation<? super o> continuation) {
            super(2, continuation);
            this.b = z;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            o oVar = new o(this.b, continuation);
            oVar.f3175a = obj;
            return oVar;
        }

        public Object invoke(Object obj, Object obj2) {
            o oVar = new o(this.b, (Continuation) obj2);
            oVar.f3175a = (MutablePreferences) obj;
            return oVar.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.f3175a).k(d.c, Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "policy_sdk_data", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class p extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f3176a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(String str, Continuation<? super p> continuation) {
            super(2, continuation);
            this.b = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            p pVar = new p(this.b, continuation);
            pVar.f3176a = obj;
            return pVar;
        }

        public Object invoke(Object obj, Object obj2) {
            p pVar = new p(this.b, (Continuation) obj2);
            pVar.f3176a = (MutablePreferences) obj;
            return pVar.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f3176a;
            Preferences.Key<String> key = d.d;
            String str = this.b;
            if (str == null) {
                str = "";
            }
            mutablePreferences.k(key, str);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$setOnlinePolicyVersion$1$1", f = "PolicyManager.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class q extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3177a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef<String> d;

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "policy_sdk_data", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$setOnlinePolicyVersion$1$1$1", f = "PolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ Object f3178a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Ref.ObjectRef<String> c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, Ref.ObjectRef<String> objectRef, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = str;
                this.c = objectRef;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                a aVar = new a(this.b, this.c, continuation);
                aVar.f3178a = obj;
                return aVar;
            }

            public Object invoke(Object obj, Object obj2) {
                a aVar = new a(this.b, this.c, (Continuation) obj2);
                aVar.f3178a = (MutablePreferences) obj;
                return aVar.invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                ((MutablePreferences) this.f3178a).k(PreferencesKeys.f(this.b), this.c.element);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(Context context, String str, Ref.ObjectRef<String> objectRef, Continuation<? super q> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = str;
            this.d = objectRef;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new q(this.b, this.c, this.d, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new q(this.b, this.c, this.d, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3177a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DataStore a2 = d.a(this.b);
                a aVar = new a(this.c, this.d, (Continuation<? super a>) null);
                this.f3177a = 1;
                if (PreferencesKt.a(a2, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    companion.e("setOnlinePolicyVersion", "error =" + e + ' ');
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showCustomPolicyDialogAndUploadRecord$builder$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class r implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3179a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public r(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3179a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            String str = z2 ? "2" : "0";
            if (z2) {
                PolicyManager.autoUploadRecord(this.f3179a, this.b, this.c, this.d, this.e, this.f, str);
            }
            this.g.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showDialogByCustomViewBuilderRecord$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class s implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3180a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public s(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3180a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            PolicyManager.autoUploadRecord(this.f3180a, this.b, this.c, this.d, this.e, this.f, z2 ? "2" : "0");
            this.g.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showDialogUploadRecordBuilder$builder$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class t implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3181a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener h;

        public t(Context context, String str, String str2, String str3, String[] strArr, String str4, String str5, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3181a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = str5;
            this.h = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            if (z2) {
                PolicyManager.autoUploadRecord(this.f3181a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
            this.h.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showNewestDialogAndUploadRecord$builder$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class u implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f3182a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String[] f;
        public final /* synthetic */ String g;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener h;

        public u(boolean z, Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3182a = z;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = strArr;
            this.g = str4;
            this.h = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            if (z2 && this.f3182a) {
                PolicyManager.autoUploadRecord(this.b, this.c, this.d, this.e, this.f, this.g, "2");
            }
            this.h.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showOverSeasCustomPolicyDialogAndUploadRecord$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class v implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3183a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public v(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3183a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            String str = z2 ? "2" : "0";
            if (z2) {
                PolicyManager.autoUploadRecordOnline(this.f3183a, this.b, this.c, this.d, this.e, this.f, str);
            }
            this.g.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showOverSeasPermissionPolicyDialogAndUploadRecord$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "map", "", "", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class w implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3184a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public w(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3184a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2, @Nullable Map<String, Boolean> map) {
            String str = z2 ? "2" : "0";
            if (z2) {
                PolicyManager.autoUploadRecordOnline(this.f3184a, this.b, this.c, this.d, this.e, this.f, str);
            }
            this.g.onPermissionClick(dialogInterface, z, z2, map);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showReGrantDialogAndUploadRecord$builder$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class x implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3185a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public x(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3185a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            PolicyManager.autoUploadRecord(this.f3185a, this.b, this.c, this.d, this.e, this.f, z2 ? "2" : "0");
            this.g.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/meizu/flyme/policy/sdk/PolicyManager$showReGrantTwoPolicyDialogAndUploadRecord$builder$1", "Lflyme/support/v7/app/PermissionDialogBuilder$OnPermissionClickListener;", "onPermissionClick", "", "dialog", "Landroid/content/DialogInterface;", "alwaysDeny", "", "allow", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class y implements PermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3186a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PermissionDialogBuilder.OnPermissionClickListener g;

        public y(Context context, String str, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f3186a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = strArr;
            this.f = str4;
            this.g = onPermissionClickListener;
        }

        public void onPermissionClick(@Nullable DialogInterface dialogInterface, boolean z, boolean z2) {
            PolicyManager.autoUploadRecord(this.f3186a, this.b, this.c, this.d, this.e, this.f, z2 ? "2" : "0");
            this.g.onPermissionClick(dialogInterface, z, z2);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class z extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public z(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("exceptionHandler", coroutineContext.get(CoroutineName.b) + " 处理异常 ：" + th);
        }
    }

    static {
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
        brand = companion.getDeviceBrand();
        model = companion.getSystemModel();
        osVersion = companion.getSystemVersion();
    }

    private PolicyManager() {
    }

    @JvmStatic
    public static final void autoUploadRecord(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String[] strArr, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "versionName");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str5, "operationType");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = createRecordRequest(context, strArr, str4, str5);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(context, str, str2, str3, (PolicyRecordRequest) objectRef.element, new a(objectRef, context));
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new b(objectRef, context, (Continuation<? super b>) null), 2, (Object) null);
    }

    @JvmStatic
    public static final void autoUploadRecordOnline(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String[] strArr, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "versionName");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str5, "operationType");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = createRecordRequestOnline(context, strArr, str4, str5);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(context, str, str2, str3, (PolicyRecordRequest) objectRef.element, new c(objectRef, context));
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new d(objectRef, context, (Continuation<? super d>) null), 2, (Object) null);
    }

    @JvmStatic
    public static final void checkNewestPolicy(@NotNull Context context, boolean z2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Function1<? super PolicySdkResultBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "appSecret");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "language");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "category");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "versionName");
        Function1<? super PolicySdkResultBean, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callBackPolicyResult");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new e(context, str8, z2, str, str6, function12, str9, str7, (Continuation<? super e>) null), 2, (Object) null);
    }

    @JvmStatic
    @NotNull
    public static final String copyPolicyFile(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "toPath");
        String currentCountryCode = PolicySdkToolsUtils.Companion.getCurrentCountryCode(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean isNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, str, currentCountryCode);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("copyPolicyFile", Intrinsics.stringPlus("policyNewestPathResultBean.isExists = ", Boolean.valueOf(isNewestPolicyFileIsExists.isExists())));
        String copyPolicyFile = isNewestPolicyFileIsExists.isExists() ? companion.copyPolicyFile(isNewestPolicyFileIsExists.getNewestPolicyPath(), str2) : "";
        companion2.d("copyPolicyFile", Intrinsics.stringPlus("successPath = ", copyPolicyFile));
        return copyPolicyFile;
    }

    private final PermissionDialogBuilder createReGrantDialogBuilder(Context context, boolean z2, boolean z3, String str, String str2, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PermissionDialogBuilder showPrivacyPolicy = new PermissionDialogBuilder(context).setPrivacyPolicyName(str2).setAppName(str).setOnPermissionListener(onPermissionClickListener).setSecondaryConfirmation(z3).showPrivacyPolicy(new g(context, z2, str2, str3));
        Intrinsics.checkNotNullExpressionValue(showPrivacyPolicy, "builder");
        return showPrivacyPolicy;
    }

    /* access modifiers changed from: private */
    /* renamed from: createReGrantDialogBuilder$lambda-6  reason: not valid java name */
    public static final void m1createReGrantDialogBuilder$lambda6(Context context, boolean z2, String str, String str2, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$privacyPolicyName");
        Intrinsics.checkNotNullParameter(str2, "$category");
        openPolicyMethod(context, z2, str, str2);
    }

    @JvmStatic
    @NotNull
    public static final PolicyRecordRequest createRecordRequest(@NotNull Context context, @NotNull String[] strArr, @Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str2, "operationType");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        Intrinsics.checkNotNullExpressionValue(string, "androidId");
        policyRecordRequest.setBusinessId(string);
        policyRecordRequest.setType("phone");
        if (str != null) {
            policyRecordRequest.setUseId(str);
        }
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            i2++;
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            policyRecordBaseInfo.setVersion(PolicySdkFileUtils.Companion.getPolicyVersion(context, str3));
            policyRecordBaseInfo.setCategory(str3);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(str2);
        return policyRecordRequest;
    }

    @JvmStatic
    @NotNull
    public static final PolicyRecordRequest createRecordRequestOnline(@NotNull Context context, @NotNull String[] strArr, @Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str2, "operationType");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        Intrinsics.checkNotNullExpressionValue(string, "androidId");
        policyRecordRequest.setBusinessId(string);
        policyRecordRequest.setType("phone");
        if (str != null) {
            policyRecordRequest.setUseId(str);
        }
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            i2++;
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            policyRecordBaseInfo.setVersion(INSTANCE.getOnlinePolicyVersion(context, str3));
            policyRecordBaseInfo.setCategory(str3);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(str2);
        return policyRecordRequest;
    }

    @JvmStatic
    public static final void getPolicyByVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Long l2, @Nullable String str4, @NotNull Function1<? super PolicySdkResultBean, PolicySdkResultBean> function1) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "language");
        Function1<? super PolicySdkResultBean, PolicySdkResultBean> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callBackPolicyResult");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new g(l2, str4, str, str2, function12, str3, (Continuation<? super g>) null), 2, (Object) null);
    }

    @JvmStatic
    public static final void getPolicyData(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Long l2, @Nullable String str5, @NotNull Function1<? super PolicySdkResultBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "language");
        Function1<? super PolicySdkResultBean, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callBackPolicyResult");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new h(str4, l2, str5, str, str2, function12, str3, (Continuation<? super h>) null), 2, (Object) null);
    }

    @JvmStatic
    public static final void getPolicyHistoryList(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, long j2, @Nullable String str5, @NotNull Function1<? super PolicySdkResultBean, PolicySdkResultBean> function1) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "language");
        Function1<? super PolicySdkResultBean, PolicySdkResultBean> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callBackPolicyResult");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new i(str4, str5, str, str2, function12, str3, j2, (Continuation<? super i>) null), 2, (Object) null);
    }

    @JvmStatic
    @NotNull
    public static final String getPolicyHistoryUrl(@NotNull String str, @NotNull String str2, long j2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "category");
        Intrinsics.checkNotNullParameter(str3, "language");
        String str4 = "https://policy-h5.flyme.com/?appId=" + str + "&category=" + str2 + "&version=" + j2 + "&language=" + str3;
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", str4);
        return str4;
    }

    @JvmStatic
    @NotNull
    public static final PolicySdkResultBean getPolicyNewestPath(@NotNull Context context, @Nullable String str, @NotNull String str2) {
        String syncLocalFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, "category");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        String currentCountryCode = PolicySdkToolsUtils.Companion.getCurrentCountryCode(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean isNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, str2, currentCountryCode);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("getNewestPolicyPath", Intrinsics.stringPlus("policyNewestPathResultBean1", Boolean.valueOf(isNewestPolicyFileIsExists.isExists())));
        companion2.d("getNewestPolicyPath", Intrinsics.stringPlus("policyNewestPathResultBean2", isNewestPolicyFileIsExists.getNewestPolicyPath()));
        if (isNewestPolicyFileIsExists.isExists()) {
            syncLocalFile = isNewestPolicyFileIsExists.getNewestPolicyPath();
        } else if (str == null || str.length() <= 0) {
            companion2.d("getNewestPolicyPath", Intrinsics.stringPlus(" localPath", str));
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        } else {
            syncLocalFile = companion.syncLocalFile(context, str, str2);
        }
        policySdkResultBean.setPolicyNewestPath(syncLocalFile);
        companion2.d("getNewestPolicyPath", Intrinsics.stringPlus(" policyNewestPath result= ", policySdkResultBean.getPolicyNewestPath()));
        try {
            String name = new File(policySdkResultBean.getPolicyNewestPath()).getName();
            Intrinsics.checkNotNullExpressionValue(name, "myFile.name");
            PolicyFileDataResultBean policyDataFromFileName = companion.getPolicyDataFromFileName(name);
            Long valueOf = policyDataFromFileName == null ? null : Long.valueOf(policyDataFromFileName.getVersion());
            policySdkResultBean.setCode(0);
            if (valueOf != null) {
                policySdkResultBean.setPolicyNewestVersion(valueOf.longValue());
            }
        } catch (Exception unused) {
            policySdkResultBean.setCode(-1);
        }
        return policySdkResultBean;
    }

    @JvmStatic
    public static final void initSDK(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "versionName");
        Intrinsics.checkNotNullParameter(hashMap, "policyCategoryMap");
        mAppId = str;
        mAppSecret = str2;
        mAppVersionName = str3;
        for (Map.Entry next : hashMap.entrySet()) {
            getPolicyNewestPath(context, (String) next.getValue(), (String) next.getKey());
        }
    }

    @JvmStatic
    @NotNull
    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByBrowser(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "title");
        PolicySdkResultBean policyNewestPath = getPolicyNewestPath(context, "", str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPath.getPolicyNewestPath() + '}');
        if (policyNewestPath.getCode() == 0) {
            String policyNewestPath2 = policyNewestPath.getPolicyNewestPath();
            companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath2 + ' ');
            Uri uriForFile = FileProvider.getUriForFile(context, Intrinsics.stringPlus(context.getPackageName(), ".PolicySdk.FileProvider"), new File(policyNewestPath2));
            if (uriForFile != null) {
                PolicySdkToolsUtils.Companion.startBrowser(context, uriForFile);
            }
        }
        return policyNewestPath;
    }

    @JvmStatic
    @NotNull
    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByWebView(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "title");
        PolicySdkResultBean policyNewestPath = getPolicyNewestPath(context, "", str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPath.getPolicyNewestPath() + '}');
        if (policyNewestPath.getCode() == 0) {
            String policyNewestPath2 = policyNewestPath.getPolicyNewestPath();
            Uri uriForFile = FileProvider.getUriForFile(context, Intrinsics.stringPlus(context.getPackageName(), ".PolicySdk.FileProvider"), new File(policyNewestPath2));
            companion.d("PolicyManager", "save sucessful path = " + policyNewestPath2 + ' ');
            PolicyWebViewActivity.Companion.a(context, uriForFile.toString(), str2);
        }
        return policyNewestPath;
    }

    @JvmStatic
    @NotNull
    public static final PolicySdkResultBean openPolicyMethod(@NotNull Context context, boolean z2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "category");
        return z2 ? openPolicyDataByWebView(context, str2, str) : openPolicyDataByBrowser(context, str2, str);
    }

    /* access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new m(context, this, (Continuation<? super m>) null), 2, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object savePolicyOperate(android.content.Context r7, boolean r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.meizu.flyme.policy.sdk.PolicyManager.n
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.meizu.flyme.policy.sdk.PolicyManager$n r0 = (com.meizu.flyme.policy.sdk.PolicyManager.n) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.meizu.flyme.policy.sdk.PolicyManager$n r0 = new com.meizu.flyme.policy.sdk.PolicyManager$n
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r6 = r0.d
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0044
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x009f
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            boolean r8 = r0.c
            java.lang.Object r7 = r0.b
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r7 = r0.f3174a
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x007f
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r6)
            com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "isOperateSuccess ="
            r1.append(r5)
            r1.append(r8)
            java.lang.String r5 = " |operateJson = "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "savePolicyOperate"
            r6.d(r5, r1)
            androidx.datastore.core.DataStore r6 = com.meizu.flyme.policy.sdk.d.a(r7)
            com.meizu.flyme.policy.sdk.PolicyManager$o r1 = new com.meizu.flyme.policy.sdk.PolicyManager$o
            r1.<init>(r8, r4)
            r0.f3174a = r7
            r0.b = r9
            r0.c = r8
            r0.f = r3
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r1, r0)
            if (r6 != r10) goto L_0x007f
            return r10
        L_0x007f:
            if (r8 != 0) goto L_0x00a2
            if (r9 == 0) goto L_0x00a2
            int r6 = r9.length()
            if (r6 <= 0) goto L_0x00a2
            androidx.datastore.core.DataStore r6 = com.meizu.flyme.policy.sdk.d.a(r7)
            com.meizu.flyme.policy.sdk.PolicyManager$p r7 = new com.meizu.flyme.policy.sdk.PolicyManager$p
            r7.<init>(r9, r4)
            r0.f3174a = r4
            r0.b = r4
            r0.f = r2
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r7, r0)
            if (r6 != r10) goto L_0x009f
            return r10
        L_0x009f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00a2:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnlinePolicyVersion$lambda-2  reason: not valid java name */
    public static final void m2setOnlinePolicyVersion$lambda2(Context context, String str, PolicySdkResultBean policySdkResultBean) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$category");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PolicyData policyData = policySdkResultBean.getPolicyData();
        T valueOf = String.valueOf(policyData == null ? null : Integer.valueOf(policyData.getVersion()));
        objectRef.element = valueOf;
        if (Intrinsics.areEqual((Object) valueOf, (Object) "null")) {
            objectRef.element = PolicySdkFileUtils.Companion.getPolicyVersion(context, str);
        }
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, exceptionHandler, (CoroutineStart) null, new q(context, str, objectRef, (Continuation<? super q>) null), 2, (Object) null);
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showCustomPolicyDialog(@NotNull Context context, boolean z2, @NotNull String[] strArr, @NotNull String[] strArr2, @NotNull String str, @NotNull String str2, @NotNull CharSequence charSequence, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissionKey");
        Intrinsics.checkNotNullParameter(strArr2, "permissionSummary");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "reminder");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setOnPermissionListener(onPermissionClickListener).setPermission(strArr, strArr2).setSecondaryConfirmation(z2).setCustomTerms(charSequence).setReminder(str2).create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showCustomPolicyDialogAndUploadRecord(@NotNull Context context, boolean z2, @NotNull String[] strArr, @NotNull String[] strArr2, @NotNull String str, @NotNull String str2, @NotNull CharSequence charSequence, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String[] strArr3, @Nullable String str6, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String[] strArr4 = strArr;
        String[] strArr5 = strArr2;
        String str7 = str;
        String str8 = str2;
        CharSequence charSequence2 = charSequence;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr4, "permissionKey");
        Intrinsics.checkNotNullParameter(strArr5, "permissionSummary");
        Intrinsics.checkNotNullParameter(str7, "title");
        Intrinsics.checkNotNullParameter(str8, "reminder");
        Intrinsics.checkNotNullParameter(charSequence2, "customTerms");
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, "appSecret");
        Intrinsics.checkNotNullParameter(str5, "versionName");
        Intrinsics.checkNotNullParameter(strArr3, "categoryList");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        boolean z3 = z2;
        return new PermissionDialogBuilder(context).setAppName(str7).setOnPermissionListener(new r(context, str3, str4, str5, strArr3, str6, onPermissionClickListener2)).setPermission(strArr4, strArr5).setSecondaryConfirmation(z2).setCustomTerms(charSequence2).setReminder(str8).create();
    }

    @JvmStatic
    @Nullable
    public static final PermissionDialogBuilder showDialogByCustomThemeViewBuilder(@NotNull Context context, int i2, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str2, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str3, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context, i2).setAppName(str).setOnPermissionListener(onPermissionClickListener).setCustomTerms(charSequence).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3);
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showDialogByCustomView(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str2, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str3, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        PermissionDialogBuilder showDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, onPermissionClickListener);
        if (showDialogByCustomViewBuilder == null) {
            return null;
        }
        return showDialogByCustomViewBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showDialogByCustomViewAndUploadRecord(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String[] strArr, @Nullable String str7, @NotNull String str8, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str2, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str3, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, "appSecret");
        Intrinsics.checkNotNullParameter(str6, "versionName");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str8, "operationType");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        PermissionDialogBuilder showDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, str4, str5, str6, strArr, str7, str8, onPermissionClickListener);
        if (showDialogUploadRecordBuilder == null) {
            return null;
        }
        return showDialogUploadRecordBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final PermissionDialogBuilder showDialogByCustomViewBuilder(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str2, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str3, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setOnPermissionListener(onPermissionClickListener).setCustomTerms(charSequence).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3);
    }

    @JvmStatic
    @Nullable
    public static final PermissionDialogBuilder showDialogByCustomViewBuilderRecord(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String[] strArr, @Nullable String str7, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String str8 = str;
        CharSequence charSequence2 = charSequence;
        String str9 = str2;
        String str10 = str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str9, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str10, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, "appSecret");
        Intrinsics.checkNotNullParameter(str6, "versionName");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setOnPermissionListener(new s(context, str4, str5, str6, strArr, str7, onPermissionClickListener2)).setCustomTerms(charSequence).setCustomNegativeButtonText(str9).setCustomPositiveButtonText(str10);
    }

    @JvmStatic
    @Nullable
    public static final PermissionDialogBuilder showDialogUploadRecordBuilder(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String[] strArr, @Nullable String str7, @NotNull String str8, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String str9 = str;
        CharSequence charSequence2 = charSequence;
        String str10 = str2;
        String str11 = str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence2, "customTerms");
        Intrinsics.checkNotNullParameter(str10, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(str11, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, "appSecret");
        Intrinsics.checkNotNullParameter(str6, "versionName");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        String str12 = str8;
        Intrinsics.checkNotNullParameter(str12, "operationType");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setOnPermissionListener(new t(context, str4, str5, str6, strArr, str7, str12, onPermissionClickListener2)).setCustomTerms(charSequence2).setCustomNegativeButtonText(str10).setCustomPositiveButtonText(str11);
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showNewestDialogAndUploadRecord(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String[] strArr, @Nullable String str5, boolean z2, @NotNull CharSequence charSequence, @NotNull String str6, @NotNull String str7, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String str8 = str;
        CharSequence charSequence2 = charSequence;
        String str9 = str6;
        String str10 = str7;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "dialogTitle");
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "appId");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, "appSecret");
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "versionName");
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(strArr2, "categoryList");
        Intrinsics.checkNotNullParameter(charSequence2, "customTerms");
        Intrinsics.checkNotNullParameter(str9, "btnNegative");
        Intrinsics.checkNotNullParameter(str10, "btnPositive");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setOnPermissionListener(new u(z2, context, str11, str12, str13, strArr2, str5, onPermissionClickListener2)).setCustomTerms(charSequence2).setCustomNegativeButtonText(str9).setCustomPositiveButtonText(str10).create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showOverSeasCustomPolicyDialogAndUploadRecord(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull CharSequence charSequence, @NotNull String[] strArr, @NotNull String str6, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String str7 = str5;
        CharSequence charSequence2 = charSequence;
        String str8 = str6;
        Intrinsics.checkNotNullParameter(context, "context");
        String str9 = str;
        Intrinsics.checkNotNullParameter(str, "appId");
        String str10 = str2;
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str4, "versionName");
        Intrinsics.checkNotNullParameter(str7, "title");
        Intrinsics.checkNotNullParameter(charSequence2, "customTerms");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(str8, "btnPositive");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        PermissionDialogBuilder permissionDialogBuilder = new PermissionDialogBuilder(context);
        permissionDialogBuilder.setUseInfo(str7);
        permissionDialogBuilder.setBuilderDialogType(1).setCustomPositiveButtonText(str8).setAppName(str7).setOnPermissionListener(new v(context, str, str2, str4, strArr, str3, onPermissionClickListener)).setCustomTerms(charSequence2);
        return permissionDialogBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showOverSeasPermissionPolicyDialogAndUploadRecord(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull CharSequence charSequence, @NotNull String[] strArr, @NotNull String[] strArr2, @NotNull String[] strArr3, @NotNull String str6, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String str7 = str5;
        CharSequence charSequence2 = charSequence;
        String[] strArr4 = strArr2;
        String[] strArr5 = strArr3;
        String str8 = str6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str4, "versionName");
        Intrinsics.checkNotNullParameter(str7, "title");
        Intrinsics.checkNotNullParameter(charSequence2, "customTerms");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        Intrinsics.checkNotNullParameter(strArr4, "permissionKey");
        Intrinsics.checkNotNullParameter(strArr5, "permissionSummary");
        Intrinsics.checkNotNullParameter(str8, "btnPositive");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        PermissionDialogBuilder permissionDialogBuilder = new PermissionDialogBuilder(context);
        permissionDialogBuilder.setUseInfo(str7);
        permissionDialogBuilder.setBuilderDialogType(1).isIntl(true).setAppName(str7).setOnPermissionListener(new w(context, str, str2, str4, strArr, str3, onPermissionClickListener2)).setPermission(strArr4, strArr5).setCustomPositiveButtonText(str8).setCustomTerms(charSequence2);
        return permissionDialogBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showOverSeasWithdrawConsentDialog(@NotNull Context context, @NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2, @NotNull String str3, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "customTerms");
        Intrinsics.checkNotNullParameter(str2, "btnNegative");
        Intrinsics.checkNotNullParameter(str3, "btnPositive");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        return new PermissionDialogBuilder(context).setAppName(str).setCustomTerms(charSequence).setOnPermissionListener(onPermissionClickListener).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3).setCancelable(true).create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showReGrantDialog(@NotNull Context context, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(str3, "category");
        Intrinsics.checkNotNullParameter(onPermissionClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, z2, z3, str, str2, str3, onPermissionClickListener).create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showReGrantDialogAndUploadRecord(@NotNull Context context, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String[] strArr, @Nullable String str7, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(str3, "category");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "appId");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "appSecret");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "versionName");
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(strArr2, "categoryList");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        Context context3 = context;
        return INSTANCE.createReGrantDialogBuilder(context3, z2, z3, str, str2, str3, new x(context3, str8, str9, str10, strArr2, str7, onPermissionClickListener2)).create();
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showReGrantTwoPolicyDialog(@NotNull Context context, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Context context2 = context;
        String str6 = str2;
        String str7 = str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(str7, "userCategory");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "privacyPolicyName");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "category");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        PermissionDialogBuilder createReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z2, z3, str, str8, str9, onPermissionClickListener2);
        createReGrantDialogBuilder.setUserAgreementName(str2);
        createReGrantDialogBuilder.showUserAgreement(new f(context, z2, str2, str7));
        return createReGrantDialogBuilder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: showReGrantTwoPolicyDialog$lambda-5  reason: not valid java name */
    public static final void m3showReGrantTwoPolicyDialog$lambda5(Context context, boolean z2, String str, String str2, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(str2, "$userCategory");
        openPolicyMethod(context, z2, str, str2);
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showReGrantTwoPolicyDialogAndUploadRecord(@NotNull Context context, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String[] strArr, @Nullable String str9, @NotNull PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Context context2 = context;
        String str10 = str2;
        String str11 = str3;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str10, "userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(str11, "userCategory");
        Intrinsics.checkNotNullParameter(str4, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(str5, "category");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "appId");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "appSecret");
        String str14 = str8;
        Intrinsics.checkNotNullParameter(str14, "versionName");
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(strArr2, "categoryList");
        PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener2 = onPermissionClickListener;
        Intrinsics.checkNotNullParameter(onPermissionClickListener2, "permissionDialogClickListener");
        PolicyManager policyManager = INSTANCE;
        Context context3 = context;
        y yVar = new y(context3, str12, str13, str14, strArr2, str9, onPermissionClickListener2);
        boolean z4 = z2;
        PermissionDialogBuilder createReGrantDialogBuilder = policyManager.createReGrantDialogBuilder(context3, z4, z3, str, str4, str5, yVar);
        createReGrantDialogBuilder.setUserAgreementName(str10);
        createReGrantDialogBuilder.showUserAgreement(new e(context2, z4, str10, str11));
        return createReGrantDialogBuilder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: showReGrantTwoPolicyDialogAndUploadRecord$lambda-4  reason: not valid java name */
    public static final void m4showReGrantTwoPolicyDialogAndUploadRecord$lambda4(Context context, boolean z2, String str, String str2, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(str2, "$userCategory");
        openPolicyMethod(context, z2, str, str2);
    }

    @JvmStatic
    public static final void uploadPolicyOperateRecord(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull PolicyRecordRequest policyRecordRequest, @NotNull Function1<? super PolicySdkResultBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appSecret");
        Intrinsics.checkNotNullParameter(str3, "versionName");
        Intrinsics.checkNotNullParameter(policyRecordRequest, "policyRecordRequest");
        Function1<? super PolicySdkResultBean, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callBackPolicyResult");
        GlobalScope globalScope = GlobalScope.f3732a;
        CoroutineExceptionHandler coroutineExceptionHandler = exceptionHandler;
        Job unused = BuildersKt__Builders_commonKt.d(globalScope, coroutineExceptionHandler, (CoroutineStart) null, new a0(str, str2, context, policyRecordRequest, function12, str3, (Continuation<? super a0>) null), 2, (Object) null);
    }

    @NotNull
    public final String getBrand() {
        return brand;
    }

    @NotNull
    public final CoroutineExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    @NotNull
    public final String getMAppId() {
        return mAppId;
    }

    @NotNull
    public final String getMAppSecret() {
        return mAppSecret;
    }

    @NotNull
    public final String getMAppVersionName() {
        return mAppVersionName;
    }

    @NotNull
    public final String getModel() {
        return model;
    }

    @NotNull
    public final String getOnlinePolicyVersion(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "category");
        return (String) BuildersKt__BuildersKt.b((CoroutineContext) null, new f(context, str, (Continuation<? super f>) null), 1, (Object) null);
    }

    @NotNull
    public final String getOsVersion() {
        return osVersion;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPolicyOperate(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.meizu.flyme.policy.sdk.PolicyManager.k
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.meizu.flyme.policy.sdk.PolicyManager$k r0 = (com.meizu.flyme.policy.sdk.PolicyManager.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.meizu.flyme.policy.sdk.PolicyManager$k r0 = new com.meizu.flyme.policy.sdk.PolicyManager$k
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.f3168a
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x004a
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            androidx.datastore.core.DataStore r4 = com.meizu.flyme.policy.sdk.d.a(r5)
            kotlinx.coroutines.flow.Flow r4 = r4.getData()
            com.meizu.flyme.policy.sdk.PolicyManager$j r5 = new com.meizu.flyme.policy.sdk.PolicyManager$j
            r5.<init>(r4)
            r0.c = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.w(r5, r0)
            if (r4 != r6) goto L_0x004a
            return r6
        L_0x004a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object getPolicyOperateJson(@NotNull Context context, @NotNull Continuation<? super String> continuation) {
        return FlowKt.w(new l(d.a(context).getData()), continuation);
    }

    public final void setBrand(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        brand = str;
    }

    public final void setMAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        model = str;
    }

    public final void setOnlinePolicyVersion(@NotNull Context context, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "categoryList");
        String language = PolicySdkToolsUtils.Companion.getLanguage();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            PolicySdk.getPolicy(language, str, 0L, new h(context, str));
        }
    }

    public final void setOsVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        osVersion = str;
    }
}
