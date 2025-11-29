package com.upuphone.xr.sapp.vm;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.audio.GlassVolInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.GlassBatteryInfo;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.monitor.air.AirFunctionHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007H@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000fJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u0018J\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000fJ\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010\u0018R.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00120 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u00100\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00118\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0014R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000201068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020<0\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b=\u0010\u0014R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\u00118\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b@\u0010\u0014R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020?068\u0006¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010:R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020E0\u00118\u0006¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\bF\u0010\u0014R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020E068\u0006¢\u0006\f\n\u0004\bH\u00108\u001a\u0004\bI\u0010:R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bK\u00103\u001a\u0004\bL\u0010\u0014R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bN\u00108\u001a\u0004\bO\u0010:R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bQ\u00103\u001a\u0004\bR\u0010\u0014R\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bT\u00108\u001a\u0004\bU\u0010:R\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bW\u00103\u001a\u0004\bX\u0010\u0014R\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bZ\u00108\u001a\u0004\b[\u0010:R\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bU\u00103\u001a\u0004\b]\u0010\u0014R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\b_\u00108\u001a\u0004\bN\u0010:R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\ba\u0010\u0014R\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bc\u00108\u001a\u0004\bd\u0010:R\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020?0\u00118\u0006¢\u0006\f\n\u0004\bf\u00103\u001a\u0004\bg\u0010\u0014R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020?068\u0006¢\u0006\f\n\u0004\bi\u00108\u001a\u0004\bZ\u0010:R\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020!0\u00118\u0006¢\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\bk\u0010\u0014R\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020!068\u0006¢\u0006\f\n\u0004\bI\u00108\u001a\u0004\bm\u0010:R\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020o0\u00118\u0006¢\u0006\f\n\u0004\bp\u00103\u001a\u0004\bq\u0010\u0014R\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020o068\u0006¢\u0006\f\n\u0004\bs\u00108\u001a\u0004\bt\u0010:R\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020!0\u00118\u0006¢\u0006\f\n\u0004\bv\u00103\u001a\u0004\bw\u0010\u0014R\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020!068\u0006¢\u0006\f\n\u0004\by\u00108\u001a\u0004\bv\u0010:R\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bt\u00103\u001a\u0004\b{\u0010\u0014R\u001d\u0010~\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\b}\u00108\u001a\u0004\bW\u0010:R,\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200\u00118\u0006@\u0006X\u000e¢\u0006\u0015\n\u0004\bm\u00103\u001a\u0005\b\u0001\u0010\u0014\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020068\u0006¢\u0006\u000e\n\u0005\b\u0001\u00108\u001a\u0005\b\u0001\u0010:R.\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014\"\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\u000e\n\u0005\b\u0001\u00108\u001a\u0005\b\u0001\u0010:R \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\r\n\u0005\b\u0001\u00108\u001a\u0004\bs\u0010:R \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\r\n\u0005\b\u0001\u00108\u001a\u0004\bi\u0010:R!\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R\u001f\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030\u0001068\u0006¢\u0006\f\n\u0004\b{\u00108\u001a\u0004\bf\u0010:R#\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020!0¡\u00018\u0006¢\u0006\u0010\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R!\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b¨\u0001\u0010\u0014R!\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030§\u0001068\u0006¢\u0006\u000e\n\u0005\bª\u0001\u00108\u001a\u0005\b«\u0001\u0010:R \u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030­\u00010\u00118\u0006¢\u0006\r\n\u0004\bw\u00103\u001a\u0005\b®\u0001\u0010\u0014R \u0010±\u0001\u001a\t\u0012\u0005\u0012\u00030­\u0001068\u0006¢\u0006\r\n\u0004\bq\u00108\u001a\u0005\b°\u0001\u0010:R \u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u00118\u0006¢\u0006\u000e\n\u0005\b²\u0001\u00103\u001a\u0005\b³\u0001\u0010\u0014R \u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u00118\u0006¢\u0006\u000e\n\u0005\bµ\u0001\u00103\u001a\u0005\b¶\u0001\u0010\u0014R \u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020!068\u0006¢\u0006\u000e\n\u0005\b¸\u0001\u00108\u001a\u0005\b¹\u0001\u0010:R#\u0010½\u0001\u001a\n\u0012\u0005\u0012\u00030»\u00010¡\u00018\u0006¢\u0006\u000f\n\u0005\b=\u0010£\u0001\u001a\u0006\b¼\u0001\u0010¥\u0001R$\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\b¿\u0001\u0010£\u0001\u001a\u0006\bÀ\u0001\u0010¥\u0001R!\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u00118\u0006¢\u0006\u000e\n\u0005\bÃ\u0001\u00103\u001a\u0005\bÄ\u0001\u0010\u0014R!\u0010Æ\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u0001068\u0006¢\u0006\u000e\n\u0005\b\u0001\u00108\u001a\u0005\b\u0001\u0010:R\"\u0010Ç\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120¡\u00018\u0006¢\u0006\u000f\n\u0005\ba\u0010£\u0001\u001a\u0006\b\u0001\u0010¥\u0001R \u0010Ê\u0001\u001a\t\u0012\u0005\u0012\u00030È\u00010\u00118\u0006¢\u0006\r\n\u0004\b]\u00103\u001a\u0005\bÉ\u0001\u0010\u0014R \u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030È\u0001068\u0006¢\u0006\r\n\u0004\bg\u00108\u001a\u0005\b\u0001\u0010:R \u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\bÌ\u0001\u0010\u0014R\u001e\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bF\u00108\u001a\u0004\b_\u0010:R\u001f\u0010Ï\u0001\u001a\b\u0012\u0004\u0012\u00020?0\u00118\u0006¢\u0006\r\n\u0004\bk\u00103\u001a\u0005\b²\u0001\u0010\u0014R\u001f\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00020?068\u0006¢\u0006\r\n\u0005\bÐ\u0001\u00108\u001a\u0004\b}\u0010:R \u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00020?0\u00118\u0006¢\u0006\u000e\n\u0005\bÒ\u0001\u00103\u001a\u0005\bµ\u0001\u0010\u0014R \u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020?068\u0006¢\u0006\u000e\n\u0005\bÔ\u0001\u00108\u001a\u0005\b\u0001\u0010:R2\u0010Ø\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!0Ö\u0001j\t\u0012\u0004\u0012\u00020!`×\u00010\u00118\u0006¢\u0006\u000e\n\u0005\bÄ\u0001\u00103\u001a\u0005\b¸\u0001\u0010\u0014R2\u0010Ú\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!0Ö\u0001j\t\u0012\u0004\u0012\u00020!`×\u0001068\u0006¢\u0006\u000e\n\u0005\bÙ\u0001\u00108\u001a\u0005\b\u0001\u0010:R \u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\bÉ\u0001\u00103\u001a\u0005\bÛ\u0001\u0010\u0014R\u001f\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\r\n\u0004\bX\u00108\u001a\u0005\bÝ\u0001\u0010:R\"\u0010ß\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120¡\u00018\u0006¢\u0006\u000f\n\u0006\b¶\u0001\u0010£\u0001\u001a\u0005\bH\u0010¥\u0001R$\u0010ã\u0001\u001a\n\u0012\u0005\u0012\u00030à\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\bá\u0001\u0010£\u0001\u001a\u0006\bâ\u0001\u0010¥\u0001R\u001f\u0010ç\u0001\u001a\u00030ä\u00018FX\u0002¢\u0006\u000e\n\u0005\b@\u0010å\u0001\u001a\u0005\bK\u0010æ\u0001R \u0010é\u0001\u001a\t\u0012\u0005\u0012\u00030è\u00010\u00118\u0006¢\u0006\r\n\u0004\b4\u00103\u001a\u0005\b¿\u0001\u0010\u0014R!\u0010ë\u0001\u001a\t\u0012\u0005\u0012\u00030è\u0001068\u0006¢\u0006\u000e\n\u0005\b¨\u0001\u00108\u001a\u0005\bê\u0001\u0010:R \u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\u000e\n\u0005\b®\u0001\u00103\u001a\u0005\b\u0001\u0010\u0014R \u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\u000e\n\u0005\bÝ\u0001\u00108\u001a\u0005\bí\u0001\u0010:R(\u0010ò\u0001\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b$\u0010\u0001\u001a\u0006\bÃ\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R(\u0010õ\u0001\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b[\u0010\u0001\u001a\u0006\bó\u0001\u0010ï\u0001\"\u0006\bô\u0001\u0010ñ\u0001R)\u0010ø\u0001\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010\u0001\u001a\u0006\bö\u0001\u0010ï\u0001\"\u0006\b÷\u0001\u0010ñ\u0001R,\u0010ÿ\u0001\u001a\u0005\u0018\u00010ù\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bê\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R&\u0010\u0002\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0015\n\u0004\bC\u0010=\u001a\u0006\b\u0002\u0010\u0002\"\u0005\b\u0002\u0010\u0018R'\u0010\u0002\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b¤\u0001\u0010=\u001a\u0006\b¢\u0001\u0010\u0002\"\u0005\b\u0002\u0010\u0018R'\u0010\u0002\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010=\u001a\u0006\b\u0002\u0010\u0002\"\u0005\b\u0002\u0010\u0018R'\u0010\u0002\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b«\u0001\u0010=\u001a\u0006\b\u0002\u0010\u0002\"\u0005\b\u0002\u0010\u0018R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0004¢\u0006\u0007\n\u0005\b°\u0001\u00103R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u0012068\u0006¢\u0006\f\n\u0004\bd\u00108\u001a\u0004\bQ\u0010:R\u0018\u0010\u0002\u001a\u00030\u00028\u0016X\u0005¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002¨\u0006\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "info", "", "d1", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;)V", "R0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "()V", "j", "Landroidx/lifecycle/MutableLiveData;", "", "t", "()Landroidx/lifecycle/MutableLiveData;", "x", "model", "g", "(Z)V", "state", "h", "U0", "T0", "S0", "isVisible", "Q0", "", "", "c", "Ljava/util/Map;", "D0", "()Ljava/util/Map;", "setMustPermissionCancelMap", "(Ljava/util/Map;)V", "mustPermissionCancelMap", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "N0", "()Lkotlin/jvm/functions/Function0;", "c1", "(Lkotlin/jvm/functions/Function0;)V", "weatherSyncCall", "Lcom/upuphone/xr/sapp/entity/ResGlassData;", "e", "Landroidx/lifecycle/MutableLiveData;", "z0", "mresGlassData", "Landroidx/lifecycle/LiveData;", "f", "Landroidx/lifecycle/LiveData;", "getResGlassData", "()Landroidx/lifecycle/LiveData;", "resGlassData", "Lcom/upuphone/xr/sapp/audio/GlassVolInfo;", "Z", "mGlassVolInfo", "", "y0", "mresGlassBrightness", "i", "H0", "resGlassBrightness", "Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;", "n0", "mglassBatteryInfoData", "k", "y", "glassBatteryInfoData", "l", "getMclickMainUI", "mclickMainUI", "m", "getClickMainUI", "clickMainUI", "n", "getMcallVoiceAutoAdjust", "mcallVoiceAutoAdjust", "o", "r", "callVoiceAutoAdjust", "p", "v0", "mnoDisturbModel", "q", "E0", "noDisturbModel", "k0", "mairModel", "s", "airModel", "j0", "mWearDetectionModel", "u", "M0", "wearDetectionModel", "v", "l0", "mautoScreenOffTime", "w", "autoScreenOffTime", "o0", "mglassLanguage", "F", "glassLanguage", "Lcom/upuphone/xr/sapp/entity/GlassFontSize;", "z", "V", "mGlassFontSize", "A", "D", "glassFontSize", "B", "U", "mGlassFastOpen", "C", "glassFastOpen", "Q", "mAutoBrightnessState", "E", "autoBrightnessState", "Lcom/upuphone/xr/sapp/entity/StabilizationMode;", "b0", "setMImageStabilizationState", "(Landroidx/lifecycle/MutableLiveData;)V", "mImageStabilizationState", "G", "O", "imageStabilizationState", "Lcom/upuphone/xr/sapp/entity/AdjustmentMode;", "H", "a0", "setMImageAdjustment", "mImageAdjustment", "I", "N", "imageAdjustment", "J", "i0", "mSoundEffectMode", "K", "J0", "soundEffectMode", "L", "S", "mGlassDebugMode", "M", "glassDebugMode", "m0", "mfactoryResetConfirm", "factoryResetConfirm", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "P", "iDeviceInfo", "deviceInfo", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "R", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "I0", "()Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "singleDeviceSn", "Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "A0", "municronBattery", "T", "K0", "unicronBattery", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "B0", "municronVersion", "L0", "unicronVersion", "W", "getMupdateAppFragment", "mupdateAppFragment", "X", "w0", "mopenAppFailed", "Y", "getOpenAppFailed", "openAppFailed", "Lcom/upuphone/xr/sapp/entity/WifiListInfo;", "P0", "wifiList", "Lcom/upuphone/xr/sapp/guide/model/WifiResultModel;", "g0", "O0", "wifiExecuteState", "Lcom/upuphone/xr/sapp/entity/GlassWifiData;", "h0", "s0", "mglassWifiInfo", "glassWifiInfo", "glassWifiState", "Lcom/upuphone/xr/sapp/entity/GlassWifiValidInfo;", "u0", "mglassWifiValid", "glassWifiValid", "getMCleanContact", "mCleanContact", "cleanContact", "mGlassFovPosition", "p0", "glassFovPosition", "q0", "mGlassStandbyPosition", "r0", "glassStandbyPosition", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mGlassStandbyWidgetInfo", "t0", "glassStandbyWidgetInfo", "c0", "mMusicTpControlModel", "C0", "musicTpControlModel", "aiStateChange", "Lcom/upuphone/xr/sapp/entity/ResPolicyData;", "x0", "F0", "policyState", "Lcom/upuphone/xr/sapp/monitor/air/AirFunctionHelper;", "Lkotlin/Lazy;", "()Lcom/upuphone/xr/sapp/monitor/air/AirFunctionHelper;", "airFunction", "Lcom/upuphone/xr/sapp/entity/SubPolicyInfo;", "mPrivacyAgreeModel", "G0", "privacyAgreeModel", "mAccountLoginModel", "getAccountLoginModel", "accountLoginModel", "()I", "a1", "(I)V", "mReSizeHeight", "getMHeight", "X0", "mHeight", "e0", "Y0", "mNavigationHeight", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "getMPreConnectState", "()Lcom/upuphone/xr/sapp/entity/NetDevice;", "Z0", "(Lcom/upuphone/xr/sapp/entity/NetDevice;)V", "mPreConnectState", "getMPairWifiState", "()Z", "setMPairWifiState", "mPairWifiState", "V0", "mDlanState", "getMGoSearchPage", "W0", "mGoSearchPage", "getRingConnectState", "b1", "ringConnectState", "_androidNaviVisibility", "androidNaviVisibility", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperViewModel extends AndroidViewModel implements CoroutineScope {
    public static final Companion N0 = new Companion((DefaultConstructorMarker) null);
    public static String O0;
    public final LiveData A;
    public final LiveData A0;
    public final MutableLiveData B;
    public final MutableLiveData B0;
    public final LiveData C;
    public final LiveData C0;
    public final MutableLiveData D;
    public int D0;
    public final LiveData E;
    public int E0;
    public MutableLiveData F;
    public int F0;
    public final LiveData G;
    public NetDevice G0;
    public MutableLiveData H;
    public boolean H0;
    public final MutableLiveData I;
    public boolean I0;
    public final MutableLiveData J;
    public boolean J0;
    public final LiveData K;
    public boolean K0;
    public final MutableLiveData L;
    public final MutableLiveData L0;
    public final LiveData M;
    public final LiveData M0;
    public final MutableLiveData N;
    public final LiveData O;
    public final MutableLiveData P;
    public final LiveData Q;
    public final SingleLiveData R;
    public final MutableLiveData S;
    public final LiveData T;
    public final MutableLiveData U;
    public final LiveData V;
    public final MutableLiveData W;
    public final MutableLiveData X;
    public final LiveData Y;
    public final SingleLiveData Z;
    public final /* synthetic */ CoroutineScope b = CoroutineScopeKt.b();
    public Map c;
    public Function0 d;
    public final MutableLiveData e;
    public final LiveData f;
    public final MutableLiveData g;
    public final SingleLiveData g0;
    public final MutableLiveData h;
    public final MutableLiveData h0;
    public final LiveData i;
    public final LiveData i0;
    public final MutableLiveData j;
    public final SingleLiveData j0;
    public final LiveData k;
    public final MutableLiveData k0;
    public final MutableLiveData l;
    public final LiveData l0;
    public final LiveData m;
    public final MutableLiveData m0;
    public final MutableLiveData n;
    public final LiveData n0;
    public final LiveData o;
    public final MutableLiveData o0;
    public final MutableLiveData p;
    public final LiveData p0;
    public final LiveData q;
    public final MutableLiveData q0;
    public final MutableLiveData r;
    public final LiveData r0;
    public final LiveData s;
    public final MutableLiveData s0;
    public final MutableLiveData t;
    public final LiveData t0;
    public final LiveData u;
    public final MutableLiveData u0;
    public final MutableLiveData v;
    public final LiveData v0;
    public final LiveData w;
    public final SingleLiveData w0;
    public final MutableLiveData x;
    public final SingleLiveData x0;
    public final LiveData y;
    public final Lazy y0;
    public final MutableLiveData z;
    public final MutableLiveData z0;

    @SourceDebugExtension({"SMAP\nSuperViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperViewModel.kt\ncom/upuphone/xr/sapp/vm/SuperViewModel$1\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,349:1\n29#2,5:350\n*S KotlinDebug\n*F\n+ 1 SuperViewModel.kt\ncom/upuphone/xr/sapp/vm/SuperViewModel$1\n*L\n216#1:350,5\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.vm.SuperViewModel$1", f = "SuperViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.vm.SuperViewModel$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SuperViewModel this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                JsonUtils jsonUtils = JsonUtils.f7893a;
                DataStoreUtils.Companion companion = DataStoreUtils.e;
                String str = (String) DataStoreUtils.i(companion.a(), "volume_info_store", "", (Context) null, 4, (Object) null);
                Type type = new SuperViewModel$1$invokeSuspend$$inlined$fromJson$1().getType();
                Unit unit = Unit.INSTANCE;
                if (Intrinsics.areEqual((Object) type, (Object) unit.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                    Intrinsics.checkNotNull(type);
                    obj2 = jsonUtils.a("{}", type);
                } else {
                    Intrinsics.checkNotNull(type);
                    obj2 = jsonUtils.a(str, type);
                }
                GlassVolInfo glassVolInfo = (GlassVolInfo) obj2;
                if (glassVolInfo == null) {
                    glassVolInfo = new GlassVolInfo(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
                }
                this.this$0.Z().setValue(glassVolInfo);
                Integer intOrNull = StringsKt.toIntOrNull((String) DataStoreUtils.i(companion.a(), "brightness_store", "0", (Context) null, 4, (Object) null));
                this.this$0.y0().setValue(Boxing.boxInt(intOrNull != null ? intOrNull.intValue() : 5));
                return unit;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vm/SuperViewModel$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        String simpleName = SuperViewModel.class.getSimpleName();
        O0 = Constants.LOG_PREFIX + simpleName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        Boolean bool = Boolean.FALSE;
        this.c = MapsKt.mutableMapOf(TuplesKt.to("bluetooth_switch", bool), TuplesKt.to("location_switch", bool), TuplesKt.to("bluetooth_permission", bool), TuplesKt.to("location_permission", bool));
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData;
        this.f = mutableLiveData;
        this.g = new MutableLiveData();
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.h = mutableLiveData2;
        this.i = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.j = mutableLiveData3;
        this.k = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.l = mutableLiveData4;
        this.m = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        this.n = mutableLiveData5;
        this.o = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        this.p = mutableLiveData6;
        this.q = mutableLiveData6;
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        this.r = mutableLiveData7;
        this.s = mutableLiveData7;
        MutableLiveData mutableLiveData8 = new MutableLiveData();
        this.t = mutableLiveData8;
        this.u = mutableLiveData8;
        MutableLiveData mutableLiveData9 = new MutableLiveData();
        this.v = mutableLiveData9;
        this.w = mutableLiveData9;
        MutableLiveData mutableLiveData10 = new MutableLiveData();
        this.x = mutableLiveData10;
        this.y = mutableLiveData10;
        MutableLiveData mutableLiveData11 = new MutableLiveData();
        this.z = mutableLiveData11;
        this.A = mutableLiveData11;
        MutableLiveData mutableLiveData12 = new MutableLiveData();
        this.B = mutableLiveData12;
        this.C = mutableLiveData12;
        MutableLiveData mutableLiveData13 = new MutableLiveData();
        this.D = mutableLiveData13;
        this.E = mutableLiveData13;
        MutableLiveData mutableLiveData14 = new MutableLiveData();
        this.F = mutableLiveData14;
        this.G = mutableLiveData14;
        MutableLiveData mutableLiveData15 = new MutableLiveData();
        this.H = mutableLiveData15;
        this.I = mutableLiveData15;
        MutableLiveData mutableLiveData16 = new MutableLiveData();
        this.J = mutableLiveData16;
        this.K = mutableLiveData16;
        MutableLiveData mutableLiveData17 = new MutableLiveData();
        this.L = mutableLiveData17;
        this.M = mutableLiveData17;
        MutableLiveData mutableLiveData18 = new MutableLiveData();
        this.N = mutableLiveData18;
        this.O = mutableLiveData18;
        MutableLiveData mutableLiveData19 = new MutableLiveData();
        this.P = mutableLiveData19;
        this.Q = mutableLiveData19;
        this.R = new SingleLiveData();
        MutableLiveData mutableLiveData20 = new MutableLiveData();
        this.S = mutableLiveData20;
        this.T = mutableLiveData20;
        MutableLiveData mutableLiveData21 = new MutableLiveData();
        this.U = mutableLiveData21;
        this.V = mutableLiveData21;
        this.W = new MutableLiveData();
        MutableLiveData mutableLiveData22 = new MutableLiveData();
        this.X = mutableLiveData22;
        this.Y = mutableLiveData22;
        this.Z = new SingleLiveData();
        this.g0 = new SingleLiveData();
        MutableLiveData mutableLiveData23 = new MutableLiveData();
        this.h0 = mutableLiveData23;
        this.i0 = mutableLiveData23;
        this.j0 = new SingleLiveData();
        MutableLiveData mutableLiveData24 = new MutableLiveData();
        this.k0 = mutableLiveData24;
        this.l0 = mutableLiveData24;
        MutableLiveData mutableLiveData25 = new MutableLiveData();
        this.m0 = mutableLiveData25;
        this.n0 = mutableLiveData25;
        MutableLiveData mutableLiveData26 = new MutableLiveData();
        this.o0 = mutableLiveData26;
        this.p0 = mutableLiveData26;
        MutableLiveData mutableLiveData27 = new MutableLiveData(0);
        this.q0 = mutableLiveData27;
        this.r0 = mutableLiveData27;
        MutableLiveData mutableLiveData28 = new MutableLiveData(new ArrayList());
        this.s0 = mutableLiveData28;
        this.t0 = mutableLiveData28;
        MutableLiveData mutableLiveData29 = new MutableLiveData();
        this.u0 = mutableLiveData29;
        this.v0 = mutableLiveData29;
        this.w0 = new SingleLiveData();
        this.x0 = new SingleLiveData();
        this.y0 = LazyKt.lazy(SuperViewModel$airFunction$2.INSTANCE);
        MutableLiveData mutableLiveData30 = new MutableLiveData();
        this.z0 = mutableLiveData30;
        this.A0 = mutableLiveData30;
        MutableLiveData mutableLiveData31 = new MutableLiveData();
        this.B0 = mutableLiveData31;
        this.C0 = mutableLiveData31;
        MutableLiveData mutableLiveData32 = new MutableLiveData();
        this.L0 = mutableLiveData32;
        this.M0 = Transformations.a(mutableLiveData32);
        ULog.Delegate delegate = ULog.f6446a;
        String str = O0;
        String name = Thread.currentThread().getName();
        delegate.a(str, "MainViewModel in init state thread name : " + name);
        mutableLiveData18.setValue(bool);
        MainApplication.k.p(true);
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final LiveData A() {
        return this.M;
    }

    public final MutableLiveData A0() {
        return this.S;
    }

    public final LiveData B() {
        return this.C;
    }

    public final MutableLiveData B0() {
        return this.U;
    }

    public final LiveData C0() {
        return this.v0;
    }

    public final LiveData D() {
        return this.A;
    }

    public final Map D0() {
        return this.c;
    }

    public final LiveData E() {
        return this.p0;
    }

    public final LiveData E0() {
        return this.q;
    }

    public final LiveData F() {
        return this.y;
    }

    public final SingleLiveData F0() {
        return this.x0;
    }

    public final LiveData G() {
        return this.r0;
    }

    public final LiveData G0() {
        return this.A0;
    }

    public final LiveData H() {
        return this.t0;
    }

    public final LiveData H0() {
        return this.i;
    }

    public final LiveData I() {
        return this.i0;
    }

    public final SingleLiveData I0() {
        return this.R;
    }

    public final LiveData J0() {
        return this.K;
    }

    public final SingleLiveData K() {
        return this.j0;
    }

    public final LiveData K0() {
        return this.T;
    }

    public final LiveData L() {
        return this.l0;
    }

    public final LiveData L0() {
        return this.V;
    }

    public final MutableLiveData M() {
        return this.P;
    }

    public final LiveData M0() {
        return this.u;
    }

    public final MutableLiveData N() {
        return this.I;
    }

    public final Function0 N0() {
        return this.d;
    }

    public final LiveData O() {
        return this.G;
    }

    public final SingleLiveData O0() {
        return this.g0;
    }

    public final MutableLiveData P() {
        return this.B0;
    }

    public final SingleLiveData P0() {
        return this.Z;
    }

    public final MutableLiveData Q() {
        return this.D;
    }

    public final void Q0(boolean z2) {
        this.L0.postValue(Boolean.valueOf(z2));
    }

    public final boolean R() {
        return this.I0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object R0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.vm.SuperViewModel$requestGlassBatteryInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.vm.SuperViewModel$requestGlassBatteryInfo$1 r0 = (com.upuphone.xr.sapp.vm.SuperViewModel$requestGlassBatteryInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vm.SuperViewModel$requestGlassBatteryInfo$1 r0 = new com.upuphone.xr.sapp.vm.SuperViewModel$requestGlassBatteryInfo$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ Exception -> 0x002a }
            goto L_0x005b
        L_0x002a:
            r5 = move-exception
            goto L_0x005f
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x002a }
            java.lang.String r1 = O0     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = "requestGlassBatteryInfo"
            r5.g(r1, r4)     // Catch:{ Exception -> 0x002a }
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ Exception -> 0x002a }
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r1.x()     // Catch:{ Exception -> 0x002a }
            if (r1 != 0) goto L_0x0050
            java.lang.String r6 = O0     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "checkUpdate, connectDevice is null"
            r5.a(r6, r0)     // Catch:{ Exception -> 0x002a }
            return r2
        L_0x0050:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r5 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ Exception -> 0x002a }
            r0.label = r3     // Catch:{ Exception -> 0x002a }
            java.lang.Object r5 = r5.l(r1, r0)     // Catch:{ Exception -> 0x002a }
            if (r5 != r6) goto L_0x005b
            return r6
        L_0x005b:
            com.upuphone.xr.sapp.entity.BasicGlassInfo r5 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r5     // Catch:{ Exception -> 0x002a }
            r2 = r5
            goto L_0x0077
        L_0x005f:
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = O0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "e: "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r6.o(r0, r5)
        L_0x0077:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.SuperViewModel.R0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final MutableLiveData S() {
        return this.L;
    }

    public final void S0() {
    }

    public final void T0(boolean z2) {
        this.m0.postValue(Boolean.valueOf(z2));
    }

    public final MutableLiveData U() {
        return this.B;
    }

    public final void U0(boolean z2) {
        this.N.setValue(Boolean.valueOf(z2));
    }

    public final MutableLiveData V() {
        return this.z;
    }

    public final void V0(boolean z2) {
        this.I0 = z2;
    }

    public final MutableLiveData W() {
        return this.o0;
    }

    public final void W0(boolean z2) {
        this.J0 = z2;
    }

    public final MutableLiveData X() {
        return this.q0;
    }

    public final void X0(int i2) {
        this.E0 = i2;
    }

    public final MutableLiveData Y() {
        return this.s0;
    }

    public final void Y0(int i2) {
        this.F0 = i2;
    }

    public final MutableLiveData Z() {
        return this.g;
    }

    public final void Z0(NetDevice netDevice) {
        this.G0 = netDevice;
    }

    public final MutableLiveData a0() {
        return this.H;
    }

    public final void a1(int i2) {
        this.D0 = i2;
    }

    public final MutableLiveData b0() {
        return this.F;
    }

    public final void b1(boolean z2) {
        this.K0 = z2;
    }

    public final MutableLiveData c0() {
        return this.u0;
    }

    public final void c1(Function0 function0) {
        this.d = function0;
    }

    public final void d1(BasicGlassInfo basicGlassInfo) {
        this.j.setValue(new GlassBatteryInfo(basicGlassInfo.getBattery(), basicGlassInfo.isCharging()));
    }

    public final int e0() {
        return this.F0;
    }

    public final void g(boolean z2) {
        this.r.setValue(Boolean.valueOf(z2));
    }

    public final MutableLiveData g0() {
        return this.z0;
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public final void h(boolean z2) {
        this.n.setValue(Boolean.valueOf(z2));
    }

    public final int h0() {
        return this.D0;
    }

    public final MutableLiveData i0() {
        return this.J;
    }

    public final void j() {
        try {
            ControlUtils controlUtils = ControlUtils.f7858a;
            UnicronBatteryInfo m2 = controlUtils.m();
            UnicronBatteryInfo unicronBatteryInfo = new UnicronBatteryInfo(m2.getCapacity(), false, m2.getDevName(), m2.getBound(), m2.getBluetooth(), m2.getMouseState());
            this.S.setValue(unicronBatteryInfo);
            controlUtils.e0(unicronBatteryInfo);
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String str = O0;
            delegate.o(str, "ring battery, e: " + e2);
        }
    }

    public final MutableLiveData j0() {
        return this.t;
    }

    public final SingleLiveData k() {
        return this.w0;
    }

    public final MutableLiveData k0() {
        return this.r;
    }

    public final AirFunctionHelper l() {
        return (AirFunctionHelper) this.y0.getValue();
    }

    public final MutableLiveData l0() {
        return this.v;
    }

    public final LiveData m() {
        return this.s;
    }

    public final MutableLiveData m0() {
        return this.N;
    }

    public final LiveData n() {
        return this.M0;
    }

    public final MutableLiveData n0() {
        return this.j;
    }

    public final MutableLiveData o0() {
        return this.x;
    }

    public void onCleared() {
        super.onCleared();
        ULog.f6446a.a(O0, "onCleared------");
        MainApplication.k.p(false);
        this.H0 = false;
    }

    public final LiveData p() {
        return this.E;
    }

    public final LiveData q() {
        return this.w;
    }

    public final LiveData r() {
        return this.o;
    }

    public final LiveData s() {
        return this.n0;
    }

    public final MutableLiveData s0() {
        return this.h0;
    }

    public final MutableLiveData t() {
        return this.l;
    }

    public final MutableLiveData u0() {
        return this.k0;
    }

    public final LiveData v() {
        return this.Q;
    }

    public final MutableLiveData v0() {
        return this.p;
    }

    public final LiveData w() {
        return this.O;
    }

    public final MutableLiveData w0() {
        return this.X;
    }

    public final void x() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new SuperViewModel$getGlassBatteryInfo$1(this, (Continuation<? super SuperViewModel$getGlassBatteryInfo$1>) null), 3, (Object) null);
    }

    public final LiveData y() {
        return this.k;
    }

    public final MutableLiveData y0() {
        return this.h;
    }

    public final MutableLiveData z0() {
        return this.e;
    }
}
