package com.meizu.flyme.policy.sdk.util;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.w2.a;
import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicyFileDataResultBean;
import com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkFileUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkFileUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] areaList = {"SA", "MY", "TH", "HK"};

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J.\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J0\u0010!\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\""}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkFileUtils$Companion;", "", "()V", "areaList", "", "", "[Ljava/lang/String;", "copyAssetsFile", "context", "Landroid/content/Context;", "sourcePath", "toPath", "copyPolicyFile", "deleteFile", "", "oldPolicyPath", "getPolicyDataFromFileName", "Lcom/meizu/flyme/policy/sdk/bean/PolicyFileDataResultBean;", "fileName", "getPolicyFolderCachePath", "category", "area", "getPolicyVersion", "isNewestPolicyFileIsExists", "Lcom/meizu/flyme/policy/sdk/bean/PolicyNewestPathResultBean;", "saveOtherAreaPolicyByUrl", "", "savePolicyByUrl", "url", "version", "", "syncLocalFile", "localPath", "writePolicyInFile", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
            r0 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
            r12 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
            r0 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c2, code lost:
            r4 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion.d("copyAssetFile", kotlin.jvm.internal.Intrinsics.stringPlus("Exception ", r12.getMessage()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d2, code lost:
            if (r4 != null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d5, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d8, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00dc, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
            r12 = e;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4 A[Catch:{ Exception -> 0x00a4, all -> 0x00c0 }, ExcHandler: Exception (e java.lang.Exception), Splitter:B:30:0x0099] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[Catch:{ Exception -> 0x001c }, ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.lang.String copyAssetsFile(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
            /*
                r11 = this;
                java.lang.String r11 = "copyAssetFile"
                java.lang.String r0 = ""
                java.lang.String r1 = "file:////android_asset"
                r2 = 0
                r3 = 2
                r4 = 0
                boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r13, (java.lang.CharSequence) r1, (boolean) r2, (int) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x001c }
                if (r1 == 0) goto L_0x001f
                java.lang.String r6 = "file:////android_asset/"
                java.lang.String r7 = ""
                r9 = 4
                r10 = 0
                r8 = 0
                r5 = r13
                java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x001c }
                goto L_0x0020
            L_0x001c:
                r12 = move-exception
                goto L_0x00c3
            L_0x001f:
                r13 = r0
            L_0x0020:
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x001c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001c }
                r2.<init>()     // Catch:{ Exception -> 0x001c }
                r2.append(r14)     // Catch:{ Exception -> 0x001c }
                r3 = 47
                r2.append(r3)     // Catch:{ Exception -> 0x001c }
                r2.append(r13)     // Catch:{ Exception -> 0x001c }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x001c }
                r1.<init>(r2)     // Catch:{ Exception -> 0x001c }
                boolean r2 = r1.exists()     // Catch:{ Exception -> 0x001c }
                java.lang.String r3 = "currentFile.path"
                if (r2 == 0) goto L_0x0057
                java.lang.String r12 = r1.getPath()     // Catch:{ Exception -> 0x001c }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)     // Catch:{ Exception -> 0x001c }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r13 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x001c, all -> 0x0054 }
                java.lang.String r14 = "currentFile"
                java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r12)     // Catch:{ Exception -> 0x001c, all -> 0x0054 }
                r13.d(r11, r14)     // Catch:{ Exception -> 0x001c, all -> 0x0054 }
                return r12
            L_0x0054:
                r0 = r12
                goto L_0x00d9
            L_0x0057:
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x001c }
                r2.<init>(r14, r13)     // Catch:{ Exception -> 0x001c }
                java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x001c }
                java.lang.String r5 = r2.getParent()     // Catch:{ Exception -> 0x001c }
                r14.<init>(r5)     // Catch:{ Exception -> 0x001c }
                boolean r5 = r2.exists()     // Catch:{ Exception -> 0x001c }
                if (r5 == 0) goto L_0x0071
                boolean r5 = r14.exists()     // Catch:{ Exception -> 0x001c }
                if (r5 != 0) goto L_0x007c
            L_0x0071:
                r14.mkdirs()     // Catch:{ Exception -> 0x001c }
                r2.createNewFile()     // Catch:{ Exception -> 0x0078 }
                goto L_0x007c
            L_0x0078:
                r14 = move-exception
                r14.printStackTrace()     // Catch:{ Exception -> 0x001c }
            L_0x007c:
                android.content.res.AssetManager r12 = r12.getAssets()     // Catch:{ Exception -> 0x001c }
                java.io.InputStream r12 = r12.open(r13)     // Catch:{ Exception -> 0x001c }
                java.lang.String r13 = "context.assets.open(sourceFileName)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ Exception -> 0x001c }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r13 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x001c }
                java.lang.String r14 = "open assets success "
                r13.d(r11, r14)     // Catch:{ Exception -> 0x001c }
                java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001c }
                java.lang.String r14 = r2.getPath()     // Catch:{ Exception -> 0x001c }
                r13.<init>(r14)     // Catch:{ Exception -> 0x001c }
            L_0x0099:
                int r14 = r12.read()     // Catch:{ Exception -> 0x00a4, all -> 0x00c0 }
                r2 = -1
                if (r14 == r2) goto L_0x00a6
                r13.write(r14)     // Catch:{ Exception -> 0x00a4, all -> 0x00c0 }
                goto L_0x0099
            L_0x00a4:
                r12 = move-exception
                goto L_0x00c2
            L_0x00a6:
                r12.close()     // Catch:{ Exception -> 0x00a4, all -> 0x00c0 }
                java.lang.String r12 = r1.getPath()     // Catch:{ Exception -> 0x00a4, all -> 0x00c0 }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)     // Catch:{ Exception -> 0x00a4, all -> 0x00c0 }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r14 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x00a4, all -> 0x00bf }
                java.lang.String r1 = "copy finished"
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r12)     // Catch:{ Exception -> 0x00a4, all -> 0x00bf }
                r14.d(r11, r1)     // Catch:{ Exception -> 0x00a4, all -> 0x00bf }
                r13.close()
                return r12
            L_0x00bf:
                r0 = r12
            L_0x00c0:
                r4 = r13
                goto L_0x00d9
            L_0x00c2:
                r4 = r13
            L_0x00c3:
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r13 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ all -> 0x00d9 }
                java.lang.String r14 = "Exception "
                java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x00d9 }
                java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r12)     // Catch:{ all -> 0x00d9 }
                r13.d(r11, r12)     // Catch:{ all -> 0x00d9 }
                if (r4 != 0) goto L_0x00d5
                goto L_0x00d8
            L_0x00d5:
                r4.close()
            L_0x00d8:
                return r0
            L_0x00d9:
                if (r4 != 0) goto L_0x00dc
                goto L_0x00df
            L_0x00dc:
                r4.close()
            L_0x00df:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils.Companion.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
        }

        /* access modifiers changed from: private */
        /* renamed from: saveOtherAreaPolicyByUrl$lambda-0  reason: not valid java name */
        public static final void m8saveOtherAreaPolicyByUrl$lambda0(Context context, String str, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, PolicySdkResultBean policySdkResultBean) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(str, "$category");
            Intrinsics.checkNotNullParameter(objectRef, "$otherArea");
            Intrinsics.checkNotNullParameter(objectRef2, "$policyNewestPathResultBean");
            if (policySdkResultBean.getCode() == 0) {
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("policyNewest", Boolean.valueOf(policySdkResultBean.getPolicyNewest())));
                if (!policySdkResultBean.getPolicyNewest()) {
                    Companion companion2 = PolicySdkFileUtils.Companion;
                    if (companion2.writePolicyInFile(context, str, policySdkResultBean.getPolicyUrl(), (String) objectRef.element, policySdkResultBean.getPolicyNewestVersion()) && ((PolicyNewestPathResultBean) objectRef2.element).isExists()) {
                        companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("oldUrl = ", ((PolicyNewestPathResultBean) objectRef2.element).getNewestPolicyPath()));
                        companion2.deleteFile(((PolicyNewestPathResultBean) objectRef2.element).getNewestPolicyPath());
                        return;
                    }
                    return;
                }
                return;
            }
            PolicySdkLogUtils.Companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("getResult: code = ", Integer.valueOf(policySdkResultBean.getCode())));
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00c7 A[Catch:{ Exception -> 0x00cb, all -> 0x00d5 }, LOOP:0: B:22:0x00c0->B:25:0x00c7, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean writePolicyInFile(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, long r11) {
            /*
                r6 = this;
                java.lang.String r0 = "savePolicyByUrl"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r8)
                r2 = 95
                r1.append(r2)
                r1.append(r10)
                r1.append(r2)
                r1.append(r11)
                java.lang.String r11 = ".html"
                r1.append(r11)
                java.lang.String r11 = r1.toString()
                r12 = 0
                r1 = 0
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r2 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x007c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
                r3.<init>()     // Catch:{ Exception -> 0x007c }
                java.lang.String r4 = "savePolicyByUrl: url = "
                r3.append(r4)     // Catch:{ Exception -> 0x007c }
                r3.append(r9)     // Catch:{ Exception -> 0x007c }
                java.lang.String r4 = " | fileName = "
                r3.append(r4)     // Catch:{ Exception -> 0x007c }
                r3.append(r11)     // Catch:{ Exception -> 0x007c }
                r4 = 32
                r3.append(r4)     // Catch:{ Exception -> 0x007c }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007c }
                r2.d(r0, r3)     // Catch:{ Exception -> 0x007c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
                r3.<init>()     // Catch:{ Exception -> 0x007c }
                java.lang.String r5 = "category = "
                r3.append(r5)     // Catch:{ Exception -> 0x007c }
                r3.append(r8)     // Catch:{ Exception -> 0x007c }
                r3.append(r4)     // Catch:{ Exception -> 0x007c }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007c }
                r2.d(r0, r3)     // Catch:{ Exception -> 0x007c }
                java.lang.String r6 = r6.getPolicyFolderCachePath(r7, r8, r10)     // Catch:{ Exception -> 0x007c }
                java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x007c }
                r7.<init>(r6, r11)     // Catch:{ Exception -> 0x007c }
                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = r7.getParent()     // Catch:{ Exception -> 0x007c }
                r6.<init>(r8)     // Catch:{ Exception -> 0x007c }
                boolean r8 = r7.exists()     // Catch:{ Exception -> 0x007c }
                if (r8 == 0) goto L_0x007e
                boolean r8 = r6.exists()     // Catch:{ Exception -> 0x007c }
                if (r8 != 0) goto L_0x0089
                goto L_0x007e
            L_0x007c:
                r6 = move-exception
                goto L_0x00d8
            L_0x007e:
                r6.mkdirs()     // Catch:{ Exception -> 0x007c }
                r7.createNewFile()     // Catch:{ Exception -> 0x0085 }
                goto L_0x0089
            L_0x0085:
                r6 = move-exception
                r6.printStackTrace()     // Catch:{ Exception -> 0x007c }
            L_0x0089:
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = "FileUtils: create file  path = "
                java.lang.String r10 = r7.getPath()     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r10)     // Catch:{ Exception -> 0x007c }
                r6.d(r0, r8)     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = "FileUtils: create file exists = "
                boolean r10 = r7.exists()     // Catch:{ Exception -> 0x007c }
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r10)     // Catch:{ Exception -> 0x007c }
                r6.d(r0, r8)     // Catch:{ Exception -> 0x007c }
                java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x007c }
                r6.<init>(r9)     // Catch:{ Exception -> 0x007c }
                java.io.InputStream r6 = r6.openStream()     // Catch:{ Exception -> 0x007c }
                java.lang.String r8 = "URL(url).openStream()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)     // Catch:{ Exception -> 0x007c }
                java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007c }
                java.lang.String r7 = r7.getPath()     // Catch:{ Exception -> 0x007c }
                r8.<init>(r7)     // Catch:{ Exception -> 0x007c }
            L_0x00c0:
                int r7 = r6.read()     // Catch:{ Exception -> 0x00cb, all -> 0x00d5 }
                r9 = -1
                if (r7 == r9) goto L_0x00cd
                r8.write(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00d5 }
                goto L_0x00c0
            L_0x00cb:
                r6 = move-exception
                goto L_0x00d7
            L_0x00cd:
                r6.close()     // Catch:{ Exception -> 0x00cb, all -> 0x00d5 }
                r8.close()
                r6 = 1
                return r6
            L_0x00d5:
                r1 = r8
                goto L_0x00f1
            L_0x00d7:
                r1 = r8
            L_0x00d8:
                r6.printStackTrace()     // Catch:{ all -> 0x00f1 }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ all -> 0x00f1 }
                java.lang.String r8 = "FileUtils Exception = "
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00f1 }
                java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r6)     // Catch:{ all -> 0x00f1 }
                r7.e(r0, r6)     // Catch:{ all -> 0x00f1 }
                if (r1 != 0) goto L_0x00ed
                goto L_0x00f0
            L_0x00ed:
                r1.close()
            L_0x00f0:
                return r12
            L_0x00f1:
                if (r1 != 0) goto L_0x00f4
                goto L_0x00f7
            L_0x00f4:
                r1.close()
            L_0x00f7:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils.Companion.writePolicyInFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String, long):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
            r6 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0096, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x009d, code lost:
            r1.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[Catch:{ Exception -> 0x0062, all -> 0x0076 }, LOOP:0: B:18:0x0057->B:21:0x005e, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[Catch:{ Exception -> 0x0062, all -> 0x0076 }, ExcHandler: Exception (e java.lang.Exception), Splitter:B:18:0x0057] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0064 A[EDGE_INSN: B:50:0x0064->B:24:0x0064 ?: BREAK  , SYNTHETIC] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String copyPolicyFile(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
            /*
                r5 = this;
                java.lang.String r5 = "copyPolicyFile"
                java.lang.String r0 = ""
                java.lang.String r1 = "sourcePath"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
                java.lang.String r1 = "toPath"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
                r1 = 0
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0035 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0035 }
                boolean r6 = r2.exists()     // Catch:{ Exception -> 0x0035 }
                if (r6 == 0) goto L_0x007a
                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0035 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0035 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0035 }
                java.lang.String r4 = r6.getParent()     // Catch:{ Exception -> 0x0035 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x0035 }
                boolean r4 = r6.exists()     // Catch:{ Exception -> 0x0035 }
                if (r4 == 0) goto L_0x0037
                boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0035 }
                if (r4 != 0) goto L_0x0042
                goto L_0x0037
            L_0x0035:
                r6 = move-exception
                goto L_0x0084
            L_0x0037:
                r3.mkdirs()     // Catch:{ Exception -> 0x0035 }
                r6.createNewFile()     // Catch:{ Exception -> 0x003e }
                goto L_0x0042
            L_0x003e:
                r3 = move-exception
                r3.printStackTrace()     // Catch:{ Exception -> 0x0035 }
            L_0x0042:
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0035 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0035 }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r2 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x0035 }
                java.lang.String r4 = "open assets success "
                r2.d(r5, r4)     // Catch:{ Exception -> 0x0035 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0035 }
                java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x0035 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0035 }
            L_0x0057:
                int r6 = r3.read()     // Catch:{ Exception -> 0x0062, all -> 0x0076 }
                r1 = -1
                if (r6 == r1) goto L_0x0064
                r2.write(r6)     // Catch:{ Exception -> 0x0062, all -> 0x0076 }
                goto L_0x0057
            L_0x0062:
                r6 = move-exception
                goto L_0x0078
            L_0x0064:
                r3.close()     // Catch:{ Exception -> 0x0062, all -> 0x0076 }
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ Exception -> 0x0062, all -> 0x0074 }
                java.lang.String r1 = "copy finished"
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r7)     // Catch:{ Exception -> 0x0062, all -> 0x0074 }
                r6.d(r5, r1)     // Catch:{ Exception -> 0x0062, all -> 0x0074 }
                r1 = r2
                goto L_0x007b
            L_0x0074:
                r1 = r2
                goto L_0x009a
            L_0x0076:
                r1 = r2
                goto L_0x0082
            L_0x0078:
                r1 = r2
                goto L_0x0084
            L_0x007a:
                r7 = r0
            L_0x007b:
                if (r1 != 0) goto L_0x007e
                goto L_0x0081
            L_0x007e:
                r1.close()
            L_0x0081:
                return r7
            L_0x0082:
                r7 = r0
                goto L_0x009a
            L_0x0084:
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch:{ all -> 0x0082 }
                java.lang.String r2 = "Exception "
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0082 }
                java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r6)     // Catch:{ all -> 0x0082 }
                r7.d(r5, r6)     // Catch:{ all -> 0x0082 }
                if (r1 != 0) goto L_0x0096
                goto L_0x0099
            L_0x0096:
                r1.close()
            L_0x0099:
                return r0
            L_0x009a:
                if (r1 != 0) goto L_0x009d
                goto L_0x00a0
            L_0x009d:
                r1.close()
            L_0x00a0:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils.Companion.copyPolicyFile(java.lang.String, java.lang.String):java.lang.String");
        }

        public final void deleteFile(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "oldPolicyPath");
            new File(str).delete();
        }

        @Nullable
        public final PolicyFileDataResultBean getPolicyDataFromFileName(@NotNull String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "fileName");
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + str2 + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) AccountConstantKt.DEFAULT_SEGMENT, false, 2, (Object) null)) {
                    if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".html", false, 2, (Object) null)) {
                        String replace$default = StringsKt.replace$default(str, ".html", "", false, 4, (Object) null);
                        List split$default = StringsKt.split$default((CharSequence) replace$default, new String[]{AccountConstantKt.DEFAULT_SEGMENT}, false, 0, 6, (Object) null);
                        companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + replace$default + ' ');
                        if ((!split$default.isEmpty()) && split$default.size() > 2) {
                            policyFileDataResultBean.setCategory((String) split$default.get(0));
                            policyFileDataResultBean.setArea((String) split$default.get(1));
                            policyFileDataResultBean.setVersion(Long.parseLong((String) split$default.get(2)));
                        }
                    }
                }
            } catch (Exception e) {
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                companion2.e("FileUtils", "Exception" + e.getMessage() + ' ');
            }
            PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
            companion3.d("FileUtils", "ResultBean version  " + policyFileDataResultBean.getVersion() + ' ');
            return policyFileDataResultBean;
        }

        @NotNull
        public final String getPolicyFolderCachePath(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "category");
            Intrinsics.checkNotNullParameter(str2, "area");
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("FileUtils", Intrinsics.stringPlus("area = ", str2));
            companion.d("FileUtils", Intrinsics.stringPlus("category = ", str));
            companion.d("FileUtils", Intrinsics.stringPlus("getPolicyFolderCachePath = ", dir == null ? null : Boolean.valueOf(dir.exists())));
            companion.d("FileUtils", Intrinsics.stringPlus("getPolicyFolderCachePath = ", dir == null ? null : dir.getPath()));
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) AccountConstantKt.DEFAULT_SEGMENT, false, 2, (Object) null)) {
                str = str + '_' + str2;
            }
            return dir.getPath() + '/' + str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x001c, code lost:
            r1 = getPolicyDataFromFileName(r2.getNewestPolicyName());
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getPolicyVersion(@org.jetbrains.annotations.NotNull android.content.Context r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "category"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils$Companion r0 = com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils.Companion
                java.lang.String r0 = r0.getCurrentCountryCode(r2)
                com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean r2 = r1.isNewestPolicyFileIsExists(r2, r3, r0)
                boolean r3 = r2.isExists()
                java.lang.String r0 = ""
                if (r3 == 0) goto L_0x0033
                java.lang.String r2 = r2.getNewestPolicyName()
                com.meizu.flyme.policy.sdk.bean.PolicyFileDataResultBean r1 = r1.getPolicyDataFromFileName(r2)
                if (r1 != 0) goto L_0x0027
                goto L_0x0033
            L_0x0027:
                long r1 = r1.getVersion()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
            L_0x0033:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils.Companion.getPolicyVersion(android.content.Context, java.lang.String):java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0049, code lost:
            if ((!(r3.length == 0)) != false) goto L_0x004d;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean isNewestPolicyFileIsExists(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
            /*
                r3 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "category"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "area"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils$Companion r0 = com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "category = "
                r1.append(r2)
                r1.append(r5)
                r2 = 32
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "isNewestPolicyFileIsExists"
                r0.d(r2, r1)
                java.lang.String r3 = r3.getPolicyFolderCachePath(r4, r5, r6)
                java.io.File r4 = new java.io.File
                r4.<init>(r3)
                java.io.File[] r3 = r4.listFiles()
                com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean r4 = new com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean
                r4.<init>()
                r5 = 0
                if (r3 == 0) goto L_0x004c
                int r6 = r3.length
                r0 = 1
                if (r6 != 0) goto L_0x0047
                r6 = r0
                goto L_0x0048
            L_0x0047:
                r6 = r5
            L_0x0048:
                r6 = r6 ^ r0
                if (r6 == 0) goto L_0x004c
                goto L_0x004d
            L_0x004c:
                r0 = r5
            L_0x004d:
                r4.setExists(r0)
                boolean r6 = r4.isExists()
                if (r6 == 0) goto L_0x0072
                r6 = r3[r5]
                java.lang.String r6 = r6.getPath()
                java.lang.String r0 = "fileList[0].path"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                r4.setNewestPolicyPath(r6)
                r3 = r3[r5]
                java.lang.String r3 = r3.getName()
                java.lang.String r5 = "fileList[0].name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
                r4.setNewestPolicyName(r3)
            L_0x0072:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String, java.lang.String):com.meizu.flyme.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final boolean saveOtherAreaPolicyByUrl(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "category");
            Intrinsics.checkNotNullParameter(str2, "area");
            try {
                int length = PolicySdkFileUtils.areaList.length;
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    T t = PolicySdkFileUtils.areaList[i];
                    objectRef.element = t;
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("otherArea = ", t));
                    if (!Intrinsics.areEqual((Object) str2, (Object) objectRef.element)) {
                        String languageByArea = PolicySdkToolsUtils.Companion.getLanguageByArea((String) objectRef.element);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        T isNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, str, (String) objectRef.element);
                        objectRef2.element = isNewestPolicyFileIsExists;
                        PolicyFileDataResultBean policyDataFromFileName = getPolicyDataFromFileName(isNewestPolicyFileIsExists.getNewestPolicyName());
                        Long valueOf = policyDataFromFileName == null ? null : Long.valueOf(policyDataFromFileName.getVersion());
                        companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("version = ", valueOf));
                        PolicySdk.getPolicy(languageByArea, str, valueOf, new a(context, str, objectRef, objectRef2));
                    }
                    i = i2;
                }
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                companion2.d("saveOtherAreaPolicyByUrl", "savePolicyByUrl: isFinished");
                companion2.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.FALSE));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
                companion3.e("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("Exception = ", e.getMessage()));
                companion3.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.FALSE));
                return false;
            } catch (Throwable unused) {
                PolicySdkLogUtils.Companion.d("saveOtherAreaPolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.FALSE));
                return false;
            }
        }

        public final boolean savePolicyByUrl(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "category");
            Intrinsics.checkNotNullParameter(str2, "url");
            Intrinsics.checkNotNullParameter(str3, "area");
            boolean z = false;
            try {
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                companion.d("savePolicyByUrl", "getResult: area = " + str3 + " //" + j);
                z = writePolicyInFile(context, str, str2, str3, j);
                companion.d("savePolicyByUrl", "savePolicyByUrl: isFinished");
                companion.d("savePolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.valueOf(z)));
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                companion2.e("savePolicyByUrl", Intrinsics.stringPlus("Exception = ", e.getMessage()));
                companion2.d("savePolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.valueOf(z)));
                return z;
            } catch (Throwable unused) {
                PolicySdkLogUtils.Companion.d("savePolicyByUrl", Intrinsics.stringPlus("isFinished = ", Boolean.valueOf(z)));
                return z;
            }
        }

        @NotNull
        public final String syncLocalFile(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "localPath");
            Intrinsics.checkNotNullParameter(str2, "category");
            PolicySdkLogUtils.Companion.d("syncLocalFile", Intrinsics.stringPlus("category = ", str2));
            return copyAssetsFile(context, str, getPolicyFolderCachePath(context, str2, PolicySdkToolsUtils.Companion.getCurrentCountryCode(context)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
