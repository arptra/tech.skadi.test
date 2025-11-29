package com.upuphone.xr.sapp.vm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.z8.h;
import com.honey.account.z8.i;
import com.honey.account.z8.j;
import com.honey.account.z8.k;
import com.honey.account.z8.l;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.audio.AudioRecordChannel;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.AsrOpusCodec;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import com.upuphone.xr.sapp.utils.SrVoiceprintStorageHelper;
import com.upuphone.xr.sapp.utils.TextSimilarityUtils;
import com.xjmz.ai.voice.VoiceManager;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Src;
import flyme.support.v7.app.AlertDialog;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\n*\u0001~\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000b*\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u001b\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b \u0010\u001eJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u001eJ\u0015\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0017J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\u001eJ\u0015\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u000b¢\u0006\u0004\b*\u0010\u001eJ\r\u0010+\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u001eJ\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020%¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\u001eJ\u0015\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0006¢\u0006\u0004\b1\u0010\u0017J\u0017\u00103\u001a\u00020\u000b2\b\b\u0001\u00102\u001a\u00020\u000e¢\u0006\u0004\b3\u0010\u0011J-\u00108\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u0010\"\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u000e¢\u0006\u0004\b8\u00109J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bA\u0010@J\r\u0010B\u001a\u00020\u0006¢\u0006\u0004\bB\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010b\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010\u000e0\u000e0^8\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\"\u0010d\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010\u000e0\u000e0^8\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010aR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020e0^8\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010aR\"\u0010i\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010:0:0^8\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010aR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00120^8\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010aR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020\u000e0l8\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u001d\u0010t\u001a\b\u0012\u0004\u0012\u00020\u000e0l8\u0006¢\u0006\f\n\u0004\br\u0010n\u001a\u0004\bs\u0010pR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020e0l8\u0006¢\u0006\f\n\u0004\bu\u0010n\u001a\u0004\bv\u0010pR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020:0l8\u0006¢\u0006\f\n\u0004\bx\u0010n\u001a\u0004\by\u0010pR\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00120l8\u0006¢\u0006\f\n\u0004\b{\u0010n\u001a\u0004\b|\u0010pR\u0016\u0010\u0001\u001a\u00020~8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "F", "()Ljava/lang/String;", "Lcom/xjsd/xr/sapp/asr/dao/Src;", "src", "", "U", "(Lcom/xjsd/xr/sapp/asr/dao/Src;)V", "", "status", "W", "(I)V", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$AudioData;", "audioData", "V", "(Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$AudioData;)V", "S", "(Ljava/lang/String;)V", "B", "", "E", "()Ljava/util/Map;", "N", "Q", "()V", "o0", "k0", "m0", "text", "X", "n0", "", "audioBytes", "", "M", "([B)[F", "j0", "A", "bytes", "Z", "([B)V", "l0", "id", "b0", "type", "a0", "Landroidx/core/widget/NestedScrollView;", "tvScrollView", "Landroid/widget/TextView;", "textView", "O", "(Landroidx/core/widget/NestedScrollView;Landroid/widget/TextView;Ljava/lang/String;I)V", "", "R", "()Z", "Landroid/app/Activity;", "activity", "g0", "(Landroid/app/Activity;)V", "c0", "D", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "c", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "mAudioAsrHelper", "Lcom/upuphone/xr/sapp/audio/AudioRecordChannel;", "d", "Lcom/upuphone/xr/sapp/audio/AudioRecordChannel;", "mAudioChannel", "Lcom/upuphone/xr/sapp/utils/AsrOpusCodec;", "e", "Lcom/upuphone/xr/sapp/utils/AsrOpusCodec;", "mAsrOpusCodec", "", "f", "J", "mSrVoiceprintEngine", "g", "[B", "mSendAudioBytes", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$RoleAsrResult;", "h", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$RoleAsrResult;", "mRoleAsrResult", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_mTtsStatus", "j", "_mSocketStatus", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "k", "_mAsrResult", "l", "_mRoleVprintSuccess", "m", "_mAudioBytes", "Landroidx/lifecycle/LiveData;", "n", "Landroidx/lifecycle/LiveData;", "L", "()Landroidx/lifecycle/LiveData;", "mTtsStatus", "o", "K", "mSocketStatus", "p", "G", "mAsrResult", "q", "I", "mRoleVprintSuccess", "r", "H", "mAudioBytes", "com/upuphone/xr/sapp/vm/RoleVprintViewModel$mAsrResultCallback$1", "s", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$mAsrResultCallback$1;", "mAsrResultCallback", "t", "AudioData", "Companion", "RoleAsrResult", "SystemLanguage", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RoleVprintViewModel extends AndroidViewModel {
    public static final Companion t = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public UnifiedAsrHelper c;
    public AudioRecordChannel d;
    public AsrOpusCodec e;
    public long f;
    public byte[] g = new byte[0];
    public RoleAsrResult h;
    public final MutableLiveData i;
    public final MutableLiveData j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final LiveData n;
    public final LiveData o;
    public final LiveData p;
    public final LiveData q;
    public final LiveData r;
    public final RoleVprintViewModel$mAsrResultCallback$1 s;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$AudioData;", "", "", "status", "", "audioBytes", "<init>", "(I[B)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "I", "b", "[B", "()[B", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class AudioData {

        /* renamed from: a  reason: collision with root package name */
        public final int f8008a;
        public final byte[] b;

        public AudioData(int i, byte[] bArr) {
            this.f8008a = i;
            this.b = bArr;
        }

        public final byte[] a() {
            return this.b;
        }

        public final int b() {
            return this.f8008a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) AudioData.class, (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.xr.sapp.vm.RoleVprintViewModel.AudioData");
            AudioData audioData = (AudioData) obj;
            if (this.f8008a != audioData.f8008a) {
                return false;
            }
            byte[] bArr = this.b;
            if (bArr != null) {
                byte[] bArr2 = audioData.b;
                return bArr2 != null && Arrays.equals(bArr, bArr2);
            } else if (audioData.b != null) {
                return false;
            }
        }

        public int hashCode() {
            int i = this.f8008a * 31;
            byte[] bArr = this.b;
            return i + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }

        public String toString() {
            int i = this.f8008a;
            String arrays = Arrays.toString(this.b);
            return "AudioData(status=" + i + ", audioBytes=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$Companion;", "", "()V", "AUDIO_FAIL", "", "AUDIO_SUCCESS", "DEFAULT_APP_NAME", "", "DEFAULT_DEVICE_ID", "ROLE_SEPARATION_VOICEPRINT_FAIL", "ROLE_SEPARATION_VOICEPRINT_RECORD", "SEND_MIN_AUDIO", "SOCKET_FAIL", "SOCKET_OPEN", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$RoleAsrResult;", "", "", "src", "tempSrc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class RoleAsrResult {

        /* renamed from: a  reason: collision with root package name */
        public final String f8009a;
        public final String b;

        public RoleAsrResult(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "src");
            Intrinsics.checkNotNullParameter(str2, "tempSrc");
            this.f8009a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f8009a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RoleAsrResult)) {
                return false;
            }
            RoleAsrResult roleAsrResult = (RoleAsrResult) obj;
            return Intrinsics.areEqual((Object) this.f8009a, (Object) roleAsrResult.f8009a) && Intrinsics.areEqual((Object) this.b, (Object) roleAsrResult.b);
        }

        public int hashCode() {
            return (this.f8009a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str = this.f8009a;
            String str2 = this.b;
            return "RoleAsrResult(src=" + str + ", tempSrc=" + str2 + ")";
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$SystemLanguage;", "", "<init>", "()V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SystemLanguage {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$SystemLanguage$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f8010a = new Companion();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData(-1);
        this.i = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(-1);
        this.j = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.k = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData(Boolean.FALSE);
        this.l = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        this.m = mutableLiveData5;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.n = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.o = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.xjsd.xr.sapp.asr.dao.AsrResult>");
        this.p = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.q = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData5, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.xr.sapp.vm.RoleVprintViewModel.AudioData>");
        this.r = mutableLiveData5;
        this.s = new RoleVprintViewModel$mAsrResultCallback$1(this);
    }

    public static final void P(TextView textView, Ref.IntRef intRef, NestedScrollView nestedScrollView) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(intRef, "$endIndex");
        Intrinsics.checkNotNullParameter(nestedScrollView, "$tvScrollView");
        Layout layout = textView.getLayout();
        int lineForOffset = layout.getLineForOffset(intRef.element);
        if (lineForOffset >= 1) {
            lineForOffset--;
        }
        nestedScrollView.smoothScrollTo(0, layout.getLineTop(lineForOffset));
    }

    /* access modifiers changed from: private */
    public final void S(String str) {
        ULog.f6446a.g("RoleVprintViewModel", str);
    }

    public static final void Y(RoleVprintViewModel roleVprintViewModel, int i2, int i3) {
        Intrinsics.checkNotNullParameter(roleVprintViewModel, "this$0");
        UnifiedAsrHelper unifiedAsrHelper = roleVprintViewModel.c;
        roleVprintViewModel.S("playTts status=" + i2 + ", errorCode=" + i3 + ", mAudioAsrHelper=" + unifiedAsrHelper);
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(roleVprintViewModel), Dispatchers.c(), (CoroutineStart) null, new RoleVprintViewModel$playTts$2$1(roleVprintViewModel, i2, (Continuation<? super RoleVprintViewModel$playTts$2$1>) null), 2, (Object) null);
    }

    public static final void e0(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public static final void h0(Activity activity, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        AppUtils.q(AppUtils.f7842a, activity, 0, 2, (Object) null);
        dialogInterface.dismiss();
    }

    public static final void i0(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public final void A() {
        UnifiedAsrHelper unifiedAsrHelper = this.c;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.sendRemoteEndMessage();
        }
    }

    public final String B() {
        String string = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String D() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        S("getAsrLanguage language=" + language + ", country=" + country);
        String str = (String) E().get(language);
        return str == null ? "cmn-Hans-CN" : str;
    }

    public final Map E() {
        HashMap hashMap = new HashMap();
        TuplesKt.to("zh", "cmn-Hans-CN");
        TuplesKt.to("en", "en-GB");
        TuplesKt.to("fr", "fr-FR");
        TuplesKt.to("de", "de-DE");
        return hashMap;
    }

    public final String F() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_device_connect_history", "UnKnow-12345", (Context) null, 4, (Object) null);
    }

    public final LiveData G() {
        return this.p;
    }

    public final LiveData H() {
        return this.r;
    }

    public final LiveData I() {
        return this.q;
    }

    public final LiveData K() {
        return this.o;
    }

    public final LiveData L() {
        return this.n;
    }

    public final float[] M(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "audioBytes");
        return VoiceManager.Companion.getInstance().spkRecogGetEmb(this.f, bArr, bArr.length);
    }

    public final String N() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        S("getSystemLanguage language=" + language + ", country=" + country);
        Intrinsics.checkNotNull(language);
        return language;
    }

    public final void O(NestedScrollView nestedScrollView, TextView textView, String str, int i2) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "tvScrollView");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(str, "text");
        String string = textView.getContext().getString(R.string.vp_separate_role_spoken_words);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Ref.IntRef intRef = new Ref.IntRef();
        if (Intrinsics.areEqual((Object) N(), (Object) "zh")) {
            Pair c2 = TextSimilarityUtils.f7926a.c(string, str);
            String str2 = (String) c2.component1();
            int intValue = ((Number) c2.component2()).intValue();
            if (!StringsKt.isBlank(str2) && intValue != -1) {
                int length = intValue + str2.length();
                intRef.element = length;
                if (length > string.length()) {
                    intRef.element = string.length();
                }
            } else {
                return;
            }
        } else {
            TextSimilarityUtils textSimilarityUtils = TextSimilarityUtils.f7926a;
            Locale locale = Locale.ROOT;
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String lowerCase2 = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            List b2 = textSimilarityUtils.b(lowerCase, lowerCase2, 0.6d);
            if (!b2.isEmpty()) {
                intRef.element = ((Number) ((Pair) b2.get(CollectionsKt.getLastIndex(b2))).getSecond()).intValue();
            } else {
                return;
            }
        }
        if (i2 == 0) {
            this.l.setValue(Boolean.TRUE);
            intRef.element = string.length();
        }
        int color = textView.getContext().getColor(R.color.vp_separate_role_ic_record_completed);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, intRef.element, 34);
        textView.setText(spannableString);
        textView.post(new h(textView, intRef, nestedScrollView));
    }

    public final void Q() {
        S("初始化ViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new RoleVprintViewModel$init$1(this, (Continuation<? super RoleVprintViewModel$init$1>) null), 2, (Object) null);
        AudioRecordChannel audioRecordChannel = new AudioRecordChannel();
        AudioRecordChannel.l(audioRecordChannel, 0, 0, new RoleVprintViewModel$init$2$1(this), new RoleVprintViewModel$init$2$2(this), 3, (Object) null);
        this.d = audioRecordChannel;
        UnifiedAsrHelper unifiedAsrHelper = new UnifiedAsrHelper("com.xjmz.sapp.voiceprint", false, 2, (DefaultConstructorMarker) null);
        unifiedAsrHelper.registerAsrResultCallback("RoleVprintViewModel", this.s);
        this.c = unifiedAsrHelper;
        AsrOpusCodec asrOpusCodec = new AsrOpusCodec();
        AsrOpusCodec.b(asrOpusCodec, false, 1, (Object) null);
        this.e = asrOpusCodec;
        SrVoiceprintStorageHelper.b(SdkContext.f6675a.c().getContext());
    }

    public final boolean R() {
        Src src;
        AsrResult asrResult = (AsrResult) this.k.getValue();
        if (asrResult == null || (src = asrResult.getSrc()) == null) {
            return false;
        }
        String string = this.b.getString(R.string.vp_separate_role_spoken_words);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return ((double) src.getContent().length()) >= ((double) string.length()) * 0.9d;
    }

    public final void U(Src src) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new RoleVprintViewModel$notifyAsrResult$1(this, src, (Continuation<? super RoleVprintViewModel$notifyAsrResult$1>) null), 2, (Object) null);
    }

    public final void V(AudioData audioData) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new RoleVprintViewModel$notifyAudioData$1(this, audioData, (Continuation<? super RoleVprintViewModel$notifyAudioData$1>) null), 2, (Object) null);
    }

    public final void W(int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new RoleVprintViewModel$notifySocketStatus$1(this, i2, (Continuation<? super RoleVprintViewModel$notifySocketStatus$1>) null), 2, (Object) null);
    }

    public final void X(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        S("playTts tts=" + str);
        TtsSdk ttsSdk = TtsSdk.f5490a;
        Bundle bundle = new Bundle();
        bundle.putInt("caller_priority", 0);
        Unit unit = Unit.INSTANCE;
        ttsSdk.p("RoleVprintViewModel", str, 0, bundle, String.valueOf(System.currentTimeMillis()), new i(this));
    }

    public final void Z(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        UnifiedAsrHelper unifiedAsrHelper = this.c;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.sendRemoteAudioData(bArr);
        }
    }

    public final void a0(int i2) {
        SdkContext.f6675a.d().reportEvent("App_RoleSeparation_Voiceprint_Fail", MapsKt.hashMapOf(TuplesKt.to("type", String.valueOf(i2))));
    }

    public final void b0(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        SdkContext.f6675a.d().reportEvent("App_RoleSeparation_Voiceprint_Record", MapsKt.hashMapOf(TuplesKt.to("vuid1", str)));
    }

    public final void c0(Activity activity) {
        View decorView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.network_error_pls_retry_later).setPositiveButton(R.string.app_confirm, (DialogInterface.OnClickListener) new j()).create();
        Window window = create.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            FlymeUtils.a(decorView, activity);
        }
        create.show();
    }

    public final void g0(Activity activity) {
        View decorView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.network_not_available_pls_check).setPositiveButton(R.string.network_setting, (DialogInterface.OnClickListener) new k(activity)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new l()).create();
        Window window = create.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            FlymeUtils.a(decorView, activity);
        }
        create.show();
    }

    public final void j0() {
        Unit unit;
        String F = F();
        String D = D();
        UnifiedAsrHelper unifiedAsrHelper = this.c;
        if (unifiedAsrHelper != null) {
            UnifiedAsrHelper.startRequest$default(unifiedAsrHelper, new AsrRequestConfig.Builder().srcLang(D).dstLang(D).deviceId(B()).iotDeviceId(F).supplier(AsrConstants.ASR_MICROSOFT).appName("com.xjmz.sapp.voiceprint").data(new AsrRequestConfig.RequestData("pcm", 0, 0, 0, (List) null, false, 62, (DefaultConstructorMarker) null)).build(), (AsrRequestConfig) null, 2, (Object) null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            S("startAsrRequest audioAsrHelper is null");
        }
        this.h = null;
    }

    public final void k0() {
        this.g = new byte[0];
        AudioRecordChannel audioRecordChannel = this.d;
        if (audioRecordChannel != null) {
            audioRecordChannel.o();
        }
    }

    public final void l0() {
        UnifiedAsrHelper unifiedAsrHelper = this.c;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.stopRequest();
        }
        this.h = null;
    }

    public final void m0() {
        AudioRecordChannel audioRecordChannel = this.d;
        if (audioRecordChannel != null) {
            audioRecordChannel.p();
        }
    }

    public final void n0() {
        TtsSdk.u(TtsSdk.f5490a, "RoleVprintViewModel", (String) null, 2, (Object) null);
    }

    public final void o0() {
        S("销毁ViewModel");
        n0();
        AudioRecordChannel audioRecordChannel = this.d;
        if (audioRecordChannel != null) {
            audioRecordChannel.m();
        }
        this.d = null;
        this.g = new byte[0];
        l0();
        UnifiedAsrHelper unifiedAsrHelper = this.c;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.unRegisterAsrResultCallback("RoleVprintViewModel", this.s);
            unifiedAsrHelper.release();
        }
        this.c = null;
        AsrOpusCodec asrOpusCodec = this.e;
        if (asrOpusCodec != null) {
            asrOpusCodec.d();
        }
        this.f = 0;
        SrVoiceprintStorageHelper.f7916a.d();
    }
}
