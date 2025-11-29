package com.upuphone.xr.sapp.vu.ota;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.CircleProgressBar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.fota.phone.CheckGlassUpdateParam;
import com.upuphone.star.fota.phone.CheckGlassUpdateParamV2;
import com.upuphone.star.fota.phone.GlassUpdateApiManager;
import com.upuphone.star.fota.phone.HostProvider;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.NotificationUtils;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.xjmz.myvu.MYVUActivity;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH@¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0003JE\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00130\u00162\u0006\u0010\t\u001a\u00020\u00062\u001a\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH@¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u00122\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H@¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00142\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b3\u0010.¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "b", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInfo", "Lkotlin/Function1;", "", "", "onProgress", "", "m", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "Lkotlin/Pair;", "Ljava/io/File;", "roms", "", "f", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;[Lkotlin/Pair;)Ljava/util/List;", "file", "type", "j", "(Ljava/io/File;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dir", "g", "(Ljava/io/File;)[Lkotlin/Pair;", "", "language", "country", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "i", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "e", "(Ljava/lang/String;Ljava/io/File;)Z", "Landroid/content/Context;", "context", "h", "(Landroid/content/Context;)Ljava/io/File;", "d", "(Ljava/io/File;)V", "zipFile", "destDir", "l", "(Ljava/io/File;Ljava/io/File;)Z", "k", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassUpdateHelper.kt\ncom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1864#2,3:429\n1864#2,3:432\n13309#3,2:435\n13309#3,2:437\n13309#3,2:439\n13309#3,2:442\n1#4:441\n*S KotlinDebug\n*F\n+ 1 VuGlassUpdateHelper.kt\ncom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper\n*L\n162#1:429,3\n185#1:432,3\n194#1:435,2\n253#1:437,2\n268#1:439,2\n381#1:442,2\n*E\n"})
public final class VuGlassUpdateHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8081a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "title", "latestVersion", "", "b", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "a", "DOWNLOAD_FILE_SUB_DIR", "Ljava/lang/String;", "GO_TO_UPDATE", "", "ID_GLASS_UPDATE", "I", "OTA_FILE_EXT", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            NotificationUtils.f7900a.a(DfuBaseService.ERROR_FILE_NOT_FOUND);
        }

        public final void b(Context context, String str, String str2) {
            Context context2 = context;
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str3, "title");
            Intrinsics.checkNotNullParameter(str4, "latestVersion");
            if (!MainApplication.k.f().v()) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("VuGlassUpdateHelper", "showNotification, title: " + str3 + ", latestVersion: " + str4);
                Intent intent = new Intent(context, MYVUActivity.class);
                intent.putExtra("go_to_update", true);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, CircleProgressBar.RIM_COLOR_DEF);
                NotificationUtils.j(NotificationUtils.f7900a, DfuBaseService.ERROR_FILE_NOT_FOUND, "channel_glass_update", str, VuGlassesHidUtil.f8104a.h(str4), 0, 0, activity, (Integer) null, true, false, false, 176, (Object) null);
            }
        }

        public Companion() {
        }
    }

    public VuGlassUpdateHelper() {
        GlassUpdateApiManager.f6471a.j(new HostProvider() {
            public String a() {
                return NetConfig.f6666a.v("sArOta");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.upuphone.xr.sapp.entity.DeviceInfo r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$checkUpdate$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$checkUpdate$1 r3 = (com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$checkUpdate$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$checkUpdate$1 r3 = new com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$checkUpdate$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            java.lang.String r7 = "VuGlassUpdateHelper"
            r8 = 1
            if (r5 == 0) goto L_0x004e
            if (r5 != r8) goto L_0x0046
            java.lang.Object r0 = r3.L$3
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r3.L$1
            com.upuphone.xr.sapp.entity.DeviceInfo r4 = (com.upuphone.xr.sapp.entity.DeviceInfo) r4
            java.lang.Object r3 = r3.L$0
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper r3 = (com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r13 = r0
            r12 = r1
            r0 = r3
            r1 = r4
            goto L_0x0089
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.String r2 = r18.getRomVersion()
            if (r2 == 0) goto L_0x018d
            int r2 = r2.length()
            if (r2 != 0) goto L_0x005f
            goto L_0x018d
        L_0x005f:
            com.upuphone.xr.sapp.utils.AppUtils r2 = com.upuphone.xr.sapp.utils.AppUtils.f7842a
            android.content.Context r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            kotlin.Pair r2 = r2.g(r5)
            java.lang.Object r5 = r2.component1()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r2 = r2.component2()
            java.lang.String r2 = (java.lang.String) r2
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r5
            r3.L$3 = r2
            r3.label = r8
            java.lang.Object r3 = r0.i(r1, r5, r2, r3)
            if (r3 != r4) goto L_0x0086
            return r4
        L_0x0086:
            r13 = r2
            r2 = r3
            r12 = r5
        L_0x0089:
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r2 = (com.upuphone.star.fota.phone.GlassCheckUpdateResult) r2
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "checkUpdateResult: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.a(r7, r4)
            com.upuphone.star.fota.phone.GlassUpdateInfo r4 = r2.getData()
            r5 = 0
            if (r4 == 0) goto L_0x00af
            boolean r4 = r4.getExistsUpdate()
            if (r4 != r8) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            r8 = r5
        L_0x00b0:
            com.upuphone.star.fota.phone.GlassUpdateInfo r4 = r2.getData()
            if (r4 == 0) goto L_0x00bb
            java.lang.String r4 = r4.getDigest()
            goto L_0x00bc
        L_0x00bb:
            r4 = r6
        L_0x00bc:
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r2.getData()
            if (r5 == 0) goto L_0x00c6
            java.lang.String r6 = r5.getPackLink()
        L_0x00c6:
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r2.getData()
            if (r5 == 0) goto L_0x00d7
            java.lang.Long r5 = r5.getFileSize()
            if (r5 == 0) goto L_0x00d7
            long r9 = r5.longValue()
            goto L_0x00d9
        L_0x00d7:
            r9 = -1
        L_0x00d9:
            boolean r5 = r2.isSuccess()
            if (r5 == 0) goto L_0x0175
            if (r8 == 0) goto L_0x0175
            if (r4 == 0) goto L_0x0175
            int r5 = r4.length()
            if (r5 != 0) goto L_0x00eb
            goto L_0x0175
        L_0x00eb:
            if (r6 == 0) goto L_0x0175
            int r5 = r6.length()
            if (r5 != 0) goto L_0x00f5
            goto L_0x0175
        L_0x00f5:
            java.lang.String r5 = "start download update file"
            r3.a(r7, r5)
            com.upuphone.xr.sapp.MainApplication$Companion r5 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r5 = r5.f()
            java.io.File r5 = r0.h(r5)
            r0.d(r5)
            r5.mkdirs()
            java.io.File r15 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r4 = ".zip"
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r15.<init>(r5, r4)
            boolean r4 = r15.exists()
            if (r4 == 0) goto L_0x012e
            long r4 = r15.length()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x0146
        L_0x012e:
            boolean r0 = r0.e(r6, r15)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "download result: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.a(r7, r0)
        L_0x0146:
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r0 = new com.upuphone.xr.sapp.vu.ota.VuUpdateInfo
            com.upuphone.star.fota.phone.GlassUpdateInfo r3 = r2.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = r3.getLatestVersion()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0159
            r10 = r4
            goto L_0x015a
        L_0x0159:
            r10 = r3
        L_0x015a:
            java.lang.String r11 = r1.getRomVersion()
            com.upuphone.star.fota.phone.GlassUpdateInfo r1 = r2.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = r1.getReleaseNote()
            if (r1 != 0) goto L_0x016d
            r14 = r4
            goto L_0x016e
        L_0x016d:
            r14 = r1
        L_0x016e:
            r16 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x0175:
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r0 = new com.upuphone.xr.sapp.vu.ota.VuUpdateInfo
            java.lang.String r3 = r1.getRomVersion()
            r7 = 0
            int r8 = r2.getCode()
            java.lang.String r2 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r0
        L_0x018d:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "checkUpdate: romVersion null"
            r0.a(r7, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper.b(com.upuphone.xr.sapp.entity.DeviceInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c() {
        File[] listFiles;
        File h = h(MainApplication.k.f());
        if (h.exists() && h.isDirectory() && (listFiles = h.listFiles()) != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public final void d(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Intrinsics.checkNotNull(file2);
                        d(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0063, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.String r11, java.io.File r12) {
        /*
            r10 = this;
            r10 = -1
            r0 = 3
        L_0x0002:
            r1 = 1
            if (r0 <= 0) goto L_0x0069
            java.net.URL r2 = new java.net.URL
            r2.<init>(r11)
            boolean r3 = r12.exists()     // Catch:{ Exception -> 0x0014 }
            if (r3 == 0) goto L_0x0016
            r12.delete()     // Catch:{ Exception -> 0x0014 }
            goto L_0x0016
        L_0x0014:
            r1 = move-exception
            goto L_0x0064
        L_0x0016:
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0014 }
            int r3 = r2.getContentLength()     // Catch:{ Exception -> 0x0014 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0014 }
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0014 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x004d }
            r5.<init>(r12)     // Catch:{ all -> 0x004d }
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0041 }
            r6.<init>()     // Catch:{ all -> 0x0041 }
            r7 = 0
            r8 = r7
        L_0x0032:
            int r9 = r2.read(r4)     // Catch:{ all -> 0x0041 }
            r6.element = r9     // Catch:{ all -> 0x0041 }
            if (r9 == r10) goto L_0x0043
            r5.write(r4, r7, r9)     // Catch:{ all -> 0x0041 }
            int r9 = r6.element     // Catch:{ all -> 0x0041 }
            int r8 = r8 + r9
            goto L_0x0032
        L_0x0041:
            r1 = move-exception
            goto L_0x0058
        L_0x0043:
            r4 = 0
            if (r8 == r3) goto L_0x004f
            kotlin.io.CloseableKt.closeFinally(r5, r4)     // Catch:{ all -> 0x004d }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ Exception -> 0x0014 }
            return r7
        L_0x004d:
            r1 = move-exception
            goto L_0x005e
        L_0x004f:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            kotlin.io.CloseableKt.closeFinally(r5, r4)     // Catch:{ all -> 0x004d }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ Exception -> 0x0014 }
            return r1
        L_0x0058:
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x005e:
            throw r1     // Catch:{ all -> 0x005f }
        L_0x005f:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ Exception -> 0x0014 }
            throw r3     // Catch:{ Exception -> 0x0014 }
        L_0x0064:
            r1.printStackTrace()
            int r0 = r0 + r10
            goto L_0x0002
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper.e(java.lang.String, java.io.File):boolean");
    }

    public final List f(VuUpdateInfo vuUpdateInfo, Pair[] pairArr) {
        List listOf = CollectionsKt.listOf(-1, 1, 2, 0);
        List split$default = StringsKt.split$default((CharSequence) vuUpdateInfo.a(), new String[]{"."}, false, 0, 6, (Object) null);
        List split$default2 = StringsKt.split$default((CharSequence) vuUpdateInfo.g(), new String[]{"."}, false, 0, 6, (Object) null);
        ULog.f6446a.a("VuGlassUpdateHelper", "filterRom currentVersion: " + split$default + ", updateVersion: " + split$default2);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : split$default2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((Object) (String) CollectionsKt.getOrNull(split$default, i), (Object) (String) next)) {
                arrayList.add(listOf.get(i));
            }
            i = i2;
        }
        ULog.f6446a.a("VuGlassUpdateHelper", "filterRom updateType: " + arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : pairArr) {
            if (pair != null && arrayList.contains(pair.getFirst())) {
                arrayList2.add(pair);
            }
        }
        return arrayList2;
    }

    public final Pair[] g(File file) {
        Pair[] pairArr = new Pair[3];
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt.contains$default((CharSequence) name, (CharSequence) "dsp", false, 2, (Object) null)) {
                    pairArr[0] = TuplesKt.to(1, file2);
                } else {
                    String name2 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (StringsKt.contains$default((CharSequence) name2, (CharSequence) "lt7911", false, 2, (Object) null)) {
                        pairArr[1] = TuplesKt.to(2, file2);
                    } else {
                        String name3 = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                        if (StringsKt.contains$default((CharSequence) name3, (CharSequence) "stm32", false, 2, (Object) null)) {
                            pairArr[2] = TuplesKt.to(0, file2);
                        }
                    }
                }
            }
        }
        return pairArr;
    }

    public final File h(Context context) {
        return new File(context.getFilesDir(), "view_glass_ota");
    }

    public final Object i(DeviceInfo deviceInfo, String str, String str2, Continuation continuation) {
        String str3 = str;
        String str4 = str2;
        Continuation continuation2 = continuation;
        boolean e = SdkContext.f6675a.c().e();
        String name = deviceInfo.getName();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassUpdateHelper", "deviceName: " + name);
        String model = deviceInfo.getModel();
        delegate.a("VuGlassUpdateHelper", "model: " + model);
        String serialNo = deviceInfo.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        delegate.a("VuGlassUpdateHelper", "sn: " + serialNo);
        String f = DataTrackUtil.f7875a.f(serialNo);
        delegate.a("VuGlassUpdateHelper", "getUpdateInfo, deviceIdEncrypted: " + true + ", deviceId: " + f);
        String romVersion = deviceInfo.getRomVersion();
        String str5 = romVersion == null ? "" : romVersion;
        delegate.a("VuGlassUpdateHelper", "romVersion: " + str5);
        if (e) {
            GlassUpdateApiManager glassUpdateApiManager = GlassUpdateApiManager.f6471a;
            long currentTimeMillis = System.currentTimeMillis();
            return glassUpdateApiManager.c(new CheckGlassUpdateParam("View", f, str5, model, "user", "release", currentTimeMillis, str3 + AccountConstantKt.DEFAULT_SEGMENT + str4, true), continuation2);
        }
        GlassUpdateApiManager glassUpdateApiManager2 = GlassUpdateApiManager.f6471a;
        long currentTimeMillis2 = System.currentTimeMillis();
        return glassUpdateApiManager2.d(new CheckGlassUpdateParamV2("View", f, str5, model, "user", "release", currentTimeMillis2, str3 + AccountConstantKt.DEFAULT_SEGMENT + str4, "2.40.51", (String) null, (String) null, true, (String) null, 4096, (DefaultConstructorMarker) null), continuation2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(java.io.File r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$1 r0 = (com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$1 r0 = new com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x005e
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "install Rom: type: "
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "VuGlassUpdateHelper"
            r4.a(r3, r1)
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$2 r4 = new com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$installRom$2
            r1 = 0
            r4.<init>(r5, r6, r7, r1)
            r0.label = r2
            r5 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.d(r5, r4, r0)
            if (r4 != r8) goto L_0x005e
            return r8
        L_0x005e:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L_0x0067
            boolean r4 = r4.booleanValue()
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper.j(java.io.File, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void k(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final boolean l(File file, File file2) {
        if (!file.exists()) {
            return false;
        }
        try {
            if (file2.exists()) {
                d(file2);
            }
            file2.mkdirs();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            try {
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    File file3 = new File(file2, nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        k(file3);
                    } else {
                        ByteStreamsKt.copyTo$default(zipInputStream instanceof BufferedInputStream ? (BufferedInputStream) zipInputStream : new BufferedInputStream(zipInputStream, 8192), new FileOutputStream(file3), 0, 2, (Object) null);
                    }
                    zipInputStream.closeEntry();
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                return true;
            } catch (Throwable th) {
                CloseableKt.closeFinally(zipInputStream, th);
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r21, kotlin.jvm.functions.Function1 r22, kotlin.coroutines.Continuation r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r23
            boolean r2 = r1 instanceof com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$1 r2 = (com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$1 r2 = new com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 1
            java.lang.String r7 = "VuGlassUpdateHelper"
            if (r4 == 0) goto L_0x005a
            if (r4 != r6) goto L_0x0052
            int r0 = r2.I$0
            float r4 = r2.F$0
            java.lang.Object r8 = r2.L$5
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r9 = r2.L$4
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r2.L$3
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r2.L$2
            java.io.File r11 = (java.io.File) r11
            java.lang.Object r12 = r2.L$1
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Object r13 = r2.L$0
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper r13 = (com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r19 = r13
            r13 = r0
            r0 = r19
            goto L_0x012f
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r1)
            java.io.File r1 = r21.f()
            if (r1 == 0) goto L_0x0197
            boolean r4 = r1.exists()
            if (r4 != r6) goto L_0x0197
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r8 = r22
            r8.invoke(r4)
            java.lang.String r4 = kotlin.io.FilesKt.getNameWithoutExtension(r1)
            java.io.File r9 = new java.io.File
            java.io.File r10 = r1.getParentFile()
            r9.<init>(r10, r4)
            r0.d(r9)
            r9.mkdirs()
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r10 = "start update"
            r4.a(r7, r10)
            boolean r1 = r0.l(r1, r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "unzip end: "
            r10.append(r11)
            r10.append(r1)
            java.lang.String r1 = r10.toString()
            r4.a(r7, r1)
            kotlin.Pair[] r1 = r0.g(r9)
            r10 = r21
            java.util.List r1 = r0.f(r10, r1)
            r17 = 63
            r18 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r10 = r1
            java.lang.String r10 = kotlin.collections.CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "roms: "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r4.a(r7, r10)
            kotlin.jvm.internal.Ref$BooleanRef r4 = new kotlin.jvm.internal.Ref$BooleanRef
            r4.<init>()
            int r10 = r1.size()
            float r10 = (float) r10
            r11 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 / r10
            java.util.Iterator r1 = r1.iterator()
            r10 = r4
            r4 = r11
            r11 = r9
            r9 = r1
            r1 = r5
        L_0x00e9:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0167
            java.lang.Object r12 = r9.next()
            int r13 = r1 + 1
            if (r1 >= 0) goto L_0x00fa
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00fa:
            kotlin.Pair r12 = (kotlin.Pair) r12
            java.lang.Object r14 = r12.getSecond()
            java.io.File r14 = (java.io.File) r14
            java.lang.Object r15 = r12.getFirst()
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$2$installResult$1 r5 = new com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper$update$2$installResult$1
            r5.<init>(r8, r1, r4)
            r2.L$0 = r0
            r2.L$1 = r8
            r2.L$2 = r11
            r2.L$3 = r10
            r2.L$4 = r9
            r2.L$5 = r12
            r2.F$0 = r4
            r2.I$0 = r13
            r2.label = r6
            java.lang.Object r1 = r0.j(r14, r15, r5, r2)
            if (r1 != r3) goto L_0x012a
            return r3
        L_0x012a:
            r19 = r12
            r12 = r8
            r8 = r19
        L_0x012f:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Object r8 = r8.getSecond()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r8)
            java.lang.String r8 = " install Result: "
            r14.append(r8)
            r14.append(r1)
            java.lang.String r8 = ", "
            r14.append(r8)
            java.lang.String r8 = r14.toString()
            r5.a(r7, r8)
            boolean r5 = r10.element
            if (r5 != 0) goto L_0x0160
            if (r1 == 0) goto L_0x015e
            goto L_0x0160
        L_0x015e:
            r1 = 0
            goto L_0x0161
        L_0x0160:
            r1 = r6
        L_0x0161:
            r10.element = r1
            r8 = r12
            r1 = r13
            r5 = 0
            goto L_0x00e9
        L_0x0167:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            boolean r2 = r10.element
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "update finish hasSuccess:"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.a(r7, r2)
            r0.d(r11)
            boolean r0 = r10.element
            if (r0 == 0) goto L_0x0190
            r0 = 100
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r8.invoke(r0)
        L_0x0190:
            boolean r0 = r10.element
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        L_0x0197:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "ota file not exist"
            r0.a(r7, r1)
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper.m(com.upuphone.xr.sapp.vu.ota.VuUpdateInfo, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
