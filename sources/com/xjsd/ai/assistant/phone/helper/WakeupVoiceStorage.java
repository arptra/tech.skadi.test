package com.xjsd.ai.assistant.phone.helper;

import androidx.annotation.Keep;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.VersionExtKt;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.util.KeyStoreHelper;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.CmdCode;
import io.ktor.util.Base64Kt;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u001c\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001c*\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u0011H\u0002J\f\u0010\u001f\u001a\u00020\u000e*\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/WakeupVoiceStorage;", "", "()V", "KEY_WAKEUP_RECORDING", "", "TAG", "cacheAbility", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cachePath", "cachePathOld", "clear", "", "get", "", "", "path", "has", "", "mark", "recording", "needSyncToGlass", "save", "emb", "sync", "syncToGlass", "state", "Lcom/xjsd/ai/assistant/phone/helper/WakeupVoiceStorage$VoiceState;", "data", "", "toByteArray", "littleEndian", "toFloatArray", "VoiceState", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WakeupVoiceStorage {
    @NotNull
    public static final WakeupVoiceStorage INSTANCE = new WakeupVoiceStorage();
    @NotNull
    public static final String KEY_WAKEUP_RECORDING = "wakeup_recording_state";
    @NotNull
    private static final String TAG = "WakeupVoiceStorage";
    @Nullable
    private static final CacheAbility cacheAbility = ((CacheAbility) AbilityManager.b.b(CacheAbility.class));
    @NotNull
    private static String cachePath;
    /* access modifiers changed from: private */
    @NotNull
    public static String cachePathOld;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage$1", f = "WakeupVoiceStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WakeupVoiceStorage wakeupVoiceStorage = WakeupVoiceStorage.INSTANCE;
                List<float[]> list = wakeupVoiceStorage.get(WakeupVoiceStorage.cachePathOld);
                if (!list.isEmpty()) {
                    ILog.a(WakeupVoiceStorage.TAG, "upgrade wakeup voice print to v2");
                    wakeupVoiceStorage.save((float[]) CollectionsKt.first(list));
                    new File(WakeupVoiceStorage.cachePathOld).delete();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/WakeupVoiceStorage$VoiceState;", "", "isRecording", "", "hasVoicePrint", "voicePrint", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHasVoicePrint", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVoicePrint", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/helper/WakeupVoiceStorage$VoiceState;", "equals", "other", "hashCode", "", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VoiceState {
        @Nullable
        private final Boolean hasVoicePrint;
        @Nullable
        private final Boolean isRecording;
        @Nullable
        private final String voicePrint;

        public VoiceState() {
            this((Boolean) null, (Boolean) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ VoiceState copy$default(VoiceState voiceState, Boolean bool, Boolean bool2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = voiceState.isRecording;
            }
            if ((i & 2) != 0) {
                bool2 = voiceState.hasVoicePrint;
            }
            if ((i & 4) != 0) {
                str = voiceState.voicePrint;
            }
            return voiceState.copy(bool, bool2, str);
        }

        @Nullable
        public final Boolean component1() {
            return this.isRecording;
        }

        @Nullable
        public final Boolean component2() {
            return this.hasVoicePrint;
        }

        @Nullable
        public final String component3() {
            return this.voicePrint;
        }

        @NotNull
        public final VoiceState copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str) {
            return new VoiceState(bool, bool2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoiceState)) {
                return false;
            }
            VoiceState voiceState = (VoiceState) obj;
            return Intrinsics.areEqual((Object) this.isRecording, (Object) voiceState.isRecording) && Intrinsics.areEqual((Object) this.hasVoicePrint, (Object) voiceState.hasVoicePrint) && Intrinsics.areEqual((Object) this.voicePrint, (Object) voiceState.voicePrint);
        }

        @Nullable
        public final Boolean getHasVoicePrint() {
            return this.hasVoicePrint;
        }

        @Nullable
        public final String getVoicePrint() {
            return this.voicePrint;
        }

        public int hashCode() {
            Boolean bool = this.isRecording;
            int i = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.hasVoicePrint;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.voicePrint;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @Nullable
        public final Boolean isRecording() {
            return this.isRecording;
        }

        @NotNull
        public String toString() {
            Boolean bool = this.isRecording;
            Boolean bool2 = this.hasVoicePrint;
            String str = this.voicePrint;
            return "VoiceState(isRecording=" + bool + ", hasVoicePrint=" + bool2 + ", voicePrint=" + str + ")";
        }

        public VoiceState(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str) {
            this.isRecording = bool;
            this.hasVoicePrint = bool2;
            this.voicePrint = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VoiceState(Boolean bool, Boolean bool2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str);
        }
    }

    static {
        String absolutePath = ContextHelper.a().getFilesDir().getAbsolutePath();
        cachePathOld = absolutePath + "/voice/print.cache";
        String absolutePath2 = ContextHelper.a().getFilesDir().getAbsolutePath();
        cachePath = absolutePath2 + "/voice/print_v2.cache";
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
    }

    private WakeupVoiceStorage() {
    }

    public static /* synthetic */ List get$default(WakeupVoiceStorage wakeupVoiceStorage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cachePath;
        }
        return wakeupVoiceStorage.get(str);
    }

    private final boolean needSyncToGlass() {
        String str;
        String romVersion;
        String d;
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null || (romVersion = a2.getRomVersion()) == null || (d = GlassInfoExtKt.d(romVersion)) == null || (str = GlassInfoExtKt.c(d)) == null) {
            str = "0.0.1";
        }
        ILog.a(TAG, "glass version: " + str);
        return VersionExtKt.a(str, "1.1.3") > 0;
    }

    private final void syncToGlass(VoiceState voiceState, byte[] bArr) {
        Communicator.c(CmdCode.CODE_WAKEUP_RECORDING, voiceState, bArr, new WakeupVoiceStorage$syncToGlass$1(voiceState));
    }

    public static /* synthetic */ void syncToGlass$default(WakeupVoiceStorage wakeupVoiceStorage, VoiceState voiceState, byte[] bArr, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        wakeupVoiceStorage.syncToGlass(voiceState, bArr);
    }

    private final byte[] toByteArray(float[] fArr, boolean z) {
        ByteBuffer allocate = ByteBuffer.allocate(fArr.length * 4);
        if (z) {
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        for (float putFloat : fArr) {
            allocate.putFloat(putFloat);
        }
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, "array(...)");
        return array;
    }

    public static /* synthetic */ byte[] toByteArray$default(WakeupVoiceStorage wakeupVoiceStorage, float[] fArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return wakeupVoiceStorage.toByteArray(fArr, z);
    }

    /* access modifiers changed from: private */
    public final float[] toFloatArray(byte[] bArr) {
        int length = bArr.length / 4;
        float[] fArr = new float[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (int i = 0; i < length; i++) {
            fArr[i] = wrap.getFloat();
        }
        return fArr;
    }

    public final void clear() {
        ILog.a(TAG, "clear wakeup voice print");
        new File(cachePath).delete();
        syncToGlass$default(this, new VoiceState((Boolean) null, Boolean.FALSE, (String) null, 5, (DefaultConstructorMarker) null), (byte[]) null, 2, (Object) null);
    }

    @NotNull
    public final List<float[]> get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        File file = new File(str);
        if (!file.exists()) {
            ILog.g(TAG, "get but file not exit.");
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        FilesKt.forEachLine$default(file, (Charset) null, new WakeupVoiceStorage$get$1$1(arrayList), 1, (Object) null);
        return arrayList;
    }

    public final boolean has() {
        boolean exists = new File(cachePath).exists();
        ILog.a(TAG, "has record wakeup voice print: " + exists);
        return exists;
    }

    public final void mark(boolean z) {
        CacheAbility cacheAbility2 = cacheAbility;
        if (cacheAbility2 != null) {
            cacheAbility2.cache(KEY_WAKEUP_RECORDING, Boolean.valueOf(z));
        }
        syncToGlass$default(this, new VoiceState(Boolean.valueOf(z), (Boolean) null, (String) null, 6, (DefaultConstructorMarker) null), (byte[]) null, 2, (Object) null);
    }

    public final void save(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "emb");
        File file = new File(cachePath);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
        } else {
            file.delete();
        }
        file.createNewFile();
        byte[] bArr = null;
        FilesKt.appendText$default(file, Base64Kt.g(KeyStoreHelper.f8445a.b(toByteArray$default(INSTANCE, fArr, false, 1, (Object) null))), (Charset) null, 2, (Object) null);
        String joinToString$default = ArraysKt.joinToString$default(fArr, (CharSequence) MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        ILog.a(TAG, "emb array: " + joinToString$default);
        VoiceState voiceState = new VoiceState((Boolean) null, Boolean.TRUE, (String) null, 5, (DefaultConstructorMarker) null);
        if (needSyncToGlass()) {
            bArr = toByteArray(fArr, true);
        }
        syncToGlass(voiceState, bArr);
    }

    public final void sync() {
        if (!needSyncToGlass()) {
            ILog.a(TAG, "old glass version not need to send voice print");
            return;
        }
        List<float[]> list = get(cachePath);
        if (!list.isEmpty()) {
            syncToGlass(new VoiceState((Boolean) null, Boolean.TRUE, (String) null, 5, (DefaultConstructorMarker) null), toByteArray((float[]) CollectionsKt.first(list), true));
        } else {
            ILog.a(TAG, "There's no voice print saved");
        }
    }
}
