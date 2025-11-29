package com.upuphone.ar.fastrecord.phone.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/FastRecordTitleHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mPhoneRecordList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "mSceneRecordList", "getStringToInt", "", "numStr", "", "getSupportTransTypes", "", "getTitle", "transType", "recordList", "isPositiveInteger", "", "updateRecordTitle", "", "noteBean", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordTitleHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTitleHelper.kt\ncom/upuphone/ar/fastrecord/phone/utils/FastRecordTitleHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1855#2,2:205\n*S KotlinDebug\n*F\n+ 1 FastRecordTitleHelper.kt\ncom/upuphone/ar/fastrecord/phone/utils/FastRecordTitleHelper\n*L\n96#1:205,2\n*E\n"})
public final class FastRecordTitleHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordTitleHelper";
    @NotNull
    public static final String TITLE_SPLIT = " ";
    /* access modifiers changed from: private */
    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    public static FastRecordTitleHelper mFastRecordTitleHelper;
    @NotNull
    private final Context context;
    @NotNull
    private volatile CopyOnWriteArrayList<RecordEntity> mPhoneRecordList = new CopyOnWriteArrayList<>();
    @NotNull
    private volatile CopyOnWriteArrayList<RecordEntity> mSceneRecordList = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/FastRecordTitleHelper$Companion;", "", "()V", "TAG", "", "TITLE_SPLIT", "mFastRecordTitleHelper", "Lcom/upuphone/ar/fastrecord/phone/utils/FastRecordTitleHelper;", "getInstance", "init", "", "mContext", "Landroid/content/Context;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FastRecordTitleHelper getInstance() {
            if (FastRecordTitleHelper.mFastRecordTitleHelper == null) {
                LogExt.logE("getInstance mFastRecordTitleHelper is null re init", FastRecordTitleHelper.TAG);
                FastRecordTitleHelper.mFastRecordTitleHelper = new FastRecordTitleHelper(SdkContext.f6675a.c().getContext());
            }
            return FastRecordTitleHelper.mFastRecordTitleHelper;
        }

        public final void init(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "mContext");
            FastRecordTitleHelper.mFastRecordTitleHelper = new FastRecordTitleHelper(context);
        }

        private Companion() {
        }
    }

    public FastRecordTitleHelper(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final int getStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("getStringToInt error msg = " + message, TAG);
            return -1;
        }
    }

    private final List<Integer> getSupportTransTypes() {
        return CollectionsKt.arrayListOf(1, 0);
    }

    private final boolean isPositiveInteger(String str) {
        return !StringsKt.isBlank(str) && new Regex("\\d+").matches(str) && getStringToInt(str) > 0;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final String getTitle(int i, @Nullable List<RecordEntity> list) {
        int i2 = i;
        LogExt.logE("getTitle start cur thread = " + Thread.currentThread().getName(), TAG);
        if (!getSupportTransTypes().contains(Integer.valueOf(i))) {
            LogExt.logE("getTitle getSupportTransTypes is not contains", TAG);
            return "";
        }
        this.mSceneRecordList.clear();
        this.mPhoneRecordList.clear();
        if (list != null) {
            for (RecordEntity recordEntity : list) {
                LogExt.logW("getTitle forEach recordList type = " + recordEntity.getType() + ",id = " + recordEntity.getRecordId() + ",title = " + recordEntity.getShortHandTitle(), TAG);
                if (recordEntity.getType() == 1) {
                    if (!this.mSceneRecordList.contains(recordEntity)) {
                        this.mSceneRecordList.add(recordEntity);
                    }
                } else if (!this.mPhoneRecordList.contains(recordEntity)) {
                    this.mPhoneRecordList.add(recordEntity);
                }
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LogExt.logE("getTitle transType = " + i2 + ", mSceneRecordList size = " + this.mSceneRecordList.size() + ", mPhoneRecordList = " + this.mPhoneRecordList.size(), TAG);
        if (i2 == 1) {
            String str = this.context.getString(R.string.fast_record_scene) + " ";
            Iterator<RecordEntity> it = this.mSceneRecordList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i4 = i3 + 1;
                RecordEntity next = it.next();
                LogExt.logE("SCENE_RECORD index = " + i3 + " ,title = " + next.getShortHandTitle(), TAG);
                linkedHashSet.add(Integer.valueOf(i4));
                String shortHandTitle = next.getShortHandTitle();
                LogExt.logE("shortHandTitle = " + shortHandTitle + ",transPrefix = " + str, TAG);
                if (shortHandTitle != null && StringsKt.startsWith$default(shortHandTitle, str, false, 2, (Object) null)) {
                    LogExt.logE("title?.startsWith(transPrefix)", TAG);
                    String substring = shortHandTitle.substring(str.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (isPositiveInteger(substring)) {
                        LogExt.logE("isPositiveInteger(numStr)", TAG);
                        linkedHashSet2.add(Integer.valueOf(Integer.parseInt(substring)));
                    }
                }
                i3 = i4;
            }
            if (linkedHashSet.isEmpty()) {
                return str + "1";
            }
            LogExt.logE("getTitle scene mSourceSet[" + linkedHashSet + "], mTargetSet[" + linkedHashSet2 + "]", TAG);
            List sorted = CollectionsKt.sorted(CollectionsKt.subtract(linkedHashSet, linkedHashSet2));
            if (sorted.isEmpty()) {
                List sorted2 = CollectionsKt.sorted(linkedHashSet);
                return str + (((Number) sorted2.get(CollectionsKt.getLastIndex(sorted2))).intValue() + 1);
            }
            LogExt.logE("getTitle scene last mSourceSet[" + sorted + "], " + str + sorted.get(0), TAG);
            return str + sorted.get(0);
        }
        String str2 = this.context.getString(R.string.fast_record_phone) + " ";
        Iterator<RecordEntity> it2 = this.mPhoneRecordList.iterator();
        int i5 = 0;
        while (it2.hasNext()) {
            int i6 = i5 + 1;
            RecordEntity next2 = it2.next();
            String shortHandTitle2 = next2.getShortHandTitle();
            StringBuilder sb = new StringBuilder();
            Iterator<RecordEntity> it3 = it2;
            sb.append("PHONE_RECORD index = ");
            sb.append(i5);
            sb.append(" ,title = ");
            sb.append(shortHandTitle2);
            LogExt.logE(sb.toString(), TAG);
            linkedHashSet.add(Integer.valueOf(i6));
            String shortHandTitle3 = next2.getShortHandTitle();
            if (shortHandTitle3 != null && StringsKt.startsWith$default(shortHandTitle3, str2, false, 2, (Object) null)) {
                String substring2 = shortHandTitle3.substring(str2.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                if (isPositiveInteger(substring2)) {
                    linkedHashSet2.add(Integer.valueOf(Integer.parseInt(substring2)));
                }
            }
            it2 = it3;
            i5 = i6;
        }
        if (linkedHashSet.isEmpty()) {
            return str2 + "1";
        }
        LogExt.logE("getTitle phone mSourceSet[" + linkedHashSet + "], mTargetSet[" + linkedHashSet2 + "]", TAG);
        List sorted3 = CollectionsKt.sorted(CollectionsKt.subtract(linkedHashSet, linkedHashSet2));
        if (sorted3.isEmpty()) {
            List sorted4 = CollectionsKt.sorted(linkedHashSet);
            return str2 + (((Number) sorted4.get(CollectionsKt.getLastIndex(sorted4))).intValue() + 1);
        }
        return str2 + sorted3.get(0);
    }

    public final void updateRecordTitle(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "noteBean");
        LogExt.logE("updateRecordTitle noteBean=" + recordEntity, TAG);
        int type = recordEntity.getType();
        if (getSupportTransTypes().contains(Integer.valueOf(type))) {
            int i = 0;
            if (type == 1) {
                Iterator<RecordEntity> it = this.mSceneRecordList.iterator();
                while (it.hasNext()) {
                    int i2 = i + 1;
                    RecordEntity next = it.next();
                    if (recordEntity.getRecordId() == next.getRecordId()) {
                        next.setShortHandTitle(recordEntity.getShortHandTitle());
                        this.mSceneRecordList.set(i, next);
                        return;
                    }
                    i = i2;
                }
                return;
            }
            Iterator<RecordEntity> it2 = this.mPhoneRecordList.iterator();
            while (it2.hasNext()) {
                int i3 = i + 1;
                RecordEntity next2 = it2.next();
                if (recordEntity.getRecordId() == next2.getRecordId()) {
                    next2.setShortHandTitle(recordEntity.getShortHandTitle());
                    this.mPhoneRecordList.set(i, next2);
                    return;
                }
                i = i3;
            }
        }
    }
}
